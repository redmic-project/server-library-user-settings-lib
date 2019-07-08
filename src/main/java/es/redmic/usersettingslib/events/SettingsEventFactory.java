package es.redmic.usersettingslib.events;

/*-
 * #%L
 * user-settings-lib
 * %%
 * Copyright (C) 2019 REDMIC Project / Server
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.redmic.brokerlib.avro.common.Event;
import es.redmic.brokerlib.avro.common.EventError;
import es.redmic.exception.common.ExceptionType;
import es.redmic.exception.common.InternalException;
import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.dto.SelectionDTO;
import es.redmic.usersettingslib.events.clear.ClearCancelledEvent;
import es.redmic.usersettingslib.events.clear.ClearConfirmedEvent;
import es.redmic.usersettingslib.events.clear.ClearEvent;
import es.redmic.usersettingslib.events.clear.ClearFailedEvent;
import es.redmic.usersettingslib.events.clear.ClearedEvent;
import es.redmic.usersettingslib.events.common.PersistenceCancelledEvent;
import es.redmic.usersettingslib.events.common.PersistenceEvent;
import es.redmic.usersettingslib.events.common.SelectionCancelledEvent;
import es.redmic.usersettingslib.events.common.SelectionEvent;
import es.redmic.usersettingslib.events.deselect.DeselectCancelledEvent;
import es.redmic.usersettingslib.events.deselect.DeselectConfirmedEvent;
import es.redmic.usersettingslib.events.deselect.DeselectEvent;
import es.redmic.usersettingslib.events.deselect.DeselectFailedEvent;
import es.redmic.usersettingslib.events.deselect.DeselectedEvent;
import es.redmic.usersettingslib.events.save.SaveCancelledEvent;
import es.redmic.usersettingslib.events.save.SaveConfirmedEvent;
import es.redmic.usersettingslib.events.save.SaveEvent;
import es.redmic.usersettingslib.events.save.SaveFailedEvent;
import es.redmic.usersettingslib.events.save.SavedEvent;
import es.redmic.usersettingslib.events.select.SelectCancelledEvent;
import es.redmic.usersettingslib.events.select.SelectConfirmedEvent;
import es.redmic.usersettingslib.events.select.SelectEvent;
import es.redmic.usersettingslib.events.select.SelectFailedEvent;
import es.redmic.usersettingslib.events.select.SelectedEvent;

public class SettingsEventFactory {

	private static Logger logger = LogManager.getLogger();

	public static Event getEvent(Event source, String type) {

		if (type.equals(SettingsEventTypes.SELECT)) {

			logger.debug("Creando evento SelectEvent para: " + source.getAggregateId());
			return new SelectEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DESELECT)) {

			logger.debug("Creando evento DeselectEvent para: " + source.getAggregateId());
			return new DeselectEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.CLEAR)) {

			logger.debug("Creando evento ClearEvent para: " + source.getAggregateId());
			return new ClearEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE)) {

			logger.debug("Creando evento SaveEvent para: " + source.getAggregateId());
			return new SaveEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SELECT_CONFIRMED)) {

			logger.debug("Creando evento SelectConfirmedEvent para: " + source.getAggregateId());

			return new SelectConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DESELECT_CONFIRMED)) {

			logger.debug("Creando evento DeselectConfirmedEvent para: " + source.getAggregateId());

			return new DeselectConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.CLEAR_CONFIRMED)) {

			logger.debug("Creando evento ClearConfirmedEvent para: " + source.getAggregateId());

			return new ClearConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE_CONFIRMED)) {

			logger.debug("Creando evento SaveConfirmedEvent para: " + source.getAggregateId());
			return new SaveConfirmedEvent().buildFrom(source);
		}

		logger.error("Tipo de evento no soportado");
		throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
	}

	public static Event getEvent(Event source, String type, SelectionDTO selection) {

		SelectionEvent successfulEvent = null;

		if (type.equals(SettingsEventTypes.SELECTED)) {
			logger.debug("Creando evento SettingsCreatedEvent para: " + source.getAggregateId());
			successfulEvent = new SelectedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DESELECTED)) {
			logger.debug("Creando evento SettingsUpdatedEvent para: " + source.getAggregateId());
			successfulEvent = new DeselectedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.CLEARED)) {
			logger.debug("Creando evento SettingsUpdatedEvent para: " + source.getAggregateId());
			successfulEvent = new ClearedEvent().buildFrom(source);
		}

		if (successfulEvent != null) {
			successfulEvent.setSelection(selection);
			return successfulEvent;
		} else {
			logger.error("Tipo de evento no soportado");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}

	public static Event getEvent(Event source, String type, PersistenceDTO persistence) {

		PersistenceEvent successfulEvent = null;

		if (type.equals(SettingsEventTypes.SAVED)) {
			logger.debug("Creando evento SavedEvent para: " + source.getAggregateId());
			successfulEvent = new SavedEvent().buildFrom(source);
		}

		if (successfulEvent != null) {
			successfulEvent.setPersistence(persistence);
			return successfulEvent;
		} else {
			logger.error("Tipo de evento no soportado");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}

	public static Event getEvent(Event source, String type, String exceptionType,
			Map<String, String> exceptionArguments) {

		EventError failedEvent = null;

		if (type.equals(SettingsEventTypes.SELECT_FAILED)) {

			logger.debug("No se pudo seleccionar el elemento");
			failedEvent = new SelectFailedEvent().buildFrom(source);
		}
		if (type.equals(SettingsEventTypes.DESELECT_FAILED)) {

			logger.debug("No se pudo deseleccionar");
			failedEvent = new DeselectFailedEvent().buildFrom(source);
		}
		if (type.equals(SettingsEventTypes.CLEAR_FAILED)) {

			logger.debug("No se pudo limpiar la selección");
			failedEvent = new ClearFailedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE_FAILED)) {

			logger.debug("No se pudo guardar la selección");
			failedEvent = new SaveFailedEvent().buildFrom(source);
		}

		if (failedEvent != null) {

			failedEvent.setExceptionType(exceptionType);
			failedEvent.setArguments(exceptionArguments);
			return failedEvent;

		} else {
			logger.error("Tipo de evento no soportado");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}

	public static Event getEvent(Event source, String type, SelectionDTO selection, String exceptionType,
			Map<String, String> exceptionArguments) {

		SelectionCancelledEvent cancelledEvent = null;

		if (type.equals(SettingsEventTypes.SELECT_CANCELLED)) {

			logger.debug("Creando evento SelectCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new SelectCancelledEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DESELECT_CANCELLED)) {

			logger.debug("Creando evento DeselectCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new DeselectCancelledEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.CLEAR_CANCELLED)) {

			logger.debug("Creando evento ClearCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new ClearCancelledEvent().buildFrom(source);
		}

		if (cancelledEvent != null) {

			cancelledEvent.setSelection(selection);
			cancelledEvent.setExceptionType(exceptionType);
			cancelledEvent.setArguments(exceptionArguments);
			return cancelledEvent;

		} else {

			logger.error("Tipo de evento no soportado");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}

	public static Event getEvent(Event source, String type, PersistenceDTO persistence, String exceptionType,
			Map<String, String> exceptionArguments) {

		PersistenceCancelledEvent cancelledEvent = null;

		if (type.equals(SettingsEventTypes.SAVE_CANCELLED)) {

			logger.debug("Creando evento SaveCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new SaveCancelledEvent().buildFrom(source);
		}

		if (cancelledEvent != null) {

			cancelledEvent.setPersistence(persistence);
			cancelledEvent.setExceptionType(exceptionType);
			cancelledEvent.setArguments(exceptionArguments);
			return cancelledEvent;

		} else {

			logger.error("Tipo de evento no soportado");
			throw new InternalException(ExceptionType.INTERNAL_EXCEPTION);
		}
	}
}

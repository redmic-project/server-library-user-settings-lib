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
import es.redmic.usersettingslib.events.clearselection.ClearSelectionCancelledEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionConfirmedEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionFailedEvent;
import es.redmic.usersettingslib.events.clearselection.SelectionClearedEvent;
import es.redmic.usersettingslib.events.common.PersistenceCancelledEvent;
import es.redmic.usersettingslib.events.common.PersistenceEvent;
import es.redmic.usersettingslib.events.common.SelectionCancelledEvent;
import es.redmic.usersettingslib.events.common.SelectionEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsCancelledEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsCheckFailedEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsCheckedEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsConfirmedEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsEvent;
import es.redmic.usersettingslib.events.delete.DeleteSettingsFailedEvent;
import es.redmic.usersettingslib.events.delete.SettingsDeletedEvent;
import es.redmic.usersettingslib.events.deselect.DeselectCancelledEvent;
import es.redmic.usersettingslib.events.deselect.DeselectConfirmedEvent;
import es.redmic.usersettingslib.events.deselect.DeselectEvent;
import es.redmic.usersettingslib.events.deselect.DeselectFailedEvent;
import es.redmic.usersettingslib.events.deselect.DeselectedEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsCancelledEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsConfirmedEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsFailedEvent;
import es.redmic.usersettingslib.events.save.SettingsSavedEvent;
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
			return new ClearSelectionEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE)) {

			logger.debug("Creando evento SaveSettingsEvent para: " + source.getAggregateId());
			return new SaveSettingsEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE)) {

			logger.debug("Creando evento DeleteSettingsEvent para: " + source.getAggregateId());
			return new DeleteSettingsEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE_CHECKED)) {

			logger.debug("Creando evento DeleteSettingsCheckedEvent para: " + source.getAggregateId());
			return new DeleteSettingsCheckedEvent().buildFrom(source);
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

			return new ClearSelectionConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE_CONFIRMED)) {

			logger.debug("Creando evento SaveSettingsConfirmedEvent para: " + source.getAggregateId());
			return new SaveSettingsConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE_CONFIRMED)) {

			logger.debug("Creando evento DeleteSettingsConfirmedEvent para: " + source.getAggregateId());

			return new DeleteSettingsConfirmedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETED)) {

			logger.debug("Creando evento SettingsDeletedEvent para: " + source.getAggregateId());
			return new SettingsDeletedEvent().buildFrom(source);
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
			successfulEvent = new SelectionClearedEvent().buildFrom(source);
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
			logger.debug("Creando evento SettingsSavedEvent para: " + source.getAggregateId());
			successfulEvent = new SettingsSavedEvent().buildFrom(source);
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
			failedEvent = new ClearSelectionFailedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.SAVE_FAILED)) {

			logger.debug("No se pudo guardar la configuración");
			failedEvent = new SaveSettingsFailedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE_FAILED)) {

			logger.debug("No se pudo eliminar la configuración");
			failedEvent = new DeleteSettingsFailedEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE_CHECK_FAILED)) {

			logger.debug("Checkeo de eliminación fallido, la confirmación está compartida");
			failedEvent = new DeleteSettingsCheckFailedEvent().buildFrom(source);
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
			cancelledEvent = new ClearSelectionCancelledEvent().buildFrom(source);
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

			logger.debug("Creando evento SaveSettingsCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new SaveSettingsCancelledEvent().buildFrom(source);
		}

		if (type.equals(SettingsEventTypes.DELETE_CANCELLED)) {

			logger.debug("Creando evento DeleteSettingsCancelledEvent para: " + source.getAggregateId());
			cancelledEvent = new DeleteSettingsCancelledEvent().buildFrom(source);
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

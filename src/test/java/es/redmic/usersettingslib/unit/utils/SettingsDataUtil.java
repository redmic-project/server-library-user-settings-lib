package es.redmic.usersettingslib.unit.utils;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.joda.time.DateTime;

import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.dto.SelectionDTO;
import es.redmic.usersettingslib.events.SettingsEventTypes;
import es.redmic.usersettingslib.events.clear.ClearCancelledEvent;
import es.redmic.usersettingslib.events.clear.ClearConfirmedEvent;
import es.redmic.usersettingslib.events.clear.ClearEvent;
import es.redmic.usersettingslib.events.clear.ClearFailedEvent;
import es.redmic.usersettingslib.events.clear.ClearedEvent;
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

public abstract class SettingsDataUtil {

	// @formatter:off
	public final static String PREFIX = "settings-",
			CODE = UUID.randomUUID().toString(),
			USER = "1";
	// @formatter:on

	// SELECT

	public static SelectEvent getSelectEvent() {

		SelectEvent evt = new SelectEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setType(SettingsEventTypes.SELECT);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static SelectConfirmedEvent getSelectConfirmedEvent() {

		SelectConfirmedEvent evt = new SelectConfirmedEvent().buildFrom(getSelectEvent());
		evt.setType(SettingsEventTypes.SELECT_CONFIRMED);
		return evt;
	}

	public static SelectedEvent getSelectedEvent() {

		SelectedEvent evt = new SelectedEvent().buildFrom(getSelectEvent());
		evt.setType(SettingsEventTypes.SELECTED);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static SelectFailedEvent getSelectFailedEvent() {

		SelectFailedEvent evt = new SelectFailedEvent().buildFrom(getSelectEvent());
		evt.setType(SettingsEventTypes.SELECT_FAILED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SelectCancelledEvent getSelectCancelledEvent() {

		SelectCancelledEvent evt = new SelectCancelledEvent().buildFrom(getSelectEvent());
		evt.setType(SettingsEventTypes.SELECT_CANCELLED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// DESELECT

	public static DeselectEvent getDeselectEvent() {

		DeselectEvent evt = new DeselectEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setType(SettingsEventTypes.SELECT);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static DeselectConfirmedEvent getDeselectConfirmedEvent() {

		DeselectConfirmedEvent evt = new DeselectConfirmedEvent().buildFrom(getDeselectEvent());
		evt.setType(SettingsEventTypes.DESELECT_CONFIRMED);
		return evt;
	}

	public static DeselectedEvent getDeselectedEvent() {

		DeselectedEvent evt = new DeselectedEvent().buildFrom(getDeselectEvent());
		evt.setType(SettingsEventTypes.DESELECTED);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static DeselectFailedEvent getDeselectFailedEvent() {

		DeselectFailedEvent evt = new DeselectFailedEvent().buildFrom(getDeselectEvent());
		evt.setType(SettingsEventTypes.DESELECT_FAILED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static DeselectCancelledEvent getDeselectCancelledEvent() {

		DeselectCancelledEvent evt = new DeselectCancelledEvent().buildFrom(getDeselectEvent());
		evt.setType(SettingsEventTypes.DESELECT_CANCELLED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// CLEAR

	public static ClearEvent getClearEvent() {

		ClearEvent evt = new ClearEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setType(SettingsEventTypes.CLEAR);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static ClearConfirmedEvent getClearConfirmedEvent() {

		ClearConfirmedEvent evt = new ClearConfirmedEvent().buildFrom(getClearEvent());
		evt.setType(SettingsEventTypes.CLEAR_CONFIRMED);
		return evt;
	}

	public static ClearedEvent getClearedEvent() {

		ClearedEvent evt = new ClearedEvent().buildFrom(getClearEvent());
		evt.setType(SettingsEventTypes.CLEARED);
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static ClearFailedEvent getClearFailedEvent() {

		ClearFailedEvent evt = new ClearFailedEvent().buildFrom(getClearEvent());
		evt.setType(SettingsEventTypes.CLEAR_FAILED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static ClearCancelledEvent getClearCancelledEvent() {

		ClearCancelledEvent evt = new ClearCancelledEvent().buildFrom(getClearEvent());
		evt.setType(SettingsEventTypes.CLEAR_CANCELLED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// SAVE

	public static SaveEvent getSaveEvent() {

		SaveEvent evt = new SaveEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setType(SettingsEventTypes.SAVE);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setPersistence(getPersistenceDTO());
		return evt;
	}

	public static SaveConfirmedEvent getSaveConfirmedEvent() {

		SaveConfirmedEvent evt = new SaveConfirmedEvent().buildFrom(getSaveEvent());
		evt.setType(SettingsEventTypes.SAVE_CONFIRMED);
		return evt;
	}

	public static SavedEvent getSaveedEvent() {

		SavedEvent evt = new SavedEvent().buildFrom(getSaveEvent());
		evt.setType(SettingsEventTypes.SAVED);
		evt.setPersistence(getPersistenceDTO());
		return evt;
	}

	public static SaveFailedEvent getSaveFailedEvent() {

		SaveFailedEvent evt = new SaveFailedEvent().buildFrom(getSaveEvent());
		evt.setType(SettingsEventTypes.SAVE_FAILED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SaveCancelledEvent getSaveCancelledEvent() {

		SaveCancelledEvent evt = new SaveCancelledEvent().buildFrom(getSaveEvent());
		evt.setType(SettingsEventTypes.SAVE_CANCELLED);
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	//

	@SuppressWarnings("serial")
	public static SelectionDTO getSelectionDTO() {

		SelectionDTO selection = new SelectionDTO();

		selection.setId(PREFIX + CODE);
		selection.setService("prueba");
		selection.setSelection(new ArrayList<String>() {
			{
				add("1");
			}
		});

		selection.setInserted(DateTime.now());
		selection.setUpdated(DateTime.now());
		selection.setAccessed(DateTime.now());
		return selection;
	}

	public static PersistenceDTO getPersistenceDTO() {

		PersistenceDTO persistence = new PersistenceDTO();

		persistence.setId(PREFIX + CODE);
		persistence.setName("prueba");
		persistence.setUserId(USER);

		persistence.setInserted(DateTime.now());
		persistence.setUpdated(DateTime.now());
		persistence.setAccessed(DateTime.now());
		return persistence;
	}
}

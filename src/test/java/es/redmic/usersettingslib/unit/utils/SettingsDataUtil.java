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
import es.redmic.usersettingslib.dto.SettingsDTO;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionCancelledEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionConfirmedEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionFailedEvent;
import es.redmic.usersettingslib.events.clearselection.PartialClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.SelectionClearedEvent;
import es.redmic.usersettingslib.events.delete.CheckDeleteSettingsEvent;
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
import es.redmic.usersettingslib.events.deselect.PartialDeselectEvent;
import es.redmic.usersettingslib.events.save.PartialSaveSettingsEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsCancelledEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsConfirmedEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsEvent;
import es.redmic.usersettingslib.events.save.SaveSettingsFailedEvent;
import es.redmic.usersettingslib.events.save.SettingsSavedEvent;
import es.redmic.usersettingslib.events.select.PartialSelectEvent;
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
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static PartialSelectEvent getPartialSelectEvent() {

		PartialSelectEvent evt = new PartialSelectEvent().buildFrom(getSelectEvent());
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static SelectConfirmedEvent getSelectConfirmedEvent() {

		return new SelectConfirmedEvent().buildFrom(getSelectEvent());
	}

	public static SelectedEvent getSelectedEvent() {

		SelectedEvent evt = new SelectedEvent().buildFrom(getSelectEvent());
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static SelectFailedEvent getSelectFailedEvent() {

		SelectFailedEvent evt = new SelectFailedEvent().buildFrom(getSelectEvent());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SelectCancelledEvent getSelectCancelledEvent() {

		SelectCancelledEvent evt = new SelectCancelledEvent().buildFrom(getSelectEvent());
		evt.setSettings(getSettingsDTO());
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
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static PartialDeselectEvent getPartialDeselectEvent() {

		PartialDeselectEvent evt = new PartialDeselectEvent().buildFrom(getDeselectEvent());
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static DeselectConfirmedEvent getDeselectConfirmedEvent() {

		return new DeselectConfirmedEvent().buildFrom(getDeselectEvent());
	}

	public static DeselectedEvent getDeselectedEvent() {

		DeselectedEvent evt = new DeselectedEvent().buildFrom(getDeselectEvent());
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static DeselectFailedEvent getDeselectFailedEvent() {

		DeselectFailedEvent evt = new DeselectFailedEvent().buildFrom(getDeselectEvent());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static DeselectCancelledEvent getDeselectCancelledEvent() {

		DeselectCancelledEvent evt = new DeselectCancelledEvent().buildFrom(getDeselectEvent());
		evt.setSettings(getSettingsDTO());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// CLEAR

	public static ClearSelectionEvent getClearEvent() {

		ClearSelectionEvent evt = new ClearSelectionEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSettings(getSettingsDTO());
		evt.getSettings().setSelection(new ArrayList<>());
		return evt;
	}

	public static PartialClearSelectionEvent getPartialClearSelectionEvent() {

		PartialClearSelectionEvent evt = new PartialClearSelectionEvent().buildFrom(getClearEvent());
		evt.setSelection(getSelectionDTO());
		return evt;
	}

	public static ClearSelectionConfirmedEvent getClearConfirmedEvent() {

		return new ClearSelectionConfirmedEvent().buildFrom(getClearEvent());
	}

	public static SelectionClearedEvent getClearedEvent() {

		SelectionClearedEvent evt = new SelectionClearedEvent().buildFrom(getClearEvent());
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static ClearSelectionFailedEvent getClearFailedEvent() {

		ClearSelectionFailedEvent evt = new ClearSelectionFailedEvent().buildFrom(getClearEvent());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static ClearSelectionCancelledEvent getClearCancelledEvent() {

		ClearSelectionCancelledEvent evt = new ClearSelectionCancelledEvent().buildFrom(getClearEvent());
		evt.setSettings(getSettingsDTO());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// SAVE

	public static SaveSettingsEvent getSaveEvent() {

		SaveSettingsEvent evt = new SaveSettingsEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static PartialSaveSettingsEvent getPartialSaveSettingsEvent() {

		PartialSaveSettingsEvent evt = new PartialSaveSettingsEvent().buildFrom(getSaveEvent());
		evt.setPersistence(getPersistenceDTO());
		return evt;
	}

	public static SaveSettingsConfirmedEvent getSaveConfirmedEvent() {

		return new SaveSettingsConfirmedEvent().buildFrom(getSaveEvent());
	}

	public static SettingsSavedEvent getSavedEvent() {

		SettingsSavedEvent evt = new SettingsSavedEvent().buildFrom(getSaveEvent());
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static SaveSettingsFailedEvent getSaveFailedEvent() {

		SaveSettingsFailedEvent evt = new SaveSettingsFailedEvent().buildFrom(getSaveEvent());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SaveSettingsCancelledEvent getSaveCancelledEvent() {

		SaveSettingsCancelledEvent evt = new SaveSettingsCancelledEvent().buildFrom(getSaveEvent());
		evt.setSettings(getSettingsDTO());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// DELETE

	public static DeleteSettingsEvent getDeleteEvent() {

		DeleteSettingsEvent evt = new DeleteSettingsEvent();
		evt.setAggregateId(PREFIX + CODE);
		evt.setVersion(1);
		evt.setUserId(USER);
		return evt;
	}

	public static DeleteSettingsConfirmedEvent getDeleteConfirmedEvent() {

		return new DeleteSettingsConfirmedEvent().buildFrom(getDeleteEvent());
	}

	public static SettingsDeletedEvent getDeletedEvent() {

		return new SettingsDeletedEvent().buildFrom(getDeleteEvent());
	}

	public static DeleteSettingsFailedEvent getDeleteFailedEvent() {

		DeleteSettingsFailedEvent evt = new DeleteSettingsFailedEvent().buildFrom(getDeleteEvent());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static DeleteSettingsCancelledEvent getDeleteCancelledEvent() {

		DeleteSettingsCancelledEvent evt = new DeleteSettingsCancelledEvent().buildFrom(getDeleteEvent());
		evt.setSettings(getSettingsDTO());
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static CheckDeleteSettingsEvent getCheckDeleteSettingsEvent() {

		return new CheckDeleteSettingsEvent().buildFrom(getDeleteEvent());
	}

	public static DeleteSettingsCheckFailedEvent getDeleteSettingsCheckFailedEvent() {

		DeleteSettingsCheckFailedEvent event = new DeleteSettingsCheckFailedEvent().buildFrom(getDeleteEvent());

		event.setExceptionType("ItemIsShared");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		event.setArguments(arguments);

		return event;
	}

	public static DeleteSettingsCheckedEvent getDeleteSettingsCheckedEvent() {

		return new DeleteSettingsCheckedEvent().buildFrom(getDeleteEvent());
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

		persistence.setService("prueba");

		persistence.setInserted(DateTime.now());
		persistence.setUpdated(DateTime.now());
		persistence.setAccessed(DateTime.now());
		return persistence;
	}

	@SuppressWarnings("serial")
	public static SettingsDTO getSettingsDTO() {

		SettingsDTO settings = new SettingsDTO();

		settings.setId(PREFIX + CODE);

		settings.setName("prueba");
		settings.setUserId(USER);

		settings.setService("prueba");
		settings.setSelection(new ArrayList<String>() {
			{
				add("1");
			}
		});

		settings.setInserted(DateTime.now());
		settings.setUpdated(DateTime.now());
		settings.setAccessed(DateTime.now());
		return settings;
	}
}

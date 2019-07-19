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
		return getSelectEvent(CODE);
	}

	public static SelectEvent getSelectEvent(String code) {

		SelectEvent evt = new SelectEvent();
		evt.setAggregateId(PREFIX + code);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSettings(getSettingsDTO());
		evt.setSessionId("sessionIdA");
		return evt;
	}

	public static PartialSelectEvent getPartialSelectEvent() {
		return getPartialSelectEvent(CODE);
	}

	public static PartialSelectEvent getPartialSelectEvent(String code) {

		PartialSelectEvent evt = new PartialSelectEvent().buildFrom(getSelectEvent(code));
		evt.setSelection(getSelectionDTO(code));
		return evt;
	}

	public static SelectConfirmedEvent getSelectConfirmedEvent() {
		return getSelectConfirmedEvent(CODE);
	}

	public static SelectConfirmedEvent getSelectConfirmedEvent(String code) {

		return new SelectConfirmedEvent().buildFrom(getSelectEvent(code));
	}

	public static SelectedEvent getSelectedEvent() {
		return getSelectedEvent(CODE);
	}

	public static SelectedEvent getSelectedEvent(String code) {

		SelectedEvent evt = new SelectedEvent().buildFrom(getSelectEvent(code));
		evt.setSettings(getSettingsDTO(code));
		return evt;
	}

	public static SelectFailedEvent getSelectFailedEvent() {
		return getSelectFailedEvent(CODE);
	}

	public static SelectFailedEvent getSelectFailedEvent(String code) {

		SelectFailedEvent evt = new SelectFailedEvent().buildFrom(getSelectEvent(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SelectCancelledEvent getSelectCancelledEvent() {
		return getSelectCancelledEvent(CODE);
	}

	public static SelectCancelledEvent getSelectCancelledEvent(String code) {

		SelectCancelledEvent evt = new SelectCancelledEvent().buildFrom(getSelectEvent(code));
		evt.setSettings(getSettingsDTO(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// DESELECT

	public static DeselectEvent getDeselectEvent() {
		return getDeselectEvent(CODE);
	}

	public static DeselectEvent getDeselectEvent(String code) {

		DeselectEvent evt = new DeselectEvent();
		evt.setAggregateId(PREFIX + code);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSessionId("sessionIdB");
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static PartialDeselectEvent getPartialDeselectEvent() {
		return getPartialDeselectEvent(CODE);
	}

	public static PartialDeselectEvent getPartialDeselectEvent(String code) {

		PartialDeselectEvent evt = new PartialDeselectEvent().buildFrom(getDeselectEvent(code));
		evt.setSelection(getSelectionDTO(code));
		return evt;
	}

	public static DeselectConfirmedEvent getDeselectConfirmedEvent() {
		return getDeselectConfirmedEvent(CODE);
	}

	public static DeselectConfirmedEvent getDeselectConfirmedEvent(String code) {

		return new DeselectConfirmedEvent().buildFrom(getDeselectEvent(code));
	}

	public static DeselectedEvent getDeselectedEvent() {
		return getDeselectedEvent(CODE);
	}

	public static DeselectedEvent getDeselectedEvent(String code) {

		DeselectedEvent evt = new DeselectedEvent().buildFrom(getDeselectEvent(code));
		evt.setSettings(getSettingsDTO(code));
		return evt;
	}

	public static DeselectFailedEvent getDeselectFailedEvent() {
		return getDeselectFailedEvent(CODE);
	}

	public static DeselectFailedEvent getDeselectFailedEvent(String code) {

		DeselectFailedEvent evt = new DeselectFailedEvent().buildFrom(getDeselectEvent(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static DeselectCancelledEvent getDeselectCancelledEvent() {
		return getDeselectCancelledEvent(CODE);
	}

	public static DeselectCancelledEvent getDeselectCancelledEvent(String code) {

		DeselectCancelledEvent evt = new DeselectCancelledEvent().buildFrom(getDeselectEvent(code));
		evt.setSettings(getSettingsDTO(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// CLEAR

	public static ClearSelectionEvent getClearEvent() {
		return getClearEvent(CODE);
	}

	public static ClearSelectionEvent getClearEvent(String code) {

		ClearSelectionEvent evt = new ClearSelectionEvent();
		evt.setAggregateId(PREFIX + code);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSessionId("sessionIdC");
		evt.setSettings(getSettingsDTO(code));
		evt.getSettings().setSelection(new ArrayList<>());
		return evt;
	}

	public static PartialClearSelectionEvent getPartialClearSelectionEvent() {
		return getPartialClearSelectionEvent(CODE);
	}

	public static PartialClearSelectionEvent getPartialClearSelectionEvent(String code) {

		PartialClearSelectionEvent evt = new PartialClearSelectionEvent().buildFrom(getClearEvent(code));
		evt.setSelection(getSelectionDTO(code));
		return evt;
	}

	public static ClearSelectionConfirmedEvent getClearConfirmedEvent() {
		return getClearConfirmedEvent(CODE);
	}

	public static ClearSelectionConfirmedEvent getClearConfirmedEvent(String code) {

		return new ClearSelectionConfirmedEvent().buildFrom(getClearEvent(code));
	}

	public static SelectionClearedEvent getClearedEvent() {
		return getClearedEvent(CODE);
	}

	public static SelectionClearedEvent getClearedEvent(String code) {

		SelectionClearedEvent evt = new SelectionClearedEvent().buildFrom(getClearEvent(code));
		evt.setSettings(getSettingsDTO(code));
		return evt;
	}

	public static ClearSelectionFailedEvent getClearFailedEvent() {
		return getClearFailedEvent(CODE);
	}

	public static ClearSelectionFailedEvent getClearFailedEvent(String code) {

		ClearSelectionFailedEvent evt = new ClearSelectionFailedEvent().buildFrom(getClearEvent(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static ClearSelectionCancelledEvent getClearCancelledEvent() {
		return getClearCancelledEvent(CODE);
	}

	public static ClearSelectionCancelledEvent getClearCancelledEvent(String code) {

		ClearSelectionCancelledEvent evt = new ClearSelectionCancelledEvent().buildFrom(getClearEvent(code));
		evt.setSettings(getSettingsDTO(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// SAVE

	public static SaveSettingsEvent getSaveSettingsEvent() {
		return getSaveSettingsEvent(CODE);
	}

	public static SaveSettingsEvent getSaveSettingsEvent(String code) {

		SaveSettingsEvent evt = new SaveSettingsEvent();
		evt.setAggregateId(PREFIX + code);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSessionId("sessionIdD");
		evt.setSettings(getSettingsDTO());
		return evt;
	}

	public static PartialSaveSettingsEvent getPartialSaveSettingsEvent() {
		return getPartialSaveSettingsEvent(CODE);
	}

	public static PartialSaveSettingsEvent getPartialSaveSettingsEvent(String code) {

		PartialSaveSettingsEvent evt = new PartialSaveSettingsEvent().buildFrom(getSaveSettingsEvent(code));
		evt.setPersistence(getPersistenceDTO(code));
		return evt;
	}

	public static SaveSettingsConfirmedEvent getSaveSettingsConfirmedEvent() {
		return getSaveSettingsConfirmedEvent(CODE);
	}

	public static SaveSettingsConfirmedEvent getSaveSettingsConfirmedEvent(String code) {

		return new SaveSettingsConfirmedEvent().buildFrom(getSaveSettingsEvent(code));
	}

	public static SettingsSavedEvent getSettingsSavedEvent() {
		return getSettingsSavedEvent(CODE);
	}

	public static SettingsSavedEvent getSettingsSavedEvent(String code) {

		SettingsSavedEvent evt = new SettingsSavedEvent().buildFrom(getSaveSettingsEvent(code));
		evt.setSettings(getSettingsDTO(code));
		return evt;
	}

	public static SaveSettingsFailedEvent getSaveSettingsFailedEvent() {
		return getSaveSettingsFailedEvent(CODE);
	}

	public static SaveSettingsFailedEvent getSaveSettingsFailedEvent(String code) {

		SaveSettingsFailedEvent evt = new SaveSettingsFailedEvent().buildFrom(getSaveSettingsEvent(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static SaveSettingsCancelledEvent getSaveSettingsCancelledEvent() {
		return getSaveSettingsCancelledEvent(CODE);
	}

	public static SaveSettingsCancelledEvent getSaveSettingsCancelledEvent(String code) {

		SaveSettingsCancelledEvent evt = new SaveSettingsCancelledEvent().buildFrom(getSaveSettingsEvent(code));
		evt.setSettings(getSettingsDTO(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	// DELETE

	public static DeleteSettingsEvent getDeleteSettingsEvent() {
		return getDeleteSettingsEvent(CODE);
	}

	public static DeleteSettingsEvent getDeleteSettingsEvent(String code) {

		DeleteSettingsEvent evt = new DeleteSettingsEvent();
		evt.setAggregateId(PREFIX + code);
		evt.setVersion(1);
		evt.setUserId(USER);
		evt.setSessionId("sessionIdE");
		return evt;
	}

	public static DeleteSettingsConfirmedEvent getDeleteSettingsConfirmedEvent() {
		return getDeleteSettingsConfirmedEvent(CODE);
	}

	public static DeleteSettingsConfirmedEvent getDeleteSettingsConfirmedEvent(String code) {

		return new DeleteSettingsConfirmedEvent().buildFrom(getDeleteSettingsEvent(code));
	}

	public static SettingsDeletedEvent getSettingsDeletedEvent() {
		return getSettingsDeletedEvent(CODE);
	}

	public static SettingsDeletedEvent getSettingsDeletedEvent(String code) {

		return new SettingsDeletedEvent().buildFrom(getDeleteSettingsEvent(code));
	}

	public static DeleteSettingsFailedEvent getDeleteSettingsFailedEvent() {
		return getDeleteSettingsFailedEvent(CODE);
	}

	public static DeleteSettingsFailedEvent getDeleteSettingsFailedEvent(String code) {

		DeleteSettingsFailedEvent evt = new DeleteSettingsFailedEvent().buildFrom(getDeleteSettingsEvent(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static DeleteSettingsCancelledEvent getDeleteSettingsCancelledEvent() {
		return getDeleteSettingsCancelledEvent(CODE);
	}

	public static DeleteSettingsCancelledEvent getDeleteSettingsCancelledEvent(String code) {

		DeleteSettingsCancelledEvent evt = new DeleteSettingsCancelledEvent().buildFrom(getDeleteSettingsEvent(code));
		evt.setSettings(getSettingsDTO(code));
		evt.setExceptionType("ItemNotFound");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		evt.setArguments(arguments);
		return evt;
	}

	public static CheckDeleteSettingsEvent getCheckDeleteSettingsEvent() {
		return getCheckDeleteSettingsEvent(CODE);
	}

	public static CheckDeleteSettingsEvent getCheckDeleteSettingsEvent(String code) {

		return new CheckDeleteSettingsEvent().buildFrom(getDeleteSettingsEvent(code));
	}

	public static DeleteSettingsCheckFailedEvent getDeleteSettingsCheckFailedEvent() {
		return getDeleteSettingsCheckFailedEvent(CODE);
	}

	public static DeleteSettingsCheckFailedEvent getDeleteSettingsCheckFailedEvent(String code) {

		DeleteSettingsCheckFailedEvent event = new DeleteSettingsCheckFailedEvent()
				.buildFrom(getDeleteSettingsEvent(code));

		event.setExceptionType("ItemIsShared");
		Map<String, String> arguments = new HashMap<String, String>();
		arguments.put("a", "b");
		event.setArguments(arguments);

		return event;
	}

	public static DeleteSettingsCheckedEvent getDeleteSettingsCheckedEvent() {
		return getDeleteSettingsCheckedEvent(CODE);
	}

	public static DeleteSettingsCheckedEvent getDeleteSettingsCheckedEvent(String code) {

		return new DeleteSettingsCheckedEvent().buildFrom(getDeleteSettingsEvent(code));
	}

	//

	public static SelectionDTO getSelectionDTO() {
		return getSelectionDTO(CODE);
	}

	@SuppressWarnings("serial")
	public static SelectionDTO getSelectionDTO(String code) {

		SelectionDTO selection = new SelectionDTO();

		selection.setId(PREFIX + code);
		selection.setService("prueba");
		selection.setUserId(USER);
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
		return getPersistenceDTO(CODE);
	}

	public static PersistenceDTO getPersistenceDTO(String code) {

		PersistenceDTO persistence = new PersistenceDTO();

		persistence.setId(PREFIX + code);
		persistence.setName("prueba");
		persistence.setUserId(USER);

		persistence.setService("prueba");

		persistence.setInserted(DateTime.now());
		persistence.setUpdated(DateTime.now());
		persistence.setAccessed(DateTime.now());
		return persistence;
	}

	public static SettingsDTO getSettingsDTO() {
		return getSettingsDTO(CODE);
	}

	@SuppressWarnings("serial")
	public static SettingsDTO getSettingsDTO(String code) {

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

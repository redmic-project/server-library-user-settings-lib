package es.redmic.usersettingslib.unit.events;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import es.redmic.brokerlib.avro.common.Event;
import es.redmic.brokerlib.avro.common.EventError;
import es.redmic.usersettingslib.events.SettingsEventFactory;
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
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

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

public class SettingsEventFactoryTest {

	@Test
	public void GetEvent_ReturnSelectEvent_IfTypeIsSelect() {

		Event source = SettingsDataUtil.getSelectEvent();
		SelectEvent event = (SelectEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SELECT);

		assertEquals(SettingsEventTypes.SELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeselectEvent_IfTypeIsDeselect_Checked() {

		Event source = SettingsDataUtil.getDeselectEvent();
		DeselectEvent event = (DeselectEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.DESELECT);

		assertEquals(SettingsEventTypes.DESELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnClearEvent_IfTypeIsClear() {

		Event source = SettingsDataUtil.getClearEvent();
		ClearEvent event = (ClearEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.CLEAR);

		assertEquals(SettingsEventTypes.CLEAR, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSaveEvent_IfTypeIsSave() {

		Event source = SettingsDataUtil.getSaveEvent();
		SaveSettingsEvent event = (SaveSettingsEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SAVE);

		assertEquals(SettingsEventTypes.SAVE, event.getType());

		checkMetadataFields(source, event);
	}

	//

	@Test
	public void GetEvent_ReturnSelectConfirmedEvent_IfTypeIsSelectConfirmed() {

		Event source = SettingsDataUtil.getSelectEvent();
		SelectConfirmedEvent event = (SelectConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SELECT_CONFIRMED);

		assertEquals(SettingsEventTypes.SELECT_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeselectConfirmedEvent_IfTypeIsDeselectConfirmed() {

		Event source = SettingsDataUtil.getDeselectEvent();
		DeselectConfirmedEvent event = (DeselectConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DESELECT_CONFIRMED);

		assertEquals(SettingsEventTypes.DESELECT_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnClearConfirmedEvent_IfTypeIsClearConfirmed() {

		Event source = SettingsDataUtil.getClearEvent();
		ClearConfirmedEvent event = (ClearConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_CONFIRMED);

		assertEquals(SettingsEventTypes.CLEAR_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSaveConfirmedEvent_IfTypeIsSaveConfirmed() {

		Event source = SettingsDataUtil.getSaveEvent();
		SaveSettingsConfirmedEvent event = (SaveSettingsConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SAVE_CONFIRMED);

		assertEquals(SettingsEventTypes.SAVE_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	/////////////////////////

	@Test
	public void GetEvent_ReturnSelectedEvent_IfTypeIsSelected() {

		Event source = SettingsDataUtil.getSelectEvent();
		SelectedEvent event = (SelectedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SELECTED,
				SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.SELECTED, event.getType());
		assertNotNull(event.getSelection());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeselectedEvent_IfTypeIsDeselected() {

		Event source = SettingsDataUtil.getDeselectEvent();
		DeselectedEvent event = (DeselectedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.DESELECTED,
				SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.DESELECTED, event.getType());
		assertNotNull(event.getSelection());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnClearedEvent_IfTypeIsCleared() {

		Event source = SettingsDataUtil.getClearEvent();
		ClearedEvent event = (ClearedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.CLEARED,
				SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.CLEARED, event.getType());
		assertNotNull(event.getSelection());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSavedEvent_IfTypeIsSaved() {

		Event source = SettingsDataUtil.getSaveEvent();
		SettingsSavedEvent event = (SettingsSavedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SAVED,
				SettingsDataUtil.getPersistenceDTO());

		assertEquals(SettingsEventTypes.SAVED, event.getType());
		assertNotNull(event.getPersistence());

		checkMetadataFields(source, event);
	}

	///////////////////

	@Test
	public void GetEvent_ReturnSelectFailedEvent_IfTypeIsSelectFailed() {

		SelectFailedEvent exception = SettingsDataUtil.getSelectFailedEvent();

		Event source = SettingsDataUtil.getSelectEvent();

		SelectFailedEvent event = (SelectFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SELECT_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.SELECT_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnDeselectFailedEvent_IfTypeIsDeselectFailed() {

		DeselectFailedEvent exception = SettingsDataUtil.getDeselectFailedEvent();

		Event source = SettingsDataUtil.getDeselectEvent();

		DeselectFailedEvent event = (DeselectFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DESELECT_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.DESELECT_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnClearFailedEventt_IfTypeIsClearFailed() {

		ClearFailedEvent exception = SettingsDataUtil.getClearFailedEvent();

		Event source = SettingsDataUtil.getClearEvent();

		ClearFailedEvent event = (ClearFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.CLEAR_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnSaveFailedEvent_IfTypeIsSaveFailed() {

		SaveSettingsFailedEvent exception = SettingsDataUtil.getSaveFailedEvent();

		Event source = SettingsDataUtil.getSaveEvent();

		SaveSettingsFailedEvent event = (SaveSettingsFailedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SAVE_FAILED,
				exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.SAVE_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	////////////////////

	@Test
	public void GetEvent_ReturnSelectCancelledEvent_IfTypeIsSelectCancelled() {

		SelectCancelledEvent exception = SettingsDataUtil.getSelectCancelledEvent();

		Event source = SettingsDataUtil.getSelectEvent();

		SelectCancelledEvent event = (SelectCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SELECT_CANCELLED, SettingsDataUtil.getSelectionDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.SELECT_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSelection());
	}

	@Test
	public void GetEvent_ReturnDeselectCancelledEvent_IfTypeIsDeselectCancelled() {

		DeselectCancelledEvent exception = SettingsDataUtil.getDeselectCancelledEvent();

		Event source = SettingsDataUtil.getDeselectEvent();

		DeselectCancelledEvent event = (DeselectCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DESELECT_CANCELLED, SettingsDataUtil.getSelectionDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.DESELECT_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSelection());
	}

	@Test
	public void GetEvent_ReturnClearCancelledEvent_IfTypeIsClearCancelled() {

		ClearCancelledEvent exception = SettingsDataUtil.getClearCancelledEvent();

		Event source = SettingsDataUtil.getClearEvent();

		ClearCancelledEvent event = (ClearCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_CANCELLED, SettingsDataUtil.getSelectionDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.CLEAR_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSelection());
	}

	@Test
	public void GetEvent_ReturnSaveCancelledEvent_IfTypeIsSaveCancelled() {

		SaveSettingsCancelledEvent exception = SettingsDataUtil.getSaveCancelledEvent();

		Event source = SettingsDataUtil.getSaveEvent();

		SaveSettingsCancelledEvent event = (SaveSettingsCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SAVE_CANCELLED, SettingsDataUtil.getPersistenceDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.SAVE_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getPersistence());
	}

	////////////////////

	private void checkMetadataFields(Event source, Event evt) {

		assertEquals(source.getAggregateId(), evt.getAggregateId());
		assertEquals(source.getVersion(), evt.getVersion());
		assertEquals(source.getSessionId(), evt.getSessionId());
		assertEquals(source.getUserId(), evt.getUserId());
	}

	private void checkErrorFields(EventError source, EventError evt) {

		assertEquals(source.getExceptionType(), evt.getExceptionType());
		assertEquals(source.getArguments(), evt.getArguments());
	}

}

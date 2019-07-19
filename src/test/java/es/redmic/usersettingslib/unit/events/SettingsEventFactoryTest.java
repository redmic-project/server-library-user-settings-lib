package es.redmic.usersettingslib.unit.events;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import es.redmic.brokerlib.avro.common.Event;
import es.redmic.brokerlib.avro.common.EventError;
import es.redmic.testutils.utils.AvroBaseTest;
import es.redmic.usersettingslib.events.SettingsEventFactory;
import es.redmic.usersettingslib.events.SettingsEventTypes;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionCancelledEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionConfirmedEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionFailedEvent;
import es.redmic.usersettingslib.events.clearselection.PartialClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.SelectionClearedEvent;
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

public class SettingsEventFactoryTest extends AvroBaseTest {

	@Test
	public void GetEvent_ReturnPartialSelectEvent_IfTypeIsPartialSelect() {

		Event source = SettingsDataUtil.getSelectEvent();
		PartialSelectEvent event = (PartialSelectEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.PARTIAL_SELECT, SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.PARTIAL_SELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnPartialDeselectEvent_IfTypeIsPartialDeselect() {

		Event source = SettingsDataUtil.getDeselectEvent();
		PartialDeselectEvent event = (PartialDeselectEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.PARTIAL_DESELECT, SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.PARTIAL_DESELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnPartialClearEvent_IfTypeIsPartialClear() {

		Event source = SettingsDataUtil.getClearEvent();
		PartialClearSelectionEvent event = (PartialClearSelectionEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.PARTIAL_CLEAR_SELECTION, SettingsDataUtil.getSelectionDTO());

		assertEquals(SettingsEventTypes.PARTIAL_CLEAR_SELECTION, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnPartialSaveEvent_IfTypeIsPartialSave() {

		Event source = SettingsDataUtil.getSaveSettingsEvent();
		PartialSaveSettingsEvent event = (PartialSaveSettingsEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.PARTIAL_SAVE, SettingsDataUtil.getPersistenceDTO());

		assertEquals(SettingsEventTypes.PARTIAL_SAVE, event.getType());

		checkMetadataFields(source, event);
	}

	//

	@Test
	public void GetEvent_ReturnSelectEvent_IfTypeIsSelect() {

		Event source = SettingsDataUtil.getSelectEvent();
		SelectEvent event = (SelectEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SELECT,
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.SELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeselectEvent_IfTypeIsDeselect() {

		Event source = SettingsDataUtil.getDeselectEvent();
		DeselectEvent event = (DeselectEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.DESELECT,
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.DESELECT, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnClearEvent_IfTypeIsClear() {

		Event source = SettingsDataUtil.getClearEvent();
		ClearSelectionEvent event = (ClearSelectionEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_SELECTION, SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.CLEAR_SELECTION, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSaveEvent_IfTypeIsSave() {

		Event source = SettingsDataUtil.getSaveSettingsEvent();
		SaveSettingsEvent event = (SaveSettingsEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SAVE,
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.SAVE, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeleteEvent_IfTypeIsDelete() {

		Event source = SettingsDataUtil.getDeleteSettingsEvent();
		DeleteSettingsEvent event = (DeleteSettingsEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETE);

		assertEquals(SettingsEventTypes.DELETE, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeleteSettingsCheckedEvent_IfTypeIsDeleteChecked() {

		Event source = SettingsDataUtil.getDeleteSettingsEvent();
		DeleteSettingsCheckedEvent event = (DeleteSettingsCheckedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETE_CHECKED);

		assertEquals(SettingsEventTypes.DELETE_CHECKED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeleteSettingsConfirmedEvent_IfTypeIsDeleteConfirmed() {

		Event source = SettingsDataUtil.getDeleteSettingsEvent();
		DeleteSettingsConfirmedEvent event = (DeleteSettingsConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETE_CONFIRMED);

		assertEquals(SettingsEventTypes.DELETE_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSettingsDeletedEvent_IfTypeIsDeleted() {

		Event source = SettingsDataUtil.getDeleteSettingsEvent();
		SettingsDeletedEvent event = (SettingsDeletedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETED);

		assertEquals(SettingsEventTypes.DELETED, event.getType());

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
		ClearSelectionConfirmedEvent event = (ClearSelectionConfirmedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_SELECTION_CONFIRMED);

		assertEquals(SettingsEventTypes.CLEAR_SELECTION_CONFIRMED, event.getType());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSaveConfirmedEvent_IfTypeIsSaveConfirmed() {

		Event source = SettingsDataUtil.getSaveSettingsEvent();
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
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.SELECTED, event.getType());
		assertNotNull(event.getSettings());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnDeselectedEvent_IfTypeIsDeselected() {

		Event source = SettingsDataUtil.getDeselectEvent();
		DeselectedEvent event = (DeselectedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.DESELECTED,
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.DESELECTED, event.getType());
		assertNotNull(event.getSettings());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnClearedEvent_IfTypeIsCleared() {

		Event source = SettingsDataUtil.getClearEvent();
		SelectionClearedEvent event = (SelectionClearedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SELECTION_CLEARED, SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.SELECTION_CLEARED, event.getType());
		assertNotNull(event.getSettings());

		checkMetadataFields(source, event);
	}

	@Test
	public void GetEvent_ReturnSavedEvent_IfTypeIsSaved() {

		Event source = SettingsDataUtil.getSaveSettingsEvent();
		SettingsSavedEvent event = (SettingsSavedEvent) SettingsEventFactory.getEvent(source, SettingsEventTypes.SAVED,
				SettingsDataUtil.getSettingsDTO());

		assertEquals(SettingsEventTypes.SAVED, event.getType());
		assertNotNull(event.getSettings());

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

		ClearSelectionFailedEvent exception = SettingsDataUtil.getClearFailedEvent();

		Event source = SettingsDataUtil.getClearEvent();

		ClearSelectionFailedEvent event = (ClearSelectionFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_SELECTION_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.CLEAR_SELECTION_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnSaveFailedEvent_IfTypeIsSaveFailed() {

		SaveSettingsFailedEvent exception = SettingsDataUtil.getSaveSettingsFailedEvent();

		Event source = SettingsDataUtil.getSaveSettingsEvent();

		SaveSettingsFailedEvent event = (SaveSettingsFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SAVE_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.SAVE_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnDeleteSettingsFailedEvent_IfTypeIsDeleteFailed() {

		DeleteSettingsFailedEvent exception = SettingsDataUtil.getDeleteSettingsFailedEvent();

		Event source = SettingsDataUtil.getDeleteSettingsEvent();

		DeleteSettingsFailedEvent event = (DeleteSettingsFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETE_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.DELETE_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	@Test
	public void GetEvent_ReturnDeleteSettingsCheckFailedEvent_IfTypeIsDeleteCheckFailed() {

		DeleteSettingsCheckFailedEvent exception = SettingsDataUtil.getDeleteSettingsCheckFailedEvent();

		Event source = SettingsDataUtil.getDeleteSettingsEvent();

		DeleteSettingsCheckFailedEvent event = (DeleteSettingsCheckFailedEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CHECK_DELETE_FAILED, exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.CHECK_DELETE_FAILED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
	}

	////////////////////

	@Test
	public void GetEvent_ReturnSelectCancelledEvent_IfTypeIsSelectCancelled() {

		SelectCancelledEvent exception = SettingsDataUtil.getSelectCancelledEvent();

		Event source = SettingsDataUtil.getSelectEvent();

		SelectCancelledEvent event = (SelectCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SELECT_CANCELLED, SettingsDataUtil.getSettingsDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.SELECT_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSettings());
	}

	@Test
	public void GetEvent_ReturnDeselectCancelledEvent_IfTypeIsDeselectCancelled() {

		DeselectCancelledEvent exception = SettingsDataUtil.getDeselectCancelledEvent();

		Event source = SettingsDataUtil.getDeselectEvent();

		DeselectCancelledEvent event = (DeselectCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DESELECT_CANCELLED, SettingsDataUtil.getSettingsDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.DESELECT_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSettings());
	}

	@Test
	public void GetEvent_ReturnClearCancelledEvent_IfTypeIsClearCancelled() {

		ClearSelectionCancelledEvent exception = SettingsDataUtil.getClearCancelledEvent();

		Event source = SettingsDataUtil.getClearEvent();

		ClearSelectionCancelledEvent event = (ClearSelectionCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.CLEAR_SELECTION_CANCELLED, SettingsDataUtil.getSettingsDTO(),
				exception.getExceptionType(), exception.getArguments());

		assertEquals(SettingsEventTypes.CLEAR_SELECTION_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSettings());
	}

	@Test
	public void GetEvent_ReturnSaveCancelledEvent_IfTypeIsSaveCancelled() {

		SaveSettingsCancelledEvent exception = SettingsDataUtil.getSaveSettingsCancelledEvent();

		Event source = SettingsDataUtil.getSaveSettingsEvent();

		SaveSettingsCancelledEvent event = (SaveSettingsCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.SAVE_CANCELLED, SettingsDataUtil.getSettingsDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.SAVE_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSettings());
	}

	@Test
	public void GetEvent_ReturnDeleteSettingsCancelledEvent_IfTypeIsDeleteCancelled() {

		DeleteSettingsCancelledEvent exception = SettingsDataUtil.getDeleteSettingsCancelledEvent();

		Event source = SettingsDataUtil.getSaveSettingsEvent();

		DeleteSettingsCancelledEvent event = (DeleteSettingsCancelledEvent) SettingsEventFactory.getEvent(source,
				SettingsEventTypes.DELETE_CANCELLED, SettingsDataUtil.getSettingsDTO(), exception.getExceptionType(),
				exception.getArguments());

		assertEquals(SettingsEventTypes.DELETE_CANCELLED, event.getType());

		checkMetadataFields(source, event);
		checkErrorFields(exception, event);
		assertNotNull(event.getSettings());
	}

	////////////////////

	private void checkMetadataFields(Event source, Event evt) {

		assertEquals(source.getAggregateId(), evt.getAggregateId());
		assertEquals(source.getVersion(), evt.getVersion());
		assertEquals(source.getSessionId(), evt.getSessionId());
		assertEquals(source.getUserId(), evt.getUserId());

		serializerAndDeserializer(evt);
	}

	private void checkErrorFields(EventError source, EventError evt) {

		assertEquals(source.getExceptionType(), evt.getExceptionType());
		assertEquals(source.getArguments(), evt.getArguments());

		serializerAndDeserializer(evt);
	}

}

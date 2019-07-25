package es.redmic.usersettingslib.unit.events;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.redmic.testutils.utils.AvroBaseTest;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionCancelledEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionConfirmedEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.ClearSelectionFailedEvent;
import es.redmic.usersettingslib.events.clearselection.PartialClearSelectionEvent;
import es.redmic.usersettingslib.events.clearselection.SelectionClearedEvent;
import es.redmic.usersettingslib.events.clone.CloneSettingsEvent;
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
import es.redmic.usersettingslib.events.update.UpdateSettingsAccessedDateEvent;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class SettingsEventsCheckAvroSchemaTest extends AvroBaseTest {

	// Select

	@Test
	public void PartialSelectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		PartialSelectEvent event = SettingsDataUtil.getPartialSelectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de PartialSelectEvent",
				PartialSelectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SelectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectEvent event = SettingsDataUtil.getSelectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectEvent", SelectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SelectConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectConfirmedEvent event = SettingsDataUtil.getSelectConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectConfirmedEvent",
				SelectConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SelectedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectedEvent event = SettingsDataUtil.getSelectedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectedEvent",
				SelectedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SelectFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectFailedEvent event = SettingsDataUtil.getSelectFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectFailedEvent",
				SelectFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SelectCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectCancelledEvent event = SettingsDataUtil.getSelectCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectCancelledEvent",
				SelectCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// Deselect

	@Test
	public void PartialDeselectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		PartialDeselectEvent event = SettingsDataUtil.getPartialDeselectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de PartialDeselectEvent",
				PartialDeselectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeselectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectEvent event = SettingsDataUtil.getDeselectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectEvent",
				DeselectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeselectConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectConfirmedEvent event = SettingsDataUtil.getDeselectConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectConfirmedEvent",
				DeselectConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeselectedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectedEvent event = SettingsDataUtil.getDeselectedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectedEvent",
				DeselectedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeselectFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectFailedEvent event = SettingsDataUtil.getDeselectFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectFailedEvent",
				DeselectFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeselectCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectCancelledEvent event = SettingsDataUtil.getDeselectCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectCancelledEvent",
				DeselectCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// Clear

	@Test
	public void PartialClearEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		PartialClearSelectionEvent event = SettingsDataUtil.getPartialClearSelectionEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de PartialClearSelectionEvent",
				PartialClearSelectionEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearSelectionEvent event = SettingsDataUtil.getClearEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearEvent",
				ClearSelectionEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearSelectionConfirmedEvent event = SettingsDataUtil.getClearConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearConfirmedEvent",
				ClearSelectionConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectionClearedEvent event = SettingsDataUtil.getClearedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearedEvent",
				SelectionClearedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearSelectionFailedEvent event = SettingsDataUtil.getClearFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearFailedEvent",
				ClearSelectionFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearSelectionCancelledEvent event = SettingsDataUtil.getClearCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearCancelledEvent",
				ClearSelectionCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// SAVE

	@Test
	public void PartialSaveEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		PartialSaveSettingsEvent event = SettingsDataUtil.getPartialSaveSettingsEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de PartialSaveSettingsEvent",
				PartialSaveSettingsEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveSettingsEvent event = SettingsDataUtil.getSaveSettingsEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveEvent",
				SaveSettingsEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveSettingsConfirmedEvent event = SettingsDataUtil.getSaveSettingsConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveConfirmedEvent",
				SaveSettingsConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SavedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SettingsSavedEvent event = SettingsDataUtil.getSettingsSavedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SavedEvent",
				SettingsSavedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveSettingsFailedEvent event = SettingsDataUtil.getSaveSettingsFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveFailedEvent",
				SaveSettingsFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveSettingsCancelledEvent event = SettingsDataUtil.getSaveSettingsCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveCancelledEvent",
				SaveSettingsCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// DELETE

	@Test
	public void DeleteEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsEvent event = SettingsDataUtil.getDeleteSettingsEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteEvent",
				DeleteSettingsEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CheckDeleteSettingsEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		CheckDeleteSettingsEvent event = SettingsDataUtil.getCheckDeleteSettingsEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de CheckDeleteSettingsEvent",
				CheckDeleteSettingsEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeleteSettingsCheckedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsCheckedEvent event = SettingsDataUtil.getDeleteSettingsCheckedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteSettingsCheckedEvent",
				DeleteSettingsCheckedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeleteSettingsCheckFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsCheckFailedEvent event = SettingsDataUtil.getDeleteSettingsCheckFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteSettingsCheckFailedEvent",
				DeleteSettingsCheckFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeleteConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsConfirmedEvent event = SettingsDataUtil.getDeleteSettingsConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteConfirmedEvent",
				DeleteSettingsConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeletedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SettingsDeletedEvent event = SettingsDataUtil.getSettingsDeletedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeletedEvent",
				SettingsDeletedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeleteFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsFailedEvent event = SettingsDataUtil.getDeleteSettingsFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteFailedEvent",
				DeleteSettingsFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void DeleteCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeleteSettingsCancelledEvent event = SettingsDataUtil.getDeleteSettingsCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeleteCancelledEvent",
				DeleteSettingsCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// CLONE

	@Test
	public void CloneEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		CloneSettingsEvent event = SettingsDataUtil.getCloneSettingsEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de CloneSettingsEvent",
				CloneSettingsEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// UpdateSettingsAccessedDate

	@Test
	public void UpdateSettingsAccessedDateEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		UpdateSettingsAccessedDateEvent event = SettingsDataUtil.getUpdateSettingsAccessedDateEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de UpdateSettingsAccessedDateEvent",
				UpdateSettingsAccessedDateEvent.class.isInstance(result));

		assertEquals(result, event);
	}
}

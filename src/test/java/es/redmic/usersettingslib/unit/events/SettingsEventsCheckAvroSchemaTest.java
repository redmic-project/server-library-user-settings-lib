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
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class SettingsEventsCheckAvroSchemaTest extends AvroBaseTest {

	// Select

	@Test
	public void CreateSelectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SelectEvent event = SettingsDataUtil.getSelectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SelectEvent", SelectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateSelectConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

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
	public void CreateSelectFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

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
	public void CreateDeselectEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		DeselectEvent event = SettingsDataUtil.getDeselectEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de DeselectEvent",
				DeselectEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateDeselectConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

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
	public void CreateDeselectFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

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
	public void CreateClearEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearEvent event = SettingsDataUtil.getClearEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearEvent", ClearEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateClearConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearConfirmedEvent event = SettingsDataUtil.getClearConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearConfirmedEvent",
				ClearConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearedEvent event = SettingsDataUtil.getClearedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearedEvent", ClearedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateClearFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearFailedEvent event = SettingsDataUtil.getClearFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearFailedEvent",
				ClearFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void ClearCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		ClearCancelledEvent event = SettingsDataUtil.getClearCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de ClearCancelledEvent",
				ClearCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	// SAVE

	@Test
	public void CreateSaveEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveEvent event = SettingsDataUtil.getSaveEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveEvent", SaveEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateSaveConfirmedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveConfirmedEvent event = SettingsDataUtil.getSaveConfirmedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveConfirmedEvent",
				SaveConfirmedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SavedEvent event = SettingsDataUtil.getSaveedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SavedEvent", SavedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void CreateSaveFailedEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveFailedEvent event = SettingsDataUtil.getSaveFailedEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveFailedEvent",
				SaveFailedEvent.class.isInstance(result));

		assertEquals(result, event);
	}

	@Test
	public void SaveCancelledEventSerializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() {

		SaveCancelledEvent event = SettingsDataUtil.getSaveCancelledEvent();

		Object result = serializerAndDeserializer(event);

		assertTrue("El objeto obtenido debe ser una instancia de SaveCancelledEvent",
				SaveCancelledEvent.class.isInstance(result));

		assertEquals(result, event);
	}
}

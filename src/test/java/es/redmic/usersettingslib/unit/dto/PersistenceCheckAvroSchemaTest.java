package es.redmic.usersettingslib.unit.dto;

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

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import es.redmic.testutils.utils.AvroBaseTest;
import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class PersistenceCheckAvroSchemaTest extends AvroBaseTest {

	@Test
	public void serializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() throws JSONException {

		PersistenceDTO dto = SettingsDataUtil.getPersistenceDTO();

		Object result = serializerAndDeserializer(dto);

		assertTrue("El objeto obtenido debe ser una instancia de PersistenceDTO",
				PersistenceDTO.class.isInstance(result));

		JSONAssert.assertEquals(result.toString(), dto.toString(), false);
	}
}

package es.redmic.usersettingslib.unit.dto;

import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import es.redmic.testutils.utils.AvroBaseTest;
import es.redmic.usersettingslib.dto.SettingsDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class SettingsCheckAvroSchemaTest extends AvroBaseTest {

	@Test
	public void serializeAndDeserialize_IsSuccessful_IfSchemaAndDataAreCorrect() throws JSONException {

		SettingsDTO dto = SettingsDataUtil.getSettings();

		Object result = serializerAndDeserializer(dto);

		assertTrue("El objeto obtenido debe ser una instancia de SettingsDTO", SettingsDTO.class.isInstance(result));

		JSONAssert.assertEquals(result.toString(), dto.toString(), false);
	}
}

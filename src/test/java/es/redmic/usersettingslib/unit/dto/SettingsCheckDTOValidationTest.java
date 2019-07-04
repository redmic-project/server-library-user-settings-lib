package es.redmic.usersettingslib.unit.dto;

import org.junit.Before;
import org.junit.Test;

import es.redmic.testutils.dto.DTOBaseTest;
import es.redmic.usersettingslib.dto.SettingsDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class SettingsCheckDTOValidationTest extends DTOBaseTest<SettingsDTO> {

	private static SettingsDTO dto;

	@Before
	public void reset() {

		dto = SettingsDataUtil.getSettings();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnError_IfServiceIsNull() {

		dto.setService(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnError_IfSharedIsNull() {

		dto.setShared(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}

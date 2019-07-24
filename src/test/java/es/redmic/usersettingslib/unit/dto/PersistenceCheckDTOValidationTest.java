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

import org.junit.Before;
import org.junit.Test;

import es.redmic.testutils.dto.DTOBaseTest;
import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class PersistenceCheckDTOValidationTest extends DTOBaseTest<PersistenceDTO> {

	private static PersistenceDTO dto;

	@Before
	public void reset() {

		dto = SettingsDataUtil.getPersistenceDTO();
	}

	@Test
	public void validationDTO_NoReturnError_IfDTOIsCorrect() {

		checkDTOHasNoError(dto);
	}

	@Test
	public void validationDTO_ReturnError_IfSharedIsNull() {

		dto.setShared(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}

	@Test
	public void validationDTO_ReturnError_IfSettingsIdIsNull() {

		dto.setSettingsId(null);

		checkDTOHasError(dto, NOT_NULL_MESSAGE_TEMPLATE);
	}
}

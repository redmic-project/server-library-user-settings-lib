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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

import es.redmic.usersettingslib.dto.SelectionDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class SelectionEqualTest {

	@Test
	public void equal_returnTrue_IfSettingsTypeIsEqual() {

		SelectionDTO dto = SettingsDataUtil.getSelectionDTO();

		assertTrue(dto.equals(dto));
	}

	@Test
	public void equal_returnFalse_IfIdIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setId("111111");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfIdIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setId(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfSelectionIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.getSelection().add("ddd");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfSelectionIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setSelection(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfServiceIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setService("ddd");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfServiceIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setService(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfInsertedIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setInserted(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfInsertedIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setInserted(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUpdatedIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setUpdated(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUpdatedIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setUpdated(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfAccessedIsDifferent() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setAccessed(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfAccessedIsNull() {

		SelectionDTO dto1 = SettingsDataUtil.getSelectionDTO();

		SelectionDTO dto2 = SettingsDataUtil.getSelectionDTO();

		dto1.setAccessed(null);
		assertFalse(dto1.equals(dto2));
	}
}

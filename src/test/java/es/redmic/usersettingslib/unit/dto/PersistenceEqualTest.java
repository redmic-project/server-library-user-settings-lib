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

import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.unit.utils.SettingsDataUtil;

public class PersistenceEqualTest {

	@Test
	public void equal_returnTrue_IfSaveTypeIsEqual() {

		PersistenceDTO dto = SettingsDataUtil.getPersistenceDTO();

		assertTrue(dto.equals(dto));
	}

	@Test
	public void equal_returnFalse_IfIdIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setId("111111");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfIdIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setId(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfNameIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setName("cddd");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfNameIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setName(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfSharedIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setShared(true);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfSharedIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setShared(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUserIdIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setUserId("ddd");
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUserIdIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setUserId(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfInsertedIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setInserted(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfInsertedIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setInserted(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUpdatedIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setUpdated(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfUpdatedIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setUpdated(null);
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfAccessedIsDifferent() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setAccessed(DateTime.now().plus(2));
		assertFalse(dto1.equals(dto2));
	}

	@Test
	public void equal_returnFalse_IfAccessedIsNull() {

		PersistenceDTO dto1 = SettingsDataUtil.getPersistenceDTO();

		PersistenceDTO dto2 = SettingsDataUtil.getPersistenceDTO();

		dto1.setAccessed(null);
		assertFalse(dto1.equals(dto2));
	}
}

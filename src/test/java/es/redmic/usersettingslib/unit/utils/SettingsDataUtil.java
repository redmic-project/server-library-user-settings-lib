package es.redmic.usersettingslib.unit.utils;

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

import java.util.ArrayList;
import java.util.UUID;

import org.joda.time.DateTime;

import es.redmic.usersettingslib.dto.SaveDTO;
import es.redmic.usersettingslib.dto.SelectionDTO;

public abstract class SettingsDataUtil {

	// @formatter:off
	public final static String PREFIX = "settings-",
			CODE = UUID.randomUUID().toString(),
			USER = "1";
	// @formatter:on

	@SuppressWarnings("serial")
	public static SelectionDTO getSelectionDTO() {

		SelectionDTO selection = new SelectionDTO();

		selection.setId(PREFIX + CODE);
		selection.setService("prueba");
		selection.setSelection(new ArrayList<String>() {
			{
				add("1");
			}
		});

		selection.setInserted(DateTime.now());
		selection.setUpdated(DateTime.now());
		selection.setAccessed(DateTime.now());
		return selection;
	}

	public static SaveDTO getSaveDTO() {

		SaveDTO save = new SaveDTO();

		save.setId(PREFIX + CODE);
		save.setName("prueba");
		save.setUserId(USER);

		save.setInserted(DateTime.now());
		save.setUpdated(DateTime.now());
		save.setAccessed(DateTime.now());
		return save;
	}
}

package es.redmic.usersettingslib.repository;

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

import es.redmic.elasticsearchlib.data.repository.RWDataESRepository;
import es.redmic.models.es.common.dto.EventApplicationResult;
import es.redmic.models.es.common.query.dto.SimpleQueryDTO;
import es.redmic.usersettingslib.model.Settings;

public abstract class SettingsRepositoryImpl<TModel extends Settings, TQueryDTO extends SimpleQueryDTO>
		extends RWDataESRepository<TModel, TQueryDTO> {

	private static String[] INDEX = { "settings" };
	private static String TYPE = "_doc";

	public SettingsRepositoryImpl() {
		super(INDEX, TYPE);
	}

	@Override
	protected EventApplicationResult checkInsertConstraintsFulfilled(Settings modelToIndex) {
		return new EventApplicationResult(true);
	}

	@Override
	protected EventApplicationResult checkUpdateConstraintsFulfilled(Settings modelToIndex) {
		return new EventApplicationResult(true);
	}

	@Override
	protected EventApplicationResult checkDeleteConstraintsFulfilled(String modelToIndex) {
		return new EventApplicationResult(true);
	}
}

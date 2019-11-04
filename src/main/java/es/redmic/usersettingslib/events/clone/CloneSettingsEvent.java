package es.redmic.usersettingslib.events.clone;

import java.util.UUID;

import org.apache.avro.Schema;

import es.redmic.usersettingslib.dto.PersistenceDTO;
import es.redmic.usersettingslib.events.SettingsEventTypes;
import es.redmic.usersettingslib.events.common.PersistenceEvent;

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

public class CloneSettingsEvent extends PersistenceEvent {

	// @formatter:off

	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{"
		+ "\"type\":\"record\",\"name\":\"CloneSettingsEvent\","
				+ "\"namespace\":\"es.redmic.usersettingslib.events.clone\",\"fields\":["
			+ getPersistenceEventSchema() + ","
			+ getEventBaseSchema() + "]}");
	// @formatter:on

	static String type = SettingsEventTypes.CLONE;

	public CloneSettingsEvent() {
		super(type);
		setSessionId(UUID.randomUUID().toString());
	}

	public CloneSettingsEvent(PersistenceDTO persistence) {
		super(type);
		this.setPersistence(persistence);
		setSessionId(UUID.randomUUID().toString());
	}

	@Override
	public Schema getSchema() {
		return SCHEMA$;
	}
}

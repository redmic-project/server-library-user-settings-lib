package es.redmic.usersettingslib.events.common;

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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;

import es.redmic.brokerlib.avro.common.Event;
import es.redmic.usersettingslib.dto.PersistenceDTO;

public abstract class PersistenceEvent extends Event {

	private PersistenceDTO persistence;

	public PersistenceEvent(String type) {
		super(type);
	}

	public PersistenceDTO getPersistence() {
		return persistence;
	}

	public void setPersistence(PersistenceDTO persistence) {
		this.persistence = persistence;
	}

	@Override
	public void setUserId(String userId) {

		super.setUserId(userId);

		if (getPersistence() != null)
			getPersistence().setUserId(userId);
	}

	@Override
	public String getUserId() {

		if (getPersistence() != null)
			assert getPersistence().getUserId().equals(super.getUserId());

		return super.getUserId();
	}

	@Override
	public Object get(int field$) {
		switch (field$) {
		case 0:
			return getPersistence();
		case 1:
			return getAggregateId();
		case 2:
			return getVersion();
		case 3:
			return getType();
		case 4:
			return getDate().getMillis();
		case 5:
			return getSessionId();
		case 6:
			return getUserId();
		case 7:
			return getId();
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	@Override
	public void put(int field$, Object value$) {
		switch (field$) {
		case 0:
			persistence = (PersistenceDTO) value$;
			break;
		case 1:
			setAggregateId(value$.toString());
			break;
		case 2:
			setVersion((java.lang.Integer) value$);
			break;
		case 3:
			setType(value$.toString());
			break;
		case 4:
			setDate(new DateTime(value$, DateTimeZone.UTC));
			break;
		case 5:
			setSessionId(value$.toString());
			break;
		case 6:
			setUserId(value$.toString());
			break;
		case 7:
			setId(value$.toString());
			break;
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	@JsonIgnore
	public static String getPersistenceEventSchema() {

		return "{\"name\":\"persistence\", \"type\": " + PersistenceDTO.SCHEMA$.toString() + "}";
	}
}

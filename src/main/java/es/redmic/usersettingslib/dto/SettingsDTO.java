package es.redmic.usersettingslib.dto;

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

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.avro.Schema;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kjetland.jackson.jsonSchema.annotations.JsonSchemaDefault;

public class SettingsDTO extends SettingsBaseDTO {

	// @formatter:off
	
	@JsonIgnore
	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
		"{\"type\":\"record\",\"name\":\"SettingsDTO\",\"namespace\":\"es.redmic.usersettingslib.dto\",\"fields\":["
			+ "{\"name\":\"name\",\"type\":[\"string\", \"null\"]},"
			+ "{\"name\":\"shared\",\"type\":\"boolean\", \"default\": \"false\"},"
			+ "{\"name\": \"selection\",\"type\": [{\"type\": \"array\",\"items\":\"string\"},\"null\"]},"
			+ "{\"name\":\"userId\",\"type\":[\"string\", \"null\"]},"
			+ "{\"name\":\"service\",\"type\":\"string\"},"
			+ "{\"name\":\"inserted\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}],"
				+ "\"default\": null},"
			+ "{\"name\":\"updated\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}],"
				+ "\"default\": null},"
			+ "{\"name\":\"accessed\",\"type\":[\"null\",{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}],"
				+ "\"default\": null},"
			+ "{\"name\":\"id\",\"type\":\"string\"}]}");
	// @formatter:on

	public SettingsDTO() {
		super();
	}

	private String name;

	@JsonSchemaDefault(value = "false")
	@NotNull
	private Boolean shared = false;

	private List<String> selection;

	@NotNull
	private String userId;

	@NotNull
	private String service;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getShared() {
		return shared;
	}

	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public List<String> getSelection() {
		return selection;
	}

	public void setSelection(List<String> selection) {
		this.selection = selection;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	@Override
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String getService() {
		return service;
	}

	@Override
	public void setService(String service) {
		this.service = service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((selection == null) ? 0 : selection.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
		result = prime * result + ((shared == null) ? 0 : shared.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SettingsDTO other = (SettingsDTO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (selection == null) {
			if (other.selection != null)
				return false;
		} else if (!selection.equals(other.selection))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		if (shared == null) {
			if (other.shared != null)
				return false;
		} else if (!shared.equals(other.shared))
			return false;
		return true;
	}

	@JsonIgnore
	@Override
	public Schema getSchema() {
		return SCHEMA$;
	}

	@JsonIgnore
	@Override
	public Object get(int field) {
		switch (field) {
		case 0:
			return getName();
		case 1:
			return getShared();
		case 2:
			return getSelection();
		case 3:
			return getUserId();
		case 4:
			return getService();
		case 5:
			return getInserted() != null ? getInserted().getMillis() : null;
		case 6:
			return getUpdated() != null ? getUpdated().getMillis() : null;
		case 7:
			return getAccessed() != null ? getAccessed().getMillis() : null;
		case 8:
			return getId();
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	@SuppressWarnings({ "rawtypes" })
	@JsonIgnore
	@Override
	public void put(int field, Object value) {
		switch (field) {
		case 0:
			setName(value != null ? value.toString() : null);
			break;
		case 1:
			setShared(value != null ? (boolean) value : null);
			break;
		case 2:
			setSelection(value != null ? getStringList((java.util.List) value) : null);
			break;
		case 3:
			setUserId(value != null ? value.toString() : null);
			break;
		case 4:
			setService(value.toString());
			break;
		case 5:
			setInserted(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 6:
			setUpdated(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 7:
			setAccessed(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 8:
			setId(value.toString());
			break;
		default:
			throw new org.apache.avro.AvroRuntimeException("Bad index");
		}
	}

	@JsonIgnore
	private List<String> getStringList(List<?> value) {

		return value.stream().map(s -> s.toString()).collect(Collectors.toList());
	}
}

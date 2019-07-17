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

import org.apache.avro.Schema;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SelectionDTO extends SettingsBaseDTO {

	// @formatter:off
	
	@JsonIgnore
	public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse(
		"{\"type\":\"record\",\"name\":\"SelectionDTO\",\"namespace\":\"es.redmic.usersettingslib.dto\",\"fields\":["
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

	public SelectionDTO() {
		super();
	}

	private List<String> selection;

	public List<String> getSelection() {
		return selection;
	}

	public void setSelection(List<String> selection) {
		this.selection = selection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((selection == null) ? 0 : selection.hashCode());
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
		SelectionDTO other = (SelectionDTO) obj;
		if (selection == null) {
			if (other.selection != null)
				return false;
		} else if (!selection.equals(other.selection))
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
			return getSelection();
		case 1:
			return getUserId();
		case 2:
			return getService();
		case 3:
			return getInserted() != null ? getInserted().getMillis() : null;
		case 4:
			return getUpdated() != null ? getUpdated().getMillis() : null;
		case 5:
			return getAccessed() != null ? getAccessed().getMillis() : null;
		case 6:
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
			setSelection(value != null ? getStringList((java.util.List) value) : null);
			break;
		case 1:
			setUserId(value != null ? value.toString() : null);
			break;
		case 2:
			setService(value.toString());
			break;
		case 3:
			setInserted(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 4:
			setUpdated(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 5:
			setAccessed(value != null ? new DateTime(value, DateTimeZone.UTC).toDateTime() : null);
			break;
		case 6:
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

package es.redmic.usersettingslib.model;

import java.util.List;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import es.redmic.brokerlib.deserializer.CustomDateTimeDeserializer;
import es.redmic.brokerlib.serializer.CustomDateTimeSerializer;
import es.redmic.models.es.common.model.BaseAbstractStringES;

public class Settings extends BaseAbstractStringES {

	private String name;

	private Boolean shared;

	private List<String> selection;

	private String service;

	private String userId;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime inserted;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	private DateTime updated;

	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	DateTime accessed;

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

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public DateTime getInserted() {
		return inserted;
	}

	public void setInserted(DateTime inserted) {
		this.inserted = inserted;
	}

	public DateTime getUpdated() {
		return updated;
	}

	public void setUpdated(DateTime updated) {
		this.updated = updated;
	}

	public DateTime getAccessed() {
		return accessed;
	}

	public void setAccessed(DateTime accessed) {
		this.accessed = accessed;
	}

}

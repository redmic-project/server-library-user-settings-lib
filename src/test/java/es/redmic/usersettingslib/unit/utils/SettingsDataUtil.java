package es.redmic.usersettingslib.unit.utils;

import java.util.ArrayList;
import java.util.UUID;

import org.joda.time.DateTime;

import es.redmic.usersettingslib.dto.SettingsDTO;

public abstract class SettingsDataUtil {

	// @formatter:off
	public final static String PREFIX = "settings-",
			CODE = UUID.randomUUID().toString(),
			USER = "1";
	// @formatter:on

	@SuppressWarnings("serial")
	public static SettingsDTO getSettings() {

		SettingsDTO settings = new SettingsDTO();

		settings.setId(PREFIX + CODE);
		settings.setName("prueba");
		settings.setService("prueba");
		settings.setUserId(USER);
		settings.setSelection(new ArrayList<String>() {
			{
				add("1");
			}
		});

		settings.setInserted(DateTime.now());
		settings.setUpdated(DateTime.now());
		settings.setAccessed(DateTime.now());
		return settings;
	}
}

package es.redmic.usersettingslib.events;

public abstract class SettingsEventTypes {

	public static String
	// @formatter:off
		//SELECT
		SELECT = "SELECT",
		SELECT_CONFIRMED = "SELECT_CONFIRMED",
		SELECTED = "SELECTED",
		SELECT_FAILED = "SELECT_FAILED",
		SELECT_CANCELLED = "SELECT_CANCELLED",
		//DESELECT
		DESELECT = "DESELECT",
		DESELECT_CONFIRMED = "DESELECT_CONFIRMED",
		DESELECTED = "DESELECTED",
		DESELECT_FAILED = "DESELECT_FAILED",
		DESELECT_CANCELLED = "DESELECT_CANCELLED",
		//CLEAR
		CLEAR = "CLEAR",
		CLEAR_CONFIRMED = "CLEAR_CONFIRMED",
		CLEARED = "CLEARED",
		CLEAR_FAILED = "CLEAR_FAILED",
		CLEAR_CANCELLED = "CLEAR_CANCELLED",
		//SAVE
		SAVE = "SAVE",
		SAVE_CONFIRMED = "SAVE_CONFIRMED",
		SAVED = "SAVED",
		SAVE_FAILED = "SAVE_FAILED",
		SAVE_CANCELLED = "SAVE_CANCELLED",
		//SHARE
		SHARE = "SHARE",
		SHARE_CONFIRMED = "SHARE_CONFIRMED",
		SHARED = "SHARED",
		SHARE_FAILED = "SHARE_FAILED",
		SHARE_CANCELLED = "SHARE_CANCELLED";
	//@formatter:on

	public static boolean isLocked(String eventType) {

		return !(eventType.equals(SELECTED.toString()) || eventType.equals(SELECT_CANCELLED.toString())
				|| eventType.equals(DESELECTED.toString()) || eventType.equals(DESELECT_CANCELLED.toString())
				|| eventType.equals(CLEARED.toString()) || eventType.equals(CLEAR_CANCELLED.toString())
				|| eventType.equals(SAVED.toString()) || eventType.equals(SAVE_CANCELLED.toString())
				|| eventType.equals(SHARED.toString()) || eventType.equals(SHARE_CANCELLED.toString()));
	}

	public static boolean isSnapshot(String eventType) {

		return eventType.equals(SettingsEventTypes.SELECTED.toString())
				|| eventType.equals(SettingsEventTypes.DESELECTED.toString())
				|| eventType.equals(SettingsEventTypes.CLEARED.toString())
				|| eventType.equals(SettingsEventTypes.SAVED.toString())
				|| eventType.equals(SettingsEventTypes.SHARED.toString());
	}

	public static boolean isUpdatable(String eventType) {

		return isSnapshot(eventType);
	}
}

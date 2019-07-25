package es.redmic.usersettingslib.events;

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

public abstract class SettingsEventTypes {

	public static String
	// @formatter:off
		//SELECT
		PARTIAL_SELECT = "PARTIAL_SELECT",
		SELECT = "SELECT",
		SELECT_CONFIRMED = "SELECT_CONFIRMED",
		SELECTED = "SELECTED",
		SELECT_FAILED = "SELECT_FAILED",
		SELECT_CANCELLED = "SELECT_CANCELLED",
		//DESELECT
		PARTIAL_DESELECT = "PARTIAL_DESELECT",
		DESELECT = "DESELECT",
		DESELECT_CONFIRMED = "DESELECT_CONFIRMED",
		DESELECTED = "DESELECTED",
		DESELECT_FAILED = "DESELECT_FAILED",
		DESELECT_CANCELLED = "DESELECT_CANCELLED",
		//CLEAR
		PARTIAL_CLEAR_SELECTION = "PARTIAL_CLEAR_SELECTION",
		CLEAR_SELECTION = "CLEAR_SELECTION",
		CLEAR_SELECTION_CONFIRMED = "CLEAR_SELECTION_CONFIRMED",
		SELECTION_CLEARED = "SELECTION_CLEARED",
		CLEAR_SELECTION_FAILED = "CLEAR_SELECTION_FAILED",
		CLEAR_SELECTION_CANCELLED = "CLEAR_SELECTION_CANCELLED",
		//SAVE
		PARTIAL_SAVE = "PARTIAL_SAVE",
		SAVE = "SAVE",
		SAVE_CONFIRMED = "SAVE_CONFIRMED",
		SAVED = "SAVED",
		SAVE_FAILED = "SAVE_FAILED",
		SAVE_CANCELLED = "SAVE_CANCELLED",
		//CLONE
		CLONE = "CLONE",
		//UPDATE
		UPDATE_ACCESSED_DATE = "UPDATE_ACCESSED_DATE",
		//DELETE
		DELETE = "DELETE",
		CHECK_DELETE = "CHECK_DELETE",
		DELETE_CHECKED = "DELETE_CHECKED",
		CHECK_DELETE_FAILED = "CHECK_DELETE_FAILED",
		DELETE_CONFIRMED = "DELETE_CONFIRMED",
		DELETED = "DELETED",
		DELETE_FAILED = "DELETE_FAILED",
		DELETE_CANCELLED = "DELETE_CANCELLED";
	//@formatter:on

	public static boolean isLocked(String eventType) {

		return !(eventType.equals(SELECTED.toString()) || eventType.equals(SELECT_CANCELLED.toString())
				|| eventType.equals(DESELECTED.toString()) || eventType.equals(DESELECT_CANCELLED.toString())
				|| eventType.equals(SELECTION_CLEARED.toString())
				|| eventType.equals(CLEAR_SELECTION_CANCELLED.toString()) || eventType.equals(SAVED.toString())
				|| eventType.equals(SAVE_CANCELLED.toString()) || eventType.equals(DELETE_CANCELLED.toString()));
	}

	public static boolean isSnapshot(String eventType) {

		return eventType.equals(SELECTED.toString()) || eventType.equals(DESELECTED.toString())
				|| eventType.equals(SELECTION_CLEARED.toString()) || eventType.equals(SAVED.toString())
				|| eventType.equals(DELETED.toString());
	}

	public static boolean isUpdatable(String eventType) {

		return (isSnapshot(eventType) && !eventType.equals(DELETED.toString()));
	}
}

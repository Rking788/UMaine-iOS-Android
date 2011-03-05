package org.umece.android.umaine;

public class Course {
	private String coursenum;
	private String title;
	private String sessionnum;
	private String description;
	private String days;
	private String times;
	private String building;
	private String roomnum;
	
	/**
	 * Creates a course to be added to a semester.
	 * 
	 * @param cnum Course Number
	 * @param ctitle Title
	 * @param csession Session Number
	 * @param cdesc Description
	 * @param cdays Course Meeting Days
	 * @param ctimes Course Times
	 * @param cbuilding Course Location
	 * @param croomnum Course Room
	 * 
	 * @author jmonk
	 */
	public Course(String cnum, String ctitle, String csession, String cdesc, 
			String cdays, String ctimes, String cbuilding, String croomnum) {
		coursenum = cnum;
		title = ctitle;
		sessionnum = csession;
		description = cdesc;
		days = cdays;
		times = ctimes;
		building = cbuilding;
		roomnum = croomnum;
	}

	/**
	 * Creates a course from the comma separated list found in each
	 * semester's file. Throws exception if strings is not at least length
	 * 8.
	 * 
	 * @param strings Course info in the following order: course_num, title,
	 *					session_num, description, days, times, building, 
	 *					room_num.
	 *
	 *@author jmonk
	 */
	public Course(String[] strings) {
		for (String string : strings) {
			string.replaceAll("\"", "");
		}
		
		coursenum = strings[0];
		title = strings[1];
		sessionnum = strings[2];
		description = strings[3];
		days = strings[4];
		times = strings[5];
		building = strings[6];
		roomnum = strings[7];
	}
	
	/**
	 * Returns all of the fields of the course separated by |.
	 * They are listed in the following order: course_num, title,
	 *					session_num, description, days, times, building, 
	 *					room_num.
	 *
	 * @author jmonk
	 */
	@Override
	public String toString() {
		String return_val;
		
		return_val = "\"" + coursenum + "\",\"";
		return_val = (return_val + title + "\",\"");
		return_val = (return_val + sessionnum + "\",\"");
		return_val = (return_val + description + "\",\"");
		return_val = (return_val + days + "\",\"");
		return_val = (return_val + times + "\",\"");
		return_val = (return_val + building + "\",\"");
		return_val = (return_val + roomnum + "\"");
		
		return return_val;
	}
	
	public String getCoursenum() {
		return coursenum;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSessionnum() {
		return sessionnum;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getDays() {
		return days;
	}
	
	public String getTimes() {
		return times;
	}
	
	public String getBuilding() {
		return building;
	}
	
	public String getRoomnum() {
		return roomnum;
	}
}
package com.aygxy.xlyy.user.entity;

public class TimeTemplate {

	private String id;
	private String timeName;
	private String timeStart;
	private String timeEnd;

	private boolean isPlan;

	/**
	 * @return the isPlan
	 */
	public boolean isPlan() {
		return isPlan;
	}

	/**
	 * @param isPlan
	 *            the isPlan to set
	 */
	public void setPlan(boolean isPlan) {
		this.isPlan = isPlan;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the timeName
	 */
	public String getTimeName() {
		return timeName;
	}

	/**
	 * @param timeName
	 *            the timeName to set
	 */
	public void setTimeName(String timeName) {
		this.timeName = timeName;
	}

	/**
	 * @return the timeStart
	 */
	public String getTimeStart() {
		return timeStart;
	}

	/**
	 * @param timeStart
	 *            the timeStart to set
	 */
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * @return the timeEnd
	 */
	public String getTimeEnd() {
		return timeEnd;
	}

	/**
	 * @param timeEnd
	 *            the timeEnd to set
	 */
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

}

package com.aygxy.xlyy.user.entity;

public class Appoint {

	private String id;
	private String stuId;
	private String teacherId;
	private String freeTimeId;
	private String appointTime;

	private FreeTime freeTimeInfo;

	/**
	 * @return the freeTime
	 */
	public FreeTime getFreeTime() {
		return freeTimeInfo;
	}

	/**
	 * @param freeTime
	 *            the freeTime to set
	 */
	public void setFreeTime(FreeTime freeTimeInfo) {
		this.freeTimeInfo = freeTimeInfo;
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
	 * @return the stuId
	 */
	public String getStuId() {
		return stuId;
	}

	/**
	 * @param stuId
	 *            the stuId to set
	 */
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId
	 *            the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the freeTimeId
	 */
	public String getFreeTimeId() {
		return freeTimeId;
	}

	/**
	 * @param freeTimeId
	 *            the freeTimeId to set
	 */
	public void setFreeTimeId(String freeTimeId) {
		this.freeTimeId = freeTimeId;
	}

	/**
	 * @return the appointTime
	 */
	public String getAppointTime() {
		return appointTime;
	}

	/**
	 * @param appointTime
	 *            the appointTime to set
	 */
	public void setAppointTime(String appointTime) {
		this.appointTime = appointTime;
	}

}

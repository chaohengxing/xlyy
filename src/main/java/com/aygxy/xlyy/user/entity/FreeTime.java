package com.aygxy.xlyy.user.entity;

import java.util.List;

public class FreeTime {

	private String id;
	private String teacherId;
	private String timeDate;
	private String timeId;

	private TimeTemplate timeTemplate;

	private TeacherInfo teacherInfo;

	private List<Appoint> appoints;

	/**
	 * @return the appoint
	 */
	public List<Appoint> getAppoint() {
		return appoints;
	}

	/**
	 * @param appoint
	 *            the appoint to set
	 */
	public void setAppoint(List<Appoint> appoints) {
		this.appoints = appoints;
	}

	/**
	 * @return the timeTemplate
	 */
	public TimeTemplate getTimeTemplate() {
		return timeTemplate;
	}

	/**
	 * @param timeTemplate
	 *            the timeTemplate to set
	 */
	public void setTimeTemplate(TimeTemplate timeTemplate) {
		this.timeTemplate = timeTemplate;
	}

	/**
	 * @return the teacherInfo
	 */
	public TeacherInfo getTeacherInfo() {
		return teacherInfo;
	}

	/**
	 * @param teacherInfo
	 *            the teacherInfo to set
	 */
	public void setTeacherInfo(TeacherInfo teacherInfo) {
		this.teacherInfo = teacherInfo;
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
	 * @return the timeDate
	 */
	public String getTimeDate() {
		return timeDate;
	}

	/**
	 * @param timeDate
	 *            the timeDate to set
	 */
	public void setTimeDate(String timeDate) {
		this.timeDate = timeDate;
	}

	/**
	 * @return the timeId
	 */
	public String getTimeId() {
		return timeId;
	}

	/**
	 * @param timeId
	 *            the timeId to set
	 */
	public void setTimeId(String timeId) {
		this.timeId = timeId;
	}

}

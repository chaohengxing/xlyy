package com.aygxy.xlyy.user.entity;

import java.util.List;

public class DiscussJt {

	private String id;
	private String jtId;
	private int userType;
	private String userId;
	private StudentInfo studentInfo;
	private TeacherInfo teacherInfo;

	private String discussInfo;
	private String discussTime;
	private int discussLevel;

	private List<ReplayDiscussJt> replayDiscussJts;

	/**
	 * @return the replayDiscussJts
	 */
	public List<ReplayDiscussJt> getReplayDiscussJts() {
		return replayDiscussJts;
	}

	/**
	 * @param replayDiscussJts
	 *            the replayDiscussJts to set
	 */
	public void setReplayDiscussJts(List<ReplayDiscussJt> replayDiscussJts) {
		this.replayDiscussJts = replayDiscussJts;
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
	 * @return the jtId
	 */
	public String getJtId() {
		return jtId;
	}

	/**
	 * @param jtId
	 *            the jtId to set
	 */
	public void setJtId(String jtId) {
		this.jtId = jtId;
	}

	/**
	 * @return the userType
	 */
	public int getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            the userType to set
	 */
	public void setUserType(int userType) {
		this.userType = userType;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the studentInfo
	 */
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	/**
	 * @param studentInfo
	 *            the studentInfo to set
	 */
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
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
	 * @return the discussInfo
	 */
	public String getDiscussInfo() {
		return discussInfo;
	}

	/**
	 * @param discussInfo
	 *            the discussInfo to set
	 */
	public void setDiscussInfo(String discussInfo) {
		this.discussInfo = discussInfo;
	}

	/**
	 * @return the discussTime
	 */
	public String getDiscussTime() {
		return discussTime;
	}

	/**
	 * @param discussTime
	 *            the discussTime to set
	 */
	public void setDiscussTime(String discussTime) {
		this.discussTime = discussTime;
	}

	/**
	 * @return the discussLevel
	 */
	public int getDiscussLevel() {
		return discussLevel;
	}

	/**
	 * @param discussLevel
	 *            the discussLevel to set
	 */
	public void setDiscussLevel(int discussLevel) {
		this.discussLevel = discussLevel;
	}

}

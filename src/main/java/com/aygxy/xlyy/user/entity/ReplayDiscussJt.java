package com.aygxy.xlyy.user.entity;

public class ReplayDiscussJt {

	private String id;
	private String discussId;
	private int replayUserType;
	private String replayUserId;
	private StudentInfo replayStudentInfo;
	private TeacherInfo replayTeacherInfo;
	private String replayInfo;
	private String replayTime;
	private int passiveUserType;
	private String passiveUserId;
	private StudentInfo passiveStudentInfo;
	private TeacherInfo passiveTeacherInfo;

	/**
	 * @return the replayStudentInfo
	 */
	public StudentInfo getReplayStudentInfo() {
		return replayStudentInfo;
	}

	/**
	 * @param replayStudentInfo
	 *            the replayStudentInfo to set
	 */
	public void setReplayStudentInfo(StudentInfo replayStudentInfo) {
		this.replayStudentInfo = replayStudentInfo;
	}

	/**
	 * @return the replayTeacherInfo
	 */
	public TeacherInfo getReplayTeacherInfo() {
		return replayTeacherInfo;
	}

	/**
	 * @param replayTeacherInfo
	 *            the replayTeacherInfo to set
	 */
	public void setReplayTeacherInfo(TeacherInfo replayTeacherInfo) {
		this.replayTeacherInfo = replayTeacherInfo;
	}

	/**
	 * @return the passiveStudentInfo
	 */
	public StudentInfo getPassiveStudentInfo() {
		return passiveStudentInfo;
	}

	/**
	 * @param passiveStudentInfo
	 *            the passiveStudentInfo to set
	 */
	public void setPassiveStudentInfo(StudentInfo passiveStudentInfo) {
		this.passiveStudentInfo = passiveStudentInfo;
	}

	/**
	 * @return the passiveTeacherInfo
	 */
	public TeacherInfo getPassiveTeacherInfo() {
		return passiveTeacherInfo;
	}

	/**
	 * @param passiveTeacherInfo
	 *            the passiveTeacherInfo to set
	 */
	public void setPassiveTeacherInfo(TeacherInfo passiveTeacherInfo) {
		this.passiveTeacherInfo = passiveTeacherInfo;
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
	 * @return the discussId
	 */
	public String getDiscussId() {
		return discussId;
	}

	/**
	 * @param discussId
	 *            the discussId to set
	 */
	public void setDiscussId(String discussId) {
		this.discussId = discussId;
	}

	/**
	 * @return the replayInfo
	 */
	public String getReplayInfo() {
		return replayInfo;
	}

	/**
	 * @param replayInfo
	 *            the replayInfo to set
	 */
	public void setReplayInfo(String replayInfo) {
		this.replayInfo = replayInfo;
	}

	/**
	 * @return the replayTime
	 */
	public String getReplayTime() {
		return replayTime;
	}

	/**
	 * @param replayTime
	 *            the replayTime to set
	 */
	public void setReplayTime(String replayTime) {
		this.replayTime = replayTime;
	}

	/**
	 * @return the replayUserType
	 */
	public int getReplayUserType() {
		return replayUserType;
	}

	/**
	 * @param replayUserType
	 *            the replayUserType to set
	 */
	public void setReplayUserType(int replayUserType) {
		this.replayUserType = replayUserType;
	}

	/**
	 * @return the replayUserId
	 */
	public String getReplayUserId() {
		return replayUserId;
	}

	/**
	 * @param replayUserId
	 *            the replayUserId to set
	 */
	public void setReplayUserId(String replayUserId) {
		this.replayUserId = replayUserId;
	}

	/**
	 * @return the passiveUserType
	 */
	public int getPassiveUserType() {
		return passiveUserType;
	}

	/**
	 * @param passiveUserType
	 *            the passiveUserType to set
	 */
	public void setPassiveUserType(int passiveUserType) {
		this.passiveUserType = passiveUserType;
	}

	/**
	 * @return the passiveUserId
	 */
	public String getPassiveUserId() {
		return passiveUserId;
	}

	/**
	 * @param passiveUserId
	 *            the passiveUserId to set
	 */
	public void setPassiveUserId(String passiveUserId) {
		this.passiveUserId = passiveUserId;
	}

}

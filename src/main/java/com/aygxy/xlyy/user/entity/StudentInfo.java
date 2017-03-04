package com.aygxy.xlyy.user.entity;

public class StudentInfo extends User {

	private int userType;
	private String userClass;
	private String userMajor;
	private String registerTime;
	private String stuIcon;
	private int stuStatus;
	private String stuNickName;
	private String sex;

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserClass() {
		return userClass;
	}

	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}

	public String getUserMajor() {
		return userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	public String getStuIcon() {
		return stuIcon;
	}

	public void setStuIcon(String stuIcon) {
		this.stuIcon = stuIcon;
	}

	public int getStuStatus() {
		return stuStatus;
	}

	public void setStuStatus(int stuStatus) {
		this.stuStatus = stuStatus;
	}

	public String getStuNickName() {
		return stuNickName;
	}

	public void setStuNickName(String stuNickName) {
		this.stuNickName = stuNickName;
	}

}

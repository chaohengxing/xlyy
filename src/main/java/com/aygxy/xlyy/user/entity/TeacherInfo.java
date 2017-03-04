package com.aygxy.xlyy.user.entity;

import java.util.List;

public class TeacherInfo extends User {

	private String teacherNickName;
	private int userType;
	private String teacherIntro;
	private String teacherIcon;
	private List<DiscussTeacher> discussTeachers;

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

	public List<DiscussTeacher> getDiscussTeachers() {
		return discussTeachers;
	}

	public void setDiscussTeachers(List<DiscussTeacher> discussTeachers) {
		this.discussTeachers = discussTeachers;
	}

	public String getTeacherNickName() {
		return teacherNickName;
	}

	public void setTeacherNickName(String teacherNickName) {
		this.teacherNickName = teacherNickName;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getTeacherIntro() {
		return teacherIntro;
	}

	public void setTeacherIntro(String teacherIntro) {
		this.teacherIntro = teacherIntro;
	}

	public String getTeacherIcon() {
		return teacherIcon;
	}

	public void setTeacherIcon(String teacherIcon) {
		this.teacherIcon = teacherIcon;
	}

}

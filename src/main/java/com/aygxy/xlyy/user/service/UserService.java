package com.aygxy.xlyy.user.service;

import java.util.List;

import com.aygxy.xlyy.user.entity.StudentInfo;
import com.aygxy.xlyy.user.entity.TeacherInfo;
import com.aygxy.xlyy.user.entity.User;

public interface UserService {

	User findUserById(String id);

	User login(String userName, String password);

	TeacherInfo getTeacherInfo(String id);

	StudentInfo getStudentInfo(String id);

	List<TeacherInfo> getTeacherInfoList();

	int updateStudentInfo(String id, String stuIcon, String stuNickName,
			String sex, String userClass, String userMajor);

	int updateTeacherInfo(String id, String teacherIcon,
			String teacherNickName, String sex, String teacherIntro);

}

package com.aygxy.xlyy.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.aygxy.xlyy.user.entity.StudentInfo;
import com.aygxy.xlyy.user.entity.TeacherInfo;
import com.aygxy.xlyy.user.entity.User;

@Repository
public interface UserMapper {

	User findUserById(@Param("id") String id);

	User login(@Param("userName") String userName,
			@Param("password") String password);

	TeacherInfo getTeacherInfo(@Param("id") String id);

	StudentInfo getStudentInfo(@Param("id") String id);

	List<TeacherInfo> getTeacherInfoList();

	int updateStudentInfo(@Param("id") String id,
			@Param("stuIcon") String stuIcon,
			@Param("stuNickName") String stuNickName, @Param("sex") String sex,
			@Param("userClass") String userClass,
			@Param("userMajor") String userMajor);

	int updateTeacherInfo(@Param("id") String id,
			@Param("teacherIcon") String teacherIcon,
			@Param("teacherNickName") String teacherNickName,
			@Param("sex") String sex, @Param("teacherIntro") String teacherIntro);

}

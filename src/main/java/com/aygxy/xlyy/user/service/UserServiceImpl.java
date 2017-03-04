package com.aygxy.xlyy.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aygxy.xlyy.user.dao.UserMapper;
import com.aygxy.xlyy.user.entity.StudentInfo;
import com.aygxy.xlyy.user.entity.TeacherInfo;
import com.aygxy.xlyy.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	UserMapper userMapper;

	@Override
	public User findUserById(String id) {
		User user = userMapper.findUserById(id);
		return user;
	}

	@Override
	public User login(String userName, String password) {

		return userMapper.login(userName, password);
	}

	@Override
	public TeacherInfo getTeacherInfo(String id) {
		// TODO Auto-generated method stub
		return userMapper.getTeacherInfo(id);
	}

	@Override
	public StudentInfo getStudentInfo(String id) {
		// TODO Auto-generated method stub
		return userMapper.getStudentInfo(id);
	}

	@Override
	public List<TeacherInfo> getTeacherInfoList() {
		// TODO Auto-generated method stub
		return userMapper.getTeacherInfoList();
	}

	@Override
	public int updateStudentInfo(String id, String stuIcon, String stuNickName,
			String sex, String userClass, String userMajor) {
		// TODO Auto-generated method stub
		return userMapper.updateStudentInfo(id, stuIcon, stuNickName, sex,
				userClass, userMajor);
	}

	@Override
	public int updateTeacherInfo(String id, String teacherIcon,
			String teacherNickName, String sex, String teacherIntro) {
		// TODO Auto-generated method stub
		return userMapper.updateTeacherInfo(id, teacherIcon, teacherNickName,
				sex, teacherIntro);
	}

}

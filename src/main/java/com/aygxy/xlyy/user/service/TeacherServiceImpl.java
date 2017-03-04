package com.aygxy.xlyy.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aygxy.xlyy.user.dao.TeacherMapper;
import com.aygxy.xlyy.user.entity.DiscussTeacher;
import com.aygxy.xlyy.user.entity.TeacherInfo;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Resource
	TeacherMapper teacherMapper;

	@Override
	public TeacherInfo getTeacherInfoAndDiscussWithReplay(String id) {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacherInfoAndDiscussWithReplay(id);
	}

	@Override
	public int sendDiscussForTeacher(DiscussTeacher discussTeacher) {
		// TODO Auto-generated method stub
		return teacherMapper.sendDiscussForTeacher(discussTeacher);
	}

}

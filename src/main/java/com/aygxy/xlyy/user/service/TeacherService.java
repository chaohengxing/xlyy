package com.aygxy.xlyy.user.service;

import com.aygxy.xlyy.user.entity.DiscussTeacher;
import com.aygxy.xlyy.user.entity.TeacherInfo;

public interface TeacherService {

	TeacherInfo getTeacherInfoAndDiscussWithReplay(String id);

	int sendDiscussForTeacher(DiscussTeacher discussTeacher);

}

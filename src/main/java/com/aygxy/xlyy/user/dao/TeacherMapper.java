package com.aygxy.xlyy.user.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.aygxy.xlyy.user.entity.DiscussTeacher;
import com.aygxy.xlyy.user.entity.TeacherInfo;

@Repository
public interface TeacherMapper {

	TeacherInfo getTeacherInfoAndDiscussWithReplay(@Param("id") String id);

	int sendDiscussForTeacher(DiscussTeacher discussTeacher);

}

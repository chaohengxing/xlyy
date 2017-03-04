package com.aygxy.xlyy.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.aygxy.xlyy.user.entity.Appoint;
import com.aygxy.xlyy.user.entity.FreeTime;
import com.aygxy.xlyy.user.entity.TimeTemplate;

@Repository
public interface AppointMapper {

	public List<TimeTemplate> getTimeTemplate();

	public List<FreeTime> getFreeTimeOfTimeDate(
			@Param("timeDates") List<String> timeDates);

	public int planFreeTime(FreeTime freeTime);

	public List<FreeTime> getTeacherInfoOfFreeTime(
			@Param("timeDate") String timeDate, @Param("timeId") String timeId);

	public int sendAppoint(Appoint appoint);

	public List<Appoint> getStudentAppointWithFreeTime(
			@Param("stuId") String stuId,
			@Param("timeDates") List<String> timeDates);

	public List<Appoint> getAppointWithStuIdAndFreetimeId(
			@Param("stuId") String stuId, @Param("freeTimeId") String freeTimeId);

	public FreeTime getFreeTimeOfteacherIdAndTimeIdAndTimeDate(
			@Param("teacherId") String teacherId,
			@Param("timeId") String timeId, @Param("timeDate") String timeDate);

	public TimeTemplate getTimeTemplateOfId(@Param("id") String id);

}

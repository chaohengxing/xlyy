package com.aygxy.xlyy.user.service;

import java.util.List;

import com.aygxy.xlyy.user.entity.Appoint;
import com.aygxy.xlyy.user.entity.FreeTime;
import com.aygxy.xlyy.user.entity.TimeTemplate;

public interface AppointService {

	List<TimeTemplate> getTimeTemplate();

	List<FreeTime> getFreeTimeOfTimeDate(List<String> timeDate);

	int planFreeTime(FreeTime freeTime);

	List<FreeTime> getTeacherInfoOfFreeTime(String timeDate, String timeId);

	int sendAppoint(Appoint appoint);

	List<Appoint> getStudentAppointWithFreeTime(String stuId,
			List<String> timeDates);

	List<Appoint> getAppointWithStuIdAndFreetimeId(String stuId, String id);

	FreeTime getFreeTimeOfteacherIdAndTimeIdAndTimeDate(String teacherId,
			String timeId, String timeDate);

	TimeTemplate getTimeTemplateOfId(String timeId);

}

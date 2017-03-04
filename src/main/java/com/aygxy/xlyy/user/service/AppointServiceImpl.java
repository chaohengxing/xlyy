package com.aygxy.xlyy.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aygxy.xlyy.user.dao.AppointMapper;
import com.aygxy.xlyy.user.entity.Appoint;
import com.aygxy.xlyy.user.entity.FreeTime;
import com.aygxy.xlyy.user.entity.TimeTemplate;

@Service
public class AppointServiceImpl implements AppointService {
	@Resource
	AppointMapper appointMapper;

	@Override
	public List<TimeTemplate> getTimeTemplate() {
		// TODO Auto-generated method stub
		return appointMapper.getTimeTemplate();
	}

	@Override
	public List<FreeTime> getFreeTimeOfTimeDate(List<String> timeDate) {
		// TODO Auto-generated method stub
		return appointMapper.getFreeTimeOfTimeDate(timeDate);
	}

	@Override
	public int planFreeTime(FreeTime freeTime) {
		// TODO Auto-generated method stub
		return appointMapper.planFreeTime(freeTime);
	}

	@Override
	public List<FreeTime> getTeacherInfoOfFreeTime(String timeDate,
			String timeId) {
		// TODO Auto-generated method stub
		return appointMapper.getTeacherInfoOfFreeTime(timeDate, timeId);
	}

	@Override
	public int sendAppoint(Appoint appoint) {
		// TODO Auto-generated method stub
		return appointMapper.sendAppoint(appoint);
	}

	@Override
	public List<Appoint> getStudentAppointWithFreeTime(String stuId,
			List<String> timeDates) {
		// TODO Auto-generated method stub
		return appointMapper.getStudentAppointWithFreeTime(stuId, timeDates);
	}

	@Override
	public List<Appoint> getAppointWithStuIdAndFreetimeId(String stuId,
			String freeTimeId) {
		// TODO Auto-generated method stub
		return appointMapper
				.getAppointWithStuIdAndFreetimeId(stuId, freeTimeId);
	}

	@Override
	public FreeTime getFreeTimeOfteacherIdAndTimeIdAndTimeDate(
			String teacherId, String timeId, String timeDate) {
		// TODO Auto-generated method stub
		return appointMapper.getFreeTimeOfteacherIdAndTimeIdAndTimeDate(
				teacherId, timeId, timeDate);
	}

	@Override
	public TimeTemplate getTimeTemplateOfId(String timeId) {
		// TODO Auto-generated method stub
		return appointMapper.getTimeTemplateOfId(timeId);
	}

}

package com.aygxy.xlyy.user.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aygxy.xlyy.user.entity.Appoint;
import com.aygxy.xlyy.user.entity.BaseEntity;
import com.aygxy.xlyy.user.entity.FreeTime;
import com.aygxy.xlyy.user.entity.TeacherTimePlan;
import com.aygxy.xlyy.user.entity.TimeTemplate;
import com.aygxy.xlyy.user.service.AppointService;
import com.aygxy.xlyy.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/appoint")
public class AppointController {

	@Resource
	AppointService appointService;
	@Resource
	UserService userService;

	/**
	 * 教师用户获取 从今天往后五天的时间排布情况
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/teacherGetFreeTimes.action")
	@ResponseBody
	public BaseEntity teacherGetFreeTimes(HttpServletRequest request,
			Model model) {

		try {
			// 先返回当前的 time_template列表
			List<TimeTemplate> templates = appointService.getTimeTemplate();

			JavaType javaType = new ObjectMapper().getTypeFactory()
					.constructParametricType(List.class, String.class);
			List<String> timeDates = new ObjectMapper().readValue(request
					.getParameter("timeDatesJson").getBytes(), javaType);
			String teacherId = request.getParameter("teacherId");
			List<FreeTime> freeTimes = new ArrayList<FreeTime>();
			for (int i = 0; i < templates.size(); i++) {
				for (int j = 0; j < timeDates.size(); j++) {
					// 根据 teacherId、timeId、timeDate去freeTime表中查询 该老师在该天的该时段是否预约了
					FreeTime freeTime = appointService
							.getFreeTimeOfteacherIdAndTimeIdAndTimeDate(
									teacherId, templates.get(i).getId(),
									timeDates.get(j));
					if (freeTime != null) {

						freeTimes.add(freeTime);
					}
				}

			}

			if (templates != null && templates.size() != 0) {

				return new BaseEntity(200, "获取时间安排成功",
						new ObjectMapper()
								.writeValueAsString(new TeacherTimePlan(
										templates, freeTimes)));
			} else {
				return new BaseEntity(-200, "获取时间安排失败", null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "获取时间安排失败", null);

		}

	}

	/**
	 * 老师发布排挡
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/planFreeTime.action")
	@ResponseBody
	public BaseEntity planFreeTime(HttpServletRequest request, Model model) {

		try {
			FreeTime freeTime = new ObjectMapper().readValue(request
					.getParameter("freeTimeJson").getBytes(), FreeTime.class);
			freeTime.setId(UUID.randomUUID().toString());
			int i = appointService.planFreeTime(freeTime);
			if (i != 0) {
				return new BaseEntity(-200, "排挡成功！", null);
			} else {
				return new BaseEntity(200, "排挡失败！", null);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "排挡失败！", null);

		}

	}

	/**
	 * 获取从今天开始 五天内 可预约列表 包括teacherInfo、时间段信息、以及我是否预约
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getFreeTimesWithMyAppoint.action")
	@ResponseBody
	public BaseEntity getFreeTimesWithMyAppoint(HttpServletRequest request,
			Model model) {

		try {
			String stuId = request.getParameter("stuId");
			JavaType javaType = new ObjectMapper().getTypeFactory()
					.constructParametricType(List.class, String.class);
			List<String> timeDates = new ObjectMapper().readValue(request
					.getParameter("timeDatesJson").getBytes(), javaType);

			List<FreeTime> freeTimes = appointService
					.getFreeTimeOfTimeDate(timeDates);

			for (int i = 0; i < freeTimes.size(); i++) {
				freeTimes.get(i).setTeacherInfo(
						userService.getTeacherInfo(freeTimes.get(i)
								.getTeacherId()));
				freeTimes.get(i).setAppoint(
						appointService.getAppointWithStuIdAndFreetimeId(stuId,
								freeTimes.get(i).getId()));
			}
			return new BaseEntity(200, "获取数据成功",
					new ObjectMapper().writeValueAsString(freeTimes));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new BaseEntity(-200, "获取数据失败", null);

	}

	/**
	 * 学生用户获取 自己已经预约的（从当天往后五天）
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getStudentAppointWithFreeTime.action")
	@ResponseBody
	public BaseEntity getStudentAppointWithFreeTime(HttpServletRequest request,
			Model model) {

		try {

			String stuId = request.getParameter("stuId");

			JavaType javaType = new ObjectMapper().getTypeFactory()
					.constructParametricType(List.class, String.class);
			List<String> timeDates = new ObjectMapper().readValue(request
					.getParameter("timeDatesJson").getBytes(), javaType);

			List<Appoint> appoints = appointService
					.getStudentAppointWithFreeTime(stuId, timeDates);
			for (int i = 0; i < appoints.size(); i++) {
				appoints.get(i)
						.getFreeTime()
						.setTeacherInfo(
								userService.getTeacherInfo(appoints.get(i)
										.getFreeTime().getTeacherId()));

				appoints.get(i)
						.getFreeTime()
						.setTimeTemplate(
								appointService.getTimeTemplateOfId(appoints
										.get(i).getFreeTime().getTimeId()));

			}

			return new BaseEntity(200, "获取时间列表成功",
					new ObjectMapper().writeValueAsString(appoints));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "获取时间列表失败！", null);
		}

	}

	/**
	 * 根据日期和时间段 来获取其详情 包括在此时间端排挡的老师信息
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/getTeacherInfoOfFreeTime.action")
	@ResponseBody
	public BaseEntity getTeacherInfoOfFreeTime(HttpServletRequest request,
			Model model) {

		String timeDate = request.getParameter("timeDate");
		String timeId = request.getParameter("timeId");

		if (timeDate != null && timeId != null && !"".equals(timeDate)
				&& !"".equals(timeId)) {

			List<FreeTime> freeTimes = appointService.getTeacherInfoOfFreeTime(
					timeDate, timeId);

			if (freeTimes != null) {
				for (int i = 0; i < freeTimes.size(); i++) {
					freeTimes.get(i).setTeacherInfo(
							userService.getTeacherInfo(freeTimes.get(i)
									.getTeacherId()));
				}
				try {
					return new BaseEntity(200, "获取该时段信息成功",
							new ObjectMapper().writeValueAsString(freeTimes));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return new BaseEntity(-200, "获取该时段信息失败", null);
				}

			} else {
				return new BaseEntity(-200, "获取该时段信息失败", null);
			}
		} else {
			return new BaseEntity(-200, "获取该时段信息失败,请求参数有误！", null);

		}

	}

	/**
	 * 学生发布预约
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/sendAppoint.action")
	@ResponseBody
	public BaseEntity sendAppoint(HttpServletRequest request, Model model) {

		try {
			Appoint appoint = new ObjectMapper().readValue(request
					.getParameter("appointJson").getBytes(), Appoint.class);
			appoint.setId(UUID.randomUUID().toString());
			appoint.setAppointTime(Long.toString(new Date().getTime()));

			int i = appointService.sendAppoint(appoint);
			if (i == 0) {
				return new BaseEntity(-200, "预约失败", null);

			} else {
				return new BaseEntity(200, "预约成功", null);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "预约失败,请求参数有误！", null);

		}

	}

}

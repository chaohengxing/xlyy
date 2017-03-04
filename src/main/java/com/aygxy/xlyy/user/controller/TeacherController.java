package com.aygxy.xlyy.user.controller;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aygxy.xlyy.user.entity.BaseEntity;
import com.aygxy.xlyy.user.entity.DiscussTeacher;
import com.aygxy.xlyy.user.entity.ReplayDiscussTeacher;
import com.aygxy.xlyy.user.entity.TeacherInfo;
import com.aygxy.xlyy.user.service.TeacherService;
import com.aygxy.xlyy.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	@Resource
	TeacherService teacherService;

	@Resource
	UserService userService;

	@RequestMapping("/getTeacherInfoAndDiscussWithReplay.action")
	@ResponseBody
	public BaseEntity getTeacherInfoAndDiscussWithReplay(
			HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		TeacherInfo teacherInfo = teacherService
				.getTeacherInfoAndDiscussWithReplay(id);

		if (teacherInfo == null) {
			return new BaseEntity(-200, "获取师资详情失败！", null);
		} else {

			if (teacherInfo.getDiscussTeachers() != null) {
				for (DiscussTeacher discussTeacher : teacherInfo
						.getDiscussTeachers()) {
					if (discussTeacher.getReplayDiscussTeachers() != null) {
						for (ReplayDiscussTeacher replayDiscussTeacher : discussTeacher
								.getReplayDiscussTeachers()) {

							if (1 == replayDiscussTeacher.getReplayUserType()) {
								replayDiscussTeacher
										.setReplayStudentInfo(userService
												.getStudentInfo(replayDiscussTeacher
														.getReplayUserId()));
							} else if (2 == replayDiscussTeacher
									.getReplayUserType()) {
								replayDiscussTeacher
										.setReplayTeacherInfo(userService
												.getTeacherInfo(replayDiscussTeacher
														.getReplayUserId()));
							}

							if (1 == replayDiscussTeacher.getPassiveUserType()) {
								replayDiscussTeacher
										.setPassiveStudentInfo(userService
												.getStudentInfo(replayDiscussTeacher
														.getPassiveUserId()));
							} else if (2 == replayDiscussTeacher
									.getPassiveUserType()) {
								replayDiscussTeacher
										.setPassiveTeacherInfo(userService
												.getTeacherInfo(replayDiscussTeacher
														.getPassiveUserId()));
							}

						}
					}

				}

			}

			try {
				return new BaseEntity(200, "获取师资详情成功",
						new ObjectMapper().writeValueAsString(teacherInfo));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new BaseEntity(-200, "获取师资详情失败！", null);

			}
		}
	}

	@RequestMapping("/sendDiscussForTeacher.action")
	@ResponseBody
	public BaseEntity sendDiscussForTeacher(HttpServletRequest request,
			Model model) {

		DiscussTeacher discussTeacher = null;
		try {
			discussTeacher = new ObjectMapper().readValue(
					request.getParameter("discussTeacherJson").getBytes(),
					DiscussTeacher.class);
			discussTeacher.setId(UUID.randomUUID().toString());
			discussTeacher.setDiscussTime(Long.toString(new Date().getTime()));
			int i = teacherService.sendDiscussForTeacher(discussTeacher);
			if (i == 0) {
				// 插入失败
				return new BaseEntity(-200, "发送师资评论失败！", null);
			} else {
				// 插入成功
				return new BaseEntity(200, "发送师资评论成功！", null);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "发送师资评论失败！", null);
		}

	}
}

package com.aygxy.xlyy.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aygxy.xlyy.user.entity.BaseEntity;
import com.aygxy.xlyy.user.entity.StudentInfo;
import com.aygxy.xlyy.user.entity.TeacherInfo;
import com.aygxy.xlyy.user.entity.User;
import com.aygxy.xlyy.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	UserService userService;

	@RequestMapping("/findUserById.action")
	@ResponseBody
	public User findUserById(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		User user = userService.findUserById(id);
		return user;

	}

	/**
	 * 用户登录
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/login.action")
	@ResponseBody
	public BaseEntity login(HttpServletRequest request, Model model) {
		try {

			User user = userService.login(request.getParameter("userName"),
					request.getParameter("password"));
			if (user != null) {
				User teacherInfo = userService.getTeacherInfo(user.getId());

				if (teacherInfo != null) {
					return new BaseEntity(200, "登录成功，用户类型是心理咨询师",
							new ObjectMapper().writeValueAsString(teacherInfo));

				} else {
					StudentInfo studentInfo = userService.getStudentInfo(user
							.getId());
					if (studentInfo != null) {
						return new BaseEntity(200, "登录成功，用户类型是学生",
								new ObjectMapper()
										.writeValueAsString(studentInfo));
					} else {
						return new BaseEntity(-200, "登录失败，用户类型未知", null);
					}
				}

			} else {
				return new BaseEntity(-200, "登录失败", null);
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "登录失败", null);

		}
	}

	@RequestMapping("/getTeacherInfoList.action")
	@ResponseBody
	public BaseEntity getTeacherInfoList(HttpServletRequest request, Model model) {
		List<TeacherInfo> teacherInfos;
		teacherInfos = userService.getTeacherInfoList();

		if (teacherInfos == null) {
			return new BaseEntity(-200, "获取师资列表失败！", null);
		} else {
			try {
				return new BaseEntity(200, "获取师资列表成功！",
						new ObjectMapper().writeValueAsString(teacherInfos));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new BaseEntity(-200, "获取师资列表失败！", null);

			}

		}

	}

	@RequestMapping("/updateStudentInfo.action")
	@ResponseBody
	public BaseEntity updateStudentInfo(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String stuIcon = request.getParameter("stuIcon");
		String stuNickName = request.getParameter("stuNickName");
		String sex = request.getParameter("sex");
		String userClass = request.getParameter("userClass");
		String userMajor = request.getParameter("userMajor");

		int i = userService.updateStudentInfo(id, stuIcon, stuNickName, sex,
				userClass, userMajor);

		if (i != 0) {
			// 更新成功，获取新的数据返回
			StudentInfo studentInfo = userService.getStudentInfo(id);
			try {
				return new BaseEntity(200, "更新学生信息成功",
						new ObjectMapper().writeValueAsString(studentInfo));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 返回失败

		} else {
			return new BaseEntity(-200, "更新学生信息失败", null);

		}

		return null;

	}

	@RequestMapping("/updateTeacherInfo.action")
	@ResponseBody
	public BaseEntity updateTeacherInfo(HttpServletRequest request, Model model) {

		String id = request.getParameter("id");
		String teacherIcon = request.getParameter("teacherIcon");
		String teacherNickName = request.getParameter("teacherNickName");
		String sex = request.getParameter("sex");
		String teacherIntro = request.getParameter("teacherIntro");

		org.eclipse.jetty.util.log.Log.debug(teacherNickName);

		int i = userService.updateTeacherInfo(id, teacherIcon, teacherNickName,
				sex, teacherIntro);

		if (i != 0) {
			// 更新成功，获取新的数据返回
			TeacherInfo teacherInfo = userService.getTeacherInfo(id);
			try {
				return new BaseEntity(200, "更新教师信息成功",
						new ObjectMapper().writeValueAsString(teacherInfo));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 返回失败

		} else {
			return new BaseEntity(-200, "更新教师信息失败", null);

		}

		return new BaseEntity(-200, "更新教师信息失败", null);

	}
}

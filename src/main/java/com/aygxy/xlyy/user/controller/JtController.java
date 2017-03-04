package com.aygxy.xlyy.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aygxy.xlyy.user.entity.BaseEntity;
import com.aygxy.xlyy.user.entity.DiscussJt;
import com.aygxy.xlyy.user.entity.JtBean;
import com.aygxy.xlyy.user.entity.ReplayDiscussJt;
import com.aygxy.xlyy.user.service.JtService;
import com.aygxy.xlyy.user.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/jt")
public class JtController {
	@Resource
	JtService jtService;

	@Resource
	UserService userService;

	@RequestMapping("/getJtList.action")
	@ResponseBody
	public BaseEntity getJtList(HttpServletRequest request, Model model) {

		List<JtBean> jtBeans = jtService.getJtList();

		if (jtBeans == null) {
			return new BaseEntity(-200, "获取鸡汤列表失败！", null);
		} else {
			for (int i = 0; i < jtBeans.size(); i++) {
				if (1 == jtBeans.get(i).getUserType()) {
					jtBeans.get(i).setStudentInfo(
							userService.getStudentInfo(jtBeans.get(i)
									.getUserId()));
				} else if (2 == jtBeans.get(i).getUserType()) {
					jtBeans.get(i).setTeacherInfo(
							userService.getTeacherInfo(jtBeans.get(i)
									.getUserId()));
				}
			}

			try {
				return new BaseEntity(200, "获取鸡汤列表成功！",
						new ObjectMapper().writeValueAsString(jtBeans));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new BaseEntity(-200, "获取鸡汤列表失败！", null);

			}
		}

	}

	@RequestMapping("/getMyJtList.action")
	@ResponseBody
	public BaseEntity getMyJtList(HttpServletRequest request, Model model) {

		String userId = request.getParameter("userId");

		List<JtBean> jtBeans = jtService.getMyJtList(userId);

		if (jtBeans == null) {
			return new BaseEntity(-200, "我的发布列表失败！", null);
		} else {
			for (int i = 0; i < jtBeans.size(); i++) {
				if (1 == jtBeans.get(i).getUserType()) {
					jtBeans.get(i).setStudentInfo(
							userService.getStudentInfo(jtBeans.get(i)
									.getUserId()));
				} else if (2 == jtBeans.get(i).getUserType()) {
					jtBeans.get(i).setTeacherInfo(
							userService.getTeacherInfo(jtBeans.get(i)
									.getUserId()));
				}
			}

			try {
				return new BaseEntity(200, "获取鸡汤列表成功！",
						new ObjectMapper().writeValueAsString(jtBeans));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new BaseEntity(-200, "获取鸡汤列表失败！", null);

			}
		}

	}

	@RequestMapping("/getJtInfoAndDiscussWithReplay.action")
	@ResponseBody
	public BaseEntity getJtInfoAndDiscussWithReplay(HttpServletRequest request,
			Model model) {
		String id = request.getParameter("id");

		JtBean jtBean = jtService.getJtInfoAndDiscussWithReplay(id);

		if (jtBean == null) {
			return new BaseEntity(-200, "获取鸡汤详情失败！", null);

		} else {
			if (1 == jtBean.getUserType()) {
				jtBean.setStudentInfo(userService.getStudentInfo(jtBean
						.getUserId()));
			} else if (2 == jtBean.getUserType()) {
				jtBean.setTeacherInfo(userService.getTeacherInfo(jtBean
						.getUserId()));
			}

			if (jtBean.getDiscussJts() != null) {
				for (DiscussJt discussJt : jtBean.getDiscussJts()) {

					if (1 == discussJt.getUserType()) {
						discussJt.setStudentInfo(userService
								.getStudentInfo(discussJt.getUserId()));
					} else if (2 == discussJt.getUserType()) {
						discussJt.setTeacherInfo(userService
								.getTeacherInfo(discussJt.getUserId()));
					}
					if (discussJt.getReplayDiscussJts() != null) {
						for (ReplayDiscussJt replayDiscussJt : discussJt
								.getReplayDiscussJts()) {
							if (1 == replayDiscussJt.getReplayUserType()) {
								replayDiscussJt
										.setReplayStudentInfo(userService
												.getStudentInfo(replayDiscussJt
														.getReplayUserId()));
							} else if (2 == replayDiscussJt.getReplayUserType()) {
								replayDiscussJt
										.setReplayTeacherInfo(userService
												.getTeacherInfo(replayDiscussJt
														.getReplayUserId()));
							}

							if (1 == replayDiscussJt.getPassiveUserType()) {
								replayDiscussJt
										.setPassiveStudentInfo(userService
												.getStudentInfo(replayDiscussJt
														.getPassiveUserId()));
							} else if (2 == replayDiscussJt
									.getPassiveUserType()) {
								replayDiscussJt
										.setPassiveTeacherInfo(userService
												.getTeacherInfo(replayDiscussJt
														.getPassiveUserId()));
							}
						}
					}
				}
			}

			try {
				return new BaseEntity(200, "获取鸡汤详情成功！",
						new ObjectMapper().writeValueAsString(jtBean));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new BaseEntity(-200, "获取鸡汤详情失败！", null);
			}

		}

	}

	@RequestMapping("/sendJtBean.action")
	@ResponseBody
	public BaseEntity sendJtBean(HttpServletRequest request, Model model) {

		JtBean jtBean = null;
		try {
			jtBean = new ObjectMapper()
					.readValue(request.getParameter("jtBeanJson").getBytes(),
							JtBean.class);
			jtBean.setId(UUID.randomUUID().toString());
			jtBean.setJtTime(Long.toString(new Date().getTime()));
			int i = jtService.sendJtBean(jtBean);
			if (i == 0) {
				// 插入失败
				return new BaseEntity(-200, "发送鸡汤失败！", null);
			} else {
				// 插入成功
				return new BaseEntity(200, "发送鸡汤成功！", null);

			}
		} catch (Exception e) {
			e.printStackTrace();
			return new BaseEntity(-200, "发送鸡汤失败！", null);

		}

	}

	@RequestMapping(value = "/sendDiscussForJt.action", method = RequestMethod.POST)
	@ResponseBody
	public BaseEntity sendDiscussForJt(HttpServletRequest request, Model model) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(request.getParameter("discussJtJson"));
		DiscussJt discussJt = null;
		try {
			discussJt = new ObjectMapper().readValue(
					request.getParameter("discussJtJson").getBytes(),
					DiscussJt.class);
			discussJt.setId(UUID.randomUUID().toString());
			discussJt.setDiscussTime(Long.toString(new Date().getTime()));
			int i = jtService.sendDiscussForJt(discussJt);
			if (i == 0) {
				// 插入失败
				return new BaseEntity(-200, "发送鸡汤评论失败！", null);
			} else {
				// 插入成功
				return new BaseEntity(200, "发送鸡汤评论成功！", null);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new BaseEntity(-200, "发送鸡汤评论失败！", null);
		}

	}

}

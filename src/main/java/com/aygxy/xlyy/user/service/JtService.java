package com.aygxy.xlyy.user.service;

import java.util.List;

import com.aygxy.xlyy.user.entity.DiscussJt;
import com.aygxy.xlyy.user.entity.JtBean;

public interface JtService {

	List<JtBean> getJtList();

	JtBean getJtInfoAndDiscussWithReplay(String id);

	int sendJtBean(JtBean jtBean);

	int sendDiscussForJt(DiscussJt discussJt);

	List<JtBean> getMyJtList(String userId);

}

package com.aygxy.xlyy.user.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aygxy.xlyy.user.dao.JtMapper;
import com.aygxy.xlyy.user.entity.DiscussJt;
import com.aygxy.xlyy.user.entity.JtBean;

@Service
public class JtServiceImpl implements JtService {

	@Resource
	JtMapper jtMapper;

	@Override
	public List<JtBean> getJtList() {
		// TODO Auto-generated method stub
		return jtMapper.getJtList();
	}

	@Override
	public JtBean getJtInfoAndDiscussWithReplay(String id) {
		// TODO Auto-generated method stub
		return jtMapper.getJtInfoAndDiscussWithReplay(id);
	}

	@Override
	public int sendJtBean(JtBean jtBean) {
		// TODO Auto-generated method stub
		return jtMapper.sendJtBean(jtBean);
	}

	@Override
	public int sendDiscussForJt(DiscussJt discussJt) {
		// TODO Auto-generated method stub
		return jtMapper.sendDiscussForJt(discussJt);
	}

	@Override
	public List<JtBean> getMyJtList(String userId) {
		// TODO Auto-generated method stub
		return jtMapper.getMyJtList(userId);
	}

}

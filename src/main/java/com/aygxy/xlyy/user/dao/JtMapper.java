package com.aygxy.xlyy.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.aygxy.xlyy.user.entity.DiscussJt;
import com.aygxy.xlyy.user.entity.JtBean;

@Repository
public interface JtMapper {

	List<JtBean> getJtList();

	JtBean getJtInfoAndDiscussWithReplay(String id);

	int sendJtBean(JtBean jtBean);

	int sendDiscussForJt(DiscussJt discussJt);

	List<JtBean> getMyJtList(@Param("userId") String userId);

}

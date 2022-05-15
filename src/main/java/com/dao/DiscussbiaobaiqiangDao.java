package com.dao;

import com.entity.DiscussbiaobaiqiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbiaobaiqiangVO;
import com.entity.view.DiscussbiaobaiqiangView;


/**
 * 表白墙评论表
 * 
 * @author 
 * @email 
 * @date 2022-04-18 22:17:45
 */
public interface DiscussbiaobaiqiangDao extends BaseMapper<DiscussbiaobaiqiangEntity> {
	
	List<DiscussbiaobaiqiangVO> selectListVO(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
	
	DiscussbiaobaiqiangVO selectVO(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
	
	List<DiscussbiaobaiqiangView> selectListView(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);

	List<DiscussbiaobaiqiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
	
	DiscussbiaobaiqiangView selectView(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
	

}

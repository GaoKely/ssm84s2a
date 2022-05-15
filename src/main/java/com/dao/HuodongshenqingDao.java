package com.dao;

import com.entity.HuodongshenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.HuodongshenqingVO;
import com.entity.view.HuodongshenqingView;


/**
 * 活动申请
 * 
 * @author 
 * @email 
 * @date 2022-04-18 22:17:44
 */
public interface HuodongshenqingDao extends BaseMapper<HuodongshenqingEntity> {
	
	List<HuodongshenqingVO> selectListVO(@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);
	
	HuodongshenqingVO selectVO(@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);
	
	List<HuodongshenqingView> selectListView(@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);

	List<HuodongshenqingView> selectListView(Pagination page,@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);
	
	HuodongshenqingView selectView(@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params")Map<String, Object> params,@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<HuodongshenqingEntity> wrapper);
}

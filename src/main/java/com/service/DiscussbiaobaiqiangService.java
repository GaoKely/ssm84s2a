package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbiaobaiqiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbiaobaiqiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbiaobaiqiangView;


/**
 * 表白墙评论表
 *
 * @author 
 * @email 
 * @date 2022-04-18 22:17:45
 */
public interface DiscussbiaobaiqiangService extends IService<DiscussbiaobaiqiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbiaobaiqiangVO> selectListVO(Wrapper<DiscussbiaobaiqiangEntity> wrapper);
   	
   	DiscussbiaobaiqiangVO selectVO(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
   	
   	List<DiscussbiaobaiqiangView> selectListView(Wrapper<DiscussbiaobaiqiangEntity> wrapper);
   	
   	DiscussbiaobaiqiangView selectView(@Param("ew") Wrapper<DiscussbiaobaiqiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbiaobaiqiangEntity> wrapper);
   	

}


package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.KaoshichengjiEntity;
import com.utils.PageUtils;
import com.entity.KaoshichengjiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KaoshichengjiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KaoshichengjiView;


/**
 * 考试成绩
 *
 * @author 
 * @email 
 * @date 2022-04-18 22:17:44
 */
public interface KaoshichengjiService extends IService<KaoshichengjiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KaoshichengjiVO> selectListVO(Wrapper<KaoshichengjiEntity> wrapper);
   	
   	KaoshichengjiVO selectVO(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
   	
   	List<KaoshichengjiView> selectListView(Wrapper<KaoshichengjiEntity> wrapper);
   	
   	KaoshichengjiView selectView(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KaoshichengjiEntity> wrapper);

	Integer deleteBatchIds(@Param("ids") List<Long> list);

	KaoshichengjiEntity selectById(@Param("id") Long id);

	boolean insert(KaoshichengjiEntity kaoshichengji);

	boolean update(KaoshichengjiEntity kaoshichengji);

	List<KaoshichengjiEntity> selectByMap(Map<String, Object> params);

	Map<String,Object> selectCourseId (String courseName);

	List<Map<String,Object>> selectCredit(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
}


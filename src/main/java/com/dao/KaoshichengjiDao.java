package com.dao;

import com.entity.KaoshichengjiEntity;
import com.entity.KaoshichengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaoshichengjiVO;
import com.entity.view.KaoshichengjiView;


/**
 * 考试成绩
 * 
 * @author 
 * @email 
 * @date 2022-04-18 22:17:44
 */
public interface KaoshichengjiDao extends BaseMapper<KaoshichengjiEntity> {
	
	List<KaoshichengjiVO> selectListVO(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
	
	KaoshichengjiVO selectVO(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
	
	List<KaoshichengjiView> selectListView(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);

	List<KaoshichengjiView> selectListView(Pagination page,@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);
	
	KaoshichengjiView selectView(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper);

	Integer deleteBatchIds(List<Long> list);

	KaoshichengjiEntity selectById(Long id);

	Integer insert(KaoshichengjiEntity kaoshichengji);

	boolean update(KaoshichengjiEntity kaoshichengji);
}

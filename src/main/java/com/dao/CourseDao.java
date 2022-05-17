package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CourseEntity;
import com.entity.view.CourseView;
import com.entity.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 教室信息Mapper接口
 */
public interface CourseDao extends BaseMapper<CourseEntity> {
    List<CourseVO> selectListVO(@Param("ew") Wrapper< CourseEntity > wrapper);

    CourseVO selectVO(@Param("ew") Wrapper<CourseEntity> wrapper);

    List<CourseView> selectListView(@Param("ew") Wrapper<CourseEntity> wrapper);

    List<CourseView> selectListView(Pagination page,@Param("ew") Wrapper<CourseEntity> wrapper);

    CourseView selectView(@Param("ew") Wrapper<CourseEntity> wrapper);

    Integer deleteBatchIds(List<Long> list);

    CourseEntity selectById(Long id);

    Integer insert(CourseEntity course);

    boolean update(CourseEntity course);

    Map<String,Object> selectMap(CourseEntity course);

}

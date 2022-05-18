package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.CourseEntity;
import com.entity.CourseInfoEntity;
import com.entity.view.CourseView;
import com.entity.vo.CourseVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 教室信息Mapper接口
 */
public interface CourseInfoDao extends BaseMapper<CourseInfoEntity> {
//    List<CourseVO> selectListVO(@Param("ew") Wrapper<CourseEntity> wrapper);
//
//    CourseVO selectVO(@Param("ew") Wrapper<CourseEntity> wrapper);
//
//    List<CourseView> selectListView(@Param("ew") Wrapper<CourseEntity> wrapper);
//
//    List<CourseView> selectListView(Pagination page, @Param("ew") Wrapper<CourseEntity> wrapper);
//
//    CourseView selectView(@Param("ew") Wrapper<CourseEntity> wrapper);
//
//    Integer deleteBatchIds(List<Long> list);
//
//    CourseEntity selectById(Long id);
//
    Integer insert(CourseInfoEntity info);

    boolean update(CourseInfoEntity info);

    List<CourseInfoEntity> selectByMap(Map<String, Object> map);

}

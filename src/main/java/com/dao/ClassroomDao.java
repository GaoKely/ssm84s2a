package com.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.ClassroomEntity;
import com.entity.view.ClassroomView;
import com.entity.vo.ClassroomVO;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.ibatis.annotations.Param;


/**
 * 教室信息Mapper接口
 */
public interface ClassroomDao extends BaseMapper<ClassroomEntity> {
    List<ClassroomVO> selectListVO(@Param("ew") Wrapper< ClassroomEntity > wrapper);

    ClassroomVO selectVO(@Param("ew") Wrapper<ClassroomEntity> wrapper);

    List<ClassroomView> selectListView(@Param("ew") Wrapper<ClassroomEntity> wrapper);

    List<ClassroomView> selectListView(Pagination page,@Param("ew") Wrapper<ClassroomEntity> wrapper);

    ClassroomView selectView(@Param("ew") Wrapper<ClassroomEntity> wrapper);

    Integer deleteBatchIds(List<Long> list);

    ClassroomEntity selectById(Long id);

    Integer insert(ClassroomEntity classroom);

    boolean update(ClassroomEntity classroom);
}

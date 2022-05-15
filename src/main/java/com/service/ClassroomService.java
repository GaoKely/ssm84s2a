package com.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.CartEntity;
import com.entity.ClassroomEntity;
import com.entity.view.CartView;
import com.entity.view.ClassroomView;
import com.entity.vo.CartVO;
import com.entity.vo.ClassroomVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

/**
 * 教室信息Service接口
 */
public interface ClassroomService extends IService<ClassroomEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<ClassroomVO> selectListVO(Wrapper<ClassroomEntity> wrapper);

    ClassroomVO selectVO(@Param("ew") Wrapper<ClassroomEntity> wrapper);

    List<ClassroomView> selectListView(Wrapper<ClassroomEntity> wrapper);

    ClassroomView selectView(@Param("ew") Wrapper<ClassroomEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<ClassroomEntity> wrapper);

    Integer deleteBatchIds(@Param("ids") List<Long> list);

    ClassroomEntity selectById(@Param("id") Long id);

    boolean insert(ClassroomEntity classroom);

    boolean update(ClassroomEntity classroom);


}
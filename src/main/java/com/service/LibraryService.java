package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.KaoshichengjiEntity;
import com.entity.LibraryEntity;
import com.entity.view.LibraryView;
import com.entity.vo.LibraryVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 教室信息Service接口
 */
public interface LibraryService extends IService<LibraryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<LibraryVO> selectListVO(Wrapper<LibraryEntity> wrapper);

    LibraryVO selectVO(@Param("ew") Wrapper<LibraryEntity> wrapper);

    List<LibraryView> selectListView(Wrapper<LibraryEntity> wrapper);

    LibraryView selectView(@Param("ew") Wrapper<LibraryEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<LibraryEntity> wrapper);

    Integer deleteBatchIds(@Param("ids") List<Long> list);

    LibraryEntity selectById(@Param("id") Long id);

    boolean insert(LibraryEntity library);

    boolean update(LibraryEntity library);

    boolean updateLibraryState(Map<String, Object> params);

    List<LibraryEntity> selectByMap(Map<String, Object> params);
}
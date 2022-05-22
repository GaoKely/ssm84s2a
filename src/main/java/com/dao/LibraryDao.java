package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.entity.KaoshichengjiEntity;
import com.entity.LibraryEntity;
import com.entity.LibraryEntity;
import com.entity.view.LibraryView;
import com.entity.vo.LibraryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 教室信息Mapper接口
 */
public interface LibraryDao extends BaseMapper<LibraryEntity> {
    List<LibraryVO> selectListVO(@Param("ew") Wrapper< LibraryEntity > wrapper);

    LibraryVO selectVO(@Param("ew") Wrapper<LibraryEntity> wrapper);

    List<LibraryView> selectListView(@Param("ew") Wrapper<LibraryEntity> wrapper);

    List<LibraryView> selectListView(Pagination page,@Param("ew") Wrapper<LibraryEntity> wrapper);

    LibraryView selectView(@Param("ew") Wrapper<LibraryEntity> wrapper);

    Integer deleteBatchIds(List<Long> list);

    LibraryEntity selectById(Long id);

    Integer insert(LibraryEntity Library);

    boolean update(LibraryEntity Library);

    List<LibraryEntity> selectByMap(Map<String,Object> params);
}

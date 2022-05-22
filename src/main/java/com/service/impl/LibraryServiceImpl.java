package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.LibraryDao;
import com.entity.KaoshichengjiEntity;
import com.entity.LibraryEntity;
import com.entity.view.LibraryView;
import com.entity.vo.LibraryVO;
import com.service.LibraryService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 教室信息Service业务层处理
 *
 * @author liyeshe
 * @date 2022-05-15
 */

@Service("libraryService")
public class LibraryServiceImpl extends ServiceImpl<LibraryDao, LibraryEntity> implements LibraryService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LibraryEntity> page = this.selectPage(
                new Query<LibraryEntity>(params).getPage(),
                new EntityWrapper<LibraryEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<LibraryEntity> wrapper) {
        Page<LibraryView> page =new Query<LibraryView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<LibraryVO> selectListVO(Wrapper<LibraryEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public LibraryVO selectVO(Wrapper<LibraryEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<LibraryView> selectListView(Wrapper<LibraryEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public LibraryView selectView(Wrapper<LibraryEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public Integer deleteBatchIds(List<Long> list) {
        return baseMapper.deleteBatchIds(list);
    }

    @Override
    public LibraryEntity selectById(Long id){
        return baseMapper.selectById(id);
    }

    @Override
    public boolean insert(LibraryEntity library){
        Integer i = baseMapper.insert(library);
        if(i==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(LibraryEntity library){
        return baseMapper.update(library);
    }

    @Override
    public boolean updateLibraryState(Map<String, Object> params){
        LibraryEntity library = new LibraryEntity();
        Long id = Long.parseLong(params.get("id").toString());
        library.setId(id);
        library.setState(params.get("state").toString());
        return baseMapper.update(library);
    }

    @Override
    public List<LibraryEntity> selectByMap(Map<String, Object> params) {
        return baseMapper.selectByMap(params);
    }
}

package com.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ClassroomDao;
import com.entity.CartEntity;
import com.entity.ClassroomEntity;
import com.entity.view.CartView;
import com.entity.view.ClassroomView;
import com.entity.vo.CartVO;
import com.entity.vo.ClassroomVO;
import com.service.ClassroomService;
import com.utils.PageUtils;
import com.utils.Query;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 教室信息Service业务层处理
 *
 * @author liyeshe
 * @date 2022-05-15
 */

@Service("classroomService")
public class ClassroomServiceImpl extends ServiceImpl<ClassroomDao, ClassroomEntity> implements ClassroomService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ClassroomEntity> page = this.selectPage(
                new Query<ClassroomEntity>(params).getPage(),
                new EntityWrapper<ClassroomEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<ClassroomEntity> wrapper) {
        Page<ClassroomView> page =new Query<ClassroomView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<ClassroomVO> selectListVO(Wrapper<ClassroomEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public ClassroomVO selectVO(Wrapper<ClassroomEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<ClassroomView> selectListView(Wrapper<ClassroomEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public ClassroomView selectView(Wrapper<ClassroomEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public Integer deleteBatchIds(List<Long> list) {
        return baseMapper.deleteBatchIds(list);
    }

    @Override
    public ClassroomEntity selectById(Long id){
        return baseMapper.selectById(id);
    }

    @Override
    public boolean insert(ClassroomEntity classroom){
        Integer i = baseMapper.insert(classroom);
        if(i==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(ClassroomEntity classroom){
        return baseMapper.update(classroom);
    }
}

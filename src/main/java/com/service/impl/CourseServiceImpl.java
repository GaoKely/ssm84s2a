package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.CourseDao;
import com.entity.CourseEntity;
import com.entity.view.CourseView;
import com.entity.vo.CourseVO;
import com.service.CourseService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 教室信息Service业务层处理
 *
 */

@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseDao, CourseEntity> implements CourseService {




    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CourseEntity> page = this.selectPage(
                new Query<CourseEntity>(params).getPage(),
                new EntityWrapper<CourseEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CourseEntity> wrapper) {
        Page<CourseView> page =new Query<CourseView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<CourseVO> selectListVO(Wrapper<CourseEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public CourseVO selectVO(Wrapper<CourseEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<CourseView> selectListView(Wrapper<CourseEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public CourseView selectView(Wrapper<CourseEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public Integer deleteBatchIds(List<Long> list) {
        return baseMapper.deleteBatchIds(list);
    }

    @Override
    public CourseEntity selectById(Long id){
        return baseMapper.selectById(id);
    }

    @Override
    public boolean insert(CourseEntity course){
        Integer i = baseMapper.insert(course);
        if(i==1){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean update(CourseEntity course){
        return baseMapper.update(course);
    }

    @Override
    public Map<String,Object> selectAllCourseCredit(){
        CourseEntity course = null;
        Map<String,Object> map = baseMapper.selectMap(course);
        return map;
    }
}

package com.service.impl;

import com.entity.CourseEntity;
import com.entity.KaoshichengjiEntity;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KaoshichengjiDao;
import com.entity.KaoshichengjiEntity;
import com.service.KaoshichengjiService;
import com.entity.vo.KaoshichengjiVO;
import com.entity.view.KaoshichengjiView;

@Service("kaoshichengjiService")
public class KaoshichengjiServiceImpl extends ServiceImpl<KaoshichengjiDao, KaoshichengjiEntity> implements KaoshichengjiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KaoshichengjiEntity> page = this.selectPage(
                new Query<KaoshichengjiEntity>(params).getPage(),
                new EntityWrapper<KaoshichengjiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KaoshichengjiEntity> wrapper) {
		  Page<KaoshichengjiView> page =new Query<KaoshichengjiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KaoshichengjiVO> selectListVO(Wrapper<KaoshichengjiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KaoshichengjiVO selectVO(Wrapper<KaoshichengjiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KaoshichengjiView> selectListView(Wrapper<KaoshichengjiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KaoshichengjiView selectView(Wrapper<KaoshichengjiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


	@Override
	public Integer deleteBatchIds(List<Long> list) {
		return baseMapper.deleteBatchIds(list);
	}

	@Override
	public KaoshichengjiEntity selectById(Long id){
		return baseMapper.selectById(id);
	}

	@Override
	public boolean insert(KaoshichengjiEntity kaoshichengji){
		Integer i = baseMapper.insert(kaoshichengji);
		if(i==1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean update(KaoshichengjiEntity kaoshichengji){
		return baseMapper.update(kaoshichengji);
	}

	@Override
	public List<KaoshichengjiEntity> selectByMap(Map<String, Object> params) {
		return baseMapper.selectByMap(params);
	}

	@Override
	public Map<String,Object> selectCourseId(String courseName){
		KaoshichengjiEntity kao = new KaoshichengjiEntity();
		kao.setCourseName(courseName);
		Map<String,Object> returnMap = baseMapper.selectMap(kao);
		return returnMap;
	}
}

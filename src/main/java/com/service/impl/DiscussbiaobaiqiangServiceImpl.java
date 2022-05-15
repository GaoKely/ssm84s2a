package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussbiaobaiqiangDao;
import com.entity.DiscussbiaobaiqiangEntity;
import com.service.DiscussbiaobaiqiangService;
import com.entity.vo.DiscussbiaobaiqiangVO;
import com.entity.view.DiscussbiaobaiqiangView;

@Service("discussbiaobaiqiangService")
public class DiscussbiaobaiqiangServiceImpl extends ServiceImpl<DiscussbiaobaiqiangDao, DiscussbiaobaiqiangEntity> implements DiscussbiaobaiqiangService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbiaobaiqiangEntity> page = this.selectPage(
                new Query<DiscussbiaobaiqiangEntity>(params).getPage(),
                new EntityWrapper<DiscussbiaobaiqiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbiaobaiqiangEntity> wrapper) {
		  Page<DiscussbiaobaiqiangView> page =new Query<DiscussbiaobaiqiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbiaobaiqiangVO> selectListVO(Wrapper<DiscussbiaobaiqiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbiaobaiqiangVO selectVO(Wrapper<DiscussbiaobaiqiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbiaobaiqiangView> selectListView(Wrapper<DiscussbiaobaiqiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbiaobaiqiangView selectView(Wrapper<DiscussbiaobaiqiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

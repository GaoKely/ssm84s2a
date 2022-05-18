package com.service.impl;

import com.entity.CourseEntity;
import com.entity.KaoshichengjiEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<Map<String,Object>> selectCredit(@Param("ew") Wrapper<KaoshichengjiEntity> wrapper){
		List<Map<String,Object>> list = baseMapper.selectMaps(wrapper);
		BigDecimal one = new BigDecimal(100);
		BigDecimal two = new BigDecimal(95);
		BigDecimal thr = new BigDecimal(90);
		BigDecimal fou = new BigDecimal(85);
		BigDecimal fir = new BigDecimal(80);
		BigDecimal six = new BigDecimal(75);
		BigDecimal sev = new BigDecimal(70);
		BigDecimal eit = new BigDecimal(65);
		BigDecimal nin = new BigDecimal(60);
		for(Map<String,Object> map : list){
			BigDecimal ten = new BigDecimal(map.get("pjz").toString());
			if((one.compareTo(ten)>0 && two.compareTo(ten)<0) || one.compareTo(ten)==0 || two.compareTo(ten)==0){
				map.put("jidian",4.5);
			}else if((two.compareTo(ten)>0 && thr.compareTo(ten)<0) || thr.compareTo(ten)==0){
				map.put("jidian",4.0);
			}else if((thr.compareTo(ten)>0 && fou.compareTo(ten)<0) || fou.compareTo(ten)==0){
				map.put("jidian",3.5);
			}else if((fou.compareTo(ten)>0 && fir.compareTo(ten)<0) || fir.compareTo(ten)==0){
				map.put("jidian",3.0);
			}else if((fir.compareTo(ten)>0 && six.compareTo(ten)<0) || six.compareTo(ten)==0){
				map.put("jidian",2.5);
			}else if((six.compareTo(ten)>0 && sev.compareTo(ten)<0) || sev.compareTo(ten)==0){
				map.put("jidian",2.0);
			}else if((sev.compareTo(ten)>0 && eit.compareTo(ten)<0) || eit.compareTo(ten)==0){
				map.put("jidian",1.5);
			}else if((eit.compareTo(ten)>0 && nin.compareTo(ten)<0) || nin.compareTo(ten)==0){
				map.put("jidian",1.0);
			}else{
				map.put("jidian",0.0);
			}
		}
		return list;
	}


}

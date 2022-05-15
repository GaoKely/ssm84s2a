package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.BiaobaiqiangEntity;
import com.entity.view.BiaobaiqiangView;

import com.service.BiaobaiqiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;

/**
 * 表白墙
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-18 22:17:44
 */
@RestController
@RequestMapping("/biaobaiqiang")
public class BiaobaiqiangController {
    @Autowired
    private BiaobaiqiangService biaobaiqiangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BiaobaiqiangEntity biaobaiqiang, 
		HttpServletRequest request){
    	if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		biaobaiqiang.setUserid((Long)request.getSession().getAttribute("userId"));
    	}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			biaobaiqiang.setXuehao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BiaobaiqiangEntity> ew = new EntityWrapper<BiaobaiqiangEntity>();
		PageUtils page = biaobaiqiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaobaiqiang), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BiaobaiqiangEntity biaobaiqiang, 
		HttpServletRequest request){
        EntityWrapper<BiaobaiqiangEntity> ew = new EntityWrapper<BiaobaiqiangEntity>();
		PageUtils page = biaobaiqiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, biaobaiqiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BiaobaiqiangEntity biaobaiqiang){
       	EntityWrapper<BiaobaiqiangEntity> ew = new EntityWrapper<BiaobaiqiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( biaobaiqiang, "biaobaiqiang")); 
        return R.ok().put("data", biaobaiqiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BiaobaiqiangEntity biaobaiqiang){
        EntityWrapper< BiaobaiqiangEntity> ew = new EntityWrapper< BiaobaiqiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( biaobaiqiang, "biaobaiqiang")); 
		BiaobaiqiangView biaobaiqiangView =  biaobaiqiangService.selectView(ew);
		return R.ok("查询表白墙成功").put("data", biaobaiqiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BiaobaiqiangEntity biaobaiqiang = biaobaiqiangService.selectById(id);
        return R.ok().put("data", biaobaiqiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BiaobaiqiangEntity biaobaiqiang = biaobaiqiangService.selectById(id);
        return R.ok().put("data", biaobaiqiang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        BiaobaiqiangEntity biaobaiqiang = biaobaiqiangService.selectById(id);
        if(type.equals("1")) {
        	biaobaiqiang.setThumbsupnum(biaobaiqiang.getThumbsupnum()+1);
        } else {
        	biaobaiqiang.setCrazilynum(biaobaiqiang.getCrazilynum()+1);
        }
        biaobaiqiangService.updateById(biaobaiqiang);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BiaobaiqiangEntity biaobaiqiang, HttpServletRequest request){
    	biaobaiqiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biaobaiqiang);
    	biaobaiqiang.setUserid((Long)request.getSession().getAttribute("userId"));

        biaobaiqiangService.insert(biaobaiqiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BiaobaiqiangEntity biaobaiqiang, HttpServletRequest request){
    	biaobaiqiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(biaobaiqiang);

        biaobaiqiangService.insert(biaobaiqiang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BiaobaiqiangEntity biaobaiqiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(biaobaiqiang);
        biaobaiqiangService.updateById(biaobaiqiang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        biaobaiqiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<BiaobaiqiangEntity> wrapper = new EntityWrapper<BiaobaiqiangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}
		if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
    		wrapper.eq("userid", (Long)request.getSession().getAttribute("userId"));
    	}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
		}

		int count = biaobaiqiangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
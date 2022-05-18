package com.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.CourseEntity;
import com.entity.CourseInfoEntity;
import com.service.CourseInfoService;
import com.service.CourseService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 教室信息Controller
 */
@RestController
@RequestMapping("/courseinfo")
public class CourseInfoController {
    @Autowired
    private CourseInfoService courseinfoService;

//    /**
//     * 后端列表-列表查询
//     */
//    @RequestMapping("/page")
//    public R page(@RequestParam Map<String, Object> params, CourseEntity course,
//                  HttpServletRequest request){
//        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
//            course.setUserid((Long)request.getSession().getAttribute("userId"));
//        }
//
//        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
//        PageUtils page = courseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, course), params), params));
//        return R.ok().put("data", page);
//    }
//
//    /**
//     * 后端删除-统一删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//        courseService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }
//
//    /**
//     * 后端详情-单个查询
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//        CourseEntity course = courseService.selectById(id);
//        return R.ok().put("data", course);
//    }
//

    /**
     * 后台新增
     */
    @RequestMapping("/save")
    public R insert(@RequestBody String jsonString, HttpServletRequest request) {
        Map<String, Object> params = (Map) JSON.parse(jsonString);
        CourseInfoEntity courseinfo = new CourseInfoEntity();
        params.put("userId", (Long) request.getSession().getAttribute("userId"));
        if(params.get("pastern") != null && !"".equals(params.get("pastern").toString()))courseinfo.setPastern(params.get("pastern").toString());
        if(params.get("major") != null && !"".equals(params.get("major").toString()))courseinfo.setMajor(params.get("major").toString());
        if(params.get("classinfo") != null && !"".equals(params.get("classinfo").toString()))courseinfo.setClassinfo(params.get("classinfo").toString());
        if(params.get("note") != null && !"".equals(params.get("note").toString()))courseinfo.setNote(params.get("note").toString());
        if(params.get("info") != null && !"".equals(params.get("info").toString()))courseinfo.setInfo(params.get("info").toString());
        courseinfoService.insert(courseinfo);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody String jsonString, HttpServletRequest request) {
        Map<String, Object> params = (Map) JSON.parse(jsonString);
        CourseInfoEntity courseinfo = new CourseInfoEntity();
        params.put("userId", (Long) request.getSession().getAttribute("userId"));
        if(params.get("pastern") != null && !"".equals(params.get("pastern").toString()))courseinfo.setPastern(params.get("pastern").toString());
        if(params.get("major") != null && !"".equals(params.get("major").toString()))courseinfo.setMajor(params.get("major").toString());
        if(params.get("classinfo") != null && !"".equals(params.get("classinfo").toString()))courseinfo.setClassinfo(params.get("classinfo").toString());
        if(params.get("note") != null && !"".equals(params.get("note").toString()))courseinfo.setNote(params.get("note").toString());
        if(params.get("id") != null && !"".equals(params.get("id").toString()))courseinfo.setId(Long.parseLong(params.get("id").toString()));
        if(params.get("info") != null && !"".equals(params.get("info").toString()))courseinfo.setInfo(params.get("info").toString());
        courseinfoService.update(courseinfo);//全部更新
        return R.ok();
    }

    /**
     * 课程表
     */
    @RequestMapping("/selectCourseInfo")
//    @RequestParam Map<String, Object> params
    public R selectCourseInfo(@RequestBody String jsonString, HttpServletRequest request) {
        Map<String, Object> params = (Map) JSON.parse(jsonString);
        if (!request.getSession().getAttribute("role").toString().equals("管理员")) {
            params.put("userId", (Long) request.getSession().getAttribute("userId"));
        }
        List<CourseInfoEntity> list = courseinfoService.selectCourseInfo(params);
        return R.ok().put("data", list);
    }


//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody CourseEntity course, HttpServletRequest request){
//        courseService.updateById(course);//全部更新
//        return R.ok();
//    }
//    /**
//     * 前端列表
//     */
//    @IgnoreAuth
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params,CourseEntity course,
//                  HttpServletRequest request){
//        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
//        PageUtils page = courseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, course), params), params));
//        return R.ok().put("data", page);
//    }
//
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/lists")
//    public R list( CourseEntity course){
//        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
//        ew.allEq(MPUtil.allEQMapPre( course, "course"));
//        return R.ok().put("data", courseService.selectListView(ew));
//    }
//
//    /**
//     * 查询
//     */
//    @RequestMapping("/query")
//    public R query(CourseEntity course){
//        EntityWrapper< CourseEntity> ew = new EntityWrapper< CourseEntity>();
//        ew.allEq(MPUtil.allEQMapPre( course, "course"));
//        CourseView courseView =  courseService.selectView(ew);
//        return R.ok("查询购物车表成功").put("data", courseView);
//    }
//
//
//
//    /**
//     * 前端详情
//     */
//    @IgnoreAuth
//    @RequestMapping("/detail/{id}")
//    public R detail(@PathVariable("id") Long id){
//        CourseEntity course = courseService.selectById(id);
//        return R.ok().put("data", course);
//    }
//
//
//
//
//    /**
//     * 后端保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody CourseEntity course, HttpServletRequest request){
//        course.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(course);
//        course.setUserid((Long)request.getSession().getAttribute("userId"));
//
//        courseService.insert(course);
//        return R.ok();
//    }
//
//    /**
//     * 前端保存
//     */
//    @RequestMapping("/add")
//    public R add(@RequestBody CourseEntity course, HttpServletRequest request){
//        course.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(course);
//
//        courseService.insert(course);
//        return R.ok();
//    }


}

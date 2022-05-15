package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.CourseEntity;
import com.service.CourseService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 教室信息Controller
 *
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 后端列表-列表查询
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, CourseEntity course,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            course.setUserid((Long)request.getSession().getAttribute("userId"));
        }

        EntityWrapper<CourseEntity> ew = new EntityWrapper<CourseEntity>();
        PageUtils page = courseService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, course), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端删除-统一删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        courseService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端详情-单个查询
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CourseEntity course = courseService.selectById(id);
        return R.ok().put("data", course);
    }

    /**
     * 后台新增
     */
    @RequestMapping("/save")
    public R insert(@RequestBody CourseEntity course, HttpServletRequest request){
        courseService.insert(course);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CourseEntity course, HttpServletRequest request){
        courseService.update(course);//全部更新
        return R.ok();
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

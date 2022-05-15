package com.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.ClassroomEntity;
import com.entity.view.ClassroomView;
import com.service.ClassroomService;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 教室信息Controller
 *
 */
@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    /**
     * 后端列表-列表查询
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, ClassroomEntity classroom,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            classroom.setUserid((Long)request.getSession().getAttribute("userId"));
        }

        EntityWrapper<ClassroomEntity> ew = new EntityWrapper<ClassroomEntity>();
        PageUtils page = classroomService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, classroom), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端删除-统一删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        classroomService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端详情-单个查询
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ClassroomEntity classroom = classroomService.selectById(id);
        return R.ok().put("data", classroom);
    }

    /**
     * 后台新增
     */
    @RequestMapping("/save")
    public R insert(@RequestBody ClassroomEntity classroom, HttpServletRequest request){
        classroomService.insert(classroom);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ClassroomEntity classroom, HttpServletRequest request){
        classroomService.update(classroom);//全部更新
        return R.ok();
    }



//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody ClassroomEntity classroom, HttpServletRequest request){
//        classroomService.updateById(classroom);//全部更新
//        return R.ok();
//    }
//    /**
//     * 前端列表
//     */
//    @IgnoreAuth
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params,ClassroomEntity classroom,
//                  HttpServletRequest request){
//        EntityWrapper<ClassroomEntity> ew = new EntityWrapper<ClassroomEntity>();
//        PageUtils page = classroomService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, classroom), params), params));
//        return R.ok().put("data", page);
//    }
//
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/lists")
//    public R list( ClassroomEntity classroom){
//        EntityWrapper<ClassroomEntity> ew = new EntityWrapper<ClassroomEntity>();
//        ew.allEq(MPUtil.allEQMapPre( classroom, "classroom"));
//        return R.ok().put("data", classroomService.selectListView(ew));
//    }
//
//    /**
//     * 查询
//     */
//    @RequestMapping("/query")
//    public R query(ClassroomEntity classroom){
//        EntityWrapper< ClassroomEntity> ew = new EntityWrapper< ClassroomEntity>();
//        ew.allEq(MPUtil.allEQMapPre( classroom, "classroom"));
//        ClassroomView classroomView =  classroomService.selectView(ew);
//        return R.ok("查询购物车表成功").put("data", classroomView);
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
//        ClassroomEntity classroom = classroomService.selectById(id);
//        return R.ok().put("data", classroom);
//    }
//
//
//
//
//    /**
//     * 后端保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody ClassroomEntity classroom, HttpServletRequest request){
//        classroom.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(classroom);
//        classroom.setUserid((Long)request.getSession().getAttribute("userId"));
//
//        classroomService.insert(classroom);
//        return R.ok();
//    }
//
//    /**
//     * 前端保存
//     */
//    @RequestMapping("/add")
//    public R add(@RequestBody ClassroomEntity classroom, HttpServletRequest request){
//        classroom.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(classroom);
//
//        classroomService.insert(classroom);
//        return R.ok();
//    }


}

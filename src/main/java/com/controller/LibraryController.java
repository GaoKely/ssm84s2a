package com.controller;

import com.annotation.IgnoreAuth;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.KaoshichengjiEntity;
import com.entity.LibraryEntity;
import com.service.LibraryService;
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
 *
 */
@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    /**
     * 后端列表-列表查询
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, LibraryEntity library,
                  HttpServletRequest request){
        if(!request.getSession().getAttribute("role").toString().equals("管理员")) {
            library.setUserid((Long)request.getSession().getAttribute("userId"));
        }

        EntityWrapper<LibraryEntity> ew = new EntityWrapper<LibraryEntity>();
        PageUtils page = libraryService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, library), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 后端删除-统一删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        libraryService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端详情-单个查询
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LibraryEntity library = libraryService.selectById(id);
        return R.ok().put("data", library);
    }

    /**
     * 后台新增
     */
    @RequestMapping("/save")
    public R insert(@RequestBody LibraryEntity library, HttpServletRequest request){
        libraryService.insert(library);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody LibraryEntity library, HttpServletRequest request){
        libraryService.update(library);//全部更新
        return R.ok();
    }

    /**
     * 图书馆占座
     */
    @RequestMapping("/updateLibraryState")
    public R updateLibraryState(@RequestParam Map<String, Object> params){
        libraryService.updateLibraryState(params);//全部更新
        return R.ok();
    }



//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody LibraryEntity library, HttpServletRequest request){
//        libraryService.updateById(library);//全部更新
//        return R.ok();
//    }
//    /**
//     * 前端列表
//     */
//    @IgnoreAuth
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params,LibraryEntity library,
//                  HttpServletRequest request){
//        EntityWrapper<LibraryEntity> ew = new EntityWrapper<LibraryEntity>();
//        PageUtils page = libraryService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, library), params), params));
//        return R.ok().put("data", page);
//    }
//
//
//    /**
//     * 列表
//     */
//    @RequestMapping("/lists")
//    public R list( LibraryEntity library){
//        EntityWrapper<LibraryEntity> ew = new EntityWrapper<LibraryEntity>();
//        ew.allEq(MPUtil.allEQMapPre( library, "library"));
//        return R.ok().put("data", libraryService.selectListView(ew));
//    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, LibraryEntity library,
                  HttpServletRequest request) {
        List<LibraryEntity> list = libraryService.selectByMap(params);
        return R.ok().put("data", list);
    }

//
//    /**
//     * 查询
//     */
//    @RequestMapping("/query")
//    public R query(LibraryEntity library){
//        EntityWrapper< LibraryEntity> ew = new EntityWrapper< LibraryEntity>();
//        ew.allEq(MPUtil.allEQMapPre( library, "library"));
//        LibraryView libraryView =  libraryService.selectView(ew);
//        return R.ok("查询购物车表成功").put("data", libraryView);
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
//        LibraryEntity library = libraryService.selectById(id);
//        return R.ok().put("data", library);
//    }
//
//
//
//
//    /**
//     * 后端保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody LibraryEntity library, HttpServletRequest request){
//        library.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(library);
//        library.setUserid((Long)request.getSession().getAttribute("userId"));
//
//        libraryService.insert(library);
//        return R.ok();
//    }
//
//    /**
//     * 前端保存
//     */
//    @RequestMapping("/add")
//    public R add(@RequestBody LibraryEntity library, HttpServletRequest request){
//        library.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//        //ValidatorUtils.validateEntity(library);
//
//        libraryService.insert(library);
//        return R.ok();
//    }


}

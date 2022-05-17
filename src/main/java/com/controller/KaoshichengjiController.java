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
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import com.entity.KaoshichengjiEntity;
import com.entity.vo.KaoshichengjiVO;
import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KaoshichengjiEntity;
import com.entity.view.KaoshichengjiView;

import com.service.KaoshichengjiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考试成绩
 * 后端接口
 *
 * @author
 * @email
 * @date 2022-04-18 22:17:44
 */
@RestController
@RequestMapping("/kaoshichengji")
public class KaoshichengjiController {
    @Autowired
    private KaoshichengjiService kaoshichengjiService;


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, KaoshichengjiEntity kaoshichengji,
                  HttpServletRequest request) {

        String tableName = request.getSession().getAttribute("tableName").toString();
        if (tableName.equals("xuesheng")) {
            kaoshichengji.setXuehao((String) request.getSession().getAttribute("username"));
        }
        if (tableName.equals("jiaoshi")) {
            kaoshichengji.setJiaoshigonghao((String) request.getSession().getAttribute("username"));
        }
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();
        PageUtils page = kaoshichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshichengji), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 前端列表
     */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, KaoshichengjiEntity kaoshichengji,
                  HttpServletRequest request) {
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();
        PageUtils page = kaoshichengjiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kaoshichengji), params), params));
        return R.ok().put("data", page);
    }

    /**
     * 列表
     */
    @RequestMapping("/lists")
    public R list(KaoshichengjiEntity kaoshichengji) {
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();
        ew.allEq(MPUtil.allEQMapPre(kaoshichengji, "kaoshichengji"));
        return R.ok().put("data", kaoshichengjiService.selectListView(ew));
    }

    /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KaoshichengjiEntity kaoshichengji) {
        EntityWrapper<KaoshichengjiEntity> ew = new EntityWrapper<KaoshichengjiEntity>();
        ew.allEq(MPUtil.allEQMapPre(kaoshichengji, "kaoshichengji"));
        KaoshichengjiView kaoshichengjiView = kaoshichengjiService.selectView(ew);
        return R.ok("查询考试成绩成功").put("data", kaoshichengjiView);
    }

    //导入成绩excel
    @RequestMapping("/uploadExcel")
    public R uploadExcel(@RequestParam("jsonData") String post, @RequestParam("file") MultipartFile file, HttpServletRequest request)throws Exception {
        //获取excel文件
        Workbook workbook =new XSSFWorkbook(file.getInputStream());;
        List<KaoshichengjiEntity> list=new ArrayList<KaoshichengjiEntity>();
        int totalsheet=workbook.getNumberOfSheets();//获取 Excel 文件中的全部 Sheet 页数量
        Sheet sheet=null;
        for (int i = 0; i < totalsheet; i++) {// 循环 Excel 文件中的全部 Sheet 页
            sheet=workbook.getSheetAt(i);// 获取 Sheet 页对象
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {// 循环 Excel 行
                KaoshichengjiEntity kao = null;
                kao.setXuehao(sheet.getRow(j).getCell(0).toString());
                kao.setXueshengxingming(sheet.getRow(j).getCell(1).toString());
                kao.setCourseName(sheet.getRow(j).getCell(2).toString());
                kao.setAchievement(Double.parseDouble(sheet.getRow(j).getCell(3).toString()));
                kao.setState(sheet.getRow(j).getCell(4).toString());
                kao.setCredit(Double.parseDouble(sheet.getRow(j).getCell(5).toString()));
                kao.setGpa(Double.parseDouble(sheet.getRow(j).getCell(6).toString()));
                kao.setCourseState(sheet.getRow(j).getCell(7).toString());
                kao.setExaminationState(sheet.getRow(j).getCell(8).toString());
                kao.setNote(sheet.getRow(j).getCell(9).toString());
                list.add(kao);
            }
        }
        //遍历插入
        try {
            for(KaoshichengjiEntity kao : list){
                kaoshichengjiService.insert(kao);
            }
        }catch (Exception e){
            R.error("导入失败，请重试");
        }
        return R.ok("导入成功");

    }



    /**
     * 导入模板-以成绩列表为例
     *
     * @param response
     * @throws Exception
     */
    @GetMapping("/exportTemplate")
    public void exportTemplate(@Param("paramMap") Map<String, Object> params, HttpServletResponse response) throws Exception {
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = workbook.createSheet("sheet1");
        String fileName = "成绩列表导入模板.xls"; // 设置要导出的文件的名字
        // 生成标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("学科");
        row.createCell(3).setCellValue("成绩");
        row.createCell(4).setCellValue("状态");
        row.createCell(5).setCellValue("学分");
        row.createCell(6).setCellValue("平均学分绩点");
        row.createCell(7).setCellValue("选课属性");
        row.createCell(8).setCellValue("考试性质");
        row.createCell(9).setCellValue("备注");

        row = sheet.createRow(1); // 从第2行开始填充数据

        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("学科(请填写正确学科)");
        row.createCell(3).setCellValue("成绩");
        row.createCell(4).setCellValue("状态；0-不及格；1-及格");
        row.createCell(5).setCellValue("学分");
        row.createCell(6).setCellValue("平均学分绩点");
        row.createCell(7).setCellValue("选课属性；0-选修；1-必修");
        row.createCell(8).setCellValue("考试性质；0-正常考试；1-补考；2-重修");
        row.createCell(9).setCellValue("备注；0-非正常；1-正常");


        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition",
                "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }


    /**
     * 导出-以成绩列表为例
     *
     * @param response
     * @throws Exception
     */
    @GetMapping("/export")
    public void export(@Param("paramMap") Map<String, Object> params, HttpServletResponse response) throws Exception {
        // 创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建sheet
        HSSFSheet sheet = workbook.createSheet("sheet1");
        String fileName = "成绩列表.xls"; // 设置要导出的文件的名字
        // 获取数据集合
        //List<Student> list
        List<KaoshichengjiEntity> list = kaoshichengjiService.selectByMap(params);
        // 生成标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("学号");
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("学科");
        row.createCell(3).setCellValue("成绩");
        row.createCell(4).setCellValue("状态");
        row.createCell(5).setCellValue("学分");
        row.createCell(6).setCellValue("平均学分绩点");
        row.createCell(7).setCellValue("选课属性");
        row.createCell(8).setCellValue("考试性质");
        row.createCell(9).setCellValue("备注");

//		int i = 0;
        KaoshichengjiEntity entity = null;
        for (int i = 0; i < list.size(); i++) {
//		for (Map map : list) {
            entity = list.get(i);
            row = sheet.createRow(i + 1); // 从第2行开始填充数据
            // 序号
//			row.createCell(0).setCellValue(String.valueOf(i+1));
//			row.createCell(7,CellType.STRING).setCellValue(getGradeNameById(entity.getGradeId()));
//			row.createCell(8,CellType.STRING).setCellValue(DateUtil.format(entity.getEnrollDate(),"yyyy-MM-dd"));
//			row.createCell(2,CellType.STRING).setCellValue(entity.getStudentName());
//			row.createCell(3).setCellValue(entity.getGender().equals("F")?"女":"男");
            row.createCell(0).setCellValue(entity.getXuehao() == null ? "" : entity.getXuehao());
            row.createCell(1).setCellValue(entity.getXueshengxingming() == null ? "" : entity.getXueshengxingming());
            row.createCell(2).setCellValue(entity.getCourseName() == null ? "" : entity.getCourseName());
            row.createCell(3).setCellValue(entity.getAchievement() == null ? 0.00 : entity.getAchievement());
            if ("0".equals(entity.getState())) {
                entity.setState("不及格");
            } else {
                entity.setState("及格");
            }
            row.createCell(4).setCellValue(entity.getState());
            row.createCell(5).setCellValue(entity.getCredit() == null ? 0.00 : entity.getCredit());
            row.createCell(6).setCellValue(entity.getGpa() == null ? 0.00 : entity.getGpa());
            if ("0".equals(entity.getCourseState())) {
                entity.setCourseState("选修");
            } else {
                entity.setCourseState("必修");
            }
            row.createCell(7).setCellValue(entity.getCourseState());
            if ("0".equals(entity.getExaminationState())) {
                entity.setExaminationState("正常考试");
            } else if ("0".equals(entity.getExaminationState())) {
                entity.setExaminationState("补考");
            } else {
                entity.setExaminationState("重修");
            }
            row.createCell(8).setCellValue(entity.getExaminationState());
            if ("0".equals(entity.getNote())) {
                entity.setNote("非正常");
            } else {
                entity.setNote("正常");
            }
            row.createCell(9).setCellValue(entity.getNote());
        }

        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition",
                "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
        response.flushBuffer();

        workbook.write(response.getOutputStream());
    }

//    /**
//     * 后端详情
//     */
//    @RequestMapping("/info/{id}")
//    public R info(@PathVariable("id") Long id){
//        KaoshichengjiEntity kaoshichengji = kaoshichengjiService.selectById(id);
//        return R.ok().put("data", kaoshichengji);
//    }
//
//    /**
//     * 前端详情
//     */
//	@IgnoreAuth
//    @RequestMapping("/detail/{id}")
//    public R detail(@PathVariable("id") Long id){
//        KaoshichengjiEntity kaoshichengji = kaoshichengjiService.selectById(id);
//        return R.ok().put("data", kaoshichengji);
//    }
//
//
//
//
//    /**
//     * 后端保存
//     */
//    @RequestMapping("/save")
//    public R save(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
//    	kaoshichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//    	//ValidatorUtils.validateEntity(kaoshichengji);
//
//        kaoshichengjiService.insert(kaoshichengji);
//        return R.ok();
//    }
//
//    /**
//     * 前端保存
//     */
//    @RequestMapping("/add")
//    public R add(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
//    	kaoshichengji.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
//    	//ValidatorUtils.validateEntity(kaoshichengji);
//
//        kaoshichengjiService.insert(kaoshichengji);
//        return R.ok();
//    }
//
//    /**
//     * 修改
//     */
//    @RequestMapping("/update")
//    public R update(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request){
//        //ValidatorUtils.validateEntity(kaoshichengji);
//        kaoshichengjiService.updateById(kaoshichengji);//全部更新
//        return R.ok();
//    }
//
//
//    /**
//     * 删除
//     */
//    @RequestMapping("/delete")
//    public R delete(@RequestBody Long[] ids){
//        kaoshichengjiService.deleteBatchIds(Arrays.asList(ids));
//        return R.ok();
//    }
//
//    /**
//     * 提醒接口
//     */
//	@RequestMapping("/remind/{columnName}/{type}")
//	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request,
//						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
//		map.put("column", columnName);
//		map.put("type", type);
//
//		if(type.equals("2")) {
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Calendar c = Calendar.getInstance();
//			Date remindStartDate = null;
//			Date remindEndDate = null;
//			if(map.get("remindstart")!=null) {
//				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
//				c.setTime(new Date());
//				c.add(Calendar.DAY_OF_MONTH,remindStart);
//				remindStartDate = c.getTime();
//				map.put("remindstart", sdf.format(remindStartDate));
//			}
//			if(map.get("remindend")!=null) {
//				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
//				c.setTime(new Date());
//				c.add(Calendar.DAY_OF_MONTH,remindEnd);
//				remindEndDate = c.getTime();
//				map.put("remindend", sdf.format(remindEndDate));
//			}
//		}
//
//		Wrapper<KaoshichengjiEntity> wrapper = new EntityWrapper<KaoshichengjiEntity>();
//		if(map.get("remindstart")!=null) {
//			wrapper.ge(columnName, map.get("remindstart"));
//		}
//		if(map.get("remindend")!=null) {
//			wrapper.le(columnName, map.get("remindend"));
//		}
//
//		String tableName = request.getSession().getAttribute("tableName").toString();
//		if(tableName.equals("xuesheng")) {
//			wrapper.eq("xuehao", (String)request.getSession().getAttribute("username"));
//		}
//		if(tableName.equals("jiaoshi")) {
//			wrapper.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
//		}
//
//		int count = kaoshichengjiService.selectCount(wrapper);
//		return R.ok().put("count", count);
//	}


    /**
     * 后端删除-统一删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids) {
        kaoshichengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 后端详情-单个查询
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        KaoshichengjiEntity kaoshichengji = kaoshichengjiService.selectById(id);
        return R.ok().put("data", kaoshichengji);
    }

    /**
     * 后台新增
     */
    @RequestMapping("/save")
    public R insert(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request) {
        kaoshichengjiService.insert(kaoshichengji);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KaoshichengjiEntity kaoshichengji, HttpServletRequest request) {
        kaoshichengjiService.update(kaoshichengji);//全部更新
        return R.ok();
    }

    /*导出*/


}

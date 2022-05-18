package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 教室信息对象 course
 *
 */
@TableName("courseinfo")
public class CourseInfoEntity<T> implements Serializable{
    private static final long serialVersionUID = 1L;

    public CourseInfoEntity() {

    }

    public CourseInfoEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private Long userid;

    /**
     * 主键id
     */
    @TableId
    private Long id;

    /** 系部名称 */
    private String pastern;

    /** 专业*/
    private String major;

     /** 班级*/
    private String classinfo;

    /** 备注 */
    private String note;

    /** 课程详情 */
    private String info;


    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPastern() {
        return pastern;
    }

    public void setPastern(String pastern) {
        this.pastern = pastern;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(String classinfo) {
        this.classinfo = classinfo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

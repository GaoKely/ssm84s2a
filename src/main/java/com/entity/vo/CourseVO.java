package com.entity.vo;

import java.io.Serializable;
import java.util.Date;


public class CourseVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userid;

	private Long id;

	/** 科目名称 */
	private String name;

	/** 学分 */
	private Double credit;

	/** 备注 */
	private String note;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}

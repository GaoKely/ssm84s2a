package com.entity.vo;

import java.io.Serializable;
import java.util.Date;


public class LibraryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userid;

	/** 座位ID */
	private Long id;

	/** 座位名称 */
	private String name;

	/** 备注 */
	private String note;

	/** 状态；0-占用；1-正常 */
	private String state;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}

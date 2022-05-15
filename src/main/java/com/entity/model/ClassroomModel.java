package com.entity.model;

import java.io.Serializable;
import java.util.Date;


public class ClassroomModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long userid;

	private Long id;

	/** 教室名称 */
	private String room;

	/** 教室状态；0-占用；1-空闲 */
	private String status;

	/** 备注 */
	private String note;

	/** 使用时间 */
	private Date usetime;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getRoom()
	{
		return room;
	}

	public void setRoom(String room)
	{
		this.room = room;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public Date getUsetime()
	{
		return usetime;
	}

	public void setUsetime(Date usetime)
	{
		this.usetime = usetime;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
}

package com.entity.view;

import com.entity.DiscussbiaobaiqiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 表白墙评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 22:17:45
 */
@TableName("discussbiaobaiqiang")
public class DiscussbiaobaiqiangView  extends DiscussbiaobaiqiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussbiaobaiqiangView(){
	}
 
 	public DiscussbiaobaiqiangView(DiscussbiaobaiqiangEntity discussbiaobaiqiangEntity){
 	try {
			BeanUtils.copyProperties(this, discussbiaobaiqiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

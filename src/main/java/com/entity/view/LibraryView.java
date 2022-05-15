package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.ClassroomEntity;
import com.entity.LibraryEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 购物车表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-04-18 22:17:44
 */
@TableName("classroom")
public class LibraryView extends LibraryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public LibraryView(){
	}

 	public LibraryView(LibraryEntity libraryEntity){
 	try {
			BeanUtils.copyProperties(this, libraryEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.vo.MType;

public interface IType {

	//��all Type
	@Select("select *  from mtype")
	public List<MType> QuerryType();
}

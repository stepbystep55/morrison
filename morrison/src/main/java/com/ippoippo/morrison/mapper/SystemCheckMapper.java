package com.ippoippo.morrison.mapper;

import org.apache.ibatis.annotations.Param;

public interface SystemCheckMapper {

	public int plus(@Param("formerArg") int formerArg, @Param("latterArg") int latterArg);
}

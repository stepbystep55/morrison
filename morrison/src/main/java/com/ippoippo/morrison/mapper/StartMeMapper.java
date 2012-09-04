package com.ippoippo.morrison.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ippoippo.morrison.dto.StartMe;

public interface StartMeMapper {

	public Integer newId();

	public List<StartMe> list();

	public StartMe get(@Param("id") Integer id);

	public void create(StartMe startMe);

	public void delete(@Param("id") Integer id);
}

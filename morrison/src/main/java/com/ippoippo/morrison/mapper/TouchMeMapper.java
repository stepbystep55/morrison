package com.ippoippo.morrison.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ippoippo.morrison.dto.TouchMe;

public interface TouchMeMapper {

	public Integer newId();

	public List<TouchMe> list();

	public TouchMe get(@Param("id") Integer id);

	public void create(TouchMe touchMe);

	public void update(TouchMe touchMe);

	public void delete(@Param("id") Integer id);
}

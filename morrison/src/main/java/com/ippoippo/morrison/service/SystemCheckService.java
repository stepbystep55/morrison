package com.ippoippo.morrison.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ippoippo.morrison.mapper.SystemCheckMapper;

@Service
public class SystemCheckService {

	@Inject
	SystemCheckMapper systemCheckMapper;

	public boolean isAlive() {
		return (systemCheckMapper.plus(1, 1) == 2);
	}
}

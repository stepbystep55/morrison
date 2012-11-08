package com.ippoippo.morrison.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ippoippo.morrison.dto.TouchMe;
import com.ippoippo.morrison.mapper.TouchMeMapper;

@Service
public class TouchMeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	TouchMeMapper touchMeMapper;

	public TouchMe newObject() {
		Integer id = touchMeMapper.newId();
		if (id == null) id = 1;
		TouchMe touchMe = new TouchMe();
		touchMe.setId(id);
		return touchMe;
	}

	@Async
	@Transactional(rollbackForClassName="java.lang.Exception")
	public void create(TouchMe touchMe) {
		if (true) throw new RuntimeException("yeah!");
		touchMeMapper.create(touchMe);
	}

	public void delete(Integer id) {
		touchMeMapper.delete(id);
	}
}
package com.ippoippo.morrison.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ippoippo.morrison.dto.StartMe;
import com.ippoippo.morrison.exception.RecoverableException;
import com.ippoippo.morrison.mapper.StartMeMapper;

@Service
public class StartMeService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	StartMeMapper startMeMapper;

	public StartMe newObject() {
		Integer id = startMeMapper.newId();
		if (id == null) id = 1;
		StartMe startMe = new StartMe();
		startMe.setId(id);
		return startMe;
	}

	public List<StartMe> list() {
		return startMeMapper.list();
	}

	@Cacheable("cachedStartMe")
	public StartMe get(Integer id) throws RecoverableException {
		logger.info("get by " + id);
		if (id == 2) { // an example
			String msg = "forbidden: " + id;
			logger.info(msg);
			throw new RecoverableException(msg);
		}
		return startMeMapper.get(id);
	}

	public void create(StartMe startMe) {
		startMeMapper.create(startMe);
	}

	public void delete(Integer id) {
		startMeMapper.delete(id);
	}
}
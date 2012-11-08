package com.ippoippo.morrison.mapper;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.ippoippo.morrison.dto.TouchMe;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= { "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@Transactional
@TransactionConfiguration(defaultRollback=true)
public class TouchMeMapperTest {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	TouchMeMapper touchMeMapper;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUpdate() {
		Integer id = touchMeMapper.newId();
		if (id == null) id = 1;
		TouchMe touchMe = new TouchMe();
		touchMe.setId(id);
		touchMe.setName("yes");
		touchMe.setTouch(new Boolean(true));
		touchMeMapper.create(touchMe);
		
		List<TouchMe> list = touchMeMapper.list();
		logger.info(list.toString());
		
		touchMe.setName("yes, yes");
		touchMe.setTouch(null);
	}

}

package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testGetList() throws Exception {
		log.info(
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
	}

	@Test
	public void testGet() throws Exception {
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "28")).andReturn()
				.getModelAndView().getModelMap());
	}

	@Test
	public void testRegister() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register").param("title", "안녕")
				.param("content", "하세요").param("writer", "인사맨")).andReturn().getModelAndView().getViewName();
		log.info(resultPage);

	}

	@Test
	public void testRemove() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove").param("bno", "15")).andReturn()
				.getModelAndView().getViewName();
		log.info(resultPage);

	}

	@Test
	public void testModify() throws Exception {
		String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify").param("bno", "28")
				.param("title", "안녕하").param("content", "세요").param("writer", "까불이")).andReturn().getModelAndView()
				.getViewName();
		log.info(resultPage);

	}

}

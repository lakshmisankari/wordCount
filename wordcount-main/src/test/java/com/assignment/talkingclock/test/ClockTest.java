package com.assignment.talkingclock.test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.talkingclock.EnglishTime;
import com.assignment.talkingclock.TalkingClockApplication;
import com.assignment.talkingclock.TalkingClockController;

/**
 * @author Lakshmi Sankari .S
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { TalkingClockApplication.class, TalkingClockController.class, EnglishTime.class })
public class ClockTest extends TalkingClockAppTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testNace() throws Exception {

		mockMvc.perform(get("/getEnglishTime/01:00")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("One O' clock"));
		
		mockMvc.perform(get("/getEnglishTime/02:00")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Two O' clock"));
		
		mockMvc.perform(get("/getEnglishTime/13:00")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("One O' clock"));
		
		mockMvc.perform(get("/getEnglishTime/13:05")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Five past One"));
		
		mockMvc.perform(get("/getEnglishTime/13:10")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Ten past One"));
		
		mockMvc.perform(get("/getEnglishTime/13:25")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Twenty five past One"));
		
		mockMvc.perform(get("/getEnglishTime/13:30")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Half past One"));
		
		mockMvc.perform(get("/getEnglishTime/13:35")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Twenty five to Two"));
		
		mockMvc.perform(get("/getEnglishTime/13:55")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json")).andExpect(jsonPath("$.time").value("Five to Two"));
		
				
	}

}
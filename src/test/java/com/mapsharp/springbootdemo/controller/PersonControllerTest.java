package com.mapsharp.springbootdemo.controller;


import com.alibaba.fastjson.JSON;
import com.mapsharp.springbootdemo.common.Constants;
import com.mapsharp.springbootdemo.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void init(){
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}



	@Test
	public void personListTest() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/person/personList"))
				.andExpect(MockMvcResultMatchers.view().name("/person/personList"));
	}

	@Test
	public void personListPostTest() throws Exception {
		Person person = new Person();
		person.setGender(Integer.parseInt("1"));
		person.setName("");
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/person/personList").content(JSON.toJSONString(person)))
				.andReturn();
		System.out.println(mvcResult.getResponse().getContentAsString());
	}

    @Test
    public void personDetailTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/person/personDetail"))
                .andExpect(MockMvcResultMatchers.view().name("/person/personDetail"));
    }


    @Test
    public void personDetailPostTest() throws Exception {
	    String personId = "402881075f0420eb015f04217aee0000";
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/person/personDetail/"+personId)).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }


	@Test
	public void newPersonTest() throws Exception {
		Person person = new Person();
//		person.setName("张三");
//		person.setGender(Constants.GENDER_MALE);
		person.setName("李四");
		person.setGender(Constants.GENDER_FEMALE);
        System.out.println(JSON.toJSONString(person));
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/person/newPerson").contentType(MediaType.APPLICATION_JSON).content(JSON.toJSONString(person))).andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}

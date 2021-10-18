package com.study.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.bbs.SpringBbsApplication;
import com.study.model.ReplyDTO;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ReplyController.class)
@ContextConfiguration(classes=SpringBbsApplication.class)
class ReplyControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@Test
	@DisplayName("댓글 목록")
	void testGetList() throws Exception {
		mvc.perform( MockMvcRequestBuilders
	              .get("/bbs/reply/list/{bbsno}/{sno}/{eno}",71,1,3)
	              .accept(MediaType.APPLICATION_JSON))
	              .andDo(print())
	              .andExpect(status().isOk())
	              .andExpect(MockMvcResultMatchers.jsonPath("$.[*].rnum").exists())
	              .andExpect(MockMvcResultMatchers.jsonPath("$.[*].rnum").isNotEmpty());
	}

	@Test
	@DisplayName("댓글 페이징")
	void testGetPage() throws Exception {
		MultiValueMap<String, String> info = new LinkedMultiValueMap<>();
		 
        info.add("nPage", "1");
        info.add("nowPage", "1");
        info.add("bbsno", "71");
        info.add("col", "");
        info.add("word", "");

        mvc.perform(get("/bbs/reply/page")
          .params(info))
          .andDo(print())
          .andExpect(status().isOk());
	}

	@Test
	@DisplayName("댓글 생성")
	void testCreate() throws Exception {
		mvc.perform( MockMvcRequestBuilders
                .post("/bbs/reply/create")
                .content(asJsonString(new ReplyDTO(0, "content4", "", "user1", 1)))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                    .andDo(print())
                .andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}

	@Test
	@DisplayName("댓글 조회-json결과")
	void testGet() throws Exception {
		mvc.perform(MockMvcRequestBuilders 
                .get("/bbs/reply/{rnum}",2)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())     
                .andExpect(MockMvcResultMatchers.jsonPath("$.rnum").value(2));		
	}

	@Test
	@DisplayName("댓글 수정")
	void testModify() throws Exception {
		mvc.perform( MockMvcRequestBuilders
	              .put("/bbs/reply/{rnum}", 4)
	              .content(asJsonString(new ReplyDTO(4, "modify_test", "", "user1", 71)))
	              .contentType(MediaType.APPLICATION_JSON)
	              .accept(MediaType.APPLICATION_JSON))
	              .andDo(print())
	              .andExpect(status().isOk());
	}

	@Test
	@DisplayName("댓글 삭제")
	void testRemove() throws Exception {
		mvc.perform( MockMvcRequestBuilders
                .delete("/bbs/reply/{rnum}", 12) )
        .andExpect(status().isOk());
	}

}

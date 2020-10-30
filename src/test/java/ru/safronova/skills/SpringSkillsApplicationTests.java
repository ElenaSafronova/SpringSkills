package ru.safronova.skills;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import ru.safronova.skills.controller.SkillController;
import ru.safronova.skills.entity.Language;
import ru.safronova.skills.entity.Skill;
import ru.safronova.skills.repository.SkillRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringRunner.class) // SpringRunner позволяет получить все контроллеры, репозитории, сервисы и т.д.
//@WebMvcTest(SkillController.class) // тестируем SkillController
@SpringBootTest
@AutoConfigureMockMvc
class SpringSkillsApplicationTests {

//	состояние объекта, которое не влияет на продакшн - не уходит в бд и пр.
	@MockBean // сначала делаем объект Mock на БД
	private SkillRepository skillRepository; // т.к. тестируем SkillController

	@Autowired
	private MockMvc mockMvc; // делаем Mock на rest-запросы

	@Test
	void testReturn() throws Exception {
		// эмуляция получения объекта из БД
		given(skillRepository.findById(any()))
				.willReturn(Optional
						.of(new Skill(1L, "Java", "Description")));

		// протестируем контроллер. testing GET-method for link: /skills/1
		mockMvc.perform(get("/skills/1"))
				.andExpect(status().isOk()) // alternatives: is5xxServerError() etc.
				.andExpect(content()
						.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	//	DB testing
	@Test
	void testRepository(){
		given(skillRepository.findById(1L))
				.willReturn(Optional
						.of(new Skill(1L, "Java", "Description")));

		assertEquals(skillRepository.findById(1L).get().getTitle(), "Java");
	}


//	-------------------    junit testing ----------------------

	@Test
	void equals() {
		assertEquals(42,42);
	}

	@Test
	void bool(){
		assertTrue(true);
		assertFalse(false);
	}

	@Test
	void language(){
		Language language = new Language(1L, "Java", null);
		assertNotNull(language);
		assertEquals(language.getId(), 1);
	}

}

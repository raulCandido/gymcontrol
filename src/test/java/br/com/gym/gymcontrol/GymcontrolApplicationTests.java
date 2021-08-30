package br.com.gym.gymcontrol;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gym.gymcontrol.model.Pessoa;
import br.com.gym.gymcontrol.model.TipoPessoa;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.repository.ProfessorRepository;

@SpringBootTest
@AutoConfigureMockMvc
class GymcontrolApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ProfessorRepository professorRepository;

	private static final String URL = "/pessoas";

	//@Test
	void deveriaCadastrarPessoa() {
	    Pessoa pessoa = new Pessoa("Fulano Souza Matias", "Fulano", LocalDate.of(1974, 10, 05),
		    TipoPessoa.PROFESSOR);
		try {
			mockMvc.perform(post(URL).contentType("application/json").content(objectMapper.writeValueAsString(pessoa)))
					.andExpect(status().isCreated());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void deveriaBuscarProfessorPorCategoria() {
	    List<ProfessorDto> findProfessoresPorCategorias = professorRepository.findProfessoresPorCategorias(2L);
	    for (ProfessorDto professorDto : findProfessoresPorCategorias) {
		System.out.println(professorDto.toString());
	    }
	}

	//@Test
	void deveriaBuscarPessoa() {
		try {
			mockMvc.perform(get(URL).contentType("application/json")).andExpect(status().isOk());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package br.com.gym.gymcontrol.model.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProfessorForm {

    @NotEmpty(message = "Nome obrigatório")
    protected String nome;

    @NotEmpty(message = "Alcunha obrigatório")
    protected String alcunha;

    @NotNull(message = "Lista de categorias é obrigatório")
    private List<Long> idCategorias;

    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDateTime dataNascimento;

}

package br.com.gym.gymcontrol.model.dto.response;

import java.time.LocalDate;

public record AlunoResponseDto(Long id, String nome, String apelido, LocalDate dataNascimento) {
}

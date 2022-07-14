package br.com.gym.gymcontrol.model.mapper;

import br.com.gym.gymcontrol.model.Categoria;
import br.com.gym.gymcontrol.model.dto.request.CategoriaRequestDto;
import br.com.gym.gymcontrol.model.dto.response.CategoriaResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria requestDtoToModel(CategoriaRequestDto categoriaRequestDto);

    CategoriaResponseDto modelToResponseDto(Categoria categoria);
}

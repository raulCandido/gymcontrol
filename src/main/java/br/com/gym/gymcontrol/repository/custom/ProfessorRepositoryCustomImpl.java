package br.com.gym.gymcontrol.repository.custom;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.response.ProfessorReponseDto;
import br.com.gym.gymcontrol.repository.ProfessorRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepositoryCustomImpl implements ProfessorRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProfessorReponseDto> findProfessoresPorCategorias(Long id) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProfessorReponseDto> query = builder.createQuery(ProfessorReponseDto.class);
        Root<Professor> root = query.from(Professor.class);
        From<?, ?> categoriasJoin = root.join("categorias", JoinType.INNER);

        query.select(builder.construct(ProfessorReponseDto.class, root.get("id"), root.get("nome"), root.get("alcunha")));

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(builder.equal(categoriasJoin.get("id"), id));
        query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

        TypedQuery<ProfessorReponseDto> createQuery = entityManager.createQuery(query);

        return createQuery.getResultList();
    }

}

package br.com.gym.gymcontrol.repository.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.From;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.gym.gymcontrol.model.Professor;
import br.com.gym.gymcontrol.model.dto.ProfessorDto;
import br.com.gym.gymcontrol.repository.ProfessorRepositoryCustom;

public class ProfessorRepositoryCustomImpl implements ProfessorRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ProfessorDto> findProfessoresPorCategorias(Long id) {

	CriteriaBuilder builder = entityManager.getCriteriaBuilder();
	CriteriaQuery<ProfessorDto> query = builder.createQuery(ProfessorDto.class);
	Root<Professor> root = query.from(Professor.class);
	From<?, ?> categoriasJoin = root.join("categorias", JoinType.INNER);

	query.select(builder.construct(ProfessorDto.class, root.get("id"), root.get("nome"), root.get("alcunha")));

	List<Predicate> predicates = new ArrayList<>();

	predicates.add(builder.equal(categoriasJoin.get("id"), id));
	query.where(builder.and(predicates.toArray(new Predicate[predicates.size()])));

	TypedQuery<ProfessorDto> createQuery = entityManager.createQuery(query);

	return createQuery.getResultList();
    }

}

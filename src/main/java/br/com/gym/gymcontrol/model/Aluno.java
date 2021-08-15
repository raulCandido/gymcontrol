package br.com.gym.gymcontrol.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Aluno implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private List<Turma> turmas;
    private LocalDate data;
    private Time horario;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<Turma> getTurmas() {
	return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
	this.turmas = turmas;
    }

    public LocalDate getData() {
	return data;
    }

    public void setData(LocalDate data) {
	this.data = data;
    }

    public Time getHorario() {
	return horario;
    }

    public void setHorario(Time horario) {
	this.horario = horario;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Aluno other = (Aluno) obj;
	return Objects.equals(id, other.id);
    }

}

package br.com.gym.gymcontrol.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Aula implements Serializable {

    /**
     * @author raul
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idaula")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Turma turma;

    @NotNull(message = "Data da aula obrigatória")
    private LocalDate data;

    @NotNull(message = "Horario da aula obrigatório")
    private Time horario;

}

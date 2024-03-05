package med.voll.apimediciner.domain.medico;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query("""
            select m from Medico m where m.ativo = true and m.especialidade = :especialidade
             and m.id not in(
                select c.medico.id from Consulta c where c.data = :data
             )
             order by rand() limit 1
            """)
    Medico escolherMedicoAleatorioDisponivelNaDatata(Especialidade especialidade, LocalDateTime data);

    @Query("""
            select m.ativo from Medico m where m.id = :idMedico
            """)
    Boolean findAtivoById(Long idMedico);

}

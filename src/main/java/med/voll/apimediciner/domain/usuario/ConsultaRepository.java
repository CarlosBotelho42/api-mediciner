package med.voll.apimediciner.domain.usuario;

import med.voll.apimediciner.domain.consulta.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}

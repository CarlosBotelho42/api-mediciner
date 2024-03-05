package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.paciente.PacienteRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteAtivo implements ValidadorAgendamentoConsulta{

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidationConsultaException("Paciente não ativo!");
        }
    }
}

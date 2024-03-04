package med.voll.apimediciner.domain.consulta.validador;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.paciente.PacienteRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;

public class PacienteAtivo {

    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidationConsultaException("Paciente não ativo!");
        }
    }
}

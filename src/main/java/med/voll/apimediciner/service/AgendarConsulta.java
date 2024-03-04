package med.voll.apimediciner.service;

import med.voll.apimediciner.domain.consulta.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.consulta.Consulta;
import med.voll.apimediciner.domain.consulta.ConsultaRepositry;
import med.voll.apimediciner.domain.medico.Medico;
import med.voll.apimediciner.domain.medico.MedicoRepository;
import med.voll.apimediciner.domain.paciente.Paciente;
import med.voll.apimediciner.domain.paciente.PacienteRepository;
import med.voll.apimediciner.util.exception.ValidationConsultaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarConsulta {

    @Autowired
    private ConsultaRepositry consultarepositry;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados){

        //Verificar existencia por id
        if(!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidationConsultaException("ID do Paciente não exsite!");
        }

        if(dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidationConsultaException("ID do Medico não exsite!");
        }

        //salvar no banco
        Medico medico = escolherMedico(dados);
        Paciente paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultarepositry.save(consulta);
    }


    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if(dados.especialidade() == null){
            throw new ValidationConsultaException("Caso o medico nao seja escolhido é necessario passar a especialidade requerida.");
        }

        return medicoRepository.escolherMedicoAleatorioDisponivelNaDatata(dados.especialidade(), dados.data());
    }

}

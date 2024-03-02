package med.voll.apimediciner.service;

import med.voll.apimediciner.controller.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.consulta.Consulta;
import med.voll.apimediciner.domain.consulta.ConsultaRepositry;
import med.voll.apimediciner.domain.medico.Medico;
import med.voll.apimediciner.domain.medico.MedicoRepository;
import med.voll.apimediciner.domain.paciente.Paciente;
import med.voll.apimediciner.domain.paciente.PacienteRepository;
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

        //salvar no banco
        Medico medico = medicoRepository.findById(dados.idMedico()).get();
        Paciente paciente = pacienteRepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());
        consultarepositry.save(consulta);
    }

}

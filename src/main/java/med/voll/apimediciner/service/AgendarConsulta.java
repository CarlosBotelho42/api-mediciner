package med.voll.apimediciner.service;

import med.voll.apimediciner.controller.DadosAgendamentoConsulta;
import med.voll.apimediciner.domain.consulta.ConsultaRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendarConsulta {

    @Autowired
    private ConsultaRepositry repositry;

    public void agendar(DadosAgendamentoConsulta dados){

        //salvar no banco


    }

}

package com.dbc.pessoaapi.scheduler;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.entity.PessoaEntity;
import com.dbc.pessoaapi.repository.PessoaRepository;
import com.dbc.pessoaapi.service.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class MeuNovoSchedulerCron {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("HH:mm:ss");
    private final PessoaRepository pessoaRepository;
    private final EmailService emailService;

    @Scheduled(cron = "0 18-21 15,20 * * *", zone = "GMT-3")
    public void meuPrimeiroScheduler() throws InterruptedException {
//        Thread.sleep(1000);
        log.info("{}", dateFormat.format(new Date()));
    }

    @Scheduled(cron = "0 0 8,20 * * *")
    public void schedulePessoaSemEndereco() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<PessoaEntity> entity = pessoaRepository.procurarPessoasComEnderecoNull();
        for (PessoaEntity pessoa : entity) {
            emailService.enviarMsg(pessoa, "email-template.ftl");
        }
    }


    @Scheduled(cron = "* * * 25 12 ?")
    public void scheduleEx2() throws InterruptedException, MessagingException, TemplateException, IOException {
        List<PessoaEntity> listaPessoa = pessoaRepository.findAll();
        for (PessoaEntity p : listaPessoa) {
            emailService.enviarMsg(p, "email-templateEx2.ftl");
        }
    }


}

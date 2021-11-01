package com.dbc.pessoaapi;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.EmailService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class PessoaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiApplication.class, args);
	}
	@Autowired
	private EmailService emailService;
	private PessoaDTO pessoaDTO;

	void contextLoads() throws MessagingException, TemplateException, IOException {
//		emailService.enviarEmailSimples();
//		emailService.enviarEmailComAnexos();
//		emailService.enviarEmailComTemplate(pessoaDTO);
//		emailService.enviarEmailComTemplateAndAnexos();
	}

}


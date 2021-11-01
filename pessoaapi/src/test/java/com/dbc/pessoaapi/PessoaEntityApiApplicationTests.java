package com.dbc.pessoaapi;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.EmailService;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootTest
class PessoaApiApplicationTests {

	@Autowired
	private EmailService emailService;

	@Test
	void contextLoads() throws MessagingException, TemplateException, IOException {
		PessoaDTO pessoaDTO = new PessoaDTO();
//		emailService.enviarEmailSimples();
//		emailService.enviarEmailComAnexos();
		emailService.enviarEmailComTemplate(pessoaDTO);
//		emailService.enviarEmailComTemplateAndAnexos();
	}

}

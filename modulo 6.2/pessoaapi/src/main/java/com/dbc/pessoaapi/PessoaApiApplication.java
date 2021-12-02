package com.dbc.pessoaapi;

import com.dbc.pessoaapi.dto.PessoaDTO;
import com.dbc.pessoaapi.service.EmailService;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class PessoaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessoaApiApplication.class, args);
	}

}


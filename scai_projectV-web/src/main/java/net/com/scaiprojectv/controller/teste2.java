package net.com.scaiprojectv.controller;

import java.util.Random;

import net.com.scaiprojectv.model.Aluno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class teste2 implements ApplicationListener<BrokerAvailabilityEvent>{

	private final MessageSendingOperations<String> messagingTemplate;
	
	 @Autowired
	    public teste2(
	        final MessageSendingOperations<String> messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	    }
	
	 @Scheduled(fixedDelay = 1000)
	    public void sendDataUpdates() {

	        this.messagingTemplate.convertAndSend(
	            "/channel", new Random().nextInt(100));

	    }
	 
	/**
	 * The @MessageMapping annotation ensures that if a message is sent to
	 * destination "/hello", then the greeting() method is called.
	 * 
	 * A anotação @MessageMapping garante que se a mensagem é enviada para o
	 * destino "/hello", então o método sendaDataUpdates é chamado.
	 * 
	 * @param aluno
	 */
	@MessageMapping("/hello")
	@SendTo("/channel")
	public String sendDataUpdates(Aluno aluno) {
		String none = "ola mundo";
		System.out.println("entrouuuuu");
		System.out.println("Aluno: " + aluno.getNome());
		return none;
	}

	@Override
	public void onApplicationEvent(BrokerAvailabilityEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
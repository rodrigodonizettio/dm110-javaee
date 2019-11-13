package br.inatel.dm110.hello.beans;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Stateless
public class HelloMessageSender {
	@Resource(lookup="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(lookup="java:/jms/queue/dm110queue") //It'll be configured inside the container
	private Queue queue;
	
	public void sendTextMessage(String text) {
		try {
			Connection connection = connectionFactory.createConnection();
			Session session = connection.createSession();
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage textMessage = session.createTextMessage(text);
			messageProducer.send(textMessage);
		} catch (JMSException e) {
			System.out.println("Erro enviando mensagem: " + text);
			throw new RuntimeException(e);
		}
	}
}

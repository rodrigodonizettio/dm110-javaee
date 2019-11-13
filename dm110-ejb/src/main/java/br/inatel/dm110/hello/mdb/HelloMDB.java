package br.inatel.dm110.hello.mdb;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class HelloMDB implements MessageListener {

	@Override
	public void onMessage(Message message) {
		if(message instanceof TextMessage) {
			try {
				TextMessage textMessage = (TextMessage) message;
				String text = textMessage.getText();
				System.out.println("HelloMDB is receiving a message");
				Thread.sleep(5000);
				System.out.println("HelloMDB received the following message: " + text);
			} catch (JMSException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

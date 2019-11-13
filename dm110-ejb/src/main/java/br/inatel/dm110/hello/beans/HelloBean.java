package br.inatel.dm110.hello.beans;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.inatel.dm110.hello.interfaces.HelloLocal;
import br.inatel.dm110.hello.interfaces.HelloRemote;

@Stateless
@Remote(HelloRemote.class)
@Local(HelloLocal.class)
public class HelloBean implements HelloLocal, HelloRemote {
	
	@EJB
	private HelloMessageSender messageSender;

	@Override
	public String sayHello(String name) {
		System.out.println("[DM110-EJB] sayHello method called in HelloBean class");
		
		messageSender.sendTextMessage(name);
		System.out.println("MessageSender sent message with name: " + name);
		
		return "Hello " + name + " from HelloBean!";
	}
	
}


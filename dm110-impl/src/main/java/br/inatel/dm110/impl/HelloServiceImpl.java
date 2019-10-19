package br.inatel.dm110.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.HelloService;
import br.inatel.dm110.api.MessageTO;

@RequestScoped
public class HelloServiceImpl implements HelloService {

	static private int count = 0;
	
	//test: in memory storage
	static private Map<Integer, MessageTO> cache = new HashMap<>();

	@Override
	public String sayHello(String name) {
		String message = "Hello " + name;
		return "<h1>" + message + "</h1>";
	}

	@Override
	public MessageTO message(String first, String last) {
		MessageTO result = new MessageTO();
		result.setFirstName(first);
		result.setLastName(last);
		String message = String.format("Hello %s %s!!!", first, last);
		result.setMessage(message);
		return result;
	}

	@Override
	public int storeNewMessage(MessageTO message) {
		message.setMessage("Hello " + message.getFirstName() + " " + message.getLastName());
		System.out.println("Message created: " + message.getMessage());
		count++;
		cache.put(count, message);
		return count;
	}
	
	@Override
	public Collection<MessageTO> getMessages() {
		return cache.values();
	}

	/**
	 * CALCULATOR EXERCISE - SLIDE-30/32 (DM100-Aula1_19554.pdf)
	 */
	@Override
	public String calcSum(int val1, int val2) {
		int sumResult = val1 + val2;
		return String.format("<h1>Resultado da Soma: %s</h1>", sumResult);
	}
	
	@Override
	public String calcSub(int val1, int val2) {
		int subResult = val1 - val2;
		return String.format("<h1>Resultado da Subtração: %s</h1>", subResult);
	}
	
	@Override
	public String calcMul(int val1, int val2) {
		int mulResult = val1 * val2;
		return String.format("<h1>Resultado da Multiplicação: %s</h1>", mulResult);
	}
	
	@Override
	public String calcDiv(int val1, int val2) {
		int divResult = val1 / val2;
		return String.format("<h1>Resultado da Divisão: %s</h1>", divResult);
	}
}

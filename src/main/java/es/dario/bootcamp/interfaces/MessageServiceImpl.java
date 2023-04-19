package es.dario.bootcamp.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Value("${courses.message:${courses:defecto}}")
	private String message;

	@Override
	public String getMessage() {
		return message;
	}




}

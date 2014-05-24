package net.com.scaiprojectv.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class HandlerClass extends TextWebSocketHandler{

	@Override
	@RequestMapping(value = "/myHandler")
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		super.handleTextMessage(session, message);
		System.out.println("asaaaaaaaaaaa");
		TextMessage returMessage = new TextMessage(message.getPayload() +" received at server");
		session.sendMessage(returMessage);
	}
	
}

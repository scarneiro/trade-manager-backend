package com.darkstar.trading.trademanager.config.remoting;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// register websocket handlers.
	}
}

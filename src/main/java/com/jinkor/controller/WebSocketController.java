package com.jinkor.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jinkor.model.base.SocketMessage;

@Controller
@EnableScheduling //开启springboot的定时功能
public class WebSocketController {

		
	
		@Autowired
		private SimpMessagingTemplate messagingTemplate;
	
		@RequestMapping("/ws")
		public String toWsPage() {
			return "ws";
		}
		
		/**
		 * 需要客户端请求 然后再推送
		 * @param message
		 * @return
		 * @throws Exception
		 */
	    @MessageMapping("/send")
	    @SendTo("/topic/send")
	    public SocketMessage send(SocketMessage message) throws Exception {
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        message.date = df.format(new Date());
	        return message;
	    }

	    /**
	     * 直接往客户端 推送数据
	     * @return
	     * @throws Exception
	     */
	    @Scheduled(fixedRate = 1000) //每一秒推送一次
	    @SendTo("/topic/callback")
	    public Object callback() throws Exception {
	        // 发现消息
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        messagingTemplate.convertAndSend("/topic/callback", df.format(new Date()));
	        return "callback";
	    }
}

package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author LinHaojia
 * @create 2022-07-26 20:20
 */
@ServerEndpoint("/websocket")
@Component
@Slf4j
public class WebSocket {

    private Session session;

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
    private static  CopyOnWriteArraySet<WebSocket> webSocketSet=new CopyOnWriteArraySet<>();


    /**
     *  建立连接成功
     * @param session
     */
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSocketSet.add(this);
        log.info("【websocket消息】 有新的连接，总数{}",webSocketSet.size());
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose(){
        this.session=session;
        webSocketSet.remove(this);
        log.info("【websocket消息】 连接断开，总数{}",webSocketSet.size());
    }

    /**
     * 接收客户端消息
     * @param message
     */
    @OnMessage
    public void onMessage(String message){
        log.info("【websocket消息】 收到客户端发来的消息：{}",message);
    }

    /**
     * 发送消息
     * @param message
     */
    public void sendMessage(String message){
        log.info("【websocket消息】 发送消息：{}",message);
        for (WebSocket webSocket:webSocketSet){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
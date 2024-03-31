package com.gfj.plantpal.WebSocketServer;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author gefangjie
 */
@Slf4j
@Component
@ServerEndpoint(value = "/websocket/{datatype}")
public class WebSocket {

    //与某个客户端的连接对话，需要通过它来给客户端发送消息
    private Session session;
    //标识当前连接客户端的发送传感器数据类型
    private String datatype;
    /**
     * 用于存所有的连接服务的客户端，这个对象存储是安全的
     * 注意这里的kv,设计的很巧妙，v刚好是本类 WebSocket (用来存放每个客户端对应的MyWebSocket对象)
     */
    private static final ConcurrentHashMap<String,WebSocket> WEB_SOCKET_SET = new ConcurrentHashMap<>();
    /**
     * 连接建立成功调用的方法
     * session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "datatype") String datatype){
        log.info("----------------------------------");
        this.session = session;
        this.datatype = datatype;
        // name是用来表示唯一客户端，如果需要指定发送，需要指定发送通过name来区分
        WEB_SOCKET_SET.put(datatype,this);
        log.info("[WebSocket] 连接成功，当前连接人数为：={}",WEB_SOCKET_SET.size());
        log.info("----------------------------------");
        log.info("");

        groupSending(datatype+" 来了");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(){
        WEB_SOCKET_SET.remove(this.datatype);
        log.info("[WebSocket] 退出成功，当前连接人数为：={}",WEB_SOCKET_SET.size());

        groupSending(datatype+" 走了");
    }
    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String messageStr){
        log.info("[WebSocket] 收到消息：{}",messageStr);
        //判断是否需要指定发送，具体规则自定义
        //message_str的格式 TOUSER:user2;message:aaaaaaaaaaaaaaaaaa;
        if(messageStr.indexOf("TOUSER") == 0){
            //取出 name和message的值
            String[] split = messageStr.split(";");
            String[] split1 = split[0].split(":");
            String[] split2 = split[1].split(":");
            String name = split1[1];
            String message = split2[1];
            //指定发送
            appointSending(name,message);
        }else{
            //群发
            groupSending(messageStr);
        }
    }

    /**
     * 发生错误时调用
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error){
        log.info("发生错误");
        error.printStackTrace();
    }

//    /**
//     * 群发
//     * @param message
//     */
//    public void GroupSending(String message){
//        for (String name : webSocketSet.keySet()){
//            try {
//                webSocketSet.get(name).session.getBasicRemote().sendText(message);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

    /**
     * 群发消息的静态方法
     * @param message 要发送的消息内容
     */
    public static void groupSending(String message){
        for (WebSocket webSocket : WEB_SOCKET_SET.values()){
            try {
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                log.error("发送WebSocket消息错误", e);
            }
        }
    }

//    /**
//     * 指定发送
//     * @param datatype
//     * @param message
//     */
//    public void AppointSending(String datatype,String message){
//        try {
//            webSocketSet.get(datatype).session.getBasicRemote().sendText(message);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    /**
     * 指定发送消息的静态方法
     * @param datatype 目标用户的唯一标识
     * @param message 要发送的消息内容
     */
    public static void appointSending(String datatype, String message) {
        WebSocket webSocket = WEB_SOCKET_SET.get(datatype);
        if (webSocket != null) {
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                log.error("向指定用户发送WebSocket消息错误", e);
            }
        } else {
            log.warn("未找到指定用户：{}", datatype);
        }
    }
}
package kr.co.tomato.webSocket2;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

// 서버측

@ServerEndpoint("/server")
public class ServerSocket
{
    // 연결된 세션(클라이언트)을 저장할 set (중복방지) 
    private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println("전송할 메시지 = " + message);
         
        
        synchronized (clients)
        {
            // Iterate over the connected sessions      연결된 세션들을 반복(순회)하며
            // and broadcast the recived messgae        받은 메시지를 공지한다.
            
            for(Session client : clients) {
                // 내 세션(나)가 아닌 다른 사용자들에게 메시지 전송
                if(!client.equals(session)) {
                    client.getBasicRemote().sendText(message);  // 여기서 예외처리로 인한 throws 추가
                }
            }
        }
    }
    
    @OnOpen
    public void onOpen(Session session) {
        // Add session to the connected session set 
        // 연결된 세션을 모아둔 set에 세션을 추가
        
        System.out.println("추가된 세션 = " + session);
        clients.add(session);
    }
    
    
    @OnClose
    public void onClose(Session session) {
        // Remove session from the conneted sessions set
        // 연결된 세션을 모아둔 set에서 입력받은 session을 제거
        System.out.println("삭제할 세션 = " + session);
        clients.remove(session);
    }
    
    
    
}

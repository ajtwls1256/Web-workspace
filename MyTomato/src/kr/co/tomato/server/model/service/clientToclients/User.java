package kr.co.tomato.server.model.service.clientToclients;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

public class User
{
    HashMap<String, DataOutputStream> clientMap = new HashMap<>();
    
    public synchronized void addClient(String name, Socket socket) {
        try {
            
            sendMsg(name + " 입장하셨습니다.", "Server");
            // 클라이언트 소켓의 outputStream을 가져와서 사용함
            clientMap.put(name, new DataOutputStream(socket.getOutputStream()));
            System.out.println("채팅 참여 인원 : " + clientMap.size());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public synchronized void removeClient(String name) {
        try {
            clientMap.remove(name);
            sendMsg(name + " 퇴장하셨습니다.", "Server");
            System.out.println("채팅 참여 인원 : " + clientMap.size());
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    
    // 채팅방에 있는 전체 client의 outputStream을 가져와서 입력한 메세지 전송
    public synchronized void sendMsg(String msg, String name) throws Exception
    {
        Iterator iter = clientMap.keySet().iterator();
        while(iter.hasNext()) {
            String clientName = (String)iter.next();
            clientMap.get(clientName).writeUTF(name + ":" + msg);
        }
    }
    
    
}

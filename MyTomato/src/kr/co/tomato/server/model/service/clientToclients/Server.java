package kr.co.tomato.server.model.service.clientToclients;

import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

    public Server()
    {
        // 접속한 Client와 통신하기위한 소켓
        Socket socket = null;
        
        // 채팅방에 접속해 있는 Client관리 객체
        User user = new User();
        
        // Client 접속을 받기 위한 serverSocket
        ServerSocket serverSocket = null;
        
        int count = 0;
        Thread thread[] = new Thread[10];
        
        try {
            serverSocket = new ServerSocket(4000);
            
            // Server의 메인쓰레드는 계속해서 사용자의 접속을 받음
            while(true) {
                socket = serverSocket.accept();
                
                thread[count] = new Thread(new Receiver(user, socket));
                thread[count].start();
                count++;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}

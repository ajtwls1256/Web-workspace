package kr.co.tomato.server.model.service.clientToclients;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client
{
    // Server와 통신하기위한 Socket
    Socket socket = null;
    
    // Server로부터 데이터를 읽어들이기 위한 입력스트림
    DataInputStream serverInput = null;
    
    // 키보드로부터 읽어들이기 위한 입력 스트림
    BufferedReader keyboardInput = null;
    
    // Server로 데이터 전송용
    DataOutputStream out = null;
    
    
    public Client() {
        
        try {
            // 서버 접속
            socket = new Socket("192.168.40.12", 4000);
            serverInput = new DataInputStream(socket.getInputStream());
            keyboardInput = new BufferedReader(new InputStreamReader(System.in));
            
            out = new DataOutputStream(socket.getOutputStream()); 
            
            // 채팅에 사용할 닉네임
            System.out.println("닉네임을 입력해주세요 : ");
            String nickname = keyboardInput.readLine();
            
            // 서버로 닉네임을 전송
            out.writeUTF(nickname);
            
            // 사용자가 채팅 내용을 입력 및 서버로 전송하기 위한 쓰레드 생성 및 시작
            Thread th = new Thread(new Send(out));
            th.start();
        }catch(IOException e) {
            e.printStackTrace();
        }
        
        try {
            // 클라이언트의 메인 쓰레드는 서버로부터 데이터를 읽어들이는 것만 반복
            
            while(true) {
                String str2 = serverInput.readUTF();
                System.out.println(str2);
            }
        }catch(IOException e2) {
            e2.printStackTrace();
        }
        
    }
    
}

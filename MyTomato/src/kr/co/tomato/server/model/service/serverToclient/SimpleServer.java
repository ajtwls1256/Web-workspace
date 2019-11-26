package kr.co.tomato.server.model.service.serverToclient;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer
{
    
    public void ServerRun() throws IOException{
        ServerSocket server = null;
        int port = 4200;
        Socket socket = null;
        
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        
        
        try {
            server = new ServerSocket(port);
            while(true) {
                System.out.println("--- 접속 대기중 ---");
                socket = server.accept();      // 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                System.out.println(socket.getInetAddress() + "로 부터 연결요청 들어옴");
                
                
                // 클라이언트로부터 데이터를 받기위한 inputStream선언
                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                
                String data = null;
                data = br.readLine();
                System.out.println("클라이언트로부터 받은 데이터 " + data);
                
                receiveData(data, socket);     // 받은 데이터를 그대로 다시 보내기
                System.out.println("전송 완료");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
                isr.close();
                is.close();
                server.close();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    public void receiveData(String data, Socket socket) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        
        try {
            
            // 클라이언트로부터 데이터를 보내기위해 outputStream 선언
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            
            bw.write(data);        // 클라이언트로 데이터 전송
            bw.flush();
        }catch(Exception e1) {
            e1.printStackTrace();
        }finally {
            try {
                bw.close();
                osw.close();
                os.close();
                socket.close();
            }catch(Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
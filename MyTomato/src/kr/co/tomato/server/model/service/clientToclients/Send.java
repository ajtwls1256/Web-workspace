package kr.co.tomato.server.model.service.clientToclients;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

public class Send implements Runnable
{
    
    DataOutputStream out;
    BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
    
    public Send(DataOutputStream out) {
        this.out = out;
    }
    
    public void run() {
        while(true) {
            try {
                
                // 키보드로부터 입력을 받음
                String msg = keyboardInput.readLine();
            
                // 서버로 전송
                out.writeUTF(msg);
                
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

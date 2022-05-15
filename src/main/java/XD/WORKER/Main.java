package XD.WORKER;

import java.util.Scanner;

import XD.XDDOS.XDDOS;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("IP:");
        String ip = s.nextLine();
        System.out.println("Protocol:");
        int protocol = s.nextInt();
        System.out.println("Method:");
        String method = s.next();
        System.out.println("Time:");
        int time = s.nextInt();
        System.out.println("CPS:");
        int CPS = s.nextInt();
        try {
            XDDOS.main(ip, protocol, method, time, CPS);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        
    }
}

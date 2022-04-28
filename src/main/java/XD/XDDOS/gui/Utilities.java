package XD.XDDOS.gui;

import java.util.ArrayList;
import java.util.HashMap;

public class Utilities {

    public static final String[] versions = {
        "1.18.2",
        "1.18.1",
        "1.18", 
        "1.17.1",
        "1.17",   
        "1.16.5",
        "1.16.4",
        "1.16.3",
        "1.16.2",
        "1.16.1",
        "1.16",
        "1.15.2",
        "1.15.1",
        "1.15", 
        "1.14.4",
        "1.14.3",
        "1.14.2",
        "1.14.1",
        "1.14",
        "1.13.2",
        "1.13.1",
        "1.13" ,
        "1.12.2",
        "1.12.1",
        "1.12",
        "1.11.2",
        "1.11.1",
        "1.11",
        "1.10.2",
        "1.10.1",
        "1.10",
        "1.9.4",
        "1.9.3",
        "1.9.2",
        "1.9.1",
        "1.9",
        "1.8.x",
        "1.7.6 - 1.7.10",
        "1.7.2 - 1.7.5"
    };


    public static final ArrayList<String> methodsList = new ArrayList<String>();
    public static HashMap<String, Integer> VERSION_ID = new HashMap();

    public static void listMethods() {
        methodsList.add("BETA");
      methodsList.add("BigHandshake");
      methodsList.add("BigPacket");
      methodsList.add("BotJoiner");
      methodsList.add("BungeeDowner");
      methodsList.add("ChatSpam");
      methodsList.add("ColorCrasher");
      methodsList.add("CpuDowner");
      methodsList.add("DoubleJoin");
      methodsList.add("EmptyNames");
      methodsList.add("EmptyPacket");
      methodsList.add("ExtremeJoin");
      methodsList.add("ExtremeKiller");
      methodsList.add("Handshake");
      methodsList.add("InstantDowner");
      methodsList.add("InvalidData");
      methodsList.add("InvalidNames");
      methodsList.add("InvalidSpoof");
      methodsList.add("IpSpooffFlood");
      methodsList.add("Join");
      methodsList.add("LegacyPing");
      methodsList.add("LegitnameJoin");
      methodsList.add("LocalHost");
      methodsList.add("LongHost");
      methodsList.add("LongNames");
      methodsList.add("Memory");
      methodsList.add("MOTD");
      methodsList.add("nabCry");
      methodsList.add("NettyDowner");
      methodsList.add("Network");
      methodsList.add("NullPing 2.0");//newnullping
      methodsList.add("NullPing");
      methodsList.add("Ping");
      methodsList.add("PingJoin");
      methodsList.add("Query");
      methodsList.add("Queue");
      methodsList.add("QuitExceptions");
      methodsList.add("RAM");
      methodsList.add("RandomExceptions");
      methodsList.add("RandomPacket");
      methodsList.add("ServerFucker");//this is sf
      methodsList.add("Slapper");
      methodsList.add("SmartBot");
      methodsList.add("Spoof");
      methodsList.add("TCPBypass");
      methodsList.add("TCPHit");
      methodsList.add("UltimateKiller");
      methodsList.add("UltimateSmasher");
      methodsList.add("UnexpectedPacket");
      methodsList.add("uuidCrash");
      methodsList.add("WaterfallBypass");
      methodsList.add("XDJoin");
      methodsList.add("xDSpam");
      methodsList.add("YooniksCry");
    }

    public static void initializeVersions() {
        VERSION_ID.put("1.18.2", 758);
        VERSION_ID.put("1.18.1", 757);
        VERSION_ID.put("1.18",   757);
        VERSION_ID.put("1.17.1", 756);
        VERSION_ID.put("1.17",   755);
        VERSION_ID.put("1.16.5", 754);
        VERSION_ID.put("1.16.4", 754);
        VERSION_ID.put("1.16.3", 753);
        VERSION_ID.put("1.16.2", 751);
        VERSION_ID.put("1.16.1", 736);
        VERSION_ID.put("1.16", 735);
        VERSION_ID.put("1.15.2", 578);
        VERSION_ID.put("1.15.1", 575);
        VERSION_ID.put("1.15", 573);
        VERSION_ID.put("1.14.4", 498);
        VERSION_ID.put("1.14.3", 490);
        VERSION_ID.put("1.14.2", 485);
        VERSION_ID.put("1.14.1", 480);
        VERSION_ID.put("1.14", 477);
        VERSION_ID.put("1.13.2", 404);
        VERSION_ID.put("1.13.1", 401);
        VERSION_ID.put("1.13", 393);
        VERSION_ID.put("1.12.2", 340);
        VERSION_ID.put("1.12.1", 338);
        VERSION_ID.put("1.12", 335);
        VERSION_ID.put("1.11.2", 316);
        VERSION_ID.put("1.11.1", 316);
        VERSION_ID.put("1.11", 315);
        VERSION_ID.put("1.10.2", 210);
        VERSION_ID.put("1.10.1", 210);
        VERSION_ID.put("1.10", 210);
        VERSION_ID.put("1.9.4", 110);
        VERSION_ID.put("1.9.3", 110);
        VERSION_ID.put("1.9.2", 109);
        VERSION_ID.put("1.9.1", 108);
        VERSION_ID.put("1.9", 107);
        VERSION_ID.put("1.8.x", 47);
        VERSION_ID.put("1.7.6 - 1.7.10", 5);
        VERSION_ID.put("1.7.2 - 1.7.5", 4);
    }
}

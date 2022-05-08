package XD.XDDOS;

import XD.XDDOS.methods.*;

import java.util.HashMap;

public class Methods {
   public static final HashMap<String, Method> METHODS = new HashMap<String,Method>();

   public static Method getByID(int i) {
      return (Method)METHODS.getOrDefault(i, (c, p) -> {
         c.close();
         System.err.println("invalid method id: " + i);
      });
   }

   private static void registerMethod(String name, Method m) {
      if (METHODS.containsKey(name)) {
         throw new IllegalStateException("Method with id " + name + " already exists");
      } else {
         METHODS.put(name, m);
      }
   }

   public static void setupMethods() {
      registerMethod("bigpacket", (Method)new BigPacket());
      registerMethod("botjoiner", (Method)new BotJoiner());
      registerMethod("doublejoin", (Method)new DoubleJoin());
      registerMethod("emptypacket", (Method)new EmptyPacket());
      registerMethod("xdspam", (Method)new XDSPAM());
      registerMethod("handshake", (Method)new HandshakeMethod());
      registerMethod("invaliddata", (Method)new InvalidData());
      registerMethod("invalidspoof", (Method)new InvalidIPSpoof());
      registerMethod("invalidnames", (Method)new InvalidNames());
      registerMethod("spoof", (Method)new IPSpoof());
      registerMethod("join", (Method)new Join());
      registerMethod("legacyping", (Method)new LegacyPing());
      registerMethod("legitnamejoin", (Method)new LegitNameKiller());
      registerMethod("localhost", (Method)new Localhost());
      registerMethod("pingjoin", (Method)new LoginPingMulticrasher());
      registerMethod("longhost", (Method)new LongHost());
      registerMethod("longnames", (Method)new LongNames());
      registerMethod("nullping", (Method)new NullPing());
      registerMethod("ping", (Method)new Ping());
      registerMethod("query", (Method)new QueryFlood());
      registerMethod("randompacket", (Method)new RandomBytes());
      registerMethod("bighandshake", (Method)new BigHandshake());
      registerMethod("unexpectedpacket", (Method)new PlayPacket());
      registerMethod("memory", (Method)new Memory());
      registerMethod("network", (Method)new Network());
      registerMethod("extremejoin", (Method)new ExtremeJoin());
      registerMethod("nettydowner", (Method)new NettyDowner());
      registerMethod("ram", (Method)new RAM());
      registerMethod("yoonikscry", (Method)new YooniksCry());
      registerMethod("colorcrasher", (Method)new ColorCrasher());
      registerMethod("tcphit", (Method)new TCPHIT());
      registerMethod("queue", (Method)new queue());
      registerMethod("tcpbypass", (Method)new TCPBYPASS());
      registerMethod("ultimatesmasher", (Method)new UltimateSmasher());
      registerMethod("sf", (Method)new ServerFucker());
      registerMethod("nabcry", (Method)new nAntiBotCry());
      registerMethod("xdjoin", (Method)new XDJOIN());
      registerMethod("ipSpooffflood", (Method)new IPSpoofFFlood());
      registerMethod("chatspam" , (Method)new ChatSpam());
      registerMethod("cpudowner", (Method)new CPUDowner());
      registerMethod("extremekiller", (Method)new ExtremeKiller());
      registerMethod("instantdowner", (Method)new InstantDowner());
      registerMethod("motd", (Method)new Motd());
      registerMethod("newnullping", (Method)new NewNullPing());
      registerMethod("quitexceptions", (Method)new QuitExceptions());
      registerMethod("randomexceptions", (Method)new RandomExceptions());
      registerMethod("slapper", (Method)new Slapper());
      registerMethod("smartbot", (Method)new SmartBot());
      registerMethod("ultimatekiller", (Method)new UltimateKiller());
      registerMethod("waterfallbypass", (Method)new WaterfallBypass());
      registerMethod("emptynames", (Method)new EmptyNames());
      registerMethod("uuidcrash", (Method)new UUIDCrash());
      registerMethod("bungeedowner", (Method)new BungeeDowner());
      registerMethod("beta", (Method)new Beta());
   }

   public static Method getMethod(String methodID) {
      return (Method)METHODS.getOrDefault(methodID, new NettyDowner());
   }

}

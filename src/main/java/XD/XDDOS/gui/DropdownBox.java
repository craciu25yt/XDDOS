package XD.XDDOS.gui;

import javax.swing.JComboBox;

public class DropdownBox extends JComboBox<String> {
    static String[] methods = {
        "BigHandshake",
        "Bigpacket",
        "Botjoiner",
        "ChatSpam",
        "ColorCrasher",
        "CPUDowner",
        "Doublejoin",
        "EmptyNames",
        "ExtremeJoin",
        "ExtremeKiller",
        "Handshake",
        "InstantDowner",
        "InvalidData",
        "InvalidNames",
        "InvalidSpoof",
        "IPSpoofFFlood",
        "Join",
        "LegacyPing",
        "LegitnameJoin",
        "LocalHost",
        "LongHost",
        "LongNames",
        "Memory",
        "MOTD",
        "NabCry",
        "NettyDowner",
        "Network",
        "NewNullPing",
        "NullPing",
        "Ping",
        "PingJoin",
        "Query",
        "Queue",
        "QuitExceptions",
        "Ram",
        "RandomExceptions",
        "RandomPacket",
        "SF",
        "Slapper",
        "SmartBot",
        "Spoof",
        "TcpBypass",
        "TcpHit",
        "UltimateKiller",
        "UltimateSmasher",
        "UnexpectedPacket",
        "WaterFallBypass",
        "XDjoin",
        "XDSpam",
        "YooniksCry",
        // EXPERIMENTAL IS MARKED WITH [E]
        "EmptyNames [E]",
        "UUIDCrash [E]",
        "BungeeDowner [E]"
    };

    public DropdownBox() {}

    public void addMethods() {
        for(String s : methods) {
            addItem(s);
        }
    }
}
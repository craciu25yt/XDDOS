package XD.XDDOS.utils.proxy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import XD.XDDOS.XDDOS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ProxyGen {

    private List<String> proxies = new CopyOnWriteArrayList<>();
    private File proxyFile;

    public ProxyGen(File proxyFile, String[] args) {
        System.out.println(XDDOS.GREEN_BOLD+"["+XDDOS.RED_BOLD+"XDDOS"+XDDOS.GREEN_BOLD+"] "+XDDOS.WHITE_BOLD+" Parsing proxy...");
        this.proxyFile = proxyFile;
        try {
            Document proxyLists = Jsoup.connect("https://api.proxyscrape.com/v2/?request=displayproxies&proxytype=socks4").get();
            proxies.addAll(Arrays.stream(proxyLists.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from proxyscrape.com!");
        }
        try {
            Document proxyLists = Jsoup.connect("https://www.proxyscan.io/api/proxy?type=socks4&last_check=10000&limit=20&format=txt").get();
            proxies.addAll(Arrays.stream(proxyLists.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from proxyscan.io");
        }
        try {
            Document proxyListd = Jsoup.connect("https://www.proxy-list.download/api/v1/get?type=socks4").get();
            proxies.addAll(Arrays.stream(proxyListd.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from proxy-list.download!");
        }


        try {
            Document proxyListf = Jsoup.connect("https://openproxylist.xyz/socks4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from openproxylist.xyz!");
        }

        try {
            Document proxyListf = Jsoup.connect("https://raw.githubusercontent.com/TheSpeedX/SOCKS-List/master/socks4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from https://raw.githubusercontent.com/TheSpeedX/SOCKS-List/master/socks4.txt");
        }
        try {
            Document proxyListf = Jsoup.connect("https://raw.githubusercontent.com/B4RC0DE-TM/proxy-list/main/SOCKS4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from https://raw.githubusercontent.com/B4RC0DE-TM/proxy-list/main/SOCKS4.txt");
        }
        try {
            Document proxyListf = Jsoup.connect("https://raw.githubusercontent.com/jetkai/proxy-list/main/online-proxies/txt/proxies-socks4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from https://raw.githubusercontent.com/jetkai/proxy-list/main/online-proxies/txt/proxies-socks4.txt");
        }
        try {
            Document proxyListf = Jsoup.connect("https://raw.githubusercontent.com/MuRongPIG/Proxy-Master/main/socks4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from https://raw.githubusercontent.com/MuRongPIG/Proxy-Master/main/socks4.txt");
        }
        try {
            Document proxyListf = Jsoup.connect("https://raw.githubusercontent.com/officialputuid/KangProxy/main/socks4/socks4.txt").get();
            proxies.addAll(Arrays.stream(proxyListf.text().split(" ")).distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("Failed to parse from https://raw.githubusercontent.com/officialputuid/KangProxy/main/socks4/socks4.txt");
        }
        proxies = new CopyOnWriteArrayList<>(new HashSet<>(proxies));

        try {
            this.proxyFile.createNewFile();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.proxyFile))) {
                for (String proxy : proxies) {
                    writer.write(proxy + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ProxyLoader load() {
        return new ProxyLoader(proxyFile);
    }

}

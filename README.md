![alt text](https://cdn.discordapp.com/attachments/949290845222350928/964583278789148763/cover.png)
# XDDOS, an advanced minecraft server stresser

XDDOS is an advanced tool for attacking and testing your server against bots that is made from [MCStorm](https://github.com/llyxa05/MCSTORM-Crack).

## Features avilable

XDDOS has the following features:

- `54` different attack methods
- Supports all versions 
- `proxy scraper` (just put the links to scrape proxy from in urls.txt)
- `user friendly CLI` dont worry about hard to remeber startup commands
- Startup commands 
- Auto ip resolver. That means that you can use the server IP or the domain
- Ansi Colours supported
- Inbuilt auto updater

## How to use XDDOS

### Things to know

- CPS is the Connection per second. If you want to use the max power use `-1` as cps limit
- Jar is compiled used java 8. That means that you an use java 8 or above to run XDDOS
- To get versions protocols go [here](https://wiki.vg/Protocol_version_numbers)

### Steps to take to run XDDOS:
 1) Download the jar -> [Download](https://github.com/AnAverageBeing/XDDOS/raw/master/XDDOS.jar)
 2) Create a folder to store XDDOS
 3) Now make a file called urls.txt in that folder
 4) Put the links to scrape socks4 proxies from in that file
   ### If you don't have, here's some socks4 links to scrape
  ```
  https://raw.githubusercontent.com/TheSpeedX/PROXY-List/master/socks4.txt
  https://raw.githubusercontent.com/ShiftyTR/Proxy-List/master/socks4.txt
  https://raw.githubusercontent.com/monosans/proxy-list/main/proxies/socks4.txt
  https://raw.githubusercontent.com/jetkai/proxy-list/main/online-proxies/txt/proxies-socks4.txt
  ```
  
 5) Now open your terminal and go to the directory (Trick, you can write in the folder patch `cmd` and the terminal will open in that folder)
 6) Now use one of the commands below for starting

### Update Command:
```
java -jar XDDOS.jar -update
```

### Startup Command: 

- For user friendly CLI/auto mode with colors:
```
java -jar XDDOS.jar
```
- For user friendly CLI/auto mode without colors:
```
java -jar XDDOS.jar -noansi
```

- for manual startup with colors:
```
java -jar XDDOS.jar [ip] [protocol] [method] [time] [cps] [y/n]
```
- for manual startup without colors:
```
java -jar XDDOS.jar [ip] [protocol] [method] [time] [cps] [y/n] -noansi
```

#### NOTE! :-
**y/n** is optional. Use `y` if you want to scrape proxy from links in urls.txt and **n** to use your own proxies from proxies.txt 

## Example Attack Commands  

- To run botjoiner for 10 seconds with 1000 cps and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 1000 y
```

- To run botjoiner for 10 seconds with 1000 cps and use your own proxy:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 1000 n
```

- To run botjoiner for 10 seconds with MAX POWER or CPS and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 -1 y
```


## Methods avilable

- Aegis
- BigHandshake
- BigPacket
- BotJoiner
- BotRiad
- BungeeDowner
- ChatSpam
- ColorCrasher
- CpuDowner
- DoubleJoin
- EmptyNames
- EmptyPacket
- ExtremeJoin
- ExtremeKiller
- Handshake
- InstantDowner
- InvalidData
- InvalidNames
- InvalidSpoof
- IpSpooffFlood
- Join
- LegacyPing
- LegitnameJoin
- LocalHost
- LongHost
- LongNames
- Memory
- MOTD
- nAntiBot
- NettyDowner
- Network
- NewNullping
- NullPing
- Ping
- PingJoin
- Query
- Queue
- QuitExceptions
- RAM
- RandomExceptions
- RandomPacket
- ServerFucker
- Slapper
- SmartBot
- Spoof
- TCPBypass
- TCPHit
- UltimateKiller
- UltimateSmasher
- UnexpectedPacket
- uuidCrash
- WaterfallBypass
- XDJoin
- XDSpam


## FAQ:
### The colours are bugged
Use -noansi at the end of the command or try using another terminal like Windows Terminal

### XDDOS has a discord?
Yes. You can join [here](https://discord.gg/U3TN8SPgvz)

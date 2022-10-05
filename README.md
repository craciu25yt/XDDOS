![alt text](https://cdn.discordapp.com/attachments/949290845222350928/964583278789148763/cover.png)
#                  TEAMXD Discord - https://discord.gg/4DQnbEnv87

## XDDOS is a tool to stress test your minecraft server.

## Features avilable

XDDOS has the following features:

- `54` different attack methods
- `proxy scraper` (just put the links to scrape proxy from in urls.txt)
- `user friendly CLI` dont worry about hard to remeber startup commands
- also supports startup commands 
- auto ip resolver you can use domain names or ip addresses
- chat spam bots
- many bypasses
- now supports both colored and plain mode just use -noansi as argument

## How to use XDDOS

CPS is Connection per second. Use -1 as cps to use max power

To get protocols go to https://wiki.vg/Protocol_version_numbers and see Version number

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

(y/n is optional y if you want to use auto proxy generator and n to use your own proxy) (IMPORTANT - if u are using n it will use proxies.txt as proxy file)

### example:  

- To run botjoiner for 10 seconds with 10 cps and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 10 y
```

- To run botjoiner for 10 seconds with 10 cps and use your own proxy:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 10 n
```

- To run botjoiner for 10 seconds with MAX POWER or CPS and use auto proxy generator:
```
java -jar XDDOS.jar localhost:25565 47 botjoiner 10 -1 y
```

- To use user friendly CLI:
```
java -jar XDDOS.jar
```

## Methods avilable

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
- nabCry
- NettyDowner
- Network
- NullPing 2.0//newnullping
- NullPing
- Ping
- PingJoin
- Query
- Queue
- QuitExceptions
- RAM
- RandomExceptions
- RandomPacket
- ServerFucker//this is sf
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
- xDSpam
- YooniksCry

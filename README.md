![alt text](https://cdn.discordapp.com/attachments/949290845222350928/964583278789148763/cover.png)
#                  TEAMXD Discord - https://discord.gg/4DQnbEnv87

## XDDOS is a tool to stress test your minecraft server.

## Features avilable

XDDOS has the following features:

- `54` different attack methods
- `auto proxy generator` so you dont have to worry about proxies
- `user friendly CLI` dont worry about hard to remeber startup commands
- also supports startup commands 
- auto ip resolver you can use domain names or ip addresses
- chat spam bots
- many bypasses

## How to use XDDOS

CPS is Connection per second. Use -1 as cps to use max power

To get protocols go to https://wiki.vg/Protocol_version_numbers and see Version number

### Startup Command: 

- For user friendly CLI/auto mode:
```
java -jar XDDOS.jar
```

- for manual startup:
```
java -jar XDDOS.jar [ip] [protocol] [method] [time] [cps] [y/n]
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

## Credits:-
Sorry i forgot to give credits before
I used MCBot as base and and some methods of MCSTORM 
I made this project to just improve me skills in java and have some fun
i am not pro dev so ya i used base and try to understand how its done after getting a good understanding
i did some tweaks in some part of code and added somethings of my own and released it public
```and not sell it like MiniFlex who just straight up coppy MCSTROM and was selling it```

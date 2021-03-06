package online.fivem.common.gtav

// https://www.se7ensins.com/forums/threads/ref-gta-v-vehicle-hashes-list-2.1615439/

enum class NativeVehicle(val hash: Int, val category: Category) {
	//NAME HEX uint32 int32 CATEGORY DESC UPDATE NAME HEX2 NAME HEX uint32 int32 CATEGORY DESC UPDATE NAME PRICE1 PRICE2 HIGH_PRICE
	BLIMP3(-307958377, Category.AFTER),
	FREECRAWLER(-54332285, Category.AFTER),
	MENACER(2044532910, Category.AFTER),
	MULE4(1945374990, Category.AFTER),
	OPPRESSOR2(2069146067, Category.AFTER),
	PATRIOT2(-420911112, Category.AFTER),
	PBUS2(345756458, Category.AFTER),
	POUNDER2(1653666139, Category.AFTER),
	SCRAMJET(-638562243, Category.AFTER),
	SPEEDO4(219613597, Category.AFTER),
	STAFFORD(321186144, Category.AFTER),
	STRIKEFORCE(1692272545, Category.AFTER),
	SWINGER(500482303, Category.AFTER),
	TERBYTE(-1988428699, Category.AFTER),

	//NAME HEX uint32 int32 CATEGORY DESC UPDATE NAME PRICE1 PRICE2 HIGH_PRICE
	ADDER(-1216765807, Category.SUPER),
	AIRBUS(1283517198, Category.SERVICE), //(Airport Bus)
	AIRTUG(1560980623, Category.SERVICE),
	AKULA(1181327175, Category.HELICOPTER),
	AKUMA(1672195559, Category.MOTORCYCLE),
	ALPHA(767087018, Category.SPORT),
	ALPHAZ1(-1523619738, Category.PLANE),
	AMBULANCE(1171614426, Category.EMERGENCY),
	ANNIHILATOR(837858166, Category.HELICOPTER),
	APC(562680400, Category.MILITARY),
	ARDENT(159274291, Category.SPORTS_CLASSIC),
	ARMYTANKER(-1207431159, Category.TRAILER),
	ARMYTRAILER(-1476447243, Category.TRAILER), //(Army Flatbed Trailer)
	ARMYTRAILER2(-1637149482, Category.TRAILER), //(Flatbed With Cutter Trailer)
	ASEA(-1809822327, Category.SEDAN),
	ASEA2(-1807623979, Category.SEDAN), //(Snowy Asea)
	ASTEROPE(-1903012613, Category.SEDAN),
	AUTARCH(-313185164, Category.SUPER),
	AVARUS(-2115793025, Category.MOTORCYCLE),
	AVENGER(-2118308144, Category.PLANE),
	AVENGER2(408970549, Category.PLANE),
	BAGGER(-2140431165, Category.MOTORCYCLE),
	BALETRAILER(-399841706, Category.TRAILER),
	BALLER(-808831384, Category.SUV),
	BALLER2(142944341, Category.SUV), //(RangeRover Evoque)
	BALLER3(1878062887, Category.SUV), //(Baller LE)
	BALLER4(634118882, Category.SUV), //(Baller LE LWB)
	BALLER5(470404958, Category.SUV), //(Baller LE (Armored)
	BALLER6(666166960, Category.SUV), //(Baller LE LWB (Armored)
	BANSHEE(-1041692462, Category.SPORT),
	BANSHEE2(633712403, Category.SUPER), //(Banshee 900R)
	BARRACKS(-823509173, Category.EMERGENCY), //(Barracks With Backcover)
	BARRACKS2(1074326203, Category.EMERGENCY), //(Barracks Semi)
	BARRACKS3(630371791, Category.EMERGENCY), //(Dark Camo and New Cover)
	BARRAGE(-212993243, Category.MILITARY),
	BATI(-114291515, Category.MOTORCYCLE),
	BATI2(-891462355, Category.MOTORCYCLE), //(Bati Livery)
	BENSON(2053223216, Category.TRUCK),
	BESRA(1824333165, Category.PLANE),
	BESTIAGTS(1274868363, Category.SPORT),
	BF400(86520421, Category.MOTORCYCLE),
	BFINJECTION(1126868326, Category.OFFROAD),
	BIFF(850991848, Category.TRUCK),
	BIFTA(-349601129, Category.OFFROAD),
	BISON(-16948145, Category.PICKUP),
	BISON2(2072156101, Category.PICKUP), //(Cowboy Construction Bison)
	BISON3(1739845664, Category.PICKUP), //(Landscapeing Bison)
	BJXL(850565707, Category.SUV),
	BLADE(-1205801634, Category.MUSCLE),
	BLAZER(-2128233223, Category.OFFROAD),
	BLAZER2(-48031959, Category.OFFROAD), //(Lifeguard Blazer)
	BLAZER3(-1269889662, Category.OFFROAD), //(Trevor's Hotrod Blazer)
	BLAZER4(-440768424, Category.OFFROAD), //(Street Blazer)
	BLAZER5(-1590337689, Category.OFFROAD), //(Blazer Aqua)
	BLIMP(-150975354, Category.HELICOPTER),
	BLIMP2(-613725916, Category.HELICOPTER), //(Xero Blimp)
	BLISTA(-344943009, Category.COMPACT),
	BLISTA2(1039032026, Category.SPORT), //(Blista Compact)
	BLISTA3(-591651781, Category.SPORT), //(Go Go Monkey Blista)
	BMX(1131912276, Category.BICYCLE),
	BOATTRAILER(524108981, Category.TRAILER), //(Boat Trailer)
	BOBCATXL(1069929536, Category.PICKUP),
	BODHI2(-1435919434, Category.OFFROAD), //(Trevor's Truck)
	BOMBUSHKA(-32878452, Category.PLANE),
	BOXVILLE(-1987130134, Category.TRUCK), //(Water&Power Boxville)
	BOXVILLE2(-233098306, Category.TRUCK), //(Postal Boxville)
	BOXVILLE3(121658888, Category.TRUCK), //(Humane Boxville)
	BOXVILLE4(444171386, Category.TRUCK), //(Post OP)
	BOXVILLE5(682434785, Category.TRUCK), //(Armored Boxville)
	BRAWLER(-1479664699, Category.OFFROAD),
	BRICKADE(-305727417, Category.SERVICE),
	BRIOSO(1549126457, Category.COMPACT), //(Brioso R/A)
	BTYPE(117401876, Category.SPORTS_CLASSIC), //(Roosevelt)
	BTYPE2(-831834716, Category.MUSCLE), //(Fränken Stange)
	BTYPE3(-602287871, Category.SPORTS_CLASSIC), //(Roosevelt Valor)
	BUCCANEER(-682211828, Category.MUSCLE),
	BUCCANEER2(-1013450936, Category.MUSCLE), //(Buccaneer Custom)
	BUFFALO(-304802106, Category.SPORT),
	BUFFALO2(736902334, Category.SPORT), //(Franklin's Buffalo)
	BUFFALO3(237764926, Category.SPORT), //(Sprunk Buffalo)
	BULLDOZER(1886712733, Category.SERVICE),
	BULLET(-1696146015, Category.SUPER),
	BURRITO(-1346687836, Category.VAN), //(Cowboy Cons/Water&Power)
	BURRITO2(-907477130, Category.VAN), //(Bugstars Burrito)
	BURRITO3(-1743316013, Category.VAN), //(No livery Burrito)
	BURRITO4(893081117, Category.VAN), //(Cowboy Construction Burrito)
	BURRITO5(1132262048, Category.VAN), //(Snowy Burrito)
	BUS(-713569950, Category.SERVICE),
	BUZZARD(788747387, Category.HELICOPTER),
	BUZZARD2(745926877, Category.HELICOPTER), //(Gunless / Transport Buzzard)
	CABLECAR(-960289747, Category.SERVICE),
	CADDY(1147287684, Category.SERVICE), //(Prolaps Caddy)
	CADDY2(-537896628, Category.SERVICE), //(Old Caddy)
	CADDY3(-769147461, Category.UTILITY),
	CAMPER(1876516712, Category.VAN),
	CARACARA(1254014755, Category.OFFROAD),
	CARBONIZZARE(2072687711, Category.SPORT),
	CARBONRS(11251904, Category.MOTORCYCLE),
	CARGOBOB(-50547061, Category.HELICOPTER),
	CARGOBOB2(1621617168, Category.HELICOPTER), //(Medical Cargobob)
	CARGOBOB3(1394036463, Category.HELICOPTER), //(Trevor's Cargobob)
	CARGOBOB4(2025593404, Category.HELICOPTER), //(Yacht Cargobob)
	CARGOPLANE(368211810, Category.PLANE),
	CASCO(941800958, Category.SPORTS_CLASSIC),
	CAVALCADE(2006918058, Category.SUV), //(Escalade 2005)
	CAVALCADE2(-789894171, Category.SUV), //(Escalade 2013)
	CHEBUREK(-988501280, Category.SPORTS_CLASSIC),
	CHEETAH(-1311154784, Category.SUPER),
	CHEETAH2(223240013, Category.SPORTS_CLASSIC),
	CHERNOBOG(-692292317, Category.MILITARY),
	CHIMERA(6774487, Category.MOTORCYCLE),
	CHINO(349605904, Category.MUSCLE),
	CHINO2(-1361687965, Category.MUSCLE), //(Chino Custom)
	CLIFFHANGER(390201602, Category.MOTORCYCLE),
	COACH(-2072933068, Category.SERVICE), //(Dashound)
	COG55(906642318, Category.SEDAN), //(Cognoscenti 55)
	COG552(704435172, Category.SEDAN), //(Cognoscenti 55 (Armored)
	COGCABRIO(330661258, Category.COUPE),
	COGNOSCENTI(-2030171296, Category.SEDAN),
	COGNOSCENTI2(-604842630, Category.SEDAN), //(Cognoscenti (Armored)
	COMET2(-1045541610, Category.SPORT),
	COMET3(-2022483795, Category.SPORT), //(Comet Retro Custom)
	COMET4(1561920505, Category.SPORT),
	COMET5(661493923, Category.SPORT),
	CONTENDER(683047626, Category.PICKUP),
	COQUETTE(108773431, Category.SPORT),
	COQUETTE2(1011753235, Category.SPORTS_CLASSIC), //(Coquette Classic)
	COQUETTE3(784565758, Category.SPORTS_CLASSIC), //(Blackfin)
	CRUISER(448402357, Category.BICYCLE),
	CRUSADER(321739290, Category.EMERGENCY),
	CUBAN800(-644710429, Category.PLANE),
	CUTTER(-1006919392, Category.TRUCK),
	CYCLONE(1392481335, Category.SUPER),
	DAEMON(2006142190, Category.MOTORCYCLE),
	DAEMON2(-1404136503, Category.MOTORCYCLE),
	DEFILER(822018448, Category.MOTORCYCLE),
	DELUXO(1483171323, Category.SPORTS_CLASSIC),
	DIABLOUS(-239841468, Category.MOTORCYCLE),
	DIABLOUS2(1790834270, Category.MOTORCYCLE), //(Diabolus Custom)
	DILETTANTE(-1130810103, Category.COMPACT),
	DILETTANTE2(1682114128, Category.COMPACT), //(Merryweather Patrol Car)
	DINGHY(1033245328, Category.BOAT),
	DINGHY2(276773164, Category.BOAT), //(2-Seater)
	DINGHY3(509498602, Category.BOAT), //(New Map On Dash)
	DINGHY4(867467158, Category.BOAT), //(Yacht Dinghy)
	DLOADER(1770332643, Category.OFFROAD),
	DOCKTRAILER(-2140210194, Category.TRAILER), //(Shipping Container Trailer)
	DOCKTUG(-884690486, Category.TRUCK),
	DODO(-901163259, Category.PLANE),
	DOMINATOR(80636076, Category.MUSCLE),
	DOMINATOR2(-915704871, Category.MUSCLE), //(Pisswasser Dominator)
	DOMINATOR3(-986944621, Category.MUSCLE),
	DOUBLE(-1670998136, Category.MOTORCYCLE),
	DUBSTA(1177543287, Category.SUV),
	DUBSTA2(-394074634, Category.SUV), //(Blacked Out Dubsta)
	DUBSTA3(-1237253773, Category.OFFROAD), //(Dubsta 6x6)
	DUKES(723973206, Category.MUSCLE),
	DUKES2(-326143852, Category.MUSCLE), //(Duke O'Death)
	DUMP(-2130482718, Category.TRUCK),
	DUNE(-1661854193, Category.OFFROAD),
	DUNE2(534258863, Category.OFFROAD), //(Spacedocker)
	DUNE3(1897744184, Category.OFFROAD),
	DUNE4(-827162039, Category.OFFROAD), //(Ramp Buggy Custom)
	DUNE5(-312295511, Category.OFFROAD), //(Ramp Buggy)
	DUSTER(970356638, Category.PLANE),
	ELEGY(196747873, Category.SPORT),
	ELEGY2(-566387422, Category.SPORT),
	ELLIE(-1267543371, Category.MUSCLE),
	EMPEROR(-685276541, Category.SEDAN),
	EMPEROR2(-1883002148, Category.SEDAN), //(Rusty Emperor)
	EMPEROR3(-1241712818, Category.SEDAN), //(Snowy Emperor)
	ENDURO(1753414259, Category.MOTORCYCLE),
	ENTITY2(-2120700196, Category.SUPER),
	ENTITYXF(-1291952903, Category.SUPER),
	ESSKEY(2035069708, Category.MOTORCYCLE),
	EXEMPLAR(-5153954, Category.COUPE),
	F620(-591610296, Category.COUPE),
	FACTION(-2119578145, Category.COUPE),
	FACTION2(-1790546981, Category.COUPE), //(Faction Custom)
	FACTION3(-2039755226, Category.MUSCLE), //(Faction Custom Donk)
	FAGALOA(1617472902, Category.SPORTS_CLASSIC),
	FAGGIO(-1842748181, Category.MOTORCYCLE),
	FAGGIO2(55628203, Category.MOTORCYCLE),
	FAGGIO3(-1289178744, Category.MOTORCYCLE), //(Faggio Mod)
	FAGGION(2134395284, Category.MOTORCYCLE),
	FBI(1127131465, Category.EMERGENCY), //(FIB Buffalo)
	FBI2(-1647941228, Category.EMERGENCY), //(FIB Granger)
	FCR(627535535, Category.MOTORCYCLE), //(FCR 1000)
	FCR2(-757735410, Category.MOTORCYCLE), //(FCR 1000 Custom)
	FELON(-391594584, Category.COUPE),
	FELON2(-89291282, Category.COUPE), //(Felon GT Convertible)
	FELTZER2(-1995326987, Category.SPORT),
	FELTZER3(-1566741232, Category.SPORTS_CLASSIC), //(Stirling GT)
	FIRETRUK(1938952078, Category.EMERGENCY),
	FIXTER(-836512833, Category.BICYCLE),
	FLASHGT(-1259134696, Category.SPORT),
	FLATBED(1353720154, Category.TRUCK),
	FMJ(1426219628, Category.SUPER),
	FORKLIFT(1491375716, Category.SERVICE),
	FQ2(-1137532101, Category.SUV),
	FREIGHT(1030400667, Category.TRAIN), //(Freight Train)
	FREIGHTCAR(184361638, Category.TRAIN), //(Train Well Car)
	FREIGHTCONT1(920453016, Category.TRAIN), //(Train Container)
	FREIGHTCONT2(240201337, Category.TRAIN), //(Train Container Livery)
	FREIGHTGRAIN(642617954, Category.TRAIN), //(Train Boxcar)
	FREIGHTTRAILER(-777275802, Category.TRAILER), //(Freight Train Flatbed)
	FROGGER(744705981, Category.HELICOPTER),
	FROGGER2(1949211328, Category.HELICOPTER), //(Trevor's Frogger)
	FUGITIVE(1909141499, Category.SEDAN),
	FUROREGT(-1089039904, Category.SPORT),
	FUSILADE(499169875, Category.SPORT),
	FUTO(2016857647, Category.SPORT),
	GARGOYLE(741090084, Category.MOTORCYCLE),
	GAUNTLET(-1800170043, Category.MUSCLE),
	GAUNTLET2(349315417, Category.MUSCLE), //(Redwood Gauntlet)
	GB200(1909189272, Category.SPORT),
	GBURRITO(-1745203402, Category.VAN),
	GBURRITO2(296357396, Category.VAN), //(No Livery)
	GLENDALE(75131841, Category.SEDAN),
	GP1(1234311532, Category.SUPER),
	GRAINTRAILER(1019737494, Category.TRAILER),
	GRANGER(-1775728740, Category.SUV),
	GRESLEY(-1543762099, Category.SUV),
	GT500(-2079788230, Category.SPORTS_CLASSIC),
	GUARDIAN(-2107990196, Category.OFFROAD),
	HABANERO(884422927, Category.SUV),
	HAKUCHOU(1265391242, Category.MOTORCYCLE),
	HAKUCHOU2(-255678177, Category.MOTORCYCLE), //(Hakuchou Drag)
	HALFTRACK(-32236122, Category.MILITARY),
	HANDLER(444583674, Category.TRUCK),
	HAULER(1518533038, Category.TRUCK),
	HAULER2(387748548, Category.COMMERCIAL),
	HAVOK(-1984275979, Category.HELICOPTER),
	HERMES(15219735, Category.MUSCLE),
	HEXER(301427732, Category.MOTORCYCLE),
	HOTKNIFE(37348240, Category.MUSCLE),
	HOTRING(1115909093, Category.SPORT),
	HOWARD(-1007528109, Category.PLANE),
	HUNTER(-42959138, Category.HELICOPTER),
	HUNTLEY(486987393, Category.SUV),
	HUSTLER(600450546, Category.MUSCLE),
	HYDRA(970385471, Category.PLANE),
	INFERNUS(418536135, Category.SUPER),
	INFERNUS2(-1405937764, Category.SPORT), //(Infernus Classic)
	INGOT(-1289722222, Category.SEDAN),
	INNOVATION(-159126838, Category.MOTORCYCLE),
	INSURGENT(-1860900134, Category.OFFROAD), //(Mounted Gun)
	INSURGENT2(2071877360, Category.OFFROAD), //(Transport)
	INSURGENT3(-1924433270, Category.OFFROAD),
	INTRUDER(886934177, Category.SEDAN),
	ISSI2(-1177863319, Category.COMPACT), //(Issi Convertible)
	ISSI3(931280609, Category.COMPACT),
	ITALIGTB(-2048333973, Category.SUPER),
	ITALIGTB2(-482719877, Category.SUPER), //(Itali GTB Custom)
	JACKAL(-624529134, Category.COUPE),
	JB700(1051415893, Category.SPORTS_CLASSIC),
	JESTER(-1297672541, Category.SPORT),
	JESTER2(-1106353882, Category.SPORT), //(Rester Race)
	JESTER3(-214906006, Category.SPORTS_CLASSIC),
	JET(1058115860, Category.PLANE),
	JETMAX(861409633, Category.BOAT),
	JOURNEY(-120287622, Category.VAN),
	KALAHARI(92612664, Category.OFFROAD),
	KAMACHO(-121446169, Category.OFFROAD),
	KHAMELION(544021352, Category.SPORT),
	KHANJALI(-1435527158, Category.MILITARY),
	KURUMA(-1372848492, Category.SPORT),
	KURUMA2(410882957, Category.SPORT), //(Armored)
	LANDSTALKER(1269098716, Category.SUV),
	LAZER(-1281684762, Category.PLANE),
	LE7B(-1232836011, Category.SUPER), //(RE-7B)
	LECTRO(640818791, Category.MOTORCYCLE),
	LGUARD(469291905, Category.EMERGENCY),
	LIMO2(-114627507, Category.SEDAN), //(Turreted Limo)
	LURCHER(2068293287, Category.SPORTS_CLASSIC), //(Zombie Hearse)
	LUXOR(621481054, Category.PLANE),
	LUXOR2(-1214293858, Category.PLANE), //(Gold)
	LYNX(482197771, Category.SPORT),
	MAMBA(-1660945322, Category.SPORT),
	MAMMATUS(-1746576111, Category.PLANE),
	MANANA(-2124201592, Category.SPORTS_CLASSIC),
	MANCHEZ(-1523428744, Category.MOTORCYCLE),
	MARQUIS(-1043459709, Category.BOAT),
	MARSHALL(1233534620, Category.OFFROAD),
	MASSACRO(-142942670, Category.SPORT),
	MASSACRO2(-631760477, Category.SPORT), //(Massacaro Race)
	MAVERICK(-1660661558, Category.HELICOPTER),
	MESA(914654722, Category.SUV),
	MESA2(-748008636, Category.SUV), //(Snowy Mesa)
	MESA3(-2064372143, Category.OFFROAD), //(Merryweather Mesa)
	METROTRAIN(868868440, Category.TRAIN),
	MICHELLI(1046206681, Category.SPORTS_CLASSIC),
	MICROLIGHT(-1763555241, Category.PLANE),
	MILJET(165154707, Category.PLANE),
	MINIVAN(-310465116, Category.VAN),
	MINIVAN2(-1126264336, Category.MUSCLE), //(Minivan Custom)
	MIXER(-784816453, Category.TRUCK),
	MIXER2(475220373, Category.TRUCK), //(Wheels On Back)
	MOGUL(-749299473, Category.PLANE),
	MOLOTOK(1565978651, Category.PLANE),
	MONROE(-433375717, Category.SPORTS_CLASSIC),
	MONSTER(-845961253, Category.OFFROAD), //(The Liberator)
	MOONBEAM(525509695, Category.VAN),
	MOONBEAM2(1896491931, Category.VAN), //(Moonbeam Custom)
	MOWER(1783355638, Category.SERVICE),
	MULE(904750859, Category.TRUCK),
	MULE2(-1050465301, Category.TRUCK), //(Drop Down Trunk)
	MULE3(-2052737935, Category.TRUCK), //(No Livery)
	NEMESIS(-634879114, Category.MOTORCYCLE),
	NEON(-1848994066, Category.SPORT),
	NERO(1034187331, Category.SUPER),
	NERO2(1093792632, Category.SUPER), //(Nero Custom)
	NIGHTBLADE(-1606187161, Category.MOTORCYCLE),
	NIGHTSHADE(-1943285540, Category.MUSCLE),
	NIGHTSHARK(433954513, Category.OFFROAD),
	NIMBUS(-1295027632, Category.PLANE),
	NINEF(1032823388, Category.SPORT),
	NINEF2(-1461482751, Category.SPORT), //(Ninef Convertible)
	NOKOTA(1036591958, Category.PLANE),
	OMNIS(-777172681, Category.SPORT),
	OPPRESSOR(884483972, Category.MOTORCYCLE),
	ORACLE(1348744438, Category.SEDAN), //(GTA IV Oracle)
	ORACLE2(-511601230, Category.SEDAN), //(Oracle XS)
	OSIRIS(1987142870, Category.SUPER),
	PACKER(569305213, Category.TRUCK),
	PANTO(-431692672, Category.COMPACT),
	PARADISE(1488164764, Category.VAN),
	PARIAH(867799010, Category.SPORT),
	PATRIOT(-808457413, Category.SUV),
	PBUS(-2007026063, Category.EMERGENCY), //(Prison Bus)
	PCJ(-909201658, Category.MOTORCYCLE),
	PENETRATOR(-1758137366, Category.SUPER),
	PENUMBRA(-377465520, Category.SPORT),
	PEYOTE(1830407356, Category.SPORTS_CLASSIC),
	PFISTER811(-1829802492, Category.SUPER),
	PHANTOM(-2137348917, Category.TRUCK),
	PHANTOM2(-1649536104, Category.TRUCK), //(Phantom Wedge)
	PHANTOM3(177270108, Category.COMMERCIAL),
	PHOENIX(-2095439403, Category.MUSCLE),
	PICADOR(1507916787, Category.MUSCLE),
	PIGALLE(1078682497, Category.SPORTS_CLASSIC),
	POLICE(2046537925, Category.EMERGENCY), //(Police Stanier)
	POLICE2(-1627000575, Category.EMERGENCY), //(Police Buffalo)
	POLICE3(1912215274, Category.EMERGENCY), //(Police Interceptor)
	POLICE4(-1973172295, Category.EMERGENCY), //(Undercover Police Stanier)
	POLICEB(-34623805, Category.EMERGENCY), //(Police Bike)
	POLICEOLD1(-1536924937, Category.EMERGENCY), //(Snowy Police Rancher)
	POLICEOLD2(-1779120616, Category.EMERGENCY), //(Snowy Police Esperanto)
	POLICET(456714581, Category.EMERGENCY), //(Police Transport Van)
	POLMAV(353883353, Category.HELICOPTER),
	PONY(-119658072, Category.VAN), //(Sunset Bleach...)
	PONY2(943752001, Category.VAN), //(Weed Van)
	POUNDER(2112052861, Category.TRUCK),
	PRAIRIE(-1450650718, Category.COMPACT),
	PRANGER(741586030, Category.EMERGENCY),
	PREDATOR(-488123221, Category.BOAT),
	PREMIER(-1883869285, Category.SEDAN),
	PRIMO(-1150599089, Category.SEDAN),
	PRIMO2(-2040426790, Category.SEDAN), //(Primo Custom)
	PROPTRAILER(356391690, Category.TRAILER), //(Mobile Home Trailer)
	PROTOTIPO(2123327359, Category.SUPER), //(X80 Proto)
	PYRO(-1386191424, Category.PLANE),
	RADI(-1651067813, Category.SUV),
	RAIDEN(-1529242755, Category.SPORT),
	RAKETRAILER(390902130, Category.TRAILER), //(Farm Cultivator)
	RALLYTRUCK(-2103821244, Category.TRUCK), //(Dune)
	RANCHERXL(1645267888, Category.OFFROAD),
	RANCHERXL2(1933662059, Category.OFFROAD), //(Snowy Rancher)
	RAPIDGT(-1934452204, Category.SPORT),
	RAPIDGT2(1737773231, Category.SPORT), //(Rapid GT Convertible)
	RAPIDGT3(2049897956, Category.SPORTS_CLASSIC),
	RAPTOR(-674927303, Category.SPORT),
	RATBIKE(1873600305, Category.MOTORCYCLE),
	RATLOADER(-667151410, Category.PICKUP),
	RATLOADER2(-589178377, Category.PICKUP), //(Rat Truck)
	REAPER(234062309, Category.SUPER),
	REBEL(-1207771834, Category.OFFROAD), //(Rusty Rebel)
	REBEL2(-2045594037, Category.OFFROAD), //(Clean Rebel)
	REGINA(-14495224, Category.SEDAN),
	RENTALBUS(-1098802077, Category.SERVICE),
	RETINUE(1841130506, Category.SPORTS_CLASSIC),
	REVOLTER(-410205223, Category.SPORT),
	RHAPSODY(841808271, Category.COMPACT),
	RHINO(782665360, Category.EMERGENCY),
	RIATA(-1532697517, Category.OFFROAD),
	RIOT(-1205689942, Category.EMERGENCY),
	RIOT2(-1693015116, Category.EMERGENCY),
	RIPLEY(-845979911, Category.SERVICE),
	ROCOTO(2136773105, Category.SUV),
	ROGUE(-975345305, Category.PLANE),
	ROMERO(627094268, Category.SEDAN),
	RUBBLE(-1705304628, Category.TRUCK),
	RUFFIAN(-893578776, Category.MOTORCYCLE),
	RUINER(-227741703, Category.MUSCLE),
	RUINER2(941494461, Category.SPORT), //(Ruiner 2000)
	RUINER3(777714999, Category.SPORT), //(Destroyed)
	RUMPO(1162065741, Category.VAN), //(Weazel News Rumpo)
	RUMPO2(-1776615689, Category.VAN), //(Deludamol Rumpo)
	RUMPO3(1475773103, Category.VAN), //(Rumpo Custom)
	RUSTON(719660200, Category.SPORT),
	SABREGT(-1685021548, Category.MUSCLE),
	SABREGT2(223258115, Category.MUSCLE), //(Sabre Turbo Custom)
	SADLER(-599568815, Category.PICKUP),
	SADLER2(734217681, Category.PICKUP), //(Snowy Sadler)
	SANCHEZ(788045382, Category.MOTORCYCLE), //(Sanchez Livery)
	SANCHEZ2(-1453280962, Category.MOTORCYCLE), //(Sanchez Paint)
	SANCTUS(1491277511, Category.MOTORCYCLE),
	SANDKING(-1189015600, Category.OFFROAD), //(Sandking 4-Seater)
	SANDKING2(989381445, Category.OFFROAD), //(Sandking 2-Seater)
	SAVAGE(-82626025, Category.HELICOPTER),
	SAVESTRA(903794909, Category.SPORTS_CLASSIC),
	SC1(1352136073, Category.SUPER),
	SCHAFTER2(-1255452397, Category.SEDAN),
	SCHAFTER3(-1485523546, Category.SEDAN), //(Schafter V12)
	SCHAFTER4(1489967196, Category.SEDAN), //(Schafter LWB)
	SCHAFTER5(-888242983, Category.SEDAN), //(Schafter V12 (Armored)
	SCHAFTER6(1922255844, Category.SEDAN), //(Schafter LWB (Armored)
	SCHWARZER(-746882698, Category.SPORT),
	SCORCHER(-186537451, Category.BICYCLE),
	SCRAP(-1700801569, Category.TRUCK),
	SEABREEZE(-392675425, Category.PLANE),
	SEASHARK(-1030275036, Category.BOAT), //(Speedophile Seashark)
	SEASHARK2(-616331036, Category.BOAT), //(Lifeguard Seashark)
	SEASHARK3(-311022263, Category.BOAT), //(Yacht Seashark)
	SEASPARROW(-726768679, Category.HELICOPTER),
	SEMINOLE(1221512915, Category.SUV),
	SENTINEL(1349725314, Category.COUPE), //(Sentinel XS)
	SENTINEL2(873639469, Category.COUPE), //(Sentinel Convertible)
	SENTINEL3(1104234922, Category.SPORT),
	SERRANO(1337041428, Category.SUV),
	SEVEN70(-1757836725, Category.SPORT),
	SHAMAL(-1214505995, Category.PLANE),
	SHEAVA(819197656, Category.SUPER), //(ETR1)
	SHERIFF(-1683328900, Category.EMERGENCY), //(Sheriff Stanier)
	SHERIFF2(1922257928, Category.EMERGENCY), //(Sheriff Granger)
	SHOTARO(-405626514, Category.MOTORCYCLE),
	SKYLIFT(1044954915, Category.HELICOPTER),
	SLAMVAN(729783779, Category.MUSCLE),
	SLAMVAN2(833469436, Category.MUSCLE), //(Lost Slamvan)
	SLAMVAN3(1119641113, Category.MUSCLE), //(Slamvan Custom)
	SOVEREIGN(743478836, Category.MOTORCYCLE),
	SPECTER(1886268224, Category.SPORT),
	SPECTER2(1074745671, Category.SPORT), //(Specter Custom)
	SPEEDER(231083307, Category.BOAT),
	SPEEDER2(437538602, Category.BOAT), //(Yacht Speeder)
	SPEEDO(-810318068, Category.VAN),
	SPEEDO2(728614474, Category.VAN), //(Clown Van)
	SQUALO(400514754, Category.BOAT),
	STALION(1923400478, Category.MUSCLE),
	STALION2(-401643538, Category.MUSCLE), //(Burger Shot Stallion)
	STANIER(-1477580979, Category.SEDAN),
	STARLING(-1700874274, Category.PLANE),
	STINGER(1545842587, Category.SPORTS_CLASSIC),
	STINGERGT(-2098947590, Category.SPORTS_CLASSIC),
	STOCKADE(1747439474, Category.TRUCK),
	STOCKADE3(-214455498, Category.TRUCK), //(Snowy Stockade)
	STRATUM(1723137093, Category.SEDAN),
	STREITER(1741861769, Category.SPORT),
	STRETCH(-1961627517, Category.SEDAN),
	STROMBERG(886810209, Category.SPORTS_CLASSIC),
	STUNT(-2122757008, Category.PLANE),
	SUBMERSIBLE(771711535, Category.BOAT),
	SUBMERSIBLE2(-1066334226, Category.BOAT), //(Kraken)
	SULTAN(970598228, Category.SPORT),
	SULTANRS(-295689028, Category.SUPER),
	SUNTRAP(-282946103, Category.BOAT),
	SUPERD(1123216662, Category.SEDAN),
	SUPERVOLITO(710198397, Category.HELICOPTER),
	SUPERVOLITO2(-1671539132, Category.HELICOPTER), //(SuperVolito Carbon)
	SURANO(384071873, Category.SPORT),
	SURFER(699456151, Category.VAN),
	SURFER2(-1311240698, Category.VAN), //(Rusty Surfer)
	SURGE(-1894894188, Category.SEDAN),
	SWIFT(-339587598, Category.HELICOPTER),
	SWIFT2(1075432268, Category.HELICOPTER), //(Gold)
	T20(1663218586, Category.SUPER),
	TACO(1951180813, Category.VAN),
	TAILGATER(-1008861746, Category.SEDAN),
	TAIPAN(-1134706562, Category.SUPER),
	TAMPA(972671128, Category.MUSCLE),
	TAMPA2(-1071380347, Category.MUSCLE), //(Drift Tampa)
	TAMPA3(-1210451983, Category.MUSCLE),
	TANKER(-730904777, Category.TRAILER),
	TANKER2(1956216962, Category.TRAILER), //(No Livery)
	TANKERCAR(586013744, Category.TRAIN), //(Train Fuel Tank Car)
	TAXI(-956048545, Category.SEDAN),
	TECHNICAL(-2096818938, Category.OFFROAD),
	TECHNICAL2(1180875963, Category.OFFROAD), //(Technical Aqua)
	TECHNICAL3(1356124575, Category.OFFROAD),
	TEMPESTA(272929391, Category.SUPER),
	TEZERACT(1031562256, Category.SUPER),
	THRUST(1836027715, Category.MOTORCYCLE),
	THRUSTER(1489874736, Category.MILITARY),
	TIPTRUCK(48339065, Category.TRUCK), //(6-Wheeler)
	TIPTRUCK2(-947761570, Category.TRUCK), //(10-Wheeler)
	TITAN(1981688531, Category.PLANE),
	TORERO(1504306544, Category.SPORTS_CLASSIC),
	TORNADO(464687292, Category.SPORTS_CLASSIC),
	TORNADO2(1531094468, Category.SPORTS_CLASSIC), //(Convertible)
	TORNADO3(1762279763, Category.SPORTS_CLASSIC), //(Rusty)
	TORNADO4(-2033222435, Category.SPORTS_CLASSIC), //(Mariachi)
	TORNADO5(-1797613329, Category.MUSCLE), //(Custom)
	TORNADO6(-1558399629, Category.MUSCLE), //(Rat Rod)
	TORO(1070967343, Category.BOAT),
	TORO2(908897389, Category.BOAT), //(Yacht Toro)
	TOURBUS(1941029835, Category.SERVICE),
	TOWTRUCK(-1323100960, Category.TRUCK), //(Large Towtruck)
	TOWTRUCK2(-442313018, Category.TRUCK), //(Small Towtruck)
	TR2(2078290630, Category.TRAILER), //(Car Carrier Trailer)
	TR3(1784254509, Category.TRAILER), //(Marquis Trailer)
	TR4(2091594960, Category.TRAILER), //(Super Car Carrier Trailer)
	TRACTOR(1641462412, Category.SERVICE), //(Rusty Tractor)
	TRACTOR2(-2076478498, Category.SERVICE), //(Farm Tractor)
	TRACTOR3(1445631933, Category.SERVICE), //(Snowy Tractor)
	TRAILERLARGE(1502869817, Category.UTILITY),
	TRAILERLOGS(2016027501, Category.TRAILER), //(Log Trailer)
	TRAILERS(-877478386, Category.TRAILER), //(Metal/Tarp Covered Trailer)
	TRAILERS2(-1579533167, Category.TRAILER), //(Up & Atom...)
	TRAILERS3(-2058878099, Category.TRAILER), //(Biggoods Trailer)
	TRAILERS4(-1100548694, Category.UTILITY),
	TRAILERSMALL(712162987, Category.TRAILER), //(Small Construction Trailer)
	TRAILERSMALL2(-1881846085, Category.MILITARY),
	TRASH(1917016601, Category.SERVICE),
	TRASH2(-1255698084, Category.SERVICE), //(Rusty Back)
	TRFLAT(-1352468814, Category.TRAILER), //(Flatbed Trailer)
	TRIBIKE(1127861609, Category.BICYCLE), //(Green Whippet Race Bike)
	TRIBIKE2(-1233807380, Category.BICYCLE), //(Red Endurex Race Bike)
	TRIBIKE3(-400295096, Category.BICYCLE), //(Blue Tri-Cycles Race Bike)
	TROPHYTRUCK(101905590, Category.OFFROAD),
	TROPHYTRUCK2(-663299102, Category.OFFROAD), //(Desert Raid)
	TROPIC(290013743, Category.BOAT),
	TROPIC2(1448677353, Category.BOAT), //(Yacht Tropic)
	TROPOS(1887331236, Category.SPORT), //(Tropos Rallye)
	TUG(-2100640717, Category.BOAT),
	TULA(1043222410, Category.PLANE),
	TURISMO2(-982130927, Category.SUPER),
	TURISMOR(408192225, Category.SUPER), //(Turismo Classic)
	TVTRAILER(-1770643266, Category.TRAILER), //(Fame or Shame Trailer)
	TYRANT(-376434238, Category.SUPER),
	TYRUS(2067820283, Category.SUPER),
	UTILLITRUCK(516990260, Category.SERVICE), //(Bldg/Renov Basket Truck)
	UTILLITRUCK2(887537515, Category.SERVICE), //(Landscape...)
	UTILLITRUCK3(2132890591, Category.SERVICE), //(Landscape Utility Pick-up)
	VACCA(338562499, Category.SUPER),
	VADER(-140902153, Category.MOTORCYCLE),
	VAGNER(1939284556, Category.SUPER),
	VALKYRIE(-1600252419, Category.HELICOPTER),
	VALKYRIE2(1543134283, Category.HELICOPTER), //(Valkyrie MOD.0)
	VELUM(-1673356438, Category.PLANE),
	VELUM2(1077420264, Category.PLANE), //(5-Seater)
	VERLIERER2(1102544804, Category.SPORT),
	VESTRA(1341619767, Category.PLANE),
	VIGERO(-825837129, Category.MUSCLE),
	VIGILANTE(-1242608589, Category.MILITARY),
	VINDICATOR(-1353081087, Category.MOTORCYCLE),
	VIRGO(-498054846, Category.MUSCLE),
	VIRGO2(-899509638, Category.MUSCLE), //(Virgo Classic Custom)
	VIRGO3(16646064, Category.MUSCLE), //(Virgo Classic)
	VISERIS(-391595372, Category.SPORTS_CLASSIC),
	VISIONE(-998177792, Category.SUPER),
	VOLATOL(447548909, Category.PLANE),
	VOLATUS(-1845487887, Category.HELICOPTER),
	VOLTIC(-1622444098, Category.SUPER),
	VOLTIC2(989294410, Category.SUPER), //(Rocket Voltic)
	VOODOO(2006667053, Category.MUSCLE), //(Voodoo Custom)
	VOODOO2(523724515, Category.MUSCLE), //(Rusty Voodoo)
	VORTEX(-609625092, Category.MOTORCYCLE),
	WARRENER(1373123368, Category.SEDAN),
	WASHINGTON(1777363799, Category.SEDAN),
	WASTELANDER(-1912017790, Category.SUPER),
	WINDSOR(1581459400, Category.COUPE),
	WINDSOR2(-1930048799, Category.COUPE), //(Windsor Drop)
	WOLFSBANE(-618617997, Category.MOTORCYCLE),
	XA21(917809321, Category.SUPER),
	XLS(1203490606, Category.SUV),
	XLS2(-432008408, Category.SUV), //(XLS (Armored)
	YOSEMITE(1871995513, Category.MUSCLE),
	YOUGA(65402552, Category.VAN),
	YOUGA2(1026149675, Category.VAN), //(Youga Classic)
	Z190(838982985, Category.SPORTS_CLASSIC),
	ZENTORNO(-1403128555, Category.SUPER),
	ZION(-1122289213, Category.COUPE), //(Zion XS)
	ZION2(-1193103848, Category.COUPE), //(Zion Convertible)
	ZOMBIEA(-1009268949, Category.MOTORCYCLE), //(Zombie Bobber)
	ZOMBIEB(-570033273, Category.MOTORCYCLE), //(Zombie Chopper)
	ZTYPE(758895617, Category.SPORTS_CLASSIC),
	;

	//todo привязать к getVehicleClass(entity)
	enum class Category {
		SUPER,
		COUPE,
		SPORTS_CLASSIC,
		MOTORCYCLE,
		SEDAN,
		VAN,
		MUSCLE,
		SUV,
		PLANE,
		SPORT,
		MILITARY,
		HELICOPTER,
		UTILITY,
		TRAILER,
		SERVICE,
		OFFROAD,
		BICYCLE,
		TRUCK,
		BOAT,
		TRAIN,
		COMMERCIAL,
		EMERGENCY,
		COMPACT,
		PICKUP,
		AFTER
	}
}


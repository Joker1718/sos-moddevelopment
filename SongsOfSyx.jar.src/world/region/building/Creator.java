/*     */ package world.region.building;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.CLIMATE;
/*     */ import init.type.CLIMATES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRegion;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.spirit.shrine.ROOM_SHRINE;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.RDOutputs;
/*     */ import world.region.RDReligions;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ final class Creator
/*     */ {
/*  59 */   private static CharSequence ¤¤prospect = "Prospect";
/*  60 */   private static CharSequence ¤¤desc = "Produces";
/*  61 */   private static CharSequence ¤¤small = "(Small)";
/*  62 */   private static CharSequence ¤¤large = "(Large)";
/*  63 */   private static CharSequence ¤¤awesome = "(Awesome)";
/*     */   
/*     */   static {
/*  66 */     D.ts(Creator.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Creator(RDBuildings buils) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public RDBuilding read(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, String key, PATHS.ResFolder f) throws IOException {
/*  76 */     Json json = new Json(f.init.gets(key));
/*  77 */     Json text = new Json(f.text.gets(key));
/*  78 */     INFO info = new INFO(text);
/*     */     
/*  80 */     ArrayListGrower<RDBuildingLevel> levels = new ArrayListGrower();
/*     */     
/*  82 */     Json[] jsons = json.jsons("LEVELS", 1, 10);
/*     */     
/*  84 */     int li = 0;
/*  85 */     String[] names = new String[0];
/*  86 */     if (text != null && text.has("LEVELS"))
/*  87 */       names = text.texts("LEVELS"); 
/*  88 */     boolean aibuild = json.bool("AI_BUILDS", true);
/*  89 */     boolean noti = json.bool("NOTIFY_WHEN_UPGRADABLE", false);
/*  90 */     String order = "";
/*  91 */     if (json.has("ORDER"))
/*  92 */       order = json.value("ORDER");  byte b1; int j; Json[] arrayOfJson1;
/*  93 */     for (j = (arrayOfJson1 = jsons).length, b1 = 0; b1 < j; ) { Json json1 = arrayOfJson1[b1];
/*  94 */       CharSequence name = (li < names.length) ? names[li] : (String.valueOf(info.name) + ": " + String.valueOf(info.name));
/*  95 */       Icon icon = SPRITES.icons().get(json1);
/*     */       
/*  97 */       Lockable<Region> needs = GVALUES.REGION.LOCK.push("BUILDING_" + cat.key + "_" + key + "_" + li + 1, name, info.desc, (SPRITE)icon);
/*  98 */       needs.push(json1);
/*     */       
/* 100 */       RDBuildingLevel l = new RDBuildingLevel(name, icon, needs);
/* 101 */       levels.add(l);
/* 102 */       li++;
/*     */       b1++; }
/*     */     
/* 105 */     RDBuilding b = new RDBuilding(all, init, cat, key, info, (LIST<RDBuildingLevel>)levels, aibuild, noti, order);
/*     */ 
/*     */     
/* 108 */     for (int i = 0; i < jsons.length; i++) {
/* 109 */       RDBuildingLevel l = (RDBuildingLevel)b.levels.get(i + 1);
/* 110 */       Json json1 = jsons[i];
/* 111 */       l.local.read("BOOST", json1, BValue.VALUE1);
/* 112 */       l.global.read("BOOST_GLOBAL", json1, BValue.VALUE1, Dic.¤¤global, true, new String[] { "ADMIN" });
/* 113 */       l.cost = json1.i("CREDITS", 0, 1000000, 0);
/*     */     } 
/*     */     
/* 116 */     pushEfficiency(b, json);
/*     */     
/* 118 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<RDBuilding> generate(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, PATHS.ResFolder f) {
/* 124 */     ArrayListGrower<RDBuilding> res = new ArrayListGrower();
/* 125 */     if (!f.init.exists("_GEN")) {
/* 126 */       return (LIST<RDBuilding>)res;
/*     */     }
/* 128 */     Json[] data = (new Json(f.init.gets("_GEN"))).jsons("GENS"); byte b; int i; Json[] arrayOfJson1;
/* 129 */     for (i = (arrayOfJson1 = data).length, b = 0; b < i; ) { Json j = arrayOfJson1[b];
/* 130 */       res.add((Iterable)generate(all, init, cat, j)); b++; }
/*     */     
/* 132 */     return (LIST<RDBuilding>)res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<RDBuilding> generate(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, Json data) {
/* 138 */     ArrayListGrower<RDBuilding> res = new ArrayListGrower();
/*     */     
/* 140 */     LIST<RoomBlueprint> rooms = (SETT.ROOMS()).collection.readMany("INDUSTRIES", data);
/*     */     
/* 142 */     for (RoomBlueprint b : rooms) {
/* 143 */       if (b instanceof ROOM_TEMPLE) {
/* 144 */         ROOM_TEMPLE t = (ROOM_TEMPLE)b;
/* 145 */         RDBuilding bu = generate(all, init, cat, t, data);
/* 146 */         res.add(bu);
/*     */       } 
/*     */ 
/*     */       
/* 150 */       if (b instanceof RoomBlueprintImp && b instanceof INDUSTRY_HASER) {
/* 151 */         INDUSTRY_HASER h = (INDUSTRY_HASER)b;
/* 152 */         RoomBlueprintImp blue = (RoomBlueprintImp)b;
/*     */         
/* 154 */         if (h.industries().size() == 0 || ((Industry)h.industries().get(0)).outs().size() == 0) {
/* 155 */           LOG.err(data.errorGet(b.key + "Is not a valid room to generate", "INDUSTRIES"));
/*     */         }
/*     */         
/* 158 */         RDBuilding bu = generate(all, init, cat, ((Industry)h.industries().get(0)).outs(), blue, data);
/*     */         
/* 160 */         if (((Industry)h.industries().get(0)).reg() != null) {
/* 161 */           final IndustryRegion ii = ((Industry)h.industries().get(0)).reg();
/* 162 */           Bo bo = new Bo(new BSourceInfo(¤¤prospect, (SPRITE)(UI.icons()).s.plusBig), 0.5D, 1.5D, true)
/*     */             {
/*     */               double get(Region reg)
/*     */               {
/* 166 */                 return 0.75D + 0.5D * RD.PROSPECT().get(ii, reg);
/*     */               }
/*     */             };
/* 169 */           bo.add(bu.efficiency);
/* 170 */           bu.baseFactors.add(bo);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 175 */         res.add(bu);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 181 */     return (LIST<RDBuilding>)res;
/*     */   }
/*     */ 
/*     */   
/* 185 */   private static double rateI = 0.05D;
/*     */ 
/*     */   
/*     */   private RDBuilding generate(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, LIST<IndustryResource> is, final RoomBlueprintImp blue, Json data) {
/* 189 */     ArrayList<RDBuildingLevel> levels = new ArrayList(data.i("LEVELS", 1, 10));
/*     */     
/* 191 */     double output = data.d("OUTPUT");
/* 192 */     double credits = data.i("CREDITS", 0, 2147483647);
/*     */ 
/*     */     
/* 195 */     String kkk = blue.key.startsWith("_") ? blue.key.substring(1) : blue.key;
/*     */     
/* 197 */     String desc = String.valueOf(¤¤desc) + ": ";
/*     */     
/* 199 */     boolean yearly = data.bool("YEARLY", false);
/*     */     
/* 201 */     for (int ri = 0; ri < is.size(); ri++) {
/* 202 */       desc = desc + desc;
/* 203 */       if (ri < is.size() - 1) {
/* 204 */         desc = desc + ", ";
/*     */       }
/*     */     } 
/* 207 */     for (int li = 0; li < levels.max(); li++) {
/* 208 */       CharSequence name = String.valueOf(blue.info.name) + ": " + String.valueOf(blue.info.name);
/* 209 */       Icon icon = blue.iconBig();
/*     */       
/* 211 */       double d = (li + 1) / levels.max();
/*     */       
/* 213 */       Lockable<Region> needs = GVALUES.REGION.LOCK.push("BUILDING_" + cat.key + "_" + kkk + "_" + li + 1, name, desc, (SPRITE)icon);
/* 214 */       RDBuildingLevel l = new RDBuildingLevel(name, icon, needs);
/* 215 */       l.cost = (int)(400.0D * credits * d);
/*     */       
/* 217 */       BSourceInfo bSourceInfo = new BSourceInfo(blue.info.name, (SPRITE)blue.icon);
/* 218 */       for (int i = 0; i < is.size(); i++) {
/* 219 */         IndustryResource industryResource = (IndustryResource)is.get(i);
/* 220 */         double rate = industryResource.rate / (1.0D + rateI * 0.05D);
/* 221 */         BoosterValue bo = new BoosterValue(BValue.VALUE1, bSourceInfo, output * d * rate, false);
/* 222 */         RDOutputs.RDResource rDResource = RD.OUTPUT().get((TRADABLE)TR.get(industryResource.resource));
/* 223 */         if (yearly) {
/* 224 */           l.local.push((Booster)bo, ((RDOutputs.RDOutput)rDResource).boostYearlyPart);
/*     */         } else {
/* 226 */           l.local.push((Booster)bo, ((RDOutputs.RDOutput)rDResource).boost);
/*     */         } 
/*     */       } 
/* 229 */       levels.add(l);
/*     */     } 
/*     */     
/* 232 */     INFO info = new INFO(blue.info.name, desc);
/*     */     
/* 234 */     final RDBuilding b = new RDBuilding(all, init, cat, kkk, info, (LIST<RDBuildingLevel>)levels, true, false, kkk);
/*     */ 
/*     */ 
/*     */     
/* 238 */     pushEfficiency(b, data);
/*     */     
/* 240 */     final BoostSpecs sp = new BoostSpecs(blue.info.name, (SPRITE)blue.icon, false);
/* 241 */     sp.read(data, BValue.VALUE1);
/* 242 */     ACTION a = new ACTION() {
/*     */         BSourceInfo info;
/*     */         
/*     */         public void exe() {
/* 246 */           for (int i = 1; i < b.levels.size(); i++) {
/* 247 */             for (BoostSpec s : sp.all()) {
/* 248 */               double am = s.booster.to() * i / (b.levels.size() - 1);
/* 249 */               ((RDBuildingLevel)b.levels.get(i)).local.push((Booster)new BoosterValue(BValue.VALUE1, this.info, am, s.booster.isMul), s.boostable);
/*     */             } 
/*     */           } 
/* 252 */           for (CLIMATE c : CLIMATES.ALL()) {
/* 253 */             for (int si = 0; si < c.boosters.all().size(); si++) {
/* 254 */               BoostSpec s = (BoostSpec)c.boosters.all().get(si);
/* 255 */               if (s.boostable == blue.bonus()) {
/* 256 */                 CLIMATES.pushIfDoesntExist(c, s.booster.to(), b.efficiency, s.booster.isMul);
/*     */               }
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 264 */           for (RDRace c : (RD.RACES()).all) {
/* 265 */             for (int si = 0; si < c.race.boosts.all().size(); si++) {
/* 266 */               BoostSpec s = (BoostSpec)c.race.boosts.all().get(si);
/* 267 */               if (s.boostable == blue.bonus()) {
/*     */                 
/* 269 */                 BoostSpec sp = RACES.boosts().pushIfDoesntExist(c.race, s.booster.to(), b.efficiency, s.booster.isMul);
/* 270 */                 if (sp != null && !sp.boostable.contains(sp.booster)) {
/* 271 */                   sp.booster.add(sp.boostable);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/* 278 */     BOOSTING.connecter(a);
/*     */ 
/*     */     
/* 281 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private RDBuilding generate(LISTE<RDBuilding> all, RD.RDInit init, RDBuildingCat cat, ROOM_TEMPLE temple, Json data) {
/* 287 */     ArrayList<RDBuildingLevel> levels = new ArrayList(5);
/* 288 */     double credits = data.i("CREDITS", 0, 2147483647);
/*     */     
/* 290 */     ROOM_SHRINE shrine = (ROOM_SHRINE)(SETT.ROOMS()).TEMPLES.SHRINES.get(temple.religion.index());
/* 291 */     RDReligions.RDReligion reg = RD.RELIGION().get(temple.religion);
/* 292 */     double[] local = {
/* 293 */         1.0D, 
/* 294 */         2.0D, 
/* 295 */         3.0D, 
/* 296 */         4.0D, 
/* 297 */         5.0D
/*     */       };
/* 299 */     double[] global = {
/* 300 */         0.0D, 
/* 301 */         0.0D, 
/* 302 */         0.1D, 
/* 303 */         0.25D, 
/* 304 */         0.5D
/*     */       };
/* 306 */     CharSequence[] name = {
/* 307 */         String.valueOf(shrine.info.name) + " " + String.valueOf(shrine.info.name), 
/* 308 */         String.valueOf(shrine.info.name) + " " + String.valueOf(shrine.info.name), 
/* 309 */         String.valueOf(temple.info.name) + " " + String.valueOf(temple.info.name), 
/* 310 */         String.valueOf(temple.info.name) + " " + String.valueOf(temple.info.name), 
/* 311 */         String.valueOf(temple.info.name) + " " + String.valueOf(temple.info.name)
/*     */       };
/*     */     
/* 314 */     Icon[] icons = {
/* 315 */         shrine.icon, 
/* 316 */         shrine.icon, 
/* 317 */         temple.icon, 
/* 318 */         temple.icon, 
/* 319 */         temple.icon
/*     */       };
/*     */     
/* 322 */     for (int i = 0; i < local.length; i++) {
/*     */       
/* 324 */       double d = (i + 1) / levels.max();
/*     */       
/* 326 */       Lockable<Region> needs = GVALUES.REGION.LOCK.push("BUILDING_" + cat.key + "_" + temple.religion.key + "_" + i + 1, name[i], temple.religion.info.desc, (SPRITE)icons[i]);
/* 327 */       RDBuildingLevel l = new RDBuildingLevel(name[i], icons[i], needs);
/* 328 */       l.cost = (int)(400.0D * credits * Math.pow(d, 2.0D));
/*     */       
/* 330 */       BSourceInfo bSourceInfo = new BSourceInfo(name[i], (SPRITE)icons[i]);
/*     */       
/* 332 */       BoosterValue bo = new BoosterValue(BValue.VALUE1, bSourceInfo, local[i], false);
/* 333 */       l.local.push((Booster)bo, reg.boost);
/* 334 */       if (global[i] > 0.0D) {
/* 335 */         bo = new BoosterValue(BValue.VALUE1, bSourceInfo, global[i], false);
/* 336 */         l.global.push((Booster)bo, reg.boost);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 341 */       levels.add(l);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     INFO info = new INFO(shrine.info.name, temple.religion.info.desc);
/*     */     
/* 349 */     final RDBuilding b = new RDBuilding(all, init, cat, temple.key, info, (LIST<RDBuildingLevel>)levels, true, false, temple.key);
/*     */     
/* 351 */     final BoostSpecs sp = new BoostSpecs(shrine.info.name, (SPRITE)shrine.icon, false);
/* 352 */     sp.read(data, BValue.VALUE1);
/* 353 */     ACTION a = new ACTION(shrine) {
/*     */         BSourceInfo info;
/*     */         
/*     */         public void exe() {
/* 357 */           for (int i = 1; i < b.levels.size(); i++) {
/* 358 */             for (BoostSpec s : sp.all()) {
/* 359 */               int am = (int)(s.booster.to() * i / (b.levels.size() - 1));
/* 360 */               ((RDBuildingLevel)b.levels.get(i)).local.push((Booster)new BoosterValue(BValue.VALUE1, this.info, am, s.booster.isMul), s.boostable);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 366 */     BOOSTING.connecter(a);
/*     */ 
/*     */     
/* 369 */     pushEfficiency(b, data);
/*     */ 
/*     */     
/* 372 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void pushEfficiency(RDBuilding bu, Json da) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static abstract class Bo
/*     */     extends BoosterImp
/*     */   {
/*     */     public Bo(BSourceInfo info, double from, double to, boolean isMul) {
/* 437 */       super(info, from, to, isMul);
/*     */     }
/*     */ 
/*     */     
/*     */     abstract double get(Region param1Region);
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 444 */       return vGet((Faction)f);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 449 */       return vGet((Faction)f);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/* 454 */       double d = 0.0D;
/*     */       
/* 456 */       for (int ri = 0; ri < f.realm().regions(); ri++) {
/* 457 */         d += vGet(f.realm().region(ri));
/*     */       }
/* 459 */       return d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE t) {
/* 465 */       return vGet((Faction)FACTIONS.player());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 470 */       return vGet((Faction)FACTIONS.player());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 475 */       return vGet(indu.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 480 */       return get(reg);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getValue(double input) {
/* 485 */       return input;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\Creator.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
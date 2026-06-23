/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.ArmyFormations;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DivGeneration;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ final class BattleStateGenArmy
/*     */ {
/*     */   static int men;
/*     */   
/*     */   public static void genArmy(ArrayList<DivGeneration> ss, boolean player, DIR d, LIST<ROOM_ARTILLERY> art, Race artrace, double moraleBase) {
/*  41 */     (GAME.ARMIES()).factors.init(player ? GAME.ARMIES().player() : GAME.ARMIES().enemy(), moraleBase);
/*     */     
/*  43 */     ArmyFormations.ArmyFormation ff = player ? (GAME.battle()).formations.player : (ArmyFormations.ArmyFormation)(GAME.battle()).formations.all.rnd();
/*     */     
/*  45 */     ArrayList<ArmyFormations.ArmyFormationDiv> divs = ff.getFirstRow((LIST)ss);
/*     */ 
/*     */     
/*  48 */     int w = 12;
/*  49 */     int cx = SETT.TILE_BOUNDS.cX() + d.x() * 120 + d.next(2).x() * w / 2;
/*  50 */     int cy = SETT.TILE_BOUNDS.cY() + d.y() * 120 + d.next(2).y() * w / 2;
/*     */     
/*  52 */     int depth = 0;
/*  53 */     for (; depth < 256 && !divs.isEmpty(); depth += w + 1) {
/*  54 */       for (int width = 0; width < 220 && 
/*  55 */         !divs.isEmpty(); width++) {
/*     */         
/*  57 */         int x1 = cx + depth * d.x() + d.next(2).x() * width;
/*  58 */         int y1 = cy + depth * d.y() + d.next(2).y() * width;
/*  59 */         ArmyFormations.ArmyFormationDiv div = ff.get((LIST)divs, 1.0D - width / 220.0D, width / 220.0D, 1.0D - depth / 256.0D, depth / 256.0D);
/*  60 */         if (divPlace(div, player, w, d, x1, y1)) {
/*  61 */           width -= w;
/*  62 */           if (width < 0)
/*  63 */             width = 0; 
/*  64 */           divs.remove(div);
/*     */         } 
/*     */ 
/*     */         
/*  68 */         if (divs.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/*  72 */         x1 = cx + depth * d.x() - d.next(2).x() * width;
/*  73 */         y1 = cy + depth * d.y() - d.next(2).y() * width;
/*  74 */         div = ff.get((LIST)divs, 1.0D - width / 220.0D, width / 220.0D, 1.0D - depth / 256.0D, depth / 256.0D);
/*  75 */         if (divPlace(div, player, w, d, x1, y1)) {
/*  76 */           width -= w;
/*  77 */           if (width < 0) {
/*  78 */             width = 0;
/*     */           }
/*  80 */           divs.remove(div);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  85 */     depth += BattleStateArt.placeArt(cx, cy, depth, d, art, artrace, player);
/*     */ 
/*     */ 
/*     */     
/*  89 */     if (player) {
/*  90 */       placeThrone(cx, cy, depth, d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void placeThrone(int cx, int cy, int depth, DIR d) {
/*  97 */     depth += 15;
/*  98 */     int x1 = cx + depth * d.x();
/*  99 */     int y1 = cy + depth * d.y();
/* 100 */     int dd = 0;
/* 101 */     for (int di = 0; di < DIR.ORTHO.size() && 
/* 102 */       DIR.ORTHO.get(di) != d.perpendicular(); di++)
/*     */     {
/* 104 */       dd++;
/*     */     }
/*     */     
/* 107 */     (SETT.ROOMS()).THRONE.init.place(x1, y1, dd);
/*     */   }
/*     */ 
/*     */   
/* 111 */   private static final Rec tmp = new Rec();
/* 112 */   private static final ArrayList<Div> tmpDivs = new ArrayList(1);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean divPlace(ArmyFormations.ArmyFormationDiv wdiv, boolean player, int widthMax, DIR d, int tx1, int ty1) {
/* 118 */     DivGeneration div = wdiv.g;
/*     */     
/* 120 */     if (div.indus.length == 0) {
/* 121 */       return true;
/*     */     }
/*     */     
/* 124 */     int depthMax = (int)Math.ceil(div.indus.length / widthMax);
/* 125 */     if (d.x() != 0) {
/* 126 */       int bi = depthMax;
/* 127 */       depthMax = widthMax;
/* 128 */       widthMax = bi;
/*     */     } 
/*     */     
/* 131 */     d = d.next(-1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 137 */     tmp.set(tx1, (tx1 + d.x() * depthMax), ty1, (ty1 + d.y() * widthMax));
/* 138 */     tmp.makePositive();
/*     */     
/* 140 */     int men = 0;
/*     */     
/* 142 */     for (COORDINATE c : tmp) {
/* 143 */       if (((AVAILABILITY)(SETT.PATH()).availability.get(c)).player <= 0.0D || SETT.ENTITIES().hasAtTile(c.x(), c.y())) {
/* 144 */         return false;
/*     */       }
/*     */     } 
/* 147 */     Div adiv = (Div)(player ? GAME.ARMIES().player() : GAME.ARMIES().enemy()).divisions().get(wdiv.divID);
/*     */     
/* 149 */     adiv.settings().clear();
/* 150 */     adiv.settings().musteringSet(true);
/* 151 */     (adiv.settings()).fireAtWill = true;
/*     */     
/* 153 */     Race race = (Race)RACES.all().get(div.race);
/* 154 */     adiv.info.raceSet(race);
/* 155 */     adiv.info.menSet(div.indus.length);
/* 156 */     adiv.info.bannerISet(div.bannerI);
/* 157 */     adiv.info.name().clear().add(div.name);
/*     */     
/* 159 */     HTYPE type = player ? HTYPES.SOLDIER() : HTYPES.ENEMY();
/*     */     
/* 161 */     int am = div.indus.length;
/*     */ 
/*     */     
/* 164 */     if (am > (Config.battle()).MEN_PER_DIVISION) {
/* 165 */       throw new RuntimeException(String.valueOf(div) + " " + String.valueOf(div));
/*     */     }
/* 167 */     for (COORDINATE c : tmp) {
/* 168 */       if (men >= div.indus.length) {
/*     */         break;
/*     */       }
/* 171 */       Humanoid h = SETT.HUMANOIDS().create(race, c.x(), c.y(), type, CAUSE_ARRIVES.SOLDIER_RETURN());
/* 172 */       if (!h.isRemoved()) {
/* 173 */         STATS.NEEDS().clear(h.indu());
/* 174 */         h.indu().copyFrom(div.indus[men]);
/* 175 */         (STATS.BATTLE()).basicTraining.setD(h.indu(), 1.0D);
/*     */ 
/*     */         
/* 178 */         for (EquipBattle m : STATS.EQUIP().BATTLE_ALL()) {
/* 179 */           m.set(h.indu(), m.get(div.indus[men]));
/*     */         }
/*     */         
/* 182 */         men++;
/* 183 */         h.setDivision(adiv);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 189 */     if (men == 0) {
/* 190 */       return false;
/*     */     }
/* 192 */     adiv.info.copySettings((DIV_SETTING)wdiv.g.target);
/* 193 */     for (EquipRange m : STATS.EQUIP().RANGED()) {
/* 194 */       m.ammoClear(adiv);
/*     */     }
/* 196 */     d = d.next(-1);
/*     */     
/* 198 */     int x1 = tx1 * 64 + 32;
/* 199 */     int y1 = ty1 * 64 + 32;
/* 200 */     int x2 = x1 + d.x() * depthMax * 64;
/* 201 */     int y2 = y1 + d.y() * widthMax * 64;
/* 202 */     tmpDivs.clear();
/* 203 */     tmpDivs.add(adiv);
/* 204 */     (GAME.ARMIES()).placer.deploy((LIST)tmpDivs, x1, x2, y1, y2);
/* 205 */     GAME.ARMIES().initAndTeleport((LIST)tmpDivs);
/*     */     
/* 207 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   static final class WDivId
/*     */   {
/*     */     final int di;
/*     */     final DivGeneration gen;
/*     */     
/*     */     public WDivId(int id, DivGeneration gen) {
/* 217 */       this.di = id;
/* 218 */       this.gen = gen;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateGenArmy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DivGeneration;
/*     */ import init.constant.Config;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class DivDeployer
/*     */ {
/*     */   public static Div deploy(ArrayList<DivGeneration> divs, SpotMaker.InvasionSpot spot) {
/*  23 */     if (divs.size() == 0) {
/*  24 */       return null;
/*     */     }
/*  26 */     Div d = getDiv();
/*  27 */     if (d == null) {
/*  28 */       return null;
/*     */     }
/*  30 */     DIR sDir = spot.dir;
/*     */     
/*  32 */     int sx = spot.body.x1();
/*  33 */     int sy = spot.body.y1();
/*  34 */     DIR dir = sDir.next(2);
/*     */     
/*  36 */     DivGeneration id = (DivGeneration)divs.get(0);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  45 */     sx += sDir.x() * 6;
/*  46 */     sy += sDir.y() * 6;
/*     */     
/*  48 */     dir = sDir.next(2);
/*  49 */     int w = (int)Math.ceil(id.indus.length / 5.0D);
/*  50 */     if (w >= spot.size)
/*  51 */       w = spot.size - 1; 
/*  52 */     for (int i = 0; i < spot.size - w; i++) {
/*     */       
/*  54 */       if (can(sx, sy)) {
/*  55 */         boolean can = true;
/*  56 */         for (int k = 1; k <= w; k++) {
/*  57 */           int dx = sx + k * dir.x();
/*  58 */           int dy = sy + k * dir.y();
/*  59 */           if (!can(dx, dy)) {
/*  60 */             can = false;
/*     */             break;
/*     */           } 
/*     */         } 
/*  64 */         if (can) {
/*  65 */           place(sx, sy, id, d, sDir);
/*  66 */           divs.remove(0);
/*  67 */           return d;
/*     */         } 
/*     */       } 
/*     */       
/*  71 */       sx += dir.x();
/*  72 */       sy += dir.y();
/*     */     } 
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   private static ArrayList<Humanoid> tmp = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/*     */   
/*     */   private static boolean place(int sx, int sy, DivGeneration d, Div div, DIR spotdir) {
/*  83 */     int amount = d.indus.length;
/*  84 */     int w = (int)Math.ceil(d.indus.length / 5.0D);
/*     */     
/*  86 */     div.settings().musteringSet(true);
/*  87 */     div.info.menSet(d.indus.length);
/*  88 */     div.info.bannerISet(d.bannerI);
/*  89 */     div.info.name().clear().add(d.name);
/*     */ 
/*     */ 
/*     */     
/*  93 */     DIR right = spotdir.next(2);
/*  94 */     DIR down = right.next(2);
/*  95 */     tmp.clear();
/*  96 */     for (int y = 0; y < w; y++) {
/*  97 */       for (int x = 0; x < 5; x++) {
/*  98 */         if (amount-- > 0) {
/*  99 */           int cx = (sx + y * right.x() + x * down.x()) * 64 + 32;
/* 100 */           int cy = (sy + y * right.y() + x * down.y()) * 64 + 32;
/*     */           
/* 102 */           if (SETT.PIXEL_BOUNDS.holdsPoint(cx, cy)) {
/* 103 */             Humanoid h = new Humanoid(cx, cy, d.race(), HTYPES.ENEMY(), null);
/*     */             
/* 105 */             if (h != null && !h.isRemoved()) {
/* 106 */               STATS.NEEDS().clear(h.indu());
/* 107 */               h.indu().copyFrom(d.indus[amount]);
/* 108 */               (STATS.BATTLE()).basicTraining.setD(h.indu(), 1.0D);
/* 109 */               for (EquipBattle m : STATS.EQUIP().BATTLE_ALL()) {
/* 110 */                 m.set(h.indu(), m.get(d.indus[amount]));
/*     */               }
/*     */               
/* 113 */               h.setDivision(div);
/* 114 */               tmp.add(h);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     div.info.copySettings((DIV_SETTING)d.target);
/*     */     
/* 126 */     int x1 = sx * 64 + 32;
/* 127 */     int y1 = sy * 64 + 32;
/* 128 */     DIR dir = spotdir.next(2);
/* 129 */     int x2 = x1 + dir.x() * w * 64;
/* 130 */     int y2 = y1 + dir.y() * w * 64;
/*     */     
/* 132 */     (GAME.ARMIES()).placer.deploy(div, x1, x2, y1, y2);
/*     */     
/* 134 */     GAME.ARMIES().initAndTeleport((LIST)new ArrayList(div));
/* 135 */     (GAME.ARMIES()).placer.deploy(div, x1, x2, y1, y2);
/* 136 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean can(int sx, int sy) {
/* 142 */     if (!SETT.IN_BOUNDS(sx, sy)) {
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     if ((SETT.PATH()).availability.get(sx, sy).isSolid(GAME.ARMIES().enemy())) {
/* 147 */       (GAME.ARMIES()).map.breakIt(sx, sy);
/* 148 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 152 */     for (ENTITY e : SETT.ENTITIES().getAtTile(sx, sy)) {
/* 153 */       if (e instanceof Humanoid && ((Humanoid)e).indu().army() == GAME.ARMIES().enemy())
/* 154 */         return false; 
/*     */     } 
/* 156 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Div getDiv() {
/* 161 */     for (Div d : GAME.ARMIES().enemy().divisions()) {
/* 162 */       if (d.menNrOf() == 0) {
/* 163 */         return d;
/*     */       }
/*     */     } 
/* 166 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\DivDeployer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
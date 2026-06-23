/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.misc.CLAMP;
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
/*     */ 
/*     */ 
/*     */ final class ToolsDiv
/*     */ {
/*     */   private final Tools t;
/*     */   private final Coo coo;
/*     */   
/*     */   ToolsDiv(Tools tools) {
/*  80 */     this.coo = new Coo(); this.t = tools;
/*     */   }
/*     */   public boolean needsFixing(DivFormationImp dest, int men, Army a, DIV_FORMATION f) { if (men <= 0) return false;  if (f != dest.formation() || dest.deployed() > men || (men > dest.deployed() && dest.hasExtraRoom()) || !this.t.deployer.isValid((DIV_SPEC)BattleOrderUpdater.Plan.div.info, dest, a)) return true;  return false; } public boolean fixIfNeeded(DivFormationImp target) { if (BattleOrderUpdater.Plan.men <= 0)
/*  83 */       return false;  if (needsFixing(target, BattleOrderUpdater.Plan.men, BattleOrderUpdater.Plan.a, (BattleOrderUpdater.Plan.div.settings()).formation)) { DivFormationImp nn = this.t.deployer.getFixedFormation((DIV_SPEC)BattleOrderUpdater.Plan.div.info, target, (BattleOrderUpdater.Plan.div.settings()).formation, BattleOrderUpdater.Plan.men, BattleOrderUpdater.Plan.a); if (nn != null) { DivFormationImp res = this.t.mover.getFromMovedIntoTo((DivPositionImp)target, nn); target.copy(res); return true; }  }  return false; } public COORDINATE getSafeCentrePixel(DivFormationImp dest) { if (dest.deployed() == 0)
/*  84 */       return dest.centrePixel(); 
/*  85 */     int x = 0, y = 0;
/*  86 */     for (int i = 0; i < dest.deployed(); i++) {
/*  87 */       x += dest.pixel(i).x();
/*  88 */       y += dest.pixel(i).y();
/*     */     } 
/*  90 */     x /= dest.deployed();
/*  91 */     y /= dest.deployed();
/*  92 */     if (DivPlacability.pixelIsBlocked(x, y, dest.formation().size(BattleOrderUpdater.Plan.div), BattleOrderUpdater.Plan.a)) {
/*  93 */       return dest.centrePixel();
/*     */     }
/*  95 */     this.coo.set(x, y);
/*  96 */     return (COORDINATE)this.coo; }
/*     */   public int inPosition(DivPositionCopyable current, DivFormationImp dest, double dist) { int am = 0; int max = CLAMP.i(current.deployed(), 0, dest.deployed()); for (int i = 0; i < max; i++) { if (BattleOrderUpdater.Plan.div.reporter.reachable(i) && dest.pixel(i).tileDistanceTo(current.pixel(i)) < dist) am++;  }  return am; }
/*     */   public int distanceAverageFromCurrentToNext(DivPositionImp current, DivPositionImp next) { int dist = 0; int am = CLAMP.i(current.deployed(), 0, next.deployed()); if (am == 0)
/*     */       return 0;  for (int i = 0; i < am; i++)
/* 100 */       dist = (int)(dist + next.pixel(i).tileDistanceTo(current.pixel(i)));  return dist / am; } public COORDINATE getSafeCentreTile(DivPositionImp dest) { if (dest.deployed() == 0)
/* 101 */       return (COORDINATE)this.coo; 
/* 102 */     int xx = 0;
/* 103 */     int yy = 0;
/* 104 */     int am = 0; int i;
/* 105 */     for (i = 0; i < dest.deployed(); i++) {
/* 106 */       if (BattleOrderUpdater.Plan.div.reporter.reachable(i)) {
/* 107 */         xx += dest.px(i);
/* 108 */         yy += dest.py(i);
/* 109 */         am++;
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     if (am == 0) {
/* 114 */       for (i = 0; i < dest.deployed(); i++) {
/* 115 */         xx += dest.px(i);
/* 116 */         yy += dest.py(i);
/* 117 */         am++;
/*     */       } 
/*     */     }
/*     */     
/* 121 */     xx /= am;
/* 122 */     yy /= am;
/*     */     
/* 124 */     int bestI = -1;
/* 125 */     double bestValue = Double.MAX_VALUE;
/* 126 */     int size = (BattleOrderUpdater.Plan.div.settings()).formation.size(BattleOrderUpdater.Plan.div);
/* 127 */     for (int j = 0; j < dest.deployed(); j++) {
/* 128 */       int x = dest.px(j);
/* 129 */       int y = dest.py(j);
/* 130 */       double dist = COORDINATE.tileDistance(x, y, xx, yy);
/*     */       
/* 132 */       if (!BattleOrderUpdater.Plan.div.reporter.reachable(j))
/* 133 */         dist += 8.988465674311579E307D; 
/* 134 */       if (!DivPlacability.pixelIsBlocked(x, y, size, BattleOrderUpdater.Plan.a) && 
/* 135 */         dist < bestValue) {
/* 136 */         bestValue = dist;
/* 137 */         bestI = j;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.coo.set(dest.tile(bestI));
/* 146 */     return (COORDINATE)this.coo; }
/*     */ 
/*     */ 
/*     */   
/*     */   public int distanceMaxFromCurrentToNext(DivPositionImp current, DivPositionImp next) {
/* 151 */     double dist = 0.0D;
/* 152 */     int am = CLAMP.i(current.deployed(), 0, next.deployed());
/*     */     
/* 154 */     for (int i = 0; i < am; i++) {
/* 155 */       dist = Math.max(dist, next.pixel(i).tileDistanceTo(current.pixel(i)));
/*     */     }
/* 157 */     return (int)dist;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int distanceTO(int x, int y, DivPositionCopyable next) {
/* 163 */     int dist = 0;
/* 164 */     int am = next.deployed();
/* 165 */     if (am == 0) {
/* 166 */       return 0;
/*     */     }
/* 168 */     for (int i = 0; i < next.deployed(); i++) {
/* 169 */       dist = (int)(dist + next.pixel(i).tileDistanceTo(x, y));
/*     */     }
/* 171 */     return dist / am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE currentCentre() {
/* 177 */     int xx = 0;
/* 178 */     int yy = 0;
/* 179 */     int am = 0;
/*     */     int i;
/* 181 */     for (i = 0; i < BattleOrderUpdater.Plan.current.deployed(); i++) {
/* 182 */       if (BattleOrderUpdater.Plan.div.reporter.reachable(i)) {
/* 183 */         xx += BattleOrderUpdater.Plan.current.px(i);
/* 184 */         yy += BattleOrderUpdater.Plan.current.py(i);
/* 185 */         am++;
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     if (am == 0) {
/* 190 */       for (i = 0; i < BattleOrderUpdater.Plan.current.deployed(); i++) {
/* 191 */         xx += BattleOrderUpdater.Plan.current.px(i);
/* 192 */         yy += BattleOrderUpdater.Plan.current.py(i);
/* 193 */         am++;
/*     */       } 
/*     */     }
/*     */     
/* 197 */     if (am > 0) {
/* 198 */       xx /= am;
/* 199 */       yy /= am;
/*     */     } 
/*     */     
/* 202 */     this.coo.set(xx, yy);
/* 203 */     return (COORDINATE)this.coo;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean intersectsSomewhat(DivFormationImp a, DivFormationImp b) {
/* 209 */     this.t.pather.filler.init(this);
/* 210 */     int s = 0;
/* 211 */     for (int i = 0; i < a.deployed(); i++) {
/* 212 */       COORDINATE c = a.tile(i);
/* 213 */       if (SETT.IN_BOUNDS(c)) {
/* 214 */         this.t.pather.filler.fill(c.x(), c.y());
/* 215 */         s++;
/*     */       } 
/*     */     } 
/*     */     
/* 219 */     int k = 0;
/* 220 */     for (int j = 0; j < b.deployed(); j++) {
/* 221 */       COORDINATE c = b.tile(j);
/* 222 */       if (SETT.IN_BOUNDS(c) && 
/* 223 */         this.t.pather.filler.isFilled(c.x(), c.y())) {
/* 224 */         k++;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 230 */     this.t.pather.filler.done();
/*     */     
/* 232 */     return (k > s / 2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCloseToFighting() {
/* 240 */     if (BattleOrderUpdater.Plan.div.status().engagements() > Math.sqrt(BattleOrderUpdater.Plan.men) / 2.0D) {
/* 241 */       return true;
/*     */     }
/* 243 */     int dist = BattleOrderUpdater.Plan.div.status().enemyClosestDist();
/* 244 */     if (dist < 0)
/* 245 */       return false; 
/* 246 */     if (dist < 16 || (BattleOrderUpdater.Plan.div.status().isFighting() && dist < 32)) {
/* 247 */       return true;
/*     */     }
/* 249 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\ToolsDiv.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
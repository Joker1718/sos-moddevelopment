/*     */ package game.battle.thread.status;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivPosition;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.MapInt;
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
/*     */ class Flanker
/*     */ {
/* 179 */   int size = Math.max((Config.battle()).DIVISIONS_PER_ARMY, (Config.battle()).MEN_PER_DIVISION);
/* 180 */   private final int[] engagedX = Alloc.ii(this.size);
/* 181 */   private final int[] engagedY = Alloc.ii(this.size);
/*     */ 
/*     */ 
/*     */   
/* 185 */   private int[] dirs = Alloc.ii(DIR.ALL.size());
/*     */   
/* 187 */   private final MapInt intmap = new MapInt();
/*     */ 
/*     */   
/*     */   public double get2(BattleContext u, Div d, DivPosition pos) {
/* 191 */     int deployed = pos.deployed();
/* 192 */     if (deployed == 0) {
/* 193 */       return 0.0D;
/*     */     }
/* 195 */     int centreX = 0;
/* 196 */     int centreY = 0;
/* 197 */     int soldiersTotal = 0;
/* 198 */     int engaged = 0;
/*     */     int pi;
/* 200 */     for (pi = 0; pi < pos.deployed(); pi++) {
/* 201 */       int px = pos.px(pi);
/* 202 */       int py = pos.py(pi);
/* 203 */       if (enemy(u, d, px, py)) {
/* 204 */         this.engagedX[engaged] = px;
/* 205 */         this.engagedY[engaged] = py;
/* 206 */         engaged++;
/* 207 */         centreX += px;
/* 208 */         centreY += py;
/* 209 */         soldiersTotal++;
/* 210 */       } else if (d.reporter.reachable(pi)) {
/* 211 */         centreX += px;
/* 212 */         centreY += py;
/* 213 */         soldiersTotal++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 218 */     if (engaged == 0) {
/* 219 */       return 0.0D;
/*     */     }
/*     */     
/* 222 */     centreX /= soldiersTotal;
/* 223 */     centreY /= soldiersTotal;
/*     */     
/* 225 */     this.intmap.clear();
/* 226 */     Arrays.fill(this.dirs, 0);
/*     */     
/* 228 */     for (pi = 0; pi < pos.deployed(); pi++) {
/* 229 */       int px = pos.px(pi);
/* 230 */       int py = pos.py(pi);
/*     */       
/* 232 */       DIR dd = DIR.get(centreX, centreY, px, py);
/* 233 */       for (int di = -1; di <= 1; di++) {
/* 234 */         DIR dir = dd.next(di);
/* 235 */         int tx = (int)((px + dir.xN() * 64.0D) / 64.0D);
/* 236 */         int ty = (int)((py + dir.yN() * 64.0D) / 64.0D);
/* 237 */         if (SETT.IN_BOUNDS(tx, ty)) {
/* 238 */           int ii = tx + ty * SETT.TWIDTH;
/* 239 */           if (!this.intmap.contains(ii)) {
/* 240 */             this.intmap.add(ii);
/* 241 */             this.dirs[dir.id()] = this.dirs[dir.id()] + u.map.soldiers(d.army().enemy()).get(tx, ty);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 249 */     double res = 0.0D;
/*     */     
/* 251 */     for (int d1 = 0; d1 < DIR.ALL.size(); d1++) {
/* 252 */       DIR da = (DIR)DIR.ALL.get(d1);
/* 253 */       for (int d2 = d1 + 1; d2 < DIR.ALL.size(); d2++) {
/* 254 */         DIR bd = (DIR)DIR.ALL.get(d2);
/* 255 */         double dot = da.xN() * bd.xN() + da.yN() * bd.yN();
/* 256 */         if (dot < 0.0D) {
/* 257 */           res += Math.min(this.dirs[d1], this.dirs[d2]) * (1.0D - dot);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 262 */     return res;
/*     */   }
/*     */   
/*     */   private boolean enemy(BattleContext u, Div div, int px, int py) {
/* 266 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 267 */       DIR dir = (DIR)DIR.ALL.get(di);
/* 268 */       int tx = (int)((px + dir.xN() * 64.0D) / 64.0D);
/* 269 */       int ty = (int)((py + dir.yN() * 64.0D) / 64.0D);
/* 270 */       if (u.map.hasEnemy.is(tx, ty, div.army())) {
/* 271 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 275 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\Updater$Flanker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
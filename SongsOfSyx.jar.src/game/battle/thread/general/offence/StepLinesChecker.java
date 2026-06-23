/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import util.data.INT;
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
/*     */ class StepLinesChecker
/*     */ {
/*     */   private final StrategosUtil u;
/*     */   private final ContextLines lines;
/*     */   private final INT.IntImp checkI;
/*     */   private final VectorImp vec;
/*     */   
/*     */   StepLinesChecker(StrategosUtil u, Context c) {
/* 101 */     this.vec = new VectorImp(); this.u = u; this.lines = c.lines; this.checkI = c.checkI;
/*     */   } public void init() { this.checkI.set(0); } public boolean check() { if (this.checkI.get() >= this.lines.lines())
/*     */       return false;  ContextLines.Line l = this.lines.get(this.checkI.get()); if (!check(l)) { this.lines.remove(this.checkI.get()); } else { this.checkI.inc(1); }
/*     */      return true; }
/* 105 */   private boolean checkSpaceInBack(ContextLines.Line n, int minDist) { this.vec.set(n.dx, n.dy);
/* 106 */     this.vec.rotate90();
/*     */     
/* 108 */     for (int in = 0; in <= minDist; in += 64) {
/*     */ 
/*     */ 
/*     */       
/* 112 */       for (int r = 0; r <= n.length; r += 64) {
/*     */         
/* 114 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 115 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 116 */         x /= 64;
/* 117 */         y /= 64;
/*     */         
/* 119 */         if (solid(x, y)) {
/* 120 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/* 124 */     return true; } private boolean check(ContextLines.Line l) { if (!checkBlockageAndChopUpIfNeeded(l))
/*     */       return false;  if (!checkSpaceInBack(l, 320))
/*     */       return false;  if (!checkEnemiesInFront(l))
/*     */       return false; 
/*     */     return true; }
/* 129 */   private boolean checkEnemiesInFront(ContextLines.Line n) { this.vec.set(n.dx, n.dy);
/* 130 */     this.vec.rotate90();
/* 131 */     this.vec.rotate90();
/* 132 */     this.vec.rotate90();
/* 133 */     double dist = 4096.0D;
/* 134 */     for (int in = 0; in <= dist; in += 64) {
/*     */       
/* 136 */       int sols = 0;
/* 137 */       boolean enemy = false;
/* 138 */       for (int r = 0; r <= n.length; r += 64) {
/*     */         
/* 140 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 141 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 142 */         x /= 64;
/* 143 */         y /= 64;
/*     */         
/* 145 */         if (solid(x, y)) {
/* 146 */           sols += 64;
/*     */         }
/* 148 */         if (!enemy && (BattleStatus.map()).hasEnemy.is(x, y, this.u.getArmy())) {
/* 149 */           enemy = true;
/*     */         }
/*     */       } 
/*     */       
/* 153 */       if (sols * 2 > n.length)
/* 154 */         return false; 
/* 155 */       if (enemy) {
/* 156 */         return true;
/*     */       }
/*     */     } 
/* 159 */     return false; }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean blocked(int x, int y, double r, ContextLines.Line l) {
/* 164 */     if (solid(x, y))
/* 165 */       return true; 
/* 166 */     if (r > 0.0D) {
/* 167 */       int ox = (int)(l.sx + (r - 64.0D) * l.dx);
/* 168 */       int oy = (int)(l.sy + (r - 64.0D) * l.dy);
/* 169 */       ox /= 64;
/* 170 */       oy /= 64;
/* 171 */       if (solid(ox, y) || solid(x, oy))
/*     */       {
/* 173 */         return true;
/*     */       }
/*     */     } 
/* 176 */     return false; }
/*     */   private boolean checkBlockageAndChopUpIfNeeded(ContextLines.Line l) { double start = 0.0D; double minSize = 256.0D; boolean blocked = false; for (int r = 0; r < l.length; r += 64) { int x = (int)(l.sx + r * l.dx); int y = (int)(l.sy + r * l.dy); x /= 64; y /= 64; if (blocked(x, y, r, l)) { blocked = true; if (r - start > minSize) {
/*     */           ContextLines.Line nl = this.lines.makeNew(); nl.dx = l.dx; nl.dy = l.dy; nl.length = (int)(r - start); nl.sx = (int)(l.sx + start * l.dx); nl.sy = (int)(l.sy + start * l.dy);
/*     */         }  start = (r + 64); }
/*     */        }
/* 181 */      return !blocked; } public boolean solid(double dx, double dy) { int tx = (int)dx;
/* 182 */     int ty = (int)dy;
/* 183 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 184 */       return true; 
/* 185 */     if (!DivPlacability.tileIsOK(tx, ty, this.u.getArmy()))
/* 186 */       return true; 
/* 187 */     return false; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLinesChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
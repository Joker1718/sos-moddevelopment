/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StepLinesBlocker
/*     */ {
/*     */   private final StrategosUtil u;
/*     */   private final Bitmap2D blob;
/*     */   private final Bitmap2D block;
/*     */   private final ContextLines lines;
/*     */   private final VectorImp vec;
/*     */   
/*     */   StepLinesBlocker(StrategosUtil u, Context c) {
/* 104 */     this.vec = new VectorImp();
/*     */     this.u = u;
/*     */     this.blob = c.blob;
/*     */     this.lines = c.lines;
/* 108 */     this.block = c.block; } private boolean block(ContextLines.Line n) { this.vec.set(n.dx, n.dy);
/* 109 */     this.vec.rotate90();
/* 110 */     this.vec.rotate90();
/* 111 */     this.vec.rotate90();
/*     */     int in;
/* 113 */     for (in = -1024; in < 1024; in += 64) {
/*     */       
/* 115 */       int ra = n.length - 128;
/* 116 */       if (in > 0)
/* 117 */         ra = (int)(ra * (1.0D - (in / 64) / 16.0D)); 
/* 118 */       int st = (n.length - ra) / 2;
/* 119 */       ra = n.length - st;
/*     */       
/* 121 */       for (int r = st; r < ra; r += 64) {
/*     */         
/* 123 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 124 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 125 */         x /= 64;
/* 126 */         y /= 64;
/*     */         
/* 128 */         if (this.block.is(x, y)) {
/* 129 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     for (in = -1024; in < 1024; in += 64) {
/* 135 */       int ra = n.length - 128;
/* 136 */       if (in > 0)
/* 137 */         ra = (int)(ra * (1.0D - (in / 64) / 16.0D)); 
/* 138 */       int st = (n.length - ra) / 2;
/* 139 */       ra = n.length - st;
/*     */       
/* 141 */       for (int r = st; r < ra; r += 64) {
/*     */         
/* 143 */         int x = (int)(n.sx + this.vec.nX() * in + r * n.dx);
/* 144 */         int y = (int)(n.sy + this.vec.nY() * in + r * n.dy);
/* 145 */         x /= 64;
/* 146 */         y /= 64;
/*     */         
/* 148 */         this.block.set(x, y, true);
/*     */       } 
/*     */     } 
/*     */     
/* 152 */     return true; }
/*     */ 
/*     */   
/*     */   public void make() {
/*     */     this.block.clear();
/*     */     PathUtilOnline.Flooder f = this.u.flooder.getFlooder();
/*     */     f.init(this);
/*     */     for (int ty = 0; ty < SETT.THEIGHT; ty++) {
/*     */       for (int tx = 0; tx < SETT.TWIDTH; tx++)
/*     */         f.setValue2(tx, ty, -1.0D); 
/*     */     } 
/*     */     for (int li = 0; li < this.lines.lines(); li++) {
/*     */       ContextLines.Line l = this.lines.get(li);
/*     */       l.mark = 0;
/*     */       int x = l.cx() >> 6;
/*     */       int y = l.cy() >> 6;
/*     */       f.setValue2(x, y, li);
/*     */     } 
/*     */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*     */       Div d = (Div)this.u.getArmy().divisions().get(di);
/*     */       if (d.active()) {
/*     */         DivFormation pos = d.position();
/*     */         int x1 = pos.start().x();
/*     */         int y1 = pos.start().x();
/*     */         x1 = (int)(x1 + pos.dx() * pos.width());
/*     */         y1 = (int)(y1 + pos.dy() * pos.width());
/*     */         f.pushSloppy(x1 / 64, y1 / 64, 0.0D);
/*     */       } 
/*     */     } 
/*     */     while (f.hasMore()) {
/*     */       PathTile t = f.pollSmallest();
/*     */       if (t.getValue2() >= 0.0F) {
/*     */         ContextLines.Line n = this.lines.get((int)t.getValue2());
/*     */         if (block(n))
/*     */           n.mark = 1; 
/*     */         continue;
/*     */       } 
/*     */       for (int j = 0; j < DIR.ORTHO.size(); j++) {
/*     */         DIR d = (DIR)DIR.ORTHO.get(j);
/*     */         if (SETT.IN_BOUNDS((COORDINATE)t, d))
/*     */           f.pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance() * (this.blob.is((COORDINATE)t) ? 5 : true)); 
/*     */       } 
/*     */     } 
/*     */     for (int i = 0; i < this.lines.lines(); i++) {
/*     */       if ((this.lines.get(i)).mark == 0) {
/*     */         this.lines.remove(i);
/*     */         i--;
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLinesBlocker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
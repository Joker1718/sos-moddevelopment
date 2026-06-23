/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StepLinesMaker
/*     */ {
/*     */   private final StrategosUtil u;
/*     */   private final Bitmap2D blob;
/*     */   private final ContextLines lines;
/*     */   private final double minDist;
/*     */   private final double maxDist;
/*     */   private final VectorImp vec;
/*     */   
/*     */   StepLinesMaker(StrategosUtil u, Context c) {
/* 177 */     this.minDist = dist(4, 4);
/* 178 */     this.maxDist = dist(8, 8);
/* 179 */     this.vec = new VectorImp();
/*     */     this.u = u;
/*     */     this.blob = c.blob;
/* 182 */     this.lines = c.lines; } private void make(PathUtilOnline.Flooder f, PathTile t) { if (t.getValue2() != 1.0F) {
/*     */       return;
/*     */     }
/* 185 */     PathTile res = trymake(f, t, t, t, this.maxDist);
/* 186 */     if (res == null) {
/* 187 */       res = trymake(f, t, t, t, this.minDist);
/*     */     }
/* 189 */     if (res != null) {
/* 190 */       ContextLines.Line line = this.lines.makeNew();
/*     */       
/* 192 */       int sx = t.x() * 64 + 32;
/* 193 */       int sy = t.y() * 64 + 32;
/* 194 */       int ex = res.x() * 64 + 32;
/* 195 */       int ey = res.y() * 64 + 32;
/* 196 */       line.length = (int)this.vec.set(sx, sy, ex, ey);
/* 197 */       line.sx = sx;
/* 198 */       line.sy = sy;
/* 199 */       line.dx = this.vec.nX();
/* 200 */       line.dy = this.vec.nY();
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private PathTile trymake(PathUtilOnline.Flooder f, PathTile start, PathTile prev, PathTile current, double targetDistPow) {
/* 207 */     if (current.getValue2() != 1.0F) {
/* 208 */       return null;
/*     */     }
/* 210 */     f.setValue2((COORDINATE)current, 2.0D);
/*     */     
/* 212 */     int dx = start.x() - current.x();
/* 213 */     int dy = start.y() - current.y();
/* 214 */     double dist = dist(dx, dy);
/* 215 */     if (dist >= targetDistPow) {
/* 216 */       return current;
/*     */     }
/* 218 */     for (int i = 0; i < DIR.ALL.size(); i++) {
/* 219 */       DIR d = (DIR)DIR.ALL.get(i);
/* 220 */       int x = current.x() + d.x();
/* 221 */       int y = current.y() + d.y();
/* 222 */       if (!prev.isSameAs(x, y))
/*     */       {
/* 224 */         if (SETT.IN_BOUNDS(x, y))
/*     */         {
/* 226 */           if (f.getValue2(x, y) == 1.0F) {
/*     */             
/* 228 */             PathTile t = trymake(f, start, current, f.get(x, y), targetDistPow);
/* 229 */             if (t != null) {
/* 230 */               f.setValue2((COORDINATE)current, 2.0D);
/* 231 */               return t;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       }
/*     */     } 
/* 237 */     return null;
/*     */   } public void make() { this.lines.clear(); PathUtilOnline.Flooder f = this.u.flooder.getFlooder(); f.init(this); for (int ty = 0; ty < SETT.THEIGHT; ty++) { for (int tx = 0; tx < SETT.TWIDTH; tx++) { f.setValue2(tx, ty, 0.0D); if (!this.blob.is(tx, ty)) { f.pushSloppy(tx, ty, (ty * SETT.TWIDTH + tx)); f.setValue2(tx, ty, 0.0D); }  }  }  int ww = SETT.TAREA * 2; while (f.hasMore()) { PathTile t = f.pollSmallest(); if (t.getValue() >= ww) { f.reopen(t); f.pushSloppy(t.x(), t.y(), 0.0D); break; }  for (int m = 0; m < DIR.ORTHO.size(); m++) { DIR d = (DIR)DIR.ORTHO.get(m); if (this.blob.is((COORDINATE)t, d)) { f.pushSmaller((COORDINATE)t, d, (t.getValue() + ww)); f.setValue2((COORDINATE)t, d, 1.0D); }  }  }  while (f.hasMore()) { PathTile t = f.pollSmallest(); make(f, t); }  f.done(); f.init(this); int id = 0; for (int k = 0; k < SETT.THEIGHT; k++) { for (int tx = 0; tx < SETT.TWIDTH; tx++) { if (!f.hasBeenPushed(tx, k) && this.blob.is(tx, k)) { f.pushSloppy(tx, k, 0.0D); while (f.hasMore()) { PathTile t = f.pollSmallest(); t.setValue2(id); for (int m = 0; m < DIR.ORTHO.size(); m++) { if (this.blob.is((COORDINATE)t, (DIR)DIR.ORTHO.get(m))) f.pushSmaller((COORDINATE)t, (DIR)DIR.ORTHO.get(m), (t.getValue() + 1.0F));  }  }  id++; }  }  }  f.done(); for (int j = 0; j < this.lines.lines(); j++) { ContextLines.Line n = this.lines.get(j); int cx = n.sx; int cy = n.sy; cx /= 64; cy /= 64; n.blobID = (int)f.getValue2(cx, cy); }  f.init(this); for (int i = 0; i < this.lines.lines(); i++) { ContextLines.Line n = this.lines.get(i); int cx = n.cx(); int cy = n.cy(); cx /= 64; cy /= 64; f.setValue2(cx, cy, -(i + 1)); }  for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) { Div d = (Div)this.u.getArmy().enemy().divisions().get(di); for (int m = 0; m < d.position().deployed(); m++) { int x = d.position().tx(m); int y = d.position().ty(m); f.pushSloppy(x, y, 0.0D); }  }  while (f.hasMore()) { PathTile t = f.pollSmallest(); if (t.getValue2() < 0.0F) { ContextLines.Line n = this.lines.get((int)-t.getValue2() - 1); int cx = n.cx(); int cy = n.cy(); PathTile o = t; while (o.getParent() != null)
/*     */           o = o.getParent();  int ex = o.x() * 64 + 32; int ey = o.y() * 64 + 32; if (this.vec.set(cx, cy, ex, ey) <= 0.0D || (this.vec.nX() == 0.0D && this.vec.nY() == 0.0D))
/*     */           this.vec.set(1.0D, 1.0D);  this.vec.rotate90(); n.sx = (int)(cx - this.vec.nX() * n.length / 2.0D); n.sy = (int)(cy - this.vec.nY() * n.length / 2.0D); n.dx = this.vec.nX(); n.dy = this.vec.nY(); }  for (int m = 0; m < DIR.ALL.size(); m++) { DIR d = (DIR)DIR.ALL.get(m); if (SETT.IN_BOUNDS((COORDINATE)t, d))
/* 241 */           f.pushSmaller((COORDINATE)t, d, d.tileDistance(), t);  }  }  f.done(); } private double dist(int dx, int dy) { return (dx * dx + dy * dy); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepLinesMaker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
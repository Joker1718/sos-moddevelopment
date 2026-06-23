/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.iterators.RECedgeIter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StepBlob
/*     */ {
/*     */   private final StrategosUtil context;
/*  28 */   private final double tileRange = 32.0D;
/*  29 */   private final Node[] nodes = new Node[(Config.battle()).DIVISIONS_PER_ARMY];
/*  30 */   private final ArrayList<Node> anodes = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  31 */   private final Node[][] nmap = new Node[(int)Math.ceil(SETT.TWIDTH / 32.0D)][(int)Math.ceil(SETT.THEIGHT / 32.0D)];
/*  32 */   private final Rec rec = new Rec();
/*     */   
/*  34 */   private final Coo[] coos = new Coo[(Config.battle()).DIVISIONS_PER_ARMY];
/*     */ 
/*     */ 
/*     */   
/*     */   RECedgeIter iter;
/*     */ 
/*     */   
/*     */   private final double tileRange2 = 1024.0D;
/*     */ 
/*     */ 
/*     */   
/*     */   void update(Bitmap2D blob, int range) {
/*  46 */     blob.clear();
/*     */     
/*  48 */     this.anodes.clearSloppy();
/*  49 */     this.rec.setDim(1.0D, 1.0D).moveX1Y1(0.0D, 0.0D);
/*     */     
/*  51 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*     */ 
/*     */       
/*  54 */       Div d = (Div)this.context.getArmy().enemy().divisions().get(di);
/*  55 */       if (d.active()) {
/*     */         
/*  57 */         int tx = d.centre().cUnitX() >> 6;
/*  58 */         int ty = d.centre().cUnitY() >> 6;
/*  59 */         Coo c = this.coos[d.indexArmy()];
/*  60 */         if (c.tileDistanceTo(tx, ty) > 10.0D) {
/*  61 */           c.set(tx, ty);
/*     */         }
/*     */ 
/*     */         
/*  65 */         Node n = this.nodes[di];
/*  66 */         n.next = null;
/*  67 */         n.coo.set(c.x(), c.y());
/*  68 */         this.anodes.add(n);
/*     */       } else {
/*  70 */         this.coos[d.indexArmy()].set(-1024.0D, -1024.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  76 */     if (this.anodes.size() > 0) {
/*  77 */       fill(blob, (LIST<Node>)this.anodes, range);
/*     */     }
/*     */   }
/*     */   
/*     */   public RECTANGLE area() {
/*  82 */     return (RECTANGLE)this.rec;
/*     */   } private void fill(Bitmap2D blob, LIST<Node> nodes, int range) { if (this.context.getArmy().men() == 0) return;  for (int y = 0; y < this.nmap.length; y++) { for (int x = 0; x < this.nmap.length; x++) this.nmap[y][x] = null;  }  PathUtilOnline.Flooder f = this.context.flooder.getFlooder(); f.init(this); this.rec.setDim(1.0D, 1.0D).moveX1Y1((COORDINATE)((Node)nodes.get(0)).coo); for (Node n : nodes) add(n, f);  while (f.hasMore()) { PathTile t = f.pollSmallest(); if (t.getValue() > range) { f.pushSloppy(t.x(), t.y(), t.getValue()); break; }  blob.set((COORDINATE)t, true); this.rec.unify(t.x(), t.y()); if (t.getValue() < 12.0F) { for (int j = 0; j < DIR.ALL.size(); j++) { int dx = t.x() + ((DIR)DIR.ALL.get(j)).x(); int dy = t.y() + ((DIR)DIR.ALL.get(j)).y(); if (blob.body().holdsPoint(dx, dy) && !(SETT.PATH()).solidity.is(dx, dy) && f.pushSmaller(dx, dy, (t.getValue() + 1.0F)) != null) f.setValue2(dx, dy, t.getValue2());  }  continue; }  for (int i = 0; i < DIR.ORTHO.size(); i++) { int dx = t.x() + ((DIR)DIR.ORTHO.get(i)).x(); int dy = t.y() + ((DIR)DIR.ORTHO.get(i)).y(); if (blob.body().holdsPoint(dx, dy) && !(SETT.PATH()).solidity.is(dx, dy) && f.pushSmaller(dx, dy, (t.getValue() + 1.0F)) != null) f.setValue2(dx, dy, t.getValue2());  }  }  this.iter.init(SETT.TILE_BOUNDS); for (COORDINATE c : this.iter) { if (!f.hasBeenPushed(c)) f.pushSloppy(c, 0.0D);  }  while (f.hasMore()) { PathTile t = f.pollSmallest(); for (int i = 0; i < DIR.ORTHO.size(); i++) { int dx = t.x() + ((DIR)DIR.ORTHO.get(i)).x(); int dy = t.y() + ((DIR)DIR.ORTHO.get(i)).y(); if (blob.body().holdsPoint(dx, dy) && !f.hasBeenPushed(dx, dy))
/*     */           f.pushSmaller(dx, dy, (t.getValue() + 1.0F));  }  }  for (int ty = 0; ty < SETT.THEIGHT; ty++) { for (int tx = 0; tx < SETT.TWIDTH; tx++) { if (!f.hasBeenPushed(tx, ty))
/*  85 */           blob.set(tx, ty, true);  }  }  f.done(); } public StepBlob(StrategosUtil context) { this.iter = new RECedgeIter();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 201 */     this.tileRange2 = 1024.0D; for (int i = 0; i < this.nodes.length; i++)
/*     */       this.nodes[i] = new Node(); 
/*     */     this.context = context;
/*     */     for (int c = 0; c < this.coos.length; c++)
/* 205 */       this.coos[c] = new Coo(-16.0D, -16.0D);  } private void add(Node n, Node other, PathUtilOnline.Flooder f) { while (other != null) {
/*     */       
/* 207 */       Node o = other;
/* 208 */       other = other.next;
/* 209 */       double dx = (o.coo.x() - n.coo.x());
/* 210 */       double dy = (o.coo.y() - n.coo.y());
/* 211 */       if (dx * dx + dy * dy > 1024.0D) {
/*     */         continue;
/*     */       }
/* 214 */       double step = Math.max(Math.abs(dx), Math.abs(dy));
/* 215 */       if (step <= 0.0D) {
/*     */         continue;
/*     */       }
/* 218 */       dx /= step;
/* 219 */       dy /= step;
/*     */       
/* 221 */       if (testLine(n, step, dx, dy))
/* 222 */         addLine(n, f, step, dx, dy); 
/*     */     }  } private void add(Node n, PathUtilOnline.Flooder f) { if (!SETT.IN_BOUNDS((COORDINATE)n.coo))
/*     */       return;  f.pushSloppy((COORDINATE)n.coo, 0.0D); for (int di = 0; di < DIR.ALLC.size(); di++) {
/*     */       DIR d = (DIR)DIR.ALLC.get(di); int i = (int)(n.coo.x() + d.xN() * 32.0D); int j = (int)(n.coo.y() + d.yN() * 32.0D); if (SETT.IN_BOUNDS(i, j)) {
/*     */         int nx = (int)(i / 32.0D); int ny = (int)(j / 32.0D); Node other = this.nmap[ny][nx]; add(n, other, f);
/*     */       } 
/*     */     }  int x = (int)(n.coo.x() / 32.0D); int y = (int)(n.coo.y() / 32.0D); n.next = this.nmap[y][x];
/*     */     this.nmap[y][x] = n; }
/* 230 */   private boolean testLine(Node n, double step, double dx, double dy) { double x = n.coo.x() + 0.5D;
/* 231 */     double y = n.coo.y() + 0.5D;
/* 232 */     for (double d = 0.0D; d < step; d++) {
/*     */       
/* 234 */       int fx = (int)x;
/* 235 */       int fy = (int)y;
/* 236 */       x += dx;
/* 237 */       y += dy;
/* 238 */       int tx = (int)x;
/* 239 */       int ty = (int)y;
/* 240 */       if (fx != tx || fy != ty) {
/*     */         
/* 242 */         if (!SETT.IN_BOUNDS(tx, ty))
/* 243 */           return false; 
/* 244 */         if ((SETT.PATH()).solidity.is(tx, ty) || (SETT.PATH()).solidity.is(fx, ty) || (SETT.PATH()).solidity.is(tx, fy))
/* 245 */           return false; 
/*     */       } 
/* 247 */     }  return true; }
/*     */ 
/*     */   
/*     */   private void addLine(Node n, PathUtilOnline.Flooder f, double step, double dx, double dy) {
/* 251 */     double x = n.coo.x() + 0.5D;
/* 252 */     double y = n.coo.y() + 0.5D;
/*     */ 
/*     */ 
/*     */     
/* 256 */     for (double d = 0.0D; d < step; d++) {
/* 257 */       x += dx;
/* 258 */       y += dy;
/* 259 */       int tx = (int)x;
/* 260 */       int ty = (int)y;
/* 261 */       f.pushSloppy(tx, ty, 0.0D);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class Node
/*     */   {
/*     */     Node next;
/* 268 */     final Coo coo = new Coo();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepBlob.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
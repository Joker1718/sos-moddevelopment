/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SComp0Quads
/*     */ {
/*     */   private final int QuadrantSize;
/*     */   private final int QScroll;
/*     */   private final int quadsDim;
/*     */   private final Bitmap1D up;
/*     */   private final Bitmap1D change;
/*     */   private final IntegerStack needsUpdate;
/*     */   private final Rec grid;
/*     */   public MAP_BOOLEAN updating;
/*     */   
/*     */   public SComp0Quads(int size) {
/* 161 */     this.updating = new MAP_BOOLEAN()
/*     */       {
/*     */         public boolean is(int tx, int ty)
/*     */         {
/* 165 */           int x = tx >> SComp0Quads.this.QScroll;
/* 166 */           int y = ty >> SComp0Quads.this.QScroll;
/* 167 */           int qi = x + y * SComp0Quads.this.quadsDim;
/* 168 */           if (x > 0 && y > 0 && x < SComp0Quads.this.quadsDim && y < SComp0Quads.this.quadsDim && SComp0Quads.this.up.get(qi)) {
/* 169 */             return true;
/*     */           }
/* 171 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean is(int tile) {
/* 176 */           return is(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*     */         }
/*     */       };
/*     */     this.QuadrantSize = size;
/*     */     this.QScroll = Integer.numberOfTrailingZeros(this.QuadrantSize);
/*     */     this.quadsDim = SETT.TWIDTH / this.QuadrantSize;
/*     */     this.up = new Bitmap1D(this.quadsDim * this.quadsDim, false);
/*     */     this.change = new Bitmap1D(this.quadsDim * this.quadsDim, false);
/*     */     this.needsUpdate = new IntegerStack(this.quadsDim * this.quadsDim);
/*     */     this.grid = new Rec(this.QuadrantSize, this.QuadrantSize);
/*     */   }
/*     */   
/*     */   public void setChangedAvailability(int tx, int ty) {
/*     */     if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return; 
/*     */     for (int i = 0; i < DIR.ALLC.size(); i++) {
/*     */       int x = tx + ((DIR)DIR.ALLC.get(i)).x() >> this.QScroll;
/*     */       int y = ty + ((DIR)DIR.ALLC.get(i)).y() >> this.QScroll;
/*     */       if (x >= 0 && y >= 0 && x < this.quadsDim && y < this.quadsDim) {
/*     */         int qi = x + y * this.quadsDim;
/*     */         if (!this.change.get(qi)) {
/*     */           this.needsUpdate.push(qi);
/*     */           this.change.set(qi, true);
/*     */         } 
/*     */         this.up.set(qi, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setChangedServices(int tx, int ty) {
/*     */     if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return; 
/*     */     for (int i = 0; i < DIR.ALLC.size(); i++) {
/*     */       int x = tx + ((DIR)DIR.ALLC.get(i)).x() >> this.QScroll;
/*     */       int y = ty + ((DIR)DIR.ALLC.get(i)).y() >> this.QScroll;
/*     */       int qi = x + y * this.quadsDim;
/*     */       if (x >= 0 && y >= 0 && x < this.quadsDim && y < this.quadsDim && !this.up.get(qi) && !this.change.get(qi)) {
/*     */         this.needsUpdate.push(qi);
/*     */         this.change.set(qi, true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void changeAll() {
/*     */     this.change.setAll(true);
/*     */     this.up.setAll(true);
/*     */     this.needsUpdate.clear();
/*     */     for (int i = 0; !this.needsUpdate.isFull(); i++)
/*     */       this.needsUpdate.push(i); 
/*     */   }
/*     */   
/*     */   public boolean updating() {
/*     */     return (this.needsUpdate.size() > 0);
/*     */   }
/*     */   
/*     */   public void clear() {
/*     */     this.needsUpdate.clear();
/*     */     this.up.clear();
/*     */     this.change.clear();
/*     */   }
/*     */   
/*     */   void update(SComp0Updater updater) {
/*     */     if (this.needsUpdate.size() > 0)
/*     */       (SETT.ENTRY()).points.updateAvailability(); 
/*     */     int ii;
/*     */     for (ii = 0; ii < this.needsUpdate.size(); ii++) {
/*     */       int i = this.needsUpdate.get(ii);
/*     */       int tx = i % this.quadsDim;
/*     */       int ty = i / this.quadsDim;
/*     */       this.grid.moveX1Y1((tx << this.QScroll), (ty << this.QScroll));
/*     */       if (this.up.get(i))
/*     */         updater.removeSuperComp((RECTANGLE)this.grid, this); 
/*     */     } 
/*     */     for (ii = 0; ii < this.needsUpdate.size(); ii++) {
/*     */       int i = this.needsUpdate.get(ii);
/*     */       int tx = i % this.quadsDim;
/*     */       int ty = i / this.quadsDim;
/*     */       this.grid.moveX1Y1((tx << this.QScroll), (ty << this.QScroll));
/*     */       if (this.up.get(i))
/*     */         updater.remove((RECTANGLE)this.grid, this); 
/*     */     } 
/*     */     while (!this.needsUpdate.isEmpty()) {
/*     */       int i = this.needsUpdate.pop();
/*     */       int tx = i % this.quadsDim;
/*     */       int ty = i / this.quadsDim;
/*     */       this.grid.moveX1Y1((tx << this.QScroll), (ty << this.QScroll));
/*     */       boolean bup = this.up.get(i);
/*     */       this.up.set(i, false);
/*     */       this.change.set(i, false);
/*     */       if (bup) {
/*     */         updater.assign((RECTANGLE)this.grid, this);
/*     */         continue;
/*     */       } 
/*     */       updater.initData((RECTANGLE)this.grid);
/*     */     } 
/*     */   }
/*     */   
/*     */   public RECTANGLE popNext() {
/*     */     if (this.needsUpdate.isEmpty())
/*     */       return null; 
/*     */     int i = this.needsUpdate.pop();
/*     */     int tx = i % this.quadsDim;
/*     */     int ty = i / this.quadsDim;
/*     */     this.up.set(i, false);
/*     */     this.grid.moveX1Y1((tx << this.QScroll), (ty << this.QScroll));
/*     */     return (RECTANGLE)this.grid;
/*     */   }
/*     */   
/*     */   public RECTANGLE peekpNext(int ii) {
/*     */     int i = this.needsUpdate.get(ii);
/*     */     int tx = i % this.quadsDim;
/*     */     int ty = i / this.quadsDim;
/*     */     this.grid.moveX1Y1((tx << this.QScroll), (ty << this.QScroll));
/*     */     return (RECTANGLE)this.grid;
/*     */   }
/*     */   
/*     */   public int updatable() {
/*     */     return this.needsUpdate.size();
/*     */   }
/*     */   
/*     */   public boolean upping() {
/*     */     return (this.needsUpdate.size() > 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0Quads.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.map.MAP_DOUBLEE;
/*    */ import snake2d.util.map.MAP_INTE;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class TAmount
/*    */   implements MAP_INTE
/*    */ {
/*    */   public final int max;
/*    */   public final double maxI;
/*    */   public final MAP_DOUBLEE DM;
/*    */   
/*    */   TAmount(final int max, CharSequence name) {
/* 71 */     this.DM = new MAP_DOUBLEE()
/*    */       {
/*    */         public double get(int tx, int ty)
/*    */         {
/* 75 */           return TAmount.this.get(tx, ty) * TAmount.this.maxI;
/*    */         }
/*    */ 
/*    */         
/*    */         public double get(int tile) {
/* 80 */           return TAmount.this.get(tile) * TAmount.this.maxI;
/*    */         }
/*    */ 
/*    */         
/*    */         public MAP_DOUBLEE set(int tx, int ty, double value) {
/* 85 */           TAmount.this.set(tx, ty, (int)(value * TAmount.this.max));
/* 86 */           return this;
/*    */         }
/*    */ 
/*    */         
/*    */         public MAP_DOUBLEE set(int tile, double value) {
/* 91 */           TAmount.this.set(tile, (int)(value * TAmount.this.max));
/* 92 */           return this;
/*    */         }
/*    */       };
/*    */     this.max = max;
/*    */     this.maxI = 1.0D / max;
/*    */     final PlacableMulti undo = new PlacableMulti(String.valueOf(name) + " decrease") {
/*    */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */           TAmount.this.increment(tx, ty, -1);
/*    */         }
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */           return (TAmount.this.get(tx, ty) > 0) ? null : E;
/*    */         }
/*    */       };
/*    */     PlacableMulti place = new PlacableMulti(String.valueOf(name) + " increase") {
/*    */         public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */           TAmount.this.increment(tx, ty, 1);
/*    */         }
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/*    */           return (TAmount.this.get(tx, ty) < max) ? null : E;
/*    */         }
/*    */         
/*    */         public PLACABLE getUndo() {
/*    */           return (PLACABLE)undo;
/*    */         }
/*    */       };
/*    */     IDebugPanelSett.add((PLACABLE)place);
/*    */   }
/*    */   
/*    */   public int get(int tx, int ty) {
/*    */     if (SETT.IN_BOUNDS(tx, ty))
/*    */       return get(tx + ty * SETT.TWIDTH); 
/*    */     return 0;
/*    */   }
/*    */   
/*    */   public MAP_INTE set(int tx, int ty, int value) {
/*    */     if (SETT.IN_BOUNDS(tx, ty))
/*    */       return set(tx + ty * SETT.TWIDTH, value); 
/*    */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TAmount.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
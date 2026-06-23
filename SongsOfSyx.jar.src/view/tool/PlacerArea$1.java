/*    */ package view.tool;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_SETTER;
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
/*    */ class null
/*    */   implements MAP_SETTER
/*    */ {
/*    */   public MAP_SETTER set(int tx, int ty) {
/* 43 */     if (SETT.IN_BOUNDS(tx, ty)) {
/* 44 */       PlacerArea.this.bounds.unify(tx, ty);
/* 45 */       int i = tx + ty * SETT.TWIDTH;
/* 46 */       if (!PlacerArea.this.map.get(i)) {
/* 47 */         PlacerArea.this.area++;
/* 48 */         PlacerArea.this.map.set(i, true);
/*    */       } 
/*    */     } 
/*    */     
/* 52 */     return this;
/*    */   }
/*    */ 
/*    */   
/*    */   public MAP_SETTER set(int tile) {
/* 57 */     throw new RuntimeException();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\PlacerArea$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
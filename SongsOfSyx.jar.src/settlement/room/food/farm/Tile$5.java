/*    */ package settlement.room.food.farm;
/*    */ 
/*    */ import snake2d.LOG;
/*    */ import view.sett.SettDebugClick;
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
/*    */   extends SettDebugClick
/*    */ {
/*    */   public boolean debug(int px, int py, int tx, int ty) {
/* 75 */     if (Tile.this.get(tx, ty) == null)
/* 76 */       return false; 
/* 77 */     Tile.Cycle c = Tile.this.cycle();
/* 78 */     LOG.ln(c.name);
/* 79 */     LOG.ln("size " + c.size());
/* 80 */     LOG.ln("growth " + c.growth());
/*    */     
/* 82 */     c.debug();
/* 83 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Tile$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
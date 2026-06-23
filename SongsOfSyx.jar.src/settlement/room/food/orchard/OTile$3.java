/*    */ package settlement.room.food.orchard;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends SettDebugClick
/*    */ {
/*    */   public boolean debug(int px, int py, int tx, int ty) {
/* 79 */     if (OTile.this.get(tx, ty) == null) {
/* 80 */       return false;
/*    */     }
/* 82 */     if (OTile.this.get(tx, ty) != null) {
/* 83 */       OTile.this.setState(OTile.this.IDEAD);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\OTile$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package settlement.room.industry.mine;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.job.RoomResStorage;
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
/*    */   extends RoomResStorage
/*    */ {
/*    */   null(int $anonymous0) {
/* 29 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public RESOURCE resource() {
/* 33 */     return print.minable.resource;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 38 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void changed(int tx, int ty) {
/* 43 */     if (hasRoom()) {
/* 44 */       MineInstance m = (MineInstance)print.get(tx, ty);
/* 45 */       m.hasStorage = true;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\mine\Job$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
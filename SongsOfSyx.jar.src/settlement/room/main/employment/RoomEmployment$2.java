/*    */ package settlement.room.main.employment;
/*    */ 
/*    */ import init.type.WGROUP;
/*    */ import settlement.main.SETT;
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
/*    */   extends RoomEmployment.GRoupInt
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 43 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(WGROUP t, int i) {
/* 47 */     int o = get(t);
/* 48 */     super.set(t, i);
/* 49 */     if (o != get(t))
/* 50 */       (SETT.ROOMS()).employment.employer.updateAll(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployment$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
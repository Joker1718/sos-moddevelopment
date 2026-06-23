/*    */ package settlement.room.home;
/*    */ 
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface HOME
/*    */ {
/*    */   HOME vacate(Humanoid paramHumanoid);
/*    */   
/*    */   HOME occupy(Humanoid paramHumanoid);
/*    */   
/*    */   Humanoid occupant(int paramInt);
/*    */   
/*    */   int occupants();
/*    */   
/*    */   int occupantsMax();
/*    */   
/*    */   int serviceX();
/*    */   
/*    */   int serviceY();
/*    */   
/*    */   int resourceAm(int paramInt);
/*    */   
/*    */   double isolation();
/*    */   
/*    */   boolean canOccupy(Humanoid paramHumanoid);
/*    */   
/*    */   CharSequence typeName(int paramInt1, int paramInt2);
/*    */   
/*    */   static HOME get(int tx, int ty) {
/* 33 */     HOME h = (HOME)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 34 */     if (h != null)
/* 35 */       return h; 
/* 36 */     return (HOME)(SETT.ROOMS()).CHAMBER.get(tx, ty);
/*    */   }
/*    */   
/*    */   boolean is(int paramInt1, int paramInt2);
/*    */   
/*    */   int area();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\HOME.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
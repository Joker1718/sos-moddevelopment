/*    */ package settlement.maintenance;
/*    */ 
/*    */ import init.resources.RESOURCE;
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
/*    */ public abstract class ROOM_DEGRADER
/*    */ {
/*    */   public abstract int getData();
/*    */   
/*    */   protected abstract void setData(int paramInt, boolean paramBoolean);
/*    */   
/*    */   public double get() {
/* 22 */     return get(getData());
/*    */   }
/*    */   
/*    */   public static double get(int data) {
/* 26 */     return MRoom.degrade(data);
/*    */   }
/*    */   
/*    */   public boolean isRealDegraded() {
/* 30 */     return MRoom.degradeReal(getData());
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract int resSize();
/*    */ 
/*    */   
/*    */   public abstract int resAmount(int paramInt);
/*    */   
/*    */   public abstract RESOURCE res(int paramInt);
/*    */   
/*    */   public static double rate(double boost, double base, double isolation, double resAm, int area) {
/* 42 */     boost *= 1.0D + (1.0D - isolation) * 2.0D;
/* 43 */     SETT.MAINTENANCE().getClass(); double v = boost * 0.020833333333333332D * area;
/* 44 */     SETT.MAINTENANCE().getClass(); v += boost * 0.015625D * resAm;
/* 45 */     return base * v;
/*    */   } public abstract int roomArea(); public abstract double base(); public abstract double expenseRate();
/*    */   public abstract double degRate();
/*    */   public static double rateResource(double boost, double base, double isolation, double resAm) {
/* 49 */     boost *= 1.0D + (1.0D - isolation) * 2.0D;
/* 50 */     SETT.MAINTENANCE().getClass(); return base * boost * 0.015625D * resAm;
/*    */   }
/*    */   
/*    */   public abstract double rate(double paramDouble);
/*    */   
/*    */   public int jobs() {
/* 56 */     return MRoom.jobs(getData(), roomArea());
/*    */   }
/*    */   
/*    */   public double getSecret() {
/* 60 */     return MRoom.secretDegrade(getData());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\maintenance\ROOM_DEGRADER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
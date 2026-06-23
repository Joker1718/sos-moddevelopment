/*    */ package settlement.room.main.util;
/*    */ 
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ 
/*    */ public final class RoomInit
/*    */ {
/*    */   public final double[] res;
/*    */   public final double[] stats;
/*  9 */   public double resMul = 1.0D;
/*    */   public final int degrade;
/*    */   
/*    */   public RoomInit(RoomBlueprintImp b, int degrade) {
/* 13 */     if (b.constructor() != null) {
/* 14 */       this.res = new double[b.constructor().resources()];
/* 15 */       this.stats = new double[b.constructor().stats().size()];
/*    */     } else {
/*    */       
/* 18 */       this.stats = new double[0];
/* 19 */       this.res = new double[0];
/*    */     } 
/* 21 */     this.degrade = degrade;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\mai\\util\RoomInit.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
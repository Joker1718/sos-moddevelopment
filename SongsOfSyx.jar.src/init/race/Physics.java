/*    */ package init.race;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ 
/*    */ 
/*    */ public final class Physics
/*    */ {
/*    */   private final transient double heightOverGround;
/*    */   private final transient int hitboxSize;
/*    */   public final int childDays;
/*    */   public final int babyDays;
/*    */   public final int adultDay;
/*    */   public final boolean decays;
/*    */   public final boolean sleeps;
/*    */   public final double slaveprice;
/*    */   public final double slavePRriceRecovery;
/*    */   public final double raiding;
/*    */   
/*    */   Physics(Json json) {
/* 20 */     json = json.json("PROPERTIES");
/*    */ 
/*    */ 
/*    */     
/* 24 */     this.heightOverGround = json.i("HEIGHT", 0, 200);
/* 25 */     this.hitboxSize = json.i("WIDTH", 5, 15) * 4;
/* 26 */     this.childDays = json.i("CHILD_DAYS");
/* 27 */     this.babyDays = json.i("BABY_DAYS");
/* 28 */     this.decays = json.bool("CORPSE_DECAY");
/* 29 */     this.sleeps = json.bool("SLEEPS");
/* 30 */     this.slaveprice = json.d("SLAVE_PRICE", 0.0D, 2.147483647E9D);
/* 31 */     this.slavePRriceRecovery = json.d("SLAVE_PRICE_RECOVERY", 0.0D, 10.0D);
/* 32 */     this.raiding = json.d("RAID_MERCINARY", 0.0D, 100000.0D);
/* 33 */     this.adultDay = this.babyDays + this.childDays;
/*    */   }
/*    */ 
/*    */   
/*    */   public double height() {
/* 38 */     return this.heightOverGround;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int hitBoxsize() {
/* 50 */     return this.hitboxSize;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\Physics.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package game.boosting;
/*    */ 
/*    */ public abstract class Booster
/*    */   extends BoosterAbs<BOOSTABLE_O> {
/*    */   public Booster(BSourceInfo info, boolean isMul) {
/*  6 */     super(info, isMul);
/*    */   }
/*    */   
/*    */   public BoostSpec add(Boostable boostable, CharSequence append) {
/* 10 */     BoostSpec b = new BoostSpec(this, boostable, append);
/* 11 */     boostable.addFactor(b);
/* 12 */     return b;
/*    */   }
/*    */   
/*    */   public BoostSpec add(Boostable boostable) {
/* 16 */     return add(boostable, null);
/*    */   }
/*    */   
/*    */   public Booster addRet(Boostable boostable) {
/* 20 */     add(boostable, null);
/* 21 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\Booster.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
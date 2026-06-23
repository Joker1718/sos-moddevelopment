/*    */ package game.boosting;
/*    */ 
/*    */ 
/*    */ public final class BoostSpec
/*    */ {
/*    */   public final Booster booster;
/*    */   public final Boostable boostable;
/*    */   public final CharSequence tName;
/*    */   
/*    */   public BoostSpec(Booster source, Boostable target, CharSequence append) {
/* 11 */     this.booster = source;
/* 12 */     this.boostable = target;
/* 13 */     CharSequence tName = target.name;
/* 14 */     if (append != null)
/* 15 */       tName = String.valueOf(tName) + " (" + String.valueOf(tName) + ")"; 
/* 16 */     this.tName = tName;
/*    */   }
/*    */ 
/*    */   
/*    */   public final double get(BOOSTABLE_O t) {
/* 21 */     return this.booster.get(t);
/*    */   }
/*    */   
/*    */   public final double inc(BOOSTABLE_O t) {
/* 25 */     return this.booster.get(t) - (this.booster.isMul ? true : false);
/*    */   }
/*    */   
/*    */   public boolean isPositive(double input) {
/* 29 */     return !((!this.booster.isMul || this.booster.getValue(input) < 1.0D) && this.booster.getValue(input) <= 0.0D);
/*    */   }
/*    */   
/*    */   public boolean isSameAs(BoostSpec other) {
/* 33 */     if (this.booster.isMul == this.booster.isMul && this.boostable == other.boostable) {
/* 34 */       return true;
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */   public String identifier() {
/* 40 */     return this.boostable.key + this.boostable.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoostSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package settlement.entity;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import init.type.CAUSE_LEAVE;
/*    */ import snake2d.LOG;
/*    */ 
/*    */ public class ECollision {
/*    */   public ENTITY other;
/*    */   public CAUSE_LEAVE leave;
/*    */   public double damagetileStrength;
/* 11 */   public double[] damage = new double[(BOOSTABLES.BATTLE()).DAMAGES.size()];
/*    */ 
/*    */   
/*    */   public double tileMomentum;
/*    */ 
/*    */   
/*    */   public double norX;
/*    */   
/*    */   public double norY;
/*    */   
/*    */   public double dirDot;
/*    */   
/*    */   public double dirDotOther;
/*    */   
/*    */   public boolean speedHasChanged;
/*    */ 
/*    */   
/*    */   public void debug() {
/* 29 */     LOG.ln("other " + String.valueOf(this.other));
/* 30 */     LOG.ln("leave " + String.valueOf(this.leave));
/* 31 */     LOG.ln("mom " + this.tileMomentum);
/* 32 */     LOG.ln("strength " + this.damagetileStrength);
/* 33 */     for (int i = 0; i < this.damage.length; i++) {
/* 34 */       LOG.ln(((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(i)).key + " " + ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(i)).key);
/*    */     }
/*    */     
/* 37 */     LOG.ln("dir " + this.dirDot);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ECollision.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
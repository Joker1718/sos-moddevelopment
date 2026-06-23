/*    */ package world.army;
/*    */ 
/*    */ import world.entity.army.WArmy;
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
/*    */   extends ADInt.ADIntImp
/*    */ {
/*    */   null(ADInit $anonymous0, String $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3) {
/* 24 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public void count(WArmy t, int delta) {
/* 28 */     ADSoldiers.this.currentTot.inc(t, get(t) * delta);
/* 29 */     super.count(t, delta);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSoldiers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
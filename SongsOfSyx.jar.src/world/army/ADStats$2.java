/*    */ package world.army;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.info.INFO;
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
/*    */   implements DOUBLE_O<Faction>
/*    */ {
/* 71 */   INFO info = new INFO(ADStats.¤¤cruelty, ADStats.¤¤cruelty);
/*    */ 
/*    */   
/*    */   public double getD(Faction t) {
/* 75 */     return CLAMP.d(-ADStats.this.mercy.getD(t), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 80 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADStats$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
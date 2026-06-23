/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   extends RTrust.BB
/*    */ {
/*    */   null(CharSequence $anonymous0, SPRITE $anonymous1, double $anonymous2, double $anonymous3, boolean $anonymous4) {
/* 38 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 42 */     return 0.5D + ROPINION.get(f.king()) / 200.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\RTrust$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
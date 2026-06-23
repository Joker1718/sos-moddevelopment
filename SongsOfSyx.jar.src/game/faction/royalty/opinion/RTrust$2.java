/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RTrust.BB
/*    */ {
/*    */   null(CharSequence $anonymous0, SPRITE $anonymous1, double $anonymous2, double $anonymous3, boolean $anonymous4) {
/* 46 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   
/*    */   public double vGet(FactionNPC f) {
/* 50 */     if (f == null || DIP.OVERLORD().is(f)) {
/* 51 */       return 0.0D;
/*    */     }
/*    */     
/* 54 */     double ff = FACTIONS.WORTH().faction((Faction)f);
/* 55 */     double pp = FACTIONS.WORTH().faction() * 1.5D;
/* 56 */     if (ff < 0.0D)
/* 57 */       return 1.0D; 
/* 58 */     double d = pp / (ff + pp);
/* 59 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\RTrust$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
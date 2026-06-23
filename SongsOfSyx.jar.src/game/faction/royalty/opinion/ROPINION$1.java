/*    */ package game.faction.royalty.opinion;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.data.DOUBLE_O;
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
/*    */   public double getD(Faction t) {
/* 44 */     if (t instanceof FactionNPC) {
/* 45 */       return ROPINION.get((FactionNPC)t);
/*    */     }
/* 47 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\ROPINION$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
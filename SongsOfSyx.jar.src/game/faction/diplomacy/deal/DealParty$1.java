/*    */ package game.faction.diplomacy.deal;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.data.INT;
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
/*    */   extends INT.IntImp
/*    */ {
/*    */   public int min() {
/* 36 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int max() {
/* 41 */     Faction fa = DealParty.this.f;
/* 42 */     int cr = 0;
/* 43 */     if (fa instanceof FactionNPC) {
/* 44 */       cr = (int)((FactionNPC)fa).stockpile.credit();
/*    */     } else {
/* 46 */       cr = (int)DealParty.this.f.credits().credits();
/* 47 */     }  if (cr < 0)
/* 48 */       return 0; 
/* 49 */     return cr;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealParty$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
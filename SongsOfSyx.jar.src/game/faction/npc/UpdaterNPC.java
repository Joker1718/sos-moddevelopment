/*    */ package game.faction.npc;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.trade.TradeManager;
/*    */ import game.time.TIME;
/*    */ import init.sprite.SPRITES;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ public final class UpdaterNPC
/*    */ {
/*    */   public void init(TradeManager trade) {
/* 13 */     SPRITES.loader().print("Simulating factions...");
/*    */     
/* 15 */     int a = 50;
/*    */     
/* 17 */     for (int i = 0; i < a; i++) {
/* 18 */       SPRITES.loader().print("Simulating factions " + (int)(100.0D * (i * 2 + a * 2) / (a * 4)) + "%");
/*    */       
/* 20 */       for (FactionNPC f : FACTIONS.NPCs()) {
/* 21 */         if (!f.isActive())
/*    */           continue; 
/* 23 */         RD.UPDATER().shipAll(f, 1.0D);
/* 24 */         f.stockpile.update(f, TIME.secondsPerDay());
/*    */       } 
/*    */       
/* 27 */       if (i % 4 == 0) {
/* 28 */         trade.prime();
/*    */       }
/*    */     } 
/* 31 */     trade.prime();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\UpdaterNPC.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package game.faction.npc.stockpile;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 33 */     for (FactionNPC f : FACTIONS.NPCs()) {
/* 34 */       f.stockpile.saver().clear();
/* 35 */       f.stockpile.update(f, 0.0D);
/* 36 */       f.credits().set(0.0D);
/*    */     } 
/* 38 */     GAME.factions().prime();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\Updater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package init.race;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.LOG;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 64 */     FactionNPC f = (FactionNPC)FACTIONS.NPCs().rnd();
/* 65 */     KingMessages m = (f.court().king().roy()).induvidual.race().kingMessage();
/*    */     
/* 67 */     for (KingMessages.Message me : m.all) {
/* 68 */       LOG.ln(me.key);
/* 69 */       for (int i = 0; i < me.all.length; i++) {
/* 70 */         LOG.ln(me.get(f, i));
/*    */       }
/* 72 */       LOG.ln();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\race\KingMessages$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
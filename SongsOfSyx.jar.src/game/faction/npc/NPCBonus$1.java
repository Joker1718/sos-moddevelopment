/*    */ package game.faction.npc;
/*    */ 
/*    */ import game.boosting.BOOSTING;
/*    */ import game.boosting.Boostable;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 37 */     double[] back = new double[128]; int i;
/* 38 */     for (i = 0; i < NPCBonus.this.bos.length; i++) {
/* 39 */       back[i] = NPCBonus.this.bos[i];
/* 40 */       NPCBonus.this.bos[i] = 1.0D;
/*    */     } 
/*    */     
/* 43 */     for (Boostable b : BOOSTING.ALL()) {
/* 44 */       LOG.ln(b.key + " " + b.key);
/*    */     }
/*    */     
/* 47 */     for (i = 0; i < NPCBonus.this.bos.length; i++)
/* 48 */       NPCBonus.this.bos[i] = back[i]; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\NPCBonus$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
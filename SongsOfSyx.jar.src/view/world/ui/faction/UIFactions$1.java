/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.data.GETTER;
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
/*    */   extends GETTER.GETTER_IMP<FactionNPC>
/*    */ {
/*    */   public void set(FactionNPC t) {
/* 25 */     super.set(t);
/* 26 */     if (get() != null)
/* 27 */       UIFactions.this.deal.setFactionAndClear(t, true); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFactions$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
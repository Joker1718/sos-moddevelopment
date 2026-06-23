/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.npc.FactionNPC;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
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
/*    */   extends GStat
/*    */ {
/*    */   null(GText $anonymous0) {
/* 33 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void update(GText text) {
/* 37 */     text.add((CharSequence)((FactionNPC)f.get()).name);
/* 38 */     text.lablify();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Banner$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
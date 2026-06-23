/*    */ package view.sett.ui.health;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.gui.misc.GBox;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 62 */     if (STATS.DISEASE().currentEpidemic() == null) {
/* 63 */       text.add('-').add('-').add('-');
/*    */     } else {
/* 65 */       text.add((STATS.DISEASE().currentEpidemic()).info.name);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 70 */     if (STATS.DISEASE().currentEpidemic() != null)
/* 71 */       STATS.DISEASE().currentEpidemic().hover((GUI_BOX)b); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\health\UIHealth$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
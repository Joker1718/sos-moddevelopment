/*    */ package view.sett.ui.noble;
/*    */ 
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Font;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   null(Font $anonymous0) {
/* 50 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void update(GText text) {
/* 54 */     text.lablify();
/* 55 */     text.add(STATS.APPEARANCE().name(NobleRow.this.n().subject().indu()));
/* 56 */     text.setMaxWidth(420);
/* 57 */     text.setMultipleLines(false);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\NobleRow$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
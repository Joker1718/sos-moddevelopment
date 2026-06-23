/*    */ package view.sett.ui.noble;
/*    */ 
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
/* 63 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void update(GText text) {
/* 67 */     if (NobleRow.this.n().office() == null) {
/* 68 */       text.warnify().add(NobleRow.¤¤no);
/*    */     } else {
/* 70 */       text.lablifySub().add(NobleRow.this.n().title());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\noble\NobleRow$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
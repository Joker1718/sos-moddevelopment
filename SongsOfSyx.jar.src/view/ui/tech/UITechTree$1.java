/*    */ package view.ui.tech;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import snake2d.util.sprite.text.StringInputSprite;
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
/*    */   extends StringInputSprite
/*    */ {
/*    */   null(int $anonymous0, Font $anonymous1) {
/* 29 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   protected void change() {
/* 32 */     if (text() == null || text().length() == 0) {
/* 33 */       UITechTree.this.swit.set((RENDEROBJ)UITechTree.this.currentTree);
/*    */     } else {
/* 35 */       UITechTree.this.swit.set((RENDEROBJ)UITechTree.this.search.set((CharSequence)text()));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tech\UITechTree$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package view.sett.ui.room.copy;
/*    */ 
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ import view.tool.PLACABLE;
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
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 47 */     (VIEW.s()).tools.place((PLACABLE)second, FirstConfig.this.sConfig);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 52 */     activeSet(false);
/* 53 */     for (COORDINATE c : source.area()) {
/* 54 */       if (source.is(c)) {
/* 55 */         activeSet(true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\FirstConfig$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
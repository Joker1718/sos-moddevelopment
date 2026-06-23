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
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GButt.Panel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 47 */     super($anonymous0);
/*    */   }
/*    */   protected void clickA() {
/* 50 */     (VIEW.s()).tools.place((PLACABLE)first, fConfig);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 55 */     activeSet(false);
/* 56 */     for (COORDINATE c : source.area()) {
/* 57 */       if (source.is(c)) {
/* 58 */         activeSet(true);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\SecondConfig$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
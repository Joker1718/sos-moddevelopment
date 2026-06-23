/*    */ package view.sett.ui.home;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASSES;
/*    */ import init.type.HGROUP;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */ 
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 67 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 71 */     UIHomeAssign.this.data.clear();
/* 72 */     for (Race r : RACES.all())
/* 73 */       UIHomeAssign.this.data.set(HGROUP.get(HCLASSES.CITIZEN(), r)); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomeAssign$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
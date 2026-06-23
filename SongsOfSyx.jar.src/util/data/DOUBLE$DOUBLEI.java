/*    */ package util.data;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.info.INFO;
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
/*    */ public abstract class DOUBLEI
/*    */   implements DOUBLE
/*    */ {
/*    */   private final INFO info;
/*    */   public final SPRITE icon;
/*    */   
/*    */   public DOUBLEI(CharSequence name, CharSequence desc) {
/* 35 */     this.info = new INFO(name, desc);
/* 36 */     this.icon = (SPRITE)(UI.icons()).s.cancel;
/*    */   }
/*    */   
/*    */   public DOUBLEI(CharSequence name, CharSequence desc, SPRITE icon) {
/* 40 */     this.info = new INFO(name, desc);
/* 41 */     this.icon = icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public INFO info() {
/* 46 */     return this.info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\data\DOUBLE$DOUBLEI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
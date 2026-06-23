/*    */ package snake2d.util.gui;
/*    */ 
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Text;
/*    */ 
/*    */ public interface GUI_BOX
/*    */ {
/*    */   GUI_BOX title(CharSequence paramCharSequence);
/*    */   
/*    */   GUI_BOX NL();
/*    */   
/*    */   GUI_BOX NL(int paramInt);
/*    */   
/*    */   GUI_BOX space();
/*    */   
/*    */   Text text();
/*    */   
/*    */   default GUI_BOX text(CharSequence text) {
/* 20 */     return add((SPRITE)text().set(text));
/*    */   }
/*    */   
/*    */   default GUI_BOX text(CharSequence text, int maxChar) {
/* 24 */     Text t = text();
/* 25 */     t.set(text);
/* 26 */     t.setMaxChars(maxChar);
/* 27 */     return add((SPRITE)t);
/*    */   }
/*    */   
/*    */   GUI_BOX add(SPRITE paramSPRITE);
/*    */   
/*    */   GUI_BOX add(SPRITE paramSPRITE, int paramInt);
/*    */   
/*    */   GUI_BOX add(RENDEROBJ paramRENDEROBJ);
/*    */   
/*    */   boolean emptyIs();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\GUI_BOX.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
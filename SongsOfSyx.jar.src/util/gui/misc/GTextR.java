/*    */ package util.gui.misc;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ 
/*    */ public class GTextR extends HOVERABLE.Sprite {
/*    */   private final GText text;
/*    */   
/*    */   public GTextR(GText text) {
/* 12 */     this(text, DIR.C);
/*    */   }
/*    */   
/*    */   public GTextR(Font f, CharSequence text) {
/* 16 */     this(new GText(f, text));
/*    */   }
/*    */   
/*    */   public GTextR(Font f, int width) {
/* 20 */     this(new GText(f, width));
/*    */   }
/*    */   
/*    */   public GTextR(Font f, int width, DIR replacementStrat) {
/* 24 */     this(new GText(f, width), replacementStrat);
/*    */   }
/*    */   
/*    */   public GTextR(GText text, DIR replacementStrat) {
/* 28 */     super((SPRITE)text);
/* 29 */     setAlign(replacementStrat);
/* 30 */     this.text = text;
/* 31 */     text.adjustWidth();
/*    */   }
/*    */ 
/*    */   
/*    */   public GText text() {
/* 36 */     return this.text;
/*    */   }
/*    */ 
/*    */   
/*    */   public void adjust() {
/* 41 */     super.adjust();
/*    */   }
/*    */ 
/*    */   
/*    */   public GTextR setAlign(DIR d) {
/* 46 */     super.setAlign(d);
/* 47 */     return this;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GTextR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
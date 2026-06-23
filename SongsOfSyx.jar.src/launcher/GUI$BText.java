/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BText
/*     */   extends GUI.Button
/*     */ {
/*     */   BText(RES res, CharSequence text) {
/* 105 */     super(sp(res, text));
/*     */   }
/*     */   
/*     */   BText(RES res, CharSequence text, int width) {
/* 109 */     super(sp2(res, text, width));
/*     */   }
/*     */   
/*     */   private static SPRITE sp(RES res, CharSequence text) {
/* 113 */     final Text p = (new Text(res.font, text)).setScale(1.0D);
/* 114 */     return (SPRITE)new SPRITE.Imp(text1.width() + 24, text1.height() + 12)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 118 */           p.render(r, X1 + 12, Y1 + 6);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static SPRITE sp2(RES res, CharSequence text, int width) {
/* 124 */     final Text p = (new Text(res.font, text)).setScale(1.0D);
/* 125 */     return (SPRITE)new SPRITE.Imp(width, text1.height() + 12)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 129 */           int x1 = X1 + (X2 - X1 - p.width()) / 2;
/*     */           
/* 131 */           p.render(r, x1, Y1 + 6);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\GUI$BText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
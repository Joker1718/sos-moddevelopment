/*    */ package util.gui.common;
/*    */ import init.sprite.BitmapSprite;
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.panel.GFrame;
/*    */ import util.text.D;
/*    */ import view.keyboard.KEYS;
/*    */ 
/*    */ public class BitmapSpriteEditor extends GuiSection {
/* 19 */   private static CharSequence ¤¤hovInfo = "¤Hold left mouse button to draw. Hold ({0}) to erase."; private BitmapSprite sprite;
/*    */   
/*    */   static {
/* 22 */     D.ts(BitmapSpriteEditor.class);
/*    */   }
/*    */   
/*    */   public BitmapSpriteEditor(BitmapSprite s) {
/* 26 */     this.sprite = s;
/*    */     
/* 28 */     final ColorImp col = new ColorImp();
/* 29 */     int pixelDim = 24;
/* 30 */     for (int y = 0; y < 12; y++) {
/* 31 */       for (int x = 0; x < 12; x++) {
/* 32 */         final int x1 = x;
/* 33 */         final int y1 = y;
/*    */         
/* 35 */         CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(pixelDim, pixelDim)
/*    */           {
/*    */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*    */             {
/* 39 */               int i = 80;
/* 40 */               if (BitmapSpriteEditor.this.sprite != null) {
/* 41 */                 i = BitmapSpriteEditor.this.sprite.is(x1, y1) ? 20 : 80;
/* 42 */                 if (isHovered && MButt.LEFT.isDown()) {
/* 43 */                   BitmapSpriteEditor.this.sprite.set(x1, y1, !(KEYS.MAIN()).MOD.isPressed());
/*    */                 }
/* 45 */                 if (isHovered) {
/* 46 */                   i += 30;
/*    */                 }
/*    */               } 
/* 49 */               col.set(i, i, i);
/* 50 */               col.render(r, (RECTANGLE)body());
/*    */             }
/*    */ 
/*    */ 
/*    */             
/*    */             public void hoverInfoGet(GUI_BOX text) {
/* 56 */               GBox b = (GBox)text;
/* 57 */               GText t = b.text();
/* 58 */               t.add(BitmapSpriteEditor.¤¤hovInfo);
/* 59 */               t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 60 */               b.add((SPRITE)t);
/*    */             }
/*    */           };
/* 63 */         clickableAbs.hoverSoundSet(null);
/* 64 */         add((RENDEROBJ)clickableAbs, x * pixelDim, y * pixelDim);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 70 */     GFrame f = new GFrame((RECTANGLE)body());
/* 71 */     add((RENDEROBJ)f);
/*    */   }
/*    */   
/*    */   public BitmapSpriteEditor() {
/* 75 */     this((BitmapSprite)null);
/*    */   }
/*    */ 
/*    */   
/*    */   public void spriteSet(BitmapSprite s) {
/* 80 */     this.sprite = s;
/*    */   }
/*    */   
/*    */   public BitmapSprite spriteGet() {
/* 84 */     return this.sprite;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\BitmapSpriteEditor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
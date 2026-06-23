/*    */ package util.gui.common;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GText;
/*    */ import view.keyboard.KEYS;
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
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 35 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 39 */     int i = 80;
/* 40 */     if (BitmapSpriteEditor.this.sprite != null) {
/* 41 */       i = BitmapSpriteEditor.this.sprite.is(x1, y1) ? 20 : 80;
/* 42 */       if (isHovered && MButt.LEFT.isDown()) {
/* 43 */         BitmapSpriteEditor.this.sprite.set(x1, y1, !(KEYS.MAIN()).MOD.isPressed());
/*    */       }
/* 45 */       if (isHovered) {
/* 46 */         i += 30;
/*    */       }
/*    */     } 
/* 49 */     col.set(i, i, i);
/* 50 */     col.render(r, (RECTANGLE)body());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 56 */     GBox b = (GBox)text;
/* 57 */     GText t = b.text();
/* 58 */     t.add(BitmapSpriteEditor.¤¤hovInfo);
/* 59 */     t.insert(0, (KEYS.MAIN()).MOD.repr());
/* 60 */     b.add((SPRITE)t);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\BitmapSpriteEditor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
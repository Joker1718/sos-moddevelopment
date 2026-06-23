/*    */ package game.boosting.tmp;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ 
/*    */ public class TmpBoostingButt {
/* 17 */   private static CharSequence ¤¤no = "Nothing out of the ordinary is having an effect.";
/*    */   
/*    */   static {
/* 20 */     D.ts(TmpBoostingButt.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static <T extends INDEXED> CLICKABLE make(final GETTER<T> get, final TmpBoostable<T> type) {
/* 25 */     GButt.ButtPanel p = new GButt.ButtPanel((SPRITE)(UI.icons()).l.event)
/*    */       {
/*    */         protected void renAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 35 */           super.render(r, ds, isActive, isSelected, isHovered);
/* 36 */           if (!type.any((INDEXED)get.get())) {
/* 37 */             OPACITY.O50.bind();
/* 38 */             COLOR.BLACK.render(r, (RECTANGLE)this.body, -2);
/* 39 */             OPACITY.unbind();
/*    */           } 
/*    */         }
/*    */ 
/*    */         
/*    */         protected void clickA() {
/* 45 */           super.clickA();
/*    */         }
/*    */ 
/*    */         
/*    */         public void hoverInfoGet(GUI_BOX text) {
/* 50 */           if (type.any((INDEXED)get.get())) {
/* 51 */             GBox b = (GBox)text;
/* 52 */             type.hover(b, (INDEXED)get.get());
/*    */           } else {
/* 54 */             text.text(TmpBoostingButt.¤¤no);
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 60 */     return (CLICKABLE)p;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TmpBoostingButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
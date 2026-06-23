/*    */ package util.gui.common;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import world.entity.army.WArmy;
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
/*    */ class Button
/*    */   extends CLICKABLE.ClickableAbs
/*    */ {
/*    */   private final GETTER<Integer> ier;
/*    */   
/*    */   public Button(GETTER<Integer> ier) {
/* 58 */     this.ier = ier;
/* 59 */     this.body.setWidth(250.0D);
/* 60 */     this.body.setHeight(40.0D);
/*    */   }
/*    */   
/*    */   private WArmy a() {
/* 64 */     return (WArmy)((Faction)UIPickerArmy.this.g.get()).armies().all().get(((Integer)this.ier.get()).intValue());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 70 */     GButt.ButtPanel.renderBG(r, true, false, isHovered, (RECTANGLE)this.body);
/* 71 */     (SPRITES.icons()).s.sword.renderCY(r, body().x1() + 6, body().cY());
/*    */     
/* 73 */     (GCOLOR.T()).H1.bind();
/*    */     
/* 75 */     (UI.FONT()).H2.render(r, (CharSequence)(a()).name, body().x1() + 24, body().cY() - (UI.FONT()).H2.height() / 2);
/* 76 */     if (!UIPickerArmy.this.canBePicked(a())) {
/* 77 */       OPACITY.O35.bind();
/* 78 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 79 */       OPACITY.unbind();
/*    */     } 
/* 81 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 87 */     if (UIPickerArmy.this.canBePicked(a())) {
/* 88 */       UIPickerArmy.this.pick(a());
/*    */     }
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 93 */     UIPickerArmy.this.hover(text, a());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerArmy$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package view.ui.top;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GMeter;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ abstract class UIPanelTopButtAbs extends GButt {
/* 13 */   private final GStat stat = (new GStat()
/*    */     {
/*    */       public void update(GText text) {
/* 16 */         GFORMAT.i(text, UIPanelTopButtAbs.this.getNumber());
/* 17 */         text.lablify();
/*    */       }
/* 19 */     }).decrease();
/*    */ 
/*    */ 
/*    */   
/*    */   public UIPanelTopButtAbs(SPRITE icon, int width, int height) {
/* 24 */     super(icon);
/* 25 */     this.body.setWidth(width);
/* 26 */     this.body.setHeight(height);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 32 */     renAction();
/*    */     
/* 34 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 35 */     GButt.ButtPanel.renderFrame(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*    */ 
/*    */ 
/*    */     
/* 39 */     boolean active = isActive();
/* 40 */     if (active) {
/* 41 */       double cu = value();
/* 42 */       double ta = valueNext();
/* 43 */       GMeter.renderSuperDelta(r, cu, ta, this.body.x1() + 2, this.body.x2() - 2, this.body.y1() + 2, this.body.y2() - 2, false);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     this.stat.adjust();
/* 53 */     render(r, this.label, this.stat, active);
/*    */   }
/*    */   
/*    */   abstract void render(SPRITE_RENDERER paramSPRITE_RENDERER, SPRITE paramSPRITE, GStat paramGStat, boolean paramBoolean);
/*    */   
/*    */   protected abstract int getNumber();
/*    */   
/*    */   protected abstract double value();
/*    */   
/*    */   protected abstract double valueNext();
/*    */   
/*    */   protected abstract boolean isActive();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\top\UIPanelTopButtAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
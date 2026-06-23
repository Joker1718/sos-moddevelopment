/*    */ package view.ui.economy;
/*    */ 
/*    */ import game.GAME;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.table.GStaples;
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
/*    */   extends GStaples
/*    */ {
/*    */   null(int $anonymous0) {
/* 67 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hover(GBox box, int stapleI) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 77 */     if (MainChart.this.hi.get() >= 0) {
/* 78 */       setHovered(MainChart.this.hi.get());
/*    */     }
/* 80 */     super.render(r, ds, hoveredIs());
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 85 */     if (super.hover(mCoo)) {
/* 86 */       MainChart.this.hi.set(hoverI());
/* 87 */       return true;
/*    */     } 
/* 89 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected double getValue(int stapleI) {
/* 94 */     return CLAMP.d(GAME.player().credits().creditsH().get(MainChart.this.am - stapleI - 1), 0.0D, 2.147483647E9D);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void setColor(ColorImp c, int stapleI, double value) {
/* 99 */     c.set(COLOR.YELLOW100).saturateSelf(0.5D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainChart$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
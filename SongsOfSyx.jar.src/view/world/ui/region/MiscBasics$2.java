/*    */ package view.world.ui.region;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import world.region.RD;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 77 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 81 */     double d = (RD.DEVASTATION()).current.getD(g.get());
/* 82 */     int am = (int)(d * (body().width() / 16));
/* 83 */     int x = body().x1();
/* 84 */     (GCOLOR.UI()).BAD.hovered.bind();
/* 85 */     for (int i = 0; i < am; i++) {
/* 86 */       (UI.icons()).s.degrade.render(r, x, body().y1());
/* 87 */       x += 16;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 93 */     GBox b = (GBox)text;
/* 94 */     b.add((RD.DEVASTATION()).current.info());
/* 95 */     b.NL();
/* 96 */     b.add((SPRITE)GFORMAT.percInv(b.text(), (RD.DEVASTATION()).current.getD(g.get())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscBasics$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
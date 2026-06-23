/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.gui.misc.GMeter;
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
/*    */   extends RENDEROBJ.RenderImp
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 66 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 70 */     double statMax = cats.getBiggest();
/* 71 */     if (CatButt.this.max > 0.0D)
/* 72 */       GMeter.renderDelta(r, CatButt.this.last / CatButt.this.max, CatButt.this.now / CatButt.this.max, this.body.x1(), (int)(this.body.x1() + this.body.width() * CatButt.this.max / statMax), this.body.y1(), this.body.y2()); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatButt$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
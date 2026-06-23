/*    */ package settlement.room.infra.inn;
/*    */ 
/*    */ import game.tourism.Review;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
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
/* 80 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 84 */     Review rev = ((InnInstance)g.get()).reviews[k];
/* 85 */     if (rev != null && rev.has())
/* 86 */       rev.render(r, this.body.x1(), this.body.y1(), 800); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\inn\Gui$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
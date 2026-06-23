/*    */ package world.entity.caravan;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import view.main.VIEW;
/*    */ import world.WORLD;
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   null(int $anonymous0, int $anonymous1) {
/* 47 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 51 */     int i = (int)(VIEW.renderSecond() * 2.0D) % 3;
/* 52 */     i *= 8;
/* 53 */     i += 32;
/* 54 */     COLOR.WHITE150.bind();
/* 55 */     (WORLD.ENTITIES()).caravans.caravan.render(r, i + DIR.SE.id(), X1, X2, Y1, Y2);
/* 56 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\caravan\Shipments$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
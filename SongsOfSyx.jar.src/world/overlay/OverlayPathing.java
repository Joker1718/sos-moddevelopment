/*    */ package world.overlay;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ final class OverlayPathing
/*    */   extends WorldOverlays.OverlayTileNormal {
/* 17 */   private static CharSequence ¤¤name = "¤Paths";
/* 18 */   private static CharSequence ¤¤desc = "¤show available paths";
/*    */   static {
/* 20 */     D.ts(OverlayPathing.class);
/*    */   }
/*    */   
/*    */   OverlayPathing() {
/* 24 */     super(¤¤name, ¤¤desc, true, true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 30 */     COLOR.ORANGE100.bind();
/*    */     
/* 32 */     if ((WORLD.PATH()).map.is.is(it.tile()))
/*    */     {
/* 34 */       for (DIR d : DIR.ALL) {
/* 35 */         if ((WORLD.PATH()).map.can(it.tile(), d)) {
/* 36 */           ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render(r, it.x(), it.y());
/*    */         }
/*    */       } 
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     COLOR.unbind();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 50 */     int m = 15;
/* 51 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 52 */     if (WORLD.REGIONS().border().is(it.tile())) {
/* 53 */       m = 0;
/* 54 */       for (DIR d : DIR.ORTHO) {
/* 55 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 56 */           m |= d.mask();
/*    */         }
/*    */       } 
/*    */     } 
/* 60 */     (GCOLOR.MAP()).F_REBEL.bind();
/* 61 */     renderUnder(m, r, it);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayPathing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
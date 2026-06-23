/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends ProjectileSprite
/*    */ {
/*    */   public void renderProj(Projectile p, double ref, Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, float ds, int zoomout) {
/* 43 */     if (zoomout < 2) {
/* 44 */       double l = Math.sqrt(dx * dx + dy * dy + dz * dz * 4.0D);
/* 45 */       dx /= l;
/* 46 */       dy /= l;
/* 47 */       dx *= 4.0D;
/* 48 */       dy *= 4.0D;
/* 49 */       for (int k = 0; k < 8; k++) {
/* 50 */         r.renderParticle((int)x, (int)y);
/* 51 */         x += dx;
/* 52 */         y += dy;
/*    */       } 
/*    */     } 
/*    */     
/* 56 */     s.setDistance2Ground((h / 4));
/* 57 */     (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, (int)x, (int)y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\ProjectileSprite$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
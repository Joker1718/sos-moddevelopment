/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 72 */     if (zoomout < 2) {
/* 73 */       cols[ran & 0x3F].bind();
/* 74 */       double l = Math.sqrt(dx * dx + dy * dy + dz * dz * 4.0D);
/* 75 */       dx /= l;
/* 76 */       dy /= l;
/* 77 */       dx *= 4.0D;
/* 78 */       dy *= 4.0D;
/* 79 */       for (int k = 0; k < 8; k++) {
/* 80 */         r.renderParticle((int)x, (int)y);
/* 81 */         x += dx;
/* 82 */         y += dy;
/*    */       } 
/* 84 */       COLOR.unbind();
/*    */     } 
/*    */     
/* 87 */     s.setHeight(0).setDistance2Ground((h / 4));
/* 88 */     (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)s, (int)x, (int)y);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\ProjectileSprite$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
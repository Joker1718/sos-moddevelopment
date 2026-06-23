/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends ProjectileSprite
/*     */ {
/*     */   public void renderProj(Projectile p, double ref, Renderer r, ShadowBatch s, double x, double y, int h, int ran, double dx, double dy, double dz, float ds, int zoomout) {
/* 121 */     int i = DIR.get(dx, dy).id();
/* 122 */     double sc = 1.0D + h * 0.015625D * 0.125D;
/*     */     
/* 124 */     int w = (int)(sheet.size() * sc);
/* 125 */     int x1 = (int)(x - (w / 2));
/* 126 */     int y1 = (int)(y - (w / 2));
/* 127 */     int x2 = x1 + w;
/* 128 */     int y2 = y1 + w;
/*     */ 
/*     */     
/* 131 */     cols[ran & 0x3F].bind();
/* 132 */     sheet.render((SPRITE_RENDERER)r, i, x1, x2, y1, y2);
/* 133 */     s.setHeight(0).setDistance2Ground((h / 4));
/* 134 */     sheet.renderC((SPRITE_RENDERER)s, i, (int)x, (int)y);
/* 135 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\ProjectileSprite$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
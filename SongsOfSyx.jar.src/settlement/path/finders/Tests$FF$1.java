/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 239 */     remove();
/*     */     
/* 241 */     if (Tests.FF.this.start.x() == -1 || (SETT.PATH()).solidity.is((COORDINATE)Tests.FF.this.start)) {
/*     */       return;
/*     */     }
/* 244 */     int dx = VIEW.s().getWindow().tile().x();
/* 245 */     int dy = VIEW.s().getWindow().tile().y();
/*     */     
/* 247 */     if ((SETT.PATH()).solidity.is(dx, dy)) {
/*     */       return;
/*     */     }
/* 250 */     PathTile t = (SETT.PATH()).finders.finder().cDebug(Tests.FF.this.start.x(), Tests.FF.this.start.y(), dx, dy, true);
/* 251 */     int dd = (int)(VIEW.renderSecond() * 8.0D) % 1024;
/*     */     
/* 253 */     while (t != null) {
/*     */       
/* 255 */       int sx = t.x();
/* 256 */       int sy = t.y();
/* 257 */       while (t != null) {
/* 258 */         ((dd == 0) ? COLOR.WHITE100 : COLOR.ORANGE100).bind();
/* 259 */         int rx = data.transformGX(t.x() * 64);
/* 260 */         int ry = data.transformGY(t.y() * 64);
/* 261 */         (SPRITES.cons()).ICO.tile.render((SPRITE_RENDERER)r, rx, ry);
/*     */ 
/*     */         
/* 264 */         t = t.getParent();
/* 265 */         dd--;
/*     */       } 
/*     */       
/* 268 */       if (Math.abs(sx - dx) <= 1 && Math.abs(sy - dy) <= 1) {
/*     */         break;
/*     */       }
/* 271 */       t = (SETT.PATH()).finders.finder().find(sx, sy, dx, dy, true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\Tests$FF$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
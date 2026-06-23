/*    */ package settlement.thing.projectiles;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.sets.ArrayListInt;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PRenderer
/*    */ {
/*    */   private final SProjectiles p;
/*    */   private final ArrayListInt tmp;
/*    */   private final Rec rec;
/*    */   
/*    */   PRenderer(SProjectiles p) {
/* 22 */     this.tmp = new ArrayListInt(4112);
/* 23 */     this.rec = new Rec();
/*    */     this.p = p;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData) {
/* 29 */     r.newLayer(false, zoomout);
/*    */ 
/*    */     
/* 32 */     SETT.WEATHER().apply(renData.absBounds());
/* 33 */     this.tmp.clear();
/* 34 */     int min = 64;
/* 35 */     this.rec.set((renData.gBounds().x1() - min), (renData.gBounds().x2() + min), (renData.gBounds().y1() - min), (renData.gBounds().y2() + min));
/* 36 */     this.p.map.fill((RECTANGLE)this.rec, this.tmp);
/*    */     
/* 38 */     int offX = renData.offX1();
/* 39 */     int offY = renData.offY1();
/*    */     
/* 41 */     for (int i = 0; i < this.p.data.last(); i++) {
/* 42 */       PData.Data d = this.p.data.data(i);
/* 43 */       double x = (d.x() - offX);
/* 44 */       double y = (d.y() - offY);
/* 45 */       int h = (int)d.z();
/* 46 */       Projectile pr = this.p.data.type(i);
/* 47 */       double ref = this.p.data.ref(i);
/* 48 */       pr.sprite().renderProj(pr, ref, r, s, x, y, h, i, d.speedX(), d.speedY(), d.dz(), ds, zoomout);
/*    */     } 
/*    */     
/* 51 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\PRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
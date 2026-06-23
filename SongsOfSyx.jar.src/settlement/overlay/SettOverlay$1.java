/*    */ package settlement.overlay;
/*    */ 
/*    */ import init.resources.Minable;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends Addable
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 65 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 70 */     if ((SETT.MINERALS()).getter.is(it.tile())) {
/* 71 */       double v = 1.0D;
/* 72 */       if (!(SETT.TERRAIN()).CAVE.is(it.tile())) {
/* 73 */         renderUnder(v, r, it, false);
/*    */       }
/* 75 */       if ((SETT.ROOMS()).map.is(it.tile()))
/* 76 */         return false; 
/* 77 */       if ((SETT.MINERALS()).getter.is(it.tile())) {
/* 78 */         COLOR.unbind();
/* 79 */         double am = 0.5D + (SETT.MINERALS()).value.get(it.tile()) / 2.0D;
/* 80 */         int size = (int)(64.0D * am);
/* 81 */         int off = (64 - size) / 2;
/* 82 */         renderAbove(am * 2.0D - 1.0D, r, it, true);
/* 83 */         COLOR.unbind();
/* 84 */         ((Minable)(SETT.MINERALS()).getter.get(it.tile())).resource.icon().render((SPRITE_RENDERER)r, it.x() + off, it.x() + off + size, it.y() + off, it.y() + off + size);
/* 85 */         return true;
/*    */       } 
/*    */     } 
/* 88 */     if (SETT.TERRAIN().get(it.tile()) instanceof settlement.tilemap.terrain.TGrowable) {
/* 89 */       SettOverlay.this.EDIBLES.renderBelow(r, it);
/* 90 */       SettOverlay.this.EDIBLES.render(r, it);
/* 91 */       return true;
/*    */     } 
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\SettOverlay$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
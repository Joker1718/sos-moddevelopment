/*     */ package settlement.overlay;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TGrowable;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Addable
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1) {
/*  98 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 102 */     if ((SETT.JOBS()).getter.get(it.tile()) == null && SETT.TERRAIN().get(it.tile()) instanceof TGrowable)
/*     */     {
/* 104 */       if (SETT.TERRAIN().get(it.tile()) instanceof TGrowable) {
/* 105 */         COLOR.unbind();
/* 106 */         double am = 1.0D;
/* 107 */         ColorImp.TMP.interpolate(COLOR.WHITE20, COLOR.WHITE100, am).bind();
/* 108 */         int size = (int)(64.0D * am);
/* 109 */         int off = (64 - size) / 2;
/* 110 */         COLOR.unbind();
/* 111 */         ((TGrowable)SETT.TERRAIN().get(it.tile())).growable.resource.icon().render((SPRITE_RENDERER)r, it.x() + off, it.x() + off + size, it.y() + off, it.y() + off + size);
/*     */         
/* 113 */         return true;
/*     */       } 
/*     */     }
/* 116 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 122 */     double v = 0.0D;
/* 123 */     if (SETT.TERRAIN().get(it.tile()) instanceof TGrowable) {
/* 124 */       TGrowable b = (TGrowable)SETT.TERRAIN().get(it.tile());
/* 125 */       v = 0.5D + 0.5D * b.size.DM.get(it.tile());
/*     */     } 
/* 127 */     renderUnder(v, r, it, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\SettOverlay$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
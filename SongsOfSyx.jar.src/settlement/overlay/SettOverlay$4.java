/*     */ package settlement.overlay;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.ground.GroundType;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   null(SPRITE $anonymous0, String $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, boolean $anonymous4, boolean $anonymous5) {
/* 149 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 153 */     double d = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 154 */     d *= d;
/* 155 */     renderUnder(d, r, it, false);
/* 156 */     if (d > 0.75D) {
/* 157 */       d = (d - 0.75D) * 4.0D;
/* 158 */       renderPluses(d, r, it);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 164 */     double d = ((GroundType)(SETT.GROUND()).MAP.get(it.tile())).farm / (SETT.GROUND()).types.NORMAL.farm;
/* 165 */     d *= d;
/* 166 */     if (renderAbove(d, r, it, false)) {
/* 167 */       if (d > 0.75D) {
/* 168 */         d = (d - 0.75D) * 4.0D;
/* 169 */         renderPluses(d, r, it);
/*     */       } 
/* 171 */       return true;
/*     */     } 
/* 173 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\SettOverlay$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
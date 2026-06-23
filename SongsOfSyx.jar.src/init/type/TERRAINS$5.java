/*     */ package init.type;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends TERRAIN
/*     */ {
/*     */   null(ArrayList<TERRAIN> $anonymous0, String $anonymous1, Json $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4, boolean $anonymous5) {
/*  88 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/*  94 */     return (SETT.TERRAIN()).MOUNTAIN.getIcon();
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(int wx, int wy) {
/*  99 */     double res = 0.0D;
/* 100 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 101 */       if ((WORLD.MOUNTAIN()).haser.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 102 */         res += 0.25D; 
/*     */     } 
/* 104 */     return CLAMP.d(res, 0.0D, 1.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAINS$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
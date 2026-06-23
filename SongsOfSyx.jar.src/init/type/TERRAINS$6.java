/*     */ package init.type;
/*     */ 
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 108 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 114 */     return (WORLD.FOREST()).icon;
/*     */   }
/*     */ 
/*     */   
/*     */   public double value(int wx, int wy) {
/* 119 */     double res = 0.0D;
/* 120 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 121 */       if ((WORLD.MOUNTAIN()).haser.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 122 */         res += 0.25D * (WORLD.FOREST()).amount.get(wx, wy); 
/*     */     } 
/* 124 */     return res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAINS$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
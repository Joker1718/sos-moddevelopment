/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.WORLD;
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
/*    */   extends TERRAIN
/*    */ {
/*    */   null(ArrayList<TERRAIN> $anonymous0, String $anonymous1, Json $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4, boolean $anonymous5) {
/* 66 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SPRITE icon() {
/* 72 */     return (WORLD.WATER()).LAKE.icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public double value(int wx, int wy) {
/* 77 */     double res = 0.0D;
/* 78 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 79 */       if ((WORLD.WATER()).RIVER_SMALL.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 80 */         res += 0.2D; 
/* 81 */       if ((WORLD.WATER()).LAKE.is.is(wx, wy, (DIR)DIR.ORTHO.get(di)) || (WORLD.WATER()).isRivery.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 82 */         res += 0.25D; 
/*    */     } 
/* 84 */     return CLAMP.d(res, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAINS$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
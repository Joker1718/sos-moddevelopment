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
/*    */ class null
/*    */   extends TERRAIN
/*    */ {
/*    */   null(ArrayList<TERRAIN> $anonymous0, String $anonymous1, Json $anonymous2, CharSequence $anonymous3, CharSequence $anonymous4, boolean $anonymous5) {
/* 44 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4, $anonymous5);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SPRITE icon() {
/* 50 */     return (WORLD.WATER()).OCEAN.icon;
/*    */   }
/*    */ 
/*    */   
/*    */   public double value(int wx, int wy) {
/* 55 */     double res = 0.0D;
/* 56 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 57 */       if ((WORLD.WATER()).OCEAN.is.is(wx, wy, (DIR)DIR.ORTHO.get(di)))
/* 58 */         res += 0.25D; 
/*    */     } 
/* 60 */     return CLAMP.d(res, 0.0D, 1.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\TERRAINS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
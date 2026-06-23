/*    */ package world.map.landmark;
/*    */ 
/*    */ import snake2d.util.file.Json;
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
/*    */ class null
/*    */   extends GeneratorLandmark.Type
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1, int $anonymous2, int $anonymous3) {
/* 31 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   
/*    */   public boolean is(int tx, int ty) {
/* 35 */     return ((WORLD.MOUNTAIN()).heighter.get(tx, ty) > 0 && !(WORLD.WATER()).has.is(tx, ty));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\landmark\GeneratorLandmark$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
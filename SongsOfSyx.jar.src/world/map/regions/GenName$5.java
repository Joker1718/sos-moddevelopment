/*    */ package world.map.regions;
/*    */ 
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
/*    */ class null
/*    */   extends GenName.LandCounter
/*    */ {
/*    */   null(GenName paramGenName2, String[] $anonymous0, double $anonymous1) {
/* 49 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   boolean count(int tx, int ty) {
/* 52 */     return (WORLD.WATER()).OCEAN.normal.is(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenName$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
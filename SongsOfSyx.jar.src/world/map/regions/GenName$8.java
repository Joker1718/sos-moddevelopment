/*    */ package world.map.regions;
/*    */ 
/*    */ import world.WORLD;
/*    */ import world.map.terrain.WorldGround;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GenName.LandCounter
/*    */ {
/*    */   null(GenName paramGenName2, String[] $anonymous0, double $anonymous1) {
/* 67 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   boolean count(int tx, int ty) {
/* 70 */     return (ty > WORLD.THEIGHT() / 2 && ((WorldGround.WGROUND)(WORLD.GROUND()).getter.get(tx, ty)).moisture() < 0.2D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\GenName$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
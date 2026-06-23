/*    */ package world.map.road;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */ abstract class TravTile
/*    */ {
/*    */   public final String name;
/*    */   
/*    */   TravTile(String name) {
/* 67 */     this.name = name;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean isPossible(int paramInt1, int paramInt2, boolean paramBoolean);
/*    */   
/*    */   public int extraCost(TravTile to) {
/* 74 */     return 0;
/*    */   }
/*    */   
/*    */   public abstract boolean isPossible(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TravTile paramTravTile, DIR paramDIR, boolean paramBoolean);
/*    */   
/*    */   public abstract void road(int paramInt1, int paramInt2, int paramInt3, int paramInt4, TravTile paramTravTile, DIR paramDIR);
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\road\WTRAV$TravTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
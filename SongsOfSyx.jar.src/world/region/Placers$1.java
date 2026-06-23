/*    */ package world.region;
/*    */ 
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 45 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 49 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 50 */     if (reg != null && reg.faction() != null) {
/* 51 */       RD.setFaction(reg, null, false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 57 */     Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/* 58 */     if (reg != null && reg.faction() != null) {
/* 59 */       return null;
/*    */     }
/* 61 */     return E;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 66 */     Region reg = (Region)(WORLD.REGIONS()).map.get(fromX, fromY);
/* 67 */     return (reg != null && reg.is(toX, toY));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\Placers$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
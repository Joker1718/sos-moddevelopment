/*    */ package settlement.thing;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
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
/*    */   extends PlacableMulti
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 60 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 64 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 65 */       if (t instanceof ThingsResources.ScatteredResource) {
/* 66 */         int a = ((ThingsResources.ScatteredResource)t).amount();
/* 67 */         a -= a / 10 * 10;
/* 68 */         a = 10 - a;
/* 69 */         if (((ThingsResources.ScatteredResource)t).amount() + a < 10000) {
/* 70 */           (SETT.THINGS()).resources.createPrecise(tx, ty, ((ThingsResources.ScatteredResource)t).resource(), a);
/*    */         }
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE type) {
/* 78 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 79 */       if (t instanceof ThingsResources.ScatteredResource)
/* 80 */         return null; 
/*    */     } 
/* 82 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingPlacer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
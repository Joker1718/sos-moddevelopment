/*    */ package settlement.entity.animal;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.main.SETT;
/*    */ import view.tool.PlacableSimple;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableSimple
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 71 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int x, int y) {
/* 75 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 76 */       if (e instanceof Animal) {
/* 77 */         ((Animal)e).kill(false, false);
/*    */         return;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int x, int y) {
/* 85 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 86 */       if (e instanceof Animal) {
/* 87 */         return null;
/*    */       }
/*    */     } 
/* 90 */     return E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\animal\Animals$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
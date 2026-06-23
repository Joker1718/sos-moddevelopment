/*    */ package game.events.disaster;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
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
/*    */ class null
/*    */   extends PlacableSimple
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 64 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int x, int y) {
/* 68 */     ENTITY e = SETT.ENTITIES().getAtPoint(x, y);
/* 69 */     if (e != null && e instanceof Humanoid) {
/* 70 */       EventAccident.this.create((Humanoid)e);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int x, int y) {
/* 76 */     ENTITY e = SETT.ENTITIES().getAtPoint(x, y);
/* 77 */     if (e != null && e instanceof Humanoid) {
/* 78 */       return null;
/*    */     }
/* 80 */     return E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\disaster\EventAccident$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
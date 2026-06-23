/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import init.type.DISEASES;
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
/* 76 */       if (e instanceof Humanoid) {
/* 77 */         Humanoid a = (Humanoid)e;
/* 78 */         StatsDisease.this.infect(a.indu(), DISEASES.randomRegular());
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int x, int y) {
/* 86 */     return (SETT.ENTITIES().getAtPoint(x, y) != null) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\StatsDisease$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
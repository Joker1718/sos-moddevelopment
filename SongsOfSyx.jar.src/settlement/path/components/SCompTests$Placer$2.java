/*    */ package settlement.path.components;
/*    */ 
/*    */ import view.main.VIEW;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 50 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 54 */     SCompTests.Placer.this.sx = tx;
/* 55 */     SCompTests.Placer.this.sy = ty;
/* 56 */     (VIEW.s()).tools.place((PLACABLE)SCompTests.Placer.this.p2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 62 */     if ((SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.zero.get(tx, ty) == null)
/* 63 */       return E; 
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompTests$Placer$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
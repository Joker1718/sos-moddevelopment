/*    */ package settlement.path.components;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/* 68 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 72 */     SCompTests.Placer.this.res = (SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.pather.findDest(SCompTests.Placer.this.sx, SCompTests.Placer.this.sy, tx, ty);
/* 73 */     SCompTests.Placer.this.ren.add();
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 78 */     if ((SCompTests.Placer.access$0(SCompTests.Placer.this)).comps.zero.get(tx, ty) == null)
/* 79 */       return E; 
/* 80 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompTests$Placer$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
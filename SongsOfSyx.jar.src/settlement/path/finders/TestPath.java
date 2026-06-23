/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComp0;
/*    */ import settlement.path.path.SPath;
/*    */ import snake2d.LOG;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableSingle;
/*    */ 
/*    */ class TestPath
/*    */   extends PlacableSingle {
/*    */   private final SFINDER finder;
/* 14 */   static final SPath tester = new SPath();
/*    */   
/*    */   TestPath(CharSequence name, SFINDER finder) {
/* 17 */     super("path test: " + String.valueOf(name));
/* 18 */     this.finder = finder;
/* 19 */     IDebugPanelSett.add((PLACABLE)this);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 25 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/* 26 */     if (sComp0 == null) {
/* 27 */       return E;
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void placeFirst(int tx, int ty) {
/* 34 */     place(tx, ty, tester);
/* 35 */     if (!tester.isSuccessful()) {
/* 36 */       LOG.ln("nay!");
/*    */     } else {
/* 38 */       LOG.ln("yay " + tester.destX() + " " + tester.destY());
/*    */     } 
/*    */   }
/*    */   protected void place(int sx, int sy, SPath p) {
/* 42 */     tester.request(sx, sy, this.finder, 2147483647);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\TestPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
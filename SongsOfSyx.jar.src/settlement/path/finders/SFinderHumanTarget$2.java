/*    */ package settlement.path.finders;
/*    */ 
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sets.ArrayList;
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
/*    */ class null
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   final ArrayList<Humanoid> all;
/*    */   
/*    */   null(CharSequence $anonymous0) {
/* 25 */     super($anonymous0);
/*    */     
/* 27 */     this.all = new ArrayList(1);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 31 */     this.all.clear();
/* 32 */     SFinderHumanTarget.this.add(this.all, tx, ty, true, 128, Humanoid.TARGET_MAX);
/*    */     
/* 34 */     for (Humanoid h : this.all) {
/* 35 */       if (!h.isRemoved()) {
/* 36 */         h.kill(true, CAUSE_LEAVES.MURDER());
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 43 */     return ((SETT.PATH()).comps.zero.get(tx, ty) != null) ? null : E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHumanTarget$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
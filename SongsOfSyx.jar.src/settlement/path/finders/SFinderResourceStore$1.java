/*    */ package settlement.path.finders;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.SComponentLevel;
/*    */ import settlement.path.components.finder.SCompFinder;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements SCompFinder.SCompPatherExister
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 57 */     SFinderResourceStore.this.storeMask.or((SFinderResourceStore.this.d()).storage.bits(c));
/* 58 */     SFinderResourceStore.this.resMask.or((SFinderResourceStore.this.d()).resScattered.bits(c));
/*    */     
/* 60 */     return SFinderResourceStore.this.storeMask.has((RBIT)SFinderResourceStore.this.resMask);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(SComponentLevel l) {
/* 65 */     SFinderResourceStore.this.resMask.clear();
/* 66 */     SFinderResourceStore.this.storeMask.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStore$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
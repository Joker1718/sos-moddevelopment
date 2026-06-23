/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.path.components.SComponent;
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
/*    */   implements SCompFinder.SCompPatherFinder
/*    */ {
/*    */   public boolean isInComponent(SComponent c, double distance) {
/* 55 */     return (SFinderHumanTarget.this.ff.get(c) > 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHumanTarget$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
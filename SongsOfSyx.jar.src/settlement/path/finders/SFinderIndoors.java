/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FINDABLE;
/*    */ 
/*    */ 
/*    */ public final class SFinderIndoors
/*    */   extends SFinderFindable
/*    */ {
/*    */   SFinderIndoors() {
/* 11 */     super("indoors");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FINDABLE getReservable(int tx, int ty) {
/* 17 */     FINDABLE f = (SETT.TERRAIN()).indoors.findable(tx, ty);
/* 18 */     if (f != null && f.findableReservedCanBe())
/* 19 */       return f; 
/* 20 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FINDABLE getReserved(int tx, int ty) {
/* 25 */     FINDABLE f = (SETT.TERRAIN()).indoors.findable(tx, ty);
/* 26 */     if (f != null && f.findableReservedIs())
/* 27 */       return f; 
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderIndoors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
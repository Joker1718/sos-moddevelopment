/*    */ package settlement.room.main.copy;
/*    */ 
/*    */ import settlement.room.main.ROOMS;
/*    */ import view.tool.PLACABLE;
/*    */ 
/*    */ public final class ROOM_COPY
/*    */ {
/*    */   private Copier copy;
/*  9 */   public final CopierMass copier = new CopierMass();
/*    */   public final SavedPrintsPlacer savedPlacer;
/*    */   public final SavedPrints prints;
/*    */   
/*    */   public ROOM_COPY(ROOMS r) {
/* 14 */     BSwap s = new BSwap(r);
/* 15 */     this.prints = new SavedPrints(r);
/* 16 */     this.savedPlacer = new SavedPrintsPlacer(s);
/* 17 */     this.copy = new Copier(s);
/*    */   }
/*    */ 
/*    */   
/*    */   public void copy(int rx, int ry) {
/* 22 */     if (this.copy.isPlacable(rx, ry) == null)
/* 23 */       this.copy.placeFirst(rx, ry); 
/*    */   }
/*    */   
/*    */   public PLACABLE copy() {
/* 27 */     return (PLACABLE)this.copy;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\ROOM_COPY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
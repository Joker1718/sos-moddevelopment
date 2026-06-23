/*    */ package settlement.path.finders;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.util.FINDABLE;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import snake2d.util.map.MAP_OBJECT;
/*    */ 
/*    */ public abstract class SFinderRoomService
/*    */   extends SFinderFindable
/*    */   implements MAP_OBJECT<FSERVICE> {
/*    */   public SFinderRoomService(CharSequence s) {
/* 12 */     super(s);
/*    */   }
/*    */ 
/*    */   
/*    */   public FINDABLE getReservable(int tx, int ty) {
/* 17 */     FINDABLE f = (FINDABLE)get(tx, ty);
/* 18 */     if (f != null && f.findableReservedCanBe())
/* 19 */       return f; 
/* 20 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public FINDABLE getReserved(int tx, int ty) {
/* 25 */     FINDABLE f = (FINDABLE)get(tx, ty);
/* 26 */     if (f != null && f.findableReservedIs())
/* 27 */       return f; 
/* 28 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public FSERVICE get(int tile) {
/* 34 */     return (FSERVICE)get(tile % SETT.TWIDTH, tile / SETT.TWIDTH);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderRoomService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
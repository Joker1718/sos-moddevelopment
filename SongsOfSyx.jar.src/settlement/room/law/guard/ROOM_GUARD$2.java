/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.path.finders.SFinderRoomService;
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
/*    */   extends SFinderRoomService
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 51 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public FSERVICE get(int tx, int ty) {
/* 55 */     GuardInstance ins = (GuardInstance)ROOM_GUARD.this.getter.get(tx, ty);
/* 56 */     if (ins != null && ins.body().cX() == tx && ins.body().cY() == ty)
/* 57 */       return ROOM_GUARD.this.service.get(ins); 
/* 58 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\ROOM_GUARD$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
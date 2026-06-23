/*    */ package settlement.room.law.execution;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.ROOMS;
/*    */ import settlement.room.main.RoomBlueprint;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.RoomSingleton;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ 
/*    */ public class ExecutionSingle
/*    */   extends RoomSingleton
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   protected ExecutionSingle(ROOMS m, RoomBlueprint p) {
/* 18 */     super(m, p);
/*    */   }
/*    */ 
/*    */   
/*    */   public ROOM_EXECTUTION blueprintI() {
/* 23 */     return (SETT.ROOMS()).EXECUTION;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void addAction(ROOMA ins) {
/* 28 */     for (COORDINATE c : ins.body()) {
/* 29 */       if (ins.is(c)) {
/* 30 */         (blueprintI()).stations.init(c.x(), c.y());
/*    */       }
/*    */     } 
/* 33 */     super.addAction(ins);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void removeAction(ROOMA ins) {
/* 38 */     for (COORDINATE c : ins.body()) {
/* 39 */       if (ins.is(c)) {
/* 40 */         (blueprintI()).stations.dispose(c.x(), c.y());
/*    */       }
/*    */     } 
/* 43 */     super.removeAction(ins);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateTileDay(int tx, int ty) {
/* 48 */     (blueprintI()).stations.update(tx, ty);
/* 49 */     super.updateTileDay(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\ExecutionSingle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
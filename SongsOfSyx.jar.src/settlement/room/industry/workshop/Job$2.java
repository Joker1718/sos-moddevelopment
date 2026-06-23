/*    */ package settlement.room.industry.workshop;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.job.RoomResDeposit;
/*    */ import settlement.room.main.job.RoomResStorage;
/*    */ import snake2d.util.datatypes.COORDINATE;
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
/*    */   extends RoomResDeposit
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0) {
/* 44 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 48 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hasCallback() {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean regularJobCanBeReserved(COORDINATE coo) {
/* 59 */     WorkshopInstance ins = (WorkshopInstance)print.get(coo.x(), coo.y());
/* 60 */     return ins.hasStorage;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void regularJobStore(COORDINATE coo, int am) {
/* 65 */     WorkshopInstance ins = (WorkshopInstance)print.get(coo.x(), coo.y());
/* 66 */     int x1 = ins.sx;
/* 67 */     int y1 = ins.sy;
/* 68 */     RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)ins);
/*    */     
/* 70 */     while (ss != null && am > 0) {
/* 71 */       if (ss.hasRoom()) {
/* 72 */         ss.deposit();
/* 73 */         am--;
/*    */         
/*    */         continue;
/*    */       } 
/* 77 */       RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)ins);
/* 78 */       if (sss == null)
/* 79 */         sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)ins); 
/* 80 */       ss = sss;
/*    */     } 
/* 82 */     if (am > 0)
/* 83 */       ins.hasStorage = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Job$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
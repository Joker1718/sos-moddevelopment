/*    */ package settlement.room.industry.refiner;
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
/*    */ class null
/*    */   extends RoomResDeposit
/*    */ {
/*    */   null(RoomBlueprintImp $anonymous0) {
/* 43 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected boolean is(int tx, int ty) {
/* 47 */     return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3);
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
/* 58 */     RefinerInstance ins = (RefinerInstance)print.get(coo.x(), coo.y());
/* 59 */     return ins.hasStorage;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void regularJobStore(COORDINATE coo, int am) {
/* 64 */     RefinerInstance ins = (RefinerInstance)print.get(coo.x(), coo.y());
/* 65 */     int x1 = ins.sx;
/* 66 */     int y1 = ins.sy;
/* 67 */     RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)ins);
/*    */     
/* 69 */     while (ss != null && am > 0) {
/* 70 */       if (ss.hasRoom()) {
/* 71 */         ss.deposit();
/* 72 */         am--;
/*    */         
/*    */         continue;
/*    */       } 
/* 76 */       RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)ins);
/* 77 */       if (sss == null)
/* 78 */         sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)ins); 
/* 79 */       ss = sss;
/*    */     } 
/* 81 */     if (am > 0)
/* 82 */       ins.hasStorage = false; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\refiner\Job$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
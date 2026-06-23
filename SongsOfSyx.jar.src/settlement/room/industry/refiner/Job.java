/*    */ package settlement.room.industry.refiner;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.main.SETT;
/*    */ import settlement.misc.job.SETT_JOB;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import settlement.room.industry.module.ROOM_PRODUCER_INSTANCE;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import settlement.room.main.job.RoomResDeposit;
/*    */ import settlement.room.main.job.RoomResStorage;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ 
/*    */ class Job {
/*    */   final RoomResDeposit FETCH;
/*    */   final RoomResStorage storage;
/*    */   
/*    */   Job(final ROOM_REFINER print, int store) {
/* 19 */     this.storage = new RoomResStorage(store)
/*    */       {
/*    */         public RESOURCE resource()
/*    */         {
/* 23 */           ROOM_PRODUCER_INSTANCE ins = (ROOM_PRODUCER_INSTANCE)(SETT.ROOMS()).map.get((COORDINATE)this);
/* 24 */           return ((IndustryResource)ins.industry().outs().get(0)).resource;
/*    */         }
/*    */ 
/*    */         
/*    */         protected boolean is(int tx, int ty) {
/* 29 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */         }
/*    */ 
/*    */         
/*    */         protected void changed(int tx, int ty) {
/* 34 */           if (hasRoom()) {
/* 35 */             RefinerInstance m = (RefinerInstance)print.get(tx, ty);
/* 36 */             m.hasStorage = true;
/* 37 */             m.jobs.searchAgain();
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 43 */     this.FETCH = new RoomResDeposit((RoomBlueprintImp)print)
/*    */       {
/*    */         protected boolean is(int tx, int ty)
/*    */         {
/* 47 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         protected void hasCallback() {}
/*    */ 
/*    */ 
/*    */         
/*    */         protected boolean regularJobCanBeReserved(COORDINATE coo) {
/* 58 */           RefinerInstance ins = (RefinerInstance)print.get(coo.x(), coo.y());
/* 59 */           return ins.hasStorage;
/*    */         }
/*    */ 
/*    */         
/*    */         protected void regularJobStore(COORDINATE coo, int am) {
/* 64 */           RefinerInstance ins = (RefinerInstance)print.get(coo.x(), coo.y());
/* 65 */           int x1 = ins.sx;
/* 66 */           int y1 = ins.sy;
/* 67 */           RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)ins);
/*    */           
/* 69 */           while (ss != null && am > 0) {
/* 70 */             if (ss.hasRoom()) {
/* 71 */               ss.deposit();
/* 72 */               am--;
/*    */               
/*    */               continue;
/*    */             } 
/* 76 */             RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)ins);
/* 77 */             if (sss == null)
/* 78 */               sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)ins); 
/* 79 */             ss = sss;
/*    */           } 
/* 81 */           if (am > 0) {
/* 82 */             ins.hasStorage = false;
/*    */           }
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */   
/*    */   SETT_JOB init(int tx, int ty, RefinerInstance ins) {
/* 90 */     return (SETT_JOB)this.FETCH.get(tx, ty, ins);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\refiner\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
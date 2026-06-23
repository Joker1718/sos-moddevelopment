/*    */ package settlement.room.industry.workshop;
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
/*    */   private final ROOM_WORKSHOP print;
/*    */   
/* 17 */   final RoomResStorage storage = new RoomResStorage(31)
/*    */     {
/*    */       public RESOURCE resource()
/*    */       {
/* 21 */         ROOM_PRODUCER_INSTANCE ins = (ROOM_PRODUCER_INSTANCE)(SETT.ROOMS()).map.get((COORDINATE)this);
/* 22 */         return ((IndustryResource)ins.industry().outs().get(0)).resource;
/*    */       }
/*    */ 
/*    */       
/*    */       protected boolean is(int tx, int ty) {
/* 27 */         return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 2);
/*    */       }
/*    */ 
/*    */       
/*    */       protected void changed(int tx, int ty) {
/* 32 */         if (hasRoom()) {
/* 33 */           WorkshopInstance m = (WorkshopInstance)Job.this.print.get(tx, ty);
/* 34 */           m.hasStorage = true;
/* 35 */           m.jobs.searchAgain();
/*    */         } 
/*    */       }
/*    */     };
/*    */   
/*    */   final RoomResDeposit FETCH;
/*    */   
/*    */   Job(final ROOM_WORKSHOP print) {
/* 43 */     this.print = print;
/* 44 */     this.FETCH = new RoomResDeposit((RoomBlueprintImp)print)
/*    */       {
/*    */         protected boolean is(int tx, int ty)
/*    */         {
/* 48 */           return ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3);
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
/* 59 */           WorkshopInstance ins = (WorkshopInstance)print.get(coo.x(), coo.y());
/* 60 */           return ins.hasStorage;
/*    */         }
/*    */ 
/*    */         
/*    */         protected void regularJobStore(COORDINATE coo, int am) {
/* 65 */           WorkshopInstance ins = (WorkshopInstance)print.get(coo.x(), coo.y());
/* 66 */           int x1 = ins.sx;
/* 67 */           int y1 = ins.sy;
/* 68 */           RoomResStorage ss = Job.this.storage.get(x1, y1, (ROOMA)ins);
/*    */           
/* 70 */           while (ss != null && am > 0) {
/* 71 */             if (ss.hasRoom()) {
/* 72 */               ss.deposit();
/* 73 */               am--;
/*    */               
/*    */               continue;
/*    */             } 
/* 77 */             RoomResStorage sss = Job.this.storage.get(ss.x() + 1, ss.y(), (ROOMA)ins);
/* 78 */             if (sss == null)
/* 79 */               sss = Job.this.storage.get(x1, ss.y() + 1, (ROOMA)ins); 
/* 80 */             ss = sss;
/*    */           } 
/* 82 */           if (am > 0) {
/* 83 */             ins.hasStorage = false;
/*    */           }
/*    */         }
/*    */       };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   SETT_JOB init(int tx, int ty, WorkshopInstance ins) {
/* 92 */     return (SETT_JOB)this.FETCH.get(tx, ty, ins);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Job.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
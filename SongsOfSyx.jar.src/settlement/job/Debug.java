/*    */ package settlement.job;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import util.data.BOOLEAN;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Debug
/*    */ {
/*    */   static boolean showRoom = false;
/*    */   
/*    */   Debug() {
/* 24 */     PlacableMulti placableMulti = new PlacableMulti("reservePerform")
/*    */       {
/*    */         public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 27 */           Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 28 */           if (j == null) {
/*    */             return;
/*    */           }
/* 31 */           RBIT bb = j.jobResourceBitToFetch();
/* 32 */           RESOURCE res = null;
/* 33 */           if (bb != null) {
/* 34 */             for (RESOURCE r : RESOURCES.ALL()) {
/* 35 */               if (bb.has(r)) {
/* 36 */                 res = r;
/*    */                 break;
/*    */               } 
/*    */             } 
/*    */           }
/* 41 */           if (j.jobReserveCanBe()) {
/* 42 */             j.jobReserve(res);
/* 43 */           } else if (j.jobReservedIs(res)) {
/* 44 */             j.jobPerform(null, res, 1);
/*    */           } 
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 51 */           Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 52 */           if (j != null) {
/*    */             
/* 54 */             RBIT bb = j.jobResourceBitToFetch();
/* 55 */             RESOURCE res = null;
/* 56 */             if (bb != null) {
/* 57 */               for (RESOURCE r : RESOURCES.ALL()) {
/* 58 */                 if (bb.has(r)) {
/* 59 */                   res = r;
/*    */                   break;
/*    */                 } 
/*    */               } 
/*    */             }
/* 64 */             if (j.jobReserveCanBe() || j.jobReservedIs(res)) {
/* 65 */               return null;
/*    */             }
/*    */           } 
/* 68 */           return "";
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 76 */     IDebugPanelSett.add("job", (PLACABLE)placableMulti);
/*    */     
/* 78 */     BOOLEAN.BOOLEAN_MUTABLE roomJobs = new BOOLEAN.BOOLEAN_MUTABLE()
/*    */       {
/*    */         
/*    */         public boolean is()
/*    */         {
/* 83 */           return Debug.showRoom;
/*    */         }
/*    */ 
/*    */         
/*    */         public BOOLEAN.BOOLEAN_MUTABLE set(boolean bool) {
/* 88 */           Debug.showRoom = bool;
/* 89 */           return this;
/*    */         }
/*    */       };
/*    */     
/* 93 */     IDebugPanelSett.add("Show roomjobs", roomJobs);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\Debug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
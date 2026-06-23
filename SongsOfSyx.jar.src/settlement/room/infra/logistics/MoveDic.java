/*    */ package settlement.room.infra.logistics;
/*    */ 
/*    */ import util.text.D;
/*    */ 
/*    */ public class MoveDic
/*    */ {
/*  7 */   public static CharSequence ¤¤capacityD = "¤Used Capacity";
/*  8 */   public static CharSequence ¤¤allocatedCrates = "¤Allocated Crates/Total crates";
/*  9 */   public static CharSequence ¤¤storing = "¤Storing";
/* 10 */   public static CharSequence ¤¤storingD = "¤When storing, this warehouse is closed to outsiders, and no one will use it as a source of goods. Does not affect pull/fetch orders from other storage rooms.";
/* 11 */   public static CharSequence ¤¤keepD = "¤Other storage rooms will not be able to pull from this warehouse if the stored goods are below this limit.";
/* 12 */   public static CharSequence ¤¤fetch = "¤Fetch";
/* 13 */   public static CharSequence ¤¤fetchProblem = "¤There is nothing to fetch in the vicinity!";
/* 14 */   public static CharSequence ¤¤pullProblem = "¤Nothing can be pulled or fetched!";
/* 15 */   public static CharSequence ¤¤fetchD = "¤When enabled, the workers will fetch all odd resources from the ground and from production rooms within their radius.";
/* 16 */   public static CharSequence ¤¤fetching = "¤Fetching";
/*    */   
/* 18 */   public static CharSequence ¤¤crates = "Crates";
/* 19 */   public static CharSequence ¤¤capacity = "Capacity";
/* 20 */   public static CharSequence ¤¤capacityRes = "Capacity Reserved";
/* 21 */   public static CharSequence ¤¤Stored = "Stored";
/* 22 */   public static CharSequence ¤¤StoredD = "How much is stored in your warehouses.";
/* 23 */   public static CharSequence ¤¤StoredRes = "Stored Reserved";
/*    */   
/* 25 */   public static CharSequence ¤¤prio = "¤Prioritize";
/* 26 */   public static CharSequence ¤¤prioD = "¤Prioritized fetching allows workers to fetch from all other storage rooms that are not prioritized within their radius.";
/*    */   
/*    */   static {
/* 29 */     D.ts(MoveDic.class);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveDic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
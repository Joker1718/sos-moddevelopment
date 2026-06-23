/*    */ package settlement.stats;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
/*    */ import init.type.HTYPES;
/*    */ import init.type.HTYPE_RACE;
/*    */ import settlement.main.SETT;
/*    */ import world.army.AD;
/*    */ 
/*    */ public class POP
/*    */ {
/*    */   public static int tot(HCLASS c, Race r) {
/* 14 */     return others(c, r) + physical(c, r);
/*    */   }
/*    */   
/*    */   public static int tot(Race r) {
/* 18 */     return tot(null, r);
/*    */   }
/*    */   
/*    */   public static int tot() {
/* 22 */     return tot(null, null);
/*    */   }
/*    */   
/*    */   public static int physical(HCLASS c, Race r) {
/* 26 */     int pop = pop(c, r);
/* 27 */     if (c == null || c == HCLASSES.CITIZEN()) {
/* 28 */       pop += STATS.POP().pop(r, HTYPES.CHILD());
/* 29 */       pop += STATS.POP().pop(r, HTYPES.RIOTER());
/* 30 */       pop += STATS.POP().pop(r, HTYPES.DERANGED());
/* 31 */       pop += STATS.LAW().criminals(HCLASSES.CITIZEN(), r);
/*    */     } 
/* 33 */     if (c == null || c == HCLASSES.SLAVE()) {
/* 34 */       pop += STATS.POP().pop(r, HTYPES.CHILD_SLAVE());
/* 35 */       pop += STATS.LAW().criminals(HCLASSES.SLAVE(), r);
/*    */     } 
/*    */     
/* 38 */     return pop;
/*    */   }
/*    */   
/*    */   public static int others(HCLASS c, Race r) {
/* 42 */     int pop = 0;
/* 43 */     if (c == null || c == HCLASSES.CITIZEN()) {
/* 44 */       pop += AD.cityDivs().total(r);
/*    */     }
/*    */     
/* 47 */     return pop;
/*    */   }
/*    */   
/*    */   public static int next(HCLASS c, Race r) {
/* 51 */     int pop = tot(c, r);
/* 52 */     if (c == null || c == HCLASSES.CITIZEN()) {
/* 53 */       pop += (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.PARENT()));
/* 54 */       pop += SETT.ENTRY().onTheirWay(r, HTYPES.SUBJECT());
/*    */     } 
/* 56 */     if (c == null || c == HCLASSES.SLAVE()) {
/* 57 */       pop += (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.PARENT_SLAVE()));
/*    */       
/* 59 */       pop += SETT.ENTRY().onTheirWay(r, HTYPES.SLAVE());
/*    */     } 
/* 61 */     return pop;
/*    */   }
/*    */   
/*    */   public static int incoming(HCLASS c, Race r) {
/* 65 */     int pop = 0;
/* 66 */     if (c == null || c == HCLASSES.CITIZEN()) {
/* 67 */       pop += (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.PARENT()));
/* 68 */       pop += SETT.ENTRY().onTheirWay(r, HTYPES.SUBJECT());
/*    */     } 
/* 70 */     if (c == null || c == HCLASSES.SLAVE()) {
/* 71 */       pop += (STATS.POP()).POP.type().get(HTYPE_RACE.get(r, HTYPES.PARENT_SLAVE()));
/*    */       
/* 73 */       pop += SETT.ENTRY().onTheirWay(r, HTYPES.SLAVE());
/*    */     } 
/* 75 */     return pop;
/*    */   }
/*    */   
/*    */   public static int next(Race r) {
/* 79 */     return next(null, r);
/*    */   }
/*    */   
/*    */   public static int next() {
/* 83 */     return next(null, null);
/*    */   }
/*    */   
/*    */   public static int pop(HCLASS c, Race r) {
/* 87 */     return (STATS.POP()).POP.data(c).get(r);
/*    */   }
/*    */   
/*    */   public static int pop(Race r) {
/* 91 */     return tot(null, r);
/*    */   }
/*    */   
/*    */   public static int pop() {
/* 95 */     return tot(null, null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\POP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
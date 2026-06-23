/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.keymap.RMAPS;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class CAUSE_ARRIVES {
/* 10 */   private final ArrayListGrower<CAUSE_ARRIVE> all = new ArrayListGrower();
/*    */   
/*    */   CAUSE_ARRIVES() {
/* 13 */     D.gInit(this);
/*    */ 
/*    */     
/* 16 */     this.BORN = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 17 */         "BORN", 
/* 18 */         D.g("Born"), 
/* 19 */         D.g("BornD", "Subjects that have been born in your city."), false);
/* 20 */     this.IMMIGRATED = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 21 */         "IMMIGRATED", 
/* 22 */         D.g("Immigrated"), 
/* 23 */         D.g("ImmigratedD", "Subjects that have immigrated to your city."), true);
/* 24 */     this.EMANCIPATED = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 25 */         "EMANCIPATED", 
/* 26 */         D.g("Emancipated"), 
/* 27 */         D.g("EmancipatedD", "Subjects that are freed slaves."), false);
/* 28 */     this.PAROLE = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 29 */         "PAROLE", 
/* 30 */         D.g("Parole"), 
/* 31 */         D.g("ParoleD", "Subjects that have been prisoners and are now pardoned and free citizens."), false);
/* 32 */     this.SOLDIER_RETURN = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 33 */         "SOLDIER", 
/* 34 */         D.g("Soldiers"), 
/* 35 */         D.g("SoldiersD", "Soldiers that have returned from campaigning."), true);
/* 36 */     this.CURED = new CAUSE_ARRIVE((LISTE<CAUSE_ARRIVE>)this.all, 
/* 37 */         "CURED", 
/* 38 */         D.g("Readjusted"), 
/* 39 */         D.g("ReadjustedD", "Subjects that have been readjusted in the asylum and cured of insanity."), false);
/*    */     
/* 41 */     this.map = new RMAPS("CAUSE_ARRIVE", (LIST)this.all);
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
/* 74 */     self = this;
/*    */   }
/*    */   
/*    */   private final CAUSE_ARRIVE BORN;
/*    */   private final CAUSE_ARRIVE IMMIGRATED;
/*    */   private final CAUSE_ARRIVE EMANCIPATED;
/*    */   private final CAUSE_ARRIVE PAROLE;
/*    */   private final CAUSE_ARRIVE SOLDIER_RETURN;
/*    */   private final CAUSE_ARRIVE CURED;
/*    */   private final RMAPS<CAUSE_ARRIVE> map;
/*    */   private static CAUSE_ARRIVES self;
/*    */   
/*    */   public static LIST<CAUSE_ARRIVE> ALL() {
/*    */     return (LIST<CAUSE_ARRIVE>)self.all;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE BORN() {
/*    */     return self.BORN;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE IMMIGRATED() {
/*    */     return self.IMMIGRATED;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE EMANCIPATED() {
/*    */     return self.EMANCIPATED;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE PAROLE() {
/*    */     return self.PAROLE;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE SOLDIER_RETURN() {
/*    */     return self.SOLDIER_RETURN;
/*    */   }
/*    */   
/*    */   public static CAUSE_ARRIVE CURED() {
/*    */     return self.CURED;
/*    */   }
/*    */   
/*    */   public static RMAPS<CAUSE_ARRIVE> MAP() {
/*    */     return self.map;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CAUSE_ARRIVES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
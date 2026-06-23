/*    */ package settlement.stats.disease;
/*    */ 
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ public enum DiseaseStatus
/*    */ {
/*  8 */   NONE(false),
/*  9 */   INCUBATING(false),
/* 10 */   ISICK(true),
/* 11 */   IIMMUNE(false);
/*    */   public final boolean active;
/*    */   public static final LIST<DiseaseStatus> ALL;
/*    */   
/*    */   DiseaseStatus(boolean active) {
/* 16 */     this.active = active;
/*    */   }
/*    */   static {
/* 19 */     ALL = (LIST<DiseaseStatus>)new ArrayList((Object[])values());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\DiseaseStatus.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
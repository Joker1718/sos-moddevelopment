/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class CAUSE_LEAVE
/*    */   extends INFO
/*    */   implements MAPPED
/*    */ {
/*    */   public final String key;
/*    */   public final boolean death;
/*    */   public final boolean natural;
/*    */   
/*    */   CAUSE_LEAVE(LISTE<CAUSE_LEAVE> all, LISTE<CAUSE_LEAVE> deaths, String key, CharSequence name, CharSequence names, CharSequence desc, boolean death, boolean natural, boolean leavesCorpse) {
/* 16 */     super(name, names, desc, null);
/* 17 */     this.key = key;
/* 18 */     this.death = death;
/* 19 */     this.natural = natural;
/* 20 */     this.leavesCorpse = leavesCorpse;
/* 21 */     this.index = all.add(this);
/* 22 */     if (death) {
/* 23 */       this.indexDeath = deaths.add(this);
/*    */     } else {
/* 25 */       this.indexDeath = -1;
/*    */     } 
/*    */   }
/*    */   public final boolean leavesCorpse; private final int index; public final int indexDeath; double defAgony;
/*    */   public int index() {
/* 30 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 35 */     return this.key;
/*    */   }
/*    */   
/*    */   public double defaultStanding() {
/* 39 */     return this.defAgony;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CAUSE_LEAVE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
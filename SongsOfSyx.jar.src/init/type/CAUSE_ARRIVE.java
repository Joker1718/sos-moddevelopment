/*    */ package init.type;
/*    */ 
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.info.INFO;
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public final class CAUSE_ARRIVE
/*    */   extends INFO implements MAPPED {
/*    */   private final int index;
/*    */   public boolean fromoutside;
/*    */   private final String key;
/*    */   
/*    */   CAUSE_ARRIVE(LISTE<CAUSE_ARRIVE> all, String key, CharSequence name, CharSequence desc, boolean fromOutside) {
/* 14 */     super(name, desc);
/* 15 */     this.index = all.add(this);
/* 16 */     this.fromoutside = fromOutside;
/* 17 */     this.key = key;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 22 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 27 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CAUSE_ARRIVE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
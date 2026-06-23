/*    */ package init.resources;
/*    */ 
/*    */ import util.keymap.MAPPED;
/*    */ 
/*    */ public class ResG
/*    */   implements MAPPED {
/*    */   public final RESOURCE resource;
/*    */   private final int index;
/*    */   private final String key;
/*    */   
/*    */   ResG(int index, String key, RESOURCE r) {
/* 12 */     this.index = index;
/* 13 */     this.resource = r;
/* 14 */     this.key = key;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 19 */     return this.index;
/*    */   }
/*    */ 
/*    */   
/*    */   public String key() {
/* 24 */     return this.key;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResG.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
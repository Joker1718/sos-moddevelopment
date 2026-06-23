/*    */ package settlement.entity;
/*    */ 
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ public enum GENDER
/*    */ {
/*  7 */   MALE("male", 1.0F), FEMALE("female", 0.6F);
/*    */   
/*    */   public final float weightReduction;
/*    */   public final String name;
/*    */   
/*    */   GENDER(String name, float weightRed) {
/* 13 */     this.name = name;
/* 14 */     this.weightReduction = weightRed;
/*    */   }
/*    */   
/*    */   public static GENDER getRND() {
/* 18 */     return values()[RND.rInt(2)];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\GENDER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
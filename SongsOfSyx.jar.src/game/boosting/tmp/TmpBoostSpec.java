/*    */ package game.boosting.tmp;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.boosting.BoostSpecs;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TmpBoostSpec
/*    */ {
/*    */   public final CharSequence name;
/*    */   public final CharSequence desc;
/*    */   public final SPRITE icon;
/* 17 */   public final int index = TmpBoosting.allTmp.add(this); public TmpBoostSpec(String key, CharSequence name, CharSequence desc, SPRITE icon) {
/* 18 */     int i = 1;
/* 19 */     String k = key;
/* 20 */     while (TmpBoosting.allMap.containsKey(k)) {
/* 21 */       k = key + key;
/* 22 */       i++;
/*    */     } 
/*    */     
/* 25 */     TmpBoosting.allMap.put(k, this);
/* 26 */     this.key = key;
/* 27 */     this.name = name;
/* 28 */     this.desc = desc;
/* 29 */     this.icon = icon;
/* 30 */     this.spec = new BoostSpecs(new BSourceInfo(name, icon), false);
/*    */   }
/*    */   
/*    */   public BoostSpecs spec;
/*    */   public final String key;
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TmpBoostSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
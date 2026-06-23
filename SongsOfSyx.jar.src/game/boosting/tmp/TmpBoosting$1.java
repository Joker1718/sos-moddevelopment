/*    */ package game.boosting.tmp;
/*    */ 
/*    */ import game.boosting.BoostSpec;
/*    */ import game.boosting.Booster;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 57 */     TmpBoosting.allTmp = null;
/*    */     
/* 59 */     for (int i = 0; i < TmpBoosting.this.datas.length; i++) {
/* 60 */       TmpBoosting.this.datas[i] = new Data(TmpBoosting.this.specs.size());
/*    */     }
/*    */     
/* 63 */     KeyMap<ArrayListGrower<BoostSpec>> map = new KeyMap();
/*    */     
/* 65 */     for (TmpBoostSpec ts : TmpBoosting.this.specs) {
/* 66 */       for (BoostSpec s : ts.spec.all()) {
/* 67 */         String k = s.boostable.key + s.boostable.key;
/* 68 */         if (!map.containsKey(k)) {
/* 69 */           map.put(k, new ArrayListGrower());
/*    */         }
/* 71 */         ((ArrayListGrower)map.get(k)).add(s);
/*    */       } 
/*    */     } 
/*    */     
/* 75 */     for (LIST<BoostSpec> bos : (Iterable<LIST<BoostSpec>>)map.all()) {
/* 76 */       boolean isMul = ((BoostSpec)bos.get(0)).booster.isMul;
/* 77 */       double min = (isMul ? true : false);
/* 78 */       double max = min;
/*    */       
/* 80 */       for (BoostSpec s : bos) {
/* 81 */         Booster b = s.booster;
/* 82 */         if (isMul) {
/* 83 */           if (b.to() < 1.0D) {
/* 84 */             min *= b.to(); continue;
/*    */           } 
/* 86 */           max *= b.to(); continue;
/*    */         } 
/* 88 */         if (b.to() < 0.0D) {
/* 89 */           min += b.to(); continue;
/*    */         } 
/* 91 */         max += b.to();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TmpBoosting$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package game.boosting;
/*    */ 
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BUtil
/*    */ {
/*    */   public static <T> double min(LIST<? extends BoosterAbs<T>> all, Class<?> b, double baseValue) {
/* 13 */     double m = 1.0D;
/* 14 */     double a = baseValue;
/* 15 */     for (int i = 0; i < all.size(); i++) {
/* 16 */       BoosterAbs<T> bb = (BoosterAbs<T>)all.get(i);
/* 17 */       if (bb.isMul) {
/* 18 */         m *= bb.min();
/*    */       } else {
/* 20 */         a += bb.min();
/*    */       } 
/*    */     } 
/*    */     
/* 24 */     return m * a;
/*    */   }
/*    */   
/*    */   public static <T> double max(LIST<? extends BoosterAbs<T>> all, Class<?> b, double baseValue) {
/* 28 */     double m = 1.0D;
/* 29 */     double a = baseValue;
/* 30 */     for (int i = 0; i < all.size(); i++) {
/* 31 */       BoosterAbs<T> bb = (BoosterAbs<T>)all.get(i);
/* 32 */       if (bb.isMul) {
/* 33 */         m *= bb.max();
/*    */       } else {
/* 35 */         a += bb.max();
/*    */       } 
/*    */     } 
/*    */     
/* 39 */     return m * a;
/*    */   }
/*    */   
/*    */   public static double value(LIST<? extends BoosterAbs<?>> all, double input, double add, double mul, double minValue) {
/* 43 */     double padd = (add > 0.0D) ? add : 0.0D;
/* 44 */     double sub = (add < 0.0D) ? add : 0.0D;
/* 45 */     for (int si = 0; si < all.size(); si++) {
/* 46 */       BoosterAbs<?> s = (BoosterAbs)all.get(si);
/* 47 */       if (s.isMul) {
/* 48 */         mul *= s.getValue(input);
/*    */       } else {
/* 50 */         double a = s.getValue(input);
/* 51 */         if (a < 0.0D) {
/* 52 */           sub += a;
/*    */         } else {
/* 54 */           padd += a;
/*    */         } 
/*    */       } 
/* 57 */     }  return CLAMP.d(padd * mul + sub, minValue, Double.MAX_VALUE);
/*    */   }
/*    */   
/*    */   public static <T> double value(LIST<? extends BoosterAbs<T>> all, T t, double add, double mul, double minValue) {
/* 61 */     double padd = (add > 0.0D) ? add : 0.0D;
/* 62 */     double sub = (add < 0.0D) ? add : 0.0D;
/* 63 */     for (int si = 0; si < all.size(); si++) {
/* 64 */       BoosterAbs<T> s = (BoosterAbs<T>)all.get(si);
/* 65 */       if (s.isMul) {
/* 66 */         mul *= s.get(t);
/*    */       } else {
/* 68 */         double a = s.get(t);
/* 69 */         if (a < 0.0D) {
/* 70 */           sub += a;
/*    */         } else {
/* 72 */           padd += a;
/*    */         } 
/*    */       } 
/*    */     } 
/* 76 */     return CLAMP.d(padd * mul + sub, minValue, Double.MAX_VALUE);
/*    */   }
/*    */   
/*    */   public static <T> double value(LIST<? extends BoosterAbs<T>> all, T t) {
/* 80 */     return value(all, t, 1.0D, 1.0D, 0.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package util.keymap;
/*    */ 
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
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
/*    */ 
/*    */ public final class Saver
/*    */ {
/*    */   private Saver(FilePutter f) {
/* 54 */     f.mark(paramRMAPS);
/* 55 */     f.i(paramRMAPS.all().size());
/* 56 */     for (MAPPED mAPPED : paramRMAPS.all()) {
/* 57 */       f.chars(mAPPED.key());
/*    */     }
/* 59 */     f.mark(paramRMAPS);
/*    */   }
/*    */   
/*    */   public void save(T t, FilePutter f) {
/* 63 */     if (t == null) {
/* 64 */       f.i(-1);
/*    */     } else {
/* 66 */       f.i(t.index());
/*    */     } 
/*    */   }
/*    */   public void save(int[] amounts, FilePutter f) {
/* 70 */     RMAPS.this.check(amounts.length);
/* 71 */     f.is(amounts);
/*    */   }
/*    */   
/*    */   public void save(short[] amounts, FilePutter f) {
/* 75 */     RMAPS.this.check(amounts.length);
/* 76 */     f.ss(amounts);
/*    */   }
/*    */   
/*    */   public void save(SAVABLE[] amounts, FilePutter f) {
/* 80 */     RMAPS.this.check(amounts.length); byte b; int i; SAVABLE[] arrayOfSAVABLE;
/* 81 */     for (i = (arrayOfSAVABLE = amounts).length, b = 0; b < i; ) { SAVABLE s = arrayOfSAVABLE[b];
/* 82 */       s.save(f);
/*    */       b++; }
/*    */   
/*    */   } public void save(LIST<? extends SAVABLE> amounts, FilePutter f) {
/* 86 */     RMAPS.this.check(amounts.size());
/* 87 */     for (SAVABLE s : amounts)
/* 88 */       s.save(f); 
/*    */   }
/*    */   
/*    */   public void save(double[] amounts, FilePutter f) {
/* 92 */     RMAPS.this.check(amounts.length);
/* 93 */     f.ds(amounts);
/*    */   }
/*    */   
/*    */   public void save(long[] amounts, FilePutter f) {
/* 97 */     RMAPS.this.check(amounts.length);
/* 98 */     f.ls(amounts);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMAPS$Saver.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
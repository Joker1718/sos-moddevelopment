/*    */ package world.battle;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.MATH;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.rnd.RND;
/*    */ 
/*    */ final class Rnd
/*    */   implements SAVABLE
/*    */ {
/* 14 */   private static final int[] rnds = Alloc.ii(2024);
/* 15 */   private static int ri = 0;
/*    */   
/*    */   public static double f() {
/* 18 */     double d = (inc() & Integer.MAX_VALUE);
/* 19 */     return d / 2.147483647E9D;
/*    */   }
/*    */   
/*    */   public static int i() {
/* 23 */     return inc();
/*    */   }
/*    */   
/*    */   public static int i(int max) {
/* 27 */     return MATH.mod(inc(), max);
/*    */   }
/*    */   
/*    */   public static boolean oneIn(int am) {
/* 31 */     int d = MATH.mod(inc(), am);
/* 32 */     return (d == 0);
/*    */   }
/*    */   
/*    */   private static int inc() {
/* 36 */     int r = rnds[ri];
/* 37 */     rnds[ri] = RND.rInt();
/* 38 */     ri++;
/* 39 */     if (ri >= rnds.length)
/* 40 */       ri = 0; 
/* 41 */     return r;
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 46 */     file.is(rnds);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 51 */     file.is(rnds);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 56 */     for (int i = 0; i < rnds.length; i++)
/* 57 */       rnds[i] = RND.rInt(); 
/* 58 */     ri = 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Rnd.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
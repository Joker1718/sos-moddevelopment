/*    */ package game.debug;
/*    */ 
/*    */ import game.GAME;
/*    */ import java.nio.file.Path;
/*    */ import java.util.Comparator;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.KeyMap;
/*    */ 
/*    */ 
/*    */ public final class CallCounter
/*    */ {
/*    */   private final int max;
/*    */   private int count;
/* 15 */   private final KeyMap<EE> map = new KeyMap();
/*    */   
/*    */   private boolean running = false;
/*    */   
/*    */   public CallCounter(int max) {
/* 20 */     this.max = max;
/* 21 */     GAME.saver().onAfterLoad(new ACTION.ACTION_O<Path>()
/*    */         {
/*    */           public void exe(Path t)
/*    */           {
/* 25 */             CallCounter.this.running = true;
/*    */           }
/*    */         });
/*    */   }
/*    */   
/*    */   private static class EE
/*    */   {
/*    */     final StackTraceElement[] ee;
/* 33 */     int count = 0;
/*    */     
/*    */     EE(StackTraceElement[] ee) {
/* 36 */       this.ee = ee;
/*    */     }
/*    */   }
/*    */   
/*    */   public void count() {
/* 41 */     if (!this.running)
/*    */       return; 
/* 43 */     StackTraceElement[] eee = Thread.currentThread().getStackTrace();
/* 44 */     String ii = ""; byte b; int i; StackTraceElement[] arrayOfStackTraceElement1;
/* 45 */     for (i = (arrayOfStackTraceElement1 = eee).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement1[b];
/* 46 */       ii = ii + ii; b++; }
/*    */     
/* 48 */     if (!this.map.containsKey(ii)) {
/* 49 */       this.map.put(ii, new EE(eee));
/*    */     }
/* 51 */     ((EE)this.map.get(ii)).count++;
/* 52 */     this.count++;
/*    */     
/* 54 */     if (this.count > this.max) {
/*    */ 
/*    */       
/* 57 */       ArrayList<EE> es = new ArrayList((Iterable)this.map.all());
/* 58 */       es.sort(new Comparator<EE>()
/*    */           {
/*    */             public int compare(CallCounter.EE o1, CallCounter.EE o2)
/*    */             {
/* 62 */               return o1.count - o2.count;
/*    */             }
/*    */           });
/*    */       
/* 66 */       for (EE e : es) {
/* 67 */         if (e.count > 0) {
/* 68 */           System.out.println(e.count);
/* 69 */           for (int ei = 2; ei < e.ee.length; ei++) {
/* 70 */             System.out.println(e.ee[ei]);
/*    */           }
/* 72 */           System.out.println();
/* 73 */           e.count = 0;
/*    */         } 
/*    */       } 
/*    */       
/* 77 */       this.count = 0;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\debug\CallCounter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
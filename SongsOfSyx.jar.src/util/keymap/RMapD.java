/*    */ package util.keymap;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.data.GETTER_TRANS;
/*    */ 
/*    */ public class RMapD<T extends MAPPED>
/*    */   implements DOUBLE_O.DOUBLE_OE<T>, SAVABLE
/*    */ {
/*    */   private final RMAPS<T> map;
/*    */   private final double[] data;
/*    */   
/*    */   public RMapD(RMAPS<T> map) {
/* 19 */     this(map, Double.MIN_VALUE, Double.MAX_VALUE);
/*    */   }
/*    */   
/*    */   public RMapD(RMAPS<T> map, double min, double max) {
/* 23 */     this.map = map;
/* 24 */     this.data = new double[map.all().size()];
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 29 */     this.map.saver().save(this.data, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 34 */     this.map.loader().load(this.data, file, 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clear() {
/* 39 */     Arrays.fill(this.data, 0.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double getD(T t) {
/* 44 */     return this.data[t.index()];
/*    */   }
/*    */ 
/*    */   
/*    */   public DOUBLE_O.DOUBLE_OE<T> setD(T t, double d) {
/* 49 */     this.data[t.index()] = d;
/* 50 */     return this;
/*    */   }
/*    */   
/*    */   public static class RMapDTwo<A extends MAPPED, B extends MAPPED>
/*    */     implements GETTER_TRANS<A, RMapD<B>>, SAVABLE {
/*    */     private final ArrayList<RMapD<B>> all;
/*    */     private final RMAPS<A> map;
/*    */     private final SAVABLE[] ss;
/*    */     
/*    */     public RMapDTwo(RMAPS<A> map, RMAPS<B> map2) {
/* 60 */       this(map, map2, -2147483648, 2147483647);
/*    */     }
/*    */     
/*    */     public RMapDTwo(RMAPS<A> map, RMAPS<B> map2, int min, int max) {
/* 64 */       this.map = map;
/* 65 */       this.all = new ArrayList(map.all().size());
/* 66 */       this.ss = new SAVABLE[map.all().size()];
/* 67 */       for (int i = 0; i < this.ss.length; i++) {
/* 68 */         RMapD<B> b = new RMapD<>(map2);
/* 69 */         this.ss[i] = b;
/* 70 */         this.all.add(b);
/*    */       } 
/*    */     }
/*    */ 
/*    */     
/*    */     public void save(FilePutter file) {
/* 76 */       this.map.saver().save(this.ss, file);
/*    */     }
/*    */ 
/*    */     
/*    */     public void load(FileGetter file) throws IOException {
/* 81 */       this.map.loader().load(this.ss, file);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void clear() {}
/*    */ 
/*    */ 
/*    */     
/*    */     public RMapD<B> get(A f) {
/* 92 */       return (RMapD<B>)this.all.get(f.index());
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMapD.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
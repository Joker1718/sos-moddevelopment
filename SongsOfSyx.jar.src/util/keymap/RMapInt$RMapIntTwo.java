/*     */ package util.keymap;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER_TRANS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RMapIntTwo<A extends MAPPED, B extends MAPPED>
/*     */   implements GETTER_TRANS<A, RMapInt<B>>, SAVABLE
/*     */ {
/*     */   private final ArrayList<RMapInt<B>> all;
/*     */   private final RMAPS<A> map;
/*     */   private final SAVABLE[] ss;
/*     */   
/*     */   public RMapIntTwo(RMAPS<A> map, RMAPS<B> map2) {
/* 108 */     this(map, map2, -2147483648, 2147483647);
/*     */   }
/*     */   
/*     */   public RMapIntTwo(RMAPS<A> map, RMAPS<B> map2, int min, int max) {
/* 112 */     this.map = map;
/* 113 */     this.all = new ArrayList(map.all().size());
/* 114 */     this.ss = new SAVABLE[map.all().size()];
/* 115 */     for (int i = 0; i < this.ss.length; i++) {
/* 116 */       RMapInt<B> b = new RMapInt<>(map2, min, max);
/* 117 */       this.ss[i] = b;
/* 118 */       this.all.add(b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 124 */     this.map.saver().save(this.ss, file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 129 */     this.map.loader().load(this.ss, file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 134 */     for (RMapInt<B> b : this.all) {
/* 135 */       b.clear();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public RMapInt<B> get(A f) {
/* 141 */     return (RMapInt<B>)this.all.get(f.index());
/*     */   }
/*     */   
/*     */   public void setAll(int v) {
/* 145 */     for (RMapInt<B> b : this.all)
/* 146 */       b.setAll(v); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMapInt$RMapIntTwo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
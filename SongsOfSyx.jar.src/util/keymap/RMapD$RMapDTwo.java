/*    */ package util.keymap;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.file.SAVABLE;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.data.GETTER_TRANS;
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
/*    */ public class RMapDTwo<A extends MAPPED, B extends MAPPED>
/*    */   implements GETTER_TRANS<A, RMapD<B>>, SAVABLE
/*    */ {
/*    */   private final ArrayList<RMapD<B>> all;
/*    */   private final RMAPS<A> map;
/*    */   private final SAVABLE[] ss;
/*    */   
/*    */   public RMapDTwo(RMAPS<A> map, RMAPS<B> map2) {
/* 60 */     this(map, map2, -2147483648, 2147483647);
/*    */   }
/*    */   
/*    */   public RMapDTwo(RMAPS<A> map, RMAPS<B> map2, int min, int max) {
/* 64 */     this.map = map;
/* 65 */     this.all = new ArrayList(map.all().size());
/* 66 */     this.ss = new SAVABLE[map.all().size()];
/* 67 */     for (int i = 0; i < this.ss.length; i++) {
/* 68 */       RMapD<B> b = new RMapD<>(map2);
/* 69 */       this.ss[i] = b;
/* 70 */       this.all.add(b);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void save(FilePutter file) {
/* 76 */     this.map.saver().save(this.ss, file);
/*    */   }
/*    */ 
/*    */   
/*    */   public void load(FileGetter file) throws IOException {
/* 81 */     this.map.loader().load(this.ss, file);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public RMapD<B> get(A f) {
/* 92 */     return (RMapD<B>)this.all.get(f.index());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMapD$RMapDTwo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
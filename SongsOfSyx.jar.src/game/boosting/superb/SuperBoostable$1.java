/*    */ package game.boosting.superb;
/*    */ 
/*    */ import game.save.Savable;
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
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
/*    */   extends Savable
/*    */ {
/*    */   null(String $anonymous0) {
/* 35 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void save(FilePutter file) {
/* 39 */     file.i(SuperBoostable.this.ups.size());
/* 40 */     for (SuperSpec.SuperSpecImp<T> s : (Iterable<SuperSpec.SuperSpecImp<T>>)SuperBoostable.this.ups) {
/* 41 */       file.chars(s.key);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {
/* 47 */     int am = file.i();
/* 48 */     SuperBoostable.this.saveOrder = Alloc.ii(am); int i;
/* 49 */     for (i = 0; i < SuperBoostable.this.saveOrder.length; i++)
/* 50 */       SuperBoostable.this.saveOrder[i] = -1; 
/* 51 */     for (i = 0; i < am; i++) {
/* 52 */       String k = file.chars();
/* 53 */       if (SuperBoostable.this.map.containsKey(k))
/* 54 */         SuperBoostable.this.saveOrder[i] = ((SuperSpec.SuperSpecImp)SuperBoostable.this.map.get(k)).index; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\superb\SuperBoostable$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
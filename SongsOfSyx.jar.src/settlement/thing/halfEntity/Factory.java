/*    */ package settlement.thing.halfEntity;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sets.Stack;
/*    */ 
/*    */ 
/*    */ public abstract class Factory<T extends HalfEntity>
/*    */ {
/*    */   final int index;
/* 13 */   private final Stack<T> free = new Stack(128);
/*    */   
/*    */   protected Factory(LISTE<Factory<?>> all) {
/* 16 */     this.index = all.add(this);
/*    */   }
/*    */   
/*    */   protected abstract void save(FilePutter paramFilePutter);
/*    */   
/*    */   protected abstract void load(FileGetter paramFileGetter) throws IOException;
/*    */   
/*    */   protected abstract void clear();
/*    */   
/*    */   protected final T create() {
/* 26 */     if (!this.free.isEmpty())
/* 27 */       return (T)this.free.pop(); 
/* 28 */     return make();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract T make();
/*    */   
/*    */   protected void returnT(HalfEntity t) {
/* 35 */     if (!this.free.isFull())
/* 36 */       this.free.push(t); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\Factory.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
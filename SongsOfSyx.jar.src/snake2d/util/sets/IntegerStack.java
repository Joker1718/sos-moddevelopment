/*    */ package snake2d.util.sets;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Serializable;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public class IntegerStack
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final int[] ints;
/* 14 */   private int current = -1;
/*    */   
/*    */   public IntegerStack(int maxSize) {
/* 17 */     this.ints = Alloc.ii(maxSize);
/*    */   }
/*    */   
/*    */   public final void save(FilePutter fp) {
/* 21 */     fp.is(this.ints);
/* 22 */     fp.writeInt(this.current);
/*    */   }
/*    */   
/*    */   public final void load(FileGetter fp) throws IOException {
/* 26 */     fp.is(this.ints);
/* 27 */     this.current = fp.i();
/*    */   }
/*    */   
/*    */   public IntegerStack fill() {
/* 31 */     if (this.current != -1)
/* 32 */       throw new RuntimeException("has elements"); 
/* 33 */     for (int i = this.ints.length - 1; i >= 0; i--)
/* 34 */       push(i); 
/* 35 */     return this;
/*    */   }
/*    */   
/*    */   public int pop() {
/* 39 */     if (this.current >= 0)
/* 40 */       return this.ints[this.current--]; 
/* 41 */     throw new RuntimeException("I'm empty!");
/*    */   }
/*    */   
/*    */   public boolean push(int i) {
/* 45 */     if (!isFull()) {
/* 46 */       this.ints[++this.current] = i;
/* 47 */       return true;
/*    */     } 
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isFull() {
/* 53 */     return (this.current >= this.ints.length - 1);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 57 */     return (this.current == -1);
/*    */   }
/*    */   
/*    */   public IntegerStack clear() {
/* 61 */     this.current = -1;
/* 62 */     return this;
/*    */   }
/*    */   
/*    */   public int size() {
/* 66 */     return this.current + 1;
/*    */   }
/*    */   
/*    */   public int get(int index) {
/* 70 */     return this.ints[index];
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\IntegerStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
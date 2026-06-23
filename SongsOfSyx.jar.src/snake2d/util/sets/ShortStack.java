/*    */ package snake2d.util.sets;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Serializable;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ 
/*    */ public class ShortStack
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final short[] ints;
/* 13 */   private int current = -1;
/*    */   
/*    */   public ShortStack(int maxSize) {
/* 16 */     this.ints = new short[maxSize];
/*    */   }
/*    */   
/*    */   public final void save(FilePutter fp) {
/* 20 */     fp.ss(this.ints);
/* 21 */     fp.writeInt(this.current);
/*    */   }
/*    */   
/*    */   public final void load(FileGetter fp) throws IOException {
/* 25 */     fp.ss(this.ints);
/* 26 */     this.current = fp.i();
/*    */   }
/*    */   
/*    */   public ShortStack fill() {
/* 30 */     if (this.current != -1)
/* 31 */       throw new RuntimeException("has elements"); 
/* 32 */     for (int i = this.ints.length - 1; i >= 0; i--)
/* 33 */       push((short)i); 
/* 34 */     return this;
/*    */   }
/*    */   
/*    */   public short pop() {
/* 38 */     if (this.current >= 0)
/* 39 */       return this.ints[this.current--]; 
/* 40 */     throw new RuntimeException("I'm empty!");
/*    */   }
/*    */   
/*    */   public boolean push(short i) {
/* 44 */     if (!isFull()) {
/* 45 */       this.ints[++this.current] = i;
/* 46 */       return true;
/*    */     } 
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isFull() {
/* 52 */     return (this.current >= this.ints.length - 1);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 56 */     return (this.current == -1);
/*    */   }
/*    */   
/*    */   public ShortStack clear() {
/* 60 */     this.current = -1;
/* 61 */     return this;
/*    */   }
/*    */   
/*    */   public int size() {
/* 65 */     return this.current + 1;
/*    */   }
/*    */   
/*    */   public int get(int index) {
/* 69 */     return this.ints[index];
/*    */   }
/*    */   
/*    */   public int capacity() {
/* 73 */     return this.ints.length;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\ShortStack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
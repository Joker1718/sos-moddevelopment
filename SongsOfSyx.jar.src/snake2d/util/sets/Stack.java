/*    */ package snake2d.util.sets;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ public class Stack<T>
/*    */   implements Serializable {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final Object[] ints;
/*  9 */   private int current = -1;
/*    */   
/*    */   public Stack(int maxSize) {
/* 12 */     this.ints = new Object[maxSize];
/*    */   }
/*    */ 
/*    */   
/*    */   public T pop() {
/* 17 */     if (this.current >= 0)
/* 18 */       return (T)this.ints[this.current--]; 
/* 19 */     throw new RuntimeException("I'm empty!");
/*    */   }
/*    */   
/*    */   public boolean push(T i) {
/* 23 */     if (!isFull()) {
/* 24 */       this.ints[++this.current] = i;
/* 25 */       return true;
/*    */     } 
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isFull() {
/* 31 */     return (this.current >= this.ints.length - 1);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 35 */     return (this.current == -1);
/*    */   }
/*    */   
/*    */   public Stack<T> clear() {
/* 39 */     this.current = -1;
/* 40 */     return this;
/*    */   }
/*    */   
/*    */   public int size() {
/* 44 */     return this.current + 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sets\Stack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
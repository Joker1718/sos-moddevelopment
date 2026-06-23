/*    */ package org.lwjgl.system;
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
/*    */ public interface Pointer
/*    */ {
/* 26 */   public static final int POINTER_SIZE = MemoryAccessJNI.getPointerSize();
/*    */ 
/*    */   
/* 29 */   public static final int POINTER_SHIFT = (POINTER_SIZE == 8) ? 3 : 2;
/*    */ 
/*    */   
/* 32 */   public static final int CLONG_SIZE = (POINTER_SIZE == 8 && Platform.get() == Platform.WINDOWS) ? 4 : POINTER_SIZE;
/*    */ 
/*    */   
/* 35 */   public static final int CLONG_SHIFT = (CLONG_SIZE == 8) ? 3 : 2;
/*    */ 
/*    */   
/* 38 */   public static final boolean BITS32 = (POINTER_SIZE * 8 == 32);
/*    */ 
/*    */   
/* 41 */   public static final boolean BITS64 = (POINTER_SIZE * 8 == 64);
/*    */ 
/*    */ 
/*    */   
/*    */   long address();
/*    */ 
/*    */ 
/*    */   
/*    */   public static abstract class Default
/*    */     implements Pointer
/*    */   {
/*    */     protected long address;
/*    */ 
/*    */ 
/*    */     
/*    */     protected Default(long address) {
/* 57 */       if (Checks.CHECKS && address == 0L) {
/* 58 */         throw new NullPointerException();
/*    */       }
/* 60 */       this.address = address;
/*    */     }
/*    */ 
/*    */     
/*    */     public long address() {
/* 65 */       return this.address;
/*    */     }
/*    */     
/*    */     public boolean equals(Object o) {
/* 69 */       if (this == o) {
/* 70 */         return true;
/*    */       }
/* 72 */       if (!(o instanceof Pointer)) {
/* 73 */         return false;
/*    */       }
/*    */       
/* 76 */       Pointer that = (Pointer)o;
/*    */       
/* 78 */       return (this.address == that.address());
/*    */     }
/*    */     
/*    */     public int hashCode() {
/* 82 */       return (int)(this.address ^ this.address >>> 32L);
/*    */     }
/*    */ 
/*    */     
/*    */     public String toString() {
/* 87 */       return String.format("%s pointer [0x%X]", new Object[] { getClass().getSimpleName(), Long.valueOf(this.address) });
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Pointer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
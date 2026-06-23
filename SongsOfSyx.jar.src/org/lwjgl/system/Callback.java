/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.lang.invoke.MethodHandles;
/*     */ import org.lwjgl.system.libffi.FFICIF;
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
/*     */ public abstract class Callback
/*     */   implements Pointer, NativeResource
/*     */ {
/*     */   private long address;
/*     */   
/*     */   protected Callback(Descriptor descriptor) {
/*  32 */     this.address = Upcalls.upcallCreate(descriptor, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Callback(long address) {
/*  41 */     if (Checks.CHECKS) {
/*  42 */       Checks.check(address);
/*     */     }
/*  44 */     this.address = address;
/*     */   }
/*     */ 
/*     */   
/*     */   public long address() {
/*  49 */     return this.address;
/*     */   }
/*     */ 
/*     */   
/*     */   public void free() {
/*  54 */     free(address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends CallbackI> T get(long functionPointer) {
/*  66 */     return Upcalls.upcallGet(functionPointer);
/*     */   }
/*     */ 
/*     */   
/*     */   public static <T extends CallbackI> T getSafe(long functionPointer) {
/*  71 */     return (functionPointer == 0L) ? null : get(functionPointer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void free(long functionPointer) {
/*  80 */     Upcalls.upcallFree(functionPointer);
/*     */   }
/*     */   
/*     */   public boolean equals(Object o) {
/*  84 */     if (this == o) {
/*  85 */       return true;
/*     */     }
/*  87 */     if (!(o instanceof Callback)) {
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     Callback that = (Callback)o;
/*     */     
/*  93 */     return (this.address == that.address());
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     return (int)(this.address ^ this.address >>> 32L);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 102 */     return String.format("%s pointer [0x%X]", new Object[] { getClass().getSimpleName(), Long.valueOf(this.address) });
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class Descriptor
/*     */   {
/*     */     final MethodHandles.Lookup lookup;
/*     */     
/*     */     final FFICIF cif;
/*     */     
/*     */     public Descriptor(MethodHandles.Lookup lookup, FFICIF cif) {
/* 113 */       this.lookup = lookup;
/* 114 */       this.cif = cif;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Callback.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
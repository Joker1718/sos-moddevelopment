/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.jni.JNINativeInterface;
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
/*     */ public final class ThreadLocalUtil
/*     */ {
/*  89 */   private static final long JNI_NATIVE_INTERFACE = MemoryUtil.memGetAddress(getThreadJNIEnv());
/*     */ 
/*     */   
/*  92 */   private static final int CAPABILITIES_OFFSET = 3 * Pointer.POINTER_SIZE;
/*     */ 
/*     */   
/*  95 */   private static final long RESERVED_NULL = MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE + CAPABILITIES_OFFSET);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final int JNI_NATIVE_INTERFACE_FUNCTION_COUNT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   private static final long FUNCTION_MISSING_ABORT = getFunctionMissingAbort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 114 */   private static long FUNCTION_MISSING_ABORT_TABLE = 0L;
/*     */   
/*     */   static {
/* 117 */     int JNI_VERSION = JNINativeInterface.GetVersion();
/*     */ 
/*     */     
/* 120 */     switch (JNI_VERSION) {
/*     */       case 65537:
/* 122 */         reservedCount = 12;
/*     */         break;
/*     */       default:
/* 125 */         reservedCount = 4;
/*     */         break;
/*     */     } 
/*     */     
/* 129 */     switch (JNI_VERSION) {
/*     */       case 65537:
/* 131 */         jniCallCount = 208;
/*     */         break;
/*     */       case 65538:
/* 134 */         jniCallCount = 225;
/*     */         break;
/*     */       case 65540:
/* 137 */         jniCallCount = 228;
/*     */         break;
/*     */       case 65542:
/*     */       case 65544:
/* 141 */         jniCallCount = 229;
/*     */         break;
/*     */       case 589824:
/*     */       case 655360:
/* 145 */         jniCallCount = 230;
/*     */         break;
/*     */       case 1245184:
/*     */       case 1310720:
/* 149 */         jniCallCount = 231;
/*     */         break;
/*     */       case 1376256:
/* 152 */         jniCallCount = 232;
/*     */         break;
/*     */       case 1572864:
/* 155 */         jniCallCount = 233;
/*     */         break;
/*     */       default:
/* 158 */         jniCallCount = 233;
/* 159 */         APIUtil.DEBUG_STREAM
/* 160 */           .println("[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash. Please inform LWJGL developers."); break;
/*     */     } 
/* 162 */     JNI_NATIVE_INTERFACE_FUNCTION_COUNT = reservedCount + ((Integer)Configuration.JNI_NATIVE_INTERFACE_FUNCTION_COUNT.get(Integer.valueOf(jniCallCount))).intValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     int reservedCount, jniCallCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(long capabilities) {
/* 176 */     long env_pp = getThreadJNIEnv();
/* 177 */     long env_p = MemoryUtil.memGetAddress(env_pp);
/*     */     
/* 179 */     if (capabilities == 0L) {
/* 180 */       if (env_p != JNI_NATIVE_INTERFACE) {
/* 181 */         MemoryUtil.memPutAddress(env_p + CAPABILITIES_OFFSET, FUNCTION_MISSING_ABORT_TABLE);
/*     */       }
/*     */     } else {
/* 184 */       if (env_p == JNI_NATIVE_INTERFACE) {
/* 185 */         setupEnvData(JNI_NATIVE_INTERFACE_FUNCTION_COUNT);
/* 186 */         env_p = MemoryUtil.memGetAddress(env_pp);
/*     */       } 
/* 188 */       MemoryUtil.memPutAddress(env_p + CAPABILITIES_OFFSET, capabilities);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setFunctionMissingAddresses(int functionCount) {
/* 194 */     long ptr = JNI_NATIVE_INTERFACE + CAPABILITIES_OFFSET;
/*     */     
/* 196 */     long currentTable = MemoryUtil.memGetAddress(ptr);
/* 197 */     if (functionCount == 0) {
/* 198 */       if (currentTable == FUNCTION_MISSING_ABORT_TABLE && FUNCTION_MISSING_ABORT_TABLE != 0L) {
/* 199 */         FUNCTION_MISSING_ABORT_TABLE = 0L;
/* 200 */         MemoryUtil.getAllocator().free(currentTable);
/* 201 */         MemoryUtil.memPutAddress(ptr, RESERVED_NULL);
/*     */       } 
/*     */     } else {
/* 204 */       if (currentTable != RESERVED_NULL) {
/* 205 */         throw new IllegalStateException("setFunctionMissingAddresses has been called already");
/*     */       }
/* 207 */       if (currentTable != 0L) {
/*     */         
/* 209 */         if (MemoryUtil.memGetAddress(JNI_NATIVE_INTERFACE) == RESERVED_NULL) {
/*     */           return;
/*     */         }
/*     */         
/* 213 */         System.err.println("[LWJGL] [ThreadLocalUtil] Unsupported JVM detected, this may result in a crash. Please inform LWJGL developers.");
/*     */       } 
/*     */ 
/*     */       
/* 217 */       FUNCTION_MISSING_ABORT_TABLE = MemoryUtil.getAllocator().malloc(Integer.toUnsignedLong(functionCount) * Pointer.POINTER_SIZE);
/* 218 */       for (int i = 0; i < functionCount; i++) {
/* 219 */         MemoryUtil.memPutAddress(FUNCTION_MISSING_ABORT_TABLE + Integer.toUnsignedLong(i) * Pointer.POINTER_SIZE, FUNCTION_MISSING_ABORT);
/*     */       }
/*     */       
/* 222 */       MemoryUtil.memPutAddress(ptr, FUNCTION_MISSING_ABORT_TABLE);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static PointerBuffer setupAddressBuffer(PointerBuffer addresses) {
/* 227 */     for (int i = addresses.position(); i < addresses.limit(); i++) {
/* 228 */       if (addresses.get(i) == 0L) {
/* 229 */         addresses.put(i, FUNCTION_MISSING_ABORT);
/*     */       }
/*     */     } 
/* 232 */     return addresses;
/*     */   }
/*     */   
/*     */   public static boolean areCapabilitiesDifferent(PointerBuffer ref, PointerBuffer caps) {
/* 236 */     for (int i = 0; i < ref.remaining(); i++) {
/* 237 */       if (ref.get(i) != caps.get(i) && caps.get(i) != 0L) {
/* 238 */         return true;
/*     */       }
/*     */     } 
/* 241 */     return false;
/*     */   }
/*     */   
/*     */   private static native long getThreadJNIEnv();
/*     */   
/*     */   private static native long getFunctionMissingAbort();
/*     */   
/*     */   private static native long setupEnvData(int paramInt);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\ThreadLocalUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
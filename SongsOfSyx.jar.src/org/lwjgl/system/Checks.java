/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import org.lwjgl.PointerBuffer;
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
/*     */ public final class Checks
/*     */ {
/*  37 */   public static final boolean CHECKS = !((Boolean)Configuration.DISABLE_CHECKS.get(Boolean.valueOf(false))).booleanValue();
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
/*  48 */   public static final boolean DEBUG = ((Boolean)Configuration.DEBUG.get(Boolean.valueOf(false))).booleanValue();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final boolean DEBUG_FUNCTIONS = ((Boolean)Configuration.DEBUG_FUNCTIONS.get(Boolean.valueOf(false))).booleanValue();
/*     */   
/*     */   static {
/*  60 */     if (DEBUG_FUNCTIONS && !DEBUG) {
/*  61 */       APIUtil.DEBUG_STREAM.println("[LWJGL] The DEBUG_FUNCTIONS option requires DEBUG to produce output.");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int lengthSafe(short[] array) {
/*  68 */     return (array == null) ? 0 : array.length;
/*  69 */   } public static int lengthSafe(int[] array) { return (array == null) ? 0 : array.length; }
/*  70 */   public static int lengthSafe(long[] array) { return (array == null) ? 0 : array.length; }
/*  71 */   public static int lengthSafe(float[] array) { return (array == null) ? 0 : array.length; }
/*  72 */   public static int lengthSafe(double[] array) { return (array == null) ? 0 : array.length; }
/*  73 */   public static int remainingSafe(Buffer buffer) { return (buffer == null) ? 0 : buffer.remaining(); } public static int remainingSafe(CustomBuffer<?> buffer) {
/*  74 */     return (buffer == null) ? 0 : buffer.remaining();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkFunctions(long... functions) {
/*  84 */     for (long pointer : functions) {
/*  85 */       if (pointer == 0L) {
/*  86 */         return false;
/*     */       }
/*     */     } 
/*  89 */     return true;
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
/*     */ 
/*     */   
/*     */   public static boolean checkFunctions(FunctionProvider provider, PointerBuffer caps, int[] indices, String... functions) {
/* 103 */     boolean available = true;
/* 104 */     for (int i = 0; i < indices.length; i++) {
/* 105 */       int index = indices[i];
/* 106 */       if (index >= 0 && caps.get(index) == 0L) {
/*     */ 
/*     */         
/* 109 */         long address = provider.getFunctionAddress(functions[i]);
/* 110 */         if (address == 0L)
/* 111 */         { available = false; }
/*     */         else
/*     */         
/* 114 */         { caps.put(index, address); } 
/*     */       } 
/* 116 */     }  return available;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean checkFunctions(FunctionProviderLocal provider, long handle, PointerBuffer caps, int[] indices, String... functions) {
/* 131 */     boolean available = true;
/* 132 */     for (int i = 0; i < indices.length; i++) {
/* 133 */       int index = indices[i];
/* 134 */       if (index >= 0 && caps.get(index) == 0L) {
/*     */ 
/*     */         
/* 137 */         long address = provider.getFunctionAddress(handle, functions[i]);
/* 138 */         if (address != 0L)
/* 139 */         { caps.put(index, address); }
/*     */         else
/*     */         
/* 142 */         { available = false; } 
/*     */       } 
/* 144 */     }  return available;
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
/*     */ 
/*     */   
/*     */   public static boolean checkFunctions(FunctionProvider provider, long[] caps, int[] indices, String... functions) {
/* 158 */     boolean available = true;
/* 159 */     for (int i = 0; i < indices.length; i++) {
/* 160 */       int index = indices[i];
/* 161 */       if (index >= 0 && caps[index] == 0L) {
/*     */ 
/*     */         
/* 164 */         long address = provider.getFunctionAddress(functions[i]);
/* 165 */         if (address == 0L)
/* 166 */         { available = false; }
/*     */         else
/*     */         
/* 169 */         { caps[index] = address; } 
/*     */       } 
/* 171 */     }  return available;
/*     */   }
/*     */   
/*     */   public static boolean reportMissing(String api, String extension) {
/* 175 */     APIUtil.apiLog("[" + api + "] " + extension + " was reported as available but an entry point is missing.");
/* 176 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long check(long pointer) {
/* 187 */     if (pointer == 0L) {
/* 188 */       throw new NullPointerException();
/*     */     }
/*     */     
/* 191 */     return pointer;
/*     */   }
/*     */   
/*     */   private static void assertNT(boolean found) {
/* 195 */     if (!found) {
/* 196 */       throw new IllegalArgumentException("Missing termination");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(int[] buf) {
/* 202 */     checkBuffer(buf.length, 1);
/* 203 */     assertNT((buf[buf.length - 1] == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(int[] buf, int terminator) {
/* 208 */     checkBuffer(buf.length, 1);
/* 209 */     assertNT((buf[buf.length - 1] == terminator));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(long[] buf) {
/* 214 */     checkBuffer(buf.length, 1);
/* 215 */     assertNT((buf[buf.length - 1] == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(float[] buf) {
/* 220 */     checkBuffer(buf.length, 1);
/* 221 */     assertNT((buf[buf.length - 1] == 0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT1(ByteBuffer buf) {
/* 226 */     checkBuffer(buf.remaining(), 1);
/* 227 */     assertNT((buf.get(buf.limit() - 1) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT2(ByteBuffer buf) {
/* 232 */     checkBuffer(buf.remaining(), 2);
/* 233 */     assertNT((buf.get(buf.limit() - 2) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(IntBuffer buf) {
/* 238 */     checkBuffer(buf.remaining(), 1);
/* 239 */     assertNT((buf.get(buf.limit() - 1) == 0));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(IntBuffer buf, int terminator) {
/* 244 */     checkBuffer(buf.remaining(), 1);
/* 245 */     assertNT((buf.get(buf.limit() - 1) == terminator));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(LongBuffer buf) {
/* 250 */     checkBuffer(buf.remaining(), 1);
/* 251 */     assertNT((buf.get(buf.limit() - 1) == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(FloatBuffer buf) {
/* 256 */     checkBuffer(buf.remaining(), 1);
/* 257 */     assertNT((buf.get(buf.limit() - 1) == 0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(PointerBuffer buf) {
/* 262 */     checkBuffer(buf.remaining(), 1);
/* 263 */     assertNT((buf.get(buf.limit() - 1) == 0L));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void checkNT(PointerBuffer buf, long terminator) {
/* 268 */     checkBuffer(buf.remaining(), 1);
/* 269 */     assertNT((buf.get(buf.limit() - 1) == terminator));
/*     */   }
/*     */   
/*     */   public static void checkNTSafe(int[] buf) {
/* 273 */     if (buf != null) {
/* 274 */       checkBuffer(buf.length, 1);
/* 275 */       assertNT((buf[buf.length - 1] == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(int[] buf, int terminator) {
/* 279 */     if (buf != null) {
/* 280 */       checkBuffer(buf.length, 1);
/* 281 */       assertNT((buf[buf.length - 1] == terminator));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(long[] buf) {
/* 285 */     if (buf != null) {
/* 286 */       checkBuffer(buf.length, 1);
/* 287 */       assertNT((buf[buf.length - 1] == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(float[] buf) {
/* 291 */     if (buf != null) {
/* 292 */       checkBuffer(buf.length, 1);
/* 293 */       assertNT((buf[buf.length - 1] == 0.0F));
/*     */     } 
/*     */   }
/*     */   public static void checkNT1Safe(ByteBuffer buf) {
/* 297 */     if (buf != null) {
/* 298 */       checkBuffer(buf.remaining(), 1);
/* 299 */       assertNT((buf.get(buf.limit() - 1) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNT2Safe(ByteBuffer buf) {
/* 303 */     if (buf != null) {
/* 304 */       checkBuffer(buf.remaining(), 2);
/* 305 */       assertNT((buf.get(buf.limit() - 2) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(IntBuffer buf) {
/* 309 */     if (buf != null) {
/* 310 */       checkBuffer(buf.remaining(), 1);
/* 311 */       assertNT((buf.get(buf.limit() - 1) == 0));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(IntBuffer buf, int terminator) {
/* 315 */     if (buf != null) {
/* 316 */       checkBuffer(buf.remaining(), 1);
/* 317 */       assertNT((buf.get(buf.limit() - 1) == terminator));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(LongBuffer buf) {
/* 321 */     if (buf != null) {
/* 322 */       checkBuffer(buf.remaining(), 1);
/* 323 */       assertNT((buf.get(buf.limit() - 1) == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(FloatBuffer buf) {
/* 327 */     if (buf != null) {
/* 328 */       checkBuffer(buf.remaining(), 1);
/* 329 */       assertNT((buf.get(buf.limit() - 1) == 0.0F));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(PointerBuffer buf) {
/* 333 */     if (buf != null) {
/* 334 */       checkBuffer(buf.remaining(), 1);
/* 335 */       assertNT((buf.get(buf.limit() - 1) == 0L));
/*     */     } 
/*     */   }
/*     */   public static void checkNTSafe(PointerBuffer buf, long terminator) {
/* 339 */     if (buf != null) {
/* 340 */       checkBuffer(buf.remaining(), 1);
/* 341 */       assertNT((buf.get(buf.limit() - 1) == terminator));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void checkBuffer(int bufferSize, int minimumSize) {
/* 346 */     if (bufferSize < minimumSize) {
/* 347 */       throwIAE(bufferSize, minimumSize);
/*     */     }
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
/*     */   public static void check(byte[] buf, int size) {
/* 360 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(short[] buf, int size) {
/* 372 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(int[] buf, int size) {
/* 384 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(long[] buf, int size) {
/* 396 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(float[] buf, int size) {
/* 408 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(double[] buf, int size) {
/* 420 */     checkBuffer(buf.length, size);
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
/*     */   public static void check(CharSequence text, int size) {
/* 432 */     checkBuffer(text.length(), size);
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
/*     */   public static void check(Buffer buf, int size) {
/* 444 */     checkBuffer(buf.remaining(), size);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void check(Buffer buf, long size) {
/* 449 */     checkBuffer(buf.remaining(), (int)size);
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
/*     */   public static void check(CustomBuffer<?> buf, int size) {
/* 461 */     checkBuffer(buf.remaining(), size);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void check(CustomBuffer<?> buf, long size) {
/* 466 */     checkBuffer(buf.remaining(), (int)size);
/*     */   }
/*     */   
/*     */   public static void checkSafe(short[] buf, int size) {
/* 470 */     if (buf != null)
/* 471 */       checkBuffer(buf.length, size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(int[] buf, int size) {
/* 475 */     if (buf != null)
/* 476 */       checkBuffer(buf.length, size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(long[] buf, int size) {
/* 480 */     if (buf != null)
/* 481 */       checkBuffer(buf.length, size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(float[] buf, int size) {
/* 485 */     if (buf != null)
/* 486 */       checkBuffer(buf.length, size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(double[] buf, int size) {
/* 490 */     if (buf != null)
/* 491 */       checkBuffer(buf.length, size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(Buffer buf, int size) {
/* 495 */     if (buf != null)
/* 496 */       checkBuffer(buf.remaining(), size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(Buffer buf, long size) {
/* 500 */     if (buf != null)
/* 501 */       checkBuffer(buf.remaining(), (int)size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(CustomBuffer<?> buf, int size) {
/* 505 */     if (buf != null)
/* 506 */       checkBuffer(buf.remaining(), size); 
/*     */   }
/*     */   
/*     */   public static void checkSafe(CustomBuffer<?> buf, long size) {
/* 510 */     if (buf != null) {
/* 511 */       checkBuffer(buf.remaining(), (int)size);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void check(Object[] array, int size) {
/* 516 */     checkBuffer(array.length, size);
/*     */   }
/*     */   
/*     */   private static void checkBufferGT(int bufferSize, int maximumSize) {
/* 520 */     if (maximumSize < bufferSize) {
/* 521 */       throwIAEGT(bufferSize, maximumSize);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void checkGT(Buffer buf, int size) {
/* 526 */     checkBufferGT(buf.remaining(), size);
/*     */   }
/*     */   
/*     */   public static void checkGT(CustomBuffer<?> buf, int size) {
/* 530 */     checkBufferGT(buf.remaining(), size);
/*     */   }
/*     */   
/*     */   public static long check(int index, int length) {
/* 534 */     if (CHECKS) {
/* 535 */       CheckIntrinsics.checkIndex(index, length);
/*     */     }
/*     */ 
/*     */     
/* 539 */     return Integer.toUnsignedLong(index);
/*     */   }
/*     */   
/*     */   public static void checkMemcpy(long address, int offset, int size, int length) {
/* 543 */     if (CHECKS) {
/* 544 */       if (address == 0L) {
/* 545 */         throw new NullPointerException();
/*     */       }
/* 547 */       CheckIntrinsics.checkFromIndexSize(offset, size, length);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void throwIAE(int bufferSize, int minimumSize) {
/* 554 */     throw new IllegalArgumentException("Number of remaining elements is " + bufferSize + ", must be at least " + minimumSize);
/*     */   }
/*     */   
/*     */   private static void throwIAEGT(int bufferSize, int maximumSize) {
/* 558 */     throw new IllegalArgumentException("Number of remaining buffer elements is " + bufferSize + ", must be at most " + maximumSize);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Checks.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package org.lwjgl.system.jni;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.nio.Buffer;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.DoubleBuffer;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.nio.LongBuffer;
/*     */ import java.nio.ShortBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
/*     */ 
/*     */ public class JNINativeInterface
/*     */ {
/*     */   static {
/*  23 */     Library.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int JNI_VERSION_1_1 = 65537;
/*     */   
/*     */   public static final int JNI_VERSION_1_2 = 65538;
/*     */   
/*     */   public static final int JNI_VERSION_1_4 = 65540;
/*     */   
/*     */   public static final int JNI_VERSION_1_6 = 65542;
/*     */   
/*     */   public static final int JNI_VERSION_1_8 = 65544;
/*     */   
/*     */   public static final int JNI_VERSION_9 = 589824;
/*     */   
/*     */   public static final int JNI_VERSION_10 = 655360;
/*     */   
/*     */   public static final int JNI_VERSION_19 = 1245184;
/*     */   public static final int JNI_VERSION_20 = 1310720;
/*     */   public static final int JNI_VERSION_21 = 1376256;
/*     */   public static final int JNI_VERSION_24 = 1572864;
/*     */   public static final int JNIInvalidRefType = 0;
/*     */   public static final int JNILocalRefType = 1;
/*     */   public static final int JNIGlobalRefType = 2;
/*     */   public static final int JNIWeakGlobalRefType = 3;
/*     */   public static final int JNI_FALSE = 0;
/*     */   public static final int JNI_TRUE = 1;
/*     */   public static final int JNI_OK = 0;
/*     */   public static final int JNI_ERR = -1;
/*     */   public static final int JNI_EDETACHED = -2;
/*     */   public static final int JNI_EVERSION = -3;
/*     */   public static final int JNI_ENOMEM = -4;
/*     */   public static final int JNI_EEXIST = -5;
/*     */   public static final int JNI_EINVAL = -6;
/*     */   public static final int JNI_COMMIT = 1;
/*     */   public static final int JNI_ABORT = 2;
/*     */   
/*     */   protected JNINativeInterface() {
/*  62 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("jobject")
/*     */   public static Method ToReflectedMethod(@NativeType("jclass") Class<?> cls, @NativeType("jmethodID") long methodID, @NativeType("jboolean") boolean isStatic) {
/*  91 */     if (Checks.CHECKS) {
/*  92 */       Checks.check(methodID);
/*     */     }
/*  94 */     return nToReflectedMethod(cls, methodID, isStatic);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jobject")
/*     */   public static Field ToReflectedField(@NativeType("jclass") Class<?> cls, @NativeType("jfieldID") long fieldID, @NativeType("jboolean") boolean isStatic) {
/* 105 */     if (Checks.CHECKS) {
/* 106 */       Checks.check(fieldID);
/*     */     }
/* 108 */     return nToReflectedField(cls, fieldID, isStatic);
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
/*     */   
/*     */   public static void DeleteGlobalRef(@NativeType("void *") long globalRef) {
/* 124 */     if (Checks.CHECKS) {
/* 125 */       Checks.check(globalRef);
/*     */     }
/* 127 */     nDeleteGlobalRef(globalRef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jboolean *")
/*     */   public static ByteBuffer GetBooleanArrayElements(@NativeType("jbooleanArray") byte[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 138 */     if (Checks.CHECKS) {
/* 139 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 141 */     long __result = nGetBooleanArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 142 */     return MemoryUtil.memByteBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseBooleanArrayElements(@NativeType("jbooleanArray") byte[] array, @NativeType("jboolean *") ByteBuffer elems, @NativeType("jint") int mode) {
/* 152 */     nReleaseBooleanArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jbyte *")
/*     */   public static ByteBuffer GetByteArrayElements(@NativeType("jbyteArray") byte[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 163 */     if (Checks.CHECKS) {
/* 164 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 166 */     long __result = nGetByteArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 167 */     return MemoryUtil.memByteBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseByteArrayElements(@NativeType("jbyteArray") byte[] array, @NativeType("jbyte *") ByteBuffer elems, @NativeType("jint") int mode) {
/* 177 */     nReleaseByteArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jchar *")
/*     */   public static ShortBuffer GetCharArrayElements(@NativeType("jcharArray") char[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 188 */     if (Checks.CHECKS) {
/* 189 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 191 */     long __result = nGetCharArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 192 */     return MemoryUtil.memShortBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseCharArrayElements(@NativeType("jcharArray") char[] array, @NativeType("jchar *") ShortBuffer elems, @NativeType("jint") int mode) {
/* 202 */     nReleaseCharArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jshort *")
/*     */   public static ShortBuffer GetShortArrayElements(@NativeType("jshortArray") short[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 213 */     if (Checks.CHECKS) {
/* 214 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 216 */     long __result = nGetShortArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 217 */     return MemoryUtil.memShortBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseShortArrayElements(@NativeType("jshortArray") short[] array, @NativeType("jshort *") ShortBuffer elems, @NativeType("jint") int mode) {
/* 227 */     nReleaseShortArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jint *")
/*     */   public static IntBuffer GetIntArrayElements(@NativeType("jintArray") int[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 238 */     if (Checks.CHECKS) {
/* 239 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 241 */     long __result = nGetIntArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 242 */     return MemoryUtil.memIntBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseIntArrayElements(@NativeType("jintArray") int[] array, @NativeType("jint *") IntBuffer elems, @NativeType("jint") int mode) {
/* 252 */     nReleaseIntArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jlong *")
/*     */   public static LongBuffer GetLongArrayElements(@NativeType("jlongArray") long[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 263 */     if (Checks.CHECKS) {
/* 264 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 266 */     long __result = nGetLongArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 267 */     return MemoryUtil.memLongBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseLongArrayElements(@NativeType("jlongArray") long[] array, @NativeType("jlong *") LongBuffer elems, @NativeType("jint") int mode) {
/* 277 */     nReleaseLongArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jfloat *")
/*     */   public static FloatBuffer GetFloatArrayElements(@NativeType("jfloatArray") float[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 288 */     if (Checks.CHECKS) {
/* 289 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 291 */     long __result = nGetFloatArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 292 */     return MemoryUtil.memFloatBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseFloatArrayElements(@NativeType("jfloatArray") float[] array, @NativeType("jfloat *") FloatBuffer elems, @NativeType("jint") int mode) {
/* 302 */     nReleaseFloatArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jdouble *")
/*     */   public static DoubleBuffer GetDoubleArrayElements(@NativeType("jdoubleArray") double[] array, @NativeType("jboolean *") ByteBuffer isCopy) {
/* 313 */     if (Checks.CHECKS) {
/* 314 */       Checks.checkSafe(isCopy, 1);
/*     */     }
/* 316 */     long __result = nGetDoubleArrayElements(array, MemoryUtil.memAddressSafe(isCopy));
/* 317 */     return MemoryUtil.memDoubleBufferSafe(__result, array.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ReleaseDoubleArrayElements(@NativeType("jdoubleArray") double[] array, @NativeType("jdouble *") DoubleBuffer elems, @NativeType("jint") int mode) {
/* 327 */     nReleaseDoubleArrayElements(array, MemoryUtil.memAddress(elems), mode);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetBooleanArrayRegion(@NativeType("jbooleanArray") byte[] array, @NativeType("jsize") int start, @NativeType("jboolean *") ByteBuffer buf) {
/* 337 */     nGetBooleanArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetBooleanArrayRegion(@NativeType("jbooleanArray") byte[] array, @NativeType("jsize") int start, @NativeType("jboolean const *") ByteBuffer buf) {
/* 347 */     nSetBooleanArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetByteArrayRegion(@NativeType("jbyteArray") byte[] array, @NativeType("jsize") int start, @NativeType("jbyte *") ByteBuffer buf) {
/* 357 */     nGetByteArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetByteArrayRegion(@NativeType("jbyteArray") byte[] array, @NativeType("jsize") int start, @NativeType("jbyte const *") ByteBuffer buf) {
/* 367 */     nSetByteArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetCharArrayRegion(@NativeType("jcharArray") char[] array, @NativeType("jsize") int start, @NativeType("jchar *") ShortBuffer buf) {
/* 377 */     nGetCharArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetCharArrayRegion(@NativeType("jcharArray") char[] array, @NativeType("jsize") int start, @NativeType("jchar const *") ShortBuffer buf) {
/* 387 */     nSetCharArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetShortArrayRegion(@NativeType("jshortArray") short[] array, @NativeType("jsize") int start, @NativeType("jshort *") ShortBuffer buf) {
/* 397 */     nGetShortArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetShortArrayRegion(@NativeType("jshortArray") short[] array, @NativeType("jsize") int start, @NativeType("jshort const *") ShortBuffer buf) {
/* 407 */     nSetShortArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetIntArrayRegion(@NativeType("jintArray") int[] array, @NativeType("jsize") int start, @NativeType("jint *") IntBuffer buf) {
/* 417 */     nGetIntArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetIntArrayRegion(@NativeType("jintArray") int[] array, @NativeType("jsize") int start, @NativeType("jint const *") IntBuffer buf) {
/* 427 */     nSetIntArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetLongArrayRegion(@NativeType("jlongArray") long[] array, @NativeType("jsize") int start, @NativeType("jlong *") LongBuffer buf) {
/* 437 */     nGetLongArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetLongArrayRegion(@NativeType("jlongArray") long[] array, @NativeType("jsize") int start, @NativeType("jlong const *") LongBuffer buf) {
/* 447 */     nSetLongArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetFloatArrayRegion(@NativeType("jfloatArray") float[] array, @NativeType("jsize") int start, @NativeType("jfloat *") FloatBuffer buf) {
/* 457 */     nGetFloatArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetFloatArrayRegion(@NativeType("jfloatArray") float[] array, @NativeType("jsize") int start, @NativeType("jfloat const *") FloatBuffer buf) {
/* 467 */     nSetFloatArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetDoubleArrayRegion(@NativeType("jdoubleArray") double[] array, @NativeType("jsize") int start, @NativeType("jdouble *") DoubleBuffer buf) {
/* 477 */     nGetDoubleArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void SetDoubleArrayRegion(@NativeType("jdoubleArray") double[] array, @NativeType("jsize") int start, @NativeType("jdouble const *") DoubleBuffer buf) {
/* 487 */     nSetDoubleArrayRegion(array, start, buf.remaining(), MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jint")
/*     */   public static int RegisterNatives(@NativeType("jclass") Class<?> targetClass, @NativeType("JNINativeMethod const *") JNINativeMethod.Buffer methods) {
/* 498 */     if (Checks.CHECKS) {
/* 499 */       Struct.validate(methods.address(), methods.remaining(), JNINativeMethod.SIZEOF, JNINativeMethod::validate);
/*     */     }
/* 501 */     return nRegisterNatives(targetClass, methods.address(), methods.remaining());
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
/*     */   
/*     */   @NativeType("jint")
/*     */   public static int GetJavaVM(@NativeType("JavaVM **") PointerBuffer vm) {
/* 518 */     if (Checks.CHECKS) {
/* 519 */       Checks.check((CustomBuffer)vm, 1);
/*     */     }
/* 521 */     return nGetJavaVM(MemoryUtil.memAddress((CustomBuffer)vm));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetStringRegion(@NativeType("jstring") String str, @NativeType("jsize") int start, @NativeType("jchar *") ByteBuffer buf) {
/* 531 */     nGetStringRegion(str, start, buf.remaining() >> 1, MemoryUtil.memAddress(buf));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void GetStringUTFRegion(@NativeType("jstring") String str, @NativeType("jsize") int start, @NativeType("jsize") int len, @NativeType("char *") ByteBuffer buf) {
/* 541 */     if (Checks.CHECKS) {
/* 542 */       Checks.check(buf, len);
/*     */     }
/* 544 */     nGetStringUTFRegion(str, start, len, MemoryUtil.memAddress(buf));
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
/*     */   
/*     */   public static void DeleteWeakGlobalRef(@NativeType("void *") long weakGlobalRef) {
/* 560 */     if (Checks.CHECKS) {
/* 561 */       Checks.check(weakGlobalRef);
/*     */     }
/* 563 */     nDeleteWeakGlobalRef(weakGlobalRef);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("jobject")
/*     */   public static ByteBuffer NewDirectByteBuffer(@NativeType("void *") long address, @NativeType("jlong") long capacity) {
/* 574 */     if (Checks.CHECKS) {
/* 575 */       Checks.check(address);
/*     */     }
/* 577 */     return nNewDirectByteBuffer(address, capacity);
/*     */   }
/*     */   
/*     */   @NativeType("jint")
/*     */   public static native int GetVersion();
/*     */   
/*     */   @NativeType("jmethodID")
/*     */   public static native long FromReflectedMethod(@NativeType("jobject") Method paramMethod);
/*     */   
/*     */   @NativeType("jfieldID")
/*     */   public static native long FromReflectedField(@NativeType("jobject") Field paramField);
/*     */   
/*     */   public static native Method nToReflectedMethod(Class<?> paramClass, long paramLong, boolean paramBoolean);
/*     */   
/*     */   public static native Field nToReflectedField(Class<?> paramClass, long paramLong, boolean paramBoolean);
/*     */   
/*     */   @NativeType("void *")
/*     */   public static native long NewGlobalRef(@NativeType("jobject") Object paramObject);
/*     */   
/*     */   public static native void nDeleteGlobalRef(long paramLong);
/*     */   
/*     */   public static native long nGetBooleanArrayElements(byte[] paramArrayOfbyte, long paramLong);
/*     */   
/*     */   public static native void nReleaseBooleanArrayElements(byte[] paramArrayOfbyte, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetByteArrayElements(byte[] paramArrayOfbyte, long paramLong);
/*     */   
/*     */   public static native void nReleaseByteArrayElements(byte[] paramArrayOfbyte, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetCharArrayElements(char[] paramArrayOfchar, long paramLong);
/*     */   
/*     */   public static native void nReleaseCharArrayElements(char[] paramArrayOfchar, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetShortArrayElements(short[] paramArrayOfshort, long paramLong);
/*     */   
/*     */   public static native void nReleaseShortArrayElements(short[] paramArrayOfshort, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetIntArrayElements(int[] paramArrayOfint, long paramLong);
/*     */   
/*     */   public static native void nReleaseIntArrayElements(int[] paramArrayOfint, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetLongArrayElements(long[] paramArrayOflong, long paramLong);
/*     */   
/*     */   public static native void nReleaseLongArrayElements(long[] paramArrayOflong, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetFloatArrayElements(float[] paramArrayOffloat, long paramLong);
/*     */   
/*     */   public static native void nReleaseFloatArrayElements(float[] paramArrayOffloat, long paramLong, int paramInt);
/*     */   
/*     */   public static native long nGetDoubleArrayElements(double[] paramArrayOfdouble, long paramLong);
/*     */   
/*     */   public static native void nReleaseDoubleArrayElements(double[] paramArrayOfdouble, long paramLong, int paramInt);
/*     */   
/*     */   public static native void nGetBooleanArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetBooleanArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetByteArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetByteArrayRegion(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetCharArrayRegion(char[] paramArrayOfchar, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetCharArrayRegion(char[] paramArrayOfchar, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetShortArrayRegion(short[] paramArrayOfshort, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetShortArrayRegion(short[] paramArrayOfshort, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetIntArrayRegion(int[] paramArrayOfint, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetIntArrayRegion(int[] paramArrayOfint, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetLongArrayRegion(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetLongArrayRegion(long[] paramArrayOflong, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetFloatArrayRegion(float[] paramArrayOffloat, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetFloatArrayRegion(float[] paramArrayOffloat, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetDoubleArrayRegion(double[] paramArrayOfdouble, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nSetDoubleArrayRegion(double[] paramArrayOfdouble, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native int nRegisterNatives(Class<?> paramClass, long paramLong, int paramInt);
/*     */   
/*     */   @NativeType("jint")
/*     */   public static native int UnregisterNatives(@NativeType("jclass") Class<?> paramClass);
/*     */   
/*     */   public static native int nGetJavaVM(long paramLong);
/*     */   
/*     */   public static native void nGetStringRegion(String paramString, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   public static native void nGetStringUTFRegion(String paramString, int paramInt1, int paramInt2, long paramLong);
/*     */   
/*     */   @NativeType("void *")
/*     */   public static native long NewWeakGlobalRef(@NativeType("jobject") Object paramObject);
/*     */   
/*     */   public static native void nDeleteWeakGlobalRef(long paramLong);
/*     */   
/*     */   public static native ByteBuffer nNewDirectByteBuffer(long paramLong1, long paramLong2);
/*     */   
/*     */   @NativeType("void *")
/*     */   public static native long GetDirectBufferAddress(@NativeType("jobject") Buffer paramBuffer);
/*     */   
/*     */   @NativeType("jobjectRefType")
/*     */   public static native int GetObjectRefType(@NativeType("jobject") Object paramObject);
/*     */   
/*     */   public static native void noop();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\jni\JNINativeInterface.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
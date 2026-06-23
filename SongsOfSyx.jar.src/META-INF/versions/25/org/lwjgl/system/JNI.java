/*      */ package META-INF.versions.25.org.lwjgl.system;
/*      */ 
/*      */ import java.lang.foreign.MemorySegment;
/*      */ import java.lang.invoke.MethodHandles;
/*      */ import org.lwjgl.system.ffm.FFM;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class JNI
/*      */ {
/* 1292 */   private static final JNIBindings jni = (JNIBindings)FFM.ffmGenerate(JNIBindings.class, 
/*      */       
/* 1294 */       FFM.ffmConfigBuilder(MethodHandles.lookup())
/* 1295 */       .withChecks(false)
/*      */ 
/*      */       
/* 1298 */       .build());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte invokePB(long param0, long __functionAddress) {
/* 1305 */     return jni.invokePB(MemorySegment.ofAddress(__functionAddress), param0);
/* 1306 */   } public static short invokeC(long __functionAddress) { return jni.invokeC(MemorySegment.ofAddress(__functionAddress)); }
/* 1307 */   public static short invokeC(int param0, long __functionAddress) { return jni.invokeC(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1308 */   public static short invokePC(long param0, long __functionAddress) { return jni.invokePC(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1309 */   public static short invokeCC(int param0, short param1, long __functionAddress) { return jni.invokeCC(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1310 */   public static short invokeCC(short param0, boolean param1, long __functionAddress) { return jni.invokeCC(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1311 */   public static short invokePC(long param0, int param1, long __functionAddress) { return jni.invokePC(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1312 */   public static short invokeJC(int param0, int param1, long param2, long __functionAddress) { return jni.invokeJC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1313 */   public static short invokeCUC(short param0, byte param1, long __functionAddress) { return jni.invokeCUC(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1314 */   public static short invokePCC(long param0, short param1, long __functionAddress) { return jni.invokePCC(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1315 */   public static short invokeCCC(short param0, short param1, boolean param2, long __functionAddress) { return jni.invokeCCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1316 */   public static short invokePCC(int param0, long param1, short param2, long __functionAddress) { return jni.invokePCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1317 */   public static short invokePCC(long param0, int param1, short param2, long __functionAddress) { return jni.invokePCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1318 */   public static short invokeUPC(byte param0, long param1, boolean param2, long __functionAddress) { return jni.invokeUPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1319 */   public static short invokePCC(long param0, int param1, int param2, short param3, long __functionAddress) { return jni.invokePCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1320 */   public static short invokeCJC(int param0, boolean param1, short param2, int param3, long param4, long __functionAddress) { return jni.invokeCJC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1321 */   public static short invokeCPCC(short param0, long param1, short param2, long __functionAddress) { return jni.invokeCPCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1322 */   public static short invokeCPPC(short param0, long param1, long param2, long __functionAddress) { return jni.invokeCPPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1323 */   public static short invokePPCC(long param0, long param1, short param2, long __functionAddress) { return jni.invokePPCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1324 */   public static short invokeCCJC(short param0, short param1, int param2, long param3, long __functionAddress) { return jni.invokeCCJC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1325 */   public static short invokePCCC(long param0, short param1, short param2, int param3, int param4, long __functionAddress) { return jni.invokePCCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1326 */   public static short invokeCCCCC(short param0, short param1, short param2, short param3, long __functionAddress) { return jni.invokeCCCCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1327 */   public static short invokePJUPC(long param0, long param1, byte param2, long param3, long __functionAddress) { return jni.invokePJUPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1328 */   public static short invokeCCJPC(short param0, boolean param1, short param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokeCCJPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1329 */   public static short invokePCCCCC(long param0, short param1, short param2, short param3, short param4, long __functionAddress) { return jni.invokePCCCCC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1330 */   public static short invokeCCCJPC(short param0, short param1, short param2, boolean param3, int param4, long param5, long param6, long __functionAddress) { return jni.invokeCCCJPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1331 */   public static short invokeCCCJPC(short param0, short param1, boolean param2, short param3, int param4, long param5, long param6, long __functionAddress) { return jni.invokeCCCJPC(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1332 */   public static double invokeD(long __functionAddress) { return jni.invokeD(MemorySegment.ofAddress(__functionAddress)); }
/* 1333 */   public static double invokeD(int param0, long __functionAddress) { return jni.invokeD(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1334 */   public static double invokePD(long param0, long __functionAddress) { return jni.invokePD(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1335 */   public static double invokePD(long param0, int param1, long __functionAddress) { return jni.invokePD(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1336 */   public static double invokePD(long param0, int param1, int param2, long __functionAddress) { return jni.invokePD(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1337 */   public static double invokePPD(long param0, long param1, long __functionAddress) { return jni.invokePPD(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1338 */   public static float invokeF(long __functionAddress) { return jni.invokeF(MemorySegment.ofAddress(__functionAddress)); }
/* 1339 */   public static float invokeF(int param0, long __functionAddress) { return jni.invokeF(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1340 */   public static float invokePF(long param0, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1341 */   public static float invokePF(float param0, long param1, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1342 */   public static float invokePF(long param0, int param1, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1343 */   public static float invokePF(float param0, float param1, long param2, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1344 */   public static float invokePF(int param0, long param1, float param2, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1345 */   public static float invokePF(long param0, float param1, float param2, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1346 */   public static float invokePF(long param0, int param1, int param2, long __functionAddress) { return jni.invokePF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1347 */   public static float invokePPF(long param0, long param1, long __functionAddress) { return jni.invokePPF(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1348 */   public static float invokePPF(long param0, int param1, long param2, long __functionAddress) { return jni.invokePPF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1349 */   public static float invokePPF(long param0, float param1, long param2, int param3, long __functionAddress) { return jni.invokePPF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1350 */   public static int invokeI(long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress)); }
/* 1351 */   public static int invokeI(int param0, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1352 */   public static int invokeI(boolean param0, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1353 */   public static int invokeI(int param0, float param1, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1354 */   public static int invokeI(int param0, int param1, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1355 */   public static int invokeI(int param0, boolean param1, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1356 */   public static int invokeI(int param0, int param1, int param2, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1357 */   public static int invokeI(int param0, int param1, int param2, int param3, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1358 */   public static int invokeI(int param0, int param1, int param2, int param3, int param4, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1359 */   public static int invokeI(int param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { return jni.invokeI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1360 */   public static int invokeJI(long param0, long __functionAddress) { return jni.invokeJI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1361 */   public static int invokePI(long param0, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1362 */   public static int invokeCI(int param0, short param1, long __functionAddress) { return jni.invokeCI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1363 */   public static int invokePI(int param0, long param1, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1364 */   public static int invokePI(long param0, int param1, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1365 */   public static int invokePI(long param0, boolean param1, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1366 */   public static int invokeCI(int param0, short param1, boolean param2, long __functionAddress) { return jni.invokeCI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1367 */   public static int invokePI(long param0, int param1, int param2, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1368 */   public static int invokePI(long param0, int param1, boolean param2, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1369 */   public static int invokePI(long param0, int param1, int param2, int param3, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1370 */   public static int invokePI(long param0, int param1, int param2, int param3, int param4, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1371 */   public static int invokePI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) { return jni.invokePI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1372 */   public static int invokeCPI(short param0, long param1, long __functionAddress) { return jni.invokeCPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1373 */   public static int invokePCI(long param0, short param1, long __functionAddress) { return jni.invokePCI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1374 */   public static int invokePJI(long param0, long param1, long __functionAddress) { return jni.invokePJI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1375 */   public static int invokePNI(long param0, long param1, long __functionAddress) { return jni.invokePNI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1376 */   public static int invokePPI(long param0, long param1, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1377 */   public static int invokePJI(long param0, long param1, int param2, long __functionAddress) { return jni.invokePJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1378 */   public static int invokePNI(long param0, int param1, long param2, long __functionAddress) { return jni.invokePNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1379 */   public static int invokePNI(long param0, long param1, int param2, long __functionAddress) { return jni.invokePNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1380 */   public static int invokePPI(int param0, long param1, long param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1381 */   public static int invokePPI(long param0, int param1, long param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1382 */   public static int invokePPI(long param0, long param1, float param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1383 */   public static int invokePPI(long param0, long param1, int param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1384 */   public static int invokePPI(long param0, long param1, boolean param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1385 */   public static int invokePPI(long param0, boolean param1, long param2, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1386 */   public static int invokePPI(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1387 */   public static int invokePPI(long param0, int param1, long param2, int param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1388 */   public static int invokePPI(long param0, int param1, long param2, boolean param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1389 */   public static int invokePPI(long param0, int param1, boolean param2, long param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1390 */   public static int invokePPI(long param0, long param1, int param2, int param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1391 */   public static int invokePPI(long param0, long param1, boolean param2, boolean param3, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1392 */   public static int invokePPI(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1393 */   public static int invokePPI(long param0, int param1, int param2, long param3, int param4, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1394 */   public static int invokePPI(long param0, int param1, long param2, int param3, int param4, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1395 */   public static int invokePPI(int param0, long param1, int param2, long param3, int param4, boolean param5, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1396 */   public static int invokePPI(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1397 */   public static int invokePPI(long param0, int param1, int param2, int param3, int param4, long param5, int param6, long __functionAddress) { return jni.invokePPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1398 */   public static int invokeCPUI(short param0, long param1, byte param2, long __functionAddress) { return jni.invokeCPUI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1399 */   public static int invokeJPPI(long param0, long param1, long param2, long __functionAddress) { return jni.invokeJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1400 */   public static int invokePCPI(long param0, short param1, long param2, long __functionAddress) { return jni.invokePCPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1401 */   public static int invokePNNI(long param0, long param1, long param2, long __functionAddress) { return jni.invokePNNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1402 */   public static int invokePNPI(long param0, long param1, long param2, long __functionAddress) { return jni.invokePNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1403 */   public static int invokePPCI(long param0, long param1, short param2, long __functionAddress) { return jni.invokePPCI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1404 */   public static int invokePPJI(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1405 */   public static int invokePPNI(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1406 */   public static int invokePPPI(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1407 */   public static int invokePNPI(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.invokePNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1408 */   public static int invokePNPI(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1409 */   public static int invokePPNI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.invokePPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1410 */   public static int invokePPPI(int param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1411 */   public static int invokePPPI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1412 */   public static int invokePPPI(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1413 */   public static int invokePPPI(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1414 */   public static int invokePNNI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) { return jni.invokePNNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1415 */   public static int invokePPPI(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1416 */   public static int invokePPPI(long param0, int param1, long param2, int param3, long param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1417 */   public static int invokePPPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1418 */   public static int invokePPPI(long param0, long param1, int param2, int param3, long param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1419 */   public static int invokePPPI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1420 */   public static int invokePPPI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1421 */   public static int invokePPPI(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1422 */   public static int invokePPPI(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1423 */   public static int invokePPPI(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1424 */   public static int invokePPPI(long param0, long param1, int param2, long param3, int param4, int param5, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1425 */   public static int invokePPPI(long param0, long param1, long param2, int param3, boolean param4, float param5, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1426 */   public static int invokePPPI(long param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1427 */   public static int invokePPPI(long param0, int param1, int param2, int param3, long param4, long param5, int param6, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1428 */   public static int invokePPPI(long param0, int param1, int param2, long param3, int param4, long param5, int param6, int param7, long __functionAddress) { return jni.invokePPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1429 */   public static int invokePNPPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePNPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1430 */   public static int invokePPNNI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPNNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1431 */   public static int invokePPNPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1432 */   public static int invokePPPNI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1433 */   public static int invokePPPPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1434 */   public static int invokePUUUI(long param0, byte param1, byte param2, byte param3, long __functionAddress) { return jni.invokePUUUI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1435 */   public static int invokePNNPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePNNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1436 */   public static int invokePPPNI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1437 */   public static int invokePPPPI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1438 */   public static int invokePPPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1439 */   public static int invokePPPPI(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1440 */   public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1441 */   public static int invokePPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1442 */   public static int invokePPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1443 */   public static int invokePPPPI(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1444 */   public static int invokePPPPI(long param0, long param1, int param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1445 */   public static int invokePPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1446 */   public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1447 */   public static int invokePPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1448 */   public static int invokePPPPI(long param0, int param1, int param2, long param3, long param4, long param5, int param6, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1449 */   public static int invokePPPPI(long param0, int param1, long param2, int param3, long param4, int param5, long param6, int param7, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1450 */   public static int invokePPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long param6, int param7, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1451 */   public static int invokePPPPI(long param0, long param1, long param2, long param3, int param4, int param5, int param6, int param7, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1452 */   public static int invokePPPPI(long param0, int param1, int param2, long param3, int param4, long param5, long param6, int param7, int param8, long __functionAddress) { return jni.invokePPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1453 */   public static int invokePNNPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePNNPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1454 */   public static int invokePPNNPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPNNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1455 */   public static int invokePPPNNI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPNNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1456 */   public static int invokePPPPNI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1457 */   public static int invokePPPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1458 */   public static int invokePPUUUI(long param0, long param1, byte param2, byte param3, byte param4, long __functionAddress) { return jni.invokePPUUUI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1459 */   public static int invokePUUUUI(long param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) { return jni.invokePUUUUI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1460 */   public static int invokePJPPNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePJPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1461 */   public static int invokePPNPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPNPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1462 */   public static int invokePPNPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPNPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1463 */   public static int invokePPPNJI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPNJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1464 */   public static int invokePPPNNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPNNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1465 */   public static int invokePPPNPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1466 */   public static int invokePPPPNI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1467 */   public static int invokePPPPNI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1468 */   public static int invokePPPPPI(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1469 */   public static int invokePPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1470 */   public static int invokePPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1471 */   public static int invokePPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1472 */   public static int invokePPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1473 */   public static int invokePNPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePNPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1474 */   public static int invokePPPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1475 */   public static int invokePPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1476 */   public static int invokePPPPPI(long param0, long param1, int param2, long param3, long param4, int param5, int param6, long param7, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1477 */   public static int invokePPPPPI(long param0, long param1, long param2, int param3, long param4, int param5, int param6, long param7, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1478 */   public static int invokePPPPPI(long param0, long param1, long param2, int param3, int param4, int param5, float param6, long param7, long param8, long __functionAddress) { return jni.invokePPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1479 */   public static int invokePPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1480 */   public static int invokePPUUUUI(long param0, long param1, byte param2, byte param3, byte param4, byte param5, long __functionAddress) { return jni.invokePPUUUUI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1481 */   public static int invokePJJJJPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long __functionAddress) { return jni.invokePJJJJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1482 */   public static int invokePPNPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPNPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1483 */   public static int invokePPPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1484 */   public static int invokePPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1485 */   public static int invokePNNPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePNNPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1486 */   public static int invokePPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1487 */   public static int invokePPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1488 */   public static int invokePPPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, int param8, long param9, long __functionAddress) { return jni.invokePPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1489 */   public static int invokePPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1490 */   public static int invokePPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) { return jni.invokePPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1491 */   public static int invokePPPPPPPI(long param0, long param1, long param2, int param3, long param4, float param5, float param6, long param7, long param8, long param9, long __functionAddress) { return jni.invokePPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1492 */   public static int invokePPPPPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long param6, int param7, long param8, int param9, long param10, int param11, long __functionAddress) { return jni.invokePPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1493 */   public static int invokePPPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) { return jni.invokePPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1494 */   public static long invokeJ(long __functionAddress) { return jni.invokeJ(MemorySegment.ofAddress(__functionAddress)); }
/* 1495 */   public static long invokeJ(int param0, int param1, long __functionAddress) { return jni.invokeJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1496 */   public static long invokePJ(long param0, long __functionAddress) { return jni.invokePJ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1497 */   public static long invokePJ(long param0, int param1, long __functionAddress) { return jni.invokePJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1498 */   public static long invokePJ(long param0, int param1, int param2, long __functionAddress) { return jni.invokePJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1499 */   public static long invokePJJ(long param0, long param1, long __functionAddress) { return jni.invokePJJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1500 */   public static long invokePPJ(long param0, long param1, long __functionAddress) { return jni.invokePPJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1501 */   public static long invokePJJ(int param0, long param1, long param2, long __functionAddress) { return jni.invokePJJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1502 */   public static long invokePJJ(long param0, int param1, long param2, long __functionAddress) { return jni.invokePJJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1503 */   public static long invokePJJ(long param0, long param1, int param2, long __functionAddress) { return jni.invokePJJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1504 */   public static long invokePPJ(long param0, long param1, int param2, long __functionAddress) { return jni.invokePPJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1505 */   public static long invokeNN(long param0, long __functionAddress) { return jni.invokeNN(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1506 */   public static long invokePN(long param0, long __functionAddress) { return jni.invokePN(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1507 */   public static long invokePN(long param0, int param1, long __functionAddress) { return jni.invokePN(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1508 */   public static long invokeNNN(long param0, long param1, long __functionAddress) { return jni.invokeNNN(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1509 */   public static long invokePPN(long param0, long param1, long __functionAddress) { return jni.invokePPN(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1510 */   public static long invokeNNNN(long param0, long param1, long param2, long __functionAddress) { return jni.invokeNNNN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1511 */   public static long invokePNPN(long param0, long param1, long param2, long __functionAddress) { return jni.invokePNPN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1512 */   public static long invokePNPN(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePNPN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1513 */   public static long invokePPNN(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPNN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1514 */   public static long invokePNPNN(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePNPNN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1515 */   public static long invokePNPNPN(long param0, long param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long param9, long param10, long param11, long __functionAddress) { return jni.invokePNPNPN(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1516 */   public static long invokeP(long __functionAddress) { return jni.invokeP(MemorySegment.ofAddress(__functionAddress)); }
/* 1517 */   public static long invokeP(int param0, long __functionAddress) { return jni.invokeP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1518 */   public static long invokeP(boolean param0, long __functionAddress) { return jni.invokeP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1519 */   public static long invokeP(int param0, int param1, long __functionAddress) { return jni.invokeP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1520 */   public static long invokeP(int param0, int param1, int param2, long __functionAddress) { return jni.invokeP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1521 */   public static long invokeCP(short param0, long __functionAddress) { return jni.invokeCP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1522 */   public static long invokeJP(long param0, long __functionAddress) { return jni.invokeJP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1523 */   public static long invokePP(long param0, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1524 */   public static long invokePP(int param0, long param1, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1525 */   public static long invokePP(long param0, double param1, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1526 */   public static long invokePP(long param0, float param1, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1527 */   public static long invokePP(long param0, int param1, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1528 */   public static long invokePP(long param0, boolean param1, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1529 */   public static long invokePP(int param0, int param1, long param2, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1530 */   public static long invokePP(int param0, boolean param1, long param2, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1531 */   public static long invokePP(long param0, int param1, int param2, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1532 */   public static long invokePP(int param0, int param1, int param2, long param3, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1533 */   public static long invokePP(long param0, int param1, int param2, int param3, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1534 */   public static long invokePP(int param0, int param1, int param2, long param3, int param4, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1535 */   public static long invokePP(long param0, float param1, int param2, float param3, int param4, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1536 */   public static long invokePP(long param0, int param1, int param2, int param3, int param4, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1537 */   public static long invokePP(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { return jni.invokePP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1538 */   public static long invokeCCP(short param0, short param1, long __functionAddress) { return jni.invokeCCP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1539 */   public static long invokeJPP(long param0, long param1, long __functionAddress) { return jni.invokeJPP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1540 */   public static long invokePJP(long param0, long param1, long __functionAddress) { return jni.invokePJP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1541 */   public static long invokePNP(long param0, long param1, long __functionAddress) { return jni.invokePNP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1542 */   public static long invokePPP(long param0, long param1, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1543 */   public static long invokePUP(long param0, byte param1, long __functionAddress) { return jni.invokePUP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1544 */   public static long invokeCPP(int param0, short param1, long param2, long __functionAddress) { return jni.invokeCPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1545 */   public static long invokePCP(long param0, short param1, boolean param2, long __functionAddress) { return jni.invokePCP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1546 */   public static long invokePJP(long param0, int param1, long param2, long __functionAddress) { return jni.invokePJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1547 */   public static long invokePJP(long param0, long param1, int param2, long __functionAddress) { return jni.invokePJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1548 */   public static long invokePPP(int param0, long param1, long param2, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1549 */   public static long invokePPP(long param0, int param1, long param2, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1550 */   public static long invokePPP(long param0, long param1, int param2, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1551 */   public static long invokePPP(long param0, long param1, boolean param2, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1552 */   public static long invokePJP(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.invokePJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1553 */   public static long invokePPP(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1554 */   public static long invokePPP(long param0, int param1, long param2, int param3, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1555 */   public static long invokePPP(long param0, long param1, int param2, int param3, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1556 */   public static long invokePPP(long param0, long param1, boolean param2, boolean param3, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1557 */   public static long invokePPP(long param0, boolean param1, boolean param2, long param3, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1558 */   public static long invokePPP(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1559 */   public static long invokePPP(long param0, int param1, long param2, int param3, int param4, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1560 */   public static long invokePJP(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.invokePJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1561 */   public static long invokePPP(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1562 */   public static long invokePPP(long param0, long param1, int param2, int param3, int param4, int param5, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1563 */   public static long invokePUP(long param0, int param1, byte param2, int param3, boolean param4, boolean param5, long __functionAddress) { return jni.invokePUP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1564 */   public static long invokePPP(int param0, int param1, int param2, int param3, long param4, int param5, long param6, long __functionAddress) { return jni.invokePPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1565 */   public static long invokeCCPP(short param0, short param1, long param2, long __functionAddress) { return jni.invokeCCPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1566 */   public static long invokeCPCP(short param0, long param1, short param2, long __functionAddress) { return jni.invokeCPCP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1567 */   public static long invokePJJP(long param0, long param1, long param2, long __functionAddress) { return jni.invokePJJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1568 */   public static long invokePPJP(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1569 */   public static long invokePPPP(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1570 */   public static long invokePPUP(long param0, long param1, byte param2, long __functionAddress) { return jni.invokePPUP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1571 */   public static long invokePPPP(int param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1572 */   public static long invokePPPP(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1573 */   public static long invokePPPP(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1574 */   public static long invokePPPP(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1575 */   public static long invokePPPP(long param0, long param1, boolean param2, long param3, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1576 */   public static long invokePPUP(long param0, long param1, int param2, byte param3, long __functionAddress) { return jni.invokePPUP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1577 */   public static long invokePPPP(int param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1578 */   public static long invokePPPP(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1579 */   public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1580 */   public static long invokePPPP(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1581 */   public static long invokePPPP(long param0, long param1, long param2, int param3, int param4, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1582 */   public static long invokeJPPP(int param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokeJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1583 */   public static long invokePPPP(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1584 */   public static long invokePPPP(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1585 */   public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, int param5, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1586 */   public static long invokePPPP(int param0, int param1, int param2, long param3, long param4, int param5, long param6, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1587 */   public static long invokePPPP(long param0, long param1, int param2, int param3, long param4, int param5, int param6, long __functionAddress) { return jni.invokePPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1588 */   public static long invokePBPPP(long param0, byte param1, long param2, long param3, long __functionAddress) { return jni.invokePBPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1589 */   public static long invokePNNPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePNNPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1590 */   public static long invokePPJPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1591 */   public static long invokePPNNP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPNNP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1592 */   public static long invokePPPPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1593 */   public static long invokePPPJP(int param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1594 */   public static long invokePPPJP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePPPJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1595 */   public static long invokePPPPP(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1596 */   public static long invokePPPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1597 */   public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1598 */   public static long invokePPPPP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1599 */   public static long invokePJPPP(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1600 */   public static long invokePJPPP(long param0, long param1, int param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1601 */   public static long invokePPPJP(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) { return jni.invokePPPJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1602 */   public static long invokePPPPP(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1603 */   public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1604 */   public static long invokePPPPP(long param0, long param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1605 */   public static long invokePPPPP(long param0, long param1, long param2, int param3, long param4, int param5, int param6, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1606 */   public static long invokePPPPP(long param0, long param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1607 */   public static long invokePPPPP(int param0, int param1, int param2, long param3, long param4, long param5, int param6, long param7, long __functionAddress) { return jni.invokePPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1608 */   public static long invokePJPJPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePJPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1609 */   public static long invokePNNNPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePNNNPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1610 */   public static long invokePPBPPP(long param0, long param1, byte param2, long param3, long param4, long __functionAddress) { return jni.invokePPBPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1611 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1612 */   public static long invokeCCCUJP(short param0, short param1, short param2, byte param3, int param4, long param5, long __functionAddress) { return jni.invokeCCCUJP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1613 */   public static long invokePPPJPP(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePPPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1614 */   public static long invokePPPPNP(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPNP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1615 */   public static long invokePPPPPP(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1616 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1617 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1618 */   public static long invokePPJPPP(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.invokePPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1619 */   public static long invokePPPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long param6, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1620 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1621 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, int param6, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1622 */   public static long invokePPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, int param6, int param7, int param8, long __functionAddress) { return jni.invokePPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1623 */   public static long invokePPJJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPJJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1624 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1625 */   public static long invokePSSCCPP(long param0, short param1, short param2, short param3, short param4, long param5, long __functionAddress) { return jni.invokePSSCCPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1626 */   public static long invokePPPPPPP(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1627 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1628 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1629 */   public static long invokePPPPPPP(long param0, long param1, int param2, int param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1630 */   public static long invokePPPPPPP(long param0, long param1, long param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1631 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1632 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1633 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, int param8, int param9, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1634 */   public static long invokePPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, int param9, long __functionAddress) { return jni.invokePPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1635 */   public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1636 */   public static long invokePPPPPJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, long __functionAddress) { return jni.invokePPPPPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1637 */   public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long __functionAddress) { return jni.invokePPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1638 */   public static long invokePPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long __functionAddress) { return jni.invokePPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1639 */   public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.invokePPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1640 */   public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, long __functionAddress) { return jni.invokePPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1641 */   public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long param9, long __functionAddress) { return jni.invokePPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1642 */   public static long invokePPPPJJPPP(long param0, long param1, long param2, long param3, int param4, long param5, int param6, long param7, int param8, long param9, long param10, long __functionAddress) { return jni.invokePPPPJJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1643 */   public static long invokePPPPPJJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) { return jni.invokePPPPPJJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1644 */   public static long invokePPPPPJPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) { return jni.invokePPPPPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1645 */   public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) { return jni.invokePPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1646 */   public static long invokePPPPPJPPP(long param0, int param1, long param2, long param3, long param4, long param5, int param6, int param7, long param8, int param9, long param10, long param11, long __functionAddress) { return jni.invokePPPPPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1647 */   public static long invokePPPPPJPPP(long param0, int param1, long param2, long param3, long param4, long param5, int param6, int param7, long param8, int param9, int param10, long param11, long param12, long __functionAddress) { return jni.invokePPPPPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12); }
/* 1648 */   public static long invokePPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, int param10, int param11, int param12, int param13, long __functionAddress) { return jni.invokePPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13); }
/* 1649 */   public static long invokePPPPPJJJPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long param8, int param9, long param10, long __functionAddress) { return jni.invokePPPPPJJJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1650 */   public static long invokePPPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, int param9, long param10, long __functionAddress) { return jni.invokePPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 1651 */   public static long invokePPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, long param10, int param11, long __functionAddress) { return jni.invokePPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1652 */   public static long invokePPPPPJPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, long param9, int param10, int param11, long param12, long param13, long __functionAddress) { return jni.invokePPPPPJPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13); }
/* 1653 */   public static long invokePPPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) { return jni.invokePPPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1654 */   public static long invokePPPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, int param9, long param10, long param11, int param12, long __functionAddress) { return jni.invokePPPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12); }
/* 1655 */   public static long invokePPPPPJPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, int param8, long param9, long param10, long param11, long param12, long param13, long __functionAddress) { return jni.invokePPPPPJPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13); }
/* 1656 */   public static long invokePPPPPJPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, int param8, long param9, long param10, int param11, int param12, long param13, long param14, long param15, long __functionAddress) { return jni.invokePPPPPJPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15); }
/* 1657 */   public static long invokePPPPPPPPPPPPP(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, int param8, long param9, long param10, int param11, int param12, int param13, int param14, long param15, long param16, long param17, long param18, long __functionAddress) { return jni.invokePPPPPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16, param17, param18); }
/* 1658 */   public static long invokePPPPPJPPPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, long param8, long param9, int param10, long param11, long param12, long param13, long param14, long param15, long __functionAddress) { return jni.invokePPPPPJPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15); }
/* 1659 */   public static long invokePPPPPJJPPPPPPP(long param0, long param1, long param2, long param3, long param4, int param5, long param6, int param7, long param8, int param9, long param10, long param11, int param12, long param13, long param14, long param15, long param16, long __functionAddress) { return jni.invokePPPPPJJPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16); }
/* 1660 */   public static short invokePS(long param0, int param1, long __functionAddress) { return jni.invokePS(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1661 */   public static byte invokeU(int param0, long __functionAddress) { return jni.invokeU(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1662 */   public static byte invokePU(long param0, int param1, long __functionAddress) { return jni.invokePU(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1663 */   public static byte invokeUPU(byte param0, long param1, long __functionAddress) { return jni.invokeUPU(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1664 */   public static void invokeV(long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress)); }
/* 1665 */   public static void invokeV(double param0, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1666 */   public static void invokeV(float param0, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1667 */   public static void invokeV(int param0, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1668 */   public static void invokeV(boolean param0, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1669 */   public static void invokeV(int param0, float param1, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1670 */   public static void invokeV(int param0, int param1, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1671 */   public static void invokeV(int param0, boolean param1, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1672 */   public static void invokeV(int param0, int param1, double param2, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1673 */   public static void invokeV(int param0, int param1, float param2, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1674 */   public static void invokeV(int param0, int param1, int param2, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1675 */   public static void invokeV(int param0, float param1, float param2, float param3, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1676 */   public static void invokeV(int param0, int param1, int param2, int param3, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1677 */   public static void invokeV(int param0, int param1, double param2, double param3, double param4, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1678 */   public static void invokeV(int param0, int param1, float param2, float param3, float param4, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1679 */   public static void invokeV(int param0, int param1, int param2, int param3, int param4, long __functionAddress) { jni.invokeV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1680 */   public static void invokeCV(short param0, long __functionAddress) { jni.invokeCV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1681 */   public static void invokeJV(long param0, long __functionAddress) { jni.invokeJV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1682 */   public static void invokePV(long param0, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1683 */   public static void invokeUV(byte param0, long __functionAddress) { jni.invokeUV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1684 */   public static void invokeCV(int param0, short param1, long __functionAddress) { jni.invokeCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1685 */   public static void invokeCV(short param0, int param1, long __functionAddress) { jni.invokeCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1686 */   public static void invokeCV(short param0, boolean param1, long __functionAddress) { jni.invokeCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1687 */   public static void invokeJV(int param0, long param1, long __functionAddress) { jni.invokeJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1688 */   public static void invokeJV(long param0, int param1, long __functionAddress) { jni.invokeJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1689 */   public static void invokePV(int param0, long param1, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1690 */   public static void invokePV(long param0, float param1, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1691 */   public static void invokePV(long param0, int param1, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1692 */   public static void invokePV(long param0, boolean param1, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1693 */   public static void invokeUV(byte param0, int param1, long __functionAddress) { jni.invokeUV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1694 */   public static void invokeUV(byte param0, boolean param1, long __functionAddress) { jni.invokeUV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1695 */   public static void invokeCV(short param0, int param1, int param2, long __functionAddress) { jni.invokeCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1696 */   public static void invokeJV(int param0, int param1, long param2, long __functionAddress) { jni.invokeJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1697 */   public static void invokePV(int param0, int param1, long param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1698 */   public static void invokePV(int param0, long param1, boolean param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1699 */   public static void invokePV(long param0, double param1, double param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1700 */   public static void invokePV(long param0, float param1, float param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1701 */   public static void invokePV(long param0, int param1, double param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1702 */   public static void invokePV(long param0, int param1, float param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1703 */   public static void invokePV(long param0, int param1, int param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1704 */   public static void invokePV(long param0, int param1, boolean param2, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1705 */   public static void invokePV(int param0, int param1, int param2, long param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1706 */   public static void invokePV(long param0, float param1, float param2, float param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1707 */   public static void invokePV(long param0, float param1, float param2, int param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1708 */   public static void invokePV(long param0, int param1, int param2, double param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1709 */   public static void invokePV(long param0, int param1, int param2, float param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1710 */   public static void invokePV(long param0, int param1, int param2, int param3, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1711 */   public static void invokePV(int param0, int param1, long param2, int param3, int param4, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1712 */   public static void invokePV(long param0, int param1, float param2, float param3, float param4, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1713 */   public static void invokePV(long param0, int param1, int param2, int param3, int param4, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1714 */   public static void invokeUV(byte param0, float param1, float param2, float param3, float param4, long __functionAddress) { jni.invokeUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1715 */   public static void invokePV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1716 */   public static void invokePV(int param0, int param1, int param2, int param3, long param4, boolean param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1717 */   public static void invokePV(long param0, int param1, int param2, double param3, double param4, double param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1718 */   public static void invokePV(long param0, int param1, int param2, float param3, float param4, float param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1719 */   public static void invokePV(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1720 */   public static void invokePV(long param0, int param1, int param2, int param3, int param4, boolean param5, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1721 */   public static void invokePV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.invokePV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1722 */   public static void invokeCCV(short param0, short param1, long __functionAddress) { jni.invokeCCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1723 */   public static void invokeCPV(short param0, long param1, long __functionAddress) { jni.invokeCPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1724 */   public static void invokePCV(long param0, short param1, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1725 */   public static void invokePJV(long param0, long param1, long __functionAddress) { jni.invokePJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1726 */   public static void invokePNV(long param0, long param1, long __functionAddress) { jni.invokePNV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1727 */   public static void invokePPV(long param0, long param1, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1728 */   public static void invokePUV(long param0, byte param1, long __functionAddress) { jni.invokePUV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1729 */   public static void invokeUPV(byte param0, long param1, long __functionAddress) { jni.invokeUPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1730 */   public static void invokeCPV(short param0, int param1, long param2, long __functionAddress) { jni.invokeCPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1731 */   public static void invokeCPV(short param0, long param1, int param2, long __functionAddress) { jni.invokeCPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1732 */   public static void invokePCV(long param0, int param1, short param2, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1733 */   public static void invokePCV(long param0, short param1, boolean param2, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1734 */   public static void invokePJV(int param0, long param1, long param2, long __functionAddress) { jni.invokePJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1735 */   public static void invokePJV(long param0, int param1, long param2, long __functionAddress) { jni.invokePJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1736 */   public static void invokePJV(long param0, long param1, int param2, long __functionAddress) { jni.invokePJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1737 */   public static void invokePPV(int param0, long param1, long param2, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1738 */   public static void invokePPV(long param0, int param1, long param2, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1739 */   public static void invokePPV(long param0, long param1, float param2, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1740 */   public static void invokePPV(long param0, long param1, int param2, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1741 */   public static void invokePPV(long param0, long param1, boolean param2, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1742 */   public static void invokeUCV(byte param0, short param1, int param2, long __functionAddress) { jni.invokeUCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1743 */   public static void invokePBV(long param0, int param1, int param2, byte param3, long __functionAddress) { jni.invokePBV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1744 */   public static void invokePCV(long param0, int param1, int param2, short param3, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1745 */   public static void invokePCV(long param0, short param1, int param2, int param3, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1746 */   public static void invokePJV(long param0, int param1, int param2, long param3, long __functionAddress) { jni.invokePJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1747 */   public static void invokePPV(int param0, int param1, long param2, long param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1748 */   public static void invokePPV(int param0, long param1, long param2, int param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1749 */   public static void invokePPV(long param0, int param1, int param2, long param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1750 */   public static void invokePPV(long param0, int param1, long param2, int param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1751 */   public static void invokePPV(long param0, int param1, long param2, boolean param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1752 */   public static void invokePPV(long param0, long param1, int param2, int param3, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1753 */   public static void invokePSV(long param0, int param1, int param2, short param3, long __functionAddress) { jni.invokePSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1754 */   public static void invokePUV(long param0, int param1, int param2, byte param3, long __functionAddress) { jni.invokePUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1755 */   public static void invokeUCV(byte param0, short param1, int param2, int param3, long __functionAddress) { jni.invokeUCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1756 */   public static void invokeUPV(byte param0, long param1, int param2, int param3, long __functionAddress) { jni.invokeUPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1757 */   public static void invokePCV(long param0, short param1, int param2, int param3, int param4, long __functionAddress) { jni.invokePCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1758 */   public static void invokePPV(int param0, int param1, int param2, long param3, long param4, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1759 */   public static void invokePPV(long param0, float param1, long param2, int param3, int param4, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1760 */   public static void invokePPV(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1761 */   public static void invokePPV(long param0, long param1, int param2, int param3, int param4, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1762 */   public static void invokePPV(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1763 */   public static void invokePPV(long param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1764 */   public static void invokePPV(long param0, int param1, int param2, long param3, int param4, int param5, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1765 */   public static void invokePPV(long param0, long param1, float param2, float param3, float param4, float param5, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1766 */   public static void invokePPV(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1767 */   public static void invokePPV(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1768 */   public static void invokePPV(long param0, int param1, int param2, int param3, int param4, long param5, boolean param6, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1769 */   public static void invokePPV(long param0, long param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1770 */   public static void invokePPV(long param0, long param1, float param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) { jni.invokePPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1771 */   public static void invokeCCPV(short param0, short param1, long param2, long __functionAddress) { jni.invokeCCPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1772 */   public static void invokeCPCV(short param0, long param1, short param2, long __functionAddress) { jni.invokeCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1773 */   public static void invokeCPPV(short param0, long param1, long param2, long __functionAddress) { jni.invokeCPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1774 */   public static void invokeJPPV(long param0, long param1, long param2, long __functionAddress) { jni.invokeJPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1775 */   public static void invokePJPV(long param0, long param1, long param2, long __functionAddress) { jni.invokePJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1776 */   public static void invokePNNV(long param0, long param1, long param2, long __functionAddress) { jni.invokePNNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1777 */   public static void invokePNPV(long param0, long param1, long param2, long __functionAddress) { jni.invokePNPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1778 */   public static void invokePPNV(long param0, long param1, long param2, long __functionAddress) { jni.invokePPNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1779 */   public static void invokePPPV(long param0, long param1, long param2, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1780 */   public static void invokeCCCV(short param0, short param1, short param2, int param3, long __functionAddress) { jni.invokeCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1781 */   public static void invokeCCUV(short param0, short param1, int param2, byte param3, long __functionAddress) { jni.invokeCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1782 */   public static void invokePJPV(long param0, long param1, long param2, int param3, long __functionAddress) { jni.invokePJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1783 */   public static void invokePPJV(long param0, int param1, long param2, long param3, long __functionAddress) { jni.invokePPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1784 */   public static void invokePPPV(int param0, long param1, long param2, long param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1785 */   public static void invokePPPV(long param0, int param1, long param2, long param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1786 */   public static void invokePPPV(long param0, long param1, int param2, long param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1787 */   public static void invokePPPV(long param0, long param1, long param2, float param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1788 */   public static void invokePPPV(long param0, long param1, long param2, int param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1789 */   public static void invokePPPV(long param0, long param1, long param2, boolean param3, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1790 */   public static void invokePUCV(long param0, byte param1, short param2, int param3, long __functionAddress) { jni.invokePUCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1791 */   public static void invokeUCCV(byte param0, short param1, short param2, int param3, long __functionAddress) { jni.invokeUCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1792 */   public static void invokeCCUV(short param0, short param1, int param2, float param3, byte param4, long __functionAddress) { jni.invokeCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1793 */   public static void invokeJJJV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.invokeJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1794 */   public static void invokePNNV(long param0, long param1, int param2, int param3, long param4, long __functionAddress) { jni.invokePNNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1795 */   public static void invokePPPV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1796 */   public static void invokePPPV(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1797 */   public static void invokePPPV(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1798 */   public static void invokePPPV(long param0, long param1, int param2, int param3, long param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1799 */   public static void invokePPPV(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1800 */   public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1801 */   public static void invokePPPV(long param0, long param1, long param2, int param3, boolean param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1802 */   public static void invokePPPV(long param0, long param1, long param2, boolean param3, boolean param4, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1803 */   public static void invokePUCV(long param0, byte param1, short param2, int param3, int param4, long __functionAddress) { jni.invokePUCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1804 */   public static void invokePUPV(long param0, byte param1, long param2, int param3, int param4, long __functionAddress) { jni.invokePUPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1805 */   public static void invokeUCCV(byte param0, short param1, int param2, int param3, short param4, long __functionAddress) { jni.invokeUCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1806 */   public static void invokeUCUV(byte param0, short param1, byte param2, int param3, int param4, long __functionAddress) { jni.invokeUCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1807 */   public static void invokeUPCV(byte param0, long param1, int param2, int param3, short param4, long __functionAddress) { jni.invokeUPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1808 */   public static void invokeCCUV(short param0, short param1, int param2, int param3, int param4, byte param5, long __functionAddress) { jni.invokeCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1809 */   public static void invokePPPV(int param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1810 */   public static void invokePPPV(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1811 */   public static void invokePPPV(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1812 */   public static void invokePPPV(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1813 */   public static void invokePPPV(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1814 */   public static void invokePPPV(long param0, long param1, long param2, int param3, boolean param4, boolean param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1815 */   public static void invokePPPV(long param0, boolean param1, int param2, long param3, long param4, int param5, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1816 */   public static void invokePPPV(long param0, int param1, int param2, long param3, int param4, long param5, int param6, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1817 */   public static void invokePPPV(long param0, int param1, long param2, int param3, long param4, int param5, int param6, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1818 */   public static void invokePPPV(long param0, long param1, float param2, float param3, float param4, float param5, long param6, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1819 */   public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1820 */   public static void invokePPPV(long param0, long param1, long param2, int param3, int param4, int param5, boolean param6, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1821 */   public static void invokePPPV(long param0, long param1, int param2, int param3, int param4, long param5, int param6, boolean param7, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1822 */   public static void invokePPPV(long param0, long param1, float param2, float param3, float param4, float param5, float param6, float param7, long param8, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1823 */   public static void invokePPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, float param8, long __functionAddress) { jni.invokePPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1824 */   public static void invokeCCPCV(short param0, short param1, long param2, short param3, long __functionAddress) { jni.invokeCCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1825 */   public static void invokeCCUPV(short param0, short param1, byte param2, long param3, long __functionAddress) { jni.invokeCCUPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1826 */   public static void invokePCPCV(long param0, short param1, long param2, short param3, long __functionAddress) { jni.invokePCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1827 */   public static void invokePNPPV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.invokePNPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1828 */   public static void invokePPPPV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1829 */   public static void invokeCCCUV(short param0, short param1, short param2, int param3, byte param4, long __functionAddress) { jni.invokeCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1830 */   public static void invokePCCUV(long param0, short param1, short param2, int param3, byte param4, long __functionAddress) { jni.invokePCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1831 */   public static void invokePJJPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.invokePJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1832 */   public static void invokePPCPV(long param0, long param1, short param2, int param3, long param4, long __functionAddress) { jni.invokePPCPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1833 */   public static void invokePPPCV(long param0, long param1, int param2, long param3, short param4, long __functionAddress) { jni.invokePPPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1834 */   public static void invokePPPPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1835 */   public static void invokePPPPV(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1836 */   public static void invokePPPPV(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1837 */   public static void invokePPPPV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1838 */   public static void invokePPPPV(long param0, long param1, long param2, long param3, boolean param4, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1839 */   public static void invokePUCCV(long param0, byte param1, short param2, short param3, int param4, long __functionAddress) { jni.invokePUCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1840 */   public static void invokeCCCUV(short param0, short param1, short param2, int param3, int param4, byte param5, long __functionAddress) { jni.invokeCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1841 */   public static void invokePJJJV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1842 */   public static void invokePPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1843 */   public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, long param5, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1844 */   public static void invokePUCCV(long param0, byte param1, short param2, int param3, int param4, short param5, long __functionAddress) { jni.invokePUCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1845 */   public static void invokePUCUV(long param0, byte param1, short param2, byte param3, int param4, int param5, long __functionAddress) { jni.invokePUCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1846 */   public static void invokePUPCV(long param0, byte param1, long param2, int param3, int param4, short param5, long __functionAddress) { jni.invokePUPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1847 */   public static void invokeCCCUV(short param0, short param1, short param2, int param3, int param4, int param5, byte param6, long __functionAddress) { jni.invokeCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1848 */   public static void invokePCCUV(long param0, short param1, short param2, int param3, int param4, int param5, byte param6, long __functionAddress) { jni.invokePCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1849 */   public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, long param7, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1850 */   public static void invokePPPPV(long param0, long param1, long param2, int param3, int param4, int param5, float param6, long param7, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1851 */   public static void invokePPPPV(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, float param8, long param9, long __functionAddress) { jni.invokePPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1852 */   public static void invokeCCCCCV(short param0, short param1, short param2, short param3, short param4, long __functionAddress) { jni.invokeCCCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1853 */   public static void invokeCCUPPV(short param0, short param1, byte param2, long param3, long param4, long __functionAddress) { jni.invokeCCUPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1854 */   public static void invokePPCPPV(long param0, long param1, short param2, long param3, long param4, long __functionAddress) { jni.invokePPCPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1855 */   public static void invokePPPPPV(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1856 */   public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, byte param5, long __functionAddress) { jni.invokePCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1857 */   public static void invokePJPPPV(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { jni.invokePJPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1858 */   public static void invokePPPPPV(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1859 */   public static void invokePPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1860 */   public static void invokePPPPPV(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1861 */   public static void invokePPPPPV(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1862 */   public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, int param5, byte param6, long __functionAddress) { jni.invokePCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1863 */   public static void invokePPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1864 */   public static void invokePPPPPV(long param0, long param1, long param2, long param3, int param4, long param5, boolean param6, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1865 */   public static void invokePCCCCV(long param0, short param1, short param2, short param3, boolean param4, boolean param5, short param6, int param7, long __functionAddress) { jni.invokePCCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1866 */   public static void invokePCCCUV(long param0, short param1, short param2, short param3, int param4, int param5, int param6, byte param7, long __functionAddress) { jni.invokePCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1867 */   public static void invokePPPPPV(long param0, long param1, int param2, long param3, int param4, long param5, int param6, long param7, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1868 */   public static void invokePPPPPV(long param0, long param1, int param2, long param3, long param4, int param5, int param6, long param7, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1869 */   public static void invokeCCCCUV(short param0, short param1, short param2, int param3, short param4, int param5, int param6, int param7, byte param8, long __functionAddress) { jni.invokeCCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1870 */   public static void invokePPPPPV(int param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, int param8, boolean param9, long __functionAddress) { jni.invokePPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1871 */   public static void invokeCCCCPCV(short param0, short param1, short param2, short param3, long param4, short param5, long __functionAddress) { jni.invokeCCCCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1872 */   public static void invokePPPPPPV(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.invokePPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1873 */   public static void invokePCCCCUV(long param0, short param1, int param2, short param3, short param4, short param5, byte param6, long __functionAddress) { jni.invokePCCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1874 */   public static void invokePPPPPPV(int param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.invokePPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1875 */   public static void invokePCCCCUV(long param0, short param1, short param2, short param3, int param4, short param5, int param6, int param7, int param8, byte param9, long __functionAddress) { jni.invokePCCCCUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1876 */   public static void invokePPPPPPPV(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.invokePPPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1877 */   public static void invokePPPPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { jni.invokePPPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1878 */   public static void invokeCCUCCCCPCV(short param0, short param1, byte param2, short param3, short param4, short param5, short param6, long param7, short param8, long __functionAddress) { jni.invokeCCUCCCCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1879 */   public static void invokeCUCCCCCCPV(short param0, byte param1, short param2, short param3, short param4, short param5, short param6, short param7, long param8, long __functionAddress) { jni.invokeCUCCCCCCPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1880 */   public static void invokeCCUUCCCCPCV(short param0, short param1, byte param2, byte param3, short param4, short param5, short param6, short param7, long param8, short param9, long __functionAddress) { jni.invokeCCUUCCCCPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1881 */   public static void invokeCCUUUUUUUUUV(short param0, short param1, float param2, byte param3, byte param4, byte param5, byte param6, byte param7, byte param8, byte param9, byte param10, byte param11, long __functionAddress) { jni.invokeCCUUUUUUUUUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1882 */   public static void invokeCCUCCCCUCCCCCCV(short param0, short param1, byte param2, short param3, short param4, short param5, short param6, byte param7, short param8, short param9, short param10, short param11, short param12, short param13, long __functionAddress) { jni.invokeCCUCCCCUCCCCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13); }
/* 1883 */   public static void invokePCCUCCCCUCCCCCCV(long param0, short param1, short param2, byte param3, short param4, short param5, short param6, short param7, byte param8, short param9, short param10, short param11, short param12, short param13, short param14, long __functionAddress) { jni.invokePCCUCCCCUCCCCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14); }
/* 1884 */   public static boolean invokeZ(long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress)); }
/* 1885 */   public static boolean invokeZ(int param0, long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1886 */   public static boolean invokeZ(boolean param0, long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1887 */   public static boolean invokeZ(float param0, float param1, long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1888 */   public static boolean invokeZ(int param0, float param1, long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1889 */   public static boolean invokeZ(int param0, int param1, long __functionAddress) { return jni.invokeZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1890 */   public static boolean invokePZ(long param0, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1891 */   public static boolean invokeJZ(long param0, int param1, long __functionAddress) { return jni.invokeJZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1892 */   public static boolean invokePZ(int param0, long param1, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1893 */   public static boolean invokePZ(long param0, float param1, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1894 */   public static boolean invokePZ(long param0, int param1, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1895 */   public static boolean invokePZ(long param0, boolean param1, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1896 */   public static boolean invokeJZ(long param0, int param1, int param2, long __functionAddress) { return jni.invokeJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1897 */   public static boolean invokePZ(int param0, int param1, long param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1898 */   public static boolean invokePZ(int param0, long param1, float param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1899 */   public static boolean invokePZ(int param0, long param1, int param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1900 */   public static boolean invokePZ(int param0, long param1, boolean param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1901 */   public static boolean invokePZ(long param0, float param1, float param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1902 */   public static boolean invokePZ(long param0, float param1, int param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1903 */   public static boolean invokePZ(long param0, int param1, int param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1904 */   public static boolean invokePZ(long param0, int param1, boolean param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1905 */   public static boolean invokePZ(long param0, boolean param1, int param2, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1906 */   public static boolean invokePZ(long param0, float param1, float param2, float param3, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1907 */   public static boolean invokePZ(long param0, int param1, int param2, int param3, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1908 */   public static boolean invokePZ(long param0, float param1, float param2, float param3, float param4, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1909 */   public static boolean invokePZ(int param0, int param1, int param2, float param3, boolean param4, long param5, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1910 */   public static boolean invokePZ(long param0, int param1, int param2, float param3, float param4, float param5, float param6, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1911 */   public static boolean invokePZ(long param0, int param1, int param2, boolean param3, float param4, float param5, float param6, long __functionAddress) { return jni.invokePZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1912 */   public static boolean invokePBZ(long param0, byte param1, long __functionAddress) { return jni.invokePBZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1913 */   public static boolean invokePCZ(long param0, short param1, long __functionAddress) { return jni.invokePCZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1914 */   public static boolean invokePJZ(long param0, long param1, long __functionAddress) { return jni.invokePJZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1915 */   public static boolean invokePPZ(long param0, long param1, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1916 */   public static boolean invokePSZ(long param0, short param1, long __functionAddress) { return jni.invokePSZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1917 */   public static boolean invokePUZ(long param0, byte param1, long __functionAddress) { return jni.invokePUZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1918 */   public static boolean invokeUPZ(byte param0, long param1, long __functionAddress) { return jni.invokeUPZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1919 */   public static boolean invokeJPZ(long param0, long param1, boolean param2, long __functionAddress) { return jni.invokeJPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1920 */   public static boolean invokePJZ(int param0, long param1, long param2, long __functionAddress) { return jni.invokePJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1921 */   public static boolean invokePPZ(int param0, long param1, long param2, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1922 */   public static boolean invokePPZ(long param0, int param1, long param2, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1923 */   public static boolean invokePPZ(long param0, long param1, int param2, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1924 */   public static boolean invokePPZ(long param0, long param1, boolean param2, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1925 */   public static boolean invokePSZ(long param0, int param1, short param2, long __functionAddress) { return jni.invokePSZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1926 */   public static boolean invokePUZ(long param0, int param1, byte param2, long __functionAddress) { return jni.invokePUZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1927 */   public static boolean invokePPZ(long param0, float param1, float param2, long param3, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1928 */   public static boolean invokePPZ(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1929 */   public static boolean invokePPZ(long param0, int param1, long param2, int param3, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1930 */   public static boolean invokePPZ(long param0, long param1, int param2, int param3, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1931 */   public static boolean invokePPZ(long param0, boolean param1, long param2, int param3, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1932 */   public static boolean invokePPZ(long param0, long param1, int param2, int param3, float param4, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1933 */   public static boolean invokePPZ(int param0, int param1, int param2, long param3, int param4, int param5, long param6, int param7, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1934 */   public static boolean invokePPZ(int param0, int param1, int param2, long param3, int param4, int param5, long param6, int param7, boolean param8, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1935 */   public static boolean invokePPZ(int param0, int param1, int param2, int param3, int param4, long param5, int param6, int param7, int param8, int param9, long param10, int param11, long __functionAddress) { return jni.invokePPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1936 */   public static boolean invokePCCZ(long param0, short param1, short param2, long __functionAddress) { return jni.invokePCCZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1937 */   public static boolean invokePPPZ(long param0, long param1, long param2, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1938 */   public static boolean invokePCCZ(long param0, short param1, short param2, int param3, long __functionAddress) { return jni.invokePCCZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1939 */   public static boolean invokePJJZ(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.invokePJJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1940 */   public static boolean invokePJPZ(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePJPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1941 */   public static boolean invokePPPZ(int param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1942 */   public static boolean invokePPPZ(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1943 */   public static boolean invokePPPZ(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1944 */   public static boolean invokePPPZ(long param0, long param1, long param2, boolean param3, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1945 */   public static boolean invokePPPZ(long param0, boolean param1, long param2, long param3, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1946 */   public static boolean invokePSSZ(long param0, int param1, short param2, short param3, long __functionAddress) { return jni.invokePSSZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1947 */   public static boolean invokeCCJZ(short param0, boolean param1, short param2, int param3, long param4, long __functionAddress) { return jni.invokeCCJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1948 */   public static boolean invokePJPZ(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePJPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1949 */   public static boolean invokePPPZ(long param0, float param1, float param2, long param3, long param4, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1950 */   public static boolean invokePPPZ(long param0, long param1, long param2, boolean param3, int param4, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1951 */   public static boolean invokePPPZ(long param0, long param1, int param2, long param3, int param4, boolean param5, long __functionAddress) { return jni.invokePPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1952 */   public static boolean invokePPPJZ(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1953 */   public static boolean invokePPPPZ(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1954 */   public static boolean invokePUUUZ(long param0, byte param1, byte param2, byte param3, long __functionAddress) { return jni.invokePUUUZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1955 */   public static boolean invokePPPPZ(int param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1956 */   public static boolean invokePPPPZ(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1957 */   public static boolean invokePPPPZ(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1958 */   public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, long param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1959 */   public static boolean invokePPPPZ(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1960 */   public static boolean invokePPPPZ(long param0, boolean param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1961 */   public static boolean invokePJPPZ(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePJPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1962 */   public static boolean invokePPPPZ(long param0, long param1, float param2, int param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1963 */   public static boolean invokePPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1964 */   public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, long param8, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 1965 */   public static boolean invokePPPPZ(long param0, long param1, int param2, int param3, int param4, int param5, float param6, int param7, long param8, long param9, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1966 */   public static boolean invokePPPPZ(long param0, long param1, long param2, float param3, float param4, float param5, float param6, float param7, long param8, float param9, long __functionAddress) { return jni.invokePPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 1967 */   public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1968 */   public static boolean invokePPPUPZ(long param0, long param1, long param2, byte param3, long param4, long __functionAddress) { return jni.invokePPPUPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1969 */   public static boolean invokePUUUUZ(long param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) { return jni.invokePUUUUZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 1970 */   public static boolean invokePPPPPZ(int param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1971 */   public static boolean invokePPPPPZ(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1972 */   public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1973 */   public static boolean invokePPPPPZ(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1974 */   public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, double param4, long param5, int param6, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1975 */   public static boolean invokePPPPPZ(long param0, long param1, long param2, long param3, long param4, boolean param5, int param6, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1976 */   public static boolean invokePUUUUZ(long param0, int param1, int param2, byte param3, byte param4, byte param5, byte param6, long __functionAddress) { return jni.invokePUUUUZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 1977 */   public static boolean invokePPPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long param6, int param7, long __functionAddress) { return jni.invokePPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 1978 */   public static boolean invokePPJJPPZ(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPJJPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1979 */   public static boolean invokePPPPPPZ(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.invokePPPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 1980 */   public static boolean invokePPPPPPZ(long param0, long param1, long param2, int param3, long param4, int param5, long param6, int param7, int param8, long param9, int param10, int param11, long __functionAddress) { return jni.invokePPPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 1981 */   public static short callC(int param0, long __functionAddress) { return jni.callC(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1982 */   public static float callF(int param0, int param1, int param2, long __functionAddress) { return jni.callF(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1983 */   public static float callPF(long param0, float param1, long __functionAddress) { return jni.callPF(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1984 */   public static int callI(long __functionAddress) { return jni.callI(MemorySegment.ofAddress(__functionAddress)); }
/* 1985 */   public static int callI(int param0, long __functionAddress) { return jni.callI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1986 */   public static int callI(int param0, int param1, long __functionAddress) { return jni.callI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1987 */   public static int callI(int param0, int param1, int param2, long __functionAddress) { return jni.callI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1988 */   public static int callPI(long param0, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0); }
/* 1989 */   public static int callPI(int param0, long param1, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1990 */   public static int callPI(long param0, float param1, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1991 */   public static int callPI(long param0, int param1, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 1992 */   public static int callPI(int param0, int param1, long param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1993 */   public static int callPI(int param0, long param1, int param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1994 */   public static int callPI(long param0, float param1, float param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1995 */   public static int callPI(long param0, float param1, int param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1996 */   public static int callPI(long param0, int param1, float param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1997 */   public static int callPI(long param0, int param1, int param2, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 1998 */   public static int callJI(int param0, long param1, int param2, int param3, long __functionAddress) { return jni.callJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 1999 */   public static int callPI(int param0, int param1, int param2, long param3, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2000 */   public static int callPI(long param0, float param1, float param2, float param3, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2001 */   public static int callPI(long param0, int param1, float param2, float param3, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2002 */   public static int callPI(long param0, int param1, int param2, int param3, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2003 */   public static int callPI(long param0, int param1, int param2, boolean param3, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2004 */   public static int callPI(int param0, int param1, int param2, int param3, long param4, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2005 */   public static int callPI(long param0, int param1, float param2, float param3, int param4, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2006 */   public static int callPI(long param0, int param1, int param2, int param3, int param4, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2007 */   public static int callPI(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2008 */   public static int callPI(int param0, long param1, int param2, int param3, float param4, int param5, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2009 */   public static int callPI(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2010 */   public static int callPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2011 */   public static int callPI(int param0, int param1, long param2, int param3, int param4, int param5, int param6, float param7, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2012 */   public static int callPI(long param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, long __functionAddress) { return jni.callPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2013 */   public static int callPJI(long param0, long param1, long __functionAddress) { return jni.callPJI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2014 */   public static int callPPI(long param0, long param1, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2015 */   public static int callPJI(long param0, int param1, long param2, long __functionAddress) { return jni.callPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2016 */   public static int callPJI(long param0, long param1, float param2, long __functionAddress) { return jni.callPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2017 */   public static int callPJI(long param0, long param1, int param2, long __functionAddress) { return jni.callPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2018 */   public static int callPPI(int param0, long param1, long param2, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2019 */   public static int callPPI(long param0, float param1, long param2, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2020 */   public static int callPPI(long param0, int param1, long param2, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2021 */   public static int callPPI(long param0, long param1, float param2, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2022 */   public static int callPPI(long param0, long param1, int param2, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2023 */   public static int callPPI(int param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2024 */   public static int callPPI(long param0, int param1, float param2, long param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2025 */   public static int callPPI(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2026 */   public static int callPPI(long param0, int param1, long param2, int param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2027 */   public static int callPPI(long param0, long param1, float param2, float param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2028 */   public static int callPPI(long param0, long param1, float param2, int param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2029 */   public static int callPPI(long param0, long param1, int param2, int param3, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2030 */   public static int callPPI(long param0, int param1, float param2, float param3, long param4, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2031 */   public static int callPPI(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2032 */   public static int callPPI(long param0, int param1, int param2, long param3, int param4, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2033 */   public static int callPPI(long param0, long param1, int param2, int param3, int param4, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2034 */   public static int callPPI(long param0, long param1, int param2, int param3, boolean param4, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2035 */   public static int callPPI(int param0, long param1, int param2, int param3, float param4, long param5, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2036 */   public static int callPPI(long param0, int param1, float param2, float param3, float param4, long param5, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2037 */   public static int callPPI(long param0, long param1, int param2, int param3, int param4, int param5, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2038 */   public static int callPPI(long param0, int param1, float param2, float param3, float param4, int param5, long param6, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2039 */   public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2040 */   public static int callPPI(long param0, int param1, float param2, float param3, float param4, float param5, int param6, long param7, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2041 */   public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2042 */   public static int callPPI(int param0, int param1, long param2, long param3, int param4, int param5, int param6, int param7, float param8, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2043 */   public static int callPPI(long param0, int param1, float param2, float param3, float param4, float param5, float param6, int param7, long param8, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2044 */   public static int callPPI(long param0, int param1, int param2, float param3, float param4, float param5, float param6, float param7, int param8, long param9, int param10, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2045 */   public static int callPPI(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, long __functionAddress) { return jni.callPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16); }
/* 2046 */   public static int callPJJI(long param0, long param1, long param2, long __functionAddress) { return jni.callPJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2047 */   public static int callPJPI(long param0, long param1, long param2, long __functionAddress) { return jni.callPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2048 */   public static int callPPJI(long param0, long param1, long param2, long __functionAddress) { return jni.callPPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2049 */   public static int callPPPI(long param0, long param1, long param2, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2050 */   public static int callPJJI(long param0, long param1, long param2, float param3, long __functionAddress) { return jni.callPJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2051 */   public static int callPJJI(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.callPJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2052 */   public static int callPJPI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2053 */   public static int callPJPI(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.callPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2054 */   public static int callPPJI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2055 */   public static int callPPJI(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.callPPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2056 */   public static int callPPNI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPPNI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2057 */   public static int callPPPI(int param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2058 */   public static int callPPPI(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2059 */   public static int callPPPI(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2060 */   public static int callPPPI(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2061 */   public static int callPJJI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { return jni.callPJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2062 */   public static int callPJPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { return jni.callPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2063 */   public static int callPPJI(long param0, int param1, long param2, int param3, long param4, long __functionAddress) { return jni.callPPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2064 */   public static int callPPPI(int param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2065 */   public static int callPPPI(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2066 */   public static int callPPPI(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2067 */   public static int callPPPI(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2068 */   public static int callPPPI(long param0, long param1, long param2, int param3, int param4, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2069 */   public static int callPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2070 */   public static int callPPPI(long param0, int param1, int param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2071 */   public static int callPPPI(long param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2072 */   public static int callPPPI(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2073 */   public static int callPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2074 */   public static int callPPPI(long param0, float param1, float param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2075 */   public static int callPPPI(long param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2076 */   public static int callPPPI(long param0, int param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2077 */   public static int callPPPI(long param0, long param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { return jni.callPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2078 */   public static int callJPPI(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.callJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2079 */   public static int callJJPPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callJJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2080 */   public static int callPJJJI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPJJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2081 */   public static int callPJJPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPJJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2082 */   public static int callPJPPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2083 */   public static int callPPJPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2084 */   public static int callPPNPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPNPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2085 */   public static int callPPPPI(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2086 */   public static int callPJJJI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPJJJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2087 */   public static int callPJPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2088 */   public static int callPPPPI(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2089 */   public static int callPPPPI(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2090 */   public static int callPPPPI(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2091 */   public static int callPPPPI(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2092 */   public static int callPJPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2093 */   public static int callPPPPI(int param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2094 */   public static int callPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2095 */   public static int callPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2096 */   public static int callPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2097 */   public static int callPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2098 */   public static int callPPPPI(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2099 */   public static int callPPPPI(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2100 */   public static int callPPPPI(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2101 */   public static int callPPPPI(long param0, long param1, long param2, int param3, long param4, int param5, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2102 */   public static int callPJPPI(long param0, long param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2103 */   public static int callPPPPI(long param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2104 */   public static int callPPPPI(long param0, int param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2105 */   public static int callPPPPI(long param0, long param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2106 */   public static int callPPPPI(int param0, long param1, long param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, int param17, int param18, int param19, int param20, long param21, long param22, long __functionAddress) { return jni.callPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16, param17, param18, param19, param20, param21, param22); }
/* 2107 */   public static int callPJJPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPJJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2108 */   public static int callPJPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPJPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2109 */   public static int callPPJPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2110 */   public static int callPPPPPI(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2111 */   public static int callPJJJPI(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPJJJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2112 */   public static int callPJPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPJPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2113 */   public static int callPPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2114 */   public static int callPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2115 */   public static int callPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2116 */   public static int callPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2117 */   public static int callPPJPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2118 */   public static int callPPJPPI(long param0, long param1, int param2, long param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2119 */   public static int callPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2120 */   public static int callPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2121 */   public static int callPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2122 */   public static int callPPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2123 */   public static int callJPPPPI(int param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.callJPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2124 */   public static int callPJPPJI(long param0, long param1, int param2, int param3, long param4, long param5, long param6, int param7, long __functionAddress) { return jni.callPJPPJI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2125 */   public static int callPPPPPI(long param0, int param1, long param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2126 */   public static int callPJJJJPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPJJJJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2127 */   public static int callPPPPJPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPJPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2128 */   public static int callPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2129 */   public static int callPJJPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPJJPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2130 */   public static int callPJPPPPI(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPJPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2131 */   public static int callPPPJPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long __functionAddress) { return jni.callPPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2132 */   public static int callPPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2133 */   public static int callPJPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.callPJPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2134 */   public static int callPPPJPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.callPPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2135 */   public static int callPPPPPPI(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2136 */   public static int callPPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2137 */   public static int callPPPPPPI(long param0, int param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2138 */   public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2139 */   public static int callPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2140 */   public static int callPPPPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2141 */   public static int callPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2142 */   public static int callPPPPPPPI(long param0, int param1, long param2, int param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2143 */   public static int callPPPPPPPI(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2144 */   public static int callPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2145 */   public static int callPPPPPPPI(long param0, long param1, long param2, int param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2146 */   public static int callPPPPPJPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPJPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2147 */   public static int callPPJPPPPPI(long param0, long param1, long param2, long param3, long param4, int param5, long param6, long param7, long param8, long __functionAddress) { return jni.callPPJPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2148 */   public static int callPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2149 */   public static int callPPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, int param7, long param8, long param9, long __functionAddress) { return jni.callPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2150 */   public static int callPPPPPPPPI(long param0, int param1, int param2, long param3, long param4, long param5, long param6, int param7, long param8, long param9, long param10, long __functionAddress) { return jni.callPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2151 */   public static int callPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, int param6, long param7, long param8, long param9, long __functionAddress) { return jni.callPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2152 */   public static int callPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long __functionAddress) { return jni.callPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2153 */   public static int callPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, int param7, long param8, long param9, long param10, long __functionAddress) { return jni.callPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2154 */   public static int callPPPPPPPPPPI(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) { return jni.callPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2155 */   public static int callPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) { return jni.callPPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2156 */   public static int callPPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, int param10, long param11, long param12, long __functionAddress) { return jni.callPPPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12); }
/* 2157 */   public static int callPPPPPPPPPPPPI(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, int param11, long param12, long param13, long __functionAddress) { return jni.callPPPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13); }
/* 2158 */   public static int callPPPPPPPPPPPPPPPI(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long param11, int param12, long param13, long param14, long param15, long __functionAddress) { return jni.callPPPPPPPPPPPPPPPI(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15); }
/* 2159 */   public static long callJ(long __functionAddress) { return jni.callJ(MemorySegment.ofAddress(__functionAddress)); }
/* 2160 */   public static long callJ(int param0, long __functionAddress) { return jni.callJ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2161 */   public static long callJ(int param0, int param1, long __functionAddress) { return jni.callJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2162 */   public static long callJ(int param0, int param1, boolean param2, int param3, int param4, long __functionAddress) { return jni.callJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2163 */   public static long callPJ(long param0, int param1, long __functionAddress) { return jni.callPJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2164 */   public static long callPPJ(long param0, long param1, long __functionAddress) { return jni.callPPJ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2165 */   public static long callPJJ(long param0, long param1, int param2, int param3, long __functionAddress) { return jni.callPJJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2166 */   public static long callPJJJ(long param0, long param1, long param2, long __functionAddress) { return jni.callPJJJ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2167 */   public static long callPN(long param0, long __functionAddress) { return jni.callPN(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2168 */   public static long callP(long __functionAddress) { return jni.callP(MemorySegment.ofAddress(__functionAddress)); }
/* 2169 */   public static long callP(int param0, long __functionAddress) { return jni.callP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2170 */   public static long callP(int param0, int param1, long __functionAddress) { return jni.callP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2171 */   public static long callP(int param0, float param1, float param2, float param3, long __functionAddress) { return jni.callP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2172 */   public static long callJP(long param0, long __functionAddress) { return jni.callJP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2173 */   public static long callPP(long param0, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2174 */   public static long callPP(int param0, long param1, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2175 */   public static long callPP(long param0, int param1, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2176 */   public static long callPP(int param0, int param1, long param2, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2177 */   public static long callPP(int param0, long param1, int param2, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2178 */   public static long callPP(long param0, int param1, int param2, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2179 */   public static long callPP(int param0, int param1, long param2, int param3, long __functionAddress) { return jni.callPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2180 */   public static long callJJP(long param0, long param1, long __functionAddress) { return jni.callJJP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2181 */   public static long callPNP(long param0, long param1, long __functionAddress) { return jni.callPNP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2182 */   public static long callPPP(long param0, long param1, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2183 */   public static long callPPP(int param0, long param1, long param2, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2184 */   public static long callPPP(long param0, int param1, long param2, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2185 */   public static long callPPP(long param0, long param1, int param2, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2186 */   public static long callPPP(int param0, long param1, long param2, int param3, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2187 */   public static long callPPP(long param0, int param1, int param2, long param3, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2188 */   public static long callPPP(int param0, int param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2189 */   public static long callPPP(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2190 */   public static long callPPP(long param0, long param1, int param2, int param3, int param4, long __functionAddress) { return jni.callPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2191 */   public static long callPPNP(long param0, long param1, long param2, long __functionAddress) { return jni.callPPNP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2192 */   public static long callPPPP(long param0, long param1, long param2, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2193 */   public static long callPJPP(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.callPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2194 */   public static long callPJPP(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.callPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2195 */   public static long callPPPP(int param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2196 */   public static long callPPPP(long param0, int param1, long param2, long param3, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2197 */   public static long callPPPP(long param0, long param1, int param2, long param3, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2198 */   public static long callPPPP(long param0, long param1, long param2, int param3, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2199 */   public static long callPPPP(long param0, long param1, int param2, int param3, long param4, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2200 */   public static long callPPPP(long param0, long param1, int param2, long param3, int param4, long __functionAddress) { return jni.callPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2201 */   public static long callPJPP(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) { return jni.callPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2202 */   public static long callJJPPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callJJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2203 */   public static long callPPJPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2204 */   public static long callPPNPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPNPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2205 */   public static long callPPPPP(long param0, long param1, long param2, long param3, long __functionAddress) { return jni.callPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2206 */   public static long callPJPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2207 */   public static long callPJPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { return jni.callPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2208 */   public static long callPPPPP(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2209 */   public static long callPPPPP(long param0, long param1, int param2, long param3, long param4, long __functionAddress) { return jni.callPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2210 */   public static long callPPPPP(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { return jni.callPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2211 */   public static long callPPPPP(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { return jni.callPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2212 */   public static long callPJPPP(long param0, long param1, int param2, int param3, long param4, long param5, long __functionAddress) { return jni.callPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2213 */   public static long callPJPPPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPJPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2214 */   public static long callPPPJPP(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPPPJPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2215 */   public static long callPPPPPP(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2216 */   public static long callPPPPPP(long param0, long param1, long param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2217 */   public static long callPPPPPP(long param0, int param1, int param2, long param3, int param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2218 */   public static long callPJJPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPJJPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2219 */   public static long callPJPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPJPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2220 */   public static long callPPJPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPJPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2221 */   public static long callPPPJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPPPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2222 */   public static long callPPPPPPP(long param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2223 */   public static long callPPJPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPJPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2224 */   public static long callPPPPJPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { return jni.callPPPPJPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2225 */   public static long callPPPPPPPP(long param0, int param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) { return jni.callPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2226 */   public static long callPPPPPPPP(int param0, long param1, long param2, int param3, int param4, int param5, int param6, long param7, long param8, long param9, int param10, long param11, long param12, long __functionAddress) { return jni.callPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12); }
/* 2227 */   public static long callPJPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long __functionAddress) { return jni.callPJPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2228 */   public static long callPPJPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, int param6, long param7, long param8, long param9, long __functionAddress) { return jni.callPPJPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2229 */   public static long callPJPPPPPPPPP(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long __functionAddress) { return jni.callPJPPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2230 */   public static long callPPJPPPPPPPP(long param0, long param1, int param2, long param3, long param4, long param5, long param6, long param7, int param8, long param9, long param10, long param11, long __functionAddress) { return jni.callPPJPPPPPPPP(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2231 */   public static short callS(int param0, long __functionAddress) { return jni.callS(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2232 */   public static short callPS(long param0, long __functionAddress) { return jni.callPS(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2233 */   public static short callPCS(long param0, short param1, long __functionAddress) { return jni.callPCS(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2234 */   public static short callPPS(long param0, long param1, long __functionAddress) { return jni.callPPS(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2235 */   public static short callPSS(long param0, short param1, long __functionAddress) { return jni.callPSS(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2236 */   public static short callSPS(short param0, long param1, long __functionAddress) { return jni.callSPS(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2237 */   public static short callPPS(long param0, long param1, int param2, long __functionAddress) { return jni.callPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2238 */   public static short callPPS(long param0, int param1, long param2, int param3, long __functionAddress) { return jni.callPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2239 */   public static short callPCPS(long param0, short param1, long param2, long __functionAddress) { return jni.callPCPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2240 */   public static short callPPCS(long param0, long param1, short param2, long __functionAddress) { return jni.callPPCS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2241 */   public static short callPPPS(long param0, long param1, long param2, long __functionAddress) { return jni.callPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2242 */   public static short callPPSS(long param0, long param1, short param2, long __functionAddress) { return jni.callPPSS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2243 */   public static short callPSPS(long param0, short param1, long param2, long __functionAddress) { return jni.callPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2244 */   public static short callSPPS(short param0, long param1, long param2, long __functionAddress) { return jni.callSPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2245 */   public static short callSPSS(short param0, long param1, short param2, long __functionAddress) { return jni.callSPSS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2246 */   public static short callPPPS(long param0, int param1, long param2, int param3, long param4, long __functionAddress) { return jni.callPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2247 */   public static short callPJCCS(long param0, long param1, short param2, short param3, long __functionAddress) { return jni.callPJCCS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2248 */   public static short callPPSPS(long param0, long param1, short param2, long param3, long __functionAddress) { return jni.callPPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2249 */   public static short callPSSPS(long param0, short param1, short param2, long param3, int param4, long __functionAddress) { return jni.callPSSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2250 */   public static short callPPPPS(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2251 */   public static short callPCPPPS(long param0, short param1, long param2, long param3, long param4, long __functionAddress) { return jni.callPCPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2252 */   public static short callPCPSPS(long param0, short param1, long param2, short param3, long param4, long __functionAddress) { return jni.callPCPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2253 */   public static short callPSSPPS(long param0, short param1, short param2, long param3, int param4, long param5, long __functionAddress) { return jni.callPSSPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2254 */   public static short callPCPPPPS(long param0, short param1, long param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPCPPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2255 */   public static short callPCSPPPS(long param0, short param1, short param2, long param3, long param4, long param5, long __functionAddress) { return jni.callPCSPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2256 */   public static short callPPSPSPS(long param0, long param1, short param2, long param3, short param4, long param5, long __functionAddress) { return jni.callPPSPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2257 */   public static short callPCCPSPPS(long param0, short param1, short param2, long param3, short param4, long param5, long param6, long __functionAddress) { return jni.callPCCPSPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2258 */   public static short callPPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long __functionAddress) { return jni.callPPSPSPSS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2259 */   public static short callSPSSPSPS(short param0, long param1, short param2, short param3, long param4, short param5, long param6, long __functionAddress) { return jni.callSPSSPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2260 */   public static short callPCPSPPSPS(long param0, short param1, long param2, short param3, long param4, long param5, short param6, long param7, long __functionAddress) { return jni.callPCPSPPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2261 */   public static short callPPPSPSPCS(long param0, long param1, long param2, short param3, long param4, short param5, long param6, short param7, long __functionAddress) { return jni.callPPPSPSPCS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2262 */   public static short callSPSPPPSPS(short param0, long param1, short param2, long param3, long param4, long param5, short param6, long param7, long __functionAddress) { return jni.callSPSPPPSPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2263 */   public static short callPCPSPPPPPS(long param0, short param1, long param2, short param3, long param4, long param5, long param6, long param7, long param8, long __functionAddress) { return jni.callPCPSPPPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2264 */   public static short callPPSPSPSCCS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, short param7, short param8, long __functionAddress) { return jni.callPPSPSPSCCS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2265 */   public static short callPPSPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long param7, short param8, long __functionAddress) { return jni.callPPSPSPSPSS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2266 */   public static short callPCPSPSPSCCS(long param0, short param1, long param2, short param3, long param4, short param5, long param6, short param7, short param8, short param9, long __functionAddress) { return jni.callPCPSPSPSCCS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2267 */   public static short callPCSSSPSPPPS(long param0, short param1, short param2, short param3, short param4, long param5, short param6, long param7, long param8, long param9, long __functionAddress) { return jni.callPCSSSPSPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2268 */   public static short callPSSSPSSPPPS(long param0, short param1, short param2, short param3, long param4, short param5, short param6, long param7, long param8, long param9, long __functionAddress) { return jni.callPSSSPSSPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2269 */   public static short callPSPSPPPPPPPS(long param0, short param1, long param2, short param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long __functionAddress) { return jni.callPSPSPPPPPPPS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2270 */   public static short callPPSPSPSPSPSPSS(long param0, long param1, short param2, long param3, short param4, long param5, short param6, long param7, short param8, long param9, short param10, long param11, short param12, long __functionAddress) { return jni.callPPSPSPSPSPSPSS(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12); }
/* 2271 */   public static void callV(long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress)); }
/* 2272 */   public static void callV(double param0, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2273 */   public static void callV(float param0, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2274 */   public static void callV(int param0, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2275 */   public static void callV(boolean param0, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2276 */   public static void callV(double param0, double param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2277 */   public static void callV(float param0, float param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2278 */   public static void callV(float param0, boolean param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2279 */   public static void callV(int param0, double param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2280 */   public static void callV(int param0, float param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2281 */   public static void callV(int param0, int param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2282 */   public static void callV(int param0, boolean param1, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2283 */   public static void callV(double param0, double param1, double param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2284 */   public static void callV(float param0, float param1, float param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2285 */   public static void callV(int param0, double param1, double param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2286 */   public static void callV(int param0, float param1, float param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2287 */   public static void callV(int param0, int param1, double param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2288 */   public static void callV(int param0, int param1, float param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2289 */   public static void callV(int param0, int param1, int param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2290 */   public static void callV(int param0, int param1, boolean param2, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2291 */   public static void callV(double param0, double param1, double param2, double param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2292 */   public static void callV(float param0, float param1, float param2, float param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2293 */   public static void callV(int param0, double param1, double param2, double param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2294 */   public static void callV(int param0, float param1, float param2, float param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2295 */   public static void callV(int param0, int param1, double param2, double param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2296 */   public static void callV(int param0, int param1, float param2, float param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2297 */   public static void callV(int param0, int param1, float param2, int param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2298 */   public static void callV(int param0, int param1, int param2, double param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2299 */   public static void callV(int param0, int param1, int param2, float param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2300 */   public static void callV(int param0, int param1, int param2, int param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2301 */   public static void callV(int param0, int param1, int param2, boolean param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2302 */   public static void callV(int param0, int param1, boolean param2, int param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2303 */   public static void callV(boolean param0, boolean param1, boolean param2, boolean param3, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2304 */   public static void callV(int param0, double param1, double param2, double param3, double param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2305 */   public static void callV(int param0, float param1, float param2, float param3, float param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2306 */   public static void callV(int param0, int param1, double param2, double param3, double param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2307 */   public static void callV(int param0, int param1, float param2, float param3, float param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2308 */   public static void callV(int param0, int param1, int param2, float param3, int param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2309 */   public static void callV(int param0, int param1, int param2, int param3, int param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2310 */   public static void callV(int param0, int param1, int param2, boolean param3, int param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2311 */   public static void callV(int param0, boolean param1, boolean param2, boolean param3, boolean param4, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2312 */   public static void callV(double param0, double param1, double param2, double param3, double param4, double param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2313 */   public static void callV(int param0, double param1, double param2, int param3, double param4, double param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2314 */   public static void callV(int param0, float param1, float param2, int param3, float param4, float param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2315 */   public static void callV(int param0, int param1, double param2, double param3, double param4, double param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2316 */   public static void callV(int param0, int param1, float param2, float param3, float param4, float param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2317 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2318 */   public static void callV(int param0, int param1, int param2, int param3, int param4, boolean param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2319 */   public static void callV(int param0, int param1, int param2, int param3, boolean param4, int param5, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2320 */   public static void callV(int param0, double param1, double param2, double param3, double param4, double param5, double param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2321 */   public static void callV(int param0, int param1, int param2, double param3, double param4, double param5, double param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2322 */   public static void callV(int param0, int param1, int param2, float param3, float param4, float param5, float param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2323 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2324 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, boolean param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2325 */   public static void callV(int param0, int param1, int param2, boolean param3, int param4, int param5, int param6, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2326 */   public static void callV(float param0, float param1, float param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2327 */   public static void callV(int param0, int param1, int param2, float param3, float param4, float param5, float param6, float param7, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2328 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2329 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, boolean param7, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2330 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2331 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, boolean param8, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2332 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2333 */   public static void callV(int param0, int param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2334 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2335 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14); }
/* 2336 */   public static void callV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, long __functionAddress) { jni.callV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16); }
/* 2337 */   public static void callJV(long param0, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2338 */   public static void callPV(long param0, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2339 */   public static void callSV(short param0, long __functionAddress) { jni.callSV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2340 */   public static void callUV(byte param0, long __functionAddress) { jni.callUV(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2341 */   public static void callCV(int param0, short param1, long __functionAddress) { jni.callCV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2342 */   public static void callJV(int param0, long param1, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2343 */   public static void callJV(long param0, int param1, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2344 */   public static void callPV(int param0, long param1, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2345 */   public static void callPV(long param0, float param1, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2346 */   public static void callPV(long param0, int param1, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2347 */   public static void callSV(int param0, short param1, long __functionAddress) { jni.callSV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2348 */   public static void callJV(int param0, int param1, long param2, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2349 */   public static void callPV(int param0, int param1, long param2, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2350 */   public static void callPV(int param0, long param1, int param2, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2351 */   public static void callPV(long param0, float param1, float param2, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2352 */   public static void callPV(long param0, int param1, int param2, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2353 */   public static void callJV(int param0, long param1, int param2, int param3, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2354 */   public static void callNV(long param0, int param1, int param2, int param3, long __functionAddress) { jni.callNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2355 */   public static void callPV(int param0, int param1, int param2, long param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2356 */   public static void callPV(int param0, int param1, long param2, int param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2357 */   public static void callPV(int param0, int param1, boolean param2, long param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2358 */   public static void callPV(int param0, long param1, int param2, int param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2359 */   public static void callPV(long param0, float param1, float param2, float param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2360 */   public static void callPV(long param0, int param1, int param2, int param3, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2361 */   public static void callPV(int param0, int param1, int param2, int param3, long param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2362 */   public static void callPV(int param0, int param1, int param2, long param3, int param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2363 */   public static void callPV(int param0, int param1, int param2, long param3, boolean param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2364 */   public static void callPV(int param0, int param1, int param2, boolean param3, long param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2365 */   public static void callPV(int param0, int param1, long param2, int param3, int param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2366 */   public static void callPV(int param0, long param1, int param2, int param3, int param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2367 */   public static void callPV(int param0, boolean param1, int param2, int param3, long param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2368 */   public static void callPV(long param0, int param1, int param2, int param3, int param4, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2369 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2370 */   public static void callPV(int param0, double param1, double param2, int param3, int param4, long param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2371 */   public static void callPV(int param0, float param1, float param2, int param3, int param4, long param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2372 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2373 */   public static void callPV(int param0, int param1, int param2, int param3, long param4, boolean param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2374 */   public static void callPV(int param0, int param1, int param2, long param3, int param4, int param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2375 */   public static void callPV(int param0, int param1, int param2, boolean param3, int param4, long param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2376 */   public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2377 */   public static void callPV(int param0, boolean param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2378 */   public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2379 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2380 */   public static void callPV(int param0, int param1, float param2, float param3, float param4, float param5, long param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2381 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2382 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, long param5, int param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2383 */   public static void callPV(int param0, int param1, int param2, long param3, int param4, int param5, int param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2384 */   public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2385 */   public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, int param6, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2386 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2387 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, boolean param5, int param6, long param7, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2388 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2389 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, boolean param5, int param6, long param7, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2390 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, boolean param6, int param7, long param8, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2391 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, long param8, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2392 */   public static void callPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, int param7, float param8, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2393 */   public static void callPV(int param0, double param1, double param2, int param3, int param4, double param5, double param6, int param7, int param8, long param9, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2394 */   public static void callPV(int param0, float param1, float param2, int param3, int param4, float param5, float param6, int param7, int param8, long param9, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2395 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, long param9, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2396 */   public static void callJV(long param0, int param1, float param2, float param3, float param4, float param5, float param6, float param7, float param8, float param9, float param10, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2397 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long param10, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2398 */   public static void callPV(long param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2399 */   public static void callJV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, long param10, boolean param11, long __functionAddress) { jni.callJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2400 */   public static void callPV(int param0, int param1, int param2, int param3, int param4, int param5, int param6, int param7, int param8, int param9, int param10, long param11, long __functionAddress) { jni.callPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11); }
/* 2401 */   public static void callPJV(long param0, long param1, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2402 */   public static void callPPV(long param0, long param1, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2403 */   public static void callSSV(short param0, short param1, long __functionAddress) { jni.callSSV(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2404 */   public static void callJJV(int param0, long param1, long param2, long __functionAddress) { jni.callJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2405 */   public static void callPCV(long param0, int param1, short param2, long __functionAddress) { jni.callPCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2406 */   public static void callPJV(long param0, int param1, long param2, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2407 */   public static void callPJV(long param0, long param1, float param2, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2408 */   public static void callPJV(long param0, long param1, int param2, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2409 */   public static void callPPV(int param0, long param1, long param2, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2410 */   public static void callPPV(long param0, int param1, long param2, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2411 */   public static void callPPV(long param0, long param1, int param2, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2412 */   public static void callSSV(int param0, short param1, short param2, long __functionAddress) { jni.callSSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2413 */   public static void callJJV(int param0, int param1, long param2, long param3, long __functionAddress) { jni.callJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2414 */   public static void callJPV(int param0, int param1, long param2, long param3, long __functionAddress) { jni.callJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2415 */   public static void callJPV(int param0, long param1, int param2, long param3, long __functionAddress) { jni.callJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2416 */   public static void callPJV(int param0, long param1, int param2, long param3, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2417 */   public static void callPJV(long param0, int param1, long param2, int param3, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2418 */   public static void callPJV(long param0, long param1, int param2, int param3, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2419 */   public static void callPPV(int param0, int param1, long param2, long param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2420 */   public static void callPPV(int param0, long param1, int param2, long param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2421 */   public static void callPPV(int param0, long param1, long param2, int param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2422 */   public static void callPPV(int param0, long param1, long param2, boolean param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2423 */   public static void callPPV(long param0, int param1, int param2, long param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2424 */   public static void callPPV(long param0, long param1, int param2, int param3, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2425 */   public static void callPJV(long param0, long param1, int param2, int param3, int param4, long __functionAddress) { jni.callPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2426 */   public static void callPPV(int param0, int param1, int param2, long param3, long param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2427 */   public static void callPPV(int param0, int param1, long param2, int param3, long param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2428 */   public static void callPPV(int param0, int param1, long param2, long param3, int param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2429 */   public static void callPPV(int param0, long param1, int param2, long param3, int param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2430 */   public static void callPPV(int param0, long param1, long param2, int param3, int param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2431 */   public static void callPPV(long param0, int param1, int param2, int param3, long param4, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2432 */   public static void callPPV(int param0, int param1, int param2, int param3, long param4, long param5, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2433 */   public static void callPPV(int param0, int param1, long param2, int param3, int param4, long param5, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2434 */   public static void callPPV(int param0, int param1, long param2, long param3, int param4, int param5, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2435 */   public static void callPPV(int param0, long param1, long param2, int param3, int param4, int param5, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2436 */   public static void callPPV(long param0, int param1, long param2, int param3, int param4, int param5, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2437 */   public static void callPPV(int param0, int param1, int param2, int param3, int param4, long param5, long param6, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2438 */   public static void callPPV(int param0, int param1, int param2, long param3, int param4, int param5, long param6, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2439 */   public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2440 */   public static void callPPV(int param0, int param1, long param2, long param3, int param4, int param5, int param6, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2441 */   public static void callPPV(int param0, int param1, int param2, int param3, int param4, int param5, long param6, long param7, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2442 */   public static void callPPV(int param0, int param1, int param2, int param3, long param4, int param5, int param6, long param7, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2443 */   public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, long param7, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2444 */   public static void callPPV(int param0, int param1, int param2, long param3, int param4, float param5, float param6, int param7, long param8, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2445 */   public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, int param6, int param7, long param8, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2446 */   public static void callPPV(int param0, int param1, long param2, int param3, int param4, int param5, long param6, int param7, int param8, float param9, long __functionAddress) { jni.callPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2447 */   public static void callBBBV(byte param0, byte param1, byte param2, long __functionAddress) { jni.callBBBV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2448 */   public static void callCCCV(short param0, short param1, short param2, long __functionAddress) { jni.callCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2449 */   public static void callPJJV(long param0, long param1, long param2, long __functionAddress) { jni.callPJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2450 */   public static void callPJPV(long param0, long param1, long param2, long __functionAddress) { jni.callPJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2451 */   public static void callPPNV(long param0, long param1, long param2, long __functionAddress) { jni.callPPNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2452 */   public static void callPPPV(long param0, long param1, long param2, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2453 */   public static void callSSSV(short param0, short param1, short param2, long __functionAddress) { jni.callSSSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2454 */   public static void callUUUV(byte param0, byte param1, byte param2, long __functionAddress) { jni.callUUUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2455 */   public static void callJJJV(int param0, long param1, long param2, long param3, long __functionAddress) { jni.callJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2456 */   public static void callPJJV(long param0, long param1, long param2, int param3, long __functionAddress) { jni.callPJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2457 */   public static void callPJPV(long param0, long param1, int param2, long param3, long __functionAddress) { jni.callPJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2458 */   public static void callPPPV(int param0, long param1, long param2, long param3, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2459 */   public static void callPPPV(long param0, int param1, long param2, long param3, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2460 */   public static void callPPPV(long param0, long param1, int param2, long param3, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2461 */   public static void callPPPV(long param0, long param1, long param2, int param3, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2462 */   public static void callSSSV(int param0, short param1, short param2, short param3, long __functionAddress) { jni.callSSSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2463 */   public static void callJJJV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.callJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2464 */   public static void callPJJV(long param0, int param1, long param2, long param3, int param4, long __functionAddress) { jni.callPJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2465 */   public static void callPJJV(long param0, long param1, long param2, int param3, int param4, long __functionAddress) { jni.callPJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2466 */   public static void callPPPV(int param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2467 */   public static void callPPPV(int param0, long param1, int param2, long param3, long param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2468 */   public static void callPPPV(int param0, long param1, long param2, int param3, long param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2469 */   public static void callPPPV(int param0, long param1, long param2, long param3, int param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2470 */   public static void callPPPV(long param0, int param1, int param2, long param3, long param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2471 */   public static void callPPPV(long param0, int param1, long param2, int param3, long param4, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2472 */   public static void callPJPV(long param0, int param1, long param2, int param3, int param4, long param5, long __functionAddress) { jni.callPJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2473 */   public static void callPJPV(long param0, long param1, int param2, int param3, int param4, long param5, long __functionAddress) { jni.callPJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2474 */   public static void callPPJV(int param0, long param1, long param2, int param3, long param4, boolean param5, long __functionAddress) { jni.callPPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2475 */   public static void callPPJV(long param0, int param1, long param2, int param3, long param4, int param5, long __functionAddress) { jni.callPPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2476 */   public static void callPPPV(int param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2477 */   public static void callPPPV(int param0, int param1, long param2, int param3, long param4, long param5, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2478 */   public static void callPPPV(int param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2479 */   public static void callPJJV(long param0, int param1, int param2, long param3, long param4, int param5, int param6, long __functionAddress) { jni.callPJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2480 */   public static void callPPPV(int param0, int param1, int param2, int param3, long param4, long param5, long param6, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2481 */   public static void callPPPV(int param0, int param1, long param2, long param3, int param4, int param5, long param6, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2482 */   public static void callPPPV(long param0, int param1, long param2, int param3, int param4, int param5, long param6, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2483 */   public static void callPPPV(int param0, int param1, int param2, int param3, long param4, int param5, long param6, long param7, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2484 */   public static void callPPPV(long param0, int param1, int param2, int param3, int param4, int param5, long param6, long param7, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2485 */   public static void callPPPV(long param0, long param1, int param2, int param3, int param4, int param5, int param6, int param7, long param8, int param9, int param10, int param11, int param12, int param13, int param14, int param15, int param16, int param17, long __functionAddress) { jni.callPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14, param15, param16, param17); }
/* 2486 */   public static void callBBBBV(byte param0, byte param1, byte param2, byte param3, long __functionAddress) { jni.callBBBBV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2487 */   public static void callCCCCV(short param0, short param1, short param2, short param3, long __functionAddress) { jni.callCCCCV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2488 */   public static void callPJJJV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.callPJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2489 */   public static void callPJJPV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2490 */   public static void callPJPPV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.callPJPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2491 */   public static void callPPPNV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.callPPPNV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2492 */   public static void callPPPPV(long param0, long param1, long param2, long param3, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2493 */   public static void callSSSSV(short param0, short param1, short param2, short param3, long __functionAddress) { jni.callSSSSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2494 */   public static void callUUUUV(byte param0, byte param1, byte param2, byte param3, long __functionAddress) { jni.callUUUUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2495 */   public static void callJJJJV(int param0, long param1, long param2, long param3, long param4, long __functionAddress) { jni.callJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2496 */   public static void callPJJJV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { jni.callPJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2497 */   public static void callPJJPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2498 */   public static void callPJJPV(long param0, long param1, long param2, int param3, long param4, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2499 */   public static void callPPPPV(long param0, int param1, long param2, long param3, long param4, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2500 */   public static void callPPPPV(long param0, long param1, long param2, long param3, int param4, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2501 */   public static void callSSSSV(int param0, short param1, short param2, short param3, short param4, long __functionAddress) { jni.callSSSSV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2502 */   public static void callUUUUV(int param0, byte param1, byte param2, byte param3, byte param4, long __functionAddress) { jni.callUUUUV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2503 */   public static void callJJJJV(int param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.callJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2504 */   public static void callPJJJV(long param0, long param1, long param2, long param3, int param4, int param5, long __functionAddress) { jni.callPJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2505 */   public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2506 */   public static void callPJJPV(long param0, long param1, long param2, int param3, int param4, long param5, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2507 */   public static void callPJPPV(long param0, long param1, int param2, long param3, int param4, long param5, long __functionAddress) { jni.callPJPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2508 */   public static void callPPPPV(int param0, long param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2509 */   public static void callPPPPV(int param0, long param1, long param2, long param3, long param4, int param5, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2510 */   public static void callPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2511 */   public static void callPJJPV(long param0, long param1, int param2, int param3, long param4, int param5, long param6, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2512 */   public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, int param5, long param6, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2513 */   public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, long param5, long param6, long __functionAddress) { jni.callPJPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2514 */   public static void callPPPPV(int param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2515 */   public static void callPPPPV(int param0, int param1, long param2, long param3, long param4, long param5, int param6, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2516 */   public static void callPJJPV(long param0, long param1, int param2, long param3, int param4, int param5, long param6, int param7, long __functionAddress) { jni.callPJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2517 */   public static void callPJPPV(long param0, int param1, long param2, int param3, int param4, long param5, int param6, long param7, long __functionAddress) { jni.callPJPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2518 */   public static void callPPPPV(long param0, int param1, int param2, int param3, int param4, long param5, int param6, long param7, int param8, long param9, long __functionAddress) { jni.callPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9); }
/* 2519 */   public static void callPJJJPV(long param0, long param1, long param2, long param3, long param4, long __functionAddress) { jni.callPJJJPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4); }
/* 2520 */   public static void callPPPPPV(long param0, int param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.callPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2521 */   public static void callPJJJJV(long param0, long param1, long param2, long param3, long param4, int param5, int param6, long __functionAddress) { jni.callPJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2522 */   public static void callPPPPPV(int param0, int param1, long param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.callPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2523 */   public static void callPPPPPV(long param0, int param1, int param2, long param3, long param4, long param5, long param6, long __functionAddress) { jni.callPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6); }
/* 2524 */   public static void callPJJJJV(long param0, long param1, int param2, int param3, long param4, long param5, long param6, int param7, long __functionAddress) { jni.callPJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2525 */   public static void callPJPPPV(long param0, int param1, int param2, long param3, long param4, int param5, long param6, long param7, long __functionAddress) { jni.callPJPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2526 */   public static void callPPPPPV(long param0, long param1, long param2, long param3, long param4, int param5, int param6, int param7, long __functionAddress) { jni.callPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2527 */   public static void callPPPPPV(long param0, int param1, long param2, int param3, int param4, int param5, long param6, int param7, long param8, int param9, long param10, long __functionAddress) { jni.callPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2528 */   public static void callPPPPPJV(long param0, long param1, long param2, long param3, long param4, long param5, long __functionAddress) { jni.callPPPPPJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5); }
/* 2529 */   public static void callPPPPPPV(long param0, long param1, long param2, int param3, int param4, long param5, long param6, long param7, long __functionAddress) { jni.callPPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7); }
/* 2530 */   public static void callPPPPPPPV(int param0, int param1, int param2, long param3, int param4, long param5, long param6, long param7, long param8, long param9, long param10, long __functionAddress) { jni.callPPPPPPPV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10); }
/* 2531 */   public static void callPPJJJJJJV(long param0, long param1, long param2, long param3, int param4, long param5, long param6, long param7, long param8, long __functionAddress) { jni.callPPJJJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8); }
/* 2532 */   public static void callPJJJJJJJJJJJV(long param0, long param1, long param2, long param3, long param4, long param5, long param6, long param7, long param8, long param9, long param10, long param11, int param12, int param13, int param14, long __functionAddress) { jni.callPJJJJJJJJJJJV(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7, param8, param9, param10, param11, param12, param13, param14); }
/* 2533 */   public static boolean callZ(int param0, long __functionAddress) { return jni.callZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2534 */   public static boolean callZ(int param0, int param1, long __functionAddress) { return jni.callZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2535 */   public static boolean callZ(int param0, float param1, float param2, long __functionAddress) { return jni.callZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2536 */   public static boolean callZ(int param0, int param1, float param2, float param3, long __functionAddress) { return jni.callZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3); }
/* 2537 */   public static boolean callJZ(long param0, long __functionAddress) { return jni.callJZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2538 */   public static boolean callPZ(long param0, long __functionAddress) { return jni.callPZ(MemorySegment.ofAddress(__functionAddress), param0); }
/* 2539 */   public static boolean callJZ(int param0, long param1, long __functionAddress) { return jni.callJZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2540 */   public static boolean callPZ(int param0, long param1, long __functionAddress) { return jni.callPZ(MemorySegment.ofAddress(__functionAddress), param0, param1); }
/* 2541 */   public static boolean callJZ(int param0, long param1, int param2, long __functionAddress) { return jni.callJZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); }
/* 2542 */   public static boolean callPPZ(int param0, long param1, long param2, long __functionAddress) { return jni.callPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2); } public static boolean callPPPPZ(int param0, int param1, int param2, float param3, long param4, long param5, long param6, long param7, long __functionAddress) {
/* 2543 */     return jni.callPPPPZ(MemorySegment.ofAddress(__functionAddress), param0, param1, param2, param3, param4, param5, param6, param7);
/*      */   }
/*      */   
/*      */   public static native short invokeUPC(byte paramByte, short[] paramArrayOfshort, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native short invokeCPCC(short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong);
/*      */   
/*      */   public static native int invokeCPI(short paramShort, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int invokePCI(float[] paramArrayOffloat, short paramShort, long paramLong);
/*      */   
/*      */   public static native int invokePPI(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int invokePPI(int paramInt1, int[] paramArrayOfint1, int paramInt2, int[] paramArrayOfint2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native int invokePPI(int paramInt1, short[] paramArrayOfshort1, int paramInt2, short[] paramArrayOfshort2, int paramInt3, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native int invokeCPUI(short paramShort, float[] paramArrayOffloat, byte paramByte, long paramLong);
/*      */   
/*      */   public static native int invokeCPUI(short paramShort, int[] paramArrayOfint, byte paramByte, long paramLong);
/*      */   
/*      */   public static native int invokeCPUI(short paramShort, short[] paramArrayOfshort, byte paramByte, long paramLong);
/*      */   
/*      */   public static native int invokePPCI(long paramLong1, float[] paramArrayOffloat, short paramShort, long paramLong2);
/*      */   
/*      */   public static native int invokePPPI(int[] paramArrayOfint, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, float paramFloat, long paramLong3);
/*      */   
/*      */   public static native int invokePPPI(short[] paramArrayOfshort, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, float paramFloat, long paramLong3);
/*      */   
/*      */   public static native int invokePPPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int invokePPPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native int invokePPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int invokePNNPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int invokePPPPPPI(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int invokePPPPPPPI(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int invokePPPPPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, float[] paramArrayOffloat, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong3);
/*      */   
/*      */   public static native long invokePP(double[] paramArrayOfdouble, int paramInt, long paramLong);
/*      */   
/*      */   public static native long invokePP(float[] paramArrayOffloat, int paramInt, long paramLong);
/*      */   
/*      */   public static native long invokePP(int[] paramArrayOfint, int paramInt, long paramLong);
/*      */   
/*      */   public static native long invokePP(long[] paramArrayOflong, int paramInt, long paramLong);
/*      */   
/*      */   public static native long invokePP(short[] paramArrayOfshort, int paramInt, long paramLong);
/*      */   
/*      */   public static native long invokePPP(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native byte invokeUPU(byte paramByte, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void invokePV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void invokeUPV(byte paramByte, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void invokePJV(int paramInt, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt, double[] paramArrayOfdouble, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, float[] paramArrayOffloat, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int[] paramArrayOfint, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, short[] paramArrayOfshort, int paramInt, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, double[] paramArrayOfdouble, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt, int[] paramArrayOfint, boolean paramBoolean, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, float[] paramArrayOffloat, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, short[] paramArrayOfshort, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void invokePPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean, long paramLong2);
/*      */   
/*      */   public static native void invokeCCPV(short paramShort1, short paramShort2, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void invokeCPCV(short paramShort1, double[] paramArrayOfdouble, short paramShort2, long paramLong);
/*      */   
/*      */   public static native void invokeCPCV(short paramShort1, float[] paramArrayOffloat, short paramShort2, long paramLong);
/*      */   
/*      */   public static native void invokeCPCV(short paramShort1, int[] paramArrayOfint, short paramShort2, long paramLong);
/*      */   
/*      */   public static native void invokeCPCV(short paramShort1, long[] paramArrayOflong, short paramShort2, long paramLong);
/*      */   
/*      */   public static native void invokeCPCV(short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong);
/*      */   
/*      */   public static native void invokeCPPV(short paramShort, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*      */   
/*      */   public static native void invokePNPV(long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native void invokePPPV(long paramLong1, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong2);
/*      */   
/*      */   public static native void invokePPPV(long paramLong1, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2);
/*      */   
/*      */   public static native void invokePPPV(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void invokePPPV(int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void invokePPJV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void invokePPPV(int paramInt, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(int paramInt1, int paramInt2, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double[] paramArrayOfdouble3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(int paramInt1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long paramLong);
/*      */   
/*      */   public static native void invokePPPV(float[] paramArrayOffloat, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native void invokePPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void invokePPPV(float[] paramArrayOffloat, boolean paramBoolean, int paramInt1, long paramLong1, long paramLong2, int paramInt2, long paramLong3);
/*      */   
/*      */   public static native void invokeCCPCV(short paramShort1, short paramShort2, double[] paramArrayOfdouble, short paramShort3, long paramLong);
/*      */   
/*      */   public static native void invokeCCPCV(short paramShort1, short paramShort2, float[] paramArrayOffloat, short paramShort3, long paramLong);
/*      */   
/*      */   public static native void invokeCCPCV(short paramShort1, short paramShort2, int[] paramArrayOfint, short paramShort3, long paramLong);
/*      */   
/*      */   public static native void invokeCCPCV(short paramShort1, short paramShort2, long[] paramArrayOflong, short paramShort3, long paramLong);
/*      */   
/*      */   public static native void invokeCCPCV(short paramShort1, short paramShort2, short[] paramArrayOfshort, short paramShort3, long paramLong);
/*      */   
/*      */   public static native void invokePCPCV(long paramLong1, short paramShort1, double[] paramArrayOfdouble, short paramShort2, long paramLong2);
/*      */   
/*      */   public static native void invokePCPCV(long paramLong1, short paramShort1, float[] paramArrayOffloat, short paramShort2, long paramLong2);
/*      */   
/*      */   public static native void invokePCPCV(long paramLong1, short paramShort1, int[] paramArrayOfint, short paramShort2, long paramLong2);
/*      */   
/*      */   public static native void invokePCPCV(long paramLong1, short paramShort1, long[] paramArrayOflong, short paramShort2, long paramLong2);
/*      */   
/*      */   public static native void invokePCPCV(long paramLong1, short paramShort1, short[] paramArrayOfshort, short paramShort2, long paramLong2);
/*      */   
/*      */   public static native void invokePNPPV(long paramLong1, long paramLong2, long paramLong3, short[] paramArrayOfshort, long paramLong4);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt1, int paramInt2, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double[] paramArrayOfdouble3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPPV(long paramLong1, long paramLong2, long paramLong3, float[] paramArrayOffloat, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void invokePPPPPV(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPPV(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void invokePPPPPV(int paramInt1, long paramLong1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong2, int paramInt3, long paramLong3, int paramInt4, boolean paramBoolean, long paramLong4);
/*      */   
/*      */   public static native void invokePPPPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong1, int paramInt3, int[] paramArrayOfint2, int paramInt4, boolean paramBoolean, long paramLong2);
/*      */   
/*      */   public static native void invokePPPPPV(int paramInt1, short[] paramArrayOfshort1, int paramInt2, float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong1, int paramInt3, short[] paramArrayOfshort2, int paramInt4, boolean paramBoolean, long paramLong2);
/*      */   
/*      */   public static native boolean invokePZ(int paramInt, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native boolean invokePPZ(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native boolean invokePPPZ(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPI(int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int callPI(int[] paramArrayOfint, int paramInt, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native int callPI(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native int callPPI(int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int callPPI(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt, double[] paramArrayOfdouble, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt, short[] paramArrayOfshort, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, long[] paramArrayOflong, int paramInt, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int callPPI(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native int callPPI(int paramInt1, long paramLong1, int paramInt2, int paramInt3, float paramFloat, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native int callPJPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPJPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong2);
/*      */   
/*      */   public static native int callPPPI(int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native int callPJPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPJPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt, long[] paramArrayOflong, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, int paramInt, long paramLong3);
/*      */   
/*      */   public static native int callPPJI(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native int callPPPI(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPNPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong3);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int[] paramArrayOfint1, long paramLong2, int paramInt, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, long[] paramArrayOflong, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native int callPJPPI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native int callPPPPI(int paramInt1, int[] paramArrayOfint1, long[] paramArrayOflong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14, int paramInt15, int paramInt16, int paramInt17, int paramInt18, int paramInt19, int[] paramArrayOfint2, long[] paramArrayOflong2, long paramLong);
/*      */   
/*      */   public static native int callPJPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*      */   
/*      */   public static native int callPPJPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong3);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native int callPJPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, long paramLong2, int paramInt, long paramLong3, long[] paramArrayOflong, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong4);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, int[] paramArrayOfint1, float[] paramArrayOffloat, int paramInt, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong2);
/*      */   
/*      */   public static native int callPPPPPI(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, int paramInt1, long paramLong2, long[] paramArrayOflong, int paramInt2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int callPPPPPI(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native int callPJPPJI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4, int paramInt3, long paramLong5);
/*      */   
/*      */   public static native int callPJPPJI(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, long[] paramArrayOflong, long paramLong4, int paramInt3, long paramLong5);
/*      */   
/*      */   public static native int callPJJJJPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*      */   
/*      */   public static native int callPPPPPPI(long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong2);
/*      */   
/*      */   public static native int callPJJPPPI(long paramLong1, long paramLong2, long paramLong3, int paramInt, long paramLong4, long paramLong5, long[] paramArrayOflong, long paramLong6);
/*      */   
/*      */   public static native int callPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native int callPPPPPPI(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, int[] paramArrayOfint5, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, int[] paramArrayOfint, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, double[] paramArrayOfdouble, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, float[] paramArrayOffloat, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, int[] paramArrayOfint, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, short[] paramArrayOfshort, int paramInt2, long paramLong5, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPJPPPPPI(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, long paramLong6, long paramLong7, long paramLong8);
/*      */   
/*      */   public static native int callPPJPPPPPI(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int paramInt, long paramLong5, int[] paramArrayOfint, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4, long paramLong5, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, double[] paramArrayOfdouble, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*      */   
/*      */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, float[] paramArrayOffloat, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*      */   
/*      */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*      */   
/*      */   public static native int callPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, short[] paramArrayOfshort, int paramInt2, long paramLong7, long paramLong8, long paramLong9);
/*      */   
/*      */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7, long paramLong8);
/*      */   
/*      */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, float[] paramArrayOffloat, long paramLong4, long paramLong5, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, int[] paramArrayOfint1, long paramLong4, long paramLong5, int paramInt, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong6, long paramLong7);
/*      */   
/*      */   public static native int callPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, int paramInt1, long paramLong4, long paramLong5, long paramLong6, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7, long paramLong8);
/*      */   
/*      */   public static native int callPPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong8, long paramLong9);
/*      */   
/*      */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, double[] paramArrayOfdouble, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*      */   
/*      */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, float[] paramArrayOffloat, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*      */   
/*      */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, int[] paramArrayOfint, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*      */   
/*      */   public static native int callPPPPPPPPPPPPI(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, short[] paramArrayOfshort, int paramInt2, long paramLong10, long paramLong11, long paramLong12);
/*      */   
/*      */   public static native int callPPPPPPPPPPPPPPPI(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, long paramLong10, long paramLong11, int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong12, long paramLong13);
/*      */   
/*      */   public static native long callPP(int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native long callPPP(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPPP(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPPP(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPPP(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native long callPPP(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPPPP(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPPPP(long paramLong1, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPPPP(int paramInt, long paramLong1, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native long callPPPP(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPJPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPPJPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPNPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, long paramLong2, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPJPPP(long paramLong1, long paramLong2, int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong3);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, long paramLong2, int paramInt, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, long paramLong2, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native long callPJPPP(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4);
/*      */   
/*      */   public static native long callPJPPPP(long paramLong1, long paramLong2, long paramLong3, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPPPPPP(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3, int paramInt, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPPPP(long paramLong1, int paramInt1, int paramInt2, long paramLong2, int paramInt3, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*      */   
/*      */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*      */   
/*      */   public static native long callPJJPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*      */   
/*      */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*      */   
/*      */   public static native long callPJPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, double[] paramArrayOfdouble, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong4);
/*      */   
/*      */   public static native long callPPJPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong4);
/*      */   
/*      */   public static native long callPPPJPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*      */   
/*      */   public static native long callPPPPPPP(long paramLong1, int paramInt, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*      */   
/*      */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int[] paramArrayOfint, long paramLong6);
/*      */   
/*      */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong5);
/*      */   
/*      */   public static native long callPPJPPPPP(long paramLong1, long[] paramArrayOflong, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native long callPPPPPPPP(long paramLong1, int paramInt1, long paramLong2, long paramLong3, int paramInt2, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint, long paramLong7);
/*      */   
/*      */   public static native long callPPPPPPPP(int paramInt1, int[] paramArrayOfint1, long[] paramArrayOflong1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, long paramLong2, long paramLong3, int paramInt6, int[] paramArrayOfint2, long[] paramArrayOflong2, long paramLong4);
/*      */   
/*      */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int[] paramArrayOfint, long paramLong8);
/*      */   
/*      */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong7);
/*      */   
/*      */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong7);
/*      */   
/*      */   public static native long callPJPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong7);
/*      */   
/*      */   public static native long callPPJPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, int paramInt2, long paramLong6, long paramLong7, int[] paramArrayOfint, long paramLong8);
/*      */   
/*      */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, long paramLong9, int[] paramArrayOfint, long paramLong10);
/*      */   
/*      */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, float[] paramArrayOffloat, int[] paramArrayOfint, long paramLong9);
/*      */   
/*      */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong9);
/*      */   
/*      */   public static native long callPJPPPPPPPPP(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, long paramLong8, short[] paramArrayOfshort, int[] paramArrayOfint, long paramLong9);
/*      */   
/*      */   public static native long callPPJPPPPPPPP(long paramLong1, long paramLong2, int paramInt1, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7, int paramInt2, long paramLong8, long paramLong9, int[] paramArrayOfint, long paramLong10);
/*      */   
/*      */   public static native void callPV(double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, boolean paramBoolean, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int[] paramArrayOfint, int paramInt2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, boolean paramBoolean, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int[] paramArrayOfint, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, int paramInt4, int paramInt5, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, float paramFloat3, float paramFloat4, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, double[] paramArrayOfdouble, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int[] paramArrayOfint, long paramLong);
/*      */   
/*      */   public static native void callPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, short[] paramArrayOfshort, long paramLong);
/*      */   
/*      */   public static native void callPPV(long paramLong1, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, long paramLong);
/*      */   
/*      */   public static native void callPPV(float[] paramArrayOffloat1, float[] paramArrayOffloat2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(short[] paramArrayOfshort1, short[] paramArrayOfshort2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPPV(long paramLong1, int paramInt, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int[] paramArrayOfint1, int paramInt, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, double[] paramArrayOfdouble, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, float[] paramArrayOffloat, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, int[] paramArrayOfint, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, long[] paramArrayOflong, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long paramLong1, short[] paramArrayOfshort, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, long[] paramArrayOflong, int[] paramArrayOfint, int paramInt2, long paramLong);
/*      */   
/*      */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int paramInt3, int[] paramArrayOfint2, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int[] paramArrayOfint, int paramInt2, long paramLong1, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, int[] paramArrayOfint2, int paramInt3, long paramLong);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int[] paramArrayOfint, long paramLong1, int paramInt2, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void callPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int[] paramArrayOfint, long paramLong1, int paramInt3, int paramInt4, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong1, int paramInt5, int paramInt6, short[] paramArrayOfshort, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, float paramFloat1, float paramFloat2, int paramInt5, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPPV(int paramInt1, int paramInt2, long paramLong1, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOffloat, long paramLong2);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt, long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt, long[] paramArrayOflong, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, long paramLong2, int paramInt, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, double[] paramArrayOfdouble, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, float[] paramArrayOffloat, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, long paramLong1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, int[] paramArrayOfint1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long paramLong2);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, double[] paramArrayOfdouble, long paramLong3);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOffloat, long paramLong3);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native void callPJPV(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native void callPPJV(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, long paramLong2, int paramInt3, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint, long paramLong1, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, long paramLong1, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int[] paramArrayOfint1, int paramInt3, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int[] paramArrayOfint1, int paramInt2, long paramLong1, int paramInt3, int[] paramArrayOfint2, long paramLong2);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, float[] paramArrayOffloat, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, int paramInt4, short[] paramArrayOfshort, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2, float[] paramArrayOffloat, long paramLong);
/*      */   
/*      */   public static native void callPPPV(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int paramInt5, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong);
/*      */   
/*      */   public static native void callPPPV(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfint, long paramLong2, long paramLong3);
/*      */   
/*      */   public static native void callPJPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void callPPPPV(long paramLong1, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void callPJJPV(long paramLong1, int paramInt, long paramLong2, long paramLong3, long[] paramArrayOflong, long paramLong4);
/*      */   
/*      */   public static native void callPPPPV(long paramLong1, int paramInt, long paramLong2, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void callPPPPV(long[] paramArrayOflong, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt, long paramLong);
/*      */   
/*      */   public static native void callPPPPV(int paramInt1, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt2, long paramLong2);
/*      */   
/*      */   public static native void callPPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long paramLong2);
/*      */   
/*      */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, int[] paramArrayOfint, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native void callPPPPV(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native void callPPPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int paramInt3, long paramLong2);
/*      */   
/*      */   public static native void callPJPPV(long paramLong1, int paramInt1, long paramLong2, int paramInt2, int paramInt3, long[] paramArrayOflong, int paramInt4, int[] paramArrayOfint, long paramLong3);
/*      */   
/*      */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, double[] paramArrayOfdouble, long paramLong5);
/*      */   
/*      */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float[] paramArrayOffloat, long paramLong5);
/*      */   
/*      */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, int[] paramArrayOfint, long paramLong5);
/*      */   
/*      */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long[] paramArrayOflong, long paramLong5);
/*      */   
/*      */   public static native void callPJJJPV(long paramLong1, long paramLong2, long paramLong3, long paramLong4, short[] paramArrayOfshort, long paramLong5);
/*      */   
/*      */   public static native void callPPPPPV(long paramLong1, int paramInt, long paramLong2, long[] paramArrayOflong, int[] paramArrayOfint, long paramLong3, long paramLong4);
/*      */   
/*      */   public static native void callPPPPPV(int paramInt1, int paramInt2, long paramLong1, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long paramLong2);
/*      */   
/*      */   public static native void callPPPPPV(long paramLong1, int paramInt1, int paramInt2, long[] paramArrayOflong1, long[] paramArrayOflong2, long[] paramArrayOflong3, long[] paramArrayOflong4, long paramLong2);
/*      */   
/*      */   public static native void callPPPPPV(long paramLong1, int paramInt1, long[] paramArrayOflong, int paramInt2, int paramInt3, int paramInt4, long paramLong2, int paramInt5, long paramLong3, int paramInt6, long paramLong4, long paramLong5);
/*      */   
/*      */   public static native void callPPPPPPPV(int paramInt1, int paramInt2, int paramInt3, long paramLong1, int paramInt4, long paramLong2, int[] paramArrayOfint1, int[] paramArrayOfint2, int[] paramArrayOfint3, int[] paramArrayOfint4, long[] paramArrayOflong, long paramLong3);
/*      */   
/*      */   public static native boolean callPPZ(int paramInt, int[] paramArrayOfint, long paramLong1, long paramLong2);
/*      */   
/*      */   public static native boolean callPPPPZ(int paramInt1, int paramInt2, int paramInt3, float paramFloat, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4, long paramLong);
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\META-INF\versions\25\org\lwjgl\system\JNI.class
 * Java compiler version: 25 (69.0)
 * JD-Core Version:       1.1.3
 */
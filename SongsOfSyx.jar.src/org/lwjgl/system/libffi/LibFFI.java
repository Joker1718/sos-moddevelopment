/*     */ package org.lwjgl.system.libffi;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.CustomBuffer;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Pointer;
/*     */ 
/*     */ public class LibFFI {
/*     */   public static final String FFI_VERSION_STRING = "3.5.0";
/*     */   public static final int FFI_VERSION_NUMBER = 30500;
/*     */   public static final short FFI_TYPE_VOID = 0;
/*     */   public static final short FFI_TYPE_INT = 1;
/*     */   public static final short FFI_TYPE_FLOAT = 2;
/*     */   public static final short FFI_TYPE_DOUBLE = 3;
/*     */   
/*     */   static {
/*  21 */     Library.initialize();
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
/*  32 */   public static final short FFI_TYPE_LONGDOUBLE = FFI_TYPE_DOUBLE();
/*     */   
/*     */   public static final short FFI_TYPE_UINT8 = 5;
/*     */   
/*     */   public static final short FFI_TYPE_SINT8 = 6;
/*     */   public static final short FFI_TYPE_UINT16 = 7;
/*     */   public static final short FFI_TYPE_SINT16 = 8;
/*     */   public static final short FFI_TYPE_UINT32 = 9;
/*     */   public static final short FFI_TYPE_SINT32 = 10;
/*     */   public static final short FFI_TYPE_UINT64 = 11;
/*     */   public static final short FFI_TYPE_SINT64 = 12;
/*     */   public static final short FFI_TYPE_STRUCT = 13;
/*     */   public static final short FFI_TYPE_POINTER = 14;
/*  45 */   public static final int FFI_FIRST_ABI = FFI_FIRST_ABI();
/*  46 */   public static final int FFI_WIN64 = FFI_WIN64();
/*  47 */   public static final int FFI_GNUW64 = FFI_GNUW64();
/*  48 */   public static final int FFI_UNIX64 = FFI_UNIX64();
/*  49 */   public static final int FFI_EFI64 = FFI_EFI64();
/*  50 */   public static final int FFI_SYSV = FFI_SYSV();
/*  51 */   public static final int FFI_STDCALL = FFI_STDCALL();
/*  52 */   public static final int FFI_THISCALL = FFI_THISCALL();
/*  53 */   public static final int FFI_FASTCALL = FFI_FASTCALL();
/*  54 */   public static final int FFI_MS_CDECL = FFI_MS_CDECL();
/*  55 */   public static final int FFI_PASCAL = FFI_PASCAL();
/*  56 */   public static final int FFI_REGISTER = FFI_REGISTER();
/*  57 */   public static final int FFI_VFP = FFI_VFP();
/*  58 */   public static final int FFI_LAST_ABI = FFI_LAST_ABI();
/*  59 */   public static final int FFI_DEFAULT_ABI = FFI_DEFAULT_ABI();
/*     */   
/*     */   public static final int FFI_OK = 0;
/*     */   
/*     */   public static final int FFI_BAD_TYPEDEF = 1;
/*     */   public static final int FFI_BAD_ABI = 2;
/*     */   public static final int FFI_BAD_ARGTYPE = 3;
/*     */   
/*     */   protected LibFFI() {
/*  68 */     throw new UnsupportedOperationException();
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
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_void() {
/* 157 */     long __result = nffi_type_void();
/* 158 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 162 */   public static final FFIType ffi_type_void = ffi_type_void();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint8() {
/* 170 */     long __result = nffi_type_uint8();
/* 171 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 175 */   public static final FFIType ffi_type_uint8 = ffi_type_uint8();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint8() {
/* 183 */     long __result = nffi_type_sint8();
/* 184 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 188 */   public static final FFIType ffi_type_sint8 = ffi_type_sint8();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint16() {
/* 196 */     long __result = nffi_type_uint16();
/* 197 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 201 */   public static final FFIType ffi_type_uint16 = ffi_type_uint16();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint16() {
/* 209 */     long __result = nffi_type_sint16();
/* 210 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 214 */   public static final FFIType ffi_type_sint16 = ffi_type_sint16();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint32() {
/* 222 */     long __result = nffi_type_uint32();
/* 223 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 227 */   public static final FFIType ffi_type_uint32 = ffi_type_uint32();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint32() {
/* 235 */     long __result = nffi_type_sint32();
/* 236 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 240 */   public static final FFIType ffi_type_sint32 = ffi_type_sint32();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint64() {
/* 248 */     long __result = nffi_type_uint64();
/* 249 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 253 */   public static final FFIType ffi_type_uint64 = ffi_type_uint64();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint64() {
/* 261 */     long __result = nffi_type_sint64();
/* 262 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 266 */   public static final FFIType ffi_type_sint64 = ffi_type_sint64();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uchar() {
/* 274 */     long __result = nffi_type_uchar();
/* 275 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 279 */   public static final FFIType ffi_type_uchar = ffi_type_uchar();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_schar() {
/* 287 */     long __result = nffi_type_schar();
/* 288 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 292 */   public static final FFIType ffi_type_schar = ffi_type_schar();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_ushort() {
/* 300 */     long __result = nffi_type_ushort();
/* 301 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 305 */   public static final FFIType ffi_type_ushort = ffi_type_ushort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sshort() {
/* 313 */     long __result = nffi_type_sshort();
/* 314 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 318 */   public static final FFIType ffi_type_sshort = ffi_type_sshort();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_uint() {
/* 326 */     long __result = nffi_type_uint();
/* 327 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 331 */   public static final FFIType ffi_type_uint = ffi_type_uint();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_sint() {
/* 339 */     long __result = nffi_type_sint();
/* 340 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 344 */   public static final FFIType ffi_type_sint = ffi_type_sint();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_ulong() {
/* 352 */     long __result = nffi_type_ulong();
/* 353 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 357 */   public static final FFIType ffi_type_ulong = ffi_type_ulong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_slong() {
/* 365 */     long __result = nffi_type_slong();
/* 366 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 370 */   public static final FFIType ffi_type_slong = ffi_type_slong();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_float() {
/* 378 */     long __result = nffi_type_float();
/* 379 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 383 */   public static final FFIType ffi_type_float = ffi_type_float();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_double() {
/* 391 */     long __result = nffi_type_double();
/* 392 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 396 */   public static final FFIType ffi_type_double = ffi_type_double();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_longdouble() {
/* 404 */     long __result = nffi_type_longdouble();
/* 405 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 409 */   public static final FFIType ffi_type_longdouble = ffi_type_longdouble();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_type *")
/*     */   private static FFIType ffi_type_pointer() {
/* 417 */     long __result = nffi_type_pointer();
/* 418 */     return FFIType.create(__result);
/*     */   }
/*     */ 
/*     */   
/* 422 */   public static final FFIType ffi_type_pointer = ffi_type_pointer();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("char const *")
/*     */   public static String ffi_get_version() {
/* 432 */     long __result = nffi_get_version();
/* 433 */     return MemoryUtil.memASCIISafe(__result);
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
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_cif(@NativeType("ffi_cif *") FFICIF cif, @NativeType("ffi_abi") int abi, @NativeType("ffi_type *") FFIType rtype, @NativeType("ffi_type **") PointerBuffer atypes) {
/* 456 */     return nffi_prep_cif(cif.address(), abi, Checks.remainingSafe((CustomBuffer)atypes), rtype.address(), MemoryUtil.memAddressSafe((Pointer)atypes));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_cif_var(@NativeType("ffi_cif *") FFICIF cif, @NativeType("ffi_abi") int abi, @NativeType("unsigned int") int nfixedargs, @NativeType("ffi_type *") FFIType rtype, @NativeType("ffi_type **") PointerBuffer atypes) {
/* 467 */     return nffi_prep_cif_var(cif.address(), abi, nfixedargs, atypes.remaining(), rtype.address(), MemoryUtil.memAddress((CustomBuffer)atypes));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ffi_call(@NativeType("ffi_cif *") FFICIF cif, @NativeType("FFI_FN_TYPE") long fn, @NativeType("void *") ByteBuffer rvalue, @NativeType("void **") PointerBuffer avalues) {
/* 477 */     if (Checks.CHECKS) {
/* 478 */       Checks.check(fn);
/*     */     }
/* 480 */     nffi_call(cif.address(), fn, MemoryUtil.memAddressSafe(rvalue), MemoryUtil.memAddressSafe((Pointer)avalues));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_get_struct_offsets(@NativeType("ffi_abi") int abi, @NativeType("ffi_type *") FFIType struct_type, @NativeType("size_t *") PointerBuffer offsets) {
/* 491 */     return nffi_get_struct_offsets(abi, struct_type.address(), MemoryUtil.memAddressSafe((Pointer)offsets));
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
/*     */   @NativeType("ffi_closure *")
/*     */   public static FFIClosure ffi_closure_alloc(@NativeType("size_t") long size, @NativeType("void **") PointerBuffer code) {
/* 508 */     if (Checks.CHECKS) {
/* 509 */       Checks.check((CustomBuffer)code, 1);
/*     */     }
/* 511 */     long __result = nffi_closure_alloc(size, MemoryUtil.memAddress((CustomBuffer)code));
/* 512 */     return FFIClosure.createSafe(__result);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ffi_closure_free(@NativeType("ffi_closure *") FFIClosure writable) {
/* 522 */     nffi_closure_free(writable.address());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("ffi_status")
/*     */   public static int ffi_prep_closure_loc(@NativeType("ffi_closure *") FFIClosure closure, @NativeType("ffi_cif *") FFICIF cif, @NativeType("FFI_CLOSURE_FUN") long fun, @NativeType("void *") long user_data, @NativeType("void *") long codeloc) {
/* 533 */     if (Checks.CHECKS) {
/* 534 */       Checks.check(fun);
/* 535 */       Checks.check(codeloc);
/*     */     } 
/* 537 */     return nffi_prep_closure_loc(closure.address(), cif.address(), fun, user_data, codeloc);
/*     */   }
/*     */   
/*     */   private static native short FFI_TYPE_DOUBLE();
/*     */   
/*     */   private static native int FFI_WIN64();
/*     */   
/*     */   private static native int FFI_GNUW64();
/*     */   
/*     */   private static native int FFI_UNIX64();
/*     */   
/*     */   private static native int FFI_EFI64();
/*     */   
/*     */   private static native int FFI_SYSV();
/*     */   
/*     */   private static native int FFI_STDCALL();
/*     */   
/*     */   private static native int FFI_THISCALL();
/*     */   
/*     */   private static native int FFI_FASTCALL();
/*     */   
/*     */   private static native int FFI_MS_CDECL();
/*     */   
/*     */   private static native int FFI_PASCAL();
/*     */   
/*     */   private static native int FFI_REGISTER();
/*     */   
/*     */   private static native int FFI_VFP();
/*     */   
/*     */   private static native int FFI_FIRST_ABI();
/*     */   
/*     */   private static native int FFI_LAST_ABI();
/*     */   
/*     */   private static native int FFI_DEFAULT_ABI();
/*     */   
/*     */   private static native long nffi_type_void();
/*     */   
/*     */   private static native long nffi_type_uint8();
/*     */   
/*     */   private static native long nffi_type_sint8();
/*     */   
/*     */   private static native long nffi_type_uint16();
/*     */   
/*     */   private static native long nffi_type_sint16();
/*     */   
/*     */   private static native long nffi_type_uint32();
/*     */   
/*     */   private static native long nffi_type_sint32();
/*     */   
/*     */   private static native long nffi_type_uint64();
/*     */   
/*     */   private static native long nffi_type_sint64();
/*     */   
/*     */   private static native long nffi_type_uchar();
/*     */   
/*     */   private static native long nffi_type_schar();
/*     */   
/*     */   private static native long nffi_type_ushort();
/*     */   
/*     */   private static native long nffi_type_sshort();
/*     */   
/*     */   private static native long nffi_type_uint();
/*     */   
/*     */   private static native long nffi_type_sint();
/*     */   
/*     */   private static native long nffi_type_ulong();
/*     */   
/*     */   private static native long nffi_type_slong();
/*     */   
/*     */   private static native long nffi_type_float();
/*     */   
/*     */   private static native long nffi_type_double();
/*     */   
/*     */   private static native long nffi_type_longdouble();
/*     */   
/*     */   private static native long nffi_type_pointer();
/*     */   
/*     */   public static native long nffi_get_version();
/*     */   
/*     */   @NativeType("unsigned long")
/*     */   public static native long ffi_get_version_number();
/*     */   
/*     */   @NativeType("unsigned int")
/*     */   public static native int ffi_get_default_abi();
/*     */   
/*     */   public static native int nffi_prep_cif(long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native int nffi_prep_cif_var(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native void nffi_call(long paramLong1, long paramLong2, long paramLong3, long paramLong4);
/*     */   
/*     */   public static native int nffi_get_struct_offsets(int paramInt, long paramLong1, long paramLong2);
/*     */   
/*     */   @NativeType("size_t")
/*     */   public static native long ffi_get_closure_size();
/*     */   
/*     */   public static native long nffi_closure_alloc(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native void nffi_closure_free(long paramLong);
/*     */   
/*     */   public static native int nffi_prep_closure_loc(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\libffi\LibFFI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
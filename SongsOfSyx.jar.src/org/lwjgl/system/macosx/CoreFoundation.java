/*     */ package org.lwjgl.system.macosx;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeType;
/*     */ 
/*     */ public class CoreFoundation
/*     */ {
/*     */   public static final byte TRUE = 1;
/*     */   public static final byte FALSE = 0;
/*     */   public static final int kCFStringEncodingMacRoman = 0;
/*     */   public static final int kCFStringEncodingWindowsLatin1 = 1280;
/*     */   
/*     */   static {
/*  17 */     Library.initialize();
/*     */   }
/*     */ 
/*     */   
/*     */   public static final int kCFStringEncodingISOLatin1 = 513;
/*     */   
/*     */   public static final int kCFStringEncodingNextStepLatin = 2817;
/*     */   
/*     */   public static final int kCFStringEncodingASCII = 1536;
/*     */   
/*     */   public static final int kCFStringEncodingUnicode = 256;
/*     */   
/*     */   public static final int kCFStringEncodingUTF8 = 134217984;
/*     */   
/*     */   public static final int kCFStringEncodingNonLossyASCII = 3071;
/*     */   
/*     */   public static final int kCFStringEncodingUTF16 = 256;
/*     */   
/*     */   public static final int kCFStringEncodingUTF16BE = 268435712;
/*     */   public static final int kCFStringEncodingUTF16LE = 335544576;
/*     */   public static final int kCFStringEncodingUTF32 = 201326848;
/*     */   public static final int kCFStringEncodingUTF32BE = 402653440;
/*     */   public static final int kCFStringEncodingUTF32LE = 469762304;
/*     */   public static final int kCFURLPOSIXPathStyle = 0;
/*     */   public static final int kCFURLHFSPathStyle = 1;
/*     */   public static final int kCFURLWindowsPathStyle = 2;
/*     */   
/*     */   protected CoreFoundation() {
/*  45 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   public static final long kCFAllocatorDefault = kCFAllocatorDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   public static final long kCFAllocatorSystemDefault = kCFAllocatorSystemDefault();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   public static final long kCFAllocatorMalloc = kCFAllocatorMalloc();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  78 */   public static final long kCFAllocatorMallocZone = kCFAllocatorMallocZone();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  86 */   public static final long kCFAllocatorNull = kCFAllocatorNull();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  94 */   public static final long kCFAllocatorUseContext = kCFAllocatorUseContext();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFTypeRef")
/*     */   public static long CFRetain(@NativeType("CFTypeRef") long cf) {
/* 104 */     if (Checks.CHECKS) {
/* 105 */       Checks.check(cf);
/*     */     }
/* 107 */     return nCFRetain(cf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void CFRelease(@NativeType("CFTypeRef") long cf) {
/* 117 */     if (Checks.CHECKS) {
/* 118 */       Checks.check(cf);
/*     */     }
/* 120 */     nCFRelease(cf);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFBundleRef")
/*     */   public static long CFBundleCreate(@NativeType("CFAllocatorRef") long allocator, @NativeType("CFURLRef") long bundleURL) {
/* 131 */     if (Checks.CHECKS) {
/* 132 */       Checks.check(bundleURL);
/*     */     }
/* 134 */     return nCFBundleCreate(allocator, bundleURL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFBundleRef")
/*     */   public static long CFBundleGetBundleWithIdentifier(@NativeType("CFStringRef") long bundleID) {
/* 145 */     if (Checks.CHECKS) {
/* 146 */       Checks.check(bundleID);
/*     */     }
/* 148 */     return nCFBundleGetBundleWithIdentifier(bundleID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("void *")
/*     */   public static long CFBundleGetFunctionPointerForName(@NativeType("CFBundleRef") long bundle, @NativeType("CFStringRef") long functionName) {
/* 159 */     if (Checks.CHECKS) {
/* 160 */       Checks.check(bundle);
/* 161 */       Checks.check(functionName);
/*     */     } 
/* 163 */     return nCFBundleGetFunctionPointerForName(bundle, functionName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFStringRef")
/*     */   public static long CFStringCreateWithCString(@NativeType("CFAllocatorRef") long allocator, @NativeType("char const *") ByteBuffer cStr, @NativeType("CFStringEncoding") int encoding) {
/* 174 */     return nCFStringCreateWithCString(allocator, MemoryUtil.memAddress(cStr), encoding);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFStringRef")
/*     */   public static long CFStringCreateWithCStringNoCopy(@NativeType("CFAllocatorRef") long allocator, @NativeType("char const *") ByteBuffer cStr, @NativeType("CFStringEncoding") int encoding, @NativeType("CFAllocatorRef") long contentsDeallocator) {
/* 185 */     return nCFStringCreateWithCStringNoCopy(allocator, MemoryUtil.memAddress(cStr), encoding, contentsDeallocator);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @NativeType("CFURLRef")
/*     */   public static long CFURLCreateWithFileSystemPath(@NativeType("CFAllocatorRef") long allocator, @NativeType("CFStringRef") long filePath, @NativeType("CFURLPathStyle") long pathStyle, @NativeType("Boolean") boolean isDirectory) {
/* 196 */     if (Checks.CHECKS) {
/* 197 */       Checks.check(filePath);
/*     */     }
/* 199 */     return nCFURLCreateWithFileSystemPath(allocator, filePath, pathStyle, isDirectory);
/*     */   }
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorDefault();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorSystemDefault();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorMalloc();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorMallocZone();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorNull();
/*     */   
/*     */   @NativeType("CFAllocatorRef")
/*     */   private static native long kCFAllocatorUseContext();
/*     */   
/*     */   public static native long nCFRetain(long paramLong);
/*     */   
/*     */   public static native void nCFRelease(long paramLong);
/*     */   
/*     */   public static native long nCFBundleCreate(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nCFBundleGetBundleWithIdentifier(long paramLong);
/*     */   
/*     */   public static native long nCFBundleGetFunctionPointerForName(long paramLong1, long paramLong2);
/*     */   
/*     */   public static native long nCFStringCreateWithCString(long paramLong1, long paramLong2, int paramInt);
/*     */   
/*     */   public static native long nCFStringCreateWithCStringNoCopy(long paramLong1, long paramLong2, int paramInt, long paramLong3);
/*     */   
/*     */   public static native long nCFURLCreateWithFileSystemPath(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\macosx\CoreFoundation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
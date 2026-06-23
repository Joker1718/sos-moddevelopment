/*     */ package org.lwjgl.system.windows;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.NativeType;
/*     */ import org.lwjgl.system.Struct;
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
/*     */ public class CRYPTPROTECT_PROMPTSTRUCT
/*     */   extends Struct<CRYPTPROTECT_PROMPTSTRUCT>
/*     */   implements NativeResource
/*     */ {
/*     */   public static final int SIZEOF;
/*     */   public static final int ALIGNOF;
/*     */   public static final int CBSIZE;
/*     */   public static final int DWPROMPTFLAGS;
/*     */   public static final int HWNDAPP;
/*     */   public static final int SZPROMPT;
/*     */   
/*     */   static {
/*  44 */     Struct.Layout layout = __struct(new Struct.Member[] {
/*  45 */           __member(4), 
/*  46 */           __member(4), 
/*  47 */           __member(POINTER_SIZE), 
/*  48 */           __member(POINTER_SIZE)
/*     */         });
/*     */     
/*  51 */     SIZEOF = layout.getSize();
/*  52 */     ALIGNOF = layout.getAlignment();
/*     */     
/*  54 */     CBSIZE = layout.offsetof(0);
/*  55 */     DWPROMPTFLAGS = layout.offsetof(1);
/*  56 */     HWNDAPP = layout.offsetof(2);
/*  57 */     SZPROMPT = layout.offsetof(3);
/*     */   }
/*     */   
/*     */   protected CRYPTPROTECT_PROMPTSTRUCT(long address, ByteBuffer container) {
/*  61 */     super(address, container);
/*     */   }
/*     */ 
/*     */   
/*     */   protected CRYPTPROTECT_PROMPTSTRUCT create(long address, ByteBuffer container) {
/*  66 */     return new CRYPTPROTECT_PROMPTSTRUCT(address, container);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT(ByteBuffer container) {
/*  76 */     super(MemoryUtil.memAddress(container), __checkContainer(container, SIZEOF));
/*     */   }
/*     */   
/*     */   public int sizeof() {
/*  80 */     return SIZEOF;
/*     */   }
/*     */   @NativeType("DWORD")
/*     */   public int cbSize() {
/*  84 */     return ncbSize(address());
/*     */   } @NativeType("DWORD")
/*     */   public int dwPromptFlags() {
/*  87 */     return ndwPromptFlags(address());
/*     */   } @NativeType("HWND")
/*     */   public long hwndApp() {
/*  90 */     return nhwndApp(address());
/*     */   } @NativeType("LPCWSTR")
/*     */   public ByteBuffer szPrompt() {
/*  93 */     return nszPrompt(address());
/*     */   } @NativeType("LPCWSTR")
/*     */   public String szPromptString() {
/*  96 */     return nszPromptString(address());
/*     */   }
/*     */   public CRYPTPROTECT_PROMPTSTRUCT cbSize(@NativeType("DWORD") int value) {
/*  99 */     ncbSize(address(), value); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT cbSize$Default() {
/* 101 */     return cbSize(SIZEOF);
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT dwPromptFlags(@NativeType("DWORD") int value) {
/* 103 */     ndwPromptFlags(address(), value); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT hwndApp(@NativeType("HWND") long value) {
/* 105 */     nhwndApp(address(), value); return this;
/*     */   } public CRYPTPROTECT_PROMPTSTRUCT szPrompt(@NativeType("LPCWSTR") ByteBuffer value) {
/* 107 */     nszPrompt(address(), value); return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT set(int cbSize, int dwPromptFlags, long hwndApp, ByteBuffer szPrompt) {
/* 116 */     cbSize(cbSize);
/* 117 */     dwPromptFlags(dwPromptFlags);
/* 118 */     hwndApp(hwndApp);
/* 119 */     szPrompt(szPrompt);
/*     */     
/* 121 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CRYPTPROTECT_PROMPTSTRUCT set(CRYPTPROTECT_PROMPTSTRUCT src) {
/* 132 */     MemoryUtil.memCopy(src.address(), address(), SIZEOF);
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT malloc() {
/* 140 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemAllocChecked(SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT calloc() {
/* 145 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.nmemCallocChecked(1L, SIZEOF), null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT create() {
/* 150 */     ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
/* 151 */     return new CRYPTPROTECT_PROMPTSTRUCT(MemoryUtil.memAddress(container), container);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT create(long address) {
/* 156 */     return new CRYPTPROTECT_PROMPTSTRUCT(address, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT createSafe(long address) {
/* 161 */     return (address == 0L) ? null : new CRYPTPROTECT_PROMPTSTRUCT(address, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT malloc(MemoryStack stack) {
/* 170 */     return new CRYPTPROTECT_PROMPTSTRUCT(stack.nmalloc(ALIGNOF, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CRYPTPROTECT_PROMPTSTRUCT calloc(MemoryStack stack) {
/* 179 */     return new CRYPTPROTECT_PROMPTSTRUCT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int ncbSize(long struct) {
/* 185 */     return MemoryUtil.memGetInt(struct + CBSIZE);
/*     */   } public static int ndwPromptFlags(long struct) {
/* 187 */     return MemoryUtil.memGetInt(struct + DWPROMPTFLAGS);
/*     */   } public static long nhwndApp(long struct) {
/* 189 */     return MemoryUtil.memGetAddress(struct + HWNDAPP);
/*     */   } public static ByteBuffer nszPrompt(long struct) {
/* 191 */     return MemoryUtil.memByteBufferNT2(MemoryUtil.memGetAddress(struct + SZPROMPT));
/*     */   } public static String nszPromptString(long struct) {
/* 193 */     return MemoryUtil.memUTF16(MemoryUtil.memGetAddress(struct + SZPROMPT));
/*     */   }
/*     */   public static void ncbSize(long struct, int value) {
/* 196 */     MemoryUtil.memPutInt(struct + CBSIZE, value);
/*     */   } public static void ndwPromptFlags(long struct, int value) {
/* 198 */     MemoryUtil.memPutInt(struct + DWPROMPTFLAGS, value);
/*     */   } public static void nhwndApp(long struct, long value) {
/* 200 */     MemoryUtil.memPutAddress(struct + HWNDAPP, Checks.check(value));
/*     */   }
/*     */   public static void nszPrompt(long struct, ByteBuffer value) {
/* 203 */     if (Checks.CHECKS) Checks.checkNT2(value); 
/* 204 */     MemoryUtil.memPutAddress(struct + SZPROMPT, MemoryUtil.memAddress(value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validate(long struct) {
/* 213 */     Checks.check(MemoryUtil.memGetAddress(struct + HWNDAPP));
/* 214 */     Checks.check(MemoryUtil.memGetAddress(struct + SZPROMPT));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\windows\CRYPTPROTECT_PROMPTSTRUCT.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
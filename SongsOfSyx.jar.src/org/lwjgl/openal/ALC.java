/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.FunctionProviderLocal;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.Library;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
/*     */ import org.lwjgl.system.NativeResource;
/*     */ import org.lwjgl.system.Platform;
/*     */ import org.lwjgl.system.SharedLibrary;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
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
/*     */ public final class ALC
/*     */ {
/*     */   private static FunctionProviderLocal functionProvider;
/*     */   private static ALCCapabilities router;
/*  46 */   private static final ThreadLocal<ALCCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*     */   private static ICD icd;
/*     */   
/*     */   static {
/*  51 */     if (!((Boolean)Configuration.OPENAL_EXPLICIT_INIT.get(Boolean.valueOf(false))).booleanValue()) {
/*  52 */       create();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create() {
/*     */     String libName;
/*  61 */     switch (Platform.get()) {
/*     */       case FREEBSD:
/*     */       case LINUX:
/*     */       case MACOSX:
/*  65 */         libName = "openal";
/*     */         break;
/*     */       case WINDOWS:
/*  68 */         libName = "OpenAL";
/*     */         break;
/*     */       default:
/*  71 */         throw new IllegalStateException();
/*     */     } 
/*     */     
/*  74 */     create((String)Configuration.OPENAL_LIBRARY_NAME.get(Platform.mapLibraryNameBundled(libName)));
/*     */   }
/*     */   
/*     */   private static class SharedLibraryAL
/*     */     extends SharedLibrary.Delegate implements FunctionProviderLocal {
/*  79 */     private final long alcGetProcAddress = getFunctionAddress("alcGetProcAddress");
/*     */     
/*     */     protected SharedLibraryAL(SharedLibrary library) {
/*  82 */       super(library);
/*  83 */       if (this.alcGetProcAddress == 0L) {
/*  84 */         throw new RuntimeException("A core ALC function is missing. Make sure that the OpenAL library has been loaded correctly.");
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public long getFunctionAddress(ByteBuffer functionName) {
/*  90 */       long address = this.library.getFunctionAddress(functionName);
/*  91 */       if (address == 0L && Checks.DEBUG_FUNCTIONS) {
/*  92 */         APIUtil.apiLogMissing("ALC core", functionName);
/*     */       }
/*  94 */       return address;
/*     */     }
/*     */ 
/*     */     
/*     */     public long getFunctionAddress(long handle, ByteBuffer functionName) {
/*  99 */       long address = JNI.invokePPP(handle, MemoryUtil.memAddress(functionName), this.alcGetProcAddress);
/* 100 */       if (address == 0L) {
/* 101 */         address = this.library.getFunctionAddress(functionName);
/*     */       }
/* 103 */       if (address == 0L && Checks.DEBUG_FUNCTIONS) {
/* 104 */         APIUtil.apiLogMissing("ALC", functionName);
/*     */       }
/* 106 */       return address;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(String libName) {
/* 117 */     SharedLibrary OPENAL = Library.loadNative(ALC.class, "org.lwjgl.openal", libName, true);
/*     */     try {
/* 119 */       create(new SharedLibraryAL(OPENAL));
/* 120 */     } catch (RuntimeException e) {
/* 121 */       OPENAL.free();
/* 122 */       throw e;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void create(FunctionProviderLocal functionProvider) {
/* 132 */     if (ALC.functionProvider != null) {
/* 133 */       throw new IllegalStateException("ALC has already been created.");
/*     */     }
/*     */     
/* 136 */     ALC.functionProvider = functionProvider;
/*     */     
/* 138 */     router = createCapabilities(0L);
/*     */     
/* 140 */     AL.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void destroy() {
/* 145 */     if (functionProvider == null) {
/*     */       return;
/*     */     }
/*     */     
/* 149 */     AL.destroy();
/*     */     
/* 151 */     router = null;
/*     */     
/* 153 */     if (functionProvider instanceof NativeResource) {
/* 154 */       ((NativeResource)functionProvider).free();
/*     */     }
/* 156 */     functionProvider = null;
/*     */   }
/*     */   
/*     */   static <T> T check(T t) {
/* 160 */     if (t == null) {
/* 161 */       throw new IllegalStateException("OpenAL library has not been loaded.");
/*     */     }
/* 163 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public static FunctionProviderLocal getFunctionProvider() {
/* 168 */     return check(functionProvider);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCapabilities(ALCCapabilities caps) {
/* 179 */     capabilitiesTLS.set(caps);
/* 180 */     if (icd == null) {
/* 181 */       icd = new ICDStatic();
/*     */     }
/* 183 */     icd.set(caps);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ALCCapabilities getCapabilities() {
/* 192 */     ALCCapabilities caps = capabilitiesTLS.get();
/* 193 */     if (caps == null) {
/* 194 */       caps = router;
/*     */     }
/*     */     
/* 197 */     return checkCapabilities(caps);
/*     */   }
/*     */   
/*     */   private static ALCCapabilities checkCapabilities(ALCCapabilities caps) {
/* 201 */     if (caps == null) {
/* 202 */       throw new IllegalStateException("No ALCCapabilities instance set");
/*     */     }
/* 204 */     return caps;
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
/*     */   public static ALCCapabilities createCapabilities(long device) {
/* 217 */     return createCapabilities(device, null);
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
/*     */   public static ALCCapabilities createCapabilities(long device, IntFunction<PointerBuffer> bufferFactory) {
/*     */     int majorVersion, minorVersion;
/* 232 */     FunctionProviderLocal functionProvider = getFunctionProvider();
/*     */ 
/*     */ 
/*     */     
/* 236 */     long GetIntegerv = functionProvider.getFunctionAddress("alcGetIntegerv");
/* 237 */     long GetString = functionProvider.getFunctionAddress("alcGetString");
/* 238 */     long IsExtensionPresent = functionProvider.getFunctionAddress("alcIsExtensionPresent");
/*     */     
/* 240 */     if (GetIntegerv == 0L || GetString == 0L || IsExtensionPresent == 0L) {
/* 241 */       throw new IllegalStateException("Core ALC functions could not be found. Make sure that OpenAL has been loaded.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 247 */     try (MemoryStack stack = MemoryStack.stackPush()) {
/* 248 */       IntBuffer version = stack.mallocInt(1);
/*     */       
/* 250 */       JNI.invokePPV(device, 4096, 1, MemoryUtil.memAddress(version), GetIntegerv);
/* 251 */       majorVersion = version.get(0);
/*     */       
/* 253 */       JNI.invokePPV(device, 4097, 1, MemoryUtil.memAddress(version), GetIntegerv);
/* 254 */       minorVersion = version.get(0);
/*     */     } 
/*     */     
/* 257 */     int[][] ALC_VERSIONS = { { 0, 1 } };
/*     */ 
/*     */ 
/*     */     
/* 261 */     Set<String> supportedExtensions = new HashSet<>(16);
/*     */     
/* 263 */     for (int major = 1; major <= ALC_VERSIONS.length; major++) {
/* 264 */       int[] minors = ALC_VERSIONS[major - 1];
/* 265 */       for (int minor : minors) {
/* 266 */         if (major < majorVersion || (major == majorVersion && minor <= minorVersion)) {
/* 267 */           supportedExtensions.add("OpenALC" + major + minor);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 273 */     String extensionsString = MemoryUtil.memASCIISafe(JNI.invokePP(device, 4102, GetString));
/* 274 */     if (extensionsString != null) {
/* 275 */       StringTokenizer tokenizer = new StringTokenizer(extensionsString);
/* 276 */       while (tokenizer.hasMoreTokens()) {
/* 277 */         String extName = tokenizer.nextToken();
/* 278 */         try (MemoryStack stack = MemoryStack.stackPush()) {
/* 279 */           if (JNI.invokePPZ(device, MemoryUtil.memAddress(memoryStack.ASCII(extName, true)), IsExtensionPresent)) {
/* 280 */             supportedExtensions.add(extName);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 285 */     APIUtil.apiFilterExtensions(supportedExtensions, Configuration.OPENAL_EXTENSION_FILTER);
/*     */     
/* 287 */     ALCCapabilities caps = new ALCCapabilities(functionProvider, device, supportedExtensions, (bufferFactory == null) ? BufferUtils::createPointerBuffer : bufferFactory);
/* 288 */     if (device != 0L) {
/* 289 */       setCapabilities(caps);
/*     */     }
/*     */     
/* 292 */     return caps;
/*     */   }
/*     */   
/*     */   static ALCCapabilities getICD() {
/* 296 */     ALCCapabilities caps = (icd == null) ? null : icd.get();
/* 297 */     if (caps == null) {
/* 298 */       caps = router;
/*     */     }
/* 300 */     return check(caps);
/*     */   }
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(ALCCapabilities caps) {}
/*     */ 
/*     */     
/*     */     ALCCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static ALCCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */     
/*     */     public void set(ALCCapabilities caps) {
/* 322 */       if (tempCaps == null) {
/* 323 */         tempCaps = caps;
/* 324 */       } else if (caps != null && caps != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, caps.addresses)) {
/* 325 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
/* 326 */         ALC.icd = ALC::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ALCCapabilities get() {
/* 332 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final ALCCapabilities caps;
/*     */       
/*     */       static {
/* 340 */         ALCCapabilities tempCaps = ALC.ICDStatic.tempCaps;
/* 341 */         if (tempCaps == null) {
/* 342 */           throw new IllegalStateException("No ALCCapabilities instance has been set");
/*     */         }
/* 344 */         caps = tempCaps;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALC.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
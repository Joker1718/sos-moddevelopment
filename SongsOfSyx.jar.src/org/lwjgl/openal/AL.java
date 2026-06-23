/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.Configuration;
/*     */ import org.lwjgl.system.FunctionProvider;
/*     */ import org.lwjgl.system.JNI;
/*     */ import org.lwjgl.system.MemoryStack;
/*     */ import org.lwjgl.system.MemoryUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AL
/*     */ {
/*     */   private static ALCapabilities processCaps;
/*  49 */   private static final ThreadLocal<ALCapabilities> capabilitiesTLS = new ThreadLocal<>();
/*     */   
/*  51 */   private static ICD icd = new ICDStatic();
/*     */ 
/*     */ 
/*     */   
/*     */   static void init() {}
/*     */ 
/*     */   
/*     */   static void destroy() {
/*  59 */     setCurrentProcess(null);
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
/*     */   public static void setCurrentProcess(ALCapabilities caps) {
/*  71 */     processCaps = caps;
/*  72 */     capabilitiesTLS.set(null);
/*  73 */     icd.set(caps);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setCurrentThread(ALCapabilities caps) {
/*  84 */     capabilitiesTLS.set(caps);
/*  85 */     icd.set(caps);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ALCapabilities getCapabilities() {
/*  94 */     ALCapabilities caps = capabilitiesTLS.get();
/*  95 */     if (caps == null) {
/*  96 */       caps = processCaps;
/*     */     }
/*     */     
/*  99 */     return checkCapabilities(caps);
/*     */   }
/*     */   
/*     */   private static ALCapabilities checkCapabilities(ALCapabilities caps) {
/* 103 */     if (caps == null) {
/* 104 */       throw new IllegalStateException("No ALCapabilities instance set for the current thread or process. Possible solutions:\n\ta) Call AL.createCapabilities() after making a context current.\n\tb) Call AL.setCurrentProcess() or AL.setCurrentThread() if an ALCapabilities instance already exists.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 110 */     return caps;
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
/*     */   public static ALCapabilities createCapabilities(ALCCapabilities alcCaps) {
/* 123 */     return createCapabilities(alcCaps, null);
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
/*     */   public static ALCapabilities createCapabilities(ALCCapabilities alcCaps, IntFunction<PointerBuffer> bufferFactory) {
/* 139 */     long alGetProcAddress = ALC.getFunctionProvider().getFunctionAddress(0L, "alGetProcAddress");
/* 140 */     if (alGetProcAddress == 0L) {
/* 141 */       throw new RuntimeException("A core AL function is missing. Make sure that the OpenAL library has been loaded correctly.");
/*     */     }
/*     */     
/* 144 */     FunctionProvider functionProvider = functionName -> {
/*     */         long address = JNI.invokePP(MemoryUtil.memAddress(functionName), alGetProcAddress);
/*     */         
/*     */         if (address == 0L && Checks.DEBUG_FUNCTIONS) {
/*     */           APIUtil.apiLogMissing("AL", functionName);
/*     */         }
/*     */         return address;
/*     */       };
/* 152 */     long GetString = functionProvider.getFunctionAddress("alGetString");
/* 153 */     long GetError = functionProvider.getFunctionAddress("alGetError");
/* 154 */     long IsExtensionPresent = functionProvider.getFunctionAddress("alIsExtensionPresent");
/* 155 */     if (GetString == 0L || GetError == 0L || IsExtensionPresent == 0L) {
/* 156 */       throw new IllegalStateException("Core OpenAL functions could not be found. Make sure that the OpenAL library has been loaded correctly.");
/*     */     }
/*     */     
/* 159 */     String versionString = MemoryUtil.memASCIISafe(JNI.invokeP(45058, GetString));
/* 160 */     if (versionString == null || JNI.invokeI(GetError) != 0) {
/* 161 */       throw new IllegalStateException("There is no OpenAL context current in the current thread or process.");
/*     */     }
/*     */     
/* 164 */     APIUtil.APIVersion apiVersion = APIUtil.apiParseVersion(versionString);
/*     */     
/* 166 */     int majorVersion = apiVersion.major;
/* 167 */     int minorVersion = apiVersion.minor;
/*     */     
/* 169 */     int[][] AL_VERSIONS = { { 0, 1 } };
/*     */ 
/*     */ 
/*     */     
/* 173 */     Set<String> supportedExtensions = new HashSet<>(32);
/*     */     
/* 175 */     for (int major = 1; major <= AL_VERSIONS.length; major++) {
/* 176 */       int[] minors = AL_VERSIONS[major - 1];
/* 177 */       for (int minor : minors) {
/* 178 */         if (major < majorVersion || (major == majorVersion && minor <= minorVersion)) {
/* 179 */           supportedExtensions.add("OpenAL" + major + minor);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 185 */     String extensionsString = MemoryUtil.memASCIISafe(JNI.invokeP(45060, GetString));
/* 186 */     if (extensionsString != null) {
/* 187 */       MemoryStack stack = MemoryStack.stackGet();
/*     */       
/* 189 */       StringTokenizer tokenizer = new StringTokenizer(extensionsString);
/* 190 */       while (tokenizer.hasMoreTokens()) {
/* 191 */         String extName = tokenizer.nextToken();
/* 192 */         try (MemoryStack frame = stack.push()) {
/* 193 */           if (JNI.invokePZ(MemoryUtil.memAddress(frame.ASCII(extName, true)), IsExtensionPresent)) {
/* 194 */             supportedExtensions.add(extName);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     if (alcCaps.ALC_EXT_EFX) {
/* 201 */       supportedExtensions.add("ALC_EXT_EFX");
/*     */     }
/* 203 */     APIUtil.apiFilterExtensions(supportedExtensions, Configuration.OPENAL_EXTENSION_FILTER);
/*     */     
/* 205 */     ALCapabilities caps = new ALCapabilities(functionProvider, supportedExtensions, (bufferFactory == null) ? BufferUtils::createPointerBuffer : bufferFactory);
/*     */     
/* 207 */     if (alcCaps.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcGetThreadContext() != 0L) {
/* 208 */       setCurrentThread(caps);
/*     */     } else {
/* 210 */       setCurrentProcess(caps);
/*     */     } 
/*     */     
/* 213 */     return caps;
/*     */   }
/*     */   
/*     */   static ALCapabilities getICD() {
/* 217 */     return ALC.<ALCapabilities>check(icd.get());
/*     */   }
/*     */ 
/*     */   
/*     */   private static interface ICD
/*     */   {
/*     */     default void set(ALCapabilities caps) {}
/*     */ 
/*     */     
/*     */     ALCapabilities get();
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ICDStatic
/*     */     implements ICD
/*     */   {
/*     */     private static ALCapabilities tempCaps;
/*     */ 
/*     */     
/*     */     private ICDStatic() {}
/*     */ 
/*     */     
/*     */     public void set(ALCapabilities caps) {
/* 240 */       if (tempCaps == null) {
/* 241 */         tempCaps = caps;
/* 242 */       } else if (caps != null && caps != tempCaps && ThreadLocalUtil.areCapabilitiesDifferent(tempCaps.addresses, caps.addresses)) {
/* 243 */         APIUtil.apiLog("[WARNING] Incompatible context detected. Falling back to thread/process lookup for AL contexts.");
/* 244 */         AL.icd = AL::getCapabilities;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public ALCapabilities get() {
/* 250 */       return WriteOnce.caps;
/*     */     }
/*     */     
/*     */     private static final class WriteOnce
/*     */     {
/*     */       static final ALCapabilities caps;
/*     */       
/*     */       static {
/* 258 */         ALCapabilities tempCaps = AL.ICDStatic.tempCaps;
/* 259 */         if (tempCaps == null) {
/* 260 */           throw new IllegalStateException("No ALCapabilities instance has been set");
/*     */         }
/* 262 */         caps = tempCaps;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\AL.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
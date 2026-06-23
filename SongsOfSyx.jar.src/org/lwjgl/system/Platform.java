/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.util.function.Function;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Platform
/*     */ {
/*  17 */   FREEBSD("FreeBSD", "freebsd") {
/*  18 */     private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");
/*     */ 
/*     */     
/*     */     String mapLibraryName(String name) {
/*  22 */       if (this.SO.matcher(name).find()) {
/*  23 */         return name;
/*     */       }
/*     */       
/*  26 */       return System.mapLibraryName(name);
/*     */     }
/*     */   },
/*  29 */   LINUX("Linux", "linux") {
/*  30 */     private final Pattern SO = Pattern.compile("(?:^|/)lib\\w+[.]so(?:[.]\\d+)*$");
/*     */ 
/*     */     
/*     */     String mapLibraryName(String name) {
/*  34 */       if (this.SO.matcher(name).find()) {
/*  35 */         return name;
/*     */       }
/*     */       
/*  38 */       return System.mapLibraryName(name);
/*     */     }
/*     */   },
/*     */   
/*  42 */   MACOSX("macOS", "macos") {
/*  43 */     private final Pattern DYLIB = Pattern.compile("(?:^|/)lib\\w+(?:[.]\\d+)*[.]dylib$");
/*     */ 
/*     */     
/*     */     String mapLibraryName(String name) {
/*  47 */       if (this.DYLIB.matcher(name).find()) {
/*  48 */         return name;
/*     */       }
/*     */       
/*  51 */       return System.mapLibraryName(name);
/*     */     }
/*     */   },
/*  54 */   WINDOWS("Windows", "windows")
/*     */   {
/*     */     String mapLibraryName(String name) {
/*  57 */       if (name.endsWith(".dll")) {
/*  58 */         return name;
/*     */       }
/*     */       
/*  61 */       return System.mapLibraryName(name);
/*     */     } }; private static final Platform current; private static final Function<String, String> bundledLibraryNameMapper;
/*     */   private static final Function<String, String> bundledLibraryPathMapper;
/*     */   private final String name;
/*     */   private final String nativePath;
/*     */   
/*  67 */   public enum Architecture { X64(true),
/*  68 */     X86(false),
/*  69 */     ARM64(true),
/*  70 */     ARM32(false),
/*  71 */     PPC64LE(true),
/*  72 */     RISCV64(true);
/*     */     
/*     */     static final Architecture current;
/*     */     
/*     */     final boolean is64Bit;
/*     */     
/*     */     static {
/*  79 */       String osArch = System.getProperty("os.arch");
/*  80 */       boolean is64Bit = (osArch.contains("64") || osArch.startsWith("armv8"));
/*     */       
/*  82 */       if (osArch.startsWith("arm") || osArch.startsWith("aarch")) {
/*  83 */         current = is64Bit ? ARM64 : ARM32;
/*  84 */       } else if (osArch.startsWith("ppc")) {
/*  85 */         if (!"ppc64le".equals(osArch)) {
/*  86 */           throw new UnsupportedOperationException("Only PowerPC 64 LE is supported.");
/*     */         }
/*  88 */         current = PPC64LE;
/*  89 */       } else if (osArch.startsWith("riscv")) {
/*  90 */         if (!"riscv64".equals(osArch)) {
/*  91 */           throw new UnsupportedOperationException("Only RISC-V 64 is supported.");
/*     */         }
/*  93 */         current = RISCV64;
/*     */       } else {
/*  95 */         current = is64Bit ? X64 : X86;
/*     */       } 
/*     */     }
/*     */     
/*     */     Architecture(boolean is64Bit) {
/* 100 */       this.is64Bit = is64Bit;
/*     */     }
/*     */     
/*     */     public boolean is32Bit() {
/* 104 */       return !this.is64Bit;
/*     */     }
/*     */     
/*     */     public boolean is64Bit() {
/* 108 */       return this.is64Bit;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 118 */     String osName = System.getProperty("os.name");
/* 119 */     if (osName.startsWith("Windows")) {
/* 120 */       current = WINDOWS;
/* 121 */     } else if (osName.startsWith("FreeBSD")) {
/* 122 */       current = FREEBSD;
/* 123 */     } else if (osName.startsWith("Linux") || osName.startsWith("SunOS") || osName.startsWith("Unix")) {
/* 124 */       current = LINUX;
/* 125 */     } else if (osName.startsWith("Mac OS X") || osName.startsWith("Darwin")) {
/* 126 */       current = MACOSX;
/*     */     } else {
/* 128 */       throw new LinkageError("Unknown platform: " + osName);
/*     */     } 
/*     */     
/* 131 */     bundledLibraryNameMapper = getMapper(Configuration.BUNDLED_LIBRARY_NAME_MAPPER
/* 132 */         .get("default"), name -> name, name -> Architecture.current.is64Bit ? name : (name + "32"));
/*     */ 
/*     */ 
/*     */     
/* 136 */     bundledLibraryPathMapper = getMapper(Configuration.BUNDLED_LIBRARY_PATH_MAPPER
/* 137 */         .get("default"), name -> current.nativePath + "/" + Architecture.current.name().toLowerCase() + "/" + name, name -> name.substring(name.lastIndexOf('/')));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Platform(String name, String nativePath) {
/* 147 */     this.name = name;
/* 148 */     this.nativePath = nativePath;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 153 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Platform get() {
/* 160 */     return current;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Architecture getArchitecture() {
/* 165 */     return Architecture.current;
/*     */   }
/*     */   
/*     */   public static String mapLibraryNameBundled(String name) {
/* 169 */     return bundledLibraryNameMapper.apply(name);
/*     */   }
/*     */   
/*     */   static String mapLibraryPathBundled(String name) {
/* 173 */     return bundledLibraryPathMapper.apply(name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Function<String, String> getMapper(Object mapper, Function<String, String> defaultMapper, Function<String, String> legacyMapper) {
/* 182 */     if (mapper == null || "default".equals(mapper)) {
/* 183 */       return defaultMapper;
/*     */     }
/*     */     
/* 186 */     if ("legacy".equals(mapper)) {
/* 187 */       return legacyMapper;
/*     */     }
/*     */     
/* 190 */     if (mapper instanceof Function) {
/* 191 */       return (Function<String, String>)mapper;
/*     */     }
/*     */     
/* 194 */     String className = mapper.toString();
/*     */     try {
/* 196 */       return 
/* 197 */         Class.forName(className)
/* 198 */         .getConstructor(new Class[0])
/* 199 */         .newInstance(new Object[0]);
/* 200 */     } catch (Throwable t) {
/* 201 */       if (Checks.DEBUG) {
/* 202 */         t.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */       }
/* 204 */       APIUtil.apiLog(String.format("Warning: Failed to instantiate bundled library mapper: %s. Using the default.", new Object[] { className }));
/* 205 */       return defaultMapper;
/*     */     } 
/*     */   }
/*     */   
/*     */   abstract String mapLibraryName(String paramString);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Platform.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
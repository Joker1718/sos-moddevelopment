/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.function.Supplier;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LibraryResource
/*     */ {
/*     */   static {
/*  27 */     Library.initialize();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Path load(String module, String name) {
/*  34 */     return load(LibraryResource.class, module, name);
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
/*     */   public static Path load(Class<?> context, String module, String name) {
/*  50 */     return load(context, module, name, false, true);
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
/*     */   public static Path load(Class<?> context, String module, String name, boolean bundledWithLWJGL) {
/*  68 */     return load(context, module, name, bundledWithLWJGL, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Path load(Class<?> context, String module, String name, boolean bundledWithLWJGL, boolean printError) {
/*  73 */     if (Checks.DEBUG) {
/*  74 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library resource: " + name + "\n\tModule: " + module + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     Path path = Paths.get(name, new String[0]);
/*  83 */     if (path.isAbsolute()) {
/*  84 */       if (!Files.exists(path, new java.nio.file.LinkOption[0])) {
/*  85 */         if (printError) {
/*  86 */           printError();
/*     */         }
/*  88 */         throw new IllegalStateException("Failed to locate library resource: " + name);
/*     */       } 
/*  90 */       APIUtil.apiLogMore("Success");
/*  91 */       return path;
/*     */     } 
/*     */ 
/*     */     
/*  95 */     URL resourceURL = Library.findResource(context, module, name, bundledWithLWJGL);
/*  96 */     if (resourceURL == null) {
/*  97 */       path = loadFromLibraryPath(module, name, bundledWithLWJGL);
/*  98 */       if (path != null) {
/*  99 */         return path;
/*     */       }
/*     */     } else {
/* 102 */       boolean debugLoader = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue();
/*     */       try {
/* 104 */         String regular = Library.getRegularFilePath(resourceURL);
/* 105 */         if (regular != null) {
/* 106 */           APIUtil.apiLogMore("Loaded from classpath: " + regular);
/* 107 */           return Paths.get(regular, new String[0]);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 112 */         if (debugLoader) {
/* 113 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 116 */         try (FileChannel ignored = SharedLibraryLoader.load(name, name, resourceURL, null)) {
/* 117 */           path = loadFromLibraryPath(module, name, bundledWithLWJGL);
/* 118 */           if (path != null) {
/* 119 */             return path;
/*     */           }
/*     */         } 
/* 122 */       } catch (Exception e) {
/* 123 */         if (debugLoader) {
/* 124 */           e.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 130 */     String paths = System.getProperty("java.library.path");
/* 131 */     if (paths != null) {
/* 132 */       path = load(module, name, bundledWithLWJGL, "java.library.path", paths);
/* 133 */       if (path != null) {
/* 134 */         return path;
/*     */       }
/*     */     } 
/*     */     
/* 138 */     if (printError) {
/* 139 */       printError();
/*     */     }
/* 141 */     throw new IllegalStateException("Failed to locate library resource: " + name);
/*     */   }
/*     */   
/*     */   private static Path loadFromLibraryPath(String module, String libName, boolean bundledWithLWJGL) {
/* 145 */     String paths = Configuration.LIBRARY_PATH.get();
/* 146 */     if (paths == null) {
/* 147 */       return null;
/*     */     }
/* 149 */     return load(module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths);
/*     */   }
/*     */   
/*     */   private static Path load(String module, String name, boolean bundledWithLWJGL, String property, String paths) {
/* 153 */     Path resource = Library.findFile(paths, module, name, bundledWithLWJGL);
/* 154 */     if (resource == null) {
/* 155 */       APIUtil.apiLogMore(name + " not found in " + property + "=" + paths);
/* 156 */       return null;
/*     */     } 
/*     */     
/* 159 */     APIUtil.apiLogMore("Loaded from " + property + ": " + resource);
/* 160 */     return resource;
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
/*     */   public static Path load(Class<?> context, String module, Configuration<String> name, String... defaultNames) {
/* 175 */     return load(context, module, name, (Supplier<Path>)null, defaultNames);
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
/*     */   public static Path load(Class<?> context, String module, Configuration<String> name, Supplier<Path> fallback, String... defaultNames) {
/* 192 */     if (defaultNames.length == 0) {
/* 193 */       throw new IllegalArgumentException("No default names specified.");
/*     */     }
/*     */     
/* 196 */     String resourceName = name.get();
/* 197 */     if (resourceName != null) {
/* 198 */       return load(context, module, resourceName);
/*     */     }
/*     */     
/* 201 */     if (fallback == null && defaultNames.length <= 1) {
/* 202 */       return load(context, module, defaultNames[0]);
/*     */     }
/*     */     
/*     */     try {
/* 206 */       return load(context, module, defaultNames[0], false, false);
/* 207 */     } catch (Throwable t) {
/* 208 */       for (int i = 1; i < defaultNames.length; i++) {
/*     */         try {
/* 210 */           return load(context, module, defaultNames[i], false, (fallback == null && i == defaultNames.length - 1));
/* 211 */         } catch (Throwable throwable) {}
/*     */       } 
/*     */       
/* 214 */       if (fallback != null) {
/* 215 */         return fallback.get();
/*     */       }
/* 217 */       throw t;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void printError() {
/* 222 */     Library.printError("[LWJGL] Failed to load a library resource. Possible solutions:\n\ta) Add the directory that contains the resource to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the resource to the classpath.");
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\LibraryResource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
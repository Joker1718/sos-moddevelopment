/*     */ package org.lwjgl.system;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Enumeration;
/*     */ import java.util.List;
/*     */ import java.util.function.Consumer;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.Manifest;
/*     */ import java.util.regex.Pattern;
/*     */ import org.lwjgl.Version;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Library
/*     */ {
/*  33 */   public static final String JNI_LIBRARY_NAME = Configuration.LIBRARY_NAME.get(Platform.mapLibraryNameBundled("lwjgl"));
/*     */   
/*     */   static final String JAVA_LIBRARY_PATH = "java.library.path";
/*     */   
/*  37 */   private static final Pattern PATH_SEPARATOR = Pattern.compile(File.pathSeparator);
/*     */   
/*  39 */   private static final Pattern NATIVES_JAR = Pattern.compile("/[\\w-]+?-natives-\\w+.jar!/");
/*     */ 
/*     */   
/*  42 */   private static final String EXPECTED_MANIFEST_PLATFORM = Platform.get().name().toLowerCase() + '/' + Platform.getArchitecture().name().toLowerCase();
/*     */   
/*     */   static {
/*  45 */     if (Checks.DEBUG) {
/*  46 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Version: " + 
/*  47 */           Version.getVersion() + "\n\t OS: " + 
/*  48 */           System.getProperty("os.name") + " v" + System.getProperty("os.version") + "\n\tJRE: " + 
/*  49 */           Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\tJVM: " + 
/*  50 */           System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  55 */     loadSystem("org.lwjgl", JNI_LIBRARY_NAME);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void initialize() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void loadSystem(String module, String name) throws UnsatisfiedLinkError {
/*  67 */     loadSystem(System::load, System::loadLibrary, Library.class, module, name);
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
/*     */   public static void loadSystem(Consumer<String> load, Consumer<String> loadLibrary, Class<?> context, String module, String name) throws UnsatisfiedLinkError {
/*  91 */     if (Checks.DEBUG) {
/*  92 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading JNI library: " + name + "\n\tModule: " + module + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     if (Paths.get(name, new String[0]).isAbsolute()) {
/* 101 */       load.accept(name);
/* 102 */       APIUtil.apiLogMore("Success");
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     String libName = Platform.get().mapLibraryName(name);
/*     */     
/* 108 */     boolean bundledWithLWJGL = name.contains("lwjgl");
/*     */ 
/*     */     
/* 111 */     URL libURL = findResource(context, module, libName, bundledWithLWJGL);
/* 112 */     if (libURL == null) {
/* 113 */       if (loadSystemFromLibraryPath(load, context, module, libName, bundledWithLWJGL)) {
/*     */         return;
/*     */       }
/*     */     } else {
/* 117 */       boolean debugLoader = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue();
/*     */       try {
/* 119 */         if (!((Boolean)Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(Boolean.valueOf(false))).booleanValue()) {
/* 120 */           String regular = getRegularFilePath(libURL);
/* 121 */           if (regular != null) {
/* 122 */             load.accept(regular);
/* 123 */             APIUtil.apiLogMore("Loaded from classpath: " + regular);
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         
/* 130 */         if (debugLoader) {
/* 131 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 134 */         try (FileChannel ignored = SharedLibraryLoader.load(name, libName, libURL, load)) {
/* 135 */           if (loadSystemFromLibraryPath(load, context, module, libName, bundledWithLWJGL)) {
/*     */             return;
/*     */           }
/*     */         } 
/* 139 */       } catch (Exception e) {
/* 140 */         if (debugLoader) {
/* 141 */           e.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 146 */     String javaLibraryPath = System.getProperty("java.library.path");
/*     */ 
/*     */     
/* 149 */     if (bundledWithLWJGL && javaLibraryPath != null && 
/* 150 */       loadSystem(load, context, module, getBundledPath(module, libName), false, "java.library.path", javaLibraryPath)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 157 */       loadLibrary.accept(name);
/*     */ 
/*     */ 
/*     */       
/* 161 */       Path libFile = (javaLibraryPath == null) ? null : findFile(javaLibraryPath, module, libName, bundledWithLWJGL);
/* 162 */       if (libFile != null) {
/* 163 */         APIUtil.apiLogMore(String.format("Loaded from %s: %s", new Object[] { "java.library.path", libFile }));
/* 164 */         if (bundledWithLWJGL) {
/* 165 */           checkHash(context, libFile, module, libName);
/*     */         }
/*     */       } else {
/* 168 */         APIUtil.apiLogMore("Loaded from a ClassLoader provided path.");
/*     */       } 
/*     */       return;
/* 171 */     } catch (Throwable t) {
/* 172 */       APIUtil.apiLogMore(libName + " not found in " + "java.library.path");
/*     */ 
/*     */       
/* 175 */       detectPlatformMismatch(context, module);
/* 176 */       printError(true);
/* 177 */       throw new UnsatisfiedLinkError("Failed to locate library: " + libName);
/*     */     } 
/*     */   }
/*     */   private static boolean loadSystemFromLibraryPath(Consumer<String> load, Class<?> context, String module, String libName, boolean bundledWithLWJGL) {
/* 181 */     String paths = Configuration.LIBRARY_PATH.get();
/* 182 */     return (paths != null && loadSystem(load, context, module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths));
/*     */   }
/*     */   
/*     */   private static boolean loadSystem(Consumer<String> load, Class<?> context, String module, String libName, boolean bundledWithLWJGL, String property, String paths) {
/* 186 */     Path libFile = findFile(paths, module, libName, bundledWithLWJGL);
/* 187 */     if (libFile == null) {
/* 188 */       APIUtil.apiLogMore(libName + " not found in " + property + "=" + paths);
/* 189 */       return false;
/*     */     } 
/*     */     
/* 192 */     load.accept(libFile.toAbsolutePath().toString());
/* 193 */     APIUtil.apiLogMore("Loaded from " + property + ": " + libFile);
/* 194 */     if (bundledWithLWJGL) {
/* 195 */       checkHash(context, libFile, module, libName);
/*     */     }
/* 197 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SharedLibrary loadNative(String module, String name) {
/* 202 */     return loadNative(Library.class, module, name);
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
/*     */   public static SharedLibrary loadNative(Class<?> context, String module, String name) {
/* 220 */     return loadNative(context, module, name, false);
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
/*     */   public static SharedLibrary loadNative(Class<?> context, String module, String name, boolean bundledWithLWJGL) {
/* 239 */     return loadNative(context, module, name, bundledWithLWJGL, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SharedLibrary loadNative(Class<?> context, String module, String name, boolean bundledWithLWJGL, boolean printError) {
/* 244 */     if (Checks.DEBUG) {
/* 245 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Loading library: " + name + "\n\tModule: " + module + "\n");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 253 */     if (Paths.get(name, new String[0]).isAbsolute()) {
/* 254 */       SharedLibrary lib = APIUtil.apiCreateLibrary(name);
/* 255 */       APIUtil.apiLogMore("Success");
/* 256 */       return lib;
/*     */     } 
/*     */     
/* 259 */     String libName = Platform.get().mapLibraryName(name);
/*     */ 
/*     */ 
/*     */     
/* 263 */     URL libURL = findResource(context, module, libName, bundledWithLWJGL);
/* 264 */     if (libURL == null) {
/* 265 */       SharedLibrary lib = loadNativeFromLibraryPath(context, module, libName, bundledWithLWJGL);
/* 266 */       if (lib != null) {
/* 267 */         return lib;
/*     */       }
/*     */     } else {
/* 270 */       boolean debugLoader = ((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue();
/*     */       try {
/* 272 */         if (!((Boolean)Configuration.SHARED_LIBRARY_EXTRACT_FORCE.get(Boolean.valueOf(false))).booleanValue()) {
/* 273 */           String regular = getRegularFilePath(libURL);
/* 274 */           if (regular != null) {
/* 275 */             SharedLibrary lib = APIUtil.apiCreateLibrary(regular);
/* 276 */             APIUtil.apiLogMore("Loaded from classpath: " + regular);
/* 277 */             return lib;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 283 */         if (debugLoader) {
/* 284 */           APIUtil.apiLogMore("Using SharedLibraryLoader...");
/*     */         }
/*     */         
/* 287 */         try (FileChannel ignored = SharedLibraryLoader.load(name, libName, libURL, null)) {
/* 288 */           SharedLibrary lib = loadNativeFromLibraryPath(context, module, libName, bundledWithLWJGL);
/* 289 */           if (lib != null) {
/* 290 */             return lib;
/*     */           }
/*     */         } 
/* 293 */       } catch (Exception e) {
/* 294 */         if (debugLoader) {
/* 295 */           e.printStackTrace(APIUtil.DEBUG_STREAM);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 301 */     if (!bundledWithLWJGL) {
/* 302 */       SharedLibrary lib = loadNativeFromSystem(libName);
/* 303 */       if (lib != null) {
/* 304 */         return lib;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 310 */     if (((Boolean)Configuration.EMULATE_SYSTEM_LOADLIBRARY.get(Boolean.valueOf(false))).booleanValue()) {
/*     */       
/*     */       try {
/* 313 */         Method findLibrary = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[] { String.class });
/* 314 */         findLibrary.setAccessible(true);
/*     */         
/* 316 */         String libPath = (String)findLibrary.invoke(context.getClassLoader(), new Object[] { name });
/* 317 */         if (libPath != null) {
/* 318 */           SharedLibrary lib = APIUtil.apiCreateLibrary(libPath);
/* 319 */           APIUtil.apiLogMore("Loaded from ClassLoader provided path: " + libPath);
/* 320 */           return lib;
/*     */         } 
/* 322 */       } catch (Exception exception) {}
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 328 */     String paths = System.getProperty("java.library.path");
/* 329 */     if (paths != null) {
/* 330 */       SharedLibrary lib = loadNative(context, module, libName, bundledWithLWJGL, "java.library.path", paths);
/* 331 */       if (lib != null) {
/* 332 */         return lib;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 338 */     if (bundledWithLWJGL) {
/* 339 */       SharedLibrary lib = loadNativeFromSystem(libName);
/* 340 */       if (lib != null) {
/* 341 */         return lib;
/*     */       }
/*     */     } 
/*     */     
/* 345 */     if (printError) {
/* 346 */       detectPlatformMismatch(context, module);
/* 347 */       printError(bundledWithLWJGL);
/*     */     } 
/* 349 */     throw new UnsatisfiedLinkError("Failed to locate library: " + libName);
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadNativeFromSystem(String libName) {
/*     */     SharedLibrary lib;
/*     */     try {
/* 355 */       lib = APIUtil.apiCreateLibrary(libName);
/* 356 */       String path = lib.getPath();
/* 357 */       APIUtil.apiLogMore((path == null) ? "Loaded from system paths" : ("Loaded from system paths: " + path));
/*     */     
/*     */     }
/* 360 */     catch (UnsatisfiedLinkError e) {
/* 361 */       lib = null;
/* 362 */       APIUtil.apiLogMore(libName + " not found in system paths");
/*     */     } 
/* 364 */     return lib;
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadNativeFromLibraryPath(Class<?> context, String module, String libName, boolean bundledWithLWJGL) {
/* 368 */     String paths = Configuration.LIBRARY_PATH.get();
/* 369 */     if (paths == null) {
/* 370 */       return null;
/*     */     }
/* 372 */     return loadNative(context, module, libName, bundledWithLWJGL, Configuration.LIBRARY_PATH.getProperty(), paths);
/*     */   }
/*     */   
/*     */   private static SharedLibrary loadNative(Class<?> context, String module, String libName, boolean bundledWithLWJGL, String property, String paths) {
/* 376 */     Path libFile = findFile(paths, module, libName, bundledWithLWJGL);
/* 377 */     if (libFile == null) {
/* 378 */       APIUtil.apiLogMore(libName + " not found in " + property + "=" + paths);
/* 379 */       return null;
/*     */     } 
/*     */     
/* 382 */     SharedLibrary lib = APIUtil.apiCreateLibrary(libFile.toAbsolutePath().toString());
/* 383 */     APIUtil.apiLogMore("Loaded from " + property + ": " + libFile);
/* 384 */     if (bundledWithLWJGL) {
/* 385 */       checkHash(context, libFile, module, libName);
/*     */     }
/* 387 */     return lib;
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
/*     */   public static SharedLibrary loadNative(Class<?> context, String module, Configuration<String> name, String... defaultNames) {
/* 402 */     return loadNative(context, module, name, (Supplier<SharedLibrary>)null, defaultNames);
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
/*     */   public static SharedLibrary loadNative(Class<?> context, String module, Configuration<String> name, Supplier<SharedLibrary> fallback, String... defaultNames) {
/* 419 */     if (name != null) {
/* 420 */       String libraryName = name.get();
/* 421 */       if (libraryName != null) {
/* 422 */         return loadNative(context, module, libraryName, false);
/*     */       }
/*     */     } 
/*     */     
/* 426 */     if (defaultNames.length == 0) {
/* 427 */       if (fallback == null) {
/* 428 */         throw new IllegalArgumentException("No fallback library supplier specified.");
/*     */       }
/* 430 */       return fallback.get();
/*     */     } 
/*     */     
/* 433 */     if (fallback == null && defaultNames.length == 1) {
/* 434 */       return loadNative(context, module, defaultNames[0], false);
/*     */     }
/*     */     
/*     */     try {
/* 438 */       return loadNative(context, module, defaultNames[0], false, false);
/* 439 */     } catch (Throwable t) {
/* 440 */       for (int i = 1; i < defaultNames.length; i++) {
/*     */         try {
/* 442 */           return loadNative(context, module, defaultNames[i], false, (fallback == null && i == defaultNames.length - 1));
/* 443 */         } catch (Throwable throwable) {}
/*     */       } 
/*     */       
/* 446 */       if (fallback != null) {
/* 447 */         return fallback.get();
/*     */       }
/* 449 */       throw t;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String getBundledPath(String module, String resource) {
/* 454 */     return Platform.mapLibraryPathBundled(module.replace('.', '/') + "/" + resource);
/*     */   }
/*     */   
/*     */   static URL findResource(Class<?> context, String module, String resource, boolean bundledWithLWJGL) {
/* 458 */     URL url = null;
/* 459 */     if (bundledWithLWJGL) {
/* 460 */       String bundledResource = getBundledPath(module, resource);
/* 461 */       if (!bundledResource.equals(resource)) {
/* 462 */         url = context.getClassLoader().getResource(bundledResource);
/*     */       }
/*     */     } 
/* 465 */     return (url == null) ? context.getClassLoader().getResource(resource) : url;
/*     */   }
/*     */   
/*     */   static String getRegularFilePath(URL url) {
/* 469 */     if (url.getProtocol().equals("file")) {
/*     */       try {
/* 471 */         Path path = Paths.get(url.toURI());
/* 472 */         if (path.isAbsolute() && Files.isReadable(path)) {
/* 473 */           return path.toString();
/*     */         }
/* 475 */       } catch (URISyntaxException uRISyntaxException) {}
/*     */     }
/*     */     
/* 478 */     return null;
/*     */   }
/*     */   
/*     */   static Path findFile(String path, String module, String file, boolean bundledWithLWJGL) {
/* 482 */     if (bundledWithLWJGL) {
/* 483 */       String bundledFile = getBundledPath(module, file);
/* 484 */       if (!bundledFile.equals(file)) {
/* 485 */         Path p = findFile(path, bundledFile);
/* 486 */         if (p != null) {
/* 487 */           return p;
/*     */         }
/*     */       } 
/*     */     } 
/* 491 */     return findFile(path, file);
/*     */   }
/*     */   
/*     */   private static Path findFile(String path, String file) {
/* 495 */     for (String directory : PATH_SEPARATOR.split(path)) {
/* 496 */       Path p = Paths.get(directory, new String[] { file });
/* 497 */       if (Files.isReadable(p)) {
/* 498 */         return p;
/*     */       }
/*     */     } 
/* 501 */     return null;
/*     */   }
/*     */   
/*     */   private static void detectPlatformMismatch(Class<?> context, String module) {
/* 505 */     if (!module.startsWith("org.lwjgl")) {
/*     */       return;
/*     */     }
/*     */     
/* 509 */     String moduleTitle = module.equals("org.lwjgl") ? "lwjgl" : ("lwjgl-" + module.substring("org.lwjgl.".length()));
/*     */     
/* 511 */     List<String> platforms = new ArrayList<>(8);
/*     */     try {
/* 513 */       Enumeration<URL> manifests = context.getClassLoader().getResources("META-INF/MANIFEST.MF");
/* 514 */       while (manifests.hasMoreElements()) {
/* 515 */         try (InputStream is = ((URL)manifests.nextElement()).openStream()) {
/* 516 */           Manifest manifest = new Manifest(is);
/* 517 */           Attributes attribs = manifest.getMainAttributes();
/*     */           
/* 519 */           if (moduleTitle.equals(attribs.getValue("Implementation-Title"))) {
/* 520 */             String jarPlatform = attribs.getValue("LWJGL-Platform");
/* 521 */             if (jarPlatform != null && !EXPECTED_MANIFEST_PLATFORM.equals(jarPlatform)) {
/* 522 */               platforms.add(jarPlatform);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/* 527 */     } catch (IOException iOException) {}
/*     */ 
/*     */     
/* 530 */     if (!platforms.isEmpty()) {
/* 531 */       APIUtil.DEBUG_STREAM.print("[LWJGL] Platform/architecture mismatch detected for module: " + module + "\n\tJVM platform:\t\t" + 
/*     */ 
/*     */           
/* 534 */           Platform.get().getName() + " " + System.getProperty("os.arch") + " " + System.getProperty("java.version") + "\n\t\t" + 
/* 535 */           System.getProperty("java.vm.name") + " v" + System.getProperty("java.vm.version") + " by " + System.getProperty("java.vm.vendor") + "\n\tPlatform" + (
/* 536 */           (platforms.size() == 1) ? "" : "s") + " available on classpath:\n\t\t" + String.join("\n\t\t", (Iterable)platforms) + "\n");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printError(boolean bundledWithLWJGL) {
/* 542 */     printError("[LWJGL] Failed to load a library. Possible solutions:\n" + (bundledWithLWJGL ? "\ta) Add the directory that contains the shared library to -Djava.library.path or -Dorg.lwjgl.librarypath.\n\tb) Add the JAR that contains the shared library to the classpath." : "\ta) Install the library or the driver that provides the library.\n\tb) Ensure that the library is accessible from the system library paths."));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void printError(String message) {
/* 553 */     StringBuilder sb = new StringBuilder(message);
/* 554 */     sb.append("\n");
/*     */     
/* 556 */     if (!Checks.DEBUG) {
/* 557 */       sb.append("[LWJGL] Enable debug mode with -Dorg.lwjgl.util.Debug=true for better diagnostics.\n");
/* 558 */       if (!((Boolean)Configuration.DEBUG_LOADER.get(Boolean.valueOf(false))).booleanValue()) {
/* 559 */         sb.append("[LWJGL] Enable the SharedLibraryLoader debug mode with -Dorg.lwjgl.util.DebugLoader=true for better diagnostics.\n");
/*     */       }
/*     */     } 
/*     */     
/* 563 */     APIUtil.DEBUG_STREAM.print(sb);
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
/*     */   private static void checkHash(Class<?> context, Path libFile, String module, String libName) {
/* 575 */     if (((Boolean)Configuration.DISABLE_HASH_CHECKS.get(Boolean.valueOf(!Checks.CHECKS))).booleanValue()) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/* 580 */       URL classesURL = null;
/* 581 */       URL nativesURL = null;
/*     */       
/* 583 */       Enumeration<URL> resources = context.getClassLoader().getResources("META-INF/" + getBundledPath(module, libName) + ".sha1");
/* 584 */       while (resources.hasMoreElements()) {
/* 585 */         URL url = resources.nextElement();
/* 586 */         if (NATIVES_JAR.matcher(url.toExternalForm()).find()) {
/* 587 */           nativesURL = url; continue;
/*     */         } 
/* 589 */         classesURL = url;
/*     */       } 
/*     */       
/* 592 */       if (classesURL == null) {
/*     */         return;
/*     */       }
/*     */       
/* 596 */       byte[] expected = getSHA1(classesURL);
/*     */ 
/*     */       
/* 599 */       byte[] actual = (Checks.DEBUG || nativesURL == null) ? getSHA1(libFile) : getSHA1(nativesURL);
/*     */       
/* 601 */       if (!Arrays.equals(expected, actual)) {
/* 602 */         APIUtil.DEBUG_STREAM.println("[LWJGL] [ERROR] Incompatible Java and native library versions detected.\nPossible reasons:\n\ta) -Djava.library.path is set to a folder containing shared libraries of an older LWJGL version.\n\tb) The classpath contains jar files of an older LWJGL version.\nPossible solutions:\n\ta) Make sure to not set -Djava.library.path (it is not needed for developing with LWJGL 3) or make\n\t   sure the folder it points to contains the shared libraries of the correct LWJGL version.\n\tb) Check the classpath and make sure to only have jar files of the same LWJGL version in it.");
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 612 */     catch (Throwable t) {
/* 613 */       if (Checks.DEBUG) {
/* 614 */         APIUtil.apiLog("Failed to verify native library.");
/* 615 */         t.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static byte[] getSHA1(URL hashURL) throws IOException {
/* 621 */     byte[] hash = new byte[20];
/* 622 */     try (InputStream sha1 = hashURL.openStream()) {
/* 623 */       for (int i = 0; i < 20; i++) {
/* 624 */         hash[i] = (byte)(Character.digit(sha1.read(), 16) << 4 | Character.digit(sha1.read(), 16));
/*     */       }
/*     */     } 
/* 627 */     return hash;
/*     */   }
/*     */   
/*     */   private static byte[] getSHA1(Path libFile) throws NoSuchAlgorithmException, IOException {
/* 631 */     MessageDigest digest = MessageDigest.getInstance("SHA-1");
/* 632 */     try (InputStream input = Files.newInputStream(libFile, new java.nio.file.OpenOption[0])) {
/* 633 */       byte[] buffer = new byte[8192]; int n;
/* 634 */       while ((n = input.read(buffer)) != -1) {
/* 635 */         digest.update(buffer, 0, n);
/*     */       }
/*     */     } 
/* 638 */     return digest.digest();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\system\Library.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
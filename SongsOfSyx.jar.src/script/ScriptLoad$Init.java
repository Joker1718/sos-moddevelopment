/*     */ package script;
/*     */ 
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.net.URL;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarInputStream;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
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
/*     */ class Init
/*     */ {
/*  46 */   private final PATH pathRoot = (PATHS.SCRIPT()).jar;
/*  47 */   private final LinkedList<ScriptLoad> all = new LinkedList();
/*  48 */   private final LinkedList<URL> urlList = new LinkedList();
/*  49 */   private final KeyMap<String> classToJar = new KeyMap();
/*     */   
/*     */   Init() {
/*  52 */     forceInit(SCRIPT.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private LIST<ScriptLoad> compileScripts(String... files) {
/*  57 */     files = grabCachedScripts(files);
/*     */     
/*  59 */     if (files.length == 0)
/*  60 */       return (LIST<ScriptLoad>)this.all;  byte b; int i;
/*     */     String[] arrayOfString;
/*  62 */     for (i = (arrayOfString = files).length, b = 0; b < i; ) { String file = arrayOfString[b];
/*     */       
/*  64 */       JarInputStream jarFile = copyAndMakeJarUrl(file);
/*  65 */       if (jarFile != null)
/*     */         
/*     */         try {
/*     */           
/*  69 */           JarEntry je = jarFile.getNextJarEntry();
/*     */           
/*  71 */           while (je != null) {
/*  72 */             JarEntry jarEntry = je;
/*  73 */             je = jarFile.getNextJarEntry();
/*  74 */             if (jarEntry.getName().contains("META-INF"))
/*     */               continue; 
/*  76 */             processJarEntry(jarEntry, file);
/*     */           } 
/*     */           
/*  79 */           jarFile.close();
/*     */         }
/*  81 */         catch (IOException e) {
/*  82 */           LOG.err("script: " + String.valueOf(this.pathRoot.get()) + File.separator + file + " unable to cache!");
/*  83 */           e.printStackTrace();
/*     */         }  
/*     */       b++; }
/*     */     
/*  87 */     loadScripts();
/*     */     
/*  89 */     ScriptLoad.cache.clear();
/*     */     
/*  91 */     for (ScriptLoad l : this.all) {
/*  92 */       if (!ScriptLoad.cache.containsKey(l.file))
/*  93 */         ScriptLoad.cache.put(l.file, new LinkedList()); 
/*  94 */       ((LinkedList)ScriptLoad.cache.get(l.file)).add(l);
/*     */     } 
/*     */     
/*  97 */     return (LIST<ScriptLoad>)this.all;
/*     */   }
/*     */   
/*     */   private String[] grabCachedScripts(String... files) {
/* 101 */     int uninited = 0; byte b; int i;
/*     */     String[] arrayOfString1;
/* 103 */     for (i = (arrayOfString1 = files).length, b = 0; b < i; ) { String f = arrayOfString1[b];
/* 104 */       if (ScriptLoad.cache.containsKey(f)) {
/* 105 */         this.all.add((Iterable)ScriptLoad.cache.get(f));
/*     */       } else {
/* 107 */         uninited++;
/*     */       }  b++; }
/*     */     
/* 110 */     String[] nFiles = new String[uninited];
/* 111 */     uninited = 0; String[] arrayOfString2;
/* 112 */     for (int j = (arrayOfString2 = files).length; i < j; ) { String f = arrayOfString2[i];
/* 113 */       if (!ScriptLoad.cache.containsKey(f)) {
/* 114 */         nFiles[uninited++] = f;
/*     */       }
/*     */       i++; }
/*     */     
/* 118 */     return nFiles;
/*     */   }
/*     */ 
/*     */   
/*     */   private void loadScripts() {
/* 123 */     LOG.ln("SCRIPTS");
/*     */     
/* 125 */     ClassLoader loader = ClassLoader.getSystemClassLoader();
/*     */     
/* 127 */     for (String className : this.classToJar.keys()) {
/*     */       Class<?> s;
/*     */       try {
/* 130 */         s = loader.loadClass(className);
/* 131 */       } catch (ClassNotFoundException e1) {
/* 132 */         throw new RuntimeException(e1);
/*     */       } 
/*     */       
/* 135 */       if (SCRIPT.class.isAssignableFrom(s) && !Modifier.isAbstract(s.getModifiers())) {
/*     */         try {
/* 137 */           SCRIPT sc = s.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
/* 138 */           this.all.add(new ScriptLoad(sc, className, (String)this.classToJar.get(className)));
/* 139 */           LOG.ln(" -script available: : " + String.valueOf(sc.name()));
/* 140 */         } catch (IllegalAccessException e) {
/* 141 */           throw new Errors.DataError(className + " could not be created. Probably cause would be a non-public constructor, or constructor parameters", (String)this.classToJar.get(className));
/* 142 */         } catch (Exception e) {
/* 143 */           e.printStackTrace();
/* 144 */           throw new RuntimeException("some weirdness with loading scripts. See std err");
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private JarInputStream copyAndMakeJarUrl(String jarFile) {
/* 153 */     if (!this.pathRoot.exists(jarFile)) {
/* 154 */       LOG.err("script: " + String.valueOf(this.pathRoot.get()) + File.separator + jarFile + " does not exist and will be ignored.");
/* 155 */       return null;
/*     */     } 
/* 157 */     LOG.ln("loading script jar " + jarFile);
/*     */     
/*     */     try {
/* 160 */       Path p = this.pathRoot.get(jarFile);
/* 161 */       this.urlList.add(p.toUri().toURL());
/* 162 */       return new JarInputStream(Files.newInputStream(p, new java.nio.file.OpenOption[0]));
/* 163 */     } catch (IOException e) {
/* 164 */       LOG.err("script: " + String.valueOf(this.pathRoot.get()) + File.separator + jarFile + " unable to cache! Ignoring.");
/* 165 */       e.printStackTrace();
/*     */ 
/*     */       
/* 168 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void processJarEntry(JarEntry jarEntry, String jarFile) {
/* 173 */     if (jarEntry.getName().endsWith(".class")) {
/* 174 */       String className = jarEntry.getName();
/* 175 */       className = jarEntry.getName().substring(0, jarEntry.getName().length() - 6);
/* 176 */       className = className.replaceAll("/", "\\.");
/*     */       
/* 178 */       if (this.classToJar.containsKey(className)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 186 */         if (Class.forName(className) != null) {
/* 187 */           throw new Errors.DataError(className + " already exist in the game and will clash with the game. This class needs to be renamed", this.pathRoot.get(jarFile));
/*     */         }
/* 189 */       } catch (Exception exception) {
/*     */       
/* 191 */       } catch (NoClassDefFoundError e) {
/* 192 */         throw new Errors.DataError(className + " could not be loaded.", this.pathRoot.get(jarFile));
/*     */       } 
/*     */       
/* 195 */       this.classToJar.put(className, jarFile);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static <T> Class<T> forceInit(Class<T> klass) {
/*     */     try {
/* 201 */       Class.forName(klass.getName(), true, klass.getClassLoader());
/* 202 */     } catch (ClassNotFoundException e) {
/* 203 */       throw new AssertionError(e);
/*     */     } 
/* 205 */     return klass;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\script\ScriptLoad$Init.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
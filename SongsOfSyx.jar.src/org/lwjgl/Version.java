/*     */ package org.lwjgl;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Objects;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.Manifest;
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
/*     */ public final class Version
/*     */ {
/*     */   public static final int VERSION_MAJOR = 3;
/*     */   public static final int VERSION_MINOR = 4;
/*     */   public static final int VERSION_REVISION = 1;
/*  24 */   public static final BuildType BUILD_TYPE = BuildType.STABLE;
/*     */ 
/*     */   
/*  27 */   private static final String versionPlain = String.valueOf(3) + '.' + '\004' + '.' + '\001' + BUILD_TYPE.postfix;
/*     */ 
/*     */ 
/*     */   
/*  31 */   private static final String version = versionPlain + VersionImpl.find();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  37 */     System.out.println(version);
/*  38 */     System.err.println(versionPlain);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getVersion() {
/*  43 */     return version;
/*     */   }
/*     */ 
/*     */   
/*     */   public enum BuildType
/*     */   {
/*  49 */     ALPHA("a"),
/*     */     
/*  51 */     BETA("b"),
/*     */     
/*  53 */     STABLE("");
/*     */     
/*     */     public final String postfix;
/*     */     
/*     */     BuildType(String postfix) {
/*  58 */       this.postfix = postfix;
/*     */     }
/*     */   }
/*     */   
/*     */   static String createImplementation(String specVersion, String implVersion) {
/*  63 */     String build = "+" + ((implVersion.startsWith("build ") && 6 < implVersion.length()) ? implVersion.substring(6) : implVersion);
/*     */     
/*  65 */     if (specVersion.contains("SNAPSHOT") || specVersion.contains("snapshot")) {
/*  66 */       return "-snapshot" + build;
/*     */     }
/*     */     
/*  69 */     return build;
/*     */   }
/*     */   
/*     */   static String findImplementationFromManifest() {
/*  73 */     ClassLoader classLoader = Version.class.getClassLoader();
/*     */     
/*  75 */     URL url = classLoader.getResource("org/lwjgl/Version.class");
/*  76 */     if (url != null) {
/*  77 */       String classURL = url.toString();
/*     */       try {
/*  79 */         if (classURL.startsWith("jar:")) {
/*  80 */           URL manifest = Version.class.getResource("/META-INF/MANIFEST.MF");
/*     */           
/*  82 */           String version = readImplementationFromManifest(Objects.<URL>requireNonNull(manifest));
/*  83 */           if (version != null) {
/*  84 */             return version;
/*     */           }
/*  86 */         } else if (classURL.startsWith("resource:")) {
/*  87 */           Enumeration<URL> e = classLoader.getResources("META-INF/MANIFEST.MF");
/*  88 */           while (e.hasMoreElements()) {
/*  89 */             String version = readImplementationFromManifest(e.nextElement());
/*  90 */             if (version != null) {
/*  91 */               return version;
/*     */             }
/*     */           } 
/*     */         } 
/*  95 */       } catch (Exception exception) {}
/*     */     } 
/*     */ 
/*     */     
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   private static String readImplementationFromManifest(URL url) {
/* 103 */     try (InputStream stream = url.openStream()) {
/* 104 */       Attributes attribs = (new Manifest(stream)).getMainAttributes();
/*     */ 
/*     */       
/* 107 */       if (!"lwjgl".equals(attribs.getValue(Attributes.Name.IMPLEMENTATION_TITLE))) {
/* 108 */         return null;
/*     */       }
/* 110 */       if (!"lwjgl.org".equals(attribs.getValue(Attributes.Name.IMPLEMENTATION_VENDOR))) {
/* 111 */         return null;
/*     */       }
/*     */       
/* 114 */       String specVersion = attribs.getValue(Attributes.Name.SPECIFICATION_VERSION);
/* 115 */       String implVersion = attribs.getValue(Attributes.Name.IMPLEMENTATION_VERSION);
/* 116 */       if (specVersion == null || implVersion == null) {
/* 117 */         return null;
/*     */       }
/*     */       
/* 120 */       return createImplementation(specVersion, implVersion);
/* 121 */     } catch (Exception ignored) {
/* 122 */       return null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\Version.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
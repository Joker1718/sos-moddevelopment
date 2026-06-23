/*     */ package util.text;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.settings.S;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class D
/*     */ {
/*     */   private static Json currentJson;
/*     */   private static String currentClass;
/*     */   private static Json dd;
/*     */   private static boolean first = true;
/*     */   private static String old;
/*     */   
/*     */   public static void init() {
/*  21 */     dd = new Json(PATHS.TEXT().getFolder("dictionary").gets("Dic"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void gInit(Class<?> clazz) {
/*  27 */     if (dd == null)
/*     */       return; 
/*  29 */     if (!dd.has(clazz.getName())) {
/*  30 */       if ((S.get()).debug) {
/*  31 */         LOG.err("No mapping for class: " + clazz.getName());
/*  32 */         if (first)
/*  33 */           (new RuntimeException()).printStackTrace(System.out); 
/*  34 */         first = false;
/*     */       } 
/*  36 */       currentJson = null;
/*  37 */       currentClass = null;
/*     */     } else {
/*  39 */       currentClass = clazz.getName();
/*  40 */       currentJson = dd.json(clazz.getName());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void gInit(Object clazz) {
/*  45 */     gInit(clazz.getClass());
/*     */   }
/*     */   
/*     */   public static CharSequence g(String key, String def) {
/*  49 */     if (dd == null)
/*  50 */       return def; 
/*  51 */     return g(key);
/*     */   }
/*     */   
/*     */   public static CharSequence g(String defKey) {
/*  55 */     if (dd == null)
/*  56 */       return defKey; 
/*  57 */     if (currentJson == null || !currentJson.has(defKey)) {
/*  58 */       if ((S.get()).debug || (S.get()).developer) {
/*     */         
/*  60 */         String ss = ""; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/*  61 */         for (i = (arrayOfStackTraceElement = Thread.currentThread().getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/*  62 */           if (!e.getClassName().equals(D.class.getName()) && e.getClassName().indexOf(".Thread") < 0) {
/*  63 */             ss = "(" + e.getClassName() + ".java:" + e.getLineNumber() + ")"; break;
/*     */           } 
/*     */           b++; }
/*     */         
/*  67 */         LOG.err("No mapping " + currentClass + " " + defKey + " " + ss);
/*     */       } 
/*  69 */       return defKey;
/*     */     } 
/*  71 */     return currentJson.text(defKey);
/*     */   }
/*     */   
/*     */   public static void t(Object clazz) {
/*  75 */     t(clazz.getClass(), clazz);
/*     */   }
/*     */   
/*     */   public static void t(Class<?> clazz) {
/*  79 */     t(clazz, null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String ts(Class<?> clazz) {
/*  85 */     String c = currentClass;
/*  86 */     t(clazz);
/*  87 */     if (c != null && dd != null) {
/*  88 */       currentClass = c;
/*  89 */       if (dd.has(c)) {
/*  90 */         currentJson = dd.json(c);
/*     */       } else {
/*  92 */         currentJson = null;
/*     */       } 
/*  94 */     }  return "";
/*     */   }
/*     */   
/*     */   public static void spush(Class<?> clazz) {
/*  98 */     old = currentClass;
/*  99 */     t(clazz);
/*     */   }
/*     */   
/*     */   public static void spop() {
/* 103 */     if (old != null && dd != null) {
/* 104 */       currentClass = old;
/* 105 */       currentJson = dd.json(old);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void t(Class<?> clazz, Object o) {
/* 111 */     gInit(clazz);
/* 112 */     if (currentJson == null)
/*     */       return;  byte b; int i;
/*     */     Field[] arrayOfField;
/* 115 */     for (i = (arrayOfField = clazz.getDeclaredFields()).length, b = 0; b < i; ) { Field f = arrayOfField[b];
/*     */       
/* 117 */       if (CharSequence.class.isAssignableFrom(f.getType())) {
/* 118 */         String s = f.getName();
/* 119 */         if (s.length() > 1 && s.charAt(0) == '¤' && s.charAt(1) == '¤') {
/* 120 */           f.setAccessible(true);
/* 121 */           s = s.substring(2, s.length());
/* 122 */           CharSequence v = g(s);
/*     */           
/*     */           try {
/* 125 */             if (o == null && !Modifier.isStatic(f.getModifiers()))
/* 126 */               throw new RuntimeException(String.valueOf(clazz) + " " + String.valueOf(clazz) + " is not Static"); 
/* 127 */             f.set(o, v);
/* 128 */           } catch (IllegalArgumentException e) {
/* 129 */             throw new RuntimeException(e);
/*     */           }
/* 131 */           catch (IllegalAccessException e) {
/* 132 */             throw new RuntimeException(e);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\D.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
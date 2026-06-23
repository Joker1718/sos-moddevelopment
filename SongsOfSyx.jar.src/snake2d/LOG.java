/*     */ package snake2d;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class LOG
/*     */ {
/*     */   private static String lasth;
/*  13 */   private static int li = 0;
/*  14 */   private static int lln = 0;
/*  15 */   private static String tab = "      ";
/*     */   
/*     */   public static void ln() {
/*  18 */     System.out.println();
/*     */   }
/*     */   
/*     */   private static void header(PrintStream o) {
/*  22 */     StackTraceElement[] ee = (new RuntimeException()).getStackTrace();
/*  23 */     String s = ee[2].getClassName();
/*  24 */     int ln = 0;
/*  25 */     if (s.contains(".")) {
/*  26 */       String[] ss = s.split("\\.");
/*  27 */       s = ss[ss.length - 1];
/*  28 */       ln = ee[2].getLineNumber();
/*     */     } 
/*  30 */     if (!s.equals(lasth) || li > 10000) {
/*  31 */       o.println();
/*  32 */       o.print("[GAME]");
/*     */       
/*  34 */       String cl = ee[2].getClassName();
/*  35 */       if (cl.indexOf('$') > 0)
/*  36 */         cl = cl.substring(0, cl.indexOf('$')); 
/*  37 */       o.println(" (" + cl + ".java:" + ln + ")");
/*     */       
/*  39 */       li = 0;
/*  40 */       lln = -1;
/*     */     } 
/*  42 */     if (lln != ln) {
/*  43 */       lln = ln;
/*  44 */       String l = "[" + ln + "]";
/*  45 */       o.print(l);
/*  46 */       for (int i = 0; i < tab.length() - l.length(); i++)
/*  47 */         o.print(" "); 
/*     */     } else {
/*  49 */       o.print(tab);
/*     */     } 
/*     */ 
/*     */     
/*  53 */     li++;
/*  54 */     lasth = s;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ln(Object info) {
/*  59 */     header(System.out);
/*  60 */     System.out.println(info);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ln(Object a, Object b) {
/*  66 */     ln(a);
/*  67 */     ln(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void ln(Object a, Object b, Object c) {
/*  72 */     ln(a);
/*  73 */     ln(b);
/*  74 */     ln(c); } public static void ln(Object[] info) {
/*     */     byte b;
/*     */     int i;
/*     */     Object[] arrayOfObject;
/*  78 */     for (i = (arrayOfObject = info).length, b = 0; b < i; ) { Object oo = arrayOfObject[b];
/*  79 */       ln(oo);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public static void err(Object info) {
/*  85 */     header(System.err);
/*  86 */     System.err.println(info);
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
/*     */   public static String bits(long l) {
/*  98 */     String s = "";
/*  99 */     int sp = 0;
/* 100 */     for (int bi = 0; bi < 64; bi++) {
/* 101 */       if (sp == 8) {
/* 102 */         s = String.valueOf(s) + "_";
/* 103 */         sp = 0;
/*     */       } 
/* 105 */       long m = 1L << 63 - bi;
/*     */       
/* 107 */       if ((l & m) != 0L) {
/* 108 */         s = String.valueOf(s) + "1";
/*     */       } else {
/* 110 */         s = String.valueOf(s) + "0";
/*     */       } 
/* 112 */       sp++;
/*     */     } 
/* 114 */     return s;
/*     */   }
/*     */   
/*     */   public static String WS(int spaces) {
/* 118 */     String s = "";
/* 119 */     for (int i = 0; i < spaces; i++)
/* 120 */       s = String.valueOf(s) + " "; 
/* 121 */     return s;
/*     */   }
/*     */   
/*     */   public static String NL() {
/* 125 */     return System.lineSeparator();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\LOG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
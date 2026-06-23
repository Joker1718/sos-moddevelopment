/*     */ package init.value;
/*     */ 
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ public abstract class COMPARATOR
/*     */   implements MAPPED {
/*  10 */   private static LinkedList<COMPARATOR> all = new LinkedList();
/*     */   
/*  12 */   public static final COMPARATOR LESS = new COMPARATOR("LESS", "<")
/*     */     {
/*     */       public boolean passes(double a, double b)
/*     */       {
/*  16 */         return (a < b);
/*     */       }
/*     */ 
/*     */       
/*     */       public double progress(double a, double b) {
/*  21 */         return b / a;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*  27 */   public static final COMPARATOR GREATER = new COMPARATOR("GREATER", ">")
/*     */     {
/*     */       public boolean passes(double a, double b)
/*     */       {
/*  31 */         return (a > b);
/*     */       }
/*     */ 
/*     */       
/*     */       public double progress(double a, double b) {
/*  36 */         return a / b;
/*     */       }
/*     */     };
/*     */   
/*  40 */   public static final COMPARATOR GREATERE = new COMPARATOR("GREATERE", ">=")
/*     */     {
/*     */       public boolean passes(double a, double b)
/*     */       {
/*  44 */         return (a >= b);
/*     */       }
/*     */ 
/*     */       
/*     */       public double progress(double a, double b) {
/*  49 */         return a / b;
/*     */       }
/*     */     };
/*     */   
/*  53 */   public static final COMPARATOR EQUAL = new COMPARATOR("EQUAL", "=")
/*     */     {
/*     */       public boolean passes(double a, double b)
/*     */       {
/*  57 */         return (a == b);
/*     */       }
/*     */ 
/*     */       
/*     */       public double progress(double a, double b) {
/*  62 */         return 1.0D - Math.abs(a - b);
/*     */       }
/*     */     };
/*     */   
/*  66 */   public static final COMPARATOR NEQUAL = new COMPARATOR("NEQUAL", "!=")
/*     */     {
/*     */       public boolean passes(double a, double b)
/*     */       {
/*  70 */         return (a != b);
/*     */       }
/*     */ 
/*     */       
/*     */       public double progress(double a, double b) {
/*  75 */         return ((a == b) ? false : true);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  80 */   public static final RMAP<COMPARATOR> map = new RMAP("COMPARATOR", (LIST)all);
/*     */   
/*     */   public final String KEY;
/*     */   public final String rep;
/*     */   private final int index;
/*     */   
/*     */   private COMPARATOR(String key, String rep) {
/*  87 */     this.rep = rep;
/*  88 */     this.KEY = key;
/*  89 */     this.index = all.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  94 */     return this.index;
/*     */   }
/*     */   
/*     */   public static LIST<COMPARATOR> ALL() {
/*  98 */     return (LIST<COMPARATOR>)all;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract boolean passes(double paramDouble1, double paramDouble2);
/*     */   
/*     */   public abstract double progress(double paramDouble1, double paramDouble2);
/*     */   
/*     */   public String key() {
/* 107 */     return this.KEY;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\COMPARATOR.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
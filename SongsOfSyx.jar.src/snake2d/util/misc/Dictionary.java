/*     */ package snake2d.util.misc;
/*     */ 
/*     */ import java.io.File;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ public final class Dictionary
/*     */ {
/*     */   private final CharSequence[] keys;
/*     */   private final CharSequence[] values;
/*     */   private final String path;
/*     */   
/*     */   private Dictionary(String path) {
/*  16 */     this.path = path;
/*  17 */     Json json = new Json((new File(path)).toPath());
/*  18 */     LIST<String> keys = json.keys();
/*  19 */     this.keys = new CharSequence[keys.size()];
/*  20 */     this.values = new CharSequence[keys.size()];
/*     */     
/*  22 */     Tree<String> t = new Tree<String>(this.values.length)
/*     */       {
/*     */         protected boolean isGreaterThan(String current, String cmp)
/*     */         {
/*  26 */           return (Dictionary.compare(current, cmp) == -1);
/*     */         }
/*     */       };
/*     */     
/*  30 */     for (String s : keys) {
/*  31 */       t.add(s);
/*     */     }
/*     */     
/*  34 */     for (int i = 0; i < this.keys.length; i++) {
/*  35 */       String s = (String)t.pollSmallest();
/*  36 */       this.keys[i] = s;
/*  37 */       this.values[i] = json.text(s);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence get(CharSequence key) {
/*  44 */     int start = 0;
/*  45 */     int length = this.keys.length - 1;
/*     */     
/*  47 */     while (length >= start) {
/*  48 */       int mid = start + (length - start) / 2;
/*     */       
/*  50 */       int c = compare(this.keys[mid], key);
/*     */       
/*  52 */       if (c == 0) {
/*  53 */         return this.values[mid];
/*     */       }
/*     */       
/*  56 */       if (c == -1) {
/*  57 */         length = mid - 1; continue;
/*     */       } 
/*  59 */       start = mid + 1;
/*     */     } 
/*     */     
/*  62 */     notify(key);
/*  63 */     return key;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void notify(CharSequence key) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence camel(CharSequence key) {
/*  74 */     int start = 0;
/*  75 */     int length = this.keys.length - 1;
/*     */     
/*  77 */     while (length >= start) {
/*  78 */       int mid = start + (length - start) / 2;
/*     */       
/*  80 */       int c = compare(this.keys[mid], key);
/*     */       
/*  82 */       if (c == 0) {
/*  83 */         return this.values[mid];
/*     */       }
/*     */       
/*  86 */       if (c == -1) {
/*  87 */         length = mid - 1; continue;
/*     */       } 
/*  89 */       start = mid + 1;
/*     */     } 
/*     */     
/*  92 */     System.err.println("Couldn't find mapping for: " + key);
/*  93 */     System.err.println("in: : " + this.path);
/*  94 */     return key;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int compare(CharSequence current, CharSequence cmp) {
/* 100 */     if (current == null)
/* 101 */       return -1; 
/* 102 */     if (cmp == null) {
/* 103 */       return 1;
/*     */     }
/* 105 */     for (int i = 0; i < current.length(); i++) {
/* 106 */       if (i >= cmp.length())
/* 107 */         return 1; 
/* 108 */       if (current.charAt(i) < cmp.charAt(i))
/* 109 */         return -1; 
/* 110 */       if (current.charAt(i) > cmp.charAt(i))
/* 111 */         return 1; 
/*     */     } 
/* 113 */     return (cmp.length() > current.length()) ? -1 : 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double compareValue(CharSequence s) {
/* 118 */     if (s == null) {
/* 119 */       return -1.0D;
/*     */     }
/* 121 */     double v = 0.0D;
/* 122 */     for (int i = 0; i < s.length(); i++) {
/* 123 */       v += (s.charAt(i) * (s.length() - i));
/*     */     }
/* 125 */     return v;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\misc\Dictionary.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
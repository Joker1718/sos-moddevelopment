/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.PrintWriter;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashSet;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ public class JsonE
/*     */ {
/*  16 */   private final LinkedList<Tuple.TupleImp<String, String>> list = new LinkedList();
/*     */   
/*  18 */   private final HashSet<String> map = new HashSet<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(String key, String value) {
/*  25 */     padd(key, value);
/*     */   }
/*     */ 
/*     */   
/*     */   private void padd(String key, String value) {
/*  30 */     if (this.map.contains(key))
/*  31 */       throw new RuntimeException(" " + key); 
/*  32 */     this.map.add(key);
/*  33 */     this.list.add(new Tuple.TupleImp(key, value));
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(String key, String[] values) {
/*  38 */     add(key, (LIST<String>)new ArrayList((Object[])values));
/*     */   }
/*     */   
/*     */   public void add(String key, LIST<String> values) {
/*  42 */     StringBuilder b = new StringBuilder();
/*  43 */     b.append('[');
/*  44 */     b.append(System.lineSeparator());
/*  45 */     for (String v : values) {
/*  46 */       b.append(v);
/*  47 */       b.append(',');
/*  48 */       b.append(System.lineSeparator());
/*     */     } 
/*  50 */     b.append(']');
/*  51 */     add(key, b.toString());
/*     */   }
/*     */   
/*     */   public void addString(String key, String value) {
/*  55 */     add(key, "\"" + value + "\"");
/*     */   }
/*     */   
/*     */   public void addStrings(String key, String[] values) {
/*  59 */     String[] vvs = new String[values.length];
/*  60 */     for (int i = 0; i < values.length; i++) {
/*  61 */       vvs[i] = "\"" + values[i] + "\"";
/*     */     }
/*  63 */     add(key, vvs);
/*     */   }
/*     */   
/*     */   public boolean has(String key) {
/*  67 */     return this.map.contains(key);
/*     */   }
/*     */   
/*     */   public void add(String key, boolean b) {
/*  71 */     padd(key, b ? "true" : "false");
/*     */   }
/*     */   
/*     */   public void add(String key, int i) {
/*  75 */     padd(key, i);
/*     */   }
/*     */   
/*     */   public void add(String key, int[] is) {
/*  79 */     String[] values = new String[is.length];
/*  80 */     for (int i = 0; i < is.length; i++) {
/*  81 */       values[i] = is[i];
/*     */     }
/*  83 */     add(key, values);
/*     */   }
/*     */   
/*     */   public void add(String key, double d) {
/*  87 */     padd(key, d);
/*     */   }
/*     */   
/*     */   public void add(String key, double[] is) {
/*  91 */     String[] values = new String[is.length];
/*  92 */     for (int i = 0; i < is.length; i++) {
/*  93 */       values[i] = is[i];
/*     */     }
/*  95 */     add(key, values);
/*     */   }
/*     */   
/*     */   public void add(String key, JsonE json) {
/*  99 */     StringBuilder b = new StringBuilder();
/* 100 */     b.append('{');
/* 101 */     b.append(System.lineSeparator());
/* 102 */     b.append(json.toString());
/* 103 */     b.append('}');
/* 104 */     add(key, b.toString());
/*     */   }
/*     */   
/*     */   public void add(String key, JsonE[] jsons) {
/* 108 */     String[] strings = new String[jsons.length];
/* 109 */     for (int i = 0; i < jsons.length; i++) {
/* 110 */       strings[i] = "{" + System.lineSeparator() + jsons[i].toString() + System.lineSeparator() + "}";
/*     */     }
/* 112 */     add(key, strings);
/*     */   }
/*     */   
/*     */   public void addJ(String key, LIST<JsonE> jsons) {
/* 116 */     String[] strings = new String[jsons.size()];
/* 117 */     for (int i = 0; i < jsons.size(); i++) {
/* 118 */       strings[i] = "\t{" + System.lineSeparator() + ((JsonE)jsons.get(i)).toString(2) + System.lineSeparator() + '\t' + "}";
/*     */     }
/* 120 */     add(key, strings);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 125 */     return toString(0);
/*     */   }
/*     */   
/*     */   public String toString(int tabs) {
/* 129 */     StringBuilder b = new StringBuilder();
/* 130 */     for (Tuple.TupleImp<String, String> e : this.list) {
/* 131 */       for (int t = 0; t < tabs; t++)
/* 132 */         b.append('\t'); 
/* 133 */       b.append((String)e.a);
/* 134 */       b.append(':');
/* 135 */       b.append(' ');
/* 136 */       String[] ss = ((String)e.b).split(System.lineSeparator());
/* 137 */       b.append(ss[0]);
/* 138 */       for (int i = 1; i < ss.length; i++) {
/* 139 */         b.append(System.lineSeparator());
/* 140 */         for (int j = 0; j < tabs; j++)
/* 141 */           b.append('\t'); 
/* 142 */         if (i < ss.length - 1)
/* 143 */           b.append('\t'); 
/* 144 */         b.append(ss[i]);
/*     */       } 
/* 146 */       b.append(',');
/* 147 */       b.append(System.lineSeparator());
/*     */     } 
/* 149 */     return b.toString();
/*     */   }
/*     */   
/*     */   public boolean save(String path) {
/*     */     try {
/* 154 */       if ((new File(path)).exists())
/* 155 */         (new File(path)).delete(); 
/* 156 */       PrintWriter out = new PrintWriter(path);
/* 157 */       out.println(toString());
/* 158 */       out.flush();
/* 159 */       out.close();
/* 160 */       return true;
/* 161 */     } catch (FileNotFoundException e) {
/* 162 */       e.printStackTrace();
/* 163 */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean save(Path path) {
/*     */     try {
/* 169 */       Files.deleteIfExists(path);
/* 170 */       PrintWriter out = new PrintWriter(Files.newOutputStream(path, new java.nio.file.OpenOption[0]));
/* 171 */       out.println(toString());
/* 172 */       out.flush();
/* 173 */       out.close();
/* 174 */       return true;
/* 175 */     } catch (Exception e) {
/* 176 */       e.printStackTrace();
/* 177 */       return false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\JsonE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
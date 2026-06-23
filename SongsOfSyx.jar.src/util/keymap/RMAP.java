/*     */ package util.keymap;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.util.Set;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.COLLECTION;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ public class RMAP<T extends MAPPED>
/*     */   implements COLLECTION<T>
/*     */ {
/*     */   public static final String WILDCARD = "*";
/*     */   public final String key;
/*     */   protected final KeyMap<T> map;
/*     */   private final LIST<T> all;
/*     */   private boolean hasErr;
/*     */   
/*     */   public T read(Json reader) {
/*     */     return read(key(), reader);
/*     */   }
/*     */   
/*     */   public T read(String key, Json reader) {
/*     */     String value = reader.value(key);
/*     */     T t = tryGet(value);
/*     */     if (t != null)
/*     */       return t; 
/*     */     String k = "   Available: ";
/*     */     for (String s : available())
/*     */       k = k + k + ", "; 
/*     */     reader.error("no " + key() + " named: " + value + k, key);
/*     */     return null;
/*     */   }
/*     */   
/*     */   public T readTry(String key, Json reader) {
/*     */     if (reader.has(key)) {
/*     */       String value = reader.value(key);
/*     */       T t = tryGet(value);
/*     */       if (t != null)
/*     */         return t; 
/*     */       String k = "   Available: ";
/*     */       for (String s : available())
/*     */         k = k + k + ", "; 
/*     */       GAME.WarnLight(reader.errorGet("no " + key() + " named: " + value + k, key));
/*     */       return null;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public T readTry(Json reader) {
/*     */     return readTry(key(), reader);
/*     */   }
/*     */   
/*     */   public T get(String key, Json error) {
/*     */     T t = tryGet(key);
/*     */     if (t != null)
/*     */       return t; 
/*     */     String k = "   Available: ";
/*     */     for (String s : available())
/*     */       k = k + k + ", "; 
/*     */     key.endsWith(" ");
/*     */     if (error == null)
/*     */       throw new RuntimeException("no " + key() + " named: " + key + (key.endsWith(" ") ? "It ends with space!" : "") + k); 
/*     */     error.error("no " + key() + " named: " + key + (key.endsWith(" ") ? "It ends with space!" : "") + k, key);
/*     */     return null;
/*     */   }
/*     */   
/*     */   public LIST<T> get(String s) {
/*     */     ArrayListGrower<T> res = new ArrayListGrower();
/*     */     if (s.indexOf("*") >= 0) {
/*     */       String beg = s.substring(0, s.indexOf("*"));
/*     */       for (String k : this.map.keys()) {
/*     */         if (k.startsWith(beg)) {
/*     */           MAPPED mAPPED = (MAPPED)this.map.get(k);
/*     */           if (!res.contains(mAPPED))
/*     */             res.add(mAPPED); 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       T t = tryGet(s);
/*     */       if (t != null)
/*     */         res.add(t); 
/*     */     } 
/*     */     return (LIST<T>)res;
/*     */   }
/*     */   
/*     */   public T getWarn(String key, Json reader) {
/*     */     T t = tryGet(key);
/*     */     if (t != null)
/*     */       return t; 
/*     */     String k = "   Available: ";
/*     */     for (String s : available())
/*     */       k = k + k + ", "; 
/*     */     GAME.WarnLight(reader.errorGet("no " + key() + " named: " + key + k, key));
/*     */     return null;
/*     */   }
/*     */   
/*     */   public LIST<T> readMany(String key, Json reader) {
/*     */     if (!reader.has(key))
/*     */       return (LIST<T>)new ArrayList((Object[])new MAPPED[0]); 
/*     */     String[] values = reader.values(key);
/*     */     ArrayListGrower<T> res = new ArrayListGrower();
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString1;
/*     */     for (i = (arrayOfString1 = values).length, b = 0; b < i; ) {
/*     */       String s = arrayOfString1[b];
/*     */       if (s.indexOf("*") >= 0) {
/*     */         String beg = s.substring(0, s.indexOf("*"));
/*     */         for (String k : this.map.keys()) {
/*     */           if (k.startsWith(beg)) {
/*     */             MAPPED mAPPED = (MAPPED)this.map.get(k);
/*     */             if (!res.contains(mAPPED))
/*     */               res.add(mAPPED); 
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         T t = tryGet(s);
/*     */         if (t != null) {
/*     */           res.add(t);
/*     */         } else {
/*     */           String k = "   Available: ";
/*     */           for (String ss : available())
/*     */             k = k + k + ", "; 
/*     */           reader.error("no " + key() + " named: " + s + k, key);
/*     */         } 
/*     */       } 
/*     */       b++;
/*     */     } 
/*     */     return (LIST<T>)res;
/*     */   }
/*     */   
/*     */   public LIST<T> readMany(Json reader) {
/*     */     return readMany(key() + "S", reader);
/*     */   }
/*     */   
/*     */   public LIST<T> readManyWarn(Json reader) {
/*     */     return readManyWarn(key() + "S", reader);
/*     */   }
/*     */   
/*     */   public LIST<T> readManyWarn(String value, Json reader) {
/*     */     if (!reader.has(value))
/*     */       return (LIST<T>)new ArrayList((Object[])new MAPPED[0]); 
/*     */     String[] values = reader.values(value);
/*     */     byte b;
/*     */     int i;
/*     */     String[] arrayOfString1;
/*     */     for (i = (arrayOfString1 = values).length, b = 0; b < i; ) {
/*     */       String v = arrayOfString1[b];
/*     */       if (v.equals("*"))
/*     */         return (LIST<T>)new ArrayList((Iterable)all()); 
/*     */       b++;
/*     */     } 
/*     */     ArrayList<T> res = new ArrayList(values.length);
/*     */     String[] arrayOfString2;
/*     */     for (int j = (arrayOfString2 = values).length; i < j; ) {
/*     */       String v = arrayOfString2[i];
/*     */       LIST<T> t = tryGetMany(v);
/*     */       if (t.size() != 0) {
/*     */         res.add((Iterable)t);
/*     */       } else {
/*     */         String k = "   Available: ";
/*     */         for (String s : available())
/*     */           k = k + k + ", \n"; 
/*     */         GAME.WarnLight(reader.errorGet("no " + key() + " named: " + v + k, v));
/*     */       } 
/*     */       i++;
/*     */     } 
/*     */     return (LIST<T>)res;
/*     */   }
/*     */   
/*     */   public void readFill(double[] res, Json j, double min, double max) {
/*     */     readFill(key(), res, j, min, max);
/*     */   }
/*     */   
/*     */   public void readFill(String key, double[] res, Json j, double min, double max) {}
/*     */   
/*     */   public double[] readFill(Json j, double max) {
/*     */     double[] res = new double[all().size()];
/*     */     readFill(res, j, max);
/*     */     return res;
/*     */   }
/*     */   
/*     */   public void readFill(double[] res, Json j, double max) {
/*     */     readFill(res, j, 0.0D, max);
/*     */   }
/*     */   
/*     */   public boolean[] readIs(Json j) {
/*     */     boolean[] res = new boolean[all().size()];
/*     */     for (MAPPED mAPPED : readMany(j))
/*     */       res[mAPPED.index()] = true; 
/*     */     return res;
/*     */   }
/*     */   
/*     */   public LIST<T> all() {
/*     */     return this.all;
/*     */   }
/*     */   
/*     */   public final T getAt(int index) {
/*     */     return (T)all().get(index);
/*     */   }
/*     */   
/*     */   public T tryGet(String value) {
/*     */     if (this.map.containsKey(value))
/*     */       return (T)this.map.get(value); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public LIST<T> tryGetMany(String s) {
/*     */     ArrayListGrower<T> res = new ArrayListGrower();
/*     */     if (s.indexOf("*") >= 0) {
/*     */       String beg = s.substring(0, s.indexOf("*"));
/*     */       for (String k : this.map.keys()) {
/*     */         if (k.startsWith(beg)) {
/*     */           MAPPED mAPPED = (MAPPED)this.map.get(k);
/*     */           if (!res.contains(mAPPED))
/*     */             res.add(mAPPED); 
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       T t = tryGet(s);
/*     */       if (t != null)
/*     */         res.add(t); 
/*     */     } 
/*     */     return (LIST<T>)res;
/*     */   }
/*     */   
/*     */   public String key() {
/*     */     return this.key;
/*     */   }
/*     */   
/*     */   public Set<String> available() {
/*     */     return this.map.keys();
/*     */   }
/*     */   
/*     */   public RMAP(String key, LIST<T> all) {
/* 280 */     this.hasErr = false; this.key = key;
/*     */     this.map = new KeyMap();
/*     */     for (MAPPED mAPPED : all)
/*     */       this.map.put(mAPPED.key(), mAPPED); 
/*     */     this.all = all;
/* 285 */     this.map.expand(); } public abstract class KJson extends MAPJson<T> { public KJson(Json json) { this(RMAP.this.key, json); }
/*     */ 
/*     */     
/*     */     public KJson(String key, Json json) {
/* 289 */       super(key, json, RMAP.this.map, RMAP.this.hasErr);
/* 290 */       RMAP.this.hasErr = this.hasErr;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class MAPJson<T>
/*     */   {
/*     */     public boolean hasErr;
/*     */ 
/*     */     
/*     */     public MAPJson(String key, Json json, KeyMap<T> map, boolean hasErr) {
/* 302 */       if (json.has(key)) {
/* 303 */         json = json.json(key);
/* 304 */         for (String s : json.keys()) {
/*     */           
/* 306 */           if (s.indexOf("*") >= 0) {
/* 307 */             String beg = s.substring(0, s.indexOf("*"));
/* 308 */             for (String k : map.keys()) {
/* 309 */               if (k.startsWith(beg))
/* 310 */                 process((T)map.get(k), json, s, true); 
/*     */             }  continue;
/*     */           } 
/* 313 */           if (map.containsKey(s)) {
/* 314 */             process((T)map.get(s), json, s, false); continue;
/*     */           } 
/* 316 */           String p = "No " + key + " named " + s + " " + json.path() + " line: " + json.line(s);
/* 317 */           if (!hasErr) {
/* 318 */             p = p + p + "Available:" + System.lineSeparator();
/* 319 */             p = p + p;
/* 320 */             GAME.Warn(p);
/* 321 */             hasErr = true; continue;
/*     */           } 
/* 323 */           LOG.ln(p);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 331 */       this.hasErr = hasErr;
/*     */     }
/*     */     
/*     */     protected abstract void process(T param1T, Json param1Json, String param1String, boolean param1Boolean);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\keymap\RMAP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
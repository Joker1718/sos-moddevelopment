/*     */ package snake2d.util.file;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.NoSuchFileException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Json
/*     */ {
/*     */   private JsonValue.JsonValueJson data;
/*  18 */   private KeyMap<Boolean> testMap = new KeyMap();
/*     */   private static boolean untest = false;
/*     */   
/*     */   private Json(JsonValue.JsonValueJson content) {
/*  22 */     this.data = content;
/*     */   }
/*     */   private static final String sTrue = "true"; private static final String sFalse = "false";
/*     */   public Json(Path p) {
/*  26 */     this.data = read(p);
/*     */   }
/*     */   
/*     */   public Json(Path[] pp) {
/*  30 */     this(pp[pp.length - 1]);
/*  31 */     for (int i = pp.length - 2; i >= 0; i--) {
/*     */       
/*  33 */       JsonValue.JsonValueJson e = read(pp[i]);
/*  34 */       boolean arrayAdd = e.map.containsKey("_ARRAY_ADD");
/*  35 */       boolean jsonAdd = e.map.containsKey("_JSON_ADD");
/*  36 */       this.data.overwrite(e, arrayAdd, jsonAdd);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static JsonValue.JsonValueJson read(Path p) {
/*  45 */     Path path = p;
/*     */     try {
/*  47 */       byte[] encoded = Files.readAllBytes(p);
/*  48 */       String s = new String(encoded, StandardCharsets.UTF_8);
/*  49 */       return new JsonValue.JsonValueJson(null, 0, (String)path, s);
/*     */     }
/*  51 */     catch (NoSuchFileException e2) {
/*  52 */       throw new Errors.DataError("File does not exist", path);
/*  53 */     } catch (IOException e) {
/*  54 */       e.printStackTrace();
/*  55 */       throw new RuntimeException("can't open file:\n" + path + "\n make sure encoding is UTF_8\n" + e.getMessage());
/*     */     } 
/*     */   }
/*     */   
/*     */   public void checkUnused() {
/*  60 */     if (untest) {
/*     */       return;
/*     */     }
/*  63 */     for (JsonValue v : this.data.map.all()) {
/*  64 */       if (!this.testMap.containsKey(v.key)) {
/*  65 */         System.err.println("unknown key: " + v.key + " in object at line: " + v.line + ". " + path());
/*  66 */         System.err.println("available: ");
/*  67 */         System.err.println(this.testMap.keysString());
/*  68 */         untest = true;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean has(String key) {
/*  74 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/*     */     
/*  76 */     return this.data.map.containsKey(key);
/*     */   }
/*     */ 
/*     */   
/*     */   private JsonValue get(String key, String type) {
/*  81 */     if (!this.data.map.containsKey(key))
/*  82 */       this.data.throwError("Missing a " + type + " with key: " + key); 
/*  83 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/*  84 */     return (JsonValue)this.data.map.get(key);
/*     */   }
/*     */ 
/*     */   
/*     */   private String getValue(String key, String type) {
/*  89 */     if (!this.data.map.containsKey(key))
/*  90 */       this.data.throwError("Missing a " + type + " with key: " + key); 
/*  91 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/*  92 */     JsonValue v = (JsonValue)this.data.map.get(key);
/*  93 */     String res = v.value();
/*  94 */     if (res == null) {
/*  95 */       this.data.throwError("Missing a " + type + " with key: " + key);
/*     */     }
/*  97 */     return res;
/*     */   }
/*     */ 
/*     */   
/*     */   private String[] getValues(String key, String type) {
/* 102 */     if (!this.data.map.containsKey(key))
/* 103 */       this.data.throwError("Missing a " + type + " with key: " + key); 
/* 104 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/* 105 */     JsonValue v = (JsonValue)this.data.map.get(key);
/* 106 */     String[] res = v.values();
/* 107 */     if (res == null) {
/* 108 */       this.data.throwError("Missing a " + type + " with key: " + key);
/*     */     }
/* 110 */     return res;
/*     */   }
/*     */   
/*     */   public String text(String key) {
/* 114 */     JsonValue v = get(key, "String");
/* 115 */     String s = v.text();
/* 116 */     if (s == null)
/* 117 */       v.throwError("Expecting a String"); 
/* 118 */     return s;
/*     */   }
/*     */   
/*     */   public String text(String key, String fallback) {
/* 122 */     if (!has(key))
/* 123 */       return fallback; 
/* 124 */     return text(key);
/*     */   }
/*     */   
/*     */   public String[] texts(String key) {
/* 128 */     JsonValue v = get(key, "String Array");
/* 129 */     String[] s = v.texts();
/* 130 */     if (s == null)
/* 131 */       v.throwError("Expecting a string Array"); 
/* 132 */     return s;
/*     */   }
/*     */   
/*     */   public String[] textsTry(String key) {
/* 136 */     if (!has(key))
/* 137 */       return new String[0]; 
/* 138 */     return texts(key);
/*     */   }
/*     */   
/*     */   public String[] texts(String key, int size) {
/* 142 */     JsonValue v = get(key, "String Array");
/* 143 */     String[] ss = v.texts();
/* 144 */     if (ss == null) {
/* 145 */       v.throwError("Expecting a string Array");
/*     */     }
/* 147 */     if (ss.length != size)
/* 148 */       v.throwError(" invalid length of array: " + ss.length + " Valid: " + size); 
/* 149 */     return ss;
/*     */   }
/*     */   
/*     */   public String[] texts(String key, int min, int max) {
/* 153 */     JsonValue v = get(key, "String Array");
/* 154 */     String[] ss = v.texts();
/* 155 */     if (ss == null)
/* 156 */       v.throwError("Expecting a string Array"); 
/* 157 */     if (ss.length < min || ss.length > max)
/* 158 */       v.throwError(" invalid length of array: " + ss.length + " Valid: " + min + "-" + max); 
/* 159 */     return ss;
/*     */   }
/*     */   
/*     */   public Json json(String key) {
/* 163 */     JsonValue v = get(key, "Json Object");
/* 164 */     JsonValue.JsonValueJson s = v.json();
/* 165 */     if (s == null)
/* 166 */       v.throwError("Expecting an Object"); 
/* 167 */     return new Json(s);
/*     */   }
/*     */   
/*     */   public Json json(String key, int minKeys) {
/* 171 */     Json j = json(key);
/* 172 */     if (j.keys().size() < minKeys)
/* 173 */       error("Json contains insufficient entries. At least " + minKeys + " entries wated", key); 
/* 174 */     return j;
/*     */   }
/*     */   
/*     */   public boolean jsonIs(String key) {
/* 178 */     return (has(key) && get(key, "Object").json() != null);
/*     */   }
/*     */   
/*     */   public boolean textIs(String key) {
/* 182 */     return (has(key) && get(key, "String").text() != null);
/*     */   }
/*     */   
/*     */   public boolean jsonsIs(String key) {
/* 186 */     return (has(key) && get(key, "Objects").jsons() != null);
/*     */   }
/*     */   
/*     */   public boolean arrayIs(String key) {
/* 190 */     return (has(key) && get(key, "Object") instanceof JsonValue.JsonValueArray);
/*     */   }
/*     */   
/*     */   public boolean arrayArrayIs(String key) {
/* 194 */     return (has(key) && get(key, "Object").values2() != null);
/*     */   }
/*     */   
/*     */   public String path() {
/* 198 */     return this.data.errorPath;
/*     */   }
/*     */   
/*     */   public Json[] jsons(String key) {
/* 202 */     JsonValue v = get(key, "Object Array");
/* 203 */     JsonValue.JsonValueJson[] ss = v.jsons();
/* 204 */     if (ss == null)
/* 205 */       v.throwError("Expecting a object Array"); 
/* 206 */     Json[] res = new Json[ss.length];
/* 207 */     for (int i = 0; i < res.length; i++) {
/* 208 */       res[i] = new Json(ss[i]);
/*     */     }
/* 210 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Json[] jsons(String key, int minSize) {
/* 216 */     Json[] js = jsons(key);
/* 217 */     if (js.length < minSize)
/* 218 */       get(key, "Object Array").throwError("Needs at least " + minSize + " entries"); 
/* 219 */     return js;
/*     */   }
/*     */   
/*     */   public Json[] jsons(String key, int minSize, int maxSize) {
/* 223 */     Json[] js = jsons(key);
/* 224 */     if (js.length < minSize)
/* 225 */       get(key, "Object Array").throwError("Needs at least " + minSize + " entries"); 
/* 226 */     if (js.length < minSize)
/* 227 */       get(key, "Object Array").throwError("Needs at least " + minSize + " entries"); 
/* 228 */     if (js.length >= maxSize)
/* 229 */       get(key, "Object Array").throwError("Needs at most " + (maxSize - 1) + " entries"); 
/* 230 */     return js;
/*     */   }
/*     */   
/*     */   public double d(String key) {
/* 234 */     String s = getValue(key, "floating point number (0.0)");
/*     */     try {
/* 236 */       return Double.parseDouble(s);
/* 237 */     } catch (Exception e) {
/* 238 */       ((JsonValue)this.data.map.get(key)).throwError("'" + s + "'" + " is not a valid floating point number. Format is X.X");
/*     */       
/* 240 */       return 0.0D;
/*     */     } 
/*     */   }
/*     */   public double d(String key, double min, double max) {
/* 244 */     double d = d(key);
/* 245 */     if (d < min || d > max)
/* 246 */       ((JsonValue)this.data.map.get(key)).throwError(String.valueOf(d) + " is outside of valid range: " + min + "-" + max); 
/* 247 */     return d;
/*     */   }
/*     */   
/*     */   public double dTry(String key, double min, double max, double fallback) {
/* 251 */     if (has(key)) {
/* 252 */       return d(key, min, max);
/*     */     }
/* 254 */     return fallback;
/*     */   }
/*     */   
/*     */   public double[] ds(String key) {
/* 258 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/* 259 */     String[] s = getValues(key, "floating point number array");
/* 260 */     double[] res = new double[s.length];
/* 261 */     for (int i = 0; i < s.length; i++) {
/*     */       try {
/* 263 */         res[i] = Double.parseDouble(s[i]);
/* 264 */       } catch (Exception e) {
/* 265 */         ((JsonValue)this.data.map.get(key)).throwError("'" + s[i] + "'" + " is not a valid floating point number. Format is X.X");
/*     */       } 
/*     */     } 
/* 268 */     return res;
/*     */   }
/*     */   
/*     */   public double[] ds(String key, int size) {
/* 272 */     double[] res = ds(key);
/* 273 */     if (res.length != size) {
/* 274 */       ((JsonValue)this.data.map.get(key)).throwError("invalid length: '" + res.length + "'" + " should be: " + size);
/*     */     }
/* 276 */     return res;
/*     */   }
/*     */   
/*     */   public int i(String key) {
/* 280 */     String s = getValue(key, "Integer number");
/*     */     try {
/* 282 */       return Integer.parseInt(s);
/* 283 */     } catch (Exception e) {
/* 284 */       ((JsonValue)this.data.map.get(key)).throwError("'" + s + "'" + " is not a valid integer.");
/*     */       
/* 286 */       return 0;
/*     */     } 
/*     */   }
/*     */   public int i(String key, int min, int max) {
/* 290 */     int d = i(key);
/* 291 */     if (d < min || min >= max)
/* 292 */       ((JsonValue)this.data.map.get(key)).throwError(String.valueOf(d) + " is outside of valid range: " + min + "-" + max); 
/* 293 */     return d;
/*     */   }
/*     */   
/*     */   public int i(String key, int min, int max, int fallback) {
/* 297 */     if (!has(key))
/* 298 */       return fallback; 
/* 299 */     int d = i(key);
/* 300 */     if (d < min || min >= max)
/* 301 */       ((JsonValue)this.data.map.get(key)).throwError(String.valueOf(d) + " is outside of valid range: " + min + "-" + max); 
/* 302 */     return d;
/*     */   }
/*     */   
/*     */   public int[] is(String key) {
/* 306 */     String[] s = getValues(key, "integer number array");
/* 307 */     int[] res = Alloc.ii(s.length);
/* 308 */     for (int i = 0; i < s.length; i++) {
/*     */       try {
/* 310 */         res[i] = Integer.parseInt(s[i]);
/* 311 */       } catch (Exception e) {
/* 312 */         ((JsonValue)this.data.map.get(key)).throwError("'" + s[i] + "'" + " is not a valid integer");
/*     */       } 
/*     */     } 
/* 315 */     return res;
/*     */   }
/*     */   
/*     */   public String value(String key) {
/* 319 */     return getValue(key, " a value");
/*     */   }
/*     */   
/*     */   public String value(String key, String fallback) {
/* 323 */     if (!has(key))
/* 324 */       return fallback; 
/* 325 */     return value(key);
/*     */   }
/*     */   
/*     */   public String[] values(String key) {
/* 329 */     return getValues(key, "value array");
/*     */   }
/*     */   
/*     */   public String[][] values2(String key) {
/* 333 */     if (!this.data.map.containsKey(key))
/* 334 */       this.data.throwError("Missing a value array with key: " + key); 
/* 335 */     this.testMap.putReplace(key, Boolean.valueOf(true));
/* 336 */     JsonValue v = (JsonValue)this.data.map.get(key);
/* 337 */     String[][] res = v.values2();
/* 338 */     if (res == null) {
/* 339 */       this.data.throwError("Missing a value array with key: " + key);
/*     */     }
/* 341 */     return res;
/*     */   }
/*     */   
/*     */   public String[] values(String key, int min, int max) {
/* 345 */     String[] vs = values(key);
/* 346 */     if (vs.length < min || vs.length >= max)
/* 347 */       ((JsonValue)this.data.map.get(key)).throwError(" invalid length of array. Valid: " + min + "-" + max); 
/* 348 */     return vs;
/*     */   }
/*     */   
/*     */   public void error(String message, CharSequence key) {
/* 352 */     this.data.throwError(message, (String)key);
/*     */   }
/*     */   
/*     */   public String errorGet(String message, CharSequence key) {
/* 356 */     return this.data.getError(message, (String)key);
/*     */   }
/*     */   
/*     */   public int line(String key) {
/* 360 */     return this.data.line;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<String> keys() {
/* 368 */     return (LIST<String>)this.data.keys;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean bool(String key) {
/* 375 */     String v = value(key);
/* 376 */     if (v.equals("true"))
/* 377 */       return true; 
/* 378 */     if (v.equals("false"))
/* 379 */       return false; 
/* 380 */     error("illegal value: '" + v + "' for boolean type. only true/false is valid", key);
/* 381 */     return false;
/*     */   }
/*     */   
/*     */   public boolean bool(String key, boolean fallback) {
/* 385 */     if (has(key))
/* 386 */       return bool(key); 
/* 387 */     return fallback;
/*     */   }
/*     */   
/*     */   public static class KeyValue
/*     */   {
/*     */     public final String key;
/*     */     public final double value;
/*     */     
/*     */     KeyValue(String key, double value) {
/* 396 */       this.key = key;
/* 397 */       this.value = value;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 404 */     return this.data.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\Json.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
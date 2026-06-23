/*     */ package snake2d.util.file;
/*     */ 
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ abstract class JsonValue
/*     */ {
/*     */   public final String key;
/*     */   public final int line;
/*     */   public final String errorPath;
/*     */   
/*     */   private JsonValue(String key, int line, String errorPath) {
/*  16 */     this.key = key;
/*  17 */     this.line = line;
/*  18 */     this.errorPath = errorPath;
/*     */   }
/*     */   
/*     */   public String text() {
/*  22 */     return null;
/*     */   }
/*     */   
/*     */   public String[] texts() {
/*  26 */     return null;
/*     */   }
/*     */   
/*     */   public String value() {
/*  30 */     return null;
/*     */   }
/*     */   
/*     */   public String[] values() {
/*  34 */     return null;
/*     */   }
/*     */   
/*     */   public String[][] values2() {
/*  38 */     return null;
/*     */   }
/*     */   
/*     */   public JsonValueJson json() {
/*  42 */     return null;
/*     */   }
/*     */   
/*     */   public JsonValueJson[] jsons() {
/*  46 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void throwError(String error) {
/*  51 */     String m = "Error parsing line: " + this.line + ". key: " + this.key + " " + error;
/*  52 */     throw new Errors.DataError(m, this.errorPath);
/*     */   }
/*     */   
/*     */   public abstract String toString(int paramInt);
/*     */   
/*     */   public abstract void overwrite(JsonValue paramJsonValue, boolean paramBoolean1, boolean paramBoolean2);
/*     */   
/*     */   public static class JsonValueString
/*     */     extends JsonValue {
/*     */     public String data;
/*     */     
/*     */     JsonValueString(String key, int line, String data, String errorPath) {
/*  64 */       super(key, line, errorPath, null);
/*  65 */       data = data.replaceAll("[\\n\\r]+", "\n");
/*  66 */       data = data.replaceAll("[\\t]+", "");
/*  67 */       data = data.replaceAll("%r%", "\n");
/*  68 */       this.data = data;
/*     */     }
/*     */ 
/*     */     
/*     */     public String text() {
/*  73 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public void overwrite(JsonValue v, boolean arrayAdd, boolean jsonAdd) {
/*  78 */       if (v instanceof JsonValueString) {
/*  79 */         JsonValueString vv = (JsonValueString)v;
/*  80 */         this.data = vv.data;
/*     */       } else {
/*  82 */         v.throwError("Entry is of another type");
/*     */       } 
/*     */     }
/*     */     
/*     */     public String toString(int indent) {
/*  87 */       String s = "";
/*  88 */       for (int i = 0; i < indent; i++)
/*  89 */         s = String.valueOf(s) + "\t"; 
/*  90 */       if (this.key != null) {
/*  91 */         s = String.valueOf(s) + this.key + ": \"" + this.data + "\"," + System.lineSeparator();
/*     */       } else {
/*  93 */         s = String.valueOf(s) + this.data + "\"," + System.lineSeparator();
/*  94 */       }  return s;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class JsonValueValue
/*     */     extends JsonValue
/*     */   {
/*     */     public String data;
/*     */     
/*     */     JsonValueValue(String key, int line, String data, String errorPath) {
/* 104 */       super(key, line, errorPath, null);
/* 105 */       this.data = data;
/*     */     }
/*     */     
/*     */     public String value() {
/* 109 */       return this.data;
/*     */     }
/*     */ 
/*     */     
/*     */     public void overwrite(JsonValue v, boolean arrayAdd, boolean jsonAdd) {
/* 114 */       if (v instanceof JsonValueValue) {
/* 115 */         JsonValueValue vv = (JsonValueValue)v;
/* 116 */         this.data = vv.data;
/*     */       } else {
/* 118 */         v.throwError("Entry is of another type");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString(int indent) {
/* 124 */       String s = "";
/* 125 */       for (int i = 0; i < indent; i++)
/* 126 */         s = String.valueOf(s) + "\t"; 
/* 127 */       if (this.key != null) {
/* 128 */         s = String.valueOf(s) + this.key + ": " + this.data + "," + System.lineSeparator();
/*     */       } else {
/* 130 */         s = String.valueOf(s) + this.data + "," + System.lineSeparator();
/* 131 */       }  return s;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class JsonValueArray
/*     */     extends JsonValue {
/* 137 */     public final ArrayListGrower<JsonValue.JsonValueValue> datas = new ArrayListGrower();
/*     */     
/*     */     JsonValueArray(String key, int line, String errorPath) {
/* 140 */       super(key, line, errorPath, null);
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] texts() {
/* 145 */       LIST<JsonValue> vvs = vvs();
/* 146 */       if (vvs.size() == 0)
/* 147 */         return new String[0]; 
/* 148 */       if (!(vvs.get(0) instanceof JsonValue.JsonValueString)) {
/* 149 */         return null;
/*     */       }
/* 151 */       for (JsonValue v : vvs) {
/* 152 */         if (!(v instanceof JsonValue.JsonValueString)) {
/* 153 */           v.throwError("The entry is not a string: " + v.value());
/*     */         }
/*     */       } 
/* 156 */       String[] res = new String[vvs.size()];
/* 157 */       for (int i = 0; i < res.length; i++)
/* 158 */         res[i] = ((JsonValue.JsonValueString)vvs.get(i)).data; 
/* 159 */       return res;
/*     */     }
/*     */     
/*     */     private LIST<JsonValue> vvs() {
/* 163 */       ArrayListGrower<JsonValue> rr = new ArrayListGrower();
/*     */       
/* 165 */       for (JsonValue.JsonValueValue v : this.datas) {
/* 166 */         rr.add((Object[])vvs(v));
/*     */       }
/* 168 */       return (LIST<JsonValue>)rr;
/*     */     }
/*     */ 
/*     */     
/*     */     private JsonValue[] vvs(JsonValue.JsonValueValue v) {
/* 173 */       JsonValue.Reader r = new JsonValue.Reader(v.data, v);
/*     */       
/* 175 */       int size = 0;
/*     */       
/* 177 */       while (r.nextChar()) {
/*     */ 
/*     */         
/* 180 */         r.getValue(this.key);
/* 181 */         size++;
/*     */       } 
/*     */       
/* 184 */       JsonValue[] res = new JsonValue[size];
/* 185 */       r = new JsonValue.Reader(v.data, v);
/* 186 */       size = 0;
/*     */ 
/*     */       
/* 189 */       while (r.nextChar())
/*     */       {
/*     */ 
/*     */         
/* 193 */         res[size++] = r.getValue(null);
/*     */       }
/* 195 */       return res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] values() {
/* 201 */       LIST<JsonValue> vvs = vvs();
/* 202 */       if (vvs.size() == 0)
/* 203 */         return new String[0]; 
/* 204 */       if (!(vvs.get(0) instanceof JsonValue.JsonValueValue)) {
/* 205 */         return null;
/*     */       }
/* 207 */       for (JsonValue v : vvs) {
/* 208 */         if (!(v instanceof JsonValue.JsonValueValue)) {
/* 209 */           v.throwError("The entry is not a value");
/*     */         }
/*     */       } 
/* 212 */       String[] res = new String[vvs.size()];
/* 213 */       for (int i = 0; i < res.length; i++)
/* 214 */         res[i] = ((JsonValue.JsonValueValue)vvs.get(i)).data; 
/* 215 */       return res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[][] values2() {
/* 221 */       LIST<JsonValue> vvs = vvs();
/* 222 */       if (vvs.size() == 0)
/* 223 */         return new String[0][0]; 
/* 224 */       if (!(vvs.get(0) instanceof JsonValueArray)) {
/* 225 */         return null;
/*     */       }
/* 227 */       for (JsonValue v : vvs) {
/* 228 */         if (!(v instanceof JsonValueArray)) {
/* 229 */           v.throwError("The entry is not an array '[]'");
/*     */         }
/*     */       } 
/* 232 */       String[][] res = new String[vvs.size()][];
/* 233 */       for (int i = 0; i < res.length; i++)
/* 234 */         res[i] = ((JsonValueArray)vvs.get(i)).values(); 
/* 235 */       return res;
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonValue.JsonValueJson[] jsons() {
/* 240 */       LIST<JsonValue> vvs = vvs();
/* 241 */       if (vvs.size() == 0)
/* 242 */         return new JsonValue.JsonValueJson[0]; 
/* 243 */       if (!(vvs.get(0) instanceof JsonValue.JsonValueJson)) {
/* 244 */         return null;
/*     */       }
/* 246 */       for (JsonValue v : vvs) {
/* 247 */         if (!(v instanceof JsonValue.JsonValueJson)) {
/* 248 */           v.throwError("The entry is not a json");
/*     */         }
/*     */       } 
/* 251 */       JsonValue.JsonValueJson[] res = new JsonValue.JsonValueJson[vvs.size()];
/* 252 */       for (int i = 0; i < res.length; i++)
/* 253 */         res[i] = (JsonValue.JsonValueJson)vvs.get(i); 
/* 254 */       return res;
/*     */     }
/*     */ 
/*     */     
/*     */     public void overwrite(JsonValue v, boolean arrayAdd, boolean jsonAdd) {
/* 259 */       if (v instanceof JsonValueArray) {
/* 260 */         JsonValueArray vv = (JsonValueArray)v;
/* 261 */         if (!arrayAdd)
/* 262 */           this.datas.clear(); 
/* 263 */         this.datas.add((Iterable)vv.datas);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 268 */         v.throwError("Entry is of another type than other files");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString(int indent) {
/* 274 */       String s = ""; int i;
/* 275 */       for (i = 0; i < indent; i++) {
/* 276 */         s = String.valueOf(s) + "\t";
/*     */       }
/* 278 */       s = String.valueOf(s) + this.key + ": [" + System.lineSeparator();
/* 279 */       for (JsonValue v : vvs()) {
/* 280 */         s = String.valueOf(s) + v.toString(indent + 1);
/*     */       }
/* 282 */       for (i = 0; i < indent; i++)
/* 283 */         s = String.valueOf(s) + "\t"; 
/* 284 */       s = String.valueOf(s) + "]," + System.lineSeparator();
/* 285 */       return s;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class JsonValueJson
/*     */     extends JsonValue
/*     */   {
/* 292 */     public final LinkedList<String> keys = new LinkedList();
/* 293 */     public final KeyMap<JsonValue> map = new KeyMap();
/*     */     JsonValueJson(String key, int line, String errorPath, String content) {
/* 295 */       super(key, line, errorPath, null);
/* 296 */       JsonValue.Reader r = new JsonValue.Reader(content, this);
/*     */ 
/*     */       
/*     */       try {
/* 300 */         while (r.nextChar()) {
/* 301 */           key = r.getKey();
/*     */           
/* 303 */           JsonValue sValue = r.getValue(key);
/* 304 */           if (this.map.containsKey(key))
/* 305 */             r.throwError("Duplicate entry: " + key + " at line " + r.lineCurrent); 
/* 306 */           this.map.put(key, sValue);
/* 307 */           this.keys.add(key);
/*     */         }
/*     */       
/* 310 */       } catch (StringIndexOutOfBoundsException e) {
/* 311 */         e.printStackTrace();
/* 312 */         r.throwError("unexpected end of file after line: " + r.lineCurrent);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public JsonValueJson json() {
/* 319 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void overwrite(JsonValue v, boolean arrayAdd, boolean jsonAdd) {
/* 324 */       if (v instanceof JsonValueJson) {
/* 325 */         JsonValueJson vv = (JsonValueJson)v;
/* 326 */         for (JsonValue jv : vv.map.all()) {
/* 327 */           if (this.map.containsKey(jv.key)) {
/* 328 */             if (jsonAdd) {
/* 329 */               ((JsonValue)this.map.get(jv.key)).overwrite(jv, arrayAdd, jsonAdd); continue;
/*     */             } 
/* 331 */             this.map.putReplace(jv.key, jv); continue;
/*     */           } 
/* 333 */           this.map.put(jv.key, jv);
/* 334 */           this.keys.add(jv.key);
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 339 */         v.throwError("Entry is not a json object");
/*     */       } 
/*     */     }
/*     */     
/*     */     public void throwError(String error, String key) {
/* 344 */       JsonValue v = (JsonValue)this.map.get(key);
/* 345 */       if (v != null) {
/* 346 */         String m = "Error parsing line: " + v.line + ", key: " + key + ". " + error;
/* 347 */         throw new Errors.DataError(m, this.errorPath);
/*     */       } 
/* 349 */       throw new Errors.DataError(String.valueOf(error) + ". Error parsing key " + key, this.errorPath);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getError(String error, String key) {
/* 354 */       JsonValue v = (JsonValue)this.map.get(key);
/* 355 */       if (v != null) {
/* 356 */         return String.valueOf(error) + " Key: " + key + " line: " + v.line + " " + this.errorPath;
/*     */       }
/* 358 */       return String.valueOf(error) + ". Error parsing key " + key + " " + this.errorPath;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 364 */       return toString((this.key == null) ? -1 : 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString(int indent) {
/* 369 */       String s = "";
/*     */       int i;
/* 371 */       for (i = 0; i < indent; i++) {
/* 372 */         s = String.valueOf(s) + "\t";
/*     */       }
/*     */       
/* 375 */       if (indent >= 0) {
/*     */         
/* 377 */         if (this.key != null) {
/* 378 */           s = String.valueOf(s) + this.key + ": ";
/*     */         }
/* 380 */         s = String.valueOf(s) + "{" + System.lineSeparator();
/*     */       } 
/* 382 */       for (String k : this.keys) {
/* 383 */         s = String.valueOf(s) + ((JsonValue)this.map.get(k)).toString(indent + 1);
/*     */       }
/*     */       
/* 386 */       for (i = 0; i < indent; i++)
/* 387 */         s = String.valueOf(s) + "\t"; 
/* 388 */       if (indent >= 0) {
/* 389 */         s = String.valueOf(s) + "}," + System.lineSeparator();
/*     */       }
/* 391 */       return s;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Reader
/*     */   {
/*     */     private final JsonValue abs;
/*     */     
/*     */     private final String content;
/* 401 */     int lineCurrent = 0;
/* 402 */     private int i = 0;
/*     */     
/*     */     Reader(String content, JsonValue abs) {
/* 405 */       this.content = content;
/* 406 */       this.abs = abs;
/* 407 */       this.lineCurrent = abs.line;
/*     */     }
/*     */     
/*     */     public boolean isNewline() {
/* 411 */       char c = this.content.charAt(this.i);
/*     */ 
/*     */       
/* 414 */       if (c == '\r' && this.i < this.content.length() - 2 && this.content.charAt(this.i + 1) == '\n') {
/* 415 */         this.lineCurrent++;
/* 416 */         this.i += 2;
/* 417 */         return true;
/* 418 */       }  if (c == '\r') {
/* 419 */         this.lineCurrent++;
/* 420 */         this.i++;
/* 421 */         return true;
/* 422 */       }  if (c == '\n') {
/* 423 */         this.lineCurrent++;
/* 424 */         this.i++;
/* 425 */         return true;
/*     */       } 
/* 427 */       return false;
/*     */     }
/*     */     
/*     */     public boolean nextChar() {
/* 431 */       boolean comment = false;
/*     */       while (true) {
/* 433 */         if (this.i >= this.content.length() - 1) {
/* 434 */           return false;
/*     */         }
/* 436 */         if (this.content.charAt(this.i) == '*' && this.i < this.content.length() - 1 && this.content.charAt(this.i + 1) == '*') {
/* 437 */           comment = true;
/* 438 */           this.i++;
/*     */           
/*     */           continue;
/*     */         } 
/* 442 */         if (isNewline()) {
/* 443 */           comment = false;
/*     */           
/*     */           continue;
/*     */         } 
/* 447 */         char c = this.content.charAt(this.i);
/*     */         
/* 449 */         if (comment) {
/* 450 */           this.i++; continue;
/* 451 */         }  if (c == ' ' || c == '\t') {
/* 452 */           this.i++; continue;
/*     */         }  break;
/* 454 */       }  return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getKey() {
/* 461 */       int i2 = this.i;
/* 462 */       int l = this.lineCurrent;
/* 463 */       while (this.content.charAt(i2) != ':') {
/* 464 */         if (i2 >= this.content.length() - 1)
/* 465 */           throwError("Expecting a keyword followed by a ':' after line: " + l); 
/* 466 */         i2++;
/*     */       } 
/* 468 */       String key = this.content.substring(this.i, i2).trim();
/* 469 */       this.i = i2 + 1;
/* 470 */       nextChar();
/* 471 */       return key;
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonValue getValue(String key) {
/* 476 */       char c = this.content.charAt(this.i);
/* 477 */       int l = this.lineCurrent;
/* 478 */       if (c == '"') {
/* 479 */         String s = findValue('"', '"');
/* 480 */         return new JsonValue.JsonValueString(key, l, s, this.abs.errorPath);
/* 481 */       }  if (c == '{') {
/* 482 */         String s = findValue('{', '}');
/* 483 */         return new JsonValue.JsonValueJson(key, l, this.abs.errorPath, s);
/* 484 */       }  if (c == '[') {
/* 485 */         String s = findValue('[', ']');
/* 486 */         JsonValue.JsonValueArray a = new JsonValue.JsonValueArray(key, l, this.abs.errorPath);
/* 487 */         a.datas.add(new JsonValue.JsonValueValue(null, l, s, this.abs.errorPath));
/* 488 */         return a;
/*     */       } 
/* 490 */       int start = this.i;
/* 491 */       while (++this.i < this.content.length()) {
/* 492 */         if (isNewline())
/* 493 */           throwError("Expecting: ','"); 
/* 494 */         if (this.content.charAt(this.i) == ',') {
/* 495 */           this.i++;
/* 496 */           String s = this.content.substring(start, this.i - 1);
/* 497 */           return new JsonValue.JsonValueValue(key, l, s, this.abs.errorPath);
/*     */         } 
/*     */       } 
/* 500 */       int i2 = (this.i - 10 >= 0) ? (this.i - 10) : 0;
/* 501 */       String after = (i2 < this.i - 1) ? this.content.substring(i2, this.i - 1) : " ";
/* 502 */       throwError("Expecting: ',' after: '" + after + "'." + " | " + this.content);
/* 503 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String findValue(char open, char close) {
/* 509 */       int nesting = 0;
/* 510 */       int start = this.i;
/* 511 */       int l = this.lineCurrent;
/* 512 */       this.i++;
/*     */       
/*     */       while (true) {
/* 515 */         if (this.i >= this.content.length())
/*     */         {
/* 517 */           throwError("Expecting a close : " + close + " followed by a ',' after line " + l);
/*     */         }
/* 519 */         if (isNewline()) {
/*     */           continue;
/*     */         }
/* 522 */         char c = this.content.charAt(this.i);
/*     */         
/* 524 */         if (c == close) {
/* 525 */           if ((this.i == this.content.length() - 1 || this.content.charAt(this.i + 1) == ',') && nesting == 0) {
/* 526 */             String s = this.content.substring(start + 1, this.i);
/* 527 */             this.i += 2;
/* 528 */             return s;
/*     */           } 
/* 530 */           nesting--;
/*     */         } 
/* 532 */         if (c == open) {
/* 533 */           nesting++;
/*     */         }
/*     */         
/* 536 */         this.i++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void throwError(String error) {
/* 544 */       String m = "Error parsing line: " + this.lineCurrent + ". " + error;
/* 545 */       throw new Errors.DataError(m, this.abs.errorPath);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\file\JsonValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.boosting;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.util.Comparator;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.BOOLEANO;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public class BoostSpecs
/*     */ {
/*  25 */   private final ArrayListGrower<BoostSpec> all = new ArrayListGrower();
/*     */   
/*     */   final boolean connect;
/*     */   
/*     */   public static final String MUL = ">MUL";
/*     */   public static final String ADD = ">ADD";
/*  31 */   private PromiseList li = null;
/*     */   
/*     */   public final BSourceInfo info;
/*     */   
/*     */   public BoostSpecs(BSourceInfo info, boolean connect) {
/*  36 */     this.connect = connect;
/*  37 */     this.info = info;
/*     */   }
/*     */ 
/*     */   
/*     */   public BoostSpecs(CharSequence sourceName, SPRITE icon, boolean connect) {
/*  42 */     this.connect = connect;
/*  43 */     this.info = new BSourceInfo(sourceName, icon);
/*     */   }
/*     */ 
/*     */   
/*     */   public void push(BoostSpec boost) {
/*  48 */     this.all.add(boost);
/*  49 */     if (this.connect)
/*  50 */       boost.boostable.addFactor(boost); 
/*     */   }
/*     */   
/*     */   public void push(Booster factor, String targetKey, Object path) {
/*  54 */     push(targetKey, factor, path.toString(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public BoostSpec push(Booster factor, Boostable target) {
/*  59 */     return push(factor, target, (CharSequence)null);
/*     */   }
/*     */   
/*     */   public void push(Boostable target, double value, boolean isMul) {
/*  63 */     Booster w = new BoosterValue(BValue.VALUE1, this.info, value, isMul);
/*  64 */     BoostSpec boost = new BoostSpec(w, target, null);
/*  65 */     this.all.add(boost);
/*  66 */     if (this.connect)
/*  67 */       target.addFactor(boost); 
/*     */   }
/*     */   
/*     */   public BoostSpec push(Booster factor, Boostable target, CharSequence append) {
/*  71 */     BoostSpec boost = new BoostSpec(factor, target, append);
/*  72 */     this.all.add(boost);
/*  73 */     if (this.connect)
/*  74 */       target.addFactor(boost); 
/*  75 */     return boost;
/*     */   }
/*     */   
/*     */   public boolean remove(Boostable target) {
/*  79 */     boolean ret = false;
/*  80 */     for (int i = 0; i < this.all.size(); i++) {
/*  81 */       if (((BoostSpec)this.all.get(i)).boostable == target) {
/*  82 */         this.all.remove(this.all.get(i));
/*     */         
/*  84 */         ret = true;
/*  85 */         i--;
/*     */       } 
/*     */     } 
/*  88 */     return ret;
/*     */   }
/*     */   
/*     */   public void remove(BoostSpec target) {
/*  92 */     if (this.all.remove(target) && 
/*  93 */       this.connect) {
/*  94 */       target.boostable.removeFactor(target);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void replace(int oldI, Booster nnew, Boostable target) {
/* 100 */     BoostSpec boost = new BoostSpec(nnew, target, null);
/* 101 */     this.all.replace(oldI, boost);
/*     */   }
/*     */   
/*     */   public boolean removeFirst(Boostable target) {
/* 105 */     boolean ret = false;
/* 106 */     for (int i = 0; i < this.all.size(); i++) {
/* 107 */       if (((BoostSpec)this.all.get(i)).boostable == target) {
/* 108 */         this.all.remove(this.all.get(i));
/* 109 */         ret = true;
/* 110 */         i--;
/*     */       } 
/*     */     } 
/* 113 */     return ret;
/*     */   }
/*     */   
/*     */   public void pushWeak(Boostable target, double value, boolean isMul, Object path) {
/* 117 */     Booster w = new BoosterValue(BValue.VALUE1, this.info, value, isMul);
/* 118 */     push(target.key, w, path.toString(), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void pushPromise(Boostable target, BValue pValue, double value, boolean isMul) {
/* 123 */     if (pValue == null)
/* 124 */       pValue = BValue.VALUE1; 
/* 125 */     Booster bb = new BoosterValue(pValue, this.info, value, isMul);
/* 126 */     push(target.key, bb, "", false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(Json json, BValue pValue) {
/* 131 */     read("BOOST", json, pValue);
/*     */   }
/*     */   
/*     */   public void read(String key, Json json, BValue pValue) {
/* 135 */     read(key, json, pValue, null);
/*     */   }
/*     */   
/*     */   public void read(String key, Json json, BValue pValue, CharSequence append) {
/* 139 */     read(key, json, pValue, append, true, new String[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void read(String key, Json json, BValue pValue, CharSequence append, boolean allowMul, String... notallowed) {
/* 144 */     if (!json.has(key)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 149 */     json = json.json(key);
/*     */     
/* 151 */     if (pValue == null) {
/* 152 */       pValue = BValue.VALUE1;
/*     */     }
/*     */     
/* 155 */     for (String k : json.keys()) {
/*     */       
/* 157 */       boolean isMul = false;
/* 158 */       double value = json.d(k);
/* 159 */       String path = json.path() + ", line" + json.path();
/*     */       
/* 161 */       if (k.endsWith(">MUL")) {
/* 162 */         if (!allowMul) {
/* 163 */           json.error("Only ADD is allowed in this context", k);
/*     */         }
/* 165 */         isMul = true;
/* 166 */         k = k.substring(0, k.length() - ">MUL".length());
/* 167 */       } else if (k.endsWith(">ADD")) {
/* 168 */         k = k.substring(0, k.length() - ">ADD".length());
/*     */       } else {
/* 170 */         json.error("Malformed value. Must be a string that ends with >ADD (addition), or >MUL (Multiplication)", k);
/*     */       }  byte b; int j;
/*     */       String[] arrayOfString;
/* 173 */       for (j = (arrayOfString = notallowed).length, b = 0; b < j; ) { String na = arrayOfString[b];
/* 174 */         if (na.equalsIgnoreCase(k))
/* 175 */           json.error("This key is special in this context and not allowed!", k);  b++; }
/*     */       
/* 177 */       BSourceInfo i = this.info;
/* 178 */       if (append != null)
/* 179 */         i = new BSourceInfo(i.name, append, i.icon); 
/* 180 */       Booster bb = new BoosterValue(pValue, i, value, isMul);
/*     */       
/* 182 */       push(k, bb, path, false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ParseValue
/*     */   {
/*     */     public String key;
/*     */     public double am;
/*     */     public boolean isMul = false;
/*     */     
/*     */     public ParseValue(String key, double am, boolean isMul) {
/* 194 */       this.key = key;
/* 195 */       this.am = am;
/* 196 */       this.isMul = isMul;
/*     */     }
/*     */     
/*     */     public ParseValue(Json json, String k) {
/* 200 */       this.am = json.d(k);
/*     */       
/* 202 */       if (k.endsWith(">MUL")) {
/* 203 */         this.isMul = true;
/* 204 */         k = k.substring(0, k.length() - ">MUL".length());
/* 205 */       } else if (k.endsWith(">ADD")) {
/* 206 */         k = k.substring(0, k.length() - ">ADD".length());
/*     */       } else {
/* 208 */         json.error("Malformed value. Must be a string that ends with >ADD (addition), or >MUL (Multiplication)", k);
/*     */       } 
/* 210 */       this.key = k;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<BoostSpec> all() {
/* 217 */     return (LIST<BoostSpec>)this.all;
/*     */   }
/*     */   
/* 220 */   private static int htab = 7;
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, BOOSTABLE_O t) {
/* 224 */     hover(text, t, Dic.¤¤Effects);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX text, BOOSTABLE_O t, CharSequence name) {
/* 228 */     hover(text, t, name, -1);
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX text, BOOSTABLE_O t, int catMask) {
/* 232 */     hover(text, t, Dic.¤¤Effects, catMask);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, BOOSTABLE_O t, CharSequence name, int catMask) {
/* 237 */     GBox b = (GBox)text;
/* 238 */     if (name != null)
/* 239 */       b.textLL(name); 
/* 240 */     b.NL();
/*     */     
/* 242 */     for (int si = 0; si < all().size(); si++) {
/* 243 */       BoostSpec s = (BoostSpec)all().get(si);
/* 244 */       if ((s.boostable.cat.typeMask & catMask) != 0 && hover(b, s, s.get(t), 0)) {
/* 245 */         b.tab(htab + 2);
/* 246 */         b.add((SPRITE)GFORMAT.iOrF(b.text(), s.booster.from()).color(COLOR.WHITE65));
/* 247 */         GText te = b.text();
/* 248 */         te.color(COLOR.WHITE65);
/* 249 */         te.add('<').add('>');
/* 250 */         b.add((SPRITE)te);
/* 251 */         b.add((SPRITE)GFORMAT.iOrF(b.text(), s.booster.to()).color(COLOR.WHITE65));
/* 252 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, double input, int catMask) {
/* 262 */     hover(text, input, Dic.¤¤Effects, catMask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, double input, CharSequence name, int catMask) {
/* 269 */     if (all().size() <= 0) {
/*     */       return;
/*     */     }
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
/* 299 */     hover(text, input, name, null, catMask);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverDetailed(GUI_BOX text, double input, CharSequence name, BOOLEANO<BoostSpec> filter, int catMask) {
/* 306 */     GBox b = (GBox)text;
/* 307 */     if (name != null)
/* 308 */       b.textLL(name); 
/* 309 */     b.NL();
/*     */     
/* 311 */     for (BoostSpec l : all()) {
/* 312 */       if (filter != null && !filter.is(l))
/*     */         continue; 
/* 314 */       double d = l.booster.getValue(input);
/* 315 */       if ((l.boostable.cat.typeMask & catMask) != 0 && hover(b, l, d, 0)) {
/*     */         
/* 317 */         b.tab(9);
/* 318 */         GText t = b.text();
/* 319 */         t.add('(');
/* 320 */         t.add(l.booster.getValue(0.0D), 2);
/* 321 */         t.s().add('>').s();
/* 322 */         t.add(l.booster.getValue(1.0D), 2);
/* 323 */         t.add(')');
/* 324 */         b.add((SPRITE)t);
/* 325 */         b.NL();
/*     */       } 
/*     */     } 
/* 328 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX text, double input, CharSequence name, BOOLEANO<BoostSpec> filter, int catMask) {
/* 333 */     if (all().size() <= 0) {
/*     */       return;
/*     */     }
/* 336 */     GBox b = (GBox)text;
/* 337 */     if (name != null)
/* 338 */       b.textLL(name); 
/* 339 */     b.NL();
/* 340 */     int tab = 0;
/*     */ 
/*     */ 
/*     */     
/* 344 */     for (BoostSpec l : all()) {
/*     */       
/* 346 */       double d = l.booster.getValue(input);
/* 347 */       if ((filter == null || filter.is(l)) && (l.boostable.cat.typeMask & catMask) != 0 && hover(b, l, d, tab)) {
/* 348 */         if (tab >= 1) {
/* 349 */           tab = 0;
/* 350 */           b.NL(); continue;
/*     */         } 
/* 352 */         tab++;
/*     */       } 
/*     */     } 
/*     */     
/* 356 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(GBox b, BoostSpec l, double d, int tab) {
/* 361 */     if (l.boostable.name == null || l.boostable.name.length() == 0) {
/* 362 */       return false;
/*     */     }
/* 364 */     COLOR c = (GCOLOR.T()).INACTIVE;
/*     */     
/* 366 */     GText t = b.text();
/*     */ 
/*     */     
/* 369 */     if (l.booster.isMul) {
/* 370 */       if (d < 1.0D) {
/* 371 */         c = (GCOLOR.T()).IBAD;
/* 372 */       } else if (d > 1.0D) {
/* 373 */         c = (GCOLOR.T()).IGOOD;
/* 374 */       }  d--;
/* 375 */       GFORMAT.percInc(t, d);
/*     */     } else {
/* 377 */       if (d < 0.0D) {
/* 378 */         c = (GCOLOR.T()).IBAD;
/* 379 */       } else if (d > 0.0D) {
/* 380 */         c = (GCOLOR.T()).IGOOD;
/* 381 */       }  if (d == (int)d) {
/* 382 */         GFORMAT.iIncr(t, (int)d);
/*     */       } else {
/* 384 */         GFORMAT.f0(t, d);
/*     */       } 
/*     */     } 
/* 387 */     b.tab(tab * (htab + 2));
/* 388 */     b.add(l.boostable.icon.small);
/* 389 */     b.add((SPRITE)b.text().color(c).add(l.tName));
/* 390 */     b.tab(tab * (htab + 2) + htab);
/*     */     
/* 392 */     t.color(c);
/* 393 */     b.add((SPRITE)t);
/* 394 */     return true;
/*     */   }
/*     */   
/*     */   private void push(String key, Booster factor, String path, boolean isWeak) {
/* 398 */     if (this.li == null) {
/* 399 */       this.li = new PromiseList(this);
/* 400 */       BOOSTING.waiting.add(this.li);
/*     */     } 
/* 402 */     this.li.push(key, factor, path, isWeak);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class PromiseList
/*     */     implements ACTION
/*     */   {
/* 409 */     public final LinkedList<Promise> all = new LinkedList();
/*     */     
/*     */     public final BoostSpecs coll;
/*     */     
/*     */     PromiseList(BoostSpecs coll) {
/* 414 */       this.coll = coll;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void exe() {
/* 420 */       for (Promise p : this.all) {
/*     */         
/* 422 */         LIST<Boostable> bos = BOOSTING.MAP().get(p.key);
/*     */ 
/*     */         
/* 425 */         if (bos.size() == 0) {
/* 426 */           String m = p.path + p.path + "no BOOSTABLE  named : " + System.lineSeparator();
/* 427 */           if (BOOSTING.hasErrored) {
/* 428 */             LOG.ln(m); continue;
/*     */           } 
/* 430 */           BOOSTING.hasErrored = true;
/* 431 */           GAME.Warn(m + m + "Available:" + System.lineSeparator() + System.lineSeparator());
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 436 */         boolean isWeak = (bos.size() > 1);
/*     */         
/* 438 */         for (Boostable bo : bos) {
/* 439 */           add(p, bo, isWeak);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 444 */       ArrayList<BoostSpec> rr = new ArrayList(this.coll.all.size());
/* 445 */       for (BoostSpec s : this.coll.all) {
/* 446 */         if (s.booster.isMul && s.booster.from() == 1.0D && s.booster.to() == 1.0D) {
/*     */           continue;
/*     */         }
/* 449 */         if (!s.booster.isMul && s.booster.from() == 0.0D && s.booster.to() == 0.0D) {
/*     */           continue;
/*     */         }
/* 452 */         rr.add(s);
/*     */       } 
/*     */       
/* 455 */       rr.sort(new Comparator<BoostSpec>()
/*     */           {
/*     */             public int compare(BoostSpec o1, BoostSpec o2)
/*     */             {
/* 459 */               int ii = String.valueOf(o1.boostable.cat.name).compareTo(String.valueOf(o2.boostable.cat.name));
/* 460 */               if (ii == 0) {
/* 461 */                 return String.valueOf(o1.boostable.name).compareTo(String.valueOf(o2.boostable.name));
/*     */               }
/* 463 */               return ii;
/*     */             }
/*     */           });
/* 466 */       this.coll.all.clear();
/* 467 */       this.coll.all.add((Iterable)rr);
/* 468 */       this.coll.li = null;
/*     */     }
/*     */     
/*     */     private void add(Promise p, Boostable b, boolean isWeak) {
/* 472 */       BoostSpec boost = new BoostSpec(p.factor, b, null);
/* 473 */       for (BoostSpec bb : this.coll.all) {
/* 474 */         if (boost.isSameAs(bb)) {
/* 475 */           if (isWeak)
/*     */             return; 
/* 477 */           this.coll.remove(bb);
/* 478 */           if (this.coll.connect) {
/* 479 */             bb.boostable.removeFactor(bb);
/*     */           }
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 485 */       this.coll.push(boost);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void push(String key, Booster factor, String path, boolean isWeak) {
/* 495 */       for (Promise pp : this.all) {
/* 496 */         if (pp.key == key && pp.factor.isMul == factor.isMul) {
/* 497 */           this.all.remove(pp);
/*     */         }
/*     */       } 
/* 500 */       Promise p = new Promise(key, factor, path, isWeak);
/* 501 */       this.all.add(p);
/*     */     }
/*     */ 
/*     */     
/*     */     private static class Promise
/*     */     {
/*     */       public final String key;
/*     */       public final String path;
/*     */       public final Booster factor;
/*     */       
/*     */       Promise(String key, Booster factor, String path, boolean isWeak) {
/* 512 */         this.key = key;
/* 513 */         this.factor = factor;
/* 514 */         this.path = path;
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double max(Boostable bo) {
/* 524 */     double m = 0.0D;
/* 525 */     for (BoostSpec s : all()) {
/* 526 */       if (s.boostable == bo)
/* 527 */         m = Math.max(m, s.booster.max()); 
/* 528 */     }  return m;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoostSpecs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
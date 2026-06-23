/*     */ package snake2d.util.sprite.text;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ 
/*     */ public class Str
/*     */   implements CharSequence
/*     */ {
/*  15 */   public static final Str TMP = new Str(64);
/*  16 */   public static final Str TMP2 = new Str(64);
/*  17 */   private static final Str TMP3 = new Str(64);
/*     */   
/*     */   protected char[] chars;
/*  20 */   protected int last = 0;
/*  21 */   private static final StringBuilder builder = new StringBuilder(1024);
/*     */   private static final String boolT = "true";
/*     */   private static final String boolF = "false";
/*     */   
/*     */   public Str(int size) {
/*  26 */     this.chars = Alloc.cc(size);
/*     */   }
/*     */   
/*     */   public Str(CharSequence s) {
/*  30 */     this.chars = Alloc.cc(s.length());
/*  31 */     add(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Str() {}
/*     */ 
/*     */   
/*     */   public char charAt(int index) {
/*  40 */     if (index >= this.last)
/*  41 */       throw new IndexOutOfBoundsException(Integer.toString(index)); 
/*  42 */     return this.chars[index];
/*     */   }
/*     */   
/*     */   public Str setMaxChars(int max) {
/*  46 */     if (this.last > max) {
/*  47 */       this.last = max;
/*  48 */       this.chars[max - 1] = '.';
/*  49 */       this.chars[max - 2] = '.';
/*     */     } 
/*  51 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int length() {
/*  56 */     return this.last;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence subSequence(int start, int end) {
/*  61 */     return new String(this.chars, start, end - start);
/*     */   }
/*     */   
/*     */   public Str add(CharSequence string) {
/*  65 */     add(string, string.length());
/*  66 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(CharSequence string, int length) {
/*  70 */     if (string.length() == 0) {
/*  71 */       return this;
/*     */     }
/*  73 */     if (length > string.length()) {
/*  74 */       length = string.length();
/*     */     }
/*  76 */     if (this.last + length > this.chars.length) {
/*  77 */       resize(this.last + length);
/*     */     }
/*  79 */     int i = 0;
/*  80 */     while (i < length) {
/*  81 */       this.chars[this.last++] = string.charAt(i++);
/*     */     }
/*  83 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(CharSequence string, int start, int end) {
/*  87 */     if (string.length() == 0) {
/*  88 */       return this;
/*     */     }
/*  90 */     if (this.last + end - start > this.chars.length) {
/*  91 */       resize(this.last + string.length());
/*     */     }
/*  93 */     int i = start;
/*  94 */     if (end > string.length())
/*  95 */       end = string.length(); 
/*  96 */     while (i < end) {
/*  97 */       this.chars[this.last++] = string.charAt(i++);
/*     */     }
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(long i) {
/* 103 */     add(i, false);
/*     */     
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(long i, boolean format) {
/* 109 */     if (i < 0L) {
/* 110 */       add('-');
/* 111 */       i = -i;
/*     */     } 
/*     */     
/* 114 */     if (i == 0L) {
/* 115 */       return add('0');
/*     */     }
/*     */     
/* 118 */     builder.setLength(0);
/*     */     
/* 120 */     int ii = 0;
/*     */     
/* 122 */     while (i > 0L) {
/* 123 */       builder.append((char)(int)(48L + i % 10L));
/* 124 */       i /= 10L;
/* 125 */       if (format && ii++ >= 2 && i > 0L) {
/* 126 */         builder.append('.');
/* 127 */         ii = 0;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 132 */     builder.reverse();
/*     */     
/* 134 */     for (int j = 0; j < builder.length(); j++) {
/* 135 */       add(builder.charAt(j));
/*     */     }
/*     */     
/* 138 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Str add(double d) {
/* 145 */     return add(d, 3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Str add(double d, int decimals) {
/* 151 */     return add(d, decimals, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str add(double d, int decimals, boolean alwaysDecimals) {
/* 156 */     if (!Double.isFinite(d)) {
/* 157 */       return add('N').add('a').add('N');
/*     */     }
/*     */     
/* 160 */     if (d < 0.0D) {
/* 161 */       add('-');
/* 162 */       d = -d;
/*     */     } 
/*     */     
/* 165 */     int mm = (int)Math.pow(10.0D, decimals);
/*     */     
/* 167 */     d = Math.round(d * mm);
/* 168 */     d /= mm;
/*     */     
/* 170 */     long full = Math.round(d * (mm * 10)) / 10L;
/*     */ 
/*     */     
/* 173 */     long f = full / mm;
/*     */     
/* 175 */     add(f);
/*     */     
/* 177 */     int lastDig = length();
/*     */     
/* 179 */     add('.');
/* 180 */     full -= f * mm;
/*     */ 
/*     */     
/* 183 */     while (decimals > 0) {
/* 184 */       decimals--;
/* 185 */       mm = (int)Math.pow(10.0D, decimals);
/* 186 */       f = full / mm;
/*     */       
/* 188 */       add(f);
/* 189 */       lastDig = length();
/* 190 */       full -= f * mm;
/*     */     } 
/* 192 */     this.last = lastDig;
/* 193 */     if (alwaysDecimals) {
/* 194 */       return this;
/*     */     }
/*     */     
/* 197 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(char chare) {
/* 201 */     if (this.last >= this.chars.length - 1)
/* 202 */       resize(this.last + 2); 
/* 203 */     this.chars[this.last++] = chare;
/* 204 */     return this;
/*     */   }
/*     */   
/*     */   public Str add(boolean b) {
/* 208 */     return add(b ? "true" : "false");
/*     */   }
/*     */ 
/*     */   
/*     */   public Str addBinary(int bin) {
/* 213 */     long m = 2147483648L;
/* 214 */     long b = bin & 0xFFFFFFFFL;
/*     */     
/* 216 */     for (int i = 0; i < 32; i++) {
/* 217 */       char c = ((b & m) == m) ? '1' : '0';
/*     */       
/* 219 */       add(c);
/* 220 */       m >>= 1L;
/*     */     } 
/* 222 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public Str addBinary(long bin) {
/* 227 */     long m = Long.MIN_VALUE;
/* 228 */     long b = bin & 0xFFFFFFFFFFFFFFFFL;
/*     */     
/* 230 */     for (int i = 0; i < 64; i++) {
/* 231 */       char c = ((b & m) == m) ? '1' : '0';
/*     */       
/* 233 */       add(c);
/* 234 */       m >>= 1L;
/*     */     } 
/* 236 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Str clear() {
/* 242 */     this.last = 0;
/* 243 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Str s() {
/* 251 */     add(' ');
/* 252 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Str s(int a) {
/* 261 */     for (int i = 0; i < a; i++)
/* 262 */       add(' '); 
/* 263 */     return this;
/*     */   }
/*     */   
/*     */   public void clearLast() {
/* 267 */     this.last--;
/* 268 */     if (this.last < 0)
/* 269 */       this.last = 0; 
/*     */   }
/*     */   
/*     */   public int spaceLeft() {
/* 273 */     return this.chars.length - this.last - 1;
/*     */   }
/*     */   
/*     */   public int capacity() {
/* 277 */     return this.chars.length;
/*     */   }
/*     */   
/*     */   private void resize(int newsize) {
/* 281 */     char[] newc = Alloc.cc(newsize);
/* 282 */     for (int i = 0; i < this.chars.length; i++) {
/* 283 */       newc[i] = this.chars[i];
/*     */     }
/* 285 */     this.chars = newc;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 290 */     return new String(Arrays.copyOf(this.chars, this.last));
/*     */   }
/*     */   
/*     */   public Str toCamel() {
/* 294 */     boolean big = true;
/* 295 */     for (int i = 0; i < this.last; i++) {
/* 296 */       if (this.chars[i] == ' ') {
/* 297 */         big = true;
/* 298 */       } else if (big) {
/* 299 */         big = false;
/* 300 */         if (this.chars[i] >= 'a' && this.chars[i] <= 'z') {
/* 301 */           this.chars[i] = (char)(this.chars[i] - 32);
/*     */         }
/*     */       }
/* 304 */       else if (this.chars[i] >= 'A' && this.chars[i] <= 'Z') {
/* 305 */         this.chars[i] = (char)(this.chars[i] + 32);
/*     */       } 
/*     */     } 
/*     */     
/* 309 */     return this;
/*     */   }
/*     */   
/*     */   public Str toLower() {
/* 313 */     for (int i = 0; i < this.last; i++) {
/* 314 */       if (this.chars[i] >= 'A' && this.chars[i] <= 'Z') {
/* 315 */         this.chars[i] = (char)(this.chars[i] + 32);
/*     */       }
/*     */     } 
/* 318 */     return this;
/*     */   }
/*     */   
/* 321 */   private static final Str TMPMATCH = new Str(64);
/*     */ 
/*     */   
/*     */   public Str insert(int index, CharSequence v) {
/* 325 */     TMPMATCH.clear().add('{').add(index).add('}');
/* 326 */     return insert(v);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str insert(CharSequence key, CharSequence v) {
/* 331 */     TMPMATCH.clear().add('{').add(key).add('}');
/* 332 */     return insert(v);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasinsert(CharSequence key) {
/* 338 */     TMPMATCH.clear().add('{').add(key).add('}');
/* 339 */     for (int i = 0; i < length(); i++) {
/* 340 */       if (matches(this, TMPMATCH, i)) {
/* 341 */         return true;
/*     */       }
/*     */     } 
/* 344 */     return false;
/*     */   }
/*     */   
/* 347 */   private static final Str ISEARCH = new Str(128);
/*     */   
/*     */   public static CharSequence getInsert(CharSequence text, int nr) {
/* 350 */     for (int si = 0; si < text.length(); si++) {
/* 351 */       if (text.charAt(si) == '{') {
/* 352 */         ISEARCH.clear();
/* 353 */         for (int ei = si + 1; ei < text.length(); ei++) {
/* 354 */           if (text.charAt(ei) == '}') {
/* 355 */             if (nr <= 0) {
/* 356 */               return ISEARCH;
/*     */             }
/* 358 */             nr--;
/*     */             break;
/*     */           } 
/* 361 */           ISEARCH.add(text.charAt(ei));
/*     */         } 
/*     */       } 
/*     */     } 
/* 365 */     return null;
/*     */   }
/*     */   
/*     */   private Str insert(CharSequence v) {
/* 369 */     builder.setLength(0);
/* 370 */     for (int i = 0; i < length(); i++) {
/* 371 */       if (matches(this, TMPMATCH, i)) {
/* 372 */         builder.append(v);
/* 373 */         i += TMPMATCH.length();
/* 374 */         for (; i < length(); i++)
/* 375 */           builder.append(charAt(i)); 
/* 376 */         clear();
/* 377 */         add(builder);
/* 378 */         return this;
/*     */       } 
/*     */       
/* 381 */       builder.append(charAt(i));
/*     */     } 
/*     */ 
/*     */     
/* 385 */     return this;
/*     */   }
/*     */   
/*     */   private static boolean matches(CharSequence s, CharSequence n, int i) {
/* 389 */     if (i + n.length() > s.length()) {
/* 390 */       return false;
/*     */     }
/* 392 */     char c = s.charAt(i);
/* 393 */     if (n.charAt(0) == c) {
/* 394 */       for (int k = 0; k < n.length(); k++) {
/* 395 */         int ki = k + i;
/* 396 */         if (n.charAt(k) != s.charAt(ki))
/* 397 */           return false; 
/*     */       } 
/* 399 */       return true;
/*     */     } 
/* 401 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean matchesText(CharSequence s, CharSequence n, int i) {
/* 405 */     if (i + n.length() > s.length())
/* 406 */       return false; 
/* 407 */     if (i >= s.length())
/* 408 */       return false; 
/* 409 */     char c = Character.toLowerCase(s.charAt(i));
/* 410 */     if (Character.toLowerCase(n.charAt(0)) == c) {
/* 411 */       for (int k = 0; k < n.length(); k++) {
/* 412 */         int ki = k + i;
/* 413 */         if (Character.toLowerCase(n.charAt(k)) != Character.toLowerCase(s.charAt(ki)))
/* 414 */           return false; 
/*     */       } 
/* 416 */       return true;
/*     */     } 
/* 418 */     return false;
/*     */   }
/*     */   
/*     */   public Str insert(int index, char v) {
/* 422 */     TMP3.clear().add(v);
/* 423 */     return insert(index, TMP3);
/*     */   }
/*     */   
/*     */   public Str insert(int index, int v) {
/* 427 */     TMP3.clear().add(v);
/* 428 */     return insert(index, TMP3);
/*     */   }
/*     */   
/*     */   public Str insert(int index, double v, int decimals) {
/* 432 */     TMP3.clear().add(v, decimals);
/* 433 */     return insert(index, TMP3);
/*     */   }
/*     */   
/*     */   public Str insertD(int index, double v, int maxDecimals) {
/* 437 */     double vv = v;
/* 438 */     for (int i = 0; i < maxDecimals; i++) {
/* 439 */       if ((int)vv == vv)
/* 440 */         return insert(index, v, i); 
/* 441 */       vv *= 10.0D;
/*     */     } 
/* 443 */     return insert(index, v, maxDecimals);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class StringReusableSer
/*     */     extends Str
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */     
/*     */     public StringReusableSer(int size) {
/* 457 */       super(size);
/*     */     }
/*     */     
/*     */     private void writeObject(ObjectOutputStream out) throws IOException {
/* 461 */       out.writeObject(this.chars);
/* 462 */       out.writeInt(this.last);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 468 */       this.chars = (char[])in.readObject();
/* 469 */       this.last = in.readInt();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Str toUpper() {
/* 475 */     for (int i = 0; i < this.last; i++) {
/* 476 */       if (this.chars[i] >= 'a' && this.chars[i] <= 'z') {
/* 477 */         this.chars[i] = (char)(this.chars[i] - 32);
/*     */       }
/*     */     } 
/* 480 */     return this;
/*     */   }
/*     */   
/*     */   public boolean startsWithIgnoreCase(CharSequence other) {
/* 484 */     return startsWithIgnoreCase(this, other);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean startsWithIgnoreCase(CharSequence a, CharSequence b) {
/* 489 */     if (a.length() == 0) {
/* 490 */       return true;
/*     */     }
/* 492 */     if (b.length() == 0)
/* 493 */       return true; 
/* 494 */     if (b.length() > a.length())
/* 495 */       return false; 
/* 496 */     for (int i = 0; i < b.length(); i++) {
/* 497 */       if (Character.toLowerCase(b.charAt(i)) != Character.toLowerCase(a.charAt(i)))
/* 498 */         return false; 
/*     */     } 
/* 500 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter f) {
/* 505 */     f.i(this.last);
/* 506 */     for (int i = 0; i < this.last; i++) {
/* 507 */       f.i(this.chars[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   public void load(FileGetter f) throws IOException {
/* 512 */     this.last = f.i();
/* 513 */     if (this.last > this.chars.length) {
/* 514 */       this.chars = Alloc.cc(this.last);
/*     */     }
/*     */     
/* 517 */     for (int i = 0; i < this.last; i++) {
/* 518 */       this.chars[i] = (char)f.i();
/*     */     }
/*     */   }
/*     */   
/*     */   public Str trim() {
/* 523 */     char[] chars = Alloc.cc(length());
/* 524 */     for (int i = 0; i < chars.length; i++)
/* 525 */       chars[i] = this.chars[i]; 
/* 526 */     this.chars = chars;
/* 527 */     return this;
/*     */   }
/*     */   
/*     */   public Str NL() {
/* 531 */     add('\n');
/* 532 */     return this;
/*     */   }
/*     */   
/*     */   public Str TAB() {
/* 536 */     add('\t');
/* 537 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 542 */     if (obj instanceof CharSequence) {
/* 543 */       CharSequence cc = (CharSequence)obj;
/* 544 */       if (cc.length() != length())
/* 545 */         return false; 
/* 546 */       for (int i = 0; i < cc.length(); i++) {
/* 547 */         if (cc.charAt(i) != charAt(i))
/* 548 */           return false; 
/*     */       } 
/* 550 */       return true;
/*     */     } 
/* 552 */     return false;
/*     */   }
/*     */   
/*     */   public boolean containsText(CharSequence text) {
/* 556 */     for (int i = 0; i < length() - text.length() + 1; i++) {
/* 557 */       if (matchesText(this, text, i))
/* 558 */         return true; 
/* 559 */     }  return false;
/*     */   }
/*     */   
/*     */   public static boolean containsText(CharSequence a, CharSequence text) {
/* 563 */     if (text.length() == 0 && a != null) {
/* 564 */       return true;
/*     */     }
/* 566 */     for (int i = 0; i < a.length() - text.length() + 1; i++) {
/* 567 */       if (matchesText(a, text, i))
/* 568 */         return true; 
/* 569 */     }  return false;
/*     */   }
/*     */   
/*     */   public static boolean isSame(CharSequence tName, CharSequence tName2) {
/* 573 */     if (tName.length() != tName2.length()) {
/* 574 */       return false;
/*     */     }
/* 576 */     for (int i = 0; i < tName.length(); i++) {
/* 577 */       if (tName.charAt(i) != tName2.charAt(i))
/* 578 */         return false; 
/*     */     } 
/* 580 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\sprite\text\Str.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package util.info;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GFORMAT
/*     */ {
/*     */   public static GText text(GText text, CharSequence t) {
/*  18 */     text.color((GCOLOR.T()).INORMAL);
/*  19 */     text.add(t);
/*  20 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText iOrF(GText text, double v) {
/*  25 */     if ((int)v == v) {
/*  26 */       i(text, (int)v);
/*     */     } else {
/*  28 */       f(text, v);
/*  29 */     }  return text;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  34 */   private static char[] iic = new char[] {
/*  35 */       'T', 
/*  36 */       'B', 
/*  37 */       'M', 
/*  38 */       'K'
/*     */     };
/*     */   
/*  41 */   private static double[] ii1 = new double[] {
/*  42 */       1.0E12D, 
/*  43 */       1.0E9D, 
/*  44 */       1000000.0D, 
/*  45 */       1000.0D
/*     */     };
/*     */   
/*     */   private static final String sdays = " day";
/*     */   
/*     */   private static final String sseason = " season";
/*     */   private static final String syears = " year";
/*     */   
/*     */   public static GText i(GText text, long i) {
/*  54 */     text.color((GCOLOR.T()).INORMAL);
/*  55 */     if (i < 0L) {
/*  56 */       text.add('-');
/*  57 */       i = -i;
/*     */     } 
/*     */     
/*  60 */     if (i < 1000L) {
/*  61 */       formatI((Str)text, i);
/*  62 */       return text;
/*     */     } 
/*     */     
/*  65 */     for (int k = 0; k < ii1.length; k++) {
/*  66 */       if (i >= ii1[k]) {
/*  67 */         int dd = (int)Math.round(i * 100.0D / ii1[k]);
/*  68 */         int full = dd / 100;
/*  69 */         int rem = dd % 100;
/*     */         
/*  71 */         text.add(full);
/*  72 */         if (full < 100)
/*     */         {
/*  74 */           if (full >= 10) {
/*  75 */             text.add('.');
/*  76 */             text.add((rem / 10));
/*     */           } else {
/*  78 */             text.add('.');
/*  79 */             text.add((rem / 10));
/*  80 */             text.add((rem % 10));
/*     */           } 
/*     */         }
/*  83 */         text.add(iic[k]);
/*  84 */         return text;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  89 */     return text;
/*     */   }
/*     */   
/*     */   public static void colorInter(GText text, double i, double k) {
/*  93 */     double d = i / k;
/*  94 */     if (!Double.isFinite(d))
/*  95 */       d = 1.0D; 
/*  96 */     CLAMP.d(d, 0.0D, 1.0D);
/*  97 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).INORMAL, (GCOLOR.T()).IBAD, d));
/*     */   }
/*     */   
/*     */   public static void colorInterInv(GText text, double i, double k) {
/* 101 */     double d = i / k;
/* 102 */     if (!Double.isFinite(d) || d > 1.0D)
/* 103 */       d = 1.0D; 
/* 104 */     if (d < 0.0D)
/* 105 */       d = 0.0D; 
/* 106 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).INORMAL, d));
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText iIncr(GText text, long i) {
/* 111 */     if (i >= 0L) {
/* 112 */       text.add('+');
/*     */     }
/*     */     
/* 115 */     i(text, i);
/*     */     
/* 117 */     if (i > 0L) {
/* 118 */       text.color((GCOLOR.T()).IGOOD);
/* 119 */     } else if (i < 0L) {
/* 120 */       text.color((GCOLOR.T()).IBAD);
/*     */     } else {
/* 122 */       text.color(COLOR.WHITE85);
/* 123 */     }  return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText iIncrI(GText text, long i) {
/* 128 */     if (i >= 0L) {
/* 129 */       text.add('+');
/*     */     }
/*     */     
/* 132 */     i(text, i);
/*     */     
/* 134 */     if (i < 0L) {
/* 135 */       text.color((GCOLOR.T()).IGOOD);
/* 136 */     } else if (i > 0L) {
/* 137 */       text.color((GCOLOR.T()).IBAD);
/*     */     } else {
/* 139 */       text.color(COLOR.WHITE85);
/* 140 */     }  return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText iIncrBig(GText text, int i) {
/* 145 */     if (i >= 0) {
/* 146 */       text.add('+');
/*     */     }
/*     */     
/* 149 */     iBig(text, i);
/*     */     
/* 151 */     if (i > 0) {
/* 152 */       text.color((GCOLOR.T()).IGOOD);
/* 153 */     } else if (i < 0) {
/* 154 */       text.color((GCOLOR.T()).IBAD);
/*     */     } else {
/* 156 */       text.color(COLOR.WHITE85);
/* 157 */     }  return text;
/*     */   }
/*     */   
/*     */   public static void formatI(Str text, long i) {
/* 161 */     if (i == 0L) {
/* 162 */       text.add(0L);
/*     */       return;
/*     */     } 
/* 165 */     formatIR(text, i, 0L);
/*     */   }
/*     */   
/*     */   private static long formatIR(Str text, long i, long r) {
/* 169 */     if (i == 0L) {
/* 170 */       return r;
/*     */     }
/*     */     
/* 173 */     if (i < 0L) {
/* 174 */       text.add('-');
/* 175 */       i = -i;
/*     */     } 
/*     */     
/* 178 */     long mod = i % 10L;
/* 179 */     long k = formatIR(text, i / 10L, r + 1L);
/* 180 */     if (k != 0L && k % 3L == 0L && i / 10L != 0L)
/* 181 */       text.s(); 
/* 182 */     text.add(mod);
/*     */     
/* 184 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText iBig(GText text, long i) {
/* 189 */     if (i < 0L) {
/* 190 */       text.add('-');
/* 191 */       text.color((GCOLOR.T()).IBAD);
/* 192 */       i = -i;
/*     */     } else {
/* 194 */       text.color((GCOLOR.T()).INORMAL);
/* 195 */     }  formatI((Str)text, i);
/* 196 */     return text;
/*     */   }
/*     */   
/*     */   public static GText iofkNoColor(GText text, long i, long k) {
/* 200 */     formatI((Str)text, i);
/* 201 */     text.add('/');
/* 202 */     formatI((Str)text, k);
/* 203 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText iofk(GText text, long i, long k) {
/* 210 */     double d = i / k;
/* 211 */     if (!Double.isFinite(d))
/* 212 */       d = 1.0D; 
/* 213 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).INORMAL, (GCOLOR.T()).IBAD, d));
/* 214 */     formatI((Str)text, i);
/* 215 */     text.add('/');
/* 216 */     formatI((Str)text, k);
/* 217 */     return text;
/*     */   }
/*     */   
/*     */   public static GText dofk(GText text, double d, double k) {
/* 221 */     double dd = d / k;
/* 222 */     if (!Double.isFinite(dd))
/* 223 */       dd = 1.0D; 
/* 224 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).INORMAL, dd));
/* 225 */     text.add(d, 1);
/* 226 */     text.add('/');
/* 227 */     text.add(k, 1);
/* 228 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText iofkInv(GText text, long i, long k) {
/* 235 */     double d = i / k;
/* 236 */     if (!Double.isFinite(d))
/* 237 */       d = 1.0D; 
/* 238 */     if (k == 0L)
/* 239 */       d = 1.0D; 
/* 240 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 241 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).INORMAL, d));
/* 242 */     formatI((Str)text, i);
/* 243 */     text.add('/');
/* 244 */     formatI((Str)text, k);
/* 245 */     return text;
/*     */   }
/*     */   
/*     */   public static GText iofkInv(GText text, double i, long k) {
/* 249 */     double d = i / k;
/* 250 */     if (!Double.isFinite(d))
/* 251 */       d = 1.0D; 
/* 252 */     if (k == 0L)
/* 253 */       d = 1.0D; 
/* 254 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 255 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).INORMAL, d));
/*     */     
/* 257 */     text.add(i, 1);
/* 258 */     text.add('/');
/* 259 */     formatI((Str)text, k);
/* 260 */     return text;
/*     */   }
/*     */   
/*     */   public static GText fofkInv(GText text, double i, double k) {
/* 264 */     double d = i / k;
/* 265 */     if (!Double.isFinite(d))
/* 266 */       d = 1.0D; 
/* 267 */     if (k == 0.0D)
/* 268 */       d = 1.0D; 
/* 269 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 270 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).INORMAL, d));
/*     */     
/* 272 */     text.add(i, 2);
/* 273 */     text.add('/');
/* 274 */     if ((int)k == k) {
/* 275 */       text.add((int)k, 2);
/*     */     } else {
/* 277 */       text.add(k, 2);
/* 278 */     }  return text;
/*     */   }
/*     */   
/*     */   public static GText f(GText text, double f) {
/* 282 */     text.color((GCOLOR.T()).INORMAL);
/* 283 */     if (Double.isFinite(f)) {
/* 284 */       text.add(f, 3);
/*     */     } else {
/* 286 */       text.add('-');
/* 287 */     }  return text;
/*     */   }
/*     */   
/*     */   public static GText f(GText text, double f, int dec) {
/* 291 */     text.color((GCOLOR.T()).INORMAL);
/* 292 */     if (Double.isFinite(f)) {
/* 293 */       text.add(f, dec);
/*     */     } else {
/* 295 */       text.add('-');
/* 296 */     }  return text;
/*     */   }
/*     */   
/*     */   public static GText f1(GText text, double f, double ref) {
/* 300 */     if (f < 1.0D) {
/* 301 */       text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IWORST, (GCOLOR.T()).IBAD, f));
/* 302 */     } else if (f > 1.0D) {
/* 303 */       text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IGOOD, (GCOLOR.T()).IGREAT, f / ref));
/*     */     } else {
/* 305 */       text.color(COLOR.WHITE85);
/* 306 */     }  text.add(f, 2);
/* 307 */     return text;
/*     */   }
/*     */   
/*     */   public static GText f1(GText text, double f) {
/* 311 */     if (f < 1.0D) {
/* 312 */       text.color((GCOLOR.T()).IWORST);
/* 313 */     } else if (f > 1.0D) {
/* 314 */       text.color((GCOLOR.T()).IGREAT);
/*     */     } else {
/* 316 */       text.color(COLOR.WHITE85);
/* 317 */     }  text.add(f, 2);
/* 318 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText mul(GText t, double mul) {
/* 323 */     t.add('*');
/* 324 */     f1(t, mul);
/* 325 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText f1Inv(GText text, double f) {
/* 330 */     if (f < 1.0D) {
/* 331 */       text.color((GCOLOR.T()).IGREAT);
/* 332 */     } else if (f > 1.0D) {
/* 333 */       text.color((GCOLOR.T()).IWORST);
/*     */     } else {
/* 335 */       text.color(COLOR.WHITE85);
/* 336 */     }  text.add(f, 2);
/* 337 */     return text;
/*     */   }
/*     */   
/*     */   public static GText f1d(GText text, double f, int dec) {
/* 341 */     if (f < 1.0D) {
/* 342 */       text.color((GCOLOR.T()).IBAD);
/* 343 */     } else if (f > 1.0D) {
/* 344 */       text.color((GCOLOR.T()).IGOOD);
/*     */     } else {
/* 346 */       text.color(COLOR.WHITE85);
/* 347 */     }  text.add(f, dec);
/* 348 */     return text;
/*     */   }
/*     */   
/*     */   public static GText fRel(GText text, double f, double ref) {
/* 352 */     f(text, f);
/* 353 */     if (f == ref) {
/* 354 */       text.color((GCOLOR.T()).NORMAL);
/* 355 */     } else if (f > ref) {
/* 356 */       text.color((GCOLOR.T()).IGOOD);
/*     */     } else {
/* 358 */       text.color((GCOLOR.T()).IBAD);
/* 359 */     }  return text;
/*     */   }
/*     */   
/*     */   public static GText f0(GText text, double f, double ref) {
/* 363 */     f0(text, f);
/* 364 */     if (ref == 0.0D)
/* 365 */       ref = f; 
/* 366 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IWORST, (GCOLOR.T()).IGREAT, f / ref));
/* 367 */     return text;
/*     */   }
/*     */   
/*     */   public static GText f0Inv(GText text, double f, double ref) {
/* 371 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IGREAT, (GCOLOR.T()).IWORST, f / ref));
/* 372 */     text.add(f, 2);
/* 373 */     return text;
/*     */   }
/*     */   
/*     */   public static GText f0(GText text, double f) {
/* 377 */     if (!Double.isFinite(f)) {
/* 378 */       f = 0.0D;
/*     */     }
/* 380 */     if (f < 0.0D) {
/* 381 */       text.color((GCOLOR.T()).IWORST);
/* 382 */     } else if (f > 0.0D) {
/* 383 */       text.color((GCOLOR.T()).IGREAT);
/* 384 */       text.add('+');
/*     */     } else {
/* 386 */       text.color(COLOR.WHITE85);
/*     */     } 
/* 388 */     text.add(f, 2);
/* 389 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText increaseAdaptive(GText text, double f) {
/* 400 */     if (!Double.isFinite(f)) {
/* 401 */       f = 0.0D;
/*     */     }
/* 403 */     if (f < 0.0D) {
/* 404 */       text.color((GCOLOR.T()).IWORST);
/* 405 */     } else if (f > 0.0D) {
/* 406 */       text.color((GCOLOR.T()).IGREAT);
/* 407 */       text.add('+');
/*     */     } else {
/* 409 */       text.color(COLOR.WHITE85);
/*     */     } 
/* 411 */     if (f == (int)f) {
/* 412 */       text.add((int)f);
/* 413 */     } else if (f * 10.0D == (int)(f * 10.0D)) {
/* 414 */       text.add(f, 1);
/*     */     } else {
/* 416 */       text.add(f, 2);
/*     */     } 
/*     */     
/* 419 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText perc(GText text, double f) {
/* 427 */     return perc(text, f, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText perc(GText text, double f, int decimals) {
/* 434 */     if (!Double.isFinite(f)) {
/* 435 */       text.add('-').add('-').add('-');
/* 436 */       text.color((GCOLOR.T()).INACTIVE);
/* 437 */       return text;
/*     */     } 
/*     */     
/* 440 */     if (f < 0.0D) {
/* 441 */       text.color((GCOLOR.T()).IBAD);
/* 442 */       text.add('-');
/* 443 */       f = -f;
/* 444 */     } else if (f > 0.0D) {
/* 445 */       text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).IGOOD, (f > 1.0D) ? 1.0D : f));
/*     */     } else {
/* 447 */       text.color((GCOLOR.T()).INACTIVE);
/*     */     } 
/* 449 */     text.add(f * 100.0D, decimals, true);
/* 450 */     text.add('%');
/*     */     
/* 452 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText perc100(GText text, double f, int decimals) {
/* 458 */     perc(text, f, decimals);
/*     */     
/* 460 */     if (f < 1.0D) {
/* 461 */       text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IWORST, (GCOLOR.T()).IBAD, f));
/*     */     } else {
/* 463 */       text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IGOOD, (GCOLOR.T()).IGREAT, CLAMP.d(f - 1.0D, 0.0D, 1.0D)));
/*     */     } 
/*     */     
/* 466 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText percInc(GText text, double f) {
/* 471 */     return percInc(text, f, 2);
/*     */   }
/*     */   
/*     */   public static GText percInc(GText text, double f, int decimals) {
/* 475 */     if (!Double.isFinite(f)) {
/* 476 */       text.add('-').add('-').add('-');
/* 477 */       text.color((GCOLOR.T()).NORMAL);
/* 478 */       return text;
/*     */     } 
/*     */     
/* 481 */     f *= 100.0D;
/*     */     
/* 483 */     if (f < 0.0D) {
/* 484 */       text.color((GCOLOR.T()).IBAD);
/* 485 */       text.add('-');
/* 486 */       f = -f;
/* 487 */     } else if (f > 0.0D) {
/* 488 */       text.color((GCOLOR.T()).IGOOD);
/* 489 */       text.add('+');
/*     */     } else {
/* 491 */       text.color((GCOLOR.T()).NORMAL);
/*     */     } 
/* 493 */     text.add(f, decimals, false);
/* 494 */     text.add('%');
/*     */     
/* 496 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText percIncInv(GText text, double f) {
/* 501 */     if (f < 0.0D) {
/* 502 */       text.color((GCOLOR.T()).IGOOD);
/* 503 */       text.add('-');
/* 504 */       text.add((int)(-f * 100.0D)).add('%');
/* 505 */       return text;
/* 506 */     }  if (f > 0.0D) {
/* 507 */       text.color((GCOLOR.T()).IBAD);
/* 508 */       text.add('+');
/* 509 */       text.add((int)(f * 100.0D)).add('%');
/* 510 */       return text;
/*     */     } 
/* 512 */     text.color((GCOLOR.T()).INACTIVE);
/* 513 */     text.add('0');
/*     */     
/* 515 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText percBig(GText text, double f) {
/* 520 */     if (!Double.isFinite(f)) {
/* 521 */       text.add('-').add('-').add('-');
/* 522 */       text.color((GCOLOR.T()).INACTIVE);
/* 523 */       return text;
/*     */     } 
/*     */     
/* 526 */     if (f < 0.0D) {
/* 527 */       text.add('-');
/* 528 */       text.color((GCOLOR.T()).IBAD);
/* 529 */       text.add((int)(-f * 100.0D)).add('%');
/* 530 */       return text;
/*     */     } 
/*     */     
/* 533 */     f *= 100.0D;
/* 534 */     int b = (int)f;
/*     */     
/* 536 */     text.add(b).add('.');
/* 537 */     f -= (int)f;
/*     */     
/* 539 */     f *= 10000.0D;
/* 540 */     b = (int)f;
/*     */     
/* 542 */     int d = 1000;
/* 543 */     if (b > 0) {
/* 544 */       while (b > 0) {
/* 545 */         int k = b / d;
/* 546 */         text.add(k);
/* 547 */         b -= k * d;
/* 548 */         d /= 10;
/*     */       } 
/*     */     } else {
/* 551 */       text.add(0L);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 560 */     text.add('%');
/* 561 */     return text;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText percGood(GText text, double f) {
/* 566 */     if (!Double.isFinite(f)) {
/* 567 */       if (!Double.isFinite(f)) {
/* 568 */         text.add('-').add('-').add('-');
/*     */       } else {
/* 570 */         text.add((int)(f * 100.0D)).add('%');
/* 571 */       }  text.color((GCOLOR.T()).INACTIVE);
/* 572 */       return text;
/*     */     } 
/* 574 */     text.color((GCOLOR.T()).INORMAL);
/* 575 */     int k = (int)(f * 1000.0D);
/* 576 */     text.add((k / 10));
/* 577 */     if (k % 10 > 0) {
/* 578 */       text.add('.').add((k % 10));
/*     */     }
/* 580 */     text.add('%');
/* 581 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText percInv(GText text, double f) {
/* 588 */     if (f < 0.0D) {
/* 589 */       text.add('-').add('-').add('-');
/* 590 */       text.color((GCOLOR.T()).INACTIVE);
/* 591 */       return text;
/*     */     } 
/*     */     
/* 594 */     text.color((COLOR)ColorImp.TMP.interpolate((GCOLOR.T()).IGOOD, (GCOLOR.T()).IBAD, f));
/* 595 */     int k = (int)(f * 1000.0D);
/* 596 */     text.add((k / 10));
/* 597 */     if (k % 10 > 0) {
/* 598 */       text.add('.').add((k % 10));
/*     */     }
/* 600 */     text.add('%');
/* 601 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void gameDays(GText text, int foodDays) {
/* 610 */     if (foodDays > TIME.years().bitConversion((TIMECYCLE)TIME.days())) {
/* 611 */       double d = foodDays / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 612 */       text.add(d, 1).add(" year");
/* 613 */       if (d > 1.0D)
/* 614 */         text.add('s'); 
/* 615 */     } else if (foodDays > TIME.seasons().bitConversion((TIMECYCLE)TIME.days())) {
/* 616 */       double d = foodDays / TIME.seasons().bitConversion((TIMECYCLE)TIME.days());
/* 617 */       text.add(d, 1).add(" season");
/* 618 */       if (d > 1.0D)
/* 619 */         text.add('s'); 
/*     */     } else {
/* 621 */       text.add(foodDays).add(" day");
/* 622 */       if (foodDays > 1) {
/* 623 */         text.add('s');
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void gameDaysShort(GText text, int foodDays) {
/* 629 */     if (foodDays > TIME.years().bitConversion((TIMECYCLE)TIME.days())) {
/* 630 */       double d = foodDays / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 631 */       text.add(d, 1).add('Y');
/* 632 */     } else if (foodDays > TIME.seasons().bitConversion((TIMECYCLE)TIME.days())) {
/* 633 */       double d = foodDays / TIME.seasons().bitConversion((TIMECYCLE)TIME.days());
/* 634 */       text.add(d, 1).add('S');
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static GText bool(GText text, boolean b) {
/* 641 */     text.add(b);
/* 642 */     text.color(b ? (GCOLOR.T()).IGOOD : (GCOLOR.T()).IBAD);
/* 643 */     return text;
/*     */   }
/*     */ 
/*     */   
/* 647 */   private static final String[] hundreds = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
/* 648 */   private static final String[] tens = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
/* 649 */   private static final String[] units = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
/* 650 */   private static final Str tmp = new Str(4);
/*     */ 
/*     */   
/*     */   public static Str toNumeral(Str text, int num) {
/* 654 */     while (num > 1000) {
/* 655 */       text.add('M');
/* 656 */       num -= 1000;
/*     */     } 
/*     */     
/* 659 */     text.add(hundreds[num / 100]);
/* 660 */     text.add(tens[num % 100 / 10]);
/* 661 */     text.add(units[num % 10]);
/*     */     
/* 663 */     return text;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static Str toNumeral(int num) {
/* 669 */     tmp.clear();
/* 670 */     return toNumeral(tmp, num);
/*     */   }
/*     */ 
/*     */   
/*     */   public static GText toNumeral(GText text, int num) {
/* 675 */     toNumeral((Str)text, num);
/* 676 */     return text;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\info\GFORMAT.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
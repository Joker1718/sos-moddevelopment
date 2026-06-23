/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ 
/*     */ public class DealDrawfter {
/*     */   private static int[] rr;
/*     */   
/*     */   public static void draftPeace(Deal deal, FactionNPC enemy, boolean playerIsMakingDeal) {
/*  21 */     deal.setFactionAndClear(enemy, playerIsMakingDeal);
/*     */     
/*  23 */     deal.bools.PEACE.set(true);
/*     */     
/*  25 */     draft(deal, 0.0D, true, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void draft(Deal deal, boolean bools, boolean regs) {
/*  30 */     draft(deal, 0.0D, bools, regs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void draft(Deal deal, double dcreds, boolean bools, boolean regs) {
/*  36 */     int v = (int)(deal.valueCredits() + dcreds);
/*  37 */     if (v < 0) {
/*  38 */       give(deal, deal.player, -v, bools, regs);
/*     */     } else {
/*  40 */       give(deal, deal.npc, v, bools, regs);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  46 */   private static ArrayListGrower<Gift> giftable = new ArrayListGrower();
/*  47 */   private static ArrayList<DealBool> tbools = new ArrayList(16);
/*     */   private static boolean log = false;
/*     */   
/*     */   private static void init(DealParty g, Deal deal) {
/*  51 */     if (rr == null) {
/*  52 */       for (TRADABLE res : TR.ALL()) {
/*  53 */         giftable.add(new Gift()
/*     */             {
/*     */               public int max()
/*     */               {
/*  57 */                 return gg.resources.max(res);
/*     */               }
/*     */ 
/*     */               
/*     */               public int get() {
/*  62 */                 return gg.resources.get(res);
/*     */               }
/*     */ 
/*     */               
/*     */               public void set(int t) {
/*  67 */                 gg.resources.set(res, t);
/*     */               }
/*     */ 
/*     */               
/*     */               public int value(int am) {
/*  72 */                 return gg.valueResource(res, am);
/*     */               }
/*     */ 
/*     */               
/*     */               public boolean canGift() {
/*  77 */                 return (oo.resources.get(res) <= 0);
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/*  83 */       rr = Alloc.ii(giftable.size());
/*     */     } 
/*     */ 
/*     */     
/*  87 */     Gift.gg = g;
/*  88 */     Gift.oo = (deal.npc == g) ? deal.player : deal.npc; int i;
/*  89 */     for (i = 0; i < rr.length; i++)
/*  90 */       rr[i] = i; 
/*  91 */     for (i = 0; i < rr.length; i++) {
/*  92 */       int o = rr[i];
/*  93 */       int ii = RND.rInt(rr.length);
/*  94 */       rr[i] = rr[ii];
/*  95 */       rr[ii] = o;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void give(Deal deal, DealParty g, int value, boolean bools, boolean regs) {
/* 101 */     int creds = (int)(g.credits.max() * 0.9D - g.credits.get());
/* 102 */     creds = Math.max(creds, 0);
/*     */     
/* 104 */     if (log) {
/* 105 */       LOG.ln("" + value + " " + value + " " + bools + " " + regs);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 110 */     if (bools) {
/*     */       
/* 112 */       if (creds >= value * 2) {
/* 113 */         g.credits.inc(value);
/*     */         
/*     */         return;
/*     */       } 
/* 117 */       if (DIP.WAR().is(deal.player.f(), deal.npc.f())) {
/* 118 */         tbools.clearSloppy();
/* 119 */         tbools.add(deal.bools.OVERLORD);
/* 120 */         tbools.add(deal.bools.VASSAL);
/* 121 */         tbools.add(deal.bools.PEACE);
/* 122 */         boolean wasPeace = deal.bools.PEACE.is();
/* 123 */         boolean hasSet = false;
/* 124 */         for (DealBool dealBool : tbools) {
/* 125 */           dealBool.set(false);
/*     */         }
/* 127 */         for (DealBool dealBool : tbools) {
/* 128 */           if (dealBool.problem() == null) {
/* 129 */             double v = dealBool.value() * ((deal.player == g) ? true : false);
/* 130 */             if (v > 0.0D && value - v >= 0.0D) {
/* 131 */               if (log) {
/* 132 */                 LOG.ln("wbool " + String.valueOf(dealBool.info.name) + " " + v + " " + value);
/*     */               }
/* 134 */               value = (int)(value - v);
/* 135 */               dealBool.set(true);
/* 136 */               hasSet = true;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/* 141 */         if (!hasSet && wasPeace) {
/* 142 */           deal.bools.PEACE.set(true);
/*     */         }
/*     */       } else {
/* 145 */         boolean hasOne = false;
/* 146 */         for (DealBool dealBool : deal.bools.all()) {
/* 147 */           if (dealBool.is()) {
/* 148 */             hasOne = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 153 */         if (!hasOne) {
/* 154 */           for (DealBool dealBool : deal.bools.all()) {
/* 155 */             if (dealBool.problem() == null && !dealBool.is()) {
/* 156 */               double v = dealBool.value() * ((deal.player == g) ? true : false);
/* 157 */               if (v > 0.0D && value - v >= 0.0D) {
/* 158 */                 value = (int)(value - v);
/* 159 */                 dealBool.set(true);
/* 160 */                 if (log) {
/* 161 */                   LOG.ln("bool " + String.valueOf(dealBool.info.name) + " " + v + " " + value);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 171 */       if (creds >= value * 2) {
/* 172 */         g.credits.inc(value);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 177 */     int i = regs & (deal.bools.ABSORB.is() ? 0 : 1);
/*     */     
/* 179 */     if (i != 0) {
/*     */       
/* 181 */       if (creds >= value * 2) {
/* 182 */         g.credits.inc(value);
/*     */         
/*     */         return;
/*     */       } 
/* 186 */       boolean hasreg = true;
/* 187 */       while (hasreg) {
/* 188 */         hasreg = false;
/* 189 */         for (DealRegs.DealReg r : g.regs.all()) {
/* 190 */           if (r.value() > 0.0D && r.canSelect() && !r.is() && r.value() < value) {
/* 191 */             if (log) {
/* 192 */               LOG.ln("reg " + r.value() + " " + value);
/*     */             }
/* 194 */             hasreg = true;
/* 195 */             r.set(true);
/* 196 */             value = (int)(value - r.value());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 202 */       if (creds >= value * 2) {
/* 203 */         g.credits.inc(value);
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 211 */     init(g, deal); byte b;
/*     */     int j, arrayOfInt[];
/* 213 */     for (j = (arrayOfInt = rr).length, b = 0; b < j; ) { int ri = arrayOfInt[b];
/*     */       
/* 215 */       Gift oo = (Gift)giftable.get(ri);
/* 216 */       if (oo.value(1) > 0) {
/*     */ 
/*     */         
/* 219 */         int am = oo.max() - oo.get();
/* 220 */         int oldValue = oo.value(oo.get());
/* 221 */         am = CLAMP.i(oo.max() / 5, 0, am);
/* 222 */         if (am > 0)
/*     */         {
/* 224 */           if (oo.canGift())
/*     */           {
/* 226 */             if (oo.value(oo.get() + 1) - oldValue <= value) {
/*     */ 
/*     */               
/* 229 */               int cv = oo.value(oo.get() + am) - oldValue;
/* 230 */               if (cv != 0) {
/*     */                 
/* 232 */                 while (cv > value && am > 0) {
/*     */                   
/* 234 */                   double dec = value;
/* 235 */                   dec /= cv;
/* 236 */                   dec = 1.0D - dec;
/*     */                   
/* 238 */                   am = (int)(am - Math.ceil(dec * am * 0.5D));
/* 239 */                   cv = oo.value(oo.get() + am) - oldValue;
/*     */                 } 
/*     */                 
/* 242 */                 if (am > 0) {
/* 243 */                   value -= cv;
/* 244 */                   oo.inc(am);
/* 245 */                   if (log) {
/* 246 */                     LOG.ln(String.valueOf(RESOURCES.ALL().get(ri)) + " " + String.valueOf(RESOURCES.ALL().get(ri)) + " " + am + " " + oo.value(am));
/*     */                   }
/* 248 */                   if (value <= 0) {
/*     */                     break;
/*     */                   }
/*     */                 } 
/* 252 */                 if (creds >= value) {
/* 253 */                   g.credits.inc(value); return;
/*     */                 } 
/*     */               } 
/*     */             }  }  } 
/*     */       }  b++; }
/* 258 */      if (creds >= value) {
/* 259 */       g.credits.inc(value);
/*     */       
/*     */       return;
/*     */     } 
/* 263 */     for (int nopI = 0; nopI < rr.length && value > 0; ) {
/* 264 */       Gift petit = null;
/* 265 */       int MV = Integer.MAX_VALUE;
/*     */       byte b1;
/*     */       int k, arrayOfInt1[];
/* 268 */       for (k = (arrayOfInt1 = rr).length, b1 = 0; b1 < k; ) { int ri = arrayOfInt1[b1];
/* 269 */         Gift oo = (Gift)giftable.get(ri);
/* 270 */         int am = oo.max() - oo.get();
/* 271 */         if (am > 0 && oo.canGift()) {
/* 272 */           int v = oo.value(oo.get() + 1) - oo.value(oo.get());
/* 273 */           if (v > 0 && v < MV) {
/* 274 */             petit = oo;
/* 275 */             MV = v;
/*     */           } 
/*     */         } 
/*     */         b1++; }
/*     */       
/* 280 */       if (petit != null) {
/* 281 */         int max = petit.max();
/* 282 */         int base = petit.value(petit.get());
/* 283 */         while (petit.get() + 1 < max - 1) {
/* 284 */           int v = petit.value(petit.get() + 1) - base;
/* 285 */           petit.inc(1);
/* 286 */           if (v >= value) {
/* 287 */             value -= v;
/*     */ 
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/*     */         nopI++;
/*     */       } 
/*     */       
/*     */       break;
/*     */     } 
/*     */     
/* 300 */     if (value > 0 && creds >= value) {
/* 301 */       g.credits.inc(value);
/*     */       return;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static abstract class Gift
/*     */     implements INT.INTE {
/*     */     public static DealParty gg;
/*     */     public static DealParty oo;
/*     */     
/*     */     public abstract int value(int param1Int);
/*     */     
/*     */     public abstract boolean canGift();
/*     */     
/*     */     public int min() {
/* 316 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealDrawfter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
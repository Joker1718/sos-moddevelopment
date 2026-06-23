/*     */ package settlement.room.industry.module;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.consumption.RoomConsumptionAbs;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class IndustryUtil
/*     */ {
/*  29 */   private static CharSequence ¤¤pRate = "Production speed";
/*  30 */   private static CharSequence ¤¤cRate = "Consumption Rate";
/*  31 */   private static CharSequence ¤¤cBonus = "Consumption Bonus";
/*     */   
/*     */   static {
/*  34 */     D.ts(IndustryUtil.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double calcConsumptionRate(double base, Humanoid h, RoomInstance ins, RoomConsumptionAbs industry) {
/*  42 */     return calcProductionRate(base, h, (IndustryRate)industry, industry.bonus(), ins) / industry.conBonus((BOOSTABLE_O)h.indu());
/*     */   }
/*     */   
/*     */   public static double calcConsumptionRate(double base, RoomInstance ins, RoomConsumptionAbs industry) {
/*  46 */     double mul = 1.0D;
/*     */     
/*  48 */     Boostable bonus = industry.conBonus;
/*     */     
/*  50 */     if (bonus != null) {
/*  51 */       mul = bonus.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */     }
/*     */ 
/*     */     
/*  55 */     return calcProductionRate(base, (IndustryRate)industry, industry.bonus(), ins) / mul;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double roomBonus(RoomInstance ins, IndustryRate rate) {
/*  60 */     double r = 1.0D;
/*  61 */     r *= 1.0D - 0.75D * ins.getDegrade();
/*  62 */     if (rate != null) {
/*  63 */       for (RoomBoost b : rate.boosts()) {
/*  64 */         r *= b.get(ins);
/*     */       }
/*     */     }
/*  67 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double calcProductionRate(double base, Humanoid h, IndustryRate rate, RoomInstance ins) {
/*  72 */     return calcProductionRate(base, h, rate, rate.bonus(), ins);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double calcProductionRate(double base, Humanoid h, IndustryRate rate, Boostable bonus, RoomInstance ins) {
/*  77 */     double r = roomBonus(ins, rate);
/*  78 */     r *= base;
/*  79 */     if (bonus != null)
/*  80 */       r *= bonus.get((BOOSTABLE_O)h.indu()); 
/*  81 */     return r;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double calcProductionRate(double baseRate, IndustryRate rate, RoomInstance ins) {
/*  86 */     return calcProductionRate(baseRate, rate, rate.bonus(), ins);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double calcProductionRate(double baseRate, IndustryRate rate, Boostable bonus, RoomInstance ins) {
/*  91 */     double r = roomBonus(ins, rate);
/*  92 */     r *= ins.employees().totEfficiency();
/*     */     
/*  94 */     double am = 0.0D;
/*  95 */     double mul = 0.0D;
/*     */ 
/*     */ 
/*     */     
/*  99 */     if (bonus != null) {
/* 100 */       for (Humanoid a : ins.employees().employees()) {
/* 101 */         mul += bonus.get((BOOSTABLE_O)a.indu());
/* 102 */         am++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (am > 0.0D) {
/* 109 */       mul /= am;
/*     */     } else {
/* 111 */       mul = 1.0D;
/*     */     } 
/*     */     
/* 114 */     return r * mul * baseRate;
/*     */   }
/*     */   
/* 117 */   private static double[] values = new double[100];
/*     */   
/*     */   public static void hoverProductionRate(GUI_BOX text, double baseRate, IndustryRate rate, RoomInstance ins) {
/* 120 */     hoverProductionRate(text, baseRate, rate, rate.bonus(), ins);
/*     */   }
/*     */   
/*     */   public static void hoverProductionRate(GUI_BOX text, double baseRate, IndustryRate rate, Boostable bonus, RoomInstance ins) {
/* 124 */     GBox b = (GBox)text;
/*     */     
/* 126 */     b.NL(4);
/*     */     
/* 128 */     b.textLL(Dic.¤¤Base);
/* 129 */     b.NL();
/* 130 */     b.text(Dic.¤¤Rate);
/* 131 */     b.tab(6);
/* 132 */     b.add((SPRITE)GFORMAT.f(b.text(), baseRate));
/* 133 */     b.NL();
/*     */     
/* 135 */     b.text(Dic.¤¤Employees);
/* 136 */     b.tab(6);
/* 137 */     b.add((SPRITE)GFORMAT.i(b.text(), ins.employees().employed()));
/* 138 */     b.NL();
/*     */     
/* 140 */     b.text(RoomEmploymentIns.¤¤Workload);
/* 141 */     b.tab(6);
/* 142 */     b.add((SPRITE)GFORMAT.f1(b.text(), ins.employees().efficiency()));
/* 143 */     b.NL();
/*     */     
/* 145 */     b.text(RoomEmploymentIns.¤¤Proximity);
/* 146 */     b.tab(6);
/* 147 */     b.add((SPRITE)GFORMAT.f1(b.text(), ins.employees().proximity()));
/* 148 */     b.NL();
/*     */     
/* 150 */     if (ins.blueprintI().employment().countInput()) {
/* 151 */       b.text(RoomEmploymentIns.¤¤ProximityInput);
/* 152 */       b.tab(6);
/* 153 */       b.add((SPRITE)GFORMAT.f1(b.text(), ins.employees().fetchProximity()));
/* 154 */       b.NL();
/*     */     } 
/*     */     
/* 157 */     b.tab(6);
/* 158 */     b.add((SPRITE)GFORMAT.fRel(b.text(), baseRate * ins.employees().employed() * ins.employees().totEfficiency(), baseRate * ins.employees().employed()));
/* 159 */     b.NL(8);
/*     */     
/* 161 */     hoverBoosts(text, baseRate * ins.employees().employed(), rate, bonus, ins, ins.employees().totEfficiency());
/*     */     
/* 163 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hoverBoosts(GUI_BOX text, double baseRate, IndustryRate rate, Boostable bonus, RoomInstance ins, double totEfficiency) {
/* 168 */     GBox b = (GBox)text;
/*     */     
/* 170 */     double mul = 1.0D;
/* 171 */     double add = 0.0D;
/*     */     
/* 173 */     int tot = 0;
/* 174 */     Arrays.fill(values, 0.0D);
/* 175 */     for (Humanoid a : ins.employees().employees()) {
/*     */       
/* 177 */       tot++;
/*     */       
/* 179 */       int i = 0;
/*     */       
/* 181 */       if ((STATS.WORK()).EMPLOYED.get(a) == ins) {
/* 182 */         for (Booster s : bonus.all()) {
/* 183 */           if (s.isMul) {
/* 184 */             values[i] = values[i] + s.get(a.indu()) - 1.0D;
/*     */           } else {
/* 186 */             values[i] = values[i] + s.get(a.indu());
/*     */           } 
/*     */           
/* 189 */           i++;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 195 */     if (tot > 0) {
/* 196 */       int i = 0;
/*     */       
/* 198 */       for (Booster s : bonus.all()) {
/* 199 */         if (s.isMul) {
/* 200 */           values[i] = values[i] / tot;
/* 201 */           values[i] = values[i] + 1.0D;
/* 202 */           mul *= values[i];
/*     */         } else {
/* 204 */           values[i] = values[i] / tot;
/* 205 */           add += values[i];
/*     */         } 
/*     */         
/* 208 */         i++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 216 */     b.textLL(Dic.¤¤Multipliers);
/* 217 */     b.NL();
/*     */     
/* 219 */     if (ins.degrader(ins.mX(), ins.mY()) != null) {
/*     */       
/* 221 */       double v = 1.0D - 0.75D * ins.getDegrade();
/* 222 */       Booster.hover((GUI_BOX)b, v, 0, (SPRITE)(UI.icons()).s.degrade, true, Dic.¤¤Degrade);
/* 223 */       Booster.hoverSpan((GUI_BOX)b, 0.25D, 1.0D);
/* 224 */       mul *= v;
/* 225 */       b.NL();
/*     */     } 
/*     */ 
/*     */     
/* 229 */     b.NL();
/* 230 */     if (rate != null) {
/* 231 */       for (RoomBoost bo : rate.boosts()) {
/* 232 */         double bb = bo.get(ins);
/* 233 */         mul *= bb;
/* 234 */         Booster.hover((GUI_BOX)b, bb, 0, (SPRITE)(UI.icons()).s.chevron(DIR.W), true, (bo.info()).name);
/* 235 */         Booster.hoverSpan((GUI_BOX)b, bo.min(), bo.max());
/* 236 */         b.NL();
/*     */       } 
/*     */     }
/* 239 */     b.NL();
/* 240 */     int vi = 0;
/*     */     
/* 242 */     for (Booster bb : bonus.all()) {
/* 243 */       if (bb.isMul) {
/* 244 */         Booster.hover((GUI_BOX)b, values[vi], 0, bb.info.icon, true, bb.info.name);
/* 245 */         Booster.hoverSpan((GUI_BOX)b, bb.from(), bb.to());
/* 246 */         b.NL();
/*     */       } 
/*     */       
/* 249 */       vi++;
/*     */     } 
/*     */ 
/*     */     
/* 253 */     b.NL(4);
/* 254 */     b.tab(6);
/* 255 */     b.add((SPRITE)GFORMAT.f1(b.text(), mul));
/*     */     
/* 257 */     b.NL(8);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 262 */     b.textLL(Dic.¤¤Addative);
/* 263 */     b.NL();
/*     */     
/* 265 */     vi = 0;
/*     */     
/* 267 */     for (Booster bb : bonus.all()) {
/* 268 */       if (!bb.isMul) {
/* 269 */         Booster.hover((GUI_BOX)b, values[vi], 0, bb.info.icon, false, bb.info.name);
/* 270 */         Booster.hoverSpan((GUI_BOX)b, bb.from(), bb.to());
/* 271 */         b.NL();
/*     */       } 
/* 273 */       vi++;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 278 */     b.NL(4);
/*     */     
/* 280 */     b.tab(6);
/* 281 */     b.add((SPRITE)GFORMAT.f0(b.text(), add));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 288 */     b.NL(16);
/* 289 */     b.textLL(Dic.¤¤Total);
/* 290 */     b.tab(6);
/* 291 */     GText t = b.text();
/* 292 */     if (baseRate * totEfficiency != 1.0D) {
/* 293 */       GFORMAT.f1(t, baseRate * totEfficiency);
/* 294 */       t.s().add('*').s();
/*     */     } 
/*     */     
/* 297 */     GFORMAT.f1(t, mul);
/* 298 */     t.s().add('*').s();
/* 299 */     t.add('(').add('1').s().add('+').s();
/* 300 */     GFORMAT.f1(t, add).add(')').s().add('=').s();
/* 301 */     double tott = calcProductionRate(baseRate, rate, bonus, ins);
/* 302 */     GFORMAT.f0(t, tott, baseRate);
/* 303 */     b.add((SPRITE)t);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hoverConsumptionRate(GUI_BOX text, double baseRate, RoomInstance ins, RoomConsumptionAbs industry) {
/* 308 */     GBox b = (GBox)text;
/*     */     
/* 310 */     b.NL(4);
/* 311 */     b.textL(¤¤cRate);
/* 312 */     b.tab(6);
/* 313 */     b.add((SPRITE)GFORMAT.f(b.text(), -baseRate));
/* 314 */     b.NL();
/*     */     
/* 316 */     double rr = calcProductionRate(1.0D, (IndustryRate)industry, ins);
/*     */     
/* 318 */     b.NL(4);
/* 319 */     b.textL(¤¤pRate);
/* 320 */     b.tab(6);
/* 321 */     GText t = b.text();
/* 322 */     b.add((SPRITE)GFORMAT.f1(t, rr));
/* 323 */     b.NL();
/*     */     
/* 325 */     b.NL();
/* 326 */     b.textL(Dic.¤¤Employees);
/* 327 */     b.tab(6);
/* 328 */     b.add((SPRITE)GFORMAT.i(b.text(), ins.employees().employed()));
/* 329 */     b.NL();
/*     */     
/* 331 */     b.NL();
/* 332 */     b.textL(¤¤cBonus);
/* 333 */     b.tab(6);
/* 334 */     b.add((SPRITE)GFORMAT.f(b.text(), industry.conBonus((BOOSTABLE_O)HCLASS_RACE.clP())));
/* 335 */     b.NL();
/*     */ 
/*     */     
/* 338 */     b.NL();
/* 339 */     b.textLL(Dic.¤¤Total);
/* 340 */     b.tab(6);
/* 341 */     b.add((SPRITE)b.text().add('(').add(baseRate).s().add('*').s().add(rr).s().add('*').s().add(ins.employees().employed()).add(')').s().add('/').s().add(industry.conBonus((BOOSTABLE_O)HCLASS_RACE.clP())).s().add('=').s().add(ins.employees().employed() * baseRate * rr / industry.conBonus((BOOSTABLE_O)HCLASS_RACE.clP())));
/* 342 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 346 */     b.NL(8);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void save(FilePutter p, LIST<Industry> ins) {
/* 351 */     p.i(ins.size());
/* 352 */     for (Industry i : ins)
/* 353 */       i.save(p); 
/*     */   }
/*     */   
/*     */   public static void load(FileGetter p, LIST<Industry> ins) throws IOException {
/* 357 */     int am = p.i();
/* 358 */     if (ins.size() != am) {
/* 359 */       for (int i = 0; i < am; i++)
/* 360 */         ((Industry)ins.get(0)).load(p); 
/*     */     } else {
/* 362 */       for (Industry i : ins)
/* 363 */         i.load(p); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void clear(LIST<Industry> ins) {
/* 368 */     for (Industry i : ins)
/* 369 */       i.clear(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\IndustryUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.room.tests;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.tests.production.Input;
/*     */ import settlement.room.tests.production.Production;
/*     */ import settlement.room.tests.production.ProductionSpec;
/*     */ import settlement.room.tests.production.ProductionTrader;
/*     */ import settlement.room.tests.production.TestRecipe;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
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
/*     */ class UITradeDebug
/*     */   extends GuiSection
/*     */ {
/*  55 */   private final int credits = 400;
/*  56 */   private final INT.IntImp toll = new INT.IntImp(0, 1000);
/*  57 */   private final INT.IntImp gametheory = new INT.IntImp(0, 100)
/*     */     {
/*     */       public void set(int t)
/*     */       {
/*  61 */         super.set(t);
/*  62 */         UITradeDebug.this.pbonuses.recount();
/*     */       }
/*     */     };
/*     */   
/*  66 */   private final INT.IntImp flatTariffSell = new INT.IntImp(0, 100);
/*  67 */   private final INT.IntImp flatTariffBuy = new INT.IntImp(0, 100);
/*  68 */   private final INT.IntImp bonusai = new INT.IntImp(100, 0, 600);
/*  69 */   private final INT.IntImp wPerItemUSed = new INT.IntImp(0, 0, 20);
/*  70 */   private final INT.IntImp consumptionBonus = new INT.IntImp(0, 0, 100);
/*     */ 
/*     */   
/*  73 */   private final ProductionSpec aibonuses = new ProductionSpec()
/*     */     {
/*     */       public double bonus(Industry t)
/*     */       {
/*  77 */         return UITradeDebug.this.bonusai.get() / 100.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double consumptionBonus(Industry ins) {
/*  82 */         return 1.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double wPerItemUsed() {
/*  87 */         return 0.1D;
/*     */       }
/*     */ 
/*     */       
/*     */       public double addedW() {
/*  92 */         return UITradeDebug.this.gametheory.getD();
/*     */       }
/*     */     };
/*     */   
/*  96 */   private final Production data = new Production();
/*  97 */   private final ProductionTrader trade = new ProductionTrader(this.data, 400);
/*     */   
/*     */   private class BonusPlayer implements ProductionSpec {
/* 100 */     private final double[] bonus = new double[Industry.all().size()];
/* 101 */     private final double[] cons = new double[Industry.all().size()];
/*     */     
/* 103 */     final ProductionSpec spec = new ProductionSpec()
/*     */       {
/*     */         public double wPerItemUsed()
/*     */         {
/* 107 */           return 0.05D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double consumptionBonus(Industry ins) {
/* 112 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double bonus(Industry ins) {
/* 117 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         public double addedW() {
/* 122 */           return 0.05D;
/*     */         }
/*     */       };
/*     */     
/*     */     BonusPlayer() {
/* 127 */       clear();
/*     */ 
/*     */ 
/*     */       
/* 131 */       recount();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void recount() {
/* 138 */       double toll = 0.05D;
/* 139 */       double buyT = 0.0D;
/* 140 */       double sellT = 0.2D;
/*     */       
/* 142 */       Arrays.fill(this.cons, 1.0D);
/* 143 */       Arrays.fill(this.bonus, 1.0D);
/* 144 */       UITradeDebug.this.bonusai.set(100);
/*     */       
/* 146 */       for (RESOURCE r : RESOURCES.ALL()) {
/* 147 */         LOG.ln(r.key + " " + r.key);
/* 148 */         LOG.ln("buy " + 400 * UITradeDebug.this.trade.sellPrice(r, this.spec, 1.0D, 0.0D, 0.05D));
/* 149 */         LOG.ln("sell " + 400 * UITradeDebug.this.trade.buyPrice(r, this.spec, 1.0D, 0.2D, 0.05D));
/* 150 */         LIST<TestRecipe> rs = UITradeDebug.this.data.get(r);
/*     */         
/* 152 */         for (TestRecipe rr : rs) {
/* 153 */           double t = rr.pricePerItem(this.spec);
/* 154 */           LOG.ln("    " + t + " " + rr.rate + " " + rr.wPerItem(this.spec));
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 161 */       boolean change = true;
/* 162 */       while (change) {
/* 163 */         change = false;
/*     */ 
/*     */ 
/*     */         
/* 167 */         for (Industry ins : (SETT.ROOMS()).industries.all) {
/*     */ 
/*     */           
/* 170 */           for (TestRecipe r : UITradeDebug.this.data.get(ins)) {
/*     */ 
/*     */             
/* 173 */             int expenditure = 0;
/* 174 */             for (Input i : r.inputs()) {
/* 175 */               double d = this.spec.bonus(ins) * i.amount;
/* 176 */               expenditure += UITradeDebug.this.trade.buyPrice(i.res, this.spec, d, 0.0D, 0.05D);
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 181 */             double amount = this.spec.bonus(ins) * r.rate;
/*     */             
/* 183 */             int income = UITradeDebug.this.trade.sellPrice(r.res, this.spec, amount, 0.2D, 0.05D);
/*     */             
/* 185 */             double cr = 400.0D - amount * 0.05D - 80.0D;
/*     */             
/* 187 */             if (expenditure > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 192 */               double c = (income - cr) / expenditure;
/* 193 */               LOG.ln(ins.blue.key + " " + ins.blue.key + " " + r.rate + " " + income + " " + -expenditure + " " + c);
/* 194 */               if (c < 1.0D) {
/*     */                 
/* 196 */                 c = 1.0D / c;
/* 197 */                 if (c > this.cons[ins.index()]) {
/* 198 */                   this.cons[ins.index()] = c;
/* 199 */                   change = true;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 209 */       LOG.ln();
/* 210 */       for (Industry ins : (SETT.ROOMS()).industries.all) {
/* 211 */         if (ins.outs().size() == 0)
/*     */           continue; 
/* 213 */         String s = " | " + String.valueOf(((IndustryResource)ins.outs().get(0)).resource.name) + " -> ";
/* 214 */         for (IndustryResource ii : ins.ins())
/* 215 */           s = s + s + ", "; 
/* 216 */         LOG.ln(ins.blue.key + " " + ins.blue.key + (int)((this.cons[ins.index()] - 1.0D) * 100.0D) / 100.0D);
/*     */       } 
/*     */ 
/*     */       
/* 220 */       for (Industry ins : (SETT.ROOMS()).industries.all) {
/* 221 */         if (ins.outs().size() == 0)
/*     */           continue; 
/* 223 */         String s = " | " + String.valueOf(((IndustryResource)ins.outs().get(0)).resource.name) + " -> ";
/* 224 */         for (IndustryResource ii : ins.ins())
/* 225 */           s = s + s + ", "; 
/* 226 */         LOG.ln(ins.blue.key + " " + ins.blue.key + (int)((this.cons[ins.index()] - 1.0D) * 100.0D) / 100.0D);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double bonus(Industry t) {
/* 234 */       return this.bonus[t.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public double consumptionBonus(Industry ins) {
/* 239 */       return 1.0D * (1.0D - UITradeDebug.this.consumptionBonus.getD()) + this.cons[ins.index()] * UITradeDebug.this.consumptionBonus.getD();
/*     */     }
/*     */     
/*     */     void clear() {
/* 243 */       Arrays.fill(this.bonus, 1.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double wPerItemUsed() {
/* 249 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double addedW() {
/* 254 */       return UITradeDebug.this.gametheory.getD();
/*     */     }
/*     */   }
/*     */   
/* 258 */   private final BonusPlayer pbonuses = new BonusPlayer();
/*     */ 
/*     */ 
/*     */   
/* 262 */   private static CharSequence ¤¤work = "Work required/item";
/* 263 */   private static CharSequence ¤¤workT = "Total work required/item";
/*     */   
/*     */   static {
/* 266 */     D.ts(UITradeDebug.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   UITradeDebug() {
/* 275 */     GuiSection info = new GuiSection();
/*     */     
/* 277 */     GSliderInt i = new GSliderInt((INT.INTE)this.toll, 100, false);
/* 278 */     i.hoverInfoSet(Dic.¤¤Toll);
/* 279 */     info.add((RENDEROBJ)i);
/*     */     
/* 281 */     i = new GSliderInt((INT.INTE)this.gametheory, 100, false);
/* 282 */     i.hoverInfoSet("Game theory");
/* 283 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 285 */     i = new GSliderInt((INT.INTE)this.flatTariffSell, 100, false);
/* 286 */     i.hoverInfoSet("sell tariff");
/* 287 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 289 */     i = new GSliderInt((INT.INTE)this.flatTariffBuy, 100, false);
/* 290 */     i.hoverInfoSet("buy tariff");
/* 291 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 293 */     addRelBody(0, DIR.S, (RENDEROBJ)info);
/*     */     
/* 295 */     info = new GuiSection();
/*     */     
/* 297 */     INT.INTE bb = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 301 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 306 */           return 600;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 311 */           return (int)(UITradeDebug.this.pbonuses.bonus[0] * 100.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 316 */           Arrays.fill(UITradeDebug.this.pbonuses.bonus, t / 100.0D);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 321 */     i = new GSliderInt(bb, 100, false);
/* 322 */     i.hoverInfoSet("bonus player");
/* 323 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 325 */     i = new GSliderInt((INT.INTE)this.bonusai, 100, false);
/* 326 */     i.hoverInfoSet("bonus ai");
/* 327 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 329 */     i = new GSliderInt((INT.INTE)this.wPerItemUSed, 100, false);
/* 330 */     i.hoverInfoSet("w per total items used");
/* 331 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 333 */     i = new GSliderInt((INT.INTE)this.consumptionBonus, 100, false);
/* 334 */     i.hoverInfoSet("consumption bonus");
/* 335 */     info.addRightC(48, (RENDEROBJ)i);
/*     */     
/* 337 */     addRelBody(0, DIR.S, (RENDEROBJ)info);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     info = new GuiSection();
/*     */     
/* 344 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("beginning")
/*     */         {
/*     */           protected void clickA() {
/* 347 */             UITradeDebug.this.toll.set(18);
/* 348 */             UITradeDebug.this.gametheory.set(0);
/* 349 */             UITradeDebug.this.flatTariffSell.set(30);
/* 350 */             UITradeDebug.this.flatTariffBuy.set(0);
/* 351 */             UITradeDebug.this.pbonuses.clear();
/* 352 */             UITradeDebug.this.bonusai.set(300);
/* 353 */             UITradeDebug.this.wPerItemUSed.set(10);
/* 354 */             UITradeDebug.this.consumptionBonus.set(0);
/*     */             
/* 356 */             super.clickA();
/*     */           }
/*     */         });
/*     */     
/* 360 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("start")
/*     */         {
/*     */           protected void clickA() {
/* 363 */             UITradeDebug.this.toll.set(100);
/* 364 */             UITradeDebug.this.gametheory.set(20);
/* 365 */             UITradeDebug.this.flatTariffSell.set(20);
/* 366 */             UITradeDebug.this.flatTariffBuy.set(20);
/* 367 */             UITradeDebug.this.pbonuses.clear();
/* 368 */             UITradeDebug.this.bonusai.set(300);
/* 369 */             super.clickA();
/*     */           }
/*     */         });
/*     */     
/* 373 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("relations")
/*     */         {
/*     */           protected void clickA() {
/* 376 */             UITradeDebug.this.toll.set(100);
/* 377 */             UITradeDebug.this.gametheory.set(20);
/* 378 */             UITradeDebug.this.flatTariffSell.set(5);
/* 379 */             UITradeDebug.this.flatTariffBuy.set(5);
/* 380 */             UITradeDebug.this.pbonuses.clear();
/* 381 */             UITradeDebug.this.bonusai.set(300);
/* 382 */             super.clickA();
/*     */           }
/*     */         });
/*     */     
/* 386 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("toll & relations")
/*     */         {
/*     */           protected void clickA() {
/* 389 */             UITradeDebug.this.toll.set(25);
/* 390 */             UITradeDebug.this.gametheory.set(20);
/* 391 */             UITradeDebug.this.flatTariffSell.set(5);
/* 392 */             UITradeDebug.this.flatTariffBuy.set(5);
/* 393 */             UITradeDebug.this.pbonuses.clear();
/* 394 */             UITradeDebug.this.bonusai.set(300);
/* 395 */             super.clickA();
/*     */           }
/*     */         });
/* 398 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("research")
/*     */         {
/*     */           protected void clickA() {
/* 401 */             UITradeDebug.this.toll.set(25);
/* 402 */             UITradeDebug.this.gametheory.set(20);
/* 403 */             UITradeDebug.this.flatTariffSell.set(5);
/* 404 */             UITradeDebug.this.flatTariffBuy.set(5);
/* 405 */             UITradeDebug.this.bonusai.set(100);
/*     */             
/* 407 */             UITradeDebug.this.pbonuses.clear();
/* 408 */             Arrays.fill(UITradeDebug.this.pbonuses.bonus, 0.0D);
/* 409 */             double hi = 0.0D;
/* 410 */             for (Industry ins : (SETT.ROOMS()).industries.all) {
/*     */               
/* 412 */               for (TestRecipe r : UITradeDebug.this.data.get(ins)) {
/* 413 */                 double c = r.amountPerW(UITradeDebug.this.aibonuses) / r.amountPerWTot(UITradeDebug.this.aibonuses);
/* 414 */                 if (c > UITradeDebug.this.pbonuses.bonus[ins.index()])
/* 415 */                   UITradeDebug.this.pbonuses.bonus[ins.index()] = c; 
/* 416 */                 hi = Math.max(c, hi);
/*     */               } 
/*     */             } 
/*     */             
/* 420 */             for (Industry ins : Industry.all()) {
/*     */               
/* 422 */               UITradeDebug.this.pbonuses.bonus[ins.index()] = UITradeDebug.this.pbonuses.bonus[ins.index()] / hi;
/* 423 */               UITradeDebug.this.pbonuses.bonus[ins.index()] = UITradeDebug.this.pbonuses.bonus[ins.index()] * 6.0D;
/* 424 */               UITradeDebug.this.pbonuses.bonus[ins.index()] = UITradeDebug.this.pbonuses.bonus[ins.index()] + 1.0D;
/* 425 */               LOG.ln(String.valueOf(ins.blue) + " " + String.valueOf(ins.blue));
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 430 */             UITradeDebug.this.bonusai.set(300);
/*     */             
/* 432 */             super.clickA();
/*     */           }
/*     */         });
/*     */     
/* 436 */     info.addRightC(0, (RENDEROBJ)new GButt.ButtPanel("consumption")
/*     */         {
/*     */           protected void clickA() {
/* 439 */             UITradeDebug.this.toll.set(18);
/* 440 */             UITradeDebug.this.gametheory.setD(0.05D);
/* 441 */             UITradeDebug.this.flatTariffSell.set(30);
/* 442 */             UITradeDebug.this.flatTariffBuy.set(0);
/* 443 */             UITradeDebug.this.pbonuses.clear();
/* 444 */             UITradeDebug.this.bonusai.set(300);
/* 445 */             UITradeDebug.this.wPerItemUSed.set(10);
/* 446 */             UITradeDebug.this.consumptionBonus.set(100);
/* 447 */             UITradeDebug.this.pbonuses.recount();
/*     */             
/* 449 */             super.clickA();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 454 */     info.add((RENDEROBJ)new GButt.ButtPanel("old system")
/*     */         {
/*     */           protected void clickA() {
/* 457 */             UITradeDebug.this.toll.set(0);
/* 458 */             UITradeDebug.this.gametheory.set(0);
/* 459 */             UITradeDebug.this.flatTariffSell.set(0);
/* 460 */             UITradeDebug.this.flatTariffBuy.set(0);
/* 461 */             UITradeDebug.this.pbonuses.clear();
/* 462 */             UITradeDebug.this.bonusai.set(100);
/* 463 */             super.clickA();
/*     */           }
/* 465 */         }info.body().x1(), info.body().y2());
/*     */     
/* 467 */     addRelBody(0, DIR.S, (RENDEROBJ)info);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 473 */     GTableBuilder bu = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 477 */           return UITradeDebug.this.data.all().size();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 482 */     bu.column(Dic.¤¤Production, 500, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 487 */             return (RENDEROBJ)new HOVERABLE.HoverableAbs(500, 32)
/*     */               {
/*     */                 protected void render(SPRITE_RENDERER ren, float ds, boolean isHovered)
/*     */                 {
/* 491 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/*     */                   
/* 493 */                   int x1 = this.body.x1() + 4;
/*     */                   
/* 495 */                   (UI.FONT()).S.renderCY(ren, x1, this.body.cY(), (CharSequence)Str.TMP.clear().add(1.0D / r.wPerItem, 1));
/* 496 */                   x1 += 32;
/*     */                   
/* 498 */                   r.res.icon().renderCY(ren, x1, this.body.cY());
/* 499 */                   x1 += 32;
/*     */ 
/*     */                   
/* 502 */                   r.ins.blue.icon.renderCY(ren, x1, this.body.cY());
/* 503 */                   COLOR.BLACK.bind();
/* 504 */                   (UI.FONT()).S.renderC(ren, x1 + 8 + 2, this.body.cY() - 8 + 2, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 505 */                   (UI.FONT()).S.renderC(ren, x1 + 8 - 2, this.body.cY() - 8 - 2, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 506 */                   COLOR.unbind();
/* 507 */                   (UI.FONT()).S.renderC(ren, x1 + 8, this.body.cY() - 8, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 508 */                   x1 += 28;
/* 509 */                   (UI.icons()).s.arrow_left.renderCY(ren, x1, this.body.cY());
/* 510 */                   x1 += 24;
/*     */ 
/*     */                   
/* 513 */                   for (int i = 0; i < r.inputs().size(); i++) {
/*     */                     
/* 515 */                     Input ii = (Input)r.inputs().get(i);
/* 516 */                     (UI.FONT()).S.renderCY(ren, x1, this.body.cY(), (CharSequence)Str.TMP.clear().add(ii.amount, 1));
/* 517 */                     x1 += 32;
/* 518 */                     ii.producer.ins.blue.icon.renderCY(ren, x1, this.body.cY());
/* 519 */                     ii.res.icon().renderCY(ren, x1 + 24, this.body.cY() - 8);
/* 520 */                     COLOR.BLACK.bind();
/* 521 */                     (UI.FONT()).S.renderC(ren, x1 + 24 + 2, this.body.cY() - 8 + 2, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 522 */                     (UI.FONT()).S.renderC(ren, x1 + 24 - 2, this.body.cY() - 8 - 2, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 523 */                     COLOR.unbind();
/* 524 */                     (UI.FONT()).S.renderC(ren, x1 + 24, this.body.cY() - 8, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 525 */                     x1 += 48;
/* 526 */                     if (x1 > this.body.x2() - 100) {
/*     */                       break;
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GUI_BOX text) {
/* 536 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 537 */                   GBox b = (GBox)text;
/* 538 */                   b.title((CharSequence)b.text().add(r.ins.blue.info.name).add(':').s().add(r.res.name).s().add((CharSequence)GFORMAT.toNumeral(r.index + 1)));
/*     */                   
/* 540 */                   b.textLL(UITradeDebug.¤¤work);
/* 541 */                   b.tab(6);
/* 542 */                   b.add((SPRITE)GFORMAT.f(b.text(), r.wPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)));
/* 543 */                   b.NL();
/* 544 */                   b.textLL(UITradeDebug.¤¤workT);
/* 545 */                   b.tab(6);
/* 546 */                   b.add((SPRITE)GFORMAT.f(b.text(), r.wTotPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)));
/* 547 */                   b.NL();
/*     */                   
/* 549 */                   hrec(b, 0, r.inputs());
/*     */ 
/*     */                   
/* 552 */                   super.hoverInfoGet(text);
/*     */                 }
/*     */                 
/*     */                 private void hrec(GBox b, int tab, LIST<Input> inputs) {
/* 556 */                   if (inputs.size() == 0) {
/*     */                     return;
/*     */                   }
/* 559 */                   for (int i = 0; i < inputs.size(); i++) {
/* 560 */                     b.tab(tab);
/* 561 */                     Input ii = (Input)inputs.get(i);
/* 562 */                     b.add((SPRITE)GFORMAT.f(b.text(), ii.amount, 2));
/* 563 */                     b.add((SPRITE)ii.res.icon());
/* 564 */                     b.add(ii.producer.ins.blue.icon.medium);
/* 565 */                     b.space();
/* 566 */                     b.NL();
/* 567 */                     hrec(b, tab + 1, ii.producer.inputs());
/* 568 */                     b.NL(8);
/*     */                   } 
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */     
/* 575 */     int colW = 100;
/*     */     
/* 577 */     bu.column("A", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 582 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 586 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 587 */                   if (r.inputs().size() == 0) {
/*     */                     return;
/*     */                   }
/*     */                   
/* 591 */                   GFORMAT.iIncr(text, UITradeDebug.null.access$0(UITradeDebug.null.this).A(r));
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 597 */                   b.text("Produce all inputs and sell them");
/* 598 */                   b.NL();
/* 599 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 600 */                   if (r.inputs().size() == 0) {
/*     */                     return;
/*     */                   }
/* 603 */                   double tot = 0.0D;
/* 604 */                   for (Input i : r.inputs()) {
/* 605 */                     tot += i.amount;
/*     */                   }
/*     */                   
/* 608 */                   int sold = 0;
/*     */                   
/* 610 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverLegend(b);
/*     */                   
/* 612 */                   for (Input i : r.inputs()) {
/* 613 */                     double am = i.amount / tot * i.producer.wTotPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses);
/* 614 */                     (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverSale(b, i.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, am, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffSell.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/*     */                     
/* 616 */                     int s = (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.sellPrice(i.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, am, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffSell.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/* 617 */                     sold += s;
/* 618 */                     b.NL();
/*     */                   } 
/*     */                   
/* 621 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverSum(b, sold);
/*     */                 }
/* 624 */               }).r(DIR.NE);
/*     */           }
/* 626 */         }DIR.NE);
/*     */     
/* 628 */     bu.column("B", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 632 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 636 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 637 */                   GFORMAT.iIncr(text, UITradeDebug.null.access$0(UITradeDebug.null.this).B(r));
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 643 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/*     */                   
/* 645 */                   double d = r.amountPerWTot((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses);
/* 646 */                   d = (d - r.amountPerW((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)) / 2.0D;
/*     */                   
/* 648 */                   for (Input i : r.inputs()) {
/* 649 */                     double a = i.producer.amountPerWTot((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses) / i.amount;
/* 650 */                     b.add((SPRITE)GFORMAT.f(b.text(), -a, 2));
/* 651 */                     b.tab(2);
/* 652 */                     b.add((SPRITE)i.res.icon());
/* 653 */                     b.NL();
/*     */                   } 
/*     */ 
/*     */ 
/*     */                   
/* 658 */                   b.add((SPRITE)r.res.icon());
/* 659 */                   b.add((SPRITE)GFORMAT.f(b.text(), r.amountPerWTot((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)));
/* 660 */                   b.NL();
/*     */                   
/* 662 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverLegend(b);
/* 663 */                   double am = r.amountPerWTot((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses);
/* 664 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverSale(b, r.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, am, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffSell.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/*     */                 }
/* 668 */               }).r(DIR.NE);
/*     */           }
/* 670 */         }DIR.NE);
/*     */     
/* 672 */     bu.column("C", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 676 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 680 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/*     */                   
/* 682 */                   if (r.inputs().size() == 0)
/*     */                     return; 
/* 684 */                   GFORMAT.iIncr(text, UITradeDebug.null.access$0(UITradeDebug.null.this).C(r));
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 692 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 693 */                   if (r.inputs().size() == 0)
/*     */                     return; 
/* 695 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverLegend(b);
/* 696 */                   double am = (UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses.bonus(r.ins) / r.wPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses);
/* 697 */                   int in = (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.sellPrice(r.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, r.amountPerW((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses), (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffSell.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/* 698 */                   int out = 0;
/* 699 */                   for (Input i : r.inputs()) {
/* 700 */                     double a = i.amount * (UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses.bonus(r.ins) / (UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses.consumptionBonus(r.ins);
/* 701 */                     (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverPuchase(b, i.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, a, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffBuy.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/* 702 */                     out += (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.buyPrice(i.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, a, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffBuy.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/*     */                   } 
/*     */                   
/* 705 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverSale(b, r.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, am, (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffSell.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/* 706 */                   (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.hoverSum(b, in - out);
/*     */                 }
/* 710 */               }).r(DIR.NE);
/*     */           }
/* 712 */         }DIR.NE);
/*     */     
/* 714 */     bu.column("buy", 100, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 718 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 722 */                   TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 723 */                   double p = (UITradeDebug.null.access$0(UITradeDebug.null.this)).trade.buyPrice(r.res, (UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses, r.amountPerW((UITradeDebug.null.access$0(UITradeDebug.null.this)).aibonuses), (UITradeDebug.null.access$0(UITradeDebug.null.this)).flatTariffBuy.getD(), (UITradeDebug.null.access$0(UITradeDebug.null.this)).toll.getD());
/*     */                   
/* 725 */                   GFORMAT.iIncr(text, -((long)p));
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {}
/* 735 */               }).r(DIR.NE);
/*     */           }
/* 737 */         }DIR.NE);
/*     */     
/* 739 */     addRelBody(8, DIR.S, (RENDEROBJ)bu.create(10, true));
/*     */   }
/*     */ 
/*     */   
/*     */   public int A(TestRecipe r) {
/* 744 */     if (r.inputs().size() == 0) {
/* 745 */       return 0;
/*     */     }
/* 747 */     double tot = 0.0D;
/* 748 */     for (Input i : r.inputs()) {
/* 749 */       tot += i.amount;
/*     */     }
/*     */     
/* 752 */     int sold = 0;
/* 753 */     for (Input i : r.inputs()) {
/* 754 */       double am = i.amount / tot * i.producer.wTotPerItem(this.pbonuses);
/* 755 */       sold += this.trade.sellPrice(i.res, this.aibonuses, am, this.flatTariffSell.getD(), this.toll.getD());
/*     */     } 
/* 757 */     return sold;
/*     */   }
/*     */   
/*     */   public int B(TestRecipe r) {
/* 761 */     double tot = r.amountPerWTot(this.pbonuses);
/* 762 */     return this.trade.sellPrice(r.res, this.aibonuses, tot, this.flatTariffSell.getD(), this.toll.getD());
/*     */   }
/*     */ 
/*     */   
/*     */   public int C(TestRecipe r) {
/* 767 */     if (r.inputs().size() == 0) {
/* 768 */       return 0;
/*     */     }
/* 770 */     int in = this.trade.sellPrice(r.res, this.aibonuses, r.amountPerW(this.pbonuses), this.flatTariffSell.getD(), this.toll.getD());
/*     */     
/* 772 */     int out = 0;
/* 773 */     for (Input i : r.inputs()) {
/* 774 */       out += this.trade.buyPrice(i.res, this.aibonuses, i.amount * this.pbonuses.bonus(r.ins) / this.pbonuses.consumptionBonus(r.ins), this.flatTariffBuy.getD(), this.toll.getD());
/*     */     }
/*     */     
/* 777 */     return in - out;
/*     */   }
/*     */   
/*     */   TestRecipe get(GETTER<Integer> ier) {
/* 781 */     return (TestRecipe)this.data.all().get(((Integer)ier.get()).intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\UITradeDebug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
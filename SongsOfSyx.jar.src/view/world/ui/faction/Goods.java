/*     */ package view.world.ui.faction;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.npc.stockpile.NPCRes;
/*     */ import game.faction.npc.stockpile.NPCStockpileDebugUI;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.race.RACES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.Icons;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.recipe.Recipe;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.region.RD;
/*     */ 
/*     */ final class Goods extends GuiSection {
/*  50 */   private static CharSequence ¤¤rate = "Production Rate";
/*  51 */   private static CharSequence ¤¤rateD = "This faction produces resources, same as you, at a specific rate based on its own technological progress, species composition and geography. The rate determines their internal stock, and their ability to trade the corresponding good. High production rate means low buy prices for other factions, while a low rate means higher buy prices. For any goods, the whole chain of production is taken into account in the final rate.";
/*  52 */   private static CharSequence ¤¤rateBase = "Base Rate";
/*  53 */   private static CharSequence ¤¤rateCurrent = "Immediate Rate";
/*  54 */   private static CharSequence ¤¤rateChain = "Production Chain Rate";
/*  55 */   private static CharSequence ¤¤Industry = "Industry";
/*  56 */   private static CharSequence ¤¤Consumption = "Production/day";
/*     */ 
/*     */ 
/*     */   
/*  60 */   private static CharSequence ¤¤priceD = "The price of a good is determined by the production rate, supply/demand, the faction's wealth, as well as species specific preference.";
/*  61 */   private static CharSequence ¤¤priceSell = "The base buy price is proportional to the amount of the resource a faction has stored, and the money it has available.";
/*  62 */   private static CharSequence ¤¤priceBuy = "The base sell price is proportional to the amount of the resource a faction has stored, and the money it has available. If a faction has scant use for a resource, the buy price will be significantly lower than the sell price.";
/*  63 */   private static CharSequence ¤¤penaltyD1 = "Toll is the distance to this faction. This penalty can be decreased by building roads in your kingdom.";
/*  64 */   private static CharSequence ¤¤penaltyD2 = "The tariff penalty is based on the faction's opinion of you. Increase their opinion for better prices.";
/*  65 */   private static CharSequence ¤¤traded = "Traded";
/*  66 */   private static CharSequence ¤¤tradedT = "Traded (total)";
/*  67 */   private static CharSequence ¤¤tradedP = "Traded (player)";
/*  68 */   private static CharSequence ¤¤tradedD = "How much a faction has traded with you and other factions. Supply and demand of a goods creates price fluctuations. The traded amount is consumed by the faction slowly, breaking down advanced goods into its components, or producing new ones in a similar fashion. Factions can also trade any excess or deficit to other factions.";
/*     */   
/*  70 */   private static CharSequence ¤¤amountD = "The size of a faction, and its production rate, and competence determines how much goods in produces and maintains. This in turn indicates its trade potential. Bigger stores means bigger trade volumes before the price crashes.";
/*  71 */   private static CharSequence ¤¤amountTarget = "Target Amount";
/*     */   
/*  73 */   private static CharSequence ¤¤Demand = "Demand";
/*  74 */   private static CharSequence ¤¤Supply = "Supply";
/*  75 */   private static CharSequence ¤¤amountTraded = "Traded Amount";
/*  76 */   private static CharSequence ¤¤amountCurrent = "Current Amount";
/*  77 */   private static CharSequence ¤¤creditScore = "Riches";
/*     */   
/*  79 */   private static CharSequence ¤¤TollTile = "Toll/Distance"; final GETTER<FactionNPC> f;
/*     */   
/*     */   static {
/*  82 */     D.ts(Goods.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  87 */   private ArrayList<TRADABLE> ress = new ArrayList(TR.ALL().size());
/*  88 */   private final StringInputSprite filter = (new StringInputSprite(12, (UI.FONT()).M)).placeHolder(Dic.¤¤Search);
/*     */   
/*     */   Goods(final GETTER<FactionNPC> f, int height) {
/*  91 */     this.f = f;
/*     */     
/*  93 */     final GChart chart = new GChart();
/*  94 */     chart.body().setDim(450.0D, 64.0D);
/*     */ 
/*     */     
/*  97 */     GuiSection s = new GuiSection();
/*     */     
/*  99 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 103 */           GFORMAT.f(text, TradeManager.toll((FactionNPC)f.get()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 108 */           b.title(Dic.¤¤Toll);
/* 109 */           b.text(Dic.¤¤TollD);
/* 110 */           b.sep();
/*     */           
/* 112 */           b.textLL(Dic.¤¤Distance);
/* 113 */           b.tab(6);
/* 114 */           b.add((SPRITE)GFORMAT.i(b.text(), RD.DIST().distance((Faction)f.get())));
/* 115 */           b.NL();
/*     */           
/* 117 */           b.textLL(Goods.¤¤TollTile);
/* 118 */           b.tab(6);
/* 119 */           b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.tollPerTile));
/* 120 */           b.NL();
/*     */           
/* 122 */           (RD.DIST()).bProximityToll.hoverDetailed((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */           
/* 124 */           b.sep();
/* 125 */           b.textLL(Dic.¤¤Total);
/* 126 */           b.tab(6);
/* 127 */           b.add((SPRITE)GFORMAT.f(b.text(), TradeManager.toll((FactionNPC)f.get())));
/* 128 */           b.NL();
/*     */         }
/* 131 */       }).hh((SPRITE)(UI.icons()).s.wheel);
/* 132 */     s.addRightC(84, (RENDEROBJ)hOVERABLE);
/*     */     
/* 134 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 138 */           GFORMAT.percInc(text, ((FactionNPC)f.get()).stockpile.creditScore() - 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 143 */           b.title(Dic.¤¤CreditScore);
/* 144 */           b.text(Dic.¤¤CreditScoreD);
/* 145 */           b.sep();
/* 146 */           b.textLL(Dic.¤¤Current);
/* 147 */           b.tab(6);
/* 148 */           b.add((SPRITE)GFORMAT.percInc(b.text(), ((FactionNPC)f.get()).stockpile.creditScore() - 1.0D));
/*     */         }
/* 151 */       }).hh((SPRITE)(UI.icons()).s.money);
/* 152 */     s.addRightC(84, (RENDEROBJ)hOVERABLE);
/*     */     
/* 154 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 158 */           GFORMAT.percInv(text, ROPINION.tradeCost((FactionNPC)f.get()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 163 */           b.title(Dic.¤¤Tariff);
/* 164 */           b.text(Dic.¤¤TariffD);
/*     */         }
/* 167 */       }).hh((SPRITE)(UI.icons()).s.angry);
/* 168 */     s.addRightC(84, (RENDEROBJ)hOVERABLE);
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     s.addRightC(64, (RENDEROBJ)new GInput(this.filter));
/*     */     
/* 216 */     if ((S.get()).developer) {
/* 217 */       s.addRightC(64, (RENDEROBJ)new GButt.ButtPanel("debug")
/*     */           {
/*     */             protected void clickA() {
/* 220 */               (VIEW.inters()).popup.show((RENDEROBJ)new NPCStockpileDebugUI((FactionNPC)f.get()), (CLICKABLE)this, true);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 227 */     s.addRightC(64, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 231 */             GFORMAT.i(text, RD.DIST().tradePartners((Faction)f.get()).size());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 236 */             b.title(Dic.¤¤Neighbours);
/* 237 */             b.textL(Dic.¤¤Faction);
/* 238 */             b.tab(6);
/* 239 */             b.textL(Dic.¤¤Distance);
/* 240 */             b.tab(9);
/* 241 */             b.textL(Dic.¤¤Toll);
/* 242 */             b.NL(2);
/* 243 */             for (WRegFinder.RegDist d : RD.DIST().tradePartners((Faction)f.get())) {
/* 244 */               b.textLL((CharSequence)(d.reg.faction()).name);
/* 245 */               b.tab(6);
/* 246 */               b.add((SPRITE)GFORMAT.i(b.text(), d.distance));
/* 247 */               if ((S.get()).developer) {
/* 248 */                 b.tab(9);
/* 249 */                 b.add((SPRITE)GFORMAT.iIncr(b.text(), (long)TradeManager.toll((Faction)f.get(), d.reg.faction(), d.distance)));
/*     */               } 
/* 251 */               b.NL();
/*     */             }
/*     */           
/*     */           }
/* 255 */         }).hh((SPRITE)(UI.icons()).s.wheel));
/*     */     
/* 257 */     addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         
/*     */         public int nrOFEntries()
/*     */         {
/* 269 */           return Goods.this.ress.size();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 274 */     builder.column(48, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 279 */             return (RENDEROBJ)new HOVERABLE.Sprite(24)
/*     */               {
/*     */                 protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */                 {
/* 283 */                   Goods.null.access$0(Goods.null.this).g(ier).icon().render(r, (RECTANGLE)body());
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GUI_BOX text) {
/* 288 */                   text.title((Goods.null.access$0(Goods.null.this).g(ier)).names);
/*     */                 }
/*     */               };
/*     */           }
/* 293 */         }DIR.C);
/*     */     
/* 295 */     final int W = 132;
/*     */     
/* 297 */     builder.column(Dic.¤¤Rate, W / 2, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 302 */             GStat s = new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 305 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 306 */                   GFORMAT.f0(text, res.rateTot());
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 312 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/*     */                   
/* 314 */                   b.title(Goods.¤¤rate);
/* 315 */                   b.text(Goods.¤¤rateD);
/*     */                   
/* 317 */                   b.sep();
/*     */                   
/* 319 */                   b.textLL(Goods.¤¤rateBase);
/* 320 */                   b.tab(6);
/* 321 */                   b.add((SPRITE)GFORMAT.f(b.text(), 1.0D / (SETT.RECIPES()).ratesV.vanillaRate(res.res)));
/* 322 */                   b.NL();
/*     */                   
/* 324 */                   b.textLL(Goods.¤¤rateCurrent);
/* 325 */                   b.tab(6);
/* 326 */                   b.add((SPRITE)GFORMAT.f(b.text(), res.rate()));
/* 327 */                   b.NL();
/*     */                   
/* 329 */                   b.textLL(Goods.¤¤rateChain);
/* 330 */                   b.tab(6);
/* 331 */                   b.add((SPRITE)GFORMAT.f(b.text(), res.rateTot()));
/* 332 */                   b.NL();
/*     */ 
/*     */ 
/*     */                   
/* 336 */                   Recipe rec = res.recipe();
/*     */                   
/* 338 */                   if (rec != null) {
/*     */                     
/* 340 */                     b.textLL(Goods.¤¤Industry);
/* 341 */                     b.tab(6);
/* 342 */                     b.add(rec.icon);
/* 343 */                     b.text(rec.name);
/* 344 */                     b.NL();
/*     */                     
/* 346 */                     b.sep();
/*     */                     
/* 348 */                     (res.recipe()).bo.hover((GUI_BOX)b, (BOOSTABLE_O)f.get(), true);
/*     */                   } 
/*     */                 }
/*     */               };
/*     */ 
/*     */ 
/*     */             
/* 355 */             return (RENDEROBJ)new Goods.Cell(W / 2, s, DIR.E);
/*     */           }
/* 358 */         }DIR.E);
/*     */     
/* 360 */     builder.column(Dic.¤¤Stored, W, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 365 */             GStat s = new GStat()
/*     */               {
/*     */                 
/*     */                 public void update(GText text)
/*     */                 {
/* 370 */                   TRADABLE res = (TRADABLE)(Goods.null.access$0(Goods.null.this)).ress.get(((Integer)ier.get()).intValue());
/* 371 */                   GFORMAT.i(text, Math.round(((FactionNPC)f.get()).res(res).amount()));
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 378 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/*     */ 
/*     */ 
/*     */                   
/* 382 */                   b.title(Dic.¤¤Stored);
/* 383 */                   b.text(Goods.¤¤amountD);
/* 384 */                   b.sep();
/*     */                   
/* 386 */                   b.add((SPRITE)(UI.icons()).s.storage);
/* 387 */                   b.textL(Goods.¤¤amountTarget);
/* 388 */                   b.tab(6);
/* 389 */                   b.add((SPRITE)GFORMAT.i(b.text(), (int)Math.round(res.amountTarget())));
/* 390 */                   b.NL();
/*     */                   
/* 392 */                   b.add((SPRITE)(UI.icons()).s.wheel);
/* 393 */                   b.textL(Goods.¤¤amountTraded);
/* 394 */                   b.tab(6);
/* 395 */                   b.add((SPRITE)GFORMAT.i(b.text(), (int)Math.round(res.offset())));
/* 396 */                   b.NL();
/*     */                   
/* 398 */                   b.add((SPRITE)(UI.icons()).s.storage);
/* 399 */                   b.textL(Goods.¤¤amountCurrent);
/* 400 */                   b.tab(6);
/* 401 */                   b.add((SPRITE)GFORMAT.i(b.text(), (int)Math.round(res.amount())));
/* 402 */                   b.NL();
/*     */                 }
/*     */               };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 410 */             return (RENDEROBJ)new Goods.Cell(W, s, DIR.E);
/*     */           }
/* 413 */         }DIR.E);
/*     */     
/* 415 */     builder.column(¤¤traded, W, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */ 
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 421 */             final GStat s = new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 425 */                   GFORMAT.i(text, (int)(((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amount() - ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amountTarget()));
/*     */                 }
/*     */               };
/*     */             
/* 429 */             s.bg();
/*     */             
/* 431 */             SPRITE.Imp imp = new SPRITE.Imp(W, s.height())
/*     */               {
/*     */                 
/*     */                 public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */                 {
/* 436 */                   double n1 = ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).offset();
/* 437 */                   double max = ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amountTarget();
/* 438 */                   double p1 = 1.0D - Math.abs(((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).playerTraded() / ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).offset());
/* 439 */                   GMeter.GMeterCol cc = GMeter.C_GRAY;
/* 440 */                   if (n1 > 0.0D) {
/* 441 */                     cc = GMeter.C_GREEN;
/* 442 */                     n1 /= 2.0D;
/* 443 */                   } else if (n1 < 0.0D) {
/* 444 */                     n1 = -n1;
/* 445 */                     cc = GMeter.C_RED;
/*     */                   } 
/*     */                   
/* 448 */                   n1 = Math.abs(n1);
/* 449 */                   n1 /= max;
/* 450 */                   GMeter.render(r, cc, p1 * n1, n1, X1 + 4, X2 - 4, Y1, Y2);
/* 451 */                   s.adjust();
/* 452 */                   s.render(r, X2 - s.width(), Y1);
/*     */                 }
/*     */               };
/*     */             
/* 456 */             return (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)imp)
/*     */               {
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GUI_BOX text)
/*     */                 {
/* 463 */                   GBox b = (GBox)text;
/* 464 */                   TRADABLE res = Goods.null.access$0(Goods.null.this).g(ier);
/*     */                   
/* 466 */                   b.title(Goods.¤¤traded);
/* 467 */                   b.text(Goods.¤¤tradedD);
/* 468 */                   b.sep();
/*     */                   
/* 470 */                   b.textLL(Goods.¤¤tradedT);
/* 471 */                   b.tab(6);
/* 472 */                   b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)((FactionNPC)f.get()).res(res).offset()));
/* 473 */                   b.NL();
/*     */                   
/* 475 */                   b.textLL(Goods.¤¤tradedP);
/* 476 */                   b.tab(6);
/* 477 */                   b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)((FactionNPC)f.get()).res(res).playerTraded()));
/* 478 */                   b.NL();
/*     */ 
/*     */                   
/* 481 */                   b.textLL(Goods.¤¤Consumption);
/* 482 */                   b.tab(6);
/* 483 */                   b.add((SPRITE)GFORMAT.f0(b.text(), -((FactionNPC)f.get()).res(res).dailyConsumption()));
/* 484 */                   b.NL();
/*     */                   
/* 486 */                   b.add((SPRITE)(UI.icons()).s.law);
/* 487 */                   b.textL(Goods.¤¤Supply);
/* 488 */                   b.tab(6);
/* 489 */                   b.add((SPRITE)GFORMAT.perc(b.text(), ((FactionNPC)f.get()).res(res).amMulAt(-1)));
/* 490 */                   b.NL();
/*     */                   
/* 492 */                   b.add((SPRITE)(UI.icons()).s.law);
/* 493 */                   b.textL(Goods.¤¤Demand);
/* 494 */                   b.tab(6);
/* 495 */                   b.add((SPRITE)GFORMAT.perc(b.text(), ((FactionNPC)f.get()).res(res).amMulAt(1)));
/* 496 */                   b.NL();
/*     */                   
/* 498 */                   super.hoverInfoGet(text);
/*     */                 }
/*     */               };
/*     */           }
/* 505 */         }DIR.E);
/*     */     
/* 507 */     builder.column(Dic.¤¤Price, W + W / 2, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 512 */             GStat s = new GStat()
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */                 {
/* 516 */                   TRADABLE res = (TRADABLE)(Goods.null.access$0(Goods.null.this)).ress.get(((Integer)ier.get()).intValue());
/*     */                   
/* 518 */                   super.render(r, X1 - 80, X2 - 80, Y1, Y2);
/* 519 */                   this.statText.clear();
/* 520 */                   int p = ((FactionNPC)f.get()).res(res).priceAt(0);
/* 521 */                   int i = p - FACTIONS.PRICE().get(res);
/* 522 */                   GFORMAT.iIncrI(this.statText, i);
/* 523 */                   this.statText.adjustWidth();
/* 524 */                   this.statText.render(r, X2 - this.statText.width(), Y1);
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void update(GText text) {
/* 530 */                   TRADABLE res = (TRADABLE)(Goods.null.access$0(Goods.null.this)).ress.get(((Integer)ier.get()).intValue());
/* 531 */                   GFORMAT.i(text, Math.round(((FactionNPC)f.get()).res(res).priceAt(0)));
/*     */                 }
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 538 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/*     */ 
/*     */ 
/*     */                   
/* 542 */                   b.title(Dic.¤¤Price);
/* 543 */                   b.text(Goods.¤¤priceD);
/* 544 */                   b.sep();
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
/* 558 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 559 */                   b.textL(Dic.¤¤basePrice);
/* 560 */                   b.tab(6);
/* 561 */                   b.add((SPRITE)GFORMAT.f(b.text(), res.priceBase()));
/* 562 */                   b.NL();
/*     */ 
/*     */ 
/*     */                   
/* 566 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 567 */                   b.textL(Goods.¤¤creditScore);
/* 568 */                   b.tab(6);
/* 569 */                   b.add((SPRITE)GFORMAT.f1(b.text(), ((FactionNPC)f.get()).stockpile.creditScore()));
/* 570 */                   b.NL();
/*     */                   
/* 572 */                   b.add((SPRITE)(UI.icons()).s.human);
/* 573 */                   b.textL(RACES.name());
/* 574 */                   b.tab(6);
/* 575 */                   b.add((SPRITE)GFORMAT.f1(b.text(), ((FactionNPC)f.get()).race().pref().priceMul(res.res)));
/* 576 */                   b.NL();
/*     */                   
/* 578 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 579 */                   b.textL(Dic.¤¤Price);
/* 580 */                   b.tab(6);
/* 581 */                   b.add((SPRITE)GFORMAT.f(b.text(), res.priceAt(0)));
/* 582 */                   b.NL(4);
/*     */ 
/*     */                   
/* 585 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 586 */                   b.textL(Dic.¤¤avePrice);
/* 587 */                   b.tab(6);
/* 588 */                   b.add((SPRITE)GFORMAT.i(b.text(), FACTIONS.PRICE().get(Goods.null.access$0(Goods.null.this).g(ier))));
/* 589 */                   b.NL();
/*     */ 
/*     */ 
/*     */                   
/* 593 */                   chart.clear();
/* 594 */                   chart.add((HISTORY)((FactionNPC)f.get()).stockpile.price.history((MAPPED)Goods.null.access$0(Goods.null.this).g(ier)));
/* 595 */                   b.add(chart.sprite);
/*     */                 }
/*     */               };
/*     */ 
/*     */             
/* 600 */             return (RENDEROBJ)new Goods.Cell(W + W / 2, s, DIR.E);
/*     */           }
/* 603 */         }DIR.E);
/*     */     
/* 605 */     builder.column(Dic.¤¤Sell, W, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 609 */             GStat s = new GStat()
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */                 {
/* 613 */                   super.render(r, X1, X2, Y1, Y2);
/* 614 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 615 */                   X1 = X2 - W;
/* 616 */                   COLOR c = (GCOLOR.UI()).BAD.hovered;
/* 617 */                   Icons.S.IconS iconS = (UI.icons()).s.chevron(DIR.W);
/*     */                   
/* 619 */                   double d = SETT.TRADE().buyer(res.res).tradeValue(res.priceSellP());
/*     */                   
/* 621 */                   int am = (int)Math.round(d * 5.0D);
/* 622 */                   if (am > 8)
/* 623 */                     am = 8; 
/* 624 */                   int x1 = X1 + 4;
/* 625 */                   int cy = Y1 + (Y2 - Y1) / 2;
/* 626 */                   if (am > 0) {
/*     */                     
/* 628 */                     c.bind();
/* 629 */                     for (int i = 0; i < am; i++) {
/*     */                       
/* 631 */                       iconS.renderCY(r, x1, cy);
/* 632 */                       x1 += 8;
/*     */                     } 
/* 634 */                     COLOR.unbind();
/*     */                   } 
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void update(GText text) {
/* 641 */                   GFORMAT.i(text, ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).priceSellP());
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 647 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/*     */ 
/*     */                   
/* 650 */                   b.title(Dic.¤¤sellPrice);
/* 651 */                   b.NL();
/* 652 */                   b.text(Goods.¤¤priceSell);
/* 653 */                   b.NL(8);
/*     */ 
/*     */                   
/* 656 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 657 */                   b.textL(Dic.¤¤Price);
/* 658 */                   b.tab(6);
/* 659 */                   b.add((SPRITE)GFORMAT.i(b.text(), (long)(res.seller.removePrice(1) / res.amMulAt(-1))));
/* 660 */                   b.NL();
/*     */                   
/* 662 */                   b.add((SPRITE)(UI.icons()).s.law);
/* 663 */                   b.textL(Goods.¤¤Supply);
/* 664 */                   b.tab(6);
/* 665 */                   GText tt = b.text();
/* 666 */                   tt.add('*').s();
/* 667 */                   b.add((SPRITE)GFORMAT.f1(tt, res.amMulAt(-1)));
/* 668 */                   b.NL();
/*     */                   
/* 670 */                   double t = TradeManager.toll((FactionNPC)f.get());
/* 671 */                   double o = TradeManager.tarif((Faction)f.get(), (Faction)FACTIONS.player(), Goods.null.access$0(Goods.null.this).g(ier), 1);
/* 672 */                   b.add((SPRITE)(UI.icons()).s.wheel);
/* 673 */                   b.textL(Dic.¤¤Toll);
/* 674 */                   b.tab(6);
/* 675 */                   b.add((SPRITE)GFORMAT.f0(b.text(), t));
/* 676 */                   b.NL();
/*     */                   
/* 678 */                   b.add((SPRITE)(UI.icons()).s.angry);
/* 679 */                   b.textL(Dic.¤¤Tariff);
/* 680 */                   b.tab(6);
/* 681 */                   b.add((SPRITE)GFORMAT.f0(b.text(), o));
/* 682 */                   b.NL();
/*     */                   
/* 684 */                   b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 685 */                   b.textLL(Dic.¤¤Total);
/* 686 */                   b.tab(6);
/* 687 */                   b.add((SPRITE)GFORMAT.i(b.text(), res.priceSellP()));
/*     */                   
/* 689 */                   b.NL(8);
/*     */                   
/* 691 */                   b.text(Goods.¤¤penaltyD1);
/* 692 */                   b.NL(4);
/* 693 */                   b.text(Goods.¤¤penaltyD2);
/* 694 */                   b.NL();
/* 695 */                   SETT.TRADE().buyer(res.res).hoverTradeValue(res.priceSellP(), (GUI_BOX)b);
/*     */                 }
/*     */               };
/*     */             
/* 699 */             return (RENDEROBJ)new Goods.Cell(W, s, DIR.E);
/*     */           }
/* 704 */         }DIR.E);
/*     */     
/* 706 */     builder.column(Dic.¤¤Buy, W, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 710 */             GStat s = new GStat()
/*     */               {
/*     */                 public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */                 {
/* 714 */                   super.render(r, X1, X2, Y1, Y2);
/* 715 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/* 716 */                   X1 = X2 - W;
/* 717 */                   COLOR c = (GCOLOR.UI()).GOOD.hovered;
/* 718 */                   Icons.S.IconS iconS = (UI.icons()).s.chevron(DIR.E);
/*     */                   
/* 720 */                   double d = SETT.TRADE().seller(res.res).tradeValue(res.priceBuyP());
/*     */                   
/* 722 */                   int am = (int)Math.round(d * 5.0D);
/* 723 */                   if (am > 8)
/* 724 */                     am = 8; 
/* 725 */                   int x1 = X1 + 4;
/* 726 */                   int cy = Y1 + (Y2 - Y1) / 2;
/* 727 */                   if (am > 0) {
/*     */                     
/* 729 */                     c.bind();
/* 730 */                     for (int i = 0; i < am; i++) {
/*     */                       
/* 732 */                       iconS.renderCY(r, x1, cy);
/* 733 */                       x1 += 8;
/*     */                     } 
/* 735 */                     COLOR.unbind();
/*     */                   } 
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void update(GText text) {
/* 742 */                   GFORMAT.i(text, ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).priceBuyP());
/*     */                 }
/*     */ 
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GBox b) {
/* 748 */                   NPCRes res = ((FactionNPC)f.get()).res((TRADABLE)TR.ALL().get(((Integer)ier.get()).intValue()));
/*     */                   
/* 750 */                   b.title(Dic.¤¤buyPrice);
/* 751 */                   b.NL();
/* 752 */                   b.text(Goods.¤¤priceBuy);
/* 753 */                   b.NL(8);
/*     */                   
/* 755 */                   b.add((SPRITE)(UI.icons()).s.money);
/* 756 */                   b.textL(Dic.¤¤Price);
/* 757 */                   b.tab(6);
/* 758 */                   b.add((SPRITE)GFORMAT.i(b.text(), (long)(res.buyer.addPrice(1) / res.amMulAt(1))));
/* 759 */                   b.NL();
/*     */                   
/* 761 */                   b.add((SPRITE)(UI.icons()).s.law);
/* 762 */                   b.textL(Goods.¤¤Demand);
/* 763 */                   b.tab(6);
/* 764 */                   GText te = b.text();
/* 765 */                   te.add('*').s();
/* 766 */                   b.add((SPRITE)GFORMAT.f1(te, res.amMulAt(1)));
/* 767 */                   b.NL();
/*     */                   
/* 769 */                   b.add((SPRITE)(UI.icons()).s.human);
/* 770 */                   b.textL(RACES.name());
/* 771 */                   b.tab(6);
/* 772 */                   te = b.text();
/* 773 */                   te.add('*').s();
/* 774 */                   b.add((SPRITE)GFORMAT.f1(te, ((FactionNPC)f.get()).race().pref().priceCap(res.res)));
/* 775 */                   b.NL();
/*     */                   
/* 777 */                   double t = TradeManager.toll((FactionNPC)f.get());
/* 778 */                   double o = TradeManager.tarif((Faction)FACTIONS.player(), (Faction)f.get(), Goods.null.access$0(Goods.null.this).g(ier), 1);
/*     */                   
/* 780 */                   b.add((SPRITE)(UI.icons()).s.wheel);
/* 781 */                   b.textL(Dic.¤¤Toll);
/* 782 */                   b.tab(6);
/* 783 */                   b.add((SPRITE)GFORMAT.f0(b.text(), -t));
/* 784 */                   b.NL();
/*     */                   
/* 786 */                   b.add((SPRITE)(UI.icons()).s.angry);
/* 787 */                   b.textL(Dic.¤¤Tariff);
/* 788 */                   b.tab(6);
/* 789 */                   b.add((SPRITE)GFORMAT.f0(b.text(), -o));
/* 790 */                   b.NL();
/*     */ 
/*     */                   
/* 793 */                   b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 794 */                   b.textLL(Dic.¤¤Total);
/* 795 */                   b.tab(6);
/* 796 */                   b.add((SPRITE)GFORMAT.i(b.text(), res.priceBuyP()));
/*     */                   
/* 798 */                   b.NL(8);
/*     */                   
/* 800 */                   b.text(Goods.¤¤penaltyD1);
/* 801 */                   b.NL(4);
/* 802 */                   b.text(Goods.¤¤penaltyD2);
/*     */                   
/* 804 */                   b.NL();
/* 805 */                   SETT.TRADE().seller(res.res).hoverTradeValue(res.priceBuyP(), (GUI_BOX)b);
/*     */                 }
/*     */               };
/* 808 */             return (RENDEROBJ)new Goods.Cell(W, s, DIR.E);
/*     */           }
/* 810 */         }DIR.E);
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
/* 946 */     addRelBody(8, DIR.S, (RENDEROBJ)builder.createHeight(height - 16 - body().height(), true));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private TRADABLE g(GETTER<Integer> ier) {
/* 952 */     return (TRADABLE)this.ress.get(((Integer)ier.get()).intValue());
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 957 */     this.ress.clearSloppy();
/* 958 */     if (this.filter.text().length() == 0) {
/* 959 */       this.ress.add((Iterable)TR.ALL());
/*     */     } else {
/* 961 */       for (TRADABLE res : TR.ALL()) {
/* 962 */         if (Str.containsText(res.name, (CharSequence)this.filter.text()) || Str.containsText(res.names, (CharSequence)this.filter.text())) {
/* 963 */           this.ress.add(res);
/*     */         }
/*     */       } 
/*     */     } 
/* 967 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class Cell extends HOVERABLE.HoverableAbs {
/*     */     private final GStat st;
/*     */     private final DIR d;
/*     */     
/*     */     Cell(int width, GStat st, DIR d) {
/* 975 */       this.st = st;
/* 976 */       this.d = d;
/* 977 */       this.body.setDim(width, 24.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 982 */       if (hoveredIs())
/* 983 */         COLOR.WHITE50.render(r, (RECTANGLE)this.body); 
/* 984 */       this.st.adjust();
/* 985 */       int dx = (this.body.width() - this.st.width()) / 2;
/* 986 */       int dy = (this.body.height() - this.st.height()) / 2;
/* 987 */       this.st.renderC(r, this.body.cX() + dx * this.d.x(), this.body.cY() + dy * this.d.y());
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 992 */       this.st.hoverInfoGet((GBox)text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Goods.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
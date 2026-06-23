/*     */ package settlement.room.tests.production;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ public class ProductionTrader {
/*  10 */   private static CharSequence ¤¤amountPrice = "items/price per item";
/*  11 */   private static CharSequence ¤¤price = "price";
/*  12 */   private static CharSequence ¤¤toll = "toll";
/*  13 */   private static CharSequence ¤¤tariff = "tariff";
/*  14 */   private static CharSequence ¤¤earnings = "earnings";
/*     */   static {
/*  16 */     D.ts(ProductionTrader.class);
/*     */   }
/*     */   
/*     */   private final Production prod;
/*     */   private int credits;
/*     */   
/*     */   public ProductionTrader(Production prod, int credits) {
/*  23 */     this.prod = prod;
/*  24 */     this.credits = credits;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sellPrice(RESOURCE res, ProductionSpec spec, double amount, double tariff, double toll) {
/*  29 */     int price = (int)(this.credits * this.prod.price(res, spec) * amount);
/*  30 */     int tar = (int)Math.ceil(tariff * price);
/*  31 */     int tt = (int)Math.ceil(toll * this.credits * amount);
/*  32 */     return price - tar - tt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverLegend(GBox b) {
/*  37 */     b.textLL(¤¤amountPrice);
/*  38 */     b.tab(4);
/*  39 */     b.space(60);
/*  40 */     b.textLL(¤¤tariff);
/*  41 */     b.rewind().space(120);
/*  42 */     b.textLL(¤¤earnings);
/*     */     
/*  44 */     b.NL();
/*  45 */     b.tab(4);
/*  46 */     b.textLL(¤¤price);
/*  47 */     b.rewind().space(120);
/*  48 */     b.textLL(¤¤toll);
/*  49 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverSum(GBox b, int credits) {
/*  54 */     b.tab(4);
/*     */     
/*  56 */     b.space(180);
/*  57 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), credits));
/*  58 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverSale(GBox b, RESOURCE res, ProductionSpec spec, double amount, double tariff, double toll) {
/*  63 */     b.add((SPRITE)GFORMAT.f(b.text(), Math.ceil(amount * 100.0D) / 100.0D, 2));
/*  64 */     b.tab(1);
/*  65 */     b.add((SPRITE)res.icon());
/*  66 */     int price = (int)(this.prod.price(res, spec) * this.credits);
/*  67 */     b.add((SPRITE)GFORMAT.i(b.text(), price));
/*     */     
/*  69 */     b.tab(4);
/*  70 */     price = (int)(price * amount);
/*  71 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), price));
/*  72 */     b.rewind().space(60);
/*  73 */     int tar = (int)Math.ceil(tariff * price);
/*  74 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -tar));
/*  75 */     b.rewind().space(60);
/*  76 */     int tt = (int)Math.ceil(toll * this.credits * amount);
/*  77 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -tt));
/*  78 */     b.rewind().space(60);
/*  79 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (price - tar - tt)));
/*  80 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public int buyPrice(RESOURCE res, ProductionSpec spec, double amount, double tariff, double toll) {
/*  85 */     int price = (int)(this.credits * this.prod.price(res, spec) * amount);
/*  86 */     int tar = (int)Math.ceil(tariff * price);
/*  87 */     int tt = (int)Math.ceil(toll * this.credits * amount);
/*     */     
/*  89 */     return price + tar + tt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverPuchase(GBox b, RESOURCE res, ProductionSpec spec, double amount, double tariff, double toll) {
/*  94 */     b.add((SPRITE)GFORMAT.f(b.text(), -Math.ceil(amount * 100.0D) / 100.0D, 2));
/*  95 */     b.tab(1);
/*  96 */     b.add((SPRITE)res.icon());
/*  97 */     int price = (int)(this.prod.price(res, spec) * this.credits);
/*  98 */     b.add((SPRITE)GFORMAT.i(b.text(), price));
/*     */     
/* 100 */     b.tab(4);
/* 101 */     price = (int)(price * amount);
/* 102 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -price));
/* 103 */     b.rewind().space(60);
/* 104 */     int tar = (int)Math.ceil(tariff * price);
/* 105 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -tar));
/* 106 */     b.rewind().space(60);
/* 107 */     int tt = (int)Math.ceil(toll * this.credits * amount);
/* 108 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -tt));
/* 109 */     b.rewind().space(60);
/* 110 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), -(price + tar + tt)));
/* 111 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\production\ProductionTrader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ 
/*     */ 
/*     */ public class NPCStockpileTest
/*     */ {
/*     */   private static final double AISize = 5000.0D;
/*     */   
/*     */   public NPCStockpileTest() {
/*  18 */     FactionNPC f = (FactionNPC)FACTIONS.NPCs().rnd();
/*     */ 
/*     */ 
/*     */     
/*  22 */     int[] workers = {
/*  23 */         50, 
/*  24 */         100, 
/*  25 */         150, 
/*  26 */         200, 
/*  27 */         250, 
/*  28 */         300
/*     */       };
/*     */     byte b;
/*     */     int i, arrayOfInt1[];
/*  32 */     for (i = (arrayOfInt1 = workers).length, b = 0; b < i; ) { int w = arrayOfInt1[b];
/*  33 */       System.out.println("WORKERS: " + w);
/*     */       
/*  35 */       RESOURCE ma = (RESOURCE)RESOURCES.map().get("MACHINERY").get(0);
/*  36 */       sell(f, ma.tr(), w);
/*     */       
/*  38 */       ma = (RESOURCE)RESOURCES.map().get("GRAIN").get(0);
/*  39 */       sell(f, ma.tr(), w);
/*     */       
/*  41 */       System.out.println();
/*     */       b++; }
/*     */   
/*     */   }
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
/*     */   private void sell(FactionNPC f, TRADABLE ma, double workers) {
/*  61 */     NPCStockpile s = f.stockpile;
/*     */ 
/*     */     
/*  64 */     s.saver().clear();
/*  65 */     s.update(f, 0.0D, 5000.0D);
/*  66 */     f.credits().set(0.0D);
/*     */     
/*  68 */     double po = f.buyer(ma).addPrice(1);
/*     */ 
/*     */ 
/*     */     
/*  72 */     double credits = 0.0D;
/*  73 */     double items = 0.0D;
/*  74 */     int resBought = 0;
/*  75 */     double tot = 0.0D;
/*     */     
/*  77 */     double cr = 0.0D;
/*  78 */     double am = 0.0D;
/*     */     
/*  80 */     int iterations = 100;
/*     */     
/*  82 */     for (int i = 0; i < 100; i++) {
/*     */       
/*  84 */       am += workers * s.res(ma).rate();
/*  85 */       items += am;
/*     */ 
/*     */       
/*  88 */       while (am > 0.0D) {
/*  89 */         double p = f.buyer(ma).addPrice(1);
/*  90 */         cr += p;
/*  91 */         credits += p;
/*  92 */         s.res(ma).inc(1.0D);
/*  93 */         f.credits().inc(-p, FCredits.CTYPE.TAX);
/*  94 */         am--;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 101 */       for (TRADABLE r : TR.ALL()) {
/* 102 */         tot += Math.max(f.seller(r).removePrice(1), 1);
/*     */       }
/*     */       
/* 105 */       while (cr > 0.0D) {
/* 106 */         TRADABLE rr = (TRADABLE)TR.ALL().rnd();
/* 107 */         if (rr == ma)
/*     */           continue; 
/* 109 */         double c = Math.max(f.seller(rr).removePrice(1), 1);
/* 110 */         s.res(rr).inc(-1.0D);
/* 111 */         cr -= c;
/* 112 */         f.credits().inc(c, FCredits.CTYPE.TAX);
/* 113 */         resBought++;
/*     */       } 
/*     */       
/* 116 */       s.update(f, TIME.secondsPerDay(), 5000.0D);
/* 117 */       f.credits().inc(-f.credits().credits() * 0.05D, FCredits.CTYPE.INFLATION);
/*     */     } 
/*     */     
/* 120 */     tot /= (RESOURCES.ALL().size() * 100);
/*     */     
/* 122 */     System.out.println(ma.key());
/* 123 */     System.out.println("starprice: " + (int)po);
/* 124 */     System.out.println("aveprice: " + (int)(credits / items));
/* 125 */     System.out.println("items sold: " + (int)items);
/* 126 */     System.out.println("money circulated: " + (int)credits);
/* 127 */     System.out.println("goods purchased: " + resBought);
/* 128 */     System.out.println("average buy price: " + (int)tot);
/* 129 */     double d = s.res(ma).rateTot() / s.res(ma).rate();
/* 130 */     System.out.println("profits: " + d * resBought / workers);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpileTest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
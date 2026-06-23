/*     */ package game.faction.player;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryTradable;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.region.RD;
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
/*     */ public class PTrade
/*     */ {
/*  36 */   private static CharSequence ¤¤InExported = "¤Exported";
/*  37 */   private static CharSequence ¤¤InExportedD = "¤Moneys earned from exports.";
/*     */   
/*  39 */   private static CharSequence ¤¤OutImported = "¤Imported";
/*  40 */   private static CharSequence ¤¤OutImportedD = "¤Moneys spent on imports.";
/*     */ 
/*     */   
/*  43 */   private static CharSequence ¤¤units = "¤units";
/*  44 */   private static CharSequence ¤¤unitsD = "¤The amount of units traded.";
/*  45 */   private static CharSequence ¤¤price = "¤Price";
/*  46 */   private static CharSequence ¤¤priceD = "¤Price per unit.";
/*     */   
/*     */   static {
/*  49 */     D.ts(PTrade.class);
/*     */   }
/*     */ 
/*     */   
/*  53 */   public final HistoryTradable pricesBuy = new HistoryTradable(
/*  54 */       new INFO(Dic.¤¤buyPrice, ""), 
/*  55 */       PCredits.history, (TIMECYCLE)TIME.days(), true);
/*  56 */   public final HistoryTradable pricesSell = new HistoryTradable(
/*  57 */       new INFO(Dic.¤¤sellPrice, ""), 
/*  58 */       PCredits.history, (TIMECYCLE)TIME.days(), true);
/*  59 */   public final HistoryTradable pricesAve = new HistoryTradable(
/*  60 */       new INFO(Dic.¤¤sellPrice, ""), 
/*  61 */       PCredits.history, (TIMECYCLE)TIME.days(), true);
/*     */   
/*  63 */   public final HistoryTradable unitsImported = new HistoryTradable(new INFO(¤¤units, ¤¤unitsD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*  64 */   public final HistoryTradable unitsExported = new HistoryTradable(new INFO(¤¤units, ¤¤unitsD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*  65 */   public final HistoryTradable priceImported = new HistoryTradable(new INFO(¤¤price, ¤¤priceD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*  66 */   public final HistoryTradable priceExported = new HistoryTradable(new INFO(¤¤price, ¤¤priceD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*     */   
/*  68 */   public final HistoryTradable inExported = new HistoryTradable(new INFO(¤¤InExported, ¤¤InExportedD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*  69 */   public final HistoryTradable outImported = new HistoryTradable(new INFO(¤¤OutImported, ¤¤OutImportedD), PCredits.history, (TIMECYCLE)TIME.days(), false);
/*     */ 
/*     */   
/*  72 */   int ri = 0;
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  76 */     this.ri %= TR.ALL().size();
/*  77 */     TRADABLE res = (TRADABLE)TR.ALL().get(this.ri);
/*     */     
/*  79 */     int s = 0;
/*  80 */     int m = Integer.MAX_VALUE;
/*  81 */     if (DIP.traders().size() == 0) {
/*  82 */       for (FactionNPC f : RD.DIST().neighs()) {
/*  83 */         if (f.capitolRegion() != null) {
/*  84 */           s = Math.max(s, f.res(res).priceBuyP());
/*  85 */           m = Math.min(m, f.res(res).priceSellP());
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/*  90 */       for (Faction ff : DIP.traders()) {
/*  91 */         FactionNPC f = (FactionNPC)ff;
/*  92 */         if (f.capitolRegion() != null) {
/*  93 */           s = Math.max(s, f.res(res).priceBuyP());
/*  94 */           m = Math.min(m, f.res(res).priceSellP());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     if (m == Integer.MAX_VALUE)
/* 103 */       m = 0; 
/* 104 */     this.pricesSell.set((MAPPED)res, s);
/* 105 */     this.pricesBuy.set((MAPPED)res, m);
/* 106 */     this.pricesAve.set((MAPPED)res, FACTIONS.PRICE().get(res));
/*     */     
/* 108 */     this.ri++;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void trade(double amount, TRADABLE res, int resAm) {
/* 114 */     if (amount < 0.0D) {
/* 115 */       this.outImported.inc(res, (int)-amount);
/* 116 */       this.unitsImported.inc(res, resAm);
/* 117 */       int p = (this.unitsImported.get((MAPPED)res) > 0) ? (this.outImported.get((MAPPED)res) / this.unitsImported.get((MAPPED)res)) : 0;
/* 118 */       this.priceImported.set((MAPPED)res, p);
/*     */     } else {
/*     */       
/* 121 */       this.inExported.inc(res, (int)amount);
/* 122 */       this.unitsExported.inc(res, resAm);
/* 123 */       this.priceExported.set((MAPPED)res, (this.inExported.get((MAPPED)res) + 1) / (this.unitsExported.get((MAPPED)res) + 1));
/*     */     } 
/*     */   }
/*     */   
/* 127 */   final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       
/*     */       public void save(FilePutter file)
/*     */       {
/* 132 */         PTrade.this.pricesBuy.save(file);
/* 133 */         PTrade.this.pricesSell.save(file);
/* 134 */         PTrade.this.pricesAve.save(file);
/* 135 */         PTrade.this.outImported.save(file);
/* 136 */         PTrade.this.inExported.save(file);
/* 137 */         PTrade.this.unitsImported.save(file);
/* 138 */         PTrade.this.unitsExported.save(file);
/* 139 */         PTrade.this.priceImported.save(file);
/* 140 */         PTrade.this.priceExported.save(file);
/* 141 */         file.i(PTrade.this.ri);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/* 146 */         PTrade.this.pricesBuy.load(file);
/* 147 */         PTrade.this.pricesSell.load(file);
/* 148 */         PTrade.this.pricesAve.load(file);
/* 149 */         PTrade.this.outImported.load(file);
/* 150 */         PTrade.this.inExported.load(file);
/* 151 */         PTrade.this.unitsImported.load(file);
/* 152 */         PTrade.this.unitsExported.load(file);
/* 153 */         PTrade.this.priceImported.load(file);
/* 154 */         PTrade.this.priceExported.load(file);
/* 155 */         PTrade.this.ri = file.i();
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {
/* 161 */         PTrade.this.pricesBuy.clear();
/* 162 */         PTrade.this.pricesSell.clear();
/* 163 */         PTrade.this.pricesAve.clear();
/* 164 */         PTrade.this.outImported.clear();
/* 165 */         PTrade.this.inExported.clear();
/* 166 */         PTrade.this.unitsImported.clear();
/* 167 */         PTrade.this.unitsExported.clear();
/* 168 */         PTrade.this.priceImported.clear();
/* 169 */         PTrade.this.priceExported.clear();
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTrade.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
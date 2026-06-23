/*     */ package settlement.trade;
/*     */ 
/*     */ import game.faction.FResources;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import init.settings.S;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ 
/*     */ class PSellerSlave extends PSeller {
/*  24 */   private static CharSequence ¤¤limit = "¤Limit: {0}. (Export when you own more than {1} slaves.)";
/*  25 */   private static CharSequence ¤¤none = "¤Never Export slaves";
/*  26 */   private static CharSequence ¤¤all = "¤Limit is set to export all slaves";
/*  27 */   private static CharSequence ¤¤nope = "¤You have set the limit to never export slaves.";
/*     */   private final TRADABLEO<Race> slave;
/*     */   
/*     */   static {
/*  31 */     D.ts(PSellerSlave.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PSellerSlave(TRADABLEO<Race> type) {
/*  38 */     super((TRADABLE)type, new INT.IntImp(0, 0, 40000));
/*  39 */     this.slave = type;
/*     */   }
/*     */ 
/*     */   
/*     */   public int attempting(TRADE_TYPE t) {
/*  44 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int extract(int amount, TRADE_TYPE t) {
/*  49 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  55 */     super.clear();
/*  56 */     this.limit.setD(0.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double prio() {
/*  62 */     if (removeMax() <= 0) {
/*  63 */       return -1.0D;
/*     */     }
/*  65 */     return (playerOwned() / (1 + this.outbound.get(null)));
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int amount, TRADE_TYPE type, int price, Faction buyer) {
/*  70 */     super.remove(amount, type, price, buyer);
/*     */   }
/*     */ 
/*     */   
/*     */   public int playerOwned() {
/*  75 */     int stocked = STATS.POP().pop((Race)this.slave.t, HTYPES.SLAVE());
/*  76 */     stocked -= this.outbound.get(null);
/*  77 */     return stocked;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void vanish(int amount, FResources.RTYPE t) {
/*  83 */     (new EntityIterator.Humans(amount)
/*     */       {
/*     */         int aa;
/*     */ 
/*     */         
/*     */         protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/*  89 */           if (h.indu().hType() == HTYPES.SLAVE()) {
/*  90 */             h.kill(false, CAUSE_LEAVES.SOLD());
/*  91 */             this.aa--;
/*     */           } 
/*  93 */           return (this.aa > 0);
/*     */         }
/*  95 */       }).iterate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int storedHistorically(int daysBack) {
/* 102 */     return STATS.POP().pop((Race)this.slave.t, HTYPES.SLAVE(), daysBack);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence exporting() {
/* 108 */     return (this.limit.get() > 0) ? null : ¤¤nope;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverCapacity(GUI_BOX bob) {
/* 114 */     super.hoverCapacity(bob);
/*     */ 
/*     */     
/* 117 */     GBox b = (GBox)bob;
/* 118 */     GText t = b.text();
/* 119 */     if (this.limit.getD() == 1.0D) {
/* 120 */       t.add(¤¤all);
/* 121 */     } else if (this.limit.getD() == 0.0D) {
/* 122 */       t.add(¤¤none);
/*     */     } else {
/* 124 */       t.add(¤¤limit);
/* 125 */       t.insert(0, this.limit.get());
/* 126 */       t.insert(1, this.limit.max - this.limit.get());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 131 */     bob.add((SPRITE)t);
/* 132 */     bob.NL();
/* 133 */     if ((S.get()).developer) {
/* 134 */       b.text((CharSequence)b.text().add(prio()));
/* 135 */       b.text((CharSequence)b.text().add(String.valueOf(exporting())));
/* 136 */       b.text((CharSequence)b.text().add((SETT.TRADE()).slavesReserved[((Race)this.slave.t).index]));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int removeMax() {
/* 142 */     if (SETT.ENTRY().isClosed())
/* 143 */       return 0; 
/* 144 */     int mustHave = 40000 - this.limit.get();
/* 145 */     int am = playerOwned() - this.outbound.get(null) - mustHave;
/* 146 */     return Math.max(am, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public double capacityValue() {
/* 151 */     double owned = STATS.POP().pop((Race)this.slave.t, HTYPES.SLAVE());
/* 152 */     if (owned == 0.0D)
/* 153 */       return 0.0D; 
/* 154 */     return this.outbound.get(null) / owned;
/*     */   }
/*     */ 
/*     */   
/*     */   public int tradeCredits(int price) {
/* 159 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public double tradeValue(int price) {
/* 164 */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void hoverTradeValue(GUI_BOX box) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PSellerSlave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
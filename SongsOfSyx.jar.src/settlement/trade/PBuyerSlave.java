/*     */ package settlement.trade;
/*     */ 
/*     */ import init.race.Race;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ class PBuyerSlave
/*     */   extends PBuyer {
/*  24 */   private static CharSequence ¤¤warning = "¤You don't have any capacity to import more captives.";
/*  25 */   private static CharSequence ¤¤LevelNever = "¤Limit is set to never Import {0}.";
/*  26 */   private static CharSequence ¤¤LevelCurrent = "¤Limit is set to import to maintain {0} {1}.";
/*     */   
/*  28 */   private static CharSequence ¤¤punishFree = "¤Your automatic punishment for captives is set to either pardon or exile! Imported captives will instantly leave your city!";
/*  29 */   private static CharSequence ¤¤punishSlave = "¤Your automatic punishment for captives is set to enslavement. Captives that arrive will be instantly turned to slaves, and your limit will refer to your slave population."; private final TRADABLEO<Race> slave;
/*  30 */   private static CharSequence ¤¤punishOther = "¤Your automatic punishment for captives is set so that the limit refers to your stockade and prisoners."; private Type tslave;
/*     */   
/*     */   static {
/*  33 */     D.ts(PBuyerSlave.class);
/*     */   }
/*     */   private Type tfree;
/*     */   private Type tstock;
/*     */   
/*     */   PBuyerSlave(TRADABLEO<Race> tradable) {
/*  39 */     super((TRADABLE)tradable, new INT.IntImp(0, 40000));
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
/* 170 */     this.tslave = new Type()
/*     */       {
/*     */         public int capacityUsed()
/*     */         {
/* 174 */           return POP.next(HCLASSES.SLAVE(), (Race)PBuyerSlave.this.slave.t) + PBuyerSlave.this.toBeAdded().get(null) + PBuyerSlave.this.toBeStored().get(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public int capacity() {
/* 179 */           return PBuyerSlave.this.limit.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GBox b) {
/* 184 */           b.text(PBuyerSlave.¤¤punishSlave);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 189 */     this.tfree = new Type()
/*     */       {
/*     */         public int capacityUsed()
/*     */         {
/* 193 */           return PBuyerSlave.this.incoming.get(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public int capacity() {
/* 198 */           return PBuyerSlave.this.limit.get();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GBox b) {
/* 203 */           b.warn(PBuyerSlave.¤¤punishFree);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 208 */     this.tstock = new Type()
/*     */       {
/*     */         public int capacityUsed()
/*     */         {
/* 212 */           return (SETT.ROOMS()).STOCKADE.punishUsed();
/*     */         }
/*     */ 
/*     */         
/*     */         public int capacity() {
/* 217 */           return Math.min((SETT.ROOMS()).STOCKADE.punishTotal() - (SETT.ROOMS()).STOCKADE.punishUsed() + PBuyerSlave.this.incoming.get(null), PBuyerSlave.this.limit.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GBox b) {
/* 222 */           b.warn(PBuyerSlave.¤¤punishOther);
/*     */         }
/*     */       };
/*     */     this.slave = tradable;
/*     */   }
/*     */   
/*     */   public int attempting(TRADE_TYPE t) {
/*     */     return SETT.ENTRY().onTheirWay((Race)this.slave.t, HTYPES.PRISONER());
/*     */   }
/*     */   
/*     */   protected int deliver(TRADE_TYPE tt, int amount) {
/*     */     SETT.ENTRY().add((Race)this.slave.t, HTYPES.PRISONER(), amount);
/*     */     return amount;
/*     */   }
/*     */   
/*     */   public boolean importing() {
/*     */     return (this.limit.get() > 0);
/*     */   }
/*     */   
/*     */   public double buyPriority(int amount, double price) {
/*     */     Type t = type();
/*     */     int owned = t.capacityUsed();
/*     */     int lim = t.capacity();
/*     */     if (owned + amount > lim)
/*     */       return -1.0D; 
/*     */     return super.buyPriority(amount, price);
/*     */   }
/*     */   
/*     */   public CharSequence warning() {
/*     */     Type t = type();
/*     */     int owned = t.capacityUsed();
/*     */     int lim = t.capacity();
/*     */     if (owned >= lim)
/*     */       return ¤¤warning; 
/*     */     return super.warning();
/*     */   }
/*     */   
/*     */   public void hoverCapacity(GBox b) {
/*     */     Type ty = type();
/*     */     type().hover(b);
/*     */     b.NL(4);
/*     */     GText t = b.text();
/*     */     double lim = this.limit.get();
/*     */     if (lim == 0.0D) {
/*     */       t.add(¤¤LevelNever);
/*     */       t.insert(0, ((Race)this.slave.t).info.names);
/*     */       b.add((SPRITE)t);
/*     */       return;
/*     */     } 
/*     */     t.add(¤¤LevelCurrent);
/*     */     t.insert(0, ((Race)this.slave.t).info.names);
/*     */     t.insert(1, this.limit.get());
/*     */     b.add((SPRITE)t);
/*     */     b.NL(4);
/*     */     b.textLL(¤¤Owned);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), ty.capacityUsed()));
/*     */     b.NL();
/*     */     b.textLL(¤¤Inbound);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), this.incoming.get(null)));
/*     */     b.NL();
/*     */     b.textLL(¤¤ImportCanBe);
/*     */     b.tab(6);
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), (ty.capacity() - ty.capacityUsed())));
/*     */     b.NL();
/*     */   }
/*     */   
/*     */   public int tradeCredits(int price) {
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public double tradeValue(int price) {
/*     */     return 0.0D;
/*     */   }
/*     */   
/*     */   public void hoverTradeValue(double price, GUI_BOX box) {}
/*     */   
/*     */   public double capacityValue() {
/*     */     double cap = type().capacity();
/*     */     if (cap == 0.0D)
/*     */       return 0.0D; 
/*     */     return CLAMP.d(type().capacityUsed() / cap, 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   private Type type() {
/*     */     CRIME_PUNISHMENTS.PUNISHMENT p = (CRIMES.WAR().stat().punishment(HCLASSES.OTHER(), (Race)this.slave.t)).punish;
/*     */     if (p == CRIME_PUNISHMENTS.BANISH() || p == CRIME_PUNISHMENTS.PARDON())
/*     */       return this.tfree; 
/*     */     if (p == CRIME_PUNISHMENTS.ENSLAVE())
/*     */       return this.tslave; 
/*     */     return this.tstock;
/*     */   }
/*     */   
/*     */   private static interface Type {
/*     */     int capacity();
/*     */     
/*     */     int capacityUsed();
/*     */     
/*     */     void hover(GBox param1GBox);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\PBuyerSlave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
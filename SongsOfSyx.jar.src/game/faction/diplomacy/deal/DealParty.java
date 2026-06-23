/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.trade.TradeManager;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.Alloc;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import world.WORLD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DealParty
/*     */ {
/*     */   private double selfWorth;
/*     */   private double offerableWorth;
/*     */   private Faction f;
/*     */   private Faction other;
/*     */   private FactionNPC npc;
/*     */   private double dist;
/*     */   
/*  32 */   public final INT.IntImp credits = new INT.IntImp()
/*     */     {
/*     */       public int min()
/*     */       {
/*  36 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max() {
/*  41 */         Faction fa = DealParty.this.f;
/*  42 */         int cr = 0;
/*  43 */         if (fa instanceof FactionNPC) {
/*  44 */           cr = (int)((FactionNPC)fa).stockpile.credit();
/*     */         } else {
/*  46 */           cr = (int)DealParty.this.f.credits().credits();
/*  47 */         }  if (cr < 0)
/*  48 */           return 0; 
/*  49 */         return cr;
/*     */       }
/*     */     };
/*     */   
/*     */   public final DealRegs regs;
/*  54 */   private final int[] res = Alloc.ii(TR.ALL().size());
/*  55 */   private final int[] resMax = Alloc.ii(TR.ALL().size());
/*     */   
/*  57 */   public final INT_O.INT_OE<TRADABLE> resources = new INT_O.INT_OE<TRADABLE>()
/*     */     {
/*     */       public int get(TRADABLE t)
/*     */       {
/*  61 */         return DealParty.this.res[t.index()];
/*     */       }
/*     */ 
/*     */       
/*     */       public int min(TRADABLE t) {
/*  66 */         return 0;
/*     */       }
/*     */ 
/*     */       
/*     */       public int max(TRADABLE t) {
/*  71 */         if (DealParty.this.f == FACTIONS.player())
/*  72 */           return DealParty.this.resMax[t.index()]; 
/*  73 */         return Math.max(DealParty.this.f.res().getAvailable(t) - 1, 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public void set(TRADABLE t, int i) {
/*  78 */         DealParty.this.res[t.index()] = i;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   DealParty(Deal deal, DealRegs.RegData rdata) {
/*  84 */     this.regs = new DealRegs(deal, rdata);
/*     */   }
/*     */   
/*     */   void clear() {
/*  88 */     this.credits.set(0);
/*  89 */     Arrays.fill(this.res, 0);
/*  90 */     this.regs.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   void execute() {
/*  95 */     this.other.credits().inc(this.credits.get(), FCredits.CTYPE.DIPLOMACY);
/*  96 */     this.f.credits().inc(-this.credits.get(), FCredits.CTYPE.DIPLOMACY);
/*     */     
/*  98 */     for (DealRegs.DealReg reg : this.regs.all()) {
/*  99 */       if (reg.is()) {
/* 100 */         RD.setFaction(reg.reg(), this.other, true);
/*     */       }
/*     */     } 
/*     */     
/* 104 */     boolean rr = false;
/* 105 */     for (TRADABLE r : TR.ALL()) {
/* 106 */       if (this.res[r.index()] > 0) {
/* 107 */         rr = true;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 112 */     if (!rr) {
/*     */       return;
/*     */     }
/* 115 */     Shipment s = (WORLD.ENTITIES()).caravans.create(this.f.capitolRegion().cx(), this.f.capitolRegion().cy(), 
/* 116 */         this.other.capitolRegion(), TRADE_TYPE.diplomacy);
/* 117 */     if (s != null) {
/* 118 */       for (TRADABLE r : TR.ALL()) {
/* 119 */         int a = this.resources.get(r);
/*     */         
/* 121 */         if (a > 0) {
/* 122 */           s.loadAndReserve(r, a);
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/* 128 */       for (TRADABLE r : TR.ALL()) {
/* 129 */         int a = this.resources.get(r);
/* 130 */         this.other.buyer(r).addReserveAndDeliver(a, TRADE_TYPE.diplomacy);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 135 */     for (TRADABLE r : TR.ALL()) {
/* 136 */       int a = this.resources.get(r);
/* 137 */       if (a > 0) {
/* 138 */         this.f.seller(r).remove(a, TRADE_TYPE.diplomacy, 0, this.other);
/*     */       }
/*     */     } 
/*     */     
/* 142 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double value() {
/* 148 */     double value = 0.0D;
/* 149 */     value += this.credits.get();
/*     */     
/* 151 */     for (TRADABLE r : TR.ALL()) {
/*     */       
/* 153 */       if (this.res[r.index()] > 0) {
/* 154 */         value += valueResource(r, this.res[r.index()]);
/*     */       }
/*     */     } 
/*     */     
/* 158 */     value += this.regs.worth();
/*     */     
/* 160 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(Faction a, Faction b, FactionNPC evaluator) {
/* 166 */     this.f = a;
/* 167 */     this.other = b;
/* 168 */     this.npc = evaluator;
/* 169 */     this.regs.init(a, b, evaluator);
/*     */     
/* 171 */     this.credits.set(0);
/* 172 */     this.selfWorth = this.regs.selfWorth();
/* 173 */     this.offerableWorth = this.regs.offerableWorth();
/* 174 */     this.selfWorth += this.credits.max();
/* 175 */     this.offerableWorth += this.credits.max();
/*     */     
/* 177 */     for (TRADABLE r : TR.ALL()) {
/* 178 */       this.res[r.index()] = 0;
/* 179 */       int available = this.f.res().getAvailable(r);
/* 180 */       this.resMax[r.index()] = available;
/*     */       
/* 182 */       if (this.f == FACTIONS.player() && available > 0) {
/* 183 */         this.dist = WORLD.PATH().distance(a.capitolRegion(), b.capitolRegion());
/* 184 */         double feePerUnit = TradeManager.totalFee((Faction)FACTIONS.player(), (Faction)this.npc, this.dist, r, 1);
/* 185 */         int low = 0;
/* 186 */         int high = available;
/* 187 */         int best = 0;
/*     */         
/* 189 */         while (low <= high) {
/* 190 */           int mid = low + (high - low) / 2;
/*     */           
/* 192 */           double pricePerUnit = this.npc.res(r).priceAt(mid) * 0.8D;
/*     */ 
/*     */           
/* 195 */           double netPrice = pricePerUnit - feePerUnit;
/*     */           
/* 197 */           if (netPrice > 0.0D) {
/* 198 */             best = mid;
/* 199 */             low = mid + 1; continue;
/*     */           } 
/* 201 */           high = mid - 1;
/*     */         } 
/*     */ 
/*     */         
/* 205 */         this.resMax[r.index()] = best;
/*     */       } 
/*     */       
/* 208 */       double v = valueResource(r, (int)Math.ceil(available * 0.75D));
/* 209 */       this.selfWorth += v;
/* 210 */       this.offerableWorth += v;
/*     */     } 
/*     */     
/* 213 */     if (a != FACTIONS.player())
/* 214 */       this.offerableWorth *= 0.25D; 
/* 215 */     clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public int valueResource(TRADABLE res, int amount) {
/* 220 */     if (this.f == FACTIONS.player()) {
/* 221 */       double d = this.npc.buyer(res).addPrice(amount);
/* 222 */       d -= TradeManager.totalFee((Faction)FACTIONS.player(), (Faction)this.npc, this.dist, res, amount);
/* 223 */       d *= 0.9D;
/* 224 */       return (int)Math.max(d, 0.0D);
/*     */     } 
/* 226 */     double p = this.npc.seller(res).removePrice(amount);
/* 227 */     p += TradeManager.totalFee(this.f, this.other, this.dist, res, amount);
/* 228 */     p *= 1.1D;
/* 229 */     return (int)Math.max(p, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static int manualPriceSell(FactionNPC f, TRADABLE res, int amount) {
/* 235 */     int p = f.seller(res).removePrice(amount);
/* 236 */     p += TradeManager.totalFee((Faction)f, (Faction)FACTIONS.player(), RD.DIST().distance((Faction)f), res, amount);
/* 237 */     if (!(DIP.get(f)).trades) {
/* 238 */       p = (int)(p * 1.5D);
/*     */     } else {
/* 240 */       p = (int)(p * 1.25D);
/* 241 */     }  return Math.max(p, 1);
/*     */   }
/*     */   
/*     */   public static int manualPriceBuy(FactionNPC f, TRADABLE res, int amount) {
/* 245 */     int p = f.buyer(res).addPrice(amount);
/* 246 */     p -= TradeManager.totalFee((Faction)FACTIONS.player(), (Faction)f, RD.DIST().distance((Faction)f), res, amount);
/*     */     
/* 248 */     p = (int)(p * 0.8D);
/* 249 */     return Math.max(p, 0);
/*     */   }
/*     */   
/*     */   public double selfWorth() {
/* 253 */     return this.selfWorth;
/*     */   }
/*     */   
/*     */   public double offerableWorth() {
/* 257 */     return this.offerableWorth;
/*     */   }
/*     */   
/*     */   public Faction f() {
/* 261 */     return this.f;
/*     */   }
/*     */   
/*     */   public FactionNPC npc() {
/* 265 */     return this.npc;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealParty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
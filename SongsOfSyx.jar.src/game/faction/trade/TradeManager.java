/*     */ package game.faction.trade;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.FactionResource;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.updating.TileUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.WORLD;
/*     */ import world.entity.caravan.Shipment;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TradeManager
/*     */   extends FactionResource
/*     */ {
/*     */   public static final int TRADE_INTERVAL = 1;
/*  33 */   public static double tollPerTile = 0.25D;
/*     */   
/*     */   private final TileUpdater updater;
/*  36 */   private final TradeShipper shipper = new TradeShipper();
/*  37 */   private final TradeSorter sorter = new TradeSorter();
/*     */ 
/*     */   
/*     */   public static int totalFee(Faction seller, Faction buyer, double distance, TRADABLE res, int amount) {
/*  41 */     double toll = toll(seller, buyer, distance);
/*  42 */     double tarif = tarif(seller, buyer, res, amount);
/*  43 */     return (int)(Math.floor(toll + tarif) * amount);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double tarif(Faction seller, Faction buyer, TRADABLE res, int amount) {
/*  49 */     if (buyer == FACTIONS.player()) {
/*  50 */       return 0.0D;
/*     */     }
/*     */     
/*  53 */     if (seller == FACTIONS.player()) {
/*  54 */       return playerTarif((FactionNPC)buyer, res, amount);
/*     */     }
/*     */     
/*  57 */     FactionNPC npc = (FactionNPC)buyer;
/*     */     
/*  59 */     double price = price(npc, res);
/*  60 */     double tt = (DIP.ALLY()).tarif;
/*  61 */     return tt * price;
/*     */   }
/*     */   
/*     */   private static double playerTarif(FactionNPC npc, TRADABLE res, int amount) {
/*  65 */     double price = price(npc, res);
/*  66 */     double tt = ROPINION.tradeCost(npc);
/*  67 */     tt += npc.res(res).playerTarif(amount);
/*  68 */     if (tt > 0.9D)
/*  69 */       tt = 0.9D; 
/*  70 */     return tt * price;
/*     */   }
/*     */   
/*     */   public static double toll(FactionNPC f) {
/*  74 */     return toll((Faction)FACTIONS.player(), (Faction)f, RD.DIST().distance((Faction)f));
/*     */   }
/*     */   
/*     */   private static double price(FactionNPC npc, TRADABLE res) {
/*  78 */     double price = npc.res(res).priceAt(0);
/*  79 */     return price;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double toll(Faction f, Faction f2, double distance) {
/*  84 */     distance = (20.0D + distance) * tollPerTile;
/*  85 */     distance = Math.max(0.0D, distance);
/*     */ 
/*     */     
/*  88 */     if (f == FACTIONS.player() || f2 == FACTIONS.player()) {
/*  89 */       return distance / (RD.DIST()).bProximityToll.get((BOOSTABLE_O)HCLASSES.CITIZEN().get(null));
/*     */     }
/*  91 */     return distance / 4.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TradeManager(FACTIONS fs) {
/*  98 */     IDebugPanel.add("Trade all", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 102 */             TradeManager.this.clear();
/* 103 */             TradeManager.this.prime();
/*     */           }
/*     */         });
/*     */     
/* 107 */     this.updater = new TileUpdater(FACTIONS.MAX(), FACTIONS.MAX() + 4, 1.0D * TIME.days().bitSeconds())
/*     */       {
/*     */         protected void update(int iteration, int factionI, int vv, double timeSinceLast)
/*     */         {
/* 111 */           if (factionI == FACTIONS.MAX() / 2 || factionI == 0) {
/*     */             
/* 113 */             if (iteration == 0) {
/* 114 */               TradeManager.this.sellPlayer();
/*     */             }
/* 116 */             if (TradeManager.this.shipper.partners() > 0) {
/* 117 */               TradeShipper.Partner p = TradeManager.this.shipper.popNextPartner();
/* 118 */               Faction b = p.faction();
/* 119 */               TradeManager.this.ship(b, (Faction)FACTIONS.player(), p, true);
/*     */             } 
/*     */             return;
/*     */           } 
/* 123 */           if (factionI == FACTIONS.MAX() / 2 + 1 || factionI == 1) {
/* 124 */             pbuy((Faction)FACTIONS.player(), iteration);
/*     */             
/*     */             return;
/*     */           } 
/* 128 */           if (factionI < FACTIONS.MAX() / 2) {
/* 129 */             factionI--;
/*     */           } else {
/* 131 */             factionI -= 3;
/*     */           } 
/* 133 */           if (factionI >= FACTIONS.MAX()) {
/*     */             return;
/*     */           }
/* 136 */           Faction buyer = FACTIONS.getByIndex(factionI);
/* 137 */           pbuy(buyer, iteration);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         private void pbuy(Faction buyer, int iteration) {
/* 143 */           if (buyer.isActive() && buyer.capitolRegion() != null) {
/* 144 */             if (iteration == 0) {
/* 145 */               TradeManager.this.buy(buyer);
/*     */             }
/*     */             
/* 148 */             if (TradeManager.this.shipper.partners() > 0) {
/* 149 */               TradeShipper.Partner p = TradeManager.this.shipper.popNextPartner();
/* 150 */               Faction b = p.faction();
/* 151 */               TradeManager.this.ship(buyer, b, p, true);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 160 */     this.updater.save(file);
/* 161 */     this.shipper.save(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 167 */     this.updater.load(file);
/* 168 */     this.shipper.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 173 */     this.updater.clear();
/* 174 */     this.shipper.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds, Faction f) {
/* 179 */     this.updater.update(ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void sellPlayer() {
/* 185 */     if (!SETT.exists() || SETT.ENTRY().isClosed()) {
/*     */       return;
/*     */     }
/* 188 */     this.shipper.init((Faction)FACTIONS.player());
/* 189 */     this.sorter.sellPlayer(this.shipper);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void buy(Faction buyer) {
/* 195 */     this.shipper.init(buyer);
/* 196 */     this.sorter.buy(buyer, this.shipper);
/*     */   }
/*     */ 
/*     */   
/*     */   private void ship(Faction buyer, Faction seller, TradeShipper.Partner count, boolean shipping) {
/* 201 */     if (!buyer.isActive()) {
/*     */       return;
/*     */     }
/* 204 */     int am = 0;
/* 205 */     for (TRADABLE r : TR.ALL()) {
/* 206 */       am += count.traded(r);
/*     */     }
/*     */ 
/*     */     
/* 210 */     if (am <= 0) {
/*     */       return;
/*     */     }
/* 213 */     Shipment s = null;
/* 214 */     if (shipping && seller.isActive()) {
/* 215 */       boolean create = !(buyer != FACTIONS.player() && seller != FACTIONS.player());
/* 216 */       if (!create) {
/* 217 */         create = (WORLD.ENTITIES().allFast().size() < 200);
/*     */       }
/* 219 */       if (create) {
/* 220 */         s = (WORLD.ENTITIES()).caravans.create(seller.capitolRegion(), buyer.capitolRegion(), TRADE_TYPE.trade);
/* 221 */         if (s == null) {
/* 222 */           LOG.ln("here!");
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 228 */     if (s != null) {
/* 229 */       for (TRADABLE r : TR.ALL()) {
/* 230 */         int a = count.traded(r);
/* 231 */         if (a > 0) {
/* 232 */           s.load(r, a);
/*     */         }
/*     */       } 
/*     */     } else {
/* 236 */       for (TRADABLE r : TR.ALL()) {
/* 237 */         int a = count.traded(r);
/* 238 */         if (a > 0) {
/* 239 */           buyer.buyer(r).addDeliver(am, TRADE_TYPE.trade);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void prime() {
/* 248 */     for (int i = 0; i < FACTIONS.NPCs().size(); i++) {
/* 249 */       FactionNPC f = (FactionNPC)FACTIONS.NPCs().get(i);
/* 250 */       if (f.isActive()) {
/*     */         
/* 252 */         buy((Faction)f);
/* 253 */         while (this.shipper.hasNextPartner()) {
/* 254 */           TradeShipper.Partner p = this.shipper.popNextPartner();
/* 255 */           ship((Faction)f, p.faction(), p, false);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\trade\TradeManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
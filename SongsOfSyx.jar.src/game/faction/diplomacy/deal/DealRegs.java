/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.BOOLEAN;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DealRegs
/*     */ {
/*  32 */   private final ArrayList<DealReg> tmp = new ArrayList(128);
/*  33 */   private final DealReg[] all = new DealReg[128];
/*     */   
/*     */   private int selfWorth;
/*     */   
/*     */   private int offerableWorth;
/*     */   
/*     */   private boolean dirty = true;
/*     */   
/*     */   private Faction giver;
/*     */   private Faction reciever;
/*     */   private final RegData data;
/*     */   private final Deal deal;
/*     */   
/*  46 */   private final WRegFinder.Treaty t = new WRegFinder.Treaty()
/*     */     {
/*     */       public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */       {
/*  50 */         if (to == null)
/*  51 */           return true; 
/*  52 */         if (prevReg == null)
/*  53 */           return false; 
/*  54 */         if (prevReg.faction() == DealRegs.this.reciever)
/*  55 */           return true; 
/*  56 */         if (prevReg == to)
/*  57 */           return true; 
/*  58 */         return (to.faction() == DealRegs.this.giver);
/*     */       }
/*     */     };
/*     */   
/*  62 */   private final WRegSel sel = new WRegSel()
/*     */     {
/*     */       public boolean is(Region t)
/*     */       {
/*  66 */         return (t.faction() == DealRegs.this.giver && !t.capitol());
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(Faction giver, Faction reciever, FactionNPC evaluator) {
/*  80 */     this.data.selected.clear();
/*  81 */     this.data.canSelect.clear();
/*     */     
/*  83 */     this.giver = giver;
/*  84 */     this.reciever = reciever;
/*  85 */     this.selfWorth = 0;
/*  86 */     for (int i = 0; i < giver.realm().regions(); i++) {
/*  87 */       if (!giver.realm().region(i).capitol()) {
/*     */         
/*  89 */         this.selfWorth = (int)(this.selfWorth + valueRegion(giver.realm().region(i), evaluator, 0.0D));
/*  90 */         this.data.selected.set(giver.realm().region(i).index(), false);
/*     */       } 
/*  92 */     }  this.tmp.clearSloppy();
/*     */     
/*  94 */     this.offerableWorth = 0;
/*  95 */     int ri = 0;
/*     */     
/*  97 */     if (reciever.capitolRegion() != null) {
/*  98 */       for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(reciever.capitolRegion(), this.t, this.sel)) {
/*  99 */         if (!this.tmp.hasRoom()) {
/*     */           break;
/*     */         }
/* 102 */         if (d.reg.capitol()) {
/*     */           continue;
/*     */         }
/* 105 */         DealReg rr = this.all[ri++];
/* 106 */         rr.reg = d.reg;
/* 107 */         if (giver == evaluator) {
/* 108 */           this.data.values[d.reg.index()] = (int)valueRegion(d.reg, evaluator, d.distance);
/*     */         } else {
/* 110 */           this.data.values[d.reg.index()] = (int)((0.5D + 0.5D * CLAMP.d(1.0D - d.distance / 255.0D, 0.0D, 1.0D)) * valueRegion(d.reg, evaluator, d.distance));
/* 111 */           if (giver == FACTIONS.player() && !DIP.WAR().is(giver, (Faction)evaluator)) {
/* 112 */             this.data.values[d.reg.index()] = (int)(this.data.values[d.reg.index()] * ROPINION.STANCE().trustWorthyness(evaluator));
/*     */           }
/*     */         } 
/*     */         
/* 116 */         this.offerableWorth += this.data.values[d.reg.index()];
/* 117 */         this.tmp.add(rr);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 125 */     this.dirty = true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean log = false;
/*     */   
/*     */   private final WRegFinder.Treaty itreaty;
/*     */   
/*     */   private static double valueRegion(Region reg, FactionNPC faction, double dist) {
/* 134 */     if (log) {
/* 135 */       LOG.ln(reg.info.name());
/*     */     }
/* 137 */     double value = 0.0D;
/*     */ 
/*     */ 
/*     */     
/* 141 */     for (RDRace r : (RD.RACES()).all) {
/* 142 */       value += FACTIONS.PRICE().get((TRADABLE)TR.get(r.race)) * 0.25D;
/*     */     }
/*     */     
/* 145 */     if (log)
/* 146 */       LOG.ln("slaves " + value); 
/* 147 */     double ma = 0.0D;
/*     */     
/* 149 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 150 */       for (BoostSpec bo : bu.boosters().all()) {
/* 151 */         TRADABLE resource = RD.OUTPUT().fromBoost(bo.boostable);
/* 152 */         if (resource != null) {
/* 153 */           double m = BUtil.value((LIST)bu.baseFactors, reg);
/* 154 */           double v = bo.booster.max() * m * faction.res(resource).priceBase();
/* 155 */           if (v > ma) {
/* 156 */             if (log)
/* 157 */               LOG.ln(String.valueOf(resource) + " " + String.valueOf(resource) + " " + m + " " + bo.booster.max() + " " + faction.res(resource).priceBase() + " " + bu.key() + " " + String.valueOf(bo.booster.info.name)); 
/* 158 */             ma = v;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 165 */     if (log)
/* 166 */       LOG.ln("res " + ma); 
/* 167 */     value += 80.0D * ma * (0.05D + RD.RACES().popSizeD(reg));
/* 168 */     if (log) {
/* 169 */       LOG.ln(Double.valueOf(value));
/*     */     }
/* 171 */     if (reg.faction() == faction) {
/* 172 */       value *= 2.0D;
/* 173 */     } else if (RD.OWNER().prevOwner(reg) == faction) {
/* 174 */       value *= 1.5D;
/*     */     } else {
/* 176 */       value *= CLAMP.d(1.0D - dist / 256.0D, 0.1D, 1.0D);
/*     */     } 
/*     */ 
/*     */     
/* 180 */     return value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double lootWorth(Region reg) {
/* 186 */     double value = 0.0D;
/*     */ 
/*     */ 
/*     */     
/* 190 */     for (RDRace r : (RD.RACES()).all) {
/* 191 */       value += FACTIONS.PRICE().get((TRADABLE)TR.get(r.race)) * 0.25D;
/*     */     }
/*     */     
/* 194 */     double ma = 0.0D;
/*     */     
/* 196 */     for (RDBuilding bu : (RD.BUILDINGS()).all) {
/* 197 */       for (BoostSpec bo : bu.boosters().all()) {
/* 198 */         TRADABLE resource = RD.OUTPUT().fromBoost(bo.boostable);
/* 199 */         if (resource != null) {
/* 200 */           double m = BUtil.value((LIST)bu.baseFactors, reg);
/*     */           
/* 202 */           double v = bo.booster.max() * m * FACTIONS.PRICE().get(resource);
/* 203 */           if (v > ma) {
/* 204 */             ma = v;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 210 */     value += 80.0D * ma * (0.05D + RD.RACES().popSizeD(reg));
/*     */     
/* 212 */     return value;
/*     */   }
/*     */   
/*     */   private void init() {
/* 216 */     for (int i = 0; i < this.giver.realm().regions(); i++) {
/* 217 */       this.data.canSelect.set(this.giver.realm().region(i).index(), false);
/*     */     }
/*     */     
/* 220 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(this.reciever.capitolRegion(), this.itreaty, this.sel))
/* 221 */       this.data.canSelect.set(d.reg.index(), true); 
/*     */   }
/*     */   
/*     */   DealRegs(Deal deal, RegData data) {
/* 225 */     this.itreaty = new WRegFinder.Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */         {
/* 229 */           if (to == null)
/* 230 */             return true; 
/* 231 */           if (prevReg == null)
/* 232 */             return false; 
/* 233 */           if (prevReg.faction() == DealRegs.this.reciever)
/* 234 */             return true; 
/* 235 */           if (prevReg == to)
/* 236 */             return true; 
/* 237 */           return (to.faction() == DealRegs.this.giver && DealRegs.this.data.selected.get(prevReg.index()));
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.all.length; i++)
/*     */       this.all[i] = new DealReg(); 
/*     */     this.data = data;
/*     */     this.deal = deal;
/*     */   }
/*     */   public final class DealReg implements BOOLEAN.BOOLEAN_MUTABLE { public Region reg() {
/* 246 */       return this.reg;
/*     */     }
/*     */     private Region reg;
/*     */     
/*     */     public boolean is() {
/* 251 */       return DealRegs.this.selected(this.reg);
/*     */     }
/*     */ 
/*     */     
/*     */     public BOOLEAN.BOOLEAN_MUTABLE set(boolean b) {
/* 256 */       DealRegs.this.data.selected.set(this.reg.index(), b);
/* 257 */       DealRegs.this.dirty = true;
/* 258 */       return this;
/*     */     }
/*     */     
/*     */     public double value() {
/* 262 */       if (DealRegs.this.reciever instanceof FactionNPC && this.reg.faction() == FACTIONS.player() && DIP.WAR().is((FactionNPC)DealRegs.this.reciever) && !DealRegs.this.deal.bools.PEACE.is())
/* 263 */         return 0.0D; 
/* 264 */       return DealRegs.this.data.values[this.reg.index()];
/*     */     }
/*     */     
/*     */     public boolean canSelect() {
/* 268 */       if (DealRegs.this.deal.bools.ABSORB.is())
/* 269 */         return false; 
/* 270 */       return DealRegs.this.data.canSelect.get(this.reg.index());
/*     */     } }
/*     */ 
/*     */   
/*     */   public int selfWorth() {
/* 275 */     return this.selfWorth;
/*     */   }
/*     */   
/*     */   public int offerableWorth() {
/* 279 */     return this.offerableWorth;
/*     */   }
/*     */   
/*     */   public LIST<DealReg> all() {
/* 283 */     if (this.dirty) {
/* 284 */       init();
/* 285 */       this.dirty = false;
/*     */     } 
/* 287 */     return (LIST<DealReg>)this.tmp;
/*     */   }
/*     */   
/*     */   public void clear() {
/* 291 */     init();
/*     */   }
/*     */   
/*     */   public double worth() {
/* 295 */     double v = 0.0D;
/* 296 */     for (DealReg r : all()) {
/* 297 */       if (r.is())
/* 298 */         v += r.value(); 
/*     */     } 
/* 300 */     return v;
/*     */   }
/*     */   
/*     */   public void add(Region reg) {
/* 304 */     this.data.selected.set(reg.index(), true);
/* 305 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public void select(Region reg, boolean sel) {
/* 309 */     this.data.selected.set(reg.index(), sel);
/* 310 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   public boolean selected(Region reg) {
/* 314 */     if (this.deal.bools.ABSORB.is())
/* 315 */       return false; 
/* 316 */     return this.data.selected.get(reg.index());
/*     */   }
/*     */   
/*     */   public boolean selecteCan(Region reg) {
/* 320 */     return this.data.canSelect.get(reg.index());
/*     */   }
/*     */   
/*     */   public int value(Region reg) {
/* 324 */     if (this.reciever instanceof FactionNPC && reg.faction() == FACTIONS.player() && DIP.WAR().is((FactionNPC)this.reciever) && !this.deal.bools.PEACE.is())
/* 325 */       return 0; 
/* 326 */     return this.data.values[reg.index()];
/*     */   }
/*     */   static class RegData { private final Bitmap1D selected;
/*     */     
/*     */     RegData() {
/* 331 */       this.selected = new Bitmap1D(1023, false);
/* 332 */       this.canSelect = new Bitmap1D(1023, false);
/* 333 */       this.values = Alloc.ii(1023);
/*     */     }
/*     */     
/*     */     private final Bitmap1D canSelect;
/*     */     private final int[] values; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealRegs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
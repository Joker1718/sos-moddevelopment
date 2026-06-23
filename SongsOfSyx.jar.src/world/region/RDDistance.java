/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoostableCat;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.BOOLEANO;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RDDistance
/*     */ {
/*  41 */   private static CharSequence ¤¤Name = "¤Proximity";
/*  42 */   private static CharSequence ¤¤NameD = "¤Proximity is the physical distance from a region to your capital. It determines the amount tribute you receive from it and the loyalty of its subjects.";
/*     */   
/*  44 */   private static CharSequence ¤¤Distance = "¤Distance";
/*  45 */   private static CharSequence ¤¤DistanceD = "¤Distance to your capital. Distance affect trade prices.";
/*     */   
/*  47 */   private static CharSequence ¤¤Borders = "¤Borders";
/*  48 */   private static CharSequence ¤¤Reachable = "¤Reachable";
/*     */   
/*     */   private final INT_O.INT_OE<Region> distance;
/*     */   
/*     */   private final INT_O.INT_OE<Faction> factionBorders;
/*     */   private final INT_O.INT_OE<Faction> factionReachable;
/*     */   private final INT_O.INT_OE<Faction> factionBorderThroughAlly;
/*     */   private final INT_O.INT_OE<Region> regionBorders;
/*     */   private final INT_O.INT_OE<Region> regionReachable;
/*     */   public final Boostable bProximity;
/*     */   public final Boostable bProximityToll;
/*  59 */   private final ArrayList<FactionNPC> borders = new ArrayList(FACTIONS.MAX());
/*     */   
/*     */   private boolean bDirty = true;
/*  62 */   private int[] dists = Alloc.ii(FACTIONS.MAX());
/*     */   
/*     */   static {
/*  65 */     D.ts(RDDistance.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Faction selTradeF;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final WRegSel selTrade;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double distancePenalty(Region reg) {
/* 183 */     double min = 60.0D;
/* 184 */     double half = 150.0D;
/*     */     
/* 186 */     double c = 30.0D;
/* 187 */     double k = 90.0D;
/*     */     
/* 189 */     return CLAMP.d(90.0D / (this.distance.get(reg) + 30.0D), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void init() {
/* 195 */     if (!this.bDirty) {
/*     */       return;
/*     */     }
/* 198 */     Region cap = FACTIONS.player().capitolRegion();
/* 199 */     if (cap == null) {
/*     */       return;
/*     */     }
/* 202 */     WORLD.FOW().setDirty();
/* 203 */     this.bDirty = false;
/*     */     
/* 205 */     for (Region reg : WORLD.REGIONS().all()) {
/* 206 */       this.regionReachable.set(reg, 0);
/* 207 */       this.regionBorders.set(reg, 0);
/* 208 */       this.distance.setD(reg, 0.0D);
/*     */     } 
/* 210 */     for (Faction f : FACTIONS.all()) {
/* 211 */       this.factionReachable.set(f, 0);
/* 212 */       this.factionBorders.set(f, 0);
/* 213 */       this.factionBorderThroughAlly.set(f, 0);
/*     */     } 
/*     */     
/* 216 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(cap, WRegFinder.Treaty.DUMMY, WRegSel.DUMMY())) {
/* 217 */       this.distance.set(d.reg, CLAMP.i(d.distance, 0, this.distance.max(null)));
/*     */     }
/*     */     
/* 220 */     this.borders.clearSloppy();
/* 221 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(cap, WRegFinder.Treaty.FACTION_REACHABLE, WRegSel.DUMMY())) {
/* 222 */       this.distance.set(d.reg, CLAMP.i(d.distance, 0, this.distance.max(null)));
/* 223 */       this.regionReachable.set(d.reg, 1);
/* 224 */       if (d.reg.faction() != null && 
/* 225 */         d.reg.capitol()) {
/* 226 */         this.factionReachable.set(d.reg.faction(), 1);
/* 227 */         if (d.reg.faction() != FACTIONS.player()) {
/* 228 */           this.borders.add(d.reg.faction());
/*     */         }
/*     */       } 
/*     */     } 
/* 232 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(cap, WRegFinder.Treaty.FACTION_CAN_ATTACK, WRegSel.DUMMY())) {
/* 233 */       if (d.reg.faction() != null && 
/* 234 */         d.reg.capitol()) {
/* 235 */         this.factionBorderThroughAlly.set(d.reg.faction(), 1);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 240 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(cap, WRegFinder.Treaty.FACTION_BORDERS, WRegSel.DUMMY())) {
/*     */       
/* 242 */       this.regionBorders.set(d.reg, 1);
/* 243 */       if (d.reg.faction() != null) {
/* 244 */         this.factionBorders.set(d.reg.faction(), 1);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int distance(Faction f) {
/* 251 */     init();
/* 252 */     return this.distance.get(f.capitolRegion());
/*     */   }
/*     */   
/*     */   public final INT_O<Region> distance() {
/* 256 */     init();
/* 257 */     return (INT_O<Region>)this.distance;
/*     */   }
/*     */   
/*     */   public boolean reachable(Region reg) {
/* 261 */     init();
/* 262 */     return (this.regionReachable.get(reg) == 1);
/*     */   }
/*     */   
/*     */   public boolean neighbours(Region reg) {
/* 266 */     init();
/* 267 */     return (this.regionBorders.get(reg) == 1);
/*     */   }
/*     */   
/*     */   public boolean reachable(Faction reg) {
/* 271 */     init();
/* 272 */     return (this.factionReachable.get(reg) == 1);
/*     */   }
/*     */   
/*     */   public boolean factionHasRegionBorderingPlayer(Faction reg) {
/* 276 */     init();
/* 277 */     return (this.factionBorders.get(reg) == 1);
/*     */   }
/*     */   
/*     */   public boolean factionCanAttackPlayerAllies(Faction reg) {
/* 281 */     init();
/* 282 */     return (this.factionBorderThroughAlly.get(reg) == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<WRegFinder.RegDist> tradePartners(Faction start) {
/* 287 */     this.selTradeF = start;
/*     */     
/* 289 */     if (start instanceof FactionNPC) {
/* 290 */       return (WORLD.PATH()).regFinder.all(start.capitolRegion(), WRegFinder.Treaty.FACTION_REACHABLE_NPC_TRADE, this.selTrade);
/*     */     }
/*     */     
/* 293 */     return (WORLD.PATH()).regFinder.all(start.capitolRegion(), WRegFinder.Treaty.FACTION_REACHABLE, this.selTrade);
/*     */   }
/*     */   
/*     */   public LIST<FactionNPC> neighs() {
/* 297 */     init();
/* 298 */     return (LIST<FactionNPC>)this.borders;
/*     */   }
/*     */   
/*     */   public int capitolDist(FactionNPC f) {
/* 302 */     if (this.dists[f.index()] == -1) {
/* 303 */       PathTile d = WORLD.PATH().path(FACTIONS.player().cx(), FACTIONS.player().cy(), f.cx(), f.cy(), WRegFinder.Treaty.DUMMY);
/* 304 */       if (d == null) {
/* 305 */         this.dists[f.index()] = 0;
/*     */       } else {
/* 307 */         this.dists[f.index()] = (int)d.getValue();
/*     */       } 
/*     */     } 
/* 310 */     return this.dists[f.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   RDDistance(RD.RDInit init) {
/* 315 */     this.selTrade = new WRegSel()
/*     */       {
/*     */         
/*     */         public boolean is(Region t)
/*     */         {
/* 320 */           if (t.faction() == null)
/* 321 */             return false; 
/* 322 */           if (!t.capitol())
/* 323 */             return false; 
/* 324 */           if (t.faction() == RDDistance.this.selTradeF)
/* 325 */             return false; 
/* 326 */           if ((DIP.get(RDDistance.this.selTradeF, t.faction())).trades)
/* 327 */             return true; 
/* 328 */           if (RDDistance.this.selTradeF instanceof FactionNPC && t.faction() instanceof FactionNPC)
/* 329 */             return (DIP.get(RDDistance.this.selTradeF, t.faction()) == DIP.NEUTRAL()); 
/* 330 */           return false;
/*     */         }
/*     */       };
/*     */     init.count.getClass();
/*     */     this.distance = (INT_O.INT_OE<Region>)new DataO.DataShort(init.count, "DISTANCE_DATA", ¤¤Distance, ¤¤DistanceD);
/*     */     init.rCount.getClass();
/*     */     this.factionReachable = (INT_O.INT_OE<Faction>)new DataO.DataBit(init.rCount, "DISTANCE_REACHABLE");
/*     */     init.rCount.getClass();
/*     */     this.factionBorders = (INT_O.INT_OE<Faction>)new DataO.DataBit(init.rCount, "DISTANCE_NEIGHBOURS");
/*     */     init.rCount.getClass();
/*     */     this.factionBorderThroughAlly = (INT_O.INT_OE<Faction>)new DataO.DataBit(init.rCount, "DISTANCE_NEIGHBOURS:ALLY");
/*     */     init.count.getClass();
/*     */     this.regionReachable = (INT_O.INT_OE<Region>)new DataO.DataBit(init.count, "REGION_REACHABLE");
/*     */     init.count.getClass();
/*     */     this.regionBorders = (INT_O.INT_OE<Region>)new DataO.DataBit(init.count, "REGION_NEIGHBOURS");
/*     */     Arrays.fill(this.dists, -1);
/*     */     this.bProximity = BOOSTING.push("PROXIMITY", 0.0D, ¤¤Name, ¤¤NameD, (SPRITE)(UI.icons()).s.wheel, (BoostableCat.ALL()).WORLD);
/*     */     this.bProximityToll = BOOSTING.push("PROXIMITY_TOLL", 1.0D, String.valueOf(¤¤Name) + " (" + String.valueOf(¤¤Name) + ")", ¤¤NameD, (SPRITE)(UI.icons()).s.wheel, (BoostableCat.ALL()).WORLD);
/*     */     (new RBooster(new BSourceInfo(Dic.¤¤Distance, (SPRITE)(UI.icons()).s.wheel), 0.0D, 1.0D, false) {
/*     */         public double get(Region t) {
/*     */           return RDDistance.this.distancePenalty(t);
/*     */         }
/*     */       }).add(this.bProximity);
/*     */     BOOSTING.connecter(new ACTION() {
/*     */           public void exe() {
/*     */             RBooster bo = new RBooster(new BSourceInfo(Dic.¤¤Distance, (SPRITE)(UI.icons()).s.wheel), 0.1D, 1.0D, true) {
/*     */                 public double get(Region t) {
/*     */                   if (t.faction() != FACTIONS.player())
/*     */                     return 0.0D; 
/*     */                   return CLAMP.d((RDDistance.null.access$0(RDDistance.null.this)).bProximity.get((BOOSTABLE_O)t), 0.0D, 1.0D);
/*     */                 }
/*     */               };
/*     */             for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/*     */               bo.add(o.boost);
/*     */               bo.add(o.boostYearlyPart);
/*     */             } 
/*     */           }
/*     */         });
/*     */     init.savable.add(new SAVABLE() {
/*     */           public void save(FilePutter file) {}
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*     */             RDDistance.this.bDirty = true;
/*     */           }
/*     */           
/*     */           public void clear() {
/*     */             RDDistance.this.bDirty = true;
/*     */           }
/*     */         });
/*     */     GVALUES.FACTION.push("PLAYER_BORDERS", ¤¤Borders, (SPRITE)(UI.icons()).s.wheel, new BOOLEANO<Faction>() {
/*     */           public boolean is(Faction t) {
/*     */             return RDDistance.this.factionBorders.isMax(t);
/*     */           }
/*     */         });
/*     */     GVALUES.FACTION.push("PLAYER_REACHABLE", ¤¤Reachable, (SPRITE)(UI.icons()).s.wheel, new BOOLEANO<Faction>() {
/*     */           public boolean is(Faction t) {
/*     */             return RDDistance.this.factionReachable.isMax(t);
/*     */           }
/*     */         });
/*     */     GVALUES.REGION.pushI("PLAYER_DISTANCE", ¤¤Distance, (SPRITE)(UI.icons()).s.wheel, (INT_O)this.distance);
/*     */     GVALUES.REGION.push("PLAYER_REACHABLE", ¤¤Reachable, (SPRITE)(UI.icons()).s.wheel, new BOOLEANO<Region>() {
/*     */           public boolean is(Region t) {
/*     */             return RDDistance.this.regionReachable.isMax(t);
/*     */           }
/*     */         });
/*     */     GVALUES.REGION.push("PLAYER_BORDERS", ¤¤Borders, (SPRITE)(UI.icons()).s.wheel, new BOOLEANO<Region>() {
/*     */           public boolean is(Region t) {
/*     */             return RDDistance.this.regionBorders.isMax(t);
/*     */           }
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDDistance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
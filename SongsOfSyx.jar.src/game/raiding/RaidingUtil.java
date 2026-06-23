/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.Config;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public final class RaidingUtil
/*     */ {
/*     */   private final ArrayList<Raider> active;
/*  25 */   private int cp = -1;
/*  26 */   private int weakest = -1;
/*     */ 
/*     */   
/*     */   RaidingUtil(int AMOUNT) {
/*  30 */     this.active = new ArrayList(AMOUNT);
/*     */   }
/*     */ 
/*     */   
/*     */   public int playerPow() {
/*  35 */     if (FACTIONS.player().capitolRegion() == null) {
/*  36 */       return 0;
/*     */     }
/*  38 */     return defences(FACTIONS.player().capitolRegion());
/*     */   }
/*     */ 
/*     */   
/*     */   public int defences(Region reg) {
/*  43 */     double p = (RD.MILITARY()).power.getD(reg);
/*     */     
/*  45 */     if (reg == FACTIONS.player().capitolRegion() && (GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0)
/*  46 */     { p *= 0.25D;
/*  47 */       for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/*  48 */         if (a.faction() == reg.faction())
/*  49 */           p += AD.power().get(a); 
/*     */       }  }
/*  51 */     else { for (WArmy a : FACTIONS.player().armies().all()) {
/*  52 */         if (a.region() != null && a.region().faction() == FACTIONS.player())
/*  53 */           p += AD.power().get(a); 
/*     */       }  }
/*     */     
/*  56 */     return (int)p;
/*     */   }
/*     */   
/*     */   public int ransomCurrent() {
/*  60 */     return (int)((POP.tot(null, null) * (Config.sett()).POP_RAIDER_WORTH + FACTIONS.player().credits().getD() / (Config.sett()).POP_RAIDER_WORTH) / (BOOSTABLES.CIVICS()).RAID_SECURITY.get((BOOSTABLE_O)HCLASS_RACE.clP()));
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE attackSpot(Raider raider) {
/*  65 */     double prob = 0.0D;
/*     */     
/*  67 */     for (RaidingMap.RaidRegion r : (GAME.raiders()).entry.entryRegions()) {
/*  68 */       if (defences(r.r()) < raider.army.power) {
/*  69 */         prob += (r.r().capitol() ? 10 : true);
/*     */       }
/*     */     } 
/*  72 */     prob *= RND.rFloat();
/*  73 */     for (RaidingMap.RaidRegion r : (GAME.raiders()).entry.entryRegions()) {
/*  74 */       if (defences(r.r()) < raider.army.power) {
/*  75 */         prob -= (r.r().capitol() ? 10 : true);
/*  76 */         if (prob <= 0.0D) {
/*  77 */           prob = 0.0D;
/*     */           
/*  79 */           for (RaidingMap.RaidEntryPoint e : (GAME.raiders()).entry.entrySpots()) {
/*  80 */             if (r.r().is(e.c()))
/*  81 */               prob++; 
/*     */           } 
/*  83 */           prob *= RND.rFloat();
/*  84 */           for (RaidingMap.RaidEntryPoint e : (GAME.raiders()).entry.entrySpots()) {
/*  85 */             if (r.r().is(e.c())) {
/*  86 */               prob--;
/*  87 */               if (prob <= 0.0D) {
/*  88 */                 return e.c();
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  95 */     Coo.TMP.set(FACTIONS.player().capitolRegion().cx(), FACTIONS.player().capitolRegion().cy());
/*  96 */     return (COORDINATE)Coo.TMP;
/*     */   }
/*     */   
/*     */   public Region weakestRegion() {
/* 100 */     cache();
/* 101 */     if (this.weakest == -1)
/* 102 */       return null; 
/* 103 */     return (Region)WORLD.REGIONS().all().get(this.cp);
/*     */   }
/*     */   
/*     */   public int weakestRegionPow() {
/* 107 */     Region reg = weakestRegion();
/* 108 */     if (reg == null)
/* 109 */       return 0; 
/* 110 */     return defences(reg);
/*     */   }
/*     */   
/*     */   public LIST<Raider> active() {
/* 114 */     cache();
/* 115 */     return (LIST<Raider>)this.active;
/*     */   }
/*     */   
/*     */   public boolean validCoo(COORDINATE c, Raider raider) {
/* 119 */     Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/* 120 */     if (reg == null || reg.faction() != FACTIONS.player())
/* 121 */       return false; 
/* 122 */     return (defences(reg) <= raider.army.power);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void cache() {
/* 128 */     if (Math.abs(this.cp - GAME.updateI()) < 128) {
/*     */       return;
/*     */     }
/* 131 */     if (this.cp == GAME.updateI())
/*     */       return; 
/* 133 */     this.cp = GAME.updateI();
/* 134 */     this.weakest = -1;
/* 135 */     double power = 8.988465674311579E307D;
/*     */     
/* 137 */     for (RaidingMap.RaidRegion reg : (GAME.raiders()).entry.entryRegions()) {
/* 138 */       if (reg.r().capitol()) {
/*     */         continue;
/*     */       }
/* 141 */       double pow = defences(reg.r());
/* 142 */       if (this.weakest == -1 || pow < power) {
/* 143 */         this.weakest = reg.r().index();
/* 144 */         power = pow;
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     this.active.clearSloppy();
/*     */     
/* 150 */     for (Raider r : GAME.raiders().ALL()) {
/* 151 */       if (!r.defeated && !r.isScared() && r.hasInterrest()) {
/* 152 */         this.active.add(r);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clear() {
/* 158 */     this.cp = -1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
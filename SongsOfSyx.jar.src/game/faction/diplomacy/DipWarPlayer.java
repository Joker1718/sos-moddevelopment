/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FWorth;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.Debugger;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class DipWarPlayer
/*     */ {
/*  29 */   private Bitmap1D bPotential = new Bitmap1D(FACTIONS.MAX(), false);
/*  30 */   private Bitmap1D bWilling = new Bitmap1D(FACTIONS.MAX(), false);
/*  31 */   private Bitmap1D bProxy = new Bitmap1D(FACTIONS.MAX(), false);
/*     */   
/*  33 */   private final ArrayList<FactionNPC> potential = new ArrayList(FACTIONS.MAX());
/*  34 */   private final ArrayList<FactionNPC> willing = new ArrayList(FACTIONS.MAX());
/*  35 */   private final ArrayList<FactionNPC> proxy = new ArrayList(FACTIONS.MAX());
/*  36 */   private final Distress[] distresses = new Distress[FACTIONS.MAX()];
/*  37 */   int upI = -120;
/*     */   
/*     */   private double pPow;
/*     */   
/*     */   private double coalitionPow;
/*  42 */   public final Str warName = new Str(64);
/*  43 */   public final Str teamName = new Str(64);
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
/*     */   private final WRegFinder.Treaty treaty;
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
/*     */   private void init() {
/*  74 */     if (Math.abs(this.upI - GAME.updateI()) < 120) {
/*     */       return;
/*     */     }
/*  77 */     this.upI = GAME.updateI();
/*     */ 
/*     */     
/*  80 */     this.bPotential.clear();
/*  81 */     this.potential.clearSloppy();
/*  82 */     for (FactionNPC ff : FACTIONS.NPCs()) {
/*  83 */       if (validEnemy(ff)) {
/*  84 */         this.bPotential.set(ff.index(), true);
/*  85 */         this.potential.add(ff);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     this.pPow = FACTIONS.player().offensivePower();
/*  94 */     this.coalitionPow = 0.0D;
/*     */     
/*  96 */     this.willing.clearSloppy();
/*     */     
/*  98 */     for (FactionNPC ff : FACTIONS.NPCs()) {
/*  99 */       if (validEnemy(ff)) {
/* 100 */         this.coalitionPow += AD.power().get((Faction)ff);
/* 101 */         this.willing.add(ff);
/* 102 */         this.bPotential.set(ff.index(), true);
/* 103 */         this.potential.add(ff); continue;
/* 104 */       }  if (DIP.WAR().is(ff)) {
/* 105 */         this.coalitionPow += AD.power().get((Faction)ff); continue;
/* 106 */       }  if (DIP.ALLY().is(ff)) {
/* 107 */         this.pPow += AD.power().get((Faction)ff);
/*     */       }
/*     */     } 
/* 110 */     boolean recalc = true;
/* 111 */     while (recalc) {
/* 112 */       recalc = false;
/* 113 */       double advantage = this.coalitionPow / this.pPow - 1.0D;
/* 114 */       if (advantage < 0.0D) {
/* 115 */         this.willing.clearSloppy();
/*     */         break;
/*     */       } 
/* 118 */       for (int i = this.willing.size() - 1; i >= 0; i--) {
/* 119 */         FactionNPC f = (FactionNPC)this.willing.get(i);
/* 120 */         if (ROPINION.trust().get(f) > advantage + distress((Faction)f)) {
/* 121 */           double pow = f.offensivePower();
/* 122 */           this.coalitionPow -= pow;
/* 123 */           if ((DIP.get(f)).ally) {
/* 124 */             this.pPow += pow;
/*     */           }
/* 126 */           recalc = true;
/* 127 */           this.willing.remove(i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 132 */     this.bWilling.clear();
/* 133 */     for (FactionNPC f : this.willing) {
/* 134 */       this.bWilling.set(f.index(), true);
/*     */     }
/*     */ 
/*     */     
/* 138 */     LIST<WRegFinder.RegDist> proxies = (WORLD.PATH()).regFinder.all((Faction)FACTIONS.player(), this.treaty, WRegSel.DUMMY());
/* 139 */     this.bProxy.clear();
/* 140 */     this.proxy.clearSloppy();
/* 141 */     for (WRegFinder.RegDist r : proxies) {
/* 142 */       Faction faction; if (r.reg.faction() != null && !this.bProxy.get(r.reg.faction().index()) && faction = r.reg.faction() instanceof FactionNPC) { FactionNPC f = (FactionNPC)faction;
/* 143 */         if (validProxy(f)) {
/* 144 */           this.proxy.add(f);
/*     */         } }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LIST<FactionNPC> potential() {
/* 155 */     init();
/* 156 */     return (LIST<FactionNPC>)this.potential;
/*     */   }
/*     */   
/*     */   public LIST<FactionNPC> willing() {
/* 160 */     init();
/* 161 */     return (LIST<FactionNPC>)this.willing;
/*     */   }
/*     */   
/*     */   public LIST<FactionNPC> proxy() {
/* 165 */     init();
/* 166 */     return (LIST<FactionNPC>)this.proxy;
/*     */   }
/*     */   
/*     */   public boolean potential(FactionNPC f) {
/* 170 */     init();
/* 171 */     return this.bPotential.get(f.index());
/*     */   }
/*     */   
/*     */   public boolean willing(FactionNPC f) {
/* 175 */     init();
/* 176 */     return this.bWilling.get(f.index());
/*     */   }
/*     */   
/*     */   public boolean proxy(FactionNPC f) {
/* 180 */     init();
/* 181 */     return this.bProxy.get(f.index());
/*     */   }
/*     */   
/*     */   public double coalitionPower() {
/* 185 */     init();
/* 186 */     return this.coalitionPow;
/*     */   }
/*     */   
/*     */   public double playerPower() {
/* 190 */     init();
/* 191 */     return this.pPow;
/*     */   }
/*     */   
/*     */   public double coalitionAdvantage() {
/* 195 */     return CLAMP.d(coalitionPower() / (playerPower() + coalitionPower() + 1.0D) * 0.5D - 0.25D + distress((Faction)FACTIONS.player()), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean validEnemy(FactionNPC f) {
/* 200 */     if (DIP.WAR().is(f)) {
/* 201 */       return false;
/*     */     }
/* 203 */     if (ROPINION.trust().get(f) >= 1.0D) {
/* 204 */       return false;
/*     */     }
/* 206 */     if (DIP.secondSinceStance(f) < (TIME.secondsPerDay() / 2)) {
/* 207 */       return false;
/*     */     }
/* 209 */     if (RD.DIST().factionCanAttackPlayerAllies((Faction)f))
/* 210 */       return true; 
/* 211 */     for (int ai = 0; ai < FACTIONS.player().armies().all().size(); ai++) {
/* 212 */       WArmy a = (WArmy)FACTIONS.player().armies().all().get(ai);
/* 213 */       if (a.region() != null && a.region().faction() == f)
/* 214 */         return true; 
/*     */     } 
/* 216 */     return false;
/*     */   }
/*     */   DipWarPlayer() {
/* 219 */     this.treaty = new WRegFinder.Treaty()
/*     */       {
/*     */         public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist)
/*     */         {
/* 223 */           if (prevReg == null)
/* 224 */             return true; 
/* 225 */           if (prevReg.faction() == null)
/* 226 */             return false; 
/* 227 */           if (prevReg.faction() == FACTIONS.player())
/* 228 */             return true;  Faction faction;
/* 229 */           if (faction = prevReg.faction() instanceof FactionNPC) { FactionNPC f = (FactionNPC)faction;
/* 230 */             if (DIP.WAR().is(f))
/* 231 */               return true; 
/* 232 */             return (prevReg == to); }
/*     */           
/* 234 */           return false;
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.distresses.length; i++)
/*     */       this.distresses[i] = new Distress(); 
/*     */   }
/*     */   private boolean validProxy(FactionNPC f) {
/* 241 */     if (RD.DIST().factionCanAttackPlayerAllies((Faction)f)) {
/* 242 */       return false;
/*     */     }
/* 244 */     if (DIP.WAR().is(f)) {
/* 245 */       return false;
/*     */     }
/* 247 */     if ((BOOSTABLES.CIVICS()).TRUST.get((BOOSTABLE_O)f) >= 1.0D) {
/* 248 */       return false;
/*     */     }
/* 250 */     if (DIP.secondSinceStance(f) < (TIME.secondsPerDay() / 2)) {
/* 251 */       return false;
/*     */     }
/* 253 */     return true;
/*     */   }
/*     */   
/*     */   public double distress(Faction f) {
/* 257 */     Distress d = this.distresses[f.index()];
/* 258 */     if (Math.abs(d.upI - GAME.updateI()) < 120) {
/* 259 */       return d.distress;
/*     */     }
/* 261 */     d.upI = GAME.updateI();
/*     */     
/* 263 */     double valueTot = 0.0D;
/* 264 */     double threatened = 0.0D;
/* 265 */     double capitol = 0.0D;
/*     */     
/* 267 */     for (int ri = 0; ri < f.realm().all().size(); ri++) {
/* 268 */       Region reg = (Region)f.realm().all().get(ri);
/* 269 */       valueTot += FWorth.region(reg);
/* 270 */       double def = (RD.MILITARY()).power.getD(reg);
/* 271 */       if (f == FACTIONS.player() && reg.capitol()) {
/* 272 */         def -= SETT.INVADOR().invadingPower();
/*     */       }
/*     */       
/* 275 */       def = Math.max(def, 0.0D);
/*     */       
/* 277 */       double att = 0.0D;
/*     */       
/* 279 */       for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/*     */         
/* 281 */         if (a.faction() != null) {
/* 282 */           if (a.faction() == f || DIP.ALLY().is(f, a.faction())) {
/* 283 */             def += AD.power().get(a); continue;
/* 284 */           }  if (DIP.WAR().is(a.faction(), f)) {
/* 285 */             att = AD.power().get(a);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 290 */       double am = (att + 1.0D) / (def + 1.0D) - 1.0D;
/*     */       
/* 292 */       if (am > 0.0D) {
/*     */         
/* 294 */         if (reg.capitol()) {
/* 295 */           capitol = reg.besieged() ? 1.0D : 0.2D;
/*     */         }
/* 297 */         threatened += FWorth.region(reg);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 302 */     threatened += valueTot * capitol;
/*     */     
/* 304 */     d.distress = 2.0D * threatened / valueTot;
/* 305 */     return d.distress;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Debugger d, FactionNPC f) {
/* 311 */     d.title(DipWarPlayer.class.getSimpleName());
/* 312 */     d.debug("potential").add(potential(f));
/* 313 */     d.debug("willing").add(validEnemy(f));
/* 314 */     d.debug("proxy").add(validProxy(f));
/* 315 */     d.debug("distress").add(distress((Faction)f));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void debug(Debugger d) {
/* 321 */     d.title(DipWarPlayer.class.getSimpleName());
/*     */ 
/*     */     
/* 324 */     d.debug("player Pow").add(playerPower());
/* 325 */     d.debug("enemy pow").add(coalitionPower());
/* 326 */     d.debug("distress player").add(distress((Faction)FACTIONS.player()));
/* 327 */     d.debug("col advantage").add(coalitionAdvantage());
/*     */     
/* 329 */     for (FactionNPC f : willing()) {
/* 330 */       d.debug("willing").add((CharSequence)f.name).s().add(ROPINION.trust().get(f)).s().add(distress((Faction)f));
/*     */     }
/*     */     
/* 333 */     for (FactionNPC f : proxy())
/* 334 */       d.debug("proxy").add((CharSequence)f.name).s().add(distress((Faction)f)); 
/*     */   }
/*     */   
/*     */   private class Distress { int upI;
/*     */     double distress;
/*     */     
/*     */     private Distress() {
/* 341 */       this.upI = -120;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DipWarPlayer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
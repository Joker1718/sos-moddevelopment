/*     */ package game.raiding;
/*     */ import game.GAME;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.battle.invasion.InvasionListener;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.battle.BattleListener;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class RaidingCurrent implements SAVABLE {
/*     */   private Raider raider;
/*     */   private int currentArmy;
/*     */   private int ai;
/*     */   
/*     */   private enum STATE {
/*  31 */     WARNING, ALLY_HELP, WARNING_REJECTED, ARMY, INVADING, DEFEATED, VICTORY, STRANGENESS, ALLY_FIGHT, APPEAR_REGION;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  37 */   private double timer = 0.0D;
/*     */   private STATE state;
/*     */   private int invadeRef;
/*     */   int iterration;
/*  41 */   private Coo appearCoo = new Coo();
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  45 */     if (current() != null) {
/*  46 */       file.bool(true);
/*  47 */       file.object(this.raider);
/*  48 */       file.i(this.currentArmy);
/*  49 */       file.i(this.ai);
/*  50 */       file.d(this.timer);
/*  51 */       file.i(this.state.ordinal());
/*  52 */       file.i(this.invadeRef);
/*  53 */       file.i(this.iterration);
/*  54 */       this.appearCoo.save(file);
/*     */     } else {
/*  56 */       file.bool(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  62 */     if (file.bool()) {
/*  63 */       this.raider = (Raider)file.object(true);
/*  64 */       this.currentArmy = file.i();
/*  65 */       this.ai = file.i();
/*  66 */       this.timer = file.d();
/*  67 */       this.state = STATE.values()[file.i()];
/*  68 */       this.invadeRef = file.i();
/*  69 */       this.iterration = file.i();
/*  70 */       this.appearCoo.load(file);
/*     */     } else {
/*  72 */       this.raider = null;
/*     */     } 
/*  74 */     if (this.raider == null) {
/*  75 */       clear();
/*     */     }
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
/*     */   public RaidingCurrent() {
/* 146 */     IDebugPanel.add("RAIDER next step", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 150 */             RaidingCurrent.this.timer += (TIME.secondsPerDay() * 10);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public Raider current() {
/* 157 */     return this.raider;
/*     */   }
/*     */   
/*     */   public WArmy army() {
/* 161 */     if (this.raider == null)
/* 162 */       return null; 
/* 163 */     if (this.currentArmy == -1)
/* 164 */       return null; 
/* 165 */     WArmy a = (WORLD.ENTITIES()).armies.tryGet(this.currentArmy);
/* 166 */     if (a != null && a.added() && a.iteration() == this.ai) {
/* 167 */       return a;
/*     */     }
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(Raider raider, STATE state, WArmy a) {
/* 174 */     if (this.raider != raider) {
/* 175 */       this.iterration++;
/* 176 */       raider.raids++;
/*     */     } 
/*     */     
/* 179 */     this.timer = 0.0D;
/* 180 */     this.raider = raider;
/* 181 */     this.state = state;
/* 182 */     if (a != null) {
/* 183 */       this.currentArmy = a.armyIndex();
/* 184 */       this.ai = a.iteration();
/*     */     } else {
/* 186 */       this.currentArmy = -1;
/* 187 */       this.ai = -1;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 193 */     if (this.raider != null) {
/* 194 */       if (this.state == STATE.INVADING) {
/* 195 */         SETT.INVADOR().cancel(this.invadeRef);
/*     */       }
/* 197 */       WArmy a = army();
/* 198 */       if (a != null)
/* 199 */         a.disband(); 
/*     */     } 
/* 201 */     this.raider = null;
/* 202 */     this.timer = 0.0D;
/* 203 */     this.currentArmy = -1;
/*     */   }
/*     */   
/*     */   public void raid(Raider raider) {
/* 207 */     clear();
/*     */     
/* 209 */     COORDINATE c = (GAME.raiders()).util.attackSpot(raider);
/* 210 */     if (c == null) {
/* 211 */       LOG.ln("no spots");
/*     */       
/*     */       return;
/*     */     } 
/* 215 */     this.appearCoo.set(c);
/*     */     
/* 217 */     FactionNPC fa = RaidingMap.passThroughFaction(c);
/*     */     
/* 219 */     if (fa != null) {
/* 220 */       set(raider, STATE.ALLY_HELP, null);
/* 221 */       MessAlly.help(raider, fa);
/*     */       
/*     */       return;
/*     */     } 
/* 225 */     set(raider, STATE.WARNING, null);
/* 226 */     (new MessDemand(raider)).send();
/*     */   }
/*     */   
/*     */   public void raid(Raider raider, CharSequence text) {
/* 230 */     clear();
/*     */     
/* 232 */     COORDINATE c = (GAME.raiders()).util.attackSpot(raider);
/* 233 */     this.appearCoo.set(c);
/*     */     
/* 235 */     set(raider, STATE.WARNING_REJECTED, null);
/* 236 */     if (text == null) {
/* 237 */       (new MessCustom(raider, String.valueOf(text))).send();
/*     */     }
/*     */   }
/*     */   
/*     */   boolean appear(Raider raider) {
/* 242 */     COORDINATE c = (GAME.raiders()).util.attackSpot(raider);
/* 243 */     if (c == null) {
/* 244 */       return false;
/*     */     }
/* 246 */     Region reg = (Region)(WORLD.REGIONS()).map.get(c);
/*     */     
/* 248 */     if (reg == null || reg.faction() != FACTIONS.player()) {
/* 249 */       return false;
/*     */     }
/*     */     
/* 252 */     appear(raider, c.x(), c.y());
/* 253 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean appear(Raider raider, int wx, int wy) {
/* 260 */     if (this.raider != raider) {
/* 261 */       this.iterration++;
/*     */     }
/* 263 */     this.raider = raider;
/* 264 */     clear();
/* 265 */     Region reg = (Region)(WORLD.REGIONS()).map.get(wx, wy);
/* 266 */     if (reg == null || !isValid(wx, wy) || reg.capitol()) {
/* 267 */       this.invadeRef = raider.army.invade(wx, wy, raider.indu);
/* 268 */       set(raider, STATE.INVADING, null);
/*     */     } else {
/*     */       
/* 271 */       WArmy a = raider.army.spawn(wx, wy, raider.name);
/* 272 */       set(raider, STATE.ARMY, a);
/* 273 */       (new MessArmyAppear(raider, wx, wy)).send();
/*     */     } 
/*     */ 
/*     */     
/* 277 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isValid(int wx, int wy) {
/* 282 */     Region reg = (Region)(WORLD.REGIONS()).map.get(wx, wy);
/* 283 */     if (reg == null)
/* 284 */       return false; 
/* 285 */     if (reg.faction() != FACTIONS.player())
/* 286 */       return false; 
/* 287 */     return true;
/*     */   }
/*     */   protected void update(double ds, Profiler prof) {
/*     */     FactionNPC f;
/* 291 */     if (this.raider == null) {
/*     */       return;
/*     */     }
/*     */     
/* 295 */     this.timer += ds;
/* 296 */     switch (this.state) {
/*     */       case ALLY_HELP:
/* 298 */         if (this.timer > TIME.secondsPerDay()) {
/* 299 */           FactionNPC factionNPC = RaidingMap.passThroughFaction((COORDINATE)this.appearCoo);
/* 300 */           if (factionNPC == null) {
/* 301 */             set(this.raider, STATE.WARNING_REJECTED, null);
/* 302 */             (new MessDemandRejected(this.raider)).send();
/* 303 */           } else if ((TIME.days().bitCurrent() & 0x2) == 1 || !(GAME.raiders()).util.validCoo((COORDINATE)this.appearCoo, this.raider)) {
/* 304 */             MessAlly.fight(this.raider, factionNPC);
/* 305 */             clear();
/*     */           } else {
/* 307 */             MessAlly.letThrough(this.raider, factionNPC);
/* 308 */             set(this.raider, STATE.WARNING_REJECTED, null);
/* 309 */             this.timer -= 120.0D;
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       case null:
/* 314 */         f = RaidingMap.passThroughFaction((COORDINATE)this.appearCoo);
/* 315 */         if (f == null) {
/* 316 */           set(this.raider, STATE.WARNING_REJECTED, null);
/* 317 */           (new MessDemandRejected(this.raider)).send();
/*     */         } 
/* 319 */         if (this.timer > (TIME.secondsPerDay() / 2)) {
/* 320 */           MessAlly.fight(this.raider, f);
/* 321 */           clear();
/*     */         } 
/*     */         return;
/*     */       case WARNING:
/* 325 */         if (this.timer > TIME.secondsPerDay()) {
/* 326 */           set(this.raider, STATE.WARNING_REJECTED, null);
/* 327 */           (new MessDemandRejected(this.raider)).send();
/*     */         } 
/*     */         return;
/*     */       case WARNING_REJECTED:
/* 331 */         if (this.timer > 30.0D) {
/*     */           
/* 333 */           Region reg = (Region)(WORLD.REGIONS()).map.get(this.appearCoo.x(), this.appearCoo.y());
/* 334 */           if (reg == null || !isValid(this.appearCoo.x(), this.appearCoo.y()) || reg.capitol()) {
/* 335 */             this.invadeRef = this.raider.army.invade(this.appearCoo.x(), this.appearCoo.y(), this.raider.indu);
/* 336 */             set(this.raider, STATE.INVADING, null);
/*     */           } else {
/* 338 */             set(this.raider, STATE.APPEAR_REGION, null);
/* 339 */             (new MessArmySpotted(this.raider, this.appearCoo.x(), this.appearCoo.y())).send();
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       case APPEAR_REGION:
/* 344 */         if (this.timer > (TIME.secondsPerDay() * 3)) {
/* 345 */           appear(this.raider, this.appearCoo.x(), this.appearCoo.y());
/*     */         }
/*     */         return;
/*     */       
/*     */       case ARMY:
/* 350 */         if (army() == null) {
/* 351 */           (new MessGoingAway(this.raider)).send();
/* 352 */           clear();
/*     */         } else {
/*     */           
/* 355 */           WArmy a = army();
/* 356 */           if (a == null) {
/* 357 */             (new MessGoingAway(this.raider)).send();
/* 358 */             clear();
/*     */           } else {
/*     */             
/* 361 */             AD.updateArmy(army());
/* 362 */             if (a.state() == WArmyState.fortifying || a.state() == WArmyState.fortified)
/*     */             
/* 364 */             { if (this.timer > 240.0D) {
/* 365 */                 (new MessGoingAway(this.raider)).send();
/* 366 */                 clear();
/*     */               }  }
/*     */             else
/* 369 */             { this.timer = 0.0D; } 
/*     */           } 
/*     */         }  return;
/*     */       case DEFEATED:
/* 373 */         if (this.timer > 20.0D) {
/* 374 */           GAME.raiders().defeat(this.raider);
/* 375 */           (new MessDefeated(this.raider)).send();
/* 376 */           clear();
/*     */         } 
/*     */         return;
/*     */       case INVADING:
/* 380 */         if (!SETT.INVADOR().invading()) {
/*     */           
/* 382 */           (new MessGoingAway(this.raider)).send();
/* 383 */           clear();
/*     */         } 
/*     */         return;
/*     */       case STRANGENESS:
/* 387 */         if (this.timer > 20.0D) {
/* 388 */           (new MessGoingAway(this.raider)).send();
/* 389 */           clear();
/*     */         } 
/*     */         return;
/*     */       case VICTORY:
/* 393 */         if (this.timer > 20.0D) {
/* 394 */           this.raider.hasAttacked = true;
/* 395 */           (new MessVictory(this.raider)).send();
/* 396 */           clear();
/*     */         } 
/*     */         return;
/*     */     } 
/* 400 */     this.raider = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean canPay(int iteration) {
/* 408 */     return (this.raider != null && (this.state == STATE.WARNING || this.state == STATE.ALLY_HELP));
/*     */   }
/*     */   
/*     */   void setAllyFight() {
/* 412 */     if (this.raider != null && (this.state == STATE.WARNING || this.state == STATE.ALLY_HELP))
/* 413 */       set(this.raider, STATE.ALLY_FIGHT, null); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingCurrent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
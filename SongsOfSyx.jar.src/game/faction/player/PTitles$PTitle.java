/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.value.GVALUES;
/*     */ import init.value.Lockable;
/*     */ import init.value.Lockers;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.info.INFO;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PTitle
/*     */   extends INFO
/*     */   implements INDEXED
/*     */ {
/* 374 */   private double timer = 0.0D;
/*     */   
/*     */   private final int index;
/*     */   public final Lockers lockers;
/*     */   public final Lockable<Faction> lockable;
/*     */   public final BoostSpecs boosters;
/*     */   public final SPRITE icon;
/*     */   private final String key;
/*     */   private boolean selected;
/*     */   private boolean isNew;
/*     */   private boolean unlocked;
/* 385 */   private boolean[] races = new boolean[RACES.all().size()];
/* 386 */   private double raceValue = 0.0D;
/*     */   
/*     */   PTitle(String key, LISTE<PTitle> all, Json jdata, Json jtext, PTitles.IconMaker iconM) throws IOException {
/* 389 */     super(jtext);
/* 390 */     this.key = key;
/* 391 */     this.index = all.add(this);
/*     */     
/* 393 */     this.lockable = GVALUES.FACTION.LOCK.push();
/* 394 */     this.lockable.push(jdata);
/* 395 */     this.icon = iconM.get(jdata);
/* 396 */     this.lockers = new Lockers(String.valueOf(PTitles.¤¤name) + ": " + String.valueOf(PTitles.¤¤name), (SPRITE)(UI.icons()).s.chevron(DIR.N));
/* 397 */     this.lockers.add(GVALUES.FACTION, jdata, new DOUBLE_O<Faction>()
/*     */         {
/*     */           public double getD(Faction t)
/*     */           {
/* 401 */             if (t == FACTIONS.player()) {
/* 402 */               return (PTitles.PTitle.this.selected ? true : false);
/*     */             }
/* 404 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 409 */     this.lockers.add(GVALUES.INDU, jdata, new DOUBLE_O<Induvidual>()
/*     */         {
/*     */           public double getD(Induvidual t)
/*     */           {
/* 413 */             if (t.faction() == FACTIONS.player()) {
/* 414 */               return (PTitles.PTitle.this.selected ? true : false);
/*     */             }
/* 416 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 421 */     this.lockers.add(GVALUES.REGION, jdata, new DOUBLE_O<Region>()
/*     */         {
/*     */           public double getD(Region t)
/*     */           {
/* 425 */             if (t.faction() == FACTIONS.player()) {
/* 426 */               return (PTitles.PTitle.this.selected ? true : false);
/*     */             }
/* 428 */             return 1.0D;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 433 */     this.boosters = new BoostSpecs(this.name, (SPRITE)(UI.icons()).s.chevron(DIR.N), false);
/* 434 */     this.boosters.read(jdata, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 439 */     return this.index;
/*     */   }
/*     */   
/*     */   public void select(boolean s) {
/* 443 */     if (s == this.selected)
/*     */       return; 
/* 445 */     this.selected = s;
/* 446 */     (FACTIONS.player()).titles.bos.clearChache();
/*     */   }
/*     */   
/*     */   public boolean selected() {
/* 450 */     return this.selected;
/*     */   }
/*     */   
/*     */   private boolean unlockable() {
/* 454 */     return this.lockable.passes(FACTIONS.player());
/*     */   }
/*     */   
/*     */   public boolean unlocked() {
/* 458 */     return !(!this.unlocked && !unlockable());
/*     */   }
/*     */   
/*     */   public boolean isNew() {
/* 462 */     return this.isNew;
/*     */   }
/*     */   
/*     */   public void consumeNew() {
/* 466 */     this.isNew = false;
/*     */   }
/*     */   
/*     */   public boolean race(Race r) {
/* 470 */     return this.races[r.index()];
/*     */   }
/*     */   
/*     */   public double boosterValue() {
/* 474 */     if (this.unlocked || this.selected)
/* 475 */       return 0.5D + 0.5D * this.raceValue / RACES.playable().size(); 
/* 476 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTitles$PTitle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
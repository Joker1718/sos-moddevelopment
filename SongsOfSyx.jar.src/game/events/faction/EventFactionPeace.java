/*     */ package game.events.faction;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ public class EventFactionPeace
/*     */   extends EVENTS.EventResource
/*     */ {
/*  19 */   private double[] secondWhenWarEnds = new double[FACTIONS.MAX()];
/*     */   private final IUpdater updater;
/*     */   
/*     */   EventFactionPeace() {
/*  23 */     super("FACTION_PEACE");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  46 */     this.updater = new IUpdater(FACTIONS.MAX(), (TIME.secondsPerDay() / 2))
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  50 */           Faction f = FACTIONS.getByIndex(i);
/*  51 */           if (f.isActive() && f instanceof FactionNPC) {
/*  52 */             EventFactionPeace.this.up((FactionNPC)f);
/*     */           }
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void update(double ds) {
/*  59 */     this.updater.update(ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void up(FactionNPC f) {
/*  65 */     if (DIP.WAR().all((Faction)f).size() == 0) {
/*     */       return;
/*     */     }
/*  68 */     if (DIP.WAR().is(f)) {
/*     */       return;
/*     */     }
/*     */     
/*  72 */     if (DIP.ALLY().is(f)) {
/*     */       return;
/*     */     }
/*  75 */     if (TIME.playedGame() > this.secondWhenWarEnds[f.index()]) {
/*  76 */       this.secondWhenWarEnds[f.index()] = peaceTime() / 2.0D;
/*  77 */       Faction e = (Faction)DIP.WAR().all((Faction)f).rnd();
/*  78 */       if (e == null) {
/*     */         return;
/*     */       }
/*  81 */       if (e == FACTIONS.player()) {
/*     */         return;
/*     */       }
/*  84 */       if (DIP.WAR().is((FactionNPC)e) && DIP.ALLY().is(f)) {
/*     */         return;
/*     */       }
/*  87 */       DIP.NEUTRAL().set((Faction)f, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private double peaceTime() {
/*     */     return TIME.playedGame() + TIME.secondsPerDay() + (RND.rFloat() * TIME.secondsPerDay()) * 32.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  98 */     this.updater.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 103 */     this.updater.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 108 */     this.updater.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionPeace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
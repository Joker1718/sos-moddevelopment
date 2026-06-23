/*     */ package game.events.faction;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EventFactionWar
/*     */   extends EVENTS.EventResource
/*     */ {
/*  25 */   private static final double dtime = (TIME.secondsPerDay() * 16);
/*  26 */   private double timer = dtime;
/*     */   private int nextFaction;
/*     */   
/*     */   EventFactionWar() {
/*  30 */     super("FACTION_WAR");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  36 */     this.timer -= ds * CLAMP.d(FACTIONS.player().realm().regions() / 8.0D, 0.0D, 1.0D);
/*  37 */     if (this.timer > 0.0D) {
/*     */       return;
/*     */     }
/*  40 */     FactionNPC f = (FactionNPC)FACTIONS.NPCs().getC(this.nextFaction);
/*     */     
/*  42 */     if (f == null) {
/*     */       return;
/*     */     }
/*     */     
/*  46 */     clear();
/*  47 */     this.timer = 16.0D;
/*     */     
/*  49 */     if ((DIP.get(f)).ally)
/*     */       return; 
/*  51 */     if (f.sanctified) {
/*     */       return;
/*     */     }
/*  54 */     if (f != null && f.isActive() && f.capitolRegion() != null && DIP.WAR().all((Faction)f).size() == 0) {
/*     */       
/*  56 */       Faction enemy = null;
/*  57 */       double bestE = 0.0D;
/*     */       
/*  59 */       for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all((Faction)f, WRegFinder.Treaty.FACTION_BORDERS, WRegSel.CAPITOLS())) {
/*  60 */         if (d.reg.faction() == null)
/*     */           continue; 
/*  62 */         if (d.reg.faction() == f || d.reg.faction() == FACTIONS.player())
/*     */           continue; 
/*  64 */         if (FACTIONS.player().realm().regions() < 3 && RD.DIST().reachable(d.reg))
/*     */           continue; 
/*  66 */         FactionNPC ff = (FactionNPC)d.reg.faction();
/*  67 */         if ((DIP.get(ff)).ally)
/*     */           continue; 
/*  69 */         if (ff.sanctified) {
/*     */           continue;
/*     */         }
/*  72 */         double v = 0.0D;
/*     */         
/*  74 */         for (RDRace race : (RD.RACES()).all) {
/*  75 */           v += race.pop.get(d.reg) * race.race.pref().race(f.race());
/*     */         }
/*  77 */         v = 1.0D / v;
/*  78 */         if (v > bestE) {
/*  79 */           enemy = d.reg.faction();
/*  80 */           bestE = v;
/*     */         } 
/*     */       } 
/*     */       
/*  84 */       if (enemy != null) {
/*  85 */         DIP.WAR().set((Faction)f, enemy);
/*  86 */         this.timer += (TIME.secondsPerDay() * 20);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  98 */     file.d(this.timer);
/*  99 */     file.i(this.nextFaction);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 104 */     this.timer = file.d();
/* 105 */     this.nextFaction = file.i();
/* 106 */     this.timer = 16.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 111 */     this.timer = dtime;
/* 112 */     this.nextFaction = RND.rInt();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionWar.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
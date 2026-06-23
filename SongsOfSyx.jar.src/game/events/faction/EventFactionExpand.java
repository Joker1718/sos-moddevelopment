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
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public class EventFactionExpand
/*     */   extends EVENTS.EventResource
/*     */ {
/*  26 */   private static final double dtime = (TIME.secondsPerDay() * 2);
/*  27 */   private double timer = dtime;
/*  28 */   private int nextFaction = RND.rInt(FACTIONS.MAX());
/*     */ 
/*     */   
/*     */   EventFactionExpand() {
/*  32 */     super("FACTION_EXPAND");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  37 */     this.timer -= ds * CLAMP.d(FACTIONS.player().realm().regions() / 8.0D, 0.0D, 1.0D);
/*  38 */     if (this.timer > 0.0D) {
/*     */       return;
/*     */     }
/*  41 */     Faction f = FACTIONS.getByIndex(this.nextFaction);
/*  42 */     if (f != null && f.isActive() && f instanceof FactionNPC) {
/*  43 */       trigger((FactionNPC)f);
/*     */     }
/*     */     
/*  46 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean trigger(FactionNPC f) {
/*  52 */     if (DIP.WAR().all((Faction)f).size() > 0) {
/*  53 */       return false;
/*     */     }
/*  55 */     if (f.sanctified) {
/*  56 */       return false;
/*     */     }
/*  58 */     Region best = null;
/*  59 */     double bv = 0.0D;
/*     */     
/*  61 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all((Faction)f, WRegFinder.Treaty.FACTION_BORDERS, WRegSel.FACTION(null))) {
/*  62 */       if (FACTIONS.player().realm().regions() == 1 && RD.DIST().reachable(d.reg))
/*     */         continue; 
/*  64 */       double v = (RD.OWNER().prevOwner(d.reg) == f) ? 5.0D : 1.0D;
/*  65 */       v /= d.distance;
/*  66 */       if (v > bv) {
/*  67 */         bv = v;
/*  68 */         best = d.reg;
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     if (best == null) {
/*  73 */       return false;
/*     */     }
/*  75 */     for (WArmy a : f.armies().all()) {
/*  76 */       if (AD.power().get(a) > (RD.MILITARY()).power.getD(best) * 1.5D) {
/*  77 */         a.besiege(best);
/*  78 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/*  82 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  88 */     file.d(this.timer);
/*  89 */     file.i(this.nextFaction);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  94 */     this.timer = file.d();
/*  95 */     this.nextFaction = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 100 */     this.timer = RND.rFloat() * dtime;
/* 101 */     this.nextFaction = RND.rInt(FACTIONS.MAX());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionExpand.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
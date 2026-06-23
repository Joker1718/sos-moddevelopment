/*     */ package world.army.ai;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import util.updating.IUpdater;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ import world.entity.army.WArmyState;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ final class War
/*     */   extends IUpdater
/*     */ {
/*  30 */   private final Recruiter recruiter = new Recruiter();
/*  31 */   private final Defender defender = new Defender();
/*  32 */   private final Attacker attacker = new Attacker();
/*  33 */   private final Chiller chiller = new Chiller();
/*     */ 
/*     */   
/*  36 */   private final Bitsmap1D hasSentMessage = new Bitsmap1D(0, 4, FACTIONS.MAX());
/*     */   
/*  38 */   private final ArrayList<WArmy> armies = new ArrayList(32); private Faction allyFaction;
/*     */   private WRegSel ally;
/*     */   
/*  41 */   public War() { super(FACTIONS.MAX(), (TIME.secondsPerDay() / 2));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     this.ally = new WRegSel()
/*     */       {
/*     */         public boolean is(Region t)
/*     */         {
/* 153 */           return (t.faction() == War.this.allyFaction);
/*     */         }
/*     */       }; } protected void update(int i, double timeSinceLast) { Faction f = FACTIONS.getByIndex(i); if (!f.isActive())
/*     */       return;  if (f == FACTIONS.player())
/*     */       return;  this.recruiter.recruit((FactionNPC)f);
/*     */     planForWar(f); } public void save(FilePutter file) { this.hasSentMessage.save(file);
/* 159 */     super.save(file); } public void init(Faction f) { update(f.index(), 0.0D);
/*     */ 
/*     */     
/* 162 */     for (WArmy a : f.armies().all()) {
/* 163 */       for (int i = 0; i < a.divs().size(); i++) {
/* 164 */         a.divs().get(i).menSet(a.divs().get(i).menTarget());
/*     */       }
/*     */       
/* 167 */       for (ADSupply s : (AD.supplies()).all)
/* 168 */         s.current().set(a, s.targetAmount(a)); 
/*     */     }  }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*     */     this.hasSentMessage.load(file);
/*     */     super.load(file);
/*     */   } public void clear() {
/*     */     this.hasSentMessage.clear();
/*     */     super.clear();
/*     */   }
/* 178 */   public static void log(WArmy d, String message) { String s = d.faction().toString() + " " + d.faction().toString() + " " + d.ctx() + ": " + d.cty();
/* 179 */     LOG.ln(s); }
/*     */   void planForWar(Faction f) { if (f == null || !f.isActive()) return;  if (f == FACTIONS.player()) return;  this.armies.clearSloppy(); for (int ai = 0; ai < f.armies().all().size(); ai++) { WArmy a = (WArmy)f.armies().all().get(ai); if (f != FACTIONS.player() && a.raiding() && (RD.DEVASTATION()).current.get(a.region()) > 0.9D) a.stop();  if (AD.men(null).get(a) > 0 && this.armies.hasRoom()) this.armies.add(a);  }  for (WArmy a : this.armies) { if (a.intercepting() != null && !DIP.WAR().is(a.intercepting().faction(), f)) { a.stop(); } else if (a.state() == WArmyState.besieging) { Region reg = a.besieging(); if (reg == null || !DIP.WAR().is(reg.faction(), f)) a.stop();  this.armies.remove(a); }  if ((a.state() == WArmyState.fortified || a.state() == WArmyState.fortifying) && (a.region() == null || (a.region().faction() != f && !DIP.WAR().is(f, a.region().faction())))) { this.allyFaction = f; WRegFinder.RegDist d = (WORLD.PATH()).regFinder.single(a.ctx(), a.cty(), WRegFinder.Treaty.FACTION, this.ally); this.armies.remove(a); if (d != null) { COORDINATE c = WORLD.PATH().rnd(d.reg); a.setDestination(c.x(), c.y()); continue; }  d = (WORLD.PATH()).regFinder.single(a.ctx(), a.cty(), WRegFinder.Treaty.DUMMY, this.ally); if (d != null) { COORDINATE c = WORLD.PATH().rnd(d.reg); a.teleport(c.x(), c.y()); continue; }  a.disband(); }  }  if (DIP.WAR().all(f).size() == 0) { this.chiller.chill(f, this.armies); return; }  if (logging)
/*     */       log(f, "has " + this.armies.size() + " armies to use");  this.defender.defend(f, this.armies); if (logging)
/*     */       log(f, "has " + this.armies.size() + " armies for offence");  this.attacker.attack(f, this.armies); if (logging)
/* 183 */       log(f, "has " + this.armies.size() + " armies without orders");  } static boolean logging = false; public static void log(Faction f, String message) { String s = f.toString() + ": " + f.toString();
/* 184 */     LOG.ln(s); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\War.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ final class UpdaterRegions
/*     */   extends IUpdater
/*     */   implements SAVABLE {
/*  39 */   private static CharSequence ¤¤nameRace = "¤{0} Raiders";
/*  40 */   private static CharSequence ¤¤nameRegion = "¤Raiders of {0}";
/*     */   
/*  42 */   private static CharSequence ¤¤title = "Raiders!";
/*  43 */   private static CharSequence ¤¤desc = "Mi lord, bandits have been spotted raiding our border settlements!";
/*     */   
/*     */   static {
/*  46 */     D.ts(UpdaterRegions.class);
/*     */   }
/*     */   
/*  49 */   private final double[] counts = new double[1023];
/*  50 */   private final double II = 1.0D / TIME.secondsPerDay() * 4.0D;
/*     */   private final ArrayList<RaidingMap.RaidEntryPoint> tmp;
/*     */   public void save(FilePutter file) { file.dsE(this.counts);
/*  53 */     super.save(file); } public UpdaterRegions() { super(1023, TIME.secondsPerDay());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     this.tmp = new ArrayList(16); IDebugPanel.add("Raider region spawn", new ACTION() {
/*     */           public void exe() { if ((GAME.raiders()).entry.entryRegions().size() > 0)
/*     */               UpdaterRegions.this.raid(((RaidingMap.RaidRegion)(GAME.raiders()).entry.entryRegions().rnd()).r());  }
/* 112 */         }); } public void load(FileGetter file) throws IOException { file.dsE(this.counts); super.load(file); } private void raid(Region reg) { if (reg.besieged())
/*     */       return; 
/* 114 */     for (WArmy wArmy : (WORLD.ENTITIES()).armies.fill(reg)) {
/* 115 */       if (wArmy.faction() == null || (wArmy.faction() != FACTIONS.player() && DIP.get(wArmy.faction(), (Faction)FACTIONS.player()) == DIP.WAR())) {
/*     */         return;
/*     */       }
/*     */     } 
/* 119 */     this.tmp.clearSloppy();
/* 120 */     for (RaidingMap.RaidEntryPoint c : (GAME.raiders()).entry.entrySpots()) {
/* 121 */       if (reg.is(c.c()) && this.tmp.hasRoom()) {
/* 122 */         this.tmp.add(c);
/*     */       }
/*     */     } 
/*     */     
/* 126 */     if (this.tmp.size() <= 0) {
/*     */       return;
/*     */     }
/* 129 */     RaidingMap.RaidEntryPoint e = (RaidingMap.RaidEntryPoint)this.tmp.rnd();
/*     */     
/* 131 */     double power = (RD.MILITARY()).power.getD(reg) + 20.0D;
/* 132 */     power += (GAME.raiders()).entry.get(reg).army();
/* 133 */     power *= 1.25D + RND.rExpo() * 2.0D;
/* 134 */     Race race = race(e);
/*     */     
/* 136 */     RaiderArmy a = new RaiderArmy(race, power, 0.2D + RND.rFloat() * 0.5D);
/* 137 */     Str.TMP.clear();
/* 138 */     if (e.from() != null) {
/* 139 */       Str.TMP.add(¤¤nameRegion).insert(0, (CharSequence)(e.from()).info.name());
/*     */     } else {
/* 141 */       Str.TMP.add(¤¤nameRace).insert(0, race.info.namePosessives);
/*     */     } 
/* 143 */     a.spawn(e.c().x(), e.c().y(), (CharSequence)Str.TMP);
/* 144 */     (new M(e.c().x(), e.c().y())).send(); }
/*     */   
/*     */   public void clear() {
/*     */     Arrays.fill(this.counts, 0.0D);
/*     */     super.clear();
/*     */   }
/* 150 */   private Race race(RaidingMap.RaidEntryPoint e) { if (e.from() != null) {
/* 151 */       double d = 0.0D;
/* 152 */       for (RDRace r : (RD.RACES()).all) {
/* 153 */         d += r.pop.get(e.from()) * r.race.physics.raiding;
/*     */       }
/*     */       
/* 156 */       d *= RND.rFloat();
/* 157 */       for (RDRace r : (RD.RACES()).all) {
/* 158 */         d -= r.pop.get(e.from()) * r.race.physics.raiding;
/* 159 */         if (d <= 0.0D) {
/* 160 */           return r.race;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     double tot = 0.0D;
/* 166 */     for (RDRace r : (RD.RACES()).all) {
/* 167 */       tot += r.race.physics.raiding;
/*     */     }
/*     */     
/* 170 */     tot *= RND.rFloat();
/* 171 */     for (RDRace r : (RD.RACES()).all) {
/* 172 */       tot -= r.race.physics.raiding;
/* 173 */       if (tot <= 0.0D) {
/* 174 */         return r.race;
/*     */       }
/*     */     } 
/* 177 */     return ((RDRace)(RD.RACES()).all.rnd()).race; } protected void update(int i, double timeSinceLast) { RaidingMap.RaidRegion r = (GAME.raiders()).entry.get((Region)WORLD.REGIONS().all().get(i)); double d = this.counts[i];
/*     */     if (r.r().faction() != FACTIONS.player() || r.r().capitol()) {
/*     */       d -= timeSinceLast * this.II;
/*     */     } else {
/*     */       double c = 1.0D - r.security();
/*     */       d += timeSinceLast * this.II * CLAMP.d(c, -1.0D, 1.0D);
/*     */       if (d >= 1.0D) {
/*     */         raid(r.r());
/*     */         d -= (int)d;
/*     */       } 
/*     */     } 
/*     */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     this.counts[i] = d; } private static class M extends MessageSection { private static final long serialVersionUID = 1L; private final int x; private final int y;
/* 190 */     public M(int x, int y) { super(UpdaterRegions.¤¤title);
/* 191 */       this.x = x;
/* 192 */       this.y = y; }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 197 */       paragraph(UpdaterRegions.¤¤desc);
/*     */       
/* 199 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 203 */             VIEW.world().activate();
/* 204 */             (VIEW.world()).window.centererTile.set(UpdaterRegions.M.this.x, UpdaterRegions.M.this.y);
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 209 */       section.addRelBody(16, DIR.S, (RENDEROBJ)buttPanel);
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\UpdaterRegions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
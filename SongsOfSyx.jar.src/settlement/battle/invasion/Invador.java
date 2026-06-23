/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.debug.Profiler;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATHS;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.room.military.artillery.ROOM_ARTILLERY;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public final class Invador
/*     */   extends SETT.SettResource
/*     */ {
/*  47 */   private ArrayList<Invasion> active = new ArrayList(16);
/*     */   
/*     */   final Projectile proj;
/*  50 */   private static CharSequence ¤¤inv = "¤Pending Invasion";
/*     */   private int ref;
/*  52 */   static { D.ts(Invador.class); }
/*     */   private void invade(int amount, double quality) { if (this.active.size() == 0) (GAME.ARMIES()).factors.init(GAME.ARMIES().enemy(), 1.0D);  if (!this.active.hasRoom()) return;  int menPerDivision = amount / (Config.battle()).DIVISIONS_PER_ARMY; if (menPerDivision < 50)
/*     */       menPerDivision = 50;  if (amount < menPerDivision)
/*  55 */       menPerDivision = amount;  int divisions = amount / menPerDivision; InvasionSpec sp = new InvasionSpec(); sp.wx = RND.rInt(1000); sp.wy = RND.rInt(1000); Race race = FACTIONS.player().race(); DIV_SETTING.DIV_SETTINGImp spec = new DIV_SETTING.DIV_SETTINGImp(); for (int i = 0; i < divisions; i++) { spec.copySettings((DIV_SETTING)(GAME.battle()).types.rnd(race, (Faction)FACTIONS.player(), RND.rFloat()), menPerDivision, Math.pow(RND.rFloat(), 1.5D), Math.pow(RND.rFloat(), 1.5D)); double experience = quality / 2.0D; sp.add(make(menPerDivision, race, spec, experience)); }  this.active.add(new Invasion(sp)); } public Invador() throws IOException { super("INVADOR", false);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     this.ref = 1; IDebugPanelSett.add("Invade Small", new ACTION() { public void exe() { Invador.this.invade(20, 0.2D); } }
/*     */       ); IDebugPanelSett.add("Invade Medium", new ACTION() { public void exe() { Invador.this.invade(200, 0.2D); } }
/*     */       ); IDebugPanelSett.add("Invade Huge", new ACTION() { public void exe() { Invador.this.invade(2000, 0.2D); } }
/* 197 */       ); this.proj = (Projectile)new Projectile.ProjectileImp(new Json((PATHS.CONFIG()).init.gets("DefaultProjectile")), "_DefaultProjectile"); IDebugPanelSett.add("Invasion Finish", new ACTION() { public void exe() { if (Invador.this.active.size() > 0) ((Invasion)Invador.this.active.get(0)).fastForward();  } }); } public int invade(InvasionSpec spec, WArmy a) { if (spec.divs.size() <= 0) {
/* 198 */       GAME.Notify("nope");
/* 199 */       return -1;
/*     */     } 
/*     */     
/* 202 */     spec.ref = this.ref;
/* 203 */     this.ref++;
/*     */     
/* 205 */     this.active.add(new Invasion(spec));
/*     */     
/* 207 */     for (InvasionListener l : InvasionListener.all) {
/* 208 */       l.register(a, this.ref);
/*     */     }
/*     */     
/* 211 */     return spec.ref; } private DivGeneration make(final int men, final Race race, final DIV_SETTING.DIV_SETTINGImp spec, final double ex) { final CharSequence name = (CharSequence)race.info.armyNames.rnd(); final int bannerI = RND.rInt((GAME.ARMIES()).banners.size()); DIV_SPEC dd = new DIV_SPEC() { public double training(StatsBattle.StatTraining tr) { return spec.training(tr); } public double equip(EquipBattle e) { return spec.equip(e); } public Race race() { return race; }
/*     */         public int men() { return men; }
/*     */         public Faction faction() { return null; }
/*     */         public double experience() { return ex; }
/*     */         public CharSequence name() { return name; }
/*     */         public int bannerI() { return bannerI; } }
/*     */       ; return new DivGeneration(dd, (DIV_SETTING)dd); }
/* 218 */   protected void update(double ds, Profiler profiler) { if (this.active.size() == 0) {
/*     */       return;
/*     */     }
/* 221 */     Invasion in = (Invasion)this.active.get(0);
/*     */     
/* 223 */     STANDINGS.emergency(HCLASSES.CITIZEN(), (TIME.secondsPerDay() * 6));
/*     */     
/* 225 */     if (in.update(ds)) {
/*     */       return;
/*     */     }
/* 228 */     this.active.removeOrdered(0); byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 230 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 231 */       if (e instanceof Humanoid) {
/* 232 */         Humanoid h = (Humanoid)e;
/* 233 */         if (h.indu().hType() == HTYPES.ENEMY()) {
/* 234 */           h.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie();
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/* 239 */     for (ROOM_ARTILLERY rOOM_ARTILLERY : (SETT.ROOMS()).ARTILLERY) {
/* 240 */       for (int j = 0; j < rOOM_ARTILLERY.instancesSize(); j++) {
/* 241 */         ArtilleryInstance ins = (ArtilleryInstance)rOOM_ARTILLERY.getInstance(j);
/* 242 */         if (ins.army() == GAME.ARMIES().enemy()) {
/* 243 */           ins.destroyTile(ins.mX(), ins.mY());
/* 244 */           j--;
/*     */         } 
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean invading(FactionNPC f) {
/* 254 */     for (Invasion i : this.active) {
/* 255 */       if (i.invador() == f)
/* 256 */         return true; 
/*     */     } 
/* 258 */     return false;
/*     */   }
/*     */   
/*     */   public boolean invading() {
/* 262 */     return (this.active.size() > 0);
/*     */   }
/*     */   
/*     */   public double invadingPower() {
/* 266 */     double p = 0.0D;
/* 267 */     for (Invasion i : this.active) {
/* 268 */       p += i.spec.power;
/*     */     }
/* 270 */     return p;
/*     */   }
/*     */   
/*     */   public boolean invadingPending() {
/* 274 */     if (this.active.size() > 0)
/* 275 */       for (int i = 0; i < this.active.size(); i++) {
/* 276 */         if (((Invasion)this.active.get(i)).spec.canBeAttacked)
/* 277 */           return true; 
/*     */       }  
/* 279 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 284 */     file.i(this.active.size());
/* 285 */     for (Invasion i : this.active) {
/* 286 */       i.save(file);
/*     */     }
/* 288 */     file.i(this.ref);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 293 */     this.active.clear();
/* 294 */     int am = file.i();
/* 295 */     for (int i = 0; i < am; i++)
/* 296 */       this.active.add(new Invasion(file)); 
/* 297 */     this.ref = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 302 */     this.active.clear();
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX text) {
/* 306 */     GBox b = (GBox)text;
/* 307 */     if (this.active.size() > 0) {
/* 308 */       b.title(¤¤inv);
/* 309 */       for (Invasion i : this.active) {
/* 310 */         int men = 0;
/* 311 */         for (DivGeneration s : i.spec.divs)
/* 312 */           men += s.indus.length; 
/* 313 */         b.textLL(Dic.¤¤Soldiers);
/* 314 */         b.tab(6);
/* 315 */         b.add((SPRITE)GFORMAT.i(b.text(), men));
/* 316 */         b.NL();
/* 317 */         b.textL(i.spot.dir.perpendicular().getName());
/* 318 */         b.NL(8);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public InvasionSpec spec(int ref) {
/* 325 */     for (Invasion i : this.active) {
/* 326 */       if (i.spec.ref == ref) {
/* 327 */         return i.spec;
/*     */       }
/*     */     } 
/* 330 */     return null;
/*     */   }
/*     */   
/*     */   public void cancel(int ref) {
/* 334 */     for (Invasion i : this.active) {
/* 335 */       if (i.spec.ref == ref) {
/* 336 */         this.active.removeOrdered(i);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Invador.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
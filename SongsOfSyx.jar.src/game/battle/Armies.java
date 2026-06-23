/*     */ package game.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.factors.DivFactors;
/*     */ import game.battle.formation.DivDeployerUser;
/*     */ import game.battle.setting.BattleSettings;
/*     */ import game.debug.Profiler;
/*     */ import game.save.Savable;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Armies
/*     */   extends GAME.GameResource
/*     */ {
/*     */   public static final int ARMIES = 2;
/*     */   public static final int ARMIES_BITS = 3;
/*  35 */   public static final int DIVISIONS = 2 * (Config.battle()).DIVISIONS_PER_ARMY;
/*  36 */   private final ArrayList<Div> divisions = new ArrayList(DIVISIONS);
/*  37 */   private final ArrayList<ArmyDiv> adivisions = new ArrayList(DIVISIONS);
/*  38 */   private final ArrayList<Army> armies = new ArrayList(2);
/*  39 */   private final PrevMen prevMen = new PrevMen();
/*     */   
/*     */   public final DivDeployerUser placer;
/*  42 */   public final DivisionBanners banners = new DivisionBanners();
/*  43 */   public final TargetMap map = new TargetMap();
/*  44 */   public final DivFactors factors = new DivFactors(this);
/*     */   
/*     */   public final BattleSettings settings;
/*  47 */   public final ArmySounds sound = new ArmySounds();
/*     */   private double ti;
/*     */   
/*  50 */   public Armies(GAME game) throws IOException { super("ARMIES", true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 194 */     this.ti = 0.0D; for (int i = 0; i < 2; i++); this.placer = new DivDeployerUser((LIST)this.armies) { protected boolean blocked(int x, int y, Army a) { if (VIEW.b().state() != null && VIEW.b().state().deploying()) { if (a == GAME.ARMIES().player()) return !VIEW.b().state().deploymentBounds().holdsPoint((x >> 6), (y >> 6));  return VIEW.b().state().deploymentBounds().holdsPoint((x >> 6), (y >> 6)); }  return false; } }
/*     */       ; for (Div d : this.divisions) this.adivisions.add(d);  this.settings = new BattleSettings(this); IDebugPanel.add("checkDivisionSpotOrder", new ACTION() { public void exe() { final Bitmap2D check = new Bitmap2D((Config.battle()).MEN_PER_DIVISION, (Config.battle()).DIVISIONS_PER_BATTLE, false); (new EntityIterator.Humans() { protected boolean processAndShouldBreakH(Humanoid h, int ie) { if (h.division() != null) check.set((h.division()).reporter.positionSpot(h), h.division().index(), true);  return false; } }
/*     */               ).iterate(); for (Div d : Armies.this.divisions) { int i; for (i = 0; i < d.menNrOf(); i++) { if (!check.is(i, d.index())) { LOG.ln("errors in division " + d.index()); break; }  }  if (d.menNrOf() > 0) { GAME.Notify(Short.valueOf(d.index())); for (i = 0; i < d.menNrOf(); i++) check.set(i, d.index(), false);  (new EntityIterator.Humans() { protected boolean processAndShouldBreakH(Humanoid h, int ie) { for (int i = 0; i < d.menNrOf(); i++) check.set(i, d.index(), false);  if (h.division() == d) { if (h.divSpot() != d.reporter.positionSpot(h)) LOG.ln("" + h.divSpot() + " -> " + h.divSpot());  check.set((h.division()).reporter.positionSpot(h), h.division().index(), true); }  return false; } }
/*     */                   ).iterate(); LOG.ln(); for (i = 0; i < d.menNrOf(); i++) { int pi = d.reporter.positionSpot(i); if (i != pi) LOG.ln("" + i + " -> " + i);  }  }  }  GAME.Notify("test completed"); } }
/* 198 */       ); } public void clear() { for (Army t : this.armies) t.saver.clear();  for (ArmyDiv d : this.adivisions) d.clear();  this.banners.clear(); for (int i = 0; i < 4; i++) ((Div)(GAME.ARMIES()).divisions.get(i)).info.menSet(50);  } protected void save(FilePutter file) { for (Army t : this.armies) t.saver.save(file);  for (ArmyDiv d : this.adivisions) d.save(file);  this.banners.save(file); } protected void update(double ds, Profiler profiler) { profiler.logStart(Div.class);
/* 199 */     profiler.logEnd(Div.class);
/* 200 */     profiler.logStart(DivFactors.class);
/* 201 */     this.factors.update(ds);
/* 202 */     profiler.logEnd(DivFactors.class);
/* 203 */     profiler.logStart(BattleSettings.class);
/* 204 */     this.settings.update(ds);
/* 205 */     profiler.logEnd(BattleSettings.class);
/*     */     
/* 207 */     this.ti += ds;
/* 208 */     if (this.ti > 0.1D) {
/* 209 */       this.ti -= 0.1D;
/* 210 */       (SETT.BATTLE()).info.update();
/*     */     } 
/*     */     
/* 213 */     this.prevMen.update(ds); }
/*     */   protected void load(FileGetter file) throws IOException { for (Army t : this.armies)
/*     */       t.saver.load(file);  for (ArmyDiv d : this.adivisions)
/*     */       d.load(file);  this.banners.load(file); }
/* 217 */   protected void loadFail() { clear(); } public Army player() { return (Army)this.armies.get(0); }
/*     */ 
/*     */   
/*     */   public Army enemy() {
/* 221 */     return (Army)this.armies.get(1);
/*     */   }
/*     */   
/*     */   public Div division(short armyDivisionID) {
/* 225 */     return (Div)this.divisions.get(armyDivisionID);
/*     */   }
/*     */   
/*     */   public LIST<Div> divisions() {
/* 229 */     return (LIST<Div>)this.divisions;
/*     */   }
/*     */   
/*     */   public LIST<Army> armies() {
/* 233 */     return (LIST<Army>)this.armies;
/*     */   }
/*     */   
/*     */   public void initAndTeleport(LIST<Div> divs) {
/* 237 */     for (Div d : divs) {
/* 238 */       this.settings.init(d);
/*     */     }
/* 240 */     GAME.BATTLE_THREADS().initAndTeleport(divs);
/* 241 */     for (Div d : divs) {
/* 242 */       this.factors.init(d);
/* 243 */       this.prevMen.men[d.index()] = d.menNrOf();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int prevMen(Div div) {
/* 249 */     return this.prevMen.men[div.index()];
/*     */   }
/*     */   
/*     */   private static class PrevMen
/*     */     extends IUpdater
/*     */   {
/* 255 */     private int[] men = Alloc.ii((Config.battle()).DIVISIONS_PER_BATTLE);
/*     */     
/*     */     PrevMen() {
/* 258 */       super((Config.battle()).DIVISIONS_PER_BATTLE, 10.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void update(int i, double timeSinceLast) {
/* 275 */       this.men[i] = GAME.ARMIES().division((short)i).men();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\Armies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
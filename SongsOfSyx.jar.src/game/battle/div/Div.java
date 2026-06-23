/*     */ package game.battle.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Army;
/*     */ import game.battle.ArmyDiv;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.battle.setting.BattleSettings;
/*     */ import game.battle.setting.DivSettings;
/*     */ import game.battle.thread.order.BattleOrder;
/*     */ import game.battle.thread.order.BattleOrders;
/*     */ import game.battle.thread.position.DivCentre;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.thread.status.DivStatus;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class Div
/*     */   extends ArmyDiv
/*     */   implements BOOSTABLE_O, DIV_SIMPLE
/*     */ {
/*     */   private final short index;
/*     */   private final short armyIndex;
/*     */   private final Army army;
/*     */   final DivMen men;
/*     */   public final DivTargets targets;
/*     */   private final DivPositionCopyable current;
/*     */   public final DivInfo info;
/*  51 */   public final DivReporter reporter = new DivReporter();
/*     */ 
/*     */   
/*     */   public Div(ArrayList<Div> all, ArrayList<Div> armyAll, Army army) {
/*  55 */     this.index = (short)all.add(this);
/*  56 */     this.armyIndex = (short)armyAll.add(this);
/*  57 */     this.army = army;
/*  58 */     this.men = new DivMen();
/*     */     
/*  60 */     this.current = new DivPositionCopyable();
/*  61 */     this.targets = new DivTargets(this);
/*  62 */     this.info = new DivInfo(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/*  67 */     return this.info.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/*  72 */     return this.men.men();
/*     */   }
/*     */   
/*     */   public int menPrevious() {
/*  76 */     return GAME.ARMIES().prevMen(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  81 */     this.men.save(file);
/*  82 */     this.current.save(file);
/*  83 */     this.targets.saver().save(file);
/*  84 */     this.info.saver.save(file);
/*  85 */     this.reporter.unreachablem.save(file);
/*  86 */     file.s(this.reporter.unreachable);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  91 */     this.men.load(file);
/*  92 */     this.current.load(file);
/*  93 */     this.targets.saver().load(file);
/*  94 */     this.info.saver.load(file);
/*  95 */     this.reporter.unreachablem.load(file);
/*  96 */     this.reporter.unreachable = file.s();
/*  97 */     this.army.men.recount();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 102 */     this.men.clear();
/* 103 */     this.current.clear();
/* 104 */     this.targets.saver().clear();
/* 105 */     this.info.saver.clear();
/* 106 */     this.reporter.unreachablem.clear();
/* 107 */     this.reporter.unreachable = 0;
/* 108 */     settings().clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public short index() {
/* 113 */     return this.index;
/*     */   }
/*     */   
/*     */   public short indexArmy() {
/* 117 */     return this.armyIndex;
/*     */   }
/*     */   
/*     */   public Army army() {
/* 121 */     return this.army;
/*     */   }
/*     */   
/*     */   public boolean player() {
/* 125 */     return (this.army == GAME.ARMIES().player());
/*     */   }
/*     */   
/*     */   public Army armyEnemy() {
/* 129 */     return (Army)GAME.ARMIES().armies().getC(this.army.index() + 1);
/*     */   }
/*     */   
/*     */   public int menNrOf() {
/* 133 */     return this.men.men();
/*     */   }
/*     */   
/*     */   public int deployed() {
/* 137 */     return position().deployed();
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR dir() {
/* 142 */     return position().dir();
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 147 */     if (army() == GAME.ARMIES().player())
/* 148 */       return (Faction)FACTIONS.player(); 
/* 149 */     return (Faction)FACTIONS.otherFaction();
/*     */   }
/* 151 */   private static final Coo tmp = new Coo();
/*     */   
/*     */   public final class DivReporter
/*     */     extends StatsBattle.HDivStat
/*     */   {
/* 156 */     private final Bitmap1D unreachablem = new Bitmap1D((Config.battle()).MEN_PER_DIVISION, false);
/*     */ 
/*     */     
/*     */     private short unreachable;
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean posHas(Humanoid a) {
/* 164 */       return (Div.this.position().deployed() >= Div.this.men.getSpot(a.divSpot()));
/*     */     }
/*     */     
/*     */     public COORDINATE getTile(Humanoid a) {
/* 168 */       COORDINATE c = Div.this.position().tile(Div.this.men.getSpot(a.divSpot()));
/* 169 */       if (c == null)
/* 170 */         return a.tc(); 
/* 171 */       return c;
/*     */     }
/*     */     
/*     */     public COORDINATE getPixel(Humanoid a) {
/* 175 */       COORDINATE c = Div.this.position().pixel(Div.this.men.getSpot(a.divSpot()));
/* 176 */       if (c == null) {
/* 177 */         Div.tmp.set(a.body().cX(), a.body().cY());
/* 178 */         return (COORDINATE)Div.tmp;
/*     */       } 
/* 180 */       return c;
/*     */     }
/*     */     
/*     */     public RECTANGLE body() {
/* 184 */       return Div.this.position().body();
/*     */     }
/*     */     
/*     */     public COORDINATE getDestTile(Humanoid a) {
/* 188 */       COORDINATE c = Div.this.position().centreTile();
/* 189 */       if (c == null)
/* 190 */         return a.tc(); 
/* 191 */       return c;
/*     */     }
/*     */     
/*     */     public void reportPosition(short spot, int x, int y) {
/* 195 */       Div.this.current.set(Div.this.men.getSpot(spot), x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public short signUpAndGetPosition(int x, int y, Race r) {
/* 200 */       if (Div.this.menNrOf() == 0) {
/* 201 */         Div.this.info.raceSet(r);
/* 202 */         (GAME.ARMIES()).factors.init(Div.this);
/*     */       } 
/* 204 */       Div.this.army.men.recount();
/* 205 */       short sp = Div.this.men.getNewSpot();
/* 206 */       reportPosition(sp, x, y);
/* 207 */       Div.this.current.init(Div.this.men.men());
/*     */       
/* 209 */       return sp;
/*     */     }
/*     */ 
/*     */     
/*     */     public void returnPosition(short pos) {
/* 214 */       Div.this.army.men.recount();
/* 215 */       Div.this.men.returnSpot(pos);
/* 216 */       if (Div.this.men.men() == 0)
/* 217 */         Div.this.settings().musteringSet(false); 
/* 218 */       reportReachable(pos, true);
/* 219 */       Div.this.current.init(Div.this.men.men());
/*     */     }
/*     */     
/*     */     private void reportReachable(int spot, boolean reachable) {
/* 223 */       if (this.unreachablem.get(spot))
/* 224 */         this.unreachable = (short)(this.unreachable - 1); 
/* 225 */       this.unreachablem.set(spot, !reachable);
/* 226 */       if (!reachable) {
/* 227 */         this.unreachable = (short)(this.unreachable + 1);
/*     */       }
/*     */     }
/*     */     
/*     */     public void reportReachable(Humanoid a, boolean reachable) {
/* 232 */       int spot = positionSpot(a);
/* 233 */       reportReachable(spot, reachable);
/*     */     }
/*     */     
/*     */     public boolean reachable(int i) {
/* 237 */       return !this.unreachablem.get(i);
/*     */     }
/*     */     
/*     */     public int unreachable() {
/* 241 */       return this.unreachable;
/*     */     }
/*     */     
/*     */     public int positionSpot(Humanoid h) {
/* 245 */       int i = STATS.BATTLE().position(h.indu());
/* 246 */       return Div.this.men.getSpot(i);
/*     */     }
/*     */     
/*     */     public int positionSpot(int ui) {
/* 250 */       return Div.this.men.spotTranslate(ui);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox text) {
/* 256 */     (VIEW.UI()).div.battle.hover((GUI_BOX)text, this);
/*     */   }
/*     */   
/*     */   public DivPositionCopyable current() {
/* 260 */     return this.current;
/*     */   }
/*     */   
/*     */   public void debug() {
/* 264 */     String s = System.lineSeparator();
/* 265 */     String res = "";
/* 266 */     res = res + "Div: " + res + " " + this.index + this.armyIndex;
/* 267 */     res = res + "Men: " + res + " Deployed:" + menNrOf() + deployed();
/* 268 */     res = res + "Current: " + res + "  " + this.current.deployed();
/*     */     
/* 270 */     GAME.Notify(res);
/*     */   }
/*     */   
/*     */   public boolean active() {
/* 274 */     return (menNrOf() > 0 && settings().mustering());
/*     */   }
/*     */ 
/*     */   
/*     */   public double boostableValue(BValue v) {
/* 279 */     return v.vGet(this);
/*     */   }
/*     */   
/*     */   public DivCentre centre() {
/* 283 */     return (GAME.BATTLE_THREADS()).centres.centre(this.index);
/*     */   }
/*     */   
/*     */   public DivStatus status() {
/* 287 */     return BattleStatus.status(this);
/*     */   }
/*     */   
/*     */   public Trajectory traj(Humanoid h) {
/* 291 */     return BattleTrajectories.request(h, this);
/*     */   }
/*     */   
/*     */   public DivFormation position() {
/* 295 */     return (DivFormation)BattleOrders.next(this);
/*     */   }
/*     */   
/*     */   public BattleOrder order() {
/* 299 */     return BattleOrders.get(this);
/*     */   }
/*     */   
/*     */   public double morale() {
/* 303 */     return (GAME.ARMIES()).factors.morale(this);
/*     */   }
/*     */   
/*     */   public DivSettings settings() {
/* 307 */     return BattleSettings.get(this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\Div.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
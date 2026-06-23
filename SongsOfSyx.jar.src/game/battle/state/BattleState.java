/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.save.GameLoader;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import java.nio.file.Path;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsPopulation;
/*     */ import snake2d.Errors;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import view.battle.UIBattleResult;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.subview.GameWindow;
/*     */ import world.WORLD;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ import world.map.road.WTRAV;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BattleState
/*     */ {
/*     */   private boolean deploying = true;
/*     */   private boolean concluded = false;
/*  46 */   private final Rec deploymentTiles = new Rec();
/*  47 */   private double throneTimer = 0.0D;
/*     */   
/*     */   public static final int throneMax = 300;
/*     */   private final BattleStateExiter resolve;
/*     */   private final Path saveFile;
/*  52 */   public static String debugLoad = "__battledebug";
/*     */ 
/*     */   
/*     */   public static void setGenerate(BattleStateExiter resolve, BattleStateSpec spec) {
/*  56 */     save("__beforeBattle");
/*  57 */     if (!PATHS.local().save().exists("__battle"))
/*  58 */       PATHS.local().save().create("__battle"); 
/*  59 */     BattleState s = new BattleState(resolve, PATHS.local().save().get("__battle"));
/*     */ 
/*     */ 
/*     */     
/*  63 */     (new BattleStateGenerator()).generate(s, spec, s.deploymentTiles);
/*  64 */     save("__battle");
/*  65 */     s.view();
/*  66 */     (VIEW.b().getWindow()).centererTile.set(THRONE.coo());
/*  67 */     VIEW.b().getWindow().zoomoutmax();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setLoaded(BattleStateExiter resolve, Path saveFile, boolean deploy) {
/*  72 */     BattleState s = new BattleState(resolve, saveFile);
/*  73 */     s.view();
/*     */   }
/*     */   
/*     */   private BattleState(BattleStateExiter resolve, Path saveFile) {
/*  77 */     GAME.BATTLE_THREADS().pause();
/*  78 */     this.saveFile = saveFile;
/*  79 */     this.resolve = resolve;
/*  80 */     this.deploying = true;
/*  81 */     this.throneTimer = 300.0D;
/*     */     
/*  83 */     DIR d = DIR.get(THRONE.coo(), SETT.TWIDTH / 2, SETT.TWIDTH / 2);
/*     */     
/*  85 */     this.deploymentTiles.set((
/*  86 */         SETT.TILE_BOUNDS.cX() + d.next(-2).x() * SETT.TWIDTH / 2), (SETT.TILE_BOUNDS.cX() + d.next(3).x() * SETT.TWIDTH / 2), (
/*  87 */         SETT.TILE_BOUNDS.cY() + d.next(-2).y() * SETT.TWIDTH / 2), (SETT.TILE_BOUNDS.cY() + d.next(3).y() * SETT.TWIDTH / 2));
/*  88 */     this.deploymentTiles.makePositive();
/*  89 */     view();
/*  90 */     (VIEW.b().getWindow()).centererTile.set(THRONE.coo());
/*  91 */     VIEW.b().getWindow().zoomoutmax();
/*     */   }
/*     */ 
/*     */   
/*     */   private void view() {
/*  96 */     VIEW.messages().hideAll();
/*  97 */     GAME.SPEED.speedSet(0.0D);
/*  98 */     VIEW.b().activate(this);
/*     */   }
/*     */   
/*     */   private static void save(String name) {
/* 102 */     if (PATHS.local().save().exists(name))
/* 103 */       PATHS.local().save().delete(name); 
/* 104 */     if (GAME.saver().save(name) == null) {
/* 105 */       throw new Errors.DataError(name, PATHS.local().save().get(name));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void reloadBattle() {
/* 112 */     (new GameLoader(this.saveFile, new String[0])
/*     */       {
/*     */         public void doAfterSet()
/*     */         {
/* 116 */           GAME.BATTLE_THREADS().pause();
/* 117 */           BattleState.this.concluded = false;
/* 118 */           BattleState.this.deploying = true;
/*     */           
/* 120 */           BattleState.this.throneTimer = 300.0D;
/*     */           
/* 122 */           VIEW.b().activate(BattleState.this);
/* 123 */           (VIEW.b().getWindow()).centererTile.set(THRONE.coo());
/* 124 */           VIEW.b().getWindow().zoomoutmax();
/* 125 */           GAME.SPEED.speedSet(0.0D);
/*     */         }
/* 129 */       }).set();
/*     */   }
/*     */   
/*     */   public double throneTimer() {
/* 133 */     return this.throneTimer;
/*     */   }
/*     */   
/*     */   public boolean deploying() {
/* 137 */     return this.deploying;
/*     */   }
/*     */   
/*     */   public void deploy() {
/* 141 */     this.deploying = false;
/* 142 */     GAME.setGameStart();
/*     */   }
/*     */   
/*     */   public RECTANGLE deploymentBounds() {
/* 146 */     return (RECTANGLE)this.deploymentTiles;
/*     */   }
/*     */ 
/*     */   
/*     */   void liveResolve(boolean retreat, boolean win) {
/* 151 */     BATTLE_RESULT res = BATTLE_RESULT.VICTORY;
/* 152 */     if (this.throneTimer <= 0.0D) {
/* 153 */       res = BATTLE_RESULT.DEFEAT;
/* 154 */     } else if (retreat) {
/* 155 */       res = BATTLE_RESULT.RETREAT;
/* 156 */     } else if (!win) {
/* 157 */       res = BATTLE_RESULT.DEFEAT;
/*     */     } 
/* 159 */     int eDeaths = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.OTHER()).get(null);
/* 160 */     int pLosses = ((StatsPopulation.StatsDeath.PopData)(STATS.POP()).COUNT.leaves().get(CAUSE_LEAVES.SLAYED().index())).statistics(HCLASSES.CITIZEN()).get(null);
/* 161 */     this.resolve.exit(res, pLosses, eDeaths);
/*     */   }
/*     */ 
/*     */   
/*     */   public void liveRetreat() {
/* 166 */     liveResolve(true, false);
/*     */   }
/*     */   
/*     */   public int liveRetreatLosses() {
/* 170 */     int am = (int)Math.ceil(GAME.ARMIES().enemy().men() * 0.4D);
/* 171 */     for (Div d : GAME.ARMIES().player().divisions()) {
/* 172 */       if (d.status().isFighting()) {
/* 173 */         am = (int)(am + d.menNrOf() * 0.5D);
/*     */       }
/*     */     } 
/* 176 */     if (am > GAME.ARMIES().player().men()) {
/* 177 */       am = GAME.ARMIES().player().men();
/*     */     }
/* 179 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 185 */     if (this.concluded) {
/*     */       return;
/*     */     }
/* 188 */     if (this.deploying) {
/*     */       return;
/*     */     }
/* 191 */     if (GAME.ARMIES().player().men() == 0 || GAME.ARMIES().enemy().men() == 0) {
/* 192 */       if (GAME.ARMIES().player().men() == 0) {
/*     */       
/* 194 */       } else if (GAME.ARMIES().enemy().men() == 0) {
/*     */       
/* 196 */       }  this.concluded = true;
/*     */       
/*     */       return;
/*     */     } 
/* 200 */     LIST<ENTITY> es = SETT.ENTITIES().fillTiles(THRONE.coo().x() - 4, THRONE.coo().y() - 4, 8, 8);
/*     */     
/* 202 */     double tt = this.throneTimer - ds;
/* 203 */     this.throneTimer = 300.0D;
/* 204 */     for (ENTITY e : es) {
/* 205 */       if (e instanceof Humanoid) {
/* 206 */         Humanoid h = (Humanoid)e;
/* 207 */         if (h.indu().hType().isHostile() && h.division() != null) {
/* 208 */           this.throneTimer = tt;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 214 */     if (this.throneTimer <= 0.0D) {
/*     */       
/* 216 */       this.concluded = true;
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final class ILiveConclude
/*     */     extends Interrupter
/*     */   {
/* 227 */     private final GameWindow window = new GameWindow(C.DIM(), SETT.PIXEL_BOUNDS, 0);
/*     */     private final GuiSection section;
/*     */     
/*     */     ILiveConclude(CharSequence title, final boolean retreat, final boolean win) {
/* 231 */       pin();
/* 232 */       persistantSet();
/*     */       
/* 234 */       this.section = (GuiSection)new UIBattleResult(title)
/*     */         {
/*     */           protected void close()
/*     */           {
/* 238 */             BattleState.ILiveConclude.this.hide();
/* 239 */             BattleState.ILiveConclude.access$1(BattleState.ILiveConclude.this).liveResolve(retreat, win);
/*     */           }
/*     */         };
/*     */       
/* 243 */       this.window.copy(VIEW.b().getWindow());
/* 244 */       GAME.BATTLE_THREADS().pause();
/* 245 */       (VIEW.inters()).manager.add(this);
/* 246 */       this.section.body().centerIn(C.DIM());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 252 */       this.section.hover(mCoo);
/* 253 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 258 */       if (button == MButt.LEFT) {
/* 259 */         this.section.click();
/*     */       }
/*     */     }
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 264 */       this.section.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 269 */       this.section.render((SPRITE_RENDERER)r, ds);
/* 270 */       GAME.s().render(r, ds, this.window, UIMinimapSettConfig.NORMAL);
/* 271 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 276 */       GAME.SPEED.speedSet(1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 283 */       return true;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean okWorldTile(int tx, int ty, DIR eDir) {
/* 289 */     return (okWorldTile(tx, ty) && okWorldTile(tx + eDir.x(), ty + eDir.y()));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean okWorldTile(int tx, int ty) {
/* 295 */     if (tx - 1 < 0 || ty - 1 < 2 || tx + 1 >= WORLD.TWIDTH() || ty + 1 >= WORLD.THEIGHT())
/* 296 */       return false; 
/* 297 */     for (int di = 0; di < DIR.ALLC.size(); di++) {
/* 298 */       DIR d = (DIR)DIR.ALLC.get(di);
/* 299 */       if (WORLD.MOUNTAIN().is(tx, ty))
/* 300 */         return false; 
/* 301 */       if ((WORLD.WATER()).isBig.is(tx, ty)) {
/* 302 */         return false;
/*     */       }
/*     */       
/* 305 */       if (!WTRAV.isGoodLandTile(tx + d.x(), ty + d.y()))
/* 306 */         return false; 
/* 307 */       if (d != DIR.C && !WTRAV.can(tx, ty, d, false))
/* 308 */         return false; 
/*     */     } 
/* 310 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleState.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
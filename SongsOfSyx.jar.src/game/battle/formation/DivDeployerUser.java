/*     */ package game.battle.formation;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Armies;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ public class DivDeployerUser {
/*     */   private final ArrayList<DivDeployer.DivDeployB> all;
/*     */   private final ArrayList<DivDeployer.DivDeployB> selection;
/*     */   public final DivDeployer deployer;
/*  24 */   private final int clampM = -16;
/*     */   
/*  26 */   private ArrayList<DivDeployer.DivDeployB> tmp = new ArrayList(Armies.DIVISIONS);
/*  27 */   private ArrayList<DivDeployer.DivDeployB> selected = new ArrayList(Armies.DIVISIONS);
/*  28 */   private final VectorImp vec = new VectorImp();
/*  29 */   private static final ArrayList<Div> tmp2 = new ArrayList(1);
/*  30 */   private final DivFormationImp fTmp = new DivFormationImp();
/*  31 */   private final BattleOrderTask task = new BattleOrderTask();
/*     */   public DivDeployerUser(LIST<Army> armies) {
/*  33 */     int size = Armies.DIVISIONS;
/*  34 */     this.all = new ArrayList(size);
/*  35 */     this.selection = new ArrayList(size);
/*  36 */     for (Army a : armies) {
/*  37 */       for (Div d : a.divisions()) {
/*  38 */         DivDeployer.DivDeployB dep = new DivDeployer.DivDeployB();
/*  39 */         dep.div = d;
/*  40 */         this.all.add(dep);
/*     */       } 
/*     */     } 
/*  43 */     this.deployer = new DivDeployer(GUTIL.pathTools())
/*     */       {
/*     */         protected boolean isDeployable(int px, int py, Army a) {
/*  46 */           return !DivDeployerUser.this.blocked(px, py, a);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected boolean blocked(int x, int y, Army a) {
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   public boolean render(SPRITE_RENDERER ren, LIST<Div> divs, int x1, int x2, int y1, int y2, RenderData data) {
/*  56 */     x1 += 8;
/*  57 */     y1 += 8;
/*  58 */     x2 += 8;
/*  59 */     y2 += 8;
/*     */     
/*  61 */     x1 &= 0xFFFFFFF0;
/*  62 */     y1 &= 0xFFFFFFF0;
/*  63 */     x2 &= 0xFFFFFFF0;
/*  64 */     y2 &= 0xFFFFFFF0;
/*     */     
/*  66 */     this.selection.clear();
/*  67 */     for (Div d : divs) {
/*  68 */       if (d.menNrOf() == 0)
/*     */         continue; 
/*  70 */       DivDeployer.DivDeployB divDeployB = (DivDeployer.DivDeployB)this.all.get(d.index());
/*  71 */       divDeployB.div = d;
/*  72 */       this.selection.add(divDeployB);
/*     */     } 
/*     */     
/*  75 */     LIST<DivDeployer.DivDeployB> result = init((LIST<DivDeployer.DivDeployB>)this.selection, x1, x2, y1, y2);
/*  76 */     boolean dep = false;
/*  77 */     for (DivDeployer.DivDeployB b : result) {
/*  78 */       DivFormationImp d = this.deployer.deploy((DIV_SPEC)b.div.info, b.div.menNrOf(), (b.div.settings()).formation, b.x1, b.y1, b.dx, b.dy, b.width, GAME.ARMIES().player());
/*  79 */       if (d != null)
/*  80 */         dep = true; 
/*  81 */       DivRenderer.render(ren, d, data);
/*     */     } 
/*  83 */     return dep;
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER ren, DivFormationImp d, RenderData data) {
/*  87 */     DivRenderer.render(ren, d, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void addSecretBlocker(MAP_BOOLEAN block) {}
/*     */ 
/*     */   
/*     */   public boolean deploy(LIST<Div> divs, int x1, int x2, int y1, int y2) {
/*  95 */     this.selection.clear();
/*     */     
/*  97 */     x1 += 8;
/*  98 */     y1 += 8;
/*  99 */     x2 += 8;
/* 100 */     y2 += 8;
/*     */     
/* 102 */     x1 &= 0xFFFFFFF0;
/* 103 */     y1 &= 0xFFFFFFF0;
/* 104 */     x2 &= 0xFFFFFFF0;
/* 105 */     y2 &= 0xFFFFFFF0;
/*     */     
/* 107 */     for (Div d : divs) {
/* 108 */       if (d.menNrOf() == 0)
/*     */         continue; 
/* 110 */       DivDeployer.DivDeployB divDeployB = (DivDeployer.DivDeployB)this.all.get(d.index());
/* 111 */       divDeployB.div = d;
/* 112 */       this.selection.add(divDeployB);
/*     */     } 
/*     */     
/* 115 */     LIST<DivDeployer.DivDeployB> result = init((LIST<DivDeployer.DivDeployB>)this.selection, x1, x2, y1, y2);
/* 116 */     boolean dep = false;
/* 117 */     for (DivDeployer.DivDeployB b : result) {
/* 118 */       DivFormationImp d = this.deployer.deploy((DIV_SPEC)b.div.info, b.div.menNrOf(), (b.div.settings()).formation, b.x1, b.y1, b.dx, b.dy, b.width, b.div.army());
/*     */       
/* 120 */       if (d != null) {
/* 121 */         dep = true;
/* 122 */         (b.div.order()).dest.set(d);
/* 123 */         this.task.move(b.div);
/* 124 */         (b.div.order()).task.set((Copyable)this.task);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 129 */     return dep;
/*     */   }
/*     */   
/*     */   public void deploy(Div div, int x1, int x2, int y1, int y2) {
/* 133 */     tmp2.clear();
/* 134 */     tmp2.add(div);
/* 135 */     deploy((LIST<Div>)tmp2, x1, x2, y1, y2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deploy(Div div, int dx, int dy) {
/* 141 */     (div.order()).dest.get(this.fTmp);
/* 142 */     DivFormationImp d = this.deployer.deploy(
/* 143 */         (DIV_SPEC)div.info, 
/* 144 */         div.menNrOf(), 
/* 145 */         this.fTmp.formation(), 
/* 146 */         this.fTmp.start().x() + dx, this.fTmp.start().y() + dy, 
/* 147 */         this.fTmp.dx(), this.fTmp.dy(), this.fTmp.width(), GAME.ARMIES().player());
/*     */     
/* 149 */     if (d != null && d.deployed() != 0) {
/* 150 */       this.task.move(div);
/* 151 */       (div.order()).dest.set(d);
/* 152 */       (div.order()).task.set((Copyable)this.task);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlocked(int x, int y, int tileSize, Army a) {
/* 159 */     return (DivPlacability.pixelIsBlocked(x, y, tileSize, GAME.ARMIES().player()) && !blocked(x, y, a));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private LIST<DivDeployer.DivDeployB> init(LIST<DivDeployer.DivDeployB> divs, int x1, int x2, int y1, int y2) {
/* 165 */     this.selected.clear();
/* 166 */     double distFull = this.vec.set(x1, y1, x2, y2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 175 */     this.selected.clear();
/* 176 */     if ((divs.size() * 64) > distFull) {
/* 177 */       return (LIST<DivDeployer.DivDeployB>)this.selected;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     double menTotal = 0.0D;
/*     */ 
/*     */     
/* 186 */     this.tmp.clear();
/* 187 */     for (DivDeployer.DivDeployB d : divs) {
/* 188 */       menTotal += d.div.menNrOf();
/* 189 */       if (d.div.menNrOf() == 0)
/*     */         continue; 
/* 191 */       this.tmp.add(d);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 196 */     while (this.tmp.size() > 0) {
/* 197 */       double smallesD = Double.MAX_VALUE;
/* 198 */       int s = -1;
/* 199 */       for (int i = 0; i < this.tmp.size(); i++) {
/* 200 */         RECTANGLE d = ((DivDeployer.DivDeployB)this.tmp.get(i)).div.position().body();
/* 201 */         double ddx = (d.cX() - x1);
/* 202 */         double ddy = (d.cY() - y1);
/* 203 */         double dist = Math.sqrt(ddx * ddx + ddy * ddy);
/* 204 */         if (dist < smallesD) {
/* 205 */           smallesD = dist;
/* 206 */           s = i;
/*     */         } 
/*     */       } 
/* 209 */       DivDeployer.DivDeployB dr = (DivDeployer.DivDeployB)this.tmp.get(s);
/* 210 */       this.selected.add(dr);
/* 211 */       this.tmp.remove(s);
/*     */     } 
/*     */     
/* 214 */     if (this.selected.isEmpty()) {
/* 215 */       return (LIST<DivDeployer.DivDeployB>)this.selected;
/*     */     }
/* 217 */     DIV_FORMATION lastF = (((DivDeployer.DivDeployB)this.selected.get(0)).div.settings()).formation;
/* 218 */     double distGaps = 0.0D;
/* 219 */     for (DivDeployer.DivDeployB d : this.selected) {
/* 220 */       if ((d.div.settings()).formation != lastF) {
/* 221 */         lastF = (d.div.settings()).formation;
/* 222 */         distGaps++;
/*     */       } 
/*     */     } 
/* 225 */     distFull -= distGaps * 32.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     double dx = x1;
/* 231 */     double dy = y1;
/* 232 */     double extra = 0.0D;
/* 233 */     DIV_FORMATION dIV_FORMATION1 = (((DivDeployer.DivDeployB)this.selected.get(0)).div.settings()).formation;
/* 234 */     for (DivDeployer.DivDeployB d : this.selected) {
/* 235 */       if ((d.div.settings()).formation != dIV_FORMATION1) {
/* 236 */         dIV_FORMATION1 = (d.div.settings()).formation;
/* 237 */         dx += 32.0D * this.vec.nX();
/* 238 */         dy += 32.0D * this.vec.nY();
/*     */       } 
/* 240 */       double dist = distFull * d.div.menNrOf() / menTotal;
/* 241 */       dist += extra;
/* 242 */       extra = dist - ((d.div.settings()).formation.size(d.div) * (int)(dist / (d.div.settings()).formation.size(d.div)));
/*     */       
/* 244 */       d.width = (int)dist;
/* 245 */       d.x1 = (int)dx;
/* 246 */       d.y1 = (int)dy;
/* 247 */       d.dx = this.vec.nX();
/* 248 */       d.dy = this.vec.nY();
/*     */       
/* 250 */       dx += ((d.div.settings()).formation.size(d.div) * (int)(dist / (d.div.settings()).formation.size(d.div))) * this.vec.nX();
/* 251 */       dy += ((d.div.settings()).formation.size(d.div) * (int)(dist / (d.div.settings()).formation.size(d.div))) * this.vec.nY();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 256 */     return (LIST<DivDeployer.DivDeployB>)this.selected;
/*     */   }
/*     */   
/*     */   public void stop(LIST<Div> divs) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\formation\DivDeployerUser.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
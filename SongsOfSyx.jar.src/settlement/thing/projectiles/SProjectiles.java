/*     */ package settlement.thing.projectiles;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.debug.Profiler;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SProjectiles
/*     */   extends SETT.SettResource
/*     */ {
/*  26 */   final Map map = new Map(SETT.PWIDTH, SETT.PHEIGHT);
/*  27 */   final PData data = new PData(this.map);
/*  28 */   private final Updater updater = new Updater(this);
/*  29 */   private final PRenderer ren = new PRenderer(this);
/*     */   
/*  31 */   public static CharSequence ¤¤OUT_OF_RANGE = "¤Out of range!";
/*  32 */   public static CharSequence ¤¤FRIENDLIES = "¤Ally subjects are in the trajectory and might get hit!";
/*  33 */   public static CharSequence ¤¤TERRAIN = "¤Trajectory blocked by terrain";
/*     */   
/*     */   static {
/*  36 */     D.ts(SProjectiles.class);
/*     */   }
/*     */   
/*     */   public SProjectiles() {
/*  40 */     super("PROJECTILES", true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  47 */     this.map.clear();
/*  48 */     this.data.saver.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  54 */     this.data.saver.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  59 */     this.map.clear();
/*  60 */     this.data.saver.clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void launchDummy(int x, int y, int height, Trajectory t, Projectile type, double ref, ENTITY e) {
/*  73 */     int i = this.data.create(x, y, height, t.vx(), t.vy(), t.vz(), type, ref, e);
/*  74 */     if (i != -1)
/*  75 */       this.data.live(i, false); 
/*     */   }
/*     */   
/*     */   public void launch(int x, int y, int height, Trajectory t, Projectile type, double ran, double ref, ENTITY e) {
/*  79 */     this.data.create(x, y, height, t.vx() * RND.rFloat1(ran), t.vy() * RND.rFloat1(ran), t.vz() * RND.rFloat1(ran), type, ref, e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds, Profiler profiler) {
/*  85 */     for (int i = 0; i < this.data.last(); i++) {
/*  86 */       this.updater.update(i, ds);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch s, float ds, int zoomout, RenderData renData) {
/*  92 */     this.ren.renderAbove(r, s, ds, zoomout, renData);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  98 */   private static final Trajectory traj = new Trajectory();
/*     */ 
/*     */   
/*     */   public static CharSequence problem(Div dd, Div target) {
/* 102 */     int tx = target.reporter.body().cX();
/* 103 */     int ty = target.reporter.body().cY();
/* 104 */     return problem(traj, dd, tx, ty);
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence problem(Trajectory work, Div dd, int destX, int destY) {
/* 109 */     int startX = dd.reporter.body().cX();
/* 110 */     int startY = dd.reporter.body().cY();
/* 111 */     int fx = startX >> 6;
/* 112 */     int fy = startY >> 6;
/* 113 */     if (!SETT.IN_BOUNDS(fx, fy)) {
/* 114 */       return Dic.¤¤Problem;
/*     */     }
/* 116 */     int tx = destX >> 6;
/* 117 */     int ty = destY >> 6;
/* 118 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 119 */       return Dic.¤¤Problem;
/*     */     }
/* 121 */     int h = SETT.TERRAIN().get(fx, fy).heightEnt(fx, fy) * 64 + 133;
/* 122 */     h -= SETT.TERRAIN().get(tx, ty).heightEnt(tx, ty) * 64 + 64;
/*     */     
/* 124 */     EquipRange am = dd.settings().ammo();
/* 125 */     if (am == null) {
/* 126 */       return ¤¤OUT_OF_RANGE;
/*     */     }
/* 128 */     double ref = dd.settings().ammoRef();
/* 129 */     double speed = am.projectile.velocity(ref);
/*     */     
/* 131 */     if (speed <= 0.0D) {
/* 132 */       return Dic.¤¤Problem;
/*     */     }
/* 134 */     CharSequence problem = ¤¤OUT_OF_RANGE;
/*     */     
/* 136 */     double angle = am.projectile.maxAngle(ref);
/*     */     
/* 138 */     if (work.calcLow(h, startX, startY, destX, destY, angle, speed)) {
/* 139 */       for (int di = 0; di < DIR.NORTHO.size(); di++) {
/* 140 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 141 */         int x = startX + d.x() * dd.reporter.body().width() / 2;
/* 142 */         int y = startY + d.y() * dd.reporter.body().height() / 2;
/* 143 */         problem = trajectoryProblem(dd.army(), work, x, y);
/* 144 */         if (problem == null)
/* 145 */           return null; 
/*     */       } 
/* 147 */     } else if (work.calcHigh(h, startX, startY, destX, destY, angle, speed)) {
/* 148 */       for (int di = 0; di < DIR.NORTHO.size(); di++) {
/* 149 */         DIR d = (DIR)DIR.ORTHO.get(di);
/* 150 */         int x = startX + d.x() * dd.reporter.body().width() / 2;
/* 151 */         int y = startY + d.y() * dd.reporter.body().height() / 2;
/* 152 */         problem = trajectoryProblem(dd.army(), work, x, y);
/* 153 */         if (problem == null) {
/* 154 */           return null;
/*     */         }
/*     */       } 
/*     */     } 
/* 158 */     return problem;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CharSequence problem(Army a, Trajectory work, int startX, int startY, int destX, int destY, double angle, double speed) {
/* 165 */     int fx = startX >> 6;
/* 166 */     int fy = startY >> 6;
/* 167 */     if (!SETT.IN_BOUNDS(fx, fy)) {
/* 168 */       return Dic.¤¤Problem;
/*     */     }
/* 170 */     int tx = destX >> 6;
/* 171 */     int ty = destY >> 6;
/* 172 */     if (!SETT.IN_BOUNDS(tx, ty)) {
/* 173 */       return Dic.¤¤Problem;
/*     */     }
/* 175 */     int h = SETT.TERRAIN().get(fx, fy).heightEnt(fx, fy) * 64 + 133;
/* 176 */     h -= SETT.TERRAIN().get(tx, ty).heightEnt(tx, ty) * 64 + 64;
/*     */     
/* 178 */     CharSequence problem = ¤¤OUT_OF_RANGE;
/*     */     
/* 180 */     if (work.calcLow(h, startX, startY, destX, destY, angle, speed)) {
/* 181 */       problem = trajectoryProblem(a, work, startX, startY);
/*     */     }
/*     */     
/* 184 */     if (problem != null && work.calcHigh(h, startX, startY, destX, destY, angle, speed)) {
/* 185 */       problem = trajectoryProblem(a, work, startX, startY);
/*     */     }
/*     */     
/* 188 */     return problem;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CharSequence trajectoryProblem(Army a, Trajectory traj, int sx, int sy) {
/* 193 */     int tx = sx >> 6;
/* 194 */     int ty = sy >> 6;
/* 195 */     int h = SETT.TERRAIN().get(tx, ty).heightEnt(tx, ty) * 64 + 133;
/* 196 */     return Updater.test(a, traj, h, sx, sy);
/*     */   }
/*     */   
/*     */   public static int releaseHeight(int tx, int ty) {
/* 200 */     return SETT.TERRAIN().get(tx, ty).heightEnt(tx, ty) * 64 + 133;
/*     */   }
/*     */   
/*     */   public static int hitHeight(int tx, int ty) {
/* 204 */     return SETT.TERRAIN().get(tx, ty).heightEnt(tx, ty) * 64 + 64;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\projectiles\SProjectiles.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
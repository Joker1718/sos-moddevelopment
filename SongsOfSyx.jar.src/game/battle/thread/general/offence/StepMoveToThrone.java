/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Bitmap2D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StepMoveToThrone
/*     */ {
/*     */   private final StrategosUtil util;
/*     */   private final Context context;
/*     */   private final Bitmap2D blocked;
/*     */   private final Res res;
/*     */   
/*     */   public StepMoveToThrone(StrategosUtil util, Context context) {
/* 179 */     this.res = new Res();
/*     */     this.util = util;
/*     */     this.context = context;
/*     */     this.blocked = context.block;
/*     */   }
/*     */   
/*     */   public void init() {
/*     */     this.blocked.clear();
/*     */   }
/*     */   
/*     */   public boolean setToThrone() {
/*     */     this.context.map.clear();
/*     */     int am = 0;
/*     */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*     */       Div d = (Div)this.util.getArmy().divisions().get(di);
/*     */       if (d.active() && !this.context.deployedToLine.get(di) && !d.status().isFighting()) {
/*     */         this.context.map.add(d);
/*     */         am++;
/*     */       } 
/*     */     } 
/*     */     if (am == 0)
/*     */       return false; 
/*     */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/*     */     f.init(this);
/*     */     f.pushSloppy(this.util.getDestCoo(), 0.0D);
/*     */     while (f.hasMore()) {
/*     */       PathTile t = f.pollSmallest();
/*     */       for (Div m : this.context.map.get(t.x(), t.y())) {
/*     */         if (this.context.deployedToLine.get(m.indexArmy()))
/*     */           continue; 
/*     */         this.context.deployedToLine.set(m.indexArmy(), true);
/*     */         f.done();
/*     */         PathTile dest = setDest(m, this.blocked, t);
/*     */         block(t, dest, this.blocked);
/*     */         this.util.divDeployer.deployTile(m, this.res.destX, this.res.destY, this.res.destDir);
/*     */         return true;
/*     */       } 
/*     */       for (int i = 0; i < DIR.ALL.size(); i++) {
/*     */         DIR dir = (DIR)DIR.ALL.get(i);
/*     */         int dx = t.x() + dir.x();
/*     */         int dy = t.y() + dir.y();
/*     */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */           double cost = cost(this.util, dx, dy);
/*     */           if (cost > 0.0D) {
/*     */             if (!dir.isOrtho()) {
/*     */               cost = Math.max(cost, cost(this.util, dx, t.y()));
/*     */               cost = Math.max(cost, cost(this.util, t.x(), dy));
/*     */             } 
/*     */             if (this.blocked.is(dx, dy))
/*     */               cost *= 4.0D; 
/*     */             f.pushSmaller(dx, dy, t.getValue() + dir.tileDistance() * cost, t);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     f.done();
/*     */     return false;
/*     */   }
/*     */   
/*     */   public static double cost(StrategosUtil context, int dx, int dy) {
/*     */     AVAILABILITY a = (SETT.PATH()).availability.get(dx, dy);
/*     */     if (a.isSolid(context.getArmy()) || SETT.TERRAIN().get(dx, dy) instanceof settlement.tilemap.terrain.TFortification.Tile)
/*     */       return 3.0D + (GAME.ARMIES()).map.strength.get(dx, dy) / 640.0D; 
/*     */     double res = 1.0D;
/*     */     double s = (SETT.ENV()).map.SPACE.get(dx, dy);
/*     */     if (s < 0.5D)
/*     */       return res + 2.0D + a.movementSpeedI; 
/*     */     return res + a.movementSpeedI;
/*     */   }
/*     */   
/*     */   private static void block(PathTile t, PathTile dest, Bitmap2D toBlock) {
/*     */     while (t != dest) {
/*     */       for (int i = 0; i < DIR.ORTHO.size(); i++)
/*     */         toBlock.set((COORDINATE)t, (DIR)DIR.ORTHO.get(i), true); 
/*     */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */   
/*     */   private PathTile setDest(Div div, Bitmap2D blocked, PathTile t) {
/*     */     if (initBlocked(div, DIR.C, t.x(), t.y(), t))
/*     */       return t; 
/*     */     if (t.getParent() == null) {
/*     */       this.res.destX = t.x();
/*     */       this.res.destY = t.y();
/*     */       this.res.destDir = DIR.C;
/*     */       return t;
/*     */     } 
/*     */     PathTile prev = null;
/*     */     boolean b = true;
/*     */     while (t.getParent() != null) {
/*     */       if (initBlocked(div, blocked, t))
/*     */         return t.getParent(); 
/*     */       if (!b && blocked.is((COORDINATE)t.getParent())) {
/*     */         this.res.destX = t.x();
/*     */         this.res.destY = t.y();
/*     */         this.res.destDir = DIR.get((COORDINATE)t, (COORDINATE)t.getParent());
/*     */         return t;
/*     */       } 
/*     */       prev = t;
/*     */       b = false;
/*     */       t = t.getParent();
/*     */     } 
/*     */     this.res.destX = t.x();
/*     */     this.res.destY = t.y();
/*     */     this.res.destDir = DIR.get((COORDINATE)prev, (COORDINATE)t);
/*     */     return t;
/*     */   }
/*     */   
/*     */   private boolean initBlocked(Div div, Bitmap2D blocked, PathTile block) {
/*     */     if (initBlocked(div, DIR.get((COORDINATE)block.getParent(), (COORDINATE)block), block.getParent().x(), block.getParent().y(), block))
/*     */       return true; 
/*     */     if (initBlocked(div, DIR.get((COORDINATE)block.getParent(), (COORDINATE)block), block.getParent().x(), block.y(), block))
/*     */       return true; 
/*     */     if (initBlocked(div, DIR.get((COORDINATE)block.getParent(), (COORDINATE)block), block.x(), block.getParent().y(), block))
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private boolean initBlocked(Div div, DIR d, int dx, int dy, PathTile block) {
/*     */     if ((SETT.PATH()).availability.get(dx, dy).isSolid(div.army()) || (BattleStatus.map()).hasEnemy.is(dx, dy, this.util.getArmy())) {
/*     */       this.res.destX = dx;
/*     */       this.res.destY = dy;
/*     */       this.res.destDir = d;
/*     */       return true;
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   private class Res {
/*     */     int destX;
/*     */     int destY;
/*     */     DIR destDir;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepMoveToThrone.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
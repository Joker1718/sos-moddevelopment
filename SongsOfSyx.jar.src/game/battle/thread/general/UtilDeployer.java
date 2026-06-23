/*     */ package game.battle.thread.general;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormation;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UtilDeployer
/*     */ {
/*     */   private final StrategosUtil context;
/*     */   private final BattleOrderTask task;
/*     */   
/*     */   public UtilDeployer(StrategosUtil context) {
/*  27 */     this.task = new BattleOrderTask();
/*     */     
/*  29 */     this.old = new DivFormationImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  75 */     this.oldDest = new DivFormationImp(); this.context = context;
/*     */   } DivFormationImp old; DivFormationImp oldDest; public DivFormation deploy(Div d, int x1, int y1, int wi, double dx, double dy) { int m = d.menNrOf(); if (m == 0)
/*     */       return null;  int w = (int)Math.sqrt(m); if (w == 0)
/*     */       return null;  DivFormationImp f = this.context.deployer.deploy((DIV_SPEC)d.info, m, (d.settings()).formation, x1, y1, dx, dy, wi, this.context.getArmy()); if (f != null) { (d.order()).task.get((Copyable)this.task); if (this.task.task() == BattleOrderTask.DIVTASK.MOVE || this.task.task() == BattleOrderTask.DIVTASK.STOP) { (d.order()).dest.get((Copyable)this.old); if (this.old.isSameAs(f, d))
/*  79 */           return (DivFormation)this.old;  }  (d.order()).dest.set((Copyable)f); this.task.move(d); (d.order()).task.set((Copyable)this.task); } else { this.task.stop(d); (d.order()).task.set((Copyable)this.task); }  return (DivFormation)f; } private DivFormationImp moveToDest(Div d, int tx, int ty, DIR dir) { int rm = (int)(1.0D + Math.sqrt(d.menNrOf() / 2.0D)) * (d.settings()).formation.size(d);
/*  80 */     DivFormationImp f = this.context.deployer.deployArroundCentre((DIV_SPEC)d.info, d.menNrOf(), (d.settings()).formation, (tx << 6) + 32, (ty << 6) + 32, dir.xN(), dir.yN(), rm, d.army());
/*     */ 
/*     */     
/*  83 */     if (f == null) {
/*  84 */       this.task.stop(d);
/*  85 */       (d.order()).task.set((Copyable)this.task);
/*  86 */       return null;
/*     */     } 
/*     */     
/*  89 */     (d.order()).dest.set((Copyable)f);
/*  90 */     this.task.move(d);
/*  91 */     (d.order()).task.set((Copyable)this.task);
/*  92 */     return f; }
/*     */   
/*     */   public DivFormationImp deployTile(Div d, int tx, int ty, DIR dir) {
/*     */     if (!attackTile(tx, ty, d))
/*     */       return moveToDest(d, tx, ty, dir); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   private boolean attackTile(int tx, int ty, Div d) {
/* 101 */     if (SETT.IN_BOUNDS(tx, ty) && (SETT.PATH()).availability.get(tx, ty).isSolid(this.context.getArmy())) {
/*     */       
/* 103 */       (d.order()).task.get((Copyable)this.task);
/*     */       
/* 105 */       if (this.task.targetTileX() != -1 && 
/* 106 */         COORDINATE.tileDistance(this.task.targetTileX(), this.task.targetTileY(), tx, ty) < 3.0D) {
/* 107 */         return true;
/*     */       }
/*     */       
/* 110 */       this.task.attack(tx, ty, d);
/* 111 */       (d.order()).task.set((Copyable)this.task);
/* 112 */       return true;
/*     */     } 
/* 114 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\UtilDeployer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
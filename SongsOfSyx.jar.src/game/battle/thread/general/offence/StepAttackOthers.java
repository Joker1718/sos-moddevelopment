/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import game.battle.thread.order.BattleOrderTask;
/*     */ import game.battle.util.Copyable;
/*     */ import init.constant.Config;
/*     */ import java.util.Iterator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ final class StepAttackOthers
/*     */ {
/*     */   private final StrategosUtil util;
/*     */   private final Context context;
/*  21 */   private final Bitmap1D attacked = new Bitmap1D((Config.battle()).DIVISIONS_PER_ARMY, false);
/*     */ 
/*     */ 
/*     */   
/*     */   private final BattleOrderTask task;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/*  31 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*  32 */       Div d = (Div)this.util.getArmy().divisions().get(di);
/*  33 */       if (valid(d)) {
/*     */ 
/*     */         
/*  36 */         this.context.trickedDivs[di] = this.context.trickedDivs[di] + 1;
/*  37 */         this.context.deployedToLine.set(di, false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean attack() {
/*  46 */     this.context.map.clear();
/*     */ 
/*     */     
/*  49 */     int am = 0;
/*  50 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*  51 */       Div d = (Div)this.util.getArmy().divisions().get(di);
/*  52 */       if (valid(d))
/*     */       {
/*     */         
/*  55 */         if (!this.context.deployedToLine.get(di))
/*     */         {
/*  57 */           if (this.context.trickedDivs[di] >= 4) {
/*     */             
/*  59 */             this.context.map.add(d);
/*  60 */             am++;
/*     */           }  }  } 
/*     */     } 
/*  63 */     if (am == 0) {
/*  64 */       return false;
/*     */     }
/*  66 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/*  67 */     f.init(this);
/*  68 */     f.pushSloppy(this.util.getDestCoo(), 0.0D);
/*  69 */     this.attacked.clear();
/*  70 */     for (int i = 0; i < (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/*  71 */       Div d = (Div)this.util.getArmy().enemy().divisions().get(i);
/*  72 */       if (d.active()) {
/*     */ 
/*     */         
/*  75 */         int tx = d.centre().ctX();
/*  76 */         int ty = d.centre().ctY();
/*  77 */         if (SETT.IN_BOUNDS(tx, ty)) {
/*  78 */           f.pushSloppy(tx, ty, 0.0D);
/*  79 */           f.setValue2(tx, ty, d.indexArmy());
/*     */         } 
/*     */       } 
/*     */     } 
/*  83 */     am = 0;
/*  84 */     while (f.hasMore()) {
/*     */       
/*  86 */       PathTile t = f.pollSmallest();
/*     */       
/*  88 */       if (t.getValue() > 100.0F) {
/*     */         break;
/*     */       }
/*  91 */       if (t.getParent() != null) {
/*  92 */         t.setValue2(t.getParent().getValue2());
/*     */       }
/*  94 */       Div enemy = (Div)this.util.getArmy().enemy().divisions().get((int)t.getValue2());
/*     */       
/*  96 */       if (enemy == null) {
/*     */         continue;
/*     */       }
/*  99 */       if (this.attacked.get(enemy.indexArmy())) {
/*     */         continue;
/*     */       }
/* 102 */       Iterator<Div> iterator = this.context.map.get(t.x(), t.y()).iterator(); if (iterator.hasNext()) { Div d = iterator.next();
/* 103 */         attack(d, enemy);
/* 104 */         am++; }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 109 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/* 110 */         DIR dir = (DIR)DIR.ALL.get(j);
/* 111 */         int dx = t.x() + dir.x();
/* 112 */         int dy = t.y() + dir.y();
/* 113 */         if (SETT.IN_BOUNDS(dx, dy)) {
/* 114 */           double cost = cost(this.util, dx, dy);
/*     */           
/* 116 */           if (cost > 0.0D) {
/* 117 */             if (!dir.isOrtho()) {
/* 118 */               cost = Math.min(cost, cost(this.util, dx, t.y()));
/* 119 */               cost = Math.min(cost, cost(this.util, t.x(), dy));
/*     */             } 
/* 121 */             f.pushSmaller(dx, dy, t.getValue() + dir.tileDistance() * cost, t);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 127 */     f.done();
/* 128 */     return (am > 0);
/*     */   }
/*     */   
/* 131 */   public StepAttackOthers(StrategosUtil context, Context c) { this.task = new BattleOrderTask();
/*     */     this.util = context;
/*     */     this.context = c; } private void attack(Div mDiv, Div enemy) {
/* 134 */     if (mDiv.settings().ammo() != null) {
/* 135 */       this.task.attackRanged(enemy, mDiv);
/*     */     } else {
/* 137 */       this.task.attackMelee(enemy, mDiv);
/*     */     } 
/* 139 */     (mDiv.order()).task.set((Copyable)this.task);
/* 140 */     this.context.deployedToLine.set(mDiv.indexArmy(), true);
/* 141 */     this.attacked.set(enemy.indexArmy(), true);
/* 142 */     (mDiv.settings()).running = true;
/* 143 */     (mDiv.settings()).formation = (enemy.settings().ammo() == null) ? DIV_FORMATION.TIGHT : DIV_FORMATION.LOOSE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static double cost(StrategosUtil context, int dx, int dy) {
/* 149 */     AVAILABILITY a = (SETT.PATH()).availability.get(dx, dy);
/* 150 */     if (a.isSolid(context.getArmy()) || SETT.TERRAIN().get(dx, dy) instanceof settlement.tilemap.terrain.TFortification.Tile) {
/* 151 */       return 1.0D;
/*     */     }
/*     */     
/* 154 */     double res = 1.0D;
/* 155 */     double s = (SETT.ENV()).map.SPACE.get(dx, dy);
/* 156 */     if (s < 0.5D)
/* 157 */       return res + 2.0D + a.movementSpeedI; 
/* 158 */     return res + a.movementSpeedI;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean valid(Div d) {
/* 163 */     if (!d.active())
/* 164 */       return false; 
/* 165 */     if (d.status().isFighting())
/* 166 */       return false; 
/* 167 */     if (this.context.distsToLine[d.indexArmy()] + this.context.distsFromLineToBlob[d.indexArmy()] > 16) {
/* 168 */       return false;
/*     */     }
/* 170 */     (d.order()).task.get((Copyable)this.task);
/*     */     
/* 172 */     if (this.task.task() != BattleOrderTask.DIVTASK.STOP) {
/* 173 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 177 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepAttackOthers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
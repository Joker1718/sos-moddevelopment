/*     */ package game.battle.thread.general.offence;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.general.StrategosUtil;
/*     */ import init.constant.Config;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ final class StepEarlyThrone
/*     */ {
/*     */   private final StrategosUtil util;
/*     */   private final Context context;
/*  22 */   private final ArrayList<Dep> dall = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*  23 */   private final ArrayList<Dep> deps = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/*     */ 
/*     */ 
/*     */   
/*     */   private final Rec tiles;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void se2tToThrone() {
/*  33 */     if (this.context.blob.is(THRONE.coo())) {
/*     */       return;
/*     */     }
/*  36 */     this.context.map.clear();
/*  37 */     this.deps.clearSloppy();
/*  38 */     this.context.block.clear();
/*     */     
/*  40 */     boolean has = false;
/*     */     
/*  42 */     for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/*  43 */       Div d = (Div)this.util.getArmy().divisions().get(di);
/*  44 */       if (d.active() && !this.context.deployedToLine.get(di) && !d.status().isFighting()) {
/*  45 */         this.context.map.add(d);
/*  46 */         has = true;
/*     */       } 
/*     */     } 
/*     */     
/*  50 */     if (!has) {
/*     */       return;
/*     */     }
/*  53 */     PathUtilOnline.Flooder f = this.util.flooder.getFlooder();
/*  54 */     f.init(this);
/*  55 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  56 */       f.pushSloppy(THRONE.coo(), (DIR)DIR.ORTHO.get(i), 0.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  62 */     while (f.hasMore()) {
/*     */       
/*  64 */       PathTile t = f.pollSmallest();
/*     */       
/*  66 */       LIST<Div> divs = this.context.map.get(t.x(), t.y());
/*  67 */       if (divs.size() > 0 && isUnblobbed(t)) {
/*  68 */         for (Div div : divs) {
/*  69 */           preDeploy(t, div);
/*     */         }
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  76 */       for (int j = 0; j < DIR.ALL.size(); j++) {
/*  77 */         DIR dir = (DIR)DIR.ALL.get(j);
/*  78 */         int dx = t.x() + dir.x();
/*  79 */         int dy = t.y() + dir.y();
/*  80 */         if (SETT.IN_BOUNDS(dx, dy)) {
/*  81 */           double cost = cost(this.util, dx, dy);
/*  82 */           if (cost > 0.0D && !dir.isOrtho()) {
/*  83 */             cost = Math.min(cost, cost(this.util, dx, t.y()));
/*  84 */             cost = Math.min(cost, cost(this.util, t.x(), dy));
/*     */           } 
/*  86 */           if (cost > 0.0D) {
/*  87 */             f.pushSmaller(dx, dy, t.getValue() + dir.tileDistance() * cost, t);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  93 */     f.done();
/*     */     
/*  95 */     int am = 0;
/*     */     
/*  97 */     for (Dep dep : this.deps) {
/*  98 */       Div div = (Div)this.util.getArmy().divisions().get(dep.di);
/*  99 */       if (this.util.divDeployer.deployTile(div, dep.tx, dep.ty, dep.d) != null) {
/* 100 */         am++;
/* 101 */         this.context.deployedToLine.set(div.indexArmy(), true);
/* 102 */         if (am > 3) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public StepEarlyThrone(StrategosUtil util, Context context) {
/* 111 */     this.tiles = new Rec();
/*     */     this.util = util;
/*     */     this.context = context;
/*     */     while (this.dall.hasRoom())
/* 115 */       this.dall.add(new Dep());  } private void preDeploy(PathTile t, Div div) { while (t.getParent() != null && !this.context.block.is((COORDINATE)t.getParent())) {
/* 116 */       t = t.getParent();
/*     */     }
/* 118 */     if (this.context.block.is((COORDINATE)t)) {
/*     */       return;
/*     */     }
/* 121 */     Dep res = (Dep)this.dall.get(this.deps.size());
/* 122 */     res.di = div.indexArmy();
/* 123 */     res.tx = t.x();
/* 124 */     res.ty = t.y();
/* 125 */     res.d = DIR.get(THRONE.coo(), (COORDINATE)t);
/* 126 */     this.deps.add(res);
/*     */     
/* 128 */     int w = (int)(Math.sqrt(div.men()) + 2.0D);
/* 129 */     this.tiles.setDim(w);
/* 130 */     this.tiles.moveC((COORDINATE)t);
/*     */     
/* 132 */     for (COORDINATE c : this.tiles) {
/* 133 */       this.context.block.set(c, true);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isUnblobbed(PathTile t) {
/* 140 */     while (t != null) {
/* 141 */       if (this.context.blob.is((COORDINATE)t))
/* 142 */         return false; 
/* 143 */       t = t.getParent();
/*     */     } 
/* 145 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double cost(StrategosUtil context, int dx, int dy) {
/* 150 */     AVAILABILITY a = (SETT.PATH()).availability.get(dx, dy);
/* 151 */     if (a.isSolid(context.getArmy()) || SETT.TERRAIN().get(dx, dy) instanceof settlement.tilemap.terrain.TFortification.Tile) {
/* 152 */       return -1.0D;
/*     */     }
/* 154 */     double res = 1.0D;
/* 155 */     double s = (SETT.ENV()).map.SPACE.get(dx, dy);
/* 156 */     if (s < 0.5D)
/* 157 */       return res + 2.0D + a.movementSpeedI; 
/* 158 */     return res + a.movementSpeedI;
/*     */   }
/*     */   
/*     */   private class Dep {
/*     */     int di;
/*     */     int tx;
/*     */     int ty;
/*     */     DIR d;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\StepEarlyThrone.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
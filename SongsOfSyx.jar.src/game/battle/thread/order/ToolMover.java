/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPlacability;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.DivPositionImp;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import init.constant.Config;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class ToolMover
/*     */ {
/*     */   private final DivFormationImp positions;
/*     */   private final TREE toTree;
/*     */   private final TREE fromTree;
/*     */   private final POS[] toPosses;
/*     */   private final POS[] fromPosses;
/*     */   private final ArrayList<POS> cache;
/*     */   private boolean[] tosThatHasBeenPlaced;
/*     */   private final PathUtilOnline pu;
/*  29 */   private final VectorImp vec = new VectorImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Rec centre;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void rearrangeDest(DivFormationImp from, DivFormationImp to) {
/*  51 */     if (from.deployed() == 0 || to.deployed() == 0) {
/*  52 */       this.positions.copy(to);
/*  53 */       from.copy(this.positions);
/*     */       return;
/*     */     } 
/*     */     int i;
/*  57 */     for (i = 0; i < to.deployed(); i++) {
/*  58 */       this.tosThatHasBeenPlaced[i] = false;
/*     */     }
/*  60 */     this.positions.copy(to);
/*     */     
/*  62 */     centers((DivPosition)from, to);
/*     */     
/*  64 */     if (this.toTree.hasMore()) {
/*  65 */       for (i = 0; i < to.deployed(); i++) {
/*  66 */         if (!this.tosThatHasBeenPlaced[i]) {
/*  67 */           COORDINATE c = to.pixel(((POS)this.toTree.pollGreatest()).i);
/*  68 */           this.positions.set(i, c.x(), c.y());
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  73 */     to.copy(this.positions);
/*  74 */     to.deployFinish(this.pu.filler, (DIV_SPEC)BattleOrderUpdater.Plan.div.info);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivFormationImp getFromMovedIntoTo(DivPositionImp current, DivFormationImp to) {
/*  80 */     if (current == this.positions || to == this.positions) {
/*  81 */       throw new RuntimeException();
/*     */     }
/*  83 */     if (current.deployed() == 0 || to.deployed() == 0) {
/*  84 */       this.positions.copy(to);
/*  85 */       return this.positions;
/*     */     } 
/*     */     int i;
/*  88 */     for (i = 0; i < to.deployed(); i++) {
/*  89 */       this.tosThatHasBeenPlaced[i] = false;
/*     */     }
/*  91 */     this.positions.copy(to);
/*     */     
/*  93 */     centers((DivPosition)current, to);
/*     */     
/*  95 */     if (this.toTree.hasMore()) {
/*  96 */       for (i = 0; i < to.deployed(); i++) {
/*  97 */         if (!this.tosThatHasBeenPlaced[i]) {
/*  98 */           COORDINATE c = to.pixel(((POS)this.toTree.pollGreatest()).i);
/*  99 */           this.positions.set(i, c.x(), c.y());
/*     */         } 
/*     */       } 
/*     */     }
/* 103 */     this.positions.deployFinish(this.pu.filler, (DIV_SPEC)BattleOrderUpdater.Plan.div.info);
/* 104 */     return this.positions;
/*     */   }
/*     */   
/* 107 */   ToolMover(PathUtilOnline pu) { this.centre = new Rec(); int maxmen = (Config.battle()).MEN_PER_DIVISION; this.positions = new DivFormationImp(); this.tosThatHasBeenPlaced = new boolean[maxmen]; this.toTree = new TREE(maxmen); this.fromTree = new TREE(maxmen); this.toPosses = new POS[maxmen]; this.fromPosses = new POS[maxmen]; for (int i = 0; i < maxmen; i++) {
/*     */       this.toPosses[i] = new POS(); this.fromPosses[i] = new POS();
/*     */     }  this.cache = new ArrayList(maxmen);
/* 110 */     this.pu = pu; } private void centers(DivPosition from, DivFormationImp to) { this.toTree.clear();
/* 111 */     this.fromTree.clear();
/*     */     
/* 113 */     this.centre.clear();
/* 114 */     for (int i = 0; i < from.deployed() && i < to.deployed(); i++) {
/* 115 */       this.centre.unify(from.pixel(i).x(), from.pixel(i).y());
/*     */     }
/*     */ 
/*     */     
/* 119 */     double toDistX = (to.body().cX() - this.centre.cX());
/* 120 */     double toDistY = (to.body().cY() - this.centre.cY());
/*     */     int j;
/* 122 */     for (j = 0; j < from.deployed() && j < to.deployed(); j++) {
/* 123 */       double dx = (from.pixel(j).x() - this.centre.cX());
/* 124 */       double dy = (from.pixel(j).y() - this.centre.cY());
/* 125 */       double d = Math.sqrt(dx * dx + dy * dy);
/* 126 */       (this.fromPosses[j]).i = j;
/* 127 */       (this.fromPosses[j]).value = d;
/* 128 */       this.fromTree.add(this.fromPosses[j]);
/*     */     } 
/*     */ 
/*     */     
/* 132 */     for (j = 0; j < from.deployed() && j < to.deployed(); j++) {
/* 133 */       double dx = to.pixel(j).x() - toDistX - this.centre.cX();
/* 134 */       double dy = to.pixel(j).y() - toDistY - this.centre.cY();
/* 135 */       double d = Math.sqrt(dx * dx + dy * dy);
/* 136 */       (this.toPosses[j]).i = j;
/* 137 */       (this.toPosses[j]).value = d;
/* 138 */       this.toTree.add(this.toPosses[j]);
/*     */     } 
/*     */     
/* 141 */     double M = (Math.max(to.formation().size(BattleOrderUpdater.Plan.div), 0) * 2);
/*     */     
/* 143 */     while (this.toTree.hasMore() && this.fromTree.hasMore()) {
/* 144 */       POS pTo = (POS)this.toTree.pollGreatest();
/*     */       
/* 146 */       this.cache.clear();
/*     */ 
/*     */       
/* 149 */       POS pFrom = (POS)this.fromTree.pollGreatest();
/* 150 */       this.cache.add(pFrom);
/* 151 */       double max = pFrom.value;
/* 152 */       double dx = to.pixel(pTo.i).x() - from.pixel(pFrom.i).x() + toDistX;
/* 153 */       double dy = to.pixel(pTo.i).y() - from.pixel(pFrom.i).y() + toDistY;
/* 154 */       double lastDist = Math.sqrt(dx * dx + dy * dy);
/*     */       
/* 156 */       while (this.fromTree.hasMore()) {
/* 157 */         POS candidate = (POS)this.fromTree.pollGreatest();
/* 158 */         this.cache.add(candidate);
/*     */         
/* 160 */         if (Math.abs(candidate.value - max) > M) {
/*     */           break;
/*     */         }
/* 163 */         dx = to.pixel(pTo.i).x() - from.pixel(candidate.i).x() + toDistX;
/* 164 */         dy = to.pixel(pTo.i).y() - from.pixel(candidate.i).y() + toDistY;
/* 165 */         double dist = Math.sqrt(dx * dx + dy * dy);
/* 166 */         if (dist < lastDist) {
/* 167 */           lastDist = dist;
/* 168 */           pFrom = candidate;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 174 */       COORDINATE t = to.pixel(pTo.i);
/* 175 */       this.positions.set(pFrom.i, t.x(), t.y());
/* 176 */       this.tosThatHasBeenPlaced[pFrom.i] = true;
/*     */       
/* 178 */       for (int k = 0; k < this.cache.size(); k++) {
/* 179 */         POS p = (POS)this.cache.get(k);
/* 180 */         if (p != pFrom) {
/* 181 */           this.fromTree.add(p);
/*     */         }
/*     */       } 
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean merge(DivFormationImp from, DivFormationImp to) {
/* 196 */     boolean move = false;
/*     */     
/* 198 */     if (from.deployed() != to.deployed()) {
/* 199 */       return false;
/*     */     }
/* 201 */     for (int i = 0; i < to.deployed(); i++) {
/*     */       
/* 203 */       double tx = to.pixel(i).x();
/* 204 */       double ty = to.pixel(i).y();
/* 205 */       if (i >= from.deployed()) {
/* 206 */         move = true;
/* 207 */         from.set(i, (int)tx, (int)ty);
/*     */       } 
/*     */       
/* 210 */       double fx = from.pixel(i).x();
/* 211 */       double fy = from.pixel(i).y();
/* 212 */       int size = from.formation().size(BattleOrderUpdater.Plan.div);
/* 213 */       if (fx != tx || fy != ty) {
/* 214 */         move = true;
/* 215 */         double mag = this.vec.set(fx, fy, tx, ty);
/* 216 */         if (mag > 64.0D)
/* 217 */           mag = 64.0D; 
/* 218 */         int nx = (int)(fx + this.vec.nX() * mag);
/* 219 */         int ny = (int)(fy + this.vec.nY() * mag);
/* 220 */         if (DivPlacability.pixelIsBlocked(nx, ny, size, BattleOrderUpdater.Plan.a)) {
/* 221 */           from.set(i, (int)tx, (int)ty);
/*     */         } else {
/* 223 */           from.set(i, nx, ny);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 229 */     if (move) {
/* 230 */       from.init(to.deployed());
/* 231 */       from.deployFinish(this.pu.filler, (DIV_SPEC)BattleOrderUpdater.Plan.div.info);
/*     */     } 
/* 233 */     return move;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean mergeNeeds(DivFormationImp from, DivFormationImp to) {
/* 239 */     for (int i = 0; i < to.deployed(); i++) {
/* 240 */       double fx = from.pixel(i).x();
/* 241 */       double fy = from.pixel(i).y();
/* 242 */       double tx = to.pixel(i).x();
/* 243 */       double ty = to.pixel(i).y();
/* 244 */       if (fx != ty || fy != ty) {
/* 245 */         double mag = this.vec.set(fx, fy, tx, ty);
/* 246 */         if (mag > 128.0D) {
/* 247 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 252 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class POS
/*     */   {
/*     */     private int i;
/*     */     private double value;
/*     */   }
/*     */   
/*     */   private static class TREE
/*     */     extends Tree<POS>
/*     */   {
/*     */     public TREE(int size) {
/* 266 */       super(size);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean isGreaterThan(ToolMover.POS current, ToolMover.POS cmp) {
/* 271 */       return (current.value > cmp.value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\ToolMover.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
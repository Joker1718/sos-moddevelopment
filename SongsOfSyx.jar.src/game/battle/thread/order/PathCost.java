/*    */ package game.battle.thread.order;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import game.battle.formation.DivPositionImp;
/*    */ import game.battle.thread.status.BattleStatus;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.Bitmap1D;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PathCost
/*    */ {
/* 18 */   private final Bitmap1D map = new Bitmap1D(SETT.TAREA / 4, false);
/* 19 */   private final ArrayList<Div> list = new ArrayList(8);
/*    */ 
/*    */   
/*    */   void init(DivPositionImp ok, int dx, int dy) {
/* 23 */     this.map.clear();
/* 24 */     add(ok);
/*    */     
/* 26 */     this.list.clear();
/* 27 */     BattleStatus.map().get((LISTE)this.list, dx, dy);
/*    */     
/* 29 */     for (Div d : this.list) {
/* 30 */       add((DivPositionImp)d.current());
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void add(DivPositionImp ok) {
/* 36 */     for (int i = 0; i < ok.deployed(); i++) {
/* 37 */       int tx = ok.tile(i).x();
/* 38 */       int ty = ok.tile(i).y();
/*    */       
/* 40 */       for (int y = -4; y <= 4; y++) {
/* 41 */         for (int x = -4; x <= 4; x++) {
/* 42 */           int r = Math.abs(x) + Math.abs(y);
/* 43 */           if (r <= 5) {
/* 44 */             int dx = tx + x;
/* 45 */             int dy = ty + y;
/* 46 */             if (SETT.IN_BOUNDS(dx, dy)) {
/* 47 */               this.map.set((dx >> 1) + (dy >> 2) * SETT.TWIDTH, true);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public double cost(int fx, int fy, DIR d) {
/* 57 */     return cost(fx, fy, fx + d.x(), fy + d.y());
/*    */   }
/*    */   
/*    */   public double cost(int fx, int fy, int tx, int ty) {
/* 61 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 62 */       return -1.0D; 
/* 63 */     AVAILABILITY a = SETT.PATH().getAvailability(fx, ty);
/* 64 */     if (a.isSolid(BattleOrderUpdater.Plan.a))
/* 65 */       return -1.0D; 
/* 66 */     a = SETT.PATH().getAvailability(tx, fy);
/* 67 */     if (a.isSolid(BattleOrderUpdater.Plan.a))
/* 68 */       return -1.0D; 
/* 69 */     a = SETT.PATH().getAvailability(tx, ty);
/* 70 */     if (a.isSolid(BattleOrderUpdater.Plan.a)) {
/* 71 */       return -1.0D;
/*    */     }
/* 73 */     int t = tx + ty * SETT.TWIDTH;
/* 74 */     double res = 1.0D + a.movementSpeedI;
/* 75 */     double space = (SETT.ENV()).map.SPACE.get(t);
/* 76 */     if (space < 0.5D)
/* 77 */       res += 10.0D - 10.0D * space; 
/* 78 */     if (this.map.get((tx >> 1) + (ty >> 2) * SETT.TWIDTH))
/* 79 */       return res; 
/* 80 */     return res;
/*    */   }
/*    */   
/*    */   public double cost(int tx, int ty) {
/* 84 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 85 */       return -1.0D; 
/* 86 */     AVAILABILITY a = SETT.PATH().getAvailability(tx, ty);
/* 87 */     if (a.isSolid(BattleOrderUpdater.Plan.a))
/* 88 */       return -1.0D; 
/* 89 */     int t = tx + ty * SETT.TWIDTH;
/* 90 */     double res = 1.0D + a.movementSpeedI;
/* 91 */     double space = (SETT.ENV()).map.SPACE.get(t);
/* 92 */     if (space < 0.5D)
/* 93 */       res += 10.0D - 10.0D * space; 
/* 94 */     if (this.map.get((tx >> 1) + (ty >> 2) * SETT.TWIDTH))
/* 95 */       return res; 
/* 96 */     return res;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\PathCost.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
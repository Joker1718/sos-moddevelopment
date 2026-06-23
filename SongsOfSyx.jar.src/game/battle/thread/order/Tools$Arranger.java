/*    */ package game.battle.thread.order;
/*    */ 
/*    */ import game.battle.formation.DivFormation;
/*    */ import init.constant.Config;
/*    */ import java.util.Arrays;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.Tree;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class Arranger
/*    */ {
/* 51 */   private final Tree<Point> tree = new Tree<Point>((Config.battle()).MEN_PER_DIVISION)
/*    */     {
/*    */       protected boolean isGreaterThan(Tools.Arranger.Point current, Tools.Arranger.Point cmp)
/*    */       {
/* 55 */         return (current.value > cmp.value);
/*    */       }
/*    */     };
/* 58 */   private final Point[] points = new Point[(Config.battle()).MEN_PER_DIVISION];
/* 59 */   private int[] arranged = Alloc.ii((Config.battle()).MEN_PER_DIVISION);
/*    */   
/*    */   private Arranger() {
/* 62 */     for (int i = 0; i < this.points.length; i++)
/* 63 */       this.points[i] = new Point(); 
/*    */   }
/*    */   
/*    */   public int[] getArrangedPointsForward(DivFormation f) {
/* 67 */     this.tree.clear();
/* 68 */     Arrays.fill(this.arranged, 0);
/* 69 */     double lineX1 = f.start().x();
/* 70 */     double lineY1 = f.start().y();
/* 71 */     double lineDirX = f.dx();
/* 72 */     double lineDirY = f.dy();
/*    */     int i;
/* 74 */     for (i = 0; i < f.deployed(); i++) {
/* 75 */       Point p = this.points[i];
/* 76 */       p.index = i;
/* 77 */       p.value = calculateDistanceToLine(f.px(i), f.py(i), lineX1, lineY1, lineDirX, lineDirY);
/* 78 */       this.tree.add(p);
/*    */     } 
/*    */     
/* 81 */     i = 0;
/* 82 */     while (this.tree.hasMore()) {
/* 83 */       Point p = (Point)this.tree.pollSmallest();
/* 84 */       this.arranged[i++] = p.index;
/*    */     } 
/* 86 */     return this.arranged;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static double calculateDistanceToLine(double pointX, double pointY, double lineX1, double lineY1, double lineDirX, double lineDirY) {
/* 94 */     double A = lineDirY;
/* 95 */     double B = -lineDirX;
/* 96 */     double C = -(A * lineX1 + B * lineY1);
/*    */ 
/*    */     
/* 99 */     return Math.abs(A * pointX + B * pointY + C) / Math.sqrt(A * A + B * B);
/*    */   }
/*    */   
/*    */   private static class Point {
/*    */     int index;
/*    */     double value;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\Tools$Arranger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
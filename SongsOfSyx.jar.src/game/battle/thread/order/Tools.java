/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivDeployer;
/*     */ import game.battle.formation.DivFormation;
/*     */ import init.constant.Config;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CircleCooIterator;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Tools
/*     */ {
/*  21 */   public final PathUtilOnline pather = new PathUtilOnline(SETT.TWIDTH);
/*  22 */   public final DivDeployer deployer = new DivDeployer(this.pather);
/*  23 */   public final PathCost pathCost = new PathCost();
/*  24 */   public final CircleCooIterator circle = new CircleCooIterator(25, this.pather.getFlooder());
/*     */   
/*  26 */   public final ToolMover mover = new ToolMover(this.pather);
/*  27 */   public final ToolsDiv div = new ToolsDiv(this);
/*  28 */   public final ToolsWalk walk = new ToolsWalk(this);
/*  29 */   public final Arranger arranger = new Arranger();
/*  30 */   public final Columns columns = new Columns();
/*     */ 
/*     */   
/*     */   Tools(BattleOrderUpdater.PlanData[] all) {}
/*     */ 
/*     */   
/*     */   public int[] arrageFromFront(DivFormation f) {
/*  37 */     return this.arranger.getArrangedPointsForward(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<Pos> getPosColumnSort(DivFormation f) {
/*  42 */     return (LIST<Pos>)this.columns.sortByColumnRow(f);
/*     */   }
/*     */   
/*     */   public LIST<Pos> getPosRowsSort(DivFormation f) {
/*  46 */     return (LIST<Pos>)this.columns.sortByRow(f);
/*     */   }
/*     */   
/*     */   private static class Arranger
/*     */   {
/*  51 */     private final Tree<Point> tree = new Tree<Point>((Config.battle()).MEN_PER_DIVISION)
/*     */       {
/*     */         protected boolean isGreaterThan(Tools.Arranger.Point current, Tools.Arranger.Point cmp)
/*     */         {
/*  55 */           return (current.value > cmp.value);
/*     */         }
/*     */       };
/*  58 */     private final Point[] points = new Point[(Config.battle()).MEN_PER_DIVISION];
/*  59 */     private int[] arranged = Alloc.ii((Config.battle()).MEN_PER_DIVISION);
/*     */     
/*     */     private Arranger() {
/*  62 */       for (int i = 0; i < this.points.length; i++)
/*  63 */         this.points[i] = new Point(); 
/*     */     }
/*     */     
/*     */     public int[] getArrangedPointsForward(DivFormation f) {
/*  67 */       this.tree.clear();
/*  68 */       Arrays.fill(this.arranged, 0);
/*  69 */       double lineX1 = f.start().x();
/*  70 */       double lineY1 = f.start().y();
/*  71 */       double lineDirX = f.dx();
/*  72 */       double lineDirY = f.dy();
/*     */       int i;
/*  74 */       for (i = 0; i < f.deployed(); i++) {
/*  75 */         Point p = this.points[i];
/*  76 */         p.index = i;
/*  77 */         p.value = calculateDistanceToLine(f.px(i), f.py(i), lineX1, lineY1, lineDirX, lineDirY);
/*  78 */         this.tree.add(p);
/*     */       } 
/*     */       
/*  81 */       i = 0;
/*  82 */       while (this.tree.hasMore()) {
/*  83 */         Point p = (Point)this.tree.pollSmallest();
/*  84 */         this.arranged[i++] = p.index;
/*     */       } 
/*  86 */       return this.arranged;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static double calculateDistanceToLine(double pointX, double pointY, double lineX1, double lineY1, double lineDirX, double lineDirY) {
/*  94 */       double A = lineDirY;
/*  95 */       double B = -lineDirX;
/*  96 */       double C = -(A * lineX1 + B * lineY1);
/*     */ 
/*     */       
/*  99 */       return Math.abs(A * pointX + B * pointY + C) / Math.sqrt(A * A + B * B);
/*     */     }
/*     */ 
/*     */     
/*     */     private static class Point
/*     */     {
/*     */       int index;
/*     */       
/*     */       double value;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Columns
/*     */   {
/* 113 */     private final VectorImp vec = new VectorImp();
/* 114 */     private final ArrayList<Tools.Pos> all = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/* 115 */     private final ArrayList<Tools.Pos> res = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/*     */     
/* 117 */     private final Tree<Tools.Pos> tree = new Tree<Tools.Pos>((Config.battle()).MEN_PER_DIVISION)
/*     */       {
/*     */         protected boolean isGreaterThan(Tools.Pos current, Tools.Pos cmp)
/*     */         {
/* 121 */           return (current.value > cmp.value);
/*     */         }
/*     */       };
/*     */     
/*     */     private Columns() {
/* 126 */       while (this.all.hasRoom()) {
/* 127 */         this.all.add(new Tools.Pos(this.all.size()));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     private ArrayList<Tools.Pos> cols(DivFormation f) {
/* 133 */       this.res.clearSloppy();
/*     */ 
/*     */       
/* 136 */       this.vec.set(f.dx(), f.dy());
/* 137 */       this.vec.rotate90().rotate90().rotate90();
/* 138 */       double dx = this.vec.nX();
/* 139 */       double dy = this.vec.nY();
/*     */       
/* 141 */       double minRow = Double.MAX_VALUE;
/* 142 */       double minCol = Double.MAX_VALUE;
/* 143 */       for (int i = 0; i < f.deployed(); i++) {
/*     */         
/* 145 */         Tools.Pos p = (Tools.Pos)this.all.get(i);
/* 146 */         double px = f.px(i);
/* 147 */         double py = f.py(i);
/*     */         
/* 149 */         double x = px;
/* 150 */         double y = py;
/*     */         
/* 152 */         p.rowI = (int)Math.round(dx * x + dy * y);
/* 153 */         p.columnI = (int)Math.round(-dy * x + dx * y);
/* 154 */         minRow = Math.min(p.rowI, minRow);
/* 155 */         minCol = Math.min(minCol, p.columnI);
/* 156 */         this.res.add(p);
/*     */       } 
/*     */       
/* 159 */       for (Tools.Pos p : this.res) {
/* 160 */         p.columnI = (int)(p.columnI - minCol);
/* 161 */         p.rowI = (int)(p.rowI - minRow);
/*     */       } 
/*     */ 
/*     */       
/* 165 */       return this.res;
/*     */     }
/*     */     
/*     */     public ArrayList<Tools.Pos> sortByRow(DivFormation f) {
/* 169 */       cols(f);
/* 170 */       this.tree.clear();
/* 171 */       for (Tools.Pos p : this.res) {
/* 172 */         p.value = -p.rowI;
/* 173 */         this.tree.add(p);
/*     */       } 
/* 175 */       this.res.clearSloppy();
/* 176 */       while (this.tree.hasMore()) {
/* 177 */         this.res.add(this.tree.pollGreatest());
/*     */       }
/* 179 */       return this.res;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<Tools.Pos> sortByColumnRow(DivFormation f) {
/* 184 */       cols(f);
/* 185 */       this.tree.clear();
/* 186 */       for (Tools.Pos p : this.res) {
/* 187 */         p.value = (p.columnI * 64 * 200 + p.rowI);
/* 188 */         this.tree.add(p);
/*     */       } 
/* 190 */       this.res.clearSloppy();
/* 191 */       while (this.tree.hasMore()) {
/* 192 */         this.res.add(this.tree.pollGreatest());
/*     */       }
/* 194 */       return this.res;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class Pos
/*     */   {
/*     */     public int columnI;
/*     */     
/*     */     public int rowI;
/*     */     public final int pos;
/*     */     private double value;
/*     */     
/*     */     private Pos(int i) {
/* 208 */       this.pos = i;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\Tools.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
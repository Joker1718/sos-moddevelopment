/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormation;
/*     */ import init.constant.Config;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Tree;
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
/*     */ class Columns
/*     */ {
/* 113 */   private final VectorImp vec = new VectorImp();
/* 114 */   private final ArrayList<Tools.Pos> all = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/* 115 */   private final ArrayList<Tools.Pos> res = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/*     */   
/* 117 */   private final Tree<Tools.Pos> tree = new Tree<Tools.Pos>((Config.battle()).MEN_PER_DIVISION)
/*     */     {
/*     */       protected boolean isGreaterThan(Tools.Pos current, Tools.Pos cmp)
/*     */       {
/* 121 */         return (current.value > cmp.value);
/*     */       }
/*     */     };
/*     */   
/*     */   private Columns() {
/* 126 */     while (this.all.hasRoom()) {
/* 127 */       this.all.add(new Tools.Pos(this.all.size()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private ArrayList<Tools.Pos> cols(DivFormation f) {
/* 133 */     this.res.clearSloppy();
/*     */ 
/*     */     
/* 136 */     this.vec.set(f.dx(), f.dy());
/* 137 */     this.vec.rotate90().rotate90().rotate90();
/* 138 */     double dx = this.vec.nX();
/* 139 */     double dy = this.vec.nY();
/*     */     
/* 141 */     double minRow = Double.MAX_VALUE;
/* 142 */     double minCol = Double.MAX_VALUE;
/* 143 */     for (int i = 0; i < f.deployed(); i++) {
/*     */       
/* 145 */       Tools.Pos p = (Tools.Pos)this.all.get(i);
/* 146 */       double px = f.px(i);
/* 147 */       double py = f.py(i);
/*     */       
/* 149 */       double x = px;
/* 150 */       double y = py;
/*     */       
/* 152 */       p.rowI = (int)Math.round(dx * x + dy * y);
/* 153 */       p.columnI = (int)Math.round(-dy * x + dx * y);
/* 154 */       minRow = Math.min(p.rowI, minRow);
/* 155 */       minCol = Math.min(minCol, p.columnI);
/* 156 */       this.res.add(p);
/*     */     } 
/*     */     
/* 159 */     for (Tools.Pos p : this.res) {
/* 160 */       p.columnI = (int)(p.columnI - minCol);
/* 161 */       p.rowI = (int)(p.rowI - minRow);
/*     */     } 
/*     */ 
/*     */     
/* 165 */     return this.res;
/*     */   }
/*     */   
/*     */   public ArrayList<Tools.Pos> sortByRow(DivFormation f) {
/* 169 */     cols(f);
/* 170 */     this.tree.clear();
/* 171 */     for (Tools.Pos p : this.res) {
/* 172 */       p.value = -p.rowI;
/* 173 */       this.tree.add(p);
/*     */     } 
/* 175 */     this.res.clearSloppy();
/* 176 */     while (this.tree.hasMore()) {
/* 177 */       this.res.add(this.tree.pollGreatest());
/*     */     }
/* 179 */     return this.res;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Tools.Pos> sortByColumnRow(DivFormation f) {
/* 184 */     cols(f);
/* 185 */     this.tree.clear();
/* 186 */     for (Tools.Pos p : this.res) {
/* 187 */       p.value = (p.columnI * 64 * 200 + p.rowI);
/* 188 */       this.tree.add(p);
/*     */     } 
/* 190 */     this.res.clearSloppy();
/* 191 */     while (this.tree.hasMore()) {
/* 192 */       this.res.add(this.tree.pollGreatest());
/*     */     }
/* 194 */     return this.res;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\Tools$Columns.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
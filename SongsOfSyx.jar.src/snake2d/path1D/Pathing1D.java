/*     */ package snake2d.path1D;
/*     */ 
/*     */ public final class Pathing1D
/*     */ {
/*     */   private final PTile1D[] tiles;
/*   6 */   int id = 0;
/*   7 */   final RBTileTree tree = new RBTileTree();
/*     */   private Object user;
/*     */   
/*     */   public Pathing1D(int size) {
/*  11 */     this.tiles = new PTile1D[size];
/*  12 */     for (int i = 0; i < size; i++)
/*  13 */       this.tiles[i] = new PTile1D(i); 
/*     */   }
/*     */   
/*     */   public Pathing1D init(Object user) {
/*  17 */     if (this.user != null) {
/*  18 */       throw new RuntimeException("already in use by: " + this.user.toString());
/*     */     }
/*  20 */     this.user = user;
/*  21 */     this.id++;
/*  22 */     if (this.id == 0) {
/*  23 */       for (int i = 0; i < this.tiles.length; i++)
/*  24 */         (this.tiles[i]).pathId = 0; 
/*  25 */       this.id = 1;
/*     */     } 
/*  27 */     this.tree.clear();
/*  28 */     return this;
/*     */   }
/*     */   
/*     */   public void done() {
/*  32 */     this.user = null;
/*     */   }
/*     */   
/*     */   public PTile1D getTile(int index) {
/*  36 */     return this.tiles[index];
/*     */   }
/*     */   
/*     */   public PTile1D pushGreater(int index, double value) {
/*  40 */     return pushGreater(index, value, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public PTile1D pushGreater(int index, double value, PTile1D parent) {
/*  45 */     PTile1D t = this.tiles[index];
/*     */     
/*  47 */     if (t.pathId == this.id) {
/*  48 */       if (t.value >= value)
/*  49 */         return t; 
/*  50 */       if (t.closed)
/*  51 */         return t; 
/*  52 */       this.tree.remove(t);
/*     */     } 
/*     */     
/*  55 */     t.pathId = this.id;
/*  56 */     t.closed = false;
/*  57 */     t.value = (float)value;
/*  58 */     t.pathParent = parent;
/*  59 */     this.tree.put(t);
/*  60 */     return t;
/*     */   }
/*     */   
/*     */   public PTile1D pushSloppy(int index, double value) {
/*  64 */     return pushSloppy(index, value, null);
/*     */   }
/*     */   
/*     */   public PTile1D pushSloppy(int index, double value, PTile1D parent) {
/*  68 */     PTile1D t = this.tiles[index];
/*     */     
/*  70 */     if (t.pathId == this.id) {
/*  71 */       return null;
/*     */     }
/*     */     
/*  74 */     t.pathId = this.id;
/*  75 */     t.value = (float)value;
/*  76 */     t.pathParent = parent;
/*  77 */     this.tree.put(t);
/*  78 */     t.closed = true;
/*  79 */     return t;
/*     */   }
/*     */   
/*     */   public PTile1D pushSmaller(int index, double value) {
/*  83 */     return pushSmaller(index, (float)value, null);
/*     */   }
/*     */ 
/*     */   
/*     */   public PTile1D pushSmaller(int index, double value, PTile1D parent) {
/*  88 */     PTile1D t = this.tiles[index];
/*     */     
/*  90 */     if (t.pathId == this.id) {
/*  91 */       if (t.value <= value)
/*  92 */         return null; 
/*  93 */       if (t.closed)
/*  94 */         return null; 
/*  95 */       this.tree.remove(t);
/*     */     } 
/*     */     
/*  98 */     t.pathId = this.id;
/*  99 */     t.closed = false;
/* 100 */     t.value = (float)value;
/* 101 */     t.pathParent = parent;
/* 102 */     this.tree.put(t);
/* 103 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasBeenPushed(int index) {
/* 108 */     PTile1D t = this.tiles[index];
/* 109 */     return (t.pathId == this.id);
/*     */   }
/*     */   
/*     */   public void unclose(int index) {
/* 113 */     PTile1D t = this.tiles[index];
/* 114 */     t.closed = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PTile1D pollAndReopen() {
/* 124 */     PTile1D t = this.tree.pollGreatest();
/* 125 */     t.pathId = this.id - 1;
/* 126 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PTile1D pollGreatest() {
/* 134 */     PTile1D t = this.tree.pollGreatest();
/* 135 */     t.closed = true;
/* 136 */     return t;
/*     */   }
/*     */   
/*     */   public int pushed() {
/* 140 */     return this.tree.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public PTile1D pollSmallest() {
/* 145 */     PTile1D t = this.tree.pollSmallest();
/* 146 */     t.closed = true;
/* 147 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void closeGreater(int index, double value) {
/* 153 */     PTile1D t = this.tiles[index];
/* 154 */     if (t.pathId == this.id && value > t.value)
/* 155 */       t.value = (float)value; 
/* 156 */     t.pathId = this.id;
/* 157 */     t.closed = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PTile1D close(int index, double value) {
/* 163 */     PTile1D t = this.tiles[index];
/*     */     
/* 165 */     t.value = (float)value;
/* 166 */     t.pathId = this.id;
/* 167 */     t.closed = true;
/* 168 */     return t;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PTile1D close(int index, double value, PTile1D parent) {
/* 174 */     PTile1D t = this.tiles[index];
/* 175 */     t.value = (float)value;
/* 176 */     t.pathId = this.id;
/* 177 */     t.closed = true;
/* 178 */     t.pathParent = parent;
/* 179 */     return t;
/*     */   }
/*     */   
/*     */   public float getValue(int index) {
/* 183 */     PTile1D t = this.tiles[index];
/* 184 */     if (t.pathId == this.id) {
/* 185 */       return t.value;
/*     */     }
/* 187 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean hasMore() {
/* 191 */     return (this.tree.size() > 0);
/*     */   }
/*     */   
/*     */   public float getValue2(int index) {
/* 195 */     PTile1D t = this.tiles[index];
/* 196 */     return t.value2;
/*     */   }
/*     */   
/*     */   public void setValue2(int index, double f) {
/* 200 */     PTile1D t = this.tiles[index];
/* 201 */     t.value2 = (float)f;
/*     */   }
/*     */   
/*     */   public PTile1D force(int index, float value, PTile1D parent) {
/* 205 */     PTile1D t = this.tiles[index];
/* 206 */     t.value = value;
/* 207 */     t.pathId = this.id;
/* 208 */     t.closed = true;
/* 209 */     t.pathParent = parent;
/* 210 */     return t;
/*     */   }
/*     */   
/*     */   public PTile1D reverse(PTile1D t) {
/* 214 */     init(this);
/*     */     
/* 216 */     PTile1D p = t.pathParent;
/* 217 */     t.pathParent = null;
/* 218 */     t = reverse(p, t);
/*     */     
/* 220 */     done();
/*     */ 
/*     */     
/* 223 */     return t;
/*     */   }
/*     */   
/*     */   private PTile1D reverse(PTile1D t, PTile1D newparent) {
/* 227 */     if (t == null)
/* 228 */       return newparent; 
/* 229 */     PTile1D parent = t.pathParent;
/* 230 */     t.pathParent = newparent;
/* 231 */     return reverse(parent, t);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\path1D\Pathing1D.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.path.components;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ 
/*     */ public abstract class SComponent
/*     */   implements INDEXED, MAP_BOOLEAN
/*     */ {
/*     */   private SComponentEdge edgeFirst;
/*  16 */   private SComponent superComp = null;
/*     */   
/*     */   boolean checked;
/*  19 */   final RBIT.RBITImp[] ress = new RBIT.RBITImp[FindableDataRes.all.size()];
/*     */   public SComponent() {
/*  21 */     for (int i = 0; i < this.ress.length; i++) {
/*  22 */       this.ress[i] = new RBIT.RBITImp();
/*     */     }
/*     */     
/*  25 */     this.fdata = new long[FindableData.datao.longCount()];
/*     */   }
/*     */   final long[] fdata;
/*     */   public abstract int centreX();
/*     */   
/*     */   public abstract int centreY();
/*     */   
/*     */   protected final void pushEdge(SComponent to, double cost, double distance) {
/*  33 */     this.edgeFirst = SComponentEdge.create(to, cost, distance, this.edgeFirst);
/*     */   }
/*     */   public abstract boolean hasEdge();
/*     */   
/*     */   public boolean is(int tile) {
/*  38 */     return (level().get(tile) == this);
/*     */   }
/*     */   public abstract boolean hasEntry();
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  43 */     return (level().get(tx, ty) == this);
/*     */   }
/*     */   
/*     */   protected void retire() {
/*  47 */     while (this.edgeFirst != null) {
/*  48 */       this.edgeFirst.to().removeEdge(this);
/*  49 */       removeEdge(this.edgeFirst.to());
/*     */     } 
/*  51 */     this.superComp = null;
/*  52 */     check();
/*     */   }
/*     */   
/*     */   public abstract boolean retired();
/*     */   
/*     */   private void removeEdge(SComponent to) {
/*  58 */     if (this.edgeFirst.to() == to) {
/*  59 */       SComponentEdge sComponentEdge = this.edgeFirst;
/*  60 */       this.edgeFirst = sComponentEdge.next();
/*  61 */       sComponentEdge.retire();
/*     */       
/*     */       return;
/*     */     } 
/*  65 */     SComponentEdge e = this.edgeFirst;
/*  66 */     while (e.next() != null) {
/*  67 */       if (e.next().to() == to) {
/*  68 */         SComponentEdge ret = e.next();
/*  69 */         e.setNext(e.next().next());
/*  70 */         ret.retire();
/*     */         return;
/*     */       } 
/*  73 */       e = e.next();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void check() {
/*  78 */     SComponentEdge e = this.edgeFirst;
/*  79 */     while (e != null) {
/*  80 */       if (e.to() != e.to().level().get(e.to().centreX(), e.to().centreY()))
/*  81 */         (new RuntimeException()).printStackTrace(); 
/*  82 */       e = e.next();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void pruneEdges() {
/*  87 */     check();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SComponent superComp() {
/* 126 */     return this.superComp;
/*     */   }
/*     */   
/*     */   public SComponent superCompTop() {
/* 130 */     SComponent s = this.superComp;
/* 131 */     while (s != null && s.superComp() != null)
/* 132 */       s = s.superComp(); 
/* 133 */     return s;
/*     */   }
/*     */   
/*     */   void superCompSet(SComponent sComp) {
/* 137 */     if (this.superComp != null && sComp != null) {
/* 138 */       System.err.println(level().level());
/* 139 */       System.err.println(String.valueOf(this.superComp) + " " + String.valueOf(this.superComp));
/* 140 */       throw new RuntimeException();
/*     */     } 
/* 142 */     this.superComp = sComp;
/*     */   }
/*     */   
/*     */   public SComponentEdge edgefirst() {
/* 146 */     return this.edgeFirst;
/*     */   }
/*     */   
/*     */   void clearData() {
/* 150 */     for (int i = 0; i < this.fdata.length; i++)
/* 151 */       this.fdata[i] = 0L;  byte b; int j;
/*     */     RBIT.RBITImp[] arrayOfRBITImp;
/* 153 */     for (j = (arrayOfRBITImp = this.ress).length, b = 0; b < j; ) { RBIT.RBITImp rBITImp = arrayOfRBITImp[b];
/* 154 */       rBITImp.clear();
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/* 159 */   private static Coo rndCoo = new Coo();
/*     */   public abstract SComponentLevel level();
/*     */   
/*     */   public COORDINATE rndCoo() {
/* 163 */     int size = level().size();
/* 164 */     int x1 = CLAMP.i(centreX() - size, 0, SETT.TWIDTH);
/* 165 */     int x2 = CLAMP.i(centreX() + size, 0, SETT.TWIDTH);
/* 166 */     int y1 = CLAMP.i(centreY() - size, 0, SETT.TWIDTH);
/* 167 */     int y2 = CLAMP.i(centreY() + size, 0, SETT.TWIDTH);
/* 168 */     int w = x2 - x1;
/* 169 */     int h = y2 - y1;
/* 170 */     int area = (x2 - x1) * (y2 - y1);
/*     */     
/* 172 */     for (int i = 0; i < area; i++) {
/* 173 */       int x = x1 + RND.rInt(w);
/* 174 */       int y = y1 + RND.rInt(h);
/* 175 */       if (is(x, y)) {
/* 176 */         rndCoo.set(x, y);
/* 177 */         return (COORDINATE)rndCoo;
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     rndCoo.set(centreX(), centreY());
/* 182 */     return (COORDINATE)rndCoo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComponent.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
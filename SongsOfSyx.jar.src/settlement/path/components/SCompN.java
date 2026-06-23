/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ final class SCompN
/*     */   extends SComponent
/*     */ {
/*     */   boolean retired = true;
/*     */   private final int index;
/*     */   private short cx;
/*     */   private short cy;
/*     */   byte edgeMask;
/*     */   private final byte level;
/*     */   
/*     */   SCompN(int index, byte level) {
/*  22 */     this.index = index;
/*  23 */     this.level = level;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  28 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int centreX() {
/*  33 */     return this.cx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int centreY() {
/*  38 */     return this.cy;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEdge() {
/*  43 */     return ((this.edgeMask & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEntry() {
/*  48 */     return ((this.edgeMask & 0x2) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void retire() {
/*  53 */     super.retire();
/*  54 */     this.retired = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retired() {
/*  59 */     return this.retired;
/*     */   }
/*     */ 
/*     */   
/*     */   public SCompNLevel level() {
/*  64 */     return (SCompNLevel)(SETT.PATH()).comps.levels.get(this.level - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   void init(SComponent underling, RECTANGLE boundsC, SComponentLevel lower, SComponentChecker checker) {
/*  69 */     this.edgeMask = 0;
/*     */     
/*  71 */     PathUtilOnline.Filler f = GUTIL.filler();
/*  72 */     f.init(this);
/*  73 */     f.fill(underling.centreX(), underling.centreY());
/*     */     
/*  75 */     double low = Double.MAX_VALUE;
/*  76 */     SComponent bestCentre = null;
/*     */     
/*  78 */     while (f.hasMore()) {
/*  79 */       COORDINATE coo = f.poll();
/*  80 */       SComponent c = (SComponent)lower.get(coo);
/*  81 */       add(c);
/*     */       
/*  83 */       SComponentEdge e = c.edgefirst();
/*     */       
/*  85 */       double dist = Math.abs(boundsC.cX() - coo.x()) + Math.abs(boundsC.cY() - coo.y()) / level().size();
/*  86 */       double cost = 1.0D;
/*  87 */       while (e != null) {
/*  88 */         if (e.to().superComp() == this && boundsC.holdsPoint(e.to().centreX(), e.to().centreY())) {
/*  89 */           f.fill(e.to().centreX(), e.to().centreY());
/*  90 */           if (e.cost2() > cost)
/*  91 */             cost = e.cost2(); 
/*     */         } 
/*  93 */         e = e.next();
/*     */       } 
/*     */       
/*  96 */       if (dist + cost < low) {
/*  97 */         low = dist + cost;
/*  98 */         bestCentre = c;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     this.cx = (short)bestCentre.centreX();
/* 103 */     this.cy = (short)bestCentre.centreY();
/*     */     
/* 105 */     f.done();
/* 106 */     if (level() == (SETT.PATH()).comps.last) {
/*     */       return;
/*     */     }
/*     */     
/* 110 */     setEdges(checker, boundsC);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(SComponent underling) {
/* 116 */     this.edgeMask = (byte)(this.edgeMask | (underling.hasEdge() ? 1 : 0));
/* 117 */     this.edgeMask = (byte)(this.edgeMask | (underling.hasEntry() ? 2 : 0));
/*     */   }
/*     */ 
/*     */   
/*     */   private void setEdges(SComponentChecker neighbours, RECTANGLE bounds) {
/* 122 */     GUTIL.flooder().init(this);
/* 123 */     GUTIL.flooder().pushSloppy(centreX(), centreY(), 0.0D);
/* 124 */     GUTIL.flooder().setValue2(centreX(), centreY(), 0.0D);
/*     */     
/* 126 */     neighbours.init();
/*     */ 
/*     */ 
/*     */     
/* 130 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 132 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 133 */       int x = t.x();
/* 134 */       int y = t.y();
/*     */       
/* 136 */       SComponent underling = (SComponent)((SComponentLevel)(SETT.PATH()).comps.all.get(this.level - 1)).get(x, y);
/* 137 */       if (underling == null)
/*     */         continue; 
/* 139 */       SCompN s = (SCompN)underling.superComp();
/* 140 */       if (s != null && s != this && s.centreX() == t.x() && s.centreY() == t.y()) {
/* 141 */         pushEdge(s, t.getValue2(), t.getValue());
/* 142 */         s.pushEdge(this, t.getValue2(), t.getValue());
/* 143 */         neighbours.isSetAndSet(s);
/*     */         
/*     */         continue;
/*     */       } 
/* 147 */       SComponentEdge e = underling.edgefirst();
/* 148 */       while (e != null) {
/* 149 */         SComponent o = e.to();
/* 150 */         double cost = e.cost2();
/* 151 */         double dist = e.distance();
/* 152 */         e = e.next();
/* 153 */         if (o.superComp() == null)
/*     */           continue; 
/* 155 */         SCompN so = (SCompN)o.superComp();
/* 156 */         if (so.retired || neighbours.is(so))
/*     */           continue; 
/* 158 */         if (so == this && !bounds.holdsPoint(centreX(), centreY()))
/*     */           continue; 
/* 160 */         if (so != this && s != this && so != s)
/*     */           continue; 
/* 162 */         if (GUTIL.flooder().pushSmaller(o.centreX(), o.centreY(), cost + t.getValue(), t) != null) {
/* 163 */           GUTIL.flooder().setValue2(o.centreX(), o.centreY(), dist + t.getValue2());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 168 */     GUTIL.flooder().done();
/*     */ 
/*     */ 
/*     */     
/* 172 */     pruneEdges();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompN.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
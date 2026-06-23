/*     */ package settlement.path.components;
/*     */ 
/*     */ import settlement.entry.EntryPoints;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SComp0
/*     */   extends SComponent
/*     */ {
/*     */   private final int index;
/*     */   private short cx;
/*     */   private short cy;
/*     */   private byte edgeMask;
/*     */   boolean checked;
/*     */   
/*     */   SComp0(int index) {
/*  24 */     this.index = index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  29 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public int centreX() {
/*  34 */     return this.cx;
/*     */   }
/*     */ 
/*     */   
/*     */   public int centreY() {
/*  39 */     return this.cy;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEdge() {
/*  44 */     return ((this.edgeMask & 0x1) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasEntry() {
/*  49 */     return ((this.edgeMask & 0x2) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void retire() {
/*  59 */     retire(true);
/*  60 */     this.cx = -1;
/*  61 */     this.cy = -1;
/*  62 */     super.retire();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean retired() {
/*  67 */     return ((this.edgeMask & 0x10) != 0);
/*     */   }
/*     */   
/*     */   void retire(boolean b) {
/*  71 */     if (b) {
/*  72 */       this.edgeMask = (byte)(this.edgeMask | 0x10);
/*     */     } else {
/*  74 */       this.edgeMask = (byte)(this.edgeMask & 0xFFFFFFEF);
/*     */     } 
/*     */   }
/*     */   boolean checked() {
/*  78 */     return ((this.edgeMask & 0x20) != 0);
/*     */   }
/*     */   
/*     */   void checked(boolean b) {
/*  82 */     if (b) {
/*  83 */       this.edgeMask = (byte)(this.edgeMask | 0x20);
/*     */     } else {
/*  85 */       this.edgeMask = (byte)(this.edgeMask & 0xFFFFFFDF);
/*     */     } 
/*     */   }
/*     */   
/*     */   void init(RECTANGLE bounds, int size, SComponentChecker neighbours) {
/*  90 */     this.edgeMask = 0;
/*  91 */     if (bounds.x1() == 0) {
/*  92 */       this.edgeMask = (byte)(this.edgeMask | 0x1);
/*  93 */     } else if (bounds.x2() == SETT.TWIDTH) {
/*  94 */       this.edgeMask = (byte)(this.edgeMask | 0x1);
/*     */     } 
/*  96 */     if (bounds.y1() == 0) {
/*  97 */       this.edgeMask = (byte)(this.edgeMask | 0x1);
/*  98 */     } else if (bounds.y2() == SETT.THEIGHT) {
/*  99 */       this.edgeMask = (byte)(this.edgeMask | 0x1);
/*     */     } 
/*     */     
/* 102 */     for (EntryPoints.EntryPoint p : (SETT.ENTRY()).points.active()) {
/* 103 */       if (is(p.coo())) {
/* 104 */         this.edgeMask = (byte)(this.edgeMask | 0x2);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 109 */     int smallest = -1;
/* 110 */     double smallestValue = Double.MAX_VALUE;
/* 111 */     for (COORDINATE c : bounds) {
/* 112 */       int x = c.x();
/* 113 */       int y = c.y();
/* 114 */       if (is(x, y)) {
/* 115 */         AVAILABILITY a = (SETT.PATH()).availability.get(x, y);
/* 116 */         double rx = (bounds.cX() - x);
/* 117 */         double ry = (bounds.cY() - y);
/* 118 */         double r = rx * rx + ry * ry + 1.0D;
/* 119 */         double v = a.player + a.from;
/* 120 */         v = v * v * r;
/* 121 */         if (v < smallestValue) {
/* 122 */           smallest = 1;
/* 123 */           smallestValue = v;
/* 124 */           this.cx = (short)x;
/* 125 */           this.cy = (short)y;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 130 */     if (smallest == -1) {
/* 131 */       throw new RuntimeException("shitty component");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 136 */     setEdges(neighbours);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setEdges(SComponentChecker neighbours) {
/* 146 */     super.retire();
/*     */     
/* 148 */     GUTIL.flooder().init(this);
/* 149 */     GUTIL.flooder().pushSloppy(centreX(), centreY(), 0.0D);
/* 150 */     GUTIL.flooder().setValue2(centreX(), centreY(), 0.0D);
/*     */     
/* 152 */     neighbours.init();
/*     */     
/* 154 */     while (GUTIL.flooder().hasMore()) {
/*     */       
/* 156 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 157 */       int x = t.x();
/* 158 */       int y = t.y();
/*     */       
/* 160 */       SComp0 n = (SETT.PATH()).comps.zero.get(x, y);
/* 161 */       if (neighbours.is(n)) {
/*     */         continue;
/*     */       }
/* 164 */       if (n != this) {
/* 165 */         if ((SETT.PATH()).comps.zero.updating().is(x, y)) {
/* 166 */           neighbours.isSetAndSet(n);
/*     */           
/*     */           continue;
/*     */         } 
/* 170 */         if (n.centreX() == x && n.centreY() == y) {
/*     */           
/* 172 */           pushEdge(n, t.getValue2(), t.getValue());
/* 173 */           n.pushEdge(this, t.getValue2(), t.getValue());
/* 174 */           neighbours.isSetAndSet(n);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 181 */       for (int i = 0; i < DIR.ALL.size(); i++) {
/* 182 */         DIR d = (DIR)DIR.ALL.get(i);
/* 183 */         double v2 = (SETT.PATH()).coster.player.getCost(x, y, x + d.x(), y + d.y()) * d.tileDistance();
/* 184 */         if (v2 > 0.0D) {
/*     */           
/* 186 */           SComponent next = (SComponent)(SETT.PATH()).comps.zero.get(x, y, d);
/* 187 */           if (next != null)
/*     */           {
/* 189 */             if (next == this || n == this || next == n)
/*     */             {
/* 191 */               if (!neighbours.is(next)) {
/*     */                 
/* 193 */                 double v = ((SETT.PATH()).availability.get(x + d.x(), y + d.y())).movementSpeedI;
/* 194 */                 if (GUTIL.flooder().pushSloppy(x, y, d, t.getValue() + v * d.tileDistance(), t) != null)
/* 195 */                   GUTIL.flooder().setValue2(x, y, d, v2 + t.getValue2()); 
/*     */               }  }  } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 200 */     GUTIL.flooder().done();
/*     */     
/* 202 */     pruneEdges();
/*     */   }
/*     */ 
/*     */   
/*     */   public SComponentLevel level() {
/* 207 */     return (SETT.PATH()).comps.zero;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
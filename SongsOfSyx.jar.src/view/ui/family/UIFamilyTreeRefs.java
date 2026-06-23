/*     */ package view.ui.family;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.relation.StatsRelations;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import util.GUTIL;
/*     */ 
/*     */ final class UIFamilyTreeRefs
/*     */ {
/*  16 */   private final int[] refs = Alloc.ii(2048);
/*  17 */   private int max = 0;
/*  18 */   private Bitmap1D hasMore = new Bitmap1D(2048, false);
/*     */   
/*  20 */   private final PathUtilOnline.Flooder f = GUTIL.flooder();
/*  21 */   private final StatsRelations r = STATS.REL();
/*     */ 
/*     */   
/*     */   private final Coo cooTmp;
/*     */ 
/*     */   
/*     */   UIFamilyTreeRefs() {
/*  28 */     this.cooTmp = new Coo();
/*     */   }
/*     */   private COORDINATE coo(int ref) {
/*  31 */     this.cooTmp.set((ref % SETT.TWIDTH), (ref / SETT.TWIDTH));
/*  32 */     return (COORDINATE)this.cooTmp;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int mainRef) {
/*  38 */     int MAX = this.r.references();
/*  39 */     double unprocessedChild = -3.0D;
/*  40 */     double unprocessed = -2.0D;
/*  41 */     double invalid = -1.0D;
/*     */ 
/*     */     
/*     */     int j;
/*     */ 
/*     */     
/*  47 */     for (j = 0; j < MAX; j++) {
/*  48 */       this.f.setValue2(coo(j), -3.0D);
/*     */     }
/*  50 */     for (j = 0; j < MAX; j++) {
/*  51 */       if (this.r.isRef(j) && this.r.hasParent(j)) {
/*  52 */         this.f.setValue2(coo(this.r.parentRef(j)), -2.0D);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     j = mainRef;
/*  61 */     for (int k = 0; k < 1000; k++) {
/*  62 */       this.f.setValue2(coo(j), k);
/*  63 */       if (!this.r.hasParent(j))
/*     */         break; 
/*  65 */       j = this.r.parentRef(j);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     for (j = 0; j < MAX; j++) {
/*  73 */       if (this.r.isRef(j))
/*     */       {
/*  75 */         if (this.f.getValue2(coo(j)) == -3.0D) {
/*     */ 
/*     */           
/*  78 */           int traveler = j;
/*  79 */           int dist = 1;
/*  80 */           this.f.setValue2(coo(j), -1.0D);
/*  81 */           while (this.r.hasParent(traveler)) {
/*  82 */             int par = this.r.parentRef(traveler);
/*  83 */             double vv = this.f.getValue2(coo(par));
/*  84 */             if (vv >= 0.0D) {
/*  85 */               traveler = j;
/*  86 */               while (dist > 0) {
/*  87 */                 this.f.setValue2(coo(traveler), vv + dist);
/*  88 */                 dist--;
/*  89 */                 traveler = this.r.parentRef(traveler);
/*     */               } 
/*     */               break;
/*     */             } 
/*  93 */             dist++;
/*  94 */             traveler = par;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 103 */     this.f.init(this);
/* 104 */     for (j = 0; j < MAX; j++) {
/* 105 */       if (this.r.isRef(j)) {
/* 106 */         COORDINATE coo = coo(j);
/* 107 */         double vv = this.f.getValue2(coo);
/* 108 */         if (vv >= 0.0D) {
/* 109 */           this.f.pushSloppy(coo, vv);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 116 */     this.max = 0;
/* 117 */     while (this.f.hasMore() && this.max < this.refs.length) {
/* 118 */       PathTile t = this.f.pollSmallest();
/* 119 */       int m = t.x() + t.y() * SETT.TWIDTH;
/* 120 */       this.refs[this.max] = m;
/* 121 */       this.max++;
/*     */     } 
/* 123 */     while (this.f.hasMore()) {
/* 124 */       PathTile t = this.f.pollSmallest();
/* 125 */       t.setValue2(-1.0D);
/*     */     } 
/*     */     
/* 128 */     this.f.done();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.f.init(this); int i;
/* 134 */     for (i = 0; i < this.max; i++) {
/* 135 */       int m = this.refs[i];
/* 136 */       COORDINATE coo = coo(m);
/* 137 */       this.f.pushSloppy(coo, m);
/*     */     } 
/* 139 */     this.max = 0;
/*     */ 
/*     */ 
/*     */     
/* 143 */     while (this.f.hasMore()) {
/* 144 */       PathTile t = this.f.pollSmallest();
/* 145 */       this.refs[this.max] = t.x() + t.y() * SETT.TWIDTH;
/* 146 */       t.setValue2(this.max);
/* 147 */       this.max++;
/*     */     } 
/* 149 */     this.f.done();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 155 */     this.hasMore.clear();
/* 156 */     for (i = 0; i < this.max; i++) {
/* 157 */       int m = this.refs[i];
/* 158 */       if (this.r.hasParent(m)) {
/* 159 */         int pref = this.r.parentRef(m);
/* 160 */         if (this.f.getValue2(coo(pref)) < 0.0F) {
/* 161 */           this.hasMore.set(m, true);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 168 */     for (int ref = 0; ref < MAX; ref++) {
/* 169 */       if (this.r.isRef(ref)) {
/* 170 */         COORDINATE coo = coo(ref);
/* 171 */         double vv = this.f.getValue2(coo);
/* 172 */         if (vv < 0.0D && this.r.hasParent(ref)) {
/* 173 */           int po = (int)this.f.getValue2(coo(this.r.parentRef(ref)));
/* 174 */           if (po >= 0) {
/* 175 */             this.hasMore.set(po, true);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(int index) {
/* 185 */     return this.refs[index];
/*     */   }
/*     */   
/*     */   public boolean hasChild(int index) {
/* 189 */     return this.hasMore.get(index);
/*     */   }
/*     */   
/*     */   public int max() {
/* 193 */     return this.max;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTreeRefs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
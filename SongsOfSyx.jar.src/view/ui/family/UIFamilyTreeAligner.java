/*     */ package view.ui.family;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.relation.StatsRelations;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.GUTIL;
/*     */ import util.data.BOOLEAN;
/*     */ 
/*     */ 
/*     */ final class UIFamilyTreeAligner
/*     */ {
/*  18 */   private final PathUtilOnline.Flooder f = GUTIL.flooder();
/*  19 */   private final StatsRelations r = STATS.REL();
/*  20 */   private final BOOLEAN.BOOLEANImp redo = new BOOLEAN.BOOLEANImp(true);
/*  21 */   int maxIterations = 128;
/*     */   
/*  23 */   private final float[] x2s = new float[2048];
/*  24 */   private final float[] levels = new float[2048];
/*  25 */   private final float[] parentXs = new float[2048];
/*  26 */   private final PathTile[] tmpLevel = new PathTile[2048];
/*     */   
/*  28 */   private final Coo cooTmp = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  33 */   private final Comparator<PathTile> parentSort = new Comparator<PathTile>()
/*     */     {
/*     */       public int compare(PathTile o1, PathTile o2)
/*     */       {
/*  37 */         int ref1 = o1.x() + o1.y() * SETT.TWIDTH;
/*  38 */         int ref2 = o2.x() + o2.y() * SETT.TWIDTH;
/*  39 */         int p1 = UIFamilyTreeAligner.this.r.parentRef(ref1);
/*  40 */         int p2 = UIFamilyTreeAligner.this.r.parentRef(ref2);
/*  41 */         int v1 = (int)UIFamilyTreeAligner.this.f.getValue2(UIFamilyTreeAligner.this.coo(p1));
/*  42 */         int v2 = (int)UIFamilyTreeAligner.this.f.getValue2(UIFamilyTreeAligner.this.coo(p2));
/*  43 */         return v1 - v2;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private COORDINATE coo(int ref) {
/*  53 */     this.cooTmp.set((ref % SETT.TWIDTH), (ref / SETT.TWIDTH));
/*  54 */     return (COORDINATE)this.cooTmp;
/*     */   }
/*     */ 
/*     */   
/*     */   void init(UIFamilyTreeRefs refs) {
/*  59 */     this.f.init(this);
/*  60 */     int MAX = refs.max();
/*     */ 
/*     */     
/*     */     int refI;
/*     */     
/*  65 */     for (refI = 0; refI < refs.max(); refI++) {
/*  66 */       int ref = refs.get(refI);
/*  67 */       this.f.setValue2(coo(ref), 0.0D);
/*     */     } 
/*     */     
/*  70 */     for (refI = 0; refI < refs.max(); refI++) {
/*  71 */       int j = refs.get(refI);
/*  72 */       if (this.r.isRef(j))
/*     */       {
/*  74 */         if (this.f.getValue2(coo(j)) == 0.0F) {
/*     */           
/*  76 */           int ref = j;
/*  77 */           int depth = 1; int tmp;
/*  78 */           for (tmp = 0; tmp < 1000 && this.r.hasParent(ref); tmp++) {
/*  79 */             ref = this.r.parentRef(ref);
/*  80 */             COORDINATE coo = coo(ref);
/*  81 */             if (this.f.getValue2(coo) != 0.0F) {
/*  82 */               depth = (int)(depth + this.f.getValue2(coo));
/*     */               
/*     */               break;
/*     */             } 
/*  86 */             depth++;
/*     */           } 
/*  88 */           ref = j;
/*  89 */           for (tmp = 0; tmp < 1000; tmp++) {
/*     */             
/*  91 */             COORDINATE coo = coo(ref);
/*  92 */             if (this.f.getValue2(coo) != 0.0F) {
/*     */               break;
/*     */             }
/*     */             
/*  96 */             this.f.setValue2(coo, depth);
/*  97 */             depth--;
/*  98 */             if (!this.r.hasParent(ref))
/*     */               break; 
/* 100 */             ref = this.r.parentRef(ref);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 109 */     for (refI = 0; refI < refs.max(); refI++) {
/* 110 */       int j = refs.get(refI);
/* 111 */       if (this.r.isRef(j)) {
/*     */         
/* 113 */         this.f.pushSloppy(coo(j), this.f.getValue2(coo(j)));
/* 114 */         this.f.setValue2(coo(j), j);
/*     */       } 
/*     */     } 
/* 117 */     if (!this.f.hasMore()) {
/* 118 */       this.f.done();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 125 */     while (this.f.hasMore()) {
/* 126 */       PathTile t = this.f.pollSmallest();
/* 127 */       int li = 0;
/* 128 */       this.tmpLevel[li] = t;
/* 129 */       li++;
/*     */       
/* 131 */       while (this.f.hasMore()) {
/* 132 */         PathTile t2 = this.f.pollSmallest();
/* 133 */         if (t2.getValue() != t.getValue()) {
/* 134 */           this.f.reopen(t2);
/* 135 */           this.f.pushSloppy((COORDINATE)t2, t2.getValue());
/*     */           break;
/*     */         } 
/* 138 */         this.tmpLevel[li] = t2;
/* 139 */         li++;
/*     */       } 
/*     */       
/* 142 */       Arrays.sort(this.tmpLevel, 0, li, this.parentSort);
/*     */       
/* 144 */       for (int j = 0; j < li; j++) {
/* 145 */         this.tmpLevel[j].setValue2(j);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 154 */     for (refI = 0; refI < refs.max(); refI++) {
/* 155 */       int j = refs.get(refI);
/* 156 */       if (this.r.isRef(j)) {
/*     */         
/* 158 */         COORDINATE coo = coo(j);
/* 159 */         PathTile t = this.f.get(coo);
/* 160 */         int depth = (int)t.getValue();
/* 161 */         this.f.reopen(t);
/* 162 */         double order = t.getValue2();
/* 163 */         this.f.pushSloppy((COORDINATE)t, (depth * MAX + MAX - 1) - order);
/*     */       } 
/*     */     } 
/* 166 */     if (!this.f.hasMore()) {
/* 167 */       this.f.done();
/*     */       
/*     */       return;
/*     */     } 
/* 171 */     PathTile start = this.f.pollGreatest();
/*     */     
/* 173 */     PathTile current = start;
/* 174 */     while (this.f.hasMore()) {
/* 175 */       PathTile t = this.f.pollGreatest();
/* 176 */       current.parentSet(t);
/* 177 */       current = t;
/*     */     } 
/*     */ 
/*     */     
/* 181 */     this.redo.set(true);
/* 182 */     for (int k = 0; k < this.maxIterations && this.redo.is(); k++) {
/* 183 */       this.redo.set(false);
/*     */       
/* 185 */       PathTile t = start;
/* 186 */       while (t != null) {
/* 187 */         int level = (int)(t.getValue() / MAX);
/* 188 */         int li = 0;
/* 189 */         this.tmpLevel[li] = t;
/* 190 */         li++;
/*     */ 
/*     */         
/* 193 */         while (t.getParent() != null) {
/* 194 */           PathTile t2 = t.getParent();
/* 195 */           int level2 = (int)(t2.getValue() / MAX);
/* 196 */           if (level != level2) {
/*     */             break;
/*     */           }
/* 199 */           this.tmpLevel[li] = t2;
/* 200 */           li++;
/* 201 */           t = t2;
/*     */         } 
/*     */         
/* 204 */         adjustXLevel(this.tmpLevel, li, level, this.redo);
/* 205 */         t = t.getParent();
/*     */       } 
/*     */     } 
/*     */     
/* 209 */     for (int i = 0; i < refs.max(); i++) {
/* 210 */       int j = refs.get(i);
/* 211 */       if (this.r.isRef(j)) {
/*     */         
/* 213 */         COORDINATE coo = coo(j);
/* 214 */         PathTile t = this.f.get(coo);
/* 215 */         int level = (int)(t.getValue() / MAX);
/* 216 */         double parentX = -1.0D;
/* 217 */         int ref = t.x() + t.y() * SETT.TWIDTH;
/* 218 */         if (this.r.hasParent(ref)) {
/* 219 */           parentX = GUTIL.flooder().getValue2(coo(this.r.parentRef(ref)));
/*     */         }
/* 221 */         this.x2s[i] = t.getValue2();
/* 222 */         this.levels[i] = level;
/* 223 */         this.parentXs[i] = (float)parentX;
/*     */       } 
/*     */     } 
/*     */     
/* 227 */     this.f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void adjustXLevel(PathTile[] refs, int li, int level, BOOLEAN.BOOLEANImp changed) {
/* 233 */     int parent = this.r.parentRef(refs[0].x() + refs[0].y() * SETT.TWIDTH);
/*     */     
/* 235 */     int startI = 0;
/* 236 */     double startX = 0.0D;
/*     */     
/* 238 */     for (int i = 0; i < li; i++) {
/*     */       
/* 240 */       PathTile t2 = refs[i];
/* 241 */       int parent2 = this.r.parentRef(t2.x() + t2.y() * SETT.TWIDTH);
/*     */       
/* 243 */       if (parent != parent2) {
/* 244 */         startX = adjustXSiblings(refs, startI, i, startX, level, changed);
/* 245 */         startI = i;
/* 246 */         parent = parent2;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 251 */     adjustXSiblings(refs, startI, li, startX, level, changed);
/*     */   }
/*     */ 
/*     */   
/*     */   private double adjustXSiblings(PathTile[] refs, int startI, int endI, double lastX, int level, BOOLEAN.BOOLEANImp parentsHaveChange) {
/* 256 */     int parentRef = this.r.parentRef(refs[startI].x() + refs[startI].y() * SETT.TWIDTH);
/* 257 */     if (!this.r.isRef(parentRef)) {
/* 258 */       return lastX;
/*     */     }
/*     */     
/* 261 */     double parentX = 0.0D;
/* 262 */     for (int i = startI; i < endI; i++) {
/*     */       
/* 264 */       PathTile t = refs[i];
/*     */       
/* 266 */       if (lastX > t.getValue2()) {
/* 267 */         t.setValue2(lastX);
/*     */       }
/* 269 */       parentX += t.getValue2();
/* 270 */       lastX = (t.getValue2() + 1.0F);
/*     */     } 
/*     */     
/* 273 */     parentX /= (endI - startI);
/* 274 */     parentX = (int)Math.round(parentX * 2.0D) / 2.0D;
/*     */     
/* 276 */     double oldParent = this.f.getValue2(coo(parentRef));
/* 277 */     if (oldParent > parentX) {
/* 278 */       double delta = oldParent - parentX;
/* 279 */       for (int j = startI; j < endI; j++) {
/* 280 */         PathTile t = refs[j];
/* 281 */         t.setValue2(t.getValue2() + delta);
/*     */       } 
/* 283 */       lastX += delta;
/*     */     }
/* 285 */     else if (oldParent < parentX) {
/* 286 */       PathTile p = this.f.get(coo(parentRef));
/* 287 */       p.setValue2(parentX);
/* 288 */       parentsHaveChange.set(true);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 294 */     return lastX;
/*     */   }
/*     */ 
/*     */   
/*     */   public double x2(int index) {
/* 299 */     return this.x2s[index];
/*     */   }
/*     */   
/*     */   public double level(int index) {
/* 303 */     return this.levels[index];
/*     */   }
/*     */   
/*     */   public double parentX(int index) {
/* 307 */     return this.parentXs[index];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTreeAligner.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
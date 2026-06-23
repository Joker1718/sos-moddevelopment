/*     */ package settlement.entity;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sets.ADDABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Grid
/*     */ {
/*     */   private static final int max = 1;
/*  18 */   private final ENTITY[][] ents = new ENTITY[SETT.THEIGHT][SETT.TWIDTH];
/*  19 */   private final Resolver resolver = new Resolver();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void add(ENTITY e) {
/*  30 */     add(e, true);
/*     */   }
/*     */ 
/*     */   
/*     */   void add(ENTITY e, boolean collide) {
/*  35 */     if (e.gx != -1 && e.gy != -1) {
/*  36 */       throw new RuntimeException();
/*     */     }
/*  38 */     int tx = e.tc().x();
/*  39 */     int ty = e.tc().y();
/*     */     
/*  41 */     if (collide)
/*  42 */       collide(e); 
/*  43 */     if (e.isRemoved()) {
/*     */       return;
/*     */     }
/*     */     
/*  47 */     e.prev = null;
/*  48 */     e.next = this.ents[ty][tx];
/*  49 */     if (e.next != null) {
/*  50 */       e.next.prev = e;
/*     */     }
/*  52 */     e.gx = (short)tx;
/*  53 */     e.gy = (short)ty;
/*  54 */     this.ents[ty][tx] = e;
/*     */     
/*  56 */     (SETT.PATH()).finders.entity.report(e, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addRaw(ENTITY e) {
/*  61 */     int tx = e.tc().x();
/*  62 */     int ty = e.tc().y();
/*     */     
/*  64 */     e.prev = null;
/*  65 */     e.next = this.ents[ty][tx];
/*  66 */     if (e.next != null) {
/*  67 */       e.next.prev = e;
/*     */     }
/*  69 */     e.gx = (short)tx;
/*  70 */     e.gy = (short)ty;
/*  71 */     this.ents[ty][tx] = e;
/*  72 */     e.physics.initMoveCheck();
/*     */   }
/*     */ 
/*     */   
/*     */   void move(ENTITY e) {
/*  77 */     if (!e.physics.MoveCheck()) {
/*     */       
/*  79 */       e.physics.initMoveCheck();
/*     */ 
/*     */ 
/*     */       
/*  83 */       int tx = e.tc().x();
/*  84 */       int ty = e.tc().y();
/*     */       
/*  86 */       if (tx != e.gx || ty != e.gy) {
/*     */         
/*  88 */         remove(e);
/*  89 */         add(e, true);
/*     */       } else {
/*  91 */         collide(e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void collide(ENTITY e) {
/* 101 */     int tx = e.tc().x();
/* 102 */     int ty = e.tc().y();
/* 103 */     int tx1 = tx - 1;
/* 104 */     int tx2 = tx + 1;
/* 105 */     int ty1 = ty - 1;
/* 106 */     int ty2 = ty + 1;
/*     */     
/* 108 */     if (tx1 < 0)
/* 109 */       tx1 = 0; 
/* 110 */     if (tx2 >= SETT.TWIDTH) {
/* 111 */       tx2 = SETT.TWIDTH - 1;
/*     */     }
/* 113 */     if (ty1 < 0)
/* 114 */       ty1 = 0; 
/* 115 */     if (ty2 >= SETT.THEIGHT) {
/* 116 */       ty2 = SETT.THEIGHT - 1;
/*     */     }
/* 118 */     int x1 = e.body().x1();
/* 119 */     int x2 = e.body().x2();
/* 120 */     int y1 = e.body().y1();
/* 121 */     int y2 = e.body().y2();
/*     */     
/* 123 */     int death = 1000;
/*     */     
/* 125 */     for (int y = ty1; y <= ty2; y++) {
/* 126 */       for (int x = tx1; x <= tx2; x++) {
/* 127 */         ENTITY c = this.ents[y][x];
/* 128 */         while (c != null) {
/* 129 */           ENTITY next = c.next;
/* 130 */           if (c != e && 
/* 131 */             x1 < c.body().x2() && x2 > c.body().x1() && y1 < c.body().y2() && y2 > c.body().y1()) {
/*     */             
/* 133 */             this.resolver.resolveCollision(c, e);
/*     */             
/* 135 */             if (e.isRemoved()) {
/*     */               return;
/*     */             }
/*     */           } 
/* 139 */           c = next;
/*     */           
/* 141 */           if (death-- <= 0) {
/* 142 */             throw new RuntimeException(String.valueOf(e) + " " + String.valueOf(e) + e.id() + " " + String.valueOf(c));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(ENTITY e) {
/* 154 */     int ty = e.gy;
/* 155 */     int tx = e.gx;
/*     */     
/* 157 */     if (tx == -1 || ty == -1) {
/*     */       return;
/*     */     }
/*     */     
/* 161 */     (SETT.PATH()).finders.entity.report(e, -1);
/*     */     
/* 163 */     if (e.next != null) {
/* 164 */       e.next.prev = e.prev;
/*     */     }
/* 166 */     if (e.prev != null) {
/* 167 */       e.prev.next = e.next;
/*     */     }
/*     */     
/* 170 */     if (this.ents[ty][tx] == e) {
/* 171 */       this.ents[ty][tx] = e.next;
/*     */     }
/*     */     
/* 174 */     e.gy = -1;
/* 175 */     e.gx = -1;
/* 176 */     e.next = null;
/* 177 */     e.prev = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void fill(RECTANGLE area, ADDABLE<ENTITY> result) {
/* 183 */     int tx1 = (area.x1() >> 6) - 1;
/* 184 */     int tx2 = (area.x2() >> 6) + 1 + 1;
/* 185 */     int ty1 = (area.y1() >> 6) - 1;
/* 186 */     int ty2 = (area.y2() >> 6) + 1 + 1;
/*     */     
/* 188 */     if (tx1 < 0)
/* 189 */       tx1 = 0; 
/* 190 */     if (tx2 >= SETT.TWIDTH) {
/* 191 */       tx2 = SETT.TWIDTH - 1;
/*     */     }
/* 193 */     if (ty1 < 0)
/* 194 */       ty1 = 0; 
/* 195 */     if (ty2 >= SETT.THEIGHT) {
/* 196 */       ty2 = SETT.THEIGHT - 1;
/*     */     }
/* 198 */     for (int y = ty1; y <= ty2; y++) {
/* 199 */       for (int x = tx1; x <= tx2; x++) {
/* 200 */         ENTITY c = this.ents[y][x];
/* 201 */         while (c != null) {
/* 202 */           if (c.body().touches(area)) {
/* 203 */             result.tryAdd(c);
/*     */           }
/* 205 */           c = c.next;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void fillTile(int tx, int ty, ADDABLE<ENTITY> result) {
/* 217 */     if (tx < 0)
/*     */       return; 
/* 219 */     if (tx >= SETT.TWIDTH) {
/*     */       return;
/*     */     }
/* 222 */     if (ty < 0)
/*     */       return; 
/* 224 */     if (ty >= SETT.THEIGHT) {
/*     */       return;
/*     */     }
/* 227 */     ENTITY c = this.ents[ty][tx];
/* 228 */     while (c != null) {
/* 229 */       result.tryAdd(c);
/* 230 */       c = c.next;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void fill(int cx, int cy, ADDABLE<ENTITY> result) {
/* 237 */     int tx1 = (cx >> 6) - 1;
/* 238 */     int tx2 = (cx >> 6) + 1;
/* 239 */     int ty1 = (cy >> 6) - 1;
/* 240 */     int ty2 = (cy >> 6) + 1;
/*     */     
/* 242 */     if (tx1 < 0)
/* 243 */       tx1 = 0; 
/* 244 */     if (tx2 >= SETT.TWIDTH) {
/* 245 */       tx2 = SETT.TWIDTH - 1;
/*     */     }
/* 247 */     if (ty1 < 0)
/* 248 */       ty1 = 0; 
/* 249 */     if (ty2 >= SETT.THEIGHT) {
/* 250 */       ty2 = SETT.THEIGHT - 1;
/*     */     }
/* 252 */     for (int y = ty1; y <= ty2; y++) {
/* 253 */       for (int x = tx1; x <= tx2; x++) {
/* 254 */         ENTITY c = this.ents[y][x];
/* 255 */         while (c != null) {
/* 256 */           if (c.body().holdsPoint(cx, cy)) {
/* 257 */             result.tryAdd(c);
/*     */           }
/* 259 */           c = c.next;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   ENTITY getFirst(int tx, int ty) {
/* 268 */     if (SETT.IN_BOUNDS(tx, ty))
/* 269 */       return this.ents[ty][tx]; 
/* 270 */     return null;
/*     */   }
/*     */   
/*     */   void clear() {
/* 274 */     for (int y = 0; y < SETT.THEIGHT; y++) {
/* 275 */       for (int x = 0; x < SETT.TWIDTH; x++) {
/* 276 */         ENTITY c = this.ents[y][x];
/* 277 */         while (c != null) {
/* 278 */           ENTITY next = c.next;
/* 279 */           c.gx = -1;
/* 280 */           c.gy = -1;
/* 281 */           c.prev = null;
/* 282 */           c.next = null;
/* 283 */           c = next;
/*     */         } 
/* 285 */         this.ents[y][x] = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void fill(ENTITY e, int radius, ADDABLE<ENTITY> result) {
/* 292 */     int tx1 = (e.body().cX() >> 6) - 1 - radius;
/* 293 */     int tx2 = (e.body().cX() >> 6) + 1 + 1 + radius;
/* 294 */     int ty1 = (e.body().cY() >> 6) - 1 - radius;
/* 295 */     int ty2 = (e.body().cY() >> 6) + 1 + 1 + radius;
/*     */     
/* 297 */     if (tx1 < 0)
/* 298 */       tx1 = 0; 
/* 299 */     if (tx2 >= SETT.TWIDTH) {
/* 300 */       tx2 = SETT.TWIDTH - 1;
/*     */     }
/* 302 */     if (ty1 < 0)
/* 303 */       ty1 = 0; 
/* 304 */     if (ty2 >= SETT.THEIGHT) {
/* 305 */       ty2 = SETT.THEIGHT - 1;
/*     */     }
/* 307 */     for (int y = ty1; y <= ty2; y++) {
/* 308 */       for (int x = tx1; x <= tx2; x++) {
/* 309 */         ENTITY c = this.ents[y][x];
/* 310 */         while (c != null) {
/* 311 */           if (c != e) {
/* 312 */             result.tryAdd(c);
/*     */           }
/* 314 */           c = c.next;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\Grid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
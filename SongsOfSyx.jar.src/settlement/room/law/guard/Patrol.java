/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ public final class Patrol
/*     */   implements SAVABLE
/*     */ {
/*  24 */   private static int WIDTH = 1;
/*  25 */   private static int DEPTH = 8;
/*  26 */   public static int MAX = (1 + WIDTH * 2) * DEPTH;
/*  27 */   private static int MAX_TILES = 120;
/*     */   
/*  29 */   public static double speed = 0.5D;
/*     */   
/*  31 */   private final PathGame.PathSimple path = new PathGame.PathSimple(MAX_TILES + 16);
/*  32 */   private double waitAtDest = (RND.rFloat() * TIME.secondsPerHour() * 3.0F);
/*  33 */   private double progressTile = 0.0D;
/*  34 */   private short[] txs = new short[DEPTH];
/*  35 */   private short[] tys = new short[DEPTH];
/*  36 */   private byte[] dirs = Alloc.bb(DEPTH);
/*     */   
/*  38 */   private Coo tmp = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  46 */     file.d(this.waitAtDest);
/*  47 */     file.d(this.progressTile);
/*  48 */     file.ssE(this.txs);
/*  49 */     file.ssE(this.tys);
/*  50 */     file.bsE(this.dirs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  55 */     this.waitAtDest = file.d();
/*  56 */     this.progressTile = file.d();
/*  57 */     file.ssE(this.txs);
/*  58 */     file.ssE(this.tys);
/*  59 */     file.bsE(this.dirs);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  65 */     this.waitAtDest = 0.0D;
/*  66 */     this.progressTile = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  71 */     if (!this.path.hasNext()) {
/*  72 */       this.waitAtDest -= ds;
/*  73 */       if (this.waitAtDest < 0.0D) {
/*  74 */         find();
/*     */         
/*  76 */         this.waitAtDest = (TIME.secondsPerHour() * (3.0F + RND.rFloat() * 3.0F));
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  81 */       this.progressTile += ds * speed;
/*     */       
/*  83 */       if (this.progressTile > 1.0D) {
/*  84 */         this.progressTile--;
/*  85 */         setNext();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setNext() {
/*  93 */     if (!this.path.hasNext())
/*     */       return; 
/*  95 */     this.path.setNext();
/*     */     
/*  97 */     for (int i = DEPTH - 1; i > 0; i--) {
/*  98 */       this.txs[i] = this.txs[i - 1];
/*  99 */       this.tys[i] = this.tys[i - 1];
/* 100 */       this.dirs[i] = this.dirs[i - 1];
/*     */     } 
/*     */     
/* 103 */     this.txs[0] = (short)this.path.x();
/* 104 */     this.tys[0] = (short)this.path.y();
/*     */     
/* 106 */     int x = this.path.x();
/* 107 */     int y = this.path.y();
/* 108 */     if (this.path.hasNext()) {
/* 109 */       this.path.setNext();
/* 110 */       DIR dirNext = DIR.get(x, y, this.path.x(), this.path.y());
/* 111 */       this.dirs[0] = (byte)dirNext.id();
/* 112 */       this.path.setPrev();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void find() {
/* 124 */     int sx = this.path.x();
/* 125 */     int sy = this.path.y();
/*     */     
/* 127 */     if (this.path.length() == 0 || !(SETT.PATH()).connectivity.is(this.path.x(), this.path.y()))
/*     */     {
/* 129 */       if ((SETT.ROOMS()).GUARD.instancesSize() > 0) {
/* 130 */         RoomInstance ins = (SETT.ROOMS()).GUARD.getInstance(RND.rInt((SETT.ROOMS()).GUARD.instancesSize()));
/* 131 */         sx = ins.mX();
/* 132 */         sy = ins.mY();
/*     */       } else {
/*     */         
/* 135 */         sx = THRONE.coo().x();
/* 136 */         sy = THRONE.coo().y();
/* 137 */         DIR d = (DIR)DIR.ORTHO.rnd();
/* 138 */         sx += d.x();
/* 139 */         sy += d.y();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     DIR dirDir = DIR.get(THRONE.coo().x(), THRONE.coo().y(), sx, sy);
/*     */     
/* 148 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/* 149 */     f.init(this);
/*     */     
/* 151 */     f.pushSloppy(sx, sy, 0.0D);
/* 152 */     f.setValue2(sx, sy, 0.0D);
/*     */     
/* 154 */     double destDist = (MAX_TILES + RND.rInt(MAX_TILES));
/*     */     
/* 156 */     while (f.hasMore()) {
/*     */       
/* 158 */       PathTile t = f.pollSmallest();
/*     */       
/* 160 */       if (t.getValue2() > destDist) {
/*     */         
/* 162 */         GUTIL.coos().set(0);
/* 163 */         GUTIL.coos().get().set((COORDINATE)t);
/*     */         
/* 165 */         while (f.hasMore()) {
/* 166 */           t = f.pollSmallest();
/* 167 */           if (t.getValue2() > destDist) {
/* 168 */             GUTIL.coos().inc();
/* 169 */             GUTIL.coos().get().set((COORDINATE)t);
/*     */           } 
/*     */         } 
/* 172 */         t = GUTIL.pathTools().getTile(GUTIL.coos().get().x(), GUTIL.coos().get().y());
/*     */         
/* 174 */         this.path.set(t);
/*     */         
/* 176 */         for (int i = 0; i < DEPTH; i++)
/* 177 */           setNext(); 
/* 178 */         f.done();
/*     */         
/*     */         return;
/*     */       } 
/* 182 */       for (int di = 0; di < DIR.ALL.size(); di++) {
/* 183 */         DIR d = (DIR)DIR.ALL.get(di);
/* 184 */         int dx = t.x() + d.x();
/* 185 */         int dy = t.y() + d.y();
/*     */         
/* 187 */         if (SETT.IN_BOUNDS(dx, dy)) {
/*     */ 
/*     */ 
/*     */           
/* 191 */           double a = (SETT.PATH()).coster.player.getCost(t.x(), t.y(), dx, dy);
/* 192 */           if (a >= 0.0D) {
/*     */ 
/*     */             
/* 195 */             if ((SETT.ENV()).map.URBAN.get(dx, dy) == 0.0D) {
/* 196 */               a *= 5.0D;
/*     */             }
/* 198 */             a *= 10.0D - 9.0D * (SETT.ENV()).map.SPACE.get(dx, dy);
/* 199 */             if ((SETT.FLOOR()).getter.get(dx, dy) == null)
/* 200 */               a *= 4.0D; 
/* 201 */             if ((SETT.ROOMS()).map.is(dx, dy)) {
/* 202 */               a *= 4.0D;
/*     */             }
/*     */             
/* 205 */             double dot = d.xN() * dirDir.xN() + d.yN() * dirDir.yN();
/* 206 */             a += 2.0D + dot;
/*     */             
/* 208 */             a *= d.tileDistance();
/*     */             
/* 210 */             if (f.pushSmaller(dx, dy, t.getValue() + a, t) != null) {
/* 211 */               f.setValue2(dx, dy, t.getValue2() + d.tileDistance());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 219 */     f.done();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Coo pos(int pos) {
/* 226 */     int side = pos / DEPTH;
/* 227 */     pos %= DEPTH;
/* 228 */     DIR d = dir(pos);
/*     */     
/* 230 */     double tx = this.txs[pos] + d.x() * this.progressTile;
/* 231 */     double ty = this.tys[pos] + d.y() * this.progressTile;
/*     */     
/* 233 */     if (side != 0) {
/* 234 */       int depth = (int)Math.ceil(side / 2.0D);
/* 235 */       d = d.next(2 + side % 2 * 4);
/* 236 */       tx += d.xN() * depth;
/* 237 */       ty += d.yN() * depth;
/*     */     } 
/* 239 */     this.tmp.set(tx * 64.0D + 32.0D, ty * 64.0D + 32.0D);
/* 240 */     return this.tmp;
/*     */   }
/*     */ 
/*     */   
/*     */   public DIR dir(int pos) {
/* 245 */     pos %= DEPTH;
/* 246 */     return (DIR)DIR.ALL.get(this.dirs[pos]);
/*     */   }
/*     */   
/*     */   public int posses() {
/* 250 */     return MAX;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Patrol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package world.map.pathing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.PathGame;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class WPath
/*     */   implements SAVABLE
/*     */ {
/*     */   private short destX;
/*  22 */   private short destY = -1;
/*     */   private byte dir;
/*  24 */   private float movement = 0.0F;
/*  25 */   final PathGame.PathSimple tilePath = new PathGame.PathSimple(256);
/*  26 */   private static final double sqrt = Math.sqrt(2.0D);
/*     */ 
/*     */ 
/*     */   
/*     */   public WPath() {
/*  31 */     clear();
/*  32 */     this.dir = (byte)RND.rInt(DIR.ALL.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  37 */     this.tilePath.save(file);
/*  38 */     file.s(this.destX);
/*  39 */     file.s(this.destY);
/*  40 */     file.b(this.dir);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  45 */     this.tilePath.load(file);
/*  46 */     this.destX = file.s();
/*  47 */     this.destY = file.s();
/*  48 */     this.dir = file.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  53 */     this.tilePath.clear();
/*  54 */     this.destX = -1;
/*  55 */     this.destY = -1;
/*     */   }
/*     */   
/*     */   public void copyTo(WPath tmp) {
/*  59 */     tmp.destX = this.destX;
/*  60 */     tmp.destY = this.destY;
/*  61 */     tmp.dir = this.dir;
/*  62 */     this.tilePath.copyTo(tmp.tilePath);
/*     */   }
/*     */   
/*     */   public int destX() {
/*  66 */     return this.destX;
/*     */   }
/*     */   
/*     */   public int destY() {
/*  70 */     return this.destY;
/*     */   }
/*     */   
/*     */   public boolean isValid() {
/*  74 */     return (this.destX >= 0 && this.destY >= 0);
/*     */   }
/*     */   
/*     */   public DIR dir() {
/*  78 */     return (DIR)DIR.ALL.get(this.dir);
/*     */   }
/*     */   
/*     */   public boolean arrived() {
/*  82 */     return (this.destX == this.tilePath.x() && this.destY == this.tilePath.y());
/*     */   }
/*     */   
/*     */   public int x() {
/*  86 */     return this.tilePath.x();
/*     */   }
/*     */   
/*     */   public int y() {
/*  90 */     return this.tilePath.y();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean find(int sx, int sy, int destX, int destY) {
/*  96 */     clear();
/*  97 */     if (sx == destX && sy == destY) {
/*  98 */       this.destX = (short)destX;
/*  99 */       this.destY = (short)destY;
/* 100 */       this.tilePath.setOne(destX, destY);
/* 101 */       return true;
/*     */     } 
/*     */     
/* 104 */     if (!(WORLD.PATH()).map.is.is(destX, destY)) {
/* 105 */       return false;
/*     */     }
/*     */     
/* 108 */     if (!(WORLD.PATH()).map.is.is(sx, sy)) {
/*     */       
/* 110 */       DIR d = DIR.get(sx, sy, destX, destY);
/* 111 */       if (!(WORLD.PATH()).map.is.is(sx, sy, d))
/*     */       {
/* 113 */         if ((WORLD.PATH()).map.is.is(sx, sy, d.next(1))) {
/* 114 */           d = d.next(1);
/* 115 */         } else if ((WORLD.PATH()).map.is.is(sx, sy, d.next(-1))) {
/* 116 */           d = d.next(-1);
/*     */         } else {
/* 118 */           return false;
/* 119 */         }  }  sx += d.x();
/* 120 */       sy += d.y();
/*     */     } 
/*     */     
/* 123 */     PathTile t = WORLD.PATH().path(sx, sy, destX, destY, treaty());
/*     */     
/* 125 */     if (t != null) {
/* 126 */       this.tilePath.set(t);
/* 127 */       this.destX = (short)destX;
/* 128 */       this.destY = (short)destY;
/*     */       
/* 130 */       return true;
/*     */     } 
/*     */     
/* 133 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean move(WEntity ent, double speed) {
/* 138 */     RECTANGLEE e = ent.body();
/*     */     
/* 140 */     speed *= WPATHING.movementSpeed(ent.ctx(), ent.cty());
/* 141 */     if (!WORLD.WATER().is(ent.ctx(), ent.cty()) && (WORLD.WATER()).isBig.is(x(), y())) {
/* 142 */       speed /= 20.0D;
/*     */     }
/*     */     
/* 145 */     return move(e, speed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean move(RECTANGLEE e, double speed) {
/* 151 */     if (!moving(e)) {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     this.movement = (float)(this.movement + speed);
/*     */     
/* 157 */     while (this.movement > sqrt && isValid()) {
/* 158 */       if (!move(e)) {
/* 159 */         this.movement = 0.0F;
/* 160 */         return false;
/*     */       } 
/*     */     } 
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean move(RECTANGLEE e) {
/* 168 */     int cx = e.cX();
/* 169 */     int cy = e.cY();
/*     */     
/* 171 */     int destx = x() * 64 + 32;
/* 172 */     int desty = y() * 64 + 32;
/*     */     
/* 174 */     int x = 0;
/* 175 */     int y = 0;
/* 176 */     while (this.movement > sqrt) {
/* 177 */       if (cx == destx && cy == desty) {
/* 178 */         return setNext();
/*     */       }
/* 180 */       x = destx - cx;
/* 181 */       y = desty - cy;
/* 182 */       x = CLAMP.i(x, -1, 1);
/* 183 */       y = CLAMP.i(y, -1, 1);
/*     */       
/* 185 */       if (Math.abs(x) != Math.abs(y)) {
/* 186 */         this.movement--;
/*     */       } else {
/* 188 */         this.movement = (float)(this.movement - sqrt);
/*     */       } 
/*     */ 
/*     */       
/* 192 */       cx += x;
/* 193 */       cy += y;
/*     */     } 
/*     */ 
/*     */     
/* 197 */     this.dir = (byte)DIR.get(x, y).id();
/* 198 */     e.moveC(cx, cy);
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean moving(RECTANGLEE e) {
/* 206 */     if (this.destX == -1 || this.destY == -1) {
/* 207 */       this.movement = 0.0F;
/* 208 */       return false;
/*     */     } 
/*     */     
/* 211 */     if (x() == this.destX && y() == this.destY) {
/* 212 */       int cx = e.cX();
/* 213 */       int cy = e.cY();
/* 214 */       int dx = x() * 64 + 32;
/* 215 */       int dy = y() * 64 + 32;
/* 216 */       if (cx == dx && cy == dy)
/* 217 */         return false; 
/*     */     } 
/* 219 */     return true;
/*     */   }
/*     */   
/*     */   public int remaining() {
/* 223 */     return this.tilePath.length() - this.tilePath.getCurrentI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean setNext() {
/* 229 */     if (this.tilePath.setNext()) {
/* 230 */       return true;
/*     */     }
/*     */     
/* 233 */     if (this.destX == this.tilePath.x() && this.destY == this.tilePath.y()) {
/* 234 */       return false;
/*     */     }
/* 236 */     if (find(this.tilePath.x(), this.tilePath.y(), this.destX, this.destY)) {
/*     */       
/* 238 */       this.tilePath.setNext();
/* 239 */       return true;
/*     */     } 
/*     */     
/* 242 */     return false;
/*     */   }
/*     */   
/*     */   public abstract WRegFinder.Treaty treaty();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WPath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
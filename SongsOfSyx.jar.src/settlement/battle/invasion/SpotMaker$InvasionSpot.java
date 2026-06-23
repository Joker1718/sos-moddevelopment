/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayCooShort;
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
/*     */ class InvasionSpot
/*     */ {
/* 212 */   private static Coo bomb = new Coo();
/*     */   public final Rec body;
/*     */   private final ArrayCooShort coos;
/*     */   public final int size;
/*     */   public final DIR dir;
/*     */   private int lastBombarded;
/* 218 */   private static Trajectory traj = new Trajectory();
/*     */   private boolean any = false;
/*     */   
/*     */   public InvasionSpot(FileGetter f) throws IOException {
/* 222 */     this.body = new Rec();
/* 223 */     this.body.load(f);
/* 224 */     this.size = Math.max(this.body.width(), this.body.height());
/* 225 */     this.coos = new ArrayCooShort(this.size);
/* 226 */     this.coos.load(f);
/* 227 */     DIR.ALL.get(f.i());
/* 228 */     this.dir = SpotMaker.dir((RECTANGLE)this.body).perpendicular();
/* 229 */     this.lastBombarded = f.i();
/* 230 */     this.any = f.bool();
/*     */   }
/*     */   
/*     */   public InvasionSpot(Rec rec) {
/* 234 */     this.body = rec;
/* 235 */     this.size = Math.max(rec.width(), rec.height());
/* 236 */     this.coos = new ArrayCooShort(this.size);
/* 237 */     int i = 0;
/* 238 */     for (COORDINATE c : rec) {
/*     */       
/* 240 */       this.coos.set(i).set(c);
/* 241 */       i++;
/*     */     } 
/* 243 */     this.coos.shuffle(i - 1);
/* 244 */     this.coos.set(0);
/* 245 */     this.dir = SpotMaker.dir((RECTANGLE)this.body).perpendicular();
/* 246 */     this.lastBombarded = 0;
/*     */   }
/*     */   
/*     */   public void save(FilePutter p) {
/* 250 */     this.body.save(p);
/* 251 */     this.coos.save(p);
/* 252 */     p.i(this.dir.id());
/* 253 */     p.i(this.lastBombarded);
/* 254 */     p.bool(this.any);
/*     */   }
/*     */ 
/*     */   
/*     */   private COORDINATE getNextBombardStart() {
/* 259 */     int dist = 12;
/*     */     
/* 261 */     while (this.lastBombarded < dist) {
/*     */       
/* 263 */       if (this.coos.getI() >= this.coos.size() - 1) {
/* 264 */         this.coos.set(0);
/* 265 */         if (!this.any)
/* 266 */           this.lastBombarded++; 
/* 267 */         this.any = false;
/*     */       } 
/*     */       
/* 270 */       int sx = this.coos.get().x();
/* 271 */       int sy = this.coos.get().y();
/*     */       
/* 273 */       int x = sx + this.dir.x() * this.lastBombarded;
/* 274 */       int y = sy + this.dir.y() * this.lastBombarded;
/* 275 */       this.coos.inc();
/* 276 */       if ((SETT.PATH()).availability.get(x, y).isSolid(GAME.ARMIES().enemy())) {
/* 277 */         this.any = true;
/* 278 */         bomb.set(sx, sy);
/*     */         
/* 280 */         return (COORDINATE)bomb;
/*     */       } 
/*     */     } 
/* 283 */     return null;
/*     */   }
/*     */   
/*     */   public boolean launchProj() {
/* 287 */     COORDINATE coo = getNextBombardStart();
/* 288 */     if (coo == null)
/* 289 */       return false; 
/* 290 */     int sx = coo.x() * 64 + 32;
/* 291 */     int sy = coo.y() * 64 + 32;
/* 292 */     int x = sx + this.lastBombarded * this.dir.x() * 64;
/* 293 */     int y = sy + this.lastBombarded * this.dir.y() * 64;
/* 294 */     Projectile proj = (SETT.INVADOR()).proj;
/*     */     
/* 296 */     if (this.lastBombarded == 0 || !traj.calcLow(16, sx, sy, x, y, proj.maxAngle(1.0D), proj.velocity(1.0D))) {
/* 297 */       (GAME.ARMIES()).map.breakIt(x / 64, y / 64);
/*     */     } else {
/* 299 */       SETT.PROJS().launch(sx, sy, 16, traj, proj, 0.0D, 1.0D, null);
/*     */     } 
/* 301 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\SpotMaker$InvasionSpot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
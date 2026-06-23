/*     */ package settlement.thing.halfEntity.transport;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.thing.halfEntity.Factory;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public final class TransportEntity
/*     */   extends HalfEntity
/*     */ {
/*  27 */   private static int length = 3;
/*     */   
/*  29 */   final SPath path = new SPath();
/*  30 */   private DIR moveDir = DIR.N;
/*     */   
/*     */   private int amount;
/*     */   
/*     */   private int ox;
/*  35 */   private final int[] oo = Alloc.ii(4 * length); private int oy;
/*     */   private short startTx;
/*     */   private short startTy;
/*     */   private RESOURCE res;
/*     */   private byte ran;
/*     */   private double mov;
/*     */   private boolean mil;
/*  42 */   private final int random = RND.rInt();
/*  43 */   private static VectorImp vec = new VectorImp();
/*  44 */   private static final int[] bumpOff = Alloc.ii(128);
/*     */   
/*     */   static {
/*  47 */     for (int i = 0; i < bumpOff.length; i += 2) {
/*  48 */       bumpOff[i] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*  49 */       bumpOff[i + 1] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TransportEntity() {
/*  55 */     super(64, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  60 */     RESOURCES.map().saver().save((MAPPED)this.res, file);
/*  61 */     file.s(this.startTx);
/*  62 */     file.s(this.startTy);
/*  63 */     file.i(this.moveDir.id());
/*  64 */     file.i(this.amount);
/*  65 */     file.b(this.ran);
/*  66 */     file.d(this.mov);
/*  67 */     file.i(this.ox);
/*  68 */     file.i(this.oy);
/*  69 */     file.bool(this.mil);
/*  70 */     file.isE(this.oo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected HalfEntity load(FileGetter file) throws IOException {
/*  76 */     this.res = (RESOURCE)RESOURCES.map().loader().loadB(file, null);
/*  77 */     this.startTx = file.s();
/*  78 */     this.startTy = file.s();
/*  79 */     this.moveDir = (DIR)DIR.ALL.getC(file.i());
/*  80 */     this.amount = file.i();
/*  81 */     this.ran = file.b();
/*  82 */     this.mov = file.d();
/*  83 */     this.ox = file.i();
/*  84 */     this.oy = file.i();
/*  85 */     this.mil = file.bool();
/*  86 */     file.isE(this.oo);
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean initMilitary(int tx, int ty, byte ran, RESOURCE res, int ramount, DIR d) {
/*  92 */     if (!(SETT.PATH()).finders.entryPoints.find(tx, ty, this.path, 2147483647))
/*  93 */       return false; 
/*  94 */     this.mil = true;
/*  95 */     init(tx, ty, ran, res, ramount, d);
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   boolean initStation(int tx, int ty, byte ran, RESOURCE res, int ramount, DIR d, COORDINATE station) {
/* 100 */     if (!this.path.request(tx, ty, station))
/* 101 */       return false; 
/* 102 */     this.mil = false;
/* 103 */     init(tx, ty, ran, res, ramount, d);
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   private void init(int tx, int ty, byte ran, RESOURCE res, int amount, DIR d) {
/* 108 */     this.moveDir = d;
/* 109 */     this.amount = amount;
/* 110 */     this.res = res;
/* 111 */     this.startTx = (short)tx;
/* 112 */     this.startTy = (short)ty;
/* 113 */     body().moveC((tx * 64 + 32), (ty * 64 + 32));
/* 114 */     this.ran = ran;
/*     */     
/* 116 */     this.ox = (short)body().cX();
/* 117 */     this.oy = (short)body().cY();
/* 118 */     this.mov = 0.0D;
/*     */     
/* 120 */     for (int i = 0; i < this.oo.length / 2; i++) {
/*     */ 
/*     */ 
/*     */       
/* 124 */       this.oo[i * 2] = (int)(body().cX() + d.xN() * i * this.moveDir.tileDistance() * 64.0D);
/* 125 */       this.oo[i * 2 + 1] = (int)(body().cY() + d.yN() * i * this.moveDir.tileDistance() * 64.0D);
/*     */     } 
/*     */     
/* 128 */     add();
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
/*     */   protected void update(double ds) {
/* 143 */     this.mov += ds * 2.0D;
/*     */     
/* 145 */     if (!this.path.isSuccessful()) {
/* 146 */       remove();
/*     */       
/*     */       return;
/*     */     } 
/* 150 */     if (this.mov >= this.moveDir.tileDistance())
/*     */     {
/*     */       
/* 153 */       if (this.path.isDest()) {
/* 154 */         this.mov = this.moveDir.tileDistance();
/* 155 */         if (!this.mil) {
/* 156 */           (SETT.ROOMS()).TRANSPORT.endDelivery(this.startTx, this.startTy, this.res, this.amount, this.path.lengthTotal());
/* 157 */           (SETT.ROOMS()).STATION.deliver(this.res, this.amount, this.path.destX(), this.path.destY());
/* 158 */           this.amount = 0;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 165 */         remove();
/*     */       } else {
/*     */         
/* 168 */         this.mov -= this.moveDir.tileDistance();
/* 169 */         body().moveC(this.ox, this.oy);
/* 170 */         this.path.setNext();
/* 171 */         this.ox = this.path.getSettCX();
/* 172 */         this.oy = this.path.getSettCY();
/* 173 */         this.moveDir = DIR.get(body().cX(), body().cY(), this.ox, this.oy);
/* 174 */         for (int i = this.oo.length / 2 - 1; i > 0; i--) {
/* 175 */           this.oo[i * 2] = this.oo[(i - 1) * 2];
/* 176 */           this.oo[i * 2 + 1] = this.oo[(i - 1) * 2 + 1];
/*     */         } 
/* 178 */         this.oo[0] = this.path.getSettCX();
/* 179 */         this.oo[1] = this.path.getSettCY();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, int x1, int y1) {
/* 189 */     if (this.amount < 0)
/*     */       return; 
/* 191 */     x1 += 32;
/* 192 */     y1 += 32;
/*     */     
/* 194 */     if (this.mil) {
/*     */       
/* 196 */       vec.set(body().cX(), body().cY(), this.ox, this.oy);
/* 197 */       DIR dir = vec.dir();
/* 198 */       int dx = (int)(vec.nX() * this.mov * 64.0D);
/* 199 */       int dy = (int)(vec.nY() * this.mov * 64.0D);
/* 200 */       int x = x1 + dx;
/* 201 */       int y = y1 + dy;
/*     */       
/* 203 */       int bi = (int)(this.mov * 22.0D);
/* 204 */       bi %= bumpOff.length;
/* 205 */       bi &= 0xFFFFFFFE;
/*     */ 
/*     */       
/* 208 */       int cx = x;
/* 209 */       int cy = y;
/* 210 */       SETT.ANIMALS().renderCaravan((SPRITE_RENDERER)r, s, this.mov, cx, cy, null, 0, false, dir.id(), this.ran);
/* 211 */       cx = (int)(x - dir.xN() * 64.0D) + bumpOff[bi];
/* 212 */       cy = (int)(y - dir.yN() * 64.0D) + bumpOff[bi + 1];
/* 213 */       renderCart((SPRITE_RENDERER)r, s, dir.id(), cx, cy, this.ran, this.res, this.amount, this.mov);
/*     */     } else {
/* 215 */       for (int i = 2; i < this.oo.length / 2; i++) {
/* 216 */         int xx = this.oo[i * 2] - body().x1() + 32;
/* 217 */         int yy = this.oo[i * 2 + 1] - body().y1() + 32;
/* 218 */         vec.set(this.oo[i * 2], this.oo[i * 2 + 1], this.oo[(i - 1) * 2], this.oo[(i - 1) * 2 + 1]);
/*     */         
/* 220 */         DIR dir = vec.dir();
/* 221 */         int dx = (int)(vec.nX() * this.mov * 64.0D);
/* 222 */         int dy = (int)(vec.nY() * this.mov * 64.0D);
/* 223 */         int x = x1 + dx + xx;
/* 224 */         int y = y1 + dy + yy;
/*     */         
/* 226 */         int bi = (int)(this.mov * 22.0D) + (this.random >> i * 2) & 0xF;
/* 227 */         bi %= bumpOff.length;
/* 228 */         bi &= 0xFFFFFFFE;
/*     */ 
/*     */ 
/*     */         
/* 232 */         int cx = x + bumpOff[bi];
/* 233 */         int cy = y + bumpOff[bi + 1];
/* 234 */         if (i == 2) {
/* 235 */           int ax = (int)(x + dir.xN() * 64.0D);
/* 236 */           int ay = (int)(y + dir.yN() * 64.0D);
/* 237 */           SETT.ANIMALS().renderCaravan((SPRITE_RENDERER)r, s, this.mov, ax, ay, null, 0, false, dir.id(), this.ran);
/* 238 */           (constructor()).sprite.renderHarness((SPRITE_RENDERER)r, s, dir.id(), cx, cy);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 243 */         renderCart((SPRITE_RENDERER)r, s, dir.id(), cx, cy, this.ran, this.res, this.amount, this.mov);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderCart(SPRITE_RENDERER r, ShadowBatch s, int rot, int cx, int cy, int ran, RESOURCE res, double resamount, double mov) {
/* 255 */     (constructor()).sprite.renderBelow(r, s, rot, cx, cy, mov, ran, 0.0D, res, resamount);
/* 256 */     (constructor()).sprite.render(r, s, rot, cx, cy, 0.0D, this.mil);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 265 */     if (this.amount > 0 && 
/* 266 */       !this.mil) {
/*     */ 
/*     */       
/* 269 */       (SETT.ROOMS()).TRANSPORT.endDelivery(this.startTx, this.startTy, this.res, this.amount, this.path.lengthTotal());
/* 270 */       (SETT.THINGS()).resources.create(body().cX() / 64, body().cY() / 64, this.res, this.amount);
/* 271 */       (SETT.ROOMS()).STATION.reserveCancel(this.res, this.path.destX(), this.path.destY());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected TransportFactory constructor() {
/* 280 */     return (SETT.HALFENTS()).transports;
/*     */   }
/*     */   
/*     */   public void hoverInfo(GBox box) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\transport\TransportEntity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
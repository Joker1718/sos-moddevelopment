/*     */ package settlement.thing.halfEntity.crate;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.thing.halfEntity.Factory;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class TransportEntity extends HalfEntity {
/*  27 */   private static int length = 3;
/*     */   
/*  29 */   private final int[] oo = Alloc.ii(4 * length);
/*     */   
/*  31 */   private static VectorImp vec = new VectorImp();
/*     */   
/*  33 */   private int hi = -1;
/*  34 */   private int ri = -1;
/*     */   
/*     */   private byte ran;
/*     */   
/*     */   private double mov;
/*  39 */   private final int random = RND.rInt(); private int ox; private int oy;
/*     */   private boolean mil;
/*     */   private static final double moveMax = 96.0D;
/*  42 */   private static final int[] bumpOff = Alloc.ii(128);
/*     */   
/*     */   static {
/*  45 */     for (int i = 0; i < bumpOff.length; i += 2) {
/*  46 */       bumpOff[i] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*  47 */       bumpOff[i + 1] = (int)(RND.rSign() * RND.rFloat() * 2.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public TransportEntity() {
/*  53 */     super(64, 64);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  58 */     file.i(this.hi);
/*  59 */     RESOURCES.map().saver().save((MAPPED)res(), file);
/*  60 */     file.b(this.ran);
/*  61 */     file.d(this.mov);
/*  62 */     file.i(this.ox);
/*  63 */     file.i(this.oy);
/*  64 */     file.bool(this.mil);
/*  65 */     file.isE(this.oo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HalfEntity load(FileGetter file) throws IOException {
/*  70 */     this.hi = file.i();
/*  71 */     RESOURCE res = (RESOURCE)RESOURCES.map().loader().loadB(file, null);
/*  72 */     this.ri = (res == null) ? -1 : res.index();
/*  73 */     this.ran = file.b();
/*  74 */     this.mov = file.d();
/*  75 */     this.ox = file.i();
/*  76 */     this.oy = file.i();
/*  77 */     this.mil = file.bool();
/*  78 */     file.isE(this.oo);
/*  79 */     return this;
/*     */   }
/*     */   
/*     */   public RESOURCE res() {
/*  83 */     return (this.ri == -1) ? null : (RESOURCE)RESOURCES.ALL().get(this.ri);
/*     */   }
/*     */   
/*     */   public Humanoid host() {
/*  87 */     ENTITY e = SETT.ENTITIES().getByID(this.hi);
/*  88 */     if (e != null && e instanceof Humanoid)
/*  89 */       return (Humanoid)e; 
/*  90 */     return null;
/*     */   }
/*     */   
/*     */   public double carryAmount() {
/*  94 */     Humanoid h = host();
/*  95 */     if (h == null)
/*  96 */       return -1.0D; 
/*  97 */     return AIModule_Work.getTransportAmount(h);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean init(Humanoid h, int tx, int ty, RESOURCE res, byte ran, boolean mil) {
/* 102 */     body().moveC((tx * 64 + 32), (ty * 64 + 32));
/* 103 */     this.hi = h.id();
/* 104 */     this.ran = ran;
/* 105 */     this.ri = res.bIndex();
/* 106 */     this.ox = (short)body().cX();
/* 107 */     this.oy = (short)body().cY();
/* 108 */     this.mov = 0.0D;
/* 109 */     vec.set((RECTANGLE)body(), h.body());
/*     */     
/* 111 */     DIR d = DIR.N;
/*     */     
/* 113 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(tx, ty);
/* 114 */     if (it != null) {
/* 115 */       d = ((DIR)DIR.ORTHO.get(it.rotation)).perpendicular();
/*     */     }
/* 117 */     for (int i = 0; i < this.oo.length / 2; i++) {
/*     */ 
/*     */ 
/*     */       
/* 121 */       this.oo[i * 2] = (int)(body().cX() + d.xN() * i * 96.0D);
/* 122 */       this.oo[i * 2 + 1] = (int)(body().cY() + d.yN() * i * 96.0D);
/*     */     } 
/*     */ 
/*     */     
/* 126 */     this.mil = mil;
/* 127 */     add();
/* 128 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 137 */     Humanoid a = host();
/* 138 */     if (a == null) {
/* 139 */       remove();
/*     */       
/*     */       return;
/*     */     } 
/* 143 */     double am = carryAmount();
/* 144 */     if (am <= 0.0D) {
/* 145 */       remove();
/*     */       
/*     */       return;
/*     */     } 
/* 149 */     if (this.ox == a.body().cX() && this.oy == a.body().cY()) {
/*     */       return;
/*     */     }
/*     */     
/* 153 */     this.mov = vec.set(this.ox, this.oy, a.body().cX(), a.body().cY());
/*     */     
/* 155 */     if (this.mov >= 96.0D) {
/* 156 */       this.mov = 0.0D;
/* 157 */       body().moveC(this.ox, this.oy);
/* 158 */       this.ox = a.body().cX();
/* 159 */       this.oy = a.body().cY();
/*     */       
/* 161 */       for (int i = this.oo.length / 2 - 1; i > 0; i--) {
/* 162 */         this.oo[i * 2] = this.oo[(i - 1) * 2];
/* 163 */         this.oo[i * 2 + 1] = this.oo[(i - 1) * 2 + 1];
/*     */       } 
/* 165 */       this.oo[0] = a.body().cX();
/* 166 */       this.oo[1] = a.body().cY();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, int x1, int y1) {
/* 173 */     double am = carryAmount();
/* 174 */     if (am < 0.0D)
/*     */       return; 
/* 176 */     x1 += 32;
/* 177 */     y1 += 32;
/*     */     
/* 179 */     if (this.mil) {
/*     */       
/* 181 */       vec.set(body().cX(), body().cY(), this.ox, this.oy);
/* 182 */       DIR dir = vec.dir();
/* 183 */       int dx = (int)(vec.nX() * this.mov);
/* 184 */       int dy = (int)(vec.nY() * this.mov);
/* 185 */       int x = x1 + dx;
/* 186 */       int y = y1 + dy;
/*     */       
/* 188 */       int bi = (int)(this.mov * 2.0D);
/* 189 */       bi %= bumpOff.length;
/* 190 */       bi &= 0xFFFFFFFE;
/*     */ 
/*     */       
/* 193 */       int cx = x;
/* 194 */       int cy = y;
/* 195 */       SETT.ANIMALS().renderCaravan((SPRITE_RENDERER)r, s, this.mov / 64.0D, cx, cy, null, 0, false, dir.id(), this.ran);
/* 196 */       cx = (int)(x - dir.xN() * 64.0D) + bumpOff[bi];
/* 197 */       cy = (int)(y - dir.yN() * 64.0D) + bumpOff[bi + 1];
/* 198 */       renderCart((SPRITE_RENDERER)r, s, dir.id(), cx, cy, this.ran, res(), am, this.mov / 64.0D);
/*     */     } else {
/* 200 */       for (int i = 2; i < this.oo.length / 2; i++) {
/* 201 */         int xx = this.oo[i * 2] - body().x1() + 32;
/* 202 */         int yy = this.oo[i * 2 + 1] - body().y1() + 32;
/* 203 */         vec.set(this.oo[i * 2], this.oo[i * 2 + 1], this.oo[(i - 1) * 2], this.oo[(i - 1) * 2 + 1]);
/*     */         
/* 205 */         DIR dir = vec.dir();
/* 206 */         int dx = (int)(vec.nX() * this.mov);
/* 207 */         int dy = (int)(vec.nY() * this.mov);
/* 208 */         int x = x1 + dx + xx;
/* 209 */         int y = y1 + dy + yy;
/*     */         
/* 211 */         int bi = (int)(this.mov * 2.0D) + (this.random >> i * 2) & 0xF;
/* 212 */         bi %= bumpOff.length;
/* 213 */         bi &= 0xFFFFFFFE;
/*     */ 
/*     */ 
/*     */         
/* 217 */         int cx = x + bumpOff[bi];
/* 218 */         int cy = y + bumpOff[bi + 1];
/* 219 */         if (i == 2) {
/* 220 */           int ax = (int)(x + dir.xN() * 64.0D);
/* 221 */           int ay = (int)(y + dir.yN() * 64.0D);
/* 222 */           SETT.ANIMALS().renderCaravan((SPRITE_RENDERER)r, s, this.mov / 64.0D, ax, ay, null, 0, false, dir.id(), this.ran);
/* 223 */           (constructor()).sprite.renderHarness((SPRITE_RENDERER)r, s, dir.id(), cx, cy);
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 228 */         renderCart((SPRITE_RENDERER)r, s, dir.id(), cx, cy, this.ran, res(), am, this.mov / 64.0D);
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
/* 240 */     (constructor()).sprite.renderBelow(r, s, rot, cx, cy, mov, ran, 0.0D, res, resamount);
/* 241 */     (constructor()).sprite.render(r, s, rot, cx, cy, 0.0D, this.mil);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected TransportFactory constructor() {
/* 252 */     return null;
/*     */   }
/*     */   
/*     */   public void hoverInfo(GBox box) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\crate\TransportEntity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
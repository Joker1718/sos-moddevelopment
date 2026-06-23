/*     */ package settlement.thing.halfEntity.caravan;
/*     */ import init.constant.C;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ 
/*     */ public class Caravan extends HalfEntity {
/*     */   private static final int TRAIL = 5;
/*     */   private static final int LOAD_PER_ANIMAL = 128;
/*     */   final SPath path;
/*     */   RESOURCE res;
/*     */   short amountCarried;
/*     */   short reserved;
/*     */   short reservedGlobally;
/*     */   short tmp;
/*     */   short itype;
/*  29 */   public static int MAX_LOAD = 512; short state; private float movement; private Type type;
/*     */   
/*     */   public Caravan() {
/*  32 */     super(64, 64);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  37 */     this.path = new SPath();
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
/*  50 */     this.ran = (byte)RND.rInt();
/*     */   }
/*  52 */   private int prev; boolean returning; private final byte ran; private static final int[] animation = new int[] {
/*  53 */       0, 1, 2, 1, 3, 4, 3
/*     */     };
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  58 */     this.path.save(file);
/*  59 */     RESOURCES.map().saver().save((MAPPED)this.res, file);
/*  60 */     file.i(this.amountCarried);
/*  61 */     file.i(this.reserved);
/*  62 */     file.i(this.reservedGlobally);
/*  63 */     file.d(this.movement);
/*  64 */     file.i(this.type.index);
/*  65 */     file.i(this.prev);
/*  66 */     file.s(this.tmp);
/*  67 */     file.s(this.itype);
/*  68 */     file.bool(this.returning);
/*     */   }
/*     */   
/*     */   public int carried() {
/*  72 */     return this.amountCarried;
/*     */   }
/*     */   
/*     */   public RESOURCE res() {
/*  76 */     return this.res;
/*     */   }
/*     */   
/*     */   Type type() {
/*  80 */     return this.type;
/*     */   }
/*     */   
/*     */   public TRADE_TYPE tType() {
/*  84 */     return (TRADE_TYPE)TRADE_TYPE.all.get(this.itype);
/*     */   }
/*     */ 
/*     */   
/*     */   protected HalfEntity load(FileGetter file) throws IOException {
/*  89 */     this.path.load(file);
/*  90 */     this.res = (RESOURCE)RESOURCES.map().loader().load(file);
/*  91 */     this.amountCarried = (short)file.i();
/*  92 */     this.reserved = (short)file.i();
/*  93 */     this.reservedGlobally = (short)file.i();
/*  94 */     this.movement = (float)file.d();
/*  95 */     this.type = (Type)Type.all.get(file.i());
/*  96 */     this.prev = file.i();
/*  97 */     this.tmp = file.s();
/*  98 */     this.itype = file.s();
/*  99 */     this.returning = file.bool();
/*     */     
/* 101 */     if (this.res == null) {
/* 102 */       this.res = RESOURCES.WOOD();
/* 103 */       this.amountCarried = 0;
/* 104 */       this.reserved = 0;
/* 105 */       this.reservedGlobally = 0;
/*     */     } 
/*     */     
/* 108 */     type().load(this);
/*     */     
/* 110 */     return this;
/*     */   }
/*     */   
/*     */   boolean init(int tx, int ty, Type type, RESOURCE res, int amount, TRADE_TYPE itype) {
/* 114 */     body().moveC((tx * 64 + 32), (ty * 64 + 32));
/* 115 */     this.res = res;
/* 116 */     this.amountCarried = 0;
/* 117 */     this.movement = 1.0F;
/* 118 */     this.reserved = 0;
/* 119 */     this.reservedGlobally = 0;
/* 120 */     this.itype = (short)itype.index;
/* 121 */     this.type = type;
/* 122 */     this.path.clear();
/* 123 */     this.prev = 0;
/* 124 */     this.returning = false;
/* 125 */     if (this.type.init(this, amount)) {
/* 126 */       add();
/* 127 */       if (added())
/* 128 */         return true; 
/*     */     } 
/* 130 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 135 */     this.movement = (float)(this.movement + ds * 2.0D);
/* 136 */     if (!this.path.isSuccessful()) {
/* 137 */       remove();
/*     */       
/*     */       return;
/*     */     } 
/* 141 */     if (this.movement >= 1.0F) {
/* 142 */       if (this.path.isDest()) {
/* 143 */         if (!this.type.update(this, ds)) {
/* 144 */           if (added())
/* 145 */             remove(); 
/*     */           return;
/*     */         } 
/* 148 */         this.movement--;
/* 149 */       } else if (this.movement >= length()) {
/* 150 */         this.movement = (float)(this.movement - length());
/* 151 */         move();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void move() {
/* 159 */     if (!this.path.isSuccessful()) {
/* 160 */       if (added())
/* 161 */         remove(); 
/*     */       return;
/*     */     } 
/* 164 */     if (this.path.setNext()) {
/* 165 */       int dx = ctx();
/* 166 */       int dy = cty();
/* 167 */       if (!this.path.isDest()) {
/* 168 */         body().moveC(this.path.getSettCX(), this.path.getSettCY());
/* 169 */         dx -= ctx();
/* 170 */         dy -= cty();
/* 171 */         prevPush(dx, dy);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 181 */     int t = 0;
/* 182 */     double d = 1.0D;
/* 183 */     if (!this.path.isDest()) {
/* 184 */       d = this.movement / length();
/* 185 */       t += 8 * animation[(int)(this.movement * animation.length) % animation.length];
/*     */     } 
/*     */     
/* 188 */     int cx = x + body().width() / 2;
/* 189 */     int cy = y + body().height() / 2;
/* 190 */     int max = (int)Math.ceil(this.reservedGlobally / 128.0D);
/* 191 */     int maxload = 128;
/* 192 */     int am = (int)Math.ceil(maxload * this.amountCarried / 128.0D);
/* 193 */     for (int i = 0; i < max + 1; i++) {
/* 194 */       int dx = prevX(i);
/* 195 */       int dy = prevY(i);
/* 196 */       int dir = DIR.get(-dx, -dy).id() & 0x7;
/* 197 */       if (dx != 0 || dy != 0) {
/* 198 */         cx += dx * 64;
/* 199 */         cy += dy * 64;
/* 200 */         int px = (int)(cx + (-64 * dx) * d);
/* 201 */         int py = (int)(cy + (-64 * dy) * d);
/* 202 */         if (i == 0) {
/* 203 */           (SETT.THINGS()).sprites.caravan.renderC((SPRITE_RENDERER)r, t + dir, px, py);
/* 204 */           s.setHeight(4);
/* 205 */           (SETT.THINGS()).sprites.caravan.renderC((SPRITE_RENDERER)s, t + dir, px, py);
/*     */         } else {
/* 207 */           int a = CLAMP.i(am, 0, maxload);
/* 208 */           SETT.ANIMALS().renderCaravan((SPRITE_RENDERER)r, s, d, px, py, this.res, (int)Math.ceil(a / 9.0D), false, dir, this.ran);
/* 209 */           am -= a;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private double length() {
/* 217 */     if (this.path.length() == 0)
/* 218 */       return 0.0D; 
/* 219 */     if ((this.path.x() - ctx()) * (this.path.y() - cty()) != 0)
/* 220 */       return C.SQR2; 
/* 221 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void removeAction() {
/* 226 */     this.type.cancel(this, true);
/*     */   }
/*     */ 
/*     */   
/*     */   protected Factory<? extends HalfEntity> constructor() {
/* 231 */     return (SETT.HALFENTS()).caravans;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int prevX(int back) {
/* 237 */     int am = this.prev >> back * 4 & 0x3;
/* 238 */     if (am == 3)
/* 239 */       return -1; 
/* 240 */     return am;
/*     */   }
/*     */   private void prevPush(int dx, int dy) {
/* 243 */     dx &= 0x3;
/* 244 */     dy &= 0x3;
/* 245 */     this.prev <<= 4;
/* 246 */     this.prev |= dy << 2;
/* 247 */     this.prev |= dx;
/*     */   }
/*     */   private int prevY(int back) {
/* 250 */     int am = this.prev >> back * 4 + 2 & 0x3;
/* 251 */     if (am == 3)
/* 252 */       return -1; 
/* 253 */     return am;
/*     */   }
/*     */   
/* 256 */   private static CharSequence ¤¤Caravan = "¤Caravan";
/*     */   static {
/* 258 */     D.ts(Caravan.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box) {
/* 264 */     box.title(¤¤Caravan);
/* 265 */     this.type.hoverInfo(box, this);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\caravan\Caravan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
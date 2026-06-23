/*     */ package settlement.thing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ESpeed;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DEG;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Gore_BloodCloud
/*     */   extends ThingsGore.Gore
/*     */ {
/*     */   private static final int time = 120;
/*     */   private static final int amount = 350;
/*  26 */   private static final int[][] pos = Alloc.i2(120, 350);
/*  27 */   private ColorImp color = new ColorImp();
/*     */ 
/*     */   
/*     */   static {
/*  31 */     for (int k = 0; k < 350; k += 2) {
/*  32 */       DEG.setRandom();
/*  33 */       double x = (RND.rInt0(5) + 64 + 32);
/*  34 */       double y = (RND.rInt0(5) + 64 + 32);
/*  35 */       double speed = (128.0F + RND.rFloat() * 64.0F * 12.0F) / 60.0D;
/*  36 */       for (int tick = 0; tick < 120; tick++) {
/*  37 */         pos[tick][k] = (int)x;
/*  38 */         pos[tick][k + 1] = (int)y;
/*  39 */         if (speed < 0.0D)
/*  40 */           speed = 0.0D; 
/*  41 */         x += speed * DEG.getCurrentX();
/*  42 */         y += speed * DEG.getCurrentY();
/*  43 */         speed -= 0.4D;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  50 */   private final Rec body = new Rec(192.0D);
/*  51 */   private final ESpeed.Imp speed = new ESpeed.Imp();
/*  52 */   private float timer = -70.0F;
/*     */   private int tick;
/*     */   private int am;
/*     */   
/*     */   Gore_BloodCloud(int index) {
/*  57 */     super(index);
/*  58 */     this.speed.magnitudeTargetSet(0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/*  63 */     this.body.save(f);
/*  64 */     this.speed.save(f);
/*  65 */     f.f(this.timer);
/*  66 */     f.i(this.tick);
/*  67 */     f.i(this.am);
/*  68 */     this.color.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*  73 */     this.body.load(f);
/*  74 */     this.speed.load(f);
/*  75 */     this.timer = f.f();
/*  76 */     this.tick = f.i();
/*  77 */     this.am = f.i();
/*  78 */     this.color.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(int cx, int cy, double sx, double sy, COLOR col) {
/*  83 */     this.color.set(col);
/*  84 */     this.body.moveC(cx, cy);
/*  85 */     this.timer = 0.0F;
/*  86 */     this.tick = 0;
/*  87 */     this.am = 350;
/*  88 */     this.speed.setRaw(sx, sy);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/*  96 */     if (this.speed.isZero()) {
/*  97 */       move((ESpeed)this.speed, ds, 0.0F, (RECTANGLEE)this.body, false);
/*     */     }
/*     */     
/* 100 */     this.speed.magnitudeAdjust(ds, 10.0D, 1.0D);
/*     */     
/* 102 */     this.timer = (float)(this.timer + ds);
/* 103 */     this.tick = (int)(this.timer * 60.0F);
/* 104 */     if (this.tick >= 120) {
/* 105 */       this.am = (int)(350.0F - (this.timer - 2.0F) * 10.0F);
/* 106 */       if (this.am <= 0)
/* 107 */         return false; 
/* 108 */       this.tick = 119;
/*     */     } 
/*     */     
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 118 */     int x = body().x1() + offsetX;
/* 119 */     int y = body().y1() + offsetY;
/*     */ 
/*     */ 
/*     */     
/* 123 */     for (int j = 0; j < this.am; j += 2) {
/* 124 */       bindCol((COLOR)this.color, j, 0.7F);
/* 125 */       r.renderParticle(pos[this.tick][j] + x, pos[this.tick][j + 1] + y);
/*     */     } 
/* 127 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 133 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/* 138 */     return 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 143 */     return (SETT.THINGS()).gore.clouds;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\Gore_BloodCloud.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.thing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DEG;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Gore_BloodDrops
/*     */   extends ThingsGore.Gore
/*     */ {
/*  23 */   private final Rec body = new Rec(192.0D);
/*  24 */   private final byte[] data = Alloc.bb(48);
/*     */   private int lim;
/*     */   private float timerLife;
/*  27 */   private final ColorImp col = new ColorImp();
/*     */   
/*     */   Gore_BloodDrops(int index, Sprites s) {
/*  30 */     super(index);
/*  31 */     for (int i = 0; i < this.data.length; i += 3) {
/*  32 */       DEG.setRandom();
/*  33 */       int d = RND.rInt(64);
/*  34 */       this.data[i] = (byte)(int)(d * DEG.getCurrentX() + 64.0D);
/*  35 */       this.data[i + 1] = (byte)(int)(d * DEG.getCurrentY() + 64.0D);
/*  36 */       this.data[i + 2] = (byte)RND.rInt(s.bloodPool.tiles());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/*  43 */     this.body.save(f);
/*  44 */     f.bs(this.data);
/*  45 */     f.i(this.lim);
/*  46 */     f.f(this.timerLife);
/*  47 */     this.col.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*  52 */     this.body.load(f);
/*  53 */     f.bs(this.data);
/*  54 */     this.lim = f.i();
/*  55 */     this.timerLife = f.f();
/*  56 */     this.col.load(f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(int cx, int cy, double sx, double sy, COLOR col) {
/*  62 */     this.col.set(col);
/*     */ 
/*     */     
/*  65 */     init(cx, cy, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(int x, int y, double amount) {
/*  71 */     this.lim = (int)(16.0D * amount);
/*  72 */     if (this.lim == 0)
/*  73 */       this.lim = 1; 
/*  74 */     if (this.lim > 16)
/*  75 */       this.lim = 16; 
/*  76 */     this.lim *= 3;
/*     */     
/*  78 */     this.timerLife = 250.0F;
/*  79 */     this.body.moveC(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/*  84 */     this.timerLife = (float)(this.timerLife - ds);
/*  85 */     if (this.timerLife < 0.0F)
/*  86 */       return false; 
/*  87 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/*  94 */     for (int i = 0; i < this.lim; i += 3) {
/*  95 */       int x = body().x1() + offsetX + this.data[i];
/*  96 */       int y = body().y1() + offsetY + this.data[i + 1];
/*  97 */       bindCol((COLOR)this.col, i);
/*  98 */       (SETT.THINGS()).sprites.bloodPool.render((SPRITE_RENDERER)r, this.data[i + 2], x, y);
/*     */     } 
/* 100 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 105 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/* 110 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 115 */     return (SETT.THINGS()).gore.drops;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\Gore_BloodDrops.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
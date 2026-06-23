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
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ class Gore_BloodDrop
/*     */   extends ThingsGore.Gore
/*     */ {
/*  22 */   private Rec body = new Rec();
/*     */   private int ran;
/*     */   private float timerLife;
/*  25 */   private final ColorImp color = new ColorImp();
/*     */   
/*     */   Gore_BloodDrop(int index) {
/*  28 */     super(index);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/*  33 */     this.body.save(f);
/*  34 */     f.i(this.ran);
/*  35 */     f.f(this.timerLife);
/*  36 */     this.color.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*  41 */     this.body.load(f);
/*  42 */     this.ran = f.i();
/*  43 */     this.timerLife = f.f();
/*  44 */     this.color.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(int cx, int cy, double sx, double sy, COLOR c) {
/*  49 */     int x = cx;
/*  50 */     int y = cy;
/*  51 */     int w = RND.rInt(16);
/*  52 */     this.color.set(c);
/*  53 */     init(x, y, w);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void init(int x, int y, int dim) {
/*  59 */     DEG.setRandom();
/*  60 */     x = (int)(x + dim * DEG.getCurrentX());
/*  61 */     y = (int)(y + dim * DEG.getCurrentY());
/*     */     
/*  63 */     this.timerLife = 120.0F;
/*  64 */     this.ran = RND.rInt();
/*     */     
/*  66 */     this.body.setDim(sprite().size());
/*  67 */     this.body.moveX1Y1(x, y);
/*     */   }
/*     */   
/*     */   private TILE_SHEET sprite() {
/*  71 */     return (SETT.THINGS()).sprites.bloodPool;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/*  76 */     this.timerLife = (float)(this.timerLife - ds);
/*  77 */     if (this.timerLife < 0.0F)
/*  78 */       return false; 
/*  79 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/*  86 */     bindCol((COLOR)this.color, this.ran >> 8);
/*  87 */     sprite().render((SPRITE_RENDERER)r, this.ran % sprite().tiles(), body().x1() + offsetX, body().y1() + offsetY);
/*  88 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/*  93 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/*  98 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 103 */     return (SETT.THINGS()).gore.drop;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\Gore_BloodDrop.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
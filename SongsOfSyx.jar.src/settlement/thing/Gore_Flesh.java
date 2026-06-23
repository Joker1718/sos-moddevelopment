/*     */ package settlement.thing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ESpeed;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DEG;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public class Gore_Flesh
/*     */   extends ThingsGore.Gore
/*     */ {
/*  24 */   private static COLOR[] cols = new COLOR[64];
/*     */   static {
/*  26 */     for (int i = 0; i < cols.length; i++) {
/*  27 */       double shade = 0.4D + 0.6D * RND.rFloat();
/*  28 */       int r = (int)(127.0D * (shade - RND.rFloat() * 0.05D));
/*  29 */       int g = (int)(127.0D * (shade - RND.rFloat() * 0.05D));
/*  30 */       int b = (int)(127.0D * (shade - RND.rFloat() * 0.05D));
/*  31 */       cols[i] = (COLOR)new ColorImp(r, g, b);
/*     */     } 
/*     */   }
/*     */   
/*  35 */   private final Rec body = new Rec();
/*  36 */   private final ESpeed.Imp speed = new ESpeed.Imp();
/*  37 */   private final ColorImp col = new ColorImp();
/*     */   
/*     */   private int ran;
/*     */   float timer;
/*     */   boolean debris = false;
/*     */   static boolean debr = false;
/*     */   
/*     */   public Gore_Flesh(int index) {
/*  45 */     super(index);
/*  46 */     this.speed.magnitudeTargetSet(0.0D);
/*  47 */     this.speed.accelerationInit(320.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/*  53 */     this.body.save(f);
/*  54 */     this.speed.save(f);
/*  55 */     f.i(this.ran);
/*  56 */     f.f(this.timer);
/*  57 */     f.bool(this.debris);
/*  58 */     this.col.save(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*  63 */     this.body.load(f);
/*  64 */     this.speed.load(f);
/*  65 */     this.ran = f.i();
/*  66 */     this.timer = f.f();
/*  67 */     this.debris = f.bool();
/*  68 */     this.col.load(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(int cx, int cy, double sx, double sy, COLOR col) {
/*  73 */     this.body.setDim(sprite().size(), sprite().size());
/*  74 */     this.body.moveC(cx, cy);
/*  75 */     this.col.set(col);
/*  76 */     this.ran = RND.rInt();
/*  77 */     double m = (128.0F + RND.rFloatP(2.0F) * 960.0F);
/*  78 */     DEG.setRandom();
/*  79 */     this.speed.setRaw(sx + DEG.getCurrentX() * m, sy + DEG.getCurrentY() * m);
/*  80 */     this.timer = 120.0F + RND.rFloat(100.0D);
/*  81 */     this.debris = debr;
/*     */   }
/*     */ 
/*     */   
/*     */   void setDebris() {
/*  86 */     this.debris = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(double ds) {
/*  92 */     if (this.speed.isZero()) {
/*  93 */       this.timer = (float)(this.timer - ds);
/*  94 */       if (this.timer < 0.0F) {
/*  95 */         return false;
/*     */       }
/*  97 */       return true;
/*     */     } 
/*     */     
/* 100 */     this.speed.magnitudeAdjust(ds, 2.0D, 1.0D);
/* 101 */     move((ESpeed)this.speed, ds, 0.5F, (RECTANGLEE)this.body, true);
/* 102 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 108 */     int spriteI = this.ran & sprite().tiles() - 1;
/* 109 */     if (!this.debris) {
/* 110 */       bindCol((COLOR)this.col, this.ran >> 8);
/*     */     } else {
/* 112 */       cols[this.ran >> 8 & 0x3F].bind();
/* 113 */     }  sprite().render((SPRITE_RENDERER)r, spriteI, body().x1() + offsetX, body().y1() + offsetY);
/* 114 */     if (spriteI < 32) {
/* 115 */       shadows.setDistance2Ground(2.0D).setHeight(0);
/* 116 */       sprite().render((SPRITE_RENDERER)shadows, spriteI, body().x1() + offsetX, body().y1() + offsetY);
/*     */     } 
/* 118 */     COLOR.unbind();
/*     */   }
/*     */   
/*     */   private final TILE_SHEET sprite() {
/* 122 */     if (this.debris)
/* 123 */       return (SETT.THINGS()).sprites.debris; 
/* 124 */     return (SETT.THINGS()).sprites.flesh;
/*     */   }
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/* 129 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/* 134 */     return 100;
/*     */   }
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 139 */     return (SETT.THINGS()).gore.flesh;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\Gore_Flesh.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
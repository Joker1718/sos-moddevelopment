/*     */ package settlement.thing;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.ShadowBatch;
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
/*     */ class ThingRubbish
/*     */   extends THINGS.Thing
/*     */ {
/*  53 */   private final Rec body = new Rec(32.0D, 32.0D);
/*     */   private byte hour;
/*     */   private byte ran;
/*     */   
/*     */   ThingRubbish(int index) {
/*  58 */     super(index);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(int cx, int cy, byte ran) {
/*  63 */     this.body.moveC(cx, cy);
/*  64 */     this.ran = ran;
/*  65 */     this.hour = (byte)(TIME.hours().bitsSinceStart() - RND.rInt(TIME.hoursPerDay() / 4) & 0x7F);
/*  66 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RECTANGLE body() {
/*  73 */     return (RECTANGLE)this.body;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/*  80 */     double t = age();
/*  81 */     t /= TIME.hoursPerDay() * 0.25D;
/*  82 */     t = CLAMP.d(t, 0.0D, 1.0D);
/*  83 */     ColorImp.TMP.interpolate(COLOR.WHITE100, COLOR.DARK_BROWN, t);
/*  84 */     ColorImp.TMP.bind();
/*  85 */     (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)r, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*  86 */     COLOR.unbind();
/*  87 */     shadows.setHeight(1).setDistance2Ground(0.0D);
/*  88 */     (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)shadows, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*     */   }
/*     */   
/*     */   int age() {
/*  92 */     int h = TIME.hours().bitsSinceStart() & 0x7F;
/*  93 */     if (h < this.hour) {
/*  94 */       return this.hour - h;
/*     */     }
/*     */     
/*  97 */     h -= this.hour;
/*  98 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int z() {
/* 103 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/* 108 */     this.body.save(f);
/* 109 */     f.b(this.hour);
/* 110 */     f.b(this.ran);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/* 116 */     this.body.load(f);
/* 117 */     this.hour = f.b();
/* 118 */     this.ran = f.b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/* 124 */     return (SETT.THINGS()).rubbish.rubbish;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsRubbish$ThingRubbish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.thing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RecFacade;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
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
/*     */ class ThingRubbishMoving
/*     */   extends THINGS.Thing
/*     */ {
/* 196 */   private static final VectorImp vec = new VectorImp();
/*     */   private byte ran;
/*     */   private double z;
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double x;
/*     */   private double y;
/*     */   private final RecFacade.RecFacadePoint rec;
/*     */   
/*     */   ThingRubbishMoving(int index) {
/* 206 */     super(index);
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
/* 300 */     this.rec = new RecFacade.RecFacadePoint()
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int x1() {
/* 309 */           return (int)ThingsRubbish.ThingRubbishMoving.this.x - 16;
/*     */         }
/*     */ 
/*     */         
/*     */         public int y1() {
/* 314 */           return (int)ThingsRubbish.ThingRubbishMoving.this.y - 16;
/*     */         }
/*     */ 
/*     */         
/*     */         public int width() {
/* 319 */           return 32;
/*     */         }
/*     */ 
/*     */         
/*     */         public int height() {
/* 324 */           return 32;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void init(int cx, int cy, int destx, int desty) {
/*     */     this.ran = (byte)RND.rInt();
/*     */     this.x = cx;
/*     */     this.y = cy;
/*     */     destx += RND.rInt0(64);
/*     */     desty += RND.rInt0(64);
/*     */     if (cx == destx && cy == desty)
/*     */       return; 
/*     */     this.z = vec.set(cx, cy, destx, desty);
/*     */     this.dx = vec.nX();
/*     */     this.dy = vec.nY();
/*     */     double speed = (640.0F + RND.rFloat(256.0D));
/*     */     this.dx *= speed;
/*     */     this.dy *= speed;
/*     */     this.z /= speed;
/*     */     add();
/*     */   }
/*     */   
/*     */   boolean update(double ds) {
/*     */     this.z -= ds;
/*     */     if (this.z <= 0.0D) {
/*     */       remove();
/*     */       (SETT.THINGS()).rubbish.rubbish.make(body().cX(), body().cY(), this.ran);
/*     */       return false;
/*     */     } 
/*     */     this.x += ds * this.dx;
/*     */     this.y += ds * this.dy;
/*     */     if (this.z < 50.0D && SETT.ENTITIES().getAtPoint((int)this.x, (int)this.y) != null) {
/*     */       remove();
/*     */       (SETT.THINGS()).rubbish.rubbish.make(body().cX(), body().cY(), this.ran);
/*     */       return false;
/*     */     } 
/*     */     return true;
/*     */   }
/*     */   
/*     */   public RECTANGLE body() {
/*     */     return (RECTANGLE)this.rec;
/*     */   }
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/*     */     (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)r, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*     */     shadows.setHeight(1).setDistance2Ground(this.z / 25.0D);
/*     */     (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)shadows, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*     */   }
/*     */   
/*     */   protected int z() {
/*     */     return (int)this.z;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter f) {
/*     */     f.d(this.x);
/*     */     f.d(this.y);
/*     */     f.d(this.z);
/*     */     f.d(this.dx);
/*     */     f.d(this.dy);
/*     */     f.b(this.ran);
/*     */   }
/*     */   
/*     */   protected void load(FileGetter f) throws IOException {
/*     */     this.x = f.d();
/*     */     this.y = f.d();
/*     */     this.z = f.d();
/*     */     this.dx = f.d();
/*     */     this.dy = f.d();
/*     */     this.ran = f.b();
/*     */   }
/*     */   
/*     */   public THINGS.ThingFactory<?> factory() {
/*     */     return (SETT.THINGS()).rubbish.rubbishMoving;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsRubbish$ThingRubbishMoving.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
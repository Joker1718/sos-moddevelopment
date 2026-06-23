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
/*     */ import snake2d.util.datatypes.RecFacade;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThingsRubbish
/*     */ {
/*     */   final RubbishHolder rubbish;
/*     */   final RubbishMovingHolder rubbishMoving;
/*     */   
/*     */   public ThingsRubbish(LISTE<THINGS.ThingFactory<?>> all) {
/*  36 */     this.rubbish = new RubbishHolder(all);
/*  37 */     this.rubbishMoving = new RubbishMovingHolder(all);
/*     */   }
/*     */ 
/*     */   
/*     */   void update(float ds) {
/*  42 */     this.rubbish.update(ds);
/*  43 */     this.rubbishMoving.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void throww(int sx, int sy, int destx, int desty) {
/*  48 */     this.rubbishMoving.make(sx, sy, destx, desty);
/*     */   }
/*     */   
/*     */   static class ThingRubbish
/*     */     extends THINGS.Thing {
/*  53 */     private final Rec body = new Rec(32.0D, 32.0D);
/*     */     private byte hour;
/*     */     private byte ran;
/*     */     
/*     */     ThingRubbish(int index) {
/*  58 */       super(index);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void init(int cx, int cy, byte ran) {
/*  63 */       this.body.moveC(cx, cy);
/*  64 */       this.ran = ran;
/*  65 */       this.hour = (byte)(TIME.hours().bitsSinceStart() - RND.rInt(TIME.hoursPerDay() / 4) & 0x7F);
/*  66 */       add();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/*  73 */       return (RECTANGLE)this.body;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/*  80 */       double t = age();
/*  81 */       t /= TIME.hoursPerDay() * 0.25D;
/*  82 */       t = CLAMP.d(t, 0.0D, 1.0D);
/*  83 */       ColorImp.TMP.interpolate(COLOR.WHITE100, COLOR.DARK_BROWN, t);
/*  84 */       ColorImp.TMP.bind();
/*  85 */       (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)r, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*  86 */       COLOR.unbind();
/*  87 */       shadows.setHeight(1).setDistance2Ground(0.0D);
/*  88 */       (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)shadows, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY);
/*     */     }
/*     */     
/*     */     int age() {
/*  92 */       int h = TIME.hours().bitsSinceStart() & 0x7F;
/*  93 */       if (h < this.hour) {
/*  94 */         return this.hour - h;
/*     */       }
/*     */       
/*  97 */       h -= this.hour;
/*  98 */       return h;
/*     */     }
/*     */ 
/*     */     
/*     */     protected int z() {
/* 103 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void save(FilePutter f) {
/* 108 */       this.body.save(f);
/* 109 */       f.b(this.hour);
/* 110 */       f.b(this.ran);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void load(FileGetter f) throws IOException {
/* 116 */       this.body.load(f);
/* 117 */       this.hour = f.b();
/* 118 */       this.ran = f.b();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public THINGS.ThingFactory<?> factory() {
/* 124 */       return (SETT.THINGS()).rubbish.rubbish;
/*     */     }
/*     */   }
/*     */   
/*     */   static final class RubbishHolder
/*     */     extends THINGS.ThingFactory<ThingRubbish>
/*     */   {
/* 131 */     private final ThingsRubbish.ThingRubbish[] gore = new ThingsRubbish.ThingRubbish[5000];
/* 132 */     private final IUpdater up = new IUpdater(5000, TIME.secondsPerDay())
/*     */       {
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/* 136 */           ThingsRubbish.ThingRubbish r = ThingsRubbish.RubbishHolder.this.gore[i];
/*     */           
/* 138 */           if (!r.isRemoved()) {
/* 139 */             int hour = r.age();
/* 140 */             if (hour >= TIME.hoursPerDay())
/* 141 */               r.remove(); 
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*     */     RubbishHolder(LISTE<THINGS.ThingFactory<?>> all) {
/* 147 */       super(all, 5000);
/* 148 */       for (int i = 0; i < this.gore.length; i++) {
/* 149 */         this.gore[i] = new ThingsRubbish.ThingRubbish(i);
/*     */       }
/*     */     }
/*     */     
/*     */     public void make(int cx, int cy) {
/* 154 */       ThingsRubbish.ThingRubbish f = nextInLine();
/* 155 */       f.init(cx, cy, (byte)(RND.rInt() & 0xFF));
/* 156 */       f.add();
/*     */     }
/*     */     
/*     */     public void make(int cx, int cy, byte ran) {
/* 160 */       ThingsRubbish.ThingRubbish f = nextInLine();
/* 161 */       f.init(cx, cy, ran);
/*     */     }
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 166 */       this.up.update(ds);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void save(FilePutter file) {
/* 171 */       this.up.save(file);
/* 172 */       super.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void load(FileGetter file) throws IOException {
/* 177 */       this.up.load(file);
/* 178 */       super.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clear() {
/* 183 */       this.up.clear();
/* 184 */       super.clear();
/*     */     }
/*     */ 
/*     */     
/*     */     protected ThingsRubbish.ThingRubbish[] all() {
/* 189 */       return this.gore;
/*     */     }
/*     */   }
/*     */   
/*     */   static class ThingRubbishMoving
/*     */     extends THINGS.Thing
/*     */   {
/* 196 */     private static final VectorImp vec = new VectorImp();
/*     */     private byte ran;
/*     */     private double z;
/*     */     private double dx;
/*     */     private double dy;
/*     */     private double x;
/*     */     private double y;
/*     */     private final RecFacade.RecFacadePoint rec;
/*     */     
/*     */     ThingRubbishMoving(int index) {
/* 206 */       super(index);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 300 */       this.rec = new RecFacade.RecFacadePoint()
/*     */         {
/*     */           private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public int x1() {
/* 309 */             return (int)ThingsRubbish.ThingRubbishMoving.this.x - 16;
/*     */           }
/*     */ 
/*     */           
/*     */           public int y1() {
/* 314 */             return (int)ThingsRubbish.ThingRubbishMoving.this.y - 16;
/*     */           }
/*     */ 
/*     */           
/*     */           public int width() {
/* 319 */             return 32;
/*     */           }
/*     */           
/*     */           public int height()
/*     */           {
/* 324 */             return 32; }
/*     */         };
/*     */     }
/*     */     protected void init(int cx, int cy, int destx, int desty) { this.ran = (byte)RND.rInt(); this.x = cx; this.y = cy; destx += RND.rInt0(64); desty += RND.rInt0(64); if (cx == destx && cy == desty)
/*     */         return;  this.z = vec.set(cx, cy, destx, desty); this.dx = vec.nX(); this.dy = vec.nY(); double speed = (640.0F + RND.rFloat(256.0D)); this.dx *= speed; this.dy *= speed; this.z /= speed; add(); }
/*     */     boolean update(double ds) { this.z -= ds; if (this.z <= 0.0D) {
/*     */         remove(); (SETT.THINGS()).rubbish.rubbish.make(body().cX(), body().cY(), this.ran); return false;
/*     */       }  this.x += ds * this.dx; this.y += ds * this.dy; if (this.z < 50.0D && SETT.ENTITIES().getAtPoint((int)this.x, (int)this.y) != null) {
/*     */         remove(); (SETT.THINGS()).rubbish.rubbish.make(body().cX(), body().cY(), this.ran); return false;
/*     */       }  return true; }
/*     */     public RECTANGLE body() { return (RECTANGLE)this.rec; } public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) { (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)r, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY); shadows.setHeight(1).setDistance2Ground(this.z / 25.0D); (SETT.THINGS()).sprites.rubbish.render((SPRITE_RENDERER)shadows, this.ran & 0xF, body().x1() + offsetX, body().y1() + offsetY); } protected int z() { return (int)this.z; } protected void save(FilePutter f) { f.d(this.x); f.d(this.y); f.d(this.z); f.d(this.dx); f.d(this.dy); f.b(this.ran); } protected void load(FileGetter f) throws IOException { this.x = f.d(); this.y = f.d(); this.z = f.d(); this.dx = f.d(); this.dy = f.d(); this.ran = f.b(); } public THINGS.ThingFactory<?> factory() { return (SETT.THINGS()).rubbish.rubbishMoving; }
/*     */   } static final class RubbishMovingHolder extends THINGS.ThingFactory<ThingRubbishMoving>
/*     */   {
/* 337 */     RubbishMovingHolder(LISTE<THINGS.ThingFactory<?>> all) { super(all, 1024);
/* 338 */       this.gore = new ThingsRubbish.ThingRubbishMoving[1024];
/* 339 */       for (int i = 0; i < this.gore.length; i++)
/* 340 */         this.gore[i] = new ThingsRubbish.ThingRubbishMoving(i);  }
/*     */     
/*     */     private final ThingsRubbish.ThingRubbishMoving[] gore;
/*     */     
/*     */     public void make(int cx, int cy, int sx, int sy) {
/* 345 */       ThingsRubbish.ThingRubbishMoving f = nextInLine();
/* 346 */       f.init(cx, cy, sx, sy);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 352 */       ThingsRubbish.ThingRubbishMoving g = first();
/* 353 */       ThingsRubbish.ThingRubbishMoving drop = null;
/* 354 */       while (g != null && 
/* 355 */         drop != g) {
/*     */         
/* 357 */         ThingsRubbish.ThingRubbishMoving next = next(g);
/* 358 */         if (g.update(ds) && 
/* 359 */           drop != null) {
/* 360 */           drop = g;
/*     */         }
/*     */ 
/*     */         
/* 364 */         g = next;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected ThingsRubbish.ThingRubbishMoving[] all() {
/* 370 */       return this.gore;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsRubbish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
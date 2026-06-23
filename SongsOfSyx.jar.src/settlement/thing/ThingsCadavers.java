/*     */ package settlement.thing;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import settlement.entity.animal.AnimalSpecies;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.LOG;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.keymap.MAPPED;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.sett.SETT_HOVERABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThingsCadavers
/*     */   extends THINGS.ThingFactory<ThingsCadavers.Cadaver>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  39 */   private final Cadaver[] cadavers = new Cadaver[1024];
/*  40 */   private final IUpdater updater = new IUpdater(this.cadavers.length, 5.0D)
/*     */     {
/*     */       
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/*  45 */         if (!ThingsCadavers.this.cadavers[i].isRemoved()) {
/*  46 */           ThingsCadavers.this.cadavers[i].update((float)timeSinceLast);
/*     */         }
/*     */       }
/*     */     };
/*     */   
/*     */   public final DRAGGABLE.DRAGGABLE_HOLDER draggable;
/*     */   
/*     */   ThingsCadavers(LISTE<THINGS.ThingFactory<?>> all) {
/*  54 */     super(all, 1024);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.draggable = new DRAGGABLE.DRAGGABLE_HOLDER()
/*     */       {
/*     */         public DRAGGABLE draggable(int index)
/*     */         {
/*  64 */           return ThingsCadavers.this.cadavers[index];
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.cadavers.length; i++)
/*     */       this.cadavers[i] = new Cadaver(i); 
/*     */   } protected Cadaver[] all() {
/*  70 */     return this.cadavers;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  75 */     this.updater.save(file);
/*  76 */     super.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  81 */     this.updater.load(file);
/*  82 */     super.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public Cadaver gore(int cx, int cy, AnimalSpecies s) {
/*  87 */     Cadaver c = nextInLine();
/*  88 */     c.gore(cx, cy, s);
/*  89 */     return c;
/*     */   }
/*     */   
/*     */   public Cadaver normal(int cx, int cy, double weight, float damage, AnimalSpecies s, int rot) {
/*  93 */     Cadaver c = nextInLine();
/*  94 */     c.normal(cx, cy, (float)(1.0D - damage), rot, s, weight);
/*  95 */     return c;
/*     */   }
/*     */   
/*     */   public Cadaver skelleton(int cx, int cy, AnimalSpecies spec, int rot) {
/*  99 */     Cadaver c = nextInLine();
/* 100 */     c.skelleton(cx, cy, rot, spec);
/* 101 */     return c;
/*     */   }
/*     */   
/*     */   public Cadaver rotten(int cx, int cy, AnimalSpecies spec, int rot) {
/* 105 */     Cadaver c = nextInLine();
/* 106 */     c.rotten(cx, cy, rot, spec);
/* 107 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 112 */     this.updater.update(ds);
/*     */   }
/*     */   
/*     */   public Cadaver getByIndex(int index) {
/* 116 */     return this.cadavers[index];
/*     */   }
/*     */   
/* 119 */   private static String ¤¤name = "Cadaver";
/* 120 */   private static String ¤¤noRes = "No resources";
/*     */   
/*     */   static {
/* 123 */     D.ts(ThingsCadavers.class);
/*     */   }
/*     */   
/*     */   public static class Cadaver
/*     */     extends THINGS.Thing
/*     */     implements SETT_HOVERABLE, DRAGGABLE
/*     */   {
/*     */     private static final byte stateGore = 0;
/*     */     private static final byte stateNormal = 1;
/*     */     private static final byte stateRotten = 2;
/*     */     private static final byte stateSkelleton = 3;
/*     */     private byte state;
/* 135 */     private static final ColorImp decayColor = new ColorImp(50, 50, 50);
/*     */     
/*     */     private short resExtracted;
/*     */     
/*     */     private short resAvailable;
/*     */     
/*     */     private short weight;
/*     */     
/*     */     private float timer;
/* 144 */     private Rec body = new Rec(96.0D);
/*     */     private byte rot;
/*     */     private byte ran;
/*     */     private float statef;
/*     */     private byte spec;
/*     */     
/*     */     Cadaver(int index) {
/* 151 */       super(index);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void save(FilePutter f) {
/* 156 */       f.b(this.state);
/* 157 */       f.s(this.resExtracted);
/* 158 */       f.s(this.resAvailable);
/* 159 */       f.s(this.weight);
/* 160 */       f.f(this.timer);
/* 161 */       this.body.save(f);
/* 162 */       f.b(this.rot);
/* 163 */       f.b(this.ran);
/* 164 */       f.f(this.statef);
/* 165 */       (SETT.ANIMALS()).map.saver().save((MAPPED)spec(), f);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void load(FileGetter f) throws IOException {
/* 170 */       this.state = f.b();
/* 171 */       this.resExtracted = f.s();
/* 172 */       this.resAvailable = f.s();
/* 173 */       this.weight = f.s();
/* 174 */       this.timer = f.f();
/* 175 */       this.body.load(f);
/* 176 */       this.rot = f.b();
/* 177 */       this.ran = f.b();
/* 178 */       this.statef = f.f();
/* 179 */       this.spec = (byte)((AnimalSpecies)(SETT.ANIMALS()).map.loader().loadB(f, null)).index();
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 184 */       return (RECTANGLE)this.body;
/*     */     }
/*     */     
/*     */     void gore(int cx, int cy, AnimalSpecies spec) {
/* 188 */       this.state = 0;
/* 189 */       this.timer = 120.0F;
/* 190 */       this.body.moveC(cx, cy);
/* 191 */       this.rot = (byte)RND.rInt(8);
/* 192 */       this.spec = (byte)spec.index();
/* 193 */       this.resAvailable = 0;
/* 194 */       add();
/*     */     }
/*     */     
/*     */     void normal(int cx, int cy, float state, int rot, AnimalSpecies spec, double weight) {
/* 198 */       this.state = 1;
/* 199 */       this.timer = 2880.0F;
/* 200 */       this.body.setDim(spec.hitBoxSize());
/* 201 */       this.body.moveC(cx, cy);
/* 202 */       this.rot = (byte)rot;
/* 203 */       this.spec = (byte)spec.index();
/* 204 */       this.statef = state;
/* 205 */       this.resExtracted = 0;
/* 206 */       this.weight = (short)(int)Math.ceil(weight);
/* 207 */       this.resAvailable = 0;
/* 208 */       for (int i = 0; i < spec().resources().size(); i++) {
/* 209 */         this.resAvailable = (short)(this.resAvailable + spec().resAmount(i, this.weight));
/*     */       }
/*     */       
/* 212 */       add();
/*     */     }
/*     */     
/*     */     public AnimalSpecies spec() {
/* 216 */       return (AnimalSpecies)(SETT.ANIMALS()).species.get(this.spec);
/*     */     }
/*     */     
/*     */     void rotten(int cx, int cy, int rot, AnimalSpecies spec) {
/* 220 */       this.state = 2;
/* 221 */       this.timer = 260.0F;
/* 222 */       this.body.moveC(cx, cy);
/* 223 */       rot = (byte)rot;
/* 224 */       this.spec = (byte)spec.index();
/* 225 */       this.resAvailable = 0;
/* 226 */       add();
/*     */     }
/*     */     
/*     */     void skelleton(int cx, int cy, int rot, AnimalSpecies spec) {
/* 230 */       this.state = 3;
/* 231 */       this.timer = 360.0F;
/* 232 */       this.body.moveC(cx, cy);
/* 233 */       rot = (byte)rot;
/* 234 */       this.spec = (byte)spec.index();
/* 235 */       this.resAvailable = 0;
/* 236 */       add();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(Renderer r, ShadowBatch shadows, float ds, int offsetX, int offsetY) {
/* 241 */       int x = this.body.cX() - 48 + offsetX;
/* 242 */       int y = this.body.cY() - 48 + offsetY;
/*     */ 
/*     */       
/* 245 */       SETT.ANIMALS().renderCorpse(spec(), r, shadows, ds, x, y, this.state, this.rot, this.ran, this.statef, (COLOR)decayColor);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void update(float ds) {
/* 252 */       this.timer -= ds;
/*     */       
/* 254 */       if (this.timer > 0.0F) {
/*     */         return;
/*     */       }
/* 257 */       if (this.state == 0) {
/* 258 */         remove();
/* 259 */       } else if (this.state == 1) {
/* 260 */         this.state = 2;
/* 261 */         this.timer = 260.0F;
/* 262 */         this.resAvailable = 0;
/* 263 */       } else if (this.state == 2) {
/* 264 */         this.state = 3;
/* 265 */         this.timer = 360.0F;
/* 266 */         this.resAvailable = 0;
/* 267 */       } else if (this.state == 3) {
/* 268 */         remove();
/*     */       } else {
/* 270 */         throw new RuntimeException();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean resHas() {
/* 276 */       return (this.state == 1 && this.resExtracted < this.resAvailable);
/*     */     }
/*     */     
/*     */     public RESOURCE resRemove() {
/* 280 */       int am = 0;
/* 281 */       for (int i = 0; i < spec().resources().size(); i++) {
/* 282 */         am += spec().resAmount(i, this.weight);
/* 283 */         if (this.resExtracted < am) {
/* 284 */           this.resExtracted = (short)(this.resExtracted + 1);
/* 285 */           if (this.resExtracted == this.resAvailable) {
/* 286 */             this.state = 3;
/* 287 */             this.timer = 260.0F;
/*     */           } 
/* 289 */           double sf = this.resExtracted / this.resAvailable;
/* 290 */           if (sf > this.statef)
/* 291 */             this.statef = (float)sf; 
/* 292 */           return (RESOURCE)spec().resources().get(i);
/*     */         } 
/*     */       } 
/*     */       
/* 296 */       GAME.Notify("" + this.resExtracted + " " + this.resExtracted + " " + am);
/* 297 */       this.state = 3;
/* 298 */       this.timer = 260.0F;
/* 299 */       return (RESOURCE)spec().resources().get(0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setInjuries(double inj) {
/* 304 */       this.statef = (float)inj;
/*     */     }
/*     */     
/*     */     void rem() {
/* 308 */       remove();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hover(GBox text) {
/* 317 */       text.textL(ThingsCadavers.¤¤name);
/* 318 */       text.NL();
/* 319 */       if (!(S.get()).developer)
/*     */         return; 
/* 321 */       if (!resHas()) {
/* 322 */         text.text(ThingsCadavers.¤¤noRes);
/*     */       } else {
/* 324 */         int am = 0;
/* 325 */         for (int i = 0; i < spec().resources().size(); i++) {
/* 326 */           int tot = spec().resAmount(i, this.weight);
/* 327 */           am += tot;
/* 328 */           int a = am - this.resExtracted;
/* 329 */           a = CLAMP.i(a, 0, tot);
/* 330 */           text.setResource((RESOURCE)spec().resources().get(i), a, tot);
/*     */         } 
/*     */       } 
/* 333 */       if ((S.get()).developer) {
/* 334 */         text.add((SPRITE)text.text().add(this.timer));
/* 335 */         text.add((SPRITE)text.text().add(this.state));
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected int z() {
/* 341 */       return 99;
/*     */     }
/*     */ 
/*     */     
/*     */     public THINGS.ThingFactory<?> factory() {
/* 346 */       return (SETT.THINGS()).cadavers;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void drag(DIR d, int cx, int cy, int fromDist) {
/* 352 */       this.rot = (byte)d.perpendicular().id();
/* 353 */       this.body.moveC(cx - fromDist * d.xN(), cy - fromDist * d.yN());
/* 354 */       if (this.body.cX() < 0)
/* 355 */         this.body.moveCX(0.0D); 
/* 356 */       if (this.body.cX() >= SETT.PIXEL_BOUNDS.x2())
/* 357 */         this.body.moveCX((SETT.PIXEL_BOUNDS.x2() - 1)); 
/* 358 */       if (this.body.cY() < 0)
/* 359 */         this.body.moveCY(0.0D); 
/* 360 */       if (this.body.cY() >= SETT.PIXEL_BOUNDS.y2()) {
/* 361 */         this.body.moveCY((SETT.PIXEL_BOUNDS.y2() - 1));
/*     */       }
/* 363 */       if (COORDINATE.tileDistance(cx, cy, body().cX(), body().cY()) > 192.0D) {
/* 364 */         LOG.ln("" + cx + " " + cx + " " + cy);
/*     */       }
/* 366 */       move();
/*     */     }
/*     */ 
/*     */     
/*     */     public void drag(DIR d, int cx, int cy) {
/* 371 */       drag(d, cx, cy, this.body.width());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean canBeDragged() {
/* 377 */       return !isRemoved();
/*     */     }
/*     */     
/*     */     public void makeSkelleton() {
/* 381 */       this.resExtracted = this.resAvailable;
/* 382 */       this.state = 3;
/* 383 */       this.timer = 360.0F;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsCadavers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
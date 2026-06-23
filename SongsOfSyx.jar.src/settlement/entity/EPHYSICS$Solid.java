/*     */ package settlement.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Solid
/*     */   implements EPHYSICS
/*     */ {
/*     */   private static final int MASK = -4;
/*     */   protected double heightOverGround;
/*     */   protected double height;
/*     */   protected double restitution;
/*     */   private float mass;
/*     */   protected float massI;
/*     */   protected final Rec hitbox;
/*     */   protected final Coo currentTile;
/*     */   int x1;
/*     */   int x2;
/*     */   int y1;
/*     */   int y2;
/*     */   protected static final double AIR_REDUCER = 0.005D;
/*     */   protected static final double GROUND_FRICTION = 64.0D;
/*     */   private static final double FLIGHTM = 640.0D;
/*     */   short tx1;
/*     */   short tx2;
/*     */   short ty1;
/*     */   short ty2;
/*     */   
/*     */   public Solid() {
/*  73 */     this.heightOverGround = 0.0D;
/*  74 */     this.height = RND.rFloat(0.01D);
/*  75 */     this.restitution = 0.20000000298023224D;
/*  76 */     this.mass = 1.0F;
/*  77 */     this.massI = 0.0F;
/*  78 */     this.hitbox = new Rec()
/*     */       {
/*     */         private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public Rec moveX1(double X1) {
/*  86 */           super.moveX1(X1);
/*  87 */           EPHYSICS.Solid.this.currentTile.set((cX() >> 6), EPHYSICS.Solid.this.currentTile.y());
/*  88 */           return this;
/*     */         }
/*     */ 
/*     */         
/*     */         public Rec moveY1(double Y1) {
/*  93 */           super.moveY1(Y1);
/*  94 */           EPHYSICS.Solid.this.currentTile.set(EPHYSICS.Solid.this.currentTile.x(), (cY() >> 6));
/*  95 */           return this;
/*     */         }
/*     */       };
/*     */     
/*  99 */     this.currentTile = new Coo();
/* 100 */     this.y2 = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void initMoveCheck() {
/* 113 */     this.x1 = body().x1();
/* 114 */     this.x2 = body().x2();
/* 115 */     this.y1 = body().y1();
/* 116 */     this.y2 = body().y2();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean MoveCheck() {
/* 125 */     return ((this.x1 & 0xFFFFFFFC) == (body().x1() & 0xFFFFFFFC) && (this.y1 & 0xFFFFFFFC) == (body().y1() & 0xFFFFFFFC));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double getHeight() {
/* 131 */     return this.height; } public void setHeight(double height) {
/* 132 */     this.height = height;
/*     */   }
/*     */   
/* 135 */   public double getRestitution() { return this.restitution; } public void setRestitution(float r) {
/* 136 */     this.restitution = r;
/*     */   }
/*     */   public double getMass() {
/* 139 */     return this.mass;
/*     */   } public void setMass(double mass) {
/* 141 */     this.mass = (float)mass;
/* 142 */     if (mass > 0.0D) {
/* 143 */       this.massI = 1.0F / this.mass;
/*     */     } else {
/* 145 */       this.massI = 0.0F;
/*     */     } 
/*     */   }
/*     */   public double getMassI() {
/* 149 */     return this.massI;
/*     */   }
/*     */   
/*     */   public double getZ() {
/* 153 */     return this.heightOverGround; } public void setHeightOverGround(double height) {
/* 154 */     this.heightOverGround = height;
/*     */   }
/*     */   
/*     */   public Rec body() {
/* 158 */     return this.hitbox;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE tileC() {
/* 163 */     return (COORDINATE)this.currentTile;
/*     */   }
/*     */   
/*     */   public void initPosition(Solid other) {
/* 167 */     this.hitbox.set(other);
/* 168 */     this.currentTile.set((COORDINATE)other.currentTile);
/*     */   }
/*     */   
/*     */   public void initPosition(int x, int y, int hitBoxWidth, int hitBoxHeight) {
/* 172 */     this.hitbox.setWidth(hitBoxWidth);
/* 173 */     this.hitbox.setHeight(hitBoxHeight);
/* 174 */     this.hitbox.moveC(x, y);
/* 175 */     this.currentTile.set((x >> 6), (y >> 6));
/*     */   }
/*     */   
/*     */   public void initPosition(BODY_HOLDER e) {
/* 179 */     initPosition(e.body().cX(), e.body().cY(), e.body().width(), e.body().height());
/*     */   }
/*     */   
/*     */   public boolean move(ENTITY e, ESpeed.Imp speed, double ds) {
/* 183 */     if (speed.magnitude() > 0.0D) {
/* 184 */       this.hitbox.incr(speed.x() * ds, speed.y() * ds);
/* 185 */       return true;
/*     */     } 
/*     */     
/* 188 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getFlightMomentum() {
/* 193 */     return getMass() * 640.0D;
/*     */   }
/*     */   
/*     */   public boolean isWithinTile() {
/* 197 */     return (this.tx1 == this.tx2 && this.ty1 == this.ty2);
/*     */   }
/*     */   
/*     */   public int tx1() {
/* 201 */     return this.tx1;
/*     */   }
/*     */   public int tx2() {
/* 204 */     return this.tx2;
/*     */   }
/*     */   public int ty1() {
/* 207 */     return this.ty1;
/*     */   }
/*     */   public int ty2() {
/* 210 */     return this.ty2;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 214 */     file.d(this.heightOverGround);
/* 215 */     file.d(this.height);
/* 216 */     file.d(this.restitution);
/* 217 */     file.f(this.mass);
/* 218 */     file.f(this.massI);
/* 219 */     this.hitbox.save(file);
/* 220 */     this.currentTile.save(file);
/* 221 */     file.s(this.tx1).s(this.tx2).s(this.ty1).s(this.ty2);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 225 */     this.heightOverGround = file.d();
/* 226 */     this.height = file.d();
/* 227 */     this.restitution = file.d();
/* 228 */     this.mass = file.f();
/* 229 */     this.massI = file.f();
/* 230 */     this.hitbox.load(file);
/* 231 */     this.currentTile.load(file);
/* 232 */     this.tx1 = file.s();
/* 233 */     this.tx2 = file.s();
/* 234 */     this.ty1 = file.s();
/* 235 */     this.ty2 = file.s();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\EPHYSICS$Solid.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
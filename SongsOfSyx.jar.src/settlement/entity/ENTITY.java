/*     */ package settlement.entity;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.sett.SETT_HOVERABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class ENTITY
/*     */   implements BODY_HOLDER, SETT_HOVERABLE
/*     */ {
/*  19 */   int handlerId = -1;
/*  20 */   public final ESpeed.Imp speed = new ESpeed.Imp();
/*  21 */   public final EPHYSICS.Solid physics = new EPHYSICS.Solid();
/*     */   transient ENTITY next;
/*     */   transient ENTITY prev;
/*  24 */   short gx = -1, gy = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void renderSimple(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   public final RECTANGLE body() {
/*  39 */     return (RECTANGLE)this.physics.body();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void collide(ECollision paramECollision);
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setCollideDamage(ECollision paramECollision1, ECollision paramECollision2);
/*     */ 
/*     */   
/*     */   protected abstract void meet(ENTITY paramENTITY);
/*     */ 
/*     */   
/*     */   protected abstract boolean willCollideWith(ENTITY paramENTITY);
/*     */ 
/*     */   
/*     */   protected boolean collidesWithOthers(ENTITY e) {
/*  58 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double getDefenceSkill(double paramDouble1, double paramDouble2, double paramDouble3);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean collideTile(boolean paramBoolean, double paramDouble1, double paramDouble2, double paramDouble3, int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void collideUnconnected();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean update(double paramDouble);
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean isRemoved() {
/*  84 */     return (this.handlerId == -1);
/*     */   }
/*     */   
/*     */   protected final void add(boolean collide) {
/*  88 */     SETT.ENTITIES().add(this, collide);
/*     */   }
/*     */   
/*     */   public final void helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie() {
/*  92 */     if (!isRemoved())
/*  93 */       SETT.ENTITIES().remove(this); 
/*     */   }
/*     */   
/*     */   protected abstract void removeAction();
/*     */   
/*     */   public final int id() {
/*  99 */     return this.handlerId;
/*     */   }
/*     */   
/*     */   protected abstract double height();
/*     */   
/*     */   public COORDINATE tc() {
/* 105 */     return this.physics.tileC();
/*     */   }
/*     */   
/*     */   public final int ssx() {
/* 109 */     return this.gx;
/*     */   }
/*     */   
/*     */   public final int ssy() {
/* 113 */     return this.gy;
/*     */   }
/*     */   
/*     */   protected void save(FilePutter file) {
/* 117 */     file.i(this.handlerId);
/* 118 */     file.s(this.gx);
/* 119 */     file.s(this.gy);
/* 120 */     this.speed.save(file);
/* 121 */     this.physics.save(file);
/*     */   }
/*     */   
/*     */   protected final void load(FileGetter file) throws IOException {
/* 125 */     this.handlerId = file.i();
/* 126 */     this.gx = file.s();
/* 127 */     this.gy = file.s();
/* 128 */     this.speed.load(file);
/* 129 */     this.physics.load(file);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\ENTITY.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
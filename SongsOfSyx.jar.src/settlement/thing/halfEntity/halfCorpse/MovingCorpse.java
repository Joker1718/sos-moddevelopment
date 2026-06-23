/*     */ package settlement.thing.halfEntity.halfCorpse;
/*     */ 
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.spirte.HCorpseRenderer;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.thing.halfEntity.Factory;
/*     */ import settlement.thing.halfEntity.HalfEntity;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public final class MovingCorpse
/*     */   extends HalfEntity
/*     */ {
/*     */   private double z;
/*     */   private double dx;
/*     */   private double dy;
/*     */   private double mag;
/*  27 */   private static int rsize = 96;
/*     */   
/*     */   private double x;
/*     */   
/*     */   private double y;
/*     */   private double dirD;
/*     */   private Induvidual indu;
/*     */   private boolean gore;
/*     */   private byte cl;
/*     */   
/*     */   public MovingCorpse() {
/*  38 */     super(rsize, rsize);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter f) {
/*  43 */     f.d(this.x);
/*  44 */     f.d(this.y);
/*  45 */     f.d(this.z);
/*  46 */     f.d(this.mag);
/*  47 */     f.d(this.dx);
/*  48 */     f.d(this.dy);
/*  49 */     f.d(this.dirD);
/*  50 */     f.b(this.cl);
/*  51 */     this.indu.save(f);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected HalfEntity load(FileGetter f) throws IOException {
/*  57 */     this.x = f.d();
/*  58 */     this.y = f.d();
/*  59 */     this.z = f.d();
/*  60 */     this.mag = f.d();
/*  61 */     this.dx = f.d();
/*  62 */     this.dy = f.d();
/*  63 */     this.dirD = f.d();
/*  64 */     this.cl = f.b();
/*  65 */     this.indu = new Induvidual(f);
/*  66 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void init(Humanoid h, boolean gore, CAUSE_LEAVE l) {
/*  71 */     this.x = h.body().cX();
/*  72 */     this.y = h.body().cY();
/*  73 */     this.dirD = h.speed.dir().id();
/*  74 */     this.mag = h.speed.magnitude();
/*  75 */     this.dx = h.speed.nX();
/*  76 */     this.dy = h.speed.nY();
/*  77 */     this.z = h.physics.getZ();
/*  78 */     this.indu = h.indu();
/*  79 */     this.gore = gore;
/*  80 */     this.cl = (byte)l.index();
/*  81 */     add();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  89 */     this.z -= ds * 64.0D;
/*     */     
/*  91 */     if (this.z <= 0.0D) {
/*  92 */       this.z = 0.0D;
/*  93 */       this.mag -= ds * (256.0D + this.mag * 0.1D);
/*     */     } else {
/*  95 */       this.mag -= ds * (512.0D + this.mag * 0.1D);
/*     */     } 
/*  97 */     if (this.mag <= 0.0D) {
/*  98 */       remove();
/*  99 */       (SETT.THINGS()).corpses.create(this.indu, (int)this.x, (int)this.y, (DIR)DIR.ALL.getC((int)this.dirD), !this.gore, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.cl));
/*     */       return;
/*     */     } 
/* 102 */     this.dirD += 0.015625D * this.mag * ds;
/* 103 */     if (this.dirD >= DIR.ALL.size()) {
/* 104 */       this.dirD -= DIR.ALL.size();
/*     */     }
/* 106 */     double nx = this.x + ds * this.mag * this.dx;
/* 107 */     double ny = this.y + ds * this.mag * this.dy;
/*     */     
/* 109 */     if ((SETT.PATH()).solidity.is((int)nx >> 6, (int)ny >> 6)) {
/* 110 */       remove();
/* 111 */       if ((SETT.PATH()).solidity.is((int)this.x >> 6, (int)this.x >> 6)) {
/* 112 */         for (DIR d : DIR.ALL) {
/* 113 */           if ((SETT.PATH()).solidity.is((int)(this.x + d.xN() * 64.0D) >> 6, (int)(this.y + d.yN() * 64.0D) >> 6)) {
/* 114 */             (SETT.THINGS()).corpses.create(this.indu, (int)(this.x + d.xN() * 64.0D), (int)(this.y + d.yN() * 64.0D), (DIR)DIR.ALL.getC((int)this.dirD), !this.gore, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.cl));
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */         return;
/*     */       } 
/* 121 */       (SETT.THINGS()).corpses.create(this.indu, (int)this.x, (int)this.y, (DIR)DIR.ALL.getC((int)this.dirD), !this.gore, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.cl));
/*     */       
/*     */       return;
/*     */     } 
/* 125 */     this.x = nx;
/* 126 */     this.y = ny;
/* 127 */     body().moveC(this.x, this.y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected MovingCorpseFactory constructor() {
/* 137 */     return (SETT.HALFENTS()).corpses;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfo(GBox box) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, ShadowBatch s, float ds, int x, int y) {
/* 149 */     boolean inWater = (SETT.ENTITIES()).submerged.is(ctx(), cty());
/*     */     
/* 151 */     DIR d = (DIR)DIR.ALL.getC((int)this.dirD);
/*     */     
/* 153 */     if (!this.gore) {
/* 154 */       HCorpseRenderer.renderCorpse(this.indu, d.id(), inWater, 0.0D, r, s, x, y, (int)this.z);
/*     */     } else {
/* 156 */       HCorpseRenderer.renderGore(this.indu, d.id(), inWater, 0.0D, r, s, x, y);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\halfCorpse\MovingCorpse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
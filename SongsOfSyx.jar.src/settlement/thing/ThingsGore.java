/*     */ package settlement.thing;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ThingsGore
/*     */ {
/*  14 */   static final float[][] colRan = new float[64][3];
/*     */   static {
/*  16 */     for (int i = 0; i < colRan.length; i++) {
/*  17 */       for (int k = 0; k < (colRan[i]).length; k++) {
/*  18 */         colRan[i][k] = (float)(0.5D + 0.5D * RND.rFloat());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static final int amount = 5000;
/*     */   final GoreHolder flesh;
/*     */   final GoreHolder drop;
/*     */   final GoreHolder clouds;
/*     */   final GoreHolder drops;
/*  29 */   private final COLOR cDebris = (COLOR)new ColorImp(80, 80, 80);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ThingsGore(LISTE<THINGS.ThingFactory<?>> all, float goreamount, Sprites s) {
/*  35 */     Gore_Flesh[] flesht = new Gore_Flesh[5000];
/*  36 */     Gore_BloodDrop[] dropst = new Gore_BloodDrop[5000];
/*  37 */     Gore_BloodDrops[] dropss = new Gore_BloodDrops[5000];
/*  38 */     for (int i = 0; i < flesht.length; i++) {
/*  39 */       flesht[i] = new Gore_Flesh(i);
/*  40 */       dropst[i] = new Gore_BloodDrop(i);
/*  41 */       dropss[i] = new Gore_BloodDrops(i, s);
/*     */     } 
/*  43 */     Gore_BloodCloud[] clouds = new Gore_BloodCloud[1250];
/*  44 */     for (int j = 0; j < clouds.length; j++) {
/*  45 */       clouds[j] = new Gore_BloodCloud(j);
/*     */     }
/*     */     
/*  48 */     this.flesh = new GoreHolder(all, (Gore[])flesht, false);
/*  49 */     this.drop = new GoreHolder(all, (Gore[])dropst, true);
/*  50 */     this.clouds = new GoreHolder(all, (Gore[])clouds, false);
/*  51 */     this.drops = new GoreHolder(all, (Gore[])dropss, true);
/*     */   }
/*     */   
/*     */   void update(float ds) {
/*  55 */     this.flesh.update(ds);
/*  56 */     this.drop.update(ds);
/*  57 */     this.clouds.update(ds);
/*  58 */     this.drops.update(ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void explode(ENTITY e, COLOR col) {
/*  63 */     for (int i = 0; i < 15; i++) {
/*  64 */       flesh(e, col);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  69 */     drops(e, col);
/*  70 */     cloud(e, col);
/*     */   }
/*     */   
/*     */   public void gore(int cx, int cy, COLOR col) {
/*  74 */     this.flesh.make(cx, cy, 0.0D, 0.0D, col);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bleed(ENTITY e, COLOR col) {
/*  79 */     this.drop.make(e, col);
/*     */   }
/*     */   
/*     */   public void bleed(int cx, int cy, double sx, double sy, COLOR col) {
/*  83 */     this.drop.make(
/*  84 */         cx + RND.rInt0(32), 
/*  85 */         cy + RND.rInt0(32), 
/*  86 */         sx, sy, col);
/*     */   }
/*     */ 
/*     */   
/*     */   public void flesh(ENTITY e, COLOR col) {
/*  91 */     this.flesh.make(e, col);
/*     */   }
/*     */   
/*     */   public void debris(ENTITY e) {
/*  95 */     Gore_Flesh.debr = true;
/*  96 */     this.flesh.make(e, this.cDebris);
/*  97 */     Gore_Flesh.debr = false;
/*     */   }
/*     */   
/*     */   public void debris(int cx, int cy, double sx, double sy) {
/* 101 */     Gore_Flesh.debr = true;
/* 102 */     this.flesh.make(cx, cy, sx, sy, this.cDebris);
/* 103 */     this.flesh.make(cx, cy, sx, sy, this.cDebris);
/* 104 */     Gore_Flesh.debr = false;
/*     */   }
/*     */   
/*     */   public void cloud(ENTITY e, COLOR col) {
/* 108 */     this.clouds.make(e, col);
/*     */   }
/*     */   
/*     */   public void drops(ENTITY e, COLOR col) {
/* 112 */     this.drops.make(e, col);
/*     */   }
/*     */   
/*     */   static abstract class Gore
/*     */     extends THINGS.Thing {
/* 117 */     private static final ColorImp colTmp = new ColorImp();
/*     */     
/*     */     Gore(int index) {
/* 120 */       super(index);
/*     */     }
/*     */     
/*     */     protected abstract boolean update(double param1Double);
/*     */     
/*     */     protected abstract void init(int param1Int1, int param1Int2, double param1Double1, double param1Double2, COLOR param1COLOR);
/*     */     
/*     */     protected void bindCol(COLOR color, int am) {
/* 128 */       bindCol(color, am, 1.0F);
/*     */     }
/*     */     
/*     */     protected void bindCol(COLOR color, int am, float mul) {
/* 132 */       float[] tt = ThingsGore.colRan[am & 0x3F];
/* 133 */       colTmp.set((int)(color.red() * tt[0] * mul) & 0xFF, (int)(color.green() * tt[1] * mul) & 0xFF, (int)(color.blue() * tt[2] * mul) & 0xFF).bind();
/*     */     }
/*     */   }
/*     */   
/*     */   public static final class GoreHolder
/*     */     extends THINGS.ThingFactory<Gore>
/*     */   {
/*     */     private final ThingsGore.Gore[] gore;
/*     */     private final boolean slow;
/* 142 */     private double t = 10.0D;
/*     */     
/*     */     GoreHolder(LISTE<THINGS.ThingFactory<?>> all, ThingsGore.Gore[] gore, boolean slow) {
/* 145 */       super(all, gore.length);
/* 146 */       this.gore = gore;
/* 147 */       this.slow = slow;
/*     */     }
/*     */     
/*     */     public void make(ENTITY e, COLOR col) {
/* 151 */       make(
/* 152 */           e.body().cX() + RND.rInt0(32), 
/* 153 */           e.body().cY() + RND.rInt0(32), 
/* 154 */           e.speed.x(), e.speed.y(), col);
/*     */     }
/*     */     
/*     */     public void make(int cx, int cy, double sx, double sy, COLOR col) {
/* 158 */       ThingsGore.Gore f = nextInLine();
/* 159 */       f.init(cx, cy, sx, sy, col);
/* 160 */       f.add();
/*     */     }
/*     */ 
/*     */     
/*     */     void update(double ds) {
/* 165 */       if (this.slow) {
/* 166 */         this.t -= ds;
/* 167 */         if (this.t > 0.0D)
/*     */           return; 
/* 169 */         this.t = 10.0D;
/* 170 */         ds = 10.0D;
/*     */       } 
/*     */ 
/*     */       
/* 174 */       ThingsGore.Gore g = first();
/* 175 */       ThingsGore.Gore drop = null;
/* 176 */       while (g != null) {
/*     */         
/* 178 */         if (drop == null) {
/* 179 */           drop = g;
/* 180 */         } else if (drop == g) {
/*     */           break;
/*     */         } 
/* 183 */         ThingsGore.Gore next = next(g);
/*     */         
/* 185 */         if (!g.update(ds)) {
/* 186 */           g.remove();
/*     */         }
/* 188 */         g = next;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected ThingsGore.Gore[] all() {
/* 194 */       return this.gore;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\ThingsGore.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
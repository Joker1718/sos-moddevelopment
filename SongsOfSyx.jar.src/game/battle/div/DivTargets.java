/*     */ package game.battle.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ 
/*     */ 
/*     */ public final class DivTargets
/*     */ {
/*  19 */   private static final ArrayList<Humanoid> list = new ArrayList(64);
/*  20 */   private float now = -10.0F;
/*  21 */   private int[] targets = Alloc.ii(64);
/*     */   
/*     */   private byte ti;
/*     */   private byte tl;
/*     */   
/*     */   DivTargets(Div div) {
/*  27 */     this.di = div.index();
/*  28 */     saver().clear();
/*     */   }
/*     */   private final short di; static DivTargets s;
/*     */   public Humanoid getNextTarget() {
/*  32 */     double t = TIME.currentSecond();
/*     */ 
/*     */     
/*  35 */     if (TIME.currentSecond() < this.now) {
/*  36 */       return null;
/*     */     }
/*  38 */     while (this.ti < this.tl) {
/*  39 */       Humanoid h = validateTarget(this.targets[this.ti]);
/*  40 */       this.ti = (byte)(this.ti + 1);
/*  41 */       if (h != null) {
/*  42 */         return h;
/*     */       }
/*     */     } 
/*  45 */     this.ti = 0;
/*  46 */     this.tl = 0;
/*     */     
/*  48 */     if (div().deployed() == 0) {
/*  49 */       this.now = (float)(t + 10.0D);
/*  50 */       return null;
/*     */     } 
/*     */     
/*  53 */     COORDINATE c = div().position().centreTile();
/*     */     
/*  55 */     if (c == null) {
/*  56 */       return null;
/*     */     }
/*  58 */     int x = c.x();
/*  59 */     int y = c.y();
/*  60 */     if (!SETT.IN_BOUNDS(x, y)) {
/*  61 */       this.now = (float)(t + 10.0D);
/*  62 */       return null;
/*     */     } 
/*     */     
/*  65 */     list.clearSloppy();
/*  66 */     (SETT.PATH().finders()).target.add(list, x, y, !player(), 128, 64);
/*     */ 
/*     */ 
/*     */     
/*  70 */     for (Humanoid a : list) {
/*  71 */       this.tl = (byte)(this.tl + 1); this.targets[this.tl] = a.id();
/*     */     } 
/*     */     
/*  74 */     if (this.tl == 0) {
/*  75 */       this.now = (float)(t + 10.0D);
/*  76 */       return null;
/*     */     } 
/*  78 */     this.ti = (byte)(this.ti + 1);
/*  79 */     return validateTarget(this.targets[this.ti - 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean player() {
/*  84 */     return (GAME.ARMIES().division(this.di).army() == GAME.ARMIES().player());
/*     */   }
/*     */   
/*     */   private Div div() {
/*  88 */     return GAME.ARMIES().division(this.di);
/*     */   }
/*     */   
/*     */   public Humanoid validateTarget(int pointer) {
/*  92 */     ENTITY e = SETT.ENTITIES().getByID(pointer);
/*  93 */     if (e == null || !(e instanceof Humanoid))
/*  94 */       return null; 
/*  95 */     Humanoid a = (Humanoid)e;
/*  96 */     if (player() == a.indu().hostile()) {
/*  97 */       return a;
/*     */     }
/*     */     
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   static final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/* 111 */         file.f(DivTargets.s.now);
/* 112 */         file.is(DivTargets.s.targets);
/* 113 */         file.b(DivTargets.s.ti);
/* 114 */         file.b(DivTargets.s.tl);
/*     */       }
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/* 119 */         DivTargets.s.now = file.f();
/* 120 */         file.is(DivTargets.s.targets);
/* 121 */         DivTargets.s.ti = file.b();
/* 122 */         DivTargets.s.tl = file.b();
/*     */       }
/*     */ 
/*     */       
/*     */       public void clear() {
/* 127 */         DivTargets.s.ti = 0;
/* 128 */         DivTargets.s.tl = 0;
/* 129 */         DivTargets.s.now = 0.0F;
/*     */       }
/*     */     };
/*     */   
/*     */   SAVABLE saver() {
/* 134 */     s = this;
/* 135 */     return saver;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\div\DivTargets.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
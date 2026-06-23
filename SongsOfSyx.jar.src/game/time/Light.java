/*     */ package game.time;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.color.RGB;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class Light {
/*     */   private boolean isNight = false;
/*     */   private double partOf;
/*     */   private double partOfCircular;
/*  21 */   private final Ambient abient = new Ambient();
/*  22 */   public final LightShadows shadow = new LightShadows();
/*  23 */   private final AmbientLight room = new AmbientLight(0.7D, 0.5D, 0.3D, 0.0F, 20.0F);
/*  24 */   private final Gui gui = new Gui();
/*     */   
/*  26 */   DOUBLE time = new DOUBLE()
/*     */     {
/*     */       public double getD()
/*     */       {
/*  30 */         return TIME.days().bitPartOf();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   Light() {
/*  36 */     ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  40 */           INT.IntImp in = new INT.IntImp(0, 300);
/*  41 */           Light.this.time = (DOUBLE)in;
/*  42 */           GuiSection s = new GuiSection();
/*  43 */           s.add((RENDEROBJ)new GSliderInt((INT.INTE)in, 300, true));
/*  44 */           (VIEW.inters()).popup.show((RENDEROBJ)s, (CLICKABLE)s, true);
/*     */         }
/*     */       };
/*     */     
/*  48 */     IDebugPanel.add("Light Test", a);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bindRoom() {
/*  53 */     this.room.setTilt(20.0D);
/*  54 */     this.room.setDir(180.0D);
/*  55 */     double roomI = 1.0D;
/*  56 */     if (dayIs()) {
/*  57 */       roomI = 1.0D - partOfCircular();
/*  58 */       roomI *= roomI;
/*     */     } 
/*  60 */     this.room.r(0.6D * roomI);
/*  61 */     this.room.g(0.3D * roomI);
/*  62 */     this.room.b(0.1D * roomI);
/*  63 */     CORE.renderer().lightDepthSet(127);
/*  64 */     CORE.renderer().setTileLight(this.room);
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
/*     */   
/*     */   public void apply(RECTANGLE rec, RGB mask) {
/*  78 */     apply(rec.x1(), rec.x2(), rec.y1(), rec.y2(), mask);
/*     */   }
/*     */   
/*     */   public void apply(int x1, int x2, int y1, int y2, RGB mask) {
/*  82 */     this.abient.apply(x1, x2, y1, y2, mask);
/*     */   }
/*     */   
/*     */   public void applyGuiLight(float ds, RECTANGLE rec) {
/*  86 */     this.gui.register(ds, rec);
/*     */   }
/*     */   
/*     */   public void applyGuiLight(float ds, int x1, int x2, int y1, int y2) {
/*  90 */     this.gui.register(ds, x1, x2, y1, y2);
/*     */   }
/*     */   
/*     */   public boolean dayIs() {
/*  94 */     return !this.isNight;
/*     */   }
/*     */   
/*     */   public boolean nightIs() {
/*  98 */     return this.isNight;
/*     */   }
/*     */   
/*     */   public double partOf() {
/* 102 */     return this.partOf;
/*     */   }
/*     */   
/*     */   public double partOfCircular() {
/* 106 */     return this.partOfCircular;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 112 */     double dayL = (TIME.seasons()).currentDay.dayLength();
/* 113 */     double nightL = 1.0D - dayL;
/* 114 */     double now = this.time.getD();
/*     */     
/* 116 */     double dawn = nightL / 2.0D;
/* 117 */     double dusk = dawn + dayL;
/*     */     
/* 119 */     if (now <= dawn) {
/* 120 */       this.partOf = 0.5D + 0.5D * now / dawn;
/* 121 */       this.isNight = true;
/* 122 */     } else if (now <= dusk) {
/* 123 */       this.partOf = (now - dawn) / dayL;
/* 124 */       this.isNight = false;
/*     */     } else {
/* 126 */       this.partOf = 0.5D * (now - dusk) / nightL / 2.0D;
/* 127 */       this.isNight = true;
/*     */     } 
/*     */     
/* 130 */     if (this.partOf <= 0.5D) {
/* 131 */       this.partOfCircular = this.partOf * 2.0D;
/*     */     } else {
/* 133 */       this.partOfCircular = 1.0D - (this.partOf - 0.5D) * 2.0D;
/*     */     } 
/*     */     
/* 136 */     this.shadow.update(this);
/* 137 */     this.gui.update(this, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\time\Light.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.Pendulum;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.gui.misc.GText;
/*     */ 
/*     */ final class Logo {
/*  16 */   private double d = 0.25D;
/*     */   private final int startY;
/*     */   private final int startX;
/*  19 */   private int letterI = 1;
/*  20 */   private double letterTimer = 0.0D;
/*     */   private final int presX1;
/*     */   private final int presY1;
/*     */   private boolean presents = false;
/*  24 */   private double presentsTimer = 0.0D;
/*     */   private final int flashY1;
/*     */   private boolean flashRetreat = false;
/*     */   private static final double letterMax = 0.06D;
/*  28 */   private double wait = 0.0D;
/*  29 */   private final AmbientLight light = new AmbientLight(1.2D, 1.2D, 1.2D, 45.0F, 45.0F);
/*  30 */   private final Pendulum lightD = (new Pendulum()).setZero(0.3D).setFactor((1.0F + RND.rFloat1(0.3D)));
/*  31 */   private final PointLight finish = new PointLight();
/*  32 */   private final GText pres = (new GText((UI.FONT()).H1, "presents")).color(COLOR.WHITE65);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Menu menu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double finTimer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ColorImp co;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Logo(Menu menu) {
/*  59 */     this.finTimer = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     this.co = new ColorImp(); this.menu = menu; int w = 0; for (int i = 0; i < (menu.res.s()).logoGlyps.length; i++)
/*     */       w += (menu.res.s()).logoGlyps[i].width();  int m = 10; this.startX = (C.WIDTH() - w) / 2; this.startY = (C.HEIGHT() - (menu.res.s()).logoGlyps[0].height() + m + (menu.res.s()).logoPresents.height()) / 2; this.flashY1 = this.startY - ((menu.res.s()).logoFlash.height() - (menu.res.s()).logoGlyps[0].height()) / 2;
/*     */     this.presX1 = C.WIDTH() / 2 - this.pres.width() / 2;
/*     */     this.presY1 = this.startY + m + (menu.res.s()).logoGlyps[0].height();
/*     */     this.finish.setRadius((menu.res.s()).logoGlyps[0].height());
/*     */     this.finish.setZ(40);
/* 114 */     this.finish.setRed(10.0D); } protected void render(Renderer r, float ds) { if (this.d > 0.0D) {
/*     */       return;
/*     */     }
/*     */     
/* 118 */     int x1 = this.startX;
/* 119 */     for (int i = 0; i < this.letterI; i++) {
/* 120 */       x1 += (this.menu.res.s()).logoGlyps[i].width();
/*     */     }
/*     */     
/* 123 */     this.light.r(1.2D * RND.rFloat1(0.05D));
/* 124 */     this.light.g(1.2D * RND.rFloat1(0.05D));
/* 125 */     this.light.b(1.2D * RND.rFloat1(0.05D));
/* 126 */     this.light.setDir((45.0F + RND.rFloat0(15.0D)));
/*     */ 
/*     */     
/* 129 */     if (this.flashRetreat || this.letterI < (this.menu.res.s()).logoGlyps.length) {
/*     */       double op;
/* 131 */       if (this.flashRetreat) {
/* 132 */         op = 255.0D - 255.0D * this.letterTimer / 0.06D;
/*     */       } else {
/* 134 */         op = 255.0D * this.letterTimer / 0.06D;
/*     */       } 
/* 136 */       int q = (int)op / 2;
/* 137 */       this.co.setRed(q).setGreen(q).setBlue(q);
/* 138 */       this.co.bind();
/*     */       
/* 140 */       this.lightD.update(ds);
/* 141 */       this.light.r(this.lightD.get() + 0.9D);
/* 142 */       this.light.g(this.lightD.get() + 0.9D);
/* 143 */       this.light.b(this.lightD.get() + 0.9D);
/*     */       
/* 145 */       x1 -= ((this.menu.res.s()).logoFlash.width() - (this.menu.res.s()).logoGlyps[this.letterI].width()) / 2;
/* 146 */       (this.menu.res.s()).logoFlash.render((SPRITE_RENDERER)r, x1, this.flashY1);
/* 147 */       COLOR.unbind();
/*     */     } 
/* 149 */     this.light.register(C.DIM());
/* 150 */     x1 = this.startX;
/* 151 */     int dx = RND.rInt0(64) / 64;
/* 152 */     int dy = RND.rInt0(64) / 64;
/* 153 */     for (int j = 0; j < this.letterI; j++) {
/* 154 */       (this.menu.res.s()).logoColors[j].bind();
/* 155 */       (this.menu.res.s()).logoGlyps[j].render((SPRITE_RENDERER)r, x1 + dx, this.startY + dy);
/* 156 */       x1 += (this.menu.res.s()).logoGlyps[j].width();
/*     */     } 
/* 158 */     COLOR.unbind();
/*     */ 
/*     */ 
/*     */     
/* 162 */     if (this.presents) {
/* 163 */       this.pres.render((SPRITE_RENDERER)r, this.presX1 + dx, this.presY1 + dy);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 168 */     if (this.finTimer > 0.0D) {
/*     */       
/* 170 */       int xl = (int)(1280.0D * this.finTimer + ((C.WIDTH() - 1280) / 2));
/* 171 */       this.finish.set(xl, (C.HEIGHT() / 2));
/* 172 */       this.finish.register();
/*     */     }  }
/*     */ 
/*     */   
/*     */   boolean update(float ds) {
/*     */     if (this.d > 0.0D) {
/*     */       this.d -= ds;
/*     */       if (this.d == 0.0D)
/*     */         this.d = -1.0D; 
/*     */       return true;
/*     */     } 
/*     */     if (this.d != 0.0D) {
/*     */       (this.menu.res.sound()).logo.setGain(0.5D);
/*     */       (this.menu.res.sound()).logo.play();
/*     */     } 
/*     */     this.d = 0.0D;
/*     */     if (this.letterI < (this.menu.res.s()).logoGlyps.length) {
/*     */       this.letterTimer += ds;
/*     */       if (this.letterTimer >= 0.06D) {
/*     */         this.letterTimer = 0.0D;
/*     */         if (this.flashRetreat)
/*     */           this.letterI++; 
/*     */         this.flashRetreat = !this.flashRetreat;
/*     */       } 
/*     */     } else if (this.wait > 0.0D) {
/*     */       this.wait -= ds;
/*     */     } else if (this.finTimer < 0.5D) {
/*     */       this.finTimer += ds;
/*     */     } else {
/*     */       this.presents = true;
/*     */       this.presentsTimer += ds;
/*     */       this.finTimer += ds;
/*     */       if (this.presentsTimer > 3.0D)
/*     */         return false; 
/*     */     } 
/*     */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\Logo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
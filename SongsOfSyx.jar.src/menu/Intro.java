/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ 
/*     */ final class Intro {
/*  14 */   private double timer = 0.0D;
/*  15 */   private int stage = 0; private HOVERABLE head; private SPRITE[] greeting; private final ScMain main;
/*  16 */   private AmbientLight moon = new AmbientLight(); private final Background bg; private final ColorImp mask;
/*     */   Intro(ScMain main, Background bg) {
/*  18 */     D.gInit(this);
/*     */     
/*  20 */     this.head = GUI.getBigText(D.g("greeting", "HAIL MIGHTY DESPOT!"));
/*     */     
/*  22 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  30 */       .greeting = new SPRITE[] { GUI.getSmallText(D.g("0", "You are about to enter the world of Syx.")), GUI.getSmallText(D.g("1", "")), GUI.getSmallText(D.g("2", "This game is still in active development and some features might be changed, removed or added.")), GUI.getSmallText(D.g("3", "If you're a pirate, no one will come after you. But when times are good, consider a purchase!")), GUI.getSmallText(D.g("4", "Suggestions and feedback are welcome.")), GUI.getSmallText(D.g("5", "Beware, if you are using mods, you play at your PC's own risk.")), GUI.getSmallText(D.g("6", "")), GUI.getSmallText(D.g("7", "May the Astari guide your hand to swift victory...")) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     this.mask = new ColorImp(COLOR.BLACK);
/*     */     this.moon.Set(AmbientLight.Strongmoonlight, 0.0D);
/*     */     this.main = main;
/*     */     this.bg = bg; } protected void render(Renderer r, float ds) {
/* 102 */     if (this.stage >= 0 && this.stage < 3) {
/* 103 */       int y = GUI.inner.cY() - 100;
/* 104 */       this.moon.register(C.DIM());
/* 105 */       this.head.body().moveY1(y);
/* 106 */       this.head.body().centerX(C.DIM());
/* 107 */       this.head.render((SPRITE_RENDERER)r, ds);
/*     */       
/* 109 */       y += this.head.body().height() * 2; byte b; int i; SPRITE[] arrayOfSPRITE;
/* 110 */       for (i = (arrayOfSPRITE = this.greeting).length, b = 0; b < i; ) { SPRITE s = arrayOfSPRITE[b];
/* 111 */         int x1 = (C.WIDTH() - s.width()) / 2;
/* 112 */         s.render((SPRITE_RENDERER)r, x1, y);
/* 113 */         y += s.height();
/*     */ 
/*     */         
/*     */         b++; }
/*     */     
/*     */     } 
/*     */     
/* 120 */     if (this.stage > 3) {
/* 121 */       this.moon.register(C.DIM());
/* 122 */       this.main.render((SPRITE_RENDERER)r, ds);
/*     */     } 
/*     */     
/* 125 */     if (this.stage >= 4) {
/* 126 */       r.newLayer(false, 0);
/* 127 */       this.mask.bind();
/* 128 */       this.bg.render((SPRITE_RENDERER)r, ds);
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean update(float ds) {
/*     */     this.timer += ds;
/*     */     switch (this.stage) {
/*     */       case 0:
/*     */         this.moon.Set(AmbientLight.Strongmoonlight, this.timer / 1.5D);
/*     */         if (this.timer > 1.5D) {
/*     */           this.moon.Set(AmbientLight.Strongmoonlight, 1.0D);
/*     */           this.timer = 0.0D;
/*     */           this.stage++;
/*     */         } 
/*     */         break;
/*     */       case 1:
/*     */         if (this.timer > 11.0D) {
/*     */           this.timer = 0.0D;
/*     */           this.stage++;
/*     */         } 
/*     */         break;
/*     */       case 2:
/*     */         this.moon.Set(AmbientLight.Strongmoonlight, 1.0D - this.timer * 2.0D);
/*     */         if (this.timer > 0.5D) {
/*     */           this.moon.Set(AmbientLight.Strongmoonlight, 0.0D);
/*     */           this.timer = 0.0D;
/*     */           this.stage++;
/*     */         } 
/*     */         break;
/*     */       case 3:
/*     */         if (this.timer > 0.5D) {
/*     */           this.timer = 0.0D;
/*     */           this.stage++;
/*     */         } 
/*     */         break;
/*     */       case 4:
/*     */         this.moon.Set(AmbientLight.Strongmoonlight, this.timer / 2.0D);
/*     */         if (this.timer > 1.0D) {
/*     */           this.mask.setRed((int)((this.timer - 1.0D) * 128.0D));
/*     */           this.mask.setGreen((int)((this.timer - 1.0D) * 128.0D));
/*     */           this.mask.setBlue((int)((this.timer - 1.0D) * 128.0D));
/*     */         } 
/*     */         if (this.timer > 2.0D) {
/*     */           this.moon.Set(AmbientLight.Strongmoonlight, 1.0D);
/*     */           this.timer = 0.0D;
/*     */           this.stage++;
/*     */         } 
/*     */         break;
/*     */       case 5:
/*     */         return false;
/*     */     } 
/*     */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\Intro.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
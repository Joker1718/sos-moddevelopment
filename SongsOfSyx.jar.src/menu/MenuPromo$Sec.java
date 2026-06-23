/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.PointLight;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.slider.GTarget;
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
/*     */ class Sec
/*     */   extends GuiSection
/*     */ {
/* 485 */   INT.IntImp current = new INT.IntImp()
/*     */     {
/*     */       public int max() {
/* 488 */         return (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.size() - 1;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get() {
/* 493 */         return CLAMP.i(super.get(), min(), max());
/*     */       }
/*     */ 
/*     */       
/*     */       public int min() {
/* 498 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public Sec() {
/* 504 */     add((RENDEROBJ)new GButt.ButtPanel("new")
/*     */         {
/*     */           protected void clickA() {
/* 507 */             PointLight l = new PointLight();
/* 508 */             l.setRed(1.0D);
/* 509 */             l.setGreen(1.0D);
/* 510 */             l.setBlue(1.0D);
/* 511 */             l.set(C.DIM().cX(), C.DIM().cY());
/* 512 */             l.setZ(20);
/* 513 */             l.setRadius(100);
/* 514 */             (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.add(l);
/* 515 */             MenuPromo.Sec.this.current.i = (MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.size() - 1;
/*     */           }
/*     */         });
/*     */     
/* 519 */     addDown(4, (RENDEROBJ)new GTarget(100, false, true, (INT.INTE)this.current));
/*     */     
/* 521 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "X", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 525 */               return -2000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 530 */               return C.DIM().x2() + 2000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 535 */               return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).x();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 540 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).set(t, ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).y());
/*     */             }
/*     */           }));
/*     */     
/* 544 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "Y", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 548 */               return -2000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 553 */               return C.DIM().x2() + 2000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 558 */               return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).y();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 563 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).set(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).x(), t);
/*     */             }
/*     */           }));
/*     */     
/* 567 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "Z", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 571 */               return -1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 576 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 581 */               return (int)((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).cz();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 586 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setZ(t);
/*     */             }
/*     */           }));
/*     */     
/* 590 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "FOFF", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 594 */               return 1;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 599 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 604 */               return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getFalloff() * 100.0F);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 609 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setFalloff((float)(t / 100.0D));
/*     */             }
/*     */           }));
/*     */     
/* 613 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "RAD", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 617 */               return 10;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 622 */               return 10000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 627 */               return ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getRadius();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 632 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setRadius(t);
/*     */             }
/*     */           }));
/*     */     
/* 636 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "R", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 640 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 645 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 650 */               return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getRed() * 100.0F);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 655 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setRed(t / 100.0D);
/*     */             }
/*     */           }));
/*     */     
/* 659 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "G", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 663 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 668 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 673 */               return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getGreen() * 100.0F);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 678 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setGreen(t / 100.0D);
/*     */             }
/*     */           }));
/*     */     
/* 682 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "B", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 686 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 691 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 696 */               return (int)(((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).getBlue() * 100.0F);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 701 */               ((PointLight)(MenuPromo.Sec.access$0(MenuPromo.Sec.this)).lights.get(MenuPromo.Sec.this.current.i)).setBlue(t / 100.0D);
/*     */             }
/*     */           }));
/*     */     
/* 705 */     body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 711 */     if (CORE.getInput().getKeyboard().isPressed(340)) {
/* 712 */       AmbientLight.full.register(C.DIM());
/* 713 */       COLOR.WHITE10.render(r, (RECTANGLE)body(), 8);
/* 714 */       super.render(r, ds);
/* 715 */       COLOR.GREEN100.render(r, CORE.getInput().getMouse().getCoo().x(), CORE.getInput().getMouse().getCoo().y());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\MenuPromo$Sec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
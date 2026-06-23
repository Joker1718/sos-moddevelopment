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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Sec2
/*     */   extends GuiSection
/*     */ {
/* 726 */   INT.IntImp current = new INT.IntImp()
/*     */     {
/*     */       public int max() {
/* 729 */         return (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.size() - 1;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get() {
/* 734 */         return CLAMP.i(super.get(), min(), max());
/*     */       }
/*     */ 
/*     */       
/*     */       public int min() {
/* 739 */         return 0;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public Sec2() {
/* 745 */     add((RENDEROBJ)new GButt.ButtPanel("new")
/*     */         {
/*     */           protected void clickA() {
/* 748 */             AmbientLight l = MenuPromo.ambient();
/* 749 */             (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.add(l);
/* 750 */             MenuPromo.Sec2.this.current.i = (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).lights.size() - 1;
/*     */           }
/*     */         });
/*     */     
/* 754 */     addDown(4, (RENDEROBJ)new GButt.ButtPanel("delete")
/*     */         {
/*     */           protected void clickA() {
/* 757 */             if ((MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.size() > 0) {
/* 758 */               (MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.remove(MenuPromo.Sec2.this.current.get());
/* 759 */               MenuPromo.Sec2.this.current.inc(-1);
/*     */             } 
/*     */           }
/*     */         });
/*     */     
/* 764 */     addDown(4, (RENDEROBJ)new GTarget(100, false, true, (INT.INTE)this.current));
/*     */     
/* 766 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "DEG", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 770 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 775 */               return 360;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 780 */               return (int)((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).getDir();
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 786 */               ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).setDir(t);
/*     */             }
/*     */           }));
/*     */     
/* 790 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "TILT", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 794 */               return -90;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 799 */               return 90;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 804 */               return (int)((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).getTilt();
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 809 */               ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).setTilt(t);
/*     */             }
/*     */           }));
/*     */     
/* 813 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "R", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 817 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 822 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 827 */               return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r() * 100.0D);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 832 */               ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(t / 100.0D, ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g(), ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b());
/*     */             }
/*     */           }));
/*     */     
/* 836 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "G", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 840 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 845 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 850 */               return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g() * 100.0D);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 855 */               ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r(), t / 100.0D, ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b());
/*     */             }
/*     */           }));
/*     */     
/* 859 */     addDown(4, (RENDEROBJ)new MenuPromo.Slider(paramMenuPromo, "B", new INT.INTE()
/*     */           {
/*     */             public int min()
/*     */             {
/* 863 */               return 0;
/*     */             }
/*     */ 
/*     */             
/*     */             public int max() {
/* 868 */               return 1000;
/*     */             }
/*     */ 
/*     */             
/*     */             public int get() {
/* 873 */               return (int)(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).b() * 100.0D);
/*     */             }
/*     */ 
/*     */             
/*     */             public void set(int t) {
/* 878 */               ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).set(((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).r(), ((AmbientLight)(MenuPromo.Sec2.access$0(MenuPromo.Sec2.this)).alights.get(MenuPromo.Sec2.this.current.i)).g(), t / 100.0D);
/*     */             }
/*     */           }));
/*     */     
/* 882 */     body().centerIn(C.DIM());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 888 */     if (CORE.getInput().getKeyboard().isPressed(341)) {
/* 889 */       AmbientLight.full.register(C.DIM());
/* 890 */       COLOR.WHITE10.render(r, (RECTANGLE)body(), 8);
/* 891 */       super.render(r, ds);
/* 892 */       COLOR.GREEN100.render(r, CORE.getInput().getMouse().getCoo().x(), CORE.getInput().getMouse().getCoo().y());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\MenuPromo$Sec2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
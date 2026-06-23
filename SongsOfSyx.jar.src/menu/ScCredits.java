/*     */ package menu;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ class ScCredits
/*     */   implements SC
/*     */ {
/*     */   private final GuiSection current;
/*  24 */   static CharSequence ¤¤name = "¤credits";
/*     */   
/*     */   static {
/*  27 */     D.ts(ScCredits.class);
/*     */   }
/*     */   
/*     */   private final SC fame;
/*     */   
/*     */   ScCredits(final Menu menu) {
/*  33 */     GuiSection main = new GUI.Shadower();
/*     */     
/*  35 */     MenuScreen sc = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  39 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*     */     
/*  43 */     main.add((RENDEROBJ)sc);
/*     */     
/*  45 */     Json json = new Json((PATHS.BASE()).DATA.gets("Credits"));
/*     */ 
/*     */ 
/*     */     
/*  49 */     int width = MenuScreen.inner.width();
/*     */     
/*  51 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/*  53 */     for (String s : json.keys()) {
/*  54 */       final Json jj = json.json(s);
/*  55 */       rows.add(new RENDEROBJ.RenderImp(width, 48)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, float ds)
/*     */             {
/*  59 */               GUI.COLORS.copper.bind();
/*  60 */               (UI.FONT()).H2.renderCX(r, body().cX(), body().y2() - 24, jj.text("TITLE"));
/*     */             }
/*     */           });
/*     */       
/*  64 */       final String[] nn = jj.texts("CREDS");
/*  65 */       for (int i = 0; i < nn.length; i++) {
/*     */         
/*  67 */         final int from = i;
/*  68 */         int w = 0;
/*  69 */         for (; i < nn.length && (
/*  70 */           w <= 0 || w + 50 + (UI.FONT()).M.getDim(nn[i]).x() <= width); i++)
/*     */         {
/*  72 */           w += 50 + (UI.FONT()).M.getDim(nn[i]).x();
/*     */         }
/*     */         
/*  75 */         final int wi = w;
/*  76 */         final int to = i;
/*  77 */         rows.add(new RENDEROBJ.RenderImp(width, 32)
/*     */             {
/*     */               public void render(SPRITE_RENDERER r, float ds)
/*     */               {
/*  81 */                 GUI.COLORS.label.bind();
/*  82 */                 Font f = (UI.FONT()).M;
/*  83 */                 int x = body().cX() - wi / 2 + 25;
/*  84 */                 for (int i = from; i < to; i++) {
/*  85 */                   f.render(r, nn[i], x, body().y1());
/*  86 */                   x += f.getDim(nn[i]).x() + 50;
/*     */                 } 
/*     */               }
/*     */             });
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     CLICKABLE cLICKABLE1 = (new GScrollRows((Iterable)rows, 416)).view();
/*     */     
/* 110 */     cLICKABLE1.body().centerIn((RECTANGLE)main.body());
/* 111 */     main.add((RENDEROBJ)cLICKABLE1);
/*     */     
/* 113 */     this.current = main;
/* 114 */     this.fame = new ScCreditsFame(menu);
/* 115 */     CLICKABLE cl = GUI.getNavButt(ScCreditsFame.¤¤name);
/* 116 */     cl.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 120 */             menu.switchScreen(ScCredits.this.fame);
/*     */           }
/*     */         });
/*     */     
/* 124 */     sc.addButt((RENDEROBJ)cl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 130 */     if (this.current.hover(mCoo))
/* 131 */       return true; 
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 137 */     this.current.click();
/* 138 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 144 */     this.current.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 150 */     menu.switchScreen(menu.main);
/* 151 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCredits.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
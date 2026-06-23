/*     */ package view.menu;
/*     */ 
/*     */ import init.settings.S;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.Dic;
/*     */ 
/*     */ class IMenuOptions
/*     */   extends GuiSection {
/*     */   IMenuOptions(final IMenu m, Font font, Font small) {
/*  23 */     MenuScreen sc = new MenuScreen(Dic.¤¤OPTIONS, (GCOLOR.T()).H1)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  27 */           m.setMain();
/*     */         }
/*     */       };
/*     */     
/*  31 */     add((RENDEROBJ)sc);
/*     */     
/*  33 */     int am = S.get().all().size();
/*     */     
/*  35 */     RENDEROBJ[] rs = new RENDEROBJ[am];
/*  36 */     am = 0;
/*  37 */     for (S.Setting s : S.get().all())
/*     */     {
/*     */       
/*  40 */       rs[am++] = (RENDEROBJ)new OptionLine(s, small);
/*     */     }
/*     */     
/*  43 */     CLICKABLE cLICKABLE = (new GScrollRows(rs, 300, 0)).view();
/*     */     
/*  45 */     cLICKABLE.body().centerIn((RECTANGLE)body());
/*  46 */     add((RENDEROBJ)cLICKABLE);
/*     */   }
/*     */ 
/*     */   
/*     */   private class OptionLine
/*     */     extends GuiSection
/*     */   {
/*     */     private final SPRITE label;
/*     */     
/*     */     private final GSliderInt sl;
/*     */     
/*     */     private final S.Setting sett;
/*     */     private final Font font;
/*     */     
/*     */     OptionLine(final S.Setting s, Font font) {
/*  61 */       this.sett = s;
/*  62 */       this.font = font;
/*  63 */       body().setWidth(600.0D);
/*     */       
/*  65 */       this.label = font.getText(s.name);
/*     */       
/*  67 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  71 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  76 */             return s.max();
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  81 */             return s.get();
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  86 */             s.set(t);
/*  87 */             S.get().applyRuntimeConfigs();
/*     */           }
/*     */         };
/*     */       
/*  91 */       this.sl = new GSliderInt(ii, 135, false);
/*  92 */       add((RENDEROBJ)this.sl, body().cX() - this.sl.body().width() / 2, 0);
/*  93 */       pad(0, 4);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/*  99 */       super.render(r, ds);
/* 100 */       (GCOLOR.T()).NORMAL.bind();
/* 101 */       Str.TMP.clear();
/* 102 */       this.sett.getValue(Str.TMP);
/* 103 */       this.font.render(r, (CharSequence)Str.TMP, body().x1() + 400, body().y1());
/* 104 */       (GCOLOR.T()).H1.bind();
/* 105 */       this.label.renderCY(r, body().cX() - 80 - this.label.width(), body().cY());
/* 106 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuOptions.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package launcher;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.util.Locale;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.text.D;
/*     */ 
/*     */ class ScreenInfo
/*     */   extends GuiSection {
/*  26 */   private Str hoverInfo = new Str(200);
/*     */   private final Launcher l;
/*     */   
/*     */   ScreenInfo(final Launcher l) {
/*  30 */     D.gInit(this);
/*  31 */     this.l = l;
/*     */ 
/*     */ 
/*     */     
/*  35 */     GUI.Header header1 = new GUI.Header(l.res, D.g("Version"));
/*  36 */     CLICKABLE c = (new GUI.BText(l.res, VERSION.VERSION_STRING, 200)).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  40 */             l.setLog();
/*     */           }
/*     */         });
/*     */     
/*  44 */     add((RENDEROBJ)header1, (RENDEROBJ)c, 0);
/*     */ 
/*     */ 
/*     */     
/*  48 */     CharSequence[] keys = {
/*  49 */         D.g("Platform"), 
/*  50 */         D.g("JRE"), 
/*  51 */         D.g("GPU"), 
/*  52 */         D.g("GPU-Driver")
/*     */       };
/*  54 */     String[] values = {
/*  55 */         System.getProperty("os.name", "generic").toLowerCase(Locale.ROOT), 
/*  56 */         System.getProperty("java.version") + " bits:" + System.getProperty("java.version"), 
/*  57 */         CORE.getGraphics().render(), 
/*  58 */         CORE.getGraphics().renderV()
/*     */       };
/*     */     
/*  61 */     for (int i = 0; i < keys.length; i++) {
/*  62 */       GUI.Header header = new GUI.Header(l.res, keys[i]);
/*  63 */       add((RENDEROBJ)header, (RENDEROBJ)new RENDEROBJ.Sprite((SPRITE)(new Text(l.res.font, values[i])).setScale(1.0D)), 2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  68 */     final ColorImp clink = new ColorImp(20, 100, 100);
/*  69 */     final ColorImp clinkH = new ColorImp(20, 127, 127);
/*     */ 
/*     */     
/*  72 */     CharSequence[] arrayOfCharSequence1 = {
/*  73 */         D.g("localF", "Local Files"), 
/*  74 */         D.g("Saves"), 
/*  75 */         D.g("Screenshots"), 
/*  76 */         D.g("Mods")
/*     */       };
/*  78 */     String[] arrayOfString1 = {
/*  79 */         String.valueOf((PATHS.local()).ROOT.get()), 
/*  80 */         String.valueOf(PATHS.local().save().get()), 
/*  81 */         String.valueOf((PATHS.local()).SCREENSHOT.get()), 
/*  82 */         String.valueOf((PATHS.local()).MODS.get())
/*     */       };
/*     */     
/*  85 */     for (int j = 0; j < arrayOfCharSequence1.length; j++) {
/*  86 */       final String v = arrayOfString1[j];
/*  87 */       GUI.Header header = new GUI.Header(l.res, arrayOfCharSequence1[j]);
/*  88 */       CLICKABLE.ClickableAbs clickableAbs1 = new CLICKABLE.ClickableAbs(l)
/*     */         {
/*     */           Text t;
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  95 */             if (isHovered) {
/*  96 */               clinkH.bind();
/*     */             } else {
/*  98 */               clink.bind();
/*  99 */             }  this.t.render(r, (RECTANGLE)this.body);
/* 100 */             COLOR.unbind();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 105 */             FileManager.openDesctop(v);
/*     */           }
/*     */         };
/* 108 */       add((RENDEROBJ)header, (RENDEROBJ)clickableAbs1, 2);
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
/* 122 */     GUI.Header header2 = new GUI.Header(l.res, D.g("Contact"));
/* 123 */     CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(l)
/*     */       {
/*     */         Text t;
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */           if (isHovered) {
/* 131 */             clinkH.bind();
/*     */           } else {
/* 133 */             clink.bind();
/* 134 */           }  this.t.render(r, (RECTANGLE)this.body);
/* 135 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 140 */           FileManager.sendEmail("info@songsofsyx.com", "Greetings, oh great dev", "Inquiry");
/*     */         }
/*     */       };
/* 143 */     add((RENDEROBJ)header2, (RENDEROBJ)clickableAbs, 2);
/*     */ 
/*     */     
/* 146 */     header2 = new GUI.Header(l.res, D.g("Road-map"));
/* 147 */     clickableAbs = new CLICKABLE.ClickableAbs(l)
/*     */       {
/*     */         Text t;
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 154 */           if (isHovered) {
/* 155 */             clinkH.bind();
/*     */           } else {
/* 157 */             clink.bind();
/* 158 */           }  this.t.render(r, (RECTANGLE)this.body);
/* 159 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/*     */           try {
/* 165 */             ScreenMain.openBrowser("https://trello.com/b/wF5RYqdF/songs-of-syx");
/*     */           }
/* 167 */           catch (IOException e) {
/* 168 */             e.printStackTrace();
/*     */           } 
/*     */         }
/*     */       };
/* 172 */     add((RENDEROBJ)header2, (RENDEROBJ)clickableAbs, 2);
/*     */ 
/*     */     
/* 175 */     CLICKABLE cLICKABLE1 = (new GUI.BText(l.res, D.g("Back"))).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 178 */             l.setMain();
/*     */           }
/*     */         });
/* 181 */     cLICKABLE1.body().moveX2(856.0D).moveY1(body().y1());
/* 182 */     add((RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */     
/* 185 */     body().moveX1Y1(8.0D, 8.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(RENDEROBJ title, RENDEROBJ oo, int dy) {
/* 192 */     title.body().moveY1((body().y2() + dy));
/* 193 */     title.body().moveX2(150.0D);
/* 194 */     add(title);
/* 195 */     addRightC(10, oo);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 201 */     OPACITY.O75.bind();
/* 202 */     COLOR.BLACK.render(r, 0, 896, 0, 448);
/* 203 */     OPACITY.unbind();
/* 204 */     super.render(r, ds);
/* 205 */     if (this.hoverInfo.length() != 0) {
/* 206 */       GUI.c_label.bind();
/* 207 */       this.l.res.font.render(r, (CharSequence)this.hoverInfo, 40, 315, 450, 1.0D);
/* 208 */       this.hoverInfo.clear();
/*     */     } 
/* 210 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
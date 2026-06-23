/*     */ package launcher;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ScreenMain
/*     */   extends GuiSection
/*     */ {
/*     */   ScreenMain(final Launcher l, ScreenLang lang) {
/*  18 */     add(l.res.smallPanel[0], 0, 0);
/*  19 */     for (int i = 0; i <= 5; i++)
/*  20 */       addDown(0, l.res.smallPanel[1]); 
/*  21 */     addDown(0, l.res.smallPanel[2]);
/*     */ 
/*     */ 
/*     */     
/*  25 */     GuiSection buttons = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  29 */     int ww = 150;
/*  30 */     D.gInit(this);
/*     */     
/*  32 */     GUI.BText bText = new GUI.BText(l.res, D.g("Launch"), ww);
/*  33 */     bText.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  36 */             l.setMods();
/*     */           }
/*     */         });
/*  39 */     buttons.add((RENDEROBJ)bText);
/*     */ 
/*     */     
/*  42 */     CLICKABLE cLICKABLE = (new GUI.BText(l.res, D.g("Settings"), ww)).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  45 */             l.setSetts();
/*     */           }
/*     */         });
/*  48 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*     */     
/*  50 */     cLICKABLE = (new GUI.BText(l.res, D.g("Info"), ww)).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  54 */             l.setInfo();
/*     */           }
/*     */         });
/*  57 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*     */     
/*  59 */     cLICKABLE = (new GUI.BText(l.res, D.g("Exit"), ww)).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  62 */             Launcher.startGame = false;
/*  63 */             CORE.annihilate();
/*     */           }
/*     */         });
/*  66 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*     */     
/*  68 */     cLICKABLE = (new GUI.BSpriteBig(l.res.social[3])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*     */             try {
/*  73 */               ScreenMain.openBrowser("https://songsofsyx.mod.io/");
/*     */             }
/*  75 */             catch (IOException e) {
/*  76 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*  80 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*  81 */     cLICKABLE = (new GUI.BSpriteBig(l.res.social[2])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*     */             try {
/*  86 */               ScreenMain.openBrowser("https://discord.gg/eacfCuE");
/*     */             }
/*  88 */             catch (IOException e) {
/*  89 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/*  93 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*  94 */     cLICKABLE = (new GUI.BSpriteBig(l.res.social[1])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*     */             try {
/*  99 */               ScreenMain.openBrowser("https://twitter.com/songsofsyx");
/*     */             }
/* 101 */             catch (IOException e) {
/* 102 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/* 106 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/* 107 */     cLICKABLE = (new GUI.BSpriteBig(l.res.social[0])).clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*     */             try {
/* 112 */               ScreenMain.openBrowser("https://www.youtube.com/channel/UCuWzoe8gnqI1brHv-k3oVyA");
/*     */             }
/* 114 */             catch (IOException e) {
/* 115 */               e.printStackTrace();
/*     */             } 
/*     */           }
/*     */         });
/* 119 */     buttons.addRightC(2, (RENDEROBJ)cLICKABLE);
/*     */     
/* 121 */     body().centerY(0.0D, 448.0D);
/* 122 */     body().centerX(0.0D, 896.0D);
/*     */     
/* 124 */     add(l.res.logo, (896 - l.res.logo.width()) / 2, body().y1() + 60);
/*     */     
/* 126 */     buttons.body().centerX(0.0D, 896.0D);
/* 127 */     buttons.body().moveY1((getLastY2() + 10));
/*     */ 
/*     */ 
/*     */     
/* 131 */     add((RENDEROBJ)buttons);
/*     */     
/* 133 */     add((RENDEROBJ)lang.butt(), 820, 160);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void openBrowser(String url) throws IOException {
/* 150 */     String os = System.getProperty("os.name").toLowerCase();
/* 151 */     if (os.indexOf("win") >= 0) {
/* 152 */       Runtime rt = Runtime.getRuntime();
/* 153 */       rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
/* 154 */     } else if (os.indexOf("mac") >= 0) {
/* 155 */       Runtime rt = Runtime.getRuntime();
/* 156 */       rt.exec("open " + url);
/* 157 */     } else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
/* 158 */       Runtime rt = Runtime.getRuntime();
/* 159 */       String[] browsers = { "epiphany", "firefox", "mozilla", "konqueror", 
/* 160 */           "netscape", "opera", "links", "lynx" };
/*     */       
/* 162 */       StringBuffer cmd = new StringBuffer();
/* 163 */       for (int i = 0; i < browsers.length; i++) {
/* 164 */         if (i == 0) {
/* 165 */           cmd.append(String.format("%s \"%s\"", new Object[] { browsers[i], url }));
/*     */         } else {
/* 167 */           cmd.append(String.format(" || %s \"%s\"", new Object[] { browsers[i], url }));
/*     */         } 
/* 169 */       }  rt.exec(new String[] { "sh", "-c", cmd.toString() });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package util.gui.common;
/*     */ 
/*     */ import game.save.PROP;
/*     */ import game.time.TIME;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.File;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SUPER_SCREENSHOT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class SuperSc
/*     */   extends GuiSection {
/*  36 */   public static CharSequence ¤¤name = "Super screenshot";
/*  37 */   private static CharSequence ¤¤desc = "A super screenshot generates a large image of the current view. It takes some time. Screenshots are saved in your local files. You can find them through the game launcher.";
/*  38 */   private static CharSequence ¤¤time = "Generate a screenshot every {0} in-game day. Older screenshots will be overwritten by new based on how many screenshots you keep";
/*  39 */   private static CharSequence ¤¤keep = "Save and keep {0} screenshot-files. If file amount is exceeded, they fill be overwritten.";
/*  40 */   private static CharSequence ¤¤sc = "¤Super Screenshot";
/*     */   
/*     */   private final String fn;
/*     */   private final SUPER_SCREENSHOT[] shot;
/*     */   
/*     */   static {
/*  46 */     D.ts(SuperSc.class);
/*     */   }
/*     */   
/*  49 */   private final double[] day = new double[] {
/*  50 */       -1.0D, 
/*  51 */       16.0D, 
/*  52 */       8.0D, 
/*  53 */       4.0D, 
/*  54 */       2.0D, 
/*  55 */       1.0D, 
/*  56 */       0.5D
/*     */     };
/*     */   
/*     */   private final INT.IntImp iday;
/*     */   
/*     */   private final INT.IntImp saved;
/*     */   private final INT.IntImp quality;
/*  63 */   double old = 0.0D;
/*     */ 
/*     */   
/*     */   public SuperSc(String fn, final SUPER_SCREENSHOT[] shot, String saveKey) {
/*  67 */     this.fn = fn;
/*  68 */     this.shot = shot;
/*  69 */     add((RENDEROBJ)new GHeader(¤¤name));
/*  70 */     addRelBody(4, DIR.S, (RENDEROBJ)(new GText((UI.FONT()).M, ¤¤desc)).setMaxWidth(400).r(DIR.N));
/*     */     
/*  72 */     addRelBody(4, DIR.S, (RENDEROBJ)new GButt.ButtPanel(String.valueOf(Dic.¤¤Generate) + " 1")
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  76 */             SuperSc.this.take();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/*  81 */     this.iday = new II(saveKey, "DAY", 0, this.day.length - 1, 0);
/*  82 */     this.saved = new II(saveKey, "SAVED", 0, 400, 100);
/*  83 */     this.quality = new II(saveKey, "QUALITY", 0, shot.length - 1, (shot.length - 1) / 2);
/*     */ 
/*     */ 
/*     */     
/*  87 */     addRelBody(16, DIR.S, (RENDEROBJ)new GHeader(Dic.¤¤Quality));
/*  88 */     GuiSection ss = new GuiSection();
/*  89 */     GSliderInt sl = new GSliderInt((INT.INTE)this.quality, 100, false);
/*  90 */     ss.add((RENDEROBJ)sl);
/*  91 */     ss.addRightC(40, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  95 */             double s = shot[SuperSc.this.quality.get()].fileSizeMB();
/*  96 */             text.add('~');
/*  97 */             GFORMAT.f(text, s, 1);
/*  98 */             text.add('M').add('b');
/*     */           }
/*     */         });
/* 101 */     addRelBody(3, DIR.S, (RENDEROBJ)ss);
/*     */ 
/*     */     
/* 104 */     if (saveKey != null) {
/* 105 */       addRelBody(16, DIR.S, (RENDEROBJ)new GHeader(Dic.¤¤Timer));
/*     */ 
/*     */ 
/*     */       
/* 109 */       GuiSection guiSection = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 113 */             GBox b = (GBox)text;
/*     */             
/* 115 */             if (SuperSc.this.iday.get() > 0) {
/* 116 */               Str.TMP.clear().add(SuperSc.¤¤time).insert(0, SuperSc.this.day[SuperSc.this.iday.get()], 1);
/* 117 */               b.text((CharSequence)Str.TMP);
/*     */             } else {
/* 119 */               b.text(Dic.¤¤Deactivated);
/*     */             } 
/*     */           }
/*     */         };
/*     */       
/* 124 */       guiSection.add((SPRITE)(UI.icons()).s.clock, 0, 0);
/* 125 */       guiSection.addRightC(8, (RENDEROBJ)new GSliderInt((INT.INTE)this.iday, 200, true));
/* 126 */       addRelBody(4, DIR.S, (RENDEROBJ)guiSection);
/*     */ 
/*     */       
/* 129 */       this.saved.set(100);
/*     */       
/* 131 */       guiSection = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 135 */             GBox b = (GBox)text;
/* 136 */             Str.TMP.clear().add(SuperSc.¤¤keep).insert(0, SuperSc.this.saved.get());
/* 137 */             b.text((CharSequence)Str.TMP);
/*     */           }
/*     */         };
/*     */       
/* 141 */       guiSection.add((SPRITE)(UI.icons()).s.storage, 0, 0);
/* 142 */       guiSection.addRightC(8, (RENDEROBJ)new GSliderInt((INT.INTE)this.saved, 200, false));
/* 143 */       addDown(2, (RENDEROBJ)guiSection);
/*     */       
/* 145 */       Interrupter in = new Interrupter(true, true)
/*     */         {
/*     */           
/*     */           protected boolean update(float ds)
/*     */           {
/* 150 */             double dday = SuperSc.this.day[SuperSc.this.iday.get()];
/* 151 */             if (dday < 0.0D) {
/* 152 */               return true;
/*     */             }
/* 154 */             double d = TIME.secondsPerDay() * dday;
/*     */             
/* 156 */             double day = TIME.currentSecond() / d % 1.0D;
/* 157 */             if (SuperSc.this.old < 0.5D && day >= 0.5D) {
/* 158 */               SuperSc.this.take();
/*     */             }
/* 160 */             SuperSc.this.old = day;
/*     */             
/* 162 */             return true;
/*     */           }
/*     */ 
/*     */           
/*     */           protected boolean render(Renderer r, float ds) {
/* 167 */             return true;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 184 */             return false;
/*     */           }
/*     */         };
/*     */       
/* 188 */       (VIEW.inters()).manager.add(in);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class II
/*     */     extends INT.IntImp
/*     */   {
/*     */     private final String key;
/*     */ 
/*     */ 
/*     */     
/*     */     II(String key, String k2, int min, int max, int def) {
/* 203 */       super(min, max);
/* 204 */       if (key != null)
/* 205 */         key = "SUPER_SCREENSHOT_" + key + "_" + k2; 
/* 206 */       this.key = key;
/* 207 */       if (this.key != null) {
/* 208 */         def = PROP.propI(key, def);
/*     */       }
/* 210 */       super.set(def);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 215 */       if (this.key != null && t != get())
/*     */       {
/* 217 */         PROP.propISet(this.key, t);
/*     */       }
/*     */       
/* 220 */       super.set(t);
/* 221 */       double dday = SuperSc.this.day[SuperSc.this.iday.get()];
/* 222 */       double d = TIME.secondsPerDay() * dday;
/* 223 */       SuperSc.this.old = TIME.currentSecond() / d % 1.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void take() {
/* 229 */     SPRITES.loader().init();
/* 230 */     SPRITES.loader().print(¤¤sc);
/*     */     
/* 232 */     String smallest = null;
/* 233 */     int am = 0;
/* 234 */     long lastM = Long.MAX_VALUE;
/* 235 */     PATH p = (PATHS.local()).SCREENSHOT_S; byte b; int i; String[] arrayOfString;
/* 236 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 237 */       if (s.startsWith(this.fn)) {
/* 238 */         am++;
/* 239 */         long m = p.get(s).toFile().lastModified();
/* 240 */         if (m < lastM) {
/* 241 */           lastM = m;
/* 242 */           smallest = s;
/*     */         } 
/*     */       }  b++; }
/*     */     
/* 246 */     if (am >= this.saved.get()) {
/* 247 */       p.delete(smallest);
/*     */     }
/*     */     
/* 250 */     String f = String.valueOf(p.get().toAbsolutePath()) + String.valueOf(p.get().toAbsolutePath()) + File.separator;
/* 251 */     f = FileManager.NAME.timeStampString(f) + ".jpg";
/*     */     
/* 253 */     this.shot[this.quality.get()].perform(f);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\SuperSc.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
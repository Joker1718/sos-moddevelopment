/*     */ package launcher;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ class ScreenMods extends GuiSection { private ModInfo hoveredMod; private String errorMod; private String errorMessage; private Text hs; private final GuiSection mods; private final Launcher l; private final CharSequence sOutdated; private final CharSequence sBy; private final CharSequence sBroken; private final Str str; public void render(SPRITE_RENDERER r, float ds) { OPACITY.O75.bind(); COLOR.BLACK.render(r, 0, 896, 0, 448); OPACITY.unbind(); super.render(r, ds); int sx = body().x1() + 470; int y1 = body().y1() + 70; if (this.hoveredMod != null) {
/*     */       this.hs.setMaxWidth(400); this.hs.clear().add(this.hoveredMod.name).add(' ').add(this.hoveredMod.version); COLOR.GREEN100.bind(); if (this.hoveredMod.majorVersion != 71) {
/*     */         COLOR.ORANGE100.bind(); this.hs.add(this.sOutdated);
/*     */       }  this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); COLOR.unbind(); this.hs.clear().add(this.hoveredMod.desc); this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); COLOR.BLUEISH.bind(); this.hs.clear().add(this.sBy).add(this.hoveredMod.author); this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); COLOR.GREENISH.bind(); this.hs.clear().add(this.hoveredMod.info); this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); COLOR.unbind(); this.hs.clear(); this.hs.add(this.hoveredMod.absolutePath); this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); this.hoveredMod = null;
/*     */     } else if (this.errorMod != null) {
/*     */       this.hs.clear(); this.hs.add(this.errorMessage); this.hs.adjustWidth(); this.hs.render(r, sx, y1); y1 += this.hs.height(); this.hs.clear(); this.hs.add(this.errorMod); this.hs.adjustWidth(); this.hs.render(r, sx, y1);
/*     */     }  this.errorMod = null; } private void update(double ds) { String[] paths = (PATHS.local()).MODS.folders(); final GUI.ScrollBox labels = new GUI.ScrollBox(this.mods.body().height()); byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = paths).length, b = 0; b < i; ) {
/*     */       String st = arrayOfString1[b]; try {
/*     */         ModInfo modInfo = new ModInfo(st); labels.add((HOVERABLE)new ModButt(modInfo, this.l));
/*     */       } catch (init.paths.ModInfo.ModInfoException e) {
/*     */         labels.add((HOVERABLE)new Borked(String.valueOf((PATHS.local()).MODS.getFolder(st).get().toAbsolutePath()), e.getMessage(), this.l)); if ((this.l.s.mods.get()).length > 0) {
/*     */           boolean contains = false; byte b1; int j; String[] arrayOfString; for (j = (arrayOfString = this.l.s.mods.get()).length, b1 = 0; b1 < j; ) {
/*     */             String s = arrayOfString[b1]; if (s.equals(st))
/*     */               contains = true;  b1++;
/*     */           }  if (contains) {
/*     */             String[] mods = new String[(this.l.s.mods.get()).length - 1]; int k = 0; byte b2; int m; String[] arrayOfString2; for (m = (arrayOfString2 = this.l.s.mods.get()).length, b2 = 0; b2 < m; ) {
/*     */               String s = arrayOfString2[b2]; if (!s.equals(st)) {
/*     */                 mods[k] = s; k++;
/*     */               }  b2++;
/*     */             }  this.l.s.mods.set(mods); this.l.s.save();
/*     */           } 
/*     */         } 
/*     */       }  b++;
/*     */     }  labels.body().incr(120.0D, 110.0D); CLICKABLE up = (new GUI.BSprite(this.l.res.arrowUpDown[0])).clickActionSet(new ACTION() { public void exe() { labels.scrollUp(); } }); CLICKABLE down = (new GUI.BSprite(this.l.res.arrowUpDown[1])).clickActionSet(new ACTION() { public void exe() { labels.scrollDown(); } }); labels.addNavButts(up, down); int x = this.mods.body().x1(); int y = this.mods.body().y1(); int h = this.mods.body().height(); this.mods.clear(); this.mods.add((RENDEROBJ)up); this.mods.add((RENDEROBJ)down, 0, h - down.body().height() - 16); this.mods.add((RENDEROBJ)labels, 48, 0);
/*  29 */     this.mods.body().moveX1(x).moveY1(y); } ScreenMods(final Launcher l) { D.gInit(this);
/*     */ 
/*     */     
/*  32 */     this.hoveredMod = null;
/*  33 */     this.errorMod = null;
/*  34 */     this.errorMessage = null;
/*     */     
/*  36 */     this.mods = new GuiSection();
/*     */ 
/*     */ 
/*     */     
/*  40 */     this.sOutdated = "(" + String.valueOf(D.g("Outdated")) + ")";
/*  41 */     this.sBy = String.valueOf(D.g("Author")) + ": ";
/*  42 */     this.sBroken = D.g("mborked", "Unsupported Mod");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 272 */     this.str = new Str(5); this.hs = (new Text(l.res.font, 200)).setScale(1.0D); this.l = l; GuiSection butts = new GuiSection(); GUI.BText bText = new GUI.BText(l.res, D.g("Play"), 200) { protected void clickA() { if (PATHS.SCRIPT().hasExternal(l.s.mods.get()) || (l.s.mods.get()).length > 0) { l.setModWarning(); return; }
/*     */            l.s.save(); Launcher.startGame = true; CORE.annihilate(); } }
/*     */       ; butts.addRightC(64, (RENDEROBJ)bText); CLICKABLE cLICKABLE = (new GUI.BText(l.res, D.g("Back"), 200)).clickActionSet(new ACTION() { public void exe() { l.setMain(); } }
/*     */       ); butts.addRightC(4, (RENDEROBJ)cLICKABLE); butts.body().moveX2(880.0D); butts.body().moveY1(0.0D); GUI.Header header = new GUI.Header(l.res, D.g("Mods")); header.body().moveX1(64.0D); header.body().moveCY(butts.body().cY()); butts.add((RENDEROBJ)header); add((RENDEROBJ)butts); this.mods.body().setHeight((448 - body().height() - 24)); add((RENDEROBJ)this.mods, 10, body().y2() + 16); update(0.0D); int am = 0; byte b; int i; String[] arrayOfString1; for (i = (arrayOfString1 = l.s.mods.get()).length, b = 0; b < i; ) { String s = arrayOfString1[b]; if ((PATHS.local()).MODS.exists(s))
/*     */         am++;  b++; }
/*     */      String[] mods = new String[am]; am = 0; String[] arrayOfString2; for (int j = (arrayOfString2 = l.s.mods.get()).length; i < j; ) { String s = arrayOfString2[i]; if ((PATHS.local()).MODS.exists(s))
/*     */         mods[am++] = s;  i++; }
/* 279 */      l.s.mods.set(mods); body().moveX1Y1(10.0D, 10.0D); update(0.0D); } private void toggle(ModButt butt) {} private class ModButt extends Butt { ModButt(ModInfo info, Launcher l) { super((info.majorVersion != 71) ? COLOR.ORANGE100 : COLOR.WHITE100, l.res, info.name);
/* 280 */       this.i = info;
/* 281 */       this.font = l.res.font; }
/*     */     
/*     */     final ModInfo i;
/*     */     private final Font font;
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 287 */       int selectedIndex = getS();
/* 288 */       isSelected = (selectedIndex != -1);
/* 289 */       if (this.i.majorVersion != 71) {
/* 290 */         isActive = false;
/*     */       }
/* 292 */       super.render(r, ds, isActive, isSelected, isHovered);
/* 293 */       if (isSelected) {
/* 294 */         ScreenMods.this.str.clear();
/* 295 */         ScreenMods.this.str.add(selectedIndex);
/* 296 */         this.font.render(r, (CharSequence)ScreenMods.this.str, body().x1() + 8, body().y1() + 4, 1.0D);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 303 */       int selectedIndex = getS();
/* 304 */       if (selectedIndex == -1) {
/* 305 */         String[] mods = new String[(ScreenMods.this.l.s.mods.get()).length + 1];
/* 306 */         for (int i = 0; i < (ScreenMods.this.l.s.mods.get()).length; i++)
/* 307 */           mods[i] = ScreenMods.this.l.s.mods.get()[i]; 
/* 308 */         mods[mods.length - 1] = this.i.path;
/* 309 */         ScreenMods.this.l.s.mods.set(mods);
/*     */       } else {
/*     */         
/* 312 */         String[] mods = new String[(ScreenMods.this.l.s.mods.get()).length - 1];
/* 313 */         int k = 0; byte b; int i; String[] arrayOfString1;
/* 314 */         for (i = (arrayOfString1 = ScreenMods.this.l.s.mods.get()).length, b = 0; b < i; ) { String s = arrayOfString1[b];
/* 315 */           if (!s.equals(this.i.path)) {
/* 316 */             mods[k] = s;
/* 317 */             k++;
/*     */           }  b++; }
/*     */         
/* 320 */         ScreenMods.this.l.s.mods.set(mods);
/*     */       } 
/*     */ 
/*     */       
/* 324 */       ScreenMods.this.toggle(this);
/* 325 */       super.clickA();
/*     */     }
/*     */     
/*     */     private int getS() {
/* 329 */       if (ScreenMods.this.l.s.mods.get() == null)
/* 330 */         return -1; 
/* 331 */       int k = 0; byte b; int i; String[] arrayOfString;
/* 332 */       for (i = (arrayOfString = ScreenMods.this.l.s.mods.get()).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 333 */         if (this.i.path.equals(s))
/* 334 */           return k; 
/* 335 */         k++; b++; }
/*     */       
/* 337 */       return -1;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 342 */       if (super.hover(mCoo)) {
/* 343 */         ScreenMods.this.hoveredMod = this.i;
/* 344 */         return true;
/*     */       } 
/* 346 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Borked
/*     */     extends Butt
/*     */   {
/*     */     final String path;
/*     */     
/*     */     final String message;
/*     */     
/*     */     Borked(String path, String message, Launcher l) {
/* 359 */       super(COLOR.REDISH, l.res, ScreenMods.this.sBroken);
/* 360 */       this.path = path;
/* 361 */       this.message = message;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 368 */       FileManager.openDesctop(this.path);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 374 */       if (super.hover(mCoo)) {
/* 375 */         ScreenMods.this.errorMod = this.path;
/* 376 */         ScreenMods.this.errorMessage = this.message;
/* 377 */         return true;
/*     */       } 
/* 379 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class Butt
/*     */     extends GUI.Button
/*     */   {
/*     */     Butt(COLOR col, RES res, CharSequence text) {
/* 387 */       super(sp(res, text, col));
/*     */     }
/*     */     
/*     */     private static SPRITE sp(final RES res, final CharSequence text, final COLOR color) {
/* 391 */       return (SPRITE)new SPRITE.Imp(380, res.font.height() + 8)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 395 */             color.bind();
/* 396 */             res.font.renderCropped(r, text, X1 + 48, Y1 + 4, width() - 48);
/* 397 */             COLOR.unbind();
/*     */           }
/*     */         };
/*     */     }
/*     */   } }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\ScreenMods.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
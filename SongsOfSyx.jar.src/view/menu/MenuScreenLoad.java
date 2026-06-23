/*     */ package view.menu;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.save.SaveFile;
/*     */ import init.constant.C;
/*     */ import init.constant.Config;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollable;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ public abstract class MenuScreenLoad
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GuiSection main;
/*  37 */   private final GuiSection prompt = new GuiSection();
/*  38 */   private final GuiSection deleteOld = new GuiSection();
/*     */   
/*     */   private GuiSection current;
/*  41 */   private SaveFile[] saves = new SaveFile[0];
/*     */   private final RENDEROBJ info;
/*  43 */   private int selectedSave = -1;
/*     */   
/*  45 */   public static CharSequence ¤¤name = "¤saved game";
/*  46 */   static CharSequence ¤¤delete = "¤Delete Save?";
/*  47 */   static CharSequence ¤¤deleteAll = "¤Delete Old";
/*  48 */   static CharSequence ¤¤deleteAllD = "¤Delete {0} outdated saves forever? You might still be able to load them if you revert for an earlier version of the game.";
/*     */   
/*  50 */   static CharSequence ¤¤prob = "Loading it may crash the game!";
/*  51 */   static CharSequence ¤¤prob2 = "It can not be loaded with the current version of the game.";
/*     */   
/*     */   private final COLOR color;
/*     */   private SaveFile file;
/*     */   private SaveFile open;
/*     */   private double hovDS;
/*     */   private final PATH path;
/*     */   
/*     */   static {
/*  60 */     D.ts(MenuScreenLoad.class);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void populateSaves() {
/* 285 */     this.file = null;
/* 286 */     this.open = null;
/* 287 */     this.hovDS = 0.0D;
/* 288 */     this.saves = SaveFile.list(this.path);
/* 289 */     this.selectedSave = -1;
/*     */   }
/*     */   
/*     */   private int oldSaves() {
/* 293 */     if (this.saves == null)
/* 294 */       return 0; 
/* 295 */     int i = 0; byte b; int j; SaveFile[] arrayOfSaveFile;
/* 296 */     for (j = (arrayOfSaveFile = this.saves).length, b = 0; b < j; ) { SaveFile f = arrayOfSaveFile[b];
/* 297 */       if (VERSION.versionMajor(f.version) < 71)
/* 298 */         i++;  b++; }
/*     */     
/* 300 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 305 */     if (this.current.hover(mCoo))
/* 306 */       return true; 
/* 307 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 312 */     this.current.click();
/* 313 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 318 */     if (this.file == null && this.selectedSave >= 0) {
/* 319 */       this.file = this.saves[this.selectedSave];
/* 320 */       this.open = this.saves[this.selectedSave];
/*     */     } 
/*     */ 
/*     */     
/* 324 */     this.current.render(r, ds);
/*     */     
/* 326 */     if (this.current != this.main) {
/* 327 */       this.file = null;
/*     */       
/*     */       return;
/*     */     } 
/* 331 */     if (this.file == null || this.file != this.open) {
/* 332 */       this.hovDS = 0.0D;
/* 333 */       this.open = this.file;
/*     */     } 
/*     */     
/* 336 */     if (this.open == null)
/*     */       return; 
/* 338 */     this.hovDS += ds;
/* 339 */     if (this.hovDS < 0.25D && !this.file.specReady())
/*     */       return; 
/* 341 */     if (this.file != null) {
/* 342 */       renderInfo(r, this.file, (RECTANGLE)this.info.body(), ds);
/*     */     }
/* 344 */     this.file = null;
/*     */   }
/*     */ 
/*     */   
/* 348 */   private static Str version = new Str(16); private GText tmp; private double mi; private class Savebutt extends CLICKABLE.ClickableAbs implements Scrollable.ScrollRow {
/* 349 */     int index = -1; public Savebutt() { this.body.setWidth(MenuScreen.inner.width()); this.body.setHeight(28.0D); } public void init(int index) { this.index = index; } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { SaveFile s = MenuScreenLoad.this.saves[this.index]; if (this.index == MenuScreenLoad.this.selectedSave) { (GCOLOR.T()).SELECTED.bind(); } else if (isHovered) { (GCOLOR.T()).HOVERED.bind(); } else if (s.specReady() && (s.spec()).fubar) { COLOR.REDISH.bind(); } else if ((((s.problem() != null) ? 1 : 0) | ((s.specReady() && s.spec().warning() != null) ? 1 : 0)) != 0) { COLOR.YELLOW100.bind(); }  MenuScreenLoad.this.renderName(r, s, (RECTANGLE)this.body); COLOR.WHITE50.render(r, this.body.x1(), this.body.x2(), this.body.y2(), this.body.y2() + 1); COLOR.unbind(); } public boolean hover(COORDINATE mCoo) { if (super.hover(mCoo)) { SaveFile s = MenuScreenLoad.this.saves[this.index]; MenuScreenLoad.this.file = s; return true; }  return false; } protected void clickA() { MenuScreenLoad.this.selectedSave = this.index; if (MButt.LEFT.isDouble()) { SaveFile f = MenuScreenLoad.this.saves[this.index]; if (!(f.spec()).fubar) MenuScreenLoad.this.load(f);  }  } public void hoverInfoGet(GUI_BOX text) { SaveFile s = MenuScreenLoad.this.saves[this.index]; MenuScreenLoad.this.file = s; } } protected MenuScreenLoad(CharSequence title, final COLOR color, boolean edit, PATH path) { this.tmp = new GText((UI.FONT()).H2, 64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 467 */     this.mi = 0.0D; this.color = color; this.path = path; Scrollable.ScrollRow[] butts = { new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt(), new Savebutt() }; GScrollable gScrollable = new GScrollable(butts) { public int nrOFEntries() { return MenuScreenLoad.this.saves.length; } }
/*     */       ; this.main = new GuiSection(); this.main.add((RENDEROBJ)gScrollable.getView()); this.main.body().centerIn(MenuScreen.inner); this.main.body().moveY1(MenuScreen.inner.y1()); this.info = (RENDEROBJ)new RENDEROBJ.RenderImp(MenuScreen.bounds.width(), 150) { public void render(SPRITE_RENDERER r, float ds) { color.renderFrame(r, (RECTANGLE)this.body, 8, 2); } }
/*     */       ; this.main.addRelBody(32, DIR.S, this.info); if (edit) { MenuScreen.ScreenButton screenButton5 = new MenuScreen.ScreenButton(Dic.¤¤load) { protected void renAction() { activeSet((MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar)); } protected void clickA() { if (MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar) MenuScreenLoad.this.load(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave]);  super.clickA(); } }
/*     */         ; MenuScreen.ScreenButton screenButton6 = new MenuScreen.ScreenButton(Dic.¤¤delete) { protected void clickA() { if (MenuScreenLoad.this.selectedSave >= 0) MenuScreenLoad.this.current = MenuScreenLoad.this.prompt;  } protected void renAction() { activeSet((MenuScreenLoad.this.selectedSave >= 0)); } }
/* 471 */         ; MenuScreen.ScreenButton screenButton7 = new MenuScreen.ScreenButton(¤¤deleteAll) { protected void clickA() { MenuScreenLoad.this.current = MenuScreenLoad.this.deleteOld; } protected void renAction() { activeSet((MenuScreenLoad.this.oldSaves() > 0)); } }; MenuScreen scr = new MenuScreen(title, color) { protected void back() { MenuScreenLoad.this.back(); } }; scr.addButt((RENDEROBJ)screenButton5); scr.addButt((RENDEROBJ)screenButton6); screenButton7.body().moveCY(screenButton6.body().cY()); screenButton7.body().moveX1((screenButton6.body().x2() + 100)); this.main.add((RENDEROBJ)scr); this.main.moveLastToBack(); this.main.add((RENDEROBJ)screenButton7); } else { MenuScreen.ScreenButton screenButton = new MenuScreen.ScreenButton(Dic.¤¤load) { protected void renAction() { activeSet((MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar)); } protected void clickA() { if (MenuScreenLoad.this.selectedSave >= 0 && !(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave].spec()).fubar) MenuScreenLoad.this.load(MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave]);  super.clickA(); } }; MenuScreen scr = new MenuScreen(title, color) { protected void back() { MenuScreenLoad.this.back(); } }; scr.addButt((RENDEROBJ)screenButton); this.main.add((RENDEROBJ)scr); this.main.moveLastToBack(); }  this.deleteOld.add((SPRITE)(new GText((UI.FONT()).H2, ¤¤delete)).color(color), 0, 0); this.deleteOld.addDownC(48, (RENDEROBJ)(new GStat() { public void update(GText text) { text.add(MenuScreenLoad.¤¤deleteAllD); text.insert(0, MenuScreenLoad.this.oldSaves()); text.setMaxWidth(600); text.setMultipleLines(true); } }).increase().r(DIR.C)); MenuScreen.ScreenButton screenButton2 = new MenuScreen.ScreenButton(Dic.¤¤Yes) { protected void clickA() { byte b; int i; SaveFile[] arrayOfSaveFile; for (i = (arrayOfSaveFile = MenuScreenLoad.this.saves).length, b = 0; b < i; ) { SaveFile f = arrayOfSaveFile[b]; if (VERSION.versionMajor(f.version) < 71) PATHS.local().save().delete(f.fullName);  b++; }  MenuScreenLoad.this.selectedSave = -1; MenuScreenLoad.this.populateSaves(); MenuScreenLoad.this.current = MenuScreenLoad.this.main; } }; MenuScreen.ScreenButton screenButton4 = new MenuScreen.ScreenButton(Dic.¤¤No) { protected void clickA() { MenuScreenLoad.this.current = MenuScreenLoad.this.main; } }; GuiSection ss = new GuiSection(); ss.add((RENDEROBJ)screenButton2).addRightC(64, (RENDEROBJ)screenButton4); this.deleteOld.addRelBody(48, DIR.S, (RENDEROBJ)ss); this.deleteOld.body().centerIn(C.DIM()); this.prompt.add((SPRITE)(new GText((UI.FONT()).H2, ¤¤delete)).color(color), 0, 0); this.prompt.addDownC(16, (RENDEROBJ)(new GStat() { public void update(GText text) { if (MenuScreenLoad.this.selectedSave >= 0) text.add((MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave]).name);  } }).increase().r(DIR.C)); MenuScreen.ScreenButton screenButton1 = new MenuScreen.ScreenButton(Dic.¤¤Yes) { protected void clickA() { if (MenuScreenLoad.this.selectedSave >= 0) { PATHS.local().save().delete((MenuScreenLoad.this.saves[MenuScreenLoad.this.selectedSave]).fullName); MenuScreenLoad.this.selectedSave = -1; MenuScreenLoad.this.populateSaves(); }  MenuScreenLoad.this.current = MenuScreenLoad.this.main; } }; MenuScreen.ScreenButton screenButton3 = new MenuScreen.ScreenButton(Dic.¤¤No) { protected void clickA() { MenuScreenLoad.this.current = MenuScreenLoad.this.main; } }; ss = new GuiSection(); ss.add((RENDEROBJ)screenButton1).addRightC(64, (RENDEROBJ)screenButton3); this.prompt.addRelBody(48, DIR.S, (RENDEROBJ)ss); this.prompt.body().centerIn(C.DIM()); this.current = this.main; populateSaves(); } protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) { version.clear(); version.add(VERSION.versionMajor(s.version)); version.add('.'); version.add(VERSION.versionMinor(s.version)); (UI.FONT()).M.render(r, (CharSequence)version, body.x1(), body.y1()); (UI.FONT()).H2.render(r, s.name, body.x1() + 90, body.y1()); this.tmp.clear().add('p').s(); GFORMAT.i(this.tmp, s.pop); (UI.FONT()).M.render(r, (CharSequence)this.tmp, body.x1() + 830, body.y1()); (UI.FONT()).M.render(r, s.ago, body.x2() - 180, body.y1()); } protected int renderInfoMod(SPRITE_RENDERER r, SaveFile file, int x1, int y1, double ds) { this.mi += ds;
/*     */     
/* 473 */     if (this.mi >= (file.spec()).mods.length) {
/* 474 */       this.mi -= (int)this.mi;
/*     */     }
/*     */     
/* 477 */     if (this.mi >= (file.spec()).mods.length) {
/* 478 */       return y1 + (UI.FONT()).H2.height() + 6;
/*     */     }
/* 480 */     this.color.bind();
/* 481 */     (UI.FONT()).H2.render(r, Dic.¤¤Mods, x1, y1);
/* 482 */     this.tmp.clear();
/* 483 */     this.tmp.add((1 + (int)this.mi)).add('/').add((file.spec()).mods.length).s();
/* 484 */     this.tmp.add((file.spec()).mods[(int)this.mi]);
/*     */     
/* 486 */     (UI.FONT()).M.render(r, (CharSequence)this.tmp, x1 + (UI.FONT()).H2.width(Dic.¤¤Mods) + 8, y1);
/* 487 */     COLOR.unbind();
/* 488 */     return y1 + (UI.FONT()).H2.height() + 6; } protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) { int y1 = renderInfoGen(r, file, body); y1 = renderInfoMod(r, file, body.x1(), y1, ds); renderInfoProb(r, file, body.x1(), y1); }
/*     */   protected int renderInfoGen(SPRITE_RENDERER r, SaveFile file, RECTANGLE body) { int ii = 0; renderPair(r, ii++, body, Dic.¤¤Capitol, (file.spec()).city); renderPair(r, ii++, body, Dic.¤¤Ruler, (file.spec()).ruler); renderPair(r, ii++, body, RACES.name(), (file.spec()).race);
/*     */     renderPair(r, ii++, body, Dic.¤¤Population, (CharSequence)GFORMAT.i(this.tmp.clear(), (file.spec()).population));
/*     */     renderPair(r, ii++, body, Dic.¤¤Regions, (CharSequence)GFORMAT.i(this.tmp.clear(), (file.spec()).regions));
/*     */     renderPair(r, ii++, body, Dic.¤¤Subjects, (CharSequence)GFORMAT.i(this.tmp.clear(), (file.spec()).regPop));
/*     */     return renderPair(r, ii++, body, Dic.¤¤PlayTime, (CharSequence)DicTime.setYears((Str)this.tmp.clear(), (file.spec()).playSeconds / ((Config.sett()).secondsPerHour * (Config.sett()).hoursPerDay) * 16.0D)); }
/* 494 */   protected void renderInfoProb(SPRITE_RENDERER r, SaveFile file, int x1, int y1) { CharSequence p = file.spec().warning();
/* 495 */     if (p != null) {
/* 496 */       this.tmp.clear();
/* 497 */       this.tmp.color((file.spec()).fubar ? COLOR.REDISH : COLOR.YELLOW100).add(p);
/* 498 */       this.tmp.s();
/* 499 */       this.tmp.add((file.spec()).fubar ? ¤¤prob2 : ¤¤prob);
/* 500 */       this.tmp.setMultipleLines(true);
/* 501 */       this.tmp.setMaxWidth(1280);
/* 502 */       ((file.spec()).fubar ? COLOR.REDISH : COLOR.YELLOW100).bind();
/* 503 */       (UI.FONT()).M.render(r, (CharSequence)this.tmp, x1, y1);
/* 504 */       COLOR.unbind();
/*     */     }  }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int renderPair(SPRITE_RENDERER r, int ii, RECTANGLE body, CharSequence title, CharSequence value) {
/* 512 */     int x1 = body.x1() + ii % 3 * 350;
/* 513 */     int y1 = body.y1() + ii / 3 * ((UI.FONT()).M.height() + 6);
/* 514 */     this.color.bind();
/* 515 */     (UI.FONT()).H2.render(r, title, x1, y1);
/* 516 */     x1 += (UI.FONT()).H2.width(title) + 8;
/* 517 */     COLOR.unbind();
/* 518 */     (UI.FONT()).M.render(r, value, x1, y1);
/* 519 */     return y1 + (UI.FONT()).M.height() + 6;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasSaves() {
/* 525 */     return (this.saves.length != 0);
/*     */   }
/*     */   
/*     */   public SaveFile[] saves() {
/* 529 */     return this.saves;
/*     */   }
/*     */   
/*     */   protected abstract void back();
/*     */   
/*     */   protected abstract void load(SaveFile paramSaveFile);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\MenuScreenLoad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
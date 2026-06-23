/*     */ package view.menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.faction.FACTIONS;
/*     */ import game.save.SaveFile;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.FileManager;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.clickable.Scrollable;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollable;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class IMenuSave
/*     */   extends GuiSection implements STRING_RECIEVER {
/*     */   private final CLICKABLE overwrite;
/*     */   private final CLICKABLE delete;
/*     */   private ACTION successfullAction;
/*  39 */   private SaveFile[] saves = new SaveFile[0];
/*     */   
/*  41 */   private int selectedSave = -1;
/*     */   
/*     */   private final ACTION overwriteAction;
/*     */   
/*  45 */   private static CharSequence ¤¤¤nameYour = "¤Name your save-game";
/*  46 */   private static CharSequence ¤¤failed = "¤failed to be overwritten";
/*  47 */   private static CharSequence ¤¤success = "¤successfully overwritten";
/*  48 */   private static CharSequence ¤¤overwrite = "¤overwrite";
/*  49 */   private static CharSequence ¤¤successSave = "{0} successfully saved!";
/*  50 */   private static CharSequence ¤¤charsAllowed = "Only characters: {0} are allowed!";
/*  51 */   private static CharSequence ¤¤fail = "Save failed. See error report!";
/*     */   
/*     */   static {
/*  54 */     D.ts(IMenuSave.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   IMenuSave(final IMenu m, Font font, Font small, final ACTION successfullAction) {
/*  60 */     MenuScreen sc = new MenuScreen(Dic.¤¤save, (GCOLOR.T()).H1)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  64 */           m.setMain();
/*     */         }
/*     */       };
/*     */     
/*  68 */     this.successfullAction = successfullAction;
/*     */     
/*  70 */     SaveEntry[] entries = { 
/*  71 */         new SaveEntry(), 
/*  72 */         new SaveEntry(), 
/*  73 */         new SaveEntry(), 
/*  74 */         new SaveEntry(), 
/*  75 */         new SaveEntry(), 
/*  76 */         new SaveEntry(), 
/*  77 */         new SaveEntry(), 
/*  78 */         new SaveEntry(), 
/*  79 */         new SaveEntry(), 
/*  80 */         new SaveEntry(), 
/*  81 */         new SaveEntry(), 
/*  82 */         new SaveEntry(), 
/*  83 */         new SaveEntry(), 
/*  84 */         new SaveEntry() };
/*     */ 
/*     */     
/*  87 */     GScrollable scroll = new GScrollable((Scrollable.ScrollRow[])entries)
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  91 */           return IMenuSave.this.saves.length;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  96 */     scroll.getView().body().centerIn(C.DIM());
/*  97 */     add((RENDEROBJ)scroll.getView());
/*     */ 
/*     */ 
/*     */     
/* 101 */     MenuScreen.ScreenButton screenButton = new MenuScreen.ScreenButton(Dic.¤¤new)
/*     */       {
/*     */         protected void clickA() {
/* 104 */           String name = String.valueOf((FACTIONS.player()).name) + "-";
/* 105 */           KeyMap<String> m = new KeyMap(); byte b; int j; SaveFile[] arrayOfSaveFile;
/* 106 */           for (j = (arrayOfSaveFile = IMenuSave.this.saves).length, b = 0; b < j; ) { SaveFile f = arrayOfSaveFile[b];
/* 107 */             if (f.name.startsWith(name)) {
/* 108 */               String n = f.name.substring(name.length(), f.name.length());
/* 109 */               m.putReplace(n, n);
/*     */             } 
/*     */             b++; }
/*     */           
/* 113 */           String ph = "";
/*     */           
/* 115 */           for (int i = 0; i < 512; i++) {
/* 116 */             String k = "" + i;
/* 117 */             if (!m.containsKey(k)) {
/* 118 */               ph = name + name;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */           
/* 124 */           (VIEW.inters()).input.requestInput(IMenuSave.this, IMenuSave.¤¤¤nameYour, ph);
/*     */         }
/*     */       };
/* 127 */     sc.addButt((RENDEROBJ)screenButton);
/*     */ 
/*     */ 
/*     */     
/* 131 */     final GButt.Glow yes = new GButt.Glow(Dic.¤¤confirm);
/* 132 */     glow1.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 136 */             PATHS.local().save().delete((IMenuSave.this.saves[IMenuSave.this.selectedSave]).fullName);
/* 137 */             if (GAME.saver().save(SaveFile.stamp((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name)) == null) {
/* 138 */               (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.RED100, null, new GButt[0]);
/*     */             } else {
/* 140 */               (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.RED100, null, new GButt[0]);
/*     */             } 
/* 142 */             (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " " + (IMenuSave.this.saves[IMenuSave.this.selectedSave]).name, COLOR.WHITE100, successfullAction, new GButt[0]);
/* 143 */             m.setMain();
/*     */           }
/*     */         });
/* 146 */     final GButt.Glow no = new GButt.Glow(Dic.¤¤cancel);
/*     */     
/* 148 */     this.overwriteAction = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 151 */           (VIEW.inters()).fullScreen.activate(String.valueOf(IMenuSave.¤¤overwrite) + " " + String.valueOf(IMenuSave.¤¤overwrite) + "?", COLOR.WHITE100, null, new GButt[] { this.val$yes, this.val$no });
/*     */         }
/*     */       };
/* 154 */     this.overwrite = (CLICKABLE)new MenuScreen.ScreenButton(¤¤overwrite)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 158 */           activeSet((IMenuSave.this.selectedSave != -1));
/*     */         }
/*     */       };
/*     */     
/* 162 */     this.overwrite.clickActionSet(this.overwriteAction);
/* 163 */     sc.addButt((RENDEROBJ)this.overwrite);
/*     */ 
/*     */     
/* 166 */     final GButt.Glow yes2 = new GButt.Glow(Dic.¤¤confirm);
/* 167 */     glow3.clickActionSet(new ACTION()
/*     */         {
/*     */           public void exe() {
/* 170 */             PATHS.local().save().delete((IMenuSave.this.saves[IMenuSave.this.selectedSave]).fullName);
/* 171 */             (VIEW.inters()).fullScreen.activate((IMenuSave.this.saves[IMenuSave.this.selectedSave]).name + " deleted!", COLOR.WHITE100, null, new GButt[0]);
/* 172 */             IMenuSave.this.populateSaves();
/*     */           }
/*     */         });
/*     */     
/* 176 */     this.delete = (CLICKABLE)new MenuScreen.ScreenButton(Dic.¤¤delete)
/*     */       {
/*     */         protected void clickA() {
/* 179 */           (VIEW.inters()).fullScreen.activate(String.valueOf(Dic.¤¤delete) + " " + String.valueOf(Dic.¤¤delete), COLOR.WHITE100, null, new GButt[] { this.val$yes2, this.val$no });
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 184 */           activeSet((IMenuSave.this.selectedSave != -1));
/*     */         }
/*     */       };
/* 187 */     sc.addButt((RENDEROBJ)this.delete);
/*     */ 
/*     */ 
/*     */     
/* 191 */     add((RENDEROBJ)sc);
/* 192 */     moveLastToBack();
/*     */     
/* 194 */     populateSaves();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void populateSaves() {
/* 200 */     this.saves = SaveFile.list();
/*     */ 
/*     */     
/* 203 */     this.selectedSave = -1;
/* 204 */     this.overwrite.activeSet(false);
/* 205 */     this.delete.activeSet(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void acceptString(CharSequence string) {
/* 212 */     if (string == null) {
/*     */       return;
/*     */     }
/* 215 */     if (!FileManager.NAME.okName(string)) {
/* 216 */       Str.TMP.clear().add(¤¤charsAllowed).insert(0, "aA - zZ, 0-9, -, _, 'space'");
/* 217 */       (VIEW.inters()).fullScreen.activate((CharSequence)Str.TMP, COLOR.RED100, null, new GButt[0]);
/*     */       
/*     */       return;
/*     */     } 
/* 221 */     for (int i = 0; i < this.saves.length; i++) {
/* 222 */       if ((this.saves[i]).name.contentEquals(string)) {
/* 223 */         this.selectedSave = i;
/* 224 */         this.overwriteAction.exe();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 229 */     if (GAME.saver().save(SaveFile.stamp(string)) == null) {
/* 230 */       (VIEW.inters()).fullScreen.activate(¤¤fail, COLOR.RED100, null, new GButt[0]);
/*     */       return;
/*     */     } 
/* 233 */     (VIEW.inters()).fullScreen.activate(¤¤fail, COLOR.RED100, null, new GButt[0]);
/*     */ 
/*     */ 
/*     */     
/* 237 */     (VIEW.inters()).menu.setMain();
/* 238 */     Str.TMP.clear().add(¤¤successSave).insert(0, string);
/* 239 */     (VIEW.inters()).fullScreen.activate((CharSequence)Str.TMP, COLOR.WHITE100, this.successfullAction, new GButt[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class SaveEntry
/*     */     extends Savebutt
/*     */   {
/*     */     protected void clickA() {
/* 250 */       IMenuSave.this.selectedSave = this.index;
/* 251 */       IMenuSave.this.overwrite.activeSet(true);
/* 252 */       IMenuSave.this.delete.activeSet(true);
/* 253 */       if (MButt.LEFT.isDouble()) {
/* 254 */         IMenuSave.this.overwriteAction.exe();
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean selected(int index) {
/* 260 */       return (index == IMenuSave.this.selectedSave);
/*     */     }
/*     */ 
/*     */     
/*     */     protected SaveFile save(int index) {
/* 265 */       return IMenuSave.this.saves[index];
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class Savebutt
/*     */     extends CLICKABLE.ClickableAbs
/*     */     implements Scrollable.ScrollRow {
/* 272 */     private static GText version = new GText((UI.FONT()).M, 16);
/* 273 */     int index = -1;
/*     */     
/*     */     public Savebutt() {
/* 276 */       this.body.setWidth(1000.0D);
/* 277 */       this.body.setHeight(28.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(int index) {
/* 282 */       this.index = index;
/*     */     }
/*     */     
/*     */     private Font font() {
/* 286 */       return (UI.FONT()).H2;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 292 */       SaveFile s = save(this.index);
/*     */       
/* 294 */       if (s == null) {
/*     */         return;
/*     */       }
/* 297 */       version.clear();
/* 298 */       version.add(VERSION.versionMajor(s.version));
/* 299 */       version.add('.');
/* 300 */       version.add(VERSION.versionMinor(s.version));
/* 301 */       if (71 != VERSION.versionMajor(s.version)) {
/* 302 */         COLOR.RED100.bind();
/* 303 */       } else if (s.problem() != null) {
/* 304 */         COLOR.YELLOW100.bind();
/*     */       }
/* 306 */       else if (selected(this.index)) {
/* 307 */         (GCOLOR.T()).SELECTED.bind();
/* 308 */       } else if (isHovered) {
/* 309 */         (GCOLOR.T()).HOVERED.bind();
/*     */       } 
/*     */       
/* 312 */       font().render(r, (CharSequence)version, body().x1(), body().y1());
/*     */       
/* 314 */       if (selected(this.index)) {
/* 315 */         (GCOLOR.T()).SELECTED.bind();
/* 316 */       } else if (isHovered) {
/* 317 */         (GCOLOR.T()).HOVERED.bind();
/*     */       } else {
/* 319 */         (GCOLOR.T()).CLICKABLE.bind();
/*     */       } 
/*     */       
/* 322 */       font().render(r, s.name, body().x1() + 60, body().y1());
/*     */ 
/*     */       
/* 325 */       version.clear().add('p').s();
/* 326 */       GFORMAT.i(version, s.pop);
/* 327 */       font().render(r, (CharSequence)version, body().x1() + 740, body().y1());
/*     */       
/* 329 */       font().render(r, s.ago, body().x1() + 820, body().y1());
/* 330 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 335 */       SaveFile s = save(this.index);
/* 336 */       if (s != null) {
/* 337 */         CharSequence p = s.problem();
/* 338 */         if (p != null)
/* 339 */           ((GBox)text).error(p); 
/*     */       } 
/*     */     }
/*     */     
/*     */     protected abstract boolean selected(int param1Int);
/*     */     
/*     */     protected abstract SaveFile save(int param1Int);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\IMenuSave.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
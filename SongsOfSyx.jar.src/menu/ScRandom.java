/*     */ package menu;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import script.ScriptEngine;
/*     */ import script.ScriptLoad;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ class ScRandom
/*     */   extends GUI.Shadower
/*     */   implements SC
/*     */ {
/*  35 */   public final KeyMap<ScriptLoad> scripts = new KeyMap();
/*     */   private CharSequence hname;
/*     */   private CharSequence hdesc;
/*  38 */   static CharSequence ¤¤name = "¤random game";
/*  39 */   private static CharSequence ¤¤Scripts = "Scripts";
/*  40 */   private static CharSequence ¤¤go = "go!";
/*     */   
/*  42 */   private static CharSequence ¤¤custom = "Custom Settings";
/*  43 */   private static CharSequence ¤¤customD = "Configure your own tweaks to the game.";
/*     */   
/*  45 */   private String selectedMode = null;
/*     */   
/*     */   static {
/*  48 */     D.ts(ScRandom.class);
/*     */   }
/*     */ 
/*     */   
/*     */   ScRandom(final Menu menu) {
/*  53 */     PATHS.ResFolder path = PATHS.PLAYER().folder("mode");
/*  54 */     if ((PATHS.local()).PROFILE.exists("Properties")) {
/*  55 */       Json old = new Json((PATHS.local()).PROFILE.gets("Properties"));
/*     */       
/*  57 */       if (old.has("MODE")) {
/*  58 */         this.selectedMode = old.value("MODE");
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/*  65 */       (PATHS.local()).PROFILE.create("Titles2");
/*     */     } 
/*     */     
/*  68 */     MenuScreen screen = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  72 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*  75 */     add((RENDEROBJ)screen);
/*     */ 
/*     */     
/*  78 */     MenuScreen.ScreenButton screenButton = new MenuScreen.ScreenButton(¤¤go)
/*     */       {
/*     */         protected void clickA() {
/*  81 */           menu.sandboxSettings.save();
/*  82 */           menu.start(new CORE_STATE.Constructor()
/*     */               {
/*     */                 
/*     */                 public CORE_STATE getState()
/*     */                 {
/*  87 */                   String[] sc = new String[(ScRandom.null.access$0(ScRandom.null.this)).scripts.all().size()];
/*  88 */                   int si = 0;
/*  89 */                   for (ScriptLoad l : (ScRandom.null.access$0(ScRandom.null.this)).scripts.all()) {
/*  90 */                     sc[si++] = l.key;
/*     */                   }
/*  92 */                   VIEW vIEW = GAME.create(sc);
/*     */                   
/*  94 */                   if ((ScRandom.null.access$0(ScRandom.null.this)).selectedMode == null) {
/*  95 */                     menu.sandboxSettings.apply();
/*     */                   } else {
/*  97 */                     (FACTIONS.player()).bonusesCustom.setMode((ScRandom.null.access$0(ScRandom.null.this)).selectedMode);
/*     */                   } 
/*     */ 
/*     */                   
/* 101 */                   return (CORE_STATE)vIEW;
/*     */                 }
/*     */               });
/*     */         }
/*     */       };
/*     */     
/* 107 */     screen.addButt((RENDEROBJ)screenButton);
/*     */ 
/*     */     
/* 110 */     GRows rr = new GRows(6);
/*     */ 
/*     */     
/* 113 */     String mode = null; byte b; int i; String[] arrayOfString;
/* 114 */     for (i = (arrayOfString = path.init.getFiles()).length, b = 0; b < i; ) { final String key = arrayOfString[b];
/*     */       
/* 116 */       Json j = new Json(path.init.gets(key));
/* 117 */       final INFO info = new INFO(new Json(path.text.gets(key)));
/* 118 */       final SPRITE ico = (menu.res.s()).modeIcons[j.i("ICON_I")];
/* 119 */       CLICKABLE.ClickableAbs clickableAbs1 = new CLICKABLE.ClickableAbs(PTitles.IconMaker.WIDTH * 2 + 48, PTitles.IconMaker.HEIGHT * 2 + 48)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/* 123 */             GUI.labelColor.renderFrame(r, (RECTANGLE)this.body, -4, 2);
/*     */             
/* 125 */             if (isSelected) {
/* 126 */               COLOR.WHITE100.renderFrame(r, (RECTANGLE)this.body, -8, 3);
/* 127 */               COLOR.WHITE150.bind();
/* 128 */             } else if (isHovered) {
/* 129 */               COLOR.WHITE50.renderFrame(r, (RECTANGLE)this.body, -8, 2);
/* 130 */               COLOR.WHITE150.bind();
/*     */             } 
/*     */             
/* 133 */             ico.renderCScaled(r, this.body.cX(), this.body.cY(), 2);
/*     */             
/* 135 */             COLOR.unbind();
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 141 */             ScRandom.this.selectedMode = key;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 146 */             selectedSet((ScRandom.this.selectedMode == key));
/*     */           }
/*     */ 
/*     */           
/*     */           public boolean hover(COORDINATE mCoo) {
/* 151 */             if (super.hover(mCoo)) {
/* 152 */               ScRandom.this.hname = info.name;
/* 153 */               ScRandom.this.hdesc = info.desc;
/* 154 */               return true;
/*     */             } 
/* 156 */             return super.hover(mCoo);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 162 */       if (this.selectedMode != null && key.equals(this.selectedMode)) {
/* 163 */         mode = this.selectedMode;
/*     */       }
/* 165 */       rr.add((RENDEROBJ)clickableAbs1);
/*     */       b++; }
/*     */     
/* 168 */     this.selectedMode = mode;
/*     */ 
/*     */     
/* 171 */     CLICKABLE.ClickableAbs clickableAbs = new CLICKABLE.ClickableAbs(PTitles.IconMaker.WIDTH * 2 + 48, PTitles.IconMaker.HEIGHT * 2 + 48)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */         {
/* 175 */           GUI.labelColor.renderFrame(r, (RECTANGLE)this.body, -4, 2);
/*     */           
/* 177 */           if (isSelected) {
/* 178 */             COLOR.WHITE100.renderFrame(r, (RECTANGLE)this.body, -8, 3);
/* 179 */             COLOR.WHITE150.bind();
/* 180 */           } else if (isHovered) {
/* 181 */             COLOR.WHITE50.renderFrame(r, (RECTANGLE)this.body, -8, 2);
/* 182 */             COLOR.WHITE150.bind();
/*     */           } 
/*     */           
/* 185 */           (UI.icons()).m.cog_big.renderCScaled(r, this.body.cX(), this.body.cY(), 2);
/*     */           
/* 187 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 193 */           ScRandom.this.selectedMode = null;
/* 194 */           menu.switchScreen(menu.sandboxSettings);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 199 */           selectedSet((ScRandom.this.selectedMode == null));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/* 204 */           if (super.hover(mCoo)) {
/* 205 */             ScRandom.this.hname = ScRandom.¤¤custom;
/* 206 */             ScRandom.this.hdesc = ScRandom.¤¤customD;
/* 207 */             return true;
/*     */           } 
/* 209 */           return super.hover(mCoo);
/*     */         }
/*     */       };
/*     */     
/* 213 */     rr.add((RENDEROBJ)clickableAbs);
/*     */ 
/*     */     
/* 216 */     GuiSection butts = new GuiSection();
/*     */     
/* 218 */     for (RENDEROBJ r : rr.rows()) {
/* 219 */       butts.addDown(8, r);
/*     */     }
/*     */     
/* 222 */     butts.addRelBody(64, DIR.E, (RENDEROBJ)new Scripts(300));
/*     */     
/* 224 */     RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(100, 48)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, float ds)
/*     */         {
/* 228 */           if (ScRandom.this.hdesc != null) {
/* 229 */             GUI.labelColor.bind();
/* 230 */             (UI.FONT()).H2.renderCX(r, this.body.cX(), this.body.y1(), ScRandom.this.hname);
/* 231 */             COLOR.unbind();
/* 232 */             (UI.FONT()).M.renderCX(r, this.body.cX(), this.body.y1() + 24, ScRandom.this.hdesc, 1.0D, GUI.bounds.width());
/* 233 */             ScRandom.this.hname = null;
/* 234 */             ScRandom.this.hdesc = null;
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/* 239 */     butts.addRelBody(8, DIR.S, (RENDEROBJ)renderImp);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 244 */     butts.body().centerIn((RECTANGLE)body());
/*     */     
/* 246 */     add((RENDEROBJ)butts);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 252 */     menu.switchScreen(menu.main);
/* 253 */     return true;
/*     */   }
/*     */   
/*     */   private final class Scripts
/*     */     extends GuiSection {
/*     */     Scripts(int height) {
/* 259 */       LinkedList<RENDEROBJ> rows = new LinkedList();
/* 260 */       for (ScriptLoad l : ScriptEngine.getAll()) {
/* 261 */         if (!l.script.isSelectable())
/*     */           continue; 
/* 263 */         final CharSequence name = l.script.name();
/* 264 */         final CharSequence desc = l.script.desc();
/*     */         
/* 266 */         GUI.CheckBox checkBox = new GUI.CheckBox(name)
/*     */           {
/*     */             public boolean hover(COORDINATE mCoo) {
/* 269 */               if (super.hover(mCoo)) {
/* 270 */                 (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).hname = name;
/* 271 */                 (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).hdesc = desc;
/* 272 */                 return true;
/*     */               } 
/* 274 */               return false;
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 280 */               if ((ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.containsKey(l.className)) {
/* 281 */                 (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.remove(l.className);
/* 282 */                 selectedSet(false);
/*     */               } else {
/* 284 */                 (ScRandom.Scripts.access$0(ScRandom.Scripts.this)).scripts.put(l.className, l);
/* 285 */                 selectedSet(true);
/*     */               } 
/*     */             }
/*     */           };
/*     */ 
/*     */         
/* 291 */         rows.add(checkBox);
/*     */       } 
/*     */       
/* 294 */       if (rows.size() > 0) {
/* 295 */         add((RENDEROBJ)(new GScrollRows((Iterable)rows, height)).view());
/* 296 */         addRelBody(4, DIR.N, (RENDEROBJ)new HOVERABLE.Sprite((UI.FONT()).H2.getText(ScRandom.¤¤Scripts), GUI.COLORS.label));
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScRandom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
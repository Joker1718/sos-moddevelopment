/*     */ package menu;
/*     */ 
/*     */ import cutscene.CutScene;
/*     */ import game.GameSpec;
/*     */ import game.VERSION;
/*     */ import game.save.GameLoader;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.file.Path;
/*     */ import java.util.HashSet;
/*     */ import script.ScriptEngine;
/*     */ import script.ScriptLoad;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTextScroller;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ 
/*     */ class ScCampaign
/*     */   extends GUI.Shadower
/*     */   implements SC
/*     */ {
/*     */   private Campaign current;
/*  45 */   static CharSequence ¤¤name = "¤campaigns";
/*  46 */   private static CharSequence ¤¤go = "go!"; private final Menu menu;
/*     */   static {
/*  48 */     D.ts(ScCampaign.class);
/*     */   }
/*     */ 
/*     */   
/*  52 */   private final HashSet<String> completed = PATHS.local().campaignsUnlocked();
/*     */ 
/*     */ 
/*     */   
/*     */   ScCampaign(final Menu menu) {
/*  57 */     this.menu = menu;
/*     */     
/*  59 */     MenuScreen screen = new MenuScreen(¤¤name, GUI.labelColor)
/*     */       {
/*     */         protected void back()
/*     */         {
/*  63 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*     */     
/*  67 */     add((RENDEROBJ)screen);
/*     */     
/*  69 */     MenuScreen.ScreenButton screenButton = new MenuScreen.ScreenButton(¤¤go)
/*     */       {
/*     */         protected void clickA() {
/*  72 */           ScCampaign.this.start();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  78 */           activeSet(ScCampaign.this.canStart());
/*     */         }
/*     */       };
/*     */     
/*  82 */     screen.addButt((RENDEROBJ)screenButton);
/*     */     
/*  84 */     GuiSection s = new GuiSection();
/*     */     
/*  86 */     final KeyMap<Campaign> cmap = new KeyMap(); byte b; int i;
/*     */     String[] arrayOfString;
/*  88 */     for (i = (arrayOfString = (PATHS.MISC()).CAMPAIGNS.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*     */       
/*  90 */       final Campaign c = new Campaign(new Json((PATHS.MISC()).CAMPAIGNS.gets(f)), f);
/*  91 */       cmap.put(f, c);
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */ 
/*     */     
/*  99 */     LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */     
/* 101 */     for (Campaign c : cmap.allSorted()) {
/*     */       
/* 103 */       SPRITE.Imp imp1 = new SPRITE.Imp(400, (UI.FONT()).H2.height() * 2 + 8)
/*     */         {
/*     */           Text t;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 113 */             this.t.renderCY(r, X1 + 32, Y1 + (Y2 - Y1) / 2);
/*     */             
/* 115 */             COLOR col = COLOR.GREEN100;
/* 116 */             if (c.locked()) {
/* 117 */               col = COLOR.WHITE50;
/* 118 */             } else if (!ScCampaign.this.completed.contains(c.key)) {
/* 119 */               col = COLOR.BLUEISH;
/* 120 */             }  col.bind();
/* 121 */             (UI.icons()).s.dot.big.renderCY(r, X1, Y1 + (Y2 - Y1) / 2);
/*     */           }
/*     */         };
/*     */       
/* 125 */       rows.add(new GUI.Button((SPRITE)imp1)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             protected void renAction()
/*     */             {
/* 133 */               selectedSet((ScCampaign.this.current == c));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 138 */               ScCampaign.this.current = c;
/* 139 */               if (MButt.LEFT.isDouble()) {
/* 140 */                 ScCampaign.this.start();
/*     */               }
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     s.add((RENDEROBJ)(new GScrollRows((Iterable)rows, 400)).view());
/*     */ 
/*     */ 
/*     */     
/* 155 */     GuiSection ss = new GuiSection();
/* 156 */     ss.add((RENDEROBJ)(new GStat((UI.FONT()).H2)
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 160 */             if (ScCampaign.this.current != null) {
/* 161 */               text.color(GUI.COLORS.unclickable);
/* 162 */               text.add(ScCampaign.this.current.info.name);
/*     */             } 
/*     */           }
/* 165 */         }).r(DIR.N));
/*     */     
/* 167 */     GETTER<CharSequence> g = new GETTER<CharSequence>()
/*     */       {
/*     */         public CharSequence get()
/*     */         {
/* 171 */           if (ScCampaign.this.current == null) {
/* 172 */             return Dic.empty;
/*     */           }
/* 174 */           Str.TMP.clear();
/* 175 */           Str.TMP.add(ScCampaign.this.current.info.desc);
/* 176 */           return (CharSequence)Str.TMP;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 182 */     GTextScroller sc = new GTextScroller((UI.FONT()).M, g, 400, 300);
/*     */     
/* 184 */     ss.addRelBody(8, DIR.S, (RENDEROBJ)sc);
/*     */     
/* 186 */     SPRITE.Imp imp = new SPRITE.Imp(400, (UI.FONT()).H2.height() * 3 + 8)
/*     */       {
/*     */         Text t;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 196 */           if (ScCampaign.this.current == null) {
/*     */             return;
/*     */           }
/* 199 */           COLOR col = COLOR.GREEN100;
/* 200 */           if (ScCampaign.this.current.locked()) {
/* 201 */             col = COLOR.REDISH;
/* 202 */           } else if (!ScCampaign.this.completed.contains(ScCampaign.this.current.key)) {
/* 203 */             col = COLOR.BLUEISH;
/* 204 */           }  col.bind();
/*     */           
/* 206 */           this.t.clear();
/* 207 */           if (ScCampaign.this.current.requires.length > 0) {
/* 208 */             this.t.add(Dic.¤¤Requires).add(':');
/* 209 */             this.t.s(); byte b; int i; String[] arrayOfString;
/* 210 */             for (i = (arrayOfString = ScCampaign.this.current.requires).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 211 */               if (cmap.containsKey(s)) {
/* 212 */                 this.t.add(((ScCampaign.Campaign)cmap.get(s)).info.name);
/*     */               } else {
/* 214 */                 this.t.add('?').s().add(s);
/*     */               } 
/*     */               b++; }
/*     */           
/*     */           } 
/* 219 */           this.t.renderCY(r, X1, Y1 + (Y2 - Y1) / 2);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 226 */     ss.addRelBody(8, DIR.S, (SPRITE)imp);
/*     */     
/* 228 */     s.addRelBody(64, DIR.E, (RENDEROBJ)ss);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     s.body().centerIn((RECTANGLE)body());
/*     */     
/* 235 */     add((RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */   
/*     */   private void start() {
/* 240 */     if (canStart()) {
/* 241 */       GameLoader loader = new GameLoader(this.current.save, this.current.scripts);
/*     */ 
/*     */       
/* 244 */       this.menu.start(CutScene.make(this.current.cutsceneData, this.current.cutsceneText, (CORE_STATE.Constructor)loader));
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean canStart() {
/* 249 */     return (this.current != null && !this.current.locked());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/* 254 */     menu.switchScreen(menu.main);
/* 255 */     return true;
/*     */   }
/*     */   
/*     */   private class Campaign
/*     */   {
/*     */     public final Json cutsceneData;
/*     */     public final Json cutsceneText;
/*     */     public final INFO info;
/*     */     public String[] requires;
/*     */     public final Path save;
/*     */     public final String[] scripts;
/*     */     public final String key;
/*     */     
/*     */     public Campaign(Json json, String key) {
/* 269 */       this.key = key;
/* 270 */       Json text = new Json(PATHS.TEXT().getFolder("campaign").gets(key));
/* 271 */       this.info = new INFO(text);
/* 272 */       this.cutsceneText = text.json("CUTSCENE");
/* 273 */       this.cutsceneData = json.json("CUTSCENE");
/* 274 */       this.requires = json.values("REQUIRES");
/* 275 */       if (json.bool("SAVE_LOCAL")) {
/* 276 */         Path s = (PATHS.local()).SAVE_CAMPAIGN.exists(key) ? (PATHS.local()).SAVE_CAMPAIGN.get(key) : null;
/* 277 */         if (s != null) {
/* 278 */           GameSpec f = GameSpec.get(s);
/* 279 */           if (VERSION.versionMajor(f.version) != 71)
/* 280 */             s = null; 
/*     */         } 
/* 282 */         this.save = s;
/*     */       } else {
/*     */         
/* 285 */         this.save = (PATHS.MISC()).SAVES_CAMPAIGN.get(key);
/*     */       } 
/* 287 */       String[] ss = json.values("SCRIPTS");
/* 288 */       ArrayListGrower<ScriptLoad> scripts = new ArrayListGrower();
/* 289 */       for (int i = 0; i < ss.length; i++) {
/* 290 */         if (!(PATHS.SCRIPT()).jar.exists(ss[i])) {
/* 291 */           json.error(String.valueOf((PATHS.SCRIPT()).jar.get().toAbsolutePath()) + " /" + String.valueOf((PATHS.SCRIPT()).jar.get().toAbsolutePath()) + " does not exist", "SCRIPTS");
/*     */         } else {
/* 293 */           scripts.add((Iterable)ScriptEngine.getInJar(ss[i]));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 298 */       this.scripts = new String[scripts.size()];
/* 299 */       int ii = 0;
/* 300 */       for (ScriptLoad l : scripts) {
/* 301 */         this.scripts[ii++] = l.key;
/*     */       }
/*     */     }
/*     */     
/*     */     boolean locked() {
/* 306 */       if (this.save == null)
/* 307 */         return true;  byte b; int i; String[] arrayOfString;
/* 308 */       for (i = (arrayOfString = this.requires).length, b = 0; b < i; ) { String s = arrayOfString[b];
/* 309 */         if (!ScCampaign.this.completed.contains(s))
/* 310 */           return true;  b++; }
/* 311 */        return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScCampaign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
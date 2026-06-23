/*     */ package menu;
/*     */ import game.GAME;
/*     */ import game.battle.state.BattleState;
/*     */ import game.battle.state.BattleStateExiter;
/*     */ import game.battle.state.BattleStateResult;
/*     */ import game.save.GameLoader;
/*     */ import game.save.SaveFile;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreenLoad;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ 
/*     */ class ScLoad implements SC {
/*  25 */   private static CharSequence ¤¤showCases = "¤showcases";
/*  26 */   private static CharSequence ¤¤custom = "¤scenarios";
/*  27 */   private static CharSequence ¤¤battles = "¤battles"; private final MenuScreenLoad screen;
/*     */   
/*     */   static {
/*  30 */     D.ts(ScLoad.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final Menu menu;
/*     */   public final CharSequence name;
/*     */   
/*     */   ScLoad(Menu menu, MenuScreenLoad screen, CharSequence name) {
/*  38 */     this.menu = menu;
/*  39 */     this.screen = screen;
/*  40 */     this.name = name;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/*  45 */     return this.screen.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/*  50 */     return this.screen.click();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  56 */     this.screen.render(r, ds);
/*  57 */     GUI.Shadower.ren(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back(Menu menu) {
/*  63 */     menu.switchScreen(menu.main);
/*  64 */     return true;
/*     */   }
/*     */   
/*     */   public boolean hasSaves() {
/*  68 */     return ((this.screen.saves()).length != 0);
/*     */   }
/*     */   
/*     */   public void loadSave() {
/*  72 */     if (hasSaves()) {
/*  73 */       this.menu.start((CORE_STATE.Constructor)new GameLoader(PATHS.local().save().get((this.screen.saves()[0]).fullName), new String[0]));
/*     */     }
/*     */   }
/*     */   
/*     */   public static ScLoad load(final Menu menu) {
/*  78 */     MenuScreenLoad screen = new MenuScreenLoad(MenuScreenLoad.¤¤name, GUI.labelColor, true, PATHS.local().save())
/*     */       {
/*     */         protected void load(SaveFile f)
/*     */         {
/*  82 */           menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0]));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void back() {
/*  87 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/*  90 */     return new ScLoad(menu, screen, MenuScreenLoad.¤¤name);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ScLoad showcase(final Menu menu) {
/*  95 */     MenuScreenLoad screen = new MenuScreenLoad(¤¤showCases, GUI.labelColor, false, (PATHS.MISC()).EXAMPLES)
/*     */       {
/*     */ 
/*     */         
/*     */         protected void load(SaveFile f)
/*     */         {
/* 101 */           menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0])
/*     */               {
/*     */                 public void doAfterSet() {
/* 104 */                   GAME.achieve(false);
/* 105 */                   super.doAfterSet();
/*     */                 }
/*     */               });
/*     */         }
/*     */ 
/*     */         
/*     */         protected void back() {
/* 112 */           menu.switchScreen(menu.main);
/*     */         }
/*     */         
/*     */         protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 116 */           int y1 = renderInfoGen(r, file, body);
/* 117 */           if (file.specReady() && (file.spec()).fubar) {
/* 118 */             renderInfoProb(r, file, body.x1(), y1);
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 125 */           (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1());
/*     */           
/* 127 */           (UI.icons()).s.human.renderCY(r, body.x1() + 700, body.y1() + (UI.FONT()).M.height() / 2);
/* 128 */           Str.TMP.clear().add(s.pop);
/* 129 */           (UI.FONT()).M.render(r, (CharSequence)Str.TMP, body.x1() + 720, body.y1());
/*     */         }
/*     */       };
/*     */     
/* 133 */     return new ScLoad(menu, screen, ¤¤showCases);
/*     */   }
/*     */   
/*     */   public static ScLoad scenarios(final Menu menu) {
/* 137 */     MenuScreenLoad screen = new MenuScreenLoad(¤¤custom, GUI.labelColor, false, (PATHS.MISC()).CUSTOM)
/*     */       {
/*     */         GText t;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void load(SaveFile f) {
/* 146 */           menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0]));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void back() {
/* 151 */           menu.switchScreen(menu.main);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 156 */           this.t.set((file.spec()).desc);
/* 157 */           this.t.renderC(r, body);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 164 */           (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1() + (UI.FONT()).M.height() / 2);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 169 */     return new ScLoad(menu, screen, ¤¤custom);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ScLoad battle(final Menu menu) {
/* 174 */     MenuScreenLoad screen = new MenuScreenLoad(¤¤battles, GUI.labelColor, false, (PATHS.MISC()).BATTLE)
/*     */       {
/*     */         GText t;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void load(final SaveFile f) {
/* 182 */           menu.start((CORE_STATE.Constructor)new GameLoader(f.path, new String[0])
/*     */               {
/*     */                 public void doAfterSet() {
/* 185 */                   super.doAfterSet();
/* 186 */                   BattleState.setLoaded(new BattleStateExiter()
/*     */                       {
/*     */                         public void exit(BATTLE_RESULT res, int plosses, int elosses)
/*     */                         {
/* 190 */                           CORE.setCurrentState(new CORE_STATE.Constructor()
/*     */                               {
/*     */                                 public CORE_STATE getState() {
/* 193 */                                   return Menu.make();
/*     */                                 }
/*     */                               },  );
/*     */                         }
/*     */ 
/*     */ 
/*     */ 
/*     */                         
/*     */                         public void afterExit(BattleStateResult res) {}
/* 202 */                       },  f.path, true);
/*     */                 }
/*     */               });
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderInfo(SPRITE_RENDERER r, SaveFile file, RECTANGLE body, double ds) {
/* 210 */           this.t.clear().add((file.spec()).population).s().add('V').add('s').s().add((file.spec()).enemies);
/* 211 */           this.t.adjustWidth();
/* 212 */           this.t.renderCX(r, body.cX(), body.y1());
/*     */           
/* 214 */           this.t.set((file.spec()).desc);
/* 215 */           this.t.renderCX(r, body.cX(), body.y1() + 32);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void renderName(SPRITE_RENDERER r, SaveFile s, RECTANGLE body) {
/* 222 */           (UI.FONT()).H2.render(r, s.name, body.x1() + 64, body.y1() + (UI.FONT()).M.height() / 2);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void back() {
/* 228 */           menu.switchScreen(menu.main);
/*     */         }
/*     */       };
/* 231 */     return new ScLoad(menu, screen, ¤¤battles);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\ScLoad.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
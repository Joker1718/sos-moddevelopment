/*     */ package view.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.battle.BattleView;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyPoller;
/*     */ import view.sett.SettView;
/*     */ import view.ui.UIView;
/*     */ import view.world.WorldView;
/*     */ import view.world.editor.WorldViewEditor;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class VIEW extends CORE_STATE {
/*     */   private static VIEW i;
/*     */   private KeyPoller keyPoller;
/*     */   private final UIView ui;
/*     */   private final WorldView world;
/*     */   private final SettView sett;
/*     */   private final BattleView battle;
/*     */   private ViewSubSimple current;
/*     */   private ViewSub previous;
/*     */   private final Mouse mouse;
/*     */   private final Interrupters inters;
/*     */   private boolean hideUI;
/*     */   private static double renderSecond;
/*     */   public static int renI;
/*     */   private final GAME game;
/*     */   private double hoverTimer;
/*     */   
/*  44 */   public VIEW(GAME game) { KEYS.init();
/*     */     
/*  46 */     this.keyPoller = (KeyPoller)KEYS.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     this.hideUI = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 143 */     this.hoverTimer = 0.0D; i = this; this.game = game; ViewSub.all.clear(); this.mouse = new Mouse(); this.inters = new Interrupters(); this.ui = new UIView(); this.world = new WorldView(); this.sett = new SettView(); this.battle = new BattleView(); this.world.activate(); KEYS.get().readSettings(); setFirstView((ViewSubSimple)this.world); GAME.saver().add(new Savable("VIEW") {
/*     */           protected void save(FilePutter file) { if (VIEW.this.current instanceof VIEW.ViewSub) { file.i(((VIEW.ViewSub)VIEW.this.current).index); } else { file.i(-1); }
/*     */              } protected void load(FileGetter file) throws IOException { int si = file.i(); VIEW.ViewSub v = null; if (si >= 0)
/*     */               v = (VIEW.ViewSub)VIEW.ViewSub.all.get(si);  KEYS.get().readSettings(); VIEW.this.setFirstView(v); VIEW.this.current.activate(); }
/* 147 */         }); } private void hover() { Coo coo = CORE.getInput().getMouse().getCoo();
/*     */     
/* 149 */     int dx = coo.x() - this.mouse.x();
/* 150 */     int dy = coo.y() - this.mouse.y();
/* 151 */     int d = dx * dx + dy * dy;
/* 152 */     boolean mouseHasMoved = (d > 5);
/* 153 */     this.mouse.getCoo().set((COORDINATE)coo);
/*     */     
/* 155 */     (GAME.script()).callback.hover((COORDINATE)coo, mouseHasMoved);
/*     */ 
/*     */ 
/*     */     
/* 159 */     if (mouseHasMoved) {
/* 160 */       this.hoverTimer = 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 166 */     if (this.inters.manager.hover((COORDINATE)coo, mouseHasMoved) && 
/* 167 */       this.current.uiManager.hover((COORDINATE)coo, mouseHasMoved)) {
/* 168 */       this.current.hover((COORDINATE)coo, mouseHasMoved);
/*     */     }
/* 170 */     (GAME.script()).callback.hoverTimer(this.hoverTimer, this.inters.mouseMessage.get());
/* 171 */     if (!this.inters.mouseMessage.get().emptyIs()) {
/*     */       return;
/*     */     }
/* 174 */     if (this.inters.manager.hoverTimer(this.hoverTimer, this.inters.mouseMessage.get()) && 
/* 175 */       this.current.uiManager.hoverTimer(this.hoverTimer, this.inters.mouseMessage.get())) {
/* 176 */       this.current.hoverTimer(this.hoverTimer, this.inters.mouseMessage.get());
/*     */     }
/* 178 */     if (!this.inters.mouseMessage.get().emptyIs()) {
/* 179 */       this.mouse.setReplacement((SPRITE)(UI.icons()).m.questionmark);
/*     */     }
/*     */     
/* 182 */     if (this.hoverTimer < 0.4D)
/* 183 */       this.inters.mouseMessage.get().clear();  }
/*     */   private void setFirstView(ViewSubSimple prefered) { WorldViewEditor worldViewEditor; WorldViewGenerator worldViewGenerator; if ((WORLD.GEN()).isEditing) {
/*     */       worldViewEditor = this.world.editor;
/*     */     } else if (worldViewEditor == null || !(WORLD.GEN()).isDone) {
/*     */       worldViewGenerator = new WorldViewGenerator();
/*     */     }  worldViewGenerator.activate(); this.previous = null; }
/*     */   protected void keyPush(LIST<KeyBoard.KeyEvent> keys, boolean hasCleared) { this.keyPoller.poll(keys); this.keyPoller = (KeyPoller)KEYS.get(); }
/*     */   protected void mouseClick(MButt button) { if (!this.inters.manager.click(button))
/*     */       return;  if (this.inters.mouseMessage.close())
/*     */       return;  (GAME.script()).callback.mouseClick(button); if (this.current.uiManager.click(button))
/* 193 */       this.current.mouseClick(button);  } protected void update(float ds, double slowDown) { this.game.afterTick();
/*     */     
/* 195 */     this.inters.manager.afterTick();
/* 196 */     this.current.uiManager.afterTick();
/* 197 */     this.current.afterTick();
/*     */ 
/*     */ 
/*     */     
/* 201 */     hover();
/*     */ 
/*     */     
/* 204 */     this.hoverTimer += ds;
/*     */     
/* 206 */     if ((KEYS.MAIN()).DEBUGGER.consumeClick())
/* 207 */       GUTIL.debugger().toggle(); 
/* 208 */     if (this.hideUI) {
/* 209 */       if (((KEYS.MAIN()).ESCAPE.consumeClick() | MButt.RIGHT.consumeAllClick()) != 0) {
/* 210 */         this.hideUI = false;
/* 211 */         this.inters.mouseMessage.get().clear();
/*     */       }
/* 213 */       else if (s().isActive() && (s()).ui.subjects.current() != null) {
/* 214 */         (s().getWindow()).centerer.set((s()).ui.subjects.current().body().cX(), (s()).ui.subjects.current().body().cY());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 220 */     this.inters.mouseMessage.update(this.mouse);
/* 221 */     if ((this.inters.manager.update(ds) & this.current.uiManager.update(ds)) != 0) {
/* 222 */       this.current.update(ds, true);
/*     */     } else {
/* 224 */       this.current.update(ds, false);
/* 225 */       ds = 0.0F;
/* 226 */       slowDown = 1.0D;
/*     */     } 
/*     */     
/* 229 */     if ((KEYS.MAIN()).SWAP.consumeClick()) {
/* 230 */       if ((UI()).manager.open()) {
/* 231 */         (UI()).manager.close();
/* 232 */         world().activate();
/*     */       }
/* 234 */       else if (world().isActive()) {
/* 235 */         s().activate();
/*     */       }
/* 237 */       else if (s().isActive()) {
/* 238 */         (UI()).manager.show();
/*     */       } 
/*     */     }
/*     */     
/* 242 */     if ((KEYS.MAIN()).ESCAPE.consumeClick()) {
/* 243 */       this.inters.menu.show();
/*     */     }
/*     */     
/* 246 */     if ((KEYS.MAIN()).QUICKSAVE.consumeClick() && canSave()) {
/* 247 */       SPRITES.loader().minify(true, Dic.¤¤SAVING);
/* 248 */       GAME.saver().quicksave();
/* 249 */       SPRITES.loader().minify(false, Dic.¤¤SAVING);
/*     */     } 
/*     */     
/* 252 */     if ((KEYS.MAIN()).QUICKLOAD.consumeClick() && GameLoader.quickload()) {
/* 253 */       SPRITES.loader().minify(true, Dic.¤¤load);
/*     */       
/*     */       return;
/*     */     } 
/* 257 */     this.game.update(ds, slowDown); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds) {
/* 264 */     renI++;
/* 265 */     renderSecond += ds;
/* 266 */     if (renderSecond > 10000.0D) {
/* 267 */       renderSecond -= 10000.0D;
/*     */     }
/* 269 */     GUTIL.debugger().flush();
/*     */     
/* 271 */     if (this.hideUI) {
/* 272 */       this.current.render(r, ds, true);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 281 */     TIME.light().applyGuiLight(ds, C.DIM());
/*     */     
/* 283 */     this.mouse.render(r, ds);
/*     */     
/* 285 */     this.inters.mouseMessage.render(r, ds);
/* 286 */     r.newLayer(true, 0);
/* 287 */     (GAME.script()).callback.render(r, ds);
/*     */ 
/*     */     
/* 290 */     if (!this.inters.manager.render(r, ds)) {
/*     */       return;
/*     */     }
/*     */     
/* 294 */     if (!this.current.uiManager.render(r, ds)) {
/*     */       return;
/*     */     }
/* 297 */     this.current.render(r, ds, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void render() {
/* 302 */     i.render(CORE.renderer(), 0.0F);
/* 303 */     i.inters.manager.afterTick();
/* 304 */     i.current.uiManager.afterTick();
/* 305 */     i.current.afterTick();
/*     */   }
/*     */   
/*     */   public static Mouse mouse() {
/* 309 */     return i.mouse;
/*     */   }
/*     */   
/*     */   public static WorldView world() {
/* 313 */     return i.world;
/*     */   }
/*     */   
/*     */   public static SettView s() {
/* 317 */     return i.sett;
/*     */   }
/*     */   
/*     */   public static BattleView b() {
/* 321 */     return i.battle;
/*     */   }
/*     */   
/*     */   public static ViewSubSimple current() {
/* 325 */     return i.current;
/*     */   }
/*     */   
/*     */   public static void setPrev() {
/* 329 */     if (i.previous == null) {
/* 330 */       i.world.activate();
/*     */     } else {
/* 332 */       i.previous.activate();
/*     */     } 
/*     */   }
/*     */   public static Interrupters inters() {
/* 336 */     return i.inters;
/*     */   }
/*     */   
/*     */   public static Messages messages() {
/* 340 */     return i.inters.messages;
/*     */   }
/*     */   
/*     */   public static GBox hoverBox() {
/* 344 */     return i.inters.mouseMessage.get();
/*     */   }
/*     */   
/*     */   public static GBox timeBox() {
/* 348 */     return i.inters.mouseMessage.init(i.mouse, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hoverBoxDistance(int max) {
/* 353 */     i.inters.mouseMessage.setDistance(max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hideUI() {
/* 360 */     return i.hideUI;
/*     */   }
/*     */   
/*     */   public static void hide() {
/* 364 */     i.hideUI = true;
/*     */   }
/*     */   
/*     */   public static double renderSecond() {
/* 368 */     return renderSecond;
/*     */   }
/*     */   
/*     */   public static boolean existTemp() {
/* 372 */     return (i != null);
/*     */   }
/*     */   
/*     */   public static UIView UI() {
/* 376 */     return i.ui;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int RI() {
/* 381 */     return renI;
/*     */   }
/*     */   
/*     */   public static void setKeyPoller(KeyPoller poller) {
/* 385 */     i.keyPoller = poller;
/*     */   }
/*     */   
/*     */   public static boolean canSave() {
/* 389 */     return (i.inters.manager.canSave() && (current()).uiManager.canSave() && current().canSave());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void exit() {
/* 394 */     GAME.count().flush();
/*     */   }
/*     */   
/*     */   public static abstract class ViewSubSimple
/*     */   {
/*     */     protected abstract void hoverTimer(double param1Double, GBox param1GBox);
/*     */     
/*     */     protected boolean canSave() {
/* 402 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract boolean update(float param1Float, boolean param1Boolean);
/*     */ 
/*     */     
/*     */     protected abstract void render(Renderer param1Renderer, float param1Float, boolean param1Boolean);
/*     */ 
/*     */     
/*     */     public void renderBelowTerrain(Renderer r, ShadowBatch s, RenderData data) {}
/*     */     
/* 414 */     public final InterManager uiManager = new InterManager();
/*     */     protected abstract void mouseClick(MButt param1MButt);
/*     */     protected abstract void hover(COORDINATE param1COORDINATE, boolean param1Boolean);
/*     */     public void activate() {
/* 418 */       if (VIEW.i.current == this)
/*     */         return; 
/* 420 */       if (VIEW.i.current != null)
/* 421 */         VIEW.i.current.deactivate(); 
/* 422 */       VIEW.i.inters.mouseMessage.close();
/* 423 */       if (VIEW.i.current instanceof VIEW.ViewSub)
/* 424 */         VIEW.i.previous = (VIEW.ViewSub)VIEW.i.current; 
/* 425 */       VIEW.i.current = this;
/* 426 */       hover((COORDINATE)CORE.getInput().getMouse().getCoo(), true);
/*     */     }
/*     */ 
/*     */     
/*     */     public void deactivate() {}
/*     */ 
/*     */     
/*     */     public final boolean isActive() {
/* 434 */       return (this == VIEW.i.current);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void afterTick() {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static abstract class ViewSub
/*     */     extends ViewSubSimple
/*     */   {
/*     */     public ViewSub() {
/* 446 */       this.index = all.add(this);
/*     */     }
/*     */     private static final ArrayList<ViewSub> all = new ArrayList(20); private final int index;
/*     */     
/*     */     public int index() {
/* 451 */       return this.index;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\main\VIEW.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
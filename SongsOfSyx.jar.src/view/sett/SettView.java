/*     */ package view.sett;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import init.constant.C;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.overlay.Addable;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.interrupter.InterGuisection;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.sett.invasion.SBattleView;
/*     */ import view.sett.ui.SettUI;
/*     */ import view.sett.ui.minimap.UIMinimapSett;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfigExt;
/*     */ import view.sett.ui.right.UIPanelRightSett;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.ToolManager;
/*     */ import view.ui.top.UIPanelTop;
/*     */ 
/*     */ 
/*     */ public class SettView
/*     */   extends VIEW.ViewSub
/*     */ {
/*  38 */   private final GameWindow window = new GameWindow(
/*  39 */       1, 
/*  40 */       C.DIM(), 
/*  41 */       SETT.PIXEL_BOUNDS, 
/*  42 */       0);
/*  43 */   public final Inters interrupters = new Inters();
/*     */   
/*     */   public SettView() {
/*  46 */     UISettMap.clear();
/*     */     
/*  48 */     this.start = new SettViewStart();
/*     */     
/*  50 */     this.ui = new SettUI(this.uiManager);
/*     */     
/*  52 */     this.tools = new ToolManager(this.uiManager, this.window);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  77 */     UIPanelTop pan = new UIPanelTop(this.uiManager);
/*     */     
/*  79 */     this.panels = new ISidePanels(this.uiManager, 0);
/*  80 */     this.panel = new UIPanelTopSett(this.ui, this, pan);
/*     */     
/*  82 */     this.window.setzoomoutMax(3);
/*  83 */     this.tools.setDefault(new ToolDefault(this.tools));
/*  84 */     this.debug = new IDebugPanelSett(this.uiManager);
/*  85 */     this.mini = new UIMinimapSett(this.uiManager, 51, this.window, (UIMinimapSettConfig)new UIMinimapSettConfigExt("VIEW_SETT"));
/*  86 */     this.mini.panel().addScreenshot("VIEW_SETT");
/*  87 */     this.overlayThing = this.mini.panel().addOverlays();
/*  88 */     this.right = new UIPanelRightSett(this.mini, this.uiManager, this.window);
/*     */ 
/*     */     
/*  91 */     this.battle = new SBattleView();
/*     */     
/*  93 */     GAME.saver().add(new Savable("SETT_VIEW")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/*  97 */             SettView.this.window.saver.save(file);
/*  98 */             SettView.this.right.save(file);
/*  99 */             file.bool(SettView.this.hasPlaced);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/* 104 */             SettView.this.window.saver.load(file);
/* 105 */             SettView.this.right.load(file);
/* 106 */             SettView.this.uiManager.clear();
/* 107 */             SettView.this.hasPlaced = file.bool();
/* 108 */             if (!SettView.this.hasPlaced) {
/* 109 */               SettView.this.start.activate();
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   boolean hasPlaced = false;
/*     */   
/*     */   private final SettViewStart start;
/*     */   public final UIPanelTopSett panel;
/*     */   public final SettUI ui;
/*     */   public final ISidePanels panels;
/*     */   public final ToolManager tools;
/*     */   public final IDebugPanelSett debug;
/*     */   public final UIMinimapSett mini;
/*     */   public final UIPanelRightSett right;
/*     */   public final SBattleView battle;
/*     */   public final GETTER.GETTER_IMP<Addable> overlayThing;
/*     */   
/*     */   public class Inters
/*     */   {
/*     */     public final InterGuisection section = new InterGuisection(SettView.this.uiManager);
/*     */     public final InterGuisection debugsection = new InterGuisection(SettView.this.uiManager);
/*     */   }
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {}
/*     */   
/*     */   protected void mouseClick(MButt button) {}
/*     */   
/*     */   protected void hoverTimer(double mouseTimer, GBox text) {}
/*     */   
/*     */   protected boolean update(float ds, boolean should) {
/* 142 */     if ((KEYS.MAIN()).THRONE.consumeClick()) {
/* 143 */       this.window.centererTile.set(THRONE.coo());
/*     */     }
/*     */     
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 152 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 153 */     GAME.s().render(r, (float)(ds * GAME.SPEED.speed()), this.window, this.mini.config);
/*     */     
/* 155 */     if (this.window.consumeHover()) {
/* 156 */       SETT.LIGHTS().renderMouse(this.window.pixel().x(), this.window.pixel().y(), -this.window.pixels().relX(), -this.window.pixels().relY(), 5);
/*     */       
/* 158 */       if (this.window.hasZoomedOutMoreandConsumeThatMotherFZoom()) {
/* 159 */         this.mini.open();
/*     */       }
/*     */     } 
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
/*     */   public GameWindow getWindow() {
/* 189 */     return this.window;
/*     */   }
/*     */   
/*     */   public void clearAllInterrupters() {
/* 193 */     this.uiManager.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate() {
/* 198 */     this.window.stop();
/* 199 */     super.activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 205 */     this.hasPlaced = false;
/* 206 */     this.start.activate();
/* 207 */     this.battle.clear();
/* 208 */     this.right.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelowTerrain(Renderer r, ShadowBatch s, RenderData data) {
/* 213 */     SETT.JOBS().render(r, s, data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SettView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
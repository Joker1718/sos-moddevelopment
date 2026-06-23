/*     */ package view.sett.invasion;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import init.constant.C;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.battle.BattlePanel;
/*     */ import view.battle.BattlePlacer;
/*     */ import view.battle.BattleRenderer;
/*     */ import view.battle.DivSelection;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSett;
/*     */ import view.subview.GameWindow;
/*     */ import view.ui.top.UIPanelTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SBattleView
/*     */   extends VIEW.ViewSub
/*     */ {
/*  37 */   private final GameWindow window = new GameWindow(
/*  38 */       1, 
/*  39 */       C.DIM(), 
/*  40 */       SETT.PIXEL_BOUNDS, 
/*  41 */       0);
/*  42 */   private final DivSelection selection = new DivSelection();
/*  43 */   private final BattlePlacer placer = new BattlePlacer(this.window, this.selection);
/*  44 */   public final BattleRenderer renderer = new BattleRenderer(this.selection);
/*     */   final ISidePanels panels;
/*     */   final BattlePanel panel;
/*     */   final UIMinimapSett minimap;
/*     */   
/*     */   public SBattleView() {
/*  50 */     UIPanelTop pp = new UIPanelTop(this.uiManager, false, true);
/*     */     
/*  52 */     GuiSection s = new GuiSection();
/*  53 */     s.addRightC(0, UIPanelTop.bToggle());
/*  54 */     pp.addRightRight(s);
/*     */ 
/*     */ 
/*     */     
/*  58 */     this.panels = new ISidePanels(this.uiManager, 0);
/*  59 */     this.minimap = new UIMinimapSett(this.uiManager, 51, this.window, null);
/*     */     
/*  61 */     this.panel = new BattlePanel(this.panels, this.window, pp, this.selection, false);
/*     */ 
/*     */     
/*  64 */     this.window.setzoomoutMax(3);
/*  65 */     GAME.saver().add(new Savable("S_BATTLEVIEW")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/*  69 */             SBattleView.this.window.saver.save(file);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/*  74 */             SBattleView.this.window.saver.load(file);
/*  75 */             SBattleView.this.selection.clear();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  84 */     if (!this.uiManager.isHovered()) {
/*  85 */       this.window.hover();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  90 */     this.placer.click(button);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(double mouseTimer, GBox text) {
/*  96 */     this.placer.hoverTimer(text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds, boolean should) {
/* 104 */     this.window.update(ds);
/* 105 */     this.placer.update(!this.uiManager.isHovered());
/* 106 */     if ((KEYS.MAIN()).THRONE.consumeClick()) {
/* 107 */       this.window.centererTile.set(THRONE.coo());
/*     */     }
/*     */     
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 115 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 116 */     this.renderer.add();
/*     */     
/* 118 */     GAME.s().render(r, ds, this.window, this.minimap.config);
/* 119 */     if (VIEW.hideUI()) {
/*     */       return;
/*     */     }
/*     */     
/* 123 */     if (this.window.consumeHover()) {
/* 124 */       SETT.LIGHTS().renderMouse(this.window.pixel().x(), this.window.pixel().y(), -this.window.pixels().relX(), -this.window.pixels().relY(), 5);
/*     */       
/* 126 */       if (this.window.hasZoomedOutMoreandConsumeThatMotherFZoom())
/* 127 */         this.minimap.open(); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public GameWindow getWindow() {
/* 132 */     return this.window;
/*     */   }
/*     */   
/*     */   public void clearAllInterrupters() {
/* 136 */     this.uiManager.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate() {
/* 141 */     this.window.stop();
/* 142 */     this.window.copy(VIEW.s().getWindow());
/* 143 */     super.activate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivate() {
/* 149 */     VIEW.s().getWindow().copy(this.window);
/* 150 */     super.deactivate();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 154 */     this.selection.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterTick() {
/* 159 */     this.selection.clearHover();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelowTerrain(Renderer r, ShadowBatch s, RenderData data) {
/* 165 */     this.renderer.renderBelow((SPRITE_RENDERER)r, data);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\invasion\SBattleView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
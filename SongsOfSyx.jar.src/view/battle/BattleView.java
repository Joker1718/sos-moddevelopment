/*     */ package view.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.state.BattleState;
/*     */ import game.save.Savable;
/*     */ import init.constant.C;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.gui.misc.GBox;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.battle.editor.BattleViewEditor;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSett;
/*     */ import view.subview.GameWindow;
/*     */ import view.ui.top.UIPanelTop;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BattleView
/*     */   extends VIEW.ViewSub
/*     */ {
/*  34 */   private final GameWindow window = new GameWindow(
/*  35 */       1, 
/*  36 */       C.DIM(), 
/*  37 */       SETT.PIXEL_BOUNDS, 
/*  38 */       0);
/*  39 */   private final DivSelection selection = new DivSelection();
/*  40 */   private final BattlePlacer placer = new BattlePlacer(this.window, this.selection);
/*  41 */   private final BattleRenderer renderer = new BattleRenderer(this.selection);
/*     */   
/*     */   public final ISidePanels panels;
/*     */   final BattlePanel panel;
/*     */   final UIMinimapSett minimap;
/*     */   private BattleState state;
/*     */   public final BattleViewEditor editor;
/*     */   
/*     */   public BattleView() {
/*  50 */     UIPanelTop pp = new UIPanelTop(this.uiManager, true, true);
/*  51 */     this.panels = new ISidePanels(this.uiManager, 0);
/*  52 */     this.minimap = new UIMinimapSett(this.uiManager, 51, this.window, null);
/*     */ 
/*     */     
/*  55 */     this.panel = new BattlePanel(this.panels, this.window, pp, this.selection, true);
/*     */ 
/*     */     
/*  58 */     this.window.setzoomoutMax(3);
/*     */     
/*  60 */     GAME.saver().add(new Savable("BATTLE_VIEW")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/*  64 */             BattleView.this.window.saver.save(file);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/*  69 */             BattleView.this.window.saver.load(file);
/*  70 */             BattleView.this.selection.clear();
/*     */           }
/*     */         });
/*     */     
/*  74 */     this.editor = new BattleViewEditor();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  80 */     if (!this.uiManager.isHovered()) {
/*  81 */       this.window.hover();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  86 */     this.placer.click(button);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(double mouseTimer, GBox text) {
/*  92 */     if (MButt.RIGHT.isDown()) {
/*  93 */       ENTITY e = SETT.ENTITIES().getAtPoint(this.window.pixel().x(), this.window.pixel().y());
/*  94 */       if (e != null) {
/*  95 */         e.hover(text);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 100 */     this.placer.hoverTimer(text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BattleState state() {
/* 106 */     return this.state;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds, boolean should) {
/* 112 */     if (this.state != null) {
/* 113 */       this.state.update(ds * GAME.SPEED.speedTarget());
/*     */     }
/* 115 */     this.window.update(ds);
/* 116 */     this.placer.update(!this.uiManager.isHovered());
/* 117 */     if ((KEYS.MAIN()).THRONE.consumeClick()) {
/* 118 */       this.window.centererTile.set(THRONE.coo());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 123 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 128 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 129 */     this.renderer.add();
/* 130 */     GAME.s().render(r, ds, this.window, this.minimap.config);
/* 131 */     if (VIEW.hideUI()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 136 */     if (this.window.consumeHover()) {
/* 137 */       SETT.LIGHTS().renderMouse(this.window.pixel().x(), this.window.pixel().y(), -this.window.pixels().relX(), -this.window.pixels().relY(), 5);
/*     */       
/* 139 */       if (this.window.hasZoomedOutMoreandConsumeThatMotherFZoom()) {
/* 140 */         this.minimap.open();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void afterTick() {
/* 146 */     this.selection.clearHover();
/* 147 */     super.afterTick();
/*     */   }
/*     */   
/*     */   public GameWindow getWindow() {
/* 151 */     return this.window;
/*     */   }
/*     */   
/*     */   public void clearAllInterrupters() {
/* 155 */     this.uiManager.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate() {
/* 160 */     this.window.stop();
/* 161 */     super.activate();
/*     */   }
/*     */   
/*     */   public void activate(BattleState state) {
/* 165 */     this.state = state;
/* 166 */     this.window.stop();
/* 167 */     super.activate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 172 */     this.selection.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelowTerrain(Renderer r, ShadowBatch s, RenderData data) {
/* 177 */     this.renderer.renderBelow((SPRITE_RENDERER)r, data);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canSave() {
/* 182 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattleView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
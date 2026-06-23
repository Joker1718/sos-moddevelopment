/*     */ package view.sett;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.minimap.UIMinimapSett;
/*     */ import view.sett.ui.minimap.UIMinimapSettConfig;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolConfig;
/*     */ import view.tool.ToolManager;
/*     */ 
/*     */ 
/*     */ public class SettViewStart
/*     */   extends VIEW.ViewSub
/*     */ {
/*  34 */   private final GameWindow window = new GameWindow(
/*  35 */       1, 
/*  36 */       C.DIM(), 
/*  37 */       SETT.PIXEL_BOUNDS, 
/*  38 */       0);
/*     */   
/*     */   private final ToolManager manager;
/*     */   
/*     */   private final UIMinimapSett mini;
/*     */   private final ToolDefault def;
/*     */   private final ToolConfig config;
/*     */   
/*     */   public SettViewStart() {
/*  47 */     D.t(this);
/*     */     
/*  49 */     final GuiSection s = new GuiSection();
/*  50 */     s.body().setDim(200.0D, 1.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.terrain, (SPRITE)(SPRITES.icons()).m.rotate))
/*     */       {
/*     */         protected void clickA() {
/*  75 */           SETT.reGenerate();
/*     */         }
/*     */       };
/*  78 */     s.addRelBody(4, DIR.S, (RENDEROBJ)buttPanel.hoverInfoSet(D.g("Regenerate")));
/*     */ 
/*     */     
/*  81 */     GPanel p = (new GPanel((RECTANGLE)s.body())).setBig();
/*  82 */     p.setTitle(D.g("start", "Landing Party"));
/*  83 */     p.body.moveY1(80.0D);
/*  84 */     p.body.centerX(C.DIM());
/*  85 */     s.body().centerIn((RECTANGLE)p.inner());
/*  86 */     s.add((RENDEROBJ)p);
/*  87 */     s.moveLastToBack();
/*     */ 
/*     */     
/*  90 */     this.manager = new ToolManager(this.uiManager, this.window);
/*  91 */     this.mini = new UIMinimapSett(this.uiManager, 0, this.window, UIMinimapSettConfig.ALL);
/*  92 */     this.mini.panel().addOverlays();
/*  93 */     this.mini.panel().addScreenshot(null);
/*     */ 
/*     */     
/*  96 */     this.config = new ToolConfig()
/*     */       {
/*     */         public boolean back()
/*     */         {
/* 100 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void update(boolean UIHovered) {
/* 105 */           if (POP.tot(null) > 0) {
/* 106 */             VIEW.s().activate();
/*     */             
/* 108 */             (FACTIONS.player()).bonusesCustom.apply();
/*     */             
/* 110 */             GAME.setGameStart();
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void addUI(LISTE<RENDEROBJ> uis) {
/* 116 */           uis.add(s);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 121 */     this.window.setzoomoutMax(3);
/* 122 */     this.def = new ToolDefault(this.manager);
/* 123 */     this.manager.place((PLACABLE)(SETT.PLACERS()).landingParty, this.config);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(double mouseTimer, GBox text) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds, boolean shoudl) {
/* 146 */     VIEW.s().getWindow().copy(this.window);
/* 147 */     if (MButt.RIGHT.isDown()) {
/* 148 */       this.manager.set(this.def);
/* 149 */     } else if (POP.tot(null) == 0) {
/* 150 */       this.manager.place((PLACABLE)(SETT.PLACERS()).landingParty, this.config);
/*     */     } 
/*     */     
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 162 */     GAME.s().render(r, ds, this.window, this.mini.config);
/* 163 */     if (this.window.consumeHover()) {
/*     */       
/* 165 */       SETT.LIGHTS().renderMouse(this.window.pixel().x(), this.window.pixel().y(), -this.window.pixels().relX(), -this.window.pixels().relY(), 5);
/*     */       
/* 167 */       if (this.window.hasZoomedOutMoreandConsumeThatMotherFZoom()) {
/* 168 */         this.mini.open();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void activate() {
/* 174 */     this.window.stop();
/* 175 */     this.window.copy(VIEW.s().getWindow());
/* 176 */     super.activate();
/*     */   }
/*     */   
/*     */   public void clear() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\SettViewStart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
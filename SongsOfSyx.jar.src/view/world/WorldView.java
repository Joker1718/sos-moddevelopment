/*     */ package view.world;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.save.Savable;
/*     */ import init.constant.C;
/*     */ import java.io.IOException;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolManager;
/*     */ import view.ui.top.UIPanelTop;
/*     */ import view.world.editor.WorldViewEditor;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorldView
/*     */   extends VIEW.ViewSub
/*     */ {
/*  31 */   public final GameWindow window = createwindow();
/*     */   public static GameWindow createwindow() {
/*  33 */     return new GameWindow(
/*  34 */         1, 
/*  35 */         C.DIM(), 
/*  36 */         WORLD.PIXELS(), 
/*  37 */         320);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ToolManager tools;
/*     */   public final WorldUI UI;
/*  43 */   public final ISidePanels panels = new ISidePanels(this.uiManager, 0);
/*     */   
/*     */   public final IDebugPanelWorld debug;
/*     */   public final WorldViewEditor editor;
/*     */   
/*     */   public WorldView() {
/*  49 */     UIPanelTop p = new UIPanelTop(this.uiManager);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     this.tools = new ToolManager(this.uiManager, this.window);
/*  55 */     this.UI = new WorldUI(this.uiManager, this.panels, this.tools);
/*  56 */     this.tools.setDefault(new ToolDefault(this.tools));
/*  57 */     this.editor = new WorldViewEditor(this.window);
/*  58 */     GAME.saver().add(new Savable("VIEW_WORLD")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/*  62 */             WorldView.this.window.saver.save(file);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/*  67 */             WorldView.this.window.saver.load(file);
/*  68 */             WORLD.MINIMAP().repaint();
/*     */           }
/*     */         });
/*     */     
/*  72 */     for (PLACABLE pl : WORLD.TERRAIN().saver().makePlacers(this.tools)) {
/*  73 */       IDebugPanelWorld.add(pl, "terrain");
/*     */     }
/*  75 */     this.debug = new IDebugPanelWorld(this.uiManager);
/*     */   }
/*     */ 
/*     */   
/*     */   public void activate() {
/*  80 */     if (VIEW.current() == this)
/*     */       return; 
/*  82 */     super.activate();
/*     */     
/*  84 */     this.window.stop();
/*  85 */     this.tools.set(null, null, true);
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
/*     */   protected boolean update(float ds, boolean should) {
/* 108 */     if ((KEYS.MAIN()).THRONE.consumeClick()) {
/* 109 */       this.window.centererTile.set(FACTIONS.player().capitolRegion().cx(), FACTIONS.player().capitolRegion().cy());
/*     */     }
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/* 117 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 118 */     GAME.world().render(r, ds, this.window.zoomout(), (RECTANGLE)this.window.pixels(), this.window.view().x1() << this.window.zoomout(), this.window.view().y1() << this.window.zoomout());
/*     */   }
/*     */   
/*     */   protected void afterTick() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\WorldView.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
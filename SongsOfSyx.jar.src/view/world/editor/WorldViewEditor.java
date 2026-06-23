/*     */ package view.world.editor;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanels;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.ToolManager;
/*     */ import world.WORLD;
/*     */ 
/*     */ public class WorldViewEditor
/*     */   extends VIEW.ViewSubSimple {
/*     */   final GameWindow window;
/*     */   final ToolManager tools;
/*     */   final ISidePanels panels;
/*     */   
/*  26 */   public static final ACTION loadPrint = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  30 */         if (!SPRITES.loader().isMini())
/*  31 */           SPRITES.loader().minify(true, Dic.¤¤Generating); 
/*  32 */         SPRITES.loader().print(Dic.¤¤Generating);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   boolean hasSeletedRace = false;
/*     */   boolean hasSelectedTitles = true;
/*     */   
/*     */   public WorldViewEditor(GameWindow window) {
/*  41 */     for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/*  42 */       if (t.unlocked()) {
/*  43 */         this.hasSelectedTitles = false;
/*     */       }
/*     */     } 
/*  46 */     this.window = window;
/*  47 */     this.tools = new ToolManager(this.uiManager, window);
/*  48 */     window.setZoomout(2);
/*  49 */     window.centererTile.set(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2);
/*  50 */     this.panels = new ISidePanels(this.uiManager, 0);
/*  51 */     reset();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void activate() {
/*  61 */     super.activate();
/*  62 */     this.window.stop();
/*  63 */     (WORLD.FOW()).toggled.set(false);
/*  64 */     (WORLD.GEN()).isEditing = true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivate() {
/*  70 */     (WORLD.FOW()).toggled.set(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/*  76 */     this.window.hover();
/*     */   }
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
/*     */   protected boolean update(float ds, boolean should) {
/*  92 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(Renderer r, float ds, boolean hide) {
/*  98 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/*  99 */     GAME.world().render(r, ds, this.window.zoomout(), (RECTANGLE)this.window.pixels(), this.window.view().x1() << this.window.zoomout(), this.window.view().y1() << this.window.zoomout());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void reset() {
/* 105 */     this.uiManager.clear();
/* 106 */     this.tools.place(null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\WorldViewEditor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.MButt;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.gui.misc.GBox;
/*    */ import util.text.Dic;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ import view.tool.ToolManager;
/*    */ import view.world.WorldView;
/*    */ import world.WORLD;
/*    */ 
/*    */ public class BattleViewEditor extends VIEW.ViewSubSimple {
/*    */   final GameWindow window;
/*    */   final ToolManager tools;
/*    */   final ISidePanels panels;
/*    */   
/* 24 */   public static final ACTION loadPrint = new ACTION()
/*    */     {
/*    */       public void exe()
/*    */       {
/* 28 */         if (!SPRITES.loader().isMini())
/* 29 */           SPRITES.loader().minify(true, Dic.¤¤Generating); 
/* 30 */         SPRITES.loader().print(Dic.¤¤Generating);
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/*    */   public BattleViewEditor() {
/* 37 */     this.window = WorldView.createwindow();
/* 38 */     this.tools = new ToolManager(this.uiManager, this.window);
/* 39 */     this.window.setZoomout(2);
/* 40 */     this.window.centererTile.set(WORLD.TWIDTH() / 2, WORLD.THEIGHT() / 2);
/* 41 */     this.panels = new ISidePanels(this.uiManager, 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void activate() {
/* 50 */     super.activate();
/* 51 */     this.window.stop();
/* 52 */     (WORLD.FOW()).toggled.set(false);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void deactivate() {
/* 58 */     (WORLD.FOW()).toggled.set(true);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 64 */     this.window.hover();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void mouseClick(MButt button) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hoverTimer(double mouseTimer, GBox text) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean update(float ds, boolean should) {
/* 80 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void render(Renderer r, float ds, boolean hide) {
/* 86 */     this.window.crop((RECTANGLE)this.uiManager.viewPort());
/* 87 */     GAME.world().render(r, ds, this.window.zoomout(), (RECTANGLE)this.window.pixels(), this.window.view().x1(), this.window.view().y1());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean canSave() {
/* 93 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\BattleViewEditor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package view.tool;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import util.gui.misc.GBox;
/*    */ import view.subview.GameWindow;
/*    */ 
/*    */ public abstract class Tool
/*    */ {
/*  9 */   private static final ToolConfig normal = new ToolConfig()
/*    */     {
/*    */     
/*    */     };
/*    */   private final ToolManager manager;
/*    */   
/*    */   protected void update(float ds, GameWindow window) {}
/*    */   
/*    */   protected abstract void updateHovered(float paramFloat, GameWindow paramGameWindow);
/*    */   
/*    */   protected ToolConfig defaultConfig() {
/* 20 */     return normal;
/*    */   }
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, GameWindow window) {}
/*    */   
/*    */   protected Tool(ToolManager manager) {
/* 26 */     this.manager = manager;
/*    */   } protected abstract void renderHovered(SPRITE_RENDERER paramSPRITE_RENDERER, float paramFloat, GameWindow paramGameWindow, GBox paramGBox);
/*    */   protected abstract void click(GameWindow paramGameWindow);
/*    */   protected boolean rightClick() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   protected ToolManager manager() {
/* 34 */     return this.manager;
/*    */   }
/*    */   
/*    */   public final void deactivate() {
/* 38 */     manager().set(null, null, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isActivated() {
/* 43 */     return (manager().current() == this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\Tool.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
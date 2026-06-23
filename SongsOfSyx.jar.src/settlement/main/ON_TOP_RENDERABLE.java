/*    */ package settlement.main;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import init.constant.C;
/*    */ import snake2d.CORE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.light.AmbientLight;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ public abstract class ON_TOP_RENDERABLE
/*    */ {
/* 14 */   static final ArrayList<ON_TOP_RENDERABLE> renderables = new ArrayList(64);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private boolean isAdded = false;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(ShadowBatch shadowBatch, RenderData data, int zoomout, double ds) {
/* 28 */     CORE.renderer().newLayer(false, zoomout);
/* 29 */     AmbientLight.full.register(0, C.WIDTH() << zoomout, 0, C.HEIGHT() << zoomout);
/* 30 */     render(CORE.renderer(), shadowBatch, data, ds);
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, RenderData paramRenderData, double paramDouble);
/*    */ 
/*    */   
/*    */   public void add() {
/* 38 */     if (this.isAdded)
/*    */       return; 
/* 40 */     renderables.add(this);
/* 41 */     this.isAdded = true;
/*    */   }
/*    */   
/*    */   public void remove() {
/* 45 */     if (!this.isAdded)
/*    */       return; 
/* 47 */     renderables.remove(this);
/* 48 */     this.isAdded = false;
/*    */   }
/*    */   
/*    */   public boolean isAdded() {
/* 52 */     return this.isAdded;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\ON_TOP_RENDERABLE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
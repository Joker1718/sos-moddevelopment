/*    */ package game.battle.thread.status;
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import view.interrupter.IDebugPanel;
/*    */ 
/*    */ class Tests {
/*    */   Tests(BattleStatus status) {
/* 19 */     final ON_TOP_RENDERABLE top = new ON_TOP_RENDERABLE()
/*    */       {
/* 21 */         private final ArrayList<Div> res = new ArrayList(16);
/*    */         
/*    */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 24 */           RenderData.RenderIterator it = data.onScreenTiles();
/*    */           
/* 26 */           DivsTileMap m = BattleStatus.map();
/*    */           
/* 28 */           while (it.has()) {
/*    */             
/* 30 */             this.res.clear();
/* 31 */             int ai = 0;
/* 32 */             for (Div d : m.get((LISTE<Div>)this.res, it.tx(), it.ty())) {
/* 33 */               if (d.army() == GAME.ARMIES().player()) {
/* 34 */                 (GCOLOR.MAP()).BEST.bind();
/*    */               } else {
/*    */                 
/* 37 */                 (GCOLOR.MAP()).BAD.bind();
/*    */               } 
/* 39 */               (SPRITES.icons()).s.dot.renderC((SPRITE_RENDERER)r, it.x() + ai % 4 * 16, it.y() + ai / 4 * 16);
/* 40 */               ai++;
/*    */             } 
/*    */ 
/*    */ 
/*    */ 
/*    */             
/* 46 */             it.next();
/*    */           } 
/*    */ 
/*    */           
/* 50 */           COLOR.unbind();
/*    */         }
/*    */       };
/*    */ 
/*    */ 
/*    */     
/* 56 */     IDebugPanel.add("battle status map", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 60 */             top.add();
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\Tests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
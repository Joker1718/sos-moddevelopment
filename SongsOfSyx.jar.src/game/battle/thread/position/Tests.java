/*    */ package game.battle.thread.position;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import view.interrupter.IDebugPanel;
/*    */ 
/*    */ class Tests
/*    */ {
/*    */   Tests(final DivCentres status) {
/* 18 */     final ON_TOP_RENDERABLE top = new ON_TOP_RENDERABLE()
/*    */       {
/*    */         
/*    */         public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*    */         {
/* 23 */           for (Div d : GAME.ARMIES().divisions()) {
/*    */             
/* 25 */             DivCentre s = status.centre(d);
/* 26 */             if (s.cx == -1)
/*    */               continue; 
/* 28 */             int x = s.cxSoft;
/* 29 */             int y = s.cySoft;
/*    */             
/* 31 */             x = data.transformGX(x);
/* 32 */             y = data.transformGY(y);
/* 33 */             (UI.icons()).s.alert.renderCScaled((SPRITE_RENDERER)r, x, y, 8);
/* 34 */             (UI.FONT()).S.renderC((SPRITE_RENDERER)r, x, y + 128, (CharSequence)Str.TMP.clear().add(s.inFormation()), 8.0D);
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 40 */     IDebugPanel.add("battle div centres", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 44 */             top.add();
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\position\Tests.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
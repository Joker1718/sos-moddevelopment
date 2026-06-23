/*    */ package game.battle.thread.status;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   boolean debug = false;
/*    */   
/* 31 */   ON_TOP_RENDERABLE ren = new ON_TOP_RENDERABLE()
/*    */     {
/*    */       public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds)
/*    */       {
/* 35 */         RenderData.RenderIterator it = data.onScreenTiles();
/* 36 */         if ((BattleStatus.null.access$0(BattleStatus.null.this)).current == null) {
/*    */           return;
/*    */         }
/* 39 */         while (it.has()) {
/* 40 */           int p = (BattleStatus.null.access$0(BattleStatus.null.this)).current.map.soldiers(GAME.ARMIES().player()).get(it.tile());
/* 41 */           int e = (BattleStatus.null.access$0(BattleStatus.null.this)).current.map.soldiers(GAME.ARMIES().enemy()).get(it.tile());
/* 42 */           if (p != 0 || e != 0) {
/*    */             
/* 44 */             Str.TMP.clear().add(p).add('/').add(e);
/* 45 */             (UI.FONT()).S.render((SPRITE_RENDERER)r, (CharSequence)Str.TMP, it.x(), it.y());
/*    */           } 
/*    */           
/* 48 */           it.next();
/*    */         } 
/* 50 */         if (!BattleStatus.null.this.debug)
/* 51 */           remove(); 
/*    */       }
/*    */     };
/*    */   
/*    */   public void exe() {
/* 56 */     this.debug = !this.debug;
/* 57 */     this.ren.add();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\status\BattleStatus$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
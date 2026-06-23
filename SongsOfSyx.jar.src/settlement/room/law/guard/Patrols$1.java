/*    */ package settlement.room.law.guard;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.overlay.Addable;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import util.rendering.RenderData;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Addable
/*    */ {
/*    */   null(boolean $anonymous0, boolean $anonymous1) {
/* 32 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void initAbove(RenderData data) {
/* 37 */     COLOR.RED100.bind();
/* 38 */     for (int pi = 0; pi < Patrols.this.patrols.length; pi++) {
/* 39 */       Patrol p = Patrols.this.patrols[pi];
/* 40 */       ((COLOR)COLOR.UNIQUE.getC(pi)).bind();
/* 41 */       for (int i = 0; i < p.posses(); i++) {
/* 42 */         Coo coo = p.pos(i);
/* 43 */         int px = data.transformGX(coo.x() - 32);
/* 44 */         int py = data.transformGY(coo.y() - 32);
/* 45 */         (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)CORE.renderer(), 0, px, py);
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     COLOR.unbind();
/* 53 */     super.initAbove(data);
/* 54 */     add();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\Patrols$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
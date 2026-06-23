/*    */ package settlement.room.infra.logistics;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 75 */     RoomInstance ins = (RoomInstance)MoveOrderPullersUI.null.access$0(MoveOrderPullersUI.null.this).all().get(((Integer)ier.get()).intValue());
/* 76 */     if (ins != null) {
/* 77 */       ins.icon().render(r, X1, Y1);
/* 78 */       (GCOLOR.T()).H1.bind();
/* 79 */       (UI.FONT()).H2.render(r, (CharSequence)ins.name(), X1 + 48, Y1 + 16 - (UI.FONT()).H2.height() / 2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullersUI$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
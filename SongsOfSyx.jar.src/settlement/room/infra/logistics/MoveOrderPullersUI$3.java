/*    */ package settlement.room.infra.logistics;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.table.GTableBuilder;
/*    */ import view.main.VIEW;
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
/*    */   extends GTableBuilder.GRowBuilder
/*    */ {
/*    */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 71 */     SPRITE.Imp imp = new SPRITE.Imp(400, 32)
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */         {
/* 75 */           RoomInstance ins = (RoomInstance)MoveOrderPullersUI.null.access$0(MoveOrderPullersUI.null.this).all().get(((Integer)ier.get()).intValue());
/* 76 */           if (ins != null) {
/* 77 */             ins.icon().render(r, X1, Y1);
/* 78 */             (GCOLOR.T()).H1.bind();
/* 79 */             (UI.FONT()).H2.render(r, (CharSequence)ins.name(), X1 + 48, Y1 + 16 - (UI.FONT()).H2.height() / 2);
/*    */           } 
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 85 */     return (RENDEROBJ)new GButt.ButtPanel((SPRITE)imp)
/*    */       {
/*    */         protected void clickA() {
/* 88 */           RoomInstance ins = (RoomInstance)MoveOrderPullersUI.null.access$0(MoveOrderPullersUI.null.this).all().get(((Integer)ier.get()).intValue());
/* 89 */           if (ins != null)
/* 90 */             (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY()); 
/*    */         }
/*    */       };
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPullersUI$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
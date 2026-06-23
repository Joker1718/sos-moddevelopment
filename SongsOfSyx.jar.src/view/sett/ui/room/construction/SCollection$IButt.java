/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import view.main.VIEW;
/*    */ import view.sett.ui.bottom.UIRoomBuild;
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
/*    */ class IButt
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   private final State state;
/*    */   private final int k;
/*    */   
/*    */   IButt(State state, int k) {
/* 56 */     super((SPRITE)new SPRITE.Imp(32, state, k)
/*    */         {
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*    */           {
/* 60 */             RoomBlueprintImp b = (RoomBlueprintImp)state.collection.rooms().get(k);
/* 61 */             b.iconBig().render(r, X1, X2, Y1, Y2);
/*    */           }
/*    */         });
/*    */     
/* 65 */     this.state = state;
/* 66 */     this.k = k;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 71 */     RoomBlueprintImp b = (RoomBlueprintImp)this.state.collection.rooms().get(this.k);
/* 72 */     activeSet((b != null && b.reqs.passes(FACTIONS.player())));
/* 73 */     selectedSet((this.state.b == this.state.collection.rooms().get(this.k)));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 78 */     (VIEW.s()).ui.placer.init((RoomBlueprintImp)this.state.collection.rooms().get(this.k), this.state.collection);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 83 */     UIRoomBuild.hoverRoomBuild((RoomBlueprintImp)this.state.collection.rooms().get(this.k), text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SCollection$IButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
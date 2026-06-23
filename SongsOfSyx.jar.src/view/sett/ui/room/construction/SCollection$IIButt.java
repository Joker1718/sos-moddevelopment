/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.furnisher.FurnisherItemGroup;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class IIButt
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final State state;
/*     */   private final int k;
/*     */   
/*     */   IIButt(State state, int k) {
/*  93 */     super((SPRITE)new SPRITE.Imp(175, (UI.FONT()).S.height(), state, k)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/*  97 */             RoomBlueprintImp b = state.b;
/*  98 */             (UI.FONT()).S.renderCropped(r, ((FurnisherItemGroup)b.constructor().groups().getC(k)).name, X1, Y1, 175);
/*     */           }
/*     */         });
/*     */     
/* 102 */     this.state = state;
/* 103 */     this.k = k;
/* 104 */     pad(2, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 109 */     selectedSet((this.state.item() == this.k));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 114 */     this.state.setItem(this.k);
/* 115 */     (VIEW.s()).ui.placer.init(this.state.b, this.state.collection);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 120 */     RoomBlueprintImp b = this.state.b;
/* 121 */     text.title(((FurnisherItemGroup)b.constructor().groups().getC(this.k)).name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SCollection$IIButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
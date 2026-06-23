/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
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
/*     */ class Row
/*     */   extends UIPanelUtil.RoomRow
/*     */ {
/*     */   Row(RoomBlueprintImp p) {
/* 181 */     super(p);
/* 182 */     body().setWidth(380.0D);
/* 183 */     if (p instanceof RoomBlueprintIns) {
/* 184 */       final RoomBlueprintIns<?> pp = (RoomBlueprintIns)p;
/* 185 */       addRightCAbs(200, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text) {
/* 188 */               GFORMAT.i(text, pp.instancesSize());
/*     */             }
/*     */           });
/* 191 */       if (pp.employmentExtra() != null) {
/* 192 */         addRightCAbs(58, (SPRITE)new GStat()
/*     */             {
/*     */               public void update(GText text) {
/* 195 */                 GFORMAT.iofkInv(text, (pp.employmentExtra()).target.get(), pp.employment().neededWorkers());
/*     */               }
/*     */             });
/*     */       }
/*     */     } 
/* 200 */     pad(2, 4);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 205 */     super.render(r, ds);
/* 206 */     if (this.p instanceof RoomBlueprintIns && ((RoomBlueprintIns)this.p).instancesSize() == 0) {
/* 207 */       OPACITY.O25.bind();
/* 208 */       COLOR.BLACK.render(r, (RECTANGLE)body(), -2);
/* 209 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 215 */     if (hovered() == null || !(hovered() instanceof snake2d.util.gui.clickable.CLICKABLE)) {
/* 216 */       (VIEW.s()).panels.addDontRemove((VIEW.s()).ui.rooms.main(), UIRoom.this.table.get());
/*     */     }
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 221 */     selectedSet((VIEW.s()).panels.added(UIRoom.this.table));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoom$Row.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
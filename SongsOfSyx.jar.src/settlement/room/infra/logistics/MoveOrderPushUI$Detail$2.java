/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   GText t;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 188 */     super($anonymous0, $anonymous1);
/* 189 */     this.t = new GText((UI.FONT()).S, 128);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 193 */     this.t.clear();
/* 194 */     this.t.setMultipleLines(true);
/* 195 */     this.t.setMaxWidth(280);
/* 196 */     if (MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 197 */       this.t.add(MoveOrderPushUI.Detail.this.o.problem((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 198 */       this.t.errorify();
/* 199 */     } else if (MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()) != null) {
/* 200 */       this.t.add(MoveOrderPushUI.Detail.this.o.warning((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()));
/* 201 */       this.t.warnify();
/*     */     } 
/* 203 */     this.t.adjustWidth();
/* 204 */     this.t.render(r, this.body.x1(), this.body.y1());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$Detail$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package settlement.room.infra.logistics;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GSliderInt
/*     */ {
/*     */   null(INT.INTE $anonymous0, int $anonymous1, boolean $anonymous2) {
/* 233 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 237 */     GBox b = (GBox)text;
/* 238 */     b.title(MoveOrderPushUI.¤¤Limit);
/* 239 */     b.text(MoveOrderPushUI.¤¤LimitD);
/*     */ 
/*     */     
/* 242 */     b.NL();
/* 243 */     b.add((SPRITE)GFORMAT.perc(b.text(), MoveOrderPushUI.Detail.this.o.limit / 100.0D));
/* 244 */     b.NL();
/*     */     
/* 246 */     if (MoveOrderPushUI.Detail.this.o.dest() != null)
/* 247 */       for (RESOURCE res : RESOURCES.ALL()) {
/* 248 */         if (MoveOrderPushUI.Detail.this.o.dest().moveCapacity().has(res) && ((MoveOrderPush.MoveOrderPushInstance)(MoveOrderPushUI.Detail.access$0(MoveOrderPushUI.Detail.this)).source.get()).moveOrderPushAvailable().has(res)) {
/* 249 */           double am = MoveOrderPushUI.Detail.this.o.dest().storedD(res);
/* 250 */           b.add((SPRITE)res.icon());
/* 251 */           b.add((SPRITE)GFORMAT.perc(b.text(), am));
/* 252 */           b.NL();
/*     */         } 
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\logistics\MoveOrderPushUI$Detail$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
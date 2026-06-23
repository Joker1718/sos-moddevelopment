/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 398 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 402 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 404 */     double stored = 0.0D;
/* 405 */     double max = 0.0D;
/*     */     
/* 407 */     for (ADSupply s : AD.supplies().get(res)) {
/* 408 */       max += s.targetAmount((Faction)FACTIONS.player());
/* 409 */       stored += s.current().faction((Faction)FACTIONS.player());
/*     */     } 
/*     */     
/* 412 */     double d = stored / max;
/* 413 */     stored += (((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.amount.total(res) + ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.spaceReserved.total(res));
/* 414 */     double d2 = stored / max;
/* 415 */     if (max > 0.0D) {
/* 416 */       GMeter.renderDelta(r, d, d2, this.body.x1() + 5, this.body.x2() - 5, this.body.y1() + 5, this.body.y2() - 5, false, false);
/*     */     }
/* 418 */     res.icon().renderC(r, this.body.cX(), this.body.cY());
/* 419 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean sel() {
/* 424 */     for (int i = 0; i < ((ROOM_SUPPLY)Gui.access$2(Gui.this)).instancesSize(); i++) {
/* 425 */       if (((SupplyInstance)((ROOM_SUPPLY)Gui.access$2(Gui.this)).getInstance(i)).allowed().has(res))
/* 426 */         return true; 
/*     */     } 
/* 428 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 433 */     selectedSet(sel());
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 437 */     boolean sel = sel();
/* 438 */     for (int i = 0; i < ((ROOM_SUPPLY)Gui.access$2(Gui.this)).instancesSize(); i++) {
/* 439 */       SupplyInstance ins = (SupplyInstance)((ROOM_SUPPLY)Gui.access$2(Gui.this)).getInstance(i);
/* 440 */       if (sel == ins.allowed().has(res)) {
/* 441 */         ins.allowedToggle(res);
/* 442 */         ins.reset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 449 */     GBox b = (GBox)text;
/* 450 */     b.title(res.name);
/*     */     
/* 452 */     Gui.this.hoverNeeded(b, res);
/*     */     
/* 454 */     b.textLL(Gui.¤¤underway);
/* 455 */     b.tab(7);
/* 456 */     b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.amount.total(res) + ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.spaceReserved.total(res))));
/* 457 */     b.NL();
/*     */     
/* 459 */     if ((S.get()).developer) {
/* 460 */       for (SupplyTally.TallyData d : ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.datas) {
/* 461 */         b.textLL(d.name);
/* 462 */         b.tab(7);
/* 463 */         b.add((SPRITE)GFORMAT.i(b.text(), d.total(res)));
/* 464 */         b.NL();
/*     */       } 
/*     */       
/* 467 */       b.add((SPRITE)(UI.icons()).s.question);
/* 468 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.access$2(Gui.this)).cache.deliverable(res)));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Gui$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
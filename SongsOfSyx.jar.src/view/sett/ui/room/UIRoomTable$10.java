/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Booster;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.employment.RoomEquip;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.BSection
/*     */ {
/*     */   protected void hoverInfoSelf(GUI_BOX box) {
/* 303 */     GBox bo = (GBox)box;
/*     */     
/* 305 */     bo.add(e.info);
/* 306 */     bo.NL(8);
/*     */     
/* 308 */     bo.textL(UIRoomTable.¤¤level);
/* 309 */     bo.add((SPRITE)GFORMAT.i(bo.text(), e.target(b.employment()).availableMax()));
/* 310 */     bo.NL();
/* 311 */     if (e.target(b.employment()).boost() != null) {
/* 312 */       e.target(b.employment()).boost().hoverDetailed((GUI_BOX)bo, (BOOSTABLE_O)HCLASS_RACE.clP(), null, true);
/*     */     }
/* 314 */     bo.sep();
/*     */     
/* 316 */     bo.textLL(Dic.¤¤Target);
/* 317 */     bo.tab(7);
/* 318 */     bo.add((SPRITE)GFORMAT.iofk(bo.text(), e.target(b.employment()).get(), e.target(b.employment()).max()));
/* 319 */     bo.NL();
/*     */     
/* 321 */     bo.textLL(Dic.¤¤Target);
/* 322 */     bo.add((SPRITE)bo.text().para(Dic.¤¤Total));
/* 323 */     bo.tab(7);
/* 324 */     bo.add((SPRITE)GFORMAT.i(bo.text(), e.targetI(b.employment())));
/* 325 */     bo.NL();
/*     */     
/* 327 */     bo.textLL(Dic.¤¤Current);
/* 328 */     bo.tab(7);
/* 329 */     bo.add((SPRITE)GFORMAT.i(bo.text(), e.current(b.employment())));
/* 330 */     bo.NL();
/*     */     
/* 332 */     bo.textLL(Dic.¤¤Degrade);
/* 333 */     bo.add((SPRITE)bo.text().para(Dic.¤¤Total));
/* 334 */     bo.add((SPRITE)bo.text().para(DicTime.¤¤Day));
/* 335 */     bo.tab(7);
/* 336 */     bo.add((SPRITE)GFORMAT.f0(bo.text(), -e.targetI(b.employment()) * e.degradePerDay));
/*     */     
/* 338 */     bo.sep();
/* 339 */     Booster bbb = (e.boost(UIRoomTable.this.blueprint.employment())).booster;
/* 340 */     bbb.hover((GUI_BOX)bo, bbb.getValue(e.value(b.employment())));
/* 341 */     bbb.hoverSpan((GUI_BOX)bo, bbb.getValue(e.value(b.employment())));
/* 342 */     bo.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomTable$10.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
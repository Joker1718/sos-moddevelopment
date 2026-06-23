/*     */ package settlement.room.infra.station;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResLine
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private ArrayList<RESOURCE> current;
/*     */   private final GETTER<StationInstance> g;
/*     */   private final int k;
/*     */   
/*     */   ResLine(int k, GETTER<StationInstance> g, ArrayList<RESOURCE> current) {
/* 330 */     super(300, 32);
/* 331 */     this.g = g;
/* 332 */     this.current = current;
/* 333 */     this.k = k;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 339 */     if (this.k >= this.current.size())
/*     */       return; 
/* 341 */     RESOURCE res = (RESOURCE)this.current.get(this.k);
/*     */     
/* 343 */     res.icon().renderCY(r, this.body.x1(), this.body.cY());
/* 344 */     StationInstance ins = (StationInstance)this.g.get();
/* 345 */     StationTally t = ins.tally(res);
/*     */     
/* 347 */     int x2 = this.body.x2() - 48;
/* 348 */     GMeter.render(r, GMeter.C_REDGREEN, t.stored() / t.space(), this.body.x1() + 30, x2, this.body.y1() + 4, this.body.y2() - 4);
/*     */     
/* 350 */     Str.TMP.clear().add(t.stored());
/* 351 */     int w = (UI.FONT()).S.width((CharSequence)Str.TMP);
/* 352 */     OPACITY.O50.bind();
/* 353 */     COLOR.BLACK.render(r, x2 - w - 8, x2, this.body.y1() + 5, this.body.y2() - 5);
/* 354 */     OPACITY.unbind();
/*     */     
/* 356 */     (UI.FONT()).S.renderCY(r, x2 - w - 4, this.body.cY(), (CharSequence)Str.TMP);
/*     */ 
/*     */     
/* 359 */     if (ins.accepting(res)) {
/* 360 */       (GCOLOR.T()).IGOOD.bind();
/*     */     } else {
/* 362 */       (GCOLOR.T()).IBAD.bind();
/*     */     } 
/* 364 */     (UI.icons()).s.storage.renderCY(r, x2 + 8, this.body.cY());
/*     */     
/* 366 */     if ((SETT.ROOMS()).TRANSPORT.hasActive(res)) {
/* 367 */       (GCOLOR.T()).IGOOD.bind();
/*     */     } else {
/* 369 */       (GCOLOR.T()).IBAD.bind();
/*     */     } 
/* 371 */     (UI.icons()).s.chevron(DIR.E).renderCY(r, x2 + 24, this.body.cY());
/* 372 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 377 */     if (this.k >= this.current.size())
/*     */       return; 
/* 379 */     RESOURCE res = (RESOURCE)this.current.get(this.k);
/* 380 */     StationInstance ins = (StationInstance)this.g.get();
/* 381 */     StationTally t = ins.tally(res);
/* 382 */     GBox b = (GBox)text;
/*     */     
/* 384 */     b.title(res.name);
/*     */     
/* 386 */     b.textLL(Dic.¤¤Stored);
/* 387 */     b.tab(6);
/* 388 */     b.add((SPRITE)GFORMAT.i(b.text(), t.stored()));
/* 389 */     b.NL();
/*     */     
/* 391 */     b.textLL(Dic.¤¤Capacity);
/* 392 */     b.tab(6);
/* 393 */     b.add((SPRITE)GFORMAT.i(b.text(), t.space()));
/* 394 */     b.NL();
/*     */     
/* 396 */     b.textLL(Gui.¤¤reserved);
/* 397 */     b.tab(6);
/* 398 */     b.add((SPRITE)GFORMAT.i(b.text(), t.reserved()));
/* 399 */     b.NL();
/*     */     
/* 401 */     b.textLL(Gui.¤¤incoming);
/* 402 */     b.tab(6);
/* 403 */     b.add((SPRITE)GFORMAT.i(b.text(), ins.incoming(res)));
/* 404 */     b.NL();
/*     */     
/* 406 */     if (ins.accepting(res)) {
/* 407 */       b.add((SPRITE)b.text().normalify2().add(Gui.¤¤accepting));
/*     */     } else {
/* 409 */       b.error(Gui.¤¤acceptingNot);
/*     */     } 
/* 411 */     if ((S.get()).developer)
/* 412 */       b.add((SPRITE)b.text().add(ins.blueprintI().tally(res).accepting())); 
/* 413 */     b.NL();
/*     */     
/* 415 */     if ((SETT.ROOMS()).TRANSPORT.hasActive(res)) {
/* 416 */       b.add((SPRITE)b.text().normalify2().add(Gui.¤¤has));
/*     */     } else {
/* 418 */       b.error(Gui.¤¤hasNot);
/*     */     } 
/* 420 */     b.NL();
/*     */     
/* 422 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Gui$ResLine.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
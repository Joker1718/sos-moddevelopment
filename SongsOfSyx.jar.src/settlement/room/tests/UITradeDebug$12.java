/*     */ package settlement.room.tests;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.tests.production.Input;
/*     */ import settlement.room.tests.production.TestRecipe;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GTableBuilder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 487 */     return (RENDEROBJ)new HOVERABLE.HoverableAbs(500, 32)
/*     */       {
/*     */         protected void render(SPRITE_RENDERER ren, float ds, boolean isHovered)
/*     */         {
/* 491 */           TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/*     */           
/* 493 */           int x1 = this.body.x1() + 4;
/*     */           
/* 495 */           (UI.FONT()).S.renderCY(ren, x1, this.body.cY(), (CharSequence)Str.TMP.clear().add(1.0D / r.wPerItem, 1));
/* 496 */           x1 += 32;
/*     */           
/* 498 */           r.res.icon().renderCY(ren, x1, this.body.cY());
/* 499 */           x1 += 32;
/*     */ 
/*     */           
/* 502 */           r.ins.blue.icon.renderCY(ren, x1, this.body.cY());
/* 503 */           COLOR.BLACK.bind();
/* 504 */           (UI.FONT()).S.renderC(ren, x1 + 8 + 2, this.body.cY() - 8 + 2, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 505 */           (UI.FONT()).S.renderC(ren, x1 + 8 - 2, this.body.cY() - 8 - 2, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 506 */           COLOR.unbind();
/* 507 */           (UI.FONT()).S.renderC(ren, x1 + 8, this.body.cY() - 8, (CharSequence)GFORMAT.toNumeral(r.index + 1));
/* 508 */           x1 += 28;
/* 509 */           (UI.icons()).s.arrow_left.renderCY(ren, x1, this.body.cY());
/* 510 */           x1 += 24;
/*     */ 
/*     */           
/* 513 */           for (int i = 0; i < r.inputs().size(); i++) {
/*     */             
/* 515 */             Input ii = (Input)r.inputs().get(i);
/* 516 */             (UI.FONT()).S.renderCY(ren, x1, this.body.cY(), (CharSequence)Str.TMP.clear().add(ii.amount, 1));
/* 517 */             x1 += 32;
/* 518 */             ii.producer.ins.blue.icon.renderCY(ren, x1, this.body.cY());
/* 519 */             ii.res.icon().renderCY(ren, x1 + 24, this.body.cY() - 8);
/* 520 */             COLOR.BLACK.bind();
/* 521 */             (UI.FONT()).S.renderC(ren, x1 + 24 + 2, this.body.cY() - 8 + 2, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 522 */             (UI.FONT()).S.renderC(ren, x1 + 24 - 2, this.body.cY() - 8 - 2, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 523 */             COLOR.unbind();
/* 524 */             (UI.FONT()).S.renderC(ren, x1 + 24, this.body.cY() - 8, (CharSequence)GFORMAT.toNumeral(ii.producer.index + 1));
/* 525 */             x1 += 48;
/* 526 */             if (x1 > this.body.x2() - 100) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 536 */           TestRecipe r = UITradeDebug.null.access$0(UITradeDebug.null.this).get(ier);
/* 537 */           GBox b = (GBox)text;
/* 538 */           b.title((CharSequence)b.text().add(r.ins.blue.info.name).add(':').s().add(r.res.name).s().add((CharSequence)GFORMAT.toNumeral(r.index + 1)));
/*     */           
/* 540 */           b.textLL(UITradeDebug.¤¤work);
/* 541 */           b.tab(6);
/* 542 */           b.add((SPRITE)GFORMAT.f(b.text(), r.wPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)));
/* 543 */           b.NL();
/* 544 */           b.textLL(UITradeDebug.¤¤workT);
/* 545 */           b.tab(6);
/* 546 */           b.add((SPRITE)GFORMAT.f(b.text(), r.wTotPerItem((UITradeDebug.null.access$0(UITradeDebug.null.this)).pbonuses)));
/* 547 */           b.NL();
/*     */           
/* 549 */           hrec(b, 0, r.inputs());
/*     */ 
/*     */           
/* 552 */           super.hoverInfoGet(text);
/*     */         }
/*     */         
/*     */         private void hrec(GBox b, int tab, LIST<Input> inputs) {
/* 556 */           if (inputs.size() == 0) {
/*     */             return;
/*     */           }
/* 559 */           for (int i = 0; i < inputs.size(); i++) {
/* 560 */             b.tab(tab);
/* 561 */             Input ii = (Input)inputs.get(i);
/* 562 */             b.add((SPRITE)GFORMAT.f(b.text(), ii.amount, 2));
/* 563 */             b.add((SPRITE)ii.res.icon());
/* 564 */             b.add(ii.producer.ins.blue.icon.medium);
/* 565 */             b.space();
/* 566 */             b.NL();
/* 567 */             hrec(b, tab + 1, ii.producer.inputs());
/* 568 */             b.NL(8);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\tests\UITradeDebug$12.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
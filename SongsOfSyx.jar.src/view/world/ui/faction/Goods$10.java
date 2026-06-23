/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
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
/*     */ class null
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 421 */     final GStat s = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 425 */           GFORMAT.i(text, (int)(((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amount() - ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amountTarget()));
/*     */         }
/*     */       };
/*     */     
/* 429 */     s.bg();
/*     */     
/* 431 */     SPRITE.Imp imp = new SPRITE.Imp(W, s.height())
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 436 */           double n1 = ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).offset();
/* 437 */           double max = ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).amountTarget();
/* 438 */           double p1 = 1.0D - Math.abs(((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).playerTraded() / ((FactionNPC)f.get()).res(Goods.null.access$0(Goods.null.this).g(ier)).offset());
/* 439 */           GMeter.GMeterCol cc = GMeter.C_GRAY;
/* 440 */           if (n1 > 0.0D) {
/* 441 */             cc = GMeter.C_GREEN;
/* 442 */             n1 /= 2.0D;
/* 443 */           } else if (n1 < 0.0D) {
/* 444 */             n1 = -n1;
/* 445 */             cc = GMeter.C_RED;
/*     */           } 
/*     */           
/* 448 */           n1 = Math.abs(n1);
/* 449 */           n1 /= max;
/* 450 */           GMeter.render(r, cc, p1 * n1, n1, X1 + 4, X2 - 4, Y1, Y2);
/* 451 */           s.adjust();
/* 452 */           s.render(r, X2 - s.width(), Y1);
/*     */         }
/*     */       };
/*     */     
/* 456 */     return (RENDEROBJ)new HOVERABLE.Sprite((SPRITE)imp)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 463 */           GBox b = (GBox)text;
/* 464 */           TRADABLE res = Goods.null.access$0(Goods.null.this).g(ier);
/*     */           
/* 466 */           b.title(Goods.¤¤traded);
/* 467 */           b.text(Goods.¤¤tradedD);
/* 468 */           b.sep();
/*     */           
/* 470 */           b.textLL(Goods.¤¤tradedT);
/* 471 */           b.tab(6);
/* 472 */           b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)((FactionNPC)f.get()).res(res).offset()));
/* 473 */           b.NL();
/*     */           
/* 475 */           b.textLL(Goods.¤¤tradedP);
/* 476 */           b.tab(6);
/* 477 */           b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)((FactionNPC)f.get()).res(res).playerTraded()));
/* 478 */           b.NL();
/*     */ 
/*     */           
/* 481 */           b.textLL(Goods.¤¤Consumption);
/* 482 */           b.tab(6);
/* 483 */           b.add((SPRITE)GFORMAT.f0(b.text(), -((FactionNPC)f.get()).res(res).dailyConsumption()));
/* 484 */           b.NL();
/*     */           
/* 486 */           b.add((SPRITE)(UI.icons()).s.law);
/* 487 */           b.textL(Goods.¤¤Supply);
/* 488 */           b.tab(6);
/* 489 */           b.add((SPRITE)GFORMAT.perc(b.text(), ((FactionNPC)f.get()).res(res).amMulAt(-1)));
/* 490 */           b.NL();
/*     */           
/* 492 */           b.add((SPRITE)(UI.icons()).s.law);
/* 493 */           b.textL(Goods.¤¤Demand);
/* 494 */           b.tab(6);
/* 495 */           b.add((SPRITE)GFORMAT.perc(b.text(), ((FactionNPC)f.get()).res(res).amMulAt(1)));
/* 496 */           b.NL();
/*     */           
/* 498 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Goods$10.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
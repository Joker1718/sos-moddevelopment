/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.time.TIME;
/*    */ import game.time.TIMECYCLE;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ import world.region.RDOutputs;
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
/*    */ class null
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 48 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 52 */     RD.OUTPUT().squeze((Region)g.get());
/* 53 */     super.clickA();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 59 */     activeSet((!RD.BUILDINGS().isTmp() && (RD.DEVASTATION()).current.getD(g.get()) < 0.25D));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 64 */     GBox b = (GBox)text;
/* 65 */     b.title(RDOutputs.¤¤Squeeze);
/* 66 */     b.text(RDOutputs.¤¤SqueezeD);
/* 67 */     b.NL();
/*    */     
/* 69 */     b.add((SPRITE)(UI.icons()).s.money);
/* 70 */     b.textLL(Dic.¤¤Currs);
/* 71 */     b.tab(6);
/* 72 */     RD.OUTPUT().getClass(); b.add((SPRITE)GFORMAT.iIncr(b.text(), (long)((RD.OUTPUT()).MONEY.boost.get((BOOSTABLE_O)g.get()) * 4.0D)));
/* 73 */     b.NL();
/*    */     
/* 75 */     for (RDOutputs.RDResource res : (RD.OUTPUT()).RES) {
/* 76 */       RD.OUTPUT().getClass(); int am = (int)(res.boostYearlyPart.get((BOOSTABLE_O)g.get()) * 4.0D / TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 77 */       RD.OUTPUT().getClass(); am = (int)(am + res.boost.get((BOOSTABLE_O)g.get()) * 4.0D);
/* 78 */       if (am > 0) {
/* 79 */         b.add(res.res.icon());
/* 80 */         b.textLL(res.res.name);
/* 81 */         b.tab(6);
/* 82 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), am));
/* 83 */         b.NL();
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 90 */     b.textLL(((RD.DEVASTATION()).current.info()).name);
/* 91 */     b.tab(6);
/* 92 */     b.add((SPRITE)GFORMAT.perc(b.text(), -0.5D));
/* 93 */     b.NL();
/* 94 */     b.textLL(((RD.RACES()).loyaltyAll.info()).name);
/* 95 */     b.tab(6);
/* 96 */     b.add((SPRITE)GFORMAT.perc(b.text(), -0.4D));
/* 97 */     b.NL();
/* 98 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayOutput$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
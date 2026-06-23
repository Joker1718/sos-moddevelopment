/*    */ package view.world.ui.region;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ import world.region.RDOutputs;
/*    */ import world.region.pop.RDRace;
/*    */ 
/*    */ 
/*    */ final class PlayHov
/*    */ {
/*    */   static void hover(Region reg, GUI_BOX box) {
/* 18 */     box.title((CharSequence)reg.info.name());
/* 19 */     GBox b = (GBox)box;
/*    */     
/* 21 */     if (reg.capitol()) {
/* 22 */       b.text(Dic.¤¤CapitolYou);
/* 23 */       b.add((SPRITE)(UI.icons()).m.sword);
/* 24 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(reg)));
/* 25 */       b.NL();
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 30 */     double ii = 32.0D;
/* 31 */     double tot = RD.RACES().maxPop(reg);
/* 32 */     if (tot > 0.0D) {
/* 33 */       for (RDRace r : (RD.RACES()).all) {
/*    */         
/* 35 */         int am = (int)(ii * r.pop.get(reg) / tot);
/* 36 */         if ((RD.RACES()).visuals.cRace(reg) == r.race) {
/* 37 */           am++;
/*    */         }
/* 39 */         while (am-- > 0) {
/* 40 */           b.add((SPRITE)(r.race.appearance()).icon);
/* 41 */           b.rewind(16);
/*    */         } 
/*    */       } 
/*    */     }
/* 45 */     b.NL(8);
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
/* 59 */     b.NL(5);
/*    */     
/* 61 */     b.add((SPRITE)(UI.icons()).m.heart);
/* 62 */     b.add((SPRITE)GFORMAT.perc(b.text(), RD.HEALTH().getD(reg)));
/* 63 */     b.tab(3);
/*    */ 
/*    */     
/* 66 */     b.add((SPRITE)(UI.icons()).m.rebellion);
/* 67 */     b.add((SPRITE)GFORMAT.perc(b.text(), (RD.RACES()).loyaltyAll.getD(reg)));
/* 68 */     b.tab(6);
/* 69 */     b.add((SPRITE)(UI.icons()).m.flag);
/* 70 */     b.add((SPRITE)GFORMAT.perc(b.text(), (RD.OWNER()).affiliation.getD(reg)));
/* 71 */     b.tab(9);
/* 72 */     b.add((SPRITE)(UI.icons()).m.sword);
/* 73 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(reg)));
/* 74 */     b.NL(2);
/*    */     
/* 76 */     int i = 0;
/*    */     
/* 78 */     for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/* 79 */       i = addTax(b, i, (SPRITE)o.boost.icon, o.getDelivery(reg));
/*    */     }
/* 81 */     OtherHov.hovSiege(reg, box);
/* 82 */     RD.HEALTH().problem(b, reg);
/*    */   }
/*    */   
/*    */   private static int addTax(GBox b, int i, SPRITE icon, double amount) {
/* 86 */     if (amount > 1.0D) {
/*    */       
/* 88 */       if (i > 4) {
/* 89 */         i = 0;
/* 90 */         b.NL();
/*    */       } 
/*    */       
/* 93 */       b.tab(i * 3);
/* 94 */       b.add(icon);
/* 95 */       b.add((SPRITE)GFORMAT.i(b.text(), (int)amount));
/* 96 */       i++;
/*    */     } 
/* 98 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayHov.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
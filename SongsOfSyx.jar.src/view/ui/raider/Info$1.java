/*    */ package view.ui.raider;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import world.army.AD;
/*    */ import world.entity.army.WArmy;
/*    */ import world.region.RD;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 55 */     GFORMAT.i(text, (GAME.raiders()).util.playerPow());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 60 */     b.text(Info.¤¤defencesD);
/*    */     
/* 62 */     b.NL(16);
/* 63 */     b.textLL(Dic.¤¤garrison);
/* 64 */     b.NL();
/* 65 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(FACTIONS.player().capitolRegion())));
/* 66 */     b.NL(8);
/*    */     
/* 68 */     double pow = 0.0D;
/* 69 */     double pow2 = 0.0D;
/* 70 */     for (WArmy a : FACTIONS.player().armies().all()) {
/* 71 */       if (a.region() == FACTIONS.player().capitolRegion())
/* 72 */         pow += AD.power().get(a); 
/* 73 */       if (a.region() != null && a.region().faction() == FACTIONS.player()) {
/* 74 */         pow2 += AD.power().get(a);
/*    */       }
/*    */     } 
/* 77 */     b.textLL(Info.¤¤armiesD);
/* 78 */     b.NL();
/* 79 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)pow));
/* 80 */     b.NL(8);
/*    */     
/* 82 */     b.textLL(Info.¤¤armiesD2);
/* 83 */     b.NL();
/* 84 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)pow2));
/* 85 */     b.NL(8);
/*    */     
/* 87 */     b.textLL(Info.¤¤suprise);
/* 88 */     b.NL();
/* 89 */     if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/* 90 */       int pp = (int)(0.75D * ((RD.MILITARY()).power.getD(FACTIONS.player().capitolRegion()) + pow));
/* 91 */       pp = (int)(pp + pow2);
/* 92 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), -pp));
/*    */     } else {
/* 94 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), 0L));
/*    */     } 
/* 96 */     b.NL(8);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Info$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
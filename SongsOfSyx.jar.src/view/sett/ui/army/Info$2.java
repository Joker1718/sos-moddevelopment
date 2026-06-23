/*    */ package view.sett.ui.army;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
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
/* 68 */     GFORMAT.iofk(text, (STATS.BATTLE()).DIV.stat().data().get(null, 0), (SETT.BATTLE()).info.targetMen());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 73 */     b.title(Dic.¤¤Soldiers);
/* 74 */     b.text(Info.¤¤SoldierD);
/* 75 */     b.NL();
/* 76 */     b.add((SPRITE)GFORMAT.iBig(b.text(), (STATS.BATTLE()).DIV.stat().data().get(null, 0)));
/* 77 */     b.NL(4);
/*    */     
/* 79 */     b.textLL(Dic.¤¤Recruits);
/* 80 */     b.add((SPRITE)GFORMAT.iBig(b.text(), (STATS.BATTLE()).RECRUIT.stat().data().get(null, 0)));
/* 81 */     b.NL();
/* 82 */     b.text(Info.¤¤RecruitD);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Info$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
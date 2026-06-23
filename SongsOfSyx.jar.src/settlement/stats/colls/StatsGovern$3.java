/*    */ package settlement.stats.colls;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.stats.POP;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STATFakeRace;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends STATFakeRace
/*    */ {
/*    */   null(String $anonymous0, StatsInit $anonymous1) {
/* 76 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */   
/*    */   protected double getDD(Race r) {
/* 81 */     int pop = (POP.tot(HCLASSES.CITIZEN(), null) + POP.tot(HCLASSES.NOBLE(), null)) * 400 * 4;
/* 82 */     double d = FACTIONS.player().credits().credits();
/* 83 */     if (pop == 0) {
/* 84 */       return ((d > 0.0D) ? true : false);
/*    */     }
/* 86 */     return d / pop;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GUI_BOX text, HCLASS cl, Race type) {
/* 91 */     GBox b = (GBox)text;
/* 92 */     b.NL();
/* 93 */     b.textLL(Dic.¤¤Currs);
/* 94 */     int tot = (POP.tot(HCLASSES.CITIZEN(), null) + POP.tot(HCLASSES.NOBLE(), null)) * 400 * 4;
/* 95 */     b.add((SPRITE)GFORMAT.iofk(b.text(), (int)FACTIONS.player().credits().credits(), tot));
/* 96 */     b.NL();
/* 97 */     super.hover(text, cl, type);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsGovern$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
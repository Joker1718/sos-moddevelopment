/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.time.TIME;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import util.text.DicTime;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 51 */     GFORMAT.i(text, RD.MILITARY().defensePower((Region)g.get()));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 59 */     b.title(Dic.¤¤Defences);
/* 60 */     b.text(Dic.¤¤DefencesD);
/* 61 */     b.NL();
/* 62 */     b.textL(Dic.¤¤Besiege);
/* 63 */     b.tab(6);
/* 64 */     b.add((SPRITE)GFORMAT.perc(b.text(), RD.MILITARY().besigeMul((Region)g.get())));
/* 65 */     Str.TMP.clear();
/* 66 */     Str.TMP.add('(');
/* 67 */     DicTime.setDays(Str.TMP, WORLD.BATTLES().besigedTime((Region)g.get()) / TIME.secondsPerDay());
/* 68 */     Str.TMP.add(')');
/* 69 */     b.text((CharSequence)Str.TMP);
/*    */ 
/*    */     
/* 72 */     b.sep();
/* 73 */     b.textLL((RD.MILITARY()).bgarrison.name);
/* 74 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), (RD.MILITARY()).garrison.get((Region)g.get()), RD.MILITARY().garrisonTarget((Region)g.get())));
/* 75 */     b.NL();
/*    */     
/* 77 */     b.textLL(Dic.¤¤Power);
/* 78 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(g.get())));
/* 79 */     b.NL();
/*    */ 
/*    */     
/* 82 */     b.textLL((RD.MILITARY()).bFortification.name);
/* 83 */     b.add((SPRITE)GFORMAT.fofkInv(b.text(), (RD.MILITARY()).fort.getD(g.get()), (RD.MILITARY()).bFortification.get((BOOSTABLE_O)g.get())));
/* 84 */     b.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayMilitary$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
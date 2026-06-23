/*    */ package view.world.ui.region;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.time.TIME;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
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
/*    */ final class PlayMilitary extends GuiSection {
/*    */   PlayMilitary(final GETTER.GETTER_IMP<Region> g, int WIDTH) {
/* 23 */     body().incrW(64.0D);
/* 24 */     body().incrH(1.0D);
/*    */     
/* 26 */     addRight(0, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 30 */             GFORMAT.iIncr(text, (int)(RD.MILITARY()).conscriptTarget.get((BOOSTABLE_O)g.get()));
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 35 */             b.title((RD.MILITARY()).conscriptTarget.name);
/* 36 */             b.text((RD.MILITARY()).conscriptTarget.desc);
/* 37 */             b.sep();
/*    */             
/* 39 */             (RD.MILITARY()).conscriptTarget.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), null, true);
/*    */           }
/* 43 */         }).hv((SPRITE)(UI.icons()).m.sword));
/*    */ 
/*    */     
/* 46 */     addRightC(64, (RENDEROBJ)(new GStat()
/*    */         {
/*    */           
/*    */           public void update(GText text)
/*    */           {
/* 51 */             GFORMAT.i(text, RD.MILITARY().defensePower((Region)g.get()));
/*    */           }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GBox b) {
/* 59 */             b.title(Dic.¤¤Defences);
/* 60 */             b.text(Dic.¤¤DefencesD);
/* 61 */             b.NL();
/* 62 */             b.textL(Dic.¤¤Besiege);
/* 63 */             b.tab(6);
/* 64 */             b.add((SPRITE)GFORMAT.perc(b.text(), RD.MILITARY().besigeMul((Region)g.get())));
/* 65 */             Str.TMP.clear();
/* 66 */             Str.TMP.add('(');
/* 67 */             DicTime.setDays(Str.TMP, WORLD.BATTLES().besigedTime((Region)g.get()) / TIME.secondsPerDay());
/* 68 */             Str.TMP.add(')');
/* 69 */             b.text((CharSequence)Str.TMP);
/*    */ 
/*    */             
/* 72 */             b.sep();
/* 73 */             b.textLL((RD.MILITARY()).bgarrison.name);
/* 74 */             b.add((SPRITE)GFORMAT.iofkInv(b.text(), (RD.MILITARY()).garrison.get((Region)g.get()), RD.MILITARY().garrisonTarget((Region)g.get())));
/* 75 */             b.NL();
/*    */             
/* 77 */             b.textLL(Dic.¤¤Power);
/* 78 */             b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(g.get())));
/* 79 */             b.NL();
/*    */ 
/*    */             
/* 82 */             b.textLL((RD.MILITARY()).bFortification.name);
/* 83 */             b.add((SPRITE)GFORMAT.fofkInv(b.text(), (RD.MILITARY()).fort.getD(g.get()), (RD.MILITARY()).bFortification.get((BOOSTABLE_O)g.get())));
/* 84 */             b.NL();
/*    */           }
/* 90 */         }).hv((SPRITE)(UI.icons()).m.shield));
/*    */ 
/*    */     
/* 93 */     addRightCAbs(64, MiscMore.garrison(g, WIDTH - body().width() - 64));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayMilitary.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
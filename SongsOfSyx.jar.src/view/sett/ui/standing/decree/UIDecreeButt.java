/*    */ package view.sett.ui.standing.decree;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.race.Race;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.HCLASS;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.muls.StatsMultipliers;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GText;
/*    */ import util.text.D;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ public final class UIDecreeButt extends GButt.ButtPanel {
/* 24 */   static CharSequence ¤¤title = "¤Decrees";
/* 25 */   static CharSequence ¤¤desc = "¤Options for a ruler to increase fulfillment.";
/*    */   static {
/* 27 */     D.ts(UIDecreeButt.class);
/*    */   }
/*    */   
/*    */   private final GETTER<Race> racegetter;
/*    */   private final ISidePanel pp;
/*    */   private final HCLASS cl;
/*    */   
/*    */   public UIDecreeButt(HCLASS cl, GETTER<Race> race) {
/* 35 */     super((SPRITE)new SPRITE.Imp(180, (UI.FONT()).H2.height()) {
/* 36 */           private final GText t = new GText((UI.FONT()).S, 8);
/*    */           
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 39 */             (GCOLOR.T()).H1.bind();
/* 40 */             (UI.FONT()).H2.render(r, UIDecreeButt.¤¤title, X1, Y1);
/* 41 */             this.t.clear();
/* 42 */             COLOR.unbind();
/*    */           }
/*    */         });
/* 45 */     this.racegetter = race;
/* 46 */     this.cl = cl;
/* 47 */     this.body.incrW(16.0D);
/* 48 */     this.pp = new DPanel(cl, race);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renAction() {
/* 53 */     activeSet((race() != null));
/* 54 */     selectedSet((VIEW.s()).panels.added(this.pp));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 59 */     (VIEW.s()).panels.addDontRemove((ISidePanel)(VIEW.s()).ui.standing, (ISidePanel)(VIEW.s()).ui.slaves, this.pp);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 64 */     text.title(¤¤title);
/* 65 */     text.text(¤¤desc);
/* 66 */     text.NL(16);
/* 67 */     GBox b = (GBox)text;
/*    */     
/* 69 */     for (StatsMultipliers.StatMultiplier m : STATS.MULTIPLIERS().get(this.cl)) {
/* 70 */       if (m.key != null) {
/* 71 */         b.textL(m.name);
/* 72 */         b.NL();
/* 73 */         b.text(m.desc);
/* 74 */         b.NL();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected Race race() {
/* 81 */     return (Race)this.racegetter.get();
/*    */   }
/*    */   
/*    */   public static void hoverP(StatsMultipliers.StatMultiplier m, GUI_BOX box, HCLASS cl, Race race) {
/* 85 */     GBox b = (GBox)box;
/* 86 */     b.textL(m.name);
/* 87 */     b.NL();
/* 88 */     b.text(m.desc);
/* 89 */     b.NL();
/*    */     
/* 91 */     m.boosters.hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(race, cl), null);
/*    */     
/* 93 */     b.sep();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\decree\UIDecreeButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
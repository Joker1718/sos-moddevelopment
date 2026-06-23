/*    */ package settlement.battle.invasion;
/*    */ 
/*    */ import game.battle.util.DivGeneration;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.gui.misc.GButt;
/*    */ import util.text.D;
/*    */ import util.text.Dic;
/*    */ import view.main.VIEW;
/*    */ import view.ui.message.MessageSection;
/*    */ 
/*    */ 
/*    */ class Prompt
/*    */   extends MessageSection
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 20 */   static CharSequence ¤¤invasion = "¤Invasion!";
/* 21 */   static CharSequence ¤¤invasionD = "¤An enemy host stands gathered {0} of the city, preparing for an assault. They will attack at any moment. If they reach the throne, it is all over.";
/* 22 */   static CharSequence ¤¤count = "Our scouts report {0} soldiers.";
/* 23 */   static CharSequence ¤¤attack = "There is still a window of opportunity to attack them before they begin their assault. If we don't, we'll fight in the city.";
/*    */   
/*    */   static {
/* 26 */     D.ts(Prompt.class);
/*    */   }
/*    */   
/*    */   private final int men;
/*    */   private final int ref;
/*    */   private final String dir;
/*    */   
/*    */   Prompt(InvasionSpec spec, DIR dd) {
/* 34 */     super(¤¤invasion);
/*    */     
/* 36 */     this.dir = dd.getName();
/* 37 */     this.ref = spec.ref;
/* 38 */     int men = 0;
/* 39 */     for (DivGeneration g : spec.divs) {
/* 40 */       men += g.indus.length;
/*    */     }
/* 42 */     this.men = men;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void make(GuiSection section) {
/* 48 */     paragraph((CharSequence)Str.TMP.clear().add(¤¤invasionD).insert(0, this.dir));
/*    */ 
/*    */     
/* 51 */     paragraph((CharSequence)Str.TMP.clear().add(¤¤count).insert(0, this.men));
/*    */     
/* 53 */     paragraph(¤¤attack);
/*    */ 
/*    */     
/* 56 */     section.addRelBody(16, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Attack)
/*    */         {
/*    */           protected void renAction()
/*    */           {
/* 60 */             InvasionSpec sp = SETT.INVADOR().spec(Prompt.this.ref);
/* 61 */             activeSet((sp != null && sp.canBeAttacked));
/*    */           }
/*    */ 
/*    */           
/*    */           protected void clickA() {
/* 66 */             InvasionSpec sp = SETT.INVADOR().spec(Prompt.this.ref);
/* 67 */             if (sp != null && sp.canBeAttacked)
/* 68 */               (VIEW.inters()).messages.hide(); 
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Prompt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
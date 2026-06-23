/*    */ package game.faction.player.emmi;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.royalty.Royalty;
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.D;
/*    */ 
/*    */ public abstract class EmiTypeRoyOp
/*    */   extends EmiTypeRoy {
/* 14 */   private static CharSequence ¤¤target = "(target)";
/* 15 */   private static CharSequence ¤¤effective = "(effective)";
/*    */   
/*    */   static {
/* 18 */     D.ts(EmiTypeRoyOp.class);
/*    */   }
/*    */   
/*    */   EmiTypeRoyOp(SPRITE icon, CharSequence name, CharSequence desc) {
/* 22 */     super(icon, name, desc);
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(Royalty t, GUI_BOX text) {
/* 27 */     super.hover(t, text);
/* 28 */     GBox b = (GBox)text;
/* 29 */     b.NL(4);
/* 30 */     b.textLL((CharSequence)b.text().add(ROPINION.¤¤name).s().add(¤¤target));
/* 31 */     b.tab(6);
/* 32 */     b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.EMMI().opinionTarget(t, 1.0D)));
/* 33 */     b.NL();
/* 34 */     b.textLL((CharSequence)b.text().add(ROPINION.¤¤name).s().add(¤¤effective));
/* 35 */     b.tab(6);
/* 36 */     b.add((SPRITE)GFORMAT.f(b.text(), ROPINION.EMMI().opinionTarget(t, (FACTIONS.player()).emissaries.penaltyMul())));
/* 37 */     b.NL();
/* 38 */     b.textLL((CharSequence)b.text().add((ROPINION.trust()).bo.name).s().add(¤¤target));
/* 39 */     b.tab(6);
/* 40 */     b.add((SPRITE)GFORMAT.perc(b.text(), ROPINION.EMMI().trustTarget(t, 1.0D)));
/* 41 */     b.NL();
/* 42 */     b.textLL((CharSequence)b.text().add((ROPINION.trust()).bo.name).s().add(¤¤effective));
/* 43 */     b.tab(6);
/* 44 */     b.add((SPRITE)GFORMAT.perc(b.text(), ROPINION.EMMI().trustTarget(t, (FACTIONS.player()).emissaries.penaltyMul())));
/* 45 */     b.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\EmiTypeRoyOp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
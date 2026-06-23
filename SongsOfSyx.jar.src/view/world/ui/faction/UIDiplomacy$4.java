/*     */ package view.world.ui.faction;
/*     */ 
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/*  91 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/*  95 */     activeSet(!(!deal.canBeAccepted() && !(S.get()).developer));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 100 */     if (deal.canBeAccepted() || (S.get()).developer) {
/* 101 */       deal.execute(true);
/*     */     }
/* 103 */     super.clickA();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 109 */     GBox b = (GBox)text;
/* 110 */     b.text(UIDiplomacy.¤¤desc);
/*     */ 
/*     */     
/* 113 */     b.NL(8);
/* 114 */     b.textLL(Dic.¤¤Value);
/* 115 */     b.tab(6);
/* 116 */     b.add((SPRITE)(UI.icons()).s.money);
/* 117 */     b.add((SPRITE)GFORMAT.i(b.text(), (long)deal.valueCredits()));
/*     */ 
/*     */ 
/*     */     
/* 121 */     b.NL();
/* 122 */     b.textLL(ROPINION.¤¤name);
/* 123 */     b.tab(6);
/*     */     
/* 125 */     b.add((SPRITE)GFORMAT.f0(b.text(), deal.opinionChange()));
/* 126 */     GText t = b.text();
/* 127 */     t.add('(');
/* 128 */     GFORMAT.f(t, ROPINION.get(deal.npc.npc()));
/* 129 */     t.add(')');
/* 130 */     b.add((SPRITE)t);
/*     */ 
/*     */ 
/*     */     
/* 134 */     b.NL(8);
/* 135 */     if (deal.canBeAccepted()) {
/* 136 */       b.textL(UIDiplomacy.¤¤Accept);
/*     */     } else {
/* 138 */       b.error(UIDiplomacy.¤¤AcceptNo);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIDiplomacy$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
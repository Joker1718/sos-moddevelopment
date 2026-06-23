/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.settings.S;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */   ACTION yes;
/*     */   
/*     */   null(SPRITE $anonymous0) {
/* 127 */     super($anonymous0);
/*     */     
/* 129 */     this.yes = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 133 */           a.a.nobleSet();
/*     */         }
/*     */       };
/*     */   }
/*     */   protected void renAction() {
/* 138 */     activeSet(((a.a.race()).playable && a.a.noble() == null));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 143 */     if (a.a.noble() == null && (a.a.race()).playable && (
/* 144 */       (S.get()).developer || GAME.NOBLE().active().size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)FACTIONS.player()))) {
/* 145 */       (VIEW.inters()).yesNo.activate(UISubjectActions.¤¤NobleSure, this.yes, null, true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 152 */     text.title(UISubjectActions.¤¤Elevate);
/* 153 */     if (a.a.noble() != null) {
/* 154 */       text.text(UISubjectActions.¤¤NobleAlready);
/* 155 */     } else if (GAME.NOBLE().active().size() < (GAME.NOBLE()).MAX.get((BOOSTABLE_O)FACTIONS.player())) {
/* 156 */       text.text(UISubjectActions.¤¤NobleOk);
/*     */     } else {
/* 158 */       ((GBox)text).error(UISubjectActions.¤¤NobleNo);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectActions$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
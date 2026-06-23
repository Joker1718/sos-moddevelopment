/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ 
/*     */ class null
/*     */   extends GButt.Panel
/*     */ {
/*     */   null(SPRITE $anonymous0, CharSequence $anonymous1) {
/* 122 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 127 */     selectedSet((BSwap.this.current == p));
/* 128 */     activeSet(p.reqs.passes(FACTIONS.player()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 133 */     text.title(p.info.name);
/* 134 */     text.text(p.info.desc);
/* 135 */     text.NL();
/*     */     
/* 137 */     if (!p.reqs.passes(FACTIONS.player())) {
/* 138 */       p.reqs.hover(text, FACTIONS.player());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 144 */     if (p.reqs.passes(FACTIONS.player()))
/* 145 */       BSwap.this.current = p; 
/* 146 */     (VIEW.inters()).popup.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\BSwap$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
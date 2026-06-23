/*     */ package view.world.panel;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopButtL
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 199 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double valueNext() {
/* 204 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/* 209 */     return (AD.menTarget(null).faction((Faction)FACTIONS.player()) + 1.0D) / (AD.men(null).faction((Faction)FACTIONS.player()) + 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/* 214 */     return (AD.menTarget(null).faction((Faction)FACTIONS.player()) > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/* 219 */     return AD.menTarget(null).faction((Faction)FACTIONS.player());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 224 */     selectedSet((VIEW.world()).UI.armies.listIsOpen((VIEW.world()).panels));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 229 */     if ((VIEW.world()).UI.armies.listIsOpen((VIEW.world()).panels))
/* 230 */       (VIEW.world()).UI.armies.close((VIEW.world()).panels); 
/* 231 */     (VIEW.world()).UI.armies.openList(null, (VIEW.world()).panels);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 236 */     GBox b = (GBox)text;
/* 237 */     b.title(Dic.¤¤Armies);
/*     */ 
/*     */     
/* 240 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIPanelTopWorld$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
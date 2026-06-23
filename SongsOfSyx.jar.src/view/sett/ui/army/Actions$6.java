/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 226 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 230 */     if (hardProblem((LIST<Div>)list) != null)
/*     */       return; 
/* 232 */     for (Div div : list) {
/* 233 */       if (AD.cityDivs().attachedArmy(div) != null) {
/* 234 */         AD.cityDivs().attach(null, div);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 241 */     isActive = can();
/* 242 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 247 */     GBox b = (GBox)text;
/*     */     
/* 249 */     b.title(Actions.¤¤Recall);
/* 250 */     b.text(Actions.¤¤RecallD);
/* 251 */     b.NL(8);
/*     */     
/* 253 */     if (!can()) {
/* 254 */       b.error(Actions.¤¤RecallProblem);
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean can() {
/* 259 */     if (list.size() == 0)
/* 260 */       return false; 
/* 261 */     for (Div div : list) {
/* 262 */       if (AD.cityDivs().attachedArmy(div) != null) {
/* 263 */         return true;
/*     */       }
/*     */     } 
/* 266 */     return false;
/*     */   }
/*     */   
/*     */   public CharSequence hardProblem(LIST<Div> divs) {
/* 270 */     if (divs.size() == 0)
/* 271 */       return Actions.¤¤NoDivs; 
/* 272 */     if (AD.army((Faction)FACTIONS.player()).all().size() <= 0)
/* 273 */       return Actions.¤¤NoArmies; 
/* 274 */     for (Div div : divs) {
/* 275 */       if (AD.cityDivs().attachedArmy(div) != null)
/* 276 */         return null; 
/*     */     } 
/* 278 */     return Actions.¤¤NoValid;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
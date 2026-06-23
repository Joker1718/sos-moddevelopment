/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final Edit edit;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 111 */     super($anonymous0);
/*     */     
/* 113 */     this.edit = new Edit();
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 117 */     for (int di = 0; di < list.size(); di++) {
/* 118 */       if (AD.cityDivs().attachedArmy((Div)list.get(di)) != null) {
/* 119 */         list.remove(di);
/* 120 */         di--;
/*     */       } 
/*     */     } 
/* 123 */     if (list.size() > 0) {
/* 124 */       (VIEW.inters()).popup.show((RENDEROBJ)this.edit.get((LIST<Div>)list, (CLICKABLE)this), (CLICKABLE)this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 130 */     isActive = false;
/* 131 */     for (Div d : list) {
/* 132 */       if (AD.cityDivs().attachedArmy(d) == null)
/* 133 */         isActive = true; 
/*     */     } 
/* 135 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
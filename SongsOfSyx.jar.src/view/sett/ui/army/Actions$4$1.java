/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerArmy;
/*     */ import view.main.VIEW;
/*     */ import view.ui.div.UIDivCardWorld;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPickerArmy
/*     */ {
/*     */   protected void pick(WArmy a) {
/* 150 */     for (Div div : list) {
/* 151 */       if (a.divs().canAdd() && AD.cityDivs().attachedArmy(div) == null && UIDivCardWorld.supplyError((DIV_SIMPLE)div) == null) {
/* 152 */         AD.cityDivs().attach(a, div);
/*     */       }
/*     */     } 
/* 155 */     (VIEW.inters()).popup.close();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean canBePicked(WArmy a) {
/* 160 */     if (a == null)
/* 161 */       return false; 
/* 162 */     return a.divs().canAdd();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$4$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package view.sett.ui.army;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SIMPLE;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerArmy;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   UIPickerArmy p;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 144 */     super($anonymous0);
/*     */     
/* 146 */     this.p = new UIPickerArmy((GETTER)new GETTER.GETTER_IMP(FACTIONS.player()), 400)
/*     */       {
/*     */         protected void pick(WArmy a)
/*     */         {
/* 150 */           for (Div div : list) {
/* 151 */             if (a.divs().canAdd() && AD.cityDivs().attachedArmy(div) == null && UIDivCardWorld.supplyError((DIV_SIMPLE)div) == null) {
/* 152 */               AD.cityDivs().attach(a, div);
/*     */             }
/*     */           } 
/* 155 */           (VIEW.inters()).popup.close();
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean canBePicked(WArmy a) {
/* 160 */           if (a == null)
/* 161 */             return false; 
/* 162 */           return a.divs().canAdd();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   protected void clickA() {
/* 168 */     if (Actions.sendProblem((LIST<Div>)list) != null) {
/*     */       return;
/*     */     }
/* 171 */     (VIEW.inters()).popup.show((RENDEROBJ)this.p, (CLICKABLE)this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 177 */     isActive = (Actions.sendProblem((LIST<Div>)list) == null);
/* 178 */     super.render(r, ds, isActive, isSelected, isHovered);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 188 */     GBox b = (GBox)text;
/*     */     
/* 190 */     b.title(Actions.¤¤SendOut);
/* 191 */     b.text(Actions.¤¤SendOutD);
/*     */     
/* 193 */     b.NL(8);
/*     */     
/* 195 */     Actions.hoverSendOutProblem((LIST<Div>)list, (GUI_BOX)b);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\army\Actions$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
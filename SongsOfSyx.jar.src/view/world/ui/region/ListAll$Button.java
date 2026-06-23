/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FBanner;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Button
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   Button(GETTER<Integer> ier) {
/* 149 */     this.ier = ier;
/* 150 */     this.body.setWidth(400.0D);
/* 151 */     this.body.setHeight(30.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 161 */     Region reg = (Region)ListAll.this.sorter.get(this.ier);
/* 162 */     (VIEW.world()).window.centererTile.set(reg.cx(), reg.cy());
/* 163 */     ISidePanel p = (VIEW.world()).UI.regions.get(reg);
/* 164 */     (VIEW.world()).panels.add(ListAll.this, true);
/* 165 */     (VIEW.world()).panels.add(p, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 171 */     Region f = (Region)ListAll.this.sorter.get(this.ier);
/* 172 */     selectedSet((VIEW.world()).UI.regions.active(f));
/* 173 */     GCOLOR.UI().border().render(r, (RECTANGLE)body());
/*     */     
/* 175 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 177 */     COLOR col = COLOR.WHITE85;
/* 178 */     if (f.faction() == null) {
/* 179 */       FBanner.rebel.MEDIUM.renderCY(r, 8, body().cY());
/*     */     } else {
/* 181 */       (f.faction().banner()).MEDIUM.renderCY(r, 8, body().cY());
/* 182 */       if (f.capitol()) {
/* 183 */         (UI.icons()).s.crown.renderCY(r, 6, this.body.cY() - 8);
/*     */       }
/* 185 */       if (f.faction() == null) {
/* 186 */         col = (GCOLOR.T()).INORMAL;
/*     */       }
/* 188 */       else if (DIP.WAR().is((Faction)FACTIONS.player(), f.faction())) {
/* 189 */         col = (GCOLOR.T()).IBAD;
/*     */       } else {
/* 191 */         col = (GCOLOR.T()).IGOOD;
/*     */       } 
/*     */     } 
/*     */     
/* 195 */     ListAll.this.textH.clear();
/* 196 */     ListAll.this.textH.color(col);
/* 197 */     ListAll.this.textH.add((CharSequence)f.info.name());
/* 198 */     ListAll.this.textH.setMaxWidth(340);
/* 199 */     ListAll.this.textH.setMultipleLines(false);
/*     */     
/* 201 */     ListAll.this.textH.renderCY(r, 40, body().cY());
/*     */     
/* 203 */     ListAll.this.textS.clear();
/* 204 */     GFORMAT.i(ListAll.this.textS, (RD.RACES()).population.get(f));
/* 205 */     ListAll.this.textS.adjustWidth();
/* 206 */     ListAll.this.textS.renderCY(r, this.body.x2() - 8 - ListAll.this.textS.width(), this.body.cY());
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 211 */     Region f = (Region)ListAll.this.sorter.get(this.ier);
/* 212 */     (VIEW.world()).UI.regions.hover(f, text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\ListAll$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.settings.S;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuilding;
/*     */ import world.region.building.RDBuildingLevel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class LevelButt
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private final RDBuilding bu;
/*     */   private final int level;
/*     */   
/*     */   LevelButt(RDBuilding b, int level) {
/* 165 */     this.body.setDim(128.0D, 40.0D);
/* 166 */     this.bu = b;
/* 167 */     this.level = level;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 172 */     GCOLOR.UI().border().render(r, (RECTANGLE)this.body, -1);
/*     */     
/* 174 */     if (RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) == this.level) {
/* 175 */       COLOR.WHITE100.render(r, (RECTANGLE)this.body, -2);
/* 176 */       GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -4);
/*     */     } else {
/* 178 */       GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, -2);
/*     */     } 
/*     */     
/* 181 */     ((RDBuildingLevel)this.bu.levels().get(this.level)).icon.big.renderCY(r, body().x1() + 8, body().cY());
/* 182 */     PlayBuildingsPop.this.num.clear();
/* 183 */     PlayBuildingsPop.this.num.color(COLOR.WHITE100);
/* 184 */     GFORMAT.toNumeral(PlayBuildingsPop.this.num, this.level);
/* 185 */     PlayBuildingsPop.this.num.renderCY(r, body().x1() + 48, this.body.cY());
/*     */     
/* 187 */     if (this.level > RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()) && 
/* 188 */       RD.BUILDINGS().tmp().canAfford(this.bu, (Region)PlayBuildingsPop.this.g.get(), this.level) != null) {
/* 189 */       OPACITY.O50.bind();
/* 190 */       COLOR.BLACK.render(r, (RECTANGLE)this.body, -1);
/* 191 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 200 */     Region reg = (Region)PlayBuildingsPop.this.g.get();
/* 201 */     GBox b = (GBox)text;
/* 202 */     b.title(((RDBuildingLevel)this.bu.levels().get(this.level)).name);
/* 203 */     if (this.level == 0) {
/*     */       return;
/*     */     }
/* 206 */     CharSequence prob = this.bu.canAfford(reg, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level);
/* 207 */     if (prob != null)
/* 208 */       b.error(prob); 
/* 209 */     b.NL();
/*     */     
/* 211 */     b.text(this.bu.info.desc);
/*     */     
/* 213 */     b.sep();
/* 214 */     for (int i = this.level; i > 0; i--) {
/* 215 */       if (((RDBuildingLevel)this.bu.levels().get(i)).reqs.hover(text, reg)) {
/* 216 */         b.sep();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 222 */     PlayBuildingsPop.hoverCosts(reg, this.bu, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level, text);
/* 223 */     PlayBuildingsPop.this.hoverNonCosts(reg, this.bu, RD.BUILDINGS().tmp().level(this.bu, (Region)PlayBuildingsPop.this.g.get()), this.level, text);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 231 */     if ((S.get()).developer || RD.BUILDINGS().tmp().canAfford(this.bu, (Region)PlayBuildingsPop.this.g.get(), this.level) == null) {
/*     */       
/* 233 */       RD.BUILDINGS().tmp().levelSet(this.bu, this.level);
/*     */ 
/*     */ 
/*     */       
/* 237 */       (VIEW.inters()).popup.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildingsPop$LevelButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
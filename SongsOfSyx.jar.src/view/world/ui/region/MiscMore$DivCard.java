/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import view.main.VIEW;
/*     */ import world.army.WDIV;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DivCard
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   private final int di;
/*     */   private final GETTER.GETTER_IMP<Region> g;
/*     */   
/*     */   DivCard(int di, GETTER.GETTER_IMP<Region> g) {
/* 152 */     super(24, 24);
/* 153 */     this.g = g;
/* 154 */     this.di = di;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 159 */     LIST<WDIV> divs = RD.MILITARY().divisions((Region)this.g.get());
/*     */     
/* 161 */     if (this.di < divs.size()) {
/* 162 */       WDIV d = (WDIV)divs.get(this.di);
/* 163 */       (d.race().appearance()).icon.render(r, (RECTANGLE)this.body);
/* 164 */       int width = (int)((body().width() * d.menTarget()) / (Config.battle()).MEN_PER_DIVISION);
/* 165 */       double dd = d.men() / d.menTarget();
/* 166 */       GMeter.render(r, GMeter.C_REDGREEN, dd, this.body.x1(), this.body.x1() + width, this.body.y2() - 8, this.body.y2());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 173 */     GBox b = (GBox)text;
/* 174 */     LIST<WDIV> divs = RD.MILITARY().divisions((Region)this.g.get());
/*     */     
/* 176 */     if (this.di < divs.size()) {
/* 177 */       WDIV d = (WDIV)divs.get(this.di);
/* 178 */       (VIEW.UI()).div.world.hover(d, (GUI_BOX)b);
/*     */     } 
/*     */ 
/*     */     
/* 182 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscMore$DivCard.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
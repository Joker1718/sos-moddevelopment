/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   WRegFinder wr;
/*     */   
/*     */   null(int $anonymous0, int $anonymous1) {
/* 241 */     super($anonymous0, $anonymous1);
/*     */     
/* 243 */     this.wr = new WRegFinder();
/*     */   }
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 246 */     COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/* 247 */     LIST<WRegFinder.RegDist> dists = this.wr.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY((Region)g.get()));
/*     */     
/* 249 */     if (dists.size() > 0) {
/* 250 */       int dd = AM * DIM / dists.size();
/* 251 */       dd = CLAMP.i(dd, 1, 16);
/* 252 */       int x1 = this.body.x1();
/* 253 */       for (WRegFinder.RegDist d : dists) {
/* 254 */         COLOR c = (d.reg.faction() == null) ? COLOR.WHITE50 : (COLOR)d.reg.faction().banner().colorBG();
/* 255 */         c.bind();
/* 256 */         (UI.icons()).s.capitol.renderCY(r, x1, this.body.cY());
/* 257 */         x1 += dd;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 265 */     GBox b = (GBox)text;
/* 266 */     b.text(Dic.¤¤Distance);
/* 267 */     b.NL();
/* 268 */     for (WRegFinder.RegDist r : this.wr.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY((Region)g.get()))) {
/* 269 */       GText n = b.text();
/* 270 */       COLOR c = (r.reg.faction() == null) ? COLOR.WHITE50 : (COLOR)r.reg.faction().banner().colorBG();
/* 271 */       n.color(c);
/* 272 */       n.add((CharSequence)r.reg.info.name());
/*     */       
/* 274 */       b.add((SPRITE)n);
/* 275 */       b.tab(6);
/* 276 */       b.add((SPRITE)(SPRITES.icons()).s.arrow_right);
/* 277 */       b.add((SPRITE)GFORMAT.i(b.text(), r.distance));
/* 278 */       if (r.water) {
/* 279 */         b.tab(8);
/* 280 */         b.add((SPRITE)(SPRITES.icons()).s.ship);
/*     */       } 
/* 282 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscBasics$10.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
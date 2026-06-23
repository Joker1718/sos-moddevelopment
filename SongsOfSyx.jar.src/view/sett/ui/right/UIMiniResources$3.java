/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GuiSection
/*     */ {
/* 250 */   int wI = 0;
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 254 */     res.hoverDetailed(text);
/* 255 */     GBox b = (GBox)text;
/* 256 */     b.sep();
/* 257 */     b.text(UIMiniResources.¤¤desc);
/*     */     
/* 259 */     super.hoverInfoGet(text);
/*     */   }
/* 261 */   int ri = 0;
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 265 */     double a = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res);
/* 266 */     double c = ((SETT.ROOMS()).STOCKPILE.tally()).space.total(res);
/* 267 */     double d = 0.0D;
/* 268 */     if (c > 0.0D)
/* 269 */       d = a / c; 
/* 270 */     if (d > 0.9D) {
/* 271 */       GMeter.render(r, GMeter.C_REDPURPLE, d, (RECTANGLE)body());
/* 272 */     } else if (c > 0.0D) {
/* 273 */       GMeter.render(r, GMeter.C_REDGREEN, d, (RECTANGLE)body());
/*     */     } else {
/* 275 */       GMeter.render(r, GMeter.C_INACTIVE, d, (RECTANGLE)body());
/*     */     } 
/* 277 */     if ((SETT.ROOMS()).IMPORT.tally.capacity.get(res) > 0) {
/* 278 */       d = (FACTIONS.player().buyer(res.tr())).limit.getD();
/* 279 */       if (d > 0.0D) {
/* 280 */         int x1 = (int)(body().x1() + d * (body().width() - 2));
/* 281 */         COLOR.WHITE85.render(r, x1, x1 + 1, body().y1(), body().y2());
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 287 */     if (!hoveredIs()) {
/* 288 */       OPACITY.O25.bind();
/* 289 */       COLOR.BLACK.render(r, (RECTANGLE)body(), -1);
/* 290 */       OPACITY.unbind();
/*     */     } 
/*     */ 
/*     */     
/* 294 */     if (Math.abs(this.ri - VIEW.RI()) <= 1 && hoveredIs() && 
/* 295 */       MButt.RIGHT.consumeClick())
/*     */     {
/* 297 */       for (int i = 0; i < (SETT.ROOMS()).STOCKPILE.instancesSize(); i++) {
/* 298 */         this.wI++;
/* 299 */         if (this.wI >= (SETT.ROOMS()).STOCKPILE.instancesSize()) {
/* 300 */           this.wI = 0;
/*     */         }
/* 302 */         RoomInstance ins = (SETT.ROOMS()).STOCKPILE.getInstance(this.wI, res);
/*     */         
/* 304 */         if (ins != null) {
/* 305 */           (VIEW.s().getWindow()).centererTile.set(ins.body().cX(), ins.body().cY());
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 312 */     this.ri = VIEW.RI();
/* 313 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 319 */     (VIEW.UI()).goods.detail(res, (Faction)GAME.player());
/* 320 */     return super.click();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniResources$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
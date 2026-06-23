/*     */ package settlement.room.military.supply;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 201 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 205 */     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/*     */     
/* 207 */     res.icon().renderC(r, this.body.cX(), this.body.cY() - 8);
/* 208 */     text.clear();
/* 209 */     GFORMAT.i(text, ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.amount.get((SupplyInstance)g.get(), res));
/* 210 */     text.adjustWidth();
/* 211 */     text.renderC(r, this.body.cX(), this.body.cY() + 12);
/* 212 */     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 218 */     selectedSet(((SupplyInstance)g.get()).allowed().has(res));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 223 */     ((SupplyInstance)g.get()).allowedToggle(res);
/* 224 */     ((SupplyInstance)g.get()).reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 229 */     GBox b = (GBox)text;
/* 230 */     b.title(res.name);
/*     */ 
/*     */ 
/*     */     
/* 234 */     b.textLL(Gui.¤¤underway);
/* 235 */     b.tab(7);
/* 236 */     b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.spaceReserved.get((SupplyInstance)g.get(), res) + ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.amount.get((SupplyInstance)g.get(), res))));
/* 237 */     b.NL();
/*     */     
/* 239 */     b.textLL(Gui.¤¤ready);
/* 240 */     b.tab(7);
/* 241 */     b.add((SPRITE)GFORMAT.i(b.text(), Gui.this.ready(res, (SupplyInstance)g.get())));
/* 242 */     b.sep();
/*     */     
/* 244 */     Gui.this.hoverNeeded(b, res);
/*     */     
/* 246 */     if ((S.get()).developer) {
/* 247 */       b.add((SPRITE)(UI.icons()).s.storage);
/* 248 */       b.tab(7);
/* 249 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.capacity((SupplyInstance)g.get(), res, ((SupplyInstance)g.get()).allowed())));
/* 250 */       b.NL();
/*     */ 
/*     */       
/* 253 */       b.add((SPRITE)(UI.icons()).s.allRight);
/* 254 */       b.tab(7);
/* 255 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.access$2(Gui.this)).cache.deliverable(res)));
/* 256 */       b.NL();
/*     */       
/* 258 */       b.NL(8);
/*     */       
/* 260 */       b.textL(Dic.¤¤Needed);
/* 261 */       b.add((SPRITE)GFORMAT.i(b.text(), ((ROOM_SUPPLY)Gui.access$2(Gui.this)).cache.needed(res)));
/* 262 */       b.NL();
/* 263 */       b.add((SPRITE)(UI.icons()).s.allRight);
/* 264 */       b.add((SPRITE)GFORMAT.bool(b.text(), ((SupplyInstance)g.get()).moveOrderPullAvailable().has(res)));
/* 265 */       b.NL();
/*     */       
/* 267 */       b.NL(8);
/*     */       
/* 269 */       for (SupplyTally.TallyData d : ((ROOM_SUPPLY)Gui.access$2(Gui.this)).tally.datas) {
/* 270 */         b.textLL(d.name);
/* 271 */         b.tab(7);
/* 272 */         b.add((SPRITE)GFORMAT.i(b.text(), d.get((SupplyInstance)g.get(), res)));
/* 273 */         b.tab(10);
/* 274 */         b.add((SPRITE)GFORMAT.i(b.text(), d.total(res)));
/* 275 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\supply\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
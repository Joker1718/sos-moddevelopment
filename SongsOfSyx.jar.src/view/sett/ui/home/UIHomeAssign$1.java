/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HGROUP;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 191 */     RenderData.RenderIterator it = data.onScreenTiles();
/* 192 */     while (it.has()) {
/* 193 */       ROOMA h = UIHomeAssign.this.room(it.tx(), it.ty());
/* 194 */       if (h != null && h.body().cX() == it.tx() && h.body().cY() == it.ty())
/*     */       {
/* 196 */         render(r, h, UIHomeAssign.this.availability(it.tx(), it.ty()), it);
/*     */       }
/* 198 */       it.next();
/*     */     } 
/* 200 */     remove();
/*     */   }
/*     */   
/* 203 */   private final ArrayList<HGROUP> rens = new ArrayList(HGROUP.all().size());
/*     */ 
/*     */   
/*     */   private void render(Renderer r, ROOMA h, HGROUP.HTypeBits t, RenderData.RenderIterator it) {
/* 207 */     double dx = h.body().x1() + h.body().width() * 0.5D;
/* 208 */     dx -= h.body().x1();
/* 209 */     int cx = it.x() - 32;
/*     */     
/* 211 */     double dy = h.body().y1() + h.body().height() * 0.5D;
/* 212 */     dy -= h.body().y1();
/* 213 */     int cy = it.y() - 32;
/*     */ 
/*     */     
/* 216 */     int am = 0;
/* 217 */     HGROUP single = null;
/* 218 */     for (HGROUP hh : HGROUP.all()) {
/* 219 */       if (t.is(hh)) {
/* 220 */         single = hh;
/* 221 */         am++;
/*     */       } 
/*     */     } 
/*     */     
/* 225 */     if (am == HGROUP.all().size()) {
/* 226 */       renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.questionmark);
/* 227 */     } else if (am == 0) {
/* 228 */       renderSingle(r, cx, cy, (SPRITE)(UI.icons()).m.cancel);
/* 229 */     } else if (am == 1) {
/* 230 */       renderSingle(r, cx, cy, single.icon);
/* 231 */     } else if (am < HGROUP.all().size() / 2) {
/* 232 */       this.rens.clearSloppy();
/* 233 */       for (HGROUP hh : HGROUP.all()) {
/* 234 */         if (t.is(hh)) {
/* 235 */           this.rens.add(hh);
/*     */         }
/*     */       } 
/* 238 */       renderMany(r, cx, cy, h, false);
/*     */     } else {
/* 240 */       this.rens.clearSloppy();
/* 241 */       for (HGROUP hh : HGROUP.all()) {
/* 242 */         if (!t.is(hh)) {
/* 243 */           this.rens.add(hh);
/*     */         }
/*     */       } 
/* 246 */       if (this.rens.size() > 0)
/* 247 */         renderMany(r, cx, cy, h, true); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderSingle(Renderer r, int cx, int cy, SPRITE icon) {
/* 252 */     int w = icon.width() * 4;
/* 253 */     int h = icon.height() * 4;
/* 254 */     int x1 = cx - w / 2;
/* 255 */     int y1 = cy - h / 2;
/* 256 */     icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderMany(Renderer r, int cx, int cy, ROOMA house, boolean anti) {
/* 261 */     int width = house.body().width() * 64;
/* 262 */     int w = 48;
/* 263 */     int h = ((HGROUP)this.rens.get(0)).icon.height() * 4 / 2;
/*     */     
/* 265 */     int dx = width / this.rens.size();
/* 266 */     dx = CLAMP.i(dx, 1, w);
/*     */     
/* 268 */     int x1 = cx - dx * this.rens.size() / 2;
/* 269 */     int y1 = cy - h;
/*     */     
/* 271 */     for (HGROUP t : this.rens) {
/* 272 */       t.icon.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h);
/* 273 */       if (anti)
/* 274 */         (UI.icons()).m.anti.render((SPRITE_RENDERER)r, x1, x1 + w, y1, y1 + h); 
/* 275 */       x1 += dx;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomeAssign$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
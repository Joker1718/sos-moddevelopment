/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.player.PCredits;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Losses
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   Losses() {
/* 211 */     this.body.setWidth((paramMainChart.w * paramMainChart.am));
/* 212 */     body().setHeight(112.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 218 */     GCOLOR.UI().border().render(r, (RECTANGLE)body(), 1);
/*     */     
/* 220 */     for (int x = 0; x < MainChart.this.am; x++) {
/*     */       
/* 222 */       int x1 = body().x1() + MainChart.this.w * x;
/*     */ 
/*     */ 
/*     */       
/* 226 */       if (x != MainChart.this.hi.get()) {
/* 227 */         GCOLOR.UI().bg().render(r, x1, x1 + MainChart.this.w, body().y1(), body().y2());
/*     */       }
/*     */       
/* 230 */       if (MainChart.this.maxout != 0.0D) {
/*     */ 
/*     */         
/* 233 */         int si = MainChart.this.am - x - 1;
/*     */         
/* 235 */         int y1 = body().y1();
/* 236 */         for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*     */           
/* 238 */           double d = h.OUT.get(si) / MainChart.this.maxout;
/* 239 */           int hig = (int)Math.ceil(body().height() * d);
/* 240 */           ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(h.type.ordinal()));
/* 241 */           if (x == MainChart.this.hi.get()) {
/* 242 */             ColorImp.TMP.shadeSelf(1.5D);
/*     */           } else {
/* 244 */             ColorImp.TMP.shadeSelf(0.5D);
/*     */           } 
/* 246 */           ColorImp.TMP.render(r, x1, x1 + MainChart.this.w, y1, y1 + hig);
/*     */           
/* 248 */           if (hig > 1)
/* 249 */             ((COLOR)COLOR.UNIQUE.getC(h.type.ordinal())).render(r, x1 + 1, x1 + MainChart.this.w - 1, y1 - 1, y1 + hig); 
/* 250 */           if (hig > 0)
/* 251 */             hig--; 
/* 252 */           y1 += hig;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 263 */     if (super.hover(mCoo)) {
/* 264 */       int ii = (mCoo.x() - body().x1()) / MainChart.this.w;
/* 265 */       if (ii < MainChart.this.am)
/* 266 */         MainChart.this.hi.set(ii); 
/* 267 */       return true;
/*     */     } 
/* 269 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainChart$Losses.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
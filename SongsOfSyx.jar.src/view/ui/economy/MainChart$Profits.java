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
/*     */ final class Profits
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   Profits() {
/* 145 */     this.body.setWidth((paramMainChart.w * paramMainChart.am));
/* 146 */     body().setHeight(112.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 152 */     GCOLOR.UI().border().render(r, (RECTANGLE)body(), 1);
/*     */     
/* 154 */     for (int x = 0; x < MainChart.this.am; x++) {
/*     */       
/* 156 */       int x1 = body().x1() + MainChart.this.w * x;
/*     */ 
/*     */ 
/*     */       
/* 160 */       if (x != MainChart.this.hi.get()) {
/* 161 */         GCOLOR.UI().bg().render(r, x1, x1 + MainChart.this.w, body().y1(), body().y2());
/*     */       }
/*     */       
/* 164 */       if (MainChart.this.maxin != 0.0D) {
/*     */ 
/*     */         
/* 167 */         int si = MainChart.this.am - x - 1;
/*     */         
/* 169 */         int y2 = body().y2();
/* 170 */         for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*     */           
/* 172 */           double d = h.IN.get(si) / MainChart.this.maxin;
/* 173 */           int hig = (int)Math.ceil(body().height() * d);
/* 174 */           ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(h.type.ordinal()));
/* 175 */           if (x == MainChart.this.hi.get()) {
/* 176 */             ColorImp.TMP.shadeSelf(1.5D);
/*     */           } else {
/* 178 */             ColorImp.TMP.shadeSelf(0.5D);
/*     */           } 
/* 180 */           ColorImp.TMP.render(r, x1, x1 + MainChart.this.w, y2 - hig, y2);
/*     */           
/* 182 */           if (hig > 1)
/* 183 */             ((COLOR)COLOR.UNIQUE.getC(h.type.ordinal())).render(r, x1 + 1, x1 + MainChart.this.w - 1, y2 - hig + 1, y2); 
/* 184 */           if (hig > 0)
/* 185 */             hig--; 
/* 186 */           y2 -= hig;
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
/* 197 */     if (super.hover(mCoo)) {
/* 198 */       int ii = (mCoo.x() - body().x1()) / MainChart.this.w;
/* 199 */       if (ii < MainChart.this.am)
/* 200 */         MainChart.this.hi.set(ii); 
/* 201 */       return true;
/*     */     } 
/* 203 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainChart$Profits.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
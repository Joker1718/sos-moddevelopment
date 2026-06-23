/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Column
/*     */   extends GuiSection
/*     */ {
/*     */   private final int pp;
/*     */   private final SPRITE icon;
/*     */   int cards;
/* 136 */   int height = 0;
/*     */   
/*     */   Column(int prio, SPRITE icon) {
/* 139 */     this.pp = prio;
/* 140 */     body().setDim(paramUIBuckets.WIDTH, paramUIBuckets.HEIGHT);
/* 141 */     this.icon = icon;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 147 */     boolean hov = ((hoveredIs() & ((UIBuckets.this.dragging != null) ? 1 : 0)) != 0 && UIBuckets.this.dragging.prio != this.pp);
/*     */     
/* 149 */     if (hov)
/* 150 */       UIBuckets.this.draggingTo = this; 
/* 151 */     GButt.ButtPanel.renderBG(r, true, hov, hov, (RECTANGLE)body());
/*     */     
/* 153 */     GCOLOR.UI().border().renderFrame(r, (RECTANGLE)body(), 0, 1);
/* 154 */     super.render(r, ds);
/* 155 */     this.icon.renderC(r, body().x1() + 16, body().cY());
/*     */   }
/*     */ 
/*     */   
/*     */   void init(ArrayList<UIBuckets.Card> cards) {
/* 160 */     int am = 0;
/* 161 */     for (UIBuckets.Card c : cards) {
/* 162 */       if (!UIBuckets.this.isActive(c.g))
/*     */         continue; 
/* 164 */       if (c.g.prio == this.pp) {
/* 165 */         am++;
/*     */       }
/*     */     } 
/*     */     
/* 169 */     int x1 = body().x1();
/* 170 */     int y1 = body().y1();
/*     */     
/* 172 */     clear();
/* 173 */     body().setDim(UIBuckets.this.WIDTH, (UIBuckets.this.HEIGHT + this.height * 32));
/*     */     
/* 175 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 178 */     int WW = UIBuckets.this.WIDTH - 32;
/*     */     
/* 180 */     int dist = (this.height + 1) * (WW - ((UIBuckets.Card)cards.get(0)).body.width()) / am;
/* 181 */     if (dist > ((UIBuckets.Card)cards.get(0)).body.width()) {
/* 182 */       dist = ((UIBuckets.Card)cards.get(0)).body.width();
/*     */     }
/*     */ 
/*     */     
/* 186 */     int sy = body().y1() + 8;
/* 187 */     int sx = body().x1() + 32;
/*     */ 
/*     */ 
/*     */     
/* 191 */     for (UIBuckets.Card c : cards) {
/* 192 */       if (!UIBuckets.this.isActive(c.g))
/*     */         continue; 
/* 194 */       if (c.g.prio == this.pp) {
/* 195 */         add((RENDEROBJ)c, sx, sy);
/* 196 */         sx += dist;
/* 197 */         if (sx + ((UIBuckets.Card)cards.get(0)).body.width() + 8 > body().x2()) {
/* 198 */           sy += 32;
/* 199 */           sx = body().x1() + 32;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     body().moveX1Y1(x1, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 209 */     GBox b = (GBox)text;
/* 210 */     super.hoverInfoGet((GUI_BOX)b);
/* 211 */     if (b.emptyIs())
/* 212 */       UIBuckets.this.hoverBucket(b, this.pp); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\UIBuckets$Column.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package view.ui.goods;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StorageDiagram
/*     */   extends GStaples
/*     */ {
/*     */   private final GETTER<RESOURCE> res;
/*     */   
/* 178 */   private GStat t = (new GStat()
/*     */     {
/*     */       public void update(GText text)
/*     */       {
/* 182 */         GFORMAT.iofkNoColor(text, (SETT.ROOMS()).STOCKPILE.tally().amountTotal((RESOURCE)Row.StorageDiagram.this.res.get()), ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)Row.StorageDiagram.this.res.get()));
/*     */       }
/* 184 */     }).bg();
/*     */   
/*     */   StorageDiagram(GETTER<RESOURCE> res) {
/* 187 */     super(Row.amount);
/* 188 */     this.res = res;
/* 189 */     body().setWidth((5 * Row.amount)).setHeight(60.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 195 */     super.render(r, ds, hoveredIs());
/* 196 */     this.t.render(r, body().x1() + 5, body().y1() + 2);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 201 */     double c = ((SETT.ROOMS()).STOCKPILE.tally()).space.total((RESOURCE)this.res.get());
/* 202 */     double d = (SETT.ROOMS()).STOCKPILE.tally().amountsDay().history((MAPPED)this.res.get()).get(Row.amount - 1 - stapleI);
/* 203 */     if (c == 0.0D) {
/* 204 */       d = ((d > 0.0D) ? true : false);
/*     */     } else {
/* 206 */       d /= c;
/*     */     } 
/* 208 */     d = CLAMP.d(d, 0.0D, 1.0D);
/* 209 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setColor(ColorImp c, int x, double value) {
/* 220 */     c.set((GCOLOR.UI()).SOSO.normal);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\Row$StorageDiagram.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
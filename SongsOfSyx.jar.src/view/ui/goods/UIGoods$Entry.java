/*     */ package view.ui.goods;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.text.Dic;
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
/*     */ class Entry
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   private final GETTER<RESOURCE> res;
/*     */   private final int off;
/*     */   
/*     */   Entry(final GETTER<Integer> ier, final int off, Pop pop) {
/* 150 */     this.off = off;
/* 151 */     this.ier = ier;
/* 152 */     this.res = new GETTER<RESOURCE>()
/*     */       {
/*     */         public RESOURCE get()
/*     */         {
/* 156 */           int i = ((Integer)ier.get()).intValue() * 2 + off;
/* 157 */           if (i >= (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.size() || (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i) == null || (UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i) == (UIGoods.Entry.access$0(UIGoods.Entry.this)).icon)
/* 158 */             return null; 
/* 159 */           return (RESOURCE)(UIGoods.Entry.access$0(UIGoods.Entry.this)).all.get(i);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 165 */     addRightCAbs(56, (RENDEROBJ)new Row(this.res, pop));
/*     */ 
/*     */ 
/*     */     
/* 169 */     addRelBody(2, DIR.S, (RENDEROBJ)new RENDEROBJ.RenderImp(body().width(), 6)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 173 */             GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().cY(), body().cY() + 1);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     pad(6, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER rr, float ds) {
/* 187 */     int i = ((Integer)this.ier.get()).intValue() * 2 + this.off;
/* 188 */     if (i >= UIGoods.this.all.size() || UIGoods.this.all.get(i) == UIGoods.this.icon) {
/*     */       return;
/*     */     }
/* 191 */     if (this.res.get() != null && UIGoods.this.flashRes == this.res.get() && VIEW.renderSecond() - UIGoods.this.flashTime < 3.0D) {
/* 192 */       COLOR.WHITE2WHITE.render(rr, (RECTANGLE)body(), -1);
/*     */     
/*     */     }
/* 195 */     else if (hoveredIs()) {
/* 196 */       OPACITY.O012.bind();
/* 197 */       COLOR.WHITE100.render(rr, (RECTANGLE)body(), -1);
/* 198 */       OPACITY.unbind();
/*     */     } 
/* 200 */     super.render(rr, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 205 */     text.title((this.res.get() == null) ? Dic.¤¤Total : ((RESOURCE)this.res.get()).name);
/* 206 */     super.hoverInfoGet(text);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 211 */     int i = ((Integer)this.ier.get()).intValue() * 2 + this.off;
/* 212 */     if (i >= UIGoods.this.all.size() || UIGoods.this.all.get(i) == UIGoods.this.icon)
/* 213 */       return false; 
/* 214 */     return super.hover(mCoo);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\goods\UIGoods$Entry.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
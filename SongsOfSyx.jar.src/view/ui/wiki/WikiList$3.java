/*     */ package view.ui.wiki;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
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
/*     */ class null
/*     */   extends GTableBuilder.GRowBuilder
/*     */ {
/*     */   public RENDEROBJ build(final GETTER<Integer> ier) {
/*  87 */     return (RENDEROBJ)new CLICKABLE.ClickableAbs(368, 38)
/*     */       {
/*     */         GText tt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  96 */           Article e = (Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue());
/*  97 */           if (e == null) {
/*  98 */             this.tt.setFont((UI.FONT()).H2);
/*  99 */             this.tt.lablify();
/* 100 */             this.tt.set(((Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue() + 1)).category);
/* 101 */             this.tt.renderCY(r, body().x1() + 8, body().cY());
/*     */           } else {
/* 103 */             isSelected |= (VIEW.UI()).wiki.added().contains(e);
/* 104 */             GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 105 */             GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 106 */             this.tt.setFont((UI.FONT()).M);
/* 107 */             this.tt.normalify2();
/* 108 */             this.tt.set(e.title);
/* 109 */             this.tt.renderCY(r, body().x1() + 16, body().cY());
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 114 */           COLOR.unbind();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 119 */           Article e = (Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue());
/* 120 */           if (e != null)
/* 121 */             (VIEW.UI()).wiki.set(e); 
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WikiList$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
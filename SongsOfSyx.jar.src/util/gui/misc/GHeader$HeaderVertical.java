/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.common.TITLEABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HeaderVertical
/*     */   extends GHeader
/*     */ {
/*     */   private final SPRITE s;
/*     */   
/*     */   public HeaderVertical(CharSequence name, SPRITE s) {
/*  84 */     super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/*  85 */     this.s = s;
/*  86 */     this.body.setHeight((this.text.height() + 1 + s.height()));
/*  87 */     this.body.setWidth(((this.text.width() > s.width()) ? this.text.width() : s.width()));
/*     */   }
/*     */   
/*     */   public HeaderVertical(SPRITE name, SPRITE s) {
/*  91 */     super(name);
/*  92 */     this.s = s;
/*  93 */     this.body.setHeight((this.text.height() + 1 + s.height()));
/*  94 */     this.body.setWidth(((this.text.width() > s.width()) ? this.text.width() : s.width()));
/*     */   }
/*     */   
/*     */   public HeaderVertical(CharSequence name, GStat s) {
/*  98 */     this(name, (SPRITE)s);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 103 */     if (this.s instanceof GStat)
/* 104 */       ((GStat)this.s).adjust(); 
/* 105 */     int cx = this.body.cX();
/* 106 */     this.body.setWidth(((this.text.width() > this.s.width()) ? this.text.width() : this.s.width()));
/* 107 */     this.body.moveCX(cx);
/* 108 */     int dx = (this.body.width() - this.text.width()) / 2;
/* 109 */     this.text.render(r, this.body.x1() + dx, this.body.y1());
/*     */     
/* 111 */     dx = (this.body.width() - this.s.width()) / 2;
/* 112 */     this.s.render(r, this.body.x1() + dx, this.body.y1() + this.text.height() + 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 117 */     if (this.s instanceof TITLEABLE)
/* 118 */       ((TITLEABLE)this.s).hoverInfoGet((GBox)text); 
/* 119 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GHeader$HeaderVertical.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
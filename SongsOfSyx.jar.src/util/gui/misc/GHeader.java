/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.common.TITLEABLE;
/*     */ import util.info.INFO;
/*     */ 
/*     */ public class GHeader
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   protected SPRITE text;
/*     */   
/*     */   public GHeader(CharSequence name) {
/*  18 */     this.text = (SPRITE)(new GText((UI.FONT()).H2, name)).lablify();
/*  19 */     this.body.setHeight(this.text.height());
/*  20 */     this.body.setWidth(this.text.width());
/*     */   }
/*     */   
/*     */   public GHeader(CharSequence name, Font f) {
/*  24 */     this.text = (SPRITE)(new GText(f, name)).lablify();
/*  25 */     this.body.setHeight(this.text.height());
/*  26 */     this.body.setWidth(this.text.width());
/*     */   }
/*     */   
/*     */   public GHeader(CharSequence name, int max) {
/*  30 */     if (name.length() > max)
/*  31 */       name = String.valueOf(name).substring(0, max - 1) + "."; 
/*  32 */     this.text = (SPRITE)(new GText((UI.FONT()).H2, name)).lablify();
/*  33 */     this.body.setHeight(this.text.height());
/*  34 */     this.body.setWidth(this.text.width());
/*     */   }
/*     */   
/*     */   public GHeader(INFO info) {
/*  38 */     this.text = (SPRITE)(new GText((UI.FONT()).H2, info.name)).lablify();
/*  39 */     this.body.setHeight(this.text.height());
/*  40 */     this.body.setWidth(this.text.width());
/*  41 */     hoverTitleSet(info.name);
/*  42 */     hoverInfoSet(info.desc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GHeader(SPRITE name) {
/*  52 */     this.text = name;
/*  53 */     this.body.setHeight(this.text.height());
/*  54 */     this.body.setWidth(this.text.width());
/*     */   }
/*     */   
/*     */   public GHeader subify() {
/*  58 */     ((GText)this.text).lablifySub();
/*  59 */     return this;
/*     */   }
/*     */   
/*     */   public void setSprite(SPRITE name) {
/*  63 */     this.text = name;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  68 */     if (this.text instanceof GStat)
/*  69 */       ((GStat)this.text).adjust(); 
/*  70 */     this.text.render(r, this.body.x1(), this.body.y1());
/*     */   }
/*     */   
/*     */   public HOVERABLE hoverInfoSet(INFO i) {
/*  74 */     hoverTitleSet(i.name);
/*  75 */     hoverInfoSet(i.desc);
/*  76 */     return (HOVERABLE)this;
/*     */   }
/*     */   
/*     */   public static class HeaderVertical
/*     */     extends GHeader {
/*     */     private final SPRITE s;
/*     */     
/*     */     public HeaderVertical(CharSequence name, SPRITE s) {
/*  84 */       super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/*  85 */       this.s = s;
/*  86 */       this.body.setHeight((this.text.height() + 1 + s.height()));
/*  87 */       this.body.setWidth(((this.text.width() > s.width()) ? this.text.width() : s.width()));
/*     */     }
/*     */     
/*     */     public HeaderVertical(SPRITE name, SPRITE s) {
/*  91 */       super(name);
/*  92 */       this.s = s;
/*  93 */       this.body.setHeight((this.text.height() + 1 + s.height()));
/*  94 */       this.body.setWidth(((this.text.width() > s.width()) ? this.text.width() : s.width()));
/*     */     }
/*     */     
/*     */     public HeaderVertical(CharSequence name, GStat s) {
/*  98 */       this(name, (SPRITE)s);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 103 */       if (this.s instanceof GStat)
/* 104 */         ((GStat)this.s).adjust(); 
/* 105 */       int cx = this.body.cX();
/* 106 */       this.body.setWidth(((this.text.width() > this.s.width()) ? this.text.width() : this.s.width()));
/* 107 */       this.body.moveCX(cx);
/* 108 */       int dx = (this.body.width() - this.text.width()) / 2;
/* 109 */       this.text.render(r, this.body.x1() + dx, this.body.y1());
/*     */       
/* 111 */       dx = (this.body.width() - this.s.width()) / 2;
/* 112 */       this.s.render(r, this.body.x1() + dx, this.body.y1() + this.text.height() + 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 117 */       if (this.s instanceof TITLEABLE)
/* 118 */         ((TITLEABLE)this.s).hoverInfoGet((GBox)text); 
/* 119 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class HeaderHorizontal
/*     */     extends GHeader
/*     */   {
/*     */     private final SPRITE s;
/*     */     private final int fixedWidth;
/*     */     
/*     */     public HeaderHorizontal(CharSequence name, SPRITE s) {
/* 130 */       super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/* 131 */       this.s = s;
/* 132 */       this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 133 */       this.body.setWidth((this.text.width() + 6 + s.width()));
/* 134 */       this.fixedWidth = -1;
/*     */     }
/*     */     
/*     */     public HeaderHorizontal(SPRITE name, SPRITE s) {
/* 138 */       super(name);
/* 139 */       this.s = s;
/* 140 */       this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 141 */       this.body.setWidth((this.text.width() + 6 + s.width()));
/* 142 */       this.fixedWidth = -1;
/*     */     }
/*     */     
/*     */     public HeaderHorizontal(CharSequence name, SPRITE s, int width) {
/* 146 */       super(name, (s.height() <= 16) ? (UI.FONT()).S : (UI.FONT()).H2);
/* 147 */       this.s = s;
/* 148 */       this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 149 */       this.body.setWidth((width + s.width()));
/* 150 */       this.fixedWidth = width;
/*     */     }
/*     */     
/*     */     public HeaderHorizontal(SPRITE name, SPRITE s, int width) {
/* 154 */       super(name);
/* 155 */       this.s = s;
/* 156 */       this.body.setHeight(((this.text.height() > s.height()) ? this.text.height() : s.height()));
/* 157 */       this.body.setWidth((width + 32));
/* 158 */       this.fixedWidth = width;
/*     */     }
/*     */     
/*     */     public HeaderHorizontal(CharSequence name, GStat s) {
/* 162 */       this((s.statText.getFont() == (UI.FONT()).M) ? (SPRITE)(new GText((UI.FONT()).H2, name)).lablify() : (SPRITE)(new GText((UI.FONT()).H2, name)).lablify(), (SPRITE)s);
/*     */     }
/*     */     
/*     */     public HeaderHorizontal(CharSequence name, GStat s, int width) {
/* 166 */       this((s.statText.getFont() == (UI.FONT()).M) ? (SPRITE)(new GText((UI.FONT()).H2, name)).lablify() : (SPRITE)(new GText((UI.FONT()).H2, name)).lablify(), (SPRITE)s, width);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 171 */       if (this.fixedWidth == -1) {
/* 172 */         this.body.setWidth((this.text.width() + 6 + this.s.width()));
/*     */       }
/* 174 */       int dy = (this.body.height() - this.text.height()) / 2;
/* 175 */       this.text.render(r, this.body.x1(), this.body.y1() + dy);
/* 176 */       dy = (this.body.height() - this.s.height()) / 2;
/* 177 */       int x1 = body().x1();
/* 178 */       if (this.fixedWidth == -1) {
/* 179 */         this.body.setWidth((6 + this.text.width() + this.s.width()));
/* 180 */         x1 += 6 + this.text.width();
/*     */       } else {
/* 182 */         this.body.setWidth((this.fixedWidth + this.s.width()));
/* 183 */         x1 += this.fixedWidth;
/*     */       } 
/*     */       
/* 186 */       this.s.render(r, x1, this.body.y1() + dy);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 191 */       if (this.s instanceof TITLEABLE)
/* 192 */         ((TITLEABLE)this.s).hoverInfoGet((GBox)text); 
/* 193 */       super.hoverInfoGet(text);
/*     */     }
/*     */     
/*     */     public HeaderHorizontal increaseWidth(int am) {
/* 197 */       this.body.incrW(am);
/* 198 */       return this;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GHeader.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
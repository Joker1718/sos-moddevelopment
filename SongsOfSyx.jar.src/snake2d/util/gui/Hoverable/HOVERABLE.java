/*     */ package snake2d.util.gui.Hoverable;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.RecFacade;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public interface HOVERABLE
/*     */   extends RENDEROBJ
/*     */ {
/*     */   boolean hover(COORDINATE paramCOORDINATE);
/*     */   
/*     */   boolean hoveredIs();
/*     */   
/*     */   void hoverInfoGet(GUI_BOX paramGUI_BOX);
/*     */   
/*     */   HOVERABLE visableSet(boolean paramBoolean);
/*     */   
/*     */   HOVERABLE hoverInfoSet(CharSequence paramCharSequence);
/*     */   
/*     */   HOVERABLE hoverTitleSet(CharSequence paramCharSequence);
/*     */   
/*     */   public static abstract class HoverableAbs
/*     */     extends RENDEROBJ.RenderImp
/*     */     implements HOVERABLE
/*     */   {
/*  50 */     protected final Rec body = new Rec();
/*     */     protected boolean isHovered = false;
/*  52 */     private CharSequence hoverInfo = null;
/*  53 */     private CharSequence title = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public HoverableAbs(int width, int height) {
/*  60 */       this.body.setDim(width, height);
/*     */     }
/*     */     
/*     */     public HoverableAbs(int dim) {
/*  64 */       this.body.setDim(dim);
/*     */     }
/*     */     
/*     */     public HoverableAbs(DIMENSION dim) {
/*  68 */       this.body.setDim(dim.width(), dim.height());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/*  73 */       if (!visableIs())
/*  74 */         return false; 
/*  75 */       return this.isHovered = mCoo.isWithinRec((RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hoveredIs() {
/*  80 */       return this.isHovered;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/*  85 */       if (this.hoverInfo != null) {
/*  86 */         text.text(this.hoverInfo);
/*     */       }
/*  88 */       if (this.title != null) {
/*  89 */         text.title(this.title);
/*     */       }
/*     */     }
/*     */     
/*     */     public RecFacade body() {
/*  94 */       return (RecFacade)this.body;
/*     */     }
/*     */ 
/*     */     
/*     */     public HoverableAbs visableSet(boolean yes) {
/*  99 */       super.visableSet(yes);
/* 100 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public HOVERABLE hoverInfoSet(CharSequence s) {
/* 105 */       this.hoverInfo = s;
/* 106 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public final void render(SPRITE_RENDERER r, float ds) {
/* 111 */       if (visableIs())
/* 112 */         render(r, ds, this.isHovered); 
/* 113 */       this.isHovered = false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoveredSet(boolean h) {
/* 120 */       this.isHovered = h;
/*     */     }
/*     */ 
/*     */     
/*     */     public HOVERABLE hoverTitleSet(CharSequence s) {
/* 125 */       this.title = s;
/* 126 */       return this;
/*     */     }
/*     */     
/*     */     public HoverableAbs() {}
/*     */     
/*     */     protected abstract void render(SPRITE_RENDERER param1SPRITE_RENDERER, float param1Float, boolean param1Boolean); }
/*     */   
/*     */   public static class Sprite extends HoverableAbs {
/* 134 */     protected COLOR color = COLOR.WHITE100; protected SPRITE sprite;
/* 135 */     private DIR align = DIR.NW;
/*     */ 
/*     */     
/*     */     public Sprite() {}
/*     */ 
/*     */     
/*     */     public Sprite(int dim) {
/* 142 */       this.body.setDim(dim);
/*     */     }
/*     */     
/*     */     public Sprite(SPRITE sprite) {
/* 146 */       setSprite(sprite);
/*     */     }
/*     */     
/*     */     public Sprite(SPRITE sprite, COLOR c) {
/* 150 */       setSprite(sprite);
/* 151 */       this.color = c;
/*     */     }
/*     */     
/*     */     public Sprite setAlign(DIR d) {
/* 155 */       this.align = d;
/* 156 */       return this;
/*     */     }
/*     */     
/*     */     public void setSprite(SPRITE sprite) {
/* 160 */       this.sprite = sprite;
/* 161 */       adjust();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void adjust() {
/* 166 */       if (this.body.width() != this.sprite.width() || this.body.height() != this.sprite.height()) {
/* 167 */         this.align.reposition(this.body, this.sprite.width(), this.sprite.height());
/*     */       }
/*     */     }
/*     */     
/*     */     public void replaceSprite(SPRITE newSprite, DIR d) {
/* 172 */       this.sprite = newSprite;
/* 173 */       if (this.sprite == null) {
/* 174 */         d.reposition(this.body, 0, 0);
/*     */       } else {
/* 176 */         d.reposition(this.body, newSprite.width(), newSprite.height());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void setColor(COLOR color) {
/* 182 */       this.color = color;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 187 */       this.color.bind();
/* 188 */       adjust();
/* 189 */       this.sprite.render(r, this.body.x1(), this.body.y1());
/* 190 */       COLOR.unbind();
/* 191 */       OPACITY.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\Hoverable\HOVERABLE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
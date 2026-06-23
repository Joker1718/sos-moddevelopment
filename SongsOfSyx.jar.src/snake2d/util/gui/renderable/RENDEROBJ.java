/*     */ package snake2d.util.gui.renderable;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDERE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.RecFacade;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ public interface RENDEROBJ
/*     */   extends BODY_HOLDERE {
/*     */   void render(SPRITE_RENDERER paramSPRITE_RENDERER, float paramFloat);
/*     */   
/*     */   default SPRITE asSprite() {
/*  19 */     return (SPRITE)new SPRITE.Imp(body().width(), body().height())
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  23 */           RENDEROBJ.this.body().moveX1Y1(X1, Y1);
/*  24 */           RENDEROBJ.this.render(r, 0.0F);
/*     */         }
/*     */       };
/*     */   }
/*     */   boolean visableIs();
/*     */   RENDEROBJ visableSet(boolean paramBoolean);
/*     */   
/*  31 */   public static abstract class RenderImp implements RENDEROBJ { protected final Rec body = new Rec();
/*     */     private boolean isVisable = true;
/*     */     
/*     */     public RenderImp(int width, int height) {
/*  35 */       this.body.setDim(width, height);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RenderImp(int size) {
/*  43 */       this(size, size);
/*     */     }
/*     */ 
/*     */     
/*     */     public RecFacade body() {
/*  48 */       return (RecFacade)this.body;
/*     */     }
/*     */     
/*     */     public boolean visableIs() {
/*  52 */       return this.isVisable;
/*     */     }
/*     */     
/*     */     public RenderImp visableSet(boolean yes) {
/*  56 */       this.isVisable = yes;
/*  57 */       return this;
/*     */     }
/*     */     
/*     */     public RenderImp() {} }
/*     */ 
/*     */   
/*     */   public static final class RenderDummy implements RENDEROBJ {
/*  64 */     protected final Rec body = new Rec();
/*     */     
/*     */     public RenderDummy(int width, int height) {
/*  67 */       this.body.setDim(width, height);
/*     */     }
/*     */     
/*     */     public RenderDummy(int size) {
/*  71 */       this(size, size);
/*     */     }
/*     */ 
/*     */     
/*     */     public RecFacade body() {
/*  76 */       return (RecFacade)this.body;
/*     */     }
/*     */     
/*     */     public boolean visableIs() {
/*  80 */       return true;
/*     */     }
/*     */     
/*     */     public RenderDummy visableSet(boolean yes) {
/*  84 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Sprite
/*     */     extends RenderImp
/*     */     implements DIMENSION
/*     */   {
/*     */     private SPRITE sprite;
/*     */     
/*  98 */     private COLOR color = COLOR.WHITE100;
/*  99 */     private DIR align = DIR.NW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Sprite(int dim) {
/* 106 */       this.body.setDim(dim);
/*     */     }
/*     */     
/*     */     public Sprite(int width, int height) {
/* 110 */       this.body.setDim(width, height);
/*     */     }
/*     */     
/*     */     public Sprite(SPRITE sprite) {
/* 114 */       setSprite(sprite);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 120 */       if (this.sprite != null) {
/* 121 */         adjust();
/* 122 */         this.color.bind();
/* 123 */         this.sprite.render(r, this.body.x1(), this.body.y1());
/* 124 */         COLOR.unbind();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Sprite setAlign(DIR d) {
/* 131 */       this.align = d;
/* 132 */       return this;
/*     */     }
/*     */     
/*     */     public RENDEROBJ setSprite(SPRITE sprite) {
/* 136 */       this.sprite = sprite;
/* 137 */       if (sprite != null)
/* 138 */         adjust(); 
/* 139 */       return this;
/*     */     }
/*     */     
/*     */     private void adjust() {
/* 143 */       if (this.body.width() != this.sprite.width() || this.body.height() != this.sprite.height()) {
/* 144 */         this.align.reposition(this.body, this.sprite.width(), this.sprite.height());
/*     */       }
/*     */     }
/*     */     
/*     */     public Sprite setColor(COLOR color) {
/* 149 */       this.color = color;
/* 150 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 155 */       return this.sprite.width();
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 160 */       return this.sprite.height();
/*     */     }
/*     */ 
/*     */     
/*     */     public Rec body() {
/* 165 */       return this.body;
/*     */     }
/*     */     
/*     */     public Sprite() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\renderable\RENDEROBJ.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
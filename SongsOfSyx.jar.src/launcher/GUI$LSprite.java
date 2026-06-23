/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.RecFacade;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class LSprite
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   protected SPRITE sprite;
/* 141 */   protected OpacityImp opacity = new OpacityImp(OpacityImp.O100);
/* 142 */   protected ColorImp mask = new ColorImp(ColorImp.WHITE100);
/* 143 */   private final Rec bounds = new Rec();
/*     */   
/*     */   public LSprite(COLOR c) {
/* 146 */     this.mask.set(c);
/*     */   }
/*     */   
/*     */   public LSprite(SPRITE s) {
/* 150 */     this(s, 0.0F, 0.0F);
/*     */   }
/*     */   
/*     */   public LSprite(SPRITE s, COLOR c) {
/* 154 */     this(s);
/* 155 */     this.mask.set(c);
/*     */   }
/*     */   
/*     */   public LSprite(SPRITE s, float x1, float y1) {
/* 159 */     this.bounds.set(x1, (x1 + s.width()), y1, (y1 + s.height()));
/* 160 */     this.sprite = s;
/*     */   }
/*     */   
/*     */   public void replaceSprite(SPRITE newSprite, DIR d) {
/* 164 */     this.sprite = newSprite;
/* 165 */     if (this.sprite == null) {
/* 166 */       d.reposition(this.bounds, 0, 0);
/*     */     } else {
/* 168 */       d.reposition(this.bounds, newSprite.width(), newSprite.height());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public OpacityImp getOpacity() {
/* 174 */     return this.opacity;
/*     */   }
/*     */   
/*     */   public ColorImp getColor() {
/* 178 */     return this.mask;
/*     */   }
/*     */ 
/*     */   
/*     */   public Rec body() {
/* 183 */     return this.bounds;
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 188 */     if (this.sprite == null)
/*     */       return; 
/* 190 */     this.opacity.bind();
/* 191 */     this.mask.bind();
/* 192 */     this.sprite.render(r, (RECTANGLE)this.bounds);
/* 193 */     ColorImp.unBind();
/* 194 */     OPACITY.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\GUI$LSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
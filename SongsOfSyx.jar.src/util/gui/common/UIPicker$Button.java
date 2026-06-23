/*     */ package util.gui.common;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderIntInput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Button
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   public Button(GETTER<Integer> ier) {
/*  92 */     this.ier = ier;
/*     */     
/*  94 */     add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/*  98 */             ((IconHaser)UIPicker.Button.this.r()).icon().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 103 */             text.title(((IconHaser)UIPicker.Button.this.r()).name());
/*     */           }
/*     */         });
/*     */     
/* 107 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 111 */           return (UIPicker.Button.access$0(UIPicker.Button.this)).g.min(UIPicker.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 116 */           return (UIPicker.Button.access$0(UIPicker.Button.this)).g.max(UIPicker.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 121 */           return (UIPicker.Button.access$0(UIPicker.Button.this)).g.get(UIPicker.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 126 */           (UIPicker.Button.access$0(UIPicker.Button.this)).g.set(UIPicker.Button.this.r(), t);
/*     */         }
/*     */       };
/*     */     
/* 130 */     addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */   }
/*     */ 
/*     */   
/*     */   private T r() {
/* 135 */     return (T)UIPicker.this.tot.get(UIPicker.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPicker$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
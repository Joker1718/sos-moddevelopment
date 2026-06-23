/*     */ package util.gui.common;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
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
/*     */ class Button
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<Integer> ier;
/*     */   
/*     */   public Button(GETTER<Integer> ier) {
/*  90 */     this.ier = ier;
/*     */     
/*  92 */     add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */           {
/*  96 */             UIPickerResAm.Button.this.r().icon().render(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 101 */             text.title((UIPickerResAm.Button.this.r()).name);
/*     */           }
/*     */         });
/*     */     
/* 105 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 109 */           return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.min(UIPickerResAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 114 */           return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.max(UIPickerResAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 119 */           return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.get(UIPickerResAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 124 */           (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.set(UIPickerResAm.Button.this.r(), t);
/*     */         }
/*     */       };
/*     */     
/* 128 */     addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */   }
/*     */ 
/*     */   
/*     */   private RESOURCE r() {
/* 133 */     return (RESOURCE)RESOURCES.ALL().get(UIPickerResAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerResAm$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package util.gui.common;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
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
/*  96 */             (UIPickerRaceAm.Button.this.r().appearance()).icon.render(r, (RECTANGLE)this.body);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 101 */             text.title((UIPickerRaceAm.Button.this.r()).info.names);
/*     */           }
/*     */         });
/*     */     
/* 105 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 109 */           return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.min(UIPickerRaceAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 114 */           return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.max(UIPickerRaceAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 119 */           return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.get(UIPickerRaceAm.Button.this.r());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 124 */           (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.set(UIPickerRaceAm.Button.this.r(), t);
/*     */         }
/*     */       };
/*     */     
/* 128 */     addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */   }
/*     */ 
/*     */   
/*     */   private Race r() {
/* 133 */     return (Race)RACES.all().get(UIPickerRaceAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRaceAm$Button.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
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
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.slider.GSliderIntInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ public class UIPickerResAm extends GuiSection {
/*     */   private INT_O.INT_OE<RESOURCE> g;
/*  21 */   private ArrayListShort all = new ArrayListShort(RESOURCES.ALL().size());
/*     */ 
/*     */   
/*     */   public UIPickerResAm(INT_O.INT_OE<RESOURCE> g, int rows) {
/*  25 */     this.g = g;
/*     */     
/*  27 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  31 */           return UIPickerResAm.this.all.size();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  37 */     Button b = new Button((GETTER<Integer>)new GETTER.GETTER_IMP(Integer.valueOf(0)));
/*  38 */     G gg = new G((GETTER<Integer>)new GETTER.GETTER_IMP(Integer.valueOf(0)));
/*  39 */     addToRow(b, gg);
/*     */     
/*  41 */     builder.column("", b.body().width(), new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  45 */             UIPickerResAm.Button b = new UIPickerResAm.Button(ier);
/*  46 */             UIPickerResAm.G gg = new UIPickerResAm.G(ier);
/*  47 */             UIPickerResAm.this.addToRow(b, gg);
/*  48 */             return (RENDEROBJ)b;
/*     */           }
/*     */         });
/*     */     
/*  52 */     add((RENDEROBJ)builder.create(rows, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addToRow(GuiSection row, GETTER<RESOURCE> g) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  63 */     this.all.clear();
/*  64 */     for (RESOURCE res : RESOURCES.ALL()) {
/*  65 */       if (this.g.max(res) > 0)
/*  66 */         this.all.add(res.index()); 
/*  67 */     }  super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class G
/*     */     implements GETTER<RESOURCE> {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     G(GETTER<Integer> ier) {
/*  75 */       this.ier = ier;
/*     */     }
/*     */ 
/*     */     
/*     */     public RESOURCE get() {
/*  80 */       return (RESOURCE)RESOURCES.ALL().get(UIPickerResAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   private class Button
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     public Button(GETTER<Integer> ier) {
/*  90 */       this.ier = ier;
/*     */       
/*  92 */       add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */           {
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/*  96 */               UIPickerResAm.Button.this.r().icon().render(r, (RECTANGLE)this.body);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 101 */               text.title((UIPickerResAm.Button.this.r()).name);
/*     */             }
/*     */           });
/*     */       
/* 105 */       INT.INTE in = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 109 */             return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.min(UIPickerResAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 114 */             return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.max(UIPickerResAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 119 */             return (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.get(UIPickerResAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 124 */             (UIPickerResAm.Button.access$0(UIPickerResAm.Button.this)).g.set(UIPickerResAm.Button.this.r(), t);
/*     */           }
/*     */         };
/*     */       
/* 128 */       addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */     }
/*     */ 
/*     */     
/*     */     private RESOURCE r() {
/* 133 */       return (RESOURCE)RESOURCES.ALL().get(UIPickerResAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerResAm.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
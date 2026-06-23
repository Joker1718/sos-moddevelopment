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
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.slider.GSliderIntInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ public class UIPickerRaceAm extends GuiSection {
/*     */   private INT_O.INT_OE<Race> g;
/*  21 */   private ArrayListShort all = new ArrayListShort(RACES.all().size());
/*     */ 
/*     */   
/*     */   public UIPickerRaceAm(INT_O.INT_OE<Race> g, int rows) {
/*  25 */     this.g = g;
/*     */     
/*  27 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  31 */           return UIPickerRaceAm.this.all.size();
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
/*  45 */             UIPickerRaceAm.Button b = new UIPickerRaceAm.Button(ier);
/*  46 */             UIPickerRaceAm.G gg = new UIPickerRaceAm.G(ier);
/*  47 */             UIPickerRaceAm.this.addToRow(b, gg);
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
/*     */   protected void addToRow(GuiSection row, GETTER<Race> g) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  63 */     this.all.clear();
/*  64 */     for (Race res : RACES.all()) {
/*  65 */       if (this.g.max(res) > 0)
/*  66 */         this.all.add(res.index()); 
/*  67 */     }  super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class G
/*     */     implements GETTER<Race> {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     G(GETTER<Integer> ier) {
/*  75 */       this.ier = ier;
/*     */     }
/*     */ 
/*     */     
/*     */     public Race get() {
/*  80 */       return (Race)RACES.all().get(UIPickerRaceAm.this.all.get(((Integer)this.ier.get()).intValue()));
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
/*  96 */               (UIPickerRaceAm.Button.this.r().appearance()).icon.render(r, (RECTANGLE)this.body);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 101 */               text.title((UIPickerRaceAm.Button.this.r()).info.names);
/*     */             }
/*     */           });
/*     */       
/* 105 */       INT.INTE in = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 109 */             return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.min(UIPickerRaceAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 114 */             return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.max(UIPickerRaceAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 119 */             return (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.get(UIPickerRaceAm.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 124 */             (UIPickerRaceAm.Button.access$0(UIPickerRaceAm.Button.this)).g.set(UIPickerRaceAm.Button.this.r(), t);
/*     */           }
/*     */         };
/*     */       
/* 128 */       addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */     }
/*     */ 
/*     */     
/*     */     private Race r() {
/* 133 */       return (Race)RACES.all().get(UIPickerRaceAm.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPickerRaceAm.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
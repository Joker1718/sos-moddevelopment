/*     */ package util.gui.common;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.data.INT_O;
/*     */ import util.gui.slider.GSliderIntInput;
/*     */ import util.gui.table.GTableBuilder;
/*     */ 
/*     */ public class UIPicker<T extends INDEXED & IconHaser> extends GuiSection {
/*     */   private INT_O.INT_OE<T> g;
/*     */   private ArrayListShort all;
/*     */   private final LIST<T> tot;
/*     */   
/*     */   public UIPicker(INT_O.INT_OE<T> g, int rows, LIST<T> tot) {
/*  25 */     this.all = new ArrayListShort(tot.size());
/*  26 */     this.g = g;
/*  27 */     this.tot = tot;
/*     */     
/*  29 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  33 */           return UIPicker.this.all.size();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  39 */     Button b = new Button((GETTER<Integer>)new GETTER.GETTER_IMP(Integer.valueOf(0)));
/*  40 */     G gg = new G((GETTER<Integer>)new GETTER.GETTER_IMP(Integer.valueOf(0)));
/*  41 */     addToRow(b, gg);
/*     */     
/*  43 */     builder.column("", b.body().width(), new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  47 */             UIPicker<T>.Button b = new UIPicker.Button(ier);
/*  48 */             UIPicker<T>.G gg = new UIPicker.G(ier);
/*  49 */             UIPicker.this.addToRow(b, gg);
/*  50 */             return (RENDEROBJ)b;
/*     */           }
/*     */         });
/*     */     
/*  54 */     add((RENDEROBJ)builder.create(rows, false));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addToRow(GuiSection row, GETTER<T> g) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  65 */     this.all.clear();
/*  66 */     for (INDEXED iNDEXED : this.tot) {
/*  67 */       if (this.g.max(iNDEXED) > 0)
/*  68 */         this.all.add(iNDEXED.index()); 
/*  69 */     }  super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class G
/*     */     implements GETTER<T> {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     G(GETTER<Integer> ier) {
/*  77 */       this.ier = ier;
/*     */     }
/*     */ 
/*     */     
/*     */     public T get() {
/*  82 */       return (T)UIPicker.this.tot.get(UIPicker.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */   }
/*     */   
/*     */   private class Button
/*     */     extends GuiSection
/*     */   {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     public Button(GETTER<Integer> ier) {
/*  92 */       this.ier = ier;
/*     */       
/*  94 */       add((RENDEROBJ)new HOVERABLE.HoverableAbs(24)
/*     */           {
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */             {
/*  98 */               ((IconHaser)UIPicker.Button.this.r()).icon().render(r, (RECTANGLE)this.body);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 103 */               text.title(((IconHaser)UIPicker.Button.this.r()).name());
/*     */             }
/*     */           });
/*     */       
/* 107 */       INT.INTE in = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 111 */             return (UIPicker.Button.access$0(UIPicker.Button.this)).g.min(UIPicker.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 116 */             return (UIPicker.Button.access$0(UIPicker.Button.this)).g.max(UIPicker.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 121 */             return (UIPicker.Button.access$0(UIPicker.Button.this)).g.get(UIPicker.Button.this.r());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 126 */             (UIPicker.Button.access$0(UIPicker.Button.this)).g.set(UIPicker.Button.this.r(), t);
/*     */           }
/*     */         };
/*     */       
/* 130 */       addRightC(4, (RENDEROBJ)new GSliderIntInput(in));
/*     */     }
/*     */ 
/*     */     
/*     */     private T r() {
/* 135 */       return (T)UIPicker.this.tot.get(UIPicker.this.all.get(((Integer)this.ier.get()).intValue()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\common\UIPicker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
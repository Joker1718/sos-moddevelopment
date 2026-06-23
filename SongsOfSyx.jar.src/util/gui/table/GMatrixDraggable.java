/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ 
/*     */ 
/*     */ public abstract class GMatrixDraggable
/*     */   extends GuiSection
/*     */ {
/*     */   private final int columns;
/*  18 */   private final ArrayListGrower<Wrap> wraps = new ArrayListGrower();
/*  19 */   private Wrap toMove = null;
/*  20 */   private Wrap toMoveTo = null;
/*     */   
/*     */   public GMatrixDraggable(int rows, final int columns, int entryWidth, final int entryheight) {
/*  23 */     if (columns <= 0)
/*  24 */       throw new RuntimeException(); 
/*  25 */     this.columns = columns;
/*  26 */     GTableBuilder b = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  30 */           return (int)Math.ceil(GMatrixDraggable.this.nrOFEntries() / columns);
/*     */         }
/*     */       };
/*     */     
/*  34 */     b.column((CharSequence)null, entryWidth * columns, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  38 */             return (RENDEROBJ)new GMatrixDraggable.Row(ier, entryheight);
/*     */           }
/*     */         });
/*     */     
/*  42 */     add((RENDEROBJ)b.create(rows, false));
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract RENDEROBJ get(int paramInt1, int paramInt2);
/*     */ 
/*     */   
/*     */   public abstract int nrOFEntries();
/*     */ 
/*     */   
/*     */   public void multiSelect(int i) {}
/*     */ 
/*     */   
/*     */   public abstract void move(int paramInt1, int paramInt2);
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  58 */     if (this.toMove != null && 
/*  59 */       !MButt.LEFT.isDown()) {
/*  60 */       if (this.toMoveTo != null && this.toMove != this.toMoveTo) {
/*  61 */         move(this.toMove.i, this.toMoveTo.i);
/*     */       }
/*  63 */       this.toMove = null;
/*  64 */       this.toMoveTo = null;
/*     */     } 
/*     */     
/*  67 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class Row
/*     */     extends GuiSection {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     Row(GETTER<Integer> ier, int height) {
/*  75 */       this.ier = ier;
/*  76 */       body().setHeight(height);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/*  82 */       int ox = body().x1();
/*  83 */       int oy = body().y1();
/*  84 */       clear();
/*     */       
/*  86 */       int s = ((Integer)this.ier.get()).intValue() * GMatrixDraggable.this.columns;
/*  87 */       int m = GMatrixDraggable.this.nrOFEntries();
/*  88 */       for (int i = 0; i < GMatrixDraggable.this.columns && s < m; i++) {
/*  89 */         while (s >= GMatrixDraggable.this.wraps.size())
/*  90 */           GMatrixDraggable.this.wraps.add(new GMatrixDraggable.Wrap()); 
/*  91 */         GMatrixDraggable.Wrap w = (GMatrixDraggable.Wrap)GMatrixDraggable.this.wraps.get(s);
/*  92 */         w.init(i, ((Integer)this.ier.get()).intValue() * GMatrixDraggable.this.columns, s++);
/*  93 */         addRight(0, (RENDEROBJ)w);
/*     */       } 
/*  95 */       body().moveX1Y1(ox, oy);
/*  96 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Wrap
/*     */     extends CLICKABLE.ClickWrap2
/*     */   {
/*     */     private int i;
/*     */ 
/*     */     
/*     */     private RENDEROBJ rr;
/*     */ 
/*     */     
/*     */     private void init(int col, int row, int i) {
/* 112 */       this.i = i;
/* 113 */       this.rr = GMatrixDraggable.this.get(i, col);
/*     */     }
/*     */ 
/*     */     
/*     */     protected RENDEROBJ get() {
/* 118 */       return this.rr;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 123 */       GMatrixDraggable.this.toMove = this;
/* 124 */       return super.click();
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 129 */       boolean hov = hoveredIs();
/*     */       
/* 131 */       super.render(r, ds);
/* 132 */       if (GMatrixDraggable.this.toMove == this) {
/* 133 */         COLOR.WHITE85.render(r, body().x1(), body().x1() + 2, body().y1(), body().y2());
/* 134 */       } else if (GMatrixDraggable.this.toMove != null && hov) {
/* 135 */         (GCOLOR.UI()).GOOD.hovered.render(r, body().x1(), body().x1() + 2, body().y1(), body().y2());
/* 136 */         GMatrixDraggable.this.toMoveTo = this;
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GMatrixDraggable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
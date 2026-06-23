/*     */ package util.gui.table;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.data.GETTER;
/*     */ 
/*     */ 
/*     */ public abstract class GMatrix
/*     */   extends GuiSection
/*     */ {
/*     */   private final int columns;
/*  15 */   private final ArrayListGrower<Wrap> wraps = new ArrayListGrower();
/*     */   
/*     */   public GMatrix(int rows, final int columns, int entryWidth, final int entryheight) {
/*  18 */     if (columns <= 0)
/*  19 */       throw new RuntimeException(); 
/*  20 */     this.columns = columns;
/*  21 */     GTableBuilder b = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  25 */           return (int)Math.ceil(GMatrix.this.nrOFEntries() / columns);
/*     */         }
/*     */       };
/*     */     
/*  29 */     b.column((CharSequence)null, entryWidth * columns, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(GETTER<Integer> ier)
/*     */           {
/*  33 */             return (RENDEROBJ)new GMatrix.Row(ier, entryheight);
/*     */           }
/*     */         });
/*     */     
/*  37 */     add((RENDEROBJ)b.create(rows, false));
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
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  51 */     super.render(r, ds);
/*     */   }
/*     */   
/*     */   private class Row
/*     */     extends GuiSection {
/*     */     private final GETTER<Integer> ier;
/*     */     
/*     */     Row(GETTER<Integer> ier, int height) {
/*  59 */       this.ier = ier;
/*  60 */       body().setHeight(height);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/*  66 */       int ox = body().x1();
/*  67 */       int oy = body().y1();
/*  68 */       clear();
/*     */       
/*  70 */       int s = ((Integer)this.ier.get()).intValue() * GMatrix.this.columns;
/*  71 */       int m = GMatrix.this.nrOFEntries();
/*  72 */       for (int i = 0; i < GMatrix.this.columns && s < m; i++) {
/*  73 */         while (s >= GMatrix.this.wraps.size())
/*  74 */           GMatrix.this.wraps.add(new GMatrix.Wrap()); 
/*  75 */         GMatrix.Wrap w = (GMatrix.Wrap)GMatrix.this.wraps.get(s);
/*  76 */         w.init(i, ((Integer)this.ier.get()).intValue() * GMatrix.this.columns, s++);
/*  77 */         addRight(0, (RENDEROBJ)w);
/*     */       } 
/*  79 */       body().moveX1Y1(ox, oy);
/*  80 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Wrap
/*     */     extends CLICKABLE.ClickWrap2
/*     */   {
/*     */     private RENDEROBJ rr;
/*     */ 
/*     */ 
/*     */     
/*     */     private void init(int col, int row, int i) {
/*  95 */       this.rr = GMatrix.this.get(i, col);
/*     */     }
/*     */ 
/*     */     
/*     */     protected RENDEROBJ get() {
/* 100 */       return this.rr;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 106 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GMatrix.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
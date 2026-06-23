/*     */ package view.sett.ui.room.priority;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GRows;
/*     */ import util.gui.table.GScrollRows;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class Filter<T> extends GButt.ButtPanel {
/*  19 */   private static CharSequence ¤¤selectAll = "Select All";
/*  20 */   private static CharSequence ¤¤selectNone = "Select None";
/*  21 */   private static CharSequence ¤¤relavant = "Only Relevant";
/*  22 */   private static CharSequence ¤¤toggle = "Toggle:";
/*     */   
/*     */   static {
/*  25 */     D.ts(Filter.class);
/*     */   }
/*     */   
/*     */   private boolean relavant = true;
/*  29 */   private final GuiSection s = new GuiSection();
/*     */   public final LIST<FilterEntry<T>> all;
/*     */   
/*     */   Filter(SPRITE icon, CharSequence name, final LIST<FilterEntry<T>> all, LIST<FilterCombined<T>> combos) {
/*  33 */     super(icon);
/*  34 */     hoverInfoSet(name);
/*  35 */     setDim(40, 40);
/*  36 */     this.all = all;
/*  37 */     this.s.add((RENDEROBJ)(new GButt.ButtPanel(¤¤selectAll)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  41 */             Filter.this.relavant = false;
/*  42 */             for (Filter.FilterEntry<T> e : (Iterable<Filter.FilterEntry<T>>)all) {
/*  43 */               e.toggled = true;
/*     */             
/*     */             }
/*     */           }
/*  47 */         }).setDim(200));
/*  48 */     this.s.addDown(0, (RENDEROBJ)(new GButt.ButtPanel(¤¤selectNone)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  52 */             Filter.this.relavant = false;
/*  53 */             for (Filter.FilterEntry<T> e : (Iterable<Filter.FilterEntry<T>>)all) {
/*  54 */               e.toggled = false;
/*     */             
/*     */             }
/*     */           }
/*  58 */         }).setDim(200));
/*  59 */     this.s.addDown(0, (RENDEROBJ)(new GButt.ButtPanel(¤¤relavant)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  63 */             Filter.this.relavant = !Filter.this.relavant;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  68 */             selectedSet(Filter.this.relavant);
/*     */           }
/*  71 */         }).setDim(200));
/*     */     
/*  73 */     GRows g = new GRows(8);
/*     */ 
/*     */     
/*  76 */     for (FilterCombined<T> b : combos) {
/*  77 */       g.add((RENDEROBJ)(new GButt.ButtPanel(b.icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  81 */               Filter.this.relavant = false;
/*  82 */               for (Filter.FilterEntry<T> f : (Iterable<Filter.FilterEntry<T>>)all) {
/*  83 */                 f.toggled = false;
/*     */               }
/*  85 */               for (Filter.FilterEntry<T> f : (Iterable<Filter.FilterEntry<T>>)b.all) {
/*  86 */                 f.toggled = true;
/*     */               
/*     */               }
/*     */             }
/*  90 */           }).setDim(48, 48).hoverTitleSet(String.valueOf(¤¤toggle) + " " + String.valueOf(¤¤toggle)));
/*     */     } 
/*     */ 
/*     */     
/*  94 */     for (FilterEntry<T> b : all) {
/*  95 */       g.add((RENDEROBJ)(new GButt.ButtPanel(b.icon)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  99 */               Filter.this.relavant = false;
/* 100 */               b.toggled = !b.toggled;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 105 */               isSelected = b.toggled;
/* 106 */               super.render(r, ds, isActive, isSelected, isHovered);
/* 107 */               if (!b.isRelavant()) {
/* 108 */                 OPACITY.O50.bind();
/* 109 */                 COLOR.BLACK.render(r, (RECTANGLE)this.body, -4);
/* 110 */                 OPACITY.unbind();
/*     */               }
/*     */             
/*     */             }
/* 114 */           }).setDim(48, 48).hoverTitleSet(String.valueOf(¤¤toggle) + " " + String.valueOf(¤¤toggle)));
/*     */     } 
/*     */     
/* 117 */     this.s.addRelBody(8, DIR.S, (RENDEROBJ)(new GScrollRows((Iterable)g.rows(), 500)).view());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 123 */     (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean active(FilterEntry<T> t) {
/* 128 */     if (this.relavant)
/* 129 */       return t.isRelavant(); 
/* 130 */     return t.toggled;
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class FilterEntry<T>
/*     */   {
/*     */     public final CharSequence name;
/*     */     public final SPRITE icon;
/*     */     public final T o;
/*     */     boolean toggled = false;
/*     */     
/*     */     public FilterEntry(CharSequence name, SPRITE icon, T o) {
/* 142 */       this.name = name;
/* 143 */       this.icon = icon;
/* 144 */       this.o = o;
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean isRelavant();
/*     */   }
/*     */   
/*     */   static class FilterCombined<T>
/*     */   {
/*     */     public final CharSequence name;
/*     */     public final SPRITE icon;
/* 155 */     public final ArrayListGrower<Filter.FilterEntry<T>> all = new ArrayListGrower();
/*     */     
/*     */     FilterCombined(CharSequence name, SPRITE icon) {
/* 158 */       this.name = name;
/* 159 */       this.icon = icon;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Filter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
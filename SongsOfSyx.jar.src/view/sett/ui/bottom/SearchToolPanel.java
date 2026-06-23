/*     */ package view.sett.ui.bottom;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.slider.GTarget;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class SearchToolPanel extends SPanel {
/*     */   static LinkedList<Holder> all;
/*     */   private final GInput input;
/*     */   private final Holder[] nonFiltered;
/*     */   private final ArrayList<Holder> filtered;
/*  30 */   private int page = 0;
/*  31 */   private GuiSection content = new GuiSection();
/*     */   
/*  33 */   private final int width = 2;
/*  34 */   private final int height = 10;
/*     */   
/*     */   static CLICKABLE add(CLICKABLE c, CharSequence name, CharSequence desc) {
/*  37 */     all.add(new Holder(c, String.valueOf(name) + " " + String.valueOf(name)));
/*  38 */     return c;
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchToolPanel() {
/*  43 */     this.nonFiltered = new Holder[all.size()];
/*  44 */     int i = 0;
/*  45 */     for (Holder rr : all)
/*  46 */       this.nonFiltered[i++] = rr; 
/*  47 */     this.filtered = new ArrayList<>(this.nonFiltered.length);
/*  48 */     Arrays.sort(this.nonFiltered, new Comparator<Holder>()
/*     */         {
/*     */           public int compare(SearchToolPanel.Holder o1, SearchToolPanel.Holder o2)
/*     */           {
/*  52 */             return Dictionary.compare(o1.name, o2.name);
/*     */           }
/*     */         });
/*     */     
/*  56 */     this.input = new GInput(new StringInputSprite(20, (UI.FONT()).M)
/*     */         {
/*     */           protected void change() {
/*  59 */             SearchToolPanel.this.filter((CharSequence)text());
/*  60 */             super.change();
/*     */           }
/*     */         });
/*  63 */     add((RENDEROBJ)new GHeader(Dic.¤¤Filter));
/*  64 */     addRightC(16, (RENDEROBJ)this.input);
/*     */     
/*  66 */     this.content.body().setDim(716.0D, 460.0D);
/*     */     
/*  68 */     addRelBody(16, DIR.S, (RENDEROBJ)this.content);
/*     */     
/*  70 */     GTarget t = new GTarget(64, false, true, new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/*  74 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/*  79 */             return SearchToolPanel.this.filtered.size() / 20;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/*  84 */             return SearchToolPanel.this.page;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/*  89 */             SearchToolPanel.this.page = t;
/*  90 */             SearchToolPanel.this.build();
/*     */           }
/*     */         });
/*  93 */     addRelBody(8, DIR.S, (RENDEROBJ)t);
/*     */     
/*  95 */     filter("");
/*     */     
/*  97 */     pad(8, 8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void open(CLICKABLE c, Inter inter) {
/* 103 */     inter.set(c, (CLICKABLE)this);
/* 104 */     this.input.focus();
/*     */   }
/*     */   
/*     */   private void filter(CharSequence filter) {
/* 108 */     String f = String.valueOf(filter).toUpperCase();
/* 109 */     this.filtered.clear(); byte b; int i; Holder[] arrayOfHolder;
/* 110 */     for (i = (arrayOfHolder = this.nonFiltered).length, b = 0; b < i; ) { Holder h = arrayOfHolder[b];
/* 111 */       if (h.name.contains(f))
/* 112 */         this.filtered.add(h);  b++; }
/*     */     
/* 114 */     this.page = 0;
/* 115 */     build();
/*     */   }
/*     */   
/*     */   private void build() {
/* 119 */     int x1 = this.content.body().x1();
/* 120 */     int y1 = this.content.body().y1();
/* 121 */     this.content.clear();
/* 122 */     int s = this.page * 20;
/* 123 */     for (int i = 0; s < this.filtered.size() && i < 20; i++) {
/* 124 */       Holder h = this.filtered.get(s);
/* 125 */       s++;
/*     */       
/* 127 */       this.content.add((RENDEROBJ)h, i % 2 * 358, i / 2 * 46);
/*     */     } 
/*     */     
/* 130 */     this.content.body().moveX1Y1(x1, y1);
/*     */   }
/*     */   
/*     */   private static class Holder
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final CLICKABLE other;
/*     */     private final String name;
/*     */     
/*     */     Holder(CLICKABLE other, CharSequence name) {
/* 139 */       this.body.set((BODY_HOLDER)other);
/* 140 */       this.other = other;
/* 141 */       this.name = String.valueOf(name).toUpperCase();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 147 */       int x1 = this.other.body().x1();
/* 148 */       int y1 = this.other.body().y1();
/* 149 */       this.other.body().moveX1Y1(body().x1(), body().y1());
/* 150 */       this.other.render(r, ds);
/* 151 */       this.other.body().moveX1Y1(x1, y1);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 156 */       int x1 = this.other.body().x1();
/* 157 */       int y1 = this.other.body().y1();
/* 158 */       this.other.body().moveX1Y1(body().x1(), body().y1());
/* 159 */       this.other.hover(mCoo);
/* 160 */       this.other.body().moveX1Y1(x1, y1);
/* 161 */       return super.hover(mCoo);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 166 */       if (super.click()) {
/* 167 */         (VIEW.inters()).popup.close();
/* 168 */         this.other.click();
/* 169 */         return true;
/*     */       } 
/* 171 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 176 */       this.other.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\SearchToolPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
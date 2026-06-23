/*     */ package view.ui.wiki;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class WikiList extends GuiSection {
/*  21 */   private final StringInputSprite filter = (new StringInputSprite(18, (UI.FONT()).M)
/*     */     {
/*     */       protected void change() {
/*  24 */         WikiList.this.filter();
/*     */       }
/*  26 */     }).placeHolder("Search");
/*  27 */   private final GInput fc = new GInput(this.filter);
/*     */   private final ArrayList<Article> all;
/*     */   private final ArrayList<Article> filtered;
/*     */   public static final int width = 400;
/*     */   private final GTableBuilder builder;
/*     */   
/*     */   WikiList(ArrayList<Article> all, int HEIGHT) {
/*  34 */     int cats = 0;
/*  35 */     CharSequence lastCat = null;
/*  36 */     for (Article e : all) {
/*  37 */       if (lastCat == null || !e.category.equals(lastCat)) {
/*  38 */         lastCat = e.category;
/*  39 */         cats++;
/*     */       } 
/*     */     } 
/*  42 */     this.all = new ArrayList(all.size() + cats);
/*  43 */     lastCat = null;
/*  44 */     for (Article e : all) {
/*  45 */       if (lastCat == null || !e.category.equals(lastCat)) {
/*  46 */         this.all.add(null);
/*  47 */         lastCat = e.category;
/*     */       } 
/*  49 */       this.all.add(e);
/*     */     } 
/*  51 */     this.filtered = new ArrayList((Iterable)this.all);
/*     */ 
/*     */     
/*  54 */     this.fc.body().centerX(0.0D, 392.0D);
/*  55 */     add((RENDEROBJ)this.fc, 4, 0);
/*     */     
/*  57 */     this.builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/*  61 */           return WikiList.this.filtered.size();
/*     */         }
/*     */ 
/*     */         
/*     */         public void click(int index) {
/*  66 */           Article e = (Article)WikiList.this.filtered.get(index);
/*  67 */           if (e != null) {
/*  68 */             (VIEW.UI()).wiki.set(e);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean selectedIs(int index) {
/*  74 */           Article a = (Article)WikiList.this.filtered.get(index);
/*  75 */           if (a == null)
/*  76 */             return false; 
/*  77 */           return ((VIEW.UI()).wiki.added().size() > 0 && (VIEW.UI()).wiki.added().get(0) == a);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  82 */     this.builder.column(null, 368, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/*  87 */             return (RENDEROBJ)new CLICKABLE.ClickableAbs(368, 38)
/*     */               {
/*     */                 GText tt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/*     */                 protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  96 */                   Article e = (Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue());
/*  97 */                   if (e == null) {
/*  98 */                     this.tt.setFont((UI.FONT()).H2);
/*  99 */                     this.tt.lablify();
/* 100 */                     this.tt.set(((Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue() + 1)).category);
/* 101 */                     this.tt.renderCY(r, body().x1() + 8, body().cY());
/*     */                   } else {
/* 103 */                     isSelected |= (VIEW.UI()).wiki.added().contains(e);
/* 104 */                     GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 105 */                     GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/* 106 */                     this.tt.setFont((UI.FONT()).M);
/* 107 */                     this.tt.normalify2();
/* 108 */                     this.tt.set(e.title);
/* 109 */                     this.tt.renderCY(r, body().x1() + 16, body().cY());
/*     */                   } 
/*     */ 
/*     */ 
/*     */                   
/* 114 */                   COLOR.unbind();
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected void clickA() {
/* 119 */                   Article e = (Article)(WikiList.null.access$0(WikiList.null.this)).filtered.get(((Integer)ier.get()).intValue());
/* 120 */                   if (e != null) {
/* 121 */                     (VIEW.UI()).wiki.set(e);
/*     */                   }
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 130 */     GuiSection guiSection = this.builder.createHeight(HEIGHT - body().height() - 10, false);
/*     */ 
/*     */ 
/*     */     
/* 134 */     guiSection.body().moveY1((this.fc.body().y2() + 5));
/* 135 */     add((RENDEROBJ)guiSection);
/* 136 */     pad(4, 3);
/*     */   }
/*     */ 
/*     */   
/*     */   void setList(Article a) {
/* 141 */     this.filter.text().clear();
/* 142 */     filter();
/*     */     
/* 144 */     for (int i = 0; i < this.all.size(); i++) {
/* 145 */       if (this.all.get(i) == a) {
/* 146 */         this.builder.set(i - 5);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void set(Article e) {
/* 155 */     this.filter.text().clear();
/* 156 */     filter();
/* 157 */     if (e == null)
/* 158 */       this.fc.focus(); 
/*     */   }
/*     */   
/*     */   private void filter() {
/* 162 */     this.filtered.clear();
/* 163 */     Str str = this.filter.text();
/* 164 */     if (str.length() == 0) {
/* 165 */       this.filtered.add((Iterable)this.all);
/*     */       
/*     */       return;
/*     */     } 
/* 169 */     for (int i = 0; i < this.all.size(); i++) {
/* 170 */       Article e = (Article)this.all.get(i);
/* 171 */       if (e != null) {
/*     */         
/* 173 */         CharSequence t = e.key;
/* 174 */         if (testFilter((CharSequence)str, t)) {
/* 175 */           if (this.filtered.isEmpty() || !((Article)this.filtered.get(this.filtered.size() - 1)).category.equals(e.category))
/* 176 */             this.filtered.add(null); 
/* 177 */           this.filtered.add(this.all.get(i));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean testFilter(CharSequence filter, CharSequence key) {
/* 187 */     for (int ti = 0; ti < key.length(); ti++) {
/* 188 */       if (Character.toLowerCase(filter.charAt(0)) == Character.toLowerCase(key.charAt(ti))) {
/* 189 */         int i = 1; while (true) { if (i >= filter.length())
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 196 */             return true; }  int k = i + ti; if (k >= key.length())
/*     */             return false;  if (Character.toLowerCase(filter.charAt(i)) != Character.toLowerCase(key.charAt(k)))
/*     */             break;  i++; } 
/*     */       } 
/* 200 */     }  return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\WikiList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
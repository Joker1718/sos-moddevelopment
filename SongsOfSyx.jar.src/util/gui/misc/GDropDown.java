/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class GDropDown<E extends CLICKABLE>
/*     */   extends CLICKABLE.ClickableAbs implements CLICKABLE {
/*     */   private final SPRITE title;
/*  28 */   private final int mX = 4;
/*  29 */   private final int mY = 1;
/*     */   private E selected;
/*  31 */   private GuiSection expansion = new GuiSection();
/*     */   private final Inter inter;
/*  33 */   private final ArrayListResize<E> es = new ArrayListResize(20, 500);
/*  34 */   private final CLICKABLE.ClickableAbs dummy = new CLICKABLE.ClickableAbs()
/*     */     {
/*     */       protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {}
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDropDown(SPRITE title) {
/*  43 */     this.title = title;
/*  44 */     this.body.setHeight(((UI.FONT()).S.height() + 2));
/*  45 */     this.inter = new Inter();
/*     */   }
/*     */   
/*     */   public GDropDown(CharSequence title) {
/*  49 */     this((SPRITE)(new GText((UI.FONT()).S, title)).lablify());
/*     */   }
/*     */   
/*     */   public GDropDown(CharSequence title, int width) {
/*  53 */     this(sp(title, width));
/*     */   }
/*     */   
/*     */   private static SPRITE sp(CharSequence title, int width) {
/*  57 */     final GText t = (new GText((UI.FONT()).S, title)).lablify();
/*  58 */     return (SPRITE)new SPRITE.Imp(width, t.height() + 4)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/*  62 */           t.render(r, X1 + 2, Y1 + 2);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  70 */     COLOR.WHITE05.render(r, (RECTANGLE)this.body);
/*     */     
/*  72 */     if (!isActive) {
/*  73 */       COLOR.WHITE15.render(r, this.body.x1() + 1, this.body.x2() - 1, this.body.y1() + 1, this.body.y2() - 1);
/*  74 */     } else if (isHovered) {
/*  75 */       COLOR.WHITE30.render(r, this.body.x1() + 1, this.body.x2() - 1, this.body.y1() + 1, this.body.y2() - 1);
/*     */     } else {
/*  77 */       COLOR.WHITE20.render(r, this.body.x1() + 1, this.body.x2() - 1, this.body.y1() + 1, this.body.y2() - 1);
/*     */     } 
/*     */     
/*  80 */     COLOR.WHITE05.render(r, this.body.x1() + this.title.width() + 8, this.body.x1() + this.title.width() + 8 + 1, this.body.y1(), this.body.y2());
/*     */     
/*  82 */     if (!isActive) {
/*  83 */       COLOR.WHITE50.bind();
/*  84 */     } else if (isHovered) {
/*  85 */       (SPRITES.icons()).s.arrowDown.render(r, this.body.x2() - 16 - 4, this.body.y1() + (this.body.height() - 16) / 2);
/*  86 */       COLOR.WHITE150.bind();
/*     */     } 
/*     */     
/*  89 */     this.title.render(r, this.body.x1() + 4, this.body.y1() + (this.body.height() - this.title.height()) / 2);
/*     */ 
/*     */ 
/*     */     
/*  93 */     COLOR.unbind();
/*     */     
/*  95 */     if (this.selected != null) {
/*  96 */       int x1 = this.selected.body().x1();
/*  97 */       int y1 = this.selected.body().y1();
/*  98 */       this.selected.body().centerY((RECTANGLE)this.body);
/*  99 */       this.selected.body().moveX1((this.body.x1() + this.title.width() + 12));
/* 100 */       this.selected.render(r, ds);
/* 101 */       this.selected.body().moveX1Y1(x1, y1);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 107 */     if (super.click()) {
/* 108 */       if (!this.inter.isActivated()) {
/* 109 */         this.inter.show();
/*     */       } else {
/* 111 */         this.inter.hide();
/* 112 */       }  return true;
/*     */     } 
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public E selected() {
/* 118 */     return this.selected;
/*     */   }
/*     */   
/*     */   public void setSelected(E s) {
/* 122 */     this.selected = s;
/*     */   }
/*     */   
/*     */   public GDropDown<E> add(E e) {
/* 126 */     this.es.add(e);
/* 127 */     if (this.selected == null)
/* 128 */       this.selected = e; 
/* 129 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GDropDown<E> init() {
/* 137 */     this.expansion.clear();
/* 138 */     int w = 0;
/* 139 */     int h = 0;
/* 140 */     for (CLICKABLE cLICKABLE : this.es) {
/* 141 */       if (cLICKABLE.body().width() > w)
/* 142 */         w = cLICKABLE.body().width(); 
/* 143 */       if (cLICKABLE.body().height() > h)
/* 144 */         h = cLICKABLE.body().height(); 
/*     */     } 
/* 146 */     this.body.setWidth((this.title.width() + 16 + w));
/* 147 */     this.dummy.body.setWidth(w).setHeight(h);
/* 148 */     this.es.trim();
/*     */     
/* 150 */     GTableBuilder builder = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries() {
/* 153 */           return GDropDown.this.es.size();
/*     */         }
/*     */       };
/*     */     
/* 157 */     final int width = w;
/* 158 */     final int height = h;
/*     */     
/* 160 */     builder.column(null, w + 8, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */ 
/*     */           
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 166 */             CLICKABLE.ClickWrap wr = new CLICKABLE.ClickWrap(width, height)
/*     */               {
/*     */                 protected CLICKABLE pget() {
/* 169 */                   if (ier.get() == null)
/* 170 */                     return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).dummy; 
/* 171 */                   int i = ((Integer)ier.get()).intValue();
/* 172 */                   if (i >= (GDropDown.null.access$0(GDropDown.null.this)).es.size())
/* 173 */                     return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).dummy; 
/* 174 */                   return (CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).es.get(i);
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public boolean click() {
/* 179 */                   int i = ((Integer)ier.get()).intValue();
/* 180 */                   GDropDown.null.access$0(GDropDown.null.this).setSelected((CLICKABLE)(GDropDown.null.access$0(GDropDown.null.this)).es.get(i));
/* 181 */                   if (super.click()) {
/*     */                     
/* 183 */                     if (i < (GDropDown.null.access$0(GDropDown.null.this)).es.size())
/*     */                     {
/* 185 */                       (GDropDown.null.access$0(GDropDown.null.this)).inter.hide();
/*     */                     }
/* 187 */                     return true;
/*     */                   } 
/* 189 */                   return false;
/*     */                 }
/*     */               };
/* 192 */             return (RENDEROBJ)wr;
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 197 */     int rows = Math.min(10, this.es.size());
/* 198 */     this.expansion = builder.create(rows, true);
/* 199 */     GPanel p = new GPanel();
/* 200 */     p.inner().set((BODY_HOLDER)this.expansion);
/* 201 */     this.expansion.add((RENDEROBJ)p);
/* 202 */     this.expansion.moveLastToBack();
/*     */ 
/*     */     
/* 205 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final class Inter
/*     */     extends Interrupter
/*     */   {
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 216 */       return GDropDown.this.expansion.hover(mCoo);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 221 */       if (button == MButt.LEFT) {
/* 222 */         GDropDown.this.expansion.click();
/* 223 */       } else if (button == MButt.RIGHT) {
/* 224 */         hide();
/*     */       } 
/*     */     }
/*     */     private void show() {
/* 228 */       if (isActivated()) {
/*     */         return;
/*     */       }
/* 231 */       GDropDown.this.expansion.body().moveC(GDropDown.this.body().cX(), 0.0D);
/* 232 */       GDropDown.this.expansion.body().moveY1(GDropDown.this.body().y2());
/* 233 */       if (GDropDown.this.expansion.body().y2() > C.HEIGHT())
/* 234 */         GDropDown.this.expansion.body().moveY2(GDropDown.this.body().y2()); 
/* 235 */       show((VIEW.current()).uiManager);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean otherClick(MButt button) {
/* 240 */       hide();
/* 241 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hide() {
/* 246 */       super.hide();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 252 */       GDropDown.this.expansion.hoverInfoGet(text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 257 */       GDropDown.this.expansion.render((SPRITE_RENDERER)r, ds);
/* 258 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 263 */       if (KEYS.anyDown())
/* 264 */         hide(); 
/* 265 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GDropDown.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
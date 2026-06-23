/*     */ package util.gui.panel;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.sprite.UI.UIPanels;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.datatypes.RecFacade;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public class GPanel
/*     */   extends CLICKABLE.ClickableAbs
/*     */ {
/*     */   private static final int MW = 8;
/*  23 */   private final GText title = (new GText((UI.FONT()).H2, 32)).lablify();
/*     */   
/*  25 */   private UIPanels.UIPanel panel = (UI.PANEL()).thin;
/*     */   
/*     */   private boolean closeH;
/*  28 */   private final RecFacade outer = new RecFacade()
/*     */     {
/*     */       private static final long serialVersionUID = 1L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public int width() {
/*  37 */         return GPanel.this.body.width() + 16 + ((GPanel.this.clickAction != null) ? 8 : 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public int height() {
/*  42 */         return GPanel.this.body.height() + 16 + GPanel.this.titleHeight() / 2 + ((GPanel.this.clickAction != null) ? 8 : 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public int y1() {
/*  47 */         return GPanel.this.body.y1() - 8 - GPanel.this.titleHeight() / 2 - ((GPanel.this.clickAction != null) ? 8 : 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public int x1() {
/*  52 */         return GPanel.this.body.x1() - 8;
/*     */       }
/*     */ 
/*     */       
/*     */       public RECTANGLEE moveY1(double Y1) {
/*  57 */         GPanel.this.body.moveY1(Y1 + 8.0D + (GPanel.this.titleHeight() / 2));
/*  58 */         return (RECTANGLEE)this;
/*     */       }
/*     */ 
/*     */       
/*     */       public RECTANGLEE moveX1(double X1) {
/*  63 */         GPanel.this.body.moveX1(X1 + 8.0D);
/*  64 */         return (RECTANGLEE)this;
/*     */       }
/*     */ 
/*     */       
/*     */       public RecFacade setWidth(double width) {
/*  69 */         GPanel.this.body.setWidth(width - 16.0D + ((GPanel.this.clickAction != null) ? 8 : false));
/*  70 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public RecFacade setHeight(double height) {
/*  75 */         GPanel.this.body.setHeight(height - 16.0D - (GPanel.this.titleHeight() / 2) + ((GPanel.this.clickAction != null) ? 8 : false));
/*  76 */         return this;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GPanel(RECTANGLE r) {
/*  85 */     this.body.set(r);
/*     */   }
/*     */   
/*     */   public GPanel(int width, int height) {
/*  89 */     this.body.setDim(width, height);
/*     */   }
/*     */   
/*     */   public GPanel set(RECTANGLE r) {
/*  93 */     this.body.set(r);
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   public GPanel setDim(int width, int height) {
/*  98 */     this.body.setWidth(width).setHeight(height);
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public GPanel setBig() {
/* 103 */     this.panel = (UI.PANEL()).big;
/* 104 */     return this;
/*     */   }
/*     */   
/*     */   public GPanel setButt() {
/* 108 */     this.panel = (UI.PANEL()).butt;
/* 109 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public RecFacade body() {
/* 114 */     return this.outer;
/*     */   }
/*     */   
/*     */   public Rec inner() {
/* 118 */     return this.body;
/*     */   }
/*     */   
/*     */   private int titleHeight() {
/* 122 */     if (this.title.length() == 0)
/* 123 */       return 0; 
/* 124 */     return (UI.PANEL().titleBox(this.title.getFont().height())).height;
/*     */   }
/*     */   
/*     */   public void setTitle(CharSequence title) {
/* 128 */     this.title.clear();
/* 129 */     if (title != null)
/* 130 */       this.title.set(title); 
/*     */   }
/*     */   
/*     */   public void setTitle(CharSequence title, Font f) {
/* 134 */     this.title.setFont(f);
/* 135 */     this.title.clear().set(title);
/*     */   }
/*     */   
/*     */   public GText title() {
/* 139 */     return this.title;
/*     */   }
/*     */   
/*     */   public GPanel setCloseAction(ACTION action) {
/* 143 */     this.clickAction = action;
/* 144 */     hoverInfoSet(Dic.¤¤Close);
/* 145 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 150 */     this.closeH = false;
/* 151 */     if (this.clickAction != null) {
/* 152 */       int cy = this.outer.y1() - this.panel.margin + this.panel.tMid;
/* 153 */       int cx = this.outer.x2() + this.panel.margin - this.panel.tMid;
/* 154 */       this.closeH = (mCoo.tileDistanceTo(cx, cy) < 16.0D);
/* 155 */       if (this.closeH && MButt.LEFT.consumeClick()) {
/* 156 */         this.clickAction.exe();
/* 157 */         return true;
/*     */       } 
/*     */     } 
/* 160 */     this.isHovered = this.closeH;
/* 161 */     return this.closeH;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 167 */     this.panel.render(r, (RECTANGLE)this.outer, 0);
/*     */     
/* 169 */     renderTitle(r);
/*     */     
/* 171 */     if (this.clickAction != null) {
/*     */       
/* 173 */       int cy = this.outer.y1() - this.panel.margin + this.panel.tMid;
/* 174 */       int cx = this.outer.x2() + this.panel.margin - this.panel.tMid;
/* 175 */       (UI.PANEL()).panelClose.renderC(r, this.closeH ? 1 : 0, cx, cy);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderTitle(SPRITE_RENDERER r) {
/* 183 */     if (this.title.length() != 0) {
/*     */       
/* 185 */       UIPanels.TitleBox b = UI.PANEL().titleBox(this.title.getFont().height());
/*     */ 
/*     */ 
/*     */       
/* 189 */       this.title.setMultipleLines(false);
/* 190 */       int cy = this.outer.y1() - this.panel.margin + this.panel.tMid;
/* 191 */       int y1 = cy - b.height / 2;
/* 192 */       int x1 = this.body.cX() - this.title.width() / 2;
/*     */       
/* 194 */       b.render(r, x1, y1, this.title.width());
/* 195 */       this.title.render(r, x1, cy - this.title.height() / 2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public GPanel() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\panel\GPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package view.interrupter;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class ISidePanels extends Interrupter {
/*  25 */   private final ArrayList<Panel> free = new ArrayList(16);
/*  26 */   private final ArrayList<Panel> added = new ArrayList(16);
/*  27 */   private final GuiSection section = new GuiSection();
/*     */   private int x2;
/*     */   private final int x1;
/*     */   private final InterManager m;
/*     */   
/*     */   public ISidePanels(InterManager m, int x1) {
/*  33 */     this.m = m;
/*  34 */     for (int i = 0; i < 16; i++)
/*  35 */       this.free.add(new Panel()); 
/*  36 */     this.x1 = x1 - 1;
/*     */   }
/*     */   
/*     */   public void add(ISidePanel panel, boolean clear) {
/*  40 */     add(panel, clear, false);
/*     */   }
/*     */   
/*     */   public void addDontRemove(ISidePanel panel, ISidePanel panel2) {
/*  44 */     if (added(panel)) {
/*  45 */       add(panel, true);
/*  46 */       add(panel2, false);
/*     */     } else {
/*  48 */       add(panel2, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addDontRemove(ISidePanel panel, ISidePanel panel2, ISidePanel panel3) {
/*  53 */     boolean p1 = added(panel);
/*  54 */     boolean p2 = added(panel2);
/*  55 */     clear();
/*  56 */     if (p1)
/*  57 */       add(panel, false); 
/*  58 */     if (p2)
/*  59 */       add(panel2, false); 
/*  60 */     add(panel3, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void toggle(ISidePanel panel, boolean clear) {
/*  65 */     if (added(panel)) {
/*  66 */       remove(panel);
/*     */     } else {
/*  68 */       add(panel, clear, false);
/*     */     } 
/*     */   }
/*     */   public void add(ISidePanel panel, boolean clear, boolean pin) {
/*  72 */     if (clear) {
/*  73 */       remove();
/*     */     }
/*  75 */     for (int i = 0; i < this.added.size(); i++) {
/*  76 */       Panel p = (Panel)this.added.get(i);
/*  77 */       if (p.panel == panel) {
/*  78 */         p.set(panel);
/*  79 */         rearrange();
/*  80 */         show(this.m);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  85 */     addP(panel, pin);
/*  86 */     show(this.m);
/*     */   }
/*     */   
/*     */   public void remove(ISidePanel panel) {
/*  90 */     for (int i = 0; i < this.added.size(); i++) {
/*  91 */       Panel p = (Panel)this.added.get(i);
/*  92 */       if (p.panel == panel) {
/*  93 */         this.added.removeOrdered(i);
/*  94 */         this.free.add(p);
/*  95 */         rearrange();
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean otherClick(MButt button) {
/* 103 */     if (button == MButt.RIGHT && this.added.size() > 0) {
/* 104 */       for (int i = this.added.size() - 1; i >= 0; i--) {
/* 105 */         Panel p = (Panel)this.added.get(i);
/* 106 */         if (p.panel.back())
/* 107 */           return false; 
/* 108 */         if (!p.pinned) {
/* 109 */           this.added.removeOrdered(i);
/* 110 */           this.free.add(p);
/* 111 */           rearrange();
/* 112 */           return true;
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 118 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 123 */     for (Panel p : this.added)
/* 124 */       this.free.add(p); 
/* 125 */     this.added.clear();
/* 126 */     rearrange();
/*     */   }
/*     */   
/*     */   public boolean added(ISidePanel panel) {
/* 130 */     if (!isActivated())
/* 131 */       return false; 
/* 132 */     for (int i = 0; i < this.added.size(); i++) {
/* 133 */       Panel p = (Panel)this.added.get(i);
/* 134 */       if (p.panel == panel)
/* 135 */         return true; 
/*     */     } 
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   private void addP(ISidePanel panel, boolean pinned) {
/* 141 */     Panel p = (Panel)this.free.removeLast();
/* 142 */     p.set(panel);
/* 143 */     this.added.add(p);
/* 144 */     rearrange();
/* 145 */     p.pinned = pinned;
/* 146 */     panel.addAction();
/* 147 */     panel.update(0.0F);
/*     */   }
/*     */   
/*     */   private void remove() {
/* 151 */     for (int i = 0; i < this.added.size(); i++) {
/* 152 */       Panel p = (Panel)this.added.get(i);
/* 153 */       if (!p.pinned) {
/* 154 */         this.free.add(p);
/* 155 */         this.added.removeOrdered(i);
/* 156 */         i--;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void rearrange() {
/* 162 */     this.section.clear();
/* 163 */     this.x2 = this.x1;
/* 164 */     for (Panel p : this.added) {
/* 165 */       p.panel.last = this;
/* 166 */       p.body().moveX1Y1(this.section.getLastX2(), 51.0D);
/* 167 */       this.section.add((RENDEROBJ)p);
/*     */     } 
/* 169 */     this.section.body().moveX1(this.x1);
/* 170 */     this.section.body().moveY1(51.0D);
/* 171 */     this.x2 = this.section.body().x2();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 176 */     return this.section.hover(mCoo);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 181 */     if (MButt.LEFT == button)
/* 182 */       this.section.click(); 
/* 183 */     if (MButt.RIGHT == button) {
/* 184 */       otherClick(button);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 191 */     this.section.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 196 */     if (this.x2 > 0) {
/* 197 */       this.addManager.viewPort().moveX1(this.x2);
/* 198 */       this.addManager.viewPort().setWidth((C.WIDTH() - this.x2));
/*     */     } 
/* 200 */     this.section.render((SPRITE_RENDERER)r, ds);
/* 201 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 206 */     for (Panel p : this.added)
/* 207 */       p.panel.update(ds); 
/* 208 */     return true;
/*     */   }
/*     */   
/*     */   private class Panel extends GuiSection {
/*     */     boolean pinned;
/* 213 */     private GText title = (new GText((UI.FONT()).H2, 20)).lablify(); private ISidePanel panel;
/*     */     
/* 215 */     private final CLICKABLE close = (CLICKABLE)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.exit)
/*     */       {
/*     */         protected void clickA() {
/* 218 */           ISidePanels.Panel.access$0(ISidePanels.Panel.this).remove(ISidePanels.Panel.this.panel);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 223 */           text.title(Dic.¤¤Close);
/* 224 */           text.add((SPRITE)text.text().add('(').add(Dic.¤¤RightClick).add(')'));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     void set(ISidePanel panel) {
/* 230 */       clear();
/* 231 */       GuiSection guiSection = panel.section();
/* 232 */       body().setHeight((C.HEIGHT() - 51));
/* 233 */       body().setWidth((guiSection.body().width() + 16));
/* 234 */       body().moveY1(51.0D);
/* 235 */       guiSection.body().centerIn((BODY_HOLDER)this);
/* 236 */       guiSection.body().moveY1(99.0D);
/* 237 */       add((RENDEROBJ)guiSection);
/* 238 */       this.close.body().moveC((body().x2() - this.close.body().width() / 2 + 8), 71.0D);
/* 239 */       add((RENDEROBJ)this.close);
/* 240 */       this.panel = panel;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 245 */       if (this.panel.title != null) {
/* 246 */         this.title.clear().add(this.panel.title).adjustWidth();
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 252 */       COLOR.WHITE10.render(r, body().x1(), body().x2(), 51, C.HEIGHT());
/* 253 */       (UI.PANEL()).butt.render(r, body().x1(), body().x2() - 3, 51 + (UI.PANEL()).butt.margin, 91 - (UI.PANEL()).butt.margin, 0, DIR.N.mask() | DIR.S.mask());
/*     */       
/* 255 */       GCOLOR.UI().border(r, body().x1(), body().x1() + 3, 51, C.HEIGHT());
/* 256 */       GCOLOR.UI().border(r, body().x2() - 3, body().x2(), 51, C.HEIGHT());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 264 */       if (this.title.length() != 0) {
/* 265 */         this.title.adjustWidth();
/* 266 */         int x = body().x1() + (this.close.body().x1() - body().x1()) / 2;
/* 267 */         int y = this.close.body().cY();
/* 268 */         this.title.renderC(r, x, y);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 305 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\ISidePanels.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
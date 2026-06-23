/*     */ package view.ui.family;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.relation.StatsRelations;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import util.colors.GCOLOR;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class UIFamilyTreeDrawer {
/*  22 */   private final StatsRelations r = STATS.REL();
/*     */   
/*     */   private static final int ww = 50;
/*     */   
/*     */   private static final int hh = 74;
/*     */   
/*     */   private static final int MX = 12;
/*     */   private static final int MY = 32;
/*  30 */   private int hoverRef = -1;
/*  31 */   private int hoverRef2 = -1;
/*     */   
/*  33 */   private final Window window = new Window();
/*     */   
/*  35 */   private final Rec body = new Rec(50.0D, 74.0D);
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int ref, UIFamilyTreeRefs refs, UIFamilyTreeAligner poss) {
/*  40 */     this.hoverRef = -1;
/*  41 */     this.hoverRef2 = -1;
/*  42 */     this.window.init(ref, refs, poss);
/*     */   }
/*     */   
/*     */   public void drag() {
/*  46 */     this.window.dragging = true;
/*  47 */     this.window.clickedCoo.set((COORDINATE)VIEW.mouse());
/*     */   }
/*     */ 
/*     */   
/*     */   public void draw(double ds, UIFamilyTreeRefs refs, UIFamilyTreeAligner poss, int primaryRef) {
/*  52 */     this.hoverRef = this.hoverRef2;
/*  53 */     this.hoverRef2 = -1;
/*     */     
/*  55 */     this.window.update(ds);
/*  56 */     this.window.renderBG();
/*     */     int refI;
/*  58 */     for (refI = 0; refI < refs.max(); refI++) {
/*     */       
/*  60 */       double dx = poss.x2(refI);
/*  61 */       double level = poss.level(refI);
/*  62 */       double parentX = poss.parentX(refI);
/*     */ 
/*     */       
/*  65 */       drawRelations(refs.get(refI), dx, level, parentX);
/*     */     } 
/*     */     
/*  68 */     for (refI = 0; refI < refs.max(); refI++) {
/*     */       
/*  70 */       double dx = poss.x2(refI);
/*  71 */       double level = poss.level(refI);
/*     */       
/*  73 */       int ref = refs.get(refI);
/*     */       
/*  75 */       int x = this.window.sx(dx);
/*  76 */       int y = this.window.sy(level);
/*  77 */       this.body.moveX1Y1(x, y);
/*     */       
/*  79 */       if (this.body.holdsPoint((COORDINATE)VIEW.mouse())) {
/*  80 */         this.hoverRef = ref;
/*  81 */         this.hoverRef2 = ref;
/*     */       } 
/*  83 */       boolean expand = refs.hasChild(refI);
/*  84 */       drawFrame(ref, primaryRef);
/*  85 */       draw(ref, expand);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawFrame(int ref, int primaryRef) {
/*  96 */     boolean hovered = (this.hoverRef == ref);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     int scale = this.window.scale;
/*     */     
/* 108 */     GCOLOR.UI().bg(!(!hovered && STATS.REL().indu(ref) == null), false, hovered).render((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body);
/*     */     
/* 110 */     GCOLOR.UI().border().renderFrame((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body, -scale, scale);
/*     */     
/* 112 */     if (ref == primaryRef) {
/* 113 */       COLOR.WHITE25.renderFrame((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body, 2, 1);
/* 114 */       COLOR.WHITE100.renderFrame((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body, 3, 1);
/* 115 */       COLOR.WHITE50.renderFrame((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body, 4, 1);
/* 116 */       COLOR.WHITE25.renderFrame((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.body, 5, 1);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void draw(int ref, boolean expand) {
/* 123 */     int scale = this.window.scale;
/* 124 */     if (STATS.REL().indu(ref) != null) {
/* 125 */       int x1 = this.body.x1() + 5 * scale;
/* 126 */       int y1 = this.body.y1() + 4 * scale;
/* 127 */       STATS.APPEARANCE().portraitRender((SPRITE_RENDERER)CORE.renderer(), STATS.REL().indu(ref), x1, y1, scale);
/* 128 */     } else if (STATS.REL().race(ref) != null) {
/* 129 */       COLOR.WHITE65.bind();
/* 130 */       (STATS.REL().race(ref).appearance()).iconBig.renderCScaled((SPRITE_RENDERER)CORE.renderer(), this.body.cX(), this.body.cY(), scale);
/* 131 */       COLOR.unbind();
/*     */     } 
/*     */     
/* 134 */     if (expand) {
/* 135 */       (UI.icons()).s.expand.renderCScaled((SPRITE_RENDERER)CORE.renderer(), this.body.x2() - scale * 8, this.body.y2() - scale * 8, this.window.scale);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void drawRelations(int ref, double dx, double level, double parentdx) {
/* 142 */     boolean active = false;
/* 143 */     if (this.r.hasParent(ref) && this.hoverRef == this.r.parentRef(ref))
/*     */     {
/* 145 */       active = true;
/*     */     }
/* 147 */     if (this.r.hasParent(this.hoverRef) && this.r.hasParent(ref) && this.r.parentRef(ref) == this.r.parentRef(this.hoverRef))
/*     */     {
/* 149 */       active = true;
/*     */     }
/*     */     
/* 152 */     COLOR col = active ? COLOR.WHITE85 : COLOR.WHITE35;
/*     */     
/* 154 */     int y = this.window.sy(level);
/*     */     
/* 156 */     int d = this.window.scale * 2;
/* 157 */     int dy = 32 * this.window.scale;
/* 158 */     int cx = this.window.cx(dx);
/* 159 */     if (parentdx >= 0.0D) {
/*     */       
/* 161 */       col.render((SPRITE_RENDERER)CORE.renderer(), cx - d, cx + d, y - dy / 2, y);
/*     */       
/* 163 */       int px = this.window.cx(parentdx);
/*     */       
/* 165 */       col.render((SPRITE_RENDERER)CORE.renderer(), px - d, px + d, y - dy, y - dy / 2);
/*     */       
/* 167 */       int x1 = Math.min(cx, px);
/* 168 */       int xx2 = Math.max(cx, px);
/*     */       
/* 170 */       col.render((SPRITE_RENDERER)CORE.renderer(), x1 - d, xx2 + d, y - dy / 2 - d, y - dy / 2 + d);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hovered() {
/* 177 */     return this.hoverRef;
/*     */   }
/*     */   
/*     */   private static class Window
/*     */   {
/* 182 */     public final Rec view = new Rec(C.WIDTH(), C.HEIGHT());
/* 183 */     public int scale = 1;
/*     */     private boolean dragging = false;
/* 185 */     private Coo clickedCoo = new Coo();
/* 186 */     private final Rec max = new Rec();
/* 187 */     private final COLOR bg = (COLOR)new ColorImp(35, 74, 80);
/*     */ 
/*     */ 
/*     */     
/*     */     void init(int ref, UIFamilyTreeRefs refs, UIFamilyTreeAligner poss) {
/* 192 */       for (int i = 0; i < refs.max(); i++) {
/* 193 */         double cx = poss.x2(i) * this.scale * 62.0D + (this.scale * 50 / 2);
/* 194 */         double cy = poss.level(i) * this.scale * 106.0D + (this.scale * 74 / 2);
/* 195 */         if (i == 0) {
/* 196 */           this.max.moveX1Y1(cx, cy);
/* 197 */           this.max.setDim(0.0D);
/*     */         } 
/* 199 */         this.max.unify((int)cx, (int)cy);
/* 200 */         if (ref == refs.get(i))
/*     */         {
/* 202 */           this.view.moveC(cx, cy);
/*     */         }
/*     */       } 
/*     */       
/* 206 */       this.max.incrX((-C.WIDTH() + 50));
/* 207 */       this.max.incrW((C.WIDTH() * 2 - 100));
/* 208 */       this.max.incrY((-C.HEIGHT() + 50));
/* 209 */       this.max.incrH((C.HEIGHT() * 2 - 100));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(double ds) {
/* 215 */       this.dragging &= MButt.LEFT.isDown();
/*     */       
/* 217 */       double acc = 2000.0D;
/*     */       
/* 219 */       if ((KEYS.MAIN()).SCROLL_LEFT.isPressed()) {
/* 220 */         this.view.incrX(-acc * ds);
/* 221 */       } else if ((KEYS.MAIN()).SCROLL_RIGHT.isPressed()) {
/* 222 */         this.view.incrX(acc * ds);
/*     */       } 
/* 224 */       if ((KEYS.MAIN()).SCROLL_UP.isPressed()) {
/* 225 */         this.view.incrY(-acc * ds);
/* 226 */       } else if ((KEYS.MAIN()).SCROLL_DOWN.isPressed()) {
/* 227 */         this.view.incrY(acc * ds);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 232 */       if (this.dragging) {
/* 233 */         int dx = this.clickedCoo.x() - VIEW.mouse().x();
/* 234 */         int dy = this.clickedCoo.y() - VIEW.mouse().y();
/* 235 */         this.view.incr(dx, dy);
/* 236 */         this.clickedCoo.set((COORDINATE)VIEW.mouse());
/*     */       } 
/*     */ 
/*     */       
/* 240 */       if (this.view.x1() < this.max.x1()) {
/* 241 */         this.view.moveX1(this.max.x1());
/* 242 */       } else if (this.view.x2() > this.max.x2()) {
/* 243 */         this.view.moveX2(this.max.x2());
/*     */       } 
/* 245 */       if (this.view.y1() < this.max.y1()) {
/* 246 */         this.view.moveY1(this.max.y1());
/* 247 */       } else if (this.view.y2() > this.max.y2()) {
/* 248 */         this.view.moveY2(this.max.y2());
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     int sx(double x) {
/* 254 */       return (int)(x * this.scale * 62.0D - this.view.x1());
/*     */     }
/*     */     
/*     */     int sy(double x) {
/* 258 */       return (int)(x * this.scale * 106.0D - this.view.y1());
/*     */     }
/*     */     
/*     */     int cx(double x) {
/* 262 */       return (int)(x * this.scale * 62.0D - this.view.x1() + (this.scale * 50 / 2));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void renderBG() {
/* 269 */       int dim = 64;
/*     */       
/* 271 */       OPACITY.O25.bind();
/* 272 */       this.bg.bind();
/*     */       
/* 274 */       for (int sy = 0; sy < C.HEIGHT(); sy += dim) {
/* 275 */         for (int sx = 0; sx < C.WIDTH(); sx += dim) {
/*     */           
/* 277 */           double tx = ((sx + this.view.x1()) / 4);
/* 278 */           double ty = ((sy + this.view.y1()) / 4);
/* 279 */           CORE.renderer().renderSprite(sx, sx + dim, sy, sy + dim, (SPRITES.textures()).dis_big.get(tx, ty));
/* 280 */           tx = ((sx + this.view.x1() + 128) / 4);
/* 281 */           ty = ((sy + this.view.y1() + 128) / 4);
/* 282 */           CORE.renderer().renderSprite(sx, sx + dim, sy, sy + dim, (SPRITES.textures()).dis_low.get(tx, ty));
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 287 */       OPACITY.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTreeDrawer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
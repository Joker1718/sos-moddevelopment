/*     */ package view.ui.economy;
/*     */ import game.GAME;
/*     */ import game.faction.player.PCredits;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ final class MainChart extends GuiSection {
/*  26 */   private int am = GAME.player().credits().creditsH().historyRecords();
/*     */   private INT.IntImp hi;
/*     */   private final int w;
/*     */   private int loCredits;
/*     */   private double maxin;
/*     */   private double maxout;
/*     */   
/*     */   MainChart(int height, INT.IntImp hi, int sw) {
/*  34 */     this.hi = hi;
/*  35 */     this.w = sw;
/*  36 */     addRelBody(4, DIR.S, (RENDEROBJ)amount());
/*  37 */     addRelBody(4, DIR.S, (RENDEROBJ)new Profits());
/*  38 */     addRelBody(8, DIR.S, (RENDEROBJ)new Losses());
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*  43 */     this.loCredits = Integer.MAX_VALUE;
/*  44 */     this.maxin = 0.0D;
/*  45 */     this.maxout = 0.0D;
/*  46 */     for (int i = 0; i < this.am; i++) {
/*  47 */       this.loCredits = Math.min(this.loCredits, GAME.player().credits().creditsH().get(i));
/*  48 */       int m = 0;
/*  49 */       int o = 0;
/*     */       
/*  51 */       for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*  52 */         m += h.IN.get(i);
/*  53 */         o += h.OUT.get(i);
/*     */       } 
/*     */       
/*  56 */       this.maxin = Math.max(this.maxin, m);
/*  57 */       this.maxout = Math.max(o, this.maxout);
/*     */     } 
/*  59 */     if (this.loCredits > 1)
/*  60 */       this.loCredits--; 
/*  61 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private GStaples amount() {
/*  67 */     GStaples s = new GStaples(this.am)
/*     */       {
/*     */         protected void hover(GBox box, int stapleI) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/*  77 */           if (MainChart.this.hi.get() >= 0) {
/*  78 */             setHovered(MainChart.this.hi.get());
/*     */           }
/*  80 */           super.render(r, ds, hoveredIs());
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean hover(COORDINATE mCoo) {
/*  85 */           if (super.hover(mCoo)) {
/*  86 */             MainChart.this.hi.set(hoverI());
/*  87 */             return true;
/*     */           } 
/*  89 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/*  94 */           return CLAMP.d(GAME.player().credits().creditsH().get(MainChart.this.am - stapleI - 1), 0.0D, 2.147483647E9D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void setColor(ColorImp c, int stapleI, double value) {
/*  99 */           c.set(COLOR.YELLOW100).saturateSelf(0.5D);
/*     */         }
/*     */       };
/* 102 */     s.normalize(true);
/* 103 */     s.body().setWidth((this.w * this.am));
/* 104 */     s.body().setHeight(78.0D);
/* 105 */     return s;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 111 */     if (this.hi.get() >= 0) {
/* 112 */       GBox b = (GBox)text;
/* 113 */       int si = this.am - this.hi.get() - 1;
/*     */ 
/*     */       
/* 116 */       int ri = 0;
/* 117 */       for (TRADABLE res : TR.ALL()) {
/* 118 */         int a = (GAME.player()).trade.inExported.history((MAPPED)res).get(si) - (GAME.player()).trade.outImported.history((MAPPED)res).get(si);
/* 119 */         if (a != 0) {
/* 120 */           b.add(res.icon());
/* 121 */           b.add((SPRITE)GFORMAT.iIncr(b.text(), a));
/* 122 */           b.space();
/* 123 */           ri++;
/* 124 */           if (ri >= 4) {
/* 125 */             ri = 0;
/* 126 */             b.NL(8);
/*     */           
/*     */           }
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 138 */       super.hoverInfoGet(text);
/*     */     } 
/*     */   }
/*     */   
/*     */   private final class Profits
/*     */     extends HOVERABLE.HoverableAbs {
/*     */     Profits() {
/* 145 */       this.body.setWidth((MainChart.this.w * MainChart.this.am));
/* 146 */       body().setHeight(112.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 152 */       GCOLOR.UI().border().render(r, (RECTANGLE)body(), 1);
/*     */       
/* 154 */       for (int x = 0; x < MainChart.this.am; x++) {
/*     */         
/* 156 */         int x1 = body().x1() + MainChart.this.w * x;
/*     */ 
/*     */ 
/*     */         
/* 160 */         if (x != MainChart.this.hi.get()) {
/* 161 */           GCOLOR.UI().bg().render(r, x1, x1 + MainChart.this.w, body().y1(), body().y2());
/*     */         }
/*     */         
/* 164 */         if (MainChart.this.maxin != 0.0D) {
/*     */ 
/*     */           
/* 167 */           int si = MainChart.this.am - x - 1;
/*     */           
/* 169 */           int y2 = body().y2();
/* 170 */           for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*     */             
/* 172 */             double d = h.IN.get(si) / MainChart.this.maxin;
/* 173 */             int hig = (int)Math.ceil(body().height() * d);
/* 174 */             ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(h.type.ordinal()));
/* 175 */             if (x == MainChart.this.hi.get()) {
/* 176 */               ColorImp.TMP.shadeSelf(1.5D);
/*     */             } else {
/* 178 */               ColorImp.TMP.shadeSelf(0.5D);
/*     */             } 
/* 180 */             ColorImp.TMP.render(r, x1, x1 + MainChart.this.w, y2 - hig, y2);
/*     */             
/* 182 */             if (hig > 1)
/* 183 */               ((COLOR)COLOR.UNIQUE.getC(h.type.ordinal())).render(r, x1 + 1, x1 + MainChart.this.w - 1, y2 - hig + 1, y2); 
/* 184 */             if (hig > 0)
/* 185 */               hig--; 
/* 186 */             y2 -= hig;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 197 */       if (super.hover(mCoo)) {
/* 198 */         int ii = (mCoo.x() - body().x1()) / MainChart.this.w;
/* 199 */         if (ii < MainChart.this.am)
/* 200 */           MainChart.this.hi.set(ii); 
/* 201 */         return true;
/*     */       } 
/* 203 */       return false;
/*     */     }
/*     */   }
/*     */   
/*     */   private final class Losses
/*     */     extends HOVERABLE.HoverableAbs
/*     */   {
/*     */     Losses() {
/* 211 */       this.body.setWidth((MainChart.this.w * MainChart.this.am));
/* 212 */       body().setHeight(112.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 218 */       GCOLOR.UI().border().render(r, (RECTANGLE)body(), 1);
/*     */       
/* 220 */       for (int x = 0; x < MainChart.this.am; x++) {
/*     */         
/* 222 */         int x1 = body().x1() + MainChart.this.w * x;
/*     */ 
/*     */ 
/*     */         
/* 226 */         if (x != MainChart.this.hi.get()) {
/* 227 */           GCOLOR.UI().bg().render(r, x1, x1 + MainChart.this.w, body().y1(), body().y2());
/*     */         }
/*     */         
/* 230 */         if (MainChart.this.maxout != 0.0D) {
/*     */ 
/*     */           
/* 233 */           int si = MainChart.this.am - x - 1;
/*     */           
/* 235 */           int y1 = body().y1();
/* 236 */           for (PCredits.CredHistory h : GAME.player().credits().all()) {
/*     */             
/* 238 */             double d = h.OUT.get(si) / MainChart.this.maxout;
/* 239 */             int hig = (int)Math.ceil(body().height() * d);
/* 240 */             ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(h.type.ordinal()));
/* 241 */             if (x == MainChart.this.hi.get()) {
/* 242 */               ColorImp.TMP.shadeSelf(1.5D);
/*     */             } else {
/* 244 */               ColorImp.TMP.shadeSelf(0.5D);
/*     */             } 
/* 246 */             ColorImp.TMP.render(r, x1, x1 + MainChart.this.w, y1, y1 + hig);
/*     */             
/* 248 */             if (hig > 1)
/* 249 */               ((COLOR)COLOR.UNIQUE.getC(h.type.ordinal())).render(r, x1 + 1, x1 + MainChart.this.w - 1, y1 - 1, y1 + hig); 
/* 250 */             if (hig > 0)
/* 251 */               hig--; 
/* 252 */             y1 += hig;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 263 */       if (super.hover(mCoo)) {
/* 264 */         int ii = (mCoo.x() - body().x1()) / MainChart.this.w;
/* 265 */         if (ii < MainChart.this.am)
/* 266 */           MainChart.this.hi.set(ii); 
/* 267 */         return true;
/*     */       } 
/* 269 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainChart.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
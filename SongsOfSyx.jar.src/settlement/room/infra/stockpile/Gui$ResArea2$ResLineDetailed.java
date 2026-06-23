/*     */ package settlement.room.infra.stockpile;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class ResLineDetailed
/*     */   extends GuiSection
/*     */ {
/*     */   private final GETTER<RESOURCE> res;
/* 525 */   RESOURCE prev = null;
/*     */   
/*     */   private final GSliderInt gg;
/*     */   private final INT.INTE crates;
/*     */   private final GETTER<StockpileInstance> g;
/*     */   
/*     */   ResLineDetailed(final GETTER<RESOURCE> res, final GETTER<StockpileInstance> g, final ACTION change) {
/* 532 */     add((SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 536 */             ((RESOURCE)res.get()).icon().render(r, X1, X2, Y1, Y2);
/*     */           }
/* 539 */         }0, 0);
/* 540 */     this.g = g;
/*     */     
/* 542 */     this.crates = new INT.INTE()
/*     */       {
/*     */         public int get()
/*     */         {
/* 546 */           return (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? ((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)res.get(), (StockpileInstance)g.get()) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public int min() {
/* 551 */           return (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? 0 : 1;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 556 */           if (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0)
/* 557 */             return ((StockpileInstance)g.get()).totalCrates(); 
/* 558 */           return Math.min(100, ((StockpileInstance)g.get()).crateSize());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 563 */           if (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) {
/* 564 */             int m = 0;
/* 565 */             for (int i = 0; i < RESOURCES.ALL().size(); i++) {
/* 566 */               if (i != ((RESOURCE)res.get()).index())
/*     */               {
/* 568 */                 m += ((SETT.ROOMS()).STOCKPILE.tally()).crates.get(i, (StockpileInstance)g.get());
/*     */               }
/*     */             } 
/* 571 */             if (m + t > ((StockpileInstance)g.get()).totalCrates()) {
/* 572 */               t = ((StockpileInstance)g.get()).totalCrates() - m;
/*     */             }
/* 574 */             ((StockpileInstance)g.get()).allocateCrate((RESOURCE)res.get(), t);
/*     */           } else {
/* 576 */             ((StockpileInstance)g.get()).setSpecialAmount((RESOURCE)res.get(), t);
/*     */           } 
/* 578 */           change.exe();
/*     */         }
/*     */       };
/*     */     
/* 582 */     this.gg = new GSliderInt(this.crates, 160, 24, true)
/*     */       {
/*     */         protected void renderMidColor(SPRITE_RENDERER r, int x1, int width, int widthFull, int y1, int y2)
/*     */         {
/* 586 */           double a = ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get());
/* 587 */           double c = ((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? (Gui.ResArea2.ResLineDetailed.this.crates.get() * ((StockpileInstance)g.get()).crateSize((RESOURCE)res.get())) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()));
/* 588 */           double d = 0.0D;
/* 589 */           if (c > 0.0D)
/* 590 */             d = a / c; 
/* 591 */           GMeter.GMeterCol col = GMeter.C_INACTIVE;
/* 592 */           if (d > 0.9D) {
/* 593 */             col = GMeter.C_REDPURPLE;
/* 594 */           } else if (c > 0.0D) {
/* 595 */             col = GMeter.C_REDGREEN;
/*     */           } else {
/* 597 */             GMeter.render(r, GMeter.C_INACTIVE, d, (RECTANGLE)body());
/*     */           } 
/* 599 */           col.bg.render(r, x1, x1 + width, y1, y2);
/*     */           
/* 601 */           col.dark.render(r, x1, (int)(x1 + width * d), y1, y2);
/* 602 */           col.bright.render(r, x1, (int)(x1 + width * d), y1 + 1, y2 - 1);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {}
/*     */       };
/* 612 */     addRightC(4, (RENDEROBJ)this.gg);
/*     */     
/* 614 */     GStat s = new GStat()
/*     */       {
/*     */         public void update(GText text) {
/* 617 */           GFORMAT.i(text, ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get()));
/*     */           
/* 619 */           double max = ((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? (Gui.ResArea2.ResLineDetailed.this.crates.get() * ((StockpileInstance)g.get()).crateSize((RESOURCE)res.get())) : ((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()));
/* 620 */           if (max == 0.0D) {
/* 621 */             text.color((GCOLOR.T()).NORMAL);
/*     */           } else {
/* 623 */             double am = ((SETT.ROOMS()).STOCKPILE.tally()).amount.get((RESOURCE)res.get(), (StockpileInstance)g.get());
/* 624 */             double d = am / max;
/* 625 */             if (d < 0.5D) {
/* 626 */               ColorImp.TMP.interpolate((GCOLOR.T()).IBAD, (GCOLOR.T()).WARNING, d * 2.0D);
/*     */             } else {
/* 628 */               ColorImp.TMP.interpolate((GCOLOR.T()).WARNING, (GCOLOR.T()).IGREAT, (d - 0.5D) * 2.0D);
/*     */             } 
/* 630 */             text.color((COLOR)ColorImp.TMP);
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 637 */           if (Gui.ResArea2.ResLineDetailed.this.hoveredIs() || Gui.ResArea2.ResLineDetailed.this.crates.get() == 0)
/*     */             return; 
/* 639 */           OPACITY.O50.bind();
/* 640 */           COLOR.BLACK.render(r, X1 - 2, X2 + 2, Y1 - 1, Y2 + 2);
/* 641 */           OPACITY.unbind();
/* 642 */           super.render(r, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/*     */     
/* 646 */     addCentredY((RENDEROBJ)s.r(DIR.E), getLastX2() - 38 - 36);
/*     */     
/* 648 */     addCentredY((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrowDown)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 652 */             ((StockpileInstance)g.get()).setSpecialAmount((RESOURCE)res.get(), (((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) == 0) ? Math.min(100, ((StockpileInstance)g.get()).crateSize()) : 0);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 657 */             activeSet(!(((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)res.get(), (StockpileInstance)g.get()) <= 0 && ((StockpileInstance)g.get()).totalCrates() - ((SETT.ROOMS()).STOCKPILE.tally()).crates.get((RESOURCE)null, (StockpileInstance)g.get()) <= 0));
/* 658 */             selectedSet((((StockpileInstance)g.get()).getSpecialAmount((RESOURCE)res.get()) > 0));
/*     */           }
/* 661 */         }).hoverInfoSet(Gui.¤¤special), body().x2() + 2);
/*     */ 
/*     */     
/* 664 */     pad(6, 2);
/*     */     
/* 666 */     this.res = res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 672 */     if (this.res.get() != this.prev)
/* 673 */       this.gg.reset(); 
/* 674 */     this.prev = (RESOURCE)this.res.get();
/* 675 */     if (this.res.get() == null)
/*     */       return; 
/* 677 */     GCOLOR.UI().border().render(r, (RECTANGLE)body(), -2);
/* 678 */     boolean hov = hoveredIs();
/* 679 */     super.render(r, ds);
/* 680 */     if (this.crates.get() == 0 && !hov) {
/* 681 */       OPACITY.O25.bind();
/* 682 */       COLOR.BLACK.render(r, (RECTANGLE)body());
/* 683 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 689 */     if (this.res.get() != this.prev)
/* 690 */       this.gg.reset(); 
/* 691 */     this.prev = (RESOURCE)this.res.get();
/* 692 */     if (this.res.get() == null)
/*     */       return; 
/* 694 */     super.hoverInfoGet(text);
/* 695 */     if (text.emptyIs()) {
/* 696 */       Gui.hover(text, (StockpileInstance)this.g.get(), (RESOURCE)this.res.get());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 702 */     if (this.res.get() != this.prev)
/* 703 */       this.gg.reset(); 
/* 704 */     this.prev = (RESOURCE)this.res.get();
/* 705 */     if (this.res.get() == null)
/* 706 */       return false; 
/* 707 */     return super.click();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\stockpile\Gui$ResArea2$ResLineDetailed.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
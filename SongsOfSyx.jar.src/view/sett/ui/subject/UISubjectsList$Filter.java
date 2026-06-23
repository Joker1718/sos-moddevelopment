/*     */ package view.sett.ui.subject;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import init.type.HTYPE_RACE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GRows;
/*     */ import util.info.GFORMAT;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Filter
/*     */   extends GuiSection
/*     */ {
/*     */   Filter(final UISubjectsList.Li li) {
/* 544 */     GRows rows = new GRows(7);
/*     */     
/* 546 */     rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).m.cancel)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 550 */             li.race.setAll(false);
/*     */           }
/* 553 */         }).hoverInfoSet(UISubjectsList.¤¤all));
/*     */     
/* 555 */     rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 559 */             li.race.setAll(true);
/*     */           }
/* 562 */         }).hoverInfoSet(UISubjectsList.¤¤clear));
/*     */     
/* 564 */     for (Race ra : RACES.all()) {
/*     */       
/* 566 */       rows.add((RENDEROBJ)new Butt((SPRITE)(ra.appearance()).icon)
/*     */           {
/*     */             
/*     */             protected void hov(GBox b)
/*     */             {
/* 571 */               b.title(ra.info.names);
/* 572 */               b.text(ra.info.desc);
/* 573 */               b.sep();
/*     */               
/* 575 */               for (HTYPE t : HTYPES.ALL()) {
/* 576 */                 int p = (STATS.POP()).POP.type().get(HTYPE_RACE.get(ra, t));
/* 577 */                 if (t.visible() && p > 0) {
/* 578 */                   b.add(t.icon);
/* 579 */                   b.textLL(t.names);
/* 580 */                   b.tab(6);
/* 581 */                   b.add((SPRITE)GFORMAT.i(b.text(), p));
/* 582 */                   b.NL();
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 587 */               b.NL();
/*     */               
/* 589 */               b.add((HTYPES.SOLDIER()).icon);
/* 590 */               b.textLL((HTYPES.SOLDIER()).names);
/* 591 */               b.tab(6);
/* 592 */               b.add((SPRITE)GFORMAT.i(b.text(), AD.cityDivs().total(ra)));
/*     */               
/* 594 */               b.NL(8);
/*     */               
/* 596 */               b.add((SPRITE)(UI.icons()).s.arrow_left);
/* 597 */               b.textLL(UISubjectsList.¤¤incoming);
/* 598 */               b.tab(6);
/* 599 */               b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().onTheirWay(ra, null)));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected int get() {
/* 605 */               return POP.tot(null, ra);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 610 */               selectedSet(li.race.get(ra.index));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 615 */               li.race.toggle(ra.index());
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */     
/* 621 */     for (RENDEROBJ o : rows.rows()) {
/* 622 */       addDown(0, o);
/*     */     }
/* 624 */     body().incrH(8.0D);
/*     */     
/* 626 */     rows = new GRows(8);
/*     */     
/* 628 */     rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).s.cancel.createColored((GCOLOR.UI()).BAD.hovered))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 632 */             li.type.setAll(false);
/* 633 */             li.favorite = false;
/* 634 */             li.soldier = false;
/*     */           }
/* 637 */         }).hoverInfoSet(UISubjectsList.¤¤all));
/*     */     
/* 639 */     rows.add((RENDEROBJ)(new ButtS((SPRITE)(UI.icons()).s.arrow_right.createColored((GCOLOR.UI()).GOOD.hovered))
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 643 */             li.type.setAll(true);
/* 644 */             li.favorite = false;
/* 645 */             li.soldier = false;
/*     */           }
/* 648 */         }).hoverInfoSet(UISubjectsList.¤¤clear));
/*     */     
/* 650 */     rows.add((RENDEROBJ)new Butt((SPRITE)(UI.icons()).s.heart)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 654 */             li.favorite = !li.favorite;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 659 */             selectedSet(li.favorite);
/*     */           }
/*     */ 
/*     */           
/*     */           protected int get() {
/* 664 */             return li.favos;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void hov(GBox b) {
/* 669 */             b.title(UISubjectsList.¤¤favo);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 674 */     rows.add((RENDEROBJ)new Butt((HTYPES.SOLDIER()).icon)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 678 */             li.soldier = !li.soldier;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 683 */             selectedSet(li.soldier);
/*     */           }
/*     */ 
/*     */           
/*     */           protected int get() {
/* 688 */             return li.sols;
/*     */           }
/*     */ 
/*     */           
/*     */           protected void hov(GBox b) {
/* 693 */             b.title((HTYPES.SOLDIER()).name);
/* 694 */             b.text((HTYPES.SOLDIER()).desc);
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 699 */     for (HTYPE t : HTYPES.ALL()) {
/* 700 */       if (!t.visible()) {
/*     */         continue;
/*     */       }
/* 703 */       rows.add((RENDEROBJ)new Butt(t.icon)
/*     */           {
/*     */             protected void hov(GBox b)
/*     */             {
/* 707 */               int tab = 0;
/* 708 */               b.title(t.names);
/* 709 */               b.text(t.desc);
/* 710 */               b.NL();
/* 711 */               for (Race r : RACES.all()) {
/* 712 */                 b.tab(tab);
/*     */                 
/* 714 */                 b.add((SPRITE)(r.appearance()).icon);
/* 715 */                 b.add((SPRITE)GFORMAT.i(b.text(), STATS.POP().pop(r, t)));
/* 716 */                 b.space();
/* 717 */                 tab += 3;
/* 718 */                 if (tab > 9) {
/* 719 */                   b.NL();
/* 720 */                   tab = 0;
/*     */                 } 
/*     */               } 
/* 723 */               b.NL(8);
/*     */               
/* 725 */               b.add((SPRITE)(UI.icons()).s.arrow_left);
/* 726 */               b.textLL(UISubjectsList.¤¤incoming);
/* 727 */               b.tab(6);
/* 728 */               b.add((SPRITE)GFORMAT.i(b.text(), SETT.ENTRY().onTheirWay(null, t)));
/*     */             }
/*     */ 
/*     */             
/*     */             protected int get() {
/* 733 */               return STATS.POP().pop(t);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 738 */               selectedSet(li.type.get(t.index()));
/*     */             }
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 743 */               li.type.toggle(t.index());
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 751 */     for (RENDEROBJ o : rows.rows()) {
/* 752 */       addDown(0, o);
/*     */     }
/*     */   }
/*     */   
/*     */   private static abstract class Butt
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final SPRITE icon;
/* 760 */     private final GText tt = new GText((UI.FONT()).S, 16);
/*     */ 
/*     */     
/*     */     Butt(SPRITE icon) {
/* 764 */       super(icon.height() + 56, icon.height() + 8);
/* 765 */       this.icon = icon;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 771 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 772 */       this.icon.renderCY(r, this.body.x1() + 4, body().cY());
/* 773 */       GFORMAT.i(this.tt.clear(), get());
/* 774 */       this.tt.renderCY(r, body().x1() + 8 + this.icon.width(), this.body.cY());
/* 775 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract int get();
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 782 */       hov((GBox)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract void hov(GBox param2GBox);
/*     */   }
/*     */   
/*     */   private static class ButtS
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final SPRITE icon;
/*     */     
/*     */     ButtS(SPRITE icon) {
/* 795 */       super(icon.height() + 56, icon.height() + 8);
/* 796 */       this.icon = icon;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 802 */       GButt.ButtPanel.renderBG(r, isActive, isSelected, isHovered, (RECTANGLE)this.body);
/* 803 */       this.icon.renderC(r, this.body.cX(), body().cY());
/* 804 */       GButt.ButtPanel.renderFrame(r, (RECTANGLE)this.body);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\UISubjectsList$Filter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
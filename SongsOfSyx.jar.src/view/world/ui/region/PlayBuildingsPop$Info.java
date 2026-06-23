/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuildPoints;
/*     */ import world.region.building.RDBuilding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Info
/*     */   extends GuiSection
/*     */ {
/*     */   Info() {
/* 635 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel(Dic.¤¤Accept)
/*     */       {
/*     */         protected void clickA() {
/* 638 */           if (((Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()).faction() == FACTIONS.player())
/* 639 */             FACTIONS.player().credits().inc(-RD.BUILDINGS().tmp().cost(), FCredits.CTYPE.CONSTRUCTION); 
/* 640 */           RD.BUILDINGS().tmp().accept();
/* 641 */           (VIEW.inters()).section.close();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 646 */           if (!RD.BUILDINGS().tmp().hasChange()) {
/* 647 */             activeSet(false);
/*     */             
/*     */             return;
/*     */           } 
/* 651 */           if (RD.BUILDINGS().tmp().canAfford()) {
/* 652 */             activeSet(true);
/*     */             
/*     */             return;
/*     */           } 
/* 656 */           for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 657 */             if (RD.BUILDINGS().tmp().level(b, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()) > b.level.get((PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).current)) {
/* 658 */               activeSet(false);
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           
/* 664 */           activeSet(true);
/*     */         }
/*     */       };
/* 667 */     addRightC(0, (RENDEROBJ)buttPanel);
/*     */ 
/*     */     
/* 670 */     CLICKABLE cLICKABLE = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_left)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 674 */           RD.BUILDINGS().tmp(true, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get());
/* 675 */           super.clickA();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 680 */           activeSet(RD.BUILDINGS().tmp().hasChange());
/*     */         }
/* 684 */       }).pad(4, 4).hoverInfoSet(Dic.¤¤cancel);
/* 685 */     addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */     
/* 687 */     cLICKABLE = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.cancel)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 691 */           for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 692 */             RD.BUILDINGS().tmp().levelSet(b, 0);
/*     */           }
/* 694 */           super.clickA();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 699 */           boolean a = false;
/* 700 */           for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 701 */             if (RD.BUILDINGS().tmp().level(b, (Region)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()) > 0) {
/* 702 */               a = true; break;
/*     */             } 
/*     */           } 
/* 705 */           activeSet(a);
/*     */         }
/* 708 */       }).pad(4, 4).hoverInfoSet(PlayBuildingsPop.¤¤RemoveAll);
/* 709 */     addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */     
/* 711 */     GuiSection butts = new GuiSection();
/*     */     
/* 713 */     butts.addRightC(16, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 717 */             int am = RD.BUILDINGS().tmp().cost();
/* 718 */             GFORMAT.i(text, -am);
/* 719 */             if (am > FACTIONS.player().credits().getD()) {
/* 720 */               text.errorify();
/* 721 */             } else if (am == 0) {
/* 722 */               text.color(COLOR.WHITE50);
/*     */             } else {
/* 724 */               text.normalify2();
/*     */             }  }
/* 726 */         }).hh((SPRITE)(UI.icons()).s.money));
/*     */     
/* 728 */     for (RDBuildPoints.RDBuildPoint c : (RD.BUILDINGS()).costs.ALL) {
/* 729 */       butts.addRightC(64, boost(c.bo, c.icon));
/*     */     }
/*     */     
/* 732 */     butts.body().incrW(64.0D);
/*     */     
/* 734 */     addRelBody(4, DIR.N, (RENDEROBJ)butts);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ boost(final Boostable bo, SPRITE icon) {
/* 742 */     return (RENDEROBJ)(new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 746 */           bo.get((BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get());
/* 747 */           GFORMAT.iIncr(text, (int)bo.get((BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get()));
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 754 */           b.title(bo.name);
/* 755 */           b.text(bo.desc);
/* 756 */           b.sep();
/* 757 */           bo.hover((GUI_BOX)b, (BOOSTABLE_O)(PlayBuildingsPop.Info.access$0(PlayBuildingsPop.Info.this)).g.get(), null, true);
/*     */         }
/* 760 */       }).hh(icon);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayBuildingsPop$Info.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
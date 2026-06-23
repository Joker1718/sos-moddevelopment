/*      */ package settlement.room.service.food.eatery;
/*      */ 
/*      */ import init.race.RACES;
/*      */ import init.race.Race;
/*      */ import init.resources.RESOURCE;
/*      */ import init.settings.S;
/*      */ import init.sprite.UI.UI;
/*      */ import settlement.room.industry.module.IndustryResource;
/*      */ import settlement.room.main.Room;
/*      */ import settlement.room.main.RoomInstance;
/*      */ import settlement.room.main.util.RoomTally;
/*      */ import snake2d.SPRITE_RENDERER;
/*      */ import snake2d.util.datatypes.COORDINATE;
/*      */ import snake2d.util.datatypes.DIR;
/*      */ import snake2d.util.gui.GUI_BOX;
/*      */ import snake2d.util.gui.GuiSection;
/*      */ import snake2d.util.gui.renderable.RENDEROBJ;
/*      */ import snake2d.util.sets.LISTE;
/*      */ import snake2d.util.sets.Stack;
/*      */ import snake2d.util.sprite.SPRITE;
/*      */ import snake2d.util.sprite.text.Str;
/*      */ import util.data.GETTER;
/*      */ import util.gui.misc.GBox;
/*      */ import util.gui.misc.GButt;
/*      */ import util.gui.misc.GChart;
/*      */ import util.gui.misc.GGrid;
/*      */ import util.gui.misc.GStat;
/*      */ import util.gui.misc.GText;
/*      */ import util.info.GFORMAT;
/*      */ import util.statistics.HISTORY;
/*      */ import view.sett.ui.room.ModuleIndustry;
/*      */ import view.sett.ui.room.UIRoomModule;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class Gui
/*      */   extends UIRoomModule
/*      */ {
/*      */   private final CharSequence sFood;
/*      */   
/*      */   Gui(CharSequence food) {
/*  743 */     this.sFood = food;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/*  751 */     GuiSection s = new GuiSection();
/*  752 */     int i = 0;
/*  753 */     for (RESOURCE e : RoomDistribution.this.all) {
/*  754 */       final int ri = RoomDistribution.this.resourceIs[e.index()];
/*  755 */       GButt.BSection bSection = new GButt.BSection()
/*      */         {
/*      */           public void hoverInfoGet(GUI_BOX text)
/*      */           {
/*  759 */             RoomDistribution.RoomDistributionIns ins = (RoomDistribution.RoomDistributionIns)get.get();
/*      */             
/*  761 */             GBox b = (GBox)text;
/*  762 */             b.title(e.name);
/*  763 */             b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).name);
/*  764 */             b.tab(6);
/*  765 */             b.add((SPRITE)GFORMAT.iofkInv(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get()), (ins.distributionData()).maxAmount));
/*  766 */             b.NL();
/*  767 */             b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allIncoming.get(ri)).name);
/*  768 */             b.tab(6);
/*  769 */             b.add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allIncoming.get(ri)).get((RoomInstance)get.get())));
/*  770 */             b.NL();
/*      */ 
/*      */             
/*  773 */             b.textLL(String.valueOf(RoomDistribution.¤¤Consumed) + "(" + String.valueOf(RoomDistribution.¤¤Consumed) + ")");
/*  774 */             b.tab(6);
/*  775 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)-((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).day.getD(ins.distributionData())));
/*  776 */             b.NL();
/*  777 */             b.textLL(String.valueOf(RoomDistribution.¤¤Consumed) + "(" + String.valueOf(RoomDistribution.¤¤Consumed) + ")");
/*  778 */             b.tab(6);
/*  779 */             b.add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).year.get(ins.distributionData())));
/*  780 */             b.NL();
/*      */             
/*  782 */             b.sep();
/*  783 */             b.textLL(RoomDistribution.¤¤Preferred);
/*  784 */             b.NL();
/*  785 */             for (Race r : RACES.all()) {
/*  786 */               if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).isPref(e, r)) {
/*  787 */                 b.add((SPRITE)(r.appearance()).icon);
/*      */               }
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           protected void renAction() {
/*  795 */             RoomDistribution.RoomDistributionIns ins = (RoomDistribution.RoomDistributionIns)get.get();
/*  796 */             selectedSet((ins.distributionData()).useMask.has(e));
/*      */           }
/*      */ 
/*      */           
/*      */           protected void clickA() {
/*  801 */             RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomInstance)get.get());
/*      */           }
/*      */         };
/*      */ 
/*      */       
/*  806 */       bSection.addRightC(4, (SPRITE)e.icon());
/*      */       
/*  808 */       bSection.addRightC(4, (SPRITE)new GStat()
/*      */           {
/*      */             public void update(GText text)
/*      */             {
/*  812 */               GFORMAT.i(text, ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get()));
/*      */             }
/*      */ 
/*      */             
/*      */             public void hoverInfoGet(GBox b) {
/*  817 */               b.title(e.name);
/*  818 */               b.textLL(RoomDistribution.Gui.this.sFood).add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).get((RoomInstance)get.get())));
/*      */             }
/*      */           });
/*      */       
/*  822 */       bSection.body().incrW(48.0D);
/*  823 */       bSection.pad(4);
/*      */       
/*  825 */       s.add((RENDEROBJ)bSection, i % 3 * bSection.body().width(), i / 3 * bSection.body().height());
/*  826 */       i++;
/*      */     } 
/*      */ 
/*      */     
/*  830 */     GuiSection ss = new GuiSection();
/*  831 */     ss.add((RENDEROBJ)(new GStat()
/*      */         {
/*      */           public void update(GText text)
/*      */           {
/*  835 */             GFORMAT.i(text, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.get((RoomInstance)get.get()));
/*      */           }
/*      */ 
/*      */           
/*      */           public void hoverInfoGet(GBox b) {
/*  840 */             if ((S.get()).developer) {
/*  841 */               b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.name);
/*  842 */               b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.get((RoomInstance)get.get())));
/*  843 */               b.NL();
/*  844 */               b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tIncoming.name);
/*  845 */               b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tIncoming.get((RoomInstance)get.get())));
/*  846 */               b.NL();
/*  847 */               b.textLL((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tReserved.name);
/*  848 */               b.add((SPRITE)GFORMAT.i(b.text(), (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tReserved.get((RoomInstance)get.get())));
/*  849 */               b.NL();
/*      */             }
/*      */           
/*      */           }
/*  853 */         }).hh(this.sFood));
/*      */     
/*  855 */     ss.addRightC(48, (RENDEROBJ)(new GStat()
/*      */         {
/*      */           
/*      */           public void update(GText text)
/*      */           {
/*  860 */             double tot = 0.0D;
/*  861 */             double worked = 0.0D;
/*      */             
/*  863 */             for (COORDINATE c : ((RoomInstance)get.get()).body()) {
/*  864 */               if (((RoomInstance)get.get()).is(c) && 
/*  865 */                 RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).isCrate(c.x(), c.y()) && RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).job(c.x(), c.y()) != null) {
/*  866 */                 tot += ((RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).maxRations * 8);
/*  867 */                 worked += (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).crate.workAmount.get();
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  872 */             GFORMAT.perc(text, worked / tot);
/*      */           }
/*  875 */         }).hh((SPRITE)(UI.icons()).s.hammer).hoverInfoSet(RoomDistribution.¤¤worked));
/*      */     
/*  877 */     ss.addRightC(48, ModuleIndustry.makeFetch(get));
/*  878 */     ss.body().incrW(48.0D);
/*      */     
/*  880 */     s.addRelBody(2, DIR.N, (RENDEROBJ)ss);
/*      */     
/*  882 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void hover(GBox b, Room room, int rx, int ry) {
/*  888 */     RoomInstance ins = (RoomInstance)room;
/*  889 */     RoomDistribution.RoomDistributionIns dd = (RoomDistribution.RoomDistributionIns)room;
/*  890 */     b.NL();
/*  891 */     b.textLL(this.sFood).add((SPRITE)GFORMAT.i(b.text(), RoomDistribution.this.tStored.get(ins)));
/*  892 */     b.NL();
/*  893 */     for (int i = 0; i < RoomDistribution.this.all.size(); i++) {
/*  894 */       RESOURCE r = (RESOURCE)RoomDistribution.this.all.get(i);
/*  895 */       b.add((SPRITE)r.icon());
/*  896 */       GText t = b.text();
/*  897 */       GFORMAT.i(t, ((RoomTally.TallyEntry)RoomDistribution.this.allStored.get(i)).get(ins));
/*  898 */       if (!(dd.distributionData()).useMask.has(r))
/*  899 */         t.errorify(); 
/*  900 */       b.add((SPRITE)t);
/*  901 */       b.space();
/*  902 */       if (i % 6 == 5) {
/*  903 */         b.NL();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  908 */     b.NL();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/*  915 */     GuiSection s = new GuiSection();
/*  916 */     final GChart cc = new GChart();
/*      */     
/*  918 */     int i = 0;
/*  919 */     int m = 5;
/*      */ 
/*      */ 
/*      */     
/*  923 */     for (RESOURCE e : RoomDistribution.this.all) {
/*  924 */       final int ri = RoomDistribution.this.resourceIs[e.index()];
/*      */       
/*  926 */       SPRITE.Imp imp = new SPRITE.Imp(70, 24)
/*      */         {
/*  928 */           GText t = new GText((UI.FONT()).S, 6);
/*      */ 
/*      */           
/*      */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  932 */             e.icon().render(r, X1, Y1);
/*  933 */             this.t.clear();
/*  934 */             GFORMAT.i(this.t, ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).total.get());
/*  935 */             this.t.renderCY(r, X1 + 26, Y1 + (Y2 - Y1) / 2);
/*      */           }
/*      */         };
/*      */       
/*  939 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)imp)
/*      */         {
/*      */           protected void clickA() {
/*  942 */             if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e)) {
/*  943 */               for (int i = 0; i < (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.instancesSize(); i++) {
/*  944 */                 RoomDistribution.RoomDistributionIns ii = (RoomDistribution.RoomDistributionIns)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i);
/*  945 */                 if ((ii.distributionData()).useMask.has(e)) {
/*  946 */                   RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i));
/*      */                 }
/*      */               } 
/*      */             } else {
/*  950 */               for (int i = 0; i < (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.instancesSize(); i++) {
/*  951 */                 RoomDistribution.RoomDistributionIns ii = (RoomDistribution.RoomDistributionIns)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i);
/*  952 */                 if (!(ii.distributionData()).useMask.has(e)) {
/*  953 */                   RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).usesToggle(e, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).blue.getInstance(i));
/*      */                 }
/*      */               } 
/*      */             } 
/*  957 */             super.clickA();
/*      */           }
/*      */ 
/*      */           
/*      */           public void hoverInfoGet(GUI_BOX text) {
/*  962 */             GBox b = (GBox)text;
/*  963 */             b.title(e.name);
/*  964 */             if (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e)) {
/*  965 */               b.text(RoomDistribution.¤¤uses);
/*      */             } else {
/*  967 */               b.text(RoomDistribution.¤¤usesN);
/*      */             } 
/*  969 */             b.NL();
/*      */             
/*  971 */             b.title(e.name);
/*  972 */             b.textLL(((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).name);
/*  973 */             b.tab(6);
/*  974 */             b.add((SPRITE)GFORMAT.i(b.text(), ((RoomTally.TallyEntry)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).allStored.get(ri)).total.get()));
/*  975 */             b.NL(8);
/*  976 */             b.textLL(RoomDistribution.¤¤Consumed);
/*  977 */             b.tab(6);
/*  978 */             b.add((SPRITE)GFORMAT.i(b.text(), -((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).history().get()));
/*  979 */             b.NL();
/*  980 */             cc.clear();
/*  981 */             cc.add((HISTORY)((IndustryResource)(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).industry.ins().get(ri)).history());
/*  982 */             b.add((RENDEROBJ)cc);
/*      */             
/*  984 */             b.sep();
/*  985 */             b.textLL(RoomDistribution.¤¤Preferred);
/*  986 */             b.NL();
/*  987 */             for (Race r : RACES.all()) {
/*  988 */               if ((r.pref()).foodMask.has(e)) {
/*  989 */                 b.add((SPRITE)(r.appearance()).icon);
/*      */               }
/*      */             } 
/*      */           }
/*      */ 
/*      */ 
/*      */           
/*      */           protected void renAction() {
/*  997 */             selectedSet(RoomDistribution.Gui.access$0(RoomDistribution.Gui.this).uses(e));
/*      */           }
/*      */         };
/*      */       
/* 1001 */       s.add((RENDEROBJ)buttPanel, i % m * buttPanel.body().width(), i / m * buttPanel.body().height());
/* 1002 */       i++;
/*      */     } 
/*      */ 
/*      */     
/* 1006 */     s.add((RENDEROBJ)(new GStat()
/*      */         {
/*      */           public void update(GText text)
/*      */           {
/* 1010 */             GFORMAT.i(text, (RoomDistribution.Gui.access$0(RoomDistribution.Gui.this)).tStored.total.get());
/*      */           }
/* 1013 */         }).hh(this.sFood), 0, s.body().y1() - 16);
/*      */     
/* 1015 */     text.add((RENDEROBJ)s);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room r, int rx, int ry) {
/* 1024 */     ModuleIndustry.fetchProblem(free, errors, warnings, (RoomInstance)r);
/*      */   }
/*      */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\eatery\RoomDistribution$Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
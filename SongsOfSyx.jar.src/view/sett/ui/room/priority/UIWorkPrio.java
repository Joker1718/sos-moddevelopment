/*     */ package view.sett.ui.room.priority;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPE_RACE;
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ 
/*     */ public final class UIWorkPrio extends ISidePanel {
/*  26 */   static CharSequence ¤¤title = "Work Priorities";
/*  27 */   static CharSequence ¤¤Adjust = "¤Adjust all by 1.";
/*     */   
/*  29 */   static CharSequence ¤¤FilterW = "¤Filter Workplaces";
/*  30 */   static CharSequence ¤¤FilterG = "¤Filter Work Groups";
/*     */   
/*  32 */   static CharSequence ¤¤setWork = "Set all priorities based on work skill.";
/*  33 */   static CharSequence ¤¤setFull = "Set all priorities based on fulfillment."; private final Filter<WGROUP> filterGroup;
/*     */   
/*     */   static {
/*  36 */     D.ts(UIWorkPrio.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public UIWorkPrio() {
/*  42 */     D.t(this);
/*  43 */     titleSet(¤¤title);
/*     */     
/*  45 */     ArrayListGrower<Filter.FilterEntry<RoomEmployment>> rooms = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     ArrayListGrower<Filter.FilterEntry<WGROUP>> rr = new ArrayListGrower();
/*     */     
/*  52 */     for (WGROUP g : WGROUP.all()) {
/*  53 */       Filter.FilterEntry<WGROUP> ee = new Filter.FilterEntry<WGROUP>(g.name, g.icon, g)
/*     */         {
/*     */           public boolean isRelavant()
/*     */           {
/*  57 */             return ((STATS.POP()).POP.type().get(HTYPE_RACE.get(g.race, g.type)) > 0);
/*     */           }
/*     */         };
/*     */       
/*  61 */       rr.add(ee);
/*     */     } 
/*     */     
/*  64 */     ArrayListGrower<Filter.FilterCombined<WGROUP>> arrayListGrower = new ArrayListGrower();
/*  65 */     this.filterGroup = new Filter<>((SPRITE)(UI.icons()).s.human, ¤¤FilterG, (LIST<Filter.FilterEntry<WGROUP>>)rr, (LIST<Filter.FilterCombined<WGROUP>>)arrayListGrower);
/*  66 */     this.section.addRightC(0, (RENDEROBJ)this.filterGroup);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     ArrayListGrower<Filter.FilterCombined<RoomEmployment>> cc = new ArrayListGrower();
/*     */ 
/*     */     
/*  75 */     for (RoomCategories.RoomCategoryMain catMain : (SETT.ROOMS()).CATS.MAINS) {
/*     */       
/*  77 */       Filter.FilterCombined<RoomEmployment> c = new Filter.FilterCombined<>(catMain.name, (SPRITE)catMain.icon);
/*  78 */       cc.add(c);
/*  79 */       for (RoomBlueprint blue : catMain.all()) {
/*  80 */         if (blue.employment() instanceof RoomEmployment) {
/*  81 */           final RoomEmployment e = (RoomEmployment)blue.employment();
/*  82 */           Filter.FilterEntry<RoomEmployment> ee = new Filter.FilterEntry<RoomEmployment>((e.blueprint()).info.names, (SPRITE)e.blueprint().iconBig(), e)
/*     */             {
/*     */               public boolean isRelavant()
/*     */               {
/*  86 */                 return (e.neededWorkers() > 0);
/*     */               }
/*     */             };
/*     */           
/*  90 */           rooms.add(ee);
/*  91 */           c.all.add(ee);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  98 */     final Filter<RoomEmployment> fRoom = new Filter<>((SPRITE)(UI.icons()).s.hammer, ¤¤FilterW, (LIST<Filter.FilterEntry<RoomEmployment>>)rooms, (LIST<Filter.FilterCombined<RoomEmployment>>)cc);
/*  99 */     this.section.addRightC(0, (RENDEROBJ)fRoom);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     GuiSection butts = new GuiSection();
/*     */     
/* 108 */     butts.addRelBody(24, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.repair)
/*     */         {
/*     */           protected void clickA() {
/* 111 */             for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 112 */               if (fRoom.active(e)) {
/* 113 */                 for (Filter.FilterEntry<WGROUP> g : UIWorkPrio.this.filterGroup.all) {
/* 114 */                   if (UIWorkPrio.this.filterGroup.active(g)) {
/* 115 */                     ((RoomEmployment)e.o).setPrioOnSkill((WGROUP)g.o);
/*     */                   }
/*     */                 }
/*     */               
/*     */               }
/*     */             }
/*     */           
/*     */           }
/* 123 */         }).pad(4, 4).hoverInfoSet(¤¤setWork));
/*     */     
/* 125 */     butts.addRightC(2, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.heart)
/*     */         {
/*     */           protected void clickA() {
/* 128 */             for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 129 */               if (fRoom.active(e)) {
/* 130 */                 for (Filter.FilterEntry<WGROUP> g : UIWorkPrio.this.filterGroup.all) {
/* 131 */                   if (UIWorkPrio.this.filterGroup.active(g)) {
/* 132 */                     ((RoomEmployment)e.o).setPrioOnFullfillment((WGROUP)g.o);
/*     */                   }
/*     */                 }
/*     */               
/*     */               }
/*     */             } 
/*     */           }
/* 139 */         }).pad(4, 4).hoverInfoSet(¤¤setFull));
/*     */     
/* 141 */     this.section.addRightC(32, (RENDEROBJ)butts);
/*     */ 
/*     */ 
/*     */     
/* 145 */     final UIRoomRaceAssign a = new UIRoomRaceAssign();
/*     */     
/* 147 */     GButt.ButtPanel butt = new GButt.ButtPanel((SPRITE)(UI.icons()).m.descrimination)
/*     */       {
/*     */         protected void clickA() {
/* 150 */           (VIEW.s()).tools.place((PLACABLE)a);
/*     */         }
/*     */       };
/* 153 */     butt.hoverTitleSet(a.name());
/* 154 */     butt.hoverInfoSet(a.desc);
/* 155 */     butt.pad(4, 4);
/*     */     
/* 157 */     this.section.addRelBody(16, DIR.W, (RENDEROBJ)butt);
/*     */ 
/*     */     
/* 160 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new Table(fRoom, this.filterGroup, HEIGHT - this.section.body().height() - 8));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Race r, HTYPE slave) {
/* 166 */     this.filterGroup.all.get((WGROUP.get(slave, r)).index);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\UIWorkPrio.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
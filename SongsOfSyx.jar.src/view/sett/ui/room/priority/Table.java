/*     */ package view.sett.ui.room.priority;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.WGROUP;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class Table
/*     */   extends GuiSection
/*     */ {
/*  18 */   private static CharSequence ¤¤MasterPrioInc = "¤Increase Master priority of all filtered workplaces by 1";
/*  19 */   private static CharSequence ¤¤MasterPrioDec = "¤Decrease Master priority of all filtered workplaces by 1";
/*     */   
/*  21 */   private static CharSequence ¤¤ColInc = "¤Increase priority of all filtered work groups in the column.";
/*  22 */   private static CharSequence ¤¤ColDec = "Decrease priority of all filtered work groups in the column.";
/*     */ 
/*     */   
/*     */   static {
/*  26 */     D.ts(Table.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Table(final Filter<RoomEmployment> fRoom, final Filter<WGROUP> filterGroup, int HEIGHT) {
/*  32 */     GuiSection butts = new GuiSection();
/*  33 */     butts.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.minifier)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  37 */             for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/*  38 */               if (fRoom.active(e)) {
/*  39 */                 ((RoomEmployment)e.o).priority.inc(-1);
/*     */               }
/*     */             } 
/*     */           }
/*  43 */         }).hoverInfoSet(¤¤MasterPrioDec));
/*  44 */     butts.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).s.magnifier)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  48 */             for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/*  49 */               if (fRoom.active(e)) {
/*  50 */                 ((RoomEmployment)e.o).priority.inc(1);
/*     */               }
/*     */             } 
/*     */           }
/*  54 */         }).hoverInfoSet(¤¤MasterPrioInc));
/*     */     
/*  56 */     int x1 = butts.body().x2();
/*     */     
/*  58 */     for (int i = 0; i <= ((RoomEmployment)((Filter.FilterEntry)fRoom.all.get(0)).o).priorities.max(null); i++) {
/*  59 */       final int prio = ((RoomEmployment)((Filter.FilterEntry)fRoom.all.get(0)).o).priorities.max(null) - i;
/*  60 */       if (prio != ((RoomEmployment)((Filter.FilterEntry)fRoom.all.get(0)).o).priorities.max(null)) {
/*  61 */         CLICKABLE c = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_left)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  65 */               for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/*  66 */                 if (fRoom.active(e)) {
/*  67 */                   for (Filter.FilterEntry<WGROUP> g : (Iterable<Filter.FilterEntry<WGROUP>>)filterGroup.all) {
/*  68 */                     if (filterGroup.active(g) && ((RoomEmployment)e.o).priorities.get((WGROUP)g.o) == prio) {
/*  69 */                       ((RoomEmployment)e.o).priorities.inc((WGROUP)g.o, 1);
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*  75 */           }).hoverInfoSet(¤¤ColInc);
/*     */         
/*  77 */         c.body().moveX2((x1 + Row.EW / 2 + i * Row.EW));
/*  78 */         butts.add((RENDEROBJ)c);
/*     */       } 
/*     */       
/*  81 */       if (prio != 0) {
/*     */         
/*  83 */         CLICKABLE c = (new GButt.ButtPanel((SPRITE)(UI.icons()).s.arrow_right)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  87 */               for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/*  88 */                 if (fRoom.active(e)) {
/*  89 */                   for (Filter.FilterEntry<WGROUP> g : (Iterable<Filter.FilterEntry<WGROUP>>)filterGroup.all) {
/*  90 */                     if (filterGroup.active(g) && ((RoomEmployment)e.o).priorities.get((WGROUP)g.o) == prio) {
/*  91 */                       ((RoomEmployment)e.o).priorities.inc((WGROUP)g.o, -1);
/*     */                     }
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             }
/*  97 */           }).hoverInfoSet(¤¤ColDec);
/*     */         
/*  99 */         c.body().moveX1((x1 + Row.EW / 2 + i * Row.EW));
/* 100 */         butts.add((RENDEROBJ)c);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 105 */     add((RENDEROBJ)butts);
/*     */     
/* 107 */     ArrayListGrower<RENDEROBJ> rows = new ArrayListGrower();
/*     */     
/* 109 */     for (Filter.FilterEntry<RoomEmployment> e : fRoom.all) {
/* 110 */       rows.add(new Row(filterGroup, (RoomEmployment)e.o));
/*     */     }
/*     */     
/* 113 */     int hh = HEIGHT - body().height() - 8;
/* 114 */     int s = hh / ((RENDEROBJ)rows.get(0)).body().height();
/* 115 */     hh = s * ((RENDEROBJ)rows.get(0)).body().height();
/*     */     
/* 117 */     GScrollRows rr = new GScrollRows((Iterable)rows, hh)
/*     */       {
/*     */         protected boolean passesFilter(int i, RENDEROBJ o)
/*     */         {
/* 121 */           return fRoom.active((Filter.FilterEntry)fRoom.all.get(i));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 126 */     addDown(8, (RENDEROBJ)rr.view());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Table.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
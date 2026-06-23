/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.WGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.gui.table.GTableBuilder;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Emp
/*     */   extends GuiSection
/*     */ {
/* 364 */   private final ArrayList<WGROUP> ll = new ArrayList((Iterable)WGROUP.all());
/*     */ 
/*     */   
/*     */   Emp() {
/* 368 */     addRightC(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 372 */             GFORMAT.iBig(text, (SETT.ROOMS()).employment.NEEDED.get());
/*     */           }
/* 375 */         }).hh(Dic.¤¤Needed));
/*     */     
/* 377 */     addRightC(100, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 381 */             GFORMAT.iBig(text, (SETT.ROOMS()).employment.TARGET.get(null));
/*     */           }
/* 384 */         }).hh(Dic.¤¤Target));
/*     */ 
/*     */     
/* 387 */     final HISTORY_INT em = (SETT.ROOMS()).employment.hEmployed();
/* 388 */     GStaples chart = new GStaples(em.historyRecords())
/*     */       {
/*     */         
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 393 */           box.title(((STATS.WORK()).EMPLOYED.stat().info()).name);
/*     */           
/* 395 */           int ii = em.historyRecords() - stapleI - 1;
/* 396 */           GText t = box.text();
/* 397 */           DicTime.setDaysAgo((Str)t, ii);
/* 398 */           t.adjustWidth();
/* 399 */           box.add((SPRITE)t.lablify());
/* 400 */           box.NL();
/* 401 */           box.add((SPRITE)GFORMAT.i(box.text(), em.get(ii)));
/* 402 */           box.NL(8);
/*     */ 
/*     */           
/* 405 */           if (stapleI > 0) {
/* 406 */             for (RoomEmployment e : (SETT.ROOMS()).employment.ALL()) {
/* 407 */               int now = e.history().get(ii);
/* 408 */               int delta = now - e.history().get(ii + 1);
/* 409 */               if (delta != 0) {
/* 410 */                 box.add((e.blueprint().iconBig()).small);
/* 411 */                 box.textLL((e.blueprint()).info.names);
/* 412 */                 box.tab(7);
/* 413 */                 box.add((SPRITE)GFORMAT.iIncr(box.text(), delta));
/* 414 */                 box.NL();
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 423 */           return em.get(em.historyRecords() - stapleI - 1);
/*     */         }
/*     */       };
/* 426 */     chart.normalize(true);
/*     */     
/* 428 */     chart.body().setWidth(410.0D).setHeight(80.0D);
/*     */     
/* 430 */     addRelBody(8, DIR.S, (RENDEROBJ)chart);
/*     */ 
/*     */ 
/*     */     
/* 434 */     GTableBuilder bb = new GTableBuilder()
/*     */       {
/*     */         public int nrOFEntries()
/*     */         {
/* 438 */           return UIPanelMain.Emp.this.ll.size() + 1;
/*     */         }
/*     */       };
/*     */     
/* 442 */     bb.column("", 48, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 446 */             return (RENDEROBJ)new HOVERABLE.HoverableAbs(32)
/*     */               {
/*     */                 protected void render(SPRITE_RENDERER r, float ds, boolean isHovered)
/*     */                 {
/* 450 */                   int i = ((Integer)ier.get()).intValue();
/* 451 */                   if (i == (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 452 */                     (UI.icons()).m.arrow_right.renderC(r, this.body.cX(), this.body.cY());
/*     */                   } else {
/* 454 */                     (((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).race.appearance()).icon.renderC(r, this.body.cX(), this.body.cY());
/* 455 */                     ((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).type.CLASS.iconSmall().renderC(r, this.body.cX() + 8, this.body.cY() + 4);
/*     */                   } 
/*     */                 }
/*     */ 
/*     */                 
/*     */                 public void hoverInfoGet(GUI_BOX text) {
/* 461 */                   GBox b = (GBox)text;
/* 462 */                   int i = ((Integer)ier.get()).intValue();
/* 463 */                   if (i == (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 464 */                     b.title(Dic.¤¤Total);
/*     */                   } else {
/* 466 */                     Str.TMP.clear().add(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).race.info.names);
/* 467 */                     Str.TMP.s().add('(').add(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(i)).type.CLASS.names).add(')');
/* 468 */                     b.title((CharSequence)Str.TMP);
/*     */                   } 
/*     */                 }
/*     */               };
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 477 */     int s = 120;
/*     */     
/* 479 */     bb.column(Dic.¤¤Workforce, s, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 483 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 487 */                   GFORMAT.i(text, STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())));
/*     */                 }
/* 490 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 496 */     bb.column(((STATS.WORK()).incap.stat.info()).name, s, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 500 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 504 */                   int i = ((Integer)ier.get()).intValue();
/* 505 */                   if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 506 */                     GFORMAT.i(text, -(STATS.WORK()).incap.get(((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())).type, ((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())).race));
/*     */                   } else {
/* 508 */                     GFORMAT.i(text, -(STATS.WORK()).incap.get());
/*     */                   }
/*     */                 
/*     */                 }
/* 512 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 518 */     bb.column(UIPanelMain.¤¤emp, s, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 522 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 526 */                   int i = ((Integer)ier.get()).intValue();
/* 527 */                   if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 528 */                     GFORMAT.i(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())));
/*     */                   } else {
/* 530 */                     GFORMAT.i(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(0)));
/*     */                   }
/*     */                 
/*     */                 }
/* 534 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 540 */     bb.column(Dic.¤¤Rate, s, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 544 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 548 */                   double wf = STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue()));
/* 549 */                   GFORMAT.perc(text, (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())) / wf);
/*     */                 }
/* 552 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 559 */     bb.column(UIPanelMain.¤¤oddjobbers, s, new GTableBuilder.GRowBuilder()
/*     */         {
/*     */           public RENDEROBJ build(final GETTER<Integer> ier)
/*     */           {
/* 563 */             return (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 567 */                   int i = ((Integer)ier.get()).intValue();
/* 568 */                   if (i != (UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.size()) {
/* 569 */                     GFORMAT.i(text, (STATS.WORK().workforce((WGROUP)(UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue())) - (SETT.ROOMS()).employment.TARGET.get((UIPanelMain.Emp.null.access$0(UIPanelMain.Emp.null.this)).ll.get(((Integer)ier.get()).intValue()))));
/*     */                   } else {
/* 571 */                     GFORMAT.i(text, (STATS.WORK().workforce() - (SETT.ROOMS()).employment.TARGET.get(null)));
/*     */                   }
/*     */                 
/*     */                 }
/* 575 */               }).r(DIR.NW);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 581 */     addRelBody(8, DIR.S, (RENDEROBJ)bb.create(8, true));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 589 */     this.ll.clearSloppy();
/*     */     
/* 591 */     for (WGROUP g : WGROUP.all()) {
/* 592 */       if ((STATS.POP()).POP.data(g.type.CLASS).get(g.race) > 0) {
/* 593 */         this.ll.add(g);
/*     */       }
/*     */     } 
/* 596 */     super.render(r, ds);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelMain$Emp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
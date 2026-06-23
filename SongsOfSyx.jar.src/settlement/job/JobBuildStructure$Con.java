/*     */ package settlement.job;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.BUILDING_PREFS;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Con
/*     */   implements ToolConfig
/*     */ {
/* 483 */   private final LinkedList<CLICKABLE> butts = new LinkedList();
/*     */   private JobBuildStructure struc;
/* 485 */   private int type = 0;
/*     */   PlacableMulti job;
/* 487 */   private final GuiSection section = new GuiSection();
/* 488 */   private GuiSection full = new GuiSection();
/* 489 */   private final GPanel panel = new GPanel();
/*     */   
/* 491 */   ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 495 */         (VIEW.s()).tools.placer.deactivate();
/*     */       }
/*     */     };
/*     */   
/*     */   public ToolConfig get(JobBuildStructure struc, PlacableMulti job) {
/* 500 */     if (job == struc.combo) {
/* 501 */       this.type = 0;
/* 502 */     } else if (job == struc.wall.placer()) {
/* 503 */       this.type = 1;
/* 504 */     } else if (job == struc.ceiling.placer()) {
/* 505 */       this.type = 2;
/*     */     } else {
/* 507 */       this.type = 3;
/* 508 */     }  this.struc = struc;
/* 509 */     this.job = job;
/* 510 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   Con() {
/* 515 */     this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wallceiling)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 519 */             JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.combo;
/* 520 */             JobBuildStructure.Con.this.type = 0;
/* 521 */             (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 526 */             JobBuildStructure.Con.this.struc.combo.hoverDesc((GBox)text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 531 */             selectedSet((JobBuildStructure.Con.this.type == 0));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 536 */     this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 540 */             JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.wall.placer();
/* 541 */             JobBuildStructure.Con.this.type = 1;
/* 542 */             (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 547 */             JobBuildStructure.Con.this.struc.wall.placer().hoverDesc((GBox)text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 552 */             selectedSet((JobBuildStructure.Con.this.type == 1));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 557 */     this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall_opening)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 561 */             JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.ceiling.placer();
/* 562 */             JobBuildStructure.Con.this.type = 2;
/* 563 */             (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 568 */             JobBuildStructure.Con.this.struc.ceiling.placer().hoverDesc((GBox)text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 573 */             selectedSet((JobBuildStructure.Con.this.type == 2));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 578 */     this.butts.add(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 582 */             JobBuildStructure.Con.this.job = JobBuildStructure.Con.this.struc.convert;
/* 583 */             JobBuildStructure.Con.this.type = 3;
/* 584 */             (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 589 */             JobBuildStructure.Con.this.struc.convert.hoverDesc((GBox)text);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 594 */             selectedSet((JobBuildStructure.Con.this.type == 3));
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 599 */     for (JobBuildStructure j : (SETT.JOBS()).build_structure) {
/*     */ 
/*     */       
/* 602 */       GButt.ButtPanel b = new GButt.ButtPanel(j.wall.placer().getIcon())
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 606 */             JobBuildStructure.Con.this.setStruc(j);
/* 607 */             (VIEW.s()).tools.place((PLACABLE)JobBuildStructure.Con.this.job, JobBuildStructure.Con.this);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 612 */             text.title(j.building.name);
/* 613 */             text.text(j.building.desc);
/* 614 */             GBox b = (GBox)text;
/* 615 */             b.NL();
/* 616 */             if (j.building.resource != null) {
/* 617 */               b.setResource(j.building.resource, (j.building.resAmount + 1));
/*     */             }
/* 619 */             b.NL(8);
/*     */             
/* 621 */             for (Race r : RACES.all()) {
/* 622 */               double d = r.pref().structure(BUILDING_PREFS.get(j.building));
/* 623 */               int k = 1 + (int)(5.0D * d);
/* 624 */               if ((r.index & 0x3) == 0)
/* 625 */                 b.NL(); 
/* 626 */               b.tab((r.index & 0x3) * 3);
/* 627 */               b.add((SPRITE)(r.appearance()).icon);
/* 628 */               ColorImp.TMP.interpolate((GCOLOR.UI()).BAD.hovered, (GCOLOR.UI()).GOOD.hovered, d);
/* 629 */               for (int i = 0; i < k; i++) {
/* 630 */                 b.add((SPRITE)(SPRITES.icons()).s.heart, (COLOR)ColorImp.TMP);
/* 631 */                 b.rewind(8);
/*     */               } 
/* 633 */               b.space();
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 641 */             selectedSet((JobBuildStructure.Con.this.struc == j));
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 646 */       this.section.addRightC(0, (RENDEROBJ)b);
/* 647 */       if (j.wall.lockText() == null) {
/* 648 */         this.struc = j;
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void setStruc(JobBuildStructure struc) {
/* 654 */     this.struc = struc;
/* 655 */     switch (this.type) { case 0:
/* 656 */         this.job = struc.combo; break;
/* 657 */       case 1: this.job = struc.wall.placer(); break;
/* 658 */       case 2: this.job = struc.ceiling.placer(); break;
/* 659 */       case 3: this.job = struc.convert;
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/* 667 */     this.full.clear();
/*     */     
/* 669 */     (VIEW.s()).tools.placer.stealButtons(this.full);
/* 670 */     for (CLICKABLE c : this.butts) {
/* 671 */       this.full.addRightC(0, (RENDEROBJ)c);
/*     */     }
/* 673 */     if (this.job.getAdditionalButt() != null)
/* 674 */       for (CLICKABLE p : this.job.getAdditionalButt())
/* 675 */         this.full.addRightC(0, (RENDEROBJ)p);  
/* 676 */     this.full.body().centerX(C.DIM());
/* 677 */     this.full.addRelBody(8, DIR.N, (RENDEROBJ)this.section);
/*     */     
/* 679 */     this.panel.setButt();
/* 680 */     this.panel.inner().set((BODY_HOLDER)this.full);
/* 681 */     this.panel.clickActionSet(this.exit);
/* 682 */     this.full.add((RENDEROBJ)this.panel);
/* 683 */     this.full.moveLastToBack();
/* 684 */     this.full.body().moveY1(90.0D);
/* 685 */     uis.add(this.full);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildStructure$Con.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
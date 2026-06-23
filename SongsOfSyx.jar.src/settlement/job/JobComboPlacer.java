/*     */ package settlement.job;
/*     */ import game.save.PROP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ final class JobComboPlacer implements ToolConfig {
/*  26 */   private final GPanel panel = new GPanel(); protected GuiSection section;
/*  27 */   private GuiSection full = new GuiSection();
/*     */   private Job place;
/*     */   private final String selectKey;
/*     */   private final LIST<? extends Job> jobs;
/*     */   
/*  32 */   ACTION exit = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/*  36 */         (VIEW.s()).tools.placer.deactivate();
/*     */       }
/*     */     };
/*     */   
/*     */   public ToolConfig get(Job j) {
/*  41 */     this.place = j;
/*  42 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Job current() {
/*  49 */     if (this.place == null || this.place.lockText() != null) {
/*  50 */       int i = PROP.propI(this.selectKey, 0);
/*  51 */       i = CLAMP.i(i, 0, this.jobs.size() - 1);
/*  52 */       this.place = (Job)this.jobs.get(i);
/*  53 */       if (this.place == null || this.place.lockText() != null) {
/*  54 */         int ii = 0;
/*  55 */         for (Job jj : this.jobs) {
/*  56 */           ii++;
/*  57 */           if (jj.lockText() == null) {
/*  58 */             this.place = jj;
/*  59 */             PROP.propISet(this.selectKey, ii);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  64 */     return this.place;
/*     */   }
/*     */   
/*     */   JobComboPlacer(LIST<? extends Job> jobs, String ss) {
/*  68 */     this.selectKey = "JOB_SELECTION_" + ss;
/*  69 */     this.jobs = jobs;
/*  70 */     this.section = new GuiSection();
/*     */     
/*  72 */     int in = 0;
/*  73 */     for (Job j : jobs) {
/*     */       
/*  75 */       final int inn = in;
/*  76 */       in++;
/*     */       
/*  78 */       GButt.ButtPanel b = new GButt.ButtPanel(j.placer().getIcon())
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  82 */             if (j.lockText() == null) {
/*  83 */               JobComboPlacer.this.place = j;
/*  84 */               PROP.propISet(JobComboPlacer.this.selectKey, inn);
/*  85 */               (VIEW.s()).tools.place((PLACABLE)j.placer(), JobComboPlacer.this);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  91 */             GBox b = (GBox)text;
/*  92 */             j.placer().hoverDesc(b);
/*  93 */             if (j.lockText() != null) {
/*  94 */               b.NL(8);
/*  95 */               b.error(j.lockText());
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 102 */             selectedSet(((VIEW.s()).tools.placer.getCurrent() == j.placer()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 108 */             super.render(r, ds, isActive, isSelected, isHovered);
/* 109 */             if (j.lockText() != null) {
/* 110 */               OPACITY.O50.bind();
/* 111 */               COLOR.BLACK.render(r, (RECTANGLE)this.body);
/* 112 */               OPACITY.unbind();
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 118 */       this.section.addRightC(0, (RENDEROBJ)b);
/*     */     } 
/*     */     
/* 121 */     int i = PROP.propI(this.selectKey, 0);
/* 122 */     i = CLAMP.i(i, 0, jobs.size() - 1);
/* 123 */     this.place = (Job)jobs.get(i);
/*     */ 
/*     */     
/* 126 */     for (Job jj : jobs) {
/* 127 */       if (jj.lockText() == null)
/* 128 */         this.place = jj; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/* 133 */     this.full.clear();
/*     */     
/* 135 */     (VIEW.s()).tools.placer.stealButtons(this.full);
/* 136 */     if (this.place.placer().getAdditionalButt() != null)
/* 137 */       for (CLICKABLE p : this.place.placer().getAdditionalButt())
/* 138 */         this.full.addRightC(0, (RENDEROBJ)p);  
/* 139 */     this.full.body().centerX(C.DIM());
/* 140 */     this.full.addRelBody(8, DIR.N, (RENDEROBJ)this.section);
/*     */     
/* 142 */     this.panel.setButt();
/* 143 */     this.panel.inner().set((BODY_HOLDER)this.full);
/* 144 */     this.panel.clickActionSet(this.exit);
/* 145 */     this.full.add((RENDEROBJ)this.panel);
/* 146 */     this.full.moveLastToBack();
/* 147 */     this.full.body().moveY1(90.0D);
/* 148 */     uis.add(this.full);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobComboPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
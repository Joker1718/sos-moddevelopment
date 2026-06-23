/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import init.constant.C;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import view.main.VIEW;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ final class Config
/*     */   implements ToolConfig {
/*     */   private final State s;
/*     */   boolean build = true;
/*  19 */   private GuiSection section = new GuiSection();
/*     */   private final SShape sshape;
/*     */   private final SMaterial sMaterial;
/*     */   private final SFrame frame;
/*     */   private final SItems items;
/*     */   private final SStats stats;
/*     */   private final SCollection coll;
/*  26 */   private final Separator sep1 = new Separator();
/*  27 */   private final Separator sep2 = new Separator();
/*     */   Config(State s) {
/*  29 */     this.s = s;
/*  30 */     this.sshape = new SShape(s);
/*  31 */     this.frame = new SFrame(s);
/*  32 */     this.items = new SItems(s);
/*  33 */     this.stats = new SStats(s);
/*  34 */     this.sMaterial = new SMaterial(s);
/*  35 */     this.coll = new SCollection(s);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addUI(LISTE<RENDEROBJ> uis) {
/*  40 */     if (this.s.b.constructor().overlay() != null && (SETT.ROOMS()).placement.placer.showOverlay.is()) {
/*  41 */       this.s.b.constructor().overlay().add();
/*  42 */     } else if (this.s.b.constructor().isHeavy() && (SETT.ROOMS()).placement.placer.showFoundation.is()) {
/*  43 */       (SETT.OVERLAY()).FOUNDATION.add();
/*     */     } 
/*     */     
/*  46 */     this.section.clear();
/*     */     
/*  48 */     if (this.s.collection != null) {
/*  49 */       (VIEW.s()).tools.placer.stealButtons(this.section);
/*  50 */       this.section.addRelBody(12, DIR.N, (RENDEROBJ)this.coll.get());
/*  51 */     } else if (this.s.b.constructor().usesArea()) {
/*  52 */       this.section.add((RENDEROBJ)this.sshape.get());
/*     */       
/*  54 */       if (this.s.b.constructor().mustBeIndoors()) {
/*  55 */         this.section.addDownC(6, (RENDEROBJ)this.sMaterial.get());
/*     */       }
/*     */       
/*  58 */       this.section.addRelBody(12, DIR.E, this.sep1.get(this.section.body().height()));
/*     */       
/*  60 */       if (this.s.b.constructor().groups().size() > 0) {
/*  61 */         this.section.addRelBody(12, DIR.E, (RENDEROBJ)this.items.get());
/*  62 */         this.section.addRelBody(12, DIR.E, this.sep2.get(this.section.body().height()));
/*     */       } 
/*     */       
/*  65 */       this.section.addRelBody(12, DIR.E, (RENDEROBJ)this.stats.get());
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*  70 */     else if (this.s.b.constructor().mustBeIndoors()) {
/*  71 */       this.section.addDownC(6, (RENDEROBJ)this.sMaterial.get());
/*  72 */       this.section.addRelBody(12, DIR.E, this.sep1.get(this.section.body().height()));
/*  73 */       if (this.s.b.constructor().groups().size() > 1) {
/*  74 */         this.section.addRelBody(12, DIR.E, (RENDEROBJ)this.items.getFlat());
/*     */       } else {
/*  76 */         this.section.addRelBody(12, DIR.E, (RENDEROBJ)this.items.getSingle());
/*     */       } 
/*  78 */     } else if (this.s.b.constructor().groups().size() > 1) {
/*     */       
/*  80 */       this.section.addRelBody(12, DIR.E, (RENDEROBJ)this.items.getFlat());
/*  81 */       if (this.s.b.constructor().overlay() != null)
/*  82 */         this.section.addRelBody(8, DIR.E, (RENDEROBJ)this.sshape.buttOverlay); 
/*     */     } else {
/*  84 */       (VIEW.s()).tools.placer.addStandardButtons(uis, false);
/*  85 */       if (this.s.b.constructor().overlay() != null) {
/*  86 */         this.section.addRelBody(8, DIR.E, (RENDEROBJ)this.sshape.buttOverlay);
/*     */       }
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/*  94 */     GuiSection s = this.frame.get(this.section);
/*     */ 
/*     */     
/*  97 */     s.body().moveCX((C.WIDTH() / 2));
/*  98 */     s.body().moveY1(80.0D);
/*  99 */     if (VIEW.s().getWindow().tiles().y1() == 0) {
/* 100 */       s.body().moveY2((C.HEIGHT() - 80));
/*     */     }
/* 102 */     if (VIEW.s().getWindow().tiles().x2() == SETT.TWIDTH) {
/* 103 */       s.body().moveX1(80.0D);
/*     */     }
/* 105 */     uis.add(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean back() {
/* 113 */     if ((SETT.ROOMS()).placement.placer.popHistory()) {
/* 114 */       return false;
/*     */     }
/* 116 */     if (!this.s.refurnishing && (SETT.ROOMS()).placement.placer.removeAllItems())
/* 117 */       return false; 
/* 118 */     if (!this.s.refurnishing && (SETT.ROOMS()).placement.placer.removeArea())
/* 119 */       return false; 
/* 120 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(boolean UIHovered) {
/* 125 */     if (VIEW.renderSecond() > this.s.problemTimer) {
/* 126 */       this.s.problemGroup = null;
/* 127 */       this.s.problemneedArea = false;
/* 128 */       this.s.problemneedDoor = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void deactivateAction() {
/* 140 */     if (this.s.refurnishing && this.build && (SETT.ROOMS()).placement.placer.createProblem() == null)
/* 141 */       (SETT.ROOMS()).placement.placer.create(); 
/* 142 */     (SETT.ROOMS()).placement.placer.init(null, 0);
/* 143 */     this.build = true;
/*     */   }
/*     */   
/*     */   private class Separator
/*     */     extends SPRITE.Imp
/*     */   {
/*     */     SPRITE get(int h) {
/* 150 */       this.height = h;
/* 151 */       this.width = 2;
/* 152 */       return (SPRITE)this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 157 */       GCOLOR.UI().border(r, X1, X2, Y1, Y2);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\Config.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
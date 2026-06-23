/*     */ package view.sett.ui.room.construction;
/*     */ import init.sprite.SPRITES;
/*     */ import init.structure.Structure;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.terrain.TBuilding;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
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
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class SMaterial {
/*  25 */   private final GuiSection section = new GuiSection();
/*  26 */   private final GuiSection buttonsIndoor = new GuiSection(); private final State s; private final CLICKABLE buttonIndoor; private final CLICKABLE buttWalls; private final CLICKABLE buttDoor; private final CLICKABLE buttDoorRemove;
/*     */   private final HOVERABLE isolation;
/*     */   
/*     */   SMaterial(final State s) {
/*  30 */     D.gInit(this);
/*     */ 
/*     */     
/*  33 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  42 */       .buttonIndoor = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.cancel) { protected void clickA() { (VIEW.inters()).popup.show((RENDEROBJ)SMaterial.this.buttonsIndoor, (CLICKABLE)this); } protected void renAction() { replaceLabel(((TBuilding)SMaterial.this.s.placement.placer.structure.get()).iconCombo, DIR.C); } }).hoverInfoSet(D.g("indoor", "This room requires to be built indoors and you must pick a structure type."));
/*     */     
/*  44 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  54 */       .buttWalls = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wall) { protected void clickA() { SMaterial.this.s.placement.placer.autoWalls.toggle(); } protected void renAction() { selectedSet(SMaterial.this.s.placement.placer.autoWalls.is()); } }).hoverInfoSet(D.g("walls", "Auto build walls around room."));
/*     */     
/*  56 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  81 */       .buttDoor = (new GButt.ButtPanel((SETT.ROOMS()).placement.placer.placerDoor.getIcon()) { protected void clickA() { if (SMaterial.this.s.placement.placer.autoWalls.is()) (VIEW.s()).tools.place((PLACABLE)SMaterial.this.s.placement.placer.placerDoor, SMaterial.this.s.config);  } protected void renAction() { activeSet(SMaterial.this.s.placement.placer.autoWalls.is()); selectedSet(((VIEW.s()).tools.placer.getCurrent() == SMaterial.this.s.placement.placer.placerDoor)); } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { super.render(r, ds, isActive, isSelected, isHovered); if (SMaterial.this.s.problemneedDoor && SMaterial.this.s.problemTimer > VIEW.renderSecond()) { COLOR.RED100.renderFrame(r, (RECTANGLE)this.body, 2, 3); OPACITY.O25To50.bind(); COLOR.RED100.render(r, (RECTANGLE)this.body); OPACITY.unbind(); }  } }).hoverInfoSet(D.g("door", "Places doorways on walls. Needed to make the room reachable. Doorways decrease insulation, but too little will make entering the room difficult."));
/*  82 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  95 */       .buttDoorRemove = (new GButt.ButtPanel((SETT.ROOMS()).placement.placer.placerDoor.getUndo().getIcon()) { protected void clickA() { if (SMaterial.this.s.placement.placer.autoWalls.is()) (VIEW.s()).tools.place(SMaterial.this.s.placement.placer.placerDoor.getUndo(), SMaterial.this.s.config);  } protected void renAction() { activeSet(SMaterial.this.s.placement.placer.autoWalls.is()); selectedSet(((VIEW.s()).tools.placer.getCurrent() == SMaterial.this.s.placement.placer.placerDoor.getUndo())); } }).hoverInfoSet((SETT.ROOMS()).placement.placer.placerDoor.getUndo().name());
/*     */     
/*  97 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 102 */       .isolation = (new GStat() { public void update(GText text) { GFORMAT.perc(text, SMaterial.this.s.placement.placer.isolation()); } }).hh((SETT.ROOMS()).isolation.info.name).hoverInfoSet((SETT.ROOMS()).isolation.info.desc);
/*     */ 
/*     */     
/* 105 */     this.s = s;
/* 106 */     for (Structure t : STRUCTURES.all()) {
/*     */ 
/*     */       
/* 109 */       GButt.Panel panel = new GButt.Panel((t.terrain()).iconCombo, t.desc)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 112 */             GBox b = (GBox)text;
/* 113 */             b.title(t.name);
/* 114 */             SMaterial.this.buttonIndoor.hoverInfoGet(text);
/* 115 */             b.NL();
/* 116 */             b.text(t.desc);
/* 117 */             b.setResource(t.resource, t.resAmount);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 122 */             s.placement.placer.structure.set(t.terrain());
/* 123 */             (VIEW.inters()).popup.close();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 128 */             selectedSet((s.placement.placer.structure.get() == t.terrain()));
/*     */           }
/*     */         };
/* 131 */       this.buttonsIndoor.addDownC(0, (RENDEROBJ)panel);
/*     */     } 
/*     */   }
/*     */   
/*     */   GuiSection get() {
/* 136 */     this.section.clear();
/*     */ 
/*     */     
/* 139 */     this.section.addRightC(0, (RENDEROBJ)this.buttWalls);
/* 140 */     if (this.s.b.constructor().mustBeIndoors() && this.s.b.constructor().usesArea()) {
/* 141 */       this.section.addRightC(0, (RENDEROBJ)this.buttDoor);
/* 142 */       this.section.addRightC(0, (RENDEROBJ)this.buttDoorRemove);
/*     */     } 
/* 144 */     this.section.addRightC(0, (RENDEROBJ)this.buttonIndoor);
/*     */     
/* 146 */     if (this.s.b.constructor().needsIsolation())
/* 147 */       this.section.addRelBody(4, DIR.N, (RENDEROBJ)this.isolation); 
/* 148 */     return this.section;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SMaterial.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
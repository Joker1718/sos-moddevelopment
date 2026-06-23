/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GHeader.HeaderHorizontal
/*     */ {
/*     */   null(SPRITE $anonymous0, SPRITE $anonymous1) {
/*  96 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 100 */     GBox b = (GBox)text;
/* 101 */     b.title(ModuleService.¤¤USAGE);
/*     */     
/* 103 */     b.textLL(ModuleService.¤¤Load);
/* 104 */     b.tab(6);
/* 105 */     b.add((SPRITE)GFORMAT.percInv(b.text(), ModuleService.I.this.p.service().load()));
/* 106 */     b.NL();
/* 107 */     b.text(ModuleService.¤¤USAGE_DESC);
/* 108 */     b.NL(8);
/*     */     
/* 110 */     b.textL(ModuleService.¤¤AVAILABLE);
/* 111 */     b.add((SPRITE)GFORMAT.i(b.text(), ModuleService.I.this.p.service().available()));
/* 112 */     b.NL();
/* 113 */     b.textL(ModuleService.¤¤TOTAL);
/* 114 */     b.add((SPRITE)GFORMAT.i(b.text(), ModuleService.I.this.p.service().total()));
/*     */     
/* 116 */     b.NL(8);
/* 117 */     b.textLL(ModuleService.¤¤Capacity);
/* 118 */     b.tab(6);
/* 119 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)(ModuleService.I.this.p.service().total() * ModuleService.I.this.p.service().totalMultiplier())));
/* 120 */     b.NL();
/* 121 */     b.text(ModuleService.¤¤CapacityD);
/*     */     
/* 123 */     b.NL(8);
/* 124 */     b.textLL(ModuleService.¤¤RADIUS);
/* 125 */     b.add((SPRITE)GFORMAT.i(b.text(), (ModuleService.I.this.p.service()).radius));
/* 126 */     b.NL();
/* 127 */     b.text(ModuleService.¤¤RADIUSD);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleService$I$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
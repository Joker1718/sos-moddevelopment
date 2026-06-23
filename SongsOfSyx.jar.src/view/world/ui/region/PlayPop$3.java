/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  78 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  81 */     GBox b = (GBox)text;
/*     */     
/*  83 */     b.title((RD.RACES()).population.name);
/*     */     
/*  85 */     b.textLL(Dic.¤¤Current);
/*  86 */     b.tab(6);
/*  87 */     b.add((SPRITE)GFORMAT.i(b.text(), (RD.RACES()).population.get((Region)g.get())));
/*  88 */     b.NL();
/*  89 */     b.textLL(Dic.¤¤Target);
/*  90 */     b.tab(6);
/*  91 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)(RD.RACES()).popTarget.getD(g.get())));
/*  92 */     b.sep();
/*     */ 
/*     */     
/*  95 */     (RD.RACES()).capacity.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), (RD.RACES()).capacity.name, true);
/*     */     
/*  97 */     b.NL(8);
/*  98 */     b.tab(1);
/*  99 */     b.textL(Dic.¤¤Used);
/*     */     
/* 101 */     double d = (RD.RACES()).capacity.get((BOOSTABLE_O)g.get()) * (RD.RACES()).population.get((Region)g.get()) / (RD.RACES()).popTarget.getD(g.get());
/*     */     
/* 103 */     b.tab(5);
/* 104 */     b.add((SPRITE)GFORMAT.f0(b.text(), -d));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayPop$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
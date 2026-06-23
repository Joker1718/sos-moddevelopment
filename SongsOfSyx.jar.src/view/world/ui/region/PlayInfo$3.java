/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FBanner;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 110 */     GFORMAT.perc(text, CLAMP.d((RD.DIST()).bProximity.get((BOOSTABLE_O)g.get()), 0.0D, 1.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 116 */     b.textLL(PlayInfo.¤¤DistanceToCapitol);
/* 117 */     b.add((SPRITE)GFORMAT.i(b.text(), RD.DIST().distance().get(g.get())));
/* 118 */     b.NL();
/* 119 */     b.textLL(Dic.¤¤Neighbours);
/* 120 */     b.NL();
/* 121 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all((Region)g.get(), WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY())) {
/* 122 */       Region reg = d.reg;
/* 123 */       if (reg.faction() == null) {
/* 124 */         b.add(FBanner.rebel.MEDIUM);
/*     */       } else {
/* 126 */         b.add((reg.faction().banner()).MEDIUM);
/*     */       } 
/* 128 */       b.textL((CharSequence)reg.info.name());
/* 129 */       b.tab(7);
/* 130 */       b.add((SPRITE)GFORMAT.i(b.text(), d.distance));
/* 131 */       b.NL();
/*     */     } 
/*     */     
/* 134 */     b.sep();
/*     */     
/* 136 */     b.title((RD.DIST()).bProximity.name);
/* 137 */     b.text((RD.DIST()).bProximity.desc);
/* 138 */     b.sep();
/* 139 */     (RD.DIST()).bProximity.hover((GUI_BOX)b, (BOOSTABLE_O)g.get(), null, true);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayInfo$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
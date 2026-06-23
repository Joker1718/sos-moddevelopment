/*     */ package view.ui.raider;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.raiding.RaidingMap;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import world.army.AD;
/*     */ import world.entity.army.WArmy;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 110 */     if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/* 111 */       text.errorify().add(Info.¤¤entryA);
/*     */     } else {
/* 113 */       text.normalify().add(Info.¤¤entryB);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 120 */     if ((GAME.raiders()).entry.get(FACTIONS.player().capitolRegion()).points() > 0) {
/* 121 */       b.text(Info.¤¤entryAD);
/*     */     } else {
/* 123 */       b.text(Info.¤¤entryBD);
/* 124 */       b.NL(8);
/* 125 */       for (RaidingMap.RaidRegion r : (GAME.raiders()).entry.entryRegions()) {
/* 126 */         b.textLL((CharSequence)(r.r()).info.name());
/* 127 */         b.tab(6);
/* 128 */         b.add((SPRITE)(UI.icons()).s.sword);
/* 129 */         b.add((SPRITE)GFORMAT.iIncr(b.text(), (int)(RD.MILITARY()).power.getD(r.r())));
/* 130 */         b.NL();
/*     */       } 
/*     */       
/* 133 */       b.NL(8);
/*     */       
/* 135 */       for (WArmy a : FACTIONS.player().armies().all()) {
/* 136 */         if (a.region() != null && a.region().faction() == FACTIONS.player()) {
/* 137 */           b.textLL((CharSequence)a.name);
/* 138 */           b.tab(6);
/* 139 */           b.add((SPRITE)(UI.icons()).s.sword);
/* 140 */           b.add((SPRITE)GFORMAT.iIncr(b.text(), AD.power().get(a)));
/* 141 */           b.NL();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\Info$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
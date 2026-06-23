/*     */ package view.sett.ui.food;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.NEEDS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 102 */     double needed = 0.0D;
/*     */     
/* 104 */     for (ResG res : RESOURCES.EDI().all()) {
/* 105 */       needed += (SETT.ROOMS()).PROD.consumed(res.resource);
/* 106 */       needed += SETT.MAINTENANCE().estimateGlobal(res.resource);
/*     */     } 
/* 108 */     for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 109 */       HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 110 */       if (c.player) {
/* 111 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 112 */           Race r = (Race)RACES.all().get(ri);
/* 113 */           double n = (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * (STATS.FOOD()).FOOD.decree().get(c, r);
/* 114 */           needed += n;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 120 */     GFORMAT.f0(text, -needed);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 127 */     double needed = 0.0D;
/* 128 */     for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/*     */       
/* 130 */       HCLASS c = (HCLASS)HCLASSES.ALL().get(ci);
/* 131 */       if (c.player) {
/* 132 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 133 */           Race r = (Race)RACES.all().get(ri);
/* 134 */           double n = (NEEDS.TYPES()).HUNGER.rate.get((BOOSTABLE_O)c.get(r)) * POP.physical(c, r) * (STATS.FOOD()).FOOD.decree().get(c, r);
/* 135 */           if (n > 0.0D) {
/* 136 */             b.add((SPRITE)(r.appearance()).icon);
/* 137 */             b.textL(c.names);
/*     */ 
/*     */             
/* 140 */             b.tab(7);
/* 141 */             b.add((SPRITE)GFORMAT.f0(b.text(), -n));
/* 142 */             b.NL();
/*     */           } 
/* 144 */           needed += n;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 151 */     b.sep();
/*     */     
/* 153 */     b.textLL(Dic.¤¤Total);
/* 154 */     b.tab(7);
/*     */     
/* 156 */     b.add((SPRITE)GFORMAT.f0(b.text(), -needed));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
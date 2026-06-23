/*     */ package view.ui.div;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.gui.common.UIPickerRace;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPickerRace
/*     */ {
/*     */   null(LIST<Race> $anonymous0) {
/*  99 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public void hover(GBox b, Race race) {
/* 103 */     b.title(race.info.names);
/* 104 */     b.text(race.info.desc);
/* 105 */     b.sep();
/*     */     
/* 107 */     race.boosts.hover((GUI_BOX)b, 1.0D, null, (BOOSTABLES.BATTLE()).filter, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(int ri) {
/* 112 */     super.set(ri);
/* 113 */     Race r = race();
/* 114 */     UIDivEditor.this.div.raceSet(r);
/*     */     
/* 116 */     for (int ei = 0; ei < STATS.EQUIP().BATTLE_ALL().size(); ei++) {
/* 117 */       EquipBattle e = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(ei);
/* 118 */       if (!e.allowed(r))
/* 119 */         UIDivEditor.this.div.equipSet(e, 0.0D); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivEditor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
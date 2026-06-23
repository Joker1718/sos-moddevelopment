/*     */ package view.ui.advice;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PBonusSetting;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.CORE;
/*     */ import snake2d.CORE_STATE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 123 */     final String race = (FACTIONS.player().race()).key;
/* 124 */     final PBonusSetting ss = (FACTIONS.player()).bonusesCustom;
/* 125 */     ss.startLevel = FACTIONS.player().level().current().index();
/*     */     
/* 127 */     for (RESOURCE res : RESOURCES.ALL()) {
/* 128 */       int am = (SETT.ROOMS()).STOCKPILE.tally().amountTotal(res) / 4;
/* 129 */       ss.startResources.set(res, am);
/*     */     } 
/*     */     
/* 132 */     final boolean a = GAME.achieving();
/*     */     
/* 134 */     CORE_STATE.Constructor c = new CORE_STATE.Constructor()
/*     */       {
/*     */         public CORE_STATE getState()
/*     */         {
/* 138 */           String[] sc = GAME.script().currentScripts();
/* 139 */           return (CORE_STATE)GAME.create(sc);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void doAfterSet() {
/* 146 */           (FACTIONS.player()).bonusesCustom.copy(ss);
/* 147 */           GAME.achieve(a);
/* 148 */           WorldViewGenerator.setresettle((Race)RACES.map().tryGet(race));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 153 */     CORE.setCurrentState(c);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\advice\UIAdvice$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
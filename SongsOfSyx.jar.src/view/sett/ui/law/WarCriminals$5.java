/*     */ package view.sett.ui.law;
/*     */ 
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 200 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void renAction() {
/* 204 */     activeSet((ii.get() > 0));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 210 */     int am = ii.get(); byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 212 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 213 */       if (am <= 0)
/*     */         break; 
/* 215 */       if (e instanceof Humanoid) {
/* 216 */         Humanoid a = (Humanoid)e;
/* 217 */         if (a.indu().hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(a.indu()) == CRIMES.WAR() && (
/* 218 */           WarCriminals.this.sel.getRace() == null || WarCriminals.this.sel.getRace() == a.race()) && 
/* 219 */           (AIModule_Prisoner.DATA()).punishmentSet.get(a.ai()) == CRIME_PUNISHMENTS.STOCKS()) {
/* 220 */           (AIModule_Prisoner.DATA()).punishmentSet.set(a.ai(), punish);
/* 221 */           am--;
/* 222 */           if (am <= 0) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*     */       b++; }
/*     */     
/* 230 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 231 */       if (am <= 0)
/*     */         break; 
/* 233 */       if (e instanceof Humanoid) {
/* 234 */         Humanoid a = (Humanoid)e;
/* 235 */         if (a.indu().hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(a.indu()) == CRIMES.WAR() && (
/* 236 */           WarCriminals.this.sel.getRace() == null || WarCriminals.this.sel.getRace() == a.race()) && 
/* 237 */           (AIModule_Prisoner.DATA()).punishmentSet.get(a.ai()) != punish) {
/* 238 */           (AIModule_Prisoner.DATA()).punishmentSet.set(a.ai(), punish);
/* 239 */           am--;
/* 240 */           if (am <= 0)
/*     */             break; 
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\WarCriminals$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
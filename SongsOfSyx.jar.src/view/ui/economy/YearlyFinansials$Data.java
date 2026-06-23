/*     */ package view.ui.economy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import game.faction.player.PCredits;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.trade.TRADABLE;
/*     */ import init.type.HGROUP;
/*     */ import java.io.Serializable;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Data
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/* 181 */   int in = 0;
/* 182 */   int out = 0;
/*     */   
/*     */   private final String name;
/*     */   
/*     */   Data(SPRITE icon, CharSequence name, PCredits.Yearly h) {
/* 187 */     this.name = String.valueOf(name);
/*     */     
/* 189 */     int yy = 1;
/*     */     
/* 191 */     this.in = h.PROFITS.get(yy);
/* 192 */     this.out = h.LOSSES.get(yy);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Data(TRADABLE tr) {
/* 198 */     this.name = String.valueOf(tr.names);
/*     */     
/* 200 */     int year = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     
/* 202 */     for (FResources.RTYPE t : FResources.RTYPE.all) {
/* 203 */       this.in += FACTIONS.player().res().in(t).history(tr).getPeriodSum(-year, 0);
/* 204 */       this.out -= FACTIONS.player().res().out(t).history(tr).getPeriodSum(-year, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Data(HGROUP h) {
/* 211 */     this.name = h.name;
/*     */     
/* 213 */     int year = (int)TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */     
/* 215 */     int ii = (STATS.POP()).POP.data(h.type).get(h.race, 0) - (STATS.POP()).POP.data(h.type).get(h.race, year);
/* 216 */     if (ii < 0) {
/* 217 */       this.out += -ii;
/*     */     } else {
/* 219 */       this.in += ii;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean active() {
/* 225 */     return !(this.in == 0 && this.out == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\YearlyFinansials$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
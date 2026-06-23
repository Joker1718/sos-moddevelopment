/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.battle.invasion.InvasionListener;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends InvasionListener
/*     */ {
/*     */   protected void weirdness(int ref) {
/*  85 */     if (RaidingCurrent.this.raider != null && RaidingCurrent.this.state == RaidingCurrent.STATE.INVADING && ref == RaidingCurrent.this.invadeRef) {
/*  86 */       RaidingCurrent.this.state = RaidingCurrent.STATE.STRANGENESS;
/*  87 */       RaidingCurrent.this.timer = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void victory(int lossed, int kills, int ref) {
/*  94 */     if (RaidingCurrent.this.raider != null && RaidingCurrent.this.state == RaidingCurrent.STATE.INVADING && ref == RaidingCurrent.this.invadeRef) {
/*  95 */       GAME.raiders().defeat(RaidingCurrent.this.raider);
/*  96 */       RaidingCurrent.this.state = RaidingCurrent.STATE.DEFEATED;
/*  97 */       RaidingCurrent.this.timer = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void defeat(int lossed, int killsf, int ref) {
/* 103 */     if (RaidingCurrent.this.raider != null && RaidingCurrent.this.state == RaidingCurrent.STATE.INVADING && ref == RaidingCurrent.this.invadeRef) {
/* 104 */       RaidingCurrent.this.state = RaidingCurrent.STATE.VICTORY;
/* 105 */       RaidingCurrent.this.timer = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void register(WArmy a, int ref) {
/* 111 */     if (RaidingCurrent.this.raider != null && a == RaidingCurrent.this.army()) {
/* 112 */       RaidingCurrent.this.currentArmy = -1;
/* 113 */       RaidingCurrent.this.state = RaidingCurrent.STATE.INVADING;
/* 114 */       RaidingCurrent.this.invadeRef = ref;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaidingCurrent$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
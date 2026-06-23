/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.Debugger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends DealBool
/*     */ {
/*     */   private double value;
/*     */   
/*     */   null(LISTE<DealBool> $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3) {
/* 117 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() {
/* 123 */     ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), DIP.NEUTRAL(), DealBools.this.player);
/*     */   }
/*     */ 
/*     */   
/*     */   public double value() {
/* 128 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 133 */     this.value = DealBools.this.pactChange(DIP.NEUTRAL(), deb);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DipStance stance() {
/* 138 */     return DIP.NEUTRAL();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 143 */     if (!DIP.WAR().is(DealBools.this.a.f(), DealBools.this.b.f()))
/* 144 */       return DealBools.¤¤pWarNot; 
/* 145 */     for (DealBool b : DealBools.this.all()) {
/* 146 */       if (b != this && b.is())
/* 147 */         return DealBools.¤¤pOther; 
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
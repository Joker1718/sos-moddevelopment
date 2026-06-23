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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 153 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double value() {
/* 159 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute() {
/* 164 */     ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), DIP.NEUTRAL(), DealBools.this.player);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 169 */     this.value = DealBools.this.pactChange(DIP.NEUTRAL(), deb);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected DipStance stance() {
/* 175 */     return DIP.NEUTRAL();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 180 */     if (!(DIP.get(DealBools.this.a.f(), DealBools.this.b.f())).trades)
/* 181 */       return DealBools.¤¤pNoAgree; 
/* 182 */     for (DealBool b : DealBools.this.all()) {
/* 183 */       if (b != this && b.is())
/* 184 */         return DealBools.¤¤pOther; 
/*     */     } 
/* 186 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
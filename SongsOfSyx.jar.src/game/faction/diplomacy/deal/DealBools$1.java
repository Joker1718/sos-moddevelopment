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
/*     */ class null
/*     */   extends DealBool
/*     */ {
/*     */   null(LISTE<DealBool> $anonymous0, CharSequence $anonymous1, CharSequence $anonymous2, SPRITE $anonymous3) {
/*  82 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute() {
/*  87 */     ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), (DipStance)DIP.WAR(), DealBools.this.player);
/*     */   }
/*     */ 
/*     */   
/*     */   public double value() {
/*  92 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void pInit(DealParty a, DealParty b, Debugger deb) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected DipStance stance() {
/* 102 */     return (DipStance)DIP.WAR();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 107 */     if (DIP.WAR().is(DealBools.this.a.f(), DealBools.this.b.f()))
/* 108 */       return DealBools.¤¤pWarAlready; 
/* 109 */     for (DealBool b : DealBools.this.all()) {
/* 110 */       if (b != this && b.is())
/* 111 */         return DealBools.¤¤pOther; 
/*     */     } 
/* 113 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.Debugger;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 201 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void execute() {
/* 207 */     while (DealBools.this.b.npc().realm().regions() > 1) {
/* 208 */       DealBools.this.b.npc().realm().region(1).fationSet(DealBools.this.a.f(), true);
/*     */     }
/* 210 */     if (DealBools.this.b.f().realm().regions() > 0)
/* 211 */       DealBools.this.b.f().realm().region(0).fationSet(DealBools.this.a.f(), true); 
/* 212 */     FACTIONS.remove(DealBools.this.b.npc(), true);
/* 213 */     (GAME.count()).UNITES.inc(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public double value() {
/* 218 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 224 */     this.value = DealBools.this.pactChange(DIP.VASSAL(), deb);
/* 225 */     this.value -= b.selfWorth();
/*     */     
/* 227 */     if (DIP.WAR().is(a.f(), b.f())) {
/* 228 */       this.value -= b.selfWorth();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected DipStance stance() {
/* 234 */     return DIP.get(DealBools.this.a.f(), DealBools.this.b.f());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 239 */     if (DealBools.this.a.f() == FACTIONS.player() && !RD.DIST().reachable(DealBools.this.b.f()))
/* 240 */       return DealBools.¤¤pDistance; 
/* 241 */     for (DealBool b : DealBools.this.all()) {
/* 242 */       if (b != this && b.is()) {
/* 243 */         return DealBools.¤¤pOther;
/*     */       }
/*     */     } 
/*     */     
/* 247 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
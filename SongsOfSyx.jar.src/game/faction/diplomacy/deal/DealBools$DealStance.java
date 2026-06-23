/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.Debugger;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DealStance
/*     */   extends DealBool
/*     */ {
/*     */   private double vv;
/*     */   private final DipStance ss;
/*     */   
/*     */   DealStance(CharSequence name, CharSequence desc, DipStance stance) {
/* 257 */     super((LISTE<DealBool>)paramDealBools.all, name, desc, stance.icon);
/* 258 */     this.ss = stance;
/*     */   }
/*     */ 
/*     */   
/*     */   public double value() {
/* 263 */     return this.vv;
/*     */   }
/*     */ 
/*     */   
/*     */   public void execute() {
/* 268 */     ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), this.ss, DealBools.this.player);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 273 */     this.vv = DealBools.this.pactChange(this.ss, deb);
/*     */   }
/*     */ 
/*     */   
/*     */   protected DipStance stance() {
/* 278 */     return this.ss;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence problem() {
/* 283 */     if (this.ss.is(DealBools.this.a.f(), DealBools.this.b.f()) || this.ss.is(DealBools.this.b.f(), DealBools.this.a.f())) {
/* 284 */       return DealBools.¤¤pAlready;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 289 */     if (ROPINION.get(DealBools.this.b.npc()) < this.ss.opinionNeeded && !(S.get()).developer) {
/* 290 */       Str.TMP.clear().add(DealBools.¤¤pOpinion).insert(0, this.ss.opinionNeeded, 1);
/* 291 */       return (CharSequence)Str.TMP;
/*     */     } 
/*     */     
/* 294 */     if (this != DealBools.this.TRADE) {
/* 295 */       if (DIP.overlord(DealBools.this.a.f()) != null) {
/* 296 */         return DealBools.¤¤pVassal;
/*     */       }
/* 298 */       if (DIP.overlord(DealBools.this.b.f()) != null) {
/* 299 */         return DealBools.¤¤pVassalOther;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 304 */     if (DealBools.this.a.f() == FACTIONS.player() && !RD.DIST().reachable(DealBools.this.b.f())) {
/* 305 */       return DealBools.¤¤pDistance;
/*     */     }
/* 307 */     for (DealBool b : DealBools.this.all()) {
/* 308 */       if (b != this && b.is())
/* 309 */         return DealBools.¤¤pOther; 
/*     */     } 
/* 311 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GBox b) {
/* 316 */     super.hover(b);
/* 317 */     b.textL(DealBools.¤¤opReq);
/* 318 */     b.tab(7);
/* 319 */     b.add((SPRITE)GFORMAT.f(b.text(), this.ss.opinionNeeded));
/* 320 */     b.NL();
/*     */     
/* 322 */     b.textL(DealBools.¤¤opTarif);
/* 323 */     b.tab(7);
/* 324 */     b.add((SPRITE)GFORMAT.percInv(b.text(), this.ss.tarif));
/* 325 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools$DealStance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
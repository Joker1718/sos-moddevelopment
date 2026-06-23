/*     */ package game.boosting;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Behaviour
/*     */   extends BOOSTABLES.BoostableCollection
/*     */ {
/*     */   public final Boostable LAWFULNESS;
/*     */   public final Boostable SUBMISSION;
/*     */   public final Boostable LOYALTY;
/*     */   public final Boostable HAPPI;
/*     */   public final Boostable HAPPI_SLAVES;
/*     */   public final Boostable SANITY;
/*     */   
/*     */   Behaviour() {
/* 294 */     super("BEHAVIOUR", D.g("Behaviour"));
/*     */ 
/*     */     
/* 297 */     this.LAWFULNESS = make("LAWFULNESS", 1.0D, (Icon)(UI.icons()).s.law, 
/* 298 */         D.g("BEHAVIOUR_LAWFULNESS", "Lawfulness"), 
/* 299 */         D.g("BEHAVIOUR_LAWFULNESS_D", "A lawful citizen is one that is reluctant to commit crime."));
/*     */     
/* 301 */     this.SUBMISSION = make("SUBMISSION", 0.0D, (Icon)(UI.icons()).s.slave, 
/* 302 */         D.g("BEHAVIOUR_SUBMISSION", "Submission"), 
/* 303 */         D.g("BEHAVIOUR_SUBMISSION_D", "The submission of your slaves. Submission under 100% can lead to escaped slaves, or a revolt."));
/*     */     
/* 305 */     this.LOYALTY = make("LOYALTY", 0.0D, (Icon)(UI.icons()).s.column, 
/* 306 */         D.g("BEHAVIOUR_LOYALTY", "Loyalty"), 
/* 307 */         D.g("BEHAVIOUR_LOYALTY_D", "The loyalty of your plebeians. Loyalty under 100% can result in emigration, strikes and riots."));
/*     */     
/* 309 */     this.HAPPI = make("HAPPINESS", 1.0D, (Icon)(UI.icons()).s.heart, 
/* 310 */         D.g("BEHAVIOUR_HAPPINESS", "Happiness"), 
/* 311 */         D.g("BEHAVIOUR_HAPPINESS_D", "Happiness is fulfillment in proportion to expectations. Fulfillment is gained by providing services and a just rule. Expectation is the amount of citizens in your city. Happiness boosts increases loyalty and immigration."));
/*     */     
/* 313 */     this.HAPPI_SLAVES = make("HAPPINESS_SLAVES", 0.5D, (Icon)(UI.icons()).s.heart, 
/* 314 */         D.g("BEHAVIOUR_HAPPINESS_SLAVE", "Happiness (Slaves)"), 
/* 315 */         D.g("BEHAVIOUR_HAPPINESS_SLAVE_D", "Happiness is fulfillment in proportion to expectations. Fulfillment is gained by providing services and a just rule. Expectation is the amount of slaves in your city. Happiness boosts increases submission."));
/*     */     
/* 317 */     this.SANITY = make("SANITY", 1.0D, (Icon)(UI.icons()).s.crazy, 
/* 318 */         D.g("BEHAVIOUR_SANITY", "Sanity"), 
/* 319 */         D.g("BEHAVIOUR_SANITY_D", "Determines the chance a subject will become deranged during its lifetime."));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTABLES$Behaviour.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
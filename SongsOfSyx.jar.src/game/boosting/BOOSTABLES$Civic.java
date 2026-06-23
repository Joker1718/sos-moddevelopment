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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Civic
/*     */   extends BOOSTABLES.BoostableCollection
/*     */ {
/*     */   public final Boostable MAINTENANCE;
/*     */   public final Boostable SPOILAGE;
/*     */   public final Boostable ACCIDENT;
/*     */   public final Boostable FURNITURE;
/*     */   public final Boostable RAID_SECURITY;
/*     */   public final Boostable DEFALTION;
/*     */   public final Boostable IMMIGRATION;
/*     */   public final Boostable INNOVATION;
/*     */   public final Boostable DIPLOMACY;
/*     */   public final Boostable LANDING;
/*     */   public final Boostable LAW;
/*     */   public final Boostable GOV;
/*     */   public final Boostable bOpinion;
/*     */   public final Boostable TRUST;
/*     */   
/*     */   Civic() {
/* 325 */     super("CIVIC", D.g("Civic"));
/*     */ 
/*     */     
/* 328 */     this.MAINTENANCE = make("MAINTENANCE", 1.0D, (Icon)(UI.icons()).s.degrade, 
/* 329 */         D.g("CIVIC_MAINTENANCE", "Robustness"), 
/* 330 */         D.g("CIVIC_MAINTENANCE_D", "Decreases the rate at which our buildings degrade."));
/*     */     
/* 332 */     this.SPOILAGE = make("SPOILAGE", 1.0D, (Icon)(UI.icons()).s.fly, 
/* 333 */         D.g("CIVIC_SPOILAGE", "Conservation"), 
/* 334 */         D.g("CIVIC_SPOILAGE_D", "Decreases the decay rate of goods."));
/*     */     
/* 336 */     this.ACCIDENT = make("ACCIDENT", 1.0D, (Icon)(UI.icons()).s.boom, 
/* 337 */         D.g("CIVIC_ACCIDENT", "Safety"), 
/* 338 */         D.g("CIVIC_ACCIDENT_D", "Decreases the chance of work related accidents."));
/*     */     
/* 340 */     this.FURNITURE = make("FURNITURE", 1.0D, (Icon)(UI.icons()).s.bed, 
/* 341 */         D.g("CIVIC_FURNITURE", "Furnishing"), 
/* 342 */         D.g("CIVIC_FURNITURE_D", "Decreases the rate at which subjects use up the furniture of their homes."));
/*     */     
/* 344 */     this.RAID_SECURITY = make("RAIDING", 1.0D, (Icon)(UI.icons()).s.headspike, 
/* 345 */         D.g("CIVIC_RAIDING", "Raid Security"), 
/* 346 */         D.g("CIVIC_RAIDING_D", "Determines the chances of us being raided"));
/*     */     
/* 348 */     this.DEFALTION = make("DEFLATION", 1.0D, (Icon)(UI.icons()).s.money, 
/* 349 */         D.g("Deflation"), 
/* 350 */         D.g("deflationD", "Decreases the inflation of your treasury, allowing you to save up more."));
/*     */     
/* 352 */     this.IMMIGRATION = make("IMMIGRATION", 4.5D, (Icon)(UI.icons()).s.human, 
/* 353 */         D.g("Immigration Speed"), 
/* 354 */         D.g("ImmigrationD", "Increases the replenishment of the immigration pool."));
/*     */ 
/*     */     
/* 357 */     this.INNOVATION = make("INNOVATION", 0.0D, (Icon)(UI.icons()).s.vial, 
/* 358 */         D.g("INNOVATION", "Innovation"), 
/* 359 */         D.g("INNOVATION_D", "Used for technologies."));
/*     */     
/* 361 */     this.DIPLOMACY = make("DIPLOMACY", 0.0D, (Icon)(UI.icons()).s.emissary, 
/* 362 */         D.g("EMISSARY", "Emissary Points"), 
/* 363 */         D.g("EMISSARY_D", "Used to manipulate opinions of factions."));
/*     */     
/* 365 */     this.LANDING = make("LANDING", 0.0D, (Icon)(UI.icons()).s.arrowUp, 
/* 366 */         D.g("START_LANDING", "Settle"), 
/* 367 */         D.g("START_LANDING_D", "Increases your starting subjects and resources."));
/*     */     
/* 369 */     this.LAW = make("LAW", 0.05D, (Icon)(UI.icons()).s.law, 
/* 370 */         D.g("CIVIC_LAW", "Law"), 
/* 371 */         D.g("CIVIC_LAW_D", "The law of your city. Law is added to loyalty/submission for your subjects. It is gained primarily from guards."));
/*     */     
/* 373 */     this.GOV = make("GOV", 5.0D, (UI.icons()).m.gov, 
/* 374 */         D.g("CIVIC_GOV", "Gov Points"), 
/* 375 */         D.g("CIVIC_GOV_D", "The main currency to build your realm with. Gained by assigning nobles to government duties."));
/*     */     
/* 377 */     this.bOpinion = make("OPINION", 1.5D, (Icon)(UI.icons()).s.soso, 
/* 378 */         D.g("CIVIC_OPINION", "Opinion"), 
/* 379 */         D.g("CIVIC_OPINION_D", "Determines the opinion of other factions."));
/*     */     
/* 381 */     this.TRUST = make("TRUST", 0.0D, (Icon)(UI.icons()).s.trust, 
/* 382 */         D.g("CIVIC_TRUST", "Trust"), 
/* 383 */         D.g("CIVIC_TRUST_D", "A faction's trust is how reliable they are when it comes to keeping their treaties and not starting a war against you."));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTABLES$Civic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
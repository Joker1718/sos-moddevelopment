/*     */ package game.boosting;
/*     */ 
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*     */ public final class Physics
/*     */   extends BOOSTABLES.BoostableCollection
/*     */ {
/*     */   public final Boostable MASS;
/*     */   public final Boostable STAMINA;
/*     */   public final Boostable SPEED;
/*     */   public final Boostable ACCELERATION;
/*     */   public final Boostable HEALTH;
/*     */   public final Boostable RESISTANCE_HOT;
/*     */   public final Boostable RESISTANCE_COLD;
/*     */   public final Boostable SOILING;
/*     */   public final Boostable DEATH_AGE;
/*     */   public final Boostable REPRODUCTION_AGE;
/*     */   public final Boostable REPRODUCTION_SPEED;
/*     */   
/*     */   Physics() {
/* 113 */     super("PHYSICS", D.g("Physics"));
/*     */ 
/*     */     
/* 116 */     this.MASS = make("MASS", 80.0D, (Icon)(UI.icons()).s.law, 
/* 117 */         D.g("PHYSICS_MASS", "Weight"), 
/* 118 */         D.g("PHYSICS_MASS_D", "The Weight of a subject."));
/*     */     
/* 120 */     this.STAMINA = make("STAMINA", 1.0D, (Icon)(UI.icons()).s.heat, 
/* 121 */         D.g("PHYSICS_STAMINA", "Stamina"), 
/* 122 */         D.g("PHYSICS_STAMINA_D", "How long a subject can walk or run before needing to rest."));
/*     */     
/* 124 */     this.SPEED = make("SPEED", 4.5D, (Icon)(UI.icons()).s.arrow_right, 
/* 125 */         D.g("PHYSICS_SPEED", "Speed"), 
/* 126 */         D.g("PHYSICS_SPEED_D", "The speed of a subject, expressed in tiles per second."));
/*     */     
/* 128 */     this.ACCELERATION = make("ACCELERATION", 3.0D, (Icon)(UI.icons()).s.speed, 
/* 129 */         D.g("PHYSICS_ACCELERATION", "Acceleration"), 
/* 130 */         D.g("PHYSICS_ACCELERATION_D", "How fast a subject speeds up."));
/*     */     
/* 132 */     this.HEALTH = make("HEALTH", 1.0D, (Icon)(UI.icons()).s.plusBig, 
/* 133 */         D.g("PHYSICS_HEALTH", "Health"), 
/* 134 */         D.g("PHYSICS_HEALTH_D", "General health of subject. The higher health, the less likely a subject is to contract disease. Low values (below 1), might lead to serious outbreaks and should be top priority to fix."));
/*     */     
/* 136 */     this.RESISTANCE_HOT = make("RESISTANCE_HOT", 0.5D, (Icon)(UI.icons()).s.heat, 
/* 137 */         D.g("PHYSICS_RESISTANCE_HOT", "Heat Resistance"), 
/* 138 */         D.g("PHYSICS_RESISTANCE_HOT_D", "The ability for a subject to endure hot temperatures."));
/*     */     
/* 140 */     this.RESISTANCE_COLD = make("RESISTANCE_COLD", 0.5D, (Icon)(UI.icons()).s.ice, 
/* 141 */         D.g("PHYSICS_RESISTANCE_COLD", "Cold Resistance"), 
/* 142 */         D.g("PHYSICS_RESISTANCE_COLD_D", "The ability for a subject to endure cold temperatures."));
/*     */     
/* 144 */     this.SOILING = make("SOILING", 0.125D, (Icon)(UI.icons()).s.ice, 
/* 145 */         D.g("PHYSICS_SOILING", "Soiling"), 
/* 146 */         D.g("PHYSICS_SOILING_D", "The rate at which a subject becomes dirty."));
/*     */     
/* 148 */     this.DEATH_AGE = make("DEATH_AGE", 100.0D, (Icon)(UI.icons()).s.death, 
/* 149 */         D.g("PHYSICS_DEATH_AGE", "Lifespan"), 
/* 150 */         D.g("PHYSICS_DEATH_AGE_D", "The maximum amount of years a subject can live for."));
/*     */     
/* 152 */     this.REPRODUCTION_AGE = make("REPRODUCTION_AGE", 0.5D, (Icon)(UI.icons()).s.reproduction, 
/* 153 */         D.g("REPRODUCTION_AGE", "Reproduction Age"), 
/* 154 */         D.g("REPRODUCTION_AGE_D", "The part at which a subject stays fertile."));
/*     */     
/* 156 */     this.REPRODUCTION_SPEED = make("REPRODUCTION_SPEED", 0.1D, (UI.icons()).s.reproduction.twin((SPRITE)(UI.icons()).s.plus), 
/* 157 */         D.g("REPRODUCTION_SPEED", "Natural Births /year"), 
/* 158 */         D.g("REPRODUCTION_SPEED_D", "The speed at which a subject propagates naturally."));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTABLES$Physics.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
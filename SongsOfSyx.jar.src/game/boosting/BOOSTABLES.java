/*     */ package game.boosting;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.info.INFO;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ 
/*     */ public class BOOSTABLES {
/*     */   static BOOSTABLES self;
/*     */   private final Physics physics;
/*     */   private final Battle battle;
/*     */   private final Behaviour behaviour;
/*     */   private final Activity activities;
/*     */   private final Civic civics;
/*     */   private final Noble noble;
/*     */   public final BoostableCat ROOMS;
/*     */   public final LIST<BoostableCat> collections;
/*     */   
/*     */   private BOOSTABLES() throws IOException {
/*  28 */     D.gInit(this);
/*     */ 
/*     */     
/*  31 */     this.physics = new Physics();
/*  32 */     this.battle = new Battle();
/*  33 */     this.behaviour = new Behaviour();
/*  34 */     this.activities = new Activity();
/*  35 */     this.civics = new Civic();
/*  36 */     this.noble = new Noble();
/*     */     
/*  38 */     this.ROOMS = new BoostableCollection("ROOM", Dic.¤¤Buildings);
/*  39 */     this.collections = (LIST<BoostableCat>)new ArrayList((Object[])new BoostableCat[] { this.physics, this.behaviour, this.activities, this.battle, this.civics, this.ROOMS, this.noble });
/*     */ 
/*     */     
/*  42 */     self = this;
/*  43 */     PATHS.ResFolder f = PATHS.STATS().folder("dynamicBoost");
/*  44 */     KeyMap<BoostableCat> map = new KeyMap();
/*  45 */     for (BoostableCat c : this.collections)
/*  46 */       map.put(c.prefix.substring(0, c.prefix.length() - 1), c);  byte b; int i;
/*     */     String[] arrayOfString;
/*  48 */     for (i = (arrayOfString = f.init.getFiles()).length, b = 0; b < i; ) { String key = arrayOfString[b];
/*     */       
/*  50 */       Json j = new Json(f.init.gets(key));
/*  51 */       String ck = j.value("CATEGORY");
/*  52 */       if (!map.containsKey(ck)) {
/*  53 */         LOG.err("No CATEGORY named: " + ck + " available: " + map.keysString());
/*     */       } else {
/*     */         
/*  56 */         BoostableCat c = (BoostableCat)map.get(ck);
/*  57 */         double base = j.d("BASE_VALUE", -100000.0D, 100000.0D);
/*  58 */         Json t = new Json(f.text.gets(key));
/*  59 */         Icon icon = UI.icons().get(j);
/*     */         
/*  61 */         BOOSTING.push(key, base, t.text("NAME"), t.text("DESC"), (SPRITE)icon, c);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void init() throws IOException {}
/*     */ 
/*     */   
/*     */   public static Physics PHYSICS() {
/*  73 */     return self.physics;
/*     */   }
/*     */   
/*     */   public static Battle BATTLE() {
/*  77 */     return self.battle;
/*     */   }
/*     */   
/*     */   public static Behaviour BEHAVIOUR() {
/*  81 */     return self.behaviour;
/*     */   }
/*     */   
/*     */   public static Activity ACTIVITY() {
/*  85 */     return self.activities;
/*     */   }
/*     */   
/*     */   public static Noble NOBLE() {
/*  89 */     return self.noble;
/*     */   }
/*     */   
/*     */   public static Civic CIVICS() {
/*  93 */     return self.civics;
/*     */   }
/*     */   
/*     */   public static BoostableCat ROOMS() {
/*  97 */     return self.ROOMS;
/*     */   }
/*     */   
/*     */   public static BoostableCat CONSUMPTION() {
/* 101 */     return self.ROOMS;
/*     */   }
/*     */   
/*     */   public static LIST<BoostableCat> colls() {
/* 105 */     return self.collections;
/*     */   }
/*     */   public static final class Physics extends BoostableCollection { public final Boostable MASS; public final Boostable STAMINA; public final Boostable SPEED; public final Boostable ACCELERATION; public final Boostable HEALTH; public final Boostable RESISTANCE_HOT; public final Boostable RESISTANCE_COLD; public final Boostable SOILING;
/*     */     public final Boostable DEATH_AGE;
/*     */     public final Boostable REPRODUCTION_AGE;
/*     */     public final Boostable REPRODUCTION_SPEED;
/*     */     
/*     */     Physics() {
/* 113 */       super("PHYSICS", D.g("Physics"));
/*     */ 
/*     */       
/* 116 */       this.MASS = make("MASS", 80.0D, (Icon)(UI.icons()).s.law, 
/* 117 */           D.g("PHYSICS_MASS", "Weight"), 
/* 118 */           D.g("PHYSICS_MASS_D", "The Weight of a subject."));
/*     */       
/* 120 */       this.STAMINA = make("STAMINA", 1.0D, (Icon)(UI.icons()).s.heat, 
/* 121 */           D.g("PHYSICS_STAMINA", "Stamina"), 
/* 122 */           D.g("PHYSICS_STAMINA_D", "How long a subject can walk or run before needing to rest."));
/*     */       
/* 124 */       this.SPEED = make("SPEED", 4.5D, (Icon)(UI.icons()).s.arrow_right, 
/* 125 */           D.g("PHYSICS_SPEED", "Speed"), 
/* 126 */           D.g("PHYSICS_SPEED_D", "The speed of a subject, expressed in tiles per second."));
/*     */       
/* 128 */       this.ACCELERATION = make("ACCELERATION", 3.0D, (Icon)(UI.icons()).s.speed, 
/* 129 */           D.g("PHYSICS_ACCELERATION", "Acceleration"), 
/* 130 */           D.g("PHYSICS_ACCELERATION_D", "How fast a subject speeds up."));
/*     */       
/* 132 */       this.HEALTH = make("HEALTH", 1.0D, (Icon)(UI.icons()).s.plusBig, 
/* 133 */           D.g("PHYSICS_HEALTH", "Health"), 
/* 134 */           D.g("PHYSICS_HEALTH_D", "General health of subject. The higher health, the less likely a subject is to contract disease. Low values (below 1), might lead to serious outbreaks and should be top priority to fix."));
/*     */       
/* 136 */       this.RESISTANCE_HOT = make("RESISTANCE_HOT", 0.5D, (Icon)(UI.icons()).s.heat, 
/* 137 */           D.g("PHYSICS_RESISTANCE_HOT", "Heat Resistance"), 
/* 138 */           D.g("PHYSICS_RESISTANCE_HOT_D", "The ability for a subject to endure hot temperatures."));
/*     */       
/* 140 */       this.RESISTANCE_COLD = make("RESISTANCE_COLD", 0.5D, (Icon)(UI.icons()).s.ice, 
/* 141 */           D.g("PHYSICS_RESISTANCE_COLD", "Cold Resistance"), 
/* 142 */           D.g("PHYSICS_RESISTANCE_COLD_D", "The ability for a subject to endure cold temperatures."));
/*     */       
/* 144 */       this.SOILING = make("SOILING", 0.125D, (Icon)(UI.icons()).s.ice, 
/* 145 */           D.g("PHYSICS_SOILING", "Soiling"), 
/* 146 */           D.g("PHYSICS_SOILING_D", "The rate at which a subject becomes dirty."));
/*     */       
/* 148 */       this.DEATH_AGE = make("DEATH_AGE", 100.0D, (Icon)(UI.icons()).s.death, 
/* 149 */           D.g("PHYSICS_DEATH_AGE", "Lifespan"), 
/* 150 */           D.g("PHYSICS_DEATH_AGE_D", "The maximum amount of years a subject can live for."));
/*     */       
/* 152 */       this.REPRODUCTION_AGE = make("REPRODUCTION_AGE", 0.5D, (Icon)(UI.icons()).s.reproduction, 
/* 153 */           D.g("REPRODUCTION_AGE", "Reproduction Age"), 
/* 154 */           D.g("REPRODUCTION_AGE_D", "The part at which a subject stays fertile."));
/*     */       
/* 156 */       this.REPRODUCTION_SPEED = make("REPRODUCTION_SPEED", 0.1D, (UI.icons()).s.reproduction.twin((SPRITE)(UI.icons()).s.plus), 
/* 157 */           D.g("REPRODUCTION_SPEED", "Natural Births /year"), 
/* 158 */           D.g("REPRODUCTION_SPEED_D", "The speed at which a subject propagates naturally."));
/*     */     } }
/*     */ 
/*     */   
/*     */   public static final class Battle
/*     */     extends BoostableCollection
/*     */   {
/* 165 */     public final Boostable OFFENCE = make("OFFENCE_SKILL", 1.0D, (Icon)(UI.icons()).s.sword, 
/* 166 */         D.g("BATTLE_OFFENCE_SKILL", "Offence"), 
/* 167 */         D.g("BATTLE_OFFENCE_SKILL_D", "Increases the ability to attack an enemy."));
/*     */     
/* 169 */     public final Boostable DEFENCE = make("DEFENCE_SKILL", 1.0D, (Icon)(UI.icons()).s.shield, 
/* 170 */         D.g("BATTLE_DEFENCE_SKILL", "Defence"), 
/* 171 */         D.g("BATTLE_DEFENCE_SKILL_D", "Increases the ability to avoid attacks when attacked frontally."));
/*     */     
/* 173 */     public final Boostable DEXTERITY = make("DEXTERITY", 5.0D, (Icon)(UI.icons()).s.crossheir, 
/* 174 */         D.g("BATTLE_DEXTERITY", "Dexterity"), 
/* 175 */         D.g("BATTLE_DEXTERITY_D", "Ability to avoid the targets block armour when attacking."));
/*     */     
/* 177 */     public final Boostable PARRY = make("BLOCK", 1.0D, (Icon)(UI.icons()).s.crossheir, 
/* 178 */         D.g("BATTLE_BLOCK", "Block"), 
/* 179 */         D.g("BATTLE_BLOCK_D", "Ability to use the parry attacks and reduce damage with block armour."));
/*     */     
/* 181 */     public final Boostable CHARGE = make("CHARGE", 1.0D, (Icon)(UI.icons()).s.speed, 
/* 182 */         D.g("BATTLE_CHARGE", "Charge"), 
/* 183 */         D.g("BATTLE_CHARGE_D", "Adds extra attack to charge attacks."));
/*     */     
/* 185 */     public final Boostable FORMATION = make("FORMATION_SKILL", 0.0D, (Icon)(UI.icons()).s.muster, 
/* 186 */         D.g("BATTLE_FORMATION_SKILL", "Formation"), 
/* 187 */         D.g("BATTLE_FORMATION_SKILL_D", "Increases defence and parry when in an intact formation and attacked from the front."));
/*     */     
/* 189 */     public final Boostable BLUNT_ATTACK = make("BLUNT_ATTACK", 40.0D, (Icon)(UI.icons()).s.fist, 
/* 190 */         D.g("BATTLE_BLUNT_DAMAGE", "Force"), 
/* 191 */         D.g("BATTLE_BLUNT_DAMAGE_D", "The force of any attack. Force applies damage in itself, but also amplified the attack of other damage types when attacking. Force also creates knock-back that can disrupt enemy formations."));
/*     */     
/* 193 */     public final Boostable BLUNT_DEFENCE = make("BLUNT_DEFENCE", 40.0D, (Icon)(UI.icons()).s.fist, 
/* 194 */         D.g("BATTLE_BLUNT_DEFENCE", "Force Absorbtion"), 
/* 195 */         D.g("BATTLE_BLUNT_DEFENCE_D", "Ability to absorb damage."));
/*     */     
/* 197 */     public final Boostable BLUNT_DEFENCE_DIR = make("BLUNT_DEFENCE_DIR", 1.0D, (Icon)(UI.icons()).s.fist, 
/* 198 */         D.g("BATTLE_BLUNT_DEFENCE_DIR", "Force Block"), 
/* 199 */         D.g("BATTLE_BLUNT_DEFENCE_DIR_D", "Force damage absorbtion when an attack is parried."));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 206 */     public final Boostable MORALE = make("MORALE", 4.0D, (Icon)(UI.icons()).s.standard, 
/* 207 */         D.g("BATTLE_MORALE", "Morale"), 
/* 208 */         D.g("BATTLE_MORALE_D", "A soldier's morale is what determines how long, and against what odds and setbacks, it will fight for before taking flight."));
/*     */     
/*     */     public final LIST<BOOSTABLES.BDamage> DAMAGES;
/*     */     
/*     */     public final RMAP<BOOSTABLES.BDamage> DAMAGE_COLL;
/*     */     
/*     */     Battle() throws IOException {
/* 215 */       super("BATTLE", D.g("Battle"));
/*     */ 
/*     */ 
/*     */       
/* 219 */       PATHS.ResFolder p = PATHS.STATS().folder("damage");
/* 220 */       LinkedList<BOOSTABLES.BDamage> pairs = new LinkedList();
/*     */       
/* 222 */       int index = 0;
/* 223 */       LinkedList<BOOSTABLES.BDamage> da = new LinkedList(); byte b; int i;
/*     */       String[] arrayOfString;
/* 225 */       for (i = (arrayOfString = p.init.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/* 226 */         BOOSTABLES.BDamage d = new BOOSTABLES.BDamage(index++, this, f, new Json(p.init.gets(f)), new Json(p.text.gets(f)));
/* 227 */         pairs.add(d);
/* 228 */         da.add(d);
/*     */         
/*     */         b++; }
/*     */       
/* 232 */       KeyMap<BOOSTABLES.BDamage> map = new KeyMap();
/* 233 */       for (BOOSTABLES.BDamage pa : pairs) {
/* 234 */         map.put(pa.key, pa);
/*     */       }
/* 236 */       this.DAMAGES = (LIST<BOOSTABLES.BDamage>)new ArrayList((Iterable)pairs);
/*     */       
/* 238 */       this.DAMAGE_COLL = new RMAP("DAMAGE", this.DAMAGES);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class BDamage
/*     */     implements MAPPED
/*     */   {
/*     */     private final int index;
/*     */     
/*     */     public final String key;
/*     */     
/*     */     public Boostable attack;
/*     */     
/*     */     public Boostable defence;
/*     */     
/*     */     public Boostable defenceDir;
/*     */     
/*     */     public final CharSequence name;
/*     */     
/*     */     private BDamage(int index, BoostableCat cat, String key, Json data, Json text) throws IOException {
/* 259 */       this.key = key;
/* 260 */       this.name = text.text("NAME");
/* 261 */       this.attack = make(cat, key, "ATTACK", data, text);
/* 262 */       this.defence = make(cat, key, "DEFENCE", data, text);
/* 263 */       this.defenceDir = make(cat, key, "DEFENCE_DIR", data, text);
/* 264 */       this.index = index;
/*     */     }
/*     */     
/*     */     private Boostable make(BoostableCat cat, String key, String pp, Json data, Json text) throws IOException {
/* 268 */       key = key + "_" + key;
/* 269 */       data = data.json(pp);
/*     */       
/* 271 */       double dd = data.d("DEFAULT_VALUE", 0.0D, 100000.0D);
/* 272 */       Icon icon = SPRITES.icons().get(data);
/* 273 */       INFO info = new INFO(text.json(pp));
/* 274 */       return BOOSTING.push(key, dd, info.name, info.desc, (SPRITE)icon, cat);
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 279 */       return this.index;
/*     */     }
/*     */ 
/*     */     
/*     */     public String key() {
/* 284 */       return this.key;
/*     */     } }
/*     */   public static final class Behaviour extends BoostableCollection { public final Boostable LAWFULNESS;
/*     */     public final Boostable SUBMISSION;
/*     */     public final Boostable LOYALTY;
/*     */     public final Boostable HAPPI;
/*     */     public final Boostable HAPPI_SLAVES;
/*     */     public final Boostable SANITY;
/*     */     
/*     */     Behaviour() {
/* 294 */       super("BEHAVIOUR", D.g("Behaviour"));
/*     */ 
/*     */       
/* 297 */       this.LAWFULNESS = make("LAWFULNESS", 1.0D, (Icon)(UI.icons()).s.law, 
/* 298 */           D.g("BEHAVIOUR_LAWFULNESS", "Lawfulness"), 
/* 299 */           D.g("BEHAVIOUR_LAWFULNESS_D", "A lawful citizen is one that is reluctant to commit crime."));
/*     */       
/* 301 */       this.SUBMISSION = make("SUBMISSION", 0.0D, (Icon)(UI.icons()).s.slave, 
/* 302 */           D.g("BEHAVIOUR_SUBMISSION", "Submission"), 
/* 303 */           D.g("BEHAVIOUR_SUBMISSION_D", "The submission of your slaves. Submission under 100% can lead to escaped slaves, or a revolt."));
/*     */       
/* 305 */       this.LOYALTY = make("LOYALTY", 0.0D, (Icon)(UI.icons()).s.column, 
/* 306 */           D.g("BEHAVIOUR_LOYALTY", "Loyalty"), 
/* 307 */           D.g("BEHAVIOUR_LOYALTY_D", "The loyalty of your plebeians. Loyalty under 100% can result in emigration, strikes and riots."));
/*     */       
/* 309 */       this.HAPPI = make("HAPPINESS", 1.0D, (Icon)(UI.icons()).s.heart, 
/* 310 */           D.g("BEHAVIOUR_HAPPINESS", "Happiness"), 
/* 311 */           D.g("BEHAVIOUR_HAPPINESS_D", "Happiness is fulfillment in proportion to expectations. Fulfillment is gained by providing services and a just rule. Expectation is the amount of citizens in your city. Happiness boosts increases loyalty and immigration."));
/*     */       
/* 313 */       this.HAPPI_SLAVES = make("HAPPINESS_SLAVES", 0.5D, (Icon)(UI.icons()).s.heart, 
/* 314 */           D.g("BEHAVIOUR_HAPPINESS_SLAVE", "Happiness (Slaves)"), 
/* 315 */           D.g("BEHAVIOUR_HAPPINESS_SLAVE_D", "Happiness is fulfillment in proportion to expectations. Fulfillment is gained by providing services and a just rule. Expectation is the amount of slaves in your city. Happiness boosts increases submission."));
/*     */       
/* 317 */       this.SANITY = make("SANITY", 1.0D, (Icon)(UI.icons()).s.crazy, 
/* 318 */           D.g("BEHAVIOUR_SANITY", "Sanity"), 
/* 319 */           D.g("BEHAVIOUR_SANITY_D", "Determines the chance a subject will become deranged during its lifetime."));
/*     */     } }
/*     */   public static final class Civic extends BoostableCollection { public final Boostable MAINTENANCE; public final Boostable SPOILAGE; public final Boostable ACCIDENT; public final Boostable FURNITURE; public final Boostable RAID_SECURITY; public final Boostable DEFALTION;
/*     */     public final Boostable IMMIGRATION;
/*     */     
/*     */     Civic() {
/* 325 */       super("CIVIC", D.g("Civic"));
/*     */ 
/*     */       
/* 328 */       this.MAINTENANCE = make("MAINTENANCE", 1.0D, (Icon)(UI.icons()).s.degrade, 
/* 329 */           D.g("CIVIC_MAINTENANCE", "Robustness"), 
/* 330 */           D.g("CIVIC_MAINTENANCE_D", "Decreases the rate at which our buildings degrade."));
/*     */       
/* 332 */       this.SPOILAGE = make("SPOILAGE", 1.0D, (Icon)(UI.icons()).s.fly, 
/* 333 */           D.g("CIVIC_SPOILAGE", "Conservation"), 
/* 334 */           D.g("CIVIC_SPOILAGE_D", "Decreases the decay rate of goods."));
/*     */       
/* 336 */       this.ACCIDENT = make("ACCIDENT", 1.0D, (Icon)(UI.icons()).s.boom, 
/* 337 */           D.g("CIVIC_ACCIDENT", "Safety"), 
/* 338 */           D.g("CIVIC_ACCIDENT_D", "Decreases the chance of work related accidents."));
/*     */       
/* 340 */       this.FURNITURE = make("FURNITURE", 1.0D, (Icon)(UI.icons()).s.bed, 
/* 341 */           D.g("CIVIC_FURNITURE", "Furnishing"), 
/* 342 */           D.g("CIVIC_FURNITURE_D", "Decreases the rate at which subjects use up the furniture of their homes."));
/*     */       
/* 344 */       this.RAID_SECURITY = make("RAIDING", 1.0D, (Icon)(UI.icons()).s.headspike, 
/* 345 */           D.g("CIVIC_RAIDING", "Raid Security"), 
/* 346 */           D.g("CIVIC_RAIDING_D", "Determines the chances of us being raided"));
/*     */       
/* 348 */       this.DEFALTION = make("DEFLATION", 1.0D, (Icon)(UI.icons()).s.money, 
/* 349 */           D.g("Deflation"), 
/* 350 */           D.g("deflationD", "Decreases the inflation of your treasury, allowing you to save up more."));
/*     */       
/* 352 */       this.IMMIGRATION = make("IMMIGRATION", 4.5D, (Icon)(UI.icons()).s.human, 
/* 353 */           D.g("Immigration Speed"), 
/* 354 */           D.g("ImmigrationD", "Increases the replenishment of the immigration pool."));
/*     */ 
/*     */       
/* 357 */       this.INNOVATION = make("INNOVATION", 0.0D, (Icon)(UI.icons()).s.vial, 
/* 358 */           D.g("INNOVATION", "Innovation"), 
/* 359 */           D.g("INNOVATION_D", "Used for technologies."));
/*     */       
/* 361 */       this.DIPLOMACY = make("DIPLOMACY", 0.0D, (Icon)(UI.icons()).s.emissary, 
/* 362 */           D.g("EMISSARY", "Emissary Points"), 
/* 363 */           D.g("EMISSARY_D", "Used to manipulate opinions of factions."));
/*     */       
/* 365 */       this.LANDING = make("LANDING", 0.0D, (Icon)(UI.icons()).s.arrowUp, 
/* 366 */           D.g("START_LANDING", "Settle"), 
/* 367 */           D.g("START_LANDING_D", "Increases your starting subjects and resources."));
/*     */       
/* 369 */       this.LAW = make("LAW", 0.05D, (Icon)(UI.icons()).s.law, 
/* 370 */           D.g("CIVIC_LAW", "Law"), 
/* 371 */           D.g("CIVIC_LAW_D", "The law of your city. Law is added to loyalty/submission for your subjects. It is gained primarily from guards."));
/*     */       
/* 373 */       this.GOV = make("GOV", 5.0D, (UI.icons()).m.gov, 
/* 374 */           D.g("CIVIC_GOV", "Gov Points"), 
/* 375 */           D.g("CIVIC_GOV_D", "The main currency to build your realm with. Gained by assigning nobles to government duties."));
/*     */       
/* 377 */       this.bOpinion = make("OPINION", 1.5D, (Icon)(UI.icons()).s.soso, 
/* 378 */           D.g("CIVIC_OPINION", "Opinion"), 
/* 379 */           D.g("CIVIC_OPINION_D", "Determines the opinion of other factions."));
/*     */       
/* 381 */       this.TRUST = make("TRUST", 0.0D, (Icon)(UI.icons()).s.trust, 
/* 382 */           D.g("CIVIC_TRUST", "Trust"), 
/* 383 */           D.g("CIVIC_TRUST_D", "A faction's trust is how reliable they are when it comes to keeping their treaties and not starting a war against you."));
/*     */     }
/*     */     public final Boostable INNOVATION; public final Boostable DIPLOMACY; public final Boostable LANDING; public final Boostable LAW; public final Boostable GOV; public final Boostable bOpinion; public final Boostable TRUST; }
/*     */   public static final class Activity extends BoostableCollection { public final Boostable MOURN; public final Boostable PUNISHMENT; public final Boostable JUDGE;
/*     */     public final Boostable SOCIAL;
/*     */     
/*     */     Activity() {
/* 390 */       super("ACTIVITY", D.g("Activities"));
/*     */ 
/*     */       
/* 393 */       this.MOURN = make("MOURN", 1.0D, (Icon)(UI.icons()).s.death, 
/* 394 */           D.g("ACTIVITY_MOURN", "Mourning"), 
/* 395 */           D.g("ACTIVITY_MOURN_D", "Sentimentality for the dead. How often a subject will visit a grave and mourn."));
/*     */       
/* 397 */       this.PUNISHMENT = make("PUNISHMENT", 1.0D, (Icon)(UI.icons()).s.law, 
/* 398 */           D.g("ACTIVITY_PUNISHMENT", "Punishment"), 
/* 399 */           D.g("ACTIVITY_PUNISHMENT_D", "How often a subject wants to see a punishment such as an execution."));
/*     */       
/* 401 */       this.JUDGE = make("JUDGE", 1.0D, (Icon)(UI.icons()).s.honor, 
/* 402 */           D.g("ACTIVITY_JUDGE", "Judgement"), 
/* 403 */           D.g("ACTIVITY_JUDGE_D", "How often a subject wants to visit a court."));
/*     */       
/* 405 */       this.SOCIAL = make("SOCIAL", 1.0D, (Icon)(UI.icons()).s.handOpen, 
/* 406 */           D.g("ACTIVITY_SOCIAL", "Social"), 
/* 407 */           D.g("ACTIVITY_SOCIAL_D", "How often a subject wants to socialize with others."));
/*     */     } }
/*     */   public static final class Noble extends BoostableCollection { public final Boostable AGRESSION; public final Boostable PRIDE; public final Boostable HONOUR; public final Boostable MERCY;
/*     */     public final Boostable COMPETANCE;
/*     */     public final Boostable TOLERANCE;
/*     */     
/*     */     Noble() {
/* 414 */       super("NOBLE", D.g("Personality"));
/*     */ 
/*     */       
/* 417 */       this.AGRESSION = make("AGRRESSION", 1.0D, (Icon)(UI.icons()).s.sword, 
/* 418 */           D.g("NOBLE_AGRRESSION", "Aggression"), 
/* 419 */           D.g("NOBLE_AGRRESSION_D", "How much war is liked."));
/*     */       
/* 421 */       this.PRIDE = make("PRIDE", 1.0D, (Icon)(UI.icons()).s.law, 
/* 422 */           D.g("NOBLE_PRIDE", "Pride"), 
/* 423 */           D.g("NOBLE_PRIDE_D", "Prideful people put great value in flattery and gifts."));
/*     */       
/* 425 */       this.HONOUR = make("HONOUR", 1.0D, (Icon)(UI.icons()).s.honor, 
/* 426 */           D.g("NOBLE_HONOR", "Honour"), 
/* 427 */           D.g("NOBLE_HONOR_D", "The value put in pledges and agreements."));
/*     */       
/* 429 */       this.MERCY = make("MERCY", 1.0D, (Icon)(UI.icons()).s.handOpen, 
/* 430 */           D.g("NOBLE_MERCY", "Mercy"), 
/* 431 */           D.g("NOBLE_MERCY_D", "The inclination towards mercy as opposed to cruelty."));
/*     */       
/* 433 */       this.COMPETANCE = make("COMPETENCE", 1.0D, (Icon)(UI.icons()).s.cog, 
/* 434 */           D.g("NOBLE_COMPETENCE", "Competence"), 
/* 435 */           D.g("NOBLE_COMPETANCE_D", "The general competence."));
/*     */       
/* 437 */       this.TOLERANCE = make("TOLERANCE", 1.0D, (Icon)(UI.icons()).s.tolerence, 
/* 438 */           D.g("NOBLE_TOLERANCE", "Tolerance"), 
/* 439 */           D.g("NOBLE_TOLERANCE_D", "Tolerance to new and different things."));
/*     */     } }
/*     */ 
/*     */   
/*     */   private static class BoostableCollection
/*     */     extends BoostableCat
/*     */   {
/*     */     BoostableCollection(String key, CharSequence name) {
/* 447 */       super(key + "_", name, "", 4, (SPRITE)(UI.icons()).s.house);
/*     */     }
/*     */     
/*     */     Boostable make(String key, double vv, Icon icon, CharSequence name, CharSequence desc) {
/* 451 */       Boostable b = BOOSTING.push(key, vv, name, desc, (SPRITE)icon, this);
/* 452 */       return b;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTABLES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
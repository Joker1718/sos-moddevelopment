/*     */ package init.type;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class CAUSE_LEAVES {
/*     */   private final ArrayListGrower<CAUSE_LEAVE> all;
/*     */   private final ArrayListGrower<CAUSE_LEAVE> deaths;
/*     */   private final CAUSE_LEAVE ARMY;
/*     */   private final CAUSE_LEAVE EMMIGRATED;
/*     */   private final CAUSE_LEAVE STARVED;
/*     */   private final CAUSE_LEAVE SACRIFICED;
/*     */   
/*     */   CAUSE_LEAVES() {
/*  13 */     D.gInit(this);
/*     */ 
/*     */     
/*  16 */     this.all = new ArrayListGrower();
/*  17 */     this.deaths = new ArrayListGrower();
/*     */     
/*  19 */     this.ARMY = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  20 */         "ARMY", 
/*  21 */         D.g("ArmyDuty", "Army Duty"), 
/*  22 */         D.g("ArmyDudys", "Army-Duties"), 
/*  23 */         D.g("ArmyDutyD", "Subjects that have left your city to join distant armies."), 
/*  24 */         false, 
/*  25 */         true, 
/*  26 */         false);
/*     */ 
/*     */     
/*  29 */     this.EMMIGRATED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  30 */         "EMMIGRATED", 
/*  31 */         D.g("Emigrated"), 
/*  32 */         D.g("Emigration"), 
/*  33 */         D.g("EmmigratedD", "Subjects that have left your city."), 
/*  34 */         false, 
/*  35 */         true, 
/*  36 */         false);
/*     */ 
/*     */     
/*  39 */     this.STARVED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  40 */         "STARVED", 
/*  41 */         D.g("Starved"), 
/*  42 */         D.g("Starvation"), 
/*  43 */         D.g("StarvedD", "Subjects that have starved to death from lack of food."), 
/*  44 */         true, 
/*  45 */         false, 
/*  46 */         true);
/*     */ 
/*     */     
/*  49 */     this.SACRIFICED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  50 */         "SACRIFICED", 
/*  51 */         D.g("Sacrificed"), 
/*  52 */         D.g("Sacrifices"), 
/*  53 */         D.g("SacrificedD", "Subjects that have been sacrificed to the gods."), 
/*  54 */         true, 
/*  55 */         true, 
/*  56 */         true);
/*     */ 
/*     */     
/*  59 */     this.SLAYED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  60 */         "SLAYED", 
/*  61 */         D.g("slayed", "Slain by enemies"), 
/*  62 */         D.g("slayeds", "Slain by enemies"), 
/*  63 */         D.g("SlainD", "Subjects that have fallen in battle."), 
/*  64 */         true, 
/*  65 */         true, 
/*  66 */         true);
/*     */ 
/*     */     
/*  69 */     this.ANIMAL = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  70 */         "ANIMAL", 
/*  71 */         D.g("Mauiled", "Mauled by a beast"), 
/*  72 */         D.g("Maulds", "Mauled by Beasts"), 
/*  73 */         D.g("AnimalsD", "Subjects that have been slain by wild beasts."), 
/*  74 */         true, 
/*  75 */         false, 
/*  76 */         true);
/*     */ 
/*     */     
/*  79 */     this.AGE = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  80 */         "AGE", 
/*  81 */         D.g("age", "Natural Causes"), 
/*  82 */         D.g("ages", "Natural Causes"), 
/*  83 */         D.g("AgeD", "Subjects that have died naturally from old age."), 
/*  84 */         true, 
/*  85 */         true, 
/*  86 */         true);
/*     */ 
/*     */     
/*  89 */     this.ACCIDENT = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/*  90 */         "ACCIDENT", 
/*  91 */         D.g("accident", "Misadventure"), 
/*  92 */         D.g("accidents", "Misadventure"), 
/*  93 */         D.g("AccidentD", "Subjects that have died from accidents."), 
/*  94 */         true, 
/*  95 */         false, 
/*  96 */         true);
/*     */ 
/*     */     
/*  99 */     this.HEAT = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 100 */         "HEAT", 
/* 101 */         D.g("heat", "Heat stroke"), 
/* 102 */         D.g("heats", "Heat strokes"), 
/* 103 */         D.g("HeatD", "Subjects that have died from heat exposure. Build bodies of water or wells to prevent this."), 
/* 104 */         true, 
/* 105 */         false, 
/* 106 */         true);
/*     */ 
/*     */     
/* 109 */     this.COLD = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 110 */         "COLD", 
/* 111 */         D.g("cold", "Hypothermia"), 
/* 112 */         D.g("colds", "Hypothermia"), 
/* 113 */         D.g("ColdD", "Subjects that have frozen to death. Build hearths to avoid."), 
/* 114 */         true, 
/* 115 */         false, 
/* 116 */         true);
/*     */ 
/*     */     
/* 119 */     this.MURDER = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 120 */         "MURDER", 
/* 121 */         D.g("Murdered"), 
/* 122 */         D.g("Murders"), 
/* 123 */         D.g("MurderD", "Subjects that have been murdered."), 
/* 124 */         true, 
/* 125 */         false, 
/* 126 */         true);
/*     */ 
/*     */     
/* 129 */     this.DISEASE = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 130 */         "DISEASE", 
/* 131 */         D.g("disease", "Succumbed to Disease"), 
/* 132 */         D.g("diseases", "Succumbed to Diseases"), 
/* 133 */         D.g("DiseaseD", "Subjects that have died from diseases."), 
/* 134 */         true, 
/* 135 */         false, 
/* 136 */         true);
/*     */ 
/*     */     
/* 139 */     this.EXECUTED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 140 */         "EXECUTED", 
/* 141 */         D.g("Executed"), 
/* 142 */         D.g("Executions"), 
/* 143 */         D.g("ExecutedD", "Subjects that have been executed."), 
/* 144 */         true, 
/* 145 */         false, 
/* 146 */         true);
/*     */ 
/*     */     
/* 149 */     this.PUNISHED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 150 */         "PUNISHED", 
/* 151 */         D.g("Punished"), 
/* 152 */         D.g("Punishment"), 
/* 153 */         D.g("PunishmentD", "Subjects that have been turned into prisoners."), 
/* 154 */         true, 
/* 155 */         true, 
/* 156 */         true);
/*     */ 
/*     */     
/* 159 */     this.DROWNED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 160 */         "DROWNED", 
/* 161 */         D.g("Drowned"), 
/* 162 */         D.g("Drownings"), 
/* 163 */         D.g("DrownedD", "Subjects that have drowned."), 
/* 164 */         true, 
/* 165 */         true, 
/* 166 */         false);
/*     */ 
/*     */     
/* 169 */     this.DESERTED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 170 */         "DESERTED", 
/* 171 */         D.g("Deserted"), 
/* 172 */         D.g("Desertion"), 
/* 173 */         D.g("DesertedD", "Soldiers that have deserted."), 
/* 174 */         true, 
/* 175 */         true, 
/* 176 */         false);
/*     */ 
/*     */     
/* 179 */     this.EXILED = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 180 */         "EXILED", 
/* 181 */         D.g("Exiled"), 
/* 182 */         D.g("Exile"), 
/* 183 */         D.g("ExileD", "People condemned to exile."), 
/* 184 */         true, 
/* 185 */         true, 
/* 186 */         false);
/*     */ 
/*     */     
/* 189 */     this.BRAWL = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 190 */         "BRAWL", 
/* 191 */         D.g("brawl", "Killed in a Brawl"), 
/* 192 */         D.g("brawls", "Killed in brawls"), 
/* 193 */         D.g("BrawlD", "Subjects that have died from a brawl that has gone too far. Try separating the homes of species that hate each other."), 
/* 194 */         true, 
/* 195 */         false, 
/* 196 */         true);
/*     */ 
/*     */     
/* 199 */     this.OTHER = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 200 */         "OTHER", 
/* 201 */         D.g("Other"), 
/* 202 */         D.g("Others"), 
/* 203 */         D.g("OtherD", "Other causes."), 
/* 204 */         true, 
/* 205 */         true, 
/* 206 */         false);
/*     */ 
/*     */     
/* 209 */     this.INSANITY = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 210 */         "INSANE", 
/* 211 */         D.g("Insane"), 
/* 212 */         D.g("Insanity"), 
/* 213 */         D.g("InsanityD", "Subjects that have become insane."), 
/* 214 */         false, 
/* 215 */         true, 
/* 216 */         false);
/*     */     
/* 218 */     this.SOLD = new CAUSE_LEAVE((LISTE<CAUSE_LEAVE>)this.all, (LISTE<CAUSE_LEAVE>)this.deaths, 
/* 219 */         "SOLD", 
/* 220 */         D.g("Sold"), 
/* 221 */         D.g("Sold"), 
/* 222 */         D.g("SoldD", "Subjects that have been sold."), 
/* 223 */         false, 
/* 224 */         true, 
/* 225 */         false);
/*     */ 
/*     */     
/* 228 */     this.map = new RMAPS("DEATH_CAUSE", (LIST)this.all);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 233 */     self = this;
/* 234 */     Json json = new Json((PATHS.CONFIG()).init.gets("LEAVE_CAUSE"));
/* 235 */     for (CAUSE_LEAVE l : this.all)
/* 236 */       l.defAgony = json.d(l.key, 0.0D, 10.0D); 
/*     */   }
/*     */   private final CAUSE_LEAVE SLAYED; private final CAUSE_LEAVE ANIMAL; private final CAUSE_LEAVE AGE; private final CAUSE_LEAVE ACCIDENT; private final CAUSE_LEAVE HEAT; private final CAUSE_LEAVE COLD; private final CAUSE_LEAVE MURDER; private final CAUSE_LEAVE DISEASE; private final CAUSE_LEAVE EXECUTED; private final CAUSE_LEAVE PUNISHED; private final CAUSE_LEAVE DROWNED; private final CAUSE_LEAVE DESERTED; private final CAUSE_LEAVE EXILED; private final CAUSE_LEAVE BRAWL; private final CAUSE_LEAVE OTHER; private final CAUSE_LEAVE INSANITY; private final CAUSE_LEAVE SOLD; public final RMAPS<CAUSE_LEAVE> map;
/*     */   private static CAUSE_LEAVES self;
/*     */   
/*     */   public static LIST<CAUSE_LEAVE> ALL() {
/* 242 */     return (LIST<CAUSE_LEAVE>)self.all;
/*     */   }
/*     */   
/*     */   public static final RMAPS<CAUSE_LEAVE> MAP() {
/* 246 */     return self.map;
/*     */   }
/*     */   
/*     */   public static LIST<CAUSE_LEAVE> DEATHS() {
/* 250 */     return (LIST<CAUSE_LEAVE>)self.deaths;
/*     */   }
/*     */ 
/*     */   
/*     */   public static CAUSE_LEAVE ARMY() {
/* 255 */     return self.ARMY;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE EMMIGRATED() {
/* 259 */     return self.EMMIGRATED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE STARVED() {
/* 263 */     return self.STARVED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE SACRIFICED() {
/* 267 */     return self.SACRIFICED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE SLAYED() {
/* 271 */     return self.SLAYED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE ANIMAL() {
/* 275 */     return self.ANIMAL;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE AGE() {
/* 279 */     return self.AGE;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE getAccident() {
/* 283 */     return self.ACCIDENT;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE HEAT() {
/* 287 */     return self.HEAT;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE COLD() {
/* 291 */     return self.COLD;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE MURDER() {
/* 295 */     return self.MURDER;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE DISEASE() {
/* 299 */     return self.DISEASE;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE EXECUTED() {
/* 303 */     return self.EXECUTED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE PUNISHED() {
/* 307 */     return self.PUNISHED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE DROWNED() {
/* 311 */     return self.DROWNED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE DESERTED() {
/* 315 */     return self.DESERTED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE EXILED() {
/* 319 */     return self.EXILED;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE BRAWL() {
/* 323 */     return self.BRAWL;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE OTHER() {
/* 327 */     return self.OTHER;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE INSAVITY() {
/* 331 */     return self.INSANITY;
/*     */   }
/*     */   
/*     */   public static CAUSE_LEAVE SOLD() {
/* 335 */     return self.SOLD;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\type\CAUSE_LEAVES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package init.resources;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.keymap.MAPPED;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public class ResSupply implements MAPPED {
/*     */   public final CharSequence name;
/*     */   public final RESOURCE resource;
/*     */   public final double morale;
/*     */   public final double health;
/*     */   public final double consumptionPerPersonday;
/*     */   public final double consumptionPerItemPerDay;
/*     */   public final int wantedPerPerson;
/*  25 */   private final int[] uses = Alloc.ii(RACES.all().size());
/*     */   
/*     */   private final int index;
/*     */   final String key;
/*  29 */   private static CharSequence ¤¤SupplyRace = "Affected Races";
/*  30 */   private static CharSequence ¤¤desc = "Supplies are needed by by certain conscripts and city troops to function. They are shipped automatically from your supply depots in your capitol. An army stores up to 6 days of worth of excess supply, in case supply lines become compromised.";
/*  31 */   private static CharSequence ¤¤stored = "Each soldier of this supply wants at least {0} items stored per soldier.";
/*  32 */   private static CharSequence ¤¤consume = "Each soldier of this supply consumes {0} items per year.";
/*  33 */   private static CharSequence ¤¤consumeItem = "Each items stored degrades by -{0} per year.";
/*  34 */   private static CharSequence ¤¤morale = "This item increases morale by at most {0}% for the soldiers affected.";
/*  35 */   private static CharSequence ¤¤health = "This is an essential supply for the affected soldiers, and low stocks will lead to {0}% poorer health and desertion.";
/*     */ 
/*     */   
/*     */   static {
/*  39 */     D.ts(ResSupply.class);
/*     */   }
/*     */   
/*     */   ResSupply(String key, Json json, LISTE<ResSupply> all) {
/*  43 */     this.index = all.add(this);
/*  44 */     this.resource = (RESOURCE)RESOURCES.map().read(json);
/*  45 */     this.key = key;
/*  46 */     this.morale = json.d("MORALE_ADD", 0.0D, 1.0D);
/*  47 */     this.health = json.d("HEALTH_EFFECT", 0.0D, 1.0D);
/*  48 */     this.consumptionPerPersonday = json.d("CONSUMPTION_PER_USER_DAY", 0.0D, 1000.0D);
/*  49 */     this.consumptionPerItemPerDay = json.d("CONSUMPTION_PER_ITEM_DAY", 0.0D, 1000.0D);
/*  50 */     this.wantedPerPerson = json.i("AMOUNT_PER_PERSON");
/*  51 */     for (Race r : RACES.map().readMany("RACES", json)) {
/*  52 */       setRace(r, 1);
/*     */     }
/*  54 */     this.name = String.valueOf(Dic.¤¤Supplies) + ": " + String.valueOf(Dic.¤¤Supplies);
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/*  59 */     return this.index;
/*     */   }
/*     */   
/*     */   public int consumedMulPerDay(Race race) {
/*  63 */     return this.uses[race.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public String key() {
/*  68 */     return this.key;
/*     */   }
/*     */   
/*     */   void setRace(Race race, int amount) {
/*  72 */     this.uses[race.index] = amount;
/*     */   }
/*     */   
/*     */   public int amount(Race race, int men) {
/*  76 */     return (int)(this.consumptionPerPersonday * consumedMulPerDay(race) * men * 6.0D + (this.wantedPerPerson * consumedMulPerDay(race) * men));
/*     */   }
/*     */   
/*     */   public void hover(GBox b) {
/*  80 */     b.title(this.name);
/*  81 */     b.text(¤¤desc);
/*     */     
/*  83 */     b.NL();
/*  84 */     b.textLL(¤¤SupplyRace);
/*  85 */     b.NL();
/*  86 */     for (Race r : RACES.all()) {
/*  87 */       if (consumedMulPerDay(r) > 0) {
/*  88 */         b.add((SPRITE)(r.appearance()).icon);
/*     */       }
/*     */     } 
/*  91 */     b.NL();
/*     */     
/*  93 */     if (this.wantedPerPerson > 0) {
/*  94 */       GText t = b.text();
/*  95 */       t.add(¤¤stored);
/*  96 */       t.insert(0, this.wantedPerPerson);
/*  97 */       b.add((SPRITE)t);
/*  98 */       b.NL();
/*     */     } 
/*     */     
/* 101 */     if (this.consumptionPerPersonday > 0.0D) {
/* 102 */       GText t = b.text();
/* 103 */       t.add(¤¤consume);
/* 104 */       t.insertD(0, this.consumptionPerPersonday * TIME.years().bitConversion((TIMECYCLE)TIME.days()), 5);
/* 105 */       b.add((SPRITE)t);
/* 106 */       b.NL();
/*     */     } 
/*     */ 
/*     */     
/* 110 */     if (this.consumptionPerItemPerDay > 0.0D) {
/* 111 */       GText t = b.text();
/* 112 */       t.add(¤¤consumeItem);
/* 113 */       t.insertD(0, this.consumptionPerItemPerDay * TIME.years().bitConversion((TIMECYCLE)TIME.days()), 5);
/* 114 */       b.add((SPRITE)t);
/* 115 */       b.NL();
/*     */     } 
/*     */     
/* 118 */     if (this.morale > 0.0D) {
/* 119 */       GText t = b.text();
/* 120 */       t.add(¤¤morale);
/* 121 */       t.insert(0, (int)(this.morale * 100.0D));
/* 122 */       b.add((SPRITE)t);
/* 123 */       b.NL();
/*     */     } 
/*     */     
/* 126 */     if (this.health > 0.0D) {
/* 127 */       GText t = b.text();
/* 128 */       t.add(¤¤health);
/* 129 */       t.insert(0, (int)(this.health * 100.0D));
/* 130 */       t.warnify();
/* 131 */       b.add((SPRITE)t);
/* 132 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\resources\ResSupply.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
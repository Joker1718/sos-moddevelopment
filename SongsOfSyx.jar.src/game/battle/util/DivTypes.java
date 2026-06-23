/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.Faction;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ public class DivTypes
/*     */ {
/*  22 */   private final ArrayListGrower<DivType> types = new ArrayListGrower();
/*  23 */   private final double[] occMaxs = new double[RACES.all().size()];
/*  24 */   private DivType tmp = new DivType();
/*     */   
/*     */   DivTypes() {
/*  27 */     PATH p = PATHS.INIT().getFolder("battle").getFolder("divType"); byte b; int i;
/*     */     String[] arrayOfString;
/*  29 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  30 */       Json j = new Json(p.gets(f));
/*  31 */       Json[] mm = j.jsons("TYPES"); byte b1; int k;
/*     */       Json[] arrayOfJson1;
/*  33 */       for (k = (arrayOfJson1 = mm).length, b1 = 0; b1 < k; ) { Json jj = arrayOfJson1[b1];
/*  34 */         double occ = jj.d("OCCURENCE");
/*  35 */         LIST<StatsBattle.StatTraining> tr = (STATS.BATTLE()).TRAINING_MAP.readMany(jj);
/*  36 */         Json eqs = jj.json("EQUIPMENT");
/*  37 */         LIST<String> ekeys = eqs.keys();
/*  38 */         occ /= ekeys.size();
/*  39 */         for (String str : ekeys) {
/*     */           
/*  41 */           LIST<EquipBattle> eqps = (STATS.EQUIP()).militaryColl.readMany(str, eqs);
/*  42 */           this.types.add(new DivType(occ, tr, eqps));
/*     */         } 
/*     */ 
/*     */         
/*     */         b1++; }
/*     */ 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */     
/*  53 */     GAME.addOnInit(new AA());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivType rnd(Race race, Faction f, double ran) {
/*  59 */     ran -= (int)ran;
/*  60 */     ran *= this.occMaxs[race.index];
/*     */ 
/*     */ 
/*     */     
/*  64 */     for (int i = 0; i < this.types.size(); i++) {
/*  65 */       if (((DivType)this.types.get(i)).valid(race)) {
/*     */         
/*  67 */         ran -= ((DivType)this.types.get(i)).roccurence[race.index()];
/*  68 */         if (ran <= 0.0D)
/*  69 */           return (DivType)this.types.get(i); 
/*     */       } 
/*     */     } 
/*  72 */     DivType r = (DivType)this.types.rnd();
/*     */     
/*  74 */     for (EquipBattle b : STATS.EQUIP().BATTLE_ALL()) {
/*  75 */       if (b.allowed(race)) {
/*  76 */         this.tmp.equip[b.indexMilitary()] = r.equip(b); continue;
/*     */       } 
/*  78 */       this.tmp.equip[b.indexMilitary()] = 0.0D;
/*     */     } 
/*     */     
/*  81 */     for (int j = 0; j < this.tmp.training.length; j++) {
/*  82 */       this.tmp.training[j] = r.training[j];
/*     */     }
/*  84 */     return this.tmp;
/*     */   }
/*     */   
/*     */   void debug() {
/*  88 */     for (DivType t : this.types) {
/*  89 */       LOG.ln(Double.valueOf(t.occurence));
/*  90 */       for (StatsBattle.StatTraining tr : (STATS.BATTLE()).TRAINING_ALL)
/*  91 */         LOG.ln(String.valueOf((tr.stat.stats.info()).name) + " " + String.valueOf((tr.stat.stats.info()).name)); 
/*  92 */       for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*  93 */         LOG.ln(String.valueOf(e.resource.name) + " " + String.valueOf(e.resource.name));
/*     */       }
/*  95 */       for (Race r : RACES.all()) {
/*  96 */         LOG.ln(r.key + " " + r.key);
/*     */       }
/*  98 */       LOG.ln();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<DivType> ALL() {
/* 104 */     return (LIST<DivType>)this.types;
/*     */   }
/*     */   
/*     */   private class AA
/*     */     implements ACTION {
/*     */     private Race race;
/*     */     private DivType type;
/*     */     
/* 112 */     private DIV_SPEC stats = new DIV_SPEC()
/*     */       {
/*     */         public double training(StatsBattle.StatTraining tr)
/*     */         {
/* 116 */           return DivTypes.AA.this.type.training(tr);
/*     */         }
/*     */ 
/*     */         
/*     */         public double equip(EquipBattle e) {
/* 121 */           return DivTypes.AA.this.type.equip(e);
/*     */         }
/*     */ 
/*     */         
/*     */         public Race race() {
/* 126 */           return DivTypes.AA.this.race;
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 131 */           return 10;
/*     */         }
/*     */ 
/*     */         
/*     */         public Faction faction() {
/* 136 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double experience() {
/* 141 */           return 0.2D;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 146 */           return Dic.empty;
/*     */         }
/*     */ 
/*     */         
/*     */         public int bannerI() {
/* 151 */           return 0;
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*     */     public void exe() {
/* 158 */       for (DivType t : DivTypes.this.types) {
/* 159 */         this.type = t;
/* 160 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/*     */ 
/*     */           
/* 163 */           this.race = (Race)RACES.all().get(ri);
/* 164 */           if (!t.valid(this.race)) {
/* 165 */             this.type.roccurence[ri] = 0.0D;
/*     */           } else {
/* 167 */             this.type.roccurence[ri] = this.type.occurence * (GAME.battle()).power.get(this.stats);
/*     */           } 
/* 169 */           DivTypes.this.occMaxs[ri] = DivTypes.this.occMaxs[ri] + this.type.roccurence[ri];
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivTypes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
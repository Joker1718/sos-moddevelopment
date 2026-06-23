/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.army.WDIV;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DivGeneration
/*     */ {
/*     */   public Induvidual[] indus;
/*     */   public final short race;
/*     */   public final CharSequence name;
/*     */   public final int bannerI;
/*     */   public final boolean isRange;
/*  38 */   public final DIV_SETTING.DIV_SETTINGImp target = new DIV_SETTING.DIV_SETTINGImp();
/*     */   
/*     */   public DivGeneration(DIV_SPEC div, DIV_SETTING target) {
/*  41 */     this.indus = new Induvidual[div.men()];
/*  42 */     this.race = (short)div.race().index();
/*  43 */     this.name = String.valueOf(div.name());
/*  44 */     this.bannerI = div.bannerI();
/*  45 */     if (div.men() > (Config.battle()).MEN_PER_DIVISION) {
/*  46 */       throw new RuntimeException();
/*     */     }
/*  48 */     for (int i = 0; i < this.indus.length; i++) {
/*  49 */       Induvidual ii = new Induvidual(HTYPES.SUBJECT(), div.race());
/*  50 */       init(div, ii, true);
/*  51 */       this.indus[i] = ii;
/*     */     } 
/*     */     
/*  54 */     this.isRange = range(div);
/*     */ 
/*     */     
/*  57 */     this.target.copySettings(target);
/*  58 */     this.target.men = div.men();
/*     */   }
/*     */ 
/*     */   
/*     */   private DivGeneration(DIV_SPEC div, CharSequence name, int bannerI, LIST<Induvidual> all, DIV_SETTING target) {
/*  63 */     this.indus = new Induvidual[div.men()];
/*  64 */     this.race = (short)div.race().index();
/*  65 */     this.name = String.valueOf(name);
/*  66 */     this.bannerI = bannerI;
/*     */     
/*  68 */     for (int i = 0; i < this.indus.length; i++) {
/*  69 */       this.indus[i] = (Induvidual)all.get(i);
/*  70 */       init(div, this.indus[i], false);
/*     */     } 
/*  72 */     this.isRange = range(div);
/*  73 */     this.target.copySettings(target);
/*  74 */     this.target.men = div.men();
/*     */   }
/*     */   
/*     */   public DivGeneration(WDIV div, LIST<Induvidual> all, DIV_SETTING target) {
/*  78 */     this((DIV_SPEC)div, div.name(), div.bannerI(), all, tar(div, target));
/*     */   }
/*     */   
/*     */   private static DIV_SETTING tar(WDIV div, DIV_SETTING target) {
/*  82 */     DIV_SETTING.DIV_SETTINGImp tar = new DIV_SETTING.DIV_SETTINGImp();
/*  83 */     tar.copySettings((DIV_SETTING)div);
/*  84 */     tar.men = div.men();
/*  85 */     return tar;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DivGeneration rnd() {
/*  91 */     DIV_SPEC stats = new DIV_SPEC() {
/*  92 */         final Race race = (Race)RACES.all().rnd();
/*  93 */         final DivType dd = (GAME.battle()).types.rnd(this.race, (Faction)FACTIONS.player(), RND.rFloat());
/*     */         
/*  95 */         final int men = CLAMP.i(RND.rInt((Config.battle()).MEN_PER_DIVISION) + 25, 1, (Config.battle()).MEN_PER_DIVISION);
/*  96 */         final String name = (String)this.race.info.armyNames.rnd();
/*  97 */         final int bannerI = RND.rInt((GAME.ARMIES()).banners.size());
/*     */         
/*  99 */         double tr = RND.rFloat();
/* 100 */         double eq = RND.rFloat();
/* 101 */         double ex = RND.rFloat();
/*     */ 
/*     */         
/*     */         public double training(StatsBattle.StatTraining t) {
/* 105 */           return this.dd.training(t) * this.tr;
/*     */         }
/*     */ 
/*     */         
/*     */         public double equip(EquipBattle e) {
/* 110 */           return this.dd.equip(e) * this.eq;
/*     */         }
/*     */ 
/*     */         
/*     */         public Race race() {
/* 115 */           return this.race;
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 120 */           return this.men;
/*     */         }
/*     */ 
/*     */         
/*     */         public Faction faction() {
/* 125 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public double experience() {
/* 130 */           return this.ex;
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 135 */           return this.name;
/*     */         }
/*     */ 
/*     */         
/*     */         public int bannerI() {
/* 140 */           return this.bannerI;
/*     */         }
/*     */       };
/*     */     
/* 144 */     return new DivGeneration(stats, stats);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMen(int men) {
/* 150 */     Induvidual[] in = new Induvidual[Math.min(men, this.indus.length)];
/* 151 */     for (int i = 0; i < in.length; i++)
/* 152 */       in[i] = this.indus[i]; 
/* 153 */     this.indus = in;
/*     */   }
/*     */   
/*     */   public DivGeneration(FileGetter file) throws IOException {
/* 157 */     this.race = (short)file.i();
/* 158 */     this.name = file.chars();
/* 159 */     this.bannerI = file.i();
/* 160 */     this.isRange = file.bool();
/*     */     
/* 162 */     this.indus = new Induvidual[file.i()];
/* 163 */     for (int i = 0; i < this.indus.length; i++) {
/* 164 */       this.indus[i] = new Induvidual(file);
/*     */     }
/* 166 */     if (!VERSION.versionIsBefore(70, 25)) {
/* 167 */       this.target.load(file);
/*     */     } else {
/* 169 */       this.target.men = this.indus.length;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static boolean range(DIV_SPEC div) {
/* 174 */     for (EquipRange r : STATS.EQUIP().RANGED()) {
/* 175 */       if (div.equip((EquipBattle)r) > 0.0D)
/* 176 */         return true; 
/* 177 */     }  return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 182 */     file.i(this.race);
/* 183 */     file.chars(this.name);
/* 184 */     file.i(this.bannerI);
/* 185 */     file.bool(this.isRange);
/*     */     
/* 187 */     file.i(this.indus.length); byte b; int i; Induvidual[] arrayOfInduvidual;
/* 188 */     for (i = (arrayOfInduvidual = this.indus).length, b = 0; b < i; ) { Induvidual a = arrayOfInduvidual[b];
/* 189 */       a.save(file); b++; }
/* 190 */      this.target.save(file);
/*     */   }
/*     */   
/*     */   public Race race() {
/* 194 */     return (Race)RACES.all().get(this.race);
/*     */   }
/*     */   
/*     */   private void init(DIV_SPEC div, Induvidual ii, boolean training) {
/* 198 */     if (training) {
/* 199 */       set(ii, (STATS.BATTLE()).COMBAT_EXPERIENCE, div.experience());
/* 200 */       for (StatsBattle.StatTraining tt : (STATS.BATTLE()).TRAINING_ALL) {
/* 201 */         set(ii, (STAT)tt.stat, div.training(tt));
/*     */       }
/*     */     } 
/*     */     
/* 205 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 206 */       set(ii, e.stat(), div.equip(e));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void set(Induvidual ii, STAT s, double d) {
/* 214 */     double ex = d * s.indu().max(ii);
/* 215 */     if (ex != (int)ex && ex - (int)ex > RND.rFloat())
/* 216 */       ex++; 
/* 217 */     ex = CLAMP.d(ex, 0.0D, s.indu().max(ii));
/*     */     
/* 219 */     s.indu().set(ii, (int)ex);
/*     */   }
/*     */ 
/*     */   
/*     */   public DIV_SPEC.DIV_SPECImp makeSpec() {
/* 224 */     DIV_SPEC.DIV_SPECImp spec = new DIV_SPEC.DIV_SPECImp();
/*     */     
/* 226 */     spec.raceSet(race());
/* 227 */     spec.menSet(this.indus.length);
/*     */     
/* 229 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*     */       
/* 231 */       double am = 0.0D; byte b; int i; Induvidual[] arrayOfInduvidual;
/* 232 */       for (i = (arrayOfInduvidual = this.indus).length, b = 0; b < i; ) { Induvidual a = arrayOfInduvidual[b];
/* 233 */         am += e.get(a); b++; }
/*     */       
/* 235 */       am /= (this.indus.length * e.max());
/* 236 */       spec.equipSet(e, am);
/*     */     } 
/*     */     
/* 239 */     double exp = 0.0D;
/* 240 */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/* 241 */       double am = 0.0D; byte b; int i; Induvidual[] arrayOfInduvidual;
/* 242 */       for (i = (arrayOfInduvidual = this.indus).length, b = 0; b < i; ) { Induvidual a = arrayOfInduvidual[b];
/* 243 */         am += t.stat.indu().getD(a);
/* 244 */         exp += (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().getD(a); b++; }
/*     */       
/* 246 */       am /= this.indus.length;
/* 247 */       spec.trainingSet(t, am);
/*     */     } 
/*     */     
/* 250 */     spec.experienceSet(exp / this.indus.length);
/* 251 */     return spec;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\DivGeneration.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
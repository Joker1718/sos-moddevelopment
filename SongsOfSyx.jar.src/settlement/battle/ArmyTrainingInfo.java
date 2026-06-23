/*     */ package settlement.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.VERSION;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.div.DivInfo;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ public final class ArmyTrainingInfo
/*     */ {
/*     */   private boolean dirty = false;
/*  30 */   private final int[] targets = Alloc.ii(RACES.all().size());
/*     */   
/*  32 */   final RaceDiv[] perRace = new RaceDiv[RACES.all().size()];
/*  33 */   private int raceU = 0;
/*     */ 
/*     */   
/*     */   private boolean sendOutWithoutTraining = true;
/*     */ 
/*     */   
/*     */   final SAVABLE saver;
/*     */ 
/*     */   
/*     */   public ROOM_M_TRAINER<?> updateAndGetEmployment(Humanoid a, ROOM_M_TRAINER<?> current) {
/*  43 */     Div div = updateExisting(a);
/*     */     
/*  45 */     if (div == null) {
/*  46 */       return null;
/*     */     }
/*  48 */     DivInfo in = div.info;
/*     */ 
/*     */     
/*  51 */     if (current != null && current.employable() >= 0 && current.training().shouldTrain(a.indu(), in.training(current.training()), true)) {
/*  52 */       return current;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  60 */     current = employmentTarget(a, div, (current != null));
/*  61 */     if (current != null) {
/*  62 */       return current;
/*     */     }
/*  64 */     (STATS.BATTLE()).RECRUIT.set(a, null);
/*  65 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ROOM_M_TRAINER<?> employmentTarget(Humanoid a, Div div, boolean training) {
/*  74 */     double bestV = 0.0D;
/*  75 */     ROOM_M_TRAINER<?> best = null;
/*  76 */     DivInfo in = div.info;
/*  77 */     for (StatsBattle.StatTraining tra : (STATS.BATTLE()).TRAINING_ALL) {
/*     */       
/*  79 */       double emp = tra.room.employable();
/*     */ 
/*     */ 
/*     */       
/*  83 */       if (emp >= 1.0D) {
/*  84 */         if (tra.shouldTrain(a.indu(), in.training(tra), training))
/*  85 */           return tra.room; 
/*  86 */         if (emp > bestV) {
/*  87 */           bestV = emp;
/*  88 */           best = tra.room;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  94 */     if (!(STATS.BATTLE()).basicTraining.isMax(a.indu()))
/*  95 */       return best; 
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private Div updateExisting(Humanoid a) {
/* 101 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/*     */     
/* 103 */     if (div != null) {
/* 104 */       if (!canStayInDiv(a, div, false)) {
/* 105 */         (STATS.BATTLE()).DIV.set(a, null);
/* 106 */         return setNew(a);
/*     */       } 
/*     */       
/* 109 */       if (this.perRace[(a.race()).index].tryBetter(a.indu(), div)) {
/* 110 */         Div match = this.perRace[(a.race()).index].getMatch(a.indu());
/* 111 */         if (match != null && match != div) {
/* 112 */           (STATS.BATTLE()).DIV.set(a, match);
/* 113 */           div = match;
/*     */         } 
/*     */       } 
/*     */       
/* 117 */       return div;
/*     */     } 
/*     */     
/* 120 */     div = (Div)(STATS.BATTLE()).RECRUIT.get(a);
/* 121 */     if (div != null) {
/*     */       
/* 123 */       if (!canStayInDiv(a, div, true)) {
/* 124 */         (STATS.BATTLE()).RECRUIT.set(a, null);
/* 125 */         return setNew(a);
/*     */       } 
/*     */       
/* 128 */       if ((STATS.BATTLE()).basicTraining.isMax(a.indu())) {
/* 129 */         (STATS.BATTLE()).RECRUIT.set(a, null);
/* 130 */         (STATS.BATTLE()).DIV.set(a, div);
/* 131 */         return div;
/*     */       } 
/* 133 */       return div;
/*     */     } 
/*     */     
/* 136 */     return setNew(a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldJoinArmy(Humanoid a) {
/* 142 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 143 */     if (div == null)
/* 144 */       return false; 
/* 145 */     if (AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a)) == null) {
/* 146 */       return false;
/*     */     }
/* 148 */     if (!(SETT.ENTRY()).points.hasAny())
/* 149 */       return false; 
/* 150 */     if (this.sendOutWithoutTraining) {
/* 151 */       return true;
/*     */     }
/* 153 */     DivInfo in = div.info;
/* 154 */     boolean training = (a.indu().hType() == HTYPES.RECRUIT());
/* 155 */     for (StatsBattle.StatTraining tra : (STATS.BATTLE()).TRAINING_ALL) {
/*     */       
/* 157 */       if (tra.shouldTrain(a.indu(), in.training(tra), training)) {
/* 158 */         return false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 163 */     return (employmentTarget(a, div, false) == null);
/*     */   }
/*     */   
/*     */   public boolean sendOutWithoutTraining() {
/* 167 */     return this.sendOutWithoutTraining;
/*     */   }
/*     */   
/*     */   public void sendOutWithoutTraining(boolean s) {
/* 171 */     this.sendOutWithoutTraining = s;
/*     */   }
/*     */   
/*     */   public void clearTargets() {
/* 175 */     this.dirty = true;
/*     */   }
/*     */   
/*     */   private void cache() {
/* 179 */     if (this.dirty) {
/* 180 */       Arrays.fill(this.targets, 0);
/* 181 */       for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/* 182 */         Div d = (Div)GAME.ARMIES().player().divisions().get(di);
/* 183 */         if (d.info.race() != null) {
/* 184 */           this.targets[d.info.race().index()] = this.targets[d.info.race().index()] + d.info.men();
/*     */         }
/*     */       } 
/* 187 */       this.dirty = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public int targetMen(Race race) {
/* 192 */     cache();
/* 193 */     if (race == null) {
/* 194 */       int am = 0; byte b; int i, arrayOfInt[];
/* 195 */       for (i = (arrayOfInt = this.targets).length, b = 0; b < i; ) { int j = arrayOfInt[b];
/* 196 */         am += j; b++; }
/* 197 */        return am;
/*     */     } 
/*     */     
/* 200 */     return this.targets[race.index];
/*     */   }
/*     */   
/*     */   public int targetMen() {
/* 204 */     return targetMen(null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean thereAreDivsToSignUpTo(Race race) {
/* 210 */     int am = AD.cityDivs().total(race) + (STATS.BATTLE()).DIV.stat().data(null).get(race, 0) + (STATS.BATTLE()).RECRUIT.stat().data(null).get(race, 0);
/* 211 */     return (am < targetMen(race));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Div setNew(Humanoid a) {
/* 217 */     if (!thereAreDivsToSignUpTo(a.race())) {
/* 218 */       return null;
/*     */     }
/*     */     
/* 221 */     if (this.perRace[(a.race()).index].has(a.indu())) {
/* 222 */       Div match = this.perRace[(a.race()).index].getMatch(a.indu());
/* 223 */       if (match != null) {
/* 224 */         if ((STATS.BATTLE()).basicTraining.isMax(a.indu())) {
/* 225 */           (STATS.BATTLE()).DIV.set(a, match);
/* 226 */           return match;
/*     */         } 
/* 228 */         (STATS.BATTLE()).RECRUIT.set(a, match);
/* 229 */         return match;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 234 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean canStayInDiv(Humanoid a, Div div, boolean recruit) {
/* 240 */     DivInfo in = div.info;
/*     */ 
/*     */     
/* 243 */     if (a.race() != in.race())
/* 244 */       return false; 
/* 245 */     if (recruit && AD.cityDivs().get(div).men() + (STATS.BATTLE()).DIV.stat().div().get(div) + (STATS.BATTLE()).RECRUIT.inDiv(div) > in.men())
/* 246 */       return false; 
/* 247 */     if (!recruit && !(STATS.BATTLE()).basicTraining.isMax(a.indu()))
/* 248 */       return false; 
/* 249 */     if (AD.cityDivs().get(div).men() + (STATS.BATTLE()).DIV.stat().div().get(div) > in.men())
/* 250 */       return false; 
/* 251 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   ArmyTrainingInfo() {
/* 256 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 260 */           file.bool(ArmyTrainingInfo.this.sendOutWithoutTraining);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 265 */           if (!VERSION.versionIsBefore(70, 5))
/* 266 */             ArmyTrainingInfo.this.sendOutWithoutTraining = file.bool(); 
/* 267 */           ArmyTrainingInfo.this.dirty = true;
/*     */           
/* 269 */           for (int i = 0; i <= (Config.battle()).DIVISIONS_PER_ARMY; i++) {
/* 270 */             ArmyTrainingInfo.this.update();
/*     */           }
/*     */         }
/*     */         
/*     */         public void clear() {
/* 275 */           ArmyTrainingInfo.this.dirty = true;
/*     */           int i;
/* 277 */           for (i = 0; i < 4; i++) {
/* 278 */             (GAME.ARMIES().division((short)i)).info.menSet(50);
/*     */           }
/*     */           
/* 281 */           for (i = 0; i <= ArmyTrainingInfo.this.perRace.length; i++)
/* 282 */             ArmyTrainingInfo.this.update(); 
/*     */         }
/*     */       };
/*     */     for (int i = 0; i < this.perRace.length; i++)
/*     */       this.perRace[i] = new RaceDiv((Race)RACES.all().get(i)); 
/*     */   }
/*     */   public void update() {
/* 289 */     if (this.raceU == (Config.battle()).DIVISIONS_PER_ARMY) {
/* 290 */       byte b; int i; RaceDiv[] arrayOfRaceDiv; for (i = (arrayOfRaceDiv = this.perRace).length, b = 0; b < i; ) { RaceDiv raceDiv = arrayOfRaceDiv[b];
/* 291 */         raceDiv.update(); b++; }
/* 292 */        this.raceU = 0;
/*     */       
/*     */       return;
/*     */     } 
/* 296 */     Div d = (Div)GAME.ARMIES().player().divisions().get(this.raceU);
/* 297 */     DivInfo in = d.info;
/* 298 */     this.perRace[(in.race()).index].update(d, in);
/*     */     
/* 300 */     this.raceU++;
/*     */   }
/*     */   
/*     */   private static class RaceDiv
/*     */   {
/*     */     private final Race race;
/* 306 */     private ArrayList<Div> divs = new ArrayList(16);
/*     */     
/*     */     RaceDiv(Race race) {
/* 309 */       this.race = race;
/*     */     }
/*     */ 
/*     */     
/*     */     public Div getMatch(Induvidual in) {
/* 314 */       return getNext();
/*     */     }
/*     */ 
/*     */     
/*     */     private Div getNext() {
/* 319 */       while (!this.divs.isEmpty()) {
/* 320 */         Div div = (Div)this.divs.get(this.divs.size() - 1);
/* 321 */         if (div.info.race() == this.race) {
/* 322 */           int am = div.info.men() - AD.cityDivs().get(div).men() + (STATS.BATTLE()).DIV.stat().div().get(div) + (STATS.BATTLE()).RECRUIT.inDiv(div);
/* 323 */           if (am > 0) {
/* 324 */             return div;
/*     */           }
/*     */         } 
/* 327 */         this.divs.removeLast();
/*     */       } 
/* 329 */       return null;
/*     */     }
/*     */     
/*     */     public boolean has(Induvidual i) {
/* 333 */       return (getNext() != null);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryBetter(Induvidual i, Div div) {
/* 338 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void update() {
/* 343 */       this.divs.clearSloppy();
/*     */     }
/*     */ 
/*     */     
/*     */     void update(Div div, DivInfo in) {
/* 348 */       if (!this.divs.hasRoom())
/*     */         return; 
/* 350 */       int am = in.men() - AD.cityDivs().get(div).men() + (STATS.BATTLE()).DIV.stat().div().get(div) + (STATS.BATTLE()).RECRUIT.inDiv(div);
/* 351 */       if (am > 0)
/* 352 */         this.divs.add(div); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\ArmyTrainingInfo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
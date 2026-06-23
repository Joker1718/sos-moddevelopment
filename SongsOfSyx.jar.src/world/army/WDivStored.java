/*     */ package world.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.Equip;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.entity.army.WArmy;
/*     */ import world.region.RD;
/*     */ 
/*     */ class WDivStored
/*     */   extends ADDiv
/*     */ {
/*     */   static final int type = 1;
/*  40 */   private static COLOR col = (COLOR)COLOR.BLUE100.makeSaturated(0.5D).shade(0.75D);
/*     */   
/*  42 */   private int[] stats = Alloc.ii(STATS.all().size());
/*  43 */   final ArrayList<Induvidual> all = new ArrayList((Config.battle()).MEN_PER_DIVISION);
/*  44 */   private double returnSecond = 0.0D;
/*     */   
/*     */   WDivStored(int index) {
/*  47 */     super(index);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  53 */     super.save(file);
/*  54 */     file.i(this.all.size());
/*  55 */     for (Induvidual s : this.all)
/*  56 */       s.save(file); 
/*  57 */     file.d(this.returnSecond);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  62 */     super.load(file);
/*     */     
/*  64 */     this.all.clear();
/*  65 */     int am = file.i();
/*  66 */     for (int i = 0; i < am; i++) {
/*  67 */       Induvidual h = new Induvidual(file);
/*  68 */       this.all.add(h);
/*  69 */       for (int si = 0; si < STATS.all().size(); si++) {
/*  70 */         this.stats[si] = this.stats[si] + ((STAT)STATS.all().get(si)).indu().get(h);
/*     */       }
/*     */     } 
/*  73 */     report(1);
/*  74 */     this.returnSecond = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/*  79 */     return e.target(div()) * AD.supplies().get(e).amountValue(army()) / e.equipMax;
/*     */   }
/*     */   
/*     */   private Div div() {
/*  83 */     return (Div)GAME.ARMIES().player().divisions().get(this.index);
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/*  88 */     return this.all.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/*  93 */     return (div()).info.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public int menTarget() {
/*  98 */     return ((Div)GAME.ARMIES().player().divisions().get(this.index)).info.men();
/*     */   }
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 103 */     return stat((STAT)tr.stat);
/*     */   }
/*     */   
/*     */   public double stat(STAT stat) {
/* 107 */     if (this.all.size() == 0)
/* 108 */       return 0.0D; 
/* 109 */     return this.stats[stat.index()] / (stat.indu().max(null) * this.all.size());
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 114 */     return stat((STATS.BATTLE()).COMBAT_EXPERIENCE);
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 119 */     return (CharSequence)(div()).info.name();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void armyChange(WArmy old, WArmy newW) {
/* 124 */     this.returnSecond = TIME.currentSecond();
/* 125 */     if (old != null && old.region() != null) {
/* 126 */       this.returnSecond += TIME.secondsPerDay() * (1.0D + RD.DIST().distance().get(old.region()) / 20.0D);
/*     */     } else {
/*     */       
/* 129 */       super.armyChange(old, newW);
/*     */     } 
/*     */   }
/*     */   public double returnSecond() {
/* 133 */     return this.returnSecond;
/*     */   }
/*     */   
/*     */   public int index() {
/* 137 */     return this.index;
/*     */   }
/*     */   
/*     */   void add(Humanoid indu) {
/* 141 */     add(indu.indu());
/*     */   }
/*     */   
/*     */   void add(Induvidual n) {
/* 145 */     report(-1);
/* 146 */     if (this.all.size() == 0) {
/* 147 */       Arrays.fill(this.stats, 0);
/*     */     }
/* 149 */     for (int si = 0; si < STATS.all().size(); si++) {
/* 150 */       this.stats[si] = this.stats[si] + ((STAT)STATS.all().get(si)).indu().get(n);
/*     */     }
/*     */     
/* 153 */     Induvidual in = new Induvidual(n.hType(), n.race());
/*     */     
/* 155 */     in.copyFrom(n);
/* 156 */     STATS.NEEDS().clear(in);
/* 157 */     this.all.add(in);
/*     */     
/* 159 */     STATS.REL().setSoldier(in, WDivStoredAll.getSoldierId(this.all.size() - 1, div().indexArmy()));
/*     */     
/* 161 */     report(1);
/*     */   }
/*     */   
/*     */   private void remove(Induvidual n) {
/* 165 */     report(-1);
/* 166 */     for (int si = 0; si < STATS.all().size(); si++) {
/* 167 */       this.stats[si] = this.stats[si] - ((STAT)STATS.all().get(si)).indu().get(n);
/*     */     }
/* 169 */     STATS.REL().setDeath(n, CAUSE_LEAVES.SLAYED());
/* 170 */     this.all.remove(n);
/* 171 */     for (int i = 0; i < this.all.size(); i++)
/* 172 */       STATS.REL().setSoldier((Induvidual)this.all.get(i), WDivStoredAll.getSoldierId(i, div().indexArmy())); 
/* 173 */     report(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int daysUntilMenArrives() {
/* 178 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void report(int d) {
/* 183 */     (AD.cityDivs()).amount += d * this.all.size();
/* 184 */     (AD.cityDivs()).ramounts[(race()).index] = (AD.cityDivs()).ramounts[(race()).index] + d * this.all.size();
/* 185 */     super.report(d);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resolve(Induvidual[] hs) {
/* 197 */     report(-1);
/* 198 */     for (int i = 0; i < this.all.size(); i++) {
/* 199 */       STATS.REL().setDeath((Induvidual)this.all.get(i), CAUSE_LEAVES.SLAYED());
/*     */     }
/*     */     
/* 202 */     Arrays.fill(this.stats, 0);
/* 203 */     this.all.clear();
/*     */     
/* 205 */     report(1); byte b; int j; Induvidual[] arrayOfInduvidual;
/* 206 */     for (j = (arrayOfInduvidual = hs).length, b = 0; b < j; ) { Induvidual induvidual = arrayOfInduvidual[b];
/* 207 */       add(induvidual);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void resolve(int surviviors, double experiencePerMan) {
/* 213 */     double dExperience = experiencePerMan - experience();
/* 214 */     dExperience *= surviviors;
/* 215 */     ArrayList<Induvidual> all = new ArrayList(surviviors);
/* 216 */     for (int i = 0; i < surviviors; i++) {
/* 217 */       Induvidual s = (Induvidual)this.all.get(i);
/* 218 */       STATS.REL().setDeath(s, CAUSE_LEAVES.SLAYED());
/* 219 */       int a = (int)dExperience;
/* 220 */       if (dExperience - a > RND.rFloat())
/* 221 */         a++; 
/* 222 */       (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().inc(s, a);
/* 223 */       all.add(s);
/*     */     } 
/* 225 */     report(-1);
/* 226 */     this.all.clear();
/* 227 */     report(1);
/* 228 */     for (Induvidual h : all) {
/* 229 */       add(h);
/*     */     }
/*     */   }
/*     */   
/*     */   public void menSet(int amount) {
/* 234 */     amount = CLAMP.i(amount, 0, men());
/* 235 */     while (amount < men()) {
/* 236 */       Induvidual t = (Induvidual)this.all.get(this.all.size() - 1);
/* 237 */       remove(t);
/*     */     } 
/* 239 */     while (amount > men()) {
/* 240 */       Induvidual i = new Induvidual(HTYPES.SUBJECT(), race());
/* 241 */       add(i);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Humanoid popSoldier(int tx, int ty, HTYPE type) {
/* 246 */     Induvidual t = (Induvidual)this.all.get(this.all.size() - 1);
/* 247 */     remove(t);
/* 248 */     for (int i = 0; i < STATS.EQUIP().allE().size(); i++) {
/* 249 */       Equip e = (Equip)STATS.EQUIP().allE().get(i);
/* 250 */       e.set(t, 0);
/*     */     } 
/*     */     
/* 253 */     (STATS.NEEDS()).INJURIES.COUNT.indu().set(t, 0);
/*     */     
/* 255 */     Humanoid h = SETT.HUMANOIDS().create(t.race(), tx, ty, type, CAUSE_ARRIVES.SOLDIER_RETURN());
/*     */     
/* 257 */     if (!h.isRemoved()) {
/* 258 */       STATS.Arrive(h);
/* 259 */       h.indu().copyFrom(t);
/*     */     } 
/* 261 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public int type() {
/* 266 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void age() {
/* 274 */     for (int k = 0; k < this.all.size(); k++) {
/* 275 */       Induvidual i = (Induvidual)this.all.get(k);
/* 276 */       (STATS.POP()).age.DAYS.inc(i, 1);
/* 277 */       if ((STATS.POP()).age.shouldDieOfOldAge(i)) {
/* 278 */         remove(i);
/* 279 */       } else if ((STATS.WORK()).RET.shoudRetire(i)) {
/* 280 */         remove(i);
/* 281 */         COORDINATE c = (SETT.ENTRY()).points.randomReachable();
/* 282 */         if (c != null) {
/* 283 */           Humanoid h = SETT.HUMANOIDS().create(i.race(), c.x(), c.y(), HTYPES.RETIREE(), CAUSE_ARRIVES.SOLDIER_RETURN());
/* 284 */           if (h != null) {
/* 285 */             h.indu().copyFrom(i);
/* 286 */             STATS.REL().setHumanoid(h);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needSupplies() {
/* 295 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 301 */     return (div()).info.bannerI();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bannerSet(int bi) {
/* 306 */     (div()).info.bannerISet(bi);
/*     */   }
/*     */ 
/*     */   
/*     */   public DivGeneration generate() {
/* 311 */     DivGeneration res = new DivGeneration(this, (LIST)this.all, target());
/* 312 */     return res;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public COLOR color() {
/* 318 */     return col;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DIV_SETTING target() {
/* 324 */     return (DIV_SETTING)(div()).info;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivStored.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
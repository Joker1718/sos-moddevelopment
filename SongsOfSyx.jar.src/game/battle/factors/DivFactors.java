/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.battle.Armies;
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.status.DivStatus;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BUtil;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoosterAbs;
/*     */ import game.save.Savable;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DivFactors
/*     */ {
/*  33 */   static final ArrayListGrower<DivFactor> all = new ArrayListGrower();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  44 */   private final ArrayListGrower<DataDiv> datas = new ArrayListGrower();
/*     */   
/*  46 */   final DataA supplies = new DataA();
/*     */ 
/*     */   
/*  49 */   final DataDiv casulties = new DataDiv();
/*  50 */   final DataDiv routing = new DataDiv();
/*  51 */   final DataDiv projectiles = new DataDiv();
/*  52 */   final DataDiv weariness = new DataDiv();
/*  53 */   final DataDiv kills = new DataDiv();
/*     */   
/*  55 */   private final DataDiv morale = new DataDiv();
/*  56 */   private final DataDiv valueFactors = new DataDiv();
/*  57 */   private final ArrayListGrower<BoosterAbs<BOOSTABLE_O>> boosters = new ArrayListGrower();
/*     */   
/*     */   private final double fMax;
/*  60 */   private final IUpdater updater = new IUpdater((Config.battle()).DIVISIONS_PER_BATTLE, 1.0D)
/*     */     {
/*     */       private double speed;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       private final ArrayListGrower<DivFactors.DataDiv> player;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       protected void update(int i, double ds) {
/*  73 */         Div div = GAME.ARMIES().division((short)i);
/*  74 */         if (div.men() == 0 || (GAME.ARMIES().enemy().men() == 0 && !div.army().player())) {
/*  75 */           for (DivFactors.DataDiv d : DivFactors.this.datas) {
/*  76 */             if (d != DivFactors.this.kills) {
/*  77 */               d.setD(div, 0.0D);
/*     */             }
/*     */           } 
/*     */         } else {
/*  81 */           if (GAME.ARMIES().enemy().men() == 0) {
/*     */             
/*  83 */             double w = DivFactors.this.weariness.getD(div);
/*  84 */             w -= ds * this.speed;
/*  85 */             w = CLAMP.d(w, 0.0D, 1.0E7D);
/*  86 */             DivFactors.this.weariness.setD(div, w);
/*  87 */             if (DivFactors.this.weariness.getD(div) == 0.0D) {
/*  88 */               DivFactors.this.kills.setD(div, 0.0D);
/*     */             }
/*     */ 
/*     */             
/*  92 */             for (DivFactors.DataDiv dataDiv : this.player) {
/*  93 */               double am = dataDiv.getD(div) - 10.0D * ds * TIME.secondsPerDayI();
/*  94 */               am = CLAMP.d(am, 0.0D, 10000.0D);
/*  95 */               dataDiv.setD(div, am);
/*     */             } 
/*     */           } else {
/*  98 */             DivStatus s = div.status();
/*  99 */             double w = DivFactors.this.weariness.getD(div);
/*     */             
/* 101 */             double cc = s.engagements() / div.men();
/* 102 */             if (cc > 0.0D) {
/* 103 */               w += ds * cc * this.speed;
/*     */             }
/* 105 */             w = CLAMP.d(w, 0.0D, 1.0E7D);
/* 106 */             DivFactors.this.weariness.setD(div, w);
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 111 */           double d = DivFactors.this.projectiles.getD(div);
/* 112 */           d -= div.men() * ds / 10.0D;
/* 113 */           d = CLAMP.d(d, 0.0D, (div.men() * 4));
/* 114 */           DivFactors.this.projectiles.setD(div, d);
/* 115 */           DivFactors.this.set(div, ds);
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DivFactors(Armies a) {
/* 131 */     GAME.saver().add(new Savable("BATTLE_DIV_FACTORS")
/*     */         {
/*     */           protected void save(FilePutter file)
/*     */           {
/* 135 */             for (DivFactors.DataDiv d : DivFactors.this.datas)
/* 136 */               d.save(file); 
/* 137 */             DivFactors.this.supplies.save(file);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void load(FileGetter file) throws IOException {
/* 142 */             for (DivFactors.DataDiv d : DivFactors.this.datas)
/* 143 */               d.load(file); 
/* 144 */             DivFactors.this.supplies.load(file);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void loadFail() {
/* 149 */             for (DivFactors.DataDiv d : DivFactors.this.datas) {
/* 150 */               d.clear();
/*     */             }
/* 152 */             DivFactors.this.supplies.clear();
/*     */           }
/*     */         });
/*     */     
/* 156 */     for (DivFactor f : all) {
/* 157 */       for (BoostSpec s : f.specs.all()) {
/* 158 */         this.boosters.add(s.booster);
/*     */       }
/*     */     } 
/* 161 */     this.fMax = BUtil.max((LIST)this.boosters, Div.class, 1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void set(Div div, double ds) {
/* 167 */     this.morale.setD(div, (BOOSTABLES.BATTLE()).MORALE.get((BOOSTABLE_O)div) - 1.0D);
/* 168 */     double m = BUtil.value((LIST)this.boosters, div) / this.fMax;
/* 169 */     this.valueFactors.setD(div, m);
/*     */   }
/*     */   
/*     */   public void init(Army a, double supplies) {
/* 173 */     for (DataDiv d : this.datas) {
/* 174 */       d.clear(a);
/*     */     }
/* 176 */     this.supplies.setD(a, supplies - 0.5D);
/* 177 */     for (Div div : a.divisions()) {
/* 178 */       this.morale.setD(div, (BOOSTABLES.BATTLE()).MORALE.get((BOOSTABLE_O)div) - 1.0D);
/* 179 */       double m = BUtil.value((LIST)this.boosters, div) / this.fMax;
/* 180 */       this.valueFactors.setD(div, m);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void init(Div div) {
/* 185 */     for (DataDiv d : this.datas)
/* 186 */       d.setD(div, 0.0D); 
/* 187 */     this.morale.setD(div, (BOOSTABLES.BATTLE()).MORALE.get((BOOSTABLE_O)div) - 1.0D);
/* 188 */     double m = BUtil.value((LIST)this.boosters, div) / this.fMax;
/* 189 */     this.valueFactors.setD(div, m);
/*     */   }
/*     */   
/*     */   public void update(double ds) {
/* 193 */     this.updater.update(ds);
/*     */   }
/*     */   
/*     */   public double morale(Div div) {
/* 197 */     return this.morale.getD(div) + 1.0D;
/*     */   }
/*     */   
/*     */   public double morale(Army as) {
/* 201 */     int m = as.men();
/* 202 */     if (m == 0)
/* 203 */       return 1.0D; 
/* 204 */     return this.morale.army.getD(as) / m + 1.0D;
/*     */   }
/*     */   
/*     */   public double valueCurrent(Div div) {
/* 208 */     return this.valueFactors.getD(div);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldRun(Div div) {
/* 213 */     return (this.projectiles.getD(div) > (div.menNrOf() >> 1));
/*     */   }
/*     */   
/*     */   public LIST<DivFactor> all() {
/* 217 */     return (LIST<DivFactor>)all;
/*     */   }
/*     */   
/*     */   class DataDiv
/*     */     implements DOUBLE_O.DOUBLE_OE<Div>, SAVABLE {
/* 222 */     private final double[] data = new double[(Config.battle()).DIVISIONS_PER_BATTLE];
/* 223 */     private final long[] dataa = new long[2];
/*     */ 
/*     */     
/*     */     public final DOUBLE_O<Army> army;
/*     */ 
/*     */ 
/*     */     
/*     */     public double getD(Div t) {
/* 231 */       return this.data[t.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 236 */       file.ds(this.data);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 241 */       file.ds(this.data);
/* 242 */       Arrays.fill(this.dataa, 0L);
/* 243 */       for (int ai = 0; ai < 2; ai++) {
/* 244 */         for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 245 */           this.dataa[ai] = this.dataa[ai] + (int)(this.data[ai * (Config.battle()).DIVISIONS_PER_ARMY + di] * 100.0D);
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 252 */       Arrays.fill(this.data, 0.0D);
/* 253 */       Arrays.fill(this.dataa, 0L);
/*     */     }
/*     */     
/*     */     void clear(Army a) {
/* 257 */       for (int di = 0; di < (Config.battle()).DIVISIONS_PER_ARMY; di++) {
/* 258 */         this.data[a.index() * (Config.battle()).DIVISIONS_PER_ARMY + di] = 0.0D;
/*     */       }
/* 260 */       this.dataa[a.index()] = 0L;
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<Div> setD(Div t, double d) {
/* 265 */       this.dataa[t.army().index()] = this.dataa[t.army().index()] - (int)(this.data[t.index()] * 100.0D);
/* 266 */       this.data[t.index()] = d;
/* 267 */       this.dataa[t.army().index()] = this.dataa[t.army().index()] + (int)(this.data[t.index()] * 100.0D);
/* 268 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     DataDiv() {
/* 273 */       this.army = new DOUBLE_O<Army>()
/*     */         {
/*     */           public double getD(Army t)
/*     */           {
/* 277 */             return DivFactors.DataDiv.this.dataa[t.index()] / 100.0D;
/*     */           }
/*     */         };
/*     */       DivFactors.this.datas.add(this);
/*     */     } }
/*     */   
/*     */   class DataA implements DOUBLE_O.DOUBLE_OE<Army>, SAVABLE {
/*     */     DataA() {
/* 285 */       this.dataa = new double[2];
/*     */     }
/*     */     private final double[] dataa;
/*     */     public double getD(Army t) {
/* 289 */       return this.dataa[t.index()] / 100.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 294 */       file.ds(this.dataa);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 300 */       file.ds(this.dataa);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 306 */       Arrays.fill(this.dataa, 0.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public DOUBLE_O.DOUBLE_OE<Army> setD(Army t, double d) {
/* 311 */       this.dataa[t.index()] = d;
/* 312 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double casulties(Army enemy) {
/* 318 */     return this.casulties.army.getD(enemy);
/*     */   }
/*     */   
/*     */   public double projectiles(Div div) {
/* 322 */     return this.projectiles.getD(div);
/*     */   }
/*     */   
/*     */   public void reportCasulty(Div division) {
/* 326 */     this.casulties.incD(division, 1.0D);
/*     */   }
/*     */   
/*     */   public void reportRout(Div division) {
/* 330 */     this.routing.incD(division, 1.0D);
/*     */   }
/*     */   
/*     */   public double casulties(Div div) {
/* 334 */     return this.casulties.getD(div);
/*     */   }
/*     */   
/*     */   public void reportProjectile(Div division) {
/* 338 */     this.projectiles.incD(division, 1.0D);
/*     */   }
/*     */   
/*     */   public void reportKill(Humanoid a) {
/* 342 */     Div d = a.division();
/* 343 */     if (d != null) {
/* 344 */       this.kills.incD(d, 1.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public int kills(Div div) {
/* 349 */     return (int)this.kills.getD(div);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\DivFactors.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
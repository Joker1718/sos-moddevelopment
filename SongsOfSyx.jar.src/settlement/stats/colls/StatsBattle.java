/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Armies;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.standing.StatStanding;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.STATFakeRace;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.stat.StatObject;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMAP;
/*     */ import util.text.D;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsBattle
/*     */   extends StatCollection
/*     */ {
/*     */   public final LIST<StatTraining> TRAINING_ALL;
/*     */   public final RMAP<StatTraining> TRAINING_MAP;
/*     */   public final INT_O.INT_OE<Induvidual> basicTraining;
/*     */   public final STAT COMBAT_EXPERIENCE;
/*     */   public final STAT ENEMY_KILLS;
/*     */   public final StatObject<Div> DIV;
/*     */   public final StatProspect RECRUIT;
/*     */   public final STAT ROUTING;
/*     */   public final STAT PROWESS;
/*     */   public final STAT CHIVALRY;
/*     */   public final STAT CRUELTY;
/*     */   public final STAT BESIGED;
/*     */   public final STAT WAR;
/*     */   private final INT_O.INT_OE<Induvidual> position;
/*  73 */   private static CharSequence ¤¤name = "Battle";
/*  74 */   private static CharSequence ¤¤desc = "Battle related stats";
/*     */   
/*     */   static {
/*  77 */     D.ts(StatsBattle.class);
/*     */   }
/*     */   
/*     */   public StatsBattle(StatsInit init) {
/*  81 */     super(init, "BATTLE", ¤¤name, ¤¤desc);
/*  82 */     D.t(this);
/*  83 */     init.count.getClass(); this.position = (INT_O.INT_OE<Induvidual>)new DataO.DataShort(init.count, "BATTLE_POSITION");
/*  84 */     init.count.getClass(); this.basicTraining = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "BATTLE_BTRAINING", new INFO(D.g("Basic", "Basic Training"), D.g("BasicD", "Basic training is acquired in any type of training room and is required to be able to join a division.")), 15);
/*  85 */     this.RECRUIT = new StatProspect(init);
/*  86 */     this.DIV = new StatDivision(init);
/*     */     
/*  88 */     init.copier.add(this.basicTraining);
/*     */     
/*  90 */     init.count.getClass(); this.COMBAT_EXPERIENCE = (STAT)new STATData("COMBAT_EXPERIENCE", init, (DataO.DataAbs)new DataO.DataNibble(init.count, "BATTLE_EXPERIENCE"));
/*  91 */     (this.COMBAT_EXPERIENCE.info()).icon = (SPRITE)(UI.icons()).s.plusBig;
/*  92 */     init.copier.add(this.COMBAT_EXPERIENCE.indu());
/*     */     
/*  94 */     LinkedList<StatTraining> li = new LinkedList();
/*  95 */     KeyMap<StatTraining> map = new KeyMap();
/*  96 */     for (ROOM_M_TRAINER<?> tt : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/*  97 */       StatTraining t = new StatTraining(init, tt);
/*  98 */       init.copier.add(t.count);
/*  99 */       init.copier.add(t.stat.indu());
/* 100 */       li.add(t);
/* 101 */       map.put(t.room.key, t);
/*     */     } 
/*     */     
/* 104 */     this.TRAINING_ALL = (LIST<StatTraining>)new ArrayList((Iterable)li);
/* 105 */     this.TRAINING_MAP = new RMAP("TRAINING", this.TRAINING_ALL);
/*     */     
/* 107 */     init.count.getClass(); this.ENEMY_KILLS = (STAT)new STATData("ENEMY_KILLS", init, (DataO.DataAbs)new DataO.DataShort(init.count, "BATTLE_KILLS"));
/* 108 */     (this.ENEMY_KILLS.info()).icon = (UI.icons()).l.death.small;
/* 109 */     init.copier.add(this.ENEMY_KILLS.indu());
/* 110 */     this.ENEMY_KILLS.info().setInt();
/* 111 */     init.count.getClass(); this.ROUTING = (STAT)new STATData("ROUTING", init, (DataO.DataAbs)new DataO<Induvidual>.DataBit(init.count, "BATTLE_ROUTING")
/*     */         {
/*     */           public void set(Induvidual t, int s)
/*     */           {
/* 115 */             super.set(t, s);
/*     */           }
/*     */         });
/*     */     
/* 119 */     this.WAR = (STAT)new STATFakeRace("WAR_TIME", init) {
/* 120 */         private double tt = (TIME.secondsPerDay() * 16 * 10);
/*     */         
/*     */         protected double getDD(Race r) {
/* 123 */           return DIP.secondsOFPlayerWar() / this.tt;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 128 */     this.PROWESS = (STAT)new STATFakeRace("PROWESS", init)
/*     */       {
/*     */         protected double getDD(Race r)
/*     */         {
/* 132 */           return AD.stats().repF().getD(FACTIONS.player());
/*     */         }
/*     */       };
/* 135 */     this.PROWESS.standing = new StatStanding(this.PROWESS, 0.5D);
/*     */     
/* 137 */     this.CHIVALRY = (STAT)new STATFakeRace("CHIVALRY", init)
/*     */       {
/*     */         protected double getDD(Race r)
/*     */         {
/* 141 */           return AD.stats().mercy().getD(FACTIONS.player());
/*     */         }
/*     */       };
/*     */     
/* 145 */     this.CRUELTY = (STAT)new STATFakeRace("CRUELTY", init)
/*     */       {
/*     */         
/*     */         protected double getDD(Race r)
/*     */         {
/* 150 */           return -AD.stats().mercy().getD(FACTIONS.player());
/*     */         }
/*     */       };
/*     */     
/* 154 */     this.BESIGED = (STAT)new STATFakeRace("BESIEGED", init) {
/* 155 */         final double bi = 0.125D * TIME.secondsPerDay();
/*     */         
/*     */         protected double getDD(Race r) {
/* 158 */           return SETT.ENTRY().besigeTime() * TIME.secondsPerDay() * this.bi;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private final class StatDivision
/*     */     extends StatObject<Div>
/*     */     implements StatsInit.StatDisposable
/*     */   {
/*     */     final STAT stat;
/*     */     
/*     */     private final INT_O.INT_OE<Induvidual> idiv;
/*     */     private final StatsInit init;
/*     */     
/*     */     public StatDivision(StatsInit init) {
/* 174 */       super(D.g("Division"), D.g("DivisionD", "The Army Division this subject belongs to."));
/* 175 */       this.init = init;
/* 176 */       init.count.getClass(); this.idiv = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "BATTLE_DIVI");
/* 177 */       INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 181 */             return (StatsBattle.StatDivision.this.idiv.get(t) != 0) ? 1 : 0;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 187 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 192 */             return 1;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int i) {}
/*     */         };
/* 202 */       this.stat = (STAT)new STATData("SOLDIERS", "BATTLE_SOLDIERS", init, b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 217 */       if (Armies.DIVISIONS >= 32767)
/* 218 */         throw new RuntimeException(); 
/* 219 */       init.disposable.add(this);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public final Div get(Induvidual i) {
/* 225 */       int di = this.idiv.get(i);
/* 226 */       if (di != 0)
/* 227 */         return GAME.ARMIES().division((short)(di - 1)); 
/* 228 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(Humanoid h, Div d) {
/* 233 */       Induvidual i = h.indu();
/* 234 */       if (!i.added())
/* 235 */         throw new RuntimeException(); 
/* 236 */       if (d != null)
/*     */       {
/* 238 */         StatsBattle.this.RECRUIT.set(h, (Div)null);
/*     */       }
/*     */       
/* 241 */       remove(h);
/*     */       
/* 243 */       if (d != null) {
/* 244 */         this.idiv.set(i, d.index() + 1);
/*     */       } else {
/* 246 */         this.idiv.set(i, 0);
/*     */       } 
/* 248 */       add(h);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void remove(Humanoid h) {
/* 254 */       Induvidual i = h.indu();
/*     */       
/* 256 */       for (int ai = 0; ai < this.init.addable.size(); ai++) {
/* 257 */         ((StatsInit.Addable)this.init.addable.get(ai)).removeH(i);
/*     */       }
/*     */       
/* 260 */       Div old = (Div)get(h);
/* 261 */       if (old != null) {
/* 262 */         old.reporter.returnPosition((short)StatsBattle.this.position.get(i));
/*     */       }
/*     */     }
/*     */     
/*     */     private void add(Humanoid a) {
/* 267 */       Induvidual i = a.indu();
/*     */       
/* 269 */       for (int ai = 0; ai < this.init.addable.size(); ai++) {
/* 270 */         ((StatsInit.Addable)this.init.addable.get(ai)).addH(i);
/*     */       }
/*     */       
/* 273 */       Div now = (Div)get(a);
/* 274 */       if (now != null) {
/* 275 */         StatsBattle.this.position.set(i, now.reporter.signUpAndGetPosition(a.body().cX(), a.body().cY(), i.race()));
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     public void dispose(Humanoid h) {
/* 281 */       set(h, (Div)null);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public STAT stat() {
/* 287 */       return this.stat;
/*     */     }
/*     */   }
/*     */   
/*     */   public final class StatProspect
/*     */     extends StatObject<Div>
/*     */     implements StatsInit.StatDisposable {
/*     */     private final STATData stat;
/*     */     private final INT_O.INT_OE<Induvidual> idiv;
/* 296 */     private final short[] divs = new short[(Config.battle()).DIVISIONS_PER_ARMY * 2];
/*     */ 
/*     */     
/*     */     public StatProspect(StatsInit init) {
/* 300 */       super(D.g("Recruit"), D.g("RecruitD", "The Army Division this subject will join when training is complete."));
/* 301 */       init.count.getClass(); this.idiv = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "BATTLE_RECI");
/* 302 */       INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 306 */             return (StatsBattle.StatProspect.this.idiv.get(t) != 0) ? 1 : 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 311 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 316 */             return 1;
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int i) {}
/*     */         };
/* 325 */       this.stat = new STATData("RECRUITS", "BATTLE_RECI", init, b)
/*     */         {
/*     */           public void removeH(Induvidual i)
/*     */           {
/* 329 */             if (StatsBattle.StatProspect.this.get(i) != null)
/* 330 */               StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] = (short)(StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] - 1); 
/* 331 */             super.removeH(i);
/*     */           }
/*     */ 
/*     */           
/*     */           public void addH(Induvidual i) {
/* 336 */             if (StatsBattle.StatProspect.this.get(i) != null)
/* 337 */               StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] = (short)(StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] + 1); 
/* 338 */             super.addH(i);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */       
/* 344 */       init.disposable.add(new StatsInit.StatDisposable()
/*     */           {
/*     */             public void dispose(Humanoid h)
/*     */             {
/* 348 */               StatsBattle.StatProspect.this.set(h, (Div)null);
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void set(Humanoid h, Div d) {
/* 357 */       Induvidual i = h.indu();
/* 358 */       if (!i.added())
/* 359 */         throw new RuntimeException(); 
/* 360 */       this.stat.removeH(h.indu());
/*     */ 
/*     */       
/* 363 */       if (d != null) {
/* 364 */         this.idiv.set(i, d.index() + 1);
/*     */       } else {
/* 366 */         this.idiv.set(i, 0);
/*     */       } 
/* 368 */       this.stat.addH(h.indu());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose(Humanoid h) {
/* 374 */       set(h, (Div)null);
/*     */     }
/*     */     
/*     */     public int inDiv(Div div) {
/* 378 */       return this.divs[div.index()];
/*     */     }
/*     */ 
/*     */     
/*     */     public Div get(Induvidual i) {
/* 383 */       if (this.idiv.get(i) != 0)
/* 384 */         return GAME.ARMIES().division((short)(this.idiv.get(i) - 1)); 
/* 385 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public STAT stat() {
/* 390 */       return (STAT)this.stat;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int position(Induvidual i) {
/* 396 */     return this.position.get(i);
/*     */   }
/*     */   
/*     */   public void makeAKill(Humanoid a) {
/* 400 */     this.ENEMY_KILLS.indu().inc(a.indu(), 1);
/* 401 */     this.COMBAT_EXPERIENCE.indu().inc(a.indu(), 1 + RND.rInt(4));
/* 402 */     (GAME.ARMIES()).factors.reportKill(a);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static class StatTraining
/*     */     implements MAPPED
/*     */   {
/*     */     private final INT_O.INT_OE<Induvidual> count;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final ROOM_M_TRAINER<?> room;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final int tIndex;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final int MAX = 15;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static final double MAXI = 0.06666666666666667D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final STATData stat;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final BValue bvalue;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     StatTraining(StatsInit init, final ROOM_M_TRAINER<?> room) {
/* 502 */       this.bvalue = (BValue)new StatBooster()
/*     */         {
/*     */ 
/*     */           
/*     */           public double vGet(HCLASS_RACE t)
/*     */           {
/* 508 */             return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.data(t.cl).getD(t.race));
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Div div) {
/* 513 */             return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.div().getD(div));
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(Induvidual indu) {
/* 518 */             return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.indu().getD(indu));
/*     */           }
/*     */         };
/*     */       this.stat = new STATData(room.key, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "BATTLE_TRAINING_" + room.key), new StatInfo(room.tInfo.name, room.tInfo.desc));
/*     */       this.count = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "BATTLE_TCOUNT_" + room.key);
/*     */       this.room = room;
/*     */       this.tIndex = room.INDEX_TRAINING;
/*     */       BOOSTING.connecter(new ACTION() {
/*     */             public void exe() {
/*     */               for (BoostSpec b : room.boosters.all()) {
/*     */                 BoosterValue boosterValue = new BoosterValue(StatsBattle.StatTraining.this.bvalue, b.booster.info, b.booster.to(), b.booster.isMul);
/*     */                 StatsBattle.StatTraining.this.stat.boosters.push((Booster)boosterValue, b.boostable);
/*     */               } 
/*     */             }
/*     */           });
/*     */       (this.stat.info()).icon = room.icon.resized(16);
/*     */     }
/*     */     
/*     */     public boolean shouldTrain(Induvidual a, double target, boolean training) {
/*     */       if (!(STATS.BATTLE()).basicTraining.isMax(a))
/*     */         return true; 
/*     */       double t = target;
/*     */       double i = this.stat.indu().getD(a);
/*     */       if (t > i)
/*     */         return true; 
/*     */       if (t < i)
/*     */         return false; 
/*     */       if (t > 0.0D && training && !this.count.isMax(a))
/*     */         return true; 
/*     */       return false;
/*     */     }
/*     */     
/*     */     public void inc(Induvidual a, double am) {
/*     */       int sign = (am < 0.0D) ? -1 : 1;
/*     */       am = Math.abs(am);
/*     */       am *= (15 * this.stat.indu().max(a));
/*     */       int iam = (int)am;
/*     */       if (RND.rFloat() < am - iam)
/*     */         iam++; 
/*     */       iam *= sign;
/*     */       int c = this.count.get(a) + iam;
/*     */       while (c >= this.count.max(a)) {
/*     */         if (this.stat.indu().isMax(a)) {
/*     */           c = this.count.max(a);
/*     */           break;
/*     */         } 
/*     */         this.stat.indu().inc(a, 1);
/*     */         c -= this.count.max(a);
/*     */       } 
/*     */       while (c <= 0) {
/*     */         this.stat.indu().inc(a, -1);
/*     */         c += this.count.max(a);
/*     */       } 
/*     */       this.count.set(a, c);
/*     */     }
/*     */     
/*     */     public int index() {
/*     */       return this.tIndex;
/*     */     }
/*     */     
/*     */     public String key() {
/*     */       return this.room.key;
/*     */     }
/*     */     
/*     */     public double bValue(double d) {
/*     */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */       return d;
/*     */     }
/*     */   }
/*     */   
/*     */   public static abstract class HDivStat {
/*     */     protected abstract void returnPosition(short param1Short);
/*     */     
/*     */     protected abstract short signUpAndGetPosition(int param1Int1, int param1Int2, Race param1Race);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
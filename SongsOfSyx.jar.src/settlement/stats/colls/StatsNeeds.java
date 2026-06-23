/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import init.type.NEEDS;
/*     */ import init.type.NEED_E;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatsNeeds
/*     */   extends StatCollection
/*     */ {
/*     */   public final LIST<StatNeedNormal> SNEEDS;
/*     */   public final LIST<STAT> OTHERS;
/*     */   public final STAT EXHASTION;
/*     */   public final StatDanger INJURIES;
/*     */   public final StatExposure EXPOSURE;
/*     */   public final INT_O.INT_OE<Induvidual> DIRTINESS;
/*  54 */   private static CharSequence ¤¤desc = "The current {0} need of a subject. As it increases, subjects will search out related services.";
/*  55 */   private static CharSequence ¤¤name = "Needs";
/*  56 */   private static CharSequence ¤¤descc = "Needs related stats"; private final StatsInit.StatUpdatableI updater;
/*     */   static {
/*  58 */     D.ts(StatsNeeds.class);
/*     */   }
/*     */   
/*     */   public StatsNeeds(StatsInit init) {
/*  62 */     super(init, "NEEDS", ¤¤name, ¤¤descc);
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
/* 152 */     this.updater = new StatsInit.StatUpdatableI()
/*     */       {
/* 154 */         private final double DY = 0.0625D;
/* 155 */         private double itime = -10.0D;
/* 156 */         private final double[] insaneRate = new double[RACES.all().size()];
/*     */ 
/*     */ 
/*     */         
/*     */         public void update16(Humanoid h, int updateI, boolean day, int ui) {
/* 161 */           Induvidual i = h.indu();
/*     */           
/* 163 */           if (StatsNeeds.this.INJURIES.update(h)) {
/*     */             return;
/*     */           }
/*     */           
/* 167 */           if (!(STATS.DISEASE().status(i)).active && i.hType() != HTYPES.TOURIST()) {
/*     */             
/* 169 */             for (StatsNeeds.StatNeedNormal n : StatsNeeds.this.SNEEDS) {
/*     */               
/* 171 */               if (RND.rFloat() < n.need.rate.get((BOOSTABLE_O)i)) {
/* 172 */                 n.inc(i, 1);
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 180 */             if ((ui & 0xFF) < (BOOSTABLES.PHYSICS()).SOILING.get((BOOSTABLE_O)i) * 256.0D)
/* 181 */               StatsNeeds.this.DIRTINESS.inc(i, 1); 
/* 182 */             if (((Terrain.TerrainTile)SETT.TERRAIN().get(h.physics.tileC())).roofIs()) {
/* 183 */               if ((SETT.ROOMS()).map.is(h.physics.tileC()) && (
/* 184 */                 (Room)(SETT.ROOMS()).map.get(h.physics.tileC())).blueprint().makesDudesDirty()) {
/* 185 */                 StatsNeeds.this.DIRTINESS.inc(i, 1);
/*     */               }
/* 187 */             } else if ((SETT.WEATHER()).rain.getD() > 0.0D && !(SETT.WEATHER()).snow.rainIsSnow()) {
/* 188 */               StatsNeeds.this.DIRTINESS.inc(i, -1);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 193 */           double insaneRate = InsaneRate(i.race());
/*     */           
/* 195 */           if (day && i.clas() == HCLASSES.CITIZEN() && i.hType() != HTYPES.DERANGED() && 
/* 196 */             2.0D * insaneRate / (1.0D + (BOOSTABLES.BEHAVIOUR()).SANITY.get((BOOSTABLE_O)i)) > RND.rFloat()) {
/* 197 */             h.HTypeSet(HTYPES.DERANGED(), CAUSE_LEAVES.INSAVITY(), null);
/*     */           }
/*     */ 
/*     */           
/* 201 */           StatsNeeds.this.EXPOSURE.update(h, insaneRate);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         private double InsaneRate(Race r) {
/* 208 */           if (TIME.currentSecond() - this.itime > 10.0D) {
/* 209 */             double v = StatsNeeds.insaneRate((STATS.POP()).POP.data().get(null));
/* 210 */             for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 211 */               Race race = (Race)RACES.all().get(ri);
/*     */ 
/*     */               
/* 214 */               int insane = STATS.POP().pop(race, HTYPES.DERANGED());
/* 215 */               if (insane > v * (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(race) * 5.0D) {
/* 216 */                 v = 0.0D;
/*     */               }
/* 218 */               this.insaneRate[r.index()] = v * 0.0625D;
/*     */             } 
/*     */             
/* 221 */             this.itime = TIME.currentSecond();
/*     */           } 
/* 223 */           return this.insaneRate[r.index()];
/*     */         }
/*     */       }; init.count.getClass(); this.INJURIES = new StatDanger("INJURIES", init, (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "NEED_DANGER")); this.EXPOSURE = new StatExposure(init); init.count.getClass(); this.EXHASTION = (STAT)new STATData("EXHAUSTION", init, (DataO.DataAbs)new DataO.DataByte(init.count, "NEED_EXHAUST", 32)); this.OTHERS = (LIST<STAT>)new ArrayList((Object[])new STAT[] { this.INJURIES.COUNT, this.EXHASTION, this.EXPOSURE.COUNT }); init.count.getClass(); this.DIRTINESS = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "NEED_DIRTY"); ArrayListGrower<StatNeedNormal> all = new ArrayListGrower(); for (NEED_E n : NEEDS.ALLE()) { if (n == (NEEDS.TYPES()).HUNGER) { DataO<Induvidual>.DataByte dataByte = new DataO<Induvidual>.DataByte(init.count, "NEED_" + n.key, 64) { public void set(Induvidual i, int s) { (STATS.FOOD()).STARVATION.indu().set(i, (get(i) >= 48) ? 1 : 0); super.set(i, s); } }
/*     */           ; all.add(new StatNeedNormal(init, n, (INT_O.INT_OE<Induvidual>)dataByte)); continue; }  DataO.DataNibble1 dataNibble1 = new DataO.DataNibble1(init.count, "NEED_" + n.key); all.add(new StatNeedNormal(init, n, (INT_O.INT_OE<Induvidual>)dataNibble1)); }  this.SNEEDS = (LIST<StatNeedNormal>)all; IDebugPanelSett.add("Cure insanity", new ACTION() { public void exe() { byte b; int i; ENTITY[] arrayOfENTITY; for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b]; if (e instanceof Humanoid) { Humanoid a = (Humanoid)e; if (a.indu().hType() == HTYPES.DERANGED())
/*     */                   a.HTypeSet(HTYPES.SUBJECT(), null, CAUSE_ARRIVES.CURED());  }
/*     */                b++; }
/*     */              } }
/*     */       ); IDebugPanelSett.add("insanity", (PLACABLE)new PlacableSimpleTile("insanity") { public CharSequence isPlacable(int tx, int ty) { return null; } public void place(int tx, int ty) { for (ENTITY e : SETT.ENTITIES().getAtTile(tx, ty)) { if (e instanceof Humanoid) { Humanoid h = (Humanoid)e; h.HTypeSet(HTYPES.DERANGED(), CAUSE_LEAVES.INSAVITY(), null); }
/*     */                }
/*     */              } }
/*     */       ); init.updatable.add(this.updater); init.onArrival.add(new StatsInit.StatInitable() { public void init(Induvidual i) { if (RND.oneIn(8))
/*     */               StatsNeeds.this.DIRTINESS.incD(i, RND.rExpo());  for (StatsNeeds.StatNeedNormal n : StatsNeeds.this.SNEEDS)
/*     */               n.inc(i, (int)(RND.rFloat() * 16.0F * 2.0F));  } });
/* 236 */   } public double grime(Induvidual i) { return (this.DIRTINESS.get(i) >> 1) / 7.0D; } public static final class StatDanger { public final STAT DANGER; private StatDanger(String key, StatsInit init, final INT_O.INT_OE<Induvidual> c) { INT_O.INT_OE<Induvidual> count = new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public void set(Induvidual t, int s) {
/* 239 */             c.set(t, s);
/* 240 */             StatsNeeds.StatDanger.this.DANGER.indu().set(t, StatsNeeds.StatDanger.this.critical(t) ? 1 : 0);
/*     */           }
/*     */ 
/*     */           
/*     */           public int get(Induvidual t) {
/* 245 */             return c.get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 250 */             return c.min(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 255 */             return c.max(t);
/*     */           }
/*     */         };
/*     */       
/* 259 */       this.COUNT = (STAT)new STATData(key, "NEED_" + key, init, count);
/* 260 */       this.DANGER = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "NEED_DANGER_" + key), this.COUNT.info());
/* 261 */       this.count = (INT_O<Induvidual>)count; }
/*     */     
/*     */     public final STAT COUNT; private final INT_O<Induvidual> count;
/*     */     public boolean inDanger(Induvidual i) {
/* 265 */       return (this.count.get(i) >= this.count.max(i) / 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean willDie(Induvidual i, double treatment) {
/* 270 */       if (inDanger(i)) {
/* 271 */         double chance = 1.0D - treatment;
/* 272 */         chance = CLAMP.d(chance, 0.0D, 1.0D);
/* 273 */         int ran = (int)(chance * 65535.0D);
/*     */ 
/*     */         
/* 276 */         return (ran >= STATS.RAN().get(i, 7, 16));
/*     */       } 
/* 278 */       return false;
/*     */     }
/*     */     
/*     */     public void setNonDanger(Induvidual i) {
/* 282 */       if (inDanger(i))
/* 283 */         this.COUNT.indu().set(i, this.count.max(i) / 2 - 2); 
/*     */     }
/*     */     
/*     */     public boolean critical(Induvidual i) {
/* 287 */       return (this.count.get(i) >= 3 * this.count.max(i) / 4);
/*     */     }
/*     */     
/*     */     boolean update(Humanoid a) {
/* 291 */       Induvidual i = a.indu();
/* 292 */       if (this.count.get(i) != 0) {
/* 293 */         if (this.count.isMax(i)) {
/* 294 */           Humanoid.HumanoidResource.dead = (a.lastLeaveCause() != null) ? a.lastLeaveCause() : CAUSE_LEAVES.getAccident();
/* 295 */           return true;
/* 296 */         }  if (inDanger(i)) {
/* 297 */           this.COUNT.indu().inc(i, 4);
/* 298 */         } else if (a.division() == null || !a.division().settings().mustering()) {
/* 299 */           this.COUNT.indu().inc(i, -((int)Math.ceil(1.0D + 15.0D * (BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)i))));
/*     */         } 
/*     */       } 
/* 302 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class StatExposure
/*     */   {
/*     */     public final STAT DANGER;
/*     */     
/*     */     public final STAT COUNT;
/*     */     private final INT_O.INT_OE<Induvidual> count;
/*     */     private final INT_O.INT_OE<Induvidual> type;
/* 314 */     private final int hidden = 8;
/* 315 */     private final int critical = 26;
/*     */ 
/*     */     
/*     */     private StatExposure(StatsInit init) {
/* 319 */       init.count.getClass(); this.count = (INT_O.INT_OE<Induvidual>)new DataO<Induvidual>.DataNibble1(init.count, "NEED_EXPOSURE")
/*     */         {
/*     */           public void set(Induvidual t, int v) {
/* 322 */             super.set(t, v);
/* 323 */             StatsNeeds.StatExposure.this.DANGER.indu().set(t, StatsNeeds.StatExposure.this.critical(t) ? 1 : 0);
/*     */           }
/*     */         };
/* 326 */       init.count.getClass(); this.type = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "NEED_EXPOSURE_TYPE");
/*     */       
/* 328 */       INT_O.INT_OE<Induvidual> statCount = new INT_O.INT_OE<Induvidual>() {
/* 329 */           final int max = StatsNeeds.StatExposure.this.count.max(null) - 8;
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int s) {
/* 333 */             s += 8;
/* 334 */             s = CLAMP.i(s, 0, StatsNeeds.StatExposure.this.count.max(t));
/* 335 */             StatsNeeds.StatExposure.this.count.set(t, s);
/*     */           }
/*     */ 
/*     */           
/*     */           public int get(Induvidual t) {
/* 340 */             return CLAMP.i(StatsNeeds.StatExposure.this.count.get(t) - 8, 0, max(t));
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 345 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 350 */             return this.max;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 355 */       this.COUNT = (STAT)new STATData("EXPOSURE", "NEED_EXPOSURE", init, statCount);
/* 356 */       init.count.getClass(); this.DANGER = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "NEED_DANGER_EXPOSURE"), this.COUNT.info());
/*     */     }
/*     */     
/*     */     public boolean critical(Induvidual i) {
/* 360 */       return (this.count.get(i) >= 26);
/*     */     }
/*     */     
/*     */     public void fix(Induvidual a) {
/* 364 */       this.count.set(a, 0);
/*     */     }
/*     */     
/*     */     public boolean isCold(Induvidual a) {
/* 368 */       return (this.type.get(a) == 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     void update(Humanoid a, double insaneRate) {
/* 374 */       Induvidual i = a.indu();
/*     */       
/* 376 */       if ((STATS.DISEASE().status(i)).active) {
/* 377 */         if (critical(i)) {
/* 378 */           this.count.set(i, 25);
/*     */         }
/*     */         
/*     */         return;
/*     */       } 
/* 383 */       double exposure = (SETT.WEATHER()).temp.getEntityTemp() * 4.0D;
/* 384 */       if (exposure == 0.0D) {
/* 385 */         if (this.count.get(i) > 25)
/* 386 */           this.count.set(i, 25); 
/*     */         return;
/*     */       } 
/* 389 */       int type = 1;
/* 390 */       Boostable b = (BOOSTABLES.PHYSICS()).RESISTANCE_HOT;
/* 391 */       CAUSE_LEAVE cause = CAUSE_LEAVES.HEAT();
/* 392 */       if (exposure < 0.0D) {
/* 393 */         b = (BOOSTABLES.PHYSICS()).RESISTANCE_COLD;
/* 394 */         cause = CAUSE_LEAVES.COLD();
/* 395 */         exposure = -exposure;
/* 396 */         type = 0;
/*     */       } 
/*     */       
/* 399 */       double protection = b.get((BOOSTABLE_O)i);
/* 400 */       if (((Terrain.TerrainTile)SETT.TERRAIN().get(a.tc())).roofIs()) {
/* 401 */         protection++;
/*     */       } else {
/* 403 */         protection = 0.5D + 0.5D * (SETT.GROUND()).MOISTURE_CURRENT.get(a.tc());
/*     */       } 
/*     */       
/* 406 */       exposure /= 1.0D + protection;
/* 407 */       exposure = CLAMP.d(exposure, 0.0D, 16.0D);
/* 408 */       int ex = (int)exposure;
/*     */       
/* 410 */       if (exposure - ex > RND.rFloat()) {
/* 411 */         ex++;
/*     */       }
/*     */       
/* 414 */       if (type != this.type.get(i)) {
/* 415 */         int cc = this.count.get(i);
/* 416 */         int c = Math.min(ex, cc);
/* 417 */         cc -= c;
/* 418 */         this.count.inc(i, -cc);
/* 419 */         ex -= c;
/*     */       } 
/*     */       
/* 422 */       if (ex > 0) {
/* 423 */         this.type.set(i, type);
/*     */       }
/* 425 */       this.count.inc(i, ex);
/* 426 */       if (i.clas() == HCLASSES.CITIZEN() && insaneRate > 0.0D && STATS.RAN().get(i, 22, 4) == 0 && critical(i)) {
/* 427 */         a.HTypeSet(HTYPES.DERANGED(), cause, null);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class StatNeedNormal
/*     */   {
/*     */     public final NEED_E need;
/*     */     private final STAT stat;
/*     */     private static final int CHUNK = 16;
/*     */     
/*     */     StatNeedNormal(StatsInit init, NEED_E ni, INT_O.INT_OE<Induvidual> ii) {
/* 440 */       this.need = ni;
/* 441 */       this.stat = (STAT)new STATData(ni.key, "NEED_" + ni.key, init, ii, new StatInfo(ni.nameNeed, (CharSequence)(new Str(StatsNeeds.¤¤desc)).insert(0, ni.nameNeed)));
/*     */     }
/*     */     
/*     */     public void fix(Induvidual h) {
/* 445 */       inc(h, -16);
/*     */     }
/*     */     
/*     */     public void fixMax(Induvidual h) {
/* 449 */       this.stat.indu().set(h, this.stat.indu().get(h) & 0xFFFFFFEF);
/*     */     }
/*     */     
/*     */     private void inc(Induvidual h, int i) {
/* 453 */       this.stat.indu().inc(h, i);
/*     */     }
/*     */     
/*     */     public STAT stat() {
/* 457 */       return this.stat;
/*     */     }
/*     */     
/*     */     public int breakpoint() {
/* 461 */       return 16;
/*     */     }
/*     */     
/*     */     public int getPrio(Humanoid h) {
/* 465 */       return this.stat.indu().get(h.indu()) / 16;
/*     */     }
/*     */     
/*     */     public int getPrio(Induvidual i) {
/* 469 */       return this.stat.indu().get(i) / 16;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear(Induvidual indu) {
/* 476 */     for (StatNeedNormal n : this.SNEEDS)
/* 477 */       n.stat.indu().set(indu, 0); 
/* 478 */     for (STAT s : this.OTHERS)
/* 479 */       s.indu().set(indu, 0); 
/* 480 */     this.DIRTINESS.set(indu, 0);
/*     */   }
/*     */   
/*     */   private static double insaneRate(int pop) {
/* 484 */     if (pop < 100)
/* 485 */       return 0.0D; 
/* 486 */     double d = (pop - 100) / 40000.0D;
/*     */     
/* 488 */     d = Math.pow(d, 0.5D);
/*     */     
/* 490 */     d /= 40.0D;
/* 491 */     return d;
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {
/* 495 */     for (int p = 0; p < 40000; p += 2000) {
/* 496 */       double d = insaneRate(p);
/* 497 */       LOG.ln("" + p + " " + p + " " + (int)(d * p));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsNeeds.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
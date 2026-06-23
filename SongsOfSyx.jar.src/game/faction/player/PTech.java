/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.BoostSpecs;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import init.tech.TechCost;
/*     */ import init.tech.TechCurrency;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.admin.AdminData;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY_INT;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.updating.IUpdater;
/*     */ import view.interrupter.IDebugPanel;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public class PTech
/*     */ {
/*  52 */   public static CharSequence ¤¤name = "Technology";
/*  53 */   private static CharSequence ¤¤allocated = "Allocated";
/*  54 */   private static CharSequence ¤¤frozen = "Frozen";
/*  55 */   private static CharSequence ¤¤available = "Available";
/*  56 */   private static CharSequence ¤¤penalty = "Penalty";
/*     */   
/*  58 */   private static CharSequence ¤¤low = "¤{0} low";
/*  59 */   private static CharSequence ¤¤lowBody = "¤There is not enough {0} to maintain our current technologies. As a result, all bonuses from technologies using these points are receiving a penalty, and some unlocked mechanics are now re-locked. Make sure your {1} producing facilities are fully operational, or build more of them.";
/*     */   
/*     */   static {
/*  62 */     D.ts(PTech.class);
/*     */   }
/*     */   
/*  65 */   private final double frozenRate = 100.0D / TIME.days().bitSeconds();
/*  66 */   private int[] level = Alloc.ii(TECHS.ALL().size());
/*  67 */   private float[] penalties = new float[TECHS.ALL().size()];
/*     */   
/*     */   public static final double FORGET_THRESHOLD = 0.8D;
/*  70 */   public final BoostSpecs boosters = new BoostSpecs(TECHS.¤¤name, (SPRITE)(UI.icons()).s.vial, true);
/*     */   private final BoostCompound<TECH> bos;
/*     */   private double[] npcAmount;
/*  73 */   private final ArrayList<TechCurr> currs = new ArrayList(TECHS.COSTS().size());
/*  74 */   private double[] costsTmp = new double[TECHS.COSTS().size()];
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
/*     */   private boolean dirty = true;
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
/*     */   final SAVABLE saver;
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
/*     */   private final IUpdater uper;
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
/*     */   public boolean isPenaltyLocked(TECH tech) {
/* 184 */     if (this.dirty)
/* 185 */       setPenalty(); 
/* 186 */     return (this.penalties[tech.index()] > 0.0F);
/*     */   }
/*     */   
/*     */   private void setBonuses() {
/* 190 */     for (TechCurr c : this.currs) {
/* 191 */       c.allocated = 0;
/*     */     }
/*     */     
/* 194 */     for (TECH t : TECHS.ALL()) {
/* 195 */       int l = level(t);
/* 196 */       if (l > 0) {
/* 197 */         for (TechCost c : t.costs) {
/* 198 */           ((TechCurr)this.currs.get(c.cu.index)).allocated += costTotal(c, t, l);
/*     */         }
/*     */       }
/*     */     } 
/* 202 */     this.bos.clearChache();
/* 203 */     setPenalty();
/*     */   }
/*     */   
/* 206 */   PTech() { this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 210 */           file.i(TECHS.ALL().size());
/* 211 */           for (TECH t : TECHS.ALL()) {
/* 212 */             file.chars(t.key);
/* 213 */             file.i(PTech.this.level[t.index()]);
/*     */           } 
/*     */           
/* 216 */           file.i(PTech.this.currs.size());
/* 217 */           for (PTech.TechCurr c : PTech.this.currs) {
/* 218 */             file.chars(c.cu.bo.key);
/* 219 */             c.save(file);
/*     */           } 
/* 221 */           PTech.this.uper.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 226 */           int tS = file.i();
/*     */           
/* 228 */           Arrays.fill(PTech.this.level, 0);
/* 229 */           Arrays.fill(PTech.this.penalties, 0.0F);
/* 230 */           KeyMap<TECH> map = new KeyMap();
/* 231 */           for (TECH t : TECHS.ALL())
/* 232 */             map.put(t.key, t); 
/* 233 */           for (int i = 0; i < tS; i++) {
/* 234 */             String k = file.chars();
/* 235 */             int l = file.i();
/* 236 */             if (map.containsKey(k)) {
/* 237 */               PTech.this.level[((TECH)map.get(k)).index()] = CLAMP.i(l, 0, ((TECH)map.get(k)).levelMax);
/*     */             }
/*     */           } 
/*     */           
/* 241 */           KeyMap<PTech.TechCurr> cmap = new KeyMap();
/* 242 */           for (PTech.TechCurr c : PTech.this.currs) {
/* 243 */             c.clear();
/* 244 */             cmap.put(c.cu.bo.key, c);
/*     */           } 
/* 246 */           tS = file.i();
/*     */           
/* 248 */           for (int j = 0; j < tS; j++) {
/* 249 */             String k = file.chars();
/* 250 */             if (cmap.containsKey(k)) {
/* 251 */               ((PTech.TechCurr)cmap.get(k)).load(file);
/*     */             } else {
/* 253 */               (new PTech.TechCurr((TechCurrency)TECHS.COSTS().get(0))).load(file);
/*     */             } 
/*     */           } 
/* 256 */           PTech.this.uper.load(file);
/* 257 */           PTech.this.setBonuses();
/* 258 */           PTech.this.bos.clearChache();
/* 259 */           PTech.this.dirty = true;
/*     */         }
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
/*     */         public void clear() {}
/*     */       };
/* 316 */     this.uper = new IUpdater(TECHS.COSTS().size(), 10.0D)
/*     */       {
/*     */         protected void update(int i, double ds)
/*     */         {
/* 320 */           PTech.TechCurr c = (PTech.TechCurr)PTech.this.currs.get(i);
/* 321 */           c.total.set(c.total());
/* 322 */           if (c.frozen > 0.0D) {
/* 323 */             double dfrocen = c.frozen / (TIME.secondsPerDay() * 4);
/* 324 */             dfrocen = Math.max(dfrocen, PTech.this.frozenRate);
/*     */             
/* 326 */             c.frozen -= dfrocen * ds;
/* 327 */             if (c.frozen < 0.0D)
/* 328 */               c.frozen = 0.0D; 
/*     */           } 
/* 330 */           PTech.this.setPenalty();
/*     */           
/* 332 */           c.forgetTimer += ds;
/* 333 */           if (c.penalty > 0.0D)
/* 334 */           { if (!c.forgetting && c.forgetTimer > 30.0D) {
/* 335 */               c.forgetting = true;
/* 336 */               (new MessageText((CharSequence)Str.TMP.clear().add(PTech.¤¤low).insert(0, c.cu.bo.name), (CharSequence)Str.TMP2.clear().add(PTech.¤¤lowBody).insert(0, c.cu.bo.name).insert(1, c.cu.bo.name))).send();
/* 337 */               c.forgetTimer = 0.0D;
/*     */             }
/*     */              }
/*     */           else
/*     */           
/* 342 */           { c.forgetting = false; } 
/*     */         }
/*     */       }; for (TechCurrency c : TECHS.COSTS()) this.currs.add(new TechCurr(c));  IDebugPanel.add("unlockRooms", new ACTION() { public void exe() { for (PTech.TechCurr c : PTech.this.currs) { BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly() { public double vGet(Player f) { return 1.0D; } public double vGet(FactionNPC f) { return 0.0D; } }
/*     */                 ; (new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo("cheat", (SPRITE)(UI.icons()).s.expand), 1000000.0D, false)).add(c.cu.bo); }  for (int ti = 0; ti < TECHS.ALL().size(); ti++) { TECH t = (TECH)TECHS.ALL().get(ti); if (t.lockers.all().size() > 0) PTech.this.levelSet(t, t.levelMax);  }  } }
/*     */       ); BOOSTING.connecter(new ACTION() { public void exe() { int ss = 0; for (TECH t : TECHS.ALL()) { for (BoostSpec s : t.boosters.all()) ss = Math.max(s.boostable.index(), ss);  }  ss++; double[] totMul = new double[ss]; double[] totAdd = new double[ss]; double[] mul = new double[ss]; double[] add = new double[ss]; Arrays.fill(totMul, 1.0D); Arrays.fill(mul, 1.0D); for (TECH t : TECHS.ALL()) { for (BoostSpec s : t.boosters.all()) { if (s.booster.isMul && s.booster.to() > 1.0D) { totMul[s.boostable.index()] = totMul[s.boostable.index()] * s.booster.to() * t.levelMax; mul[s.boostable.index()] = mul[s.boostable.index()] * s.booster.to() * t.AIAmount * t.levelMax; continue; }  if (!s.booster.isMul && s.booster.to() > 0.0D) { totAdd[s.boostable.index()] = totAdd[s.boostable.index()] + s.booster.to() * t.levelMax; add[s.boostable.index()] = add[s.boostable.index()] + s.booster.to() * t.AIAmount * t.levelMax; }  }  }  PTech.this.npcAmount = new double[ss]; for (int i = 0; i < ss; i++) { double tot = totMul[i] * totAdd[i]; double t = mul[i] * add[i]; PTech.this.npcAmount[i] = CLAMP.d(t / tot, 0.0D, 1.0D); }  } }
/*     */       ); this.bos = new BoostCompound<TECH>(this.boosters, TECHS.ALL()) {
/*     */         protected BoostSpecs bos(TECH t) { BoostSpecs bos = new BoostSpecs(t.boosters.info.name, t.boosters.info.icon, false); for (BoostSpec s : t.boosters.all()) { double to = s.booster.isMul ? ((s.booster.to() - 1.0D) * t.levelMax + 1.0D) : (s.booster.to() * t.levelMax); BoosterValue b = new BoosterValue(BValue.VALUE1, t.boosters.info, s.booster.from(), to, s.booster.isMul); bos.push((Booster)b, s.boostable); }  return bos; } protected double getValue(TECH t) { return (1.0D - PTech.this.penalties[t.index()]) * PTech.this.level(t) / t.levelMax; } protected double get(Boostable bo, FactionNPC f, boolean isMul) { return super.get(bo, f, isMul) * PTech.this.npcAmount[bo.index() % PTech.this.npcAmount.length]; }
/* 349 */       }; } void update(double ds) { this.uper.update(ds); }
/*     */   private void setPenalty() { if (FACTIONS.player() == null || FACTIONS.player().capitolRegion() == null) { for (TechCurr c : this.currs)
/*     */         c.penalty = 0.0D;  Arrays.fill(this.penalties, 0.0F); return; }  this.dirty = false; boolean changed = false; for (TechCurr c : this.currs) { double old = c.penalty; c.penalty = 0.0D; double tot = c.total(); double all = (c.frozen() + c.allocated()) * 0.8D; if (tot == 0.0D) { c.penalty = ((c.available() < 0) ? true : false); } else if (all > tot) { c.penalty = 1.0D - tot / all; c.penalty *= c.penalty; } else { c.penalty = 0.0D; }  if (old != c.penalty)
/*     */         changed = true;  }  if (changed) { for (TECH t : TECHS.ALL()) { double p = 0.0D; for (TechCost c : t.costs)
/* 353 */           p += ((TechCurr)this.currs.get(c.cu.index)).penalty * c.amount / t.costTotal;  this.penalties[t.index()] = (float)p; }  this.bos.clearChache(); }  } public int level(TECH tech) { return this.level[tech.index()]; }
/*     */ 
/*     */   
/*     */   public void levelSet(TECH tech, int level) {
/* 357 */     level = CLAMP.i(level, 0, tech.levelMax);
/* 358 */     if (level < level(tech)) {
/* 359 */       for (TechCost c : tech.costs) {
/* 360 */         ((TechCurr)this.currs.get(c.cu.index)).frozen += 0.5D * (costTotal(c, tech) - costTotal(c, tech, level));
/*     */       }
/*     */     }
/* 363 */     this.level[tech.index()] = level;
/* 364 */     setBonuses();
/*     */   }
/*     */ 
/*     */   
/*     */   public int costLevel(double am, TECH tech) {
/* 369 */     return costLevel(am, tech, level(tech));
/*     */   }
/*     */   
/*     */   public int costLevelNext(double am, TECH tech) {
/* 373 */     return costLevel(am, tech, level(tech) + 1);
/*     */   }
/*     */   
/*     */   public int costLevel(double am, TECH tech, int level) {
/* 377 */     if (am == 0.0D)
/* 378 */       return 0; 
/* 379 */     if (level > 1) {
/* 380 */       am += Math.round(tech.levelCostInc * CLAMP.i(level - 1, 0, level));
/*     */     }
/*     */     
/* 383 */     return (int)Math.ceil(am);
/*     */   }
/*     */   
/*     */   public int costTotal(TechCost cost, TECH tech) {
/* 387 */     return costTotal(cost, tech, level(tech));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int costTotal(TechCost cost, TECH tech, int level) {
/* 392 */     int L = level;
/* 393 */     int A = (int)cost.amount;
/* 394 */     int B = (int)tech.levelCostInc;
/*     */     
/* 396 */     int am = A * L;
/*     */     
/* 398 */     if (L > 1) {
/* 399 */       L--;
/* 400 */       int sum = B * L * (L + 1) / 2;
/* 401 */       am += sum;
/*     */     } 
/*     */     
/* 404 */     return am;
/*     */   }
/*     */   
/*     */   public int costOfNextWithRequired(TechCurrency cost, double am, TECH tech) {
/* 408 */     return costLevelNext(am, tech) + costOfRequired(cost, tech);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean passes(TECH tech) {
/* 413 */     if (!tech.requires.passes(null))
/* 414 */       return false; 
/* 415 */     for (int ti = 0; ti < tech.requires().size(); ti++) {
/* 416 */       TECH.TechRequirement r = (TECH.TechRequirement)tech.requires().get(ti);
/* 417 */       if (!passes(r.tech))
/* 418 */         return false; 
/*     */     } 
/* 420 */     return true;
/*     */   }
/*     */   
/*     */   public int costOfRequired(TechCurrency cost, TECH tech) {
/* 424 */     int am = 0;
/* 425 */     for (TECH.TechRequirement r : tech.requires()) {
/* 426 */       for (TechCost c : r.tech.costs) {
/* 427 */         if (c.cu == cost) {
/* 428 */           am += Math.max(costTotal(c, r.tech, r.level) - costTotal(c, r.tech, level(r.tech)), 0);
/*     */         }
/*     */       } 
/*     */     } 
/* 432 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canUnlockNext(TECH tech) {
/* 438 */     if (this.level[tech.index()] >= tech.levelMax)
/* 439 */       return false; 
/* 440 */     if (!passes(tech))
/* 441 */       return false; 
/* 442 */     return canAffordNext(tech);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canAffordNext(TECH tech) {
/* 448 */     Arrays.fill(this.costsTmp, 0.0D);
/* 449 */     for (TechCost c : tech.costs) {
/* 450 */       this.costsTmp[c.cu.index] = c.amount;
/*     */     }
/* 452 */     for (int ti = 0; ti < TECHS.COSTS().size(); ti++) {
/* 453 */       if (costOfNextWithRequired((TechCurrency)TECHS.COSTS().get(ti), this.costsTmp[ti], tech) > Math.max(0, ((TechCurr)this.currs.get(ti)).available()))
/* 454 */         return false; 
/*     */     } 
/* 456 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<TechCurr> currs() {
/* 461 */     return (LIST<TechCurr>)this.currs;
/*     */   }
/*     */   
/*     */   public static class TechCurr
/*     */   {
/*     */     public final TechCurrency cu;
/*     */     private int allocated;
/* 468 */     private double frozen = 0.0D;
/* 469 */     private double penalty = 0.0D;
/*     */     private boolean forgetting = false;
/* 471 */     private double forgetTimer = 50.0D;
/* 472 */     private double askTimer = -10.0D;
/* 473 */     private final HistoryInt total = new HistoryInt(32, (TIMECYCLE)TIME.days(), true);
/*     */     
/*     */     TechCurr(TechCurrency cu) {
/* 476 */       this.cu = cu;
/*     */     }
/*     */     
/*     */     public int allocated() {
/* 480 */       return this.allocated;
/*     */     }
/*     */     
/*     */     public int frozen() {
/* 484 */       return (int)Math.ceil(this.frozen);
/*     */     }
/*     */     
/*     */     public int total() {
/* 488 */       return (int)this.cu.bo.get((BOOSTABLE_O)HCLASS_RACE.clP());
/*     */     }
/*     */     
/*     */     public int available() {
/* 492 */       return total() - frozen() - allocated();
/*     */     }
/*     */     
/*     */     public double penalty() {
/* 496 */       return this.penalty;
/*     */     }
/*     */     
/*     */     public HISTORY_INT produced() {
/* 500 */       this.total.set(total());
/* 501 */       return (HISTORY_INT)this.total;
/*     */     }
/*     */     
/*     */     public void hover(GUI_BOX box) {
/* 505 */       GBox b = (GBox)box;
/* 506 */       box.title(this.cu.bo.name);
/*     */ 
/*     */       
/* 509 */       this.cu.bo.hoverDetailed(box, (BOOSTABLE_O)HCLASS_RACE.clP(), Dic.¤¤Produced, true);
/* 510 */       b.NL();
/*     */       
/* 512 */       b.textLL(PTech.¤¤allocated);
/* 513 */       b.tab(6);
/* 514 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), -this.allocated));
/* 515 */       b.NL();
/*     */       
/* 517 */       b.textLL(PTech.¤¤frozen);
/* 518 */       b.tab(6);
/* 519 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), -frozen()));
/* 520 */       b.NL();
/*     */       
/* 522 */       b.sep();
/*     */       
/* 524 */       b.textLL(PTech.¤¤available);
/* 525 */       b.tab(6);
/* 526 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), available()));
/* 527 */       b.NL();
/*     */       
/* 529 */       b.textLL(PTech.¤¤penalty);
/* 530 */       b.tab(6);
/* 531 */       b.add((SPRITE)GFORMAT.percInv(b.text(), this.penalty));
/* 532 */       b.NL();
/*     */       
/* 534 */       b.sep();
/*     */       
/* 536 */       for (RoomBlueprint bb : SETT.ROOMS().all()) {
/*     */ 
/*     */         
/* 539 */         if (bb instanceof RoomBlueprintIns && bb instanceof AdminData.ROOM_ADMIN_HOLDER) {
/* 540 */           AdminData d = ((AdminData.ROOM_ADMIN_HOLDER)bb).admin();
/* 541 */           if (d.target == this.cu.bo) {
/* 542 */             b.title(((RoomBlueprintIns)bb).info.names);
/*     */ 
/*     */             
/* 545 */             b.textL(Dic.¤¤Produced);
/* 546 */             b.tab(6);
/* 547 */             b.add((SPRITE)GFORMAT.f0(b.text(), d.value()));
/* 548 */             b.NL();
/*     */             
/* 550 */             b.textL(Dic.¤¤Target);
/* 551 */             b.tab(6);
/* 552 */             b.add((SPRITE)GFORMAT.f0(b.text(), d.projection()));
/* 553 */             b.NL();
/*     */             
/* 555 */             b.NL();
/* 556 */             b.textL(Dic.¤¤Employees);
/* 557 */             b.tab(6);
/* 558 */             b.add((SPRITE)GFORMAT.i(b.text(), bb.employment().employed()));
/* 559 */             b.NL();
/*     */             
/* 561 */             b.textL(Dic.¤¤ProductionRate);
/* 562 */             b.tab(6);
/* 563 */             b.add((SPRITE)GFORMAT.f0(b.text(), d.perEmployee()));
/* 564 */             b.NL(6);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void save(FilePutter file) {
/* 574 */       file.i(this.allocated);
/* 575 */       file.d(this.frozen);
/* 576 */       file.d(this.penalty);
/* 577 */       file.bool(this.forgetting);
/* 578 */       file.d(this.forgetTimer);
/* 579 */       file.d(this.askTimer);
/* 580 */       this.total.save(file);
/*     */     }
/*     */ 
/*     */     
/*     */     void load(FileGetter file) throws IOException {
/* 585 */       this.allocated = file.i();
/* 586 */       this.frozen = file.d();
/* 587 */       this.penalty = file.d();
/* 588 */       this.forgetting = file.bool();
/* 589 */       this.forgetTimer = file.d();
/* 590 */       this.askTimer = file.d();
/* 591 */       this.total.load(file);
/*     */     }
/*     */ 
/*     */     
/*     */     void clear() {
/* 596 */       this.allocated = 0;
/* 597 */       this.frozen = 0.0D;
/* 598 */       this.penalty = 0.0D;
/* 599 */       this.forgetting = false;
/* 600 */       this.forgetTimer = 50.0D;
/* 601 */       this.askTimer = -10.0D;
/* 602 */       this.total.clear();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
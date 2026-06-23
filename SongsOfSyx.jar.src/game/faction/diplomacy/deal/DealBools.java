/*     */ package game.faction.diplomacy.deal;
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.Debugger;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.WORLD;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class DealBools {
/*  29 */   private static CharSequence ¤¤ally = "Alliance";
/*  30 */   private static CharSequence ¤¤allyD = "As allies, you will trade at an increased discount, respect each other's sovereignty, and also share your enemies. Armies can move freely in allied territory.";
/*     */   
/*  32 */   private static CharSequence ¤¤pact = "Become Colleagues";
/*  33 */   private static CharSequence ¤¤pactD = "As colleagues, you will trade at an increased discount, and also pledge not attack each other and respect each others sovereignty.";
/*     */   
/*  35 */   private static CharSequence ¤¤peace = "Peace";
/*  36 */   private static CharSequence ¤¤peaceD = "Peace Agreement. Will affect all allies and common enemies.";
/*     */   
/*  38 */   private static CharSequence ¤¤absorb = "Unite";
/*  39 */   private static CharSequence ¤¤absorbD = "The faction, and all of its territory joins you as your own territory.";
/*     */   
/*  41 */   private static CharSequence ¤¤vassal = "Become Vassal";
/*  42 */   private static CharSequence ¤¤vassalD = "You become a vassal to this faction. You will have no diplomatic relations with other factions. You will also pay a 10% tax at the end of each year, and in return you will be protected against attackers.";
/*     */   
/*  44 */   private static CharSequence ¤¤protector = "Become Protector";
/*  45 */   private static CharSequence ¤¤protectorD = "The faction becomes your vassal, and you its protector. At the end of each year you will receive a tribute of your choosing.";
/*     */ 
/*     */   
/*  48 */   private static CharSequence ¤¤tradeCancel = "Cancel All Agreements";
/*  49 */   private static CharSequence ¤¤tradeCancelD = "Will cancel all agreements, including trade and make you neutral to each other";
/*     */   
/*  51 */   private static CharSequence ¤¤tradeD = "You and the faction become trade partners, which will allow you to automatically trade at better prices.";
/*     */   
/*  53 */   private static CharSequence ¤¤pWarAlready = "You are already at war.";
/*  54 */   private static CharSequence ¤¤pWarNot = "You are not at war.";
/*  55 */   private static CharSequence ¤¤pOther = "Can not be combined with other proposals.";
/*  56 */   private static CharSequence ¤¤pNoAgree = "You have no agreements to break.";
/*  57 */   private static CharSequence ¤¤pDistance = "This option requires the faction to be your neighbour.";
/*  58 */   private static CharSequence ¤¤pAlready = "You are already at this stance with each other.";
/*  59 */   private static CharSequence ¤¤pOpinion = "You are not liked enough by the faction for this stance to be considered. A minimum opinion of {0} is required.";
/*  60 */   private static CharSequence ¤¤pVassal = "As a vassal, you can not propose this agreement to this faction.";
/*  61 */   private static CharSequence ¤¤pVassalOther = "This faction is a puppet state of another faction, and is not allowed to make this agreement.";
/*     */   
/*  63 */   private static CharSequence ¤¤opReq = "Opinion Required";
/*  64 */   private static CharSequence ¤¤opTarif = "Tariff";
/*     */   
/*     */   static {
/*  67 */     D.ts(DealBools.class);
/*     */   }
/*     */   private final DealParty a; private final DealParty b; public final DealBool WAR; public final DealBool PEACE; public final DealBool CANCEL_ALL; public final DealBool TRADE; public final DealBool PACT; public final DealBool ALLY;
/*  70 */   private final ArrayListGrower<DealBool> all = new ArrayListGrower();
/*     */   
/*     */   public final DealBool VASSAL;
/*     */   public final DealBool OVERLORD;
/*     */   public final DealBool ABSORB;
/*     */   private double allyValue;
/*     */   private double peaceValue;
/*     */   private double tradeValue;
/*     */   private double opinionMul;
/*     */   private boolean player;
/*     */   
/*     */   DealBools(DealParty a, DealParty b) {
/*  82 */     this.WAR = new DealBool((LISTE)this.all, Dic.¤¤DeclareWar, Dic.¤¤WarD, (DIP.WAR()).icon)
/*     */       {
/*     */         
/*     */         public void execute()
/*     */         {
/*  87 */           ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), (DipStance)DIP.WAR(), DealBools.this.player);
/*     */         }
/*     */ 
/*     */         
/*     */         public double value() {
/*  92 */           return 0.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void pInit(DealParty a, DealParty b, Debugger deb) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected DipStance stance() {
/* 102 */           return (DipStance)DIP.WAR();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence problem() {
/* 107 */           if (DIP.WAR().is(DealBools.this.a.f(), DealBools.this.b.f()))
/* 108 */             return DealBools.¤¤pWarAlready; 
/* 109 */           for (DealBool b : DealBools.this.all()) {
/* 110 */             if (b != this && b.is())
/* 111 */               return DealBools.¤¤pOther; 
/*     */           } 
/* 113 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 117 */     this.PEACE = new DealBool((LISTE)this.all, ¤¤peace, ¤¤peaceD, (SPRITE)(UI.icons()).s.sprout.createColored((COLOR)new ColorImp(0, 128, 128)))
/*     */       {
/*     */         private double value;
/*     */ 
/*     */         
/*     */         public void execute() {
/* 123 */           ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), DIP.NEUTRAL(), DealBools.this.player);
/*     */         }
/*     */ 
/*     */         
/*     */         public double value() {
/* 128 */           return this.value;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 133 */           this.value = DealBools.this.pactChange(DIP.NEUTRAL(), deb);
/*     */         }
/*     */ 
/*     */         
/*     */         protected DipStance stance() {
/* 138 */           return DIP.NEUTRAL();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence problem() {
/* 143 */           if (!DIP.WAR().is(DealBools.this.a.f(), DealBools.this.b.f()))
/* 144 */             return DealBools.¤¤pWarNot; 
/* 145 */           for (DealBool b : DealBools.this.all()) {
/* 146 */             if (b != this && b.is())
/* 147 */               return DealBools.¤¤pOther; 
/*     */           } 
/* 149 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 153 */     this.CANCEL_ALL = new DealBool((LISTE)this.all, ¤¤tradeCancel, ¤¤tradeCancelD, (DIP.TRADE()).icon.twin((SPRITE)(UI.icons()).s.cancel.createColored(COLOR.REDISH), DIR.C, 1))
/*     */       {
/*     */         private double value;
/*     */ 
/*     */         
/*     */         public double value() {
/* 159 */           return this.value;
/*     */         }
/*     */ 
/*     */         
/*     */         public void execute() {
/* 164 */           ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), DIP.NEUTRAL(), DealBools.this.player);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 169 */           this.value = DealBools.this.pactChange(DIP.NEUTRAL(), deb);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected DipStance stance() {
/* 175 */           return DIP.NEUTRAL();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence problem() {
/* 180 */           if (!(DIP.get(DealBools.this.a.f(), DealBools.this.b.f())).trades)
/* 181 */             return DealBools.¤¤pNoAgree; 
/* 182 */           for (DealBool b : DealBools.this.all()) {
/* 183 */             if (b != this && b.is())
/* 184 */               return DealBools.¤¤pOther; 
/*     */           } 
/* 186 */           return null;
/*     */         }
/*     */       };
/*     */     
/* 190 */     this.TRADE = new DealStance(Dic.¤¤Trade, ¤¤tradeD, DIP.TRADE());
/*     */     
/* 192 */     this.PACT = new DealStance(¤¤pact, ¤¤pactD, DIP.PACT());
/*     */     
/* 194 */     this.ALLY = new DealStance(¤¤ally, ¤¤allyD, DIP.ALLY());
/*     */     
/* 196 */     this.VASSAL = new DealStance(¤¤protector, ¤¤protectorD, DIP.OVERLORD());
/*     */     
/* 198 */     this.OVERLORD = new DealStance(¤¤vassal, ¤¤vassalD, DIP.VASSAL());
/*     */ 
/*     */     
/* 201 */     this.ABSORB = new DealBool((LISTE)this.all, ¤¤absorb, ¤¤absorbD, (SPRITE)(UI.icons()).s.flags.createColored((COLOR)new ColorImp(128, 128, 0)))
/*     */       {
/*     */         private double value;
/*     */ 
/*     */         
/*     */         public void execute() {
/* 207 */           while (DealBools.this.b.npc().realm().regions() > 1) {
/* 208 */             DealBools.this.b.npc().realm().region(1).fationSet(DealBools.this.a.f(), true);
/*     */           }
/* 210 */           if (DealBools.this.b.f().realm().regions() > 0)
/* 211 */             DealBools.this.b.f().realm().region(0).fationSet(DealBools.this.a.f(), true); 
/* 212 */           FACTIONS.remove(DealBools.this.b.npc(), true);
/* 213 */           (GAME.count()).UNITES.inc(1);
/*     */         }
/*     */ 
/*     */         
/*     */         public double value() {
/* 218 */           return this.value;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 224 */           this.value = DealBools.this.pactChange(DIP.VASSAL(), deb);
/* 225 */           this.value -= b.selfWorth();
/*     */           
/* 227 */           if (DIP.WAR().is(a.f(), b.f())) {
/* 228 */             this.value -= b.selfWorth();
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         protected DipStance stance() {
/* 234 */           return DIP.get(DealBools.this.a.f(), DealBools.this.b.f());
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence problem() {
/* 239 */           if (DealBools.this.a.f() == FACTIONS.player() && !RD.DIST().reachable(DealBools.this.b.f()))
/* 240 */             return DealBools.¤¤pDistance; 
/* 241 */           for (DealBool b : DealBools.this.all()) {
/* 242 */             if (b != this && b.is()) {
/* 243 */               return DealBools.¤¤pOther;
/*     */             }
/*     */           } 
/*     */           
/* 247 */           return null;
/*     */         }
/*     */       };
/*     */     this.a = a;
/*     */     this.b = b;
/*     */   }
/*     */   private class DealStance extends DealBool { private double vv;
/*     */     private final DipStance ss;
/*     */     
/*     */     DealStance(CharSequence name, CharSequence desc, DipStance stance) {
/* 257 */       super((LISTE<DealBool>)DealBools.this.all, name, desc, stance.icon);
/* 258 */       this.ss = stance;
/*     */     }
/*     */ 
/*     */     
/*     */     public double value() {
/* 263 */       return this.vv;
/*     */     }
/*     */ 
/*     */     
/*     */     public void execute() {
/* 268 */       ROPINION.STANCE().setNewStance(DealBools.this.b.npc(), this.ss, DealBools.this.player);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void pInit(DealParty a, DealParty b, Debugger deb) {
/* 273 */       this.vv = DealBools.this.pactChange(this.ss, deb);
/*     */     }
/*     */ 
/*     */     
/*     */     protected DipStance stance() {
/* 278 */       return this.ss;
/*     */     }
/*     */ 
/*     */     
/*     */     public CharSequence problem() {
/* 283 */       if (this.ss.is(DealBools.this.a.f(), DealBools.this.b.f()) || this.ss.is(DealBools.this.b.f(), DealBools.this.a.f())) {
/* 284 */         return DealBools.¤¤pAlready;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 289 */       if (ROPINION.get(DealBools.this.b.npc()) < this.ss.opinionNeeded && !(S.get()).developer) {
/* 290 */         Str.TMP.clear().add(DealBools.¤¤pOpinion).insert(0, this.ss.opinionNeeded, 1);
/* 291 */         return (CharSequence)Str.TMP;
/*     */       } 
/*     */       
/* 294 */       if (this != DealBools.this.TRADE) {
/* 295 */         if (DIP.overlord(DealBools.this.a.f()) != null) {
/* 296 */           return DealBools.¤¤pVassal;
/*     */         }
/* 298 */         if (DIP.overlord(DealBools.this.b.f()) != null) {
/* 299 */           return DealBools.¤¤pVassalOther;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 304 */       if (DealBools.this.a.f() == FACTIONS.player() && !RD.DIST().reachable(DealBools.this.b.f())) {
/* 305 */         return DealBools.¤¤pDistance;
/*     */       }
/* 307 */       for (DealBool b : DealBools.this.all()) {
/* 308 */         if (b != this && b.is())
/* 309 */           return DealBools.¤¤pOther; 
/*     */       } 
/* 311 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hover(GBox b) {
/* 316 */       super.hover(b);
/* 317 */       b.textL(DealBools.¤¤opReq);
/* 318 */       b.tab(7);
/* 319 */       b.add((SPRITE)GFORMAT.f(b.text(), this.ss.opinionNeeded));
/* 320 */       b.NL();
/*     */       
/* 322 */       b.textL(DealBools.¤¤opTarif);
/* 323 */       b.tab(7);
/* 324 */       b.add((SPRITE)GFORMAT.percInv(b.text(), this.ss.tarif));
/* 325 */       b.NL();
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double pactChange(DipStance newStance, Debugger deb) {
/* 332 */     DipStance old = DIP.get(this.a.f(), this.b.f());
/* 333 */     if (old == newStance) {
/* 334 */       return 0.0D;
/*     */     }
/* 336 */     double value = 0.0D;
/*     */     
/* 338 */     deb.debug(old.name).add(newStance.name);
/*     */     
/* 340 */     if (old == DIP.WAR()) {
/* 341 */       value += this.peaceValue;
/*     */     }
/*     */     
/* 344 */     deb.debug("1").add(value);
/*     */     
/* 346 */     if (newStance.tarif < old.tarif) {
/* 347 */       double d = old.tarif - newStance.tarif;
/* 348 */       value += this.tradeValue + 20.0D * this.tradeValue * d;
/*     */     } 
/*     */     
/* 351 */     deb.debug("2").add(value);
/*     */     
/* 353 */     if (!old.ally && newStance.ally) {
/* 354 */       value += this.allyValue;
/*     */     }
/*     */     
/* 357 */     deb.debug("3").add(value);
/*     */ 
/*     */     
/* 360 */     if (old == DIP.VASSAL()) {
/* 361 */       value -= 0.5D * this.a.offerableWorth() * this.opinionMul;
/* 362 */     } else if (newStance == DIP.VASSAL()) {
/* 363 */       value = this.tradeValue;
/* 364 */       value += CLAMP.d(0.25D * this.a.selfWorth() * (1.0D - this.opinionMul), 0.0D, this.b.offerableWorth());
/*     */     } 
/*     */     
/* 367 */     deb.debug("4").add(value);
/*     */ 
/*     */     
/* 370 */     if (old == DIP.OVERLORD()) {
/* 371 */       value += this.b.offerableWorth() * 0.1D * this.opinionMul;
/* 372 */     } else if (newStance == DIP.OVERLORD()) {
/* 373 */       value -= this.b.selfWorth() * 0.5D * (1.0D - this.opinionMul);
/*     */     } 
/*     */     
/* 376 */     deb.debug("5").add(value);
/*     */     
/* 378 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   private double tradeValue(Debugger deb) {
/* 383 */     double d = WORLD.PATH().distance(this.a.f().capitolRegion(), this.b.f().capitolRegion());
/* 384 */     deb.debug("trade Dist").add(d);
/* 385 */     if (d == 0.0D) {
/* 386 */       return 0.0D;
/*     */     }
/* 388 */     double dist = 1.0D + d / 512.0D;
/* 389 */     double cs = 5.0E-4D * FACTIONS.WORTH().faction((Faction)this.b.npc());
/* 390 */     cs *= 1.0D + CLAMP.d(POP.tot(null, null) / 2500.0D, 0.0D, 1.0D);
/* 391 */     deb.debug("trade data").add(dist).s().add(cs).add(cs * dist);
/* 392 */     deb.debug("trade value").add(-dist * cs);
/* 393 */     return -dist * cs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double peaceValue(Debugger deb) {
/* 402 */     double adv = DIP.WAR_PLAYER().coalitionAdvantage();
/* 403 */     deb.debug("peace advantage").add(adv);
/* 404 */     adv -= DIP.WAR_PLAYER().distress(this.b.f());
/* 405 */     deb.debug("peace distress").add(adv);
/* 406 */     adv = CLAMP.d(adv, 0.0D, 1.0D);
/*     */     
/* 408 */     double pv = -adv * 0.75D * this.a.offerableWorth();
/* 409 */     deb.debug("peace").add(pv);
/*     */     
/* 411 */     return pv;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double allyValue(Debugger deb) {
/* 417 */     double powA = 0.0D;
/* 418 */     double powB = 0.0D;
/* 419 */     double enemiesA = 0.0D;
/* 420 */     double enemiesB = 0.0D;
/*     */     
/* 422 */     for (Faction f : FACTIONS.all()) {
/* 423 */       if (f == this.a.f() || (DIP.get(this.a.f(), f)).ally) {
/* 424 */         powA += f.offensivePower(); continue;
/* 425 */       }  if (f != this.b.f() && DIP.WAR().is(this.a.f(), f)) {
/* 426 */         if (!DIP.WAR().is(this.b.f(), f))
/* 427 */           enemiesA += f.offensivePower();  continue;
/* 428 */       }  if (f == this.b.f() || (DIP.get(this.b.f(), f)).ally) {
/* 429 */         powB += f.offensivePower(); continue;
/* 430 */       }  if (f != this.a.f() && DIP.WAR().is(this.b.f(), f)) {
/* 431 */         enemiesB -= f.offensivePower();
/*     */       }
/*     */     } 
/*     */     
/* 435 */     double before = (powB + 100.0D) / (enemiesB + 100.0D);
/* 436 */     double after = (powA + powB + 100.0D) / (enemiesA + enemiesB + 100.0D);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 441 */     if (before < 1.0D) {
/* 442 */       if (after > before)
/*     */       {
/* 444 */         return this.b.selfWorth() * CLAMP.d((after - before) * 0.25D, 0.0D, 0.25D);
/*     */       }
/*     */       
/* 447 */       return -this.b.selfWorth();
/*     */     } 
/*     */ 
/*     */     
/* 451 */     double d = 0.1D * before / after;
/*     */ 
/*     */     
/* 454 */     deb.debug("allyValue powA").add(powA);
/* 455 */     deb.debug("allyValue powB").add(powB);
/* 456 */     deb.debug("allyValue enemiesA").add(enemiesA);
/* 457 */     deb.debug("allyValue enemirsB").add(enemiesB);
/* 458 */     deb.debug("allyValue d").add(d);
/* 459 */     deb.debug("allyValue").add(-this.b.selfWorth() * d);
/*     */ 
/*     */     
/* 462 */     return -this.b.selfWorth() * d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(boolean player, boolean clear, Debugger d) {
/* 473 */     this.player = player;
/*     */     
/* 475 */     this.opinionMul = 0.5D;
/* 476 */     if (this.a.f() == FACTIONS.player()) {
/* 477 */       double op = ROPINION.get(this.b.npc());
/* 478 */       this.opinionMul = 0.5D + -op / 10.0D;
/* 479 */       this.opinionMul = CLAMP.d(this.opinionMul, 0.05D, 1.0D);
/*     */     } 
/*     */ 
/*     */     
/* 483 */     d.title((CharSequence)(this.b.f()).name);
/* 484 */     d.debug("opinionMul").add(this.opinionMul);
/* 485 */     d.debug("a Worth").add(this.a.selfWorth()).s().add(this.a.offerableWorth());
/* 486 */     d.debug("b Worth").add(this.b.selfWorth()).s().add(this.b.offerableWorth());
/*     */ 
/*     */     
/* 489 */     this.allyValue = allyValue(d);
/* 490 */     this.peaceValue = peaceValue(d);
/* 491 */     this.tradeValue = tradeValue(d);
/*     */     
/* 493 */     for (DealBool bool : this.all) {
/* 494 */       bool.pInit(this.a, this.b, d);
/* 495 */       if (clear) {
/* 496 */         bool.set(false);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public double value() {
/* 502 */     double v = 0.0D;
/* 503 */     for (DealBool bool : this.all) {
/* 504 */       if (bool.is())
/* 505 */         v += bool.value(); 
/*     */     } 
/* 507 */     if (this.ABSORB.is()) {
/* 508 */       v -= this.b.selfWorth() * 0.5D * (1.0D - this.opinionMul);
/* 509 */       v -= this.b.regs.worth();
/*     */     } 
/*     */     
/* 512 */     return v;
/*     */   }
/*     */   
/*     */   public double betrayal() {
/* 516 */     if (this.a.f() != FACTIONS.player()) {
/* 517 */       return 0.0D;
/*     */     }
/* 519 */     for (DealBool bool : this.all) {
/* 520 */       if (bool.is()) {
/* 521 */         return Math.max(0.0D, ROPINION.STANCE().betrayal(this.b.npc(), bool.stance()));
/*     */       }
/*     */     } 
/* 524 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   void execute() {
/* 529 */     double be = betrayal();
/* 530 */     for (DealBool bo : this.all) {
/* 531 */       if (bo.is()) {
/* 532 */         if (this.a.f() == FACTIONS.player() && be > 0.0D)
/* 533 */           ROPINION.STANCE().betrayal(this.b.npc(), DIP.get(this.b.npc()), bo.stance()); 
/* 534 */         bo.execute();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public LIST<DealBool> all() {
/* 540 */     return (LIST<DealBool>)this.all;
/*     */   }
/*     */   
/*     */   public void betrayalHover(GBox box) {
/* 544 */     if (this.a.f() != FACTIONS.player()) {
/*     */       return;
/*     */     }
/* 547 */     for (DealBool bool : this.all) {
/* 548 */       if (bool.is()) {
/* 549 */         ROPINION.STANCE().betrayalHover(box, this.b.npc(), bool.stance());
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealBools.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
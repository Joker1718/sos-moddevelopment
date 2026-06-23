/*     */ package game.faction.royalty.opinion;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperSpec;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import world.army.AD;
/*     */ import world.battle.BattleListener;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ public final class OpsStance {
/*  27 */   private static CharSequence ¤¤WarDec = "War Declaration";
/*  28 */   private static CharSequence ¤¤WarDecD = "Wars that have been declared by you against this faction.";
/*  29 */   private static CharSequence ¤¤WarD = "Time spent at war with this faction.";
/*  30 */   private static CharSequence ¤¤agression = "Aggression";
/*  31 */   private static CharSequence ¤¤agressionD = "Aggression you have shown towards other factions by declaring war. The value is negated by the distance from you to the faction at the time of the declaration. Decreases with time.";
/*     */   
/*  33 */   private static CharSequence ¤¤chivalry = "Chivalry";
/*  34 */   private static CharSequence ¤¤chivalryD = "Based on your chivalrous actions after a successful battle.";
/*  35 */   private static CharSequence ¤¤cruelty = "Cruelty";
/*  36 */   private static CharSequence ¤¤crueltyD = "Based on your cruel actions after a successful battle.";
/*     */   
/*  38 */   private static CharSequence ¤¤joinW = "Joint Wars";
/*  39 */   private static CharSequence ¤¤joinWD = "Joint wars against a common enemy.";
/*     */   
/*  41 */   public static CharSequence ¤¤betrayal = "Betrayal";
/*  42 */   private static CharSequence ¤¤betrayalD = "Oaths, such as pacts or alliances that have been broken.";
/*     */   
/*  44 */   private static CharSequence ¤¤betrayalH = "When setting a new stance, the faction might feel betrayed. This happens when decreasing your current stance, especially if said stance is new. Declaring war on a faction you have a stance with is also frowned upon. You should break all agreements first. You could also sabotage their opinion of you, and have them break off the treaties for no penalty at all.";
/*  45 */   private static CharSequence ¤¤betrayalTime = "Current treaty freshness.";
/*  46 */   private static CharSequence ¤¤betrayalBase = "Base betrayal inflicted.";
/*  47 */   private static CharSequence ¤¤betrayalThis = "Betrayal inflicted on this faction.";
/*  48 */   private static CharSequence ¤¤betrayalOthers = "Betrayal inflicted on surrounding factions.";
/*     */   
/*  50 */   private static CharSequence ¤¤raidingD = "Raids, done by you on this faction's land.";
/*  51 */   private static CharSequence ¤¤peaceD = "From signing a reasonable peace agreement.";
/*     */   
/*  53 */   private static CharSequence ¤¤vassalP = "Failed Protection";
/*  54 */   private static CharSequence ¤¤vassalD = "Vassals you have failed to protect.";
/*     */   
/*  56 */   private static CharSequence ¤¤trespassing = "Trespassing";
/*  57 */   private static CharSequence ¤¤trespassingD = "By having your armies march in this faction's territory, unless you're allies.";
/*     */   
/*  59 */   private static CharSequence ¤¤fatique = "War Fatigue";
/*  60 */   private static CharSequence ¤¤fatiqueD = "Joint was with your allies. No one wants war forever. Aggressive rulers might be more forgiven for drawn-out wars."; private final ROpper.ROpperDown agression;
/*     */   
/*     */   static {
/*  63 */     D.ts(OpsStance.class);
/*     */   }
/*     */ 
/*     */   
/*     */   private final ROpper.ROpperDown war;
/*     */   
/*     */   public final SuperSpec.SuperSpecImp<Royalty> chivalry;
/*     */   
/*     */   public final ROpper cruelty;
/*     */   
/*     */   final ROpper.ROpperDown joint;
/*     */   private final ROpper.ROpperDown betrayal;
/*     */   private final ROpper.ROpperDown raiding;
/*     */   private final ROpper.ROpperDown trespassing;
/*     */   private final ROpper.ROpperDown peace;
/*     */   private final ROpper.ROpperDown vassal;
/*     */   
/*     */   OpsStance() {
/*  81 */     double year = (16 * TIME.secondsPerDay());
/*  82 */     this.agression = new ROpper.ROpperDown("AGRESSION", ¤¤agression, ¤¤agressionD, (SPRITE)(UI.icons()).s.shield, -1.0D, false, year * 4.0D)
/*     */       {
/*     */         public double getModifier(Royalty roy) {
/*  85 */           return 1.0D / (0.25D + (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)roy.induvidual));
/*     */         }
/*     */       };
/*  88 */     this.war = new ROpper.ROpperDown("WAR_DECLARATION", ¤¤WarDec, ¤¤WarDecD, (SPRITE)(UI.icons()).s.sword, -2.0D, false, year * 5.0D);
/*     */     
/*  90 */     this.vassal = new ROpper.ROpperDown("VASSAL_FAIL", ¤¤vassalP, ¤¤vassalD, (SPRITE)(UI.icons()).s.slave, -20.0D, false, year * 4.0D * 20.0D)
/*     */       {
/*     */         public double pget(Royalty roy)
/*     */         {
/*  94 */           if (DIP.VASSAL().is(roy.court.faction)) {
/*  95 */             return super.pget(roy);
/*     */           }
/*  97 */           return 0.0D;
/*     */         }
/*     */       };
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
/* 148 */     this.chivalry = new ROpper("CHIVALRY", ¤¤chivalry, ¤¤chivalryD, (SPRITE)(UI.icons()).s.law, 1.0D, false)
/*     */       {
/*     */         public double getModifier(Royalty roy)
/*     */         {
/* 152 */           return CLAMP.d((BOOSTABLES.NOBLE()).MERCY.get((BOOSTABLE_O)roy.induvidual) - 1.0D, 0.0D, 1.0D);
/*     */         }
/*     */         
/*     */         public double pget(Royalty roy) {
/* 156 */           double d = AD.stats().mercy().getD(FACTIONS.player());
/* 157 */           if (d > 0.0D)
/* 158 */             return CLAMP.d(d, 0.0D, 1.0D); 
/* 159 */           return 0.0D;
/*     */         }
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/* 163 */           return pget(bo);
/*     */         }
/*     */       };
/*     */     
/* 167 */     this.cruelty = new ROpper("CRUELTY", ¤¤cruelty, ¤¤crueltyD, (SPRITE)(UI.icons()).s.law, 1.0D, false)
/*     */       {
/*     */         public double getModifier(Royalty roy)
/*     */         {
/* 171 */           return CLAMP.d(1.0D - (BOOSTABLES.NOBLE()).MERCY.get((BOOSTABLE_O)roy.induvidual), 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public double pget(Royalty roy) {
/* 176 */           double d = -AD.stats().mercy().getD(FACTIONS.player());
/* 177 */           if (d > 0.0D)
/* 178 */             return CLAMP.d(d, 0.0D, 1.0D); 
/* 179 */           return 0.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double ptarget(Royalty bo) {
/* 184 */           return pget(bo);
/*     */         }
/*     */       };
/*     */     
/* 188 */     this.joint = new ROpper.ROpperDown("MUTUAL_WAR", ¤¤joinW, ¤¤joinWD, (SPRITE)(UI.icons()).s.sword, 3.0D, false, year * 16.0D)
/*     */       {
/*     */         public double getModifier(Royalty roy) {
/* 191 */           return (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)roy.induvidual);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 196 */     this.peace = new ROpper.ROpperDown("PEACE", Dic.¤¤peace, ¤¤peaceD, (SPRITE)(UI.icons()).s.sprout, 100.0D, false, year * 4.0D * 100.0D);
/*     */     
/* 198 */     this.betrayal = new ROpper.ROpperDown("BETRAYAL", ¤¤betrayal, ¤¤betrayalD, (SPRITE)(UI.icons()).s.sword, -10.0D, false, year * 10.0D * 2.0D)
/*     */       {
/*     */         public double getModifier(Royalty roy) {
/* 201 */           return (BOOSTABLES.NOBLE()).HONOUR.get((BOOSTABLE_O)roy.induvidual);
/*     */         }
/*     */       };
/*     */     
/* 205 */     this.raiding = new ROpper.ROpperDown("RAIDING", Dic.¤¤Raiding, ¤¤raidingD, (SPRITE)(UI.icons()).s.sword, -8.0D, false, year * 24.0D);
/*     */     
/* 207 */     this.trespassing = new ROpper.ROpperDown("TRESPASS", ¤¤trespassing, ¤¤trespassingD, (SPRITE)(UI.icons()).s.sword, -4.0D, false, year * 4.0D);
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
/*     */   public double betrayal(FactionNPC npc, DipStance newStance) {
/* 255 */     return betrayal(npc, DIP.get(npc), newStance);
/*     */   }
/*     */ 
/*     */   
/*     */   public double betrayal(FactionNPC npc, DipStance old, DipStance newStance) {
/* 260 */     return betrayalD(npc, old, newStance) * this.betrayal.to() * this.betrayal.getModifier((SuperBoostableObj)npc.court().king().roy());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double betrayalD(FactionNPC npc, DipStance old, DipStance newStance) {
/* 266 */     double dp = newStance.loyalty - old.loyalty;
/* 267 */     if (dp > 0.0D) {
/* 268 */       return dp;
/*     */     }
/*     */     
/* 271 */     if (newStance == DIP.WAR()) {
/* 272 */       dp *= 2.0D;
/* 273 */       dp--;
/*     */     } 
/*     */     
/* 276 */     double time = DIP.secondSinceStance(npc) / TIME.secondsPerDay() * 16.0D * 8.0D;
/* 277 */     time = 1.0D - time;
/* 278 */     time = CLAMP.d(time, 0.01D, 1.0D);
/* 279 */     dp *= time;
/*     */     
/* 281 */     return dp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNewStance(FactionNPC npc, DipStance newStance, boolean playerDidIt) {
/* 288 */     DipStance old = DIP.get((Faction)npc, (Faction)FACTIONS.player());
/*     */     
/* 290 */     if (old == newStance) {
/*     */       return;
/*     */     }
/* 293 */     double betray = -betrayalD(npc, old, newStance);
/* 294 */     if (betray > 0.0D) {
/* 295 */       for (FactionNPC o : FACTIONS.NPCs()) {
/* 296 */         double v = 0.25D * CLAMP.d(128.0D / RD.DIST().distance((Faction)o), 0.0D, 1.0D);
/* 297 */         if (o == npc)
/* 298 */           v = 1.0D; 
/* 299 */         for (Royalty r : o.court().all()) {
/* 300 */           this.betrayal.value.incD(r, r.isKing() ? (betray * v) : (betray * 0.25D * v));
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 305 */     if (old == DIP.WAR()) {
/* 306 */       signPeace();
/*     */     }
/*     */     
/* 309 */     newStance.set(npc);
/*     */ 
/*     */ 
/*     */     
/* 313 */     if (newStance == DIP.WAR()) {
/* 314 */       for (Royalty r : npc.court().all()) {
/* 315 */         this.war.value.incD(r, r.isKing() ? 1.0D : 0.25D);
/* 316 */         this.joint.value.setD(r, 0.0D);
/* 317 */         this.peace.value.setD(r, 0.0D);
/*     */       } 
/* 319 */       for (FactionNPC o : FACTIONS.NPCs()) {
/* 320 */         if (o != npc) {
/* 321 */           double v = 0.5D * CLAMP.d(1.0D - RD.DIST().distance((Faction)npc) / 256.0D, 0.0D, 1.0D);
/* 322 */           for (Royalty r : o.court().all())
/*     */           {
/* 324 */             this.agression.value.incD(r, r.isKing() ? v : (0.25D * v));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void signPeace() {
/* 335 */     for (Faction f : DIP.WAR().all((Faction)FACTIONS.player())) {
/* 336 */       ROPINION.setOpinionValue((FactionNPC)f, this.peace, 0.5D);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void raid(FactionNPC f, double time) {
/* 343 */     double inc = 0.1D + time * TIME.secondsPerDayI();
/*     */     
/* 345 */     for (Royalty r : f.court().all()) {
/* 346 */       this.raiding.value.incD(r, r.isKing() ? inc : (inc * 0.5D));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void tresPass(FactionNPC f, double time) {
/* 353 */     if ((DIP.get(f)).ally) {
/*     */       return;
/*     */     }
/* 356 */     double inc = 0.1D + time * TIME.secondsPerDayI();
/*     */     
/* 358 */     for (Royalty r : f.court().all()) {
/* 359 */       this.trespassing.value.incD(r, r.isKing() ? inc : (inc * 0.5D));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double trustWorthyness(FactionNPC f) {
/* 365 */     return CLAMP.d(1.0D - this.betrayal.value.getD(f.king()), 0.0D, 1.0D);
/*     */   }
/*     */   
/*     */   public void betrayalHover(GBox box, FactionNPC npc, DipStance stance) {
/* 369 */     box.title(¤¤betrayal);
/* 370 */     box.text(¤¤betrayalH);
/* 371 */     box.sep();
/* 372 */     box.textLL(¤¤betrayalTime);
/* 373 */     box.NL();
/* 374 */     double time = DIP.secondSinceStance(npc) / TIME.secondsPerDay() * 16.0D * 8.0D;
/* 375 */     time = 1.0D - time;
/* 376 */     time = CLAMP.d(time, 0.0D, 1.0D);
/* 377 */     box.add((SPRITE)GFORMAT.perc(box.text(), time));
/* 378 */     box.sep();
/*     */     
/* 380 */     box.textLL(¤¤betrayalBase);
/* 381 */     box.NL();
/* 382 */     box.add((SPRITE)GFORMAT.f0(box.text(), betrayal(npc, stance)));
/* 383 */     box.sep();
/*     */     
/* 385 */     box.textLL(¤¤betrayalThis);
/* 386 */     box.NL();
/* 387 */     double m = betrayal(npc, stance) * this.betrayal.getModifier((SuperBoostableObj)npc.king());
/* 388 */     box.add((SPRITE)GFORMAT.f0(box.text(), m));
/* 389 */     box.sep();
/*     */     
/* 391 */     box.textLL(¤¤betrayalOthers);
/* 392 */     box.NL();
/* 393 */     m = betrayal(npc, stance) * 0.25D;
/* 394 */     box.add((SPRITE)GFORMAT.f0(box.text(), m));
/* 395 */     box.sep();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsStance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
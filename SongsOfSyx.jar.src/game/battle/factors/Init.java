/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ class Init {
/*  17 */   private static CharSequence ¤¤exhaustion = "Exhaustion";
/*  18 */   private static CharSequence ¤¤exhaustionDesc = "Running and fighting will exhaust a division, making them less effective in combat.";
/*  19 */   private static CharSequence ¤¤exhMess = "Exhaustion";
/*     */   
/*  21 */   private static CharSequence ¤¤formName = "Formation";
/*  22 */   private static CharSequence ¤¤formDesc = "A coherent formation of enough depth makes soldiers feel safe and helps them defend each other against attacks.";
/*  23 */   private static CharSequence ¤¤formMess = "Formation is Intact";
/*  24 */   private static CharSequence ¤¤inPos = "In Position";
/*  25 */   private static CharSequence ¤¤depth = "Formation depth";
/*     */   
/*  27 */   private static CharSequence ¤¤armyName = "Numbers";
/*  28 */   private static CharSequence ¤¤armyDesc = "The size of our army against the size of the enemy's army.";
/*  29 */   private static CharSequence ¤¤armyMess = "Numbers";
/*  30 */   private static CharSequence ¤¤armyPlayer = "Army Size";
/*  31 */   private static CharSequence ¤¤armyEnemy = "Enemy Army Size";
/*     */   
/*  33 */   private static CharSequence ¤¤suppliesName = "Supplies";
/*  34 */   private static CharSequence ¤¤suppliesDesc = "The army's supplies prior to engagement.";
/*  35 */   private static CharSequence ¤¤suppliesMess = "Supplied";
/*     */   
/*  37 */   private static CharSequence ¤¤casultiesName = "Casualties";
/*  38 */   private static CharSequence ¤¤casultiesDesc = "The amount of casualties sustained in this battle.";
/*  39 */   private static CharSequence ¤¤casultiesMess = "Taking Casulties";
/*  40 */   private static CharSequence ¤¤inUnit = "In Unit";
/*  41 */   private static CharSequence ¤¤inArmy = "In Army";
/*     */   
/*  43 */   private static CharSequence ¤¤routName = "Routing";
/*  44 */   private static CharSequence ¤¤routDesc = "The amount of soldiers that have routed.";
/*  45 */   private static CharSequence ¤¤routMess = "Routing";
/*     */   
/*  47 */   private static CharSequence ¤¤projectilesName = "Under Fire";
/*  48 */   private static CharSequence ¤¤projectilesDesc = "Nothing can be as demoralizing as being bombarded by projectiles. The effect lasts for some time.";
/*  49 */   private static CharSequence ¤¤projectilesMess = "Under Fire";
/*     */   
/*  51 */   private static CharSequence ¤¤situationName = "Situation";
/*  52 */   private static CharSequence ¤¤situationDesc = "The proximity, and amount of enemy troops and their quality.";
/*  53 */   private static CharSequence ¤¤situationMess = "Feeling Outmatched";
/*  54 */   private static CharSequence ¤¤enemiesNear = "Enemy Power Nearby";
/*  55 */   private static CharSequence ¤¤friendsNear = "Ally Power Nearby";
/*     */   
/*  57 */   private static CharSequence ¤¤wearinessName = "Battle Weariness";
/*  58 */   private static CharSequence ¤¤wearinessDesc = "While soldiers are often eager to do battle initially, extended periods of combat can make them think their warm beds back home.";
/*  59 */   private static CharSequence ¤¤wearinessMess = "Battle Weariness";
/*  60 */   private static CharSequence ¤¤weariness = "Weariness";
/*  61 */   private static CharSequence ¤¤wearinessDelta = "Weariness Increase";
/*     */   
/*  63 */   private static CharSequence ¤¤flanksName = "Flanks Compromized";
/*  64 */   private static CharSequence ¤¤flanksDesc = "There's nothing to ruin a soldier's day more than being attacked in the flank.";
/*  65 */   private static CharSequence ¤¤flanksMess = "Flanks Compromized";
/*  66 */   private static CharSequence ¤¤flanks = "Flanked Soldiers";
/*  67 */   private static CharSequence ¤¤flanksValue = "Flanked Value";
/*     */   
/*  69 */   private static CharSequence ¤¤surroundedName = "Surrounded";
/*  70 */   private static CharSequence ¤¤surroundedDesc = "Apart from flanks, being surrounded by an enemy force is the greatest deterrence to stand and fight.";
/*  71 */   private static CharSequence ¤¤surroundedMess = "Feeling Surrounded";
/*  72 */   private static CharSequence ¤¤surroundedThreat = "Surrounding Threats";
/*     */   
/*     */   static {
/*  75 */     D.ts(Init.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public Init(final DivFactors ff) {
/*  80 */     (new DivFactor(¤¤formName, ¤¤formDesc, (SPRITE)(UI.icons()).s.shield, ¤¤formMess, 0.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/*  84 */           if (!div.position().isCoherent())
/*  85 */             return 0.0D; 
/*  86 */           double men = div.men();
/*  87 */           if (men == 0.0D)
/*  88 */             return 0.0D; 
/*  89 */           double d = div.centre().inFormation() / div.men();
/*  90 */           d -= 0.35D;
/*  91 */           d /= 0.65D;
/*  92 */           double w = men / (div.position().width() / div.position().formation().size(div));
/*  93 */           w = CLAMP.d(w / 5.0D, 0.0D, 1.0D);
/*  94 */           return d * w;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 100 */           b.textLL(Init.¤¤inPos);
/* 101 */           b.tab(6);
/* 102 */           b.add((SPRITE)GFORMAT.iofkInv(b.text(), div.centre().inFormation(), div.men()));
/* 103 */           b.NL();
/* 104 */           b.textLL(Init.¤¤depth);
/* 105 */           b.tab(6);
/* 106 */           int d = div.position().width() / div.position().formation().size(div);
/* 107 */           if (d == 0)
/* 108 */             d = 1; 
/* 109 */           b.add((SPRITE)GFORMAT.iofkInv(b.text(), (div.men() / d), 5L));
/* 110 */           b.NL();
/*     */         }
/* 113 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 1.0D, 1.25D, true)
/* 114 */       .boost((BOOSTABLES.BATTLE()).FORMATION, 0.0D, 1.0D, true);
/*     */     
/* 116 */     (new DivFactor(¤¤exhaustion, ¤¤exhaustionDesc, (SPRITE)(UI.icons()).s.shield, ¤¤exhMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 120 */           return 1.0D - (STATS.NEEDS()).EXHASTION.div().getD(div);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected double induValue(Induvidual indu) {
/* 130 */           return 1.0D - (STATS.NEEDS()).EXHASTION.indu().getD(indu);
/*     */         }
/* 134 */       }).boost((BOOSTABLES.PHYSICS()).SPEED, 0.25D, 1.0D, true)
/* 135 */       .boost((BOOSTABLES.BATTLE()).OFFENCE, 0.5D, 1.0D, true)
/* 136 */       .boost((BOOSTABLES.BATTLE()).DEFENCE, 0.5D, 1.0D, true);
/*     */     
/* 138 */     (new DivFactor(¤¤armyName, ¤¤armyDesc, (SPRITE)(UI.icons()).s.typeSoldier, ¤¤armyMess, 0.5D)
/*     */       {
/*     */         
/*     */         public double getD(Div div)
/*     */         {
/* 143 */           double m = div.army().men();
/* 144 */           double e = div.army().enemy().men();
/*     */           
/* 146 */           if (e == 0.0D)
/* 147 */             return 0.5D; 
/* 148 */           return m / e - 0.5D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 154 */           b.textLL(Init.¤¤armyPlayer);
/* 155 */           b.tab(6);
/* 156 */           b.add((SPRITE)GFORMAT.i(b.text(), div.army().men()));
/* 157 */           b.NL();
/* 158 */           b.textLL(Init.¤¤armyEnemy);
/* 159 */           b.tab(6);
/* 160 */           b.add((SPRITE)GFORMAT.i(b.text(), div.army().enemy().men()));
/* 161 */           b.NL();
/*     */         }
/* 164 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.75D, 1.25D, true);
/*     */     
/* 166 */     (new DivFactor(¤¤suppliesName, ¤¤suppliesDesc, (SPRITE)(UI.icons()).s.storage, ¤¤suppliesMess, 0.5D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 170 */           return ff.supplies.getD(div.army()) + 0.5D;
/*     */         }
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 175 */           if ((S.get()).developer) {
/* 176 */             b.add((SPRITE)b.text().add(ff.supplies.getD(div.army())));
/* 177 */             b.NL();
/* 178 */             b.add((SPRITE)b.text().add(getD(div)));
/*     */           }
/*     */         
/*     */         }
/* 182 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.25D, 1.75D, true);
/*     */     
/* 184 */     (new DivFactor(¤¤casultiesName, ¤¤casultiesDesc, (SPRITE)(UI.icons()).s.death, ¤¤casultiesMess, 1.0D)
/*     */       {
/*     */         
/*     */         public double getD(Div div)
/*     */         {
/* 189 */           if (div.army().men() == 0)
/* 190 */             return 1.0D; 
/* 191 */           if (div.men() == 0) {
/* 192 */             return 1.0D;
/*     */           }
/* 194 */           double a = ff.casulties.army.getD(div.army());
/* 195 */           a /= a + div.army().men();
/*     */           
/* 197 */           double d = ff.casulties.getD(div);
/* 198 */           d = 2.0D * d / (d + div.men());
/*     */           
/* 200 */           return CLAMP.d(1.0D - 0.5D * a - d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 206 */           b.textLL(Init.¤¤inUnit);
/* 207 */           b.tab(6);
/* 208 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.casulties.getD(div)));
/* 209 */           b.NL();
/* 210 */           b.textLL(Init.¤¤inArmy);
/* 211 */           b.tab(6);
/* 212 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.casulties.army.getD(div.army())));
/* 213 */           b.NL();
/*     */         }
/* 216 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.0D, 1.0D, true);
/*     */     
/* 218 */     (new DivFactor(¤¤routName, ¤¤routDesc, (SPRITE)(UI.icons()).s.flag, ¤¤routMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 222 */           if (div.army().men() == 0)
/* 223 */             return 1.0D; 
/* 224 */           if (div.men() == 0) {
/* 225 */             return 1.0D;
/*     */           }
/* 227 */           double a = ff.routing.army.getD(div.army());
/* 228 */           a /= a + div.army().men();
/*     */           
/* 230 */           double d = ff.routing.getD(div);
/* 231 */           d = 2.0D * d / (d + div.men());
/*     */           
/* 233 */           return CLAMP.d(1.0D - a * d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 239 */           b.textLL(Init.¤¤inUnit);
/* 240 */           b.tab(6);
/* 241 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.routing.getD(div)));
/* 242 */           b.NL();
/* 243 */           b.textLL(Init.¤¤inArmy);
/* 244 */           b.tab(6);
/* 245 */           b.add((SPRITE)GFORMAT.i(b.text(), (int)ff.routing.army.getD(div.army())));
/* 246 */           b.NL();
/*     */         }
/* 249 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.0D, 1.0D, true);
/*     */     
/* 251 */     (new DivFactor(¤¤projectilesName, ¤¤projectilesDesc, (SPRITE)(UI.icons()).s.arrow_left, ¤¤projectilesMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 255 */           if (div.men() == 0)
/* 256 */             return 1.0D; 
/* 257 */           return 1.0D - CLAMP.d(ff.projectiles.getD(div) / (div.men() * 4), 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 263 */           b.textLL(Dic.¤¤Projectiles);
/* 264 */           b.tab(6);
/* 265 */           b.add((SPRITE)GFORMAT.percInv(b.text(), 1.0D - getD(div)));
/*     */         }
/* 268 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.5D, 1.0D, true)
/* 269 */       .boost((BOOSTABLES.BATTLE()).DEFENCE, 0.75D, 1.0D, true)
/* 270 */       .boost((BOOSTABLES.BATTLE()).OFFENCE, 0.75D, 1.0D, true);
/*     */     
/* 272 */     (new DivFactor(¤¤situationName, ¤¤situationDesc, (SPRITE)(UI.icons()).s.eye, ¤¤situationMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 276 */           double ee = div.status().ajacentEnemiesPower();
/* 277 */           if (ee == 0.0D) {
/* 278 */             return 1.0D;
/*     */           }
/* 280 */           double f = div.status().ajacentFriendsPower();
/*     */ 
/*     */           
/* 283 */           double d = (ee - f) / (ee + f) * 2.0D;
/*     */           
/* 285 */           return 1.0D - CLAMP.d(d, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 291 */           b.textLL(Init.¤¤enemiesNear);
/* 292 */           b.tab(6);
/* 293 */           b.add((SPRITE)GFORMAT.f0(b.text(), -div.status().ajacentEnemiesPower()));
/* 294 */           b.NL();
/* 295 */           b.textLL(Init.¤¤friendsNear);
/* 296 */           b.tab(6);
/* 297 */           b.add((SPRITE)GFORMAT.f0(b.text(), div.status().ajacentFriendsPower()));
/*     */         }
/* 300 */       }).boost((BOOSTABLES.BATTLE()).MORALE, 0.0D, 1.0D, true);
/*     */     
/* 302 */     (new DivFactor(¤¤wearinessName, ¤¤wearinessDesc, (SPRITE)(UI.icons()).s.happy, ¤¤wearinessMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 306 */           return 1.0D - ff.weariness.getD(div) / 10000.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 312 */           b.textLL(Init.¤¤weariness);
/* 313 */           b.tab(6);
/* 314 */           b.add((SPRITE)GFORMAT.f0(b.text(), -ff.weariness.getD(div)));
/* 315 */           b.NL();
/* 316 */           b.textLL(Init.¤¤wearinessDelta);
/* 317 */           b.tab(6);
/* 318 */           b.add((SPRITE)GFORMAT.f0(b.text(), -(div.status().engagements()) / (1 + div.men())));
/*     */         }
/* 321 */       }).boost((BOOSTABLES.BATTLE()).MORALE, -10000.0D, 0.0D, false);
/*     */     
/* 323 */     (new DivFactor(¤¤flanksName, ¤¤flanksDesc, (SPRITE)(UI.icons()).s.expand, ¤¤flanksMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 327 */           return 1.0D - v(div);
/*     */         }
/*     */ 
/*     */         
/*     */         private double v(Div div) {
/* 332 */           double f = div.status().flanks();
/* 333 */           f /= div.men();
/* 334 */           f -= 0.3D;
/* 335 */           f *= 4.0D;
/* 336 */           f = CLAMP.d(f, 0.0D, 1.0D);
/* 337 */           return f;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 343 */           b.textLL(Init.¤¤flanks);
/* 344 */           b.tab(6);
/* 345 */           b.add((SPRITE)GFORMAT.i(b.text(), (long)div.status().flanks()));
/* 346 */           b.NL();
/* 347 */           b.textLL(Init.¤¤flanksValue);
/* 348 */           b.tab(6);
/* 349 */           b.add((SPRITE)GFORMAT.percInv(b.text(), v(div)));
/* 350 */           b.NL();
/*     */         }
/* 354 */       }).boost((BOOSTABLES.BATTLE()).DEFENCE, 0.2D, 1.0D, true)
/* 355 */       .boost((BOOSTABLES.BATTLE()).MORALE, -1.0D, 0.0D, false);
/*     */     
/* 357 */     (new DivFactor(¤¤surroundedName, ¤¤surroundedDesc, (SPRITE)(UI.icons()).s.circle, ¤¤surroundedMess, 1.0D)
/*     */       {
/*     */         public double getD(Div div)
/*     */         {
/* 361 */           double d = div.status().encirclementPower();
/* 362 */           d /= (div.status().ajacentFriendsPower() + 1.0D) * 10.0D;
/*     */ 
/*     */           
/* 365 */           return 1.0D - d;
/*     */         }
/*     */ 
/*     */         
/*     */         public void phover(Div div, GBox b) {
/* 370 */           b.textLL(Init.¤¤surroundedThreat);
/* 371 */           b.tab(6);
/* 372 */           b.add((SPRITE)GFORMAT.f0(b.text(), -div.status().encirclementPower()));
/* 373 */           b.NL();
/* 374 */           b.textLL(Init.¤¤friendsNear);
/* 375 */           b.tab(6);
/* 376 */           b.add((SPRITE)GFORMAT.f0(b.text(), div.status().ajacentFriendsPower()));
/*     */         }
/* 380 */       }).boost((BOOSTABLES.BATTLE()).MORALE, -15.0D, 0.0D, false);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\Init.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
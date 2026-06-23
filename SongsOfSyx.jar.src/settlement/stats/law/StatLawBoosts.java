/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ class StatLawBoosts {
/*  24 */   private static CharSequence ¤¤popSize = "Population Size";
/*  25 */   private static CharSequence ¤¤escapes = "Escapes";
/*  26 */   private static CharSequence ¤¤punishment = "Punishment";
/*     */   
/*     */   static {
/*  29 */     D.ts(StatLawBoosts.class);
/*     */   }
/*     */ 
/*     */   
/*     */   StatLawBoosts(final StatsLaw l) {
/*  34 */     lawfulness();
/*     */     
/*  36 */     Value v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/*  40 */           return l.escapees() / 10.0D;
/*     */         }
/*     */       };
/*  43 */     (new Boost(v, ¤¤escapes, (SPRITE)(SPRITES.icons()).m.chainsFree, 1.0D, 0.25D, true)).add((BOOSTABLES.CIVICS()).LAW);
/*     */     
/*  45 */     v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/*  49 */           return l.guards.data(t.cl).getD(t.race);
/*     */         }
/*     */       };
/*  52 */     (new Boost(v, (l.guards.info()).name, (l.guards.info()).icon, 0.0D, 1.0D, true)).add((BOOSTABLES.CIVICS()).LAW);
/*     */     
/*  54 */     v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE cl)
/*     */         {
/*  58 */           return l.lawMultiplier(cl.cl, cl.race) / 100.0D;
/*     */         }
/*     */       };
/*  61 */     (new Boost(v, ¤¤punishment, (SPRITE)(SPRITES.icons()).m.law, 0.0D, 100.0D, false)).add((BOOSTABLES.CIVICS()).LAW);
/*     */ 
/*     */ 
/*     */     
/*  65 */     v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/*  69 */           return 0.01D + (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)t) / 99.0D;
/*     */         }
/*     */       };
/*  72 */     (new Boost(v, (BOOSTABLES.CIVICS()).LAW.name, (SPRITE)(BOOSTABLES.CIVICS()).LAW.icon, 0.0D, 100.0D, true)).addRet((BOOSTABLES.BEHAVIOUR()).LOYALTY).add((BOOSTABLES.BEHAVIOUR()).SUBMISSION);
/*     */     
/*  74 */     v = new Value()
/*     */       {
/*     */         
/*     */         public double vGet(HCLASS_RACE cl)
/*     */         {
/*  79 */           return STATS.LAW().tyrrany(cl.cl, cl.race);
/*     */         }
/*     */       };
/*     */     
/*  83 */     (new Boost(v, StatsLaw.¤¤tyranny, (SPRITE)(SPRITES.icons()).m.law, 1.0D, 0.0D, true)).addRet((BOOSTABLES.BEHAVIOUR()).HAPPI).add((BOOSTABLES.BEHAVIOUR()).HAPPI_SLAVES);
/*     */   }
/*     */ 
/*     */   
/*     */   private void lawfulness() {
/*  88 */     Value v = new Value()
/*     */       {
/*     */ 
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/*  95 */           double d = 1000.0D / (STATS.POP()).POP.data().get(null);
/*  96 */           d = Math.pow(d, 1.5D);
/*  97 */           d = 1.0D - d;
/*  98 */           d = CLAMP.d(d, 0.0D, 1.0D);
/*  99 */           return d;
/*     */         }
/*     */       };
/* 102 */     (new Boost(v, ¤¤popSize, (SPRITE)(UI.icons()).s.citizen, 10.0D, 0.0D, true)).add((BOOSTABLES.BEHAVIOUR()).LAWFULNESS);
/*     */     
/* 104 */     v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/* 108 */           Boostable bo = (BOOSTABLES.BEHAVIOUR()).HAPPI;
/*     */           
/* 110 */           if (t.cl == HCLASSES.SLAVE()) {
/* 111 */             bo = (BOOSTABLES.BEHAVIOUR()).HAPPI_SLAVES;
/*     */           }
/* 113 */           double d = bo.get((BOOSTABLE_O)t);
/*     */           
/* 115 */           if (d < 1.0D) {
/* 116 */             return d / 100.0D;
/*     */           }
/* 118 */           d--;
/* 119 */           d *= 99.0D;
/* 120 */           d++;
/*     */           
/* 122 */           return d / 100.0D;
/*     */         }
/*     */       };
/* 125 */     (new Boost(v, (BOOSTABLES.BEHAVIOUR()).HAPPI.name, (SPRITE)(BOOSTABLES.BEHAVIOUR()).HAPPI.icon, 0.0D, 100.0D, true)).add((BOOSTABLES.BEHAVIOUR()).LAWFULNESS);
/*     */     
/* 127 */     v = new Value()
/*     */       {
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/* 131 */           return (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)t) * 2.0D / 100.0D;
/*     */         }
/*     */       };
/* 134 */     (new Boost(v, (BOOSTABLES.CIVICS()).LAW.name, (SPRITE)(BOOSTABLES.CIVICS()).LAW.icon, 1.0D, 100.0D, true)).add((BOOSTABLES.BEHAVIOUR()).LAWFULNESS);
/*     */   }
/*     */   
/*     */   private static abstract class Value
/*     */     implements BValue
/*     */   {
/*     */     public double vGet(Induvidual indu) {
/* 141 */       return vGet(indu.popCL());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 146 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 151 */       return 0.0D;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 157 */       return vGet(HCLASS_RACE.clP());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 162 */       return 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Boost
/*     */     extends BoosterValue
/*     */   {
/*     */     public Boost(StatLawBoosts.Value v, CharSequence name, SPRITE icon, double from, double to, boolean isMul) {
/* 173 */       super(v, new BSourceInfo(name, icon), from, to, isMul);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatLawBoosts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
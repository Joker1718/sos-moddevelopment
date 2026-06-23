/*     */ package world.army.ai;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Tree;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupplies;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ final class Recruiter {
/*     */   Recruiter() {
/*  22 */     this.tree = new Tree<WArmy>(100)
/*     */       {
/*     */         protected boolean isGreaterThan(WArmy current, WArmy cmp)
/*     */         {
/*  26 */           if (AD.menTarget(null).get(current) > AD.menTarget(null).get(cmp))
/*  27 */             return true; 
/*  28 */           return (current.armyIndex() > cmp.armyIndex());
/*     */         }
/*     */       };
/*     */   }
/*     */   private final Tree<WArmy> tree;
/*     */   
/*     */   public void recruit(FactionNPC f) {
/*  35 */     if (f.realm().all().size() == 0) {
/*     */       return;
/*     */     }
/*  38 */     int menTarget = AD.conscripts().available(null).get(f);
/*  39 */     int men = AD.menTarget(null).faction((Faction)f);
/*  40 */     int recruits = menTarget - men;
/*  41 */     if (recruits < 10) {
/*     */       return;
/*     */     }
/*     */     
/*  45 */     int armies = CLAMP.i(1 + menTarget / 5000, 1, 3);
/*     */     
/*  47 */     while (f.armies().all().size() < armies && f.armies().canCreate()) {
/*  48 */       Region r = (Region)f.realm().all().rnd();
/*  49 */       COORDINATE c = WORLD.PATH().rnd(r);
/*  50 */       (WORLD.ENTITIES()).armies.create(c.x(), c.y(), (Faction)f);
/*     */     } 
/*     */ 
/*     */     
/*  54 */     this.tree.clear();
/*  55 */     for (int ai = 0; ai < f.armies().all().size(); ai++) {
/*  56 */       WArmy a = (WArmy)f.armies().all().get(ai);
/*  57 */       this.tree.add(a);
/*     */     } 
/*     */     
/*  60 */     while (this.tree.hasMore()) {
/*  61 */       WArmy a = (WArmy)this.tree.pollGreatest();
/*  62 */       int target = menTarget;
/*  63 */       if (this.tree.hasMore()) {
/*  64 */         target = (int)(target * 0.75D);
/*     */       }
/*     */       
/*  67 */       target = CLAMP.i(target, 0, (Config.battle()).MEN_PER_ARMY);
/*  68 */       recruit(f, a, target);
/*     */       
/*  70 */       menTarget -= AD.menTarget(null).get(a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void recruit(FactionNPC f, WArmy a, int target) {
/*  80 */     label30: while (AD.menTarget(null).get(a) < target && a.divs().canAdd()) {
/*  81 */       int ri = RND.rInt(RACES.all().size());
/*     */       
/*  83 */       for (int i = 0; i < RACES.all().size(); i++) {
/*  84 */         Race r = (Race)RACES.all().get((ri + i) % RACES.all().size());
/*     */         
/*  86 */         int am = AD.conscripts().available(r).get(f);
/*     */         
/*  88 */         am = CLAMP.i(am, 0, (Config.battle()).MEN_PER_DIVISION);
/*     */         
/*  90 */         int min = (int)(((Config.battle()).MEN_PER_DIVISION * a.divs().size()) / 10.0D);
/*  91 */         min = Math.min(min, (Config.battle()).MEN_PER_DIVISION);
/*  92 */         if (am >= min)
/*     */         {
/*     */           
/*  95 */           if (am > 0) {
/*  96 */             if (r.playable) {
/*  97 */               am = CLAMP.i(am, 5, (Config.battle()).MEN_PER_DIVISION);
/*     */             }
/*  99 */             double trai = 0.1D + 0.225D * (BOOSTABLES.NOBLE()).AGRESSION.get((BOOSTABLE_O)(f.court().king().roy()).induvidual);
/* 100 */             double equip = 0.1D + 0.45D * (BOOSTABLES.NOBLE()).COMPETANCE.get((BOOSTABLE_O)(f.court().king().roy()).induvidual);
/* 101 */             WDivRegional d = AD.regional().create(r, am / (Config.battle()).MEN_PER_DIVISION, a);
/* 102 */             d.randomize(trai, equip);
/*     */             continue label30;
/*     */           } 
/*     */         }
/*     */       } 
/*     */       break;
/*     */     } 
/* 109 */     int arts = AD.menTarget(null).get(a);
/* 110 */     arts /= 200 + RND.rInt(100);
/* 111 */     arts = (int)(arts * Math.abs(AD.rnd(a)));
/* 112 */     arts = CLAMP.i(arts, 0, 40);
/* 113 */     for (ADSupplies.ADArtillery aa : AD.supplies().arts()) {
/* 114 */       arts -= aa.target.get(a);
/*     */     }
/*     */     
/* 117 */     for (ADSupplies.ADArtillery aa : AD.supplies().arts())
/* 118 */       aa.target.set(a, arts); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Recruiter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
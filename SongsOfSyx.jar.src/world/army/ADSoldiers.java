/*    */ package world.army;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import util.text.Dic;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class ADSoldiers
/*    */ {
/* 13 */   private final ArrayList<ADInt.ADIntImp> current = new ArrayList(RACES.all().size());
/* 14 */   private final ArrayList<ADInt.ADIntImp> target = new ArrayList(RACES.all().size());
/*    */   
/*    */   private final ADInt.ADIntImp currentTot;
/*    */   private final ADInt.ADIntImp targetTot;
/*    */   
/*    */   ADSoldiers(ADInit init) {
/* 20 */     this.currentTot = new ADInt.ADIntImp(init, "SOLDIERS", Dic.¤¤Soldiers, "");
/* 21 */     this.targetTot = new ADInt.ADIntImp(init, "SOLDIERS_TARGET", Dic.¤¤SoldiersTarget, "");
/*    */     
/* 23 */     for (Race r : RACES.all()) {
/* 24 */       ADInt.ADIntImp ii = new ADInt.ADIntImp(init, "SOLDIERS_" + r.key, String.valueOf(Dic.¤¤Soldiers) + ": " + String.valueOf(Dic.¤¤Soldiers), "")
/*    */         {
/*    */           public void count(WArmy t, int delta)
/*    */           {
/* 28 */             ADSoldiers.this.currentTot.inc(t, get(t) * delta);
/* 29 */             super.count(t, delta);
/*    */           }
/*    */         };
/*    */       
/* 33 */       this.current.add(ii);
/* 34 */       ii = new ADInt.ADIntImp(init, "SOLDIERS_TAR_" + r.key, String.valueOf(Dic.¤¤SoldiersTarget) + ": " + String.valueOf(Dic.¤¤SoldiersTarget), "")
/*    */         {
/*    */           public void count(WArmy t, int delta)
/*    */           {
/* 38 */             ADSoldiers.this.targetTot.inc(t, get(t) * delta);
/* 39 */             super.count(t, delta);
/*    */           }
/*    */         };
/*    */       
/* 43 */       this.target.add(ii);
/*    */     } 
/*    */ 
/*    */     
/* 47 */     init.registers.add(new ADInit.Register()
/*    */         {
/*    */           public void register(ADDiv div, int d)
/*    */           {
/* 51 */             ((ADInt.ADIntImp)ADSoldiers.this.current.get(div.race().index())).inc(div.army(), d * div.men());
/* 52 */             ((ADInt.ADIntImp)ADSoldiers.this.target.get(div.race().index())).inc(div.army(), d * div.menTarget());
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */   
/*    */   public ADInt current(Race race) {
/* 59 */     if (race == null)
/* 60 */       return this.currentTot; 
/* 61 */     return (ADInt)this.current.get(race.index);
/*    */   }
/*    */   
/*    */   public ADInt target(Race race) {
/* 65 */     if (race == null)
/* 66 */       return this.targetTot; 
/* 67 */     return (ADInt)this.target.get(race.index);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ADSoldiers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
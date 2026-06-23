/*    */ package world.army.ai;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.Tree;
/*    */ import world.WORLD;
/*    */ import world.army.AD;
/*    */ import world.entity.army.WArmy;
/*    */ import world.map.pathing.WRegFinder;
/*    */ import world.map.pathing.WRegSel;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ final class Defender {
/*    */   private final Tree<WArmy> tree;
/*    */   
/*    */   Defender() {
/* 18 */     this.tree = new Tree<WArmy>(100)
/*    */       {
/*    */         protected boolean isGreaterThan(WArmy current, WArmy cmp)
/*    */         {
/* 22 */           if (AD.power().get(current) > AD.power().get(cmp))
/* 23 */             return true; 
/* 24 */           return (current.armyIndex() > cmp.armyIndex());
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 29 */     this.threats = new Threat[16];
/*    */     
/* 31 */     for (int i = 0; i < this.threats.length; i++)
/* 32 */       this.threats[i] = new Threat(); 
/*    */   }
/*    */   private final Threat[] threats;
/*    */   
/*    */   public LIST<WArmy> defend(Faction f, ArrayList<WArmy> available) {
/* 37 */     this.tree.clear();
/* 38 */     for (int ri = 0; ri < f.realm().regions(); ri++) {
/* 39 */       Region reg = f.realm().region(ri);
/* 40 */       for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/* 41 */         if (DIP.WAR().is(a.faction(), f)) {
/* 42 */           this.tree.add(a);
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 47 */     int threatI = 0;
/* 48 */     while (this.tree.hasMore() && threatI < this.threats.length) {
/* 49 */       (this.threats[threatI]).a = (WArmy)this.tree.pollGreatest();
/* 50 */       (this.threats[threatI]).powerAdded = 0;
/* 51 */       threatI++;
/*    */     } 
/*    */     
/* 54 */     for (int i = 0; i < threatI && available.size() > 0; i++) {
/* 55 */       WArmy a = getClosest((this.threats[i]).a, available);
/* 56 */       if (a != null) {
/* 57 */         a.intercept((this.threats[i]).a);
/* 58 */         (this.threats[i]).powerAdded += AD.power().get(a);
/* 59 */         if ((this.threats[i]).powerAdded * 0.5D < AD.power().get((this.threats[i]).a)) {
/* 60 */           i--;
/*    */         }
/*    */       } 
/*    */     } 
/* 64 */     return (LIST<WArmy>)available;
/*    */   }
/*    */   
/*    */   private WArmy getClosest(WArmy enemy, ArrayList<WArmy> available) {
/* 68 */     double bestValue = 2.147483647E9D;
/* 69 */     WArmy best = null;
/*    */     
/* 71 */     for (WArmy a : available) {
/*    */       
/* 73 */       Region ar = (Region)(WORLD.REGIONS()).map.get(a.ctx(), a.cty());
/* 74 */       if (ar != null) {
/* 75 */         WRegFinder.RegDist rr = (WORLD.PATH()).regFinder.single(enemy.ctx(), enemy.cty(), WRegFinder.Treaty.DUMMY, WRegSel.SINGLE(ar));
/* 76 */         if (rr != null && 
/* 77 */           AD.power().get(a) * 0.75D > AD.power().get(enemy) && rr.distance < bestValue) {
/* 78 */           if (a.region() != null && a.region().faction() == a.faction() && AD.supplies().health(a) < 1.0D) {
/* 79 */             a.stop();
/*    */             
/*    */             continue;
/*    */           } 
/* 83 */           best = a;
/* 84 */           bestValue = rr.distance;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 91 */     return best;
/*    */   }
/*    */   
/*    */   private static class Threat {
/*    */     public WArmy a;
/*    */     public int powerAdded;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Defender.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
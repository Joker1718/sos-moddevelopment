/*    */ package game.events.killer;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.type.HCLASSES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.EntityIterator;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.data.GETTER;
/*    */ 
/*    */ 
/*    */ 
/*    */ class Util
/*    */ {
/*    */   public static int pickKiller() {
/* 19 */     final GETTER.GETTER_IMP<Humanoid> res = new GETTER.GETTER_IMP();
/*    */     
/* 21 */     (new EntityIterator.Humans()
/*    */       {
/*    */         protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*    */         {
/* 25 */           if (Util.isGoodKiller((ENTITY)h) != null) {
/* 26 */             res.set(h);
/* 27 */             if (RND.rBoolean())
/* 28 */               return true; 
/*    */           } 
/* 30 */           return false;
/*    */         }
/* 32 */       }).iterate(RND.rInt() & Integer.MAX_VALUE);
/* 33 */     if (res.get() == null)
/* 34 */       return -1; 
/* 35 */     return ((Humanoid)res.get()).id();
/*    */   }
/*    */ 
/*    */   
/*    */   public static Humanoid isGoodKiller(ENTITY e) {
/* 40 */     if (e == null)
/* 41 */       return null; 
/* 42 */     if (e instanceof Humanoid) {
/* 43 */       Humanoid a = (Humanoid)e;
/* 44 */       if (a.indu().clas() == HCLASSES.CITIZEN() && (a.race()).playable)
/* 45 */         return a; 
/*    */     } 
/* 47 */     return null;
/*    */   }
/*    */   
/*    */   public static int pickRace() {
/* 51 */     double pop = 0.0D;
/* 52 */     for (Race race : RACES.all()) {
/* 53 */       if (race.playable) {
/* 54 */         pop += (STATS.POP()).POP.data().get(race);
/*    */       }
/*    */     } 
/*    */     
/* 58 */     pop *= RND.rFloat();
/*    */     
/* 60 */     for (Race race : RACES.all()) {
/* 61 */       if (race.playable) {
/* 62 */         pop -= (STATS.POP()).POP.data().get(race);
/* 63 */         if (pop < 0.0D) {
/* 64 */           return race.index;
/*    */         }
/*    */       } 
/*    */     } 
/* 68 */     return (FACTIONS.player().race()).index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\killer\Util.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
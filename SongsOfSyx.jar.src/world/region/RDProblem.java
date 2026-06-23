/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import world.map.regions.Region;
/*    */ import world.region.building.RDBuilding;
/*    */ 
/*    */ public class RDProblem {
/* 11 */   private static CharSequence ¤¤efficiency = "The {0} is operating at low efficiency.";
/* 12 */   private static CharSequence ¤¤popDecline = "The population is declining.";
/* 13 */   private static CharSequence ¤¤loyalty = "Loyalty is at critical levels.";
/* 14 */   private static CharSequence ¤¤health = "Health is at critical levels.";
/*    */   
/*    */   static {
/* 17 */     D.ts(RDProblem.class);
/*    */   }
/*    */ 
/*    */   
/* 21 */   private ArrayListGrower<RDBuilding> notis = new ArrayListGrower();
/* 22 */   private final Str str = new Str(128);
/*    */   
/*    */   RDProblem() {
/* 25 */     for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 26 */       if (b.notify) {
/* 27 */         this.notis.add(b);
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public CharSequence problem(Region reg) {
/* 33 */     for (RDBuilding bu : this.notis) {
/*    */       
/* 35 */       if (bu.efficiency.get((BOOSTABLE_O)reg) < 1.0D) {
/* 36 */         this.str.clear().add(¤¤efficiency).insert(0, bu.info.name);
/* 37 */         return (CharSequence)this.str;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 42 */     if ((RD.RACES()).popTarget.getD(reg) < (RD.RACES()).population.get(reg)) {
/* 43 */       return (CharSequence)this.str.clear().add(¤¤popDecline);
/*    */     }
/* 45 */     if ((RD.RACES()).loyaltyAll.getD(reg) < 0.0D) {
/* 46 */       return (CharSequence)this.str.clear().add(¤¤loyalty);
/*    */     }
/*    */     
/* 49 */     if ((RD.HEALTH()).boostablee.get((BOOSTABLE_O)reg) < 0.5D) {
/* 50 */       return (CharSequence)this.str.clear().add(¤¤health);
/*    */     }
/* 52 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDProblem.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
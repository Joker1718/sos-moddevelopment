/*    */ package game.faction.royalty.opinion;
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.boosting.superb.SuperBoostableObj;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.royalty.Royalty;
/*    */ import game.time.TIME;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class OpsGifts {
/* 13 */   private static CharSequence ¤¤name = "Generosity";
/* 14 */   private static CharSequence ¤¤nameE = "Extortion";
/* 15 */   private static CharSequence ¤¤nameD = "Based on your previous dealings and gifts."; private final ROpper.ROpperDown op;
/*    */   
/*    */   static {
/* 18 */     D.ts(OpsGifts.class);
/*    */   }
/*    */ 
/*    */   
/*    */   private final ROpper.ROpperDown ex;
/*    */   
/*    */   OpsGifts() {
/* 25 */     double year = (TIME.secondsPerDay() * 16);
/* 26 */     this.op = new ROpper.ROpperDown("DEALINGS", ¤¤name, ¤¤nameD, (SPRITE)(UI.icons()).s.happy, 100.0D, false, year * 10.0D * 100.0D)
/*    */       {
/*    */         public double getModifier(Royalty roy) {
/* 29 */           return 0.25D + 0.75D * (BOOSTABLES.NOBLE()).PRIDE.get((BOOSTABLE_O)roy.induvidual);
/*    */         }
/*    */ 
/*    */         
/*    */         public double increase(Royalty roy) {
/* 34 */           return (1.0D + 99.0D * this.value.getD(roy)) * super.increase(roy);
/*    */         }
/*    */       };
/*    */     
/* 38 */     this.ex = new ROpper.ROpperDown("DEALINGSE", ¤¤nameE, ¤¤nameD, (SPRITE)(UI.icons()).s.happy, -100.0D, false, year * 10.0D * 100.0D)
/*    */       {
/*    */         public double getModifier(Royalty roy) {
/* 41 */           return 0.25D + 0.75D * (BOOSTABLES.NOBLE()).PRIDE.get((BOOSTABLE_O)roy.induvidual);
/*    */         }
/*    */ 
/*    */         
/*    */         public double increase(Royalty roy) {
/* 46 */           return (1.0D + 99.0D * this.value.getD(roy)) * super.increase(roy);
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public double getGenerosityNeededForPeace(FactionNPC f) {
/* 52 */     return (ROPINION.getPeaceValue(f, this.op, 1.0D) - this.op.value.getD(f.king())) * this.op.to();
/*    */   }
/*    */   
/*    */   public double getGenerosityNeededForOpinion(FactionNPC f, double target) {
/* 56 */     return (ROPINION.getOpinionValue(f, this.op, target) - this.op.value.getD(f.king())) * this.op.to();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void makeDeal(FactionNPC f, double generousity) {
/* 62 */     for (Royalty r : f.court().all()) {
/* 63 */       makeDeal(r, r.isKing() ? generousity : (generousity * 0.25D));
/*    */     }
/*    */   }
/*    */   
/*    */   private void makeDeal(Royalty roy, double generousity) {
/* 68 */     if (generousity < 0.0D) {
/* 69 */       this.ex.value.incD(roy, generousity / this.ex.to() * this.ex.getModifier((SuperBoostableObj)roy));
/*    */     } else {
/* 71 */       this.op.value.incD(roy, generousity / this.op.to() * this.op.getModifier((SuperBoostableObj)roy));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\OpsGifts.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
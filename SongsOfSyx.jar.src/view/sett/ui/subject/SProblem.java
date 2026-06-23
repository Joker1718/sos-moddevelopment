/*    */ package view.sett.ui.subject;
/*    */ 
/*    */ import game.GAME;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ 
/*    */ 
/*    */ final class SProblem
/*    */ {
/* 12 */   private static CharSequence ¤¤ProblemSick = "¤Currently ill with {0}. Needs to recuperate.";
/* 13 */   private static CharSequence ¤¤ProblemSick2 = "¤Currently ill with {0}. Needs a hospital.";
/* 14 */   private static CharSequence ¤¤ProblemInjured = "¤Bleeding badly";
/* 15 */   private static CharSequence ¤¤Starving = "¤Starving to death.";
/* 16 */   private static CharSequence ¤¤CutOff = "¤Cut off from the throne.";
/* 17 */   private static CharSequence ¤¤Exposed = "¤Exposed to the temperature!";
/* 18 */   private static CharSequence ¤¤OnStrike = "¤On Strike, refuses to work";
/*    */   
/* 20 */   private static CharSequence ¤¤ProbLeisure = "¤Leisure Time.";
/*    */ 
/*    */   
/*    */   static {
/* 24 */     D.ts(SProblem.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public static CharSequence problem(Humanoid a) {
/* 29 */     if ((STATS.DISEASE().status(a.indu())).active && STATS.DISEASE().shouldHospital(a)) {
/* 30 */       if (STATS.DISEASE().shouldHospital(a)) {
/* 31 */         return (CharSequence)Str.TMP.clear().add(¤¤ProblemSick).insert(0, (STATS.DISEASE().get(a.indu())).info.name);
/*    */       }
/* 33 */       return (CharSequence)Str.TMP.clear().add(¤¤ProblemSick2).insert(0, (STATS.DISEASE().get(a.indu())).info.name);
/*    */     } 
/* 35 */     if ((STATS.NEEDS()).INJURIES.inDanger(a.indu())) {
/* 36 */       return ¤¤ProblemInjured;
/*    */     }
/* 38 */     if ((STATS.NEEDS()).EXPOSURE.COUNT.indu().get(a.indu()) > 0)
/* 39 */       return ¤¤Exposed; 
/* 40 */     if ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0)
/* 41 */       return ¤¤Starving; 
/* 42 */     if ((STATS.POP()).TRAPPED.indu().get(a.indu()) > 0)
/* 43 */       return ¤¤CutOff; 
/* 44 */     if (GAME.EVENT().message(a.indu()) != null) {
/* 45 */       return GAME.EVENT().message(a.indu());
/*    */     }
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static CharSequence warning(Humanoid a) {
/* 53 */     if ((GAME.events()).riot.onStrike(a)) {
/* 54 */       return ¤¤OnStrike;
/*    */     }
/* 56 */     if ((STATS.WORK()).WORK_TIME.indu().isMax(a.indu())) {
/* 57 */       return ¤¤ProbLeisure;
/*    */     }
/* 59 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\subject\SProblem.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
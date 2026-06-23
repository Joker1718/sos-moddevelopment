/*    */ package game.raiding;
/*    */ 
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class RaiderTextsRace
/*    */ {
/*    */   public final LIST<CharSequence> greetings;
/*    */   public final LIST<CharSequence> mids;
/*    */   public final LIST<CharSequence> bodies;
/*    */   public final LIST<CharSequence> ends;
/*    */   public final LIST<CharSequence> rgreetings;
/*    */   public final LIST<CharSequence> rmids;
/*    */   public final LIST<CharSequence> rbodies;
/*    */   public final LIST<CharSequence> rends;
/*    */   public final LIST<CharSequence> rejected;
/*    */   public final LIST<CharSequence> payed;
/*    */   public final LIST<CharSequence> afterRaid;
/*    */   public final LIST<CharSequence> allyHelp;
/*    */   public final LIST<CharSequence> allyDead;
/*    */   public final LIST<CharSequence> allyFight;
/*    */   
/*    */   public RaiderTextsRace(Json j) {
/* 31 */     Json jj = j.json("FIRST");
/* 32 */     this.greetings = (LIST<CharSequence>)tt((CharSequence[])jj.texts("GREETING"));
/* 33 */     this.mids = (LIST<CharSequence>)tt((CharSequence[])jj.texts("INTROS"));
/* 34 */     this.bodies = (LIST<CharSequence>)tt((CharSequence[])jj.texts("BODIES"));
/* 35 */     this.ends = (LIST<CharSequence>)tt((CharSequence[])jj.texts("ENDS"));
/*    */ 
/*    */     
/* 38 */     jj = j.json("REPEAT");
/* 39 */     this.rgreetings = (LIST<CharSequence>)tt((CharSequence[])jj.texts("GREETING"));
/* 40 */     this.rmids = (LIST<CharSequence>)tt((CharSequence[])jj.texts("INTROS"));
/* 41 */     this.rbodies = (LIST<CharSequence>)tt((CharSequence[])jj.texts("BODIES"));
/* 42 */     this.rends = (LIST<CharSequence>)tt((CharSequence[])jj.texts("ENDS"));
/*    */ 
/*    */     
/* 45 */     this.rejected = (LIST<CharSequence>)tt((CharSequence[])j.texts("REJECTED"));
/* 46 */     this.payed = (LIST<CharSequence>)tt((CharSequence[])j.texts("PAYED"));
/* 47 */     this.afterRaid = (LIST<CharSequence>)tt((CharSequence[])j.texts("AFTER_RAID"));
/* 48 */     this.allyHelp = (LIST<CharSequence>)tt((CharSequence[])j.texts("HELP"));
/* 49 */     this.allyDead = (LIST<CharSequence>)tt((CharSequence[])j.texts("HELP_DESTROYED"));
/* 50 */     this.allyFight = (LIST<CharSequence>)tt((CharSequence[])j.texts("HELP_FIGHT"));
/*    */   }
/*    */   
/*    */   private ArrayList<CharSequence> tt(CharSequence[] tt) {
/* 54 */     RaiderText.insert.check(tt);
/* 55 */     return new ArrayList((Object[])tt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaiderTextsRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
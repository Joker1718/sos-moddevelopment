/*    */ package settlement.entity.humanoid.ai.types.prisoner;
/*    */ 
/*    */ import init.type.CRIME_PUNISHMENTS;
/*    */ import settlement.entity.humanoid.ai.main.AIModules;
/*    */ import settlement.entity.humanoid.ai.main.HAI;
/*    */ import snake2d.util.bit.Bits;
/*    */ import util.data.GETTER_TRANS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements GETTER_TRANS.GETTER_TRANSE<HAI, CRIME_PUNISHMENTS.PUNISHMENT>
/*    */ {
/* 41 */   PrisonerData.Wrap pp = new PrisonerData.Wrap(new Bits(255), (AIModules.data()).byte2);
/*    */   
/*    */   public CRIME_PUNISHMENTS.PUNISHMENT get(HAI f) {
/* 44 */     int i = this.pp.get(f);
/* 45 */     if (i == 0)
/* 46 */       return null; 
/* 47 */     return (CRIME_PUNISHMENTS.PUNISHMENT)CRIME_PUNISHMENTS.ALL().get(i - 1);
/*    */   }
/*    */ 
/*    */   
/*    */   public void set(HAI f, CRIME_PUNISHMENTS.PUNISHMENT t) {
/* 52 */     int i = (t == null) ? 0 : (t.index() + 1);
/* 53 */     this.pp.set(f, i);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\PrisonerData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
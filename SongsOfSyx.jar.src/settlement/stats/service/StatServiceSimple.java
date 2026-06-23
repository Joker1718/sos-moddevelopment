/*    */ package settlement.stats.service;
/*    */ 
/*    */ import init.type.NEED;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.StatsInit;
/*    */ import settlement.stats.stat.STAT;
/*    */ import settlement.stats.stat.STATData;
/*    */ import settlement.stats.stat.StatInfo;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DataO;
/*    */ 
/*    */ public class StatServiceSimple extends StatServiceImp {
/*    */   private final STAT access;
/*    */   
/*    */   StatServiceSimple(String key, LISTE<StatServiceImp> all, StatsInit init, CharSequence name, CharSequence desc, SPRITE icon, NEED need) {
/* 18 */     super(key, all, init, name, desc, icon, need);
/*    */ 
/*    */     
/* 21 */     this.access = (STAT)new STATData(key, init, (DataO.DataAbs)new DataO.DataBit(init.count, "SERVICEA_" + key), new StatInfo(name, ¤¤TotalDesc));
/* 22 */     this.access.info().setMatters(false, true);
/* 23 */     (this.access.info()).icon = icon;
/* 24 */     init.onArrivalStats.add(this.access);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean access(Humanoid h) {
/* 30 */     return (this.access.indu().get(h.indu()) == 1);
/*    */   }
/*    */   
/*    */   public void setAccess(Humanoid h, boolean access) {
/* 34 */     setAccess(h.indu(), access);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAccess(Induvidual i, boolean access) {
/* 39 */     this.access.indu().set(i, access ? 1 : 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public STAT total() {
/* 44 */     return this.access;
/*    */   }
/*    */ 
/*    */   
/*    */   public void clearAccess(Induvidual i) {
/* 49 */     this.access.indu().set(i, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void cheatSetTotal(Induvidual i, double tot) {
/* 54 */     this.access.indu().set(i, (tot > 0.0D) ? 1 : 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceSimple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
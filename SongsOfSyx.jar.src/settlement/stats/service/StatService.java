/*    */ package settlement.stats.service;
/*    */ 
/*    */ import init.type.NEED;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.stat.STAT;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public abstract class StatService
/*    */ {
/*    */   public final CharSequence name;
/*    */   public final CharSequence desc;
/*    */   public final SPRITE icon;
/*    */   public final NEED need;
/* 15 */   public double usage = 1.0D;
/*    */   
/*    */   public StatService(CharSequence name, CharSequence desc, SPRITE icon, NEED need) {
/* 18 */     this.name = name;
/* 19 */     this.desc = desc;
/* 20 */     this.icon = icon;
/* 21 */     this.need = need;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract boolean access(Humanoid paramHumanoid);
/*    */ 
/*    */   
/*    */   public abstract void clearAccess(Induvidual paramInduvidual);
/*    */   
/*    */   public CharSequence name(Induvidual i) {
/* 31 */     return this.name;
/*    */   } public abstract STAT total();
/*    */   public abstract void cheatSetTotal(Induvidual paramInduvidual, double paramDouble);
/*    */   public SPRITE icon(Induvidual i) {
/* 35 */     return this.icon;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatService.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
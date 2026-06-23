/*    */ package settlement.room.industry.module;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public abstract class IndustryRegion
/*    */ {
/* 10 */   private static ArrayListGrower<IndustryRegion> all = new ArrayListGrower();
/*    */ 
/*    */ 
/*    */   
/*    */   public final int index;
/*    */ 
/*    */ 
/*    */   
/*    */   public final Industry ins;
/*    */ 
/*    */   
/*    */   public final double rarity;
/*    */ 
/*    */ 
/*    */   
/*    */   public IndustryRegion(Industry ins, double rarity) {
/* 26 */     this.ins = ins;
/* 27 */     this.index = all.add(this);
/* 28 */     this.rarity = rarity;
/* 29 */     ins.reg = this;
/*    */   }
/*    */   
/*    */   public abstract double occurence(Region paramRegion);
/*    */   
/*    */   public static LIST<IndustryRegion> ALL() {
/* 35 */     return (LIST<IndustryRegion>)all;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\IndustryRegion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
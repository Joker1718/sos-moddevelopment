/*    */ package world.region.building;
/*    */ 
/*    */ import game.boosting.BoostSpecs;
/*    */ import init.sprite.UI.Icon;
/*    */ import init.value.Lockable;
/*    */ import snake2d.util.sets.INDEXED;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public final class RDBuildingLevel implements INDEXED {
/*    */   public final BoostSpecs local;
/*    */   BoostSpecs global;
/*    */   public final Lockable<Region> reqs;
/*    */   public final Icon icon;
/*    */   public final CharSequence name;
/*    */   int index;
/* 17 */   public int cost = 0;
/*    */   
/*    */   RDBuildingLevel(CharSequence name, Icon icon, Lockable<Region> needs) {
/* 20 */     this.local = new BoostSpecs(name, (SPRITE)icon, false);
/* 21 */     this.global = new BoostSpecs(name, (SPRITE)icon, false);
/*    */     
/* 23 */     this.name = name;
/* 24 */     this.icon = icon;
/* 25 */     this.reqs = needs;
/*    */   }
/*    */ 
/*    */   
/*    */   public int index() {
/* 30 */     return this.index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildingLevel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
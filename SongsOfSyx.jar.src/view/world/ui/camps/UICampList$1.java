/*    */ package view.world.ui.camps;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import java.util.Comparator;
/*    */ import world.WORLD;
/*    */ import world.entity.haven.WHaven;
/*    */ import world.map.regions.Region;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements Comparator<WHaven>
/*    */ {
/*    */   public int compare(WHaven o1, WHaven o2) {
/* 47 */     return get(o1) - get(o2);
/*    */   }
/*    */   
/*    */   private int get(WHaven current) {
/* 51 */     int res = current.index();
/* 52 */     Faction f = current.faction();
/* 53 */     if (f != FACTIONS.player())
/*    */     {
/* 55 */       if (f == null && (WORLD.REGIONS()).map.get(current.ctx(), current.cty()) != null && ((Region)(WORLD.REGIONS()).map.get(current.ctx(), current.cty())).faction() == FACTIONS.player()) {
/* 56 */         res += 10000;
/* 57 */       } else if (f == null) {
/* 58 */         res += 20000;
/*    */       } else {
/* 60 */         res += 30000;
/*    */       }  } 
/* 62 */     return res;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\camps\UICampList$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package world.army.ai;
/*    */ 
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ import world.WORLD;
/*    */ import world.map.pathing.WRegFinder;
/*    */ import world.map.pathing.WRegSel;
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
/*    */ class null
/*    */   extends PlacableSimpleTile
/*    */ {
/*    */   null(CharSequence $anonymous0) {
/* 29 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void place(int tx, int ty) {
/* 33 */     LOG.ln("test " + tx + " " + ty);
/* 34 */     LIST<WRegFinder.RegDist> ds = (WORLD.PATH()).regFinder.all(tx, ty, WRegFinder.Treaty.FACTION_BORDERS, WRegSel.ENEMY(((Region)(WORLD.REGIONS()).map.get(tx, ty)).faction()));
/*    */     
/* 36 */     for (WRegFinder.RegDist d : ds) {
/* 37 */       LOG.ln(String.valueOf(d.reg) + " " + String.valueOf(d.reg));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 43 */     if ((WORLD.PATH()).map.is.is(tx, ty) && (WORLD.REGIONS()).map.get(tx, ty) != null && ((Region)(WORLD.REGIONS()).map.get(tx, ty)).faction() != null) {
/* 44 */       return null;
/*    */     }
/* 46 */     return E;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\ai\Attacker$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
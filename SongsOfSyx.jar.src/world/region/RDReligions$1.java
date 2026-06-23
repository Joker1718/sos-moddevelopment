/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.map.regions.Region;
/*    */ import world.region.pop.RDRace;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 52 */     RBooster lo = new RBooster(new BSourceInfo(RDReligions.¤¤Opposition, (SPRITE)(UI.icons()).s.heat), 1.0D, 0.75D, true)
/*    */       {
/*    */         public double get(Region t)
/*    */         {
/* 56 */           return (RDReligions.null.access$0(RDReligions.null.this)).opposition.getD(t);
/*    */         }
/*    */       };
/*    */     
/* 60 */     for (RDRace race : (RD.RACES()).all)
/* 61 */       lo.add(race.loyalty.target); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDReligions$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
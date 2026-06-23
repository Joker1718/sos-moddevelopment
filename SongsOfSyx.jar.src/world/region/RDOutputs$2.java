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
/* 80 */     RBooster b = new RBooster(new BSourceInfo(RDOutputs.¤¤Squeeze, (SPRITE)(UI.icons()).s.money), 1.0D, 0.25D, true)
/*    */       {
/*    */         public double get(Region t)
/*    */         {
/* 84 */           return (RDOutputs.null.access$0(RDOutputs.null.this)).squeeze.getD(t);
/*    */         }
/*    */       };
/* 87 */     for (RDRace r : (RD.RACES()).all)
/* 88 */       b.add(r.loyalty.target); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOutputs$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
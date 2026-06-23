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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 42 */     RBooster b = new RBooster(new BSourceInfo(RDDevastation.¤¤Name, (SPRITE)(UI.icons()).s.heat), 0.25D, 1.0D, true)
/*    */       {
/*    */         public double get(Region t)
/*    */         {
/* 46 */           return 1.0D - (RDDevastation.null.access$0(RDDevastation.null.this)).current.getD(t);
/*    */         }
/*    */       };
/*    */     
/* 50 */     b.add((RD.RACES()).capacity);
/*    */     
/* 52 */     for (RDRace r : (RD.RACES()).all) {
/* 53 */       b.add(r.pop.growth);
/*    */     }
/*    */     
/* 56 */     for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/* 57 */       b.add(o.boost);
/* 58 */       b.add(o.boostYearlyPart);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDDevastation$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
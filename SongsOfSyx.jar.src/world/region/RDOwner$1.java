/*    */ package world.region;
/*    */ 
/*    */ import game.boosting.BSourceInfo;
/*    */ import game.faction.FACTIONS;
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
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 47 */     RBooster b = new RBooster(new BSourceInfo(RDOwner.¤¤Affiliation, (SPRITE)(UI.icons()).s.happy), 0.0D, 1.0D, true)
/*    */       {
/*    */         public double get(Region t)
/*    */         {
/* 51 */           if (t.faction() == FACTIONS.player())
/* 52 */             return (RDOwner.null.access$0(RDOwner.null.this)).affiliation.getD(t); 
/* 53 */           return 1.0D;
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 58 */     for (RDRace r : (RD.RACES()).all)
/* 59 */       b.add(r.loyalty.target); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDOwner$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
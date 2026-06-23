/*    */ package world.region;
/*    */ 
/*    */ import init.sprite.UI.UI;
/*    */ import init.value.GVALUES;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.DOUBLE_O;
/*    */ import util.data.DataRandom;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ public final class RDRandom
/*    */   extends DataRandom<Region>
/*    */ {
/*    */   RDRandom(RD.RDInit init) {
/* 15 */     super(init.count, 4);
/*    */     
/* 17 */     for (int i = 0; i < 8; i++) {
/* 18 */       final int bit = 16 * i;
/* 19 */       DOUBLE_O<Region> vv = new DOUBLE_O<Region>()
/*    */         {
/*    */           public double getD(Region reg)
/*    */           {
/* 23 */             return RDRandom.this.get(reg, bit, 16);
/*    */           }
/*    */         };
/*    */       
/* 27 */       GVALUES.REGION.push("RANDOM_" + i, "Random: " + i, (SPRITE)(UI.icons()).s.question, vv, false);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDRandom.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
/*     */ package world.region;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 122 */     RBooster bo = new RBooster(new BSourceInfo(RDHealth.¤¤epidemic, (SPRITE)(UI.icons()).s.death), 1.0D, 0.0D, true)
/*     */       {
/*     */         protected double get(Region reg)
/*     */         {
/* 126 */           return (RDHealth.null.access$0(RDHealth.null.this)).outbreak.get(reg);
/*     */         }
/*     */       };
/* 129 */     for (RDOutputs.RDOutput o : (RD.OUTPUT()).ALL) {
/* 130 */       bo.add(o.boost);
/* 131 */       bo.add(o.boostYearlyPart);
/*     */     } 
/* 133 */     bo = new RBooster(new BSourceInfo(RDHealth.¤¤epidemic, (SPRITE)(UI.icons()).s.death), 1.0D, 0.0D, true)
/*     */       {
/*     */         protected double get(Region reg)
/*     */         {
/* 137 */           return (RDHealth.null.access$0(RDHealth.null.this)).outbreak.get(reg);
/*     */         }
/*     */       };
/* 140 */     bo.add((RD.RACES()).capacity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDHealth$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
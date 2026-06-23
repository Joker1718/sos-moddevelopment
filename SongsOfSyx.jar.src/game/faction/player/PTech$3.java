/*     */ package game.faction.player;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import init.sprite.UI.UI;
/*     */ import init.tech.TECH;
/*     */ import init.tech.TECHS;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
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
/*  87 */     for (PTech.TechCurr c : PTech.this.currs) {
/*  88 */       BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly()
/*     */         {
/*     */           public double vGet(Player f)
/*     */           {
/*  92 */             return 1.0D;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/*  97 */             return 0.0D;
/*     */           }
/*     */         };
/* 100 */       (new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo("cheat", (SPRITE)(UI.icons()).s.expand), 1000000.0D, false)).add(c.cu.bo);
/*     */     } 
/*     */     
/* 103 */     for (int ti = 0; ti < TECHS.ALL().size(); ti++) {
/* 104 */       TECH t = (TECH)TECHS.ALL().get(ti);
/* 105 */       if (t.lockers.all().size() > 0)
/* 106 */         PTech.this.levelSet(t, t.levelMax); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\PTech$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
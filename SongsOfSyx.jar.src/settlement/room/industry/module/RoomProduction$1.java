/*     */ package settlement.room.industry.module;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.ResGEat;
/*     */ import init.sprite.UI.UI;
/*     */ import init.trade.TR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
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
/*     */   extends RoomProduction.Source
/*     */ {
/*     */   null(RESOURCE $anonymous0) {
/*  90 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public double am() {
/*  94 */     return FACTIONS.player().res().out(FResources.RTYPE.CONSUMED).history(TR.get(e.resource)).get(1);
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/*  99 */     return (SPRITE)(UI.icons()).s.human;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 104 */     return Dic.¤¤Consumed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\RoomProduction$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
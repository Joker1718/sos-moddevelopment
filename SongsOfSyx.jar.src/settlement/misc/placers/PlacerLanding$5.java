/*     */ package settlement.misc.placers;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
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
/*     */   implements Tile
/*     */ {
/* 116 */   private int am = -1;
/* 117 */   private int ePerTile = -1;
/*     */   
/*     */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 120 */     return (SPRITES.cons()).ICO.cancel;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 125 */     if ((STATS.POP()).POP.data(null).get(null) == 0) {
/* 126 */       this.am = 10 + (int)(10.0D * (BOOSTABLES.CIVICS()).LANDING.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null)));
/*     */       
/* 128 */       this.ePerTile = (int)Math.ceil(this.am / 10.0D);
/*     */     } 
/* 130 */     for (int i = 0; i < this.ePerTile; i++) {
/* 131 */       if (this.am > 0) {
/*     */         
/* 133 */         Humanoid h = SETT.HUMANOIDS().create(FACTIONS.player().race(), tx, ty, HTYPES.SUBJECT(), CAUSE_ARRIVES.IMMIGRATED());
/* 134 */         (STATS.POP()).TYPE.IMMIGRANT.set(h.indu());
/* 135 */         this.am--;
/*     */       } 
/* 137 */     }  VIEW.messages().hide();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 143 */     return !(SETT.PATH()).solidity.is(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\PlacerLanding$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */
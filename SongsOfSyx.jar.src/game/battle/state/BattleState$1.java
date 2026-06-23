/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.GameLoader;
/*     */ import java.nio.file.Path;
/*     */ import settlement.room.main.throne.THRONE;
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
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends GameLoader
/*     */ {
/*     */   null(Path $anonymous0, String... $anonymous1) {
/* 112 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void doAfterSet() {
/* 116 */     GAME.BATTLE_THREADS().pause();
/* 117 */     BattleState.this.concluded = false;
/* 118 */     BattleState.this.deploying = true;
/*     */     
/* 120 */     BattleState.this.throneTimer = 300.0D;
/*     */     
/* 122 */     VIEW.b().activate(BattleState.this);
/* 123 */     (VIEW.b().getWindow()).centererTile.set(THRONE.coo());
/* 124 */     VIEW.b().getWindow().zoomoutmax();
/* 125 */     GAME.SPEED.speedSet(0.0D);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleState$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */